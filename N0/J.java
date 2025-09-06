package N0;

public final class j implements m0 {
    public final int a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final m g;
    public static final i h;
    public static final j i;

    static {
        j.b = new i(0);
        j.c = new i(4);
        j.d = new i(2);
        j.e = new i(3);
        j.f = new i(5);
        j.g = new m();  // 初始化器: Ljava/lang/Object;-><init>()V
        j.h = new i(1);
        j.i = new j(1);
    }

    public j(int v) {
        this.a = v;
        super();
    }

    @Override  // N0.m0
    public boolean p(Object object0, Object object1) {
        return false;
    }

    @Override  // N0.m0
    public void r(l0 l00) {
        l00.clear();
    }

    @Override
    public String toString() {
        return this.a == 2 ? "ReusedSlotId" : super.toString();
    }
}

