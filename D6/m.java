package D6;

import androidx.viewpager.widget.ViewPager;

public final class m implements e {
    public final ViewPager a;

    public m(ViewPager viewPager0) {
        this.a = viewPager0;
    }

    @Override  // D6.d
    public final void onTabReselected(i i0) {
    }

    @Override  // D6.d
    public final void onTabSelected(i i0) {
        this.a.setCurrentItem(i0.d);
    }

    @Override  // D6.d
    public final void onTabUnselected(i i0) {
    }
}

