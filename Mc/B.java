package Mc;

import androidx.viewpager2.adapter.f;
import androidx.viewpager2.widget.j;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import we.k;

public final class b extends j {
    public final int a;
    public final Object b;

    public b() {
        this.a = 2;
        super();
        this.b = new ArrayList(3);
    }

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // androidx.viewpager2.widget.j
    public void onPageScrollStateChanged(int v) {
        switch(this.a) {
            case 1: {
                ((f)this.b).b(false);
                return;
            }
            case 2: {
                try {
                    for(Object object0: ((ArrayList)this.b)) {
                        ((j)object0).onPageScrollStateChanged(v);
                    }
                    return;
                }
                catch(ConcurrentModificationException concurrentModificationException0) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException0);
                }
            }
            default: {
                super.onPageScrollStateChanged(v);
            }
        }
    }

    @Override  // androidx.viewpager2.widget.j
    public void onPageScrolled(int v, float f, int v1) {
        if(this.a != 2) {
            super.onPageScrolled(v, f, v1);
            return;
        }
        try {
            for(Object object0: ((ArrayList)this.b)) {
                ((j)object0).onPageScrolled(v, f, v1);
            }
        }
        catch(ConcurrentModificationException concurrentModificationException0) {
            throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException0);
        }
    }

    @Override  // androidx.viewpager2.widget.j
    public final void onPageSelected(int v) {
        switch(this.a) {
            case 0: {
                ((k)this.b).invoke(v);
                return;
            }
            case 1: {
                ((f)this.b).b(false);
                return;
            }
            default: {
                try {
                    for(Object object0: ((ArrayList)this.b)) {
                        ((j)object0).onPageSelected(v);
                    }
                }
                catch(ConcurrentModificationException concurrentModificationException0) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException0);
                }
            }
        }
    }
}

