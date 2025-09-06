package l4;

import D5.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class y extends z {
    public final Object a;
    public Executor b;
    public x c;
    public u d;
    public ArrayList e;

    public y() {
        this.a = new Object();
    }

    public String k() {
        return null;
    }

    public String l() {
        return null;
    }

    public final void m(u u0, ArrayList arrayList0) {
        if(u0 == null) {
            throw new NullPointerException("groupRoute must not be null");
        }
        synchronized(this.a) {
            Executor executor0 = this.b;
            if(executor0 == null) {
                this.d = u0;
                this.e = new ArrayList(arrayList0);
            }
            else {
                executor0.execute(new a(this, this.c, u0, arrayList0, 26));
            }
        }
    }

    public abstract void n(String arg1);

    public abstract void o(String arg1);

    public abstract void p(List arg1);

    public final void q(Executor executor0, x x0) {
        synchronized(this.a) {
            if(executor0 == null) {
                throw new NullPointerException("Executor shouldn\'t be null");
            }
            if(x0 == null) {
                throw new NullPointerException("Listener shouldn\'t be null");
            }
            this.b = executor0;
            this.c = x0;
            if(this.e != null && !this.e.isEmpty()) {
                u u0 = this.d;
                ArrayList arrayList0 = this.e;
                this.d = null;
                this.e = null;
                this.b.execute(new a(this, x0, u0, arrayList0, 27));
            }
        }
    }
}

