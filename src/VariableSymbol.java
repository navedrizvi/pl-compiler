
public class VariableSymbol extends Symbol {
    enum StorageClass {
        VAR,
        STATIC
    }

    private StorageClass storageClass;

    public VariableSymbol(String name, String type, Scope scope, StorageClass storageClass) {
        super(name, type, scope);
        this.storageClass = storageClass;
    }

    public StorageClass getStorageClass() {
        return storageClass;
    }

    public String toString() {
        return "<" + super.getName() + " " + super.getType() + " " + super.getScope() + " " + storageClass + ">";
    }
}
