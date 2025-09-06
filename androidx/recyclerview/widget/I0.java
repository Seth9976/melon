package androidx.recyclerview.widget;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class i0 extends Enum {
    public static final enum i0 a;
    public static final i0[] b;

    static {
        i0.a = new i0("ALLOW", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        i0.b = new i0[]{i0.a, new i0("PREVENT_WHEN_EMPTY", 1), new i0("PREVENT", 2)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
    }

    public static i0 valueOf(String s) {
        return (i0)Enum.valueOf(i0.class, s);
    }

    public static i0[] values() {
        return (i0[])i0.b.clone();
    }
}

