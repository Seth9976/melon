package Cc;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class e1 extends Enum {
    public static final enum e1 a;
    public static final e1[] b;

    static {
        e1 e10 = new e1("DELETE", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e1 e11 = new e1("ATTACH", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e1.a = new e1("PLAY", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e1[] arr_e1 = {e10, e11, e1.a, new e1("CHECK", 3), new e1("MOVE", 4), new e1("REMOVE", 5), new e1("FOR_YOU_CHECK", 6), new e1("FOR_YOU_RECOMMEND", 7)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e1.b = arr_e1;
        q.g(arr_e1, "entries");
        new b(arr_e1);
    }

    public static e1 valueOf(String s) {
        return (e1)Enum.valueOf(e1.class, s);
    }

    public static e1[] values() {
        return (e1[])e1.b.clone();
    }
}

