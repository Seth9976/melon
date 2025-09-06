package k6;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import com.google.android.material.carousel.CarouselLayoutManager;

public final class c extends LinearSmoothScroller {
    public final CarouselLayoutManager a;

    public c(CarouselLayoutManager carouselLayoutManager0, Context context0) {
        this.a = carouselLayoutManager0;
        super(context0);
    }

    @Override  // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDxToMakeVisible(View view0, int v) {
        CarouselLayoutManager carouselLayoutManager0 = this.a;
        if(carouselLayoutManager0.f != null && carouselLayoutManager0.C()) {
            int v1 = carouselLayoutManager0.getPosition(view0);
            float f = (float)carouselLayoutManager0.z(v1, carouselLayoutManager0.y(v1));
            return (int)(((float)carouselLayoutManager0.a) - f);
        }
        return 0;
    }

    @Override  // androidx.recyclerview.widget.LinearSmoothScroller
    public final int calculateDyToMakeVisible(View view0, int v) {
        CarouselLayoutManager carouselLayoutManager0 = this.a;
        if(carouselLayoutManager0.f != null && !carouselLayoutManager0.C()) {
            int v1 = carouselLayoutManager0.getPosition(view0);
            float f = (float)carouselLayoutManager0.z(v1, carouselLayoutManager0.y(v1));
            return (int)(((float)carouselLayoutManager0.a) - f);
        }
        return 0;
    }

    @Override  // androidx.recyclerview.widget.J0
    public final PointF computeScrollVectorForPosition(int v) {
        return this.a.computeScrollVectorForPosition(v);
    }
}

