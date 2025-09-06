package com.google.protobuf;

public abstract class i2 {
    public static final h2 a;
    public static final h2 b;

    static {
        h2 h20 = null;
        try {
            h20 = (h2)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        }
        catch(Exception unused_ex) {
        }
        i2.a = h20;
        i2.b = new h2();  // 初始化器: Ljava/lang/Object;-><init>()V
    }
}

