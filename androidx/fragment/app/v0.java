package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class v0 {
    public final ArrayList a;
    public final HashMap b;
    public final HashMap c;
    public o0 d;

    public v0() {
        this.a = new ArrayList();
        this.b = new HashMap();
        this.c = new HashMap();
    }

    public final void a(I i0) {
        if(this.a.contains(i0)) {
            throw new IllegalStateException("Fragment already added: " + i0);
        }
        synchronized(this.a) {
            this.a.add(i0);
        }
        i0.mAdded = true;
    }

    public final I b(String s) {
        t0 t00 = (t0)this.b.get(s);
        return t00 == null ? null : t00.c;
    }

    public final I c(String s) {
        for(Object object0: this.b.values()) {
            t0 t00 = (t0)object0;
            if(t00 != null) {
                I i0 = t00.c.findFragmentByWho(s);
                if(i0 != null) {
                    return i0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.b.values()) {
            t0 t00 = (t0)object0;
            if(t00 != null) {
                arrayList0.add(t00);
            }
        }
        return arrayList0;
    }

    public final ArrayList e() {
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: this.b.values()) {
            t0 t00 = (t0)object0;
            if(t00 == null) {
                arrayList0.add(null);
            }
            else {
                arrayList0.add(t00.c);
            }
        }
        return arrayList0;
    }

    public final List f() {
        if(this.a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList0 = this.a;
        return new ArrayList(this.a);
    }

    public final void g(t0 t00) {
        I i0 = t00.c;
        HashMap hashMap0 = this.b;
        if(hashMap0.get(i0.mWho) != null) {
            return;
        }
        hashMap0.put(i0.mWho, t00);
        if(i0.mRetainInstanceChangedWhileDetached) {
            if(i0.mRetainInstance) {
                this.d.b(i0);
            }
            else {
                this.d.f(i0);
            }
            i0.mRetainInstanceChangedWhileDetached = false;
        }
        if(l0.P(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + i0);
        }
    }

    public final void h(t0 t00) {
        I i0 = t00.c;
        if(i0.mRetainInstance) {
            this.d.f(i0);
        }
        if(this.b.get(i0.mWho) == t00 && ((t0)this.b.put(i0.mWho, null)) != null && l0.P(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + i0);
        }
    }

    public final Bundle i(Bundle bundle0, String s) {
        return bundle0 == null ? ((Bundle)this.c.remove(s)) : ((Bundle)this.c.put(s, bundle0));
    }
}

