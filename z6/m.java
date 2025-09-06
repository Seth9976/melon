package z6;

import d3.g;

public final class m {
    public g a;
    public g b;
    public g c;
    public g d;
    public d e;
    public d f;
    public d g;
    public d h;
    public f i;
    public f j;
    public f k;
    public f l;

    public m() {
        this.a = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.b = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.c = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.d = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.e = new a(0.0f);
        this.f = new a(0.0f);
        this.g = new a(0.0f);
        this.h = new a(0.0f);
        this.i = new f(0);
        this.j = new f(0);
        this.k = new f(0);
        this.l = new f(0);
    }

    public final o a() {
        o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.a = this.a;
        o0.b = this.b;
        o0.c = this.c;
        o0.d = this.d;
        o0.e = this.e;
        o0.f = this.f;
        o0.g = this.g;
        o0.h = this.h;
        o0.i = this.i;
        o0.j = this.j;
        o0.k = this.k;
        o0.l = this.l;
        return o0;
    }

    public static void b(g g0) {
        if(g0 instanceof l) {
            ((l)g0).getClass();
            return;
        }
        if(g0 instanceof e) {
            ((e)g0).getClass();
        }
    }

    public final void c(float f) {
        this.e = new a(f);
        this.f = new a(f);
        this.g = new a(f);
        this.h = new a(f);
    }
}

