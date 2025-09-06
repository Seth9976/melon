package Vb;

import U4.x;
import com.iloen.melon.constants.CType;
import kotlin.jvm.internal.q;

public final class v0 {
    public final String a;
    public final CType b;
    public final String c;

    public v0(String s, CType cType0, String s1) {
        this.a = s;
        this.b = cType0;
        this.c = s1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v0)) {
            return false;
        }
        if(!q.b(this.a, ((v0)object0).a)) {
            return false;
        }
        return q.b(this.b, ((v0)object0).b) ? q.b(this.c, ((v0)object0).c) : false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("PlayableMediaId(trackId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", cType=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", contentId=");
        return x.m(stringBuilder0, this.c, ")");
    }
}

