package B2;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class u extends Enum {
    public static final enum u a;
    public static final u[] b;

    static {
        u.a = new u("Visible", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        u.b = new u[]{u.a, new u("Invisible", 1), new u("Gone", 2)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
    }

    public static u valueOf(String s) {
        return (u)Enum.valueOf(u.class, s);
    }

    public static u[] values() {
        return (u[])u.b.clone();
    }
}

