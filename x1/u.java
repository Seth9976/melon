package x1;

public final class u {
    public final String a;
    public static final u b;
    public static final u c;

    static {
        u.b = new u("visible");
        u.c = new u("gone");
    }

    public u(String s) {
        this.a = s;
    }
}

