package H8;

import G4.a;
import G4.c;
import Hd.v;
import Hd.z0;
import Ic.o;
import Lc.l;
import U4.F;
import X0.u;
import X0.x;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.K4;
import ie.H;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.q;
import we.k;

public final class g implements k {
    public final int a;

    public g(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        switch(this.a) {
            case 0: {
                try(c c0 = ((a)object0).l0("SELECT data, artists, artist_ids, COUNT(artists) as count FROM local_contents WHERE mime_type == \'audio/flac\' and genre != \'어학\' GROUP BY artists ORDER BY (CASE WHEN substr(artists, 1, 1) BETWEEN \'ㄱ\' AND \'ㅎ\' THEN 1 WHEN substr(artists, 1, 1) BETWEEN \'가\' AND \'힣\' THEN 1 WHEN substr(artists, 1, 1) BETWEEN \'A\' AND \'Z\' THEN 2 WHEN substr(artists, 1, 1) BETWEEN \'a\' AND \'z\' THEN 2 WHEN substr(artists, 1, 1) BETWEEN \'0\' AND \'9\' THEN 3 ELSE 4 END), artists COLLATE BINARY ASC")) {
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c0.j0()) {
                            break;
                        }
                        String s = c0.S(0);
                        String s1 = c0.S(1);
                        String s2 = c0.S(2);
                        arrayList0.add(new b(((int)c0.getLong(3)), s, s1, s2));
                    }
                    return arrayList0;
                }
            }
            case 1: {
                try(c c1 = ((a)object0).l0("SELECT _id, name, date_added, date_modified, sort_order, (select count(_id) from local_playlists_map where local_playlists_map.playlist_id = local_playlists._id) as playlist_count FROM local_playlists ORDER BY sort_order DESC")) {
                    ArrayList arrayList1 = new ArrayList();
                    while(true) {
                        if(!c1.j0()) {
                            break;
                        }
                        arrayList1.add(new s(c1.getLong(0), c1.S(1), c1.getLong(2), c1.getLong(3), ((int)c1.getLong(4)), ((int)c1.getLong(5))));
                    }
                    return arrayList1;
                }
            }
            case 2: {
                try(c c2 = ((a)object0).l0("SELECT count(_id) FROM local_playlists")) {
                    return c2.j0() ? ((int)c2.getLong(0)) : 0;
                }
            }
            case 3: {
                try(c c3 = ((a)object0).l0("SELECT sort_order from local_playlists ORDER BY sort_order DESC LIMIT 1")) {
                    return c3.j0() ? ((int)c3.getLong(0)) : 0;
                }
            }
            case 4: {
                try(c c4 = ((a)object0).l0("SELECT * FROM local_playlists_map")) {
                    int v = F.v(c4, "_id");
                    int v1 = F.v(c4, "audio_id");
                    int v2 = F.v(c4, "mime_type");
                    int v3 = F.v(c4, "data");
                    int v4 = F.v(c4, "uri");
                    int v5 = F.v(c4, "displayName");
                    int v6 = F.v(c4, "title");
                    int v7 = F.v(c4, "album_id");
                    int v8 = F.v(c4, "album");
                    int v9 = F.v(c4, "artist");
                    int v10 = F.v(c4, "artist_id");
                    int v11 = F.v(c4, "playlist_id");
                    int v12 = F.v(c4, "play_order");
                    int v13 = F.v(c4, "duration");
                    ArrayList arrayList2 = new ArrayList();
                    while(true) {
                        if(!c4.j0()) {
                            break;
                        }
                        arrayList2.add(new t(c4.getLong(v), c4.getLong(v1), c4.S(v2), c4.S(v3), c4.S(v4), c4.S(v5), c4.S(v6), c4.S(v7), c4.S(v8), c4.S(v9), c4.S(v10), c4.getLong(v11), ((int)c4.getLong(v12)), ((int)c4.getLong(v13))));
                    }
                    return arrayList2;
                }
            }
            case 5: {
                q.g(((Throwable)object0), "it");
                ToastManager.show(0x7F131061);  // string:toast_create_log_fail "로그 생성을 실패하였습니다."
                return h0;
            }
            case 6: {
                q.g(((Throwable)object0), "it");
                ToastManager.show(0x7F131061);  // string:toast_create_log_fail "로그 생성을 실패하였습니다."
                return h0;
            }
            case 7: {
                q.g(((K4)object0), "it");
                return v.a;
            }
            case 8: {
                return new ie.s("", "", "");
            }
            case 9: {
                return new ie.s("", "", "");
            }
            case 10: {
                q.g(((o)object0), "artist");
                return ((o)object0).b;
            }
            case 11: {
                q.g(((Playable)object0), "it");
                q.f("", "getSongidString(...)");
                return "";
            }
            case 12: {
                q.g(((o)object0), "artist");
                return ((o)object0).b;
            }
            case 13: {
                q.g(((o)object0), "artist");
                return ((o)object0).a;
            }
            case 14: {
                q.g(((Playable)object0), "it");
                q.f("", "getSongName(...)");
                return "";
            }
            case 15: {
                q.g(((o)object0), "artist");
                return ((o)object0).b;
            }
            case 16: {
                q.g(((o)object0), "artist");
                return ((o)object0).a;
            }
            case 17: {
                q.g(((Playable)object0), "it");
                q.f("", "getSongidString(...)");
                return "";
            }
            case 18: {
                q.g(((Playable)object0), "it");
                q.f("", "getSongName(...)");
                return "";
            }
            case 19: {
                q.g(((z0)object0), "it");
                return h0;
            }
            case 20: {
                q.g(((Bc.b)object0), "it");
                return ((Bc.b)object0).b;
            }
            case 21: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 22: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 23: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return h0;
            }
            case 24: {
                q.g(((Map)object0), "it");
                return h0;
            }
            case 25: {
                q.g(((K4)object0), "it");
                return l.a;
            }
            case 26: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return h0;
            }
            case 27: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return h0;
            }
            case 28: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return h0;
            }
            default: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return h0;
            }
        }
    }
}

