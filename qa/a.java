package Qa;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class a extends Enum {
    public static final a[] a;

    static {
        a[] arr_a = {new a("MENU", 0), new a("MM_PROMO_DTL", 1), new a("MM_LAYERPOP_F02", 2), new a("MPLAYER", 3), new a("MPLAYER_V4", 4), new a("MM_MENU_SVC_GID", 5), new a("MM_JUST_SONG", 6), new a("MSPTS_HOME_PRO", 7), new a("MM_MDJ_TODAY", 8), new a("MM_PLYLST_PTDJ", 9)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        a.a = arr_a;
        q.g(arr_a, "entries");
        new b(arr_a);
    }

    public static a valueOf(String s) {
        return (a)Enum.valueOf(a.class, s);
    }

    public static a[] values() {
        return (a[])a.a.clone();
    }
}

