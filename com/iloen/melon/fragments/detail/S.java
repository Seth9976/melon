package com.iloen.melon.fragments.detail;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.utils.template.TemplateImageLoader;

public final class s implements View.OnClickListener {
    public final int a;
    public final TemplateImageLoader b;

    public s(TemplateImageLoader templateImageLoader0, int v) {
        this.a = v;
        this.b = templateImageLoader0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            MixMakerPlaylistDetailFragment.drawHeaderView$lambda$15$lambda$11(this.b, view0);
            return;
        }
        MixMakerPlaylistBySongIdsDetailFragment.drawHeaderView$lambda$14$lambda$11(this.b, view0);
    }
}

