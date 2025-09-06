package X;

public abstract class c {
    public static final String a;
    public static final String b;

    // 去混淆评级： 低(26)
    static {
        c.a = "HHHHHHHHHH";
        c.b = "HHHHHHHHHH" + '\n' + "HHHHHHHHHH";
    }
}

