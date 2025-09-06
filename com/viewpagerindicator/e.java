package com.viewpagerindicator;

public final class e implements Runnable {
    public final int a;
    public final UnderlinePageIndicator b;

    public e(UnderlinePageIndicator underlinePageIndicator0, int v) {
        this.a = v;
        this.b = underlinePageIndicator0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            UnderlinePageIndicator underlinePageIndicator0 = this.b;
            if(underlinePageIndicator0.b) {
                underlinePageIndicator0.post(underlinePageIndicator0.o);
            }
            return;
        }
        UnderlinePageIndicator underlinePageIndicator1 = this.b;
        if(underlinePageIndicator1.b) {
            int v = Math.max(underlinePageIndicator1.a.getAlpha() - underlinePageIndicator1.e, 0);
            underlinePageIndicator1.a.setAlpha(v);
            underlinePageIndicator1.invalidate();
            if(v > 0) {
                underlinePageIndicator1.postDelayed(this, 30L);
            }
        }
    }
}

