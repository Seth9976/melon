package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;

public class TranslationParallaxContainer extends FrameLayout {
    public TranslationParallaxView a;
    public RecyclerView b;
    public boolean c;
    public boolean d;

    public TranslationParallaxContainer(Context context0) {
        this(context0, null);
    }

    public TranslationParallaxContainer(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.isInEditMode();
    }

    @Override  // android.view.ViewGroup
    public final boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        if((motionEvent0.getAction() & 0xFF) == 0) {
            this.c = true;
            this.d = false;
        }
        boolean z = this.c;
        boolean z1 = super.dispatchTouchEvent(motionEvent0);
        this.c = z1;
        if(z) {
            TranslationParallaxView translationParallaxView0 = this.a;
            if(translationParallaxView0.e && (translationParallaxView0.c == -1 || Math.abs(translationParallaxView0.getTranslationY()) < ((float)translationParallaxView0.c))) {
                this.d = true;
                return this.b.dispatchTouchEvent(motionEvent0);
            }
            return this.c;
        }
        return !this.d || !this.a.f ? z1 : this.b.dispatchTouchEvent(motionEvent0);
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TranslationParallaxView)this.findViewById(0x7F0A08FD);  // id:parallax
        this.b = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
    }
}

