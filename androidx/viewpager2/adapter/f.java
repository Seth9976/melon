package androidx.viewpager2.adapter;

import Mc.b;
import android.view.ViewParent;
import androidx.appcompat.app.o;
import androidx.fragment.app.I;
import androidx.fragment.app.a;
import androidx.lifecycle.s;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class f {
    public b a;
    public d b;
    public e c;
    public ViewPager2 d;
    public long e;
    public final h f;

    public f(h h0) {
        this.f = h0;
        this.e = -1L;
    }

    public static ViewPager2 a(RecyclerView recyclerView0) {
        ViewParent viewParent0 = recyclerView0.getParent();
        if(!(viewParent0 instanceof ViewPager2)) {
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + viewParent0);
        }
        return (ViewPager2)viewParent0;
    }

    public final void b(boolean z) {
        h h0 = this.f;
        if(!h0.shouldDelayFragmentTransactions() && this.d.getScrollState() == 0 && !h0.mFragments.d() && h0.getItemCount() != 0) {
            int v = this.d.getCurrentItem();
            if(v < h0.getItemCount() && (((long)v) != this.e || z)) {
                I i0 = (I)h0.mFragments.b(((long)v));
                if(i0 != null && i0.isAdded()) {
                    this.e = (long)v;
                    a a0 = o.f(h0.mFragmentManager, h0.mFragmentManager);
                    ArrayList arrayList0 = new ArrayList();
                    I i1 = null;
                    for(int v1 = 0; v1 < h0.mFragments.h(); ++v1) {
                        long v2 = h0.mFragments.e(v1);
                        I i2 = (I)h0.mFragments.i(v1);
                        if(i2.isAdded()) {
                            if(v2 == this.e) {
                                i1 = i2;
                            }
                            else {
                                a0.h(i2, s.d);
                                c c0 = h0.mFragmentEventDispatcher;
                                c0.getClass();
                                ArrayList arrayList1 = new ArrayList();
                                Iterator iterator0 = c0.a.iterator();
                                if(iterator0.hasNext()) {
                                    throw H0.b.b(iterator0);
                                }
                                arrayList0.add(arrayList1);
                            }
                            i2.setMenuVisibility(v2 == this.e);
                        }
                    }
                    if(i1 != null) {
                        a0.h(i1, s.e);
                        c c1 = h0.mFragmentEventDispatcher;
                        c1.getClass();
                        ArrayList arrayList2 = new ArrayList();
                        Iterator iterator1 = c1.a.iterator();
                        if(iterator1.hasNext()) {
                            throw H0.b.b(iterator1);
                        }
                        arrayList0.add(arrayList2);
                    }
                    if(!a0.a.isEmpty()) {
                        a0.m();
                        Collections.reverse(arrayList0);
                        for(Object object0: arrayList0) {
                            h0.mFragmentEventDispatcher.getClass();
                            c.a(((List)object0));
                        }
                    }
                }
            }
        }
    }
}

