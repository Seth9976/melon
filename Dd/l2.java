package Dd;

import com.melon.net.res.common.ArtistPlayListWrapperInfoBase;
import ie.H;
import w0.h;
import we.a;
import we.k;

public final class l2 implements a {
    public final int a;
    public final h b;
    public final k c;
    public final ArtistPlayListWrapperInfoBase d;
    public final int e;

    public l2(h h0, k k0, ArtistPlayListWrapperInfoBase artistPlayListWrapperInfoBase0, int v, int v1) {
        this.a = v1;
        this.b = h0;
        this.c = k0;
        this.d = artistPlayListWrapperInfoBase0;
        this.e = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        if(this.a != 0) {
            h.a(this.b);
            ArtistPlayListWrapperInfoBase artistPlayListWrapperInfoBase0 = this.d;
            boolean z = artistPlayListWrapperInfoBase0.getIsdj();
            String s = artistPlayListWrapperInfoBase0.plylstseq;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            String s2 = artistPlayListWrapperInfoBase0.plylsttitle == null ? "" : artistPlayListWrapperInfoBase0.plylsttitle;
            String s3 = artistPlayListWrapperInfoBase0.contsTypeCode;
            if(s3 != null) {
                s1 = s3;
            }
            a2 a20 = new a2(z, s, s2, s1, artistPlayListWrapperInfoBase0.statsElements, this.e);
            this.c.invoke(a20);
            return H.a;
        }
        h.a(this.b);
        ArtistPlayListWrapperInfoBase artistPlayListWrapperInfoBase1 = this.d;
        boolean z1 = artistPlayListWrapperInfoBase1.getIsdj();
        String s4 = artistPlayListWrapperInfoBase1.plylstseq;
        String s5 = "";
        if(s4 == null) {
            s4 = "";
        }
        String s6 = artistPlayListWrapperInfoBase1.plylsttitle == null ? "" : artistPlayListWrapperInfoBase1.plylsttitle;
        String s7 = artistPlayListWrapperInfoBase1.contsTypeCode;
        if(s7 != null) {
            s5 = s7;
        }
        Z1 z10 = new Z1(s4, s6, s5, this.e, z1);
        this.c.invoke(z10);
        return H.a;
    }
}

