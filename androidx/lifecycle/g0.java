package androidx.lifecycle;

import E4.d;
import E4.e;
import Nc.f;
import Q0.o0;
import android.os.Bundle;
import d3.g;
import ie.m;
import ie.r;
import java.util.Arrays;
import java.util.Map.Entry;
import kotlin.jvm.internal.q;

public final class g0 implements d {
    public final e a;
    public boolean b;
    public Bundle c;
    public final r d;

    public g0(e e0, r0 r00) {
        q.g(e0, "savedStateRegistry");
        super();
        this.a = e0;
        this.d = g.Q(new f(r00, 26));
    }

    @Override  // E4.d
    public final Bundle a() {
        Bundle bundle0 = d5.f.j(((m[])Arrays.copyOf(new m[0], 0)));
        Bundle bundle1 = this.c;
        if(bundle1 != null) {
            bundle0.putAll(bundle1);
        }
        for(Object object0: ((h0)this.d.getValue()).a.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            Bundle bundle2 = ((o0)((c0)((Map.Entry)object0).getValue()).b.f).a();
            if(!bundle2.isEmpty()) {
                q.g(s, "key");
                bundle0.putBundle(s, bundle2);
            }
        }
        this.b = false;
        return bundle0;
    }

    public final void b() {
        if(!this.b) {
            Bundle bundle0 = this.a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundle1 = d5.f.j(((m[])Arrays.copyOf(new m[0], 0)));
            Bundle bundle2 = this.c;
            if(bundle2 != null) {
                bundle1.putAll(bundle2);
            }
            if(bundle0 != null) {
                bundle1.putAll(bundle0);
            }
            this.c = bundle1;
            this.b = true;
            h0 h00 = (h0)this.d.getValue();
        }
    }
}

