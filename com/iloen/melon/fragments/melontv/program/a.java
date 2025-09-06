package com.iloen.melon.fragments.melontv.program;

public final class a implements Runnable {
    public final TvProgramHomeFragment a;
    public final String b;

    public a(TvProgramHomeFragment tvProgramHomeFragment0, String s) {
        this.a = tvProgramHomeFragment0;
        this.b = s;
    }

    @Override
    public final void run() {
        TvProgramHomeFragment.activityResult$lambda$3$lambda$2$lambda$1(this.a, this.b);
    }
}

