package c2;

import S1.d;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation.Bounds;
import android.view.WindowInsetsAnimation.Callback;
import android.view.WindowInsetsAnimation;
import androidx.datastore.preferences.protobuf.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import x9.c;

public final class i0 extends WindowInsetsAnimation.Callback {
    public final m a;
    public List b;
    public ArrayList c;
    public final HashMap d;

    public i0(m m0) {
        super(m0.a);
        this.d = new HashMap();
        this.a = m0;
    }

    public final l0 a(WindowInsetsAnimation windowInsetsAnimation0) {
        l0 l00 = (l0)this.d.get(windowInsetsAnimation0);
        if(l00 == null) {
            l00 = new l0(0, null, 0L);
            if(Build.VERSION.SDK_INT >= 30) {
                l00.a = new j0(windowInsetsAnimation0);
            }
            this.d.put(windowInsetsAnimation0, l00);
        }
        return l00;
    }

    @Override  // android.view.WindowInsetsAnimation$Callback
    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation0) {
        l0 l00 = this.a(windowInsetsAnimation0);
        this.a.d(l00);
        this.d.remove(windowInsetsAnimation0);
    }

    @Override  // android.view.WindowInsetsAnimation$Callback
    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation0) {
        l0 l00 = this.a(windowInsetsAnimation0);
        this.a.e(l00);
    }

    @Override  // android.view.WindowInsetsAnimation$Callback
    public final WindowInsets onProgress(WindowInsets windowInsets0, List list0) {
        ArrayList arrayList0 = this.c;
        if(arrayList0 == null) {
            ArrayList arrayList1 = new ArrayList(list0.size());
            this.c = arrayList1;
            this.b = Collections.unmodifiableList(arrayList1);
        }
        else {
            arrayList0.clear();
        }
        for(int v = list0.size() - 1; v >= 0; --v) {
            WindowInsetsAnimation windowInsetsAnimation0 = h0.j(list0.get(v));
            l0 l00 = this.a(windowInsetsAnimation0);
            float f = windowInsetsAnimation0.getFraction();
            l00.a.e(f);
            this.c.add(l00);
        }
        B0 b00 = B0.h(null, windowInsets0);
        return this.a.f(b00, this.b).g();
    }

    @Override  // android.view.WindowInsetsAnimation$Callback
    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation0, WindowInsetsAnimation.Bounds windowInsetsAnimation$Bounds0) {
        l0 l00 = this.a(windowInsetsAnimation0);
        c c0 = new c(windowInsetsAnimation$Bounds0);
        c c1 = this.a.g(l00, c0);
        c1.getClass();
        return h0.h(((d)c1.b).e(), ((d)c1.c).e());
    }
}

