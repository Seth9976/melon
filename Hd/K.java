package hd;

import androidx.compose.runtime.l;
import com.iloen.melon.popup.CommonFilterPopupKt;
import com.melon.net.res.MusicDnaMainMonthlyLogRes.RESPONSE.LIKETOPINFO;
import java.io.Serializable;
import r0.q;
import we.a;
import we.n;

public final class k implements n {
    public final int a;
    public final Serializable b;
    public final boolean c;
    public final boolean d;
    public final Object e;
    public final a f;
    public final int g;
    public final int h;

    public k(LIKETOPINFO musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO0, boolean z, boolean z1, we.k k0, a a0, int v, int v1, int v2) {
        this.a = v2;
        this.b = musicDnaMainMonthlyLogRes$RESPONSE$LIKETOPINFO0;
        this.c = z;
        this.d = z1;
        this.e = k0;
        this.f = a0;
        this.g = v;
        this.h = v1;
        super();
    }

    public k(String s, boolean z, boolean z1, a a0, q q0, int v, int v1) {
        this.a = 2;
        super();
        this.b = s;
        this.c = z;
        this.d = z1;
        this.f = a0;
        this.e = q0;
        this.g = v;
        this.h = v1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        switch(this.a) {
            case 0: {
                ((Integer)object1).getClass();
                H.e(((LIKETOPINFO)this.b), this.c, this.d, ((we.k)this.e), this.f, ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)), this.h);
                return ie.H.a;
            }
            case 1: {
                ((Integer)object1).getClass();
                H.e(((LIKETOPINFO)this.b), this.c, this.d, ((we.k)this.e), this.f, ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)), this.h);
                return ie.H.a;
            }
            default: {
                ((Integer)object1).intValue();
                CommonFilterPopupKt.CommonFilterListItem(((String)this.b), this.c, this.d, this.f, ((q)this.e), ((l)object0), (this.g | 1) & -920350135 | ((0x24924924 & (this.g | 1)) >> 1 | 306783378 & (this.g | 1)) | (306783378 & (this.g | 1)) << 1 & (0x24924924 & (this.g | 1)), this.h);
                return ie.H.a;
            }
        }
    }
}

