package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;

public final class n implements View.OnClickListener {
    public final DataWrapper a;
    public final LyricHighLightFragment b;
    public final int c;
    public final HighLightAdapter d;

    public n(DataWrapper lyricHighLightFragment$DataWrapper0, LyricHighLightFragment lyricHighLightFragment0, int v, HighLightAdapter lyricHighLightFragment$HighLightAdapter0) {
        this.a = lyricHighLightFragment$DataWrapper0;
        this.b = lyricHighLightFragment0;
        this.c = v;
        this.d = lyricHighLightFragment$HighLightAdapter0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        HighLightAdapter.onBindViewImpl$lambda$4$lambda$3$lambda$2(this.a, this.b, this.c, this.d, view0);
    }
}

