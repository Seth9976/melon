package eb;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class r extends Enum {
    public static final r[] a;

    static {
        r[] arr_r = {new r("VERBOSE", 0), new r("INFO", 1), new r("WARN", 2), new r("ERROR", 3)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.a = arr_r;
        q.g(arr_r, "entries");
        new b(arr_r);
    }

    public static r valueOf(String s) {
        return (r)Enum.valueOf(r.class, s);
    }

    public static r[] values() {
        return (r[])r.a.clone();
    }
}

