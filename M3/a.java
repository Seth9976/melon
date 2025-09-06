package m3;

import android.net.Uri;
import android.os.SystemClock;
import androidx.media3.session.N;
import g3.t;
import i.n.i.b.a.s.e.Ca;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public final class a implements p {
    public final c a;

    public a(c c0) {
        this.a = c0;
    }

    @Override  // m3.p
    public final boolean a(Uri uri0, Ca ca0, boolean z) {
        N n0;
        c c0 = this.a;
        HashMap hashMap0 = c0.d;
        if(c0.l == null) {
            long v = SystemClock.elapsedRealtime();
            List list0 = c0.j.e;
            int v2 = 0;
            for(int v1 = 0; v1 < list0.size(); ++v1) {
                b b0 = (b)hashMap0.get(((j)list0.get(v1)).a);
                if(b0 != null && v < b0.h) {
                    ++v2;
                }
            }
            int v3 = c0.j.e.size();
            c0.c.getClass();
            IOException iOException0 = ca0.a;
            if(iOException0 instanceof t) {
                switch(((t)iOException0).d) {
                    case 403: 
                    case 404: 
                    case 410: 
                    case 0x1A0: 
                    case 500: 
                    case 503: {
                        n0 = v3 - v2 > 1 ? new N(2, 60000L) : null;
                        break;
                    }
                    default: {
                        n0 = null;
                    }
                }
            }
            else {
                n0 = null;
            }
            if(n0 != null && n0.a == 2) {
                b b1 = (b)hashMap0.get(uri0);
                if(b1 != null) {
                    b.b(b1, n0.b);
                }
            }
        }
        return false;
    }

    @Override  // m3.p
    public final void onPlaylistChanged() {
        this.a.e.remove(this);
    }
}

