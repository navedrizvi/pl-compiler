// TODO add pkg to makefile
package codegen;

import java.util.*;
import java.util.stream.Collectors;

import codegen.ir_instructions.*;
import codegen.mips_instructions.MipsInstruction;

// TargetCodeGenerator :: [ir] -> [mips]
public class TargetCodeGenerator {
   List<String> srcIrInstrs;
   List<String> staticIntList;
   List<String> staticFloatList;
   Map<String, List<String>> functionToArgs = new HashMap<>();

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
         // int array
         if (e.endsWith("]")) {
            int size = Integer.parseInt(e.substring(e.indexOf("[") + 1, e.indexOf("]")));
            String var = e.substring(0, e.indexOf("["));
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < size; i++)
               temp.add("0");

            out.add(var + ": .word " + String.join(", ", temp));
         }
         else {
            out.add(e + ": .word 0");
         }
      }
      for (String e: this.staticFloatList) {
         out.add("_" + e + ": .float 0.0");
      }
      return out;
   }

   private List<FunctionBlock> getTextSectionInstrs(List<String> staticIntList, List<String> staticFloatList) {
      List<IRInstruction> inpIr = new ArrayList<>();
      IRInstruction parsed;
      ArrayList<FunctionBlock> text = new ArrayList<>();
      int maxArgs = 0;
      for (int i=0; i<this.srcIrInstrs.size(); i++) {
         String instr = this.srcIrInstrs.get(i);
         if (instr.startsWith("start_function")) {
            String func_name = this.srcIrInstrs.get(i).split(" ")[1];
            // todo refactor to remove counters
            i += 1;
            String return_type = this.srcIrInstrs.get(i).split(" ")[0];
            String delta = this.srcIrInstrs.get(i).replace(return_type + " " + func_name + "(", "");
            delta = delta.replace(")", "");
            List<String> funcArgs = new ArrayList<>();
            String[] split = delta.split(",");
            if (!delta.isEmpty()) {
               for (String s : split) {
                  String[] splt = s.trim().split(" ");
                  funcArgs.add(splt[1]);
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
               int numOfArgs = getNumOfArgs(parsed);
               if (numOfArgs > maxArgs)
                  maxArgs = numOfArgs;
               inpIr.add(parsed);
               instructions.add(parsed);
               i += 1;
            }
            text.add(new FunctionBlock(func_name, return_type, funcArgs, staticIntList, staticFloatList, int_list, float_list,
                                       instructions.toArray(new IRInstruction[instructions.size()]), maxArgs));
            functionToArgs.put(func_name, funcArgs);
         }
      }
      return text;
   }

   private int getNumOfArgs(IRInstruction ir) {
      if (ir instanceof Call) {
         return ((Call) ir).getFunction_args().length;
      }
      if (ir instanceof Callr) {
         return ((Callr) ir).getFunction_args().length;
      }
      return 0;
   }

   private IRInstruction parseSourceIR(String ir_instr) {
      // grab opcodes and pattern match (only need startswith for now) (assumes all IR instructions don't cross 1 line)
      String type;
      String[] split_instr = ir_instr.split(",");
      List<String> args_ls = new ArrayList<>();
      type = split_instr[0];
      for (int i=1; i<split_instr.length; i++) {
         args_ls.add(split_instr[i].trim());
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
            // label
            return (IRInstruction) new Label(split_instr[0].split(":"));
     }
   }

   public String generateTargetMipsCodeNaiveAlloc() {
      List<FunctionBlock> functionBlocks = getTextSectionInstrs(staticIntList, staticFloatList);
      for(FunctionBlock block: functionBlocks) {
         block.setGlobalFunctionToArgs(functionToArgs);
      }
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
