package v1;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class r extends Enum {
    public static final enum r a;
    public static final enum r b;
    public static final r[] c;

    static {
        r.a = new r("Inherit", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.b = new r("SecureOn", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r[] arr_r = {r.a, r.b, new r("SecureOff", 2)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.c = arr_r;
        q.g(arr_r, "entries");
        new b(arr_r);
    }

    public static r valueOf(String s) {
        return (r)Enum.valueOf(r.class, s);
    }

    public static r[] values() {
        return (r[])r.c.clone();
    }
}

