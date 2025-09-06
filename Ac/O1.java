package Ac;

import C0.c;
import Cc.N1;
import Cc.e0;
import Cc.r0;
import De.I;
import H0.e;
import K.m;
import M.b;
import M.j;
import M.p0;
import M.q0;
import M.y;
import N0.M;
import N0.g0;
import P0.h;
import P0.i;
import Q0.k0;
import U4.x;
import a1.t;
import android.content.Context;
import androidx.appcompat.app.o;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.l1;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.CommentUiModel;
import com.melon.net.res.v3.MediaAttachHelper.AttachAlbumData;
import com.melon.net.res.v3.MediaAttachHelper.AttachArtistData;
import com.melon.net.res.v3.MediaAttachHelper.AttachImageData;
import com.melon.net.res.v3.MediaAttachHelper.AttachKakaoEmoticonData;
import com.melon.net.res.v3.MediaAttachHelper.AttachLinkGenrlData;
import com.melon.net.res.v3.MediaAttachHelper.AttachLinkVideoData;
import com.melon.net.res.v3.MediaAttachHelper.AttachMusicData;
import com.melon.net.res.v3.MediaAttachHelper.AttachPropertyData;
import com.melon.net.res.v3.MediaAttachHelper.AttachSongData;
import com.melon.net.res.v3.MediaAttachHelper.AttachVideoData;
import ie.H;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import r0.g;
import r0.n;
import r0.q;
import we.k;
import ye.a;

public abstract class o1 {
    public static final void a(k k0, String s, int v, int v1, boolean z, String s1, q q0, l l0, int v2) {
        q q1;
        ((p)l0).c0(0xEC0C1B61);
        int v3 = (v2 & 6) == 0 ? (((p)l0).i(k0) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v3 |= (((p)l0).g(s) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v3 |= (((p)l0).e(v) ? 0x100 : 0x80);
        }
        if((v2 & 0xC00) == 0) {
            v3 |= (((p)l0).e(v1) ? 0x800 : 0x400);
        }
        if((v2 & 0x6000) == 0) {
            v3 |= (((p)l0).h(z) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v2) == 0) {
            v3 |= (((p)l0).g(s1) ? 0x20000 : 0x10000);
        }
        if(((p)l0).Q((v3 | 0x180000) & 1, (0x92493 & (v3 | 0x180000)) != 0x92492)) {
            m m0 = ((p)l0).N();
            if(m0 == androidx.compose.runtime.k.a) {
                m0 = o.d(((p)l0));
            }
            c c0 = I.Q((z || ((Boolean)a.u(m0, ((p)l0), 6).getValue()).booleanValue() ? v1 : v), ((p)l0), 0);
            W0 w00 = new W0(0, s, k0);
            androidx.compose.foundation.q.c(c0, s1, r0.a.a(n.a, w00), null, null, 0.0f, null, ((p)l0), (v3 | 0x180000) >> 12 & 0x70, 120);
            q1 = n.a;
        }
        else {
            ((p)l0).T();
            q1 = q0;
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new T0(k0, s, v, v1, z, s1, q1, v2);
        }
    }

    public static final void b(CommentConfig commentConfig0, List list0, k k0, l l0, int v) {
        n n1;
        boolean z14;
        boolean z11;
        boolean z8;
        boolean z5;
        boolean z2;
        kotlin.jvm.internal.q.g(commentConfig0, "config");
        kotlin.jvm.internal.q.g(k0, "onClickAttachButton");
        p p0 = (p)l0;
        p0.c0(0xF7EC6F5E);
        int v1 = (p0.i(commentConfig0) ? 4 : 2) | v | (p0.i(list0) ? 0x20 : 16) | (p0.i(k0) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            boolean z = false;
            String s = e.Y(p0, 0x7F130B96);  // string:talkback_music_attach_btn "음악 첨부 버튼"
            boolean z1 = commentConfig0.isSongAttachable();
            if(list0 == null) {
                z2 = false;
            }
            else {
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object0: list0) {
                        if(((AttachPropertyData)object0) instanceof AttachMusicData) {
                            z = true;
                            break;
                        }
                    }
                }
                z2 = z;
            }
            boolean z3 = false;
            Ac.a a0 = new Ac.a("music_song", 0x7F0800EC, 0x7F0800ED, s, z1, z2);  // drawable:btn_attach_song_off
            String s1 = e.Y(p0, 0x7F130B51);  // string:talkback_image_attach_btn "이미지 첨부 버튼"
            boolean z4 = commentConfig0.isImageAttachable();
            if(list0 == null) {
                z5 = false;
            }
            else {
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object1: list0) {
                        if(((AttachPropertyData)object1) instanceof AttachImageData) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z5 = z3;
            }
            boolean z6 = false;
            Ac.a a1 = new Ac.a("image", 0x7F0800EA, 0x7F0800EB, s1, z4, z5);  // drawable:btn_attach_photo_off
            String s2 = e.Y(p0, 0x7F130C7D);  // string:talkback_video_attach_btn "비디오 첨부 버튼"
            boolean z7 = commentConfig0.isVideoAttachable();
            if(list0 == null) {
                z8 = false;
            }
            else {
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object2: list0) {
                        if(((AttachPropertyData)object2) instanceof AttachVideoData) {
                            z6 = true;
                            break;
                        }
                    }
                }
                z8 = z6;
            }
            boolean z9 = false;
            Ac.a a2 = new Ac.a("video", 0x7F0800EE, 0x7F0800EF, s2, z7, z8);  // drawable:btn_attach_video_off
            String s3 = e.Y(p0, 0x7F130C7E);  // string:talkback_video_link_attach_btn "유튜브 링크 첨부 버튼"
            boolean z10 = commentConfig0.isLinkAttachable();
            if(list0 == null) {
                z11 = false;
            }
            else {
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object3: list0) {
                        if(((AttachPropertyData)object3) instanceof AttachLinkVideoData) {
                            z9 = true;
                            break;
                        }
                    }
                }
                z11 = z9;
            }
            boolean z12 = false;
            Ac.a a3 = new Ac.a("link_video", 0x7F0800E8, 0x7F0800E9, s3, z10, z11);  // drawable:btn_attach_link_off
            String s4 = e.Y(p0, 0x7F130B57);  // string:talkback_kakao_emoticon_attach_btn "이모티콘 첨부 버튼"
            boolean z13 = commentConfig0.isKakaoEmoticonAttachable();
            if(list0 == null) {
                z14 = false;
            }
            else {
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object4: list0) {
                        if(((AttachPropertyData)object4) instanceof AttachKakaoEmoticonData) {
                            z12 = true;
                            break;
                        }
                    }
                }
                z14 = z12;
            }
            List list1 = e.k.A(new Ac.a[]{a0, a1, a2, a3, new Ac.a("kakao_emoticon", 0x7F0800E6, 0x7F0800E7, s4, z13, z14)});  // drawable:btn_attach_kakao_off
            n n0 = n.a;
            q q0 = androidx.compose.foundation.layout.a.n(d.h(n0, 52.0f), 18.0f, 0.0f, 0.0f, 0.0f, 14);
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            p0.a0(0xB6DECB27);
            int v3 = 0;
            for(Object object5: list1) {
                if(v3 >= 0) {
                    if(((Ac.a)object5).e) {
                        p0.a0(1708902789);
                        o1.a(k0, ((Ac.a)object5).a, ((Ac.a)object5).b, ((Ac.a)object5).c, ((Ac.a)object5).f, ((Ac.a)object5).d, null, p0, v1 >> 6 & 14);
                        if(v3 < e.k.s(list1)) {
                            p0.a0(1709356908);
                            n1 = n0;
                            x.z(n1, 16.0f, p0, false);
                        }
                        else {
                            n1 = n0;
                            p0.a0(0x635F909C);
                            p0.p(false);
                        }
                    }
                    else {
                        n1 = n0;
                        p0.a0(0x635F909C);
                    }
                    p0.p(false);
                    n0 = n1;
                    ++v3;
                    continue;
                }
                e.k.O();
                throw null;
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new E(commentConfig0, list0, k0, v);
        }
    }

    public static final void c(l l0, int v) {
        p p0 = (p)l0;
        p0.c0(1027259422);
        if(p0.Q(v & 1, v != 0)) {
            n n0 = n.a;
            q q0 = d.t(d.f(n0, 1.0f), 3);
            M m0 = M.p.d(r0.d.e, false);
            int v1 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v1)) {
                A7.d.q(v1, p0, v1, h0);
            }
            w.x(p0, q1, P0.j.d);
            q q2 = androidx.compose.foundation.layout.a.n(n0, 0.0f, 20.0f, 0.0f, 20.0f, 5);
            N1.b(e.Y(p0, 0x7F1302FE), q2, e0.T(p0, 0x7F060160), 15.0f, null, null, 0L, new l1.k(3), 19.0f, 0, false, 0, 0, null, null, p0, 0xC30, 6, 0x1F9F0);  // string:detail_empty_comment_text "등록된 댓글이 없습니다.\n첫 댓글을 남겨보세요."
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new F(v, 3);
        }
    }

    public static final void d(CommentUiModel commentUiModel0, boolean z, boolean z1, float f, boolean z2, CommentConfig commentConfig0, k k0, l l0, int v, int v1) {
        float f5;
        float f4;
        n n11;
        n n10;
        r0.h h17;
        float f3;
        n n9;
        r0.h h13;
        float f2;
        r0.h h12;
        int v20;
        n n8;
        q q31;
        n n7;
        n n6;
        n n5;
        n n4;
        int v11;
        String s1;
        n n3;
        n n2;
        M.d d1;
        Context context1;
        V v7;
        g g2;
        n n1;
        r0.i i0 = r0.d.a;
        r0 r00 = r0.b;
        r0.h h0 = r0.d.k;
        N0.i i1 = N0.j.f;
        kotlin.jvm.internal.q.g(commentUiModel0, "commentInfo");
        kotlin.jvm.internal.q.g(commentConfig0, "commentConfig");
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        p p0 = (p)l0;
        p0.c0(0x83D8D089);
        int v2 = (v & 6) == 0 ? (p0.i(commentUiModel0) ? 4 : 2) | v : v;
        if((v & 0x30) == 0) {
            v2 |= (p0.h(z) ? 0x20 : 16);
        }
        if((v & 0x180) == 0) {
            v2 |= (p0.h(z1) ? 0x100 : 0x80);
        }
        if((v1 & 8) != 0) {
            v2 |= 0xC00;
        }
        else if((v & 0xC00) == 0) {
            v2 |= (p0.d(f) ? 0x800 : 0x400);
        }
        if((v & 0x6000) == 0) {
            v2 |= (p0.h(z2) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v) == 0) {
            v2 |= (p0.i(commentConfig0) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v) == 0) {
            v2 |= (p0.i(k0) ? 0x100000 : 0x80000);
        }
        if(p0.Q(v2 & 1, (v2 & 0x92493) != 0x92492)) {
            String s = o1.i(commentUiModel0, commentConfig0, p0);
            Context context0 = (Context)p0.k(AndroidCompositionLocals_androidKt.c());
            int v3 = v2 >> 12;
            n n0 = n.a;
            q q0 = d.g(androidx.compose.foundation.layout.a.n(n0, 20.0f, (z ? 10.0f : 22.0f), 0.0f, 0.0f, 12));
            boolean z3 = p0.g(s);
            Ac.g g0 = p0.N();
            V v4 = androidx.compose.runtime.k.a;
            if(z3 || g0 == v4) {
                g0 = new Ac.g(s, 2);
                p0.l0(g0);
            }
            q q1 = X0.n.b(q0, g0);
            M.d d0 = j.c;
            g g1 = r0.d.m;
            y y0 = M.w.a(d0, g1, p0, 0);
            int v5 = w.j(p0);
            i0 i00 = p0.y();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i2 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i2);
            }
            else {
                p0.o0();
            }
            w.x(p0, y0, P0.j.c());
            w.x(p0, i00, P0.j.e());
            h h1 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v5)) {
                A7.d.q(v5, p0, v5, h1);
            }
            w.x(p0, q2, P0.j.d());
            q q3 = d.g(n0);
            b b0 = j.a;
            p0 p00 = M.n0.a(b0, h0, p0, 0x30);
            int v6 = w.j(p0);
            i0 i01 = p0.y();
            q q4 = r0.a.d(p0, q3);
            float f1 = (v1 & 8) == 0 ? f : 0.0f;
            i i3 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i3);
            }
            else {
                p0.o0();
            }
            h h2 = A7.d.h(p0, p00, p0, i01);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v6)) {
                A7.d.q(v6, p0, v6, h2);
            }
            w.x(p0, q4, P0.j.d());
            if(commentUiModel0.isReply()) {
                p0.a0(-1277505958);
                n1 = n0;
                q q5 = d.h(d.q(androidx.compose.foundation.layout.a.n(n0, 0.0f, 0.0f, 10.0f, 0.0f, 11), 10.0f), 10.0f);
                g2 = g1;
                v7 = v4;
                context1 = context0;
                d1 = d0;
                androidx.compose.foundation.q.c(I.Q(0x7F0803CD, p0, 6), null, q5, null, i1, 0.0f, null, p0, 25008, 104);  // drawable:ic_comment_bulletpoint
            }
            else {
                d1 = d0;
                g2 = g1;
                v7 = v4;
                context1 = context0;
                n1 = n0;
                p0.a0(0xB36D09B3);
            }
            p0.s();
            q q6 = d.n(n1, 28.0f);
            r00.e(r0.a.a(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q6, T.e.e()), new Y0(commentUiModel0, k0, 0)), commentUiModel0.getProfileImageUrl(), 28.0f, null, 0L, false, false, p0, 0xC00180, 120);  // color:gray100a
            M.c.d(p0, d.q(n1, 8.0f));
            q q7 = q0.a(n1, 1.0f);
            y y1 = M.w.a(d1, g2, p0, 0);
            int v8 = w.j(p0);
            i0 i02 = p0.y();
            q q8 = r0.a.d(p0, q7);
            i i4 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i4);
            }
            else {
                p0.o0();
            }
            w.x(p0, y1, P0.j.c());
            w.x(p0, i02, P0.j.e());
            h h3 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v8)) {
                A7.d.q(v8, p0, v8, h3);
            }
            w.x(p0, q8, P0.j.d());
            if(commentUiModel0.isPinned()) {
                p0.a0(0xAFA33413);
                p0 p01 = M.n0.a(b0, h0, p0, 0x30);
                int v9 = w.j(p0);
                i0 i03 = p0.y();
                q q9 = r0.a.d(p0, n1);
                i i5 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i5);
                }
                else {
                    p0.o0();
                }
                h h4 = A7.d.h(p0, p01, p0, i03);
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v9)) {
                    A7.d.q(v9, p0, v9, h4);
                }
                w.x(p0, q9, P0.j.d());
                q q10 = d.h(d.q(n1, 11.0f), 12.0f);
                androidx.compose.foundation.q.c(I.Q(0x7F0803D0, p0, 6), null, q10, null, i1, 0.0f, null, p0, 25008, 104);  // drawable:ic_comment_pin
                n2 = n1;
                q q11 = d.u(androidx.compose.foundation.layout.a.n(n1, 2.0f, 0.0f, 0.0f, 0.0f, 14), 3);
                N1.b(e.Y(p0, 0x7F1301EB), q11, e0.T(p0, 0x7F060163), 11.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // string:cmt_pinned "고정한 글"
                p0.r();
            }
            else {
                n2 = n1;
                p0.a0(0xAF1DA069);
            }
            p0.s();
            q q12 = d.h(n2, 16.0f);
            p0 p02 = M.n0.a(b0, h0, p0, 0x30);
            int v10 = w.j(p0);
            i0 i04 = p0.y();
            q q13 = r0.a.d(p0, q12);
            i i6 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i6);
            }
            else {
                p0.o0();
            }
            h h5 = A7.d.h(p0, p02, p0, i04);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v10)) {
                A7.d.q(v10, p0, v10, h5);
            }
            w.x(p0, q13, P0.j.d());
            if(commentUiModel0.isNotice()) {
                p0.a0(130122378);
                n3 = n2;
                q q14 = d.h(d.q(androidx.compose.foundation.layout.a.n(n3, 0.0f, 0.0f, 4.0f, 0.0f, 11), 26.0f), 14.0f);
                androidx.compose.foundation.q.c(I.Q(0x7F0803CF, p0, 6), null, q14, null, i1, 0.0f, null, p0, 25008, 104);  // drawable:ic_comment_notice
            }
            else {
                n3 = n2;
                p0.a0(0x729BF6D);
            }
            p0.s();
            if(commentUiModel0.isBest()) {
                p0.a0(130647084);
                q q15 = d.h(d.q(androidx.compose.foundation.layout.a.n(n3, 0.0f, 0.0f, 4.0f, 0.0f, 11), 29.0f), 14.0f);
                androidx.compose.foundation.q.c(I.Q(0x7F0803CC, p0, 6), null, q15, null, i1, 0.0f, null, p0, 25008, 104);  // drawable:ic_comment_best
            }
            else {
                p0.a0(0x729BF6D);
            }
            p0.s();
            if(commentUiModel0.isDj() || commentUiModel0.isArtist()) {
                p0.a0(0x7D20C76);
                if(commentUiModel0.isArtist()) {
                    p0.a0(0x7D3CFA8);
                    s1 = e.Y(p0, 0x7F130136);  // string:artist_eng "ARTIST"
                    p0.s();
                    v11 = 0x7F060447;  // color:pink600s
                }
                else {
                    p0.a0(0x7D66857);
                    s1 = e.Y(p0, 0x7F130335);  // string:dj_playlist_dj_badge "DJ"
                    v11 = commentUiModel0.getDjIconColor();
                    p0.s();
                }
                N1.b(s1, d.u(androidx.compose.foundation.layout.a.n(n3, 0.0f, 0.0f, 4.0f, 0.0f, 11), 3), e0.T(p0, v11), 13.0f, e1.x.F(), null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30C30, 0, 0x1FFD0);
            }
            else {
                p0.a0(0x729BF6D);
            }
            p0.s();
            n4 = n3;
            LayoutWeightElement layoutWeightElement0 = new LayoutWeightElement(1.0f, true);
            p0 p03 = M.n0.a(b0, h0, p0, 0x30);
            int v12 = w.j(p0);
            i0 i05 = p0.y();
            q q16 = r0.a.d(p0, layoutWeightElement0);
            i i7 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i7);
            }
            else {
                p0.o0();
            }
            h h6 = A7.d.h(p0, p03, p0, i05);
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v12)) {
                A7.d.q(v12, p0, v12, h6);
            }
            w.x(p0, q16, P0.j.d());
            N1.b(commentUiModel0.getUserNickname(), r0.a.a(androidx.compose.foundation.layout.a.n(n4, 0.0f, 0.0f, 4.0f, 0.0f, 11).then(new LayoutWeightElement(1.0f, false)), new Y0(commentUiModel0, k0, 1)), e0.T(p0, (commentUiModel0.isNotice() ? 0x7F06017C : 0x7F060165)), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC00, 0xC30, 0x1D7F0);  // color:green500s_support_high_contrast
            if(commentUiModel0.isOfficial()) {
                p0.a0(0x6F8CD6F8);
                n5 = n4;
                q q17 = d.n(androidx.compose.foundation.layout.a.n(n5, 0.0f, 0.0f, 4.0f, 0.0f, 11), 12.0f);
                androidx.compose.foundation.q.c(I.Q(0x7F08041B, p0, 6), null, q17, null, i1, 0.0f, null, p0, 25008, 104);  // drawable:ic_common_verify_12
            }
            else {
                n5 = n4;
                p0.a0(0x6EBD49D1);
            }
            p0.s();
            if(commentUiModel0.isListened()) {
                p0.a0(0x6F94D0DA);
                q q18 = d.n(androidx.compose.foundation.layout.a.n(n5, 0.0f, 0.0f, 4.0f, 0.0f, 11), 12.0f);
                androidx.compose.foundation.q.c(I.Q(0x7F0803CE, p0, 6), null, q18, null, i1, 0.0f, null, p0, 25008, 104);  // drawable:ic_comment_listen
            }
            else {
                p0.a0(0x6EBD49D1);
            }
            p0.s();
            if(commentUiModel0.getIntimacy() > -1) {
                p0.a0(0x6F9D6711);
                q q19 = d.d(androidx.compose.foundation.layout.a.n(n5, 0.0f, 0.0f, 4.0f, 0.0f, 11));
                p0 p04 = M.n0.a(b0, h0, p0, 0x30);
                int v13 = w.j(p0);
                i0 i06 = p0.y();
                q q20 = r0.a.d(p0, q19);
                i i8 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i8);
                }
                else {
                    p0.o0();
                }
                h h7 = A7.d.h(p0, p04, p0, i06);
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v13)) {
                    A7.d.q(v13, p0, v13, h7);
                }
                w.x(p0, q20, P0.j.d());
                N1.b(String.valueOf(commentUiModel0.getIntimacy()), null, y0.M.c(ResourceUtils.getFriendlyColorId(context1, commentUiModel0.getIntimacy())), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);
                q q21 = d.d(n5);
                M m0 = M.p.d(i0, false);
                int v14 = w.j(p0);
                i0 i07 = p0.y();
                q q22 = r0.a.d(p0, q21);
                i i9 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i9);
                }
                else {
                    p0.o0();
                }
                w.x(p0, m0, P0.j.c());
                w.x(p0, i07, P0.j.e());
                h h8 = P0.j.b();
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v14)) {
                    A7.d.q(v14, p0, v14, h8);
                }
                w.x(p0, q22, P0.j.d());
                q q23 = androidx.compose.foundation.layout.a.n(n5, 0.0f, 2.0f, 0.0f, 0.0f, 13);
                n6 = n5;
                q q24 = (androidx.compose.foundation.layout.b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(q23, r0.d.c);
                androidx.compose.foundation.q.c(L5.c.a(d5.w.B(context1, ResourceUtils.get4dpDegreeImageResId(commentUiModel0.getIntimacy())), p0), null, q24, null, i1, 0.0f, null, p0, 0x6030, 104);
                p0.r();
                p0.r();
            }
            else {
                n6 = n5;
                p0.a0(0x6EBD49D1);
            }
            p0.s();
            p0.r();
            p0.r();
            p0.r();
            N1.b(commentUiModel0.getDisplayTime(), null, e0.T(p0, 0x7F06015D), 12.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // color:gray500s_support_high_contrast
            q q25 = r0.a.a(d.h(d.q(n6, 40.0f), 28.0f), new a1(k0, commentConfig0, commentUiModel0, z2));
            M m1 = M.p.d(i0, false);
            int v15 = w.j(p0);
            i0 i08 = p0.y();
            q q26 = r0.a.d(p0, q25);
            i i10 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i10);
            }
            else {
                p0.o0();
            }
            w.x(p0, m1, P0.j.c());
            w.x(p0, i08, P0.j.e());
            h h9 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v15)) {
                A7.d.q(v15, p0, v15, h9);
            }
            w.x(p0, q26, P0.j.d());
            q q27 = d.h(d.q(n6, 20.0f), 28.0f);
            androidx.compose.foundation.q.c(I.Q(0x7F08010F, p0, 6), null, q27, null, N0.j.c, 0.0f, null, p0, 25008, 104);  // drawable:btn_comment_more
            p0.r();
            p0.r();
            q q28 = androidx.compose.foundation.layout.a.n(n6, 0.0f, 0.0f, 20.0f, 0.0f, 11);
            y y2 = M.w.a(d1, g2, p0, 0);
            int v16 = w.j(p0);
            i0 i09 = p0.y();
            q q29 = r0.a.d(p0, q28);
            i i11 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i11);
            }
            else {
                p0.o0();
            }
            w.x(p0, y2, P0.j.c());
            w.x(p0, i09, P0.j.e());
            h h10 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v16)) {
                A7.d.q(v16, p0, v16, h10);
            }
            w.x(p0, q29, P0.j.d());
            b0 b00 = p0.N();
            if(b00 == v7) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            String s2 = String.valueOf(commentUiModel0.getCommentSeq());
            A9.a a0 = p0.N();
            if(a0 == v7) {
                a0 = new A9.a(4);
                p0.l0(a0);
            }
            b0 b01 = (b0)d5.w.P(new Object[0], null, s2, a0, p0, 0xC00, 2);
            q q30 = androidx.compose.foundation.layout.a.n(n6, 0.0f, 12.0f, 0.0f, 0.0f, 13);
            if(commentUiModel0.isReply()) {
                n7 = n6;
                q31 = androidx.compose.foundation.layout.a.n(n6, 20.0f, 0.0f, 0.0f, 0.0f, 14);
            }
            else {
                n7 = n6;
                q31 = n7;
            }
            q q32 = r0.a.a(q30.then(q31), new r(commentUiModel0, b01, b00, 1));
            y y3 = M.w.a(d1, g2, p0, 0);
            int v17 = w.j(p0);
            i0 i010 = p0.y();
            q q33 = r0.a.d(p0, q32);
            i i12 = P0.j.a();
            p0.e0();
            if(p0.C()) {
                p0.l(i12);
            }
            else {
                p0.o0();
            }
            w.x(p0, y3, P0.j.c());
            w.x(p0, i010, P0.j.e());
            h h11 = P0.j.b();
            if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v17)) {
                A7.d.q(v17, p0, v17, h11);
            }
            w.x(p0, q33, P0.j.d());
            int v18 = commentUiModel0.isReply() || ((Boolean)b01.getValue()).booleanValue() ? 0x7FFFFFFF : 5;
            String s3 = t.h(Tf.o.f1(commentUiModel0.getContent()).toString(), null, 6).toString();
            long v19 = e0.T(p0, 0x7F06016D);  // color:gray900s
            R0 r01 = p0.N();
            if(r01 == v7) {
                r01 = new R0(b00, 0);
                p0.l0(r01);
            }
            N1.b(s3, null, v19, 15.0f, null, null, 0L, null, 22.0f, 2, false, v18, 0, r01, null, p0, 0xC00, 0x30036, 87026);
            if(!commentUiModel0.isReply() && (((Boolean)b00.getValue()).booleanValue() || ((Boolean)b01.getValue()).booleanValue())) {
                p0.a0(0x52F04F21);
                q q34 = d.g(androidx.compose.foundation.layout.a.n(n7, 0.0f, 6.0f, 0.0f, 0.0f, 13));
                N1.b(e.Y(p0, (((Boolean)b01.getValue()).booleanValue() ? 0x7F13043E : 0x7F130CA2)), q34, e0.T(p0, 0x7F060160), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // string:fold_title "접기"
            }
            else {
                p0.a0(1372357019);
            }
            p0.s();
            p0.r();
            if(commentUiModel0.isAttachedContent()) {
                p0.a0(0xAD3B21CF);
                for(Object object0: commentUiModel0.getAttachList()) {
                    AttachPropertyData mediaAttachHelper$AttachPropertyData0 = (AttachPropertyData)object0;
                    if(mediaAttachHelper$AttachPropertyData0 instanceof AttachImageData) {
                        p0.a0(0x22C62B0A);
                        n8 = n7;
                        v20 = v3;
                        h12 = h0;
                        f2 = f1;
                        Ac.y.e(androidx.compose.foundation.layout.a.n(n8, 0.0f, 16.0f, 0.0f, 0.0f, 13), ((AttachImageData)mediaAttachHelper$AttachPropertyData0), commentUiModel0.getCommentSeq(), false, k0, p0, v2 >> 6 & 0xE000 | 0xC06, 0);
                    }
                    else {
                        v20 = v3;
                        h12 = h0;
                        n8 = n7;
                        f2 = f1;
                        if(mediaAttachHelper$AttachPropertyData0 instanceof AttachSongData) {
                            p0.a0(0x22CDD1DA);
                            Ac.y.b(androidx.compose.foundation.layout.a.n(n8, 0.0f, 16.0f, 0.0f, 0.0f, 13), mediaAttachHelper$AttachPropertyData0, true, false, k0, p0, v2 >> 6 & 0xE000 | 0xD86);
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachAlbumData) {
                            p0.a0(584401049);
                            Ac.y.b(androidx.compose.foundation.layout.a.n(n8, 0.0f, 16.0f, 0.0f, 0.0f, 13), mediaAttachHelper$AttachPropertyData0, false, false, k0, p0, v2 >> 6 & 0xE000 | 0xD86);
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachArtistData) {
                            p0.a0(584890136);
                            Ac.y.a(androidx.compose.foundation.layout.a.n(n8, 0.0f, 16.0f, 0.0f, 0.0f, 13), ((AttachArtistData)mediaAttachHelper$AttachPropertyData0), false, k0, p0, v2 >> 6 & 0xE000 | 0xD86);
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachVideoData) {
                            p0.a0(0x22E434FA);
                            Ac.y.g(androidx.compose.foundation.layout.a.n(n8, 0.0f, 16.0f, 0.0f, 0.0f, 13), mediaAttachHelper$AttachPropertyData0, commentUiModel0.getCommentSeq(), true, false, k0, p0, 0x70000 & v2 >> 3 | 0x6C06, 0);
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachLinkVideoData) {
                            p0.a0(0x22ECAB39);
                            Ac.y.g(androidx.compose.foundation.layout.a.n(n8, 0.0f, 16.0f, 0.0f, 0.0f, 13), mediaAttachHelper$AttachPropertyData0, commentUiModel0.getCommentSeq(), false, false, k0, p0, 0x70000 & v2 >> 3 | 0x6C06, 0);
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachLinkGenrlData) {
                            p0.a0(0x22F5113E);
                            Ac.y.d(androidx.compose.foundation.layout.a.n(n8, 0.0f, 16.0f, 0.0f, 0.0f, 13), ((AttachLinkGenrlData)mediaAttachHelper$AttachPropertyData0), k0, p0, v20 & 0x380 | 6);
                        }
                        else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachKakaoEmoticonData) {
                            p0.a0(0x22FB2283);
                            Ac.y.c(androidx.compose.foundation.layout.a.n(n8, 0.0f, 16.0f, 0.0f, 0.0f, 13), ((AttachKakaoEmoticonData)mediaAttachHelper$AttachPropertyData0), false, k0, p0, v2 >> 9 & 0x1C00 | 390);
                        }
                        else {
                            p0.a0(0x21980703);
                        }
                    }
                    p0.s();
                    v3 = v20;
                    n7 = n8;
                    h0 = h12;
                    f1 = f2;
                }
                h13 = h0;
                n9 = n7;
                f3 = f1;
            }
            else {
                h13 = h0;
                n9 = n7;
                f3 = f1;
                p0.a0(0xAC0D7E05);
            }
            p0.s();
            if(commentUiModel0.isNotice() || commentUiModel0.isReply()) {
                n11 = n9;
                p0.a0(0xAC0D7E05);
            }
            else {
                p0.a0(0xAD7BAD0D);
                q q35 = d.g(androidx.compose.foundation.layout.a.n(n9, 0.0f, 16.0f, 0.0f, 0.0f, 13));
                b b1 = j.a;
                p0 p05 = M.n0.a(b1, h13, p0, 0x30);
                int v21 = w.j(p0);
                i0 i011 = p0.y();
                q q36 = r0.a.d(p0, q35);
                P0.k.y.getClass();
                i i13 = P0.j.a();
                p0.e0();
                if(p0.C()) {
                    p0.l(i13);
                }
                else {
                    p0.o0();
                }
                h h14 = A7.d.h(p0, p05, p0, i011);
                if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v21)) {
                    A7.d.q(v21, p0, v21, h14);
                }
                w.x(p0, q36, P0.j.d());
                if(commentUiModel0.isHideReplyButton()) {
                    p0.a0(0xF9140F7B);
                }
                else {
                    p0.a0(-92017067);
                    q q37 = r0.a.a(n9, new c1(k0, commentConfig0, commentUiModel0, 0));
                    p0 p06 = M.n0.a(b1, h13, p0, 0x30);
                    int v22 = w.j(p0);
                    i0 i012 = p0.y();
                    q q38 = r0.a.d(p0, q37);
                    i i14 = P0.j.a();
                    p0.e0();
                    if(p0.C()) {
                        p0.l(i14);
                    }
                    else {
                        p0.o0();
                    }
                    h h15 = A7.d.h(p0, p06, p0, i012);
                    if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v22)) {
                        A7.d.q(v22, p0, v22, h15);
                    }
                    w.x(p0, q38, P0.j.d());
                    N1.b(e.Y(p0, 0x7F1308CF), null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF2);  // string:reply_text "답글"
                    M.c.d(p0, d.q(n9, 3.0f));
                    N1.b(StringUtils.getCountString(commentUiModel0.getReplyCount(), 0xF423F), null, e0.T(p0, 0x7F060160), 13.0f, null, null, 0L, null, 0.0f, 0, false, 1, 0, null, null, p0, 0xC00, 0xC00, 0x1DFF2);  // color:gray600s_support_high_contrast
                    p0.r();
                }
                p0.s();
                M.c.d(p0, new LayoutWeightElement(1.0f, true));
                if(commentUiModel0.getHasRecommender()) {
                    p0.a0(0xFA9BAC07);
                    q q39 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.n(n9, 0.0f, 0.0f, 16.0f, 0.0f, 11), e0.T(p0, 0x7F060142), T.e.b(10.5f));  // color:gray030s
                    p0 p07 = M.n0.a(b1, h13, p0, 0x30);
                    int v23 = w.j(p0);
                    i0 i013 = p0.y();
                    q q40 = r0.a.d(p0, q39);
                    i i15 = P0.j.a();
                    p0.e0();
                    if(p0.C()) {
                        p0.l(i15);
                    }
                    else {
                        p0.o0();
                    }
                    h h16 = A7.d.h(p0, p07, p0, i013);
                    if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v23)) {
                        A7.d.q(v23, p0, v23, h16);
                    }
                    w.x(p0, q40, P0.j.d());
                    q q41 = d.n(n9, 21.0f);
                    h17 = h13;
                    r00.e(androidx.compose.foundation.q.i(0.5f, e0.T(p0, 0x7F06014A), q41, T.e.e()), commentUiModel0.getRecommenderImage(), 21.0f, null, 0L, false, false, p0, 0xC00180, 120);  // color:gray100a
                    n10 = n9;
                    q q42 = androidx.compose.foundation.layout.a.n(d.u(androidx.compose.foundation.layout.a.n(n9, 4.0f, 0.0f, 0.0f, 0.0f, 14), 3), 0.0f, 0.0f, 8.0f, 0.0f, 11);
                    N1.b(e.Y(p0, 0x7F130659), q42, e0.T(p0, 0x7F06017C), 10.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // string:melondj_recommend "DJ추천"
                    p0.r();
                }
                else {
                    h17 = h13;
                    n10 = n9;
                    p0.a0(0xF9140F7B);
                }
                p0.s();
                if(commentConfig0.isRecommendAvailable(commentUiModel0)) {
                    p0.a0(-88742041);
                    q q43 = r0.a.a(n10, new c1(k0, commentConfig0, commentUiModel0, 1));
                    p0 p08 = M.n0.a(b1, h17, p0, 0x30);
                    int v24 = w.j(p0);
                    i0 i014 = p0.y();
                    q q44 = r0.a.d(p0, q43);
                    i i16 = P0.j.a();
                    p0.e0();
                    if(p0.C()) {
                        p0.l(i16);
                    }
                    else {
                        p0.o0();
                    }
                    h h18 = A7.d.h(p0, p08, p0, i014);
                    if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v24)) {
                        A7.d.q(v24, p0, v24, h18);
                    }
                    w.x(p0, q44, P0.j.d());
                    q q45 = d.h(d.q(n10, 15.0f), 17.0f);
                    androidx.compose.foundation.q.c(I.Q((commentUiModel0.isRecommendStatus() ? 0x7F080111 : 0x7F080110), p0, 0), e.Y(p0, 0x7F130C1B), q45, null, i1, 0.0f, null, p0, 0x6180, 104);  // drawable:btn_comment_recommend_on
                    q q46 = androidx.compose.foundation.layout.a.n(n10, 4.0f, 0.0f, 16.0f, 0.0f, 10);
                    N1.b(StringUtils.getCountString(String.valueOf(commentUiModel0.getRecommendCount()), 0xF423F), q46, e0.T(p0, (commentUiModel0.isRecommendStatus() ? 0x7F06017C : 0x7F060160)), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:green500s_support_high_contrast
                    p0.r();
                    q q47 = r0.a.a(n10, new c1(k0, commentConfig0, commentUiModel0, 2));
                    p0 p09 = M.n0.a(b1, h17, p0, 0x30);
                    int v25 = w.j(p0);
                    i0 i015 = p0.y();
                    q q48 = r0.a.d(p0, q47);
                    i i17 = P0.j.a();
                    p0.e0();
                    if(p0.C()) {
                        p0.l(i17);
                    }
                    else {
                        p0.o0();
                    }
                    h h19 = A7.d.h(p0, p09, p0, i015);
                    if(p0.C() || !kotlin.jvm.internal.q.b(p0.N(), v25)) {
                        A7.d.q(v25, p0, v25, h19);
                    }
                    w.x(p0, q48, P0.j.d());
                    q q49 = d.h(d.q(n10, 15.0f), 17.0f);
                    androidx.compose.foundation.q.c(I.Q((commentUiModel0.isNotRecommendStatus() ? 0x7F080114 : 0x7F080113), p0, 0), e.Y(p0, 0x7F130C78), q49, null, i1, 0.0f, null, p0, 0x6180, 104);  // drawable:btn_comment_unrecommend_on
                    n11 = n10;
                    q q50 = d.t(androidx.compose.foundation.layout.a.n(n10, 4.0f, 0.0f, 0.0f, 0.0f, 14), 3);
                    N1.b(StringUtils.getCountString(String.valueOf(commentUiModel0.getNotRecommendCount()), 0xF423F), q50, e0.T(p0, (commentUiModel0.isNotRecommendStatus() ? 0x7F06017C : 0x7F060160)), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, p0, 0xC30, 0xC30, 0x1D7F0);  // color:green500s_support_high_contrast
                    p0.r();
                }
                else {
                    n11 = n10;
                    p0.a0(0xF9140F7B);
                }
                p0.s();
                p0.r();
            }
            p0.s();
            if(z1) {
                p0.a0(0xADED2CC5);
                f4 = f3;
                if(Float.compare(f4, 0.0f) > 0) {
                    p0.a0(0xADEDD400);
                    M.p.a(d.h(d.g(n11), 40.0f), p0, 6);
                }
                else {
                    p0.a0(0xAC0D7E05);
                }
                p0.s();
                p0.s();
            }
            else {
                p0.a0(0xADE8A31E);
                P4.a.b(d.h(d.g(androidx.compose.foundation.layout.a.n(n11, 0.0f, 22.0f, 0.0f, 0.0f, 13)), 0.5f), e0.T(p0, 0x7F06014A), 0.0f, 0.0f, p0, 6, 12);  // color:gray100a
                p0.s();
                f4 = f3;
            }
            p0.r();
            p0.r();
            f5 = f4;
        }
        else {
            p0.T();
            f5 = f;
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.f(new S0(commentUiModel0, z, z1, f5, z2, commentConfig0, k0, v, v1));
        }
    }

    public static final void e(q q0, String s, String s1, l l0, int v) {
        kotlin.jvm.internal.q.g(q0, "modifier");
        kotlin.jvm.internal.q.g(s, "inputText");
        kotlin.jvm.internal.q.g(s1, "writeMaxLength");
        p p0 = (p)l0;
        p0.c0(0x7FFE0158);
        int v1 = v | (p0.g(q0) ? 4 : 2) | (p0.g(s) ? 0x20 : 16) | (p0.g(s1) ? 0x100 : 0x80);
        if(p0.Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            p0 p00 = M.n0.a(j.a, r0.d.j, p0, 0);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            o1.f(s, p0, v1 >> 3 & 14);
            N1.b(x.k(" ", e.Y(p0, 0x7F130A13), " "), null, e0.T(p0, 0x7F060160), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0, 0, 0x1FFFA);  // string:slash "/"
            N1.b(s1, null, e0.T(p0, 0x7F060160), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, v1 >> 6 & 14, 0, 0x1FFFA);  // color:gray600s_support_high_contrast
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new P0(q0, s, s1, v, 0);
        }
    }

    public static final void f(String s, l l0, int v) {
        ((p)l0).c0(0xF8FF233D);
        int v1 = (v & 6) == 0 ? (((p)l0).g(s) ? 4 : 2) | v : v;
        if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
            N1.b(String.valueOf(s.length()), null, (s.length() == 0 ? A7.d.f(((p)l0), 0x2A7631B, 0x7F060160, ((p)l0), false) : A7.d.f(((p)l0), 44602993, 0x7F06016D, ((p)l0), false)), 0.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, ((p)l0), 0, 0, 0x1FFFA);  // color:gray600s_support_high_contrast
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new U0(s, v, 0);
        }
    }

    public static final void g(String s, String s1, String s2, k k0, l l0, int v) {
        b0 b02;
        x1.m m2;
        g1 g10;
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        p p0 = (p)l0;
        p0.c0(1067925820);
        int v1 = v | (p0.g(s) ? 4 : 2) | (p0.g(s1) ? 0x20 : 16) | (p0.g(s2) ? 0x100 : 0x80) | (p0.i(k0) ? 0x800 : 0x400);
        if(p0.Q(v1 & 1, (v1 & 0x493) != 1170)) {
            n n0 = n.a;
            q q0 = androidx.compose.foundation.q.f(androidx.compose.foundation.layout.a.m(n0, 20.0f, 10.0f, 20.0f, 12.0f), e0.T(p0, 0x7F06013E), T.e.b(4.0f));  // color:gray000s
            M m0 = M.p.d(r0.d.a, false);
            int v2 = p0.P;
            i0 i00 = p0.m();
            q q1 = r0.a.d(p0, q0);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, m0, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v2)) {
                A7.d.q(v2, p0, v2, h0);
            }
            w.x(p0, q1, P0.j.d);
            q q2 = r0.a.a(d.h(d.f(n0, 1.0f), 46.0f), new W0(1, s, k0));
            p0.a0(-1003410150);
            p0.a0(212064437);
            p0.p(false);
            r1.c c0 = (r1.c)p0.k(k0.h);
            x1.q q3 = p0.N();
            V v3 = androidx.compose.runtime.k.a;
            if(q3 == v3) {
                q3 = l1.w(c0, p0);
            }
            x1.j j0 = p0.N();
            if(j0 == v3) {
                j0 = l1.u(p0);
            }
            b0 b00 = p0.N();
            if(b00 == v3) {
                b00 = w.s(Boolean.FALSE);
                p0.l0(b00);
            }
            x1.m m1 = p0.N();
            if(m1 == v3) {
                m1 = l1.v(j0, p0);
            }
            b0 b01 = p0.N();
            if(b01 == v3) {
                b01 = w.r(H.a, V.c);
                p0.l0(b01);
            }
            boolean z = p0.i(q3);
            boolean z1 = p0.e(0x101);
            Object object0 = p0.N();
            if(z || z1 || object0 == v3) {
                g10 = new g1(b01, q3, m1, 0, b00);
                m2 = m1;
                b02 = b00;
                p0.l0(g10);
            }
            else {
                g10 = object0;
                m2 = m1;
                b02 = b00;
            }
            h1 h10 = p0.N();
            if(h10 == v3) {
                h10 = new h1(b02, m2, 0);
                p0.l0(h10);
            }
            boolean z2 = p0.i(q3);
            i1 i10 = p0.N();
            if(z2 || i10 == v3) {
                i10 = new i1(q3, 0);
                p0.l0(i10);
            }
            g0.a(X0.n.c(q2, false, i10), m0.c.e(1200550679, p0, new j1(b01, j0, h10, s2, s1, 0)), g10, p0, 0x30);
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new Q0(s, s1, s2, k0, v, 0);
        }
    }

    public static final void h(boolean z, int v, String s, String s1, int v1, float f, float f1, float f2, k k0, l l0, int v2) {
        kotlin.jvm.internal.q.g(k0, "sendUserEvent");
        p p0 = (p)l0;
        p0.c0(0x8800B576);
        int v3 = (v2 & 6) == 0 ? (p0.h(z) ? 4 : 2) | v2 : v2;
        if((v2 & 0x30) == 0) {
            v3 |= (p0.h(false) ? 0x20 : 16);
        }
        if((v2 & 0x180) == 0) {
            v3 |= (p0.e(v) ? 0x100 : 0x80);
        }
        if((v2 & 0xC00) == 0) {
            v3 |= (p0.g(s) ? 0x800 : 0x400);
        }
        if((v2 & 0x6000) == 0) {
            v3 |= (p0.g(s1) ? 0x4000 : 0x2000);
        }
        if((0x30000 & v2) == 0) {
            v3 |= (p0.e(v1) ? 0x20000 : 0x10000);
        }
        if((0x180000 & v2) == 0) {
            v3 |= (p0.d(f) ? 0x100000 : 0x80000);
        }
        if((0xC00000 & v2) == 0) {
            v3 |= (p0.d(f1) ? 0x800000 : 0x400000);
        }
        if((0x6000000 & v2) == 0) {
            v3 |= (p0.d(f2) ? 0x4000000 : 0x2000000);
        }
        if((0x30000000 & v2) == 0) {
            v3 |= (p0.i(k0) ? 0x20000000 : 0x10000000);
        }
        if(p0.Q(v3 & 1, (306783379 & v3) != 306783378)) {
            q q0 = androidx.compose.foundation.layout.a.n(n.a, f, f1, f2, 0.0f, 8);
            n n0 = n.a;
            q q1 = d.h(d.f(q0, 1.0f), 48.0f);
            p0 p00 = M.n0.a(j.a, r0.d.k, p0, 0x30);
            int v4 = p0.P;
            i0 i00 = p0.m();
            q q2 = r0.a.d(p0, q1);
            P0.k.y.getClass();
            i i0 = P0.j.b;
            p0.e0();
            if(p0.O) {
                p0.l(i0);
            }
            else {
                p0.o0();
            }
            w.x(p0, p00, P0.j.f);
            w.x(p0, i00, P0.j.e);
            h h0 = P0.j.g;
            if(p0.O || !kotlin.jvm.internal.q.b(p0.N(), v4)) {
                A7.d.q(v4, p0, v4, h0);
            }
            w.x(p0, q2, P0.j.d);
            N1.b((s1 + (v1 <= -1 ? "" : va.e.b(" ", StringUtils.getCountString(v1, 0x98967F)))), null, e0.T(p0, 0x7F06016D), 21.0f, e1.y.i, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0x30000, 0, 0x1FFD2);  // color:gray900s
            l1.x(1.0f, true, p0);
            if(z) {
                p0.a0(0x57C5F70F);
                q q3 = d.h(d.q(n0, 65.0f), 32.0f);
                androidx.compose.foundation.y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060152), 0.5f);  // color:gray200a
                T.d d0 = T.e.b(100.0f);
                q q4 = d.t(r0.a.a(androidx.compose.foundation.q.j(q3, y0.a, y0.b, d0), new Ac.l1(0, k0)), 2);
                N1.b(e.Y(p0, 0x7F1301F0), q4, e0.T(p0, 0x7F06016D), 14.0f, null, null, 0L, new l1.k(3), 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FDF0);  // string:cmt_write "글쓰기"
            }
            else {
                p0.a0(1473362074);
                q q5 = r0.a.a(n0, new n1(k0, v, s, s1, e.Y(p0, 0x7F130DB1)));  // string:tiara_click_copy_view_all "전체보기"
                N1.b(e.Y(p0, 0x7F13056E), q5, e0.T(p0, 0x7F060160), 15.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC00, 0, 0x1FFF0);  // string:main_common_view_all "전체보기"
            }
            p0.p(false);
            p0.p(true);
        }
        else {
            p0.T();
        }
        n0 n00 = p0.t();
        if(n00 != null) {
            n00.d = new O0(z, v, s, s1, v1, f, f1, f2, k0, v2);
        }
    }

    public static final String i(CommentUiModel commentUiModel0, CommentConfig commentConfig0, l l0) {
        String s4;
        String s3;
        int v2;
        int v1;
        String s1;
        List list1;
        List list0;
        boolean z = commentConfig0.isFanTalk();
        p p0 = (p)l0;
        p0.a0(0x9FE4F39E);
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(e.Y(p0, (commentUiModel0.isArtist() ? 0x7F1300FC : 0x7F1310FD)));  // string:artist "아티스트"
        stringBuilder0.append(" ");
        stringBuilder0.append(commentUiModel0.getUserNickname());
        stringBuilder0.append(", ");
        if(!z || commentUiModel0.getIntimacy() <= -1) {
            p0.a0(1017193574);
        }
        else {
            p0.a0(0xA4C84C7);
            stringBuilder0.append(e.Y(p0, 0x7F130105));  // string:artist_channel_friendly "친밀도"
            stringBuilder0.append(" ");
            stringBuilder0.append(commentUiModel0.getIntimacy());
            stringBuilder0.append(e.Y(p0, 0x7F1302E3));  // string:degree "도"
            stringBuilder0.append(", ");
        }
        p0.p(false);
        String s = commentUiModel0.getDisplayDate();
        Pattern pattern0 = Pattern.compile("\\.");
        kotlin.jvm.internal.q.f(pattern0, "compile(...)");
        kotlin.jvm.internal.q.g(s, "input");
        Tf.o.P0(0);
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.find()) {
            ArrayList arrayList0 = new ArrayList(10);
            int v = 0;
            do {
                v = o.c(matcher0, s, v, arrayList0);
            }
            while(matcher0.find());
            o.w(v, s, arrayList0);
            list0 = arrayList0;
        }
        else {
            list0 = e.k.z(s.toString());
        }
        if(!list0.isEmpty()) {
            ListIterator listIterator0 = list0.listIterator(list0.size());
            while(listIterator0.hasPrevious()) {
                if(((String)listIterator0.previous()).length() == 0) {
                    continue;
                }
                list1 = je.p.K0(listIterator0.nextIndex() + 1, list0);
                goto label_40;
            }
        }
        list1 = je.w.a;
    label_40:
        String[] arr_s = (String[])list1.toArray(new String[0]);
        if(arr_s.length == 3) {
            p0.a0(0xB1BF02D2);
            s1 = arr_s[0] + e.Y(p0, 0x7F131105) + " " + StringUtils.getNumberFromString(arr_s[1]) + e.Y(p0, 0x7F1306AD) + " " + arr_s[2] + e.Y(p0, 0x7F1302A4);  // string:year "년"
            kotlin.jvm.internal.q.d(s1);
            p0.p(false);
        }
        else {
            p0.a0(-2044322273);
            p0.p(false);
            s1 = commentUiModel0.getDisplayDate();
        }
        stringBuilder0.append(e.Y(p0, 0x7F1310FC));  // string:write_time "작성시간"
        stringBuilder0.append(" ");
        stringBuilder0.append(s1);
        stringBuilder0.append(", ");
        stringBuilder0.append(commentUiModel0.getContent());
        stringBuilder0.append(", ");
        if(commentUiModel0.getAttachList().isEmpty()) {
            p0.a0(1017193574);
        }
        else {
            p0.a0(0x3F4CBB65);
            for(Object object0: commentUiModel0.getAttachList()) {
                AttachPropertyData mediaAttachHelper$AttachPropertyData0 = (AttachPropertyData)object0;
                String s2 = "";
                if(mediaAttachHelper$AttachPropertyData0 instanceof AttachImageData) {
                    v1 = 0x61B618AE;
                    v2 = 0x7F130B50;  // string:talkback_image "이미지"
                    goto label_107;
                }
                else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachSongData) {
                    p0.a0(0x61B895A2);
                    s2 = e.Y(p0, 0x7F130A63);  // string:song "곡"
                    s3 = ((AttachSongData)mediaAttachHelper$AttachPropertyData0).getSongName();
                    s4 = e.Y(p0, 0x7F1300FC) + ", " + ((AttachSongData)mediaAttachHelper$AttachPropertyData0).getArtistName();  // string:artist "아티스트"
                    p0.p(false);
                }
                else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachAlbumData) {
                    p0.a0(0x61BD2440);
                    s2 = e.Y(p0, 0x7F130053);  // string:album "앨범"
                    s3 = ((AttachAlbumData)mediaAttachHelper$AttachPropertyData0).getAlbumName();
                    s4 = e.Y(p0, 0x7F1300FC) + ", " + ((AttachAlbumData)mediaAttachHelper$AttachPropertyData0).getArtistName();  // string:artist "아티스트"
                    p0.p(false);
                }
                else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachArtistData) {
                    p0.a0(1640084035);
                    String s5 = e.Y(p0, 0x7F1300FC);  // string:artist "아티스트"
                    s4 = ((AttachArtistData)mediaAttachHelper$AttachPropertyData0).getArtistName();
                    p0.p(false);
                    s2 = s5;
                    s3 = "";
                }
                else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachVideoData) {
                    p0.a0(1640289503);
                    s2 = e.Y(p0, 0x7F1310EE);  // string:video "비디오"
                    s3 = ((AttachVideoData)mediaAttachHelper$AttachPropertyData0).getVideoTitle();
                    s4 = e.Y(p0, 0x7F1300FC) + ", " + ((AttachVideoData)mediaAttachHelper$AttachPropertyData0).getArtistName();  // string:artist "아티스트"
                    p0.p(false);
                }
                else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachLinkVideoData) {
                    v1 = 1640590389;
                    v2 = 0x7F131106;  // string:youtube "Youtube"
                    goto label_107;
                }
                else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachLinkGenrlData) {
                    v1 = 0x61CBD12F;
                    v2 = 0x7F130B65;  // string:talkback_link "링크"
                    goto label_107;
                }
                else if(mediaAttachHelper$AttachPropertyData0 instanceof AttachKakaoEmoticonData) {
                    v1 = 0x61CE5C2F;
                    v2 = 0x7F1302F2;  // string:desc_emoticon "Emoticon"
                label_107:
                    s3 = "";
                    s2 = l1.h(p0, v1, v2, p0, false);
                    s4 = "";
                }
                else {
                    p0.a0(0x5F081191);
                    p0.p(false);
                    s4 = "";
                    s3 = "";
                }
                stringBuilder0.append(s2);
                stringBuilder0.append(", ");
                if(s3.length() > 0) {
                    stringBuilder0.append(s3);
                    stringBuilder0.append(", ");
                }
                if(s4.length() > 0) {
                    stringBuilder0.append(s4);
                    stringBuilder0.append(", ");
                }
                stringBuilder0.append(e.Y(p0, 0x7F130AD7));  // string:talkback_attach "첨부"
                stringBuilder0.append(", ");
            }
        }
        p0.p(false);
        if(commentUiModel0.isNotice() || commentUiModel0.isReply()) {
            p0.a0(1017193574);
        }
        else {
            p0.a0(1064420059);
            if(commentUiModel0.isHideReplyButton()) {
                p0.a0(1017193574);
            }
            else {
                p0.a0(0xA4DFFC3);
                stringBuilder0.append(e.Y(p0, 0x7F1308CF));  // string:reply_text "답글"
                stringBuilder0.append(" ");
                stringBuilder0.append(commentUiModel0.getReplyCount());
                stringBuilder0.append(e.Y(p0, 0x7F130753));  // string:musicdna_count_hangle "개"
                stringBuilder0.append(", ");
            }
            p0.p(false);
            if(commentConfig0.isRecommendAvailable(commentUiModel0)) {
                p0.a0(0xA4E2C9C);
                if(commentUiModel0.isRecommendStatus()) {
                    p0.a0(0xA4E2F88);
                    stringBuilder0.append(e.Y(p0, 0x7F130C1B));  // string:talkback_recom "추천"
                    stringBuilder0.append(" ");
                    stringBuilder0.append(e.Y(p0, 0x7F130C44));  // string:talkback_selected "선택됨"
                    stringBuilder0.append(", ");
                }
                else {
                    p0.a0(1017193574);
                }
                p0.p(false);
                if(commentUiModel0.isNotRecommendStatus()) {
                    p0.a0(172905450);
                    stringBuilder0.append(e.Y(p0, 0x7F130C78));  // string:talkback_unrecom "비추천"
                    stringBuilder0.append(" ");
                    stringBuilder0.append(e.Y(p0, 0x7F130C44));  // string:talkback_selected "선택됨"
                    stringBuilder0.append(", ");
                }
                else {
                    p0.a0(1017193574);
                }
                p0.p(false);
                stringBuilder0.append(e.Y(p0, 0x7F130C1B));  // string:talkback_recom "추천"
                stringBuilder0.append(" ");
                stringBuilder0.append(commentUiModel0.getRecommendCount());
                stringBuilder0.append(e.Y(p0, 0x7F130753));  // string:musicdna_count_hangle "개"
                stringBuilder0.append(", ");
                stringBuilder0.append(e.Y(p0, 0x7F130C78));  // string:talkback_unrecom "비추천"
                stringBuilder0.append(" ");
                stringBuilder0.append(commentUiModel0.getNotRecommendCount());
                stringBuilder0.append(e.Y(p0, 0x7F130753));  // string:musicdna_count_hangle "개"
                stringBuilder0.append(", ");
                stringBuilder0.append(e.Y(p0, 0x7F130ADE));  // string:talkback_button "버튼"
            }
            else {
                p0.a0(1017193574);
            }
            p0.p(false);
        }
        p0.p(false);
        p0.p(false);
        String s6 = stringBuilder0.toString();
        kotlin.jvm.internal.q.f(s6, "toString(...)");
        return s6;
    }
}

