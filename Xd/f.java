package xd;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class f implements K4 {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public f(int v, String s, String s1, String s2, boolean z, boolean z1, boolean z2) {
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = z;
        this.f = z1;
        this.g = z2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof f)) {
            return false;
        }
        if(this.a != ((f)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((f)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((f)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((f)object0).d)) {
            return false;
        }
        if(this.e != ((f)object0).e) {
            return false;
        }
        return this.f == ((f)object0).f ? this.g == ((f)object0).g : false;
    }

    @Override
    public final int hashCode() {
        int v = this.a;
        int v1 = 0;
        int v2 = this.b == null ? 0 : this.b.hashCode();
        int v3 = this.c == null ? 0 : this.c.hashCode();
        String s = this.d;
        if(s != null) {
            v1 = s.hashCode();
        }
        return Boolean.hashCode(this.g) + d.e(d.e((((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v1) * 0x1F, 0x1F, this.e), 0x1F, this.f);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = x.o(this.a, "ArtistMultiPopupItemUiState(contextMenuType=", ", artistId=", this.b, ", artistName=");
        d.u(stringBuilder0, this.c, ", artistImgUrl=", this.d, ", isFan=");
        x.y(stringBuilder0, this.e, ", isEnable=", this.f, ", isShowFan=");
        return o.s(stringBuilder0, this.g, ")");
    }
}

