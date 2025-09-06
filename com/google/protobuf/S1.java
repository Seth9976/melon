package com.google.protobuf;

public final class s1 implements j2 {
    public final int a;
    public static final s1 b;

    static {
        s1.b = new s1(0);
    }

    public s1(int v) {
        this.a = v;
        super();
    }

    @Override  // com.google.protobuf.j2
    public final D2 a(Class class0) {
        if(this.a != 0) {
            throw new IllegalStateException("This should never be called.");
        }
        Class class1 = A1.class;
        if(class1.isAssignableFrom(class0)) {
            try {
                return (D2)A1.getDefaultInstance(class0.asSubclass(class1)).buildMessageInfo();
            }
            catch(Exception exception0) {
                throw new RuntimeException("Unable to get message info for " + class0.getName(), exception0);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + class0.getName());
    }

    @Override  // com.google.protobuf.j2
    public final boolean b(Class class0) {
        return this.a == 0 ? A1.class.isAssignableFrom(class0) : false;
    }
}

