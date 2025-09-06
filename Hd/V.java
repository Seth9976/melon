package hd;

import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.melon.net.res.MusicDnaMainRes.RESPONSE.MYDNA.CARD;
import we.k;
import we.n;

public final class v implements n {
    public final CARD a;
    public final int b;
    public final k c;

    public v(CARD musicDnaMainRes$RESPONSE$MYDNA$CARD0, int v, k k0) {
        this.a = musicDnaMainRes$RESPONSE$MYDNA$CARD0;
        this.b = v;
        this.c = k0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = ((Number)object1).intValue();
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            H.h(this.a, this.b, 0.0f, this.c, null, ((p)(((l)object0))), 0x6180);
            return ie.H.a;
        }
        ((p)(((l)object0))).T();
        return ie.H.a;
    }
}

