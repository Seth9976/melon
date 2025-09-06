package k6;

import S1.c;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e extends r0 {
    public final Paint a;
    public List b;

    public e() {
        Paint paint0 = new Paint();
        this.a = paint0;
        this.b = Collections.unmodifiableList(new ArrayList());
        paint0.setStrokeWidth(5.0f);
        paint0.setColor(0xFFFF00FF);
    }

    @Override  // androidx.recyclerview.widget.r0
    public final void onDrawOver(Canvas canvas0, RecyclerView recyclerView0, K0 k00) {
        super.onDrawOver(canvas0, recyclerView0, k00);
        float f = recyclerView0.getResources().getDimension(0x7F070195);  // dimen:m3_carousel_debug_keyline_width
        Paint paint0 = this.a;
        paint0.setStrokeWidth(f);
        for(Object object0: this.b) {
            k k0 = (k)object0;
            paint0.setColor(c.d(k0.c, 0xFFFF00FF, 0xFF0000FF));
            if(((CarouselLayoutManager)recyclerView0.getLayoutManager()).C()) {
                float f1 = (float)((CarouselLayoutManager)recyclerView0.getLayoutManager()).j.i();
                float f2 = (float)((CarouselLayoutManager)recyclerView0.getLayoutManager()).j.d();
                canvas0.drawLine(k0.b, f1, k0.b, f2, paint0);
            }
            else {
                float f3 = (float)((CarouselLayoutManager)recyclerView0.getLayoutManager()).j.f();
                float f4 = (float)((CarouselLayoutManager)recyclerView0.getLayoutManager()).j.g();
                canvas0.drawLine(f3, k0.b, f4, k0.b, paint0);
            }
        }
    }
}

