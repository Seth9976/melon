package N7;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class d extends Enum {
    public static final enum d a;
    public static final enum d b;
    public static final d[] c;

    static {
        d.a = new d("CRASHLYTICS", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d.b = new d("PERFORMANCE", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d.c = new d[]{d.a, d.b, new d("MATT_SAYS_HI", 2)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
    }

    public static d valueOf(String s) {
        return (d)Enum.valueOf(d.class, s);
    }

    public static d[] values() {
        return (d[])d.c.clone();
    }
}

