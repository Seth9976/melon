package com.google.protobuf;

public abstract class d {
    public static final Class a;
    public static final boolean b;

    static {
        Class class1;
        Class class0 = null;
        try {
            class1 = null;
            class1 = Class.forName("libcore.io.Memory");
        }
        catch(Throwable unused_ex) {
        }
        try {
            d.a = class1;
            class0 = Class.forName("org.robolectric.Robolectric");
        }
        catch(Throwable unused_ex) {
        }
        d.b = class0 != null;
    }

    public static boolean a() [...] // 潜在的解密器
}

