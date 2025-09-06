package com.iloen.melon.fragments.shortform;

import a9.d;
import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.popup.BottomSingleFilterListPopup;

public final class m implements View.OnClickListener {
    public final int a;
    public final int b;
    public final Object c;

    public m(Object object0, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            BottomSingleFilterListPopup bottomSingleFilterListPopup0 = (BottomSingleFilterListPopup)this.c;
            d d0 = bottomSingleFilterListPopup0.getFilterListener();
            if(d0 != null) {
                d0.onSelected(this.b);
            }
            bottomSingleFilterListPopup0.dismiss();
            return;
        }
        TrendShortFormViewPagerAdapter.onBindViewHolder$lambda$1(((TrendShortFormViewPagerAdapter)this.c), this.b, view0);
    }
}

