package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.graphics.Rect;

public final class z implements Runnable {
    public final int a;
    public final Object b;

    public z(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void run() {
        int v6;
        int v = 0;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                ValueAnimator valueAnimator0 = ((C)object0).z;
                int v1 = ((C)object0).A;
                if(v1 == 1) {
                    valueAnimator0.cancel();
                }
                else if(v1 != 2) {
                    return;
                }
                ((C)object0).A = 3;
                valueAnimator0.setFloatValues(new float[]{((float)(((Float)valueAnimator0.getAnimatedValue()))), 0.0f});
                valueAnimator0.setDuration(500L);
                valueAnimator0.start();
                return;
            }
            case 1: {
                O o0 = (O)object0;
                if(o0.c != null) {
                    long v2 = System.currentTimeMillis();
                    long v3 = o0.B == 0x8000000000000000L ? 0L : v2 - o0.B;
                    w0 w00 = o0.r.getLayoutManager();
                    if(o0.A == null) {
                        o0.A = new Rect();
                    }
                    w00.calculateItemDecorationsForChild(o0.c.itemView, o0.A);
                    if(w00.canScrollHorizontally()) {
                        int v4 = (int)(o0.j + o0.h);
                        int v5 = v4 - o0.A.left - o0.r.getPaddingLeft();
                        float f = o0.h;
                        if(f < 0.0f && v5 < 0) {
                            v6 = v5;
                        }
                        else if(f > 0.0f) {
                            v5 = o0.c.itemView.getWidth() + v4 + o0.A.right - (o0.r.getWidth() - o0.r.getPaddingRight());
                            v6 = v5 > 0 ? v5 : 0;
                        }
                        else {
                            v6 = 0;
                        }
                    }
                    else {
                        v6 = 0;
                    }
                    if(w00.canScrollVertically()) {
                        int v7 = (int)(o0.k + o0.i);
                        int v8 = v7 - o0.A.top - o0.r.getPaddingTop();
                        float f1 = o0.i;
                        if(f1 < 0.0f && v8 < 0) {
                            v = v8;
                        }
                        else if(f1 > 0.0f) {
                            int v9 = o0.c.itemView.getHeight() + v7 + o0.A.bottom - (o0.r.getHeight() - o0.r.getPaddingBottom());
                            if(v9 > 0) {
                                v = v9;
                            }
                        }
                    }
                    if(v6 != 0) {
                        RecyclerView recyclerView0 = o0.r;
                        int v10 = o0.c.itemView.getWidth();
                        int v11 = o0.r.getWidth();
                        v6 = o0.m.interpolateOutOfBoundsScroll(recyclerView0, v10, v6, v11, v3);
                    }
                    if(v != 0) {
                        RecyclerView recyclerView1 = o0.r;
                        int v12 = o0.c.itemView.getHeight();
                        int v13 = o0.r.getHeight();
                        v = o0.m.interpolateOutOfBoundsScroll(recyclerView1, v12, v, v13, v3);
                    }
                    if(v6 == 0 && v == 0) {
                        o0.B = 0x8000000000000000L;
                        return;
                    }
                    if(o0.B == 0x8000000000000000L) {
                        o0.B = v2;
                    }
                    o0.r.scrollBy(v6, v);
                    O0 o00 = o0.c;
                    if(o00 != null) {
                        o0.k(o00);
                    }
                    o0.r.removeCallbacks(o0.s);
                    o0.r.postOnAnimation(this);
                }
                return;
            }
            default: {
                ((StaggeredGridLayoutManager)object0).q();
            }
        }
    }
}

