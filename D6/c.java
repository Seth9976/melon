package D6;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import androidx.viewpager.widget.i;
import com.google.android.material.tabs.TabLayout;

public final class c implements i {
    public boolean a;
    public final TabLayout b;

    public c(TabLayout tabLayout0) {
        this.b = tabLayout0;
    }

    @Override  // androidx.viewpager.widget.i
    public final void a(ViewPager viewPager0, a a0, a a1) {
        TabLayout tabLayout0 = this.b;
        if(tabLayout0.n0 == viewPager0) {
            tabLayout0.k(a1, this.a);
        }
    }
}

