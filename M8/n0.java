package m8;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class n0 extends Enum {
    public static final n0[] a;
    public static final b b;

    static {
        n0[] arr_n0 = {new n0("ON", 0), new n0("OFF", 1)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        n0.a = arr_n0;
        q.g(arr_n0, "entries");
        n0.b = new b(arr_n0);
    }

    public static n0 valueOf(String s) {
        return (n0)Enum.valueOf(n0.class, s);
    }

    public static n0[] values() {
        return (n0[])n0.a.clone();
    }
}

