package cd;

import Cc.q0;
import P.k;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.l;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.ALBUM;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import we.p;

public final class h1 extends r implements p {
    public final int f;
    public final List g;
    public final b0 h;

    public h1(List list0, b0 b00, int v) {
        this.f = v;
        this.g = list0;
        this.h = b00;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        if(this.f != 0) {
            int v = ((Number)object1).intValue();
            int v1 = ((Number)object3).intValue();
            int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((k)object0)) ? 4 : 2) | v1 : v1;
            if((v1 & 0x30) == 0) {
                v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
            }
            if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
                q1 q10 = (q1)this.g.get(v);
                ((androidx.compose.runtime.p)(((l)object2))).a0(0xF771C190);
                ALBUM mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM0 = q10.a;
                String s = mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM0.albumImg;
                String s1 = "";
                if(s == null) {
                    s = "";
                }
                String s2 = mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM0.albumName == null ? "" : mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM0.albumName;
                String s3 = ProtocolUtils.getArtistNames(mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM0.artistList);
                if(s3 != null) {
                    s1 = s3;
                }
                int v3 = q10.a.isMyAlbum() ? 0x7F08057E : 0;  // drawable:ic_music_fan
                boolean z = ((androidx.compose.runtime.p)(((l)object2))).i(q10);
                int v4 = v2 & 0x70 ^ 0x30;
                boolean z1 = v4 > 0x20 && ((androidx.compose.runtime.p)(((l)object2))).e(v) || (v2 & 0x30) == 0x20;
                z1 z10 = ((androidx.compose.runtime.p)(((l)object2))).N();
                b0 b00 = this.h;
                V v5 = androidx.compose.runtime.k.a;
                if(z || z1 || z10 == v5) {
                    z10 = new z1(q10, v, b00, 0);
                    ((androidx.compose.runtime.p)(((l)object2))).l0(z10);
                }
                boolean z2 = ((androidx.compose.runtime.p)(((l)object2))).i(q10);
                boolean z3 = v4 > 0x20 && ((androidx.compose.runtime.p)(((l)object2))).e(v) || (v2 & 0x30) == 0x20;
                z1 z11 = ((androidx.compose.runtime.p)(((l)object2))).N();
                if(z2 || z3 || z11 == v5) {
                    z11 = new z1(q10, v, b00, 1);
                    ((androidx.compose.runtime.p)(((l)object2))).l0(z11);
                }
                boolean z4 = ((androidx.compose.runtime.p)(((l)object2))).i(q10);
                boolean z5 = v4 > 0x20 && ((androidx.compose.runtime.p)(((l)object2))).e(v) || (v2 & 0x30) == 0x20;
                z1 z12 = ((androidx.compose.runtime.p)(((l)object2))).N();
                if(z5 || z4 || z12 == v5) {
                    z12 = new z1(q10, v, b00, 2);
                    ((androidx.compose.runtime.p)(((l)object2))).l0(z12);
                }
                q0.e(s, s2, s1, v3, z10, z11, z12, ((androidx.compose.runtime.p)(((l)object2))), 0);
                ((androidx.compose.runtime.p)(((l)object2))).p(false);
                return H.a;
            }
            ((androidx.compose.runtime.p)(((l)object2))).T();
            return H.a;
        }
        int v6 = ((Number)object1).intValue();
        int v7 = ((Number)object3).intValue();
        int v8 = (v7 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v7 : v7;
        if((v7 & 0x30) == 0) {
            v8 |= (((androidx.compose.runtime.p)(((l)object2))).e(v6) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v8 & 1, (v8 & 0x93) != 0x92)) {
            b1 b10 = (b1)this.g.get(v6);
            ((androidx.compose.runtime.p)(((l)object2))).a0(0xC7413F16);
            i1.a(((String)this.h.getValue()), b10, ((androidx.compose.runtime.p)(((l)object2))), 0);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

