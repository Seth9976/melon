package a1;

import androidx.appcompat.app.o;
import kotlin.jvm.internal.q;

public final class v extends w {
    public final String a;
    public final S b;

    public v(String s, S s1) {
        this.a = s;
        this.b = s1;
    }

    @Override  // a1.w
    public final S a() {
        return this.b;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v)) {
            return false;
        }
        if(!q.b(this.a, ((v)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((v)object0).b)) {
            return false;
        }
        ((v)object0).getClass();
        return true;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? v * 961 : (v * 0x1F + this.b.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        return o.r(new StringBuilder("LinkAnnotation.Url(url="), this.a, ')');
    }
}

