package D6;

import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

public final class j implements androidx.viewpager.widget.j {
    public final WeakReference a;
    public int b;
    public int c;

    public j(TabLayout tabLayout0) {
        this.a = new WeakReference(tabLayout0);
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrollStateChanged(int v) {
        this.b = this.c;
        this.c = v;
        TabLayout tabLayout0 = (TabLayout)this.a.get();
        if(tabLayout0 != null) {
            tabLayout0.t0 = this.c;
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageScrolled(int v, float f, int v1) {
        boolean z1;
        Object object0 = this.a.get();
        if(((TabLayout)object0) != null) {
            int v2 = this.c;
            boolean z = true;
            if(v2 != 2 || this.b == 1) {
                z1 = true;
            }
            else {
                z1 = true;
                z = false;
            }
            if(v2 == 2 && this.b == 0) {
                z1 = false;
            }
            ((TabLayout)object0).l(v, f, z, z1, false);
        }
    }

    @Override  // androidx.viewpager.widget.j
    public final void onPageSelected(int v) {
        TabLayout tabLayout0 = (TabLayout)this.a.get();
        if(tabLayout0 != null && tabLayout0.getSelectedTabPosition() != v && v < tabLayout0.getTabCount()) {
            boolean z = this.c == 0 || this.c == 2 && this.b == 0;
            tabLayout0.j(tabLayout0.g(v), z);
        }
    }
}

