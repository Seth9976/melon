package com.google.protobuf;

public abstract class v2 {
    public static final u2 a;
    public static final u2 b;

    static {
        u2 u20 = null;
        try {
            u20 = (u2)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        }
        catch(Exception unused_ex) {
        }
        v2.a = u20;
        v2.b = new u2();  // 初始化器: Ljava/lang/Object;-><init>()V
    }
}

