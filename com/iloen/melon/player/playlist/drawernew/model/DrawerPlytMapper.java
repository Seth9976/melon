package com.iloen.melon.player.playlist.drawernew.model;

import H0.e;
import Tf.v;
import com.iloen.melon.fragments.main.foru.ForUUtils;
import com.iloen.melon.net.v6x.response.DjSmartPlaylistListRes.RESPONSE.DJPLAYLISTLIST;
import com.iloen.melon.net.v6x.response.MyMusicLikePlaylistRes.RESPONSE.LIKEPLYLSTLIST;
import com.iloen.melon.net.v6x.response.MyMusicRecentPlaylistRes.RESPONSE.RECNTPLYLSTLIST;
import com.iloen.melon.net.v6x.response.MyMusicSmartPlaylistListRes.RESPONSE.PLAYLISTLIST;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.utils.ResourceUtilsKt;
import com.iloen.melon.utils.image.ImageUrl;
import com.iloen.melon.utils.network.NetUtils;
import e.k;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.w;
import k9.h;
import k9.j;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J)\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ)\u0010\u000B\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\n2\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u000B\u0010\fJ)\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\r2\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u000E\u0010\u000FJ)\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00102\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytMapper;", "", "Lcom/iloen/melon/net/v6x/response/MyMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST;", "res", "", "isPlaying", "isSelect", "Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "recentToDrawerPlytListListItemUiState", "(Lcom/iloen/melon/net/v6x/response/MyMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST;ZZ)Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "Lcom/iloen/melon/net/v6x/response/MyMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST;", "likeToDrawerPlytListListItemUiState", "(Lcom/iloen/melon/net/v6x/response/MyMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST;ZZ)Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "Lcom/iloen/melon/net/v6x/response/MyMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST;", "madeByMeToDrawerPlytListListItemUiState", "(Lcom/iloen/melon/net/v6x/response/MyMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST;ZZ)Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "Lcom/iloen/melon/net/v6x/response/DjSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST;", "djToDrawerPlytListListItemUiState", "(Lcom/iloen/melon/net/v6x/response/DjSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST;ZZ)Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlytMapper {
    public static final int $stable;
    @NotNull
    public static final DrawerPlytMapper INSTANCE;

    static {
        DrawerPlytMapper.INSTANCE = new DrawerPlytMapper();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static List a(String s, int v, List list0) {
        ArrayList arrayList0;
        boolean z = j.b();
        if(v == 0) {
            String s1 = null;
            String s2 = "";
            if(s.equals("33")) {
                String s3 = 2 < list0.size() ? list0.get(2) : "";
                if(!z) {
                    s1 = s3;
                }
                if(s1 == null) {
                    s1 = ImageUrl.getOfflinePlaylistImagePath(s3).toString();
                    q.f(s1, "toString(...)");
                }
            }
            else {
                String s4 = 1 < list0.size() ? list0.get(1) : "";
                if(!z) {
                    s1 = s4;
                }
                if(s1 == null) {
                    s1 = ImageUrl.getOfflinePlaylistImagePath(s4).toString();
                    q.f(s1, "toString(...)");
                }
            }
            if(s.equals("33")) {
                String s5 = list0.size() > 0 ? list0.get(0) : "";
                if(1 < list0.size()) {
                    s2 = list0.get(1);
                }
                arrayList0 = k.e(new String[]{s5, s2});
                return p.A0(k.e(new String[]{s1}), arrayList0);
            }
            String[] arr_s = new String[1];
            if(list0.size() > 0) {
                s2 = list0.get(0);
            }
            arr_s[0] = s2;
            arrayList0 = k.e(arr_s);
            return p.A0(k.e(new String[]{s1}), arrayList0);
        }
        return list0;
    }

    @NotNull
    public final DrawerPlytWrapper djToDrawerPlytListListItemUiState(@NotNull DJPLAYLISTLIST djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0, boolean z, boolean z1) {
        q.g(djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0, "res");
        String s = "";
        DrawerPlaylistInfo drawerPlaylistInfo0 = new DrawerPlaylistInfo("DJ", (djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylstseq == null ? "" : djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylstseq), (djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.contsTypeCode == null ? "" : djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.contsTypeCode), null, null, "1000003097", (djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylsttitle == null ? "" : djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylsttitle), null, 0x98, null);
        boolean z2 = h.d(drawerPlaylistInfo0);
        String s1 = djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylsttitle == null ? "" : djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylsttitle;
        String s2 = ResourceUtilsKt.getString(0x7F13083B, new Object[]{(djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.songcnt == null ? "" : djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.songcnt)});  // string:playlist_song_count "%s곡"
        String s3 = djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylstseq == null ? "" : djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.plylstseq;
        String s4 = djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.thumbimg;
        if(s4 != null) {
            s = s4;
        }
        List list0 = DrawerPlytMapper.a(s3, 2, k.z(s));
        boolean z3 = djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0.isOpen();
        return !z2 || NetUtils.isConnected() ? new DrawerPlytWrapper(2, s1, s1, s2, list0, z3, false, z, z1, false, "playlist", drawerPlaylistInfo0, 0x40, null) : new DrawerPlytWrapper(2, s1, s1, s2, list0, z3, false, z, z1, true, "playlist", drawerPlaylistInfo0, 0x40, null);
    }

    public static DrawerPlytWrapper djToDrawerPlytListListItemUiState$default(DrawerPlytMapper drawerPlytMapper0, DJPLAYLISTLIST djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        if((v & 4) != 0) {
            z1 = false;
        }
        return drawerPlytMapper0.djToDrawerPlytListListItemUiState(djSmartPlaylistListRes$RESPONSE$DJPLAYLISTLIST0, z, z1);
    }

    @NotNull
    public final DrawerPlytWrapper likeToDrawerPlytListListItemUiState(@NotNull LIKEPLYLSTLIST myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0, boolean z, boolean z1) {
        int v1;
        q.g(myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0, "res");
        boolean z2 = q.b(myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.type, "like");
        String s = z2 ? "PlaylistSeqLike" : myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.contentId;
        q.d(s);
        String s1 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.type;
        q.f(s1, "type");
        int v = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.albumImgs == null ? 0 : myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.albumImgs.size();
        String s2 = e.z(s);
        if(!q.b(s1, "mix") || !s2.equals("TYPE_FORU_ARTIST")) {
            v1 = v <= 1 ? 2 : 1;
        }
        else {
            v1 = 0;
        }
        String s3 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.mainTitle;
        q.f(s3, "mainTitle");
        String s4 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.mainReplace;
        String s5 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.contentsTypeCode;
        q.f(s5, "contentsTypeCode");
        String s6 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.seedContentsTypeCode;
        String s7 = null;
        if(z2) {
            s6 = null;
        }
        String s8 = "";
        String s9 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.seedContentId;
        if(!z2) {
            s7 = s9;
        }
        if(s7 != null) {
            s8 = s7;
        }
        DrawerPlaylistInfo drawerPlaylistInfo0 = new DrawerPlaylistInfo("LIKE", s, s5, s8, (s6 == null ? "" : s6), (z2 ? "1000003094" : "1000003095"), s3, s4);
        boolean z3 = h.d(drawerPlaylistInfo0);
        String s10 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.mainTitle;
        q.f(s10, "mainTitle");
        String s11 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.mainReplace;
        q.f(s11, "mainReplace");
        String s12 = v.p0(s10, "<b>MAINREPLACE</b>", s11);
        String s13 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.ownerNickName;
        q.f(s13, "ownerNickName");
        ArrayList arrayList0 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.albumImgs;
        if(arrayList0 == null) {
            arrayList0 = w.a;
        }
        List list0 = DrawerPlytMapper.a(s, v1, arrayList0);
        String s14 = myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0.type;
        q.f(s14, "type");
        return !z3 || NetUtils.isConnected() ? new DrawerPlytWrapper(v1, s12, s12, s13, list0, true, false, z, z1, false, s14, drawerPlaylistInfo0) : new DrawerPlytWrapper(v1, s12, s12, s13, list0, true, false, z, z1, true, s14, drawerPlaylistInfo0);
    }

    public static DrawerPlytWrapper likeToDrawerPlytListListItemUiState$default(DrawerPlytMapper drawerPlytMapper0, LIKEPLYLSTLIST myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        if((v & 4) != 0) {
            z1 = false;
        }
        return drawerPlytMapper0.likeToDrawerPlytListListItemUiState(myMusicLikePlaylistRes$RESPONSE$LIKEPLYLSTLIST0, z, z1);
    }

    @NotNull
    public final DrawerPlytWrapper madeByMeToDrawerPlytListListItemUiState(@NotNull PLAYLISTLIST myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0, boolean z, boolean z1) {
        q.g(myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0, "res");
        String s = "";
        DrawerPlaylistInfo drawerPlaylistInfo0 = new DrawerPlaylistInfo("MADE_BY_ME", (myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylstseq == null ? "" : myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylstseq), (myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.contsTypeCode == null ? "" : myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.contsTypeCode), null, null, "1000003096", (myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylsttitle == null ? "" : myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylsttitle), null, 0x98, null);
        boolean z2 = h.d(drawerPlaylistInfo0);
        String s1 = myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylsttitle == null ? "" : myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylsttitle;
        String s2 = ResourceUtilsKt.getString(0x7F13083B, new Object[]{(myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.songcnt == null ? "" : myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.songcnt)});  // string:playlist_song_count "%s곡"
        String s3 = myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylstseq == null ? "" : myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.plylstseq;
        String s4 = myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.thumbimg;
        if(s4 != null) {
            s = s4;
        }
        List list0 = DrawerPlytMapper.a(s3, 2, k.z(s));
        boolean z3 = myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0.isOpen();
        return !z2 || NetUtils.isConnected() ? new DrawerPlytWrapper(2, s1, s1, s2, list0, z3, false, z, z1, false, "playlist", drawerPlaylistInfo0, 0x40, null) : new DrawerPlytWrapper(2, s1, s1, s2, list0, z3, false, z, z1, true, "playlist", drawerPlaylistInfo0, 0x40, null);
    }

    public static DrawerPlytWrapper madeByMeToDrawerPlytListListItemUiState$default(DrawerPlytMapper drawerPlytMapper0, PLAYLISTLIST myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        if((v & 4) != 0) {
            z1 = false;
        }
        return drawerPlytMapper0.madeByMeToDrawerPlytListListItemUiState(myMusicSmartPlaylistListRes$RESPONSE$PLAYLISTLIST0, z, z1);
    }

    @NotNull
    public final DrawerPlytWrapper recentToDrawerPlytListListItemUiState(@NotNull RECNTPLYLSTLIST myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0, boolean z, boolean z1) {
        int v1;
        q.g(myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0, "res");
        boolean z2 = q.b(myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.type, "recent");
        String s = z2 ? "PlaylistSeqRecent" : myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.contentId;
        q.d(s);
        String s1 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.type;
        q.f(s1, "type");
        int v = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.albumImgs == null ? 0 : myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.albumImgs.size();
        String s2 = e.z(s);
        if(!q.b(s1, "mix") || !s2.equals("TYPE_FORU_ARTIST")) {
            v1 = v <= 1 ? 2 : 1;
        }
        else {
            v1 = 0;
        }
        String s3 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.mainTitle;
        q.f(s3, "mainTitle");
        String s4 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.mainReplace;
        String s5 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.contentsTypeCode;
        q.f(s5, "contentsTypeCode");
        String s6 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.seedContentId;
        String s7 = null;
        if(z2) {
            s6 = null;
        }
        if(s6 == null) {
            s6 = "";
        }
        String s8 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.seedContentsTypeCode;
        if(!z2) {
            s7 = s8;
        }
        DrawerPlaylistInfo drawerPlaylistInfo0 = new DrawerPlaylistInfo("RECENT", s, s5, s6, (s7 == null ? "" : s7), (z2 ? "1000003092" : "1000003093"), s3, s4);
        boolean z3 = h.d(drawerPlaylistInfo0);
        m m0 = q.b(myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.contentsTypeCode, "N10078") ? new m(ForUUtils.replaceNicknameWithMarkup(myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.mainTitle, "<b>MAINREPLACE</b>", myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.mainReplace, 10), ForUUtils.replaceNicknameWithMarkup(myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.mainTitle, "<b>MAINREPLACE</b>", myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.mainReplace, 22)) : new m(myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.mainTitle, myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.mainTitle);
        String s9 = (String)m0.a;
        String s10 = (String)m0.b;
        q.d(s9);
        q.d(s10);
        String s11 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.ownerNickName;
        q.f(s11, "ownerNickName");
        Boolean boolean0 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.isOpen;
        q.f(boolean0, "isOpen");
        boolean z4 = boolean0.booleanValue();
        ArrayList arrayList0 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.albumImgs;
        if(arrayList0 == null) {
            arrayList0 = w.a;
        }
        List list0 = DrawerPlytMapper.a(s, v1, arrayList0);
        boolean z5 = z3 && !NetUtils.isConnected();
        String s12 = myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0.type;
        q.f(s12, "type");
        return new DrawerPlytWrapper(v1, s9, s10, s11, list0, z4, false, z, z1, z5, s12, drawerPlaylistInfo0);
    }

    public static DrawerPlytWrapper recentToDrawerPlytListListItemUiState$default(DrawerPlytMapper drawerPlytMapper0, RECNTPLYLSTLIST myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0, boolean z, boolean z1, int v, Object object0) {
        if((v & 2) != 0) {
            z = false;
        }
        if((v & 4) != 0) {
            z1 = false;
        }
        return drawerPlytMapper0.recentToDrawerPlytListListItemUiState(myMusicRecentPlaylistRes$RESPONSE$RECNTPLYLSTLIST0, z, z1);
    }
}

