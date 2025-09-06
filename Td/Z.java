package td;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.fragment.app.u0;
import com.iloen.melon.custom.n;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.playermusic.BgType;
import com.melon.ui.playermusic.d;
import kotlin.jvm.internal.q;
import pc.t;

public final class z extends u0 {
    public final LogU a;
    public final int b;
    public final int c;
    public final int d;
    public final BgType[] e;
    public final SparseArray f;
    public final n g;
    public final t h;
    public final b0 i;

    public z(b0 b00, l0 l00) {
        this.i = b00;
        super(l00);
        this.a = new LogU("MusicPlayerBG-Adapter");
        this.b = 3;
        this.c = 1;
        this.d = 2;
        this.e = new BgType[3];
        this.f = new SparseArray();
        this.g = new n(new t(this, 18));
        this.h = new t(b00, 19);
    }

    public final void a(int v) {
        SparseArray sparseArray0 = this.f;
        if(sparseArray0.size() != 0) {
            LogU.debug$default(this.a, "setPlayableFragment() index=" + v, null, false, 6, null);
            BgType[] arr_bgType = this.e;
            if(v > 0) {
                d d0 = (d)sparseArray0.get(v - 1);
                if(d0 != null) {
                    d0.m(arr_bgType[0]);
                }
            }
            d d1 = (d)sparseArray0.get(v);
            if(d1 != null) {
                d1.m(arr_bgType[this.c]);
            }
            if(v < this.g.a() - 1) {
                d d2 = (d)sparseArray0.get(v + 1);
                if(d2 != null) {
                    d2.m(arr_bgType[this.d]);
                }
            }
        }
    }

    @Override  // androidx.fragment.app.u0
    public final void destroyItem(ViewGroup viewGroup0, int v, Object object0) {
        q.g(viewGroup0, "container");
        q.g(object0, "any");
        ((d)this.f.get(v)).f = null;
        this.f.remove(v);
        super.destroyItem(viewGroup0, v, object0);
    }

    @Override  // androidx.viewpager.widget.a
    public final int getCount() {
        return this.g.a();
    }

    @Override  // androidx.fragment.app.u0
    public final I getItem(int v) {
        BgType bgType0;
        int v1 = this.i.o;
        BgType[] arr_bgType = this.e;
        if(v1 > v) {
            bgType0 = arr_bgType[0];
        }
        else {
            bgType0 = v1 >= v ? arr_bgType[this.c] : arr_bgType[this.d];
        }
        LogU.debug$default(this.a, "getItem pos=" + v + ", bgData=" + bgType0, null, false, 6, null);
        I i0 = new d();
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("arg_bg_data", bgType0);
        i0.setArguments(bundle0);
        return i0;
    }

    @Override  // androidx.fragment.app.u0
    public final Object instantiateItem(ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "container");
        d d0 = (d)super.instantiateItem(viewGroup0, v);
        d0.f = this.h;
        this.f.put(v, d0);
        this.a(this.i.o);
        return d0;
    }
}

