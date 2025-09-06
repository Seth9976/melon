package k5;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class m extends Enum {
    public static final enum m a;
    public static final m[] b;

    static {
        m m0 = new m("IGNORE", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        m.a = new m("RESPECT_PERFORMANCE", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        m[] arr_m = {m0, m.a, new m("RESPECT_ALL", 2)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        m.b = arr_m;
        q.g(arr_m, "entries");
        new b(arr_m);
    }

    public static m valueOf(String s) {
        return (m)Enum.valueOf(m.class, s);
    }

    public static m[] values() {
        return (m[])m.b.clone();
    }
}

