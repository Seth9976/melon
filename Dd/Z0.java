package Dd;

import Ac.p0;
import android.app.Activity;
import kotlin.jvm.internal.q;

public final class z0 extends p0 {
    public final V1 a;
    public final Activity b;

    public z0(V1 v10, Activity activity0) {
        q.g(v10, "uiState");
        super();
        this.a = v10;
        this.b = activity0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof z0)) {
            return false;
        }
        return q.b(this.a, ((z0)object0).a) ? q.b(this.b, ((z0)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 0x1F : v * 0x1F + this.b.hashCode();
    }

    @Override
    public final String toString() {
        return "OnMessageClick(uiState=" + this.a + ", activity=" + this.b + ")";
    }
}

