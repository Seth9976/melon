package com.google.gson;

import java.lang.reflect.Field;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class a extends h {
    public a() {
        super("IDENTITY", 0);
    }

    @Override  // com.google.gson.h
    public final String b(Field field0) {
        return field0.getName();
    }
}

