package m8;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class m0 extends Enum {
    public static final m0[] a;
    public static final b b;

    static {
        m0[] arr_m0 = {new m0("INFO", 0), new m0("MARKETING", 1)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        m0.a = arr_m0;
        q.g(arr_m0, "entries");
        m0.b = new b(arr_m0);
    }

    public static m0 valueOf(String s) {
        return (m0)Enum.valueOf(m0.class, s);
    }

    public static m0[] values() {
        return (m0[])m0.a.clone();
    }
}

