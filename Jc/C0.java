package Jc;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;
import we.k;

public final class c0 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final k g;

    public c0(String s, String s1, String s2, String s3, String s4, String s5, k k0) {
        q.g(s3, "artistNames");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = s5;
        this.g = k0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof c0)) {
            return false;
        }
        if(!q.b(this.a, ((c0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((c0)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((c0)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((c0)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((c0)object0).e)) {
            return false;
        }
        return q.b(this.f, ((c0)object0).f) ? q.b(this.g, ((c0)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f);
        return this.g == null ? v : v + this.g.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("VideoItemUiState(mv169Img=", this.a, ", mvId=", this.b, ", mvName=");
        d.u(stringBuilder0, this.c, ", artistNames=", this.d, ", playTime=");
        d.u(stringBuilder0, this.e, ", adultGrade=", this.f, ", clickItem=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

