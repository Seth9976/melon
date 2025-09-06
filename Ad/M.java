package ad;

import R6.d;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class m extends Enum {
    public static final d a;
    public static final m[] b;
    public static final b c;

    static {
        m[] arr_m = {new m("D100", 0), new m("D30", 1)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        m.b = arr_m;
        q.g(arr_m, "entries");
        m.c = new b(arr_m);
        m.a = new d(13);
    }

    public static m valueOf(String s) {
        return (m)Enum.valueOf(m.class, s);
    }

    public static m[] values() {
        return (m[])m.b.clone();
    }
}

