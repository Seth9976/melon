package com.iloen.melon.popup;

import android.view.View.OnClickListener;
import android.view.View;
import e.k;

public final class b implements View.OnClickListener {
    public final BuyAlbumPopup a;
    public final BuyAlbumChoiceAdapter b;
    public final int c;

    public b(BuyAlbumPopup buyAlbumPopup0, BuyAlbumChoiceAdapter buyAlbumPopup$BuyAlbumChoiceAdapter0, int v) {
        this.a = buyAlbumPopup0;
        this.b = buyAlbumPopup$BuyAlbumChoiceAdapter0;
        this.c = v;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        int v = 0;
        for(Object object0: this.a.getDataList()) {
            if(v >= 0) {
                ((AlbumDataSet)object0).setChecked(v == this.c);
                ++v;
                continue;
            }
            k.O();
            throw null;
        }
        this.b.notifyDataSetChanged();
    }
}

