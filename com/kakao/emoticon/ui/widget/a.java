package com.kakao.emoticon.ui.widget;

import android.view.View.OnClickListener;
import android.view.View;

public final class a implements View.OnClickListener {
    public final int a;
    public final EmoticonSlidePreview b;

    public a(EmoticonSlidePreview emoticonSlidePreview0, int v) {
        this.a = v;
        this.b = emoticonSlidePreview0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            this.b.lambda$showPreview$2(view0);
            return;
        }
        this.b.lambda$showPreview$1(view0);
    }
}

