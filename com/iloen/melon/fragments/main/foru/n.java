package com.iloen.melon.fragments.main.foru;

import android.view.View;
import com.iloen.melon.fragments.main.common.TagCollectionView.OnTagClickListener;
import com.iloen.melon.net.v6x.response.ForuMixMakerMainRes.RESPONSE;

public final class n implements OnTagClickListener {
    public final int a;
    public final RESPONSE b;

    public n(RESPONSE foruMixMakerMainRes$RESPONSE0, int v) {
        this.a = v;
        this.b = foruMixMakerMainRes$RESPONSE0;
        super();
    }

    @Override  // com.iloen.melon.fragments.main.common.TagCollectionView$OnTagClickListener
    public final void onClick(View view0, int v) {
        if(this.a != 0) {
            ForUMixMakerMainFragment.updateUi$lambda$39$lambda$15$lambda$14(this.b, view0, v);
            return;
        }
        ForUMixMakerMainFragment.updateUi$lambda$39$lambda$11$lambda$10(this.b, view0, v);
    }
}

