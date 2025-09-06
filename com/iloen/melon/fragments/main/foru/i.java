package com.iloen.melon.fragments.main.foru;

import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.TextView;

public final class i implements View.OnTouchListener {
    public final TextView a;
    public final MixMakerKeywordSelectAdapter b;
    public final View c;

    public i(TextView textView0, MixMakerKeywordSelectAdapter forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0, View view0) {
        this.a = textView0;
        this.b = forUMixMakerKeywordSelectFragment$MixMakerKeywordSelectAdapter0;
        this.c = view0;
    }

    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        return MixMakerKeywordSelectAdapter.getSelectedTagView$lambda$12(this.a, this.b, this.c, view0, motionEvent0);
    }
}

