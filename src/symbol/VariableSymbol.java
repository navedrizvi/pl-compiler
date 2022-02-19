package symbol;

public class VariableSymbol extends Symbol {
    public enum StorageClass {
        VAR,
        STATIC
    }

    private StorageClass storageClass;
    private String type;

    public VariableSymbol(String name, String type, Scope scope, StorageClass storageClass) {
        super(name, scope);
        this.storageClass = storageClass;
        this.type = type;
    }

    public StorageClass getStorageClass() {
        return storageClass;
    }

    public String getType() {
        return type;
    }

    public String toFormattedString() {
        return super.getName() + ", " + storageClass + ", " + getType();
    }

    public String toString() {
        return "<" + super.getName() + " " + getType() + " " + super.getScope() + " " + storageClass + ">";
    }
}
