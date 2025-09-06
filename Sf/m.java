package sf;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class m extends Enum {
    public static final enum m a;
    public static final enum m b;
    public static final m[] c;

    static {
        m.a = new m("RENDER_OVERRIDE", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        m.b = new m("RENDER_OPEN", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        m[] arr_m = {m.a, m.b, new m("RENDER_OPEN_OVERRIDE", 2)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        m.c = arr_m;
        q.g(arr_m, "entries");
        new b(arr_m);
    }

    public static m valueOf(String s) {
        return (m)Enum.valueOf(m.class, s);
    }

    public static m[] values() {
        return (m[])m.c.clone();
    }
}

