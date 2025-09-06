package w0;

import kotlin.jvm.internal.q;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class b extends Enum {
    public static final enum b a;
    public static final enum b b;
    public static final enum b c;
    public static final b[] d;

    static {
        b.a = new b("None", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        b.b = new b("Cancelled", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        b.c = new b("Redirected", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        b[] arr_b = {b.a, b.b, b.c, new b("RedirectCancelled", 3)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        b.d = arr_b;
        q.g(arr_b, "entries");
        new pe.b(arr_b);
    }

    public static b valueOf(String s) {
        return (b)Enum.valueOf(b.class, s);
    }

    public static b[] values() {
        return (b[])b.d.clone();
    }
}

