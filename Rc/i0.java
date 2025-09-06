package Rc;

import android.content.Context;
import com.iloen.melon.net.v5x.response.CastDetailRes.CAST;
import com.iloen.melon.net.v5x.response.CreatorInfoBase;
import com.melon.playlist.station.CastData;
import ie.H;
import kotlin.coroutines.Continuation;
import oc.Q;
import oe.i;
import tc.F;
import we.n;

public final class i0 extends i implements n {
    public Object r;
    public final t0 w;

    public i0(t0 t00, Continuation continuation0) {
        this.w = t00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new i0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((i0)this.create(((Q)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s1;
        String s;
        Q q0 = (Q)this.r;
        d5.n.D(object0);
        t0 t00 = this.w;
        t00.j = q0;
        if(q0 instanceof F) {
            CastData castData0 = ((F)q0).c;
            CreatorInfoBase creatorInfoBase0 = null;
            if(castData0 == null) {
                s = null;
            }
            else {
                CAST castDetailRes$CAST0 = castData0.b;
                s = castDetailRes$CAST0 == null ? null : castDetailRes$CAST0.castImgUrl;
            }
            t00.o = s;
            if(castData0 == null) {
                s1 = null;
            }
            else {
                CAST castDetailRes$CAST1 = castData0.b;
                s1 = castDetailRes$CAST1 == null ? null : castDetailRes$CAST1.castTitle;
            }
            t00.p = s1;
            Context context0 = t00.a;
            if(castData0 != null) {
                CAST castDetailRes$CAST2 = castData0.b;
                if(castDetailRes$CAST2 != null) {
                    creatorInfoBase0 = castDetailRes$CAST2.creator;
                }
            }
            t00.q = CreatorInfoBase.getCreatorNames(context0, creatorInfoBase0);
        }
        t0.c(t00, "currentPlaylist_collectLatest");
        return H.a;
    }
}

