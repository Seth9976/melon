package gd;

import A7.d;
import androidx.appcompat.app.o;
import com.melon.ui.K4;
import java.util.List;
import kotlin.jvm.internal.q;

public final class j5 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final List f;
    public final boolean g;

    public j5(String s, String s1, String s2, String s3, String s4, List list0, boolean z) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = s4;
        this.f = list0;
        this.g = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof j5)) {
            return false;
        }
        if(!q.b(this.a, ((j5)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((j5)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((j5)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((j5)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((j5)object0).e)) {
            return false;
        }
        return q.b(this.f, ((j5)object0).f) ? this.g == ((j5)object0).g : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        int v4 = this.d == null ? 0 : this.d.hashCode();
        String s = this.e;
        if(s != null) {
            v = s.hashCode();
        }
        return Boolean.hashCode(this.g) + d.d(((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v) * 0x1F, 0x1F, this.f);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("Success(failContent=", this.a, ", thumbImg=", this.b, ", playlistSeq=");
        d.u(stringBuilder0, this.c, ", playlistTitle=", this.d, ", memberNickName=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", tagList=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", isChecked=");
        return o.s(stringBuilder0, this.g, ")");
    }
}

