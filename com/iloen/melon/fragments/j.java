package com.iloen.melon.fragments;

public final class j implements Runnable {
    public final int a;
    public final DetailTabPagerBaseFragment b;

    public j(DetailTabPagerBaseFragment detailTabPagerBaseFragment0, int v) {
        this.a = v;
        this.b = detailTabPagerBaseFragment0;
        super();
    }

    @Override
    public final void run() {
        if(this.a != 0) {
            this.b.lambda$onViewCreated$0();
            return;
        }
        this.b.lambda$initTranslationHeight$1();
    }
}

