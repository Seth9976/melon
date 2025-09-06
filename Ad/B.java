package ad;

import R6.c;
import kotlin.jvm.internal.q;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class b extends Enum {
    public static final c a;
    public static final b[] b;
    public static final pe.b c;

    static {
        b[] arr_b = {new b("YE", 0), new b("AG", 1)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        b.b = arr_b;
        q.g(arr_b, "entries");
        b.c = new pe.b(arr_b);
        b.a = new c(13);
    }

    public static b valueOf(String s) {
        return (b)Enum.valueOf(b.class, s);
    }

    public static b[] values() {
        return (b[])b.b.clone();
    }
}

