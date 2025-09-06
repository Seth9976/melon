package com.iloen.melon.fragments;

public final class n implements Runnable {
    public final int a;
    public final MelonBaseFragment b;

    public n(MelonBaseFragment melonBaseFragment0, int v) {
        this.a = v;
        this.b = melonBaseFragment0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.lambda$onExecuteDirectOpenFragment$5();
            return;
        }
        this.b.lambda$onResume$3();
    }
}

