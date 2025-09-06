package u7;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class d extends Enum {
    public static final enum d a;
    public static final d[] b;

    static {
        d.a = new d("DEFAULT", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d.b = new d[]{d.a, new d("SIGNED", 1), new d("FIXED", 2)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
    }

    public static d valueOf(String s) {
        return (d)Enum.valueOf(d.class, s);
    }

    public static d[] values() {
        return (d[])d.b.clone();
    }
}

