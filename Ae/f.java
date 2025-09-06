package Ae;

public abstract class f {
    public static final e a;
    public static final a b;

    static {
        f.a = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        Be.a a0 = se.a.a == null || ((int)se.a.a) >= 34 ? new Be.a() : new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        f.b = a0;
    }

    public abstract int a(int arg1);

    public abstract int b();

    public int c(int v) {
        return this.d(0, v);
    }

    public int d(int v, int v1) {
        int v5;
        int v3;
        if(v1 <= v) {
            throw new IllegalArgumentException(("Random range is empty: [" + v + ", " + v1 + ").").toString());
        }
        int v2 = v1 - v;
        if(v2 <= 0 && v2 != 0x80000000) {
            do {
                v3 = this.b();
            }
            while(v > v3 || v3 >= v1);
            return v3;
        }
        if((-v2 & v2) == v2) {
            return v + this.a(0x1F - Integer.numberOfLeadingZeros(v2));
        }
        do {
            int v4 = this.b();
            v5 = (v4 >>> 1) % v2;
        }
        while(v2 - 1 + ((v4 >>> 1) - v5) < 0);
        return v + v5;
    }
}

