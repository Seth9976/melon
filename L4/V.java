package l4;

import android.os.Bundle;
import androidx.appcompat.app.o;

public final class v {
    public final Bundle a;
    public G b;

    public v(Bundle bundle0) {
        this.a = bundle0;
    }

    public v(G g0, boolean z) {
        if(g0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Bundle bundle0 = new Bundle();
        this.a = bundle0;
        this.b = g0;
        bundle0.putBundle("selector", g0.a);
        bundle0.putBoolean("activeScan", z);
    }

    public final void a() {
        if(this.b == null) {
            G g0 = G.b(this.a.getBundle("selector"));
            this.b = g0;
            if(g0 == null) {
                this.b = G.c;
            }
        }
    }

    public final boolean b() {
        return this.a.getBoolean("activeScan");
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 instanceof v) {
            this.a();
            G g0 = this.b;
            ((v)object0).a();
            return g0.equals(((v)object0).b) && this.b() == ((v)object0).b();
        }
        return false;
    }

    @Override
    public final int hashCode() {
        this.a();
        return this.b.hashCode() ^ this.b();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("DiscoveryRequest{ selector=");
        this.a();
        stringBuilder0.append(this.b);
        stringBuilder0.append(", activeScan=");
        stringBuilder0.append(this.b());
        stringBuilder0.append(", isValid=");
        this.a();
        G g0 = this.b;
        g0.a();
        return o.s(stringBuilder0, !g0.b.contains(null), " }");
    }
}

