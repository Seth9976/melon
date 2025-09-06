package com.iloen.melon.fragments.webview;

public final class b implements Runnable {
    public final int a;
    public final MelonWebViewFragment b;

    public b(MelonWebViewFragment melonWebViewFragment0, int v) {
        this.a = v;
        this.b = melonWebViewFragment0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.lambda$requestWebViewFocus$1();
            return;
        }
        this.b.lambda$shouldOverrideUrlLoading$4();
    }
}

