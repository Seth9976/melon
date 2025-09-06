package kc;

import com.iloen.melon.net.mcp.Area;
import com.iloen.melon.net.mcp.response.EpPlayPositionRes;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytTab.Companion;
import com.iloen.melon.player.playlist.drawernew.model.DrawerPlytTab;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import e.k;
import ie.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

public final class c {
    public final Object a(String s, oe.c c0) {
        Object object1;
        String s4;
        a a0;
        if(c0 instanceof a) {
            a0 = (a)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new a(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new a(this, c0);
        }
        Object object0 = a0.r;
        ne.a a1 = ne.a.a;
        switch(a0.B) {
            case 0: {
                n.D(object0);
                try {
                    a0.B = 1;
                    object0 = BuildersKt.withContext(Dispatchers.getIO(), new b(s, null), a0);
                    if(object0 == a1) {
                        return a1;
                    label_18:
                        n.D(object0);
                    }
                    Area area0 = ((EpPlayPositionRes)object0).area;
                    String s1 = area0.smartListType;
                    if(q.b(s1, "song")) {
                        String s12 = area0.pcId;
                        q.f(s12, "pcId");
                        String s13 = area0.trackId;
                        q.f(s13, "trackId");
                        String s14 = area0.position;
                        q.f(s14, "position");
                        object1 = new h3(s12, s13, Long.parseLong(s14) * 1000L);
                    }
                    else {
                        if(!q.b(s1, "playlist")) {
                            throw new IllegalStateException("Unknown smart list type: " + area0.smartListType);
                        }
                        String s2 = area0.cId;
                        if(area0.contsId != null && area0.contsId.length() != 0) {
                            s4 = area0.contsId;
                        }
                        else {
                            String s3 = area0.listType;
                            if(q.b(s3, "recent")) {
                                s4 = "PlaylistSeqRecent";
                            }
                            else {
                                if(!q.b(s3, "like")) {
                                    throw new Exception("Invalid contsId when syncEpPlayPosition drawer.");
                                }
                                s4 = "PlaylistSeqLike";
                            }
                        }
                        String s5 = "RECENT";
                        String s6 = area0.position;
                        q.f(s6, "position");
                        long v1 = Long.parseLong(s6);
                        String s7 = area0.listType;
                        if(s7 != null) {
                            switch(s7) {
                                case "created": {
                                    goto label_47;
                                }
                                case "dj": {
                                    s5 = "DJ";
                                    break;
                                }
                                case "like": {
                                    s5 = "LIKE";
                                }
                            }
                            goto label_48;
                        label_47:
                            s5 = "MADE_BY_ME";
                        }
                    label_48:
                        q.d(s4);
                        String s8 = area0.contsTypeCode;
                        q.f(s8, "contsTypeCode");
                        String s9 = area0.seedContsId;
                        q.f(s9, "seedContsId");
                        String s10 = area0.seedContsTypeCode;
                        q.f(s10, "seedContsTypeCode");
                        DrawerPlaylistInfo drawerPlaylistInfo0 = new DrawerPlaylistInfo(s5, s4, s8, s9, s10, Companion.getMenuIdsInDetail$default(DrawerPlytTab.Companion, s5, false, 2, null), null, null, 0xC0, null);
                        String s11 = area0.pcId;
                        q.f(s11, "pcId");
                        q.d(s2);
                        object1 = new g3(s11, drawerPlaylistInfo0, s2, v1 * 1000L);
                    }
                    goto label_71;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                goto label_18;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        object1 = n.t(throwable0);
    label_71:
        Throwable throwable1 = p.a(object1);
        if(throwable1 != null) {
            LogU.Companion.d("EpPlaySyncRepository", "getSyncEpPlayPosition failed", throwable1);
        }
        return object1;
    }

    public static boolean b(PlaylistId playlistId0) {
        return je.p.d0(k.A(new PlaylistId[]{PlaylistId.SMART, PlaylistId.DRAWER}), playlistId0);
    }
}

