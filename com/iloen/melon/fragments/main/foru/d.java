package com.iloen.melon.fragments.main.foru;

import J8.a1;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.custom.MelonEditText;

public final class d implements View.OnClickListener {
    public final int a;
    public final Object b;

    public d(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                SearchFooterViewHolder._init_$lambda$1(((ForUMixMakerKeywordPredictiveFragment)this.b), view0);
                return;
            }
            case 1: {
                ForUMixMakerKeywordPredictiveFragment.onViewCreated$lambda$4(((MelonEditText)this.b), view0);
                return;
            }
            case 2: {
                ForUMixMakerKeywordSelectFragment.onViewCreated$lambda$2(((ForUMixMakerKeywordSelectFragment)this.b), view0);
                return;
            }
            case 3: {
                ForUMixMakerMainFragment.updateUi$lambda$39$lambda$7(((a1)this.b), view0);
                return;
            }
            case 4: {
                ForUTasteArtistFragment.onViewCreated$lambda$1(((ForUTasteArtistFragment)this.b), view0);
                return;
            }
            default: {
                ForUTasteSongFragment.onViewCreated$lambda$1(((ForUTasteSongFragment)this.b), view0);
            }
        }
    }
}

