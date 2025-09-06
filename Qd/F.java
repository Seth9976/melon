package qd;

import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import com.iloen.melon.lyric.LyricsInfo;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.r;
import we.p;

public final class f extends r implements p {
    public final List f;
    public final boolean g;
    public final long h;
    public final Integer i;

    public f(List list0, boolean z, long v, Integer integer0) {
        this.f = list0;
        this.g = z;
        this.h = v;
        this.i = integer0;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            LyricsInfo lyricsInfo0 = (LyricsInfo)this.f.get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(-801027292);
            h.b(lyricsInfo0.b, this.i != null && v == ((int)this.i), this.g || 1L <= this.h && this.h < lyricsInfo0.a, ((androidx.compose.runtime.p)(((l)object2))), 0, 0);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

