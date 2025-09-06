package androidx.recyclerview.widget;

import androidx.fragment.app.F0;
import d5.e;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public final class h {
    public final a0 a;
    public final e b;
    public final g c;
    public final CopyOnWriteArrayList d;
    public List e;
    public List f;
    public int g;
    public static final g h;

    static {
        h.h = new g();
    }

    public h(a0 a00, e e0) {
        this.d = new CopyOnWriteArrayList();
        this.f = Collections.EMPTY_LIST;
        this.a = a00;
        this.b = e0;
        this.c = h.h;
    }

    public final void a(List list0, Runnable runnable0) {
        for(Object object0: this.d) {
            ((f)object0).a(list0, this.f);
        }
        if(runnable0 != null) {
            runnable0.run();
        }
    }

    public final void b(List list0, Runnable runnable0) {
        int v = this.g + 1;
        this.g = v;
        List list1 = this.e;
        if(list0 == list1) {
            if(runnable0 != null) {
                runnable0.run();
            }
            return;
        }
        List list2 = this.f;
        a0 a00 = this.a;
        if(list0 == null) {
            this.e = null;
            this.f = Collections.EMPTY_LIST;
            a00.i(0, list1.size());
            this.a(list2, runnable0);
            return;
        }
        if(list1 == null) {
            this.e = list0;
            this.f = Collections.unmodifiableList(list0);
            a00.e(0, list0.size());
            this.a(list2, runnable0);
            return;
        }
        ((Executor)this.b.b).execute(new F0(this, list1, list0, v, runnable0));
    }
}

