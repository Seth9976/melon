package Le;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class h extends Enum {
    public static final h[] a;

    static {
        h[] arr_h = {new h("FROM_DEPENDENCIES", 0), new h("FROM_CLASS_LOADER", 1), new h("FALLBACK", 2)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        h.a = arr_h;
        q.g(arr_h, "entries");
        new b(arr_h);
    }

    public static h valueOf(String s) {
        return (h)Enum.valueOf(h.class, s);
    }

    public static h[] values() {
        return (h[])h.a.clone();
    }
}

