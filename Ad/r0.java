package ad;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class r0 extends Enum {
    public static final r0[] a;

    static {
        r0[] arr_r0 = {new r0("ALL", 0), new r0("TOP_RANK", 1), new r0("MALE_GROUP", 2), new r0("FEMALE_GROUP", 3), new r0("MIXED_GROUP", 4), new r0("MALE_SOLO", 5), new r0("FEMALE_SOLO", 6), new r0("INDI_GENRE", 7)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r0.a = arr_r0;
        q.g(arr_r0, "entries");
        new b(arr_r0);
    }

    public static r0 valueOf(String s) {
        return (r0)Enum.valueOf(r0.class, s);
    }

    public static r0[] values() {
        return (r0[])r0.a.clone();
    }
}

