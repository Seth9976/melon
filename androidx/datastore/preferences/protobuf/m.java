package androidx.datastore.preferences.protobuf;

public final class M {
    public final Object a;
    public static final x b;

    static {
        M.b = new x(1);
    }

    public M() {
        T t0;
        try {
            t0 = (T)Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        }
        catch(Exception unused_ex) {
            t0 = M.b;
        }
        L l0 = new L();  // 初始化器: Ljava/lang/Object;-><init>()V
        l0.a = new T[]{x.b, t0};
        super();
        this.a = l0;
    }

    public M(o o0) {
        this.a = o0;
        o0.j = this;
    }

    public void a(int v, Object object0, e0 e00) {
        ((o)this.a).H0(v, 3);
        e00.e(((a)object0), ((o)this.a).j);
        ((o)this.a).H0(v, 4);
    }
}

