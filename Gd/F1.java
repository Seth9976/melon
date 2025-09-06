package gd;

import A7.d;
import androidx.appcompat.app.o;
import com.melon.ui.K4;
import k8.Y;
import kotlin.jvm.internal.q;

public final class f1 implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;
    public final boolean e;

    public f1(String s, String s1, boolean z, String s2, boolean z1) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = z;
        this.e = z1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f1)) {
            return false;
        }
        if(!q.b(this.a, ((f1)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((f1)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((f1)object0).c)) {
            return false;
        }
        return this.d == ((f1)object0).d ? this.e == ((f1)object0).e : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        int v2 = this.b == null ? 0 : this.b.hashCode();
        String s = this.c;
        if(s != null) {
            v = s.hashCode();
        }
        return Boolean.hashCode(this.e) + d.e(((v1 * 0x1F + v2) * 0x1F + v) * 0x1F, 0x1F, this.d);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MelonDjBrandRecommendArtistItemUiState(artistId=", this.a, ", artistName=", this.b, ", artistImgUrl=");
        Y.x(stringBuilder0, this.c, ", showFan=", this.d, ", isFan=");
        return o.s(stringBuilder0, this.e, ")");
    }
}

