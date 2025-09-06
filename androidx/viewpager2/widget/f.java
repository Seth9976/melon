package androidx.viewpager2.widget;

import androidx.recyclerview.widget.l0;
import d5.i;

public final class f extends l0 {
    public final int a;
    public final Object b;

    public f(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // androidx.recyclerview.widget.l0
    public final void onChanged() {
        if(this.a != 0) {
            ((i)this.b).i();
            return;
        }
        ((ViewPager2)this.b).e = true;
        ((ViewPager2)this.b).l.l = true;
    }

    @Override  // androidx.recyclerview.widget.l0
    public final void onItemRangeChanged(int v, int v1) {
        this.onChanged();
    }

    @Override  // androidx.recyclerview.widget.l0
    public final void onItemRangeChanged(int v, int v1, Object object0) {
        this.onChanged();
    }

    @Override  // androidx.recyclerview.widget.l0
    public final void onItemRangeInserted(int v, int v1) {
        this.onChanged();
    }

    @Override  // androidx.recyclerview.widget.l0
    public final void onItemRangeMoved(int v, int v1, int v2) {
        this.onChanged();
    }

    @Override  // androidx.recyclerview.widget.l0
    public final void onItemRangeRemoved(int v, int v1) {
        this.onChanged();
    }
}

