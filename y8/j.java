package y8;

import A7.d;
import U4.x;
import java.util.Arrays;
import kotlin.jvm.internal.q;

public final class j extends i {
    public final String b;
    public final p c;
    public final String d;
    public final float[] e;

    public j(String s, p p0, String s1, float[] arr_f) {
        q.g(p0, "presetType");
        q.g(s1, "name");
        super(p0.a, s1, arr_f);
        this.b = s;
        this.c = p0;
        this.d = s1;
        this.e = arr_f;
    }

    @Override  // y8.i
    public final String b() {
        return this.d;
    }

    @Override  // y8.i
    public final float[] c() {
        return this.e;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof j)) {
            return false;
        }
        if(!q.b(this.b, ((j)object0).b)) {
            return false;
        }
        if(this.c != ((j)object0).c) {
            return false;
        }
        return q.b(this.d, ((j)object0).d) ? q.b(this.e, ((j)object0).e) : false;
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(this.e) + x.b((this.c.hashCode() + this.b.hashCode() * 0x1F) * 0x1F, 0x1F, this.d);
    }

    @Override
    public final String toString() {
        String s = Arrays.toString(this.e);
        StringBuilder stringBuilder0 = new StringBuilder("EqualizerPreset(analyticsId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", presetType=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", name=");
        return d.n(stringBuilder0, this.d, ", values=", s, ")");
    }
}

