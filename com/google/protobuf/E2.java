package com.google.protobuf;

public final class e2 {
    public final Object a;
    public static final s1 b;

    static {
        e2.b = new s1(1);
    }

    public e2() {
        j2 j20;
        try {
            j20 = (j2)Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        }
        catch(Exception unused_ex) {
            j20 = e2.b;
        }
        d2 d20 = new d2();  // 初始化器: Ljava/lang/Object;-><init>()V
        d20.a = new j2[]{s1.b, j20};
        super();
        this.a = d20;
    }

    public e2(x x0) {
        P1.a(x0, "output");
        this.a = x0;
        x0.a = this;
    }

    public void a(int v, Object object0, E2 e20) {
        ((x)this.a).j0(v, 3);
        e20.e(((l2)object0), ((x)this.a).a);
        ((x)this.a).j0(v, 4);
    }
}

