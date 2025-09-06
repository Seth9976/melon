package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ListView;
import d5.c;
import java.util.ArrayList;
import java.util.Iterator;
import l4.O;

final class OverlayListView extends ListView {
    public final ArrayList a;

    public OverlayListView(Context context0) {
        super(context0);
        this.a = new ArrayList();
    }

    public OverlayListView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new ArrayList();
    }

    public OverlayListView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = new ArrayList();
    }

    @Override  // android.view.View
    public final void onDraw(Canvas canvas0) {
        int v1;
        super.onDraw(canvas0);
        ArrayList arrayList0 = this.a;
        if(arrayList0.size() > 0) {
            Iterator iterator0 = arrayList0.iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                L l0 = (L)object0;
                BitmapDrawable bitmapDrawable0 = l0.a;
                if(bitmapDrawable0 != null) {
                    bitmapDrawable0.draw(canvas0);
                }
                long v = this.getDrawingTime();
                BitmapDrawable bitmapDrawable1 = l0.a;
                Rect rect0 = l0.c;
                if(l0.k) {
                    v1 = 0;
                }
                else {
                    float f = 0.0f;
                    float f1 = Math.max(0.0f, Math.min(1.0f, ((float)(v - l0.i)) / ((float)l0.e)));
                    if(l0.j) {
                        f = f1;
                    }
                    float f2 = l0.d == null ? f : l0.d.getInterpolation(f);
                    int v2 = (int)(((float)l0.g) * f2);
                    rect0.top = l0.f.top + v2;
                    rect0.bottom = l0.f.bottom + v2;
                    float f3 = (l0.h - 1.0f) * f2 + 1.0f;
                    l0.b = f3;
                    if(bitmapDrawable1 != null) {
                        bitmapDrawable1.setAlpha(((int)(f3 * 255.0f)));
                        bitmapDrawable1.setBounds(rect0);
                    }
                    if(l0.j && f >= 1.0f) {
                        l0.k = true;
                        c c0 = l0.l;
                        if(c0 != null) {
                            MediaRouteControllerDialog mediaRouteControllerDialog0 = (MediaRouteControllerDialog)c0.c;
                            mediaRouteControllerDialog0.f0.remove(((O)c0.b));
                            mediaRouteControllerDialog0.b0.notifyDataSetChanged();
                        }
                    }
                    v1 = !l0.k;
                }
                if(v1 == 0) {
                    iterator0.remove();
                }
            }
        }
    }
}

