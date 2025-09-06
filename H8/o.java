package H8;

import Cb.i;
import G4.a;
import G4.c;
import U4.F;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import we.k;

public final class o implements k {
    public final int a;
    public final int b;
    public final int c;

    public o(int v, int v1, int v2) {
        this.a = v2;
        this.b = v;
        this.c = v1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            q.g(((StringBuilder)object0), "$this$buildDebug");
            ((StringBuilder)object0).append("handleMediaPlayerException() Retry");
            i.a(((StringBuilder)object0), "maxRetryCount: " + this.b);
            i.a(((StringBuilder)object0), "retryCount: " + this.c);
            return H.a;
        }
        try(c c0 = ((a)object0).l0("SELECT * from local_playlists WHERE sort_order BETWEEN ? AND ?")) {
            c0.a(1, ((long)this.b));
            c0.a(2, ((long)this.c));
            int v = F.v(c0, "_id");
            int v1 = F.v(c0, "name");
            int v2 = F.v(c0, "date_added");
            int v3 = F.v(c0, "date_modified");
            int v4 = F.v(c0, "sort_order");
            int v5 = F.v(c0, "playlist_count");
            ArrayList arrayList0 = new ArrayList();
            while(true) {
                if(!c0.j0()) {
                    break;
                }
                arrayList0.add(new s(c0.getLong(v), c0.S(v1), c0.getLong(v2), c0.getLong(v3), ((int)c0.getLong(v4)), ((int)c0.getLong(v5))));
            }
        }
        return arrayList0;
    }
}

