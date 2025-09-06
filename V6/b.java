package v6;

import android.os.SystemClock;

public final class b implements Runnable {
    public final int a;
    public final d b;

    public b(d d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            d d0 = this.b;
            ((l)d0.getCurrentDrawable()).c(false, false, true);
            if((d0.getProgressDrawable() == null || !d0.getProgressDrawable().isVisible()) && (d0.getIndeterminateDrawable() == null || !d0.getIndeterminateDrawable().isVisible())) {
                d0.setVisibility(4);
            }
            d0.getClass();
            return;
        }
        d d1 = this.b;
        if(d1.d > 0) {
            SystemClock.uptimeMillis();
        }
        d1.setVisibility(0);
    }
}

