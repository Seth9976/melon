package com.iloen.melon.fragments.main.foru;

import android.view.View.OnClickListener;
import android.view.View;

public final class h implements View.OnClickListener {
    public final View a;
    public final ForUMixMakerKeywordSelectFragment b;
    public final MixMakerKeywordSelectAdapter c;

    public h(View view0, ForUMixMakerKeywordSelectFragment forUMixMakerKeywordSelectFragment0, MixMakerKeywordSelectAdapter forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0) {
        this.a = view0;
        this.b = forUMixMakerKeywordSelectFragment0;
        this.c = forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        MixMakerKeywordSelectAdapter.getSelectedTagView$lambda$11(this.a, this.b, this.c, view0);
    }
}

