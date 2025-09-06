package androidx.viewpager2.widget;

import android.view.View;
import d2.n;
import d5.i;

public final class k implements n {
    public final int a;
    public final i b;

    public k(i i0, int v) {
        this.a = v;
        this.b = i0;
        super();
    }

    @Override  // d2.n
    public final boolean t(View view0) {
        if(this.a != 0) {
            int v = ((ViewPager2)view0).getCurrentItem();
            ViewPager2 viewPager20 = (ViewPager2)this.b.d;
            if(viewPager20.B) {
                viewPager20.d(v - 1, true);
            }
            return true;
        }
        int v1 = ((ViewPager2)view0).getCurrentItem();
        ViewPager2 viewPager21 = (ViewPager2)this.b.d;
        if(viewPager21.B) {
            viewPager21.d(v1 + 1, true);
        }
        return true;
    }
}

