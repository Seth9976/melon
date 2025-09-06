package U8;

import com.iloen.melon.interfaces.UiRefreshListener;

public final class g implements UiRefreshListener {
    public final int a;
    public final l b;

    public g(l l0, int v) {
        this.a = v;
        this.b = l0;
        super();
    }

    @Override  // com.iloen.melon.interfaces.UiRefreshListener
    public final void a() {
        if(this.a != 0) {
            w w0 = (w)this.b.getViewModel();
            w0.g(false);
            w0.c();
            return;
        }
        w w1 = (w)this.b.getViewModel();
        w1.g(false);
        w1.c();
    }
}

