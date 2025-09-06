package Ue;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class c extends Enum implements a {
    public static final enum c a;
    public static final enum c b;
    public static final enum c c;
    public static final enum c d;
    public static final enum c e;
    public static final enum c f;
    public static final enum c g;
    public static final enum c h;
    public static final c[] i;

    static {
        c c0 = new c("FROM_IDE", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c1 = new c("FROM_BACKEND", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c2 = new c("FROM_TEST", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.a = new c("FROM_BUILTINS", 3);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c3 = new c("WHEN_CHECK_DECLARATION_CONFLICTS", 4);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c4 = new c("WHEN_CHECK_OVERRIDES", 5);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c5 = new c("FOR_SCRIPT", 6);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.b = new c("FROM_REFLECTION", 7);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c6 = new c("WHEN_RESOLVE_DECLARATION", 8);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c7 = new c("WHEN_GET_DECLARATION_SCOPE", 9);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c8 = new c("WHEN_RESOLVING_DEFAULT_TYPE_ARGUMENTS", 10);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.c = new c("FOR_ALREADY_TRACKED", 11);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.d = new c("WHEN_GET_ALL_DESCRIPTORS", 12);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c9 = new c("WHEN_TYPING", 13);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.e = new c("WHEN_GET_SUPER_MEMBERS", 14);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.f = new c("FOR_NON_TRACKED_SCOPE", 15);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c c10 = new c("FROM_SYNTHETIC_SCOPE", 16);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.g = new c("FROM_DESERIALIZATION", 17);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.h = new c("FROM_JAVA_LOADER", 18);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c[] arr_c = {c0, c1, c2, c.a, c3, c4, c5, c.b, c6, c7, c8, c.c, c.d, c9, c.e, c.f, c10, c.g, c.h, new c("WHEN_GET_LOCAL_VARIABLE", 19), new c("WHEN_FIND_BY_FQNAME", 20), new c("WHEN_GET_COMPANION_OBJECT", 21), new c("FOR_DEFAULT_IMPORTS", 22)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        c.i = arr_c;
        q.g(arr_c, "entries");
        new b(arr_c);
    }

    public static c valueOf(String s) {
        return (c)Enum.valueOf(c.class, s);
    }

    public static c[] values() {
        return (c[])c.i.clone();
    }
}

