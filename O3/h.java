package o3;

public final class h implements u {
    public static final h a;
    public static final h b;

    static {
        h.a = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
        h.b = new h();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // o3.u
    public int getScore(Object object0) {
        String s = ((m)object0).a;
        return s.startsWith("OMX.google") || s.startsWith("c2.android") ? 1 : 0;
    }
}

