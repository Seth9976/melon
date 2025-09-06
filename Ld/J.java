package ld;

import G4.a;
import G4.c;
import Qb.z;
import U4.F;
import X0.u;
import X0.x;
import com.iloen.melon.net.mcp.TrackBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.premium.PremiumContentsEntity;
import com.iloen.melon.premium.PremiumPlaylistEntity;
import com.iloen.melon.utils.Navigator;
import ie.H;
import ie.m;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;
import we.k;
import xd.g;
import xd.h;

public final class j implements k {
    public final int a;

    public j(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        Boolean boolean0;
        boolean z2;
        Integer integer0;
        int v23;
        int v22;
        String s14;
        String s13;
        String s12;
        boolean z1;
        boolean z;
        H h0 = H.a;
        switch(this.a) {
            case 0: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 1: {
                q.g(((oc.H)object0), "it");
                Navigator.openNowPlayer$default(Navigator.INSTANCE, 0, 1, null);
                return h0;
            }
            case 2: {
                q.g(((oc.H)object0), "it");
                Navigator.INSTANCE.openNowPlayList();
                return h0;
            }
            case 3: {
                q.g(((Playable)object0), "it");
                q.f("", "getSongidString(...)");
                return "";
            }
            case 4: {
                q.g(((Playable)object0), "it");
                q.f("", "getSongidString(...)");
                return "";
            }
            case 5: {
                q.g(((Playable)object0), "it");
                q.f("", "getSongidString(...)");
                return "";
            }
            case 6: {
                q.g(((z)object0), "$this$request");
                ((z)object0).r();
                return h0;
            }
            case 7: {
                try(c c0 = ((a)object0).l0("select * from premium_playlist where playlist_type != -1 ")) {
                    int v = F.v(c0, "_id");
                    int v1 = F.v(c0, "seq");
                    int v2 = F.v(c0, "response_type");
                    int v3 = F.v(c0, "playlist_type");
                    int v4 = F.v(c0, "is_dj");
                    int v5 = F.v(c0, "offline_mode");
                    int v6 = F.v(c0, "response_message");
                    int v7 = F.v(c0, "save_date");
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c0.j0()) {
                            break;
                        }
                        PremiumPlaylistEntity premiumPlaylistEntity0 = new PremiumPlaylistEntity();
                        premiumPlaylistEntity0.a = (int)c0.getLong(v);
                        String s1 = c0.S(v1);
                        q.g(s1, "<set-?>");
                        premiumPlaylistEntity0.b = s1;
                        premiumPlaylistEntity0.c = (int)c0.getLong(v2);
                        premiumPlaylistEntity0.d = (int)c0.getLong(v3);
                        z = ((int)c0.getLong(v4)) == 0 ? false : true;
                        premiumPlaylistEntity0.e = z;
                        z1 = ((int)c0.getLong(v5)) == 0 ? false : true;
                        premiumPlaylistEntity0.f = z1;
                        String s2 = c0.S(v6);
                        q.g(s2, "<set-?>");
                        premiumPlaylistEntity0.g = s2;
                        premiumPlaylistEntity0.h = c0.getLong(v7);
                        arrayList0.add(premiumPlaylistEntity0);
                    }
                    return arrayList0;
                }
            }
            case 8: {
                try(c c1 = ((a)object0).l0("delete from premium_contents where cid != -1")) {
                    c1.j0();
                    return Q1.c.F(((a)object0));
                }
            }
            case 9: {
                try(c c2 = ((a)object0).l0("select * from premium_contents")) {
                    int v8 = F.v(c2, "_id");
                    int v9 = F.v(c2, "cid");
                    int v10 = F.v(c2, "ctype");
                    int v11 = F.v(c2, "meta_type");
                    int v12 = F.v(c2, "bitrate");
                    int v13 = F.v(c2, "content_type");
                    int v14 = F.v(c2, "secret");
                    int v15 = F.v(c2, "file_update");
                    int v16 = F.v(c2, "file_size");
                    int v17 = F.v(c2, "cache_path");
                    int v18 = F.v(c2, "thumbnail_path");
                    int v19 = F.v(c2, "image_path");
                    int v20 = F.v(c2, "image_etag");
                    int v21 = F.v(c2, "is_free");
                    ArrayList arrayList1 = new ArrayList();
                    while(true) {
                        if(!c2.j0()) {
                            break;
                        }
                        PremiumContentsEntity premiumContentsEntity0 = new PremiumContentsEntity();
                        premiumContentsEntity0.a = (int)c2.getLong(v8);
                        String s3 = c2.S(v9);
                        q.g(s3, "<set-?>");
                        premiumContentsEntity0.b = s3;
                        String s4 = c2.S(v10);
                        q.g(s4, "<set-?>");
                        premiumContentsEntity0.c = s4;
                        String s5 = c2.S(v11);
                        q.g(s5, "<set-?>");
                        premiumContentsEntity0.d = s5;
                        String s6 = c2.S(v12);
                        q.g(s6, "<set-?>");
                        premiumContentsEntity0.e = s6;
                        String s7 = c2.S(v13);
                        q.g(s7, "<set-?>");
                        premiumContentsEntity0.f = s7;
                        String s8 = c2.S(v14);
                        q.g(s8, "<set-?>");
                        premiumContentsEntity0.g = s8;
                        String s9 = c2.S(v15);
                        q.g(s9, "<set-?>");
                        premiumContentsEntity0.h = s9;
                        String s10 = c2.S(v16);
                        q.g(s10, "<set-?>");
                        premiumContentsEntity0.i = s10;
                        String s11 = c2.S(v17);
                        q.g(s11, "<set-?>");
                        premiumContentsEntity0.j = s11;
                        s12 = c2.isNull(v18) ? null : c2.S(v18);
                        premiumContentsEntity0.k = s12;
                        s13 = c2.isNull(v19) ? null : c2.S(v19);
                        premiumContentsEntity0.l = s13;
                        s14 = c2.isNull(v20) ? null : c2.S(v20);
                        premiumContentsEntity0.m = s14;
                        if(c2.isNull(v21)) {
                            v22 = v9;
                            v23 = v18;
                            integer0 = null;
                        }
                        else {
                            v22 = v9;
                            v23 = v18;
                            integer0 = (int)c2.getLong(v21);
                        }
                        if(integer0 == null) {
                            boolean0 = null;
                        }
                        else {
                            z2 = ((int)integer0) == 0 ? false : true;
                            boolean0 = Boolean.valueOf(z2);
                        }
                        premiumContentsEntity0.n = boolean0;
                        arrayList1.add(premiumContentsEntity0);
                        v18 = v23;
                        v9 = v22;
                    }
                    return arrayList1;
                }
            }
            case 10: {
                try(c c3 = ((a)object0).l0("delete from premium_playlist where seq != -1")) {
                    c3.j0();
                    return Q1.c.F(((a)object0));
                }
            }
            case 11: {
                return Boolean.valueOf(ResourceFileSystem.f(((ZipEntry)object0)));
            }
            case 12: {
                return Boolean.valueOf(ZipFilesKt.a(((ZipEntry)object0)));
            }
            case 13: {
                q.g(((Playable)object0), "it");
                q.f("", "getSongidString(...)");
                return "";
            }
            case 14: {
                q.g(((m)object0), "it");
                String s15 = (String)((m)object0).a;
                return s15 == null ? "" : s15;
            }
            case 15: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 16: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.c(((x)object0));
                return h0;
            }
            case 17: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.c(((x)object0));
                return h0;
            }
            case 18: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 19: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 20: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 21: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.c(((x)object0));
                return h0;
            }
            case 22: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                u.c(((x)object0));
                return h0;
            }
            case 23: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 24: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 25: {
                q.g(((x)object0), "$this$semantics");
                u.m(((x)object0));
                return h0;
            }
            case 26: {
                ((Integer)object0).getClass();
                return h0;
            }
            case 27: {
                if(((h)object0) instanceof g) {
                    Navigator.openArtistInfo(((g)(((h)object0))).b);
                }
                return h0;
            }
            case 28: {
                try(c c4 = ((a)object0).l0("DELETE from response_cache")) {
                    c4.j0();
                    return h0;
                }
            }
            default: {
                String s = ((TrackBase)object0).songId;
                q.f(s, "songId");
                return s;
            }
        }
    }
}

