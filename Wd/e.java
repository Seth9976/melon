package wd;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import kotlin.jvm.internal.q;

public final class e implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final boolean d;

    public e(String s, String s1, String s2, boolean z) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof e)) {
            return false;
        }
        if(!q.b(this.a, ((e)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((e)object0).b)) {
            return false;
        }
        return q.b(this.c, ((e)object0).c) ? this.d == ((e)object0).d : false;
    }

    @Override
    public final int hashCode() {
        int v = x.b(this.a.hashCode() * 0x1F, 0x1F, this.b);
        return this.c == null ? Boolean.hashCode(this.d) + v * 0x1F : Boolean.hashCode(this.d) + (v + this.c.hashCode()) * 0x1F;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("AddToPlaylistPopupItemUiState(playlistSeq=", this.a, ", title=", this.b, ", songCount=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", isLastItem=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

