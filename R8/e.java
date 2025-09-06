package r8;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class e extends Enum {
    public static final e[] a;

    static {
        e[] arr_e = {new e("ManyListen", 0)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e.a = arr_e;
        q.g(arr_e, "entries");
        new b(arr_e);
    }

    public static e valueOf(String s) {
        return (e)Enum.valueOf(e.class, s);
    }

    public static e[] values() {
        return (e[])e.a.clone();
    }
}

