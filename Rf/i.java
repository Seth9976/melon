package rf;

import java.util.Map.Entry;

public abstract class i extends h implements t {
    public g b;
    public boolean c;

    public i() {
        this.b = g.c;
    }

    public final void d(j j0) {
        if(!this.c) {
            this.b = this.b.b();
            this.c = true;
        }
        g g0 = this.b;
        g g1 = j0.a;
        g0.getClass();
        for(int v = 0; true; ++v) {
            y y0 = g1.a;
            if(v >= y0.b.size()) {
                break;
            }
            g0.g(((Map.Entry)y0.b.get(v)));
        }
        for(Object object0: y0.c()) {
            g0.g(((Map.Entry)object0));
        }
    }
}

