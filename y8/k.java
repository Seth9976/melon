package y8;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class k {
    public final int a;
    public final int b;
    public final int c;
    public final String d;
    public final float[] e;

    public k(int v, int v1, int v2, String s, float[] arr_f) {
        q.g(s, "eqName");
        q.g(arr_f, "eqValues");
        super();
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = s;
        this.e = arr_f;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof k)) {
            return false;
        }
        if(this.a != ((k)object0).a) {
            return false;
        }
        if(this.b != ((k)object0).b) {
            return false;
        }
        if(this.c != ((k)object0).c) {
            return false;
        }
        return q.b(this.d, ((k)object0).d) ? q.b(this.e, ((k)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.e) + x.b(d.b(this.c, d.b(this.b, this.a * 0x1F, 0x1F), 0x1F), 0x1F, this.d);
    }

    @Override
    public final String toString() {
        String s = Arrays.toString(this.e);
        StringBuilder stringBuilder0 = o.t(this.a, this.b, "EqualizerState(eqStatus=", ", eqType=", ", eqId=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", eqName=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", eqValues=");
        return x.m(stringBuilder0, s, ")");
    }
}

