package com.google.protobuf;

public abstract class i1 {
    public static final h1 a;
    public static final h1 b;

    static {
        i1.a = new h1();  // 初始化器: Ljava/lang/Object;-><init>()V
        h1 h10 = null;
        try {
            h10 = (h1)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        }
        catch(Exception unused_ex) {
        }
        i1.b = h10;
    }
}

