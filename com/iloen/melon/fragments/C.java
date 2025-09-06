package com.iloen.melon.fragments;

import android.view.View.OnClickListener;
import android.view.View;

public final class c implements View.OnClickListener {
    public final int a;
    public final BottomBtnClickListener b;

    public c(BottomBtnClickListener detailSongMetaContentBaseFragment$BottomBtnClickListener0, int v) {
        this.a = v;
        this.b = detailSongMetaContentBaseFragment$BottomBtnClickListener0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DetailSongMetaContentBaseFragment.addBottomBtnView$lambda$9(this.b, view0);
                return;
            }
            case 1: {
                DetailSongMetaContentBaseFragment.addBottomBtnView$lambda$10(this.b, view0);
                return;
            }
            case 2: {
                DetailSongMetaContentBaseFragment.addBottomBtnView$lambda$11(this.b, view0);
                return;
            }
            case 3: {
                DetailSongMetaContentBaseFragment.addBottomBtnView$lambda$12(this.b, view0);
                return;
            }
            default: {
                DetailSongMetaContentBaseFragment.addBottomBtnView$lambda$13(this.b, view0);
            }
        }
    }
}

