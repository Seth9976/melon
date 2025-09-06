package com.iloen.melon.custom;

import android.content.Context;
import android.support.v4.view.NonSwipeableViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TranslationHeaderContainer extends FrameLayout {
    public TranslationView a;
    public NonSwipeableViewPager b;
    public boolean c;
    public boolean d;
    public boolean e;

    public TranslationHeaderContainer(Context context0) {
        this(context0, null);
    }

    public TranslationHeaderContainer(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.isInEditMode();
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getAction();
        if((v & 0xFF) == 0) {
            this.c = true;
            this.d = this.b.isEnabledLeftSwipe();
            this.e = this.b.isEnabledRightSwipe();
        }
        else if((v & 0xFF) == 1) {
            this.b.enableSwipe(this.d, this.e);
        }
        boolean z = this.c;
        this.c = super.dispatchTouchEvent(motionEvent0);
        if(z) {
            TranslationView translationView0 = this.a;
            if(translationView0.e && Math.abs(translationView0.getTranslationY()) < ((float)translationView0.c)) {
                if((v & 0xFF) == 0) {
                    this.b.enableSwipe(false, false);
                }
                return this.b.dispatchTouchEvent(motionEvent0);
            }
            return this.c;
        }
        return this.b.dispatchTouchEvent(motionEvent0);
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TranslationView)this.findViewById(0x7F0A0BE6);  // id:translation_header
        this.b = (NonSwipeableViewPager)this.findViewById(0x7F0A08F9);  // id:pager
    }
}

