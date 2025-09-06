package hf;

import Hf.B;
import Hf.I;
import Hf.Y;
import Hf.a0;
import Hf.c;
import Hf.j;
import Hf.m;
import Hf.p;
import Hf.x;
import i.n.i.b.a.s.e.M3;
import kotlin.jvm.internal.q;

public final class f extends m implements j {
    public final B b;

    public f(B b0) {
        q.g(b0, "delegate");
        super();
        this.b = b0;
    }

    @Override  // Hf.m
    public final boolean D() {
        return false;
    }

    @Override  // Hf.B
    public final a0 S(I i0) {
        q.g(i0, "newAttributes");
        return new f(this.b.W(i0));
    }

    @Override  // Hf.B
    public final B V(boolean z) {
        return z ? this.b.V(true) : this;
    }

    @Override  // Hf.B
    public final B W(I i0) {
        q.g(i0, "newAttributes");
        return new f(this.b.W(i0));
    }

    @Override  // Hf.m
    public final B Y() {
        return this.b;
    }

    @Override  // Hf.m
    public final m c0(B b0) {
        return new f(b0);
    }

    @Override  // Hf.j
    public final a0 k(x x0) {
        q.g(x0, "replacement");
        a0 a00 = x0.I();
        if(!Y.f(a00) && !Y.e(a00)) {
            return a00;
        }
        if(a00 instanceof B) {
            a0 a01 = ((B)a00).V(false);
            return !Y.f(((B)a00)) ? a01 : new f(((B)a01));
        }
        if(!(a00 instanceof p)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        B b0 = ((p)a00).b.V(false);
        if(Y.f(((p)a00).b)) {
            b0 = new f(b0);
        }
        B b1 = ((p)a00).c.V(false);
        if(Y.f(((p)a00).c)) {
            b1 = new f(b1);
        }
        return c.G(c.f(b0, b1), c.g(a00));
    }

    @Override  // Hf.j
    public final boolean o() {
        return true;
    }
}

