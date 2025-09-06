package wf;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class a extends Enum {
    public static final enum a a;
    public static final a[] b;

    static {
        a a0 = new a("WARNING", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        a.a = new a("ERROR", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        a[] arr_a = {a0, a.a, new a("HIDDEN", 2)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        a.b = arr_a;
        q.g(arr_a, "entries");
        new b(arr_a);
    }

    public static a valueOf(String s) {
        return (a)Enum.valueOf(a.class, s);
    }

    public static a[] values() {
        return (a[])a.b.clone();
    }
}

