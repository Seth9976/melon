package e;

import Sf.n;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.B;
import androidx.lifecycle.D;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import f.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.q;

public abstract class h {
    public final LinkedHashMap a;
    public final LinkedHashMap b;
    public final LinkedHashMap c;
    public final ArrayList d;
    public final transient LinkedHashMap e;
    public final LinkedHashMap f;
    public final Bundle g;

    public h() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new ArrayList();
        this.e = new LinkedHashMap();
        this.f = new LinkedHashMap();
        this.g = new Bundle();
    }

    public final boolean a(int v, int v1, Intent intent0) {
        String s = (String)this.a.get(v);
        if(s == null) {
            return false;
        }
        d d0 = (d)this.e.get(s);
        if((d0 == null ? null : d0.a) != null) {
            ArrayList arrayList0 = this.d;
            if(arrayList0.contains(s)) {
                Object object0 = d0.b.parseResult(v1, intent0);
                d0.a.onActivityResult(object0);
                arrayList0.remove(s);
                return true;
            }
        }
        this.f.remove(s);
        ActivityResult activityResult0 = new ActivityResult(v1, intent0);
        this.g.putParcelable(s, activityResult0);
        return true;
    }

    public abstract void b(int arg1, b arg2, Object arg3);

    public final g c(String s, D d0, b b0, a a0) {
        q.g(s, "key");
        q.g(b0, "contract");
        q.g(a0, "callback");
        t t0 = d0.getLifecycle();
        if(t0.b().compareTo(s.d) >= 0) {
            throw new IllegalStateException(("LifecycleOwner " + d0 + " is attempting to register while current state is " + t0.b() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        this.e(s);
        LinkedHashMap linkedHashMap0 = this.c;
        e e0 = (e)linkedHashMap0.get(s);
        if(e0 == null) {
            e0 = new e(t0);
        }
        c c0 = new c(this, s, a0, b0);
        e0.a.a(c0);
        e0.b.add(c0);
        linkedHashMap0.put(s, e0);
        return new g(this, s, b0, 0);
    }

    public final g d(String s, b b0, a a0) {
        q.g(s, "key");
        q.g(b0, "contract");
        this.e(s);
        d d0 = new d(b0, a0);
        this.e.put(s, d0);
        LinkedHashMap linkedHashMap0 = this.f;
        if(linkedHashMap0.containsKey(s)) {
            Object object0 = linkedHashMap0.get(s);
            linkedHashMap0.remove(s);
            a0.onActivityResult(object0);
        }
        Bundle bundle0 = this.g;
        ActivityResult activityResult0 = (ActivityResult)com.google.firebase.b.F(bundle0, s, ActivityResult.class);
        if(activityResult0 != null) {
            bundle0.remove(s);
            a0.onActivityResult(b0.parseResult(activityResult0.a, activityResult0.b));
        }
        return new g(this, s, b0, 1);
    }

    public final void e(String s) {
        LinkedHashMap linkedHashMap0 = this.b;
        if(((Integer)linkedHashMap0.get(s)) != null) {
            return;
        }
        for(Object object0: ((Sf.a)n.l0(f.f))) {
            Number number0 = (Number)object0;
            LinkedHashMap linkedHashMap1 = this.a;
            if(!linkedHashMap1.containsKey(number0.intValue())) {
                int v = number0.intValue();
                linkedHashMap1.put(v, s);
                linkedHashMap0.put(s, v);
                return;
            }
            if(false) {
                break;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void f(String s) {
        q.g(s, "key");
        if(!this.d.contains(s)) {
            Integer integer0 = (Integer)this.b.remove(s);
            if(integer0 != null) {
                this.a.remove(integer0);
            }
        }
        this.e.remove(s);
        LinkedHashMap linkedHashMap0 = this.f;
        if(linkedHashMap0.containsKey(s)) {
            StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("Dropping pending result for request ", s, ": ");
            stringBuilder0.append(linkedHashMap0.get(s));
            Log.w("ActivityResultRegistry", stringBuilder0.toString());
            linkedHashMap0.remove(s);
        }
        Bundle bundle0 = this.g;
        if(bundle0.containsKey(s)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + s + ": " + ((ActivityResult)com.google.firebase.b.F(bundle0, s, ActivityResult.class)));
            bundle0.remove(s);
        }
        LinkedHashMap linkedHashMap1 = this.c;
        e e0 = (e)linkedHashMap1.get(s);
        if(e0 != null) {
            ArrayList arrayList0 = e0.b;
            for(Object object0: arrayList0) {
                e0.a.c(((B)object0));
            }
            arrayList0.clear();
            linkedHashMap1.remove(s);
        }
    }
}

