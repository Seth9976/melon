package com.google.protobuf;

public abstract class e1 {
    public static final Class a;

    static {
        Class class0 = null;
        try {
            class0 = Class.forName("com.google.protobuf.ExtensionRegistry");
        }
        catch(ClassNotFoundException unused_ex) {
        }
        e1.a = class0;
    }
}

