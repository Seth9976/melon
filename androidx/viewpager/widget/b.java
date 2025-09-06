package androidx.viewpager.widget;

import android.view.View.OnClickListener;
import android.view.View;

public final class b implements View.OnClickListener {
    public final int a;
    public final PagerTabStrip b;

    public b(PagerTabStrip pagerTabStrip0, int v) {
        this.a = v;
        this.b = pagerTabStrip0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            ViewPager viewPager0 = this.b.a;
            viewPager0.setCurrentItem(viewPager0.getCurrentItem() + 1);
            return;
        }
        ViewPager viewPager1 = this.b.a;
        viewPager1.setCurrentItem(viewPager1.getCurrentItem() - 1);
    }
}

