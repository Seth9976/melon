package H8;

import Cb.i;
import G4.a;
import G4.c;
import U4.F;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import we.k;

public final class p implements k {
    public final int a;
    public final int b;
    public final long c;
    public final int d;

    public p(int v, int v1, int v2, long v3) {
        this.a = v2;
        this.b = v;
        this.c = v3;
        this.d = v1;
        super();
    }

    public p(int v, int v1, long v2) {
        this.a = 0;
        super();
        this.c = v2;
        this.b = v;
        this.d = v1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                try(c c0 = ((a)object0).l0("SELECT * from local_playlists_map WHERE playlist_id == ? AND play_order BETWEEN ? AND ?")) {
                    c0.a(1, this.c);
                    c0.a(2, ((long)this.b));
                    c0.a(3, ((long)this.d));
                    int v = F.v(c0, "_id");
                    int v1 = F.v(c0, "audio_id");
                    int v2 = F.v(c0, "mime_type");
                    int v3 = F.v(c0, "data");
                    int v4 = F.v(c0, "uri");
                    int v5 = F.v(c0, "displayName");
                    int v6 = F.v(c0, "title");
                    int v7 = F.v(c0, "album_id");
                    int v8 = F.v(c0, "album");
                    int v9 = F.v(c0, "artist");
                    int v10 = F.v(c0, "artist_id");
                    int v11 = F.v(c0, "playlist_id");
                    int v12 = F.v(c0, "play_order");
                    int v13 = F.v(c0, "duration");
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c0.j0()) {
                            break;
                        }
                        arrayList0.add(new t(c0.getLong(v), c0.getLong(v1), c0.S(v2), c0.S(v3), c0.S(v4), c0.S(v5), c0.S(v6), c0.S(v7), c0.S(v8), c0.S(v9), c0.S(v10), c0.getLong(v11), ((int)c0.getLong(v12)), ((int)c0.getLong(v13))));
                    }
                }
                return arrayList0;
            }
            case 1: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("handleSeek()");
                i.a(((StringBuilder)object0), "mediaItemIndex: " + this.b);
                i.a(((StringBuilder)object0), "positionMs: " + this.c);
                i.a(((StringBuilder)object0), "seekCommand: " + F.Z(this.d));
                return H.a;
            }
            case 2: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("handleSeekToMediaItem()");
                i.a(((StringBuilder)object0), "mediaItemIndex: " + this.b);
                i.a(((StringBuilder)object0), "positionMs: " + this.c);
                i.a(((StringBuilder)object0), "seekCommand: " + F.Z(this.d));
                return H.a;
            }
            case 3: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("handleSeekToNextMediaItem()");
                i.a(((StringBuilder)object0), "mediaItemIndex: " + this.b);
                i.a(((StringBuilder)object0), "positionMs: " + this.c);
                i.a(((StringBuilder)object0), "seekCommand: " + F.Z(this.d));
                return H.a;
            }
            case 4: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("handleSeekToPreviousMediaItem()");
                i.a(((StringBuilder)object0), "mediaItemIndex: " + this.b);
                i.a(((StringBuilder)object0), "positionMs: " + this.c);
                i.a(((StringBuilder)object0), "seekCommand: " + F.Z(this.d));
                return H.a;
            }
            default: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("handleSeekInCurrentMediaItem()");
                i.a(((StringBuilder)object0), "mediaItemIndex: " + this.b);
                i.a(((StringBuilder)object0), "positionMs: " + this.c);
                i.a(((StringBuilder)object0), "seekCommand: " + F.Z(this.d));
                return H.a;
            }
        }
    }
}

