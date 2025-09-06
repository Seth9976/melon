package k6;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import com.google.android.material.carousel.CarouselLayoutManager;

public final class f extends h {
    public final CarouselLayoutManager b;

    public f(CarouselLayoutManager carouselLayoutManager0) {
        this.b = carouselLayoutManager0;
        super(1);
    }

    @Override  // k6.h
    public final void a(RectF rectF0, RectF rectF1, RectF rectF2) {
        float f = rectF1.top;
        float f1 = rectF2.top;
        if(f < f1 && rectF1.bottom > f1) {
            float f2 = f1 - f;
            rectF0.top += f2;
            rectF2.top += f2;
        }
        float f3 = rectF1.bottom;
        float f4 = rectF2.bottom;
        if(f3 > f4 && rectF1.top < f4) {
            float f5 = f3 - f4;
            rectF0.bottom = Math.max(rectF0.bottom - f5, rectF0.top);
            rectF1.bottom = Math.max(rectF1.bottom - f5, rectF1.top);
        }
    }

    @Override  // k6.h
    public final float b(LayoutParams recyclerView$LayoutParams0) {
        return (float)(recyclerView$LayoutParams0.topMargin + recyclerView$LayoutParams0.bottomMargin);
    }

    @Override  // k6.h
    public final RectF c(float f, float f1, float f2, float f3) {
        return new RectF(0.0f, f2, f1, f - f2);
    }

    @Override  // k6.h
    public final int d() {
        return this.b.getHeight();
    }

    @Override  // k6.h
    public final int e() {
        return this.b.getHeight();
    }

    @Override  // k6.h
    public final int f() {
        return this.b.getPaddingLeft();
    }

    @Override  // k6.h
    public final int g() {
        int v = this.b.getPaddingRight();
        return this.b.getWidth() - v;
    }

    @Override  // k6.h
    public final int h() {
        return 0;
    }

    @Override  // k6.h
    public final int i() {
        return 0;
    }

    @Override  // k6.h
    public final void j(View view0, int v, int v1) {
        int v2 = this.b.getPaddingLeft();
        LayoutParams recyclerView$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        int v3 = this.b.getDecoratedMeasuredWidth(view0);
        this.b.layoutDecoratedWithMargins(view0, v2, v, v3 + recyclerView$LayoutParams0.leftMargin + recyclerView$LayoutParams0.rightMargin + v2, v1);
    }

    @Override  // k6.h
    public final void k(RectF rectF0, RectF rectF1, RectF rectF2) {
        if(Float.compare(rectF1.bottom, rectF2.top) <= 0) {
            float f = ((float)Math.floor(rectF0.bottom)) - 1.0f;
            rectF0.bottom = f;
            rectF0.top = Math.min(rectF0.top, f);
        }
        if(rectF1.top >= rectF2.bottom) {
            float f1 = ((float)Math.ceil(rectF0.top)) + 1.0f;
            rectF0.top = f1;
            rectF0.bottom = Math.max(f1, rectF0.bottom);
        }
    }

    @Override  // k6.h
    public final void l(View view0, Rect rect0, float f, float f1) {
        view0.offsetTopAndBottom(((int)(f1 - (((float)rect0.top) + f))));
    }
}

