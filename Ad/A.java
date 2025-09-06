package ad;

import R6.d;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class a extends Enum {
    public static final d a;
    public static final a[] b;
    public static final b c;

    static {
        a[] arr_a = {new a("KPOP", 0), new a("POP", 1)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        a.b = arr_a;
        q.g(arr_a, "entries");
        a.c = new b(arr_a);
        a.a = new d(12);
    }

    public static a valueOf(String s) {
        return (a)Enum.valueOf(a.class, s);
    }

    public static a[] values() {
        return (a[])a.b.clone();
    }
}

