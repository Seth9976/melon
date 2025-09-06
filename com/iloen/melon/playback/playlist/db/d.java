package com.iloen.melon.playback.playlist.db;

import G4.a;
import G4.c;
import U4.F;
import X0.u;
import X0.x;
import com.iloen.melon.premium.PremiumContentsEntity;
import ie.H;
import java.util.ArrayList;
import jd.y2;
import kotlin.jvm.internal.q;
import q8.h;
import s8.b;
import we.k;

public final class d implements k {
    public final int a;
    public final String b;

    public d(String s, int v) {
        this.a = v;
        this.b = s;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        Boolean boolean0;
        boolean z;
        Integer integer0;
        int v15;
        int v14;
        String s12;
        String s11;
        String s10;
        H h0 = H.a;
        String s = this.b;
        switch(this.a) {
            case 0: {
                return PlaylistDao_Impl.z(s, ((a)object0));
            }
            case 1: {
                return PlaylistDao_Impl.k(s, ((a)object0));
            }
            case 2: {
                return PlaylistDao_Impl.lambda$deleteTrackIdEdu$47(s, ((a)object0));
            }
            case 3: {
                return PlaylistDao_Impl.p(s, ((a)object0));
            }
            case 4: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), s);
                u.k(((x)object0), 0);
                return h0;
            }
            case 5: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), s);
                u.k(((x)object0), 1);
                return h0;
            }
            case 6: {
                q.g(((q8.a)object0), "$this$click");
                ((q8.a)object0).g = s + "";
                return h0;
            }
            case 7: {
                try(c c0 = ((a)object0).l0("delete from local_playback_log where timestamp < ?")) {
                    c0.e(1, s);
                    c0.j0();
                    return Q1.c.F(((a)object0));
                }
            }
            case 8: {
                try(c c1 = ((a)object0).l0("select count(*) from premium_off_play_log where memberkey = ?")) {
                    c1.e(1, s);
                    return c1.j0() ? ((int)c1.getLong(0)) : 0;
                }
            }
            case 9: {
                try(c c2 = ((a)object0).l0("delete from premium_off_play_log where timestamp < ?")) {
                    c2.e(1, s);
                    c2.j0();
                    return Q1.c.F(((a)object0));
                }
            }
            case 10: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.h(((x)object0), s);
                return h0;
            }
            case 11: {
                q.g(((h)object0), "$this$track");
                ((h)object0).a = s;
                return h0;
            }
            case 12: {
                q.g(((h)object0), "$this$track");
                ((h)object0).a = s;
                return h0;
            }
            case 13: {
                u.h(((x)object0), s);
                u.k(((x)object0), 5);
                return h0;
            }
            case 14: {
                return !(((y2)object0) instanceof jd.d) || !q.b(((jd.d)(((y2)object0))).b, s) ? false : true;
            }
            case 15: {
                q.g(((h)object0), "$this$track");
                ((h)object0).a = s;
                return h0;
            }
            case 16: {
                try(c c3 = ((a)object0).l0("select * from premium_contents where image_path = ?")) {
                    c3.e(1, s);
                    int v = F.v(c3, "_id");
                    int v1 = F.v(c3, "cid");
                    int v2 = F.v(c3, "ctype");
                    int v3 = F.v(c3, "meta_type");
                    int v4 = F.v(c3, "bitrate");
                    int v5 = F.v(c3, "content_type");
                    int v6 = F.v(c3, "secret");
                    int v7 = F.v(c3, "file_update");
                    int v8 = F.v(c3, "file_size");
                    int v9 = F.v(c3, "cache_path");
                    int v10 = F.v(c3, "thumbnail_path");
                    int v11 = F.v(c3, "image_path");
                    int v12 = F.v(c3, "image_etag");
                    int v13 = F.v(c3, "is_free");
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c3.j0()) {
                            break;
                        }
                        PremiumContentsEntity premiumContentsEntity0 = new PremiumContentsEntity();
                        premiumContentsEntity0.a = (int)c3.getLong(v);
                        String s1 = c3.S(v1);
                        q.g(s1, "<set-?>");
                        premiumContentsEntity0.b = s1;
                        String s2 = c3.S(v2);
                        q.g(s2, "<set-?>");
                        premiumContentsEntity0.c = s2;
                        String s3 = c3.S(v3);
                        q.g(s3, "<set-?>");
                        premiumContentsEntity0.d = s3;
                        String s4 = c3.S(v4);
                        q.g(s4, "<set-?>");
                        premiumContentsEntity0.e = s4;
                        String s5 = c3.S(v5);
                        q.g(s5, "<set-?>");
                        premiumContentsEntity0.f = s5;
                        String s6 = c3.S(v6);
                        q.g(s6, "<set-?>");
                        premiumContentsEntity0.g = s6;
                        String s7 = c3.S(v7);
                        q.g(s7, "<set-?>");
                        premiumContentsEntity0.h = s7;
                        String s8 = c3.S(v8);
                        q.g(s8, "<set-?>");
                        premiumContentsEntity0.i = s8;
                        String s9 = c3.S(v9);
                        q.g(s9, "<set-?>");
                        premiumContentsEntity0.j = s9;
                        s10 = c3.isNull(v10) ? null : c3.S(v10);
                        premiumContentsEntity0.k = s10;
                        s11 = c3.isNull(v11) ? null : c3.S(v11);
                        premiumContentsEntity0.l = s11;
                        s12 = c3.isNull(v12) ? null : c3.S(v12);
                        premiumContentsEntity0.m = s12;
                        if(c3.isNull(v13)) {
                            v14 = v10;
                            v15 = v;
                            integer0 = null;
                        }
                        else {
                            v14 = v10;
                            v15 = v;
                            integer0 = (int)c3.getLong(v13);
                        }
                        if(integer0 == null) {
                            boolean0 = null;
                        }
                        else {
                            z = ((int)integer0) == 0 ? false : true;
                            boolean0 = Boolean.valueOf(z);
                        }
                        premiumContentsEntity0.n = boolean0;
                        arrayList0.add(premiumContentsEntity0);
                        v = v15;
                        v10 = v14;
                    }
                }
                return arrayList0;
            }
            case 17: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                u.h(((x)object0), s);
                u.k(((x)object0), 0);
                return h0;
            }
            case 18: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), s);
                return h0;
            }
            case 19: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                u.h(((x)object0), s);
                return h0;
            }
            case 20: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), s);
                return h0;
            }
            case 21: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                u.h(((x)object0), s);
                return h0;
            }
            case 22: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                u.h(((x)object0), s);
                return h0;
            }
            case 23: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                u.h(((x)object0), s);
                return h0;
            }
            case 24: {
                try(c c4 = ((a)object0).l0("DELETE from response_cache WHERE ? = cacheKey")) {
                    c4.e(1, s);
                    c4.j0();
                }
                return null;
            }
            case 25: {
                try(c c5 = ((a)object0).l0("SELECT * from response_cache WHERE ? = cacheKey")) {
                    c5.e(1, s);
                    int v16 = F.v(c5, "cacheKey");
                    int v17 = F.v(c5, "apiResource");
                    int v18 = F.v(c5, "modified_at");
                    int v19 = F.v(c5, "startIndex");
                    if(c5.j0()) {
                        String s13 = c5.S(v16);
                        String s14 = c5.S(v17);
                        long v20 = c5.getLong(v18);
                        return new b(((int)c5.getLong(v19)), s13, s14, v20);
                    }
                }
                return null;
            }
            case 26: {
                q.g(((x)object0), "$this$semantics");
                if(s == null) {
                    s = "";
                }
                u.h(((x)object0), s);
                return h0;
            }
            case 27: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.h(((x)object0), s);
                u.c(((x)object0));
                return h0;
            }
            case 28: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.h(((x)object0), s);
                u.c(((x)object0));
                return h0;
            }
            default: {
                q.g(((x)object0), "$this$semantics");
                u.h(((x)object0), s);
                return h0;
            }
        }
    }
}

