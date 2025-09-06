package N4;

import android.graphics.Rect;

public final class r extends L {
    public final int u;
    public final Rect v;

    public r(int v, Rect rect0) {
        this.u = v;
        this.v = rect0;
        super();
    }

    @Override  // N4.L
    public final Rect i() {
        if(this.u != 0) {
            return this.v.isEmpty() ? null : this.v;
        }
        return this.v;
    }
}

