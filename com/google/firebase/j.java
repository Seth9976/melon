package com.google.firebase;

import kotlin.jvm.internal.z;

public final class j extends z {
    public static final j b;

    static {
        j.b = new j(Timestamp.class, "nanoseconds", "getNanoseconds()I", 0);  // 初始化器: Lkotlin/jvm/internal/z;-><init>(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;I)V
    }

    @Override  // kotlin.jvm.internal.z
    public final Object get(Object object0) {
        return ((Timestamp)object0).b;
    }
}

