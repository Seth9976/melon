package hd;

import Bc.a;
import Cc.H3;
import Cc.N1;
import Cc.c1;
import Cc.e0;
import De.I;
import Kd.g;
import M.n0;
import M.p0;
import P0.h;
import P0.j;
import Q1.c;
import T.e;
import Vc.A;
import android.content.Context;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.y;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.l1;
import com.iloen.melon.net.v6x.response.ForUMixInfoBase;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistMvInfo;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistRcmTrackInfo.ArtistRecmInfo.MusicDnaSongInfo;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistRcmTrackInfo.ArtistRecmInfo;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistRcmTrackInfo;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistRecentAlbumInfo;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistTopDetail;
import com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistTopSong3Info;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.SongInfoBase;
import ed.D;
import ed.s;
import gd.R7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import m0.b;
import r0.i;
import r0.n;
import wc.u;
import we.k;
import y0.M;

public abstract class f0 {
    public static final void a(A1 a10, int v, b b0, k k0, l l0, int v1) {
        a a2;
        a a1;
        g g3;
        String s35;
        String s34;
        String s33;
        String s32;
        String s31;
        String s30;
        String s29;
        String s28;
        a a0;
        g g1;
        String s21;
        String s20;
        String s19;
        String s18;
        String s17;
        int v5;
        String s5;
        String s4;
        String s3;
        String s16;
        String s15;
        String s14;
        String s13;
        String s12;
        String s11;
        String s9;
        String s8;
        String s7;
        String s1;
        q.g(a10, "uiState");
        String s = a10.e;
        q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(0x2F036661);
        int v2 = (p0.i(a10) ? 4 : 2) | v1 | (p0.i(b0) ? 0x100 : 0x80);
        if((v1 & 0xC00) == 0) {
            v2 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if(p0.Q(v2 & 1, (v2 & 0x493) != 1170)) {
            n n0 = n.a;
            r0.q q0 = d5.n.o(d.o(androidx.compose.foundation.layout.a.n(n0, 11.0f, 0.0f, 0.0f, 0.0f, 14), 300.0f, 375.0f), e.b(4.0f));
            y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
            T.d d0 = e.b(4.0f);
            r0.q q1 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q0, y0.a, y0.b, d0), e0.T(p0, 0x7F060142), M.a);  // color:gray030s
            i i0 = r0.d.a;
            N0.M m0 = M.p.d(i0, false);
            int v3 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O) {
                s1 = s;
                A7.d.q(v3, p0, v3, h2);
            }
            else {
                s1 = s;
                if(!q.b(p0.N(), v3)) {
                    A7.d.q(v3, p0, v3, h2);
                }
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            N0.M m1 = M.p.d(i0, false);
            int v4 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, d.c);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q3, h3);
            String s2 = "";
            List list0 = je.w.a;
            switch(v) {
                case 0: {
                    s5 = "";
                    ArtistTopSong3Info musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 = a10.g;
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 == null) {
                        s4 = "";
                    }
                    else {
                        String s6 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.title;
                        s4 = s6 == null ? "" : s6;
                    }
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 == null) {
                        s7 = "";
                    }
                    else {
                        s7 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.subTitle1;
                        if(s7 == null) {
                            s7 = "";
                        }
                    }
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 == null) {
                        s8 = "";
                    }
                    else {
                        s8 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.detailImg;
                        if(s8 == null) {
                            s8 = "";
                        }
                    }
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 == null) {
                        s9 = s7;
                    }
                    else {
                        ArrayList arrayList0 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.songList;
                        if(arrayList0 == null) {
                            s9 = s7;
                        }
                        else {
                            s9 = s7;
                            list0 = je.p.K0(3, arrayList0);
                        }
                    }
                    s2 = s8;
                    v5 = list0.size();
                    s3 = s9;
                    break;
                }
                case 1: {
                    ArtistRecentAlbumInfo musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0 = a10.h;
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0 == null) {
                        s4 = "";
                    }
                    else {
                        String s10 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0.title;
                        s4 = s10 == null ? "" : s10;
                    }
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0 == null) {
                        s11 = "";
                    }
                    else {
                        s11 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0.subTitle1;
                        if(s11 == null) {
                            s11 = "";
                        }
                    }
                    s5 = "";
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0 == null) {
                        s12 = "";
                    }
                    else {
                        s12 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0.detailImg;
                        if(s12 == null) {
                            s12 = "";
                        }
                    }
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0 == null) {
                        s13 = s12;
                    }
                    else {
                        ArrayList arrayList1 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRecentAlbumInfo0.albumList;
                        if(arrayList1 == null) {
                            s13 = s12;
                        }
                        else {
                            s13 = s12;
                            list0 = je.p.K0(3, arrayList1);
                        }
                    }
                    v5 = list0.size();
                    s3 = s11;
                    s2 = s13;
                    break;
                }
                case 2: {
                    ArtistRcmTrackInfo musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0 = a10.i;
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0 == null) {
                        s4 = "";
                    }
                    else {
                        s4 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0.title;
                        if(s4 == null) {
                            s4 = "";
                        }
                    }
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0 == null) {
                        s14 = "";
                    }
                    else {
                        s14 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0.subTitle1;
                        if(s14 == null) {
                            s14 = "";
                        }
                    }
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0 == null) {
                        s15 = "";
                    }
                    else {
                        s15 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0.detailImg;
                        if(s15 == null) {
                            s15 = "";
                        }
                    }
                    if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0 == null) {
                        s16 = s15;
                    }
                    else {
                        ArrayList arrayList2 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo0.artistRecmInfoList;
                        if(arrayList2 == null) {
                            s16 = s15;
                        }
                        else {
                            s16 = s15;
                            list0 = je.p.K0(3, arrayList2);
                        }
                    }
                    v5 = list0.size();
                    s5 = "";
                    s3 = s14;
                    s2 = s16;
                    break;
                }
                default: {
                    s3 = "";
                    s4 = "";
                    s5 = "";
                    v5 = 0;
                }
            }
            f0.e(s4, s3, s2, p0, 0);
            M.y y1 = M.w.a(M.j.c, (v5 == 1 ? r0.d.n : r0.d.m), p0, 0);
            int v6 = p0.P;
            i0 i02 = p0.m();
            r0.q q4 = r0.a.d(p0, n0);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q4, h3);
            g g0 = null;
            if(v5 == 1) {
                p0.a0(0x854DF906);
                switch(v) {
                    case 0: {
                        Object object1 = list0.get(0);
                        q.e(object1, "null cannot be cast to non-null type com.melon.net.res.common.SongInfoBase");
                        g1 = Kd.h.c(((SongInfoBase)object1));
                        s17 = s1;
                        s18 = "";
                        s19 = "";
                        s20 = "";
                        s21 = "";
                        a0 = null;
                        break;
                    }
                    case 1: {
                        Object object2 = list0.get(0);
                        q.e(object2, "null cannot be cast to non-null type com.melon.net.res.common.AlbumInfoBase");
                        a0 = c.V(((AlbumInfoBase)object2));
                        s17 = s1;
                        s18 = "";
                        s19 = "";
                        s20 = "";
                        s21 = "";
                        g1 = null;
                        break;
                    }
                    default: {
                        if(v == 2) {
                            Object object0 = list0.get(0);
                            q.e(object0, "null cannot be cast to non-null type com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistRcmTrackInfo.ArtistRecmInfo");
                            MusicDnaSongInfo musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo$ArtistRecmInfo$MusicDnaSongInfo0 = ((ArtistRecmInfo)object0).songInfo;
                            q.f(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo$ArtistRecmInfo$MusicDnaSongInfo0, "songInfo");
                            g g2 = Kd.h.c(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo$ArtistRecmInfo$MusicDnaSongInfo0);
                            String s22 = ((ArtistRecmInfo)object0).songInfo.mainArtistName;
                            if(s22 != null && s22.length() != 0) {
                                g2 = g.a(g2, ((ArtistRecmInfo)object0).songInfo.mainArtistName, false, false, 0xEFFFFF);
                            }
                            String s23 = ((ArtistRecmInfo)object0).categoryCode;
                            q.f(s23, "categoryCode");
                            String s24 = ((ArtistRecmInfo)object0).categoryName;
                            q.f(s24, "categoryName");
                            String s25 = ((ArtistRecmInfo)object0).songInfo.coverImgPath;
                            q.f(s25, "coverImgPath");
                            String s26 = ((ArtistRecmInfo)object0).songInfo.mainArtistImg;
                            q.f(s26, "mainArtistImg");
                            String s27 = ((ArtistRecmInfo)object0).songInfo.mainArtistName;
                            q.f(s27, "mainArtistName");
                            s19 = s24;
                            g1 = g2;
                            s17 = s27;
                            s18 = s23;
                            s20 = s25;
                            s21 = s26;
                        }
                        else {
                            s17 = s1;
                            s18 = "";
                            s19 = "";
                            s20 = "";
                            s21 = "";
                            g1 = null;
                        }
                        a0 = null;
                    }
                }
                f0.f(v, g1, a0, a10.d, s17, s18, s19, true, "1", s20, s21, k0, p0, 0x6C00006, v2 >> 6 & 0x70, 0);
            }
            else if(v5 > 1) {
                p0.a0(0x85752811);
                r0.q q5 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 0.0f, 20.0f, 0.0f, 10);
                p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
                int v7 = p0.P;
                i0 i03 = p0.m();
                r0.q q6 = r0.a.d(p0, q5);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, p00, h0);
                w.x(p0, i03, h1);
                if(p0.O || !q.b(p0.N(), v7)) {
                    A7.d.q(v7, p0, v7, h2);
                }
                w.x(p0, q6, h3);
                switch(v) {
                    case 0: {
                        Object object3 = list0.get(0);
                        q.e(object3, "null cannot be cast to non-null type com.melon.net.res.common.SongInfoBase");
                        g g4 = Kd.h.c(((SongInfoBase)object3));
                        Object object4 = list0.get(1);
                        q.e(object4, "null cannot be cast to non-null type com.melon.net.res.common.SongInfoBase");
                        g3 = g4;
                        s28 = s1;
                        s29 = "";
                        s31 = "";
                        s32 = "";
                        s33 = "";
                        s34 = "";
                        s35 = "";
                        a1 = null;
                        a2 = null;
                        g0 = Kd.h.c(((SongInfoBase)object4));
                        s30 = "";
                        break;
                    }
                    case 1: {
                        Object object5 = list0.get(0);
                        q.e(object5, "null cannot be cast to non-null type com.melon.net.res.common.AlbumInfoBase");
                        a a3 = c.V(((AlbumInfoBase)object5));
                        Object object6 = list0.get(1);
                        q.e(object6, "null cannot be cast to non-null type com.melon.net.res.common.AlbumInfoBase");
                        a1 = a3;
                        a2 = c.V(((AlbumInfoBase)object6));
                        s28 = s1;
                        s29 = "";
                        s30 = "";
                        s31 = "";
                        s32 = "";
                        s33 = "";
                        s34 = "";
                        s35 = "";
                        g3 = null;
                        break;
                    }
                    case 2: {
                        Object object7 = list0.get(0);
                        q.e(object7, "null cannot be cast to non-null type com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistRcmTrackInfo.ArtistRecmInfo");
                        MusicDnaSongInfo musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo$ArtistRecmInfo$MusicDnaSongInfo1 = ((ArtistRecmInfo)object7).songInfo;
                        q.f(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo$ArtistRecmInfo$MusicDnaSongInfo1, "songInfo");
                        g g5 = Kd.h.c(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo$ArtistRecmInfo$MusicDnaSongInfo1);
                        String s36 = ((ArtistRecmInfo)object7).songInfo.mainArtistName;
                        if(s36 != null && s36.length() != 0) {
                            g5 = g.a(g5, ((ArtistRecmInfo)object7).songInfo.mainArtistName, false, false, 0xEFFFFF);
                        }
                        String s37 = ((ArtistRecmInfo)object7).categoryCode;
                        q.f(s37, "categoryCode");
                        s32 = ((ArtistRecmInfo)object7).categoryName;
                        q.f(s32, "categoryName");
                        String s38 = ((ArtistRecmInfo)object7).songInfo.coverImgPath;
                        q.f(s38, "coverImgPath");
                        String s39 = ((ArtistRecmInfo)object7).songInfo.mainArtistImg;
                        q.f(s39, "mainArtistImg");
                        String s40 = ((ArtistRecmInfo)object7).songInfo.mainArtistName;
                        q.f(s40, "mainArtistName");
                        Object object8 = list0.get(1);
                        q.e(object8, "null cannot be cast to non-null type com.melon.net.res.MusicDnaMonthlyLogRes.RESPONSE.ArtistTopInfo.ArtistRcmTrackInfo.ArtistRecmInfo");
                        MusicDnaSongInfo musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo$ArtistRecmInfo$MusicDnaSongInfo2 = ((ArtistRecmInfo)object8).songInfo;
                        q.f(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo$ArtistRecmInfo$MusicDnaSongInfo2, "songInfo");
                        g g6 = Kd.h.c(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistRcmTrackInfo$ArtistRecmInfo$MusicDnaSongInfo2);
                        String s41 = ((ArtistRecmInfo)object8).songInfo.mainArtistName;
                        if(s41 != null && s41.length() != 0) {
                            g6 = g.a(g6, ((ArtistRecmInfo)object8).songInfo.mainArtistName, false, false, 0xEFFFFF);
                        }
                        String s42 = ((ArtistRecmInfo)object8).categoryCode;
                        q.f(s42, "categoryCode");
                        String s43 = ((ArtistRecmInfo)object8).categoryName;
                        q.f(s43, "categoryName");
                        String s44 = ((ArtistRecmInfo)object8).songInfo.coverImgPath;
                        q.f(s44, "coverImgPath");
                        String s45 = ((ArtistRecmInfo)object8).songInfo.mainArtistImg;
                        q.f(s45, "mainArtistImg");
                        String s46 = ((ArtistRecmInfo)object8).songInfo.mainArtistName;
                        q.f(s46, "mainArtistName");
                        s5 = s42;
                        s35 = s45;
                        s1 = s46;
                        s34 = s39;
                        s28 = s40;
                        a1 = null;
                        a2 = null;
                        g0 = g6;
                        s33 = s38;
                        s30 = s44;
                        s29 = s43;
                        g3 = g5;
                        s31 = s37;
                        break;
                    }
                    default: {
                        s28 = s1;
                        s29 = "";
                        s30 = "";
                        s31 = "";
                        s32 = "";
                        s33 = "";
                        s34 = "";
                        s35 = "";
                        g3 = null;
                        a1 = null;
                        a2 = null;
                    }
                }
                int v8 = v2 >> 6 & 0x70;
                f0.f(v, g3, a1, a10.d, s28, s31, s32, false, "1", s33, s34, k0, p0, 0x6C00006, v8, 0);
                M.c.d(p0, d.q(n0, 10.0f));
                f0.f(v, g0, a2, a10.d, s1, s5, s29, false, "2", s30, s35, k0, p0, 0x6C00006, v8, 0);
                p0.p(true);
            }
            else {
                p0.a0(-2072291009);
            }
            p0.p(false);
            l1.x(1.0f, true, p0);
            b0.invoke(p0, ((int)(v2 >> 6 & 14)));
            p0.p(true);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new H3(a10, v, b0, k0, v1, 18);
        }
    }

    public static final void b(r0.q q0, A1 a10, boolean z, k k0, l l0, int v) {
        C0.c c0;
        String s3;
        String s2;
        String s1;
        h h4;
        P0.i i4;
        V v8;
        V v7;
        u u1;
        q.g(a10, "uiState");
        ArtistTopDetail musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0 = a10.f;
        q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(-1777698007);
        int v1 = (v & 6) == 0 ? (p0.g(q0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v1 |= (p0.i(a10) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v1 |= (p0.h(z) ? 0x100 : 0x80);
        }
        if((v & 0xC00) == 0) {
            v1 |= (p0.i(k0) ? 0x800 : 0x400);
        }
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            boolean z1 = a10.a;
            long v2 = e0.T(p0, 0x7F0604A1);  // color:white000e
            long v3 = M.c(ColorUtils.getColorFromHexStr("#8C2CFF"));
            e0.T(p0, 0x7F060153);  // color:gray200e
            if(z1) {
                p0.a0(1840910515);
                v2 = e0.T(p0, 0x7F06016A);  // color:gray900e
                v3 = M.c(ColorUtils.getColorFromHexStr("#73F4DE"));
                e0.T(p0, 0x7F06048A);  // color:transparent
            }
            else {
                p0.a0(0x6D828A79);
            }
            p0.p(false);
            long v4 = e0.T(p0, 0x7F06014D);  // color:gray125e
            float f = 225.0f;
            float f1 = 112.0f;
            if(z) {
                f = 240.0f;
                f1 = 122.0f;
            }
            r0.q q1 = d5.n.o(q0, e.b(4.0f));
            u u0 = M.a;
            r0.q q2 = androidx.compose.foundation.q.f(q1, v3, u0);
            N0.M m0 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i00 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            P0.k.y.getClass();
            i i0 = r0.d.a;
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O) {
                u1 = u0;
                A7.d.q(v5, p0, v5, h2);
            }
            else {
                u1 = u0;
                if(!q.b(p0.N(), v5)) {
                    A7.d.q(v5, p0, v5, h2);
                }
            }
            h h3 = j.d;
            w.x(p0, q3, h3);
            r0.q q4 = d.n(n.a, 280.0f);
            i i2 = r0.d.c;
            r0.q q5 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, i2);
            n n0 = n.a;
            s s0 = p0.N();
            androidx.compose.foundation.layout.b b0 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false));
            V v6 = androidx.compose.runtime.k.a;
            if(s0 == v6) {
                v7 = v6;
                s0 = new s(27);
                p0.l0(s0);
            }
            else {
                v7 = v6;
            }
            c1.n(X0.n.b(q5, s0), (musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0 == null ? null : musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0.bgImg), null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0xC00, 0, 0x7FF4);
            N0.i i3 = N0.j.b;
            r0.q q6 = b0.a(d.o(androidx.compose.foundation.layout.a.h(androidx.compose.foundation.layout.a.n(n0, 0.0f, f1, 0.0f, 0.0f, 13), 10.0f, 0.0f, 2), f, f), i2);
            T.d d0 = e.a;
            r0.q q7 = r0.a.a(androidx.compose.foundation.q.f(d5.n.o(q6, d0), v3, u1), new Ac.l(24, k0, a10));
            boolean z2 = p0.i(a10);
            boolean z3 = p0.i(context0);
            R7 r70 = p0.N();
            if(z2 || z3) {
                v8 = v7;
                r70 = new R7(a10, context0);
                p0.l0(r70);
            }
            else {
                v8 = v7;
                if(r70 == v8) {
                    r70 = new R7(a10, context0);
                    p0.l0(r70);
                }
            }
            r0.q q8 = X0.n.b(q7, r70);
            N0.M m1 = M.p.d(i0, false);
            int v9 = p0.P;
            i0 i01 = p0.m();
            r0.q q9 = r0.a.d(p0, q8);
            p0.e0();
            if(p0.O) {
                i4 = i1;
                p0.l(i4);
            }
            else {
                i4 = i1;
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(!p0.O && q.b(p0.N(), v9)) {
                h4 = h2;
            }
            else {
                h4 = h2;
                A7.d.q(v9, p0, v9, h4);
            }
            w.x(p0, q9, h3);
            r0.q q10 = androidx.compose.foundation.q.f(d5.n.o(b0.a(d.c, r0.d.e), d0), v4, u1);
            androidx.compose.foundation.q.c(I.Q(0x7F0807A1, p0, 6), null, q10, null, N0.j.f, 0.0f, null, p0, 0x6030, 104);  // drawable:noimage_person_xlarge_dark
            r0.q q11 = d5.n.o(d.c, d0);
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0 == null) {
                s1 = "";
            }
            else {
                s1 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0.artistImg;
                if(s1 == null) {
                    s1 = "";
                }
            }
            c1.n(q11, s1, null, i3, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, 0x6C00, 0, 0x7FE4);
            p0.p(true);
            r0.q q12 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 26.0f, 20.0f, 0.0f, 8);
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v10 = p0.P;
            i0 i02 = p0.m();
            r0.q q13 = r0.a.d(p0, q12);
            p0.e0();
            if(p0.O) {
                p0.l(i4);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h4);
            }
            w.x(p0, q13, h3);
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0 == null) {
                s2 = "";
            }
            else {
                s2 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0.title;
                if(s2 == null) {
                    s2 = "";
                }
            }
            e1.y y1 = e1.y.i;
            N1.b(s2, null, v2, 15.0f, y1, null, 0L, null, 18.0f, 2, false, 2, 0, null, null, p0, 0x30C00, 0xC36, 0x1D3D2);
            r0.q q14 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 10.0f, 0.0f, 0.0f, 13);
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0 == null) {
                s3 = "";
            }
            else {
                s3 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0.artistName;
                if(s3 == null) {
                    s3 = "";
                }
            }
            N1.b(s3, q14, v2, 34.0f, y1, null, 0L, null, 0.0f, 2, false, 2, 0, null, null, p0, 0x30C30, 0xC30, 0x1D7D0);
            p0.p(true);
            r0.q q15 = b0.a(androidx.compose.foundation.layout.a.n(n0, 17.0f, 0.0f, 20.0f, 14.0f, 2), r0.d.g);
            p0 p00 = n0.a(M.j.a, r0.d.k, p0, 0x30);
            int v11 = p0.P;
            i0 i03 = p0.m();
            r0.q q16 = r0.a.d(p0, q15);
            p0.e0();
            if(p0.O) {
                p0.l(i4);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, h0);
            w.x(p0, i03, h1);
            if(p0.O || !q.b(p0.N(), v11)) {
                A7.d.q(v11, p0, v11, h4);
            }
            w.x(p0, q16, h3);
            if(z1) {
                p0.a0(-1127583005);
                c0 = I.Q(0x7F08042C, p0, 6);  // drawable:ic_dna_streamings_black
            }
            else {
                p0.a0(0xBCCBFE23);
                c0 = I.Q(0x7F08042D, p0, 6);  // drawable:ic_dna_streamings_white
            }
            p0.p(false);
            androidx.compose.foundation.q.c(c0, null, null, null, N0.j.g, 0.0f, null, p0, 0x6030, 108);
            String s4 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0 == null ? null : musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopDetail0.listenCnt;
            q.f("%s 스트리밍", "getString(...)");
            String s5 = String.format("%s 스트리밍", Arrays.copyOf(new Object[]{StringUtils.getCountString(s4, 0x1869F)}, 1));
            r0.q q17 = androidx.compose.foundation.layout.a.n(n0, 3.0f, 0.0f, 0.0f, 0.0f, 14);
            boolean z4 = p0.i(context0);
            boolean z5 = p0.g(s4);
            Y y2 = p0.N();
            if(z4 || z5 || y2 == v8) {
                y2 = new Y(context0, s4, 0);
                p0.l0(y2);
            }
            N1.b(s5, X0.n.c(q17, false, y2), v2, 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Ac.c(q0, a10, z, k0, v, 7);
        }
    }

    public static final void c(A1 a10, b b0, k k0, l l0, int v) {
        V v12;
        int v10;
        V v8;
        List list0;
        String s2;
        String s1;
        r0.g g0 = r0.d.m;
        q.g(a10, "uiState");
        ArtistMvInfo musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0 = a10.j;
        q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(0xB23EAAA1);
        int v1 = (p0.i(a10) ? 4 : 2) | v | (p0.i(b0) ? 0x20 : 16);
        if((v & 0x180) == 0) {
            v1 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            n n0 = n.a;
            r0.q q0 = d5.n.o(d.o(androidx.compose.foundation.layout.a.n(n0, 11.0f, 0.0f, 0.0f, 0.0f, 14), 300.0f, 375.0f), e.b(4.0f));
            y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
            T.d d0 = e.b(4.0f);
            r0.q q1 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q0, y0.a, y0.b, d0), e0.T(p0, 0x7F060142), M.a);  // color:gray030s
            i i0 = r0.d.a;
            N0.M m0 = M.p.d(i0, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            N0.M m1 = M.p.d(i0, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, d.c);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            String s = "";
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0 == null) {
                s1 = "";
            }
            else {
                s1 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0.title;
                if(s1 == null) {
                    s1 = "";
                }
            }
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0 == null) {
                s2 = "";
            }
            else {
                s2 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0.subTitle1;
                if(s2 == null) {
                    s2 = "";
                }
            }
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0 != null) {
                String s3 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0.detailImg;
                if(s3 != null) {
                    s = s3;
                }
            }
            f0.e(s1, s2, s, p0, 0);
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0 == null) {
                list0 = null;
            }
            else {
                ArrayList arrayList0 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistMvInfo0.mvList;
                list0 = arrayList0 == null ? null : je.p.K0(3, arrayList0);
            }
            int v4 = list0 == null ? 0 : list0.size();
            V v5 = androidx.compose.runtime.k.a;
            if(v4 == 1) {
                p0.a0(1804982621);
                r0.q q10 = d.f(androidx.compose.foundation.layout.a.n(n0, 20.0f, 129.0f, 20.0f, 0.0f, 8), 1.0f);
                M.y y3 = M.w.a(M.j.c, g0, p0, 0);
                int v13 = p0.P;
                i0 i05 = p0.m();
                r0.q q11 = r0.a.d(p0, q10);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, y3, h0);
                w.x(p0, i05, h1);
                if(p0.O || !q.b(p0.N(), v13)) {
                    A7.d.q(v13, p0, v13, h2);
                }
                w.x(p0, q11, h3);
                N0.M m2 = M.p.d(i0, false);
                int v14 = p0.P;
                i0 i06 = p0.m();
                r0.q q12 = r0.a.d(p0, n0);
                p0.e0();
                if(p0.O) {
                    p0.l(i1);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m2, h0);
                w.x(p0, i06, h1);
                if(p0.O || !q.b(p0.N(), v14)) {
                    A7.d.q(v14, p0, v14, h2);
                }
                w.x(p0, q12, h3);
                q.d(list0);
                Object object3 = list0.get(0);
                q.f(object3, "get(...)");
                Bc.i i5 = Bc.j.b(((MvInfoBase)object3));
                boolean z7 = p0.i(i5);
                boolean z8 = p0.i(a10);
                X x2 = p0.N();
                if(((v1 & 0x380) == 0x100 | z7 | z8) != 0 || x2 == v5) {
                    x2 = new X(k0, i5, a10, 0);
                    p0.l0(x2);
                }
                hd.a.d(i5, x2, p0, 0);
                p0.p(true);
                l1.x(1.0f, true, p0);
                b0.invoke(p0, ((int)(v1 >> 3 & 14)));
                p0.p(true);
                p0.p(false);
            }
            else {
                switch(v4) {
                    case 2: {
                        p0.a0(1806100698);
                        r0.q q4 = d.f(androidx.compose.foundation.layout.a.n(n0, 20.0f, 129.0f, 20.0f, 0.0f, 8), 1.0f);
                        M.y y1 = M.w.a(M.j.c, g0, p0, 0);
                        int v6 = p0.P;
                        i0 i02 = p0.m();
                        r0.q q5 = r0.a.d(p0, q4);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i1);
                        }
                        else {
                            p0.o0();
                        }
                        w.x(p0, y1, h0);
                        w.x(p0, i02, h1);
                        if(p0.O || !q.b(p0.N(), v6)) {
                            A7.d.q(v6, p0, v6, h2);
                        }
                        w.x(p0, q5, h3);
                        r0.q q6 = d.h(n0, 170.0f);
                        p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
                        int v7 = p0.P;
                        i0 i03 = p0.m();
                        r0.q q7 = r0.a.d(p0, q6);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i1);
                        }
                        else {
                            p0.o0();
                        }
                        w.x(p0, p00, h0);
                        w.x(p0, i03, h1);
                        if(p0.O || !q.b(p0.N(), v7)) {
                            A7.d.q(v7, p0, v7, h2);
                        }
                        w.x(p0, q7, h3);
                        q.d(list0);
                        Object object0 = list0.get(0);
                        q.f(object0, "get(...)");
                        Bc.i i2 = Bc.j.b(((MvInfoBase)object0));
                        Object object1 = list0.get(1);
                        q.f(object1, "get(...)");
                        Bc.i i3 = Bc.j.b(((MvInfoBase)object1));
                        boolean z = p0.i(i2);
                        boolean z1 = p0.i(a10);
                        X x0 = p0.N();
                        if(((v1 & 0x380) == 0x100 | z | z1) == 0) {
                            v8 = v5;
                            if(x0 == v8) {
                                x0 = new X(k0, i2, a10, 1);
                                p0.l0(x0);
                            }
                        }
                        else {
                            v8 = v5;
                            x0 = new X(k0, i2, a10, 1);
                            p0.l0(x0);
                        }
                        hd.a.b(i2, x0, p0, 0);
                        M.c.d(p0, d.q(n0, 10.0f));
                        boolean z2 = p0.i(i3);
                        boolean z3 = p0.i(a10);
                        X x1 = p0.N();
                        if(((v1 & 0x380) == 0x100 | z2 | z3) != 0 || x1 == v8) {
                            x1 = new X(k0, i3, a10, 2);
                            p0.l0(x1);
                        }
                        hd.a.b(i3, x1, p0, 0);
                        p0.p(true);
                        l1.x(1.0f, true, p0);
                        b0.invoke(p0, ((int)(v1 >> 3 & 14)));
                        p0.p(true);
                        p0.p(false);
                        break;
                    }
                    case 3: {
                        p0.a0(1807937014);
                        r0.q q8 = d.f(androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.g), 20.0f, 0.0f, 20.0f, 0.0f, 10), 1.0f);
                        M.y y2 = M.w.a(M.j.c, g0, p0, 0);
                        int v9 = p0.P;
                        i0 i04 = p0.m();
                        r0.q q9 = r0.a.d(p0, q8);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i1);
                        }
                        else {
                            p0.o0();
                        }
                        w.x(p0, y2, h0);
                        w.x(p0, i04, h1);
                        if(p0.O || !q.b(p0.N(), v9)) {
                            A7.d.q(v9, p0, v9, h2);
                        }
                        w.x(p0, q9, h3);
                        if(list0 == null) {
                            p0.a0(-930329419);
                            p0.p(false);
                            v10 = v1;
                        }
                        else {
                            p0.a0(-930329418);
                            int v11 = 0;
                            for(Object object2: list0) {
                                if(v11 >= 0) {
                                    q.d(((MvInfoBase)object2));
                                    Bc.i i4 = Bc.j.b(((MvInfoBase)object2));
                                    String s4 = String.valueOf(v11 + 1);
                                    boolean z4 = p0.i(i4);
                                    boolean z5 = p0.i(a10);
                                    boolean z6 = p0.g(s4);
                                    A a0 = p0.N();
                                    if(((v1 & 0x380) == 0x100 | z4 | z5 | z6) != 0 || a0 == v5) {
                                        v12 = v5;
                                        A a1 = new A(k0, i4, a10, s4, 5);
                                        p0.l0(a1);
                                        a0 = a1;
                                    }
                                    else {
                                        v12 = v5;
                                    }
                                    hd.a.c(i4, a0, p0, 0);
                                    ++v11;
                                    v5 = v12;
                                    continue;
                                }
                                e.k.O();
                                throw null;
                            }
                            v10 = v1;
                            p0.p(false);
                        }
                        b0.invoke(p0, ((int)(v10 >> 3 & 14)));
                        p0.p(true);
                        p0.p(false);
                        break;
                    }
                    default: {
                        p0.a0(1775706965);
                        p0.p(false);
                    }
                }
            }
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b0(a10, b0, k0, v, 0);
        }
    }

    public static final void d(A1 a10, b b0, k k0, l l0, int v) {
        int v5;
        List list0;
        String s2;
        String s1;
        q.g(a10, "uiState");
        ArtistTopSong3Info musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 = a10.g;
        q.g(k0, "onEvent");
        p p0 = (p)l0;
        p0.c0(0xDB3DAF4D);
        int v1 = (p0.i(a10) ? 4 : 2) | v | (p0.i(b0) ? 0x20 : 16);
        if((v & 0x180) == 0) {
            v1 |= (p0.i(k0) ? 0x100 : 0x80);
        }
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            n n0 = n.a;
            r0.q q0 = d5.n.o(d.o(androidx.compose.foundation.layout.a.n(n0, 11.0f, 0.0f, 0.0f, 0.0f, 14), 300.0f, 375.0f), e.b(4.0f));
            y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F06014A), 0.5f);  // color:gray100a
            T.d d0 = e.b(4.0f);
            r0.q q1 = androidx.compose.foundation.q.f(androidx.compose.foundation.q.j(q0, y0.a, y0.b, d0), e0.T(p0, 0x7F060142), M.a);  // color:gray030s
            i i0 = r0.d.a;
            N0.M m0 = M.p.d(i0, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i1 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, m0, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q2, h3);
            N0.M m1 = M.p.d(i0, false);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, d.c);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            String s = "";
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 == null) {
                s1 = "";
            }
            else {
                s1 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.title;
                if(s1 == null) {
                    s1 = "";
                }
            }
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 == null) {
                s2 = "";
            }
            else {
                s2 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.subTitle1;
                if(s2 == null) {
                    s2 = "";
                }
            }
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 != null) {
                String s3 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.detailImg;
                if(s3 != null) {
                    s = s3;
                }
            }
            f0.e(s1, s2, s, p0, 0);
            if(musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0 == null) {
                list0 = null;
            }
            else {
                ArrayList arrayList0 = musicDnaMonthlyLogRes$RESPONSE$ArtistTopInfo$ArtistTopSong3Info0.songList;
                list0 = arrayList0 == null ? null : je.p.K0(3, arrayList0);
            }
            r0.q q4 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 12.0f, 0.0f, 11);
            r0.q q5 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q4, r0.d.g);
            M.y y1 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v4 = p0.P;
            i0 i02 = p0.m();
            r0.q q6 = r0.a.d(p0, q5);
            p0.e0();
            if(p0.O) {
                p0.l(i1);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, h0);
            w.x(p0, i02, h1);
            if(p0.O || !q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h2);
            }
            w.x(p0, q6, h3);
            if(list0 == null) {
                p0.a0(-239604180);
                p0.p(false);
                v5 = v1;
            }
            else {
                p0.a0(-239604179);
                int v6 = 0;
                for(Object object0: list0) {
                    if(v6 >= 0) {
                        q.d(((SongInfoBase)object0));
                        g g0 = Kd.h.c(((SongInfoBase)object0));
                        String s4 = String.valueOf(v6 + 1);
                        boolean z = p0.i(g0);
                        boolean z1 = p0.i(a10);
                        boolean z2 = p0.g(s4);
                        c0 c00 = p0.N();
                        V v7 = androidx.compose.runtime.k.a;
                        if(((v1 & 0x380) == 0x100 | z | z1 | z2) != 0 || c00 == v7) {
                            c0 c01 = new c0(k0, g0, a10, s4, 0);
                            p0.l0(c01);
                            c00 = c01;
                        }
                        boolean z3 = p0.i(g0);
                        boolean z4 = p0.i(a10);
                        boolean z5 = p0.g(s4);
                        c0 c02 = p0.N();
                        if(((v1 & 0x380) == 0x100 | z3 | z4 | z5) != 0 || c02 == v7) {
                            c0 c03 = new c0(k0, g0, a10, s4, 1);
                            p0.l0(c03);
                            c02 = c03;
                        }
                        c1.P(g0, false, false, null, c00, c02, null, true, p0, 0xC00180, 0xFF4A);
                        ++v6;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                v5 = v1;
                p0.p(false);
            }
            b0.invoke(p0, ((int)(v5 >> 3 & 14)));
            p0.p(true);
            p0.p(true);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new b0(a10, b0, k0, v, 1);
        }
    }

    public static final void e(String s, String s1, String s2, l l0, int v) {
        p p0 = (p)l0;
        p0.c0(-2081530078);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.g(s2) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            n n0 = n.a;
            r0.q q0 = d.f(n0, 1.0f);
            p0 p00 = n0.a(M.j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            r0.q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            h h0 = j.f;
            w.x(p0, p00, h0);
            h h1 = j.e;
            w.x(p0, i00, h1);
            h h2 = j.g;
            if(p0.O || !q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h2);
            }
            h h3 = j.d;
            w.x(p0, q1, h3);
            r0.q q2 = androidx.compose.foundation.layout.a.n(n0, 20.0f, 26.0f, 10.0f, 0.0f, 8);
            M.y y0 = M.w.a(M.j.c, r0.d.m, p0, 0);
            int v3 = p0.P;
            i0 i01 = p0.m();
            r0.q q3 = r0.a.d(p0, q2);
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, h0);
            w.x(p0, i01, h1);
            if(p0.O || !q.b(p0.N(), v3)) {
                A7.d.q(v3, p0, v3, h2);
            }
            w.x(p0, q3, h3);
            N1.b(s, d.q(n0, 176.0f), e0.T(p0, 0x7F06016D), 24.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 & 14 | 0x30C30, 0xC30, 0x1D7D0);  // color:gray900s
            N1.b(s1, d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 2.0f, 0.0f, 0.0f, 13), 176.0f), e0.T(p0, 0x7F06016D), 24.0f, e1.y.i, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, v1 >> 3 & 14 | 0x30C30, 0xC30, 0x1D7D0);  // color:gray900s
            p0.p(true);
            l1.x(1.0f, true, p0);
            c1.n(d.n(androidx.compose.foundation.layout.a.n(n0, 0.0f, 15.0f, 10.0f, 0.0f, 9), 84.0f), s2, null, N0.j.b, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, p0, v1 >> 3 & 0x70 | 0xC06, 0, 0x7FF4);
            p0.p(true);
        }
        else {
            p0.T();
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Id.h(v, 23, s1, s2, s);
        }
    }

    public static final void f(int v, g g0, a a0, String s, String s1, String s2, String s3, boolean z, String s4, String s5, String s6, k k0, l l0, int v1, int v2, int v3) {
        String s18;
        boolean z3;
        String s17;
        g g3;
        String s16;
        boolean z2;
        a a2;
        int v12;
        String s15;
        String s14;
        String s32;
        String s31;
        String s30;
        String s29;
        g g5;
        boolean z7;
        String s28;
        String s27;
        a a3;
        int v18;
        p p1;
        V v17;
        String s24;
        String s23;
        g g4;
        n n1;
        String s22;
        String s21;
        String s20;
        H h13;
        H h12;
        H h11;
        int v16;
        H h7;
        int v11;
        int v9;
        int v8;
        int v7;
        int v6;
        int v5;
        String s7;
        int v4;
        q.g(k0, "onEvent");
        ((p)l0).c0(0x7FE499E7);
        if((v3 & 1) == 0) {
            v4 = (v1 & 6) == 0 ? (((p)l0).e(v) ? 4 : 2) | v1 : v1;
        }
        else {
            v4 = v1 | 6;
        }
        if((v3 & 2) != 0) {
            v4 |= 0x30;
        }
        else if((v1 & 0x30) == 0) {
            v4 |= (((p)l0).i(g0) ? 0x20 : 16);
        }
        if((v3 & 4) != 0) {
            v4 |= 0x180;
        }
        else if((v1 & 0x180) == 0) {
            v4 |= (((p)l0).g(a0) ? 0x100 : 0x80);
        }
        if((v3 & 8) != 0) {
            v4 |= 0xC00;
        }
        else if((v1 & 0xC00) == 0) {
            v4 |= (((p)l0).g(s) ? 0x800 : 0x400);
        }
        if((v3 & 16) != 0) {
            v4 |= 0x6000;
        }
        else if((v1 & 0x6000) == 0) {
            v4 |= (((p)l0).g(s1) ? 0x4000 : 0x2000);
        }
        if((v3 & 0x20) == 0) {
            s7 = s2;
            if((v1 & 0x30000) == 0) {
                v4 |= (((p)l0).g(s7) ? 0x20000 : 0x10000);
            }
        }
        else {
            v4 |= 0x30000;
            s7 = s2;
        }
        if((v3 & 0x40) != 0) {
            v4 |= 0x180000;
        }
        else if((v1 & 0x180000) == 0) {
            v4 |= (((p)l0).g(s3) ? 0x100000 : 0x80000);
        }
        if((v3 & 0x80) != 0) {
            v4 |= 0xC00000;
            v5 = v3 & 0x80;
        }
        else if((v1 & 0xC00000) == 0) {
            v5 = v3 & 0x80;
            v4 |= (((p)l0).h(z) ? 0x800000 : 0x400000);
        }
        else {
            v5 = v3 & 0x80;
        }
        if((v3 & 0x100) != 0) {
            v4 |= 0x6000000;
            v6 = v3 & 0x100;
        }
        else if((v1 & 0x6000000) == 0) {
            v6 = v3 & 0x100;
            v4 |= (((p)l0).g(s4) ? 0x4000000 : 0x2000000);
        }
        else {
            v6 = v3 & 0x100;
        }
        if((v3 & 0x200) != 0) {
            v4 |= 0x30000000;
            v7 = v3 & 0x200;
        }
        else if((v1 & 0x30000000) == 0) {
            v7 = v3 & 0x200;
            v4 |= (((p)l0).g(s5) ? 0x20000000 : 0x10000000);
        }
        else {
            v7 = v3 & 0x200;
        }
        if((v3 & 0x400) != 0) {
            v8 = v2 | 6;
            v9 = v3 & 0x400;
        }
        else if((v2 & 6) == 0) {
            v9 = v3 & 0x400;
            v8 = v2 | (((p)l0).g(s6) ? 4 : 2);
        }
        else {
            v9 = v3 & 0x400;
            v8 = v2;
        }
        if((v2 & 0x30) == 0) {
            v8 |= (((p)l0).i(k0) ? 0x20 : 16);
        }
        if(((p)l0).Q(v4 & 1, (v4 & 306783379) != 306783378 || (v8 & 19) != 18)) {
            int v10 = (v3 & 1) == 0 ? v : 0;
            g g1 = (v3 & 2) == 0 ? g0 : null;
            a a1 = (v3 & 4) == 0 ? a0 : null;
            String s8 = (v3 & 8) == 0 ? s : "";
            String s9 = (v3 & 16) == 0 ? s1 : "";
            if((v3 & 0x20) != 0) {
                s7 = "";
            }
            boolean z1 = false;
            String s10 = (v3 & 0x40) == 0 ? s3 : "";
            if(v5 == 0) {
                z1 = z;
            }
            String s11 = v6 == 0 ? s4 : "";
            String s12 = v7 == 0 ? s5 : "";
            String s13 = v9 == 0 ? s6 : "";
            Context context0 = (Context)((p)l0).k(AndroidCompositionLocals_androidKt.b);
            r0.g g2 = r0.d.m;
            if(z1) {
                g2 = r0.d.n;
                v11 = 3;
            }
            else {
                v11 = 5;
            }
            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            h0.a = "";
            H h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            h1.a = "";
            H h2 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            H h3 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            switch(v10) {
                case 0: {
                    s16 = s13;
                    if(g1 == null) {
                        androidx.compose.runtime.n0 n00 = ((p)l0).t();
                        if(n00 != null) {
                            n00.d = new Z(0, null, a1, s8, s9, s7, s10, z1, s11, s12, s16, k0, v1, v2, v3, 0);
                            return;
                        }
                    }
                    else {
                        a2 = a1;
                        s14 = s9;
                        s18 = s7;
                        s15 = s10;
                        z2 = z1;
                        g3 = g1;
                        h0.a = g3.b;
                        String s19 = g3.G == null ? "" : g3.G;
                        h1.a = s19;
                        v12 = 0;
                        h2.a = new A0(g3, s8, s19, s11);
                        h3.a = new z0(g3, s8, ((String)h1.a), s11);
                        z3 = g3.i;
                        s17 = g3.e;
                        goto label_177;
                    }
                    break;
                }
                case 1: {
                    s16 = s13;
                    if(a1 == null) {
                        androidx.compose.runtime.n0 n01 = ((p)l0).t();
                        if(n01 != null) {
                            n01.d = new Z(1, g1, null, s8, s9, s7, s10, z1, s11, s12, s16, k0, v1, v2, v3, 1);
                            return;
                        }
                    }
                    else {
                        v12 = 1;
                        h0.a = a1.c;
                        h1.a = a1.d;
                        h2.a = new r0(a1.a, ((String)h0.a), s8, a1.d, s11);
                        h3.a = new t0(a1.a, ((String)h0.a), s8, ((String)h1.a), s11);
                        a2 = a1;
                        s14 = s9;
                        s18 = s7;
                        s15 = s10;
                        z2 = z1;
                        s17 = a1.b;
                        z3 = a1.f;
                        g3 = g1;
                        goto label_177;
                    }
                    break;
                }
                case 2: {
                    if(g1 == null) {
                        androidx.compose.runtime.n0 n02 = ((p)l0).t();
                        if(n02 != null) {
                            n02.d = new Z(2, null, a1, s8, s9, s7, s10, z1, s11, s12, s13, k0, v1, v2, v3, 2);
                            return;
                        }
                    }
                    else {
                        s16 = s13;
                        h0.a = s10;
                        h1.a = g1.G == null ? "" : g1.G;
                        s17 = g1.e;
                        h2.a = new B0(s8, s9, s7);
                        h3.a = new C0(s8, s9, s7);
                        v12 = 2;
                        a2 = a1;
                        s14 = s9;
                        s18 = s7;
                        s15 = s10;
                        z2 = z1;
                        z3 = g1.i;
                        g3 = g1;
                    label_177:
                        r0.q q0 = androidx.compose.foundation.layout.a.n(n.a, 0.0f, 129.0f, 0.0f, 0.0f, 13);
                        n n0 = n.a;
                        r0.q q1 = r0.a.a(q0, new hd.e0(k0, h2, 0));
                        r0.q q2 = z3 ? X0.n.c(q1, true, new com.iloen.melon.player.playlist.mixup.composables.c(context0, h0, h1)) : e2.a.r(q1, 0.3f);
                        p p0 = (p)l0;
                        M.y y0 = M.w.a(M.j.c, g2, p0, 0);
                        int v13 = p0.P;
                        i0 i00 = p0.m();
                        r0.q q3 = r0.a.d(p0, q2);
                        P0.k.y.getClass();
                        P0.i i0 = j.b;
                        p0.e0();
                        if(p0.O) {
                            p0.l(i0);
                        }
                        else {
                            p0.o0();
                        }
                        h h4 = j.f;
                        w.x(p0, y0, h4);
                        h h5 = j.e;
                        w.x(p0, i00, h5);
                        h h6 = j.g;
                        if(p0.O) {
                            h7 = h3;
                            A7.d.q(v13, p0, v13, h6);
                        }
                        else {
                            h7 = h3;
                            if(!q.b(p0.N(), v13)) {
                                A7.d.q(v13, p0, v13, h6);
                            }
                        }
                        h h8 = j.d;
                        w.x(p0, q3, h8);
                        N0.M m0 = M.p.d(r0.d.a, false);
                        int v14 = p0.P;
                        i0 i01 = p0.m();
                        r0.q q4 = r0.a.d(p0, n0);
                        p0.e0();
                        if(p0.O) {
                            p0.l(i0);
                        }
                        else {
                            p0.o0();
                        }
                        w.x(p0, m0, h4);
                        w.x(p0, i01, h5);
                        if(p0.O || !q.b(p0.N(), v14)) {
                            A7.d.q(v14, p0, v14, h6);
                        }
                        w.x(p0, q4, h8);
                        boolean z4 = q.b(s18, "A003");
                        V v15 = androidx.compose.runtime.k.a;
                        if(z4) {
                            p0.a0(0xF249FCF7);
                            ForUMixInfoBase forUMixInfoBase0 = p0.N();
                            if(forUMixInfoBase0 == v15) {
                                forUMixInfoBase0 = new ForUMixInfoBase();
                                forUMixInfoBase0.setContsTypeCode("N10078");
                                forUMixInfoBase0.setContsId("32");
                                ArrayList arrayList0 = new ArrayList();
                                arrayList0.add(s16);
                                forUMixInfoBase0.setMainImgUrls(arrayList0);
                                forUMixInfoBase0.setMainSubImgUrl(s12);
                                forUMixInfoBase0.setMainReplace(((String)h1.a));
                                p0.l0(forUMixInfoBase0);
                            }
                            boolean z5 = p0.i(forUMixInfoBase0);
                            Yc.h h9 = p0.N();
                            if(z5 || h9 == v15) {
                                h9 = new Yc.h(forUMixInfoBase0, 1);
                                p0.l0(h9);
                            }
                            boolean z6 = p0.i(forUMixInfoBase0);
                            Yc.h h10 = p0.N();
                            if(z6 || h10 == v15) {
                                h10 = new Yc.h(forUMixInfoBase0, 2);
                                p0.l0(h10);
                            }
                            androidx.compose.ui.viewinterop.a.a(h9, null, h10, p0, 0, 2);
                            p0.p(false);
                            v16 = v12;
                            h11 = h0;
                            h12 = h7;
                            h13 = h1;
                            s20 = s18;
                            s21 = s12;
                            s22 = s16;
                            n1 = n0;
                            g4 = g3;
                            s23 = s8;
                            s24 = s11;
                            v17 = v15;
                        }
                        else {
                            p0.a0(0xF25EFE22);
                            r0.q q5 = e0.K(d.h(d.q(n0, 125.0f), 125.0f));
                            n1 = n0;
                            v17 = v15;
                            s20 = s18;
                            g4 = g3;
                            v16 = v12;
                            h11 = h0;
                            h12 = h7;
                            s22 = s16;
                            h13 = h1;
                            s21 = s12;
                            s23 = s8;
                            s24 = s11;
                            Cc.r0.b.c(q5, s17, 125.0f, null, 0L, null, false, false, p0, 0x6000180, 0xF8);
                            p0.p(false);
                        }
                        if(z3) {
                            p0.a0(0xF26452FB);
                            r0.q q6 = r0.a.a(androidx.compose.foundation.layout.a.n((androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n1, r0.d.c), 0.0f, 6.0f, 6.0f, 0.0f, 9), new hd.e0(k0, h12, 1));
                            androidx.compose.foundation.q.c(I.Q(0x7F08015E, p0, 6), "앨범 재생", q6, null, N0.j.g, 0.0f, null, p0, 0x6000, 104);  // drawable:btn_common_play_01
                        }
                        else {
                            p0.a0(0xF0CAE39F);
                        }
                        p0.p(false);
                        p0.p(true);
                        r0.q q7 = d.q(androidx.compose.foundation.layout.a.n(n1, 0.0f, 8.0f, 0.0f, 0.0f, 13), 125.0f);
                        s s25 = p0.N();
                        if(s25 == v17) {
                            s25 = new s(25);
                            p0.l0(s25);
                        }
                        r0.q q8 = X0.n.b(q7, s25);
                        N1.b(((String)h11.a), q8, e0.T(p0, 0x7F06016D), 15.0f, null, null, 0L, new l1.k(v11), 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D5F0);  // color:gray900s
                        r0.q q9 = d.q(androidx.compose.foundation.layout.a.n(n1, 0.0f, 3.0f, 0.0f, 0.0f, 13), 125.0f);
                        s s26 = p0.N();
                        if(s26 == v17) {
                            s26 = new s(26);
                            p0.l0(s26);
                        }
                        r0.q q10 = X0.n.b(q9, s26);
                        p1 = p0;
                        N1.b((v16 == 2 ? "" : ((String)h13.a)), q10, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, new l1.k(v11), 0.0f, 2, false, 1, 0, null, null, p1, 0xC00, 0xC30, 0x1D5F0);  // color:gray600s_support_high_contrast
                        p1.p(true);
                        v18 = v16;
                        a3 = a2;
                        s27 = s14;
                        s28 = s15;
                        z7 = z2;
                        g5 = g4;
                        s29 = s23;
                        s7 = s20;
                        s30 = s24;
                        s31 = s21;
                        s32 = s22;
                        goto label_325;
                    }
                    break;
                }
                default: {
                    s14 = s9;
                    s15 = s10;
                    v12 = v10;
                    a2 = a1;
                    z2 = z1;
                    s16 = s13;
                    g3 = g1;
                    s17 = "";
                    z3 = true;
                    s18 = s7;
                    goto label_177;
                }
            }
        }
        else {
            ((p)l0).T();
            s29 = s;
            s27 = s1;
            z7 = z;
            s31 = s5;
            s32 = s6;
            v18 = v;
            p1 = (p)l0;
            g5 = g0;
            a3 = a0;
            s28 = s3;
            s30 = s4;
        label_325:
            androidx.compose.runtime.n0 n03 = p1.t();
            if(n03 != null) {
                n03.d = new Z(v18, g5, a3, s29, s27, s7, s28, z7, s30, s31, s32, k0, v1, v2, v3, 3);
            }
        }
    }

    public static final void g(float f, boolean z, int v, we.a a0, l l0, int v1, int v2) {
        boolean z2;
        float f1;
        q.g(a0, "action");
        p p0 = (p)l0;
        p0.c0(0x78FD1B8F);
        int v3 = (v2 & 1) == 0 ? (p0.d(f) ? 4 : 2) | v1 : v1 | 6;
        if((v2 & 2) != 0) {
            v3 |= 0x30;
        }
        else if((v1 & 0x30) == 0) {
            v3 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v1 & 0x180) == 0) {
            v3 |= (p0.e(v) ? 0x100 : 0x80);
        }
        int v4 = v3 | (p0.i(a0) ? 0x800 : 0x400);
        if(p0.Q(v4 & 1, (v4 & 0x493) != 1170)) {
            f1 = (v2 & 1) == 0 ? f : 20.0f;
            boolean z1 = (v2 & 2) == 0 ? z : true;
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.b);
            n n0 = n.a;
            r0.q q0 = z1 ? androidx.compose.foundation.layout.a.m(n0, 20.0f, 12.0f, f1, 20.0f) : androidx.compose.foundation.layout.a.n(n0, 0.0f, 12.0f, 0.0f, 20.0f, 5);
            String s = "더보기";
            q.f("더보기", "getString(...)");
            if(v == 1) {
                s = "아티스트 채널로 가기";
                q.f("아티스트 채널로 가기", "getString(...)");
            }
            r0.q q1 = r0.a.a(androidx.compose.foundation.q.f(d5.n.o(d.h(d.f(q0, 1.0f), 42.0f), e.b(4.0f)), e0.T(p0, 0x7F060153), M.a), new D(5, a0));  // color:gray200e
            N0.M m0 = M.p.d(r0.d.a, false);
            int v5 = p0.P;
            i0 i00 = p0.m();
            r0.q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            P0.i i0 = j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, j.f);
            w.x(p0, i00, j.e);
            h h0 = j.g;
            if(p0.O || !q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h0);
            }
            w.x(p0, q2, j.d);
            N1.b(s, (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.e), e0.T(p0, 0x7F06016D), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // color:gray900s
            p0.p(true);
            z2 = z1;
        }
        else {
            p0.T();
            f1 = f;
            z2 = z;
        }
        androidx.compose.runtime.n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new a0(f1, z2, v, a0, v1, v2);
        }
    }
}

