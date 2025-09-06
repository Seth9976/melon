package Bc;

import Kd.h;
import com.iloen.melon.constants.CType;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.playback.Playable;
import com.melon.net.res.common.MvInfoBase;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import je.w;
import kotlin.jvm.internal.q;

public abstract class j {
    public static final Playable a(i i0, String s) {
        q.g(i0, "<this>");
        q.g(s, "menuId");
        Playable playable0 = Playable.newBuilder().mvIdTitle(i0.e, i0.a).songIdTitle(i0.f, i0.g).albumIdName(i0.h, i0.i).albumImg(i0.j).albumImgThumb(i0.k).artists(i0.l).isAdult(i0.n).isService(i0.o).isTitle(i0.r).isHitsong(i0.w).isHoldback(i0.B).isFree(i0.D).isSong(i0.E).hasMv(true).playTime(i0.G).cType(CType.MV).menuId(s).originMenuId(s).statsElements(null).genreList(((List)i0.M)).build();
        q.f(playable0, "build(...)");
        return playable0;
    }

    public static final i b(MvInfoBase mvInfoBase0) {
        String s11;
        String s9;
        String s8;
        String s = mvInfoBase0.mvName == null ? "" : mvInfoBase0.mvName;
        String s1 = mvInfoBase0.mv169Img == null ? "" : mvInfoBase0.mv169Img;
        boolean z = mvInfoBase0.canService;
        String s2 = mvInfoBase0.issueDate == null ? "" : mvInfoBase0.issueDate;
        String s3 = mvInfoBase0.mvId == null ? "" : mvInfoBase0.mvId;
        String s4 = mvInfoBase0.songId == null ? "" : mvInfoBase0.songId;
        String s5 = mvInfoBase0.songName == null ? "" : mvInfoBase0.songName;
        String s6 = mvInfoBase0.albumId == null ? "" : mvInfoBase0.albumId;
        String s7 = mvInfoBase0.albumName == null ? "" : mvInfoBase0.albumName;
        if(mvInfoBase0.mv169Img == null || mvInfoBase0.mv169Img.length() == 0) {
            s8 = mvInfoBase0.albumImgLarge;
            if(s8 == null) {
                s8 = "";
            }
        }
        else {
            s8 = mvInfoBase0.mv169Img;
            if(s8 == null) {
                s8 = "";
            }
        }
        if(mvInfoBase0.mvImg == null || mvInfoBase0.mvImg.length() == 0) {
            s9 = mvInfoBase0.albumImg;
            if(s9 == null) {
                s9 = "";
            }
        }
        else {
            s9 = mvInfoBase0.mvImg;
            if(s9 == null) {
                s9 = "";
            }
        }
        LinkedHashMap linkedHashMap0 = h.a(mvInfoBase0);
        String s10 = ProtocolUtils.getArtistNames(mvInfoBase0.artistList);
        if(s10 == null) {
            s10 = "";
        }
        s11 = "";
        boolean z1 = mvInfoBase0.isAdult;
        boolean z2 = mvInfoBase0.canService;
        boolean z3 = mvInfoBase0.isTitleSong;
        boolean z4 = mvInfoBase0.isHitSong;
        boolean z5 = mvInfoBase0.isHoldback;
        boolean z6 = mvInfoBase0.isFree;
        boolean z7 = mvInfoBase0.hasSong;
        String s12 = mvInfoBase0.playTime;
        if(s12 != null) {
            s11 = s12;
        }
        q.f(CType.MV, "MV");
        ArrayList arrayList0 = mvInfoBase0.genreList;
        return arrayList0 == null ? new i(s, s1, z, s2, s3, s4, s5, s6, s7, s8, s9, linkedHashMap0, s10, z1, z2, z3, z4, z5, z6, z7, s11, CType.MV, w.a) : new i(s, s1, z, s2, s3, s4, s5, s6, s7, s8, s9, linkedHashMap0, s10, z1, z2, z3, z4, z5, z6, z7, s11, CType.MV, arrayList0);
    }
}

