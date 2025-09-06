package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
import b2.b;
import java.util.Calendar;

public final class n extends r0 {
    public final Calendar a;
    public final Calendar b;
    public final p c;

    public n(p p0) {
        this.c = p0;
        this.a = E.g(null);
        this.b = E.g(null);
    }

    @Override  // androidx.recyclerview.widget.r0
    public final void onDraw(Canvas canvas0, RecyclerView recyclerView0, K0 k00) {
        int v11;
        int v9;
        if(recyclerView0.getAdapter() instanceof H && recyclerView0.getLayoutManager() instanceof GridLayoutManager) {
            H h0 = (H)recyclerView0.getAdapter();
            GridLayoutManager gridLayoutManager0 = (GridLayoutManager)recyclerView0.getLayoutManager();
            p p0 = this.c;
            for(Object object0: p0.c.G()) {
                Object object1 = ((b)object0).a;
                Object object2 = ((b)object0).b;
                if(object1 != null && object2 != null) {
                    this.a.setTimeInMillis(((long)(((Long)object1))));
                    this.b.setTimeInMillis(((long)(((Long)object2))));
                    int v = this.a.get(1) - h0.a.d.a.c;
                    int v1 = this.b.get(1) - h0.a.d.a.c;
                    View view0 = gridLayoutManager0.findViewByPosition(v);
                    View view1 = gridLayoutManager0.findViewByPosition(v1);
                    int v2 = gridLayoutManager0.b;
                    int v3 = v / v2;
                    int v4 = v1 / v2;
                    for(int v5 = v3; v5 <= v4; ++v5) {
                        View view2 = gridLayoutManager0.findViewByPosition(gridLayoutManager0.b * v5);
                        if(view2 != null) {
                            int v6 = view2.getTop() + ((Rect)((androidx.recyclerview.widget.b)p0.h.e).b).top;
                            int v7 = view2.getBottom() - ((Rect)((androidx.recyclerview.widget.b)p0.h.e).b).bottom;
                            if(v5 != v3 || view0 == null) {
                                v9 = 0;
                            }
                            else {
                                int v8 = view0.getLeft();
                                v9 = view0.getWidth() / 2 + v8;
                            }
                            if(v5 != v4 || view1 == null) {
                                v11 = recyclerView0.getWidth();
                            }
                            else {
                                int v10 = view1.getLeft();
                                v11 = view1.getWidth() / 2 + v10;
                            }
                            canvas0.drawRect(((float)v9), ((float)v6), ((float)v11), ((float)v7), ((Paint)p0.h.i));
                        }
                    }
                }
            }
        }
    }
}

