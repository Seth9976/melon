package com.iloen.melon.custom;

import android.view.View.OnClickListener;
import android.view.View;
import com.kakao.emoticon.ui.widget.EmoticonView;

public final class e0 implements View.OnClickListener {
    public final EmoticonView a;

    public e0(EmoticonView emoticonView0) {
        this.a = emoticonView0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        EmoticonView emoticonView0 = this.a;
        if(!emoticonView0.isAnimating()) {
            emoticonView0.startAnimation();
        }
    }
}

