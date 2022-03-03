import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IR {

    static int tempVarCount = 0;
    static int labelCount = 0;

    static List<String> irOutput = new ArrayList<>();
    static List<String> staticIntList = new ArrayList<>();
    static List<String> staticFloatList = new ArrayList<>();
    static List<String> varIntList = new ArrayList<>();
    static List<String> varFloatList = new ArrayList<>();
    static Stack<Integer> forLoopIndex = new Stack<>();
    static int intListIdx = 0;
    static int floatListIdx = 0;
    static int index = 0;

//    public static String generate() {
//        return null;
//    }

    public static void addStaticInt(String var) {
        staticIntList.add(var);
    }

    public static void addStaticFloat(String var) {
        staticFloatList.add(var);
    }

    public static String toFormattedString() {
        //return irOutput.toString();
        StringBuilder buf = new StringBuilder();
        for (String line : irOutput) {
            buf.append(line + "\n");
        }
        return buf.toString();
    }

    public static void emit(String instruction) {
        irOutput.add(instruction);
        index++;
    }

    public static void emitForVarIntList() {
        intListIdx = index;
        emit("int-list:");
    }

    public static void addVarInt(String var) {
        varIntList.add(var);
    }

    public static void emitForVarFloatList(List<String> varFloatList) {
        floatListIdx = index;
        if (varFloatList.size() > 0) {
            emit("float-list: " + String.join(", ", varFloatList) + ",");
        }
        else {
            emit("float-list:");
        }
    }

    public static void addVarFloat(String var) {
        varFloatList.add(var);
    }

    public static void populateVarLists() {
        if (!varIntList.isEmpty())
            irOutput.set(intListIdx, irOutput.get(intListIdx) + " " + String.join(", ", varIntList));
        if (!varFloatList.isEmpty())
            irOutput.set(floatListIdx, irOutput.get(floatListIdx) + " " + String.join(", ", varFloatList));
    }

    public static void populateStaticVarLists() {
        if (staticIntList.isEmpty())
            emit("static-int-list:");
        else
            emit("static-int-list: " + String.join(", ", staticIntList));
        if (staticFloatList.isEmpty())
            emit("static-float-list:");
        else
            emit("static-float-list: " + String.join(", ", staticFloatList));
    }

    public static void emitForLoopIndex() {
        forLoopIndex.add(index);
        emit("for-loop");
    }

    public static void emitForLoopCond() {
        forLoopIndex.add(index);
        emit("for-loop");
    }

    public static void updateForLoopEntryPoint(String var, String value) {
        int index = forLoopIndex.pop();
        irOutput.set(index, "assign, " + var + "," + value);
    }

    public static void updateForLoopCond(String code, String from, String to, String exitLabel) {
        int index = forLoopIndex.pop();
        irOutput.set(index, code + ", " + from + ", " + to + ", " + exitLabel);
    }

    public static void reset() {
        varIntList = new ArrayList<>();
        varFloatList = new ArrayList<>();
    }

    public static String createNewLabel() {
        String label = "_L" + labelCount;
        labelCount++;
        return label;
    }

    public static VariableSymbol createNewTemp(String type, Symbol.Scope scope) {
        VariableSymbol temp = new VariableSymbol("_t" + tempVarCount, type, scope, VariableSymbol.StorageClass.VAR);
        tempVarCount++;
        return temp;
    }

}
