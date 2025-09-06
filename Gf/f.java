package gf;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class f extends Enum {
    public static final f[] a;

    static {
        f[] arr_f = {new f("SOURCE", 0), new f("BINARY", 1)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        f.a = arr_f;
        q.g(arr_f, "entries");
        new b(arr_f);
    }

    public static f valueOf(String s) {
        return (f)Enum.valueOf(f.class, s);
    }

    public static f[] values() {
        return (f[])f.a.clone();
    }
}

