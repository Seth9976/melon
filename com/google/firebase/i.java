package com.google.firebase;

import kotlin.jvm.internal.z;

public final class i extends z {
    public static final i b;

    static {
        i.b = new i(Timestamp.class, "seconds", "getSeconds()J", 0);  // 初始化器: Lkotlin/jvm/internal/z;-><init>(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // kotlin.jvm.internal.z
    public final Object get(Object object0) {
        return ((Timestamp)object0).a;
    }
}

