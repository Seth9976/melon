package androidx.media3.session;

import X2.l;
import android.os.Bundle;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.b0;
import androidx.media3.session.legacy.s;
import java.util.ArrayList;
import java.util.Objects;

public final class j0 implements v0 {
    public final Object a;
    public final b0 b;
    public final ArrayList c;
    public final k0 d;

    public j0(k0 k00, b0 b00) {
        this.d = k00;
        this.a = new Object();
        this.c = new ArrayList();
        this.b = b00;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof j0 ? Objects.equals(this.b, ((j0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(new Object[]{this.b});
    }

    @Override  // androidx.media3.session.v0
    public final void p(int v, String s) {
        Bundle bundle0 = Bundle.EMPTY;
        b0 b00 = this.b;
        if(b00 == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if(bundle0 == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        s s1 = this.d.a;
        s1.getClass();
        l l0 = new l(s1, b00, s, bundle0, 1);
        ((MediaBrowserServiceCompat)s1.d).g.post(l0);
    }
}

