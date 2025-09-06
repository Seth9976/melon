package androidx.datastore.preferences.protobuf;

public final class x implements T {
    public final int a;
    public static final x b;

    static {
        x.b = new x(0);
    }

    public x(int v) {
        this.a = v;
        super();
    }

    @Override  // androidx.datastore.preferences.protobuf.T
    public final d0 a(Class class0) {
        if(this.a != 0) {
            throw new IllegalStateException("This should never be called.");
        }
        Class class1 = A.class;
        if(class1.isAssignableFrom(class0)) {
            try {
                return (d0)A.c(class0.asSubclass(class1)).b(3);
            }
            catch(Exception exception0) {
                throw new RuntimeException("Unable to get message info for " + class0.getName(), exception0);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + class0.getName());
    }

    @Override  // androidx.datastore.preferences.protobuf.T
    public final boolean b(Class class0) {
        return this.a == 0 ? A.class.isAssignableFrom(class0) : false;
    }
}

