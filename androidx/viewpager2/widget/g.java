package androidx.viewpager2.widget;

public final class g extends j {
    public final int a;
    public final ViewPager2 b;

    public g(ViewPager2 viewPager20, int v) {
        this.a = v;
        this.b = viewPager20;
        super();
    }

    @Override  // androidx.viewpager2.widget.j
    public void onPageScrollStateChanged(int v) {
        if(this.a != 0) {
            super.onPageScrollStateChanged(v);
            return;
        }
        if(v == 0) {
            this.b.e();
        }
    }

    @Override  // androidx.viewpager2.widget.j
    public final void onPageSelected(int v) {
        if(this.a != 0) {
            ViewPager2 viewPager20 = this.b;
            viewPager20.clearFocus();
            if(viewPager20.hasFocus()) {
                viewPager20.j.requestFocus(2);
            }
            return;
        }
        ViewPager2 viewPager21 = this.b;
        if(viewPager21.d != v) {
            viewPager21.d = v;
            viewPager21.E.i();
        }
    }
}

