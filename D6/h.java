package D6;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View.MeasureSpec;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import com.google.android.material.internal.B;
import com.google.android.material.tabs.TabLayout;
import z6.f;

public final class h extends LinearLayout {
    public ValueAnimator a;
    public final TabLayout b;
    public static final int c;

    public h(TabLayout tabLayout0, Context context0) {
        this.b = tabLayout0;
        super(context0);
        this.setWillNotDraw(false);
    }

    public final void a(int v) {
        TabLayout tabLayout0 = this.b;
        if(tabLayout0.t0 != 0 && (tabLayout0.getTabSelectedIndicator().getBounds().left != -1 || tabLayout0.getTabSelectedIndicator().getBounds().right != -1)) {
            return;
        }
        View view0 = this.getChildAt(v);
        Drawable drawable0 = tabLayout0.o;
        tabLayout0.h0.getClass();
        RectF rectF0 = f.c(tabLayout0, view0);
        drawable0.setBounds(((int)rectF0.left), drawable0.getBounds().top, ((int)rectF0.right), drawable0.getBounds().bottom);
        tabLayout0.a = v;
    }

    public final void b(int v) {
        Rect rect0 = this.b.o.getBounds();
        this.b.o.setBounds(rect0.left, 0, rect0.right, v);
        this.requestLayout();
    }

    public final void c(View view0, View view1, float f) {
        TabLayout tabLayout0 = this.b;
        if(view0 == null || view0.getWidth() <= 0) {
            tabLayout0.o.setBounds(-1, tabLayout0.o.getBounds().top, -1, tabLayout0.o.getBounds().bottom);
        }
        else {
            tabLayout0.h0.t(tabLayout0, view0, view1, f, tabLayout0.o);
        }
        this.postInvalidateOnAnimation();
    }

    public final void d(int v, int v1, boolean z) {
        TabLayout tabLayout0 = this.b;
        if(tabLayout0.a == v) {
            return;
        }
        View view0 = this.getChildAt(tabLayout0.getSelectedTabPosition());
        View view1 = this.getChildAt(v);
        if(view1 == null) {
            this.a(tabLayout0.getSelectedTabPosition());
            return;
        }
        tabLayout0.a = v;
        g g0 = new g(this, view0, view1);
        if(z) {
            ValueAnimator valueAnimator0 = new ValueAnimator();
            this.a = valueAnimator0;
            valueAnimator0.setInterpolator(tabLayout0.i0);
            valueAnimator0.setDuration(((long)v1));
            valueAnimator0.setFloatValues(new float[]{0.0f, 1.0f});
            valueAnimator0.addUpdateListener(g0);
            valueAnimator0.start();
            return;
        }
        this.a.removeAllUpdateListeners();
        this.a.addUpdateListener(g0);
    }

    @Override  // android.view.View
    public final void draw(Canvas canvas0) {
        TabLayout tabLayout0 = this.b;
        int v = tabLayout0.o.getBounds().height();
        if(v < 0) {
            v = tabLayout0.o.getIntrinsicHeight();
        }
        int v1 = 0;
        int v2 = tabLayout0.W;
        if(v2 == 0) {
            v1 = this.getHeight() - v;
            v = this.getHeight();
        }
        else {
            switch(v2) {
                case 1: {
                    v1 = (this.getHeight() - v) / 2;
                    v = (this.getHeight() + v) / 2;
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    v = this.getHeight();
                    break;
                }
                default: {
                    v = 0;
                }
            }
        }
        if(tabLayout0.o.getBounds().width() > 0) {
            Rect rect0 = tabLayout0.o.getBounds();
            tabLayout0.o.setBounds(rect0.left, v1, rect0.right, v);
            tabLayout0.o.draw(canvas0);
        }
        super.draw(canvas0);
    }

    @Override  // android.widget.LinearLayout
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        TabLayout tabLayout0 = this.b;
        if(this.a != null && this.a.isRunning()) {
            this.d(tabLayout0.getSelectedTabPosition(), -1, false);
            return;
        }
        if(tabLayout0.a == -1) {
            tabLayout0.a = tabLayout0.getSelectedTabPosition();
        }
        this.a(tabLayout0.a);
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(v, v1);
        if(View.MeasureSpec.getMode(v) == 0x40000000) {
            TabLayout tabLayout0 = this.b;
            int v2 = 1;
            if(tabLayout0.T == 1 || tabLayout0.b0 == 2) {
                int v3 = this.getChildCount();
                int v6 = 0;
                for(int v5 = 0; v5 < v3; ++v5) {
                    View view0 = this.getChildAt(v5);
                    if(view0.getVisibility() == 0) {
                        v6 = Math.max(v6, view0.getMeasuredWidth());
                    }
                }
                if(v6 > 0) {
                    int v7 = (int)B.g(this.getContext(), 16);
                    if(v6 * v3 <= this.getMeasuredWidth() - v7 * 2) {
                        int v8 = 0;
                        for(int v4 = 0; v4 < v3; ++v4) {
                            LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)this.getChildAt(v4).getLayoutParams();
                            if(linearLayout$LayoutParams0.width != v6 || linearLayout$LayoutParams0.weight != 0.0f) {
                                linearLayout$LayoutParams0.width = v6;
                                linearLayout$LayoutParams0.weight = 0.0f;
                                v8 = 1;
                            }
                        }
                        v2 = v8;
                    }
                    else {
                        tabLayout0.T = 0;
                        tabLayout0.n(false);
                    }
                    if(v2 != 0) {
                        super.onMeasure(v, v1);
                    }
                }
            }
        }
    }
}

