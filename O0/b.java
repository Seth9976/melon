package o0;

import X.k;
import androidx.compose.runtime.V;
import androidx.compose.runtime.w0;
import p0.n;

public final class b implements w0 {
    public l a;
    public i b;
    public String c;
    public Object d;
    public Object[] e;
    public h f;
    public final k g;

    public b(l l0, i i0, String s, Object object0, Object[] arr_object) {
        this.a = l0;
        this.b = i0;
        this.c = s;
        this.d = object0;
        this.e = arr_object;
        this.g = new k(this, 25);
    }

    public final void a() {
        String s;
        i i0 = this.b;
        if(this.f != null) {
            throw new IllegalArgumentException(("entry(" + this.f + ") is not null").toString());
        }
        if(i0 != null) {
            k k0 = this.g;
            Object object0 = k0.invoke();
            if(object0 != null && !i0.a(object0)) {
                if(!(object0 instanceof n)) {
                    s = object0 + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
                }
                else if(((n)object0).h() != V.c && ((n)object0).h() != V.f && ((n)object0).h() != V.d) {
                    s = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                }
                else {
                    s = "MutableState containing " + ((n)object0).getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                }
                throw new IllegalArgumentException(s);
            }
            this.f = i0.d(this.c, k0);
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void c() {
        this.a();
    }

    @Override  // androidx.compose.runtime.w0
    public final void d() {
        h h0 = this.f;
        if(h0 != null) {
            ((androidx.media3.session.legacy.V)h0).E();
        }
    }

    @Override  // androidx.compose.runtime.w0
    public final void e() {
        h h0 = this.f;
        if(h0 != null) {
            ((androidx.media3.session.legacy.V)h0).E();
        }
    }
}

