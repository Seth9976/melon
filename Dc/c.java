package dc;

import U4.F;
import X0.u;
import X0.x;
import com.melon.data.database.entity.MusicSearchHistoryEntity;
import com.melon.playback.melon.streaming.tracker.NetworkEvents;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import je.p;
import kotlin.jvm.internal.q;
import we.k;

public final class c implements k {
    public final int a;

    public c(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z1;
        switch(this.a) {
            case 0: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection0 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("secureConnectStart", System.currentTimeMillis()), collection0), null, null, null, null, 30, null);
            }
            case 1: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection1 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("proxySelectEnd", System.currentTimeMillis()), collection1), null, null, null, null, 30, null);
            }
            case 2: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection2 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("cacheConditionalHit", System.currentTimeMillis()), collection2), null, null, null, null, 30, null);
            }
            case 3: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection3 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("dnsStart", System.currentTimeMillis()), collection3), null, null, null, null, 30, null);
            }
            case 4: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection4 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("connectStart", System.currentTimeMillis()), collection4), null, null, null, null, 30, null);
            }
            case 5: {
                q.g(((NetworkEvents)object0), "it");
                return new NetworkEvents(e.k.z(new a("callStart", System.currentTimeMillis())), null, null, null, null, 30, null);
            }
            case 6: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection5 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("secureConnectEnd", System.currentTimeMillis()), collection5), null, null, null, null, 30, null);
            }
            case 7: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection6 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("responseBodyStart", System.currentTimeMillis()), collection6), null, null, null, null, 30, null);
            }
            case 8: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection7 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("responseBodyEnd", System.currentTimeMillis()), collection7), null, null, null, null, 30, null);
            }
            case 9: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection8 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("satisfactionFailure", System.currentTimeMillis()), collection8), null, null, null, null, 30, null);
            }
            case 10: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection9 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("requestHeadersStart", System.currentTimeMillis()), collection9), null, null, null, null, 30, null);
            }
            case 11: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection10 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("cacheHit", System.currentTimeMillis()), collection10), null, null, null, null, 30, null);
            }
            case 12: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection11 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("cacheMiss", System.currentTimeMillis()), collection11), null, null, null, null, 30, null);
            }
            case 13: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection12 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("connectEnd", System.currentTimeMillis()), collection12), null, null, null, null, 30, null);
            }
            case 14: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection13 = ((NetworkEvents)object0).getEvents();
                NetworkEvents networkEvents0 = NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("callEnd", System.currentTimeMillis()), collection13), null, null, null, null, 30, null);
                g.c.q(networkEvents0);
                return networkEvents0;
            }
            case 15: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection14 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("responseHeadersStart", System.currentTimeMillis()), collection14), null, null, null, null, 30, null);
            }
            case 16: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection15 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("canceled", System.currentTimeMillis()), collection15), null, null, null, null, 30, null);
            }
            case 17: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection16 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("requestBodyEnd", System.currentTimeMillis()), collection16), null, null, null, null, 30, null);
            }
            case 18: {
                q.g(((NetworkEvents)object0), "previous");
                Collection collection17 = ((NetworkEvents)object0).getEvents();
                return NetworkEvents.copy$default(((NetworkEvents)object0), p.z0(new a("proxySelectStart", System.currentTimeMillis()), collection17), null, null, null, null, 30, null);
            }
            case 19: {
                try(G4.c c0 = ((G4.a)object0).l0("SELECT COUNT(*) FROM banner_popup")) {
                    return c0.j0() ? ((int)c0.getLong(0)) : 0;
                }
            }
            case 20: {
                try(G4.c c1 = ((G4.a)object0).l0("select count(*) from local_playback_log")) {
                    return c1.j0() ? ((int)c1.getLong(0)) : 0;
                }
            }
            case 21: {
                try(G4.c c2 = ((G4.a)object0).l0("delete from search_history where timestamp = (select min(timestamp) from search_history)")) {
                    c2.j0();
                    return Q1.c.F(((G4.a)object0));
                }
            }
            case 22: {
                try(G4.c c3 = ((G4.a)object0).l0("delete from search_history")) {
                    c3.j0();
                }
                return null;
            }
            case 23: {
                try(G4.c c4 = ((G4.a)object0).l0("select * from search_history order by timestamp desc")) {
                    int v = F.v(c4, "_id");
                    int v1 = F.v(c4, "song_id");
                    int v2 = F.v(c4, "song_name");
                    int v3 = F.v(c4, "album_id");
                    int v4 = F.v(c4, "album_name");
                    int v5 = F.v(c4, "album_img_path");
                    int v6 = F.v(c4, "artist_id");
                    int v7 = F.v(c4, "artist_name");
                    int v8 = F.v(c4, "ctype");
                    int v9 = F.v(c4, "is_service");
                    int v10 = F.v(c4, "is_adult");
                    int v11 = F.v(c4, "play_time");
                    int v12 = F.v(c4, "timestamp");
                    ArrayList arrayList0 = new ArrayList();
                    while(true) {
                        if(!c4.j0()) {
                            break;
                        }
                        MusicSearchHistoryEntity musicSearchHistoryEntity0 = new MusicSearchHistoryEntity();
                        musicSearchHistoryEntity0.setUid(((int)c4.getLong(v)));
                        musicSearchHistoryEntity0.setSongId(c4.S(v1));
                        musicSearchHistoryEntity0.setSongName(c4.S(v2));
                        musicSearchHistoryEntity0.setAlbumId(c4.S(v3));
                        musicSearchHistoryEntity0.setAlbumName(c4.S(v4));
                        musicSearchHistoryEntity0.setAlbumImgPath(c4.S(v5));
                        musicSearchHistoryEntity0.setArtistId(c4.S(v6));
                        musicSearchHistoryEntity0.setArtistName(c4.S(v7));
                        musicSearchHistoryEntity0.setCType(c4.S(v8));
                        boolean z = false;
                        z1 = ((int)c4.getLong(v9)) == 0 ? false : true;
                        musicSearchHistoryEntity0.setService(z1);
                        if(((int)c4.getLong(v10)) != 0) {
                            z = true;
                        }
                        musicSearchHistoryEntity0.setAdult(z);
                        musicSearchHistoryEntity0.setPlayTime(c4.S(v11));
                        musicSearchHistoryEntity0.setTimestamp(c4.getLong(v12));
                        arrayList0.add(musicSearchHistoryEntity0);
                    }
                }
                return arrayList0;
            }
            case 24: {
                try(G4.c c5 = ((G4.a)object0).l0("select count(*) from search_history")) {
                    return c5.j0() ? ((int)c5.getLong(0)) : 0;
                }
            }
            case 25: {
                try(G4.c c6 = ((G4.a)object0).l0("select memberkey from premium_off_play_log group by memberkey")) {
                    ArrayList arrayList1 = new ArrayList();
                    while(true) {
                        if(!c6.j0()) {
                            break;
                        }
                        arrayList1.add(c6.S(0));
                    }
                }
                return arrayList1;
            }
            case 26: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return H.a;
            }
            case 27: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return H.a;
            }
            case 28: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return H.a;
            }
            default: {
                q.g(((x)object0), "$this$semantics");
                u.k(((x)object0), 0);
                return H.a;
            }
        }
    }
}

