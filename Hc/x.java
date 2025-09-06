package Hc;

import A7.d;
import androidx.appcompat.app.o;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;
import v9.c;

public final class x implements K4 {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final String e;
    public final c f;
    public final boolean g;

    public x(int v, boolean z, boolean z1, int v1, String s, c c0, boolean z2) {
        this.a = v;
        this.b = z;
        this.c = z1;
        this.d = v1;
        this.e = s;
        this.f = c0;
        this.g = z2;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof x)) {
            return false;
        }
        if(this.a != ((x)object0).a) {
            return false;
        }
        if(this.b != ((x)object0).b) {
            return false;
        }
        if(this.c != ((x)object0).c) {
            return false;
        }
        if(this.d != ((x)object0).d) {
            return false;
        }
        if(!q.b(this.e, ((x)object0).e)) {
            return false;
        }
        return this.f == ((x)object0).f ? this.g == ((x)object0).g : false;
    }

    @Override
    public final int hashCode() {
        int v = d.b(this.d, d.e(d.e(this.a * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F);
        return this.e == null ? Boolean.hashCode(this.g) + (this.f.hashCode() + v * 0x1F) * 0x1F : Boolean.hashCode(this.g) + (this.f.hashCode() + (v + this.e.hashCode()) * 0x1F) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("CommentCountUiState(count=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", isHot=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isNew=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", channelSeq=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", contentRefValue=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", theme=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", showTitle=");
        return o.s(stringBuilder0, this.g, ")");
    }
}

