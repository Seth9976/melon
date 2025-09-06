package n8;

import android.view.ViewGroup;
import androidx.fragment.app.I;
import androidx.fragment.app.N0;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import b3.Z;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.List;

public class q extends N0 {
    public final ArrayList a;
    public final l0 b;

    public q(List list0, l0 l00) {
        super(l00);
        ArrayList arrayList0 = new ArrayList();
        this.a = arrayList0;
        this.b = l00;
        arrayList0.addAll(list0);
    }

    @Override  // androidx.fragment.app.N0
    public final void destroyItem(ViewGroup viewGroup0, int v, Object object0) {
        Z.r(v, "destroyItem: ", "TabPagerAdapter");
        super.destroyItem(viewGroup0, v, object0);
        ArrayList arrayList0 = this.a;
        if(arrayList0.size() > v) {
            I i0 = (I)arrayList0.get(v);
            if(i0 != null) {
                this.b.getClass();
                a a0 = new a(this.b);
                a0.d(i0);
                a0.f(i0);
                a0.l(true, true);
            }
        }
    }

    @Override  // androidx.viewpager.widget.a
    public final int getCount() {
        return this.a.size();
    }

    @Override  // androidx.fragment.app.N0
    public final I getItem(int v) {
        I i0 = (I)this.a.get(v);
        LogU.d("TabPagerAdapter", "getItem: " + v + ", f:" + i0 + ", isAdded:" + i0.isAdded());
        return i0;
    }
}

