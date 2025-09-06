package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import com.melon.custom.RatingView;

public class SmallRatingView extends RatingView {
    public SmallRatingView(Context context0) {
        super(context0, 1);
    }

    public SmallRatingView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0, 1);
    }

    public final void c(float f) {
        if(f > 4.9f) {
            this.a(10);
            return;
        }
        if(f > 4.0f) {
            this.a(9);
            return;
        }
        if(f > 3.9f) {
            this.a(8);
            return;
        }
        if(f > 3.0f) {
            this.a(7);
            return;
        }
        if(f > 2.9f) {
            this.a(6);
            return;
        }
        if(f > 2.0f) {
            this.a(5);
            return;
        }
        if(f > 1.9f) {
            this.a(4);
            return;
        }
        if(f > 1.0f) {
            this.a(3);
            return;
        }
        if(f > 0.9f) {
            this.a(2);
            return;
        }
        if(f > 0.0f) {
            this.a(1);
            return;
        }
        this.a(0);
    }
}

