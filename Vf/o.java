package vf;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class o extends Enum {
    public static final o[] a;

    static {
        o[] arr_o = {new o("COMMON_SUPER_TYPE", 0), new o("INTERSECTION_TYPE", 1)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        o.a = arr_o;
        q.g(arr_o, "entries");
        new b(arr_o);
    }

    public static o valueOf(String s) {
        return (o)Enum.valueOf(o.class, s);
    }

    public static o[] values() {
        return (o[])o.a.clone();
    }
}

