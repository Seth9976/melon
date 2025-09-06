package jd;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class n3 extends Enum {
    public static final n3[] a;

    static {
        n3[] arr_n3 = {new n3("User", 0), new n3("Host", 1), new n3("Artist", 2), new n3("Bot", 3)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        n3.a = arr_n3;
        q.g(arr_n3, "entries");
        new b(arr_n3);
    }

    public static n3 valueOf(String s) {
        return (n3)Enum.valueOf(n3.class, s);
    }

    public static n3[] values() {
        return (n3[])n3.a.clone();
    }
}

