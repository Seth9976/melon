package Dd;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;

public final class l0 implements K4 {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final String d;
    public final int e;
    public final List f;
    public final String g;
    public final int h;
    public final String i;
    public final String j;
    public final int k;
    public final String l;

    public l0(boolean z, boolean z1, boolean z2, String s, int v, ArrayList arrayList0, String s1, int v1, String s2, String s3, int v2, String s4) {
        this.a = z;
        this.b = z1;
        this.c = z2;
        this.d = s;
        this.e = v;
        this.f = arrayList0;
        this.g = s1;
        this.h = v1;
        this.i = s2;
        this.j = s3;
        this.k = v2;
        this.l = s4;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l0)) {
            return false;
        }
        if(this.a != ((l0)object0).a) {
            return false;
        }
        if(this.b != ((l0)object0).b) {
            return false;
        }
        if(this.c != ((l0)object0).c) {
            return false;
        }
        if(!q.b(this.d, ((l0)object0).d)) {
            return false;
        }
        if(this.e != ((l0)object0).e) {
            return false;
        }
        if(!q.b(this.f, ((l0)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((l0)object0).g)) {
            return false;
        }
        if(this.h != ((l0)object0).h) {
            return false;
        }
        if(!q.b(this.i, ((l0)object0).i)) {
            return false;
        }
        if(!q.b(this.j, ((l0)object0).j)) {
            return false;
        }
        return this.k == ((l0)object0).k ? q.b(this.l, ((l0)object0).l) : false;
    }

    @Override
    public final int hashCode() {
        int v = d.b(this.e, x.b(d.e(d.e(Boolean.hashCode(this.a) * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F);
        return this.f == null ? this.l.hashCode() + d.b(this.k, x.b(x.b(d.b(this.h, x.b(v * 0x1F, 0x1F, this.g), 0x1F), 0x1F, this.i), 0x1F, this.j), 0x1F) : this.l.hashCode() + d.b(this.k, x.b(x.b(d.b(this.h, x.b((v + this.f.hashCode()) * 0x1F, 0x1F, this.g), 0x1F), 0x1F, this.i), 0x1F, this.j), 0x1F);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = Y.q("LikeItemUiState(likeSongExist=", ", likeAlbumExist=", this.a, ", likePlaylistExist=", this.b);
        Y.y(stringBuilder0, this.c, ", likeSongName=", this.d, ", likeSongCount=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", likeSongImgList=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", likeAlbumName=");
        d.t(stringBuilder0, this.g, ", likeAlbumCount=", this.h, ", likeAlbumImg=");
        d.u(stringBuilder0, this.i, ", likePlaylistName=", this.j, ", likePlaylistCount=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", likePlaylistImg=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

