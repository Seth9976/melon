package androidx.glance.appwidget.protobuf;

public final class u implements O {
    public final int a;
    public static final u b;

    static {
        u.b = new u(0);
    }

    public u(int v) {
        this.a = v;
        super();
    }

    @Override  // androidx.glance.appwidget.protobuf.O
    public final Y a(Class class0) {
        if(this.a != 0) {
            throw new IllegalStateException("This should never be called.");
        }
        Class class1 = x.class;
        if(class1.isAssignableFrom(class0)) {
            try {
                return (Y)x.c(class0.asSubclass(class1)).b(3);
            }
            catch(Exception exception0) {
                throw new RuntimeException("Unable to get message info for " + class0.getName(), exception0);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + class0.getName());
    }

    @Override  // androidx.glance.appwidget.protobuf.O
    public final boolean b(Class class0) {
        return this.a == 0 ? x.class.isAssignableFrom(class0) : false;
    }
}

