package v9;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class f extends Enum {
    public static final enum f a;
    public static final f[] b;

    static {
        f f0 = new f("Aztalk", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        f f1 = new f("Shopping", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        f.a = new f("Ticket", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        f.b = new f[]{f0, f1, f.a};
    }

    public static f valueOf(String s) {
        return (f)Enum.valueOf(f.class, s);
    }

    public static f[] values() {
        return (f[])f.b.clone();
    }
}

