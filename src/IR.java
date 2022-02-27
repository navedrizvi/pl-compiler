import java.util.ArrayList;
import java.util.List;

public class IR {

    static int tempVarCount = 0;
    static int labelCount = 0;

    static List<String> irOutput = new ArrayList<>();
    static List<String> staticIntList = new ArrayList<>();
    static List<String> staticFloatList = new ArrayList<>();
    static List<String> varIntList = new ArrayList<>();
    static List<String> varFloatList = new ArrayList<>();
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

    public static void emitForVarFloatList() {
        floatListIdx = index;
        emit("float-list:");
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
//        irOutput.set(intListIdx, String.format(irOutput.get(intListIdx), String.join(",", varIntList)));
//        irOutput.set(floatListIdx, String.format(irOutput.get(floatListIdx), String.join(",", varFloatList)));
        if (staticIntList.isEmpty())
            emit("static-int-list:");
        else
            emit("static-int-list: " + String.join(", ", staticIntList));
        if (staticFloatList.isEmpty())
            emit("static-float-list:");
        else
            emit("static-float-list: " + String.join(", ", staticFloatList));
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
