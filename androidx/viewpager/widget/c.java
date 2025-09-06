package androidx.viewpager.widget;

import android.database.DataSetObserver;

public final class c extends DataSetObserver implements i, j {
    public int a;
    public final PagerTitleStrip b;

    public c(PagerTitleStrip pagerTitleStrip0) {
        this.b = pagerTitleStrip0;
        super();
    }

    @Override  // androidx.viewpager.widget.i
    public final void a(ViewPager viewPager0, a a0, a a1) {
        this.b.a(a0, a1);
    }

    @Override  // android.database.DataSetObserver
    public final void onChanged() {
        this.b.b(this.b.a.getCurrentItem(), this.b.a.getAdapter());
        float f = this.b.f >= 0.0f ? this.b.f : 0.0f;
        this.b.c(this.b.a.getCurrentItem(), true, f);
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrollStateChanged(int v) {
        this.a = v;
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrolled(int v, float f, int v1) {
        if(f > 0.5f) {
            ++v;
        }
        this.b.c(v, false, f);
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageSelected(int v) {
        if(this.a == 0) {
            this.b.b(this.b.a.getCurrentItem(), this.b.a.getAdapter());
            float f = this.b.f >= 0.0f ? this.b.f : 0.0f;
            this.b.c(this.b.a.getCurrentItem(), true, f);
        }
    }
}

