package com.iloen.melon.custom.tablayout;

import E8.a;
import E8.b;
import U4.x;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.I;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.j;
import b3.Z;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import n8.q;

public abstract class AbsTabIndicatorLayout extends FrameLayout implements j {
    public LinearLayout a;
    public ViewPager b;
    public j c;
    public b d;
    public int e;
    public int f;
    public boolean g;
    public final a h;

    public AbsTabIndicatorLayout(Context context0) {
        this(context0, null);
    }

    public AbsTabIndicatorLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.g = false;
        this.h = new a(this, 0);
        this.d();
    }

    public abstract void a(TabInfo arg1, int arg2);

    public void b() {
        LogU.d("AbsTabIndicatorLayout", "notifyDataSetChanged");
        if(this.b == null) {
            LogU.w("AbsTabIndicatorLayout", "ViewPager is invalid!!");
            return;
        }
        LinearLayout linearLayout0 = this.a;
        if(linearLayout0 == null) {
            LogU.w("AbsTabIndicatorLayout", "TabContainer is invalid!!");
            return;
        }
        linearLayout0.removeAllViews();
        androidx.viewpager.widget.a a0 = this.b.getAdapter();
        if(a0 instanceof q) {
            int v = ((q)a0).a.size();
            for(int v1 = 0; v1 < v; ++v1) {
                I i0 = ((q)a0).getItem(v1);
                if(i0 instanceof MelonBaseFragment) {
                    this.a(((MelonBaseFragment)i0).getTabInfo(), v1);
                }
            }
            int v2 = this.f;
            if(v2 > v) {
                this.f = v2 % v;
            }
            this.setCurrentItem(this.f);
            this.requestLayout();
        }
    }

    public final void c(int v, String s) {
        TabView tabView0 = (TabView)this.a.getChildAt(v);
        if(tabView0 != null) {
            tabView0.setCount(s);
            this.a.requestLayout();
            this.requestLayout();
        }
    }

    public abstract void d();

    public final void e(ArrayList arrayList0) {
        LogU.d("AbsTabIndicatorLayout", "updateTabViewLayout");
        if(this.b == null) {
            LogU.w("AbsTabIndicatorLayout", "ViewPager is invalid!!");
            return;
        }
        LinearLayout linearLayout0 = this.a;
        if(linearLayout0 == null) {
            LogU.w("AbsTabIndicatorLayout", "TabContainer is invalid!!");
            return;
        }
        linearLayout0.removeAllViews();
        for(int v = 0; v < arrayList0.size(); ++v) {
            this.a(((TabInfo)arrayList0.get(v)), v);
        }
        this.setCurrentItem(this.f);
        this.requestLayout();
    }

    public int getCurrentItem() {
        return this.f;
    }

    public b getOnTabEventListener() {
        return this.d;
    }

    public int getPreviousIndex() {
        return this.e;
    }

    @Override  // androidx.viewpager.widget.j
    public void onPageScrollStateChanged(int v) {
        j j0 = this.c;
        if(j0 != null) {
            j0.onPageScrollStateChanged(v);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public void onPageScrolled(int v, float f, int v1) {
        j j0 = this.c;
        if(j0 != null) {
            j0.onPageScrolled(v, f, v1);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public void onPageSelected(int v) {
        StringBuilder stringBuilder0 = x.n(v, "onPageSelected : ", " / mSelectedTabIndex : ");
        stringBuilder0.append(this.f);
        stringBuilder0.append(" / mPreviousIndex : ");
        Z.s(this.e, "AbsTabIndicatorLayout", stringBuilder0);
        j j0 = this.c;
        if(j0 != null) {
            j0.onPageSelected(v);
        }
        if(this.e != this.f) {
            androidx.viewpager.widget.a a0 = this.b.getAdapter();
            if(a0 instanceof q) {
                int v1 = this.e;
                if(v1 >= 0 && v1 < ((q)a0).a.size()) {
                    View view0 = this.a.getChildAt(v1);
                    if(view0 instanceof TabView) {
                        if(this.g) {
                            ((TabView)view0).setCount("");
                        }
                        ViewUtils.showWhen(((TabView)view0).h, false);
                        ((TabView)view0).requestLayout();
                    }
                }
                this.requestLayout();
            }
        }
    }

    @Override  // android.view.View
    public void setBackgroundColor(int v) {
        View view0 = this.findViewById(0x7F0A0B11);  // id:tab_background
        if(view0 != null) {
            view0.setBackgroundColor(v);
        }
    }

    public void setCleanCount(boolean z) {
        this.g = z;
    }

    public void setCurrentItem(int v) {
        if(this.b == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        Z.r(v, "setCurrentItem :", "AbsTabIndicatorLayout");
        int v1 = this.f;
        if(v1 != this.e) {
            this.e = v1;
        }
        this.f = v;
        LinearLayout linearLayout0 = this.a;
        if(linearLayout0 != null) {
            int v2 = linearLayout0.getChildCount();
            for(int v3 = 0; v3 < v2; ++v3) {
                View view0 = this.a.getChildAt(v3);
                if(view0 instanceof TabView) {
                    ((TabView)view0).setSelected(this.f == v3);
                }
            }
        }
        this.b.setCurrentItem(v);
    }

    public void setOnPageChangeListener(j j0) {
        this.c = j0;
    }

    public void setOnTabEventListener(b b0) {
        this.d = b0;
    }

    public void setSelectedTabIndex(int v) {
        this.f = v;
    }

    public void setTitleColor(int v) {
        int v1 = this.a.getChildCount();
        for(int v2 = 0; v2 < v1; ++v2) {
            ((TabView)this.a.getChildAt(v2)).f.setTextColor(v);
        }
        this.requestLayout();
    }

    public void setTitleHighlightResource(int v) {
        int v1 = this.a.getChildCount();
        for(int v2 = 0; v2 < v1; ++v2) {
            ((TabView)this.a.getChildAt(v2)).setDotImageRes(v);
        }
        this.requestLayout();
    }

    public void setUnderline(Drawable drawable0) {
        View view0 = this.findViewById(0x7F0A0D6B);  // id:underline
        if(view0 != null) {
            view0.setBackground(drawable0);
        }
    }

    public void setUnderlineColor(int v) {
        View view0 = this.findViewById(0x7F0A0D6B);  // id:underline
        if(view0 != null) {
            view0.setBackgroundColor(v);
        }
    }

    public void setUnderlineDrawable(Drawable drawable0) {
        View view0 = this.findViewById(0x7F0A0D6B);  // id:underline
        if(view0 != null) {
            view0.setBackgroundDrawable(drawable0);
        }
    }

    public void setUnderlineResource(int v) {
        View view0 = this.findViewById(0x7F0A0D6B);  // id:underline
        if(view0 != null) {
            view0.setBackgroundResource(v);
        }
    }

    public void setViewPager(ViewPager viewPager0) {
        LogU.d("AbsTabIndicatorLayout", "setViewPager");
        if(viewPager0 == null) {
            return;
        }
        ViewPager viewPager1 = this.b;
        if(viewPager1 != null) {
            viewPager1.setOnPageChangeListener(null);
        }
        if(viewPager0.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        this.b = viewPager0;
        viewPager0.setOnPageChangeListener(this);
        this.b();
    }
}

