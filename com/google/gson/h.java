package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public abstract class h extends Enum {
    public static final enum a a;
    public static final h[] b;

    static {
        a a0 = new a();
        h.a = a0;
        h.b = new h[]{a0, new b(), new c(), new h() {
            @Override  // com.google.gson.h
            public final String b(Field field0) {
                return h.a(field0.getName(), '_').toUpperCase(Locale.ENGLISH);
            }
        }, new h() {
            @Override  // com.google.gson.h
            public final String b(Field field0) {
                return h.a(field0.getName(), '_').toLowerCase(Locale.ENGLISH);
            }
        }, new h() {
            @Override  // com.google.gson.h
            public final String b(Field field0) {
                return h.a(field0.getName(), '-').toLowerCase(Locale.ENGLISH);
            }
        }, new h() {
            @Override  // com.google.gson.h
            public final String b(Field field0) {
                return h.a(field0.getName(), '.').toLowerCase(Locale.ENGLISH);
            }
        }};
    }

    public static String a(String s, char c) {
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = s.charAt(v1);
            if(Character.isUpperCase(((char)v2)) && stringBuilder0.length() != 0) {
                stringBuilder0.append(c);
            }
            stringBuilder0.append(((char)v2));
        }
        return stringBuilder0.toString();
    }

    public abstract String b(Field arg1);

    public static String c(String s) {
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            int v2 = s.charAt(v1);
            if(Character.isLetter(((char)v2))) {
                if(Character.isUpperCase(((char)v2))) {
                    break;
                }
                int v3 = Character.toUpperCase(((char)v2));
                return v1 == 0 ? ((char)v3) + s.substring(1) : s.substring(0, v1) + ((char)v3) + s.substring(v1 + 1);
            }
        }
        return s;
    }

    public static h valueOf(String s) {
        return (h)Enum.valueOf(h.class, s);
    }

    public static h[] values() {
        return (h[])h.b.clone();
    }
}

