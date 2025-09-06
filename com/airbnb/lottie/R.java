package com.airbnb.lottie;

public final class r implements Runnable {
    public final int a;
    public final LottieDrawable b;

    public r(LottieDrawable lottieDrawable0, int v) {
        this.a = v;
        this.b = lottieDrawable0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.lambda$new$2();
            return;
        }
        this.b.lambda$new$1();
    }
}

