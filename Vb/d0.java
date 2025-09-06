package Vb;

import com.iloen.melon.playback.playlist.PlaylistId;
import ie.H;
import kc.e;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import ne.a;
import oc.Q;
import oe.c;
import oe.i;

public final class d0 implements e {
    public final o0 a;

    public d0(o0 o00) {
        this.a = o00;
    }

    public final Object b(Q q0, long v, boolean z, i i0) {
        if(z) {
            Object object0 = o0.Q0(this.a, q0, v, i0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return H.a;
    }

    public final Object c(PlaylistId playlistId0, Q q0, long v, c c0) {
        o0 o00 = this.a;
        Job job0 = o00.Z;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        Object object0 = o0.S0(o00, playlistId0, q0, v, c0);
        return object0 == a.a ? object0 : H.a;
    }
}

