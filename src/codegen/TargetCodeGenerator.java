// TODO add pkg to makefile
package codegen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import codegen.ir_instructions.*;
import codegen.mips_instructions.MipsInstruction;

// TargetCodeGenerator :: [ir] -> [mips]
public class TargetCodeGenerator {
   List<String> srcIrInstrs;
   List<String> staticIntList;
   List<String> staticFloatList;

   public TargetCodeGenerator(List<String> srcIrInstrs, List<String> staticIntList, List<String> staticFloatList) {
      // @ir is called with IR.irOutput
      this.srcIrInstrs = srcIrInstrs;
      this.staticIntList = staticIntList;
      this.staticFloatList = staticFloatList;
   }

   private List<String> getDataSectionInstrs() {
      List<String> out = new ArrayList<>();
      String val = "";
      out.add("newline: .asciiz \"\\n\"");
      for (String e: this.staticIntList) {
         for (String instr : this.srcIrInstrs) {
            if (instr.startsWith("assign, " + e)) {
               val = instr.replace("assign, " + e + ", ", "");
               out.add(e + " .word " + val);
            }
         }
      }
      for (String e: this.staticFloatList) {
         for (String instr : this.staticFloatList) {
            if (instr.startsWith("assign, " + e)) {
               val = instr.replace("assign, " + e + " ", "");
               val = val.replaceAll(",*", "");
               out.add("_" + e + " .float " + val);
            }
         }
      }
      return out;
   }

   private List<FunctionBlock> getTextSectionInstrs() {
      List<IRInstruction> inpIr = new ArrayList<>();
      IRInstruction parsed;
      ArrayList<FunctionBlock> text = new ArrayList<>();
      for (int i=0; i<this.srcIrInstrs.size(); i++) {
         String instr = this.srcIrInstrs.get(i);
         if (instr.startsWith("start_function")) {
            String func_name = this.srcIrInstrs.get(i).split(" ")[1];
            // todo refactor to remove counters
            i += 1;
            String return_type = this.srcIrInstrs.get(i).split(" ")[0];
            String delta = this.srcIrInstrs.get(i).replace(return_type + " " + func_name, "(");
            delta = delta.replace(")", "");
            LinkedHashMap<String, String> funcArgs = new LinkedHashMap<>();
            String[] split = delta.split(", ");
            for (String s: split) {
               String[] splt = s.split(" ");
               if (splt.length >= 2) {
                  String argType = splt[0];
                  String argName = splt[1];
                  funcArgs.put(argType, argName);
               }
            }
            i += 1;
            String[] int_list = this.srcIrInstrs.get(i).replace("int-list: ", "").split(", ");
            i += 1;
            String[] float_list = this.srcIrInstrs.get(i).replace("float-list: ", "").split(", ");
            i += 1;
            i += 1;
            ArrayList<IRInstruction> instructions = new ArrayList<>();
            while (!this.srcIrInstrs.get(i).startsWith("end_function"))
            {
               parsed = this.parseSourceIR(this.srcIrInstrs.get(i));
               inpIr.add(parsed);
               instructions.add(parsed);
               i += 1;
            }
            text.add(new FunctionBlock(func_name, return_type, funcArgs, int_list, float_list,
                                       instructions.toArray(new IRInstruction[instructions.size()])));
         }
      }
      return text;
   }

   private IRInstruction parseSourceIR(String ir_instr) {
      // grab opcodes and pattern match (only need startswith for now) (assumes all IR instructions don't cross 1 line)
      String type;
      String[] split_instr = ir_instr.split(", ");
      List<String> args_ls = new ArrayList<String>();
      type = split_instr[0];
      for (int i=1; i<split_instr.length; i++) {
         args_ls.add(split_instr[i]);
      }
      String[] args = new String[args_ls.size()];
      args = args_ls.toArray(args);
      switch (type) {
         case "add":
             return (IRInstruction) new Add(args);
         case "and":
             return (IRInstruction) new And(args);
         case "array_load":
             return (IRInstruction) new Array_load(args);
         case "array_store":
             return (IRInstruction) new Array_store(args);
         case "breq":
            return (IRInstruction) new Breq(args);
         case "brgeq":
            return (IRInstruction) new Brgeq(args);
         case "brgt":
             return (IRInstruction) new Brgt(args);
         case "brleq":
            return (IRInstruction) new Brleq(args);
         case "brlt":
             return (IRInstruction) new Brlt(args);
         case "brneq":
             return (IRInstruction) new Brneq(args);
         case "call":
             return (IRInstruction) new Call(args);
         case "callr":
             return (IRInstruction) new Callr(args);
         case "div":
             return (IRInstruction) new Div(args);
         case "goto":
             return (IRInstruction) new Goto(args);
         case "mult":
             return (IRInstruction) new Mult(args);
         case "or":
             return (IRInstruction) new Or(args);
         case "sub":
             return (IRInstruction) new Sub(args);
         case "return":
               if (args.length == 0) {
                  return (IRInstruction) new ReturnVoid();
               } else {
                  return (IRInstruction) new Return(args);
               }
         case "assign":
               if (args.length == 3) {
                  return (IRInstruction) new AssignArray(args);
               }
               if (args.length == 2) {
                  return (IRInstruction) new Assign(args);
               }
         default:
             throw new UnsupportedOperationException("IR instruction type not supported: " + ir_instr);
     }
   }

   public String generateTargetMipsCodeNaiveAlloc() {
      List<FunctionBlock> functionBlocks = getTextSectionInstrs();
      List<String> mipsDataInstrs = getDataSectionInstrs();
      List<String> mipsTextInstrs = functionBlocks.stream()
                                       .map(FunctionBlock::getNaiveMips)
                                       .flatMap(Collection::stream)
                                       .map(MipsInstruction::asString)
                                       .collect(Collectors.toList());

      return ".data\n" + 
             String.join("\n", mipsDataInstrs) + "\n" +
             ".text\n" + 
             ".globl main\n" +
             String.join("\n", mipsTextInstrs) + "\n";
   }
}
