package com.google.protobuf;

public abstract class a2 {
    public static final Z1 a;
    public static final Z1 b;

    static {
        Z1 z10 = null;
        try {
            z10 = (Z1)Class.forName("com.google.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        }
        catch(Exception unused_ex) {
        }
        a2.a = z10;
        a2.b = new Z1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }
}

