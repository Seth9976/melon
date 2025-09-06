package pc;

import e1.F;
import kotlin.jvm.internal.q;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class b extends Enum {
    public static final F a;
    public static final b[] b;
    public static final pe.b c;

    static {
        b[] arr_b = {new b("TYPE_1", 0), new b("TYPE_2", 1), new b("TYPE_3", 2), new b("TYPE_4", 3), new b("TYPE_5", 4), new b("TYPE_6", 5), new b("TYPE_7", 6), new b("TYPE_8", 7)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        b.b = arr_b;
        q.g(arr_b, "entries");
        b.c = new pe.b(arr_b);
        b.a = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static b valueOf(String s) {
        return (b)Enum.valueOf(b.class, s);
    }

    public static b[] values() {
        return (b[])b.b.clone();
    }
}

