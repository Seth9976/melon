package w1;

public final class j {
    public Object a;
    public m b;
    public o c;
    public boolean d;

    public final void a(Object object0) {
        this.d = true;
        if(this.b != null && this.b.b.i(object0)) {
            this.a = null;
            this.b = null;
            this.c = null;
        }
    }

    public final void b() {
        this.d = true;
        if(this.b != null && this.b.b.cancel(true)) {
            this.a = null;
            this.b = null;
            this.c = null;
        }
    }

    public final void c(Throwable throwable0) {
        this.d = true;
        if(this.b != null && this.b.b.j(throwable0)) {
            this.a = null;
            this.b = null;
            this.c = null;
        }
    }

    @Override
    public final void finalize() {
        m m0 = this.b;
        if(m0 != null) {
            l l0 = m0.b;
            if(!l0.isDone()) {
                l0.j(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.a, 1));
            }
        }
        if(!this.d) {
            o o0 = this.c;
            if(o0 != null) {
                o0.i(null);
            }
        }
    }
}

