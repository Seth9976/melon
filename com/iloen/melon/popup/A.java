package com.iloen.melon.popup;

import android.view.View.OnClickListener;
import android.view.View;

public final class a implements View.OnClickListener {
    public final int a;
    public final BuyAlbumPopup b;

    public a(BuyAlbumPopup buyAlbumPopup0, int v) {
        this.a = v;
        this.b = buyAlbumPopup0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        OnClickListener onClickListener2;
        BuyAlbumPopup buyAlbumPopup0 = this.b;
        if(this.a != 0) {
            if(buyAlbumPopup0.c != null && !buyAlbumPopup0.c.isEmpty()) {
                for(Object object0: buyAlbumPopup0.c) {
                    AlbumDataSet albumDataSet0 = (AlbumDataSet)object0;
                    if(albumDataSet0.isChecked()) {
                        switch(albumDataSet0.getType()) {
                            case 0: {
                                OnClickListener onClickListener0 = buyAlbumPopup0.a;
                                if(onClickListener0 == null) {
                                    continue;
                                }
                                onClickListener0.onBuyClick(0);
                                continue;
                            }
                            case 1: {
                                OnClickListener onClickListener1 = buyAlbumPopup0.a;
                                if(onClickListener1 == null) {
                                    continue;
                                }
                                onClickListener1.onBuyClick(1);
                                continue;
                            }
                            case 2: {
                                onClickListener2 = buyAlbumPopup0.a;
                                if(onClickListener2 != null) {
                                    break;
                                }
                                continue;
                            }
                            default: {
                                continue;
                            }
                        }
                        onClickListener2.onBuyClick(2);
                    }
                }
            }
            buyAlbumPopup0.dismiss();
            return;
        }
        buyAlbumPopup0.dismiss();
    }
}

