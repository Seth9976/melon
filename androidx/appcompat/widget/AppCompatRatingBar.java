package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

public class AppCompatRatingBar extends RatingBar {
    public final B a;

    public AppCompatRatingBar(Context context0) {
        this(context0, null);
    }

    public AppCompatRatingBar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F0404FB);  // attr:ratingBarStyle
    }

    public AppCompatRatingBar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        a1.a(this.getContext(), this);
        B b0 = new B(this);
        this.a = b0;
        b0.b(attributeSet0, v);
    }

    @Override  // android.widget.RatingBar
    public final void onMeasure(int v, int v1) {
        synchronized(this) {
            super.onMeasure(v, v1);
            Bitmap bitmap0 = (Bitmap)this.a.c;
            if(bitmap0 != null) {
                this.setMeasuredDimension(View.resolveSizeAndState(bitmap0.getWidth() * this.getNumStars(), v, 0), this.getMeasuredHeight());
            }
        }
    }
}

