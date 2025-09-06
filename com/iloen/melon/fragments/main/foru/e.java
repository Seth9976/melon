package com.iloen.melon.fragments.main.foru;

import android.view.View.OnClickListener;
import android.view.View;

public final class e implements View.OnClickListener {
    public final boolean a;
    public final ForUMixMakerKeywordSelectFragment b;

    public e(ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, boolean z) {
        this.a = z;
        this.b = forUMixMakerKeywordSelectFragment0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        MixMakerKeywordSelectAdapter.onBindViewImpl$lambda$2$lambda$1(this.a, this.b, view0);
    }
}

