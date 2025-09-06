package a1;

import A7.d;
import androidx.appcompat.app.o;
import g1.a;
import kotlin.jvm.internal.q;

public final class c {
    public final Object a;
    public final int b;
    public int c;
    public final String d;

    public c(Object object0, int v, int v1, int v2) {
        if((v2 & 4) != 0) {
            v1 = 0x80000000;
        }
        this(((v2 & 8) == 0 ? "androidx.compose.foundation.text.inlineContent" : ""), v, v1, object0);
    }

    public c(String s, int v, int v1, Object object0) {
        this.a = object0;
        this.b = v;
        this.c = v1;
        this.d = s;
    }

    public final e a(int v) {
        int v1 = this.c;
        if(v1 != 0x80000000) {
            v = v1;
        }
        if(v == 0x80000000) {
            a.c("Item.end should be set first");
        }
        return new e(this.d, this.b, v, this.a);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c)) {
            return false;
        }
        if(!q.b(this.a, ((c)object0).a)) {
            return false;
        }
        if(this.b != ((c)object0).b) {
            return false;
        }
        return this.c == ((c)object0).c ? q.b(this.d, ((c)object0).d) : false;
    }

    @Override
    public final int hashCode() {
        return this.a == null ? this.d.hashCode() + d.b(this.c, d.b(this.b, 0, 0x1F), 0x1F) : this.d.hashCode() + d.b(this.c, d.b(this.b, this.a.hashCode() * 0x1F, 0x1F), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MutableRange(item=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", start=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", end=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", tag=");
        return o.r(stringBuilder0, this.d, ')');
    }
}

