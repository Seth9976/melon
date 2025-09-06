package Yb;

import com.iloen.melon.drm.DcfError;
import kotlin.jvm.internal.q;

public final class k extends m {
    public final String c;
    public final DcfError d;
    public final String e;

    public k(String s, DcfError dcfError0) {
        q.g(s, "message");
        super(s, null);
        this.c = s;
        this.d = dcfError0;
        this.e = "DrmException.LoadError";
    }

    @Override  // Sb.a
    public final String b() {
        return this.e;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k)) {
            return false;
        }
        return q.b(this.c, ((k)object0).c) ? q.b(this.d, ((k)object0).d) : false;
    }

    @Override
    public final String getMessage() {
        return this.c;
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + this.c.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "LoadError(message=" + this.c + ", error=" + this.d + ")";
    }
}

