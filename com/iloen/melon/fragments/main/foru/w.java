package com.iloen.melon.fragments.main.foru;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

public final class w implements View.OnTouchListener {
    public final ConstraintLayout a;
    public final TextView b;
    public final MixMakerTagCollectionView c;
    public final Drawable d;
    public final ColorStateList e;

    public w(ConstraintLayout constraintLayout0, TextView textView0, MixMakerTagCollectionView mixMakerTagCollectionView0, Drawable drawable0, ColorStateList colorStateList0) {
        this.a = constraintLayout0;
        this.b = textView0;
        this.c = mixMakerTagCollectionView0;
        this.d = drawable0;
        this.e = colorStateList0;
    }

    @Override  // android.view.View$OnTouchListener
    public final boolean onTouch(View view0, MotionEvent motionEvent0) {
        return MixMakerTagCollectionView.onCreateChildView$lambda$0(this.a, this.b, this.c, this.d, this.e, view0, motionEvent0);
    }
}

