package Cc;

import A0.d;
import A0.f;
import Cb.i;
import G4.a;
import G4.c;
import H8.t;
import P0.K;
import Pb.b;
import U4.F;
import X0.u;
import X0.x;
import android.os.Bundle;
import androidx.media3.session.v;
import ie.H;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import we.k;

public final class h0 implements k {
    public final int a;
    public final long b;

    public h0(long v, int v1) {
        this.a = v1;
        this.b = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        long v = this.b;
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), Cb.k.e(String.valueOf(v)));
                return h0;
            }
            case 1: {
                try(c c0 = ((a)object0).l0("DELETE FROM dev_log_history WHERE time_ms < ?")) {
                    c0.a(1, v);
                    c0.j0();
                }
                return null;
            }
            case 2: {
                try(c c1 = ((a)object0).l0("DELETE FROM log_history WHERE time_ms < ?")) {
                    c1.a(1, v);
                    c1.j0();
                }
                return null;
            }
            case 3: {
                try(c c2 = ((a)object0).l0("SELECT * FROM local_playlists_map WHERE playlist_id == ? ORDER BY play_order DESC")) {
                    c2.a(1, v);
                    int v2 = F.v(c2, "_id");
                    int v3 = F.v(c2, "audio_id");
                    int v4 = F.v(c2, "mime_type");
                    int v5 = F.v(c2, "data");
                    int v6 = F.v(c2, "uri");
                    int v7 = F.v(c2, "displayName");
                    int v8 = F.v(c2, "title");
                    int v9 = F.v(c2, "album_id");
                    int v10 = F.v(c2, "album");
                    int v11 = F.v(c2, "artist");
                    int v12 = F.v(c2, "artist_id");
                    int v13 = F.v(c2, "playlist_id");
                    int v14 = F.v(c2, "play_order");
                    int v15 = F.v(c2, "duration");
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c2.j0()) {
                            break;
                        }
                        arrayList0.add(new t(c2.getLong(v2), c2.getLong(v3), c2.S(v4), c2.S(v5), c2.S(v6), c2.S(v7), c2.S(v8), c2.S(v9), c2.S(v10), c2.S(v11), c2.S(v12), c2.getLong(v13), ((int)c2.getLong(v14)), ((int)c2.getLong(v15))));
                    }
                }
                return arrayList0;
            }
            case 4: {
                try(c c3 = ((a)object0).l0("DELETE FROM local_playlists_map WHERE playlist_id = ?")) {
                    c3.a(1, v);
                    c3.j0();
                }
                return null;
            }
            case 5: {
                try(c c4 = ((a)object0).l0("DELETE FROM local_playlists WHERE _id = ?")) {
                    c4.a(1, v);
                    c4.j0();
                }
                return null;
            }
            case 6: {
                try(c c5 = ((a)object0).l0("SELECT * FROM local_playlists_map WHERE playlist_id == ? ORDER BY play_order ASC")) {
                    c5.a(1, v);
                    int v16 = F.v(c5, "_id");
                    int v17 = F.v(c5, "audio_id");
                    int v18 = F.v(c5, "mime_type");
                    int v19 = F.v(c5, "data");
                    int v20 = F.v(c5, "uri");
                    int v21 = F.v(c5, "displayName");
                    int v22 = F.v(c5, "title");
                    int v23 = F.v(c5, "album_id");
                    int v24 = F.v(c5, "album");
                    int v25 = F.v(c5, "artist");
                    int v26 = F.v(c5, "artist_id");
                    int v27 = F.v(c5, "playlist_id");
                    int v28 = F.v(c5, "play_order");
                    int v29 = F.v(c5, "duration");
                    ArrayList arrayList1 = new ArrayList();
                    while(true) {
                        if(!c5.j0()) {
                            break;
                        }
                        arrayList1.add(new t(c5.getLong(v16), c5.getLong(v17), c5.S(v18), c5.S(v19), c5.S(v20), c5.S(v21), c5.S(v22), c5.S(v23), c5.S(v24), c5.S(v25), c5.S(v26), c5.getLong(v27), ((int)c5.getLong(v28)), ((int)c5.getLong(v29))));
                    }
                }
                return arrayList1;
            }
            case 7: {
                try(c c6 = ((a)object0).l0("SELECT name from local_playlists WHERE _id = ?")) {
                    c6.a(1, v);
                    return c6.j0() && !c6.isNull(0) ? c6.S(0) : null;
                }
            }
            case 8: {
                try(c c7 = ((a)object0).l0("SELECT play_order FROM local_playlists_map WHERE playlist_id == ? ORDER BY play_order DESC")) {
                    c7.a(1, v);
                    ArrayList arrayList2 = new ArrayList();
                    while(true) {
                        if(!c7.j0()) {
                            break;
                        }
                        arrayList2.add(((int)c7.getLong(0)));
                    }
                }
                return arrayList2;
            }
            case 9: {
                q.g(((f)object0), "$this$Canvas");
                f.Q(((f)object0), this.b, 0.0f, 0L, 0x7E);
                return h0;
            }
            case 10: {
                q.g(((f)object0), "$this$Canvas");
                float f = Float.intBitsToFloat(((int)(((f)object0).c() >> 0x20)));
                float f1 = Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL)));
                f.Q(((f)object0), this.b, 0.0f, ((long)Float.floatToRawIntBits(f / 2.0f)) << 0x20 | ((long)Float.floatToRawIntBits(f1 / 2.0f)) & 0xFFFFFFFFL, 0x7A);
                return h0;
            }
            case 11: {
                q.g(((v)object0), "$this$executeAwaitPrepareWithResult");
                Bundle bundle0 = new Bundle();
                bundle0.putLong("position", v);
                return F.U(((v)object0), Pb.c.b, bundle0);
            }
            case 12: {
                q.g(((v)object0), "$this$executeAwaitPrepareWithResult");
                Bundle bundle1 = new Bundle();
                bundle1.putLong("position", v);
                return F.U(((v)object0), b.b, bundle1);
            }
            case 13: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("setRangeRepeatA()");
                i.a(((StringBuilder)object0), "positionMs: " + v);
                return h0;
            }
            case 14: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("setRangeRepeatB()");
                i.a(((StringBuilder)object0), "positionMs: " + v);
                return h0;
            }
            case 15: {
                q.g(((d)object0), "$this$drawWithContent");
                ((K)(((d)object0))).a();
                float f2 = ((K)(((d)object0))).Y(0.5f);
                float f3 = Float.intBitsToFloat(((int)(((K)(((d)object0))).a.c() & 0xFFFFFFFFL)));
                float f4 = ((K)(((d)object0))).Y(1.0f);
                float f5 = Float.intBitsToFloat(((int)(((K)(((d)object0))).a.c() >> 0x20)));
                f.k0(((d)object0), this.b, ((long)Float.floatToRawIntBits(f3 - f4)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f5)) << 0x20 | ((long)Float.floatToRawIntBits(f3 - f4)) & 0xFFFFFFFFL, f2, 0, null, 0x1F0);
                return h0;
            }
            case 16: {
                q.g(((f)object0), "$this$drawBehind");
                float f6 = ((f)object0).Y(0.5f);
                float f7 = Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL)));
                float f8 = Float.intBitsToFloat(((int)(((f)object0).c() >> 0x20)));
                float f9 = Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL)));
                f.k0(((f)object0), this.b, ((long)Float.floatToRawIntBits(f7)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f8)) << 0x20 | ((long)Float.floatToRawIntBits(f9)) & 0xFFFFFFFFL, f6, 0, null, 0x1F0);
                return h0;
            }
            case 17: {
                q.g(((d)object0), "$this$drawWithContent");
                ((K)(((d)object0))).a();
                f.d0(((d)object0), this.b, 0L, 0.0f, null, 0, 0x7E);
                return h0;
            }
            case 18: {
                q.g(((d)object0), "$this$drawWithContent");
                ((K)(((d)object0))).a();
                float f10 = Float.intBitsToFloat(((int)(((K)(((d)object0))).a.c() >> 0x20)));
                float f11 = Float.intBitsToFloat(((int)(((K)(((d)object0))).a.c() & 0xFFFFFFFFL)));
                float f12 = ((K)(((d)object0))).Y(4.0f);
                float f13 = ((K)(((d)object0))).Y(4.0f);
                f.V(((d)object0), this.b, ((long)Float.floatToRawIntBits(f10)) << 0x20 | ((long)Float.floatToRawIntBits(f11)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f12)) << 0x20 | ((long)Float.floatToRawIntBits(f13)) & 0xFFFFFFFFL, 0xF2);
                return h0;
            }
            case 19: {
                q.g(((d)object0), "$this$drawWithContent");
                ((K)(((d)object0))).a();
                float f14 = Float.intBitsToFloat(((int)(((K)(((d)object0))).a.c() >> 0x20)));
                float f15 = Float.intBitsToFloat(((int)(((K)(((d)object0))).a.c() & 0xFFFFFFFFL)));
                f.V(((d)object0), this.b, ((long)Float.floatToRawIntBits(f14)) << 0x20 | ((long)Float.floatToRawIntBits(f15)) & 0xFFFFFFFFL, 0L, 0xFA);
                return h0;
            }
            default: {
                q.g(((d)object0), "$this$drawWithContent");
                long v1 = ((K)(((d)object0))).a.c();
                f.d0(((d)object0), this.b, v1, 0.0f, null, 0, 0x7A);
                ((K)(((d)object0))).a();
                return h0;
            }
        }
    }
}

