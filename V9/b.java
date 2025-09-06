package v9;

import android.text.TextUtils;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.AtachListBase.ATACHPROPTY;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.AtachListBase;
import com.iloen.melon.net.v3x.comments.CmtSharedTypeRes.AtachProptyBase;
import com.iloen.melon.types.MediaAttachInfo;
import com.iloen.melon.types.MediaAttachType;
import com.iloen.melon.utils.log.LogU;

public abstract class b {
    public static MediaAttachInfo a(AtachListBase cmtSharedTypeRes$AtachListBase0) {
        ATACHPROPTY cmtSharedTypeRes$AtachListBase$ATACHPROPTY0 = cmtSharedTypeRes$AtachListBase0.atachpropty;
        if(cmtSharedTypeRes$AtachListBase$ATACHPROPTY0 == null) {
            LogU.e("CmtAttachType", "getAttachInfo() invalid atachPropty");
            return null;
        }
        MediaAttachInfo mediaAttachInfo0 = new MediaAttachInfo();
        String s = cmtSharedTypeRes$AtachListBase0.atachtype;
        if("text".equals(s)) {
            return null;
        }
        if("image".equals(s)) {
            mediaAttachInfo0.a = MediaAttachType.g;
            mediaAttachInfo0.g = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.thumburl;
            mediaAttachInfo0.h = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.originalurl;
            return mediaAttachInfo0;
        }
        if("music_song".equals(s)) {
            mediaAttachInfo0.a = MediaAttachType.c;
            mediaAttachInfo0.e = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.songid;
            mediaAttachInfo0.j = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.songname;
            mediaAttachInfo0.c = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.albumid;
            mediaAttachInfo0.i = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.albumname;
            mediaAttachInfo0.k = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistname;
            mediaAttachInfo0.g = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.albumimagepath;
            mediaAttachInfo0.B = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.dsplyissuedate;
            mediaAttachInfo0.d = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistid;
            String s1 = AtachProptyBase.getArtistNames(cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistlist);
            mediaAttachInfo0.k = s1;
            if(TextUtils.isEmpty(s1)) {
                mediaAttachInfo0.k = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistname;
            }
            mediaAttachInfo0.I = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.adultflag;
            mediaAttachInfo0.M = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.holdbackflag;
            mediaAttachInfo0.N = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.freezoneflag;
            mediaAttachInfo0.Y = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.isUnavailableService();
            return mediaAttachInfo0;
        }
        if("music_album".equals(s)) {
            mediaAttachInfo0.a = MediaAttachType.d;
            mediaAttachInfo0.c = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.albumid;
            mediaAttachInfo0.i = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.albumname;
            mediaAttachInfo0.g = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.albumimagepath;
            mediaAttachInfo0.B = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.dsplyissuedate;
            mediaAttachInfo0.d = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistid;
            String s2 = AtachProptyBase.getArtistNames(cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistlist);
            mediaAttachInfo0.k = s2;
            if(TextUtils.isEmpty(s2)) {
                mediaAttachInfo0.k = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistname;
            }
            mediaAttachInfo0.Y = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.isUnavailableService();
            return mediaAttachInfo0;
        }
        if("music_artist".equals(s)) {
            mediaAttachInfo0.a = MediaAttachType.e;
            mediaAttachInfo0.d = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistid;
            mediaAttachInfo0.k = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistname;
            mediaAttachInfo0.l = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artisttype;
            mediaAttachInfo0.m = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.nationalityname;
            mediaAttachInfo0.n = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.acttypename;
            mediaAttachInfo0.o = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.sex;
            mediaAttachInfo0.r = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.gnr;
            mediaAttachInfo0.g = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistimagepath;
            mediaAttachInfo0.w = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.fancnt;
            return mediaAttachInfo0;
        }
        if("video".equals(s)) {
            mediaAttachInfo0.a = MediaAttachType.h;
            mediaAttachInfo0.f = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videoid;
            mediaAttachInfo0.E = AtachProptyBase.getMvTitle(cmtSharedTypeRes$AtachListBase$ATACHPROPTY0);
            mediaAttachInfo0.I = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videoadultflag;
            mediaAttachInfo0.g = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videoimagepath;
            mediaAttachInfo0.B = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.dsplyvideoissuedate;
            mediaAttachInfo0.D = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.dsplyplaytime;
            mediaAttachInfo0.e = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.songid;
            mediaAttachInfo0.c = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.albumid;
            mediaAttachInfo0.k = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistname;
            mediaAttachInfo0.G = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videoviewcnt;
            mediaAttachInfo0.d = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistid;
            String s3 = AtachProptyBase.getArtistNames(cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistlist);
            mediaAttachInfo0.k = s3;
            if(TextUtils.isEmpty(s3)) {
                mediaAttachInfo0.k = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.artistname;
            }
            mediaAttachInfo0.I = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videoadultflag;
            mediaAttachInfo0.M = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.holdbackflag;
            mediaAttachInfo0.N = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.freezoneflag;
            mediaAttachInfo0.S = b.c(cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videoagelevel);
            return mediaAttachInfo0;
        }
        if("link_video".equals(s)) {
            mediaAttachInfo0.a = MediaAttachType.i;
            mediaAttachInfo0.E = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videotitle;
            mediaAttachInfo0.g = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.thumburl;
            mediaAttachInfo0.h = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videourl;
            mediaAttachInfo0.T = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videowidth;
            mediaAttachInfo0.V = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.videoheight;
            return mediaAttachInfo0;
        }
        if("kakao_emoticon".equals(s)) {
            mediaAttachInfo0.a = MediaAttachType.j;
            String s4 = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.kakaoemoticon;
            if(s4 != null) {
                mediaAttachInfo0.X = s4.replaceAll("&quot;", "\"");
            }
            return mediaAttachInfo0;
        }
        if("link_genrl".equals(s)) {
            mediaAttachInfo0.a = MediaAttachType.k;
            mediaAttachInfo0.h = cmtSharedTypeRes$AtachListBase$ATACHPROPTY0.linkurl;
            return mediaAttachInfo0;
        }
        LogU.e("CmtAttachType", "getAttachInfo() unknown type: " + s);
        return null;
    }

    public static a b(MediaAttachInfo mediaAttachInfo0) {
        if(mediaAttachInfo0 == null) {
            LogU.e("CmtAttachType", "getCmtAttachValue() invalid parameter");
            return null;
        }
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        MediaAttachType mediaAttachType0 = mediaAttachInfo0.a;
        if(MediaAttachType.c.equals(mediaAttachType0)) {
            a0.a = "music_song";
            a0.b = String.valueOf(mediaAttachInfo0.e);
        }
        else if(MediaAttachType.d.equals(mediaAttachType0)) {
            a0.a = "music_album";
            a0.b = String.valueOf(mediaAttachInfo0.c);
        }
        else if(MediaAttachType.e.equals(mediaAttachType0)) {
            a0.a = "music_artist";
            a0.b = String.valueOf(mediaAttachInfo0.d);
        }
        else if(MediaAttachType.h.equals(mediaAttachType0)) {
            a0.a = "video";
            a0.b = String.valueOf(mediaAttachInfo0.f);
        }
        else if(MediaAttachType.g.equals(mediaAttachType0) || MediaAttachType.f.equals(mediaAttachType0)) {
            a0.a = "image";
            a0.b = mediaAttachInfo0.h;
        }
        else if(MediaAttachType.i.equals(mediaAttachType0)) {
            a0.a = "link_video";
            a0.b = mediaAttachInfo0.h;
            a0.c = mediaAttachInfo0.E;
            a0.d = mediaAttachInfo0.g;
            a0.e = mediaAttachInfo0.T;
            a0.f = mediaAttachInfo0.V;
        }
        else if(MediaAttachType.j.equals(mediaAttachType0)) {
            a0.a = "kakao_emoticon";
            a0.b = mediaAttachInfo0.X;
        }
        else {
            LogU.e("CmtAttachType", "getCmtAttachValue() unknown type: " + mediaAttachInfo0);
        }
        LogU.d("CmtAttachType", "getCmtAttachValue() " + a0);
        return a0;
    }

    public static String c(int v) {
        if(v == 0) {
            return "ALL";
        }
        switch(v) {
            case 1: {
                return "19";
            }
            case 2: {
                return "15";
            }
            case 3: {
                return "12";
            }
            default: {
                return null;
            }
        }
    }
}

