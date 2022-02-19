import java.util.ArrayList;

public class SubroutineSymbol extends Symbol {

    public static class Tuple { 
        public final String name;  // used for representing symbol name
        public final String type;  // used for representing symbol type
        public Tuple(String name, String type) { 
          this.name = name; 
          this.type = type; 
        } 
    } 

    public static class CustomArrayList extends ArrayList<Tuple> {
        public void insert(String name, String type) {
            Tuple item = new Tuple(name, type);
            this.add(item);
        }
        public String printArgTypes() {
            // print fmt: "t1, t2, ..."
            StringBuilder buf = new StringBuilder();
            for (Tuple t: this) {
                buf.append(", " + t.type);
            }
            if (buf.toString().length() > 2) {
                return buf.toString().substring(2); // remove first ", "
            } else {
                    return "";
            }
        }
    }
    
    private String returnType; // is null for procedures
    private CustomArrayList args = new CustomArrayList();
    private static String type = "function";

    // @args maps arg name to arg type
    public SubroutineSymbol(String name, Scope scope, CustomArrayList args, String returnType) {
        super(name, type, scope);
        this.args = args;
        this.returnType = returnType;
    }

    public String getReturnType() {
        return returnType;
    }

    public String toFormattedString() {
        return super.getName() + ", " + super.getType() + "(" + this.args.printArgTypes() + ") " + ", " + returnType;
    }

    public String toString() {
        return "<" + super.getName() + " " + super.getType() + " " + super.getScope() + " " + args + " " + returnType + ">";
    }
}
