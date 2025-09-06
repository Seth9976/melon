package androidx.media3.session.legacy;

public abstract class u {
    public final Object a;
    public boolean b;
    public boolean c;
    public boolean d;
    public int e;

    public u(Object object0) {
        this.a = object0;
    }

    public void a() {
        Object object0 = this.a;
        if(this.b) {
            throw new IllegalStateException("detach() called when detach() had already been called for: " + object0);
        }
        if(this.c) {
            throw new IllegalStateException("detach() called when sendResult() had already been called for: " + object0);
        }
        if(this.d) {
            throw new IllegalStateException("detach() called when sendError() had already been called for: " + object0);
        }
        this.b = true;
    }

    // 去混淆评级： 低(30)
    public final boolean b() {
        return this.b || this.c || this.d;
    }

    public void c() {
        throw new UnsupportedOperationException("It is not supported to send an error for " + this.a);
    }

    public abstract void d(Object arg1);

    public final void e() {
        if(this.c || this.d) {
            throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.a);
        }
        this.d = true;
        this.c();
    }

    public final void f(Object object0) {
        if(this.c || this.d) {
            throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.a);
        }
        this.c = true;
        this.d(object0);
    }
}

