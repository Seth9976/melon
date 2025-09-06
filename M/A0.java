package M;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class a0 extends Enum {
    public static final enum a0 a;
    public static final a0[] b;

    static {
        a0.a = new a0("Horizontal", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        a0[] arr_a0 = {a0.a, new a0("Vertical", 1)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        a0.b = arr_a0;
        q.g(arr_a0, "entries");
        new b(arr_a0);
    }

    public static a0 valueOf(String s) {
        return (a0)Enum.valueOf(a0.class, s);
    }

    public static a0[] values() {
        return (a0[])a0.b.clone();
    }
}

