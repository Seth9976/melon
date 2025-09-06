package com.iloen.melon.fragments.shortform;

public final class o implements Runnable {
    public final TrendShortVideoEmphasisFragment a;

    public o(TrendShortVideoEmphasisFragment trendShortVideoEmphasisFragment0) {
        this.a = trendShortVideoEmphasisFragment0;
    }

    @Override
    public final void run() {
        TrendShortVideoEmphasisFragment.setFirstFrameToBackground$lambda$4(this.a);
    }
}

