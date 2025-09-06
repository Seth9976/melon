package eb;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class s extends Enum {
    public static final s[] a;

    static {
        s[] arr_s = {new s("PLAYER", 0), new s("MCACHE", 1), new s("DRM", 2), new s("DOWNLOAD", 3), new s("CRASH", 4), new s("INFLOW", 5), new s("SERVICE", 6), new s("PREMIUM_DOWNLOAD", 7), new s("APP", 8), new s("REMOTE", 9), new s("PLYMIG", 10), new s("LOGIN", 11), new s("PLAYLIST", 12), new s("HTTP", 13), new s("PTRACE", 14)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        s.a = arr_s;
        q.g(arr_s, "entries");
        new b(arr_s);
    }

    public static s valueOf(String s) {
        return (s)Enum.valueOf(s.class, s);
    }

    public static s[] values() {
        return (s[])s.a.clone();
    }
}

