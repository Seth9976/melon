package androidx.media3.exoplayer;

import U4.x;
import android.text.TextUtils;
import androidx.media3.common.b;

public final class g {
    public final String a;
    public final b b;
    public final b c;
    public final int d;
    public final int e;

    public g(String s, b b0, b b1, int v, int v1) {
        e3.b.c(v == 0 || v1 == 0);
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException();
        }
        this.a = s;
        b0.getClass();
        this.b = b0;
        b1.getClass();
        this.c = b1;
        this.d = v;
        this.e = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return g.class == class0 && this.d == ((g)object0).d && this.e == ((g)object0).e && this.a.equals(((g)object0).a) && this.b.equals(((g)object0).b) && this.c.equals(((g)object0).c);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + x.b(((this.d + 0x20F) * 0x1F + this.e) * 0x1F, 0x1F, this.a)) * 0x1F;
    }
}

