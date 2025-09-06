package com.iloen.melon.popup;

import J8.I2;
import M.j;
import M.w;
import P0.h;
import P0.i;
import android.content.res.Configuration;
import androidx.compose.runtime.V;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.utils.color.ColorUtils;
import ie.H;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.q;
import p8.e;
import r0.a;
import we.n;

public final class y implements n {
    public final int a;
    public final Object b;

    public y(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        V v0 = k.a;
        H h0 = H.a;
        Object object2 = this.b;
        boolean z = false;
        switch(this.a) {
            case 0: {
                InstantPlayPopup instantPlayPopup0 = (InstantPlayPopup)object2;
                boolean z3 = ((Boolean)object1).booleanValue();
                q.g(((List)object0), "list");
                instantPlayPopup0.r.setPlayable(instantPlayPopup0.f);
                instantPlayPopup0.w = z3;
                Lyric instantPlayPopup$Lyric0 = instantPlayPopup0.r;
                instantPlayPopup$Lyric0.setLyricsInfoList(((List)object0));
                if(instantPlayPopup0.B != null) {
                    Collection collection0 = instantPlayPopup$Lyric0.getLyricsInfoList();
                    String s = "";
                    if(collection0 != null && !collection0.isEmpty()) {
                        if(z3) {
                            I2 i20 = instantPlayPopup0.B;
                            q.d(i20);
                            String s1 = ((LyricsInfo)instantPlayPopup$Lyric0.getLyricsInfoList().get(0)).b;
                            i20.j.setText(s1);
                            I2 i21 = instantPlayPopup0.B;
                            q.d(i21);
                            int v2 = ColorUtils.getColor(instantPlayPopup0.getContext(), 0x7F060194);  // color:instant_play_lyric_text
                            i21.j.setTextColor(v2);
                            I2 i22 = instantPlayPopup0.B;
                            q.d(i22);
                            MelonTextView melonTextView0 = i22.k;
                            if(instantPlayPopup$Lyric0.getLyricsInfoList().size() > 1) {
                                s = ((LyricsInfo)instantPlayPopup$Lyric0.getLyricsInfoList().get(1)).b;
                            }
                            melonTextView0.setText(s);
                            I2 i23 = instantPlayPopup0.B;
                            q.d(i23);
                            i23.k.setVisibility(0);
                            I2 i24 = instantPlayPopup0.B;
                            q.d(i24);
                            i24.g.setVisibility(0);
                            return h0;
                        }
                        I2 i25 = instantPlayPopup0.B;
                        q.d(i25);
                        int v3 = ColorUtils.getColor(instantPlayPopup0.getContext(), 0x7F06044E);  // color:primary_green
                        i25.j.setTextColor(v3);
                        I2 i26 = instantPlayPopup0.B;
                        q.d(i26);
                        i26.k.setVisibility(0);
                        I2 i27 = instantPlayPopup0.B;
                        q.d(i27);
                        i27.g.setVisibility(0);
                        instantPlayPopup0.o.requestUpdateLyric(0L);
                        return h0;
                    }
                    I2 i28 = instantPlayPopup0.B;
                    q.d(i28);
                    String s2 = instantPlayPopup0.getString(0x7F13038E);  // string:empty_lyrics "등록된 가사가 없습니다"
                    i28.j.setText(s2);
                    I2 i29 = instantPlayPopup0.B;
                    q.d(i29);
                    int v4 = ColorUtils.getColor(instantPlayPopup0.getContext(), 0x7F060194);  // color:instant_play_lyric_text
                    i29.j.setTextColor(v4);
                    I2 i210 = instantPlayPopup0.B;
                    q.d(i210);
                    i210.k.setText("");
                    I2 i211 = instantPlayPopup0.B;
                    q.d(i211);
                    i211.k.setVisibility(8);
                    I2 i212 = instantPlayPopup0.B;
                    q.d(i212);
                    i212.g.setVisibility(8);
                }
                return h0;
            }
            case 1: {
                int v5 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(1 & v5, (v5 & 3) != 2)) {
                    Configuration configuration0 = (Configuration)((p)(((l)object0))).k(AndroidCompositionLocals_androidKt.a);
                    int v6 = CommonFilterPopup.b;
                    String s3 = CommonFilterPopup.c;
                    if(s3 != null) {
                        List list0 = CommonFilterPopup.d;
                        if(list0 != null) {
                            int v7 = CommonFilterPopup.e;
                            int v8 = CommonFilterPopup.f;
                            int v9 = CommonFilterPopup.g;
                            int v10 = configuration0.orientation;
                            boolean z4 = ((p)(((l)object0))).i(((CommonFilterPopup)object2));
                            c c2 = ((p)(((l)object0))).N();
                            if(z4 || c2 == v0) {
                                c2 = new c(((CommonFilterPopup)object2), 0);
                                ((p)(((l)object0))).l0(c2);
                            }
                            boolean z5 = ((p)(((l)object0))).i(((CommonFilterPopup)object2));
                            d d0 = ((p)(((l)object0))).N();
                            if(z5 || d0 == v0) {
                                d0 = new d(((CommonFilterPopup)object2), 0);
                                ((p)(((l)object0))).l0(d0);
                            }
                            CommonFilterPopupKt.BottomSheetDialogScreen(v6, s3, list0, v7, v8, v9, v10, c2, d0, ((p)(((l)object0))), 0, 0);
                            return h0;
                        }
                        q.m("filterList");
                        throw null;
                    }
                    q.m("listType");
                    throw null;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            case 2: {
                int v11 = (int)(((Integer)object1));
                if((v11 & 3) != 2) {
                    z = true;
                }
                if(((p)(((l)object0))).Q(v11 & 1, z)) {
                    List list1 = DjSelectionPopup.b;
                    boolean z6 = ((p)(((l)object0))).i(((DjSelectionPopup)object2));
                    com.iloen.melon.popup.p p0 = ((p)(((l)object0))).N();
                    if(z6 || p0 == v0) {
                        p0 = new com.iloen.melon.popup.p(((DjSelectionPopup)object2), 1);
                        ((p)(((l)object0))).l0(p0);
                    }
                    boolean z7 = ((p)(((l)object0))).i(((DjSelectionPopup)object2));
                    c c3 = ((p)(((l)object0))).N();
                    if(z7 || c3 == v0) {
                        c3 = new c(((DjSelectionPopup)object2), 1);
                        ((p)(((l)object0))).l0(c3);
                    }
                    DjSelectionPopupKt.DjSelectionPopupBase(list1, p0, c3, ((p)(((l)object0))), 0, 0);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
            case 3: {
                int v12 = (int)(((Integer)object1));
                p p1 = (p)(((l)object0));
                if(p1.Q(v12 & 1, (v12 & 3) != 2)) {
                    M.y y0 = w.a(j.c, r0.d.m, p1, 0);
                    int v13 = p1.P;
                    i0 i00 = p1.m();
                    r0.n n0 = r0.n.a;
                    r0.q q0 = a.d(p1, n0);
                    P0.k.y.getClass();
                    i i0 = P0.j.b;
                    p1.e0();
                    if(p1.O) {
                        p1.l(i0);
                    }
                    else {
                        p1.o0();
                    }
                    androidx.compose.runtime.w.x(p1, y0, P0.j.f);
                    androidx.compose.runtime.w.x(p1, i00, P0.j.e);
                    h h1 = P0.j.g;
                    if(p1.O || !q.b(p1.N(), v13)) {
                        A7.d.q(v13, p1, v13, h1);
                    }
                    androidx.compose.runtime.w.x(p1, q0, P0.j.d);
                    CommonFilterPopupKt.CommonBtmSheetHeader(0x7F13034D, p1, 6);  // string:dj_popup_list_title "DJ 선택"
                    boolean z8 = p1.g(((List)object2));
                    com.iloen.melon.popup.p p2 = p1.N();
                    if(z8 || p2 == v0) {
                        p2 = new com.iloen.melon.popup.p(((List)object2), 2);
                        p1.l0(p2);
                    }
                    ye.a.i(null, null, null, false, null, null, null, false, null, p2, p1, 0, 0x1FF);
                    CommonFilterPopupKt.CommonFilterDivider(androidx.compose.foundation.layout.d.h(androidx.compose.foundation.layout.a.l(androidx.compose.foundation.layout.d.f(n0, 1.0f), 20.0f, 0.0f, 2), 1.0f), p1, 6, 0);
                    e e0 = p1.N();
                    if(e0 == v0) {
                        e0 = new e(24);
                        p1.l0(e0);
                    }
                    CommonFilterPopupKt.CommonFilterCloseBtn(e0, null, p1, 6, 2);
                    p1.p(true);
                    return h0;
                }
                p1.T();
                return h0;
            }
            default: {
                int v1 = (int)(((Integer)object1));
                if(((p)(((l)object0))).Q(v1 & 1, (v1 & 3) != 2)) {
                    boolean z1 = ((p)(((l)object0))).i(((MalrangServiceGuidePopup)object2));
                    C c0 = ((p)(((l)object0))).N();
                    if(z1 || c0 == v0) {
                        c0 = new C(((MalrangServiceGuidePopup)object2), 0);
                        ((p)(((l)object0))).l0(c0);
                    }
                    boolean z2 = ((p)(((l)object0))).i(((MalrangServiceGuidePopup)object2));
                    C c1 = ((p)(((l)object0))).N();
                    if(z2 || c1 == v0) {
                        c1 = new C(((MalrangServiceGuidePopup)object2), 1);
                        ((p)(((l)object0))).l0(c1);
                    }
                    MalrangServiceGuidePopupKt.BottomSheetDialogScreen(c0, c1, ((p)(((l)object0))), 0, 0);
                    return h0;
                }
                ((p)(((l)object0))).T();
                return h0;
            }
        }
    }
}

