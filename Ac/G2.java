package Ac;

import Pc.d;
import Pc.e;
import T2.a;
import Ua.N;
import Ua.O;
import Ua.P;
import Ua.o;
import Ua.u;
import android.net.Uri.Builder;
import android.net.Uri;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.fragments.comments.CmtHelper;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.CommentListUiModel;
import com.melon.net.res.v3.CommentUiModel;
import com.melon.ui.K4;
import com.melon.ui.Q;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.q4;
import com.melon.ui.r4;
import com.melon.ui.s4;
import com.melon.ui.t4;
import d5.f;
import d5.n;
import e.k;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.w;
import k8.t;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import oe.c;
import p8.s;
import zd.x;

public final class g2 {
    public final N a;
    public Integer b;
    public String c;
    public CommentConfig d;
    public final MutableStateFlow e;
    public final StateFlow f;
    public final MutableStateFlow g;
    public final StateFlow h;

    public g2(N n0) {
        this.a = n0;
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(null);
        this.e = mutableStateFlow0;
        this.f = FlowKt.asStateFlow(mutableStateFlow0);
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow(null);
        this.g = mutableStateFlow1;
        this.h = FlowKt.asStateFlow(mutableStateFlow1);
    }

    public final List a(int v, int v1, String s, List list0, List list1) {
        if(list1 != null && !list1.isEmpty() && v1 != -1) {
            List list2 = p.Q0(list1);
            if(list0 != null && !list0.isEmpty()) {
                ((ArrayList)list2).add(v1, new N3(this.b(), v, 0x1C0, this.d(), s, false));
                int v2 = 0;
                for(Object object0: list0) {
                    if(v2 >= 0) {
                        ((ArrayList)list2).add(v1 + v2 + 1, O2.a(((O2)object0), null, v2 == k.s(list0), 7));
                        ++v2;
                        continue;
                    }
                    k.O();
                    throw null;
                }
                return list2;
            }
            ((ArrayList)list2).add(v1, new N3(0, -1, 460, null, s, true));
            ((ArrayList)list2).add(v1 + 1, p1.a);
            return list2;
        }
        return null;
    }

    public final int b() {
        Integer integer0 = this.b;
        if(integer0 != null) {
            return (int)integer0;
        }
        LogU.Companion.e("CommentFeatureControllerImpl", "channelSeq must be initialized before use.");
        return -1;
    }

    public final List c(List list0, V3 v30) {
        q.g(v30, "commentAction");
        if(list0 != null) {
            List list1 = new ArrayList(je.q.Q(10, list0));
            for(Object object0: list0) {
                K4 k40 = (K4)object0;
                if(k40 instanceof O2) {
                    k40 = this.l(((O2)k40), v30);
                }
                ((ArrayList)list1).add(k40);
            }
            return list1;
        }
        return w.a;
    }

    public final String d() {
        String s = this.c;
        if(s == null) {
            LogU.Companion.e("CommentFeatureControllerImpl", "contentRefValue must be initialized before use.");
            return "";
        }
        return s;
    }

    public final void e(e e0, boolean z, d d0, Q q0, com.melon.ui.q q1, a a0, we.k k0, we.k k1, W.p p0) {
        String s7;
        q.g(d0, "stringProvider");
        q.g(q0, "addPlayUserEventHelper");
        if(e0 instanceof S1) {
            j3 j30 = V2.a(((S1)e0).b, ((S1)e0).c, ((S1)e0).a, false, 8);
            Navigator.INSTANCE.open(j30);
            E9.w.G(((s)p0.a), this.d, d0, ((StringProviderImpl)d0).a(0x7F130DC9), null, ((S1)e0).d, ((S1)e0).e, false, null, null, null);  // string:tiara_common_action_name_move_page "페이지이동"
            return;
        }
        s4 s40 = s4.a;
        if(e0 instanceof X1) {
            if(!NetUtils.isConnected()) {
                k0.invoke(new t4(((StringProviderImpl)d0).a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                return;
            }
            if(!z) {
                k0.invoke(s40);
                return;
            }
            CommentConfig commentConfig0 = this.d;
            if(commentConfig0 != null && commentConfig0.isValid()) {
                if(commentConfig0.getNeedCheckArtistFan() && !commentConfig0.isArtistFan()) {
                    k0.invoke(new q4(28, ((StringProviderImpl)d0).a(0x7F1300D0), ((StringProviderImpl)d0).a(0x7F1301E1), null, null));  // string:alert_dlg_title_info "안내"
                    return;
                }
                if(commentConfig0.isBlindWrite()) {
                    k0.invoke(new q4(28, ((StringProviderImpl)d0).a(0x7F1300D0), commentConfig0.getBlindText(), null, null));  // string:alert_dlg_title_info "안내"
                    return;
                }
                if(commentConfig0.isBreakMember()) {
                    u.b(commentConfig0, ((StringProviderImpl)d0).a(0x7F1300D0), k0);  // string:alert_dlg_title_info "안내"
                    return;
                }
                String s = commentConfig0.getContentRefValue();
                q.g(s, "contentRefValue");
                h4 h40 = new h4();
                h40.setArguments(f.j(new m[]{new m("key_channel_seq", commentConfig0.getChannelSeq()), new m("key_content_ref_value", s), new m("key_cmt_config", commentConfig0), new m("key_cmt_mode", o4.a), new m("key_cmt_seq", -1)}));
                Navigator.INSTANCE.open(h40);
            }
        }
        else {
            if(e0 instanceof M1) {
                if(!z) {
                    k0.invoke(s40);
                    return;
                }
                if(this.d != null && this.d.isBreakMember()) {
                    u.b(this.d, ((StringProviderImpl)d0).a(0x7F1300D0), k0);  // string:alert_dlg_title_info "안내"
                    return;
                }
                k0.invoke(U1.a);
                return;
            }
            if(e0 instanceof V1) {
                g2.g(((V1)e0).a, ((V1)e0).c, ((V1)e0).b);
                s s1 = (s)p0.a;
                CommentConfig commentConfig1 = this.d;
                String s2 = null;
                ActionKind actionKind0 = ActionKind.ClickContent;
                String s3 = ((StringProviderImpl)d0).a((((V1)e0).b ? 0x7F130EF1 : 0x7F130D82));  // string:tiara_meta_type_artist "아티스트"
                String s4 = ((V1)e0).b ? ((V1)e0).c : null;
                if(((V1)e0).b) {
                    s2 = ((StringProviderImpl)d0).a(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                }
                E9.w.n(s1, commentConfig1, d0, actionKind0, s3, s4, s2, ((V1)e0).d);
                return;
            }
            if(e0 instanceof K1) {
                g2.g(((K1)e0).a, ((K1)e0).c, ((K1)e0).b);
                s s5 = (s)p0.a;
                CommentConfig commentConfig2 = this.d;
                String s6 = ((StringProviderImpl)d0).a((((K1)e0).b ? 0x7F130EF1 : 0x7F130D82));  // string:tiara_meta_type_artist "아티스트"
                E9.w.n(s5, commentConfig2, d0, ActionKind.ClickContent, s6, (((K1)e0).b ? ((K1)e0).c : null), (((K1)e0).b ? ((StringProviderImpl)d0).a(0x7F130EF1) : null), ((K1)e0).d);  // string:tiara_meta_type_artist "아티스트"
                return;
            }
            if(e0 instanceof J1) {
                CommentConfig commentConfig3 = ((J1)e0).a;
                CommentUiModel commentUiModel0 = ((J1)e0).b;
                if(commentConfig3.hasCommentMoreOption(commentUiModel0)) {
                    ArrayList arrayList0 = new ArrayList();
                    ArrayList arrayList1 = new ArrayList();
                    if(commentUiModel0.isReply()) {
                        s7 = ((StringProviderImpl)d0).a(0x7F1308CF);  // string:reply_text "답글"
                    }
                    else {
                        s7 = commentConfig3.isFanTalk() ? ((StringProviderImpl)d0).a(0x7F130433) : ((StringProviderImpl)d0).a(0x7F130212);  // string:fan_talk "팬톡"
                    }
                    if(commentUiModel0.isEditable()) {
                        if(!commentUiModel0.isReply()) {
                            arrayList0.add(x.k0);
                            arrayList1.add(new I1(z1.a, commentConfig3, commentUiModel0));
                        }
                        arrayList0.add(x.l0);
                        arrayList1.add(new I1(z1.b, commentConfig3, commentUiModel0));
                    }
                    else {
                        arrayList0.add(x.d0);
                        arrayList1.add(new I1(z1.c, commentConfig3, commentUiModel0));
                    }
                    if(!((J1)e0).c && !commentUiModel0.isReply() && commentConfig3.isPinAvailable()) {
                        if(commentUiModel0.isPinned()) {
                            arrayList0.add(x.w0);
                            arrayList1.add(new I1(z1.e, commentConfig3, commentUiModel0));
                        }
                        else {
                            arrayList0.add(x.v0);
                            arrayList1.add(new I1(z1.d, commentConfig3, commentUiModel0));
                        }
                    }
                    k0.invoke(new y1(s7, arrayList0, arrayList1));
                    s s8 = (s)p0.a;
                    CommentConfig commentConfig4 = this.d;
                    String s9 = ((StringProviderImpl)d0).a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    String s10 = (String)p0.b;
                    String s11 = ((StringProviderImpl)d0).a(0x7F130D54);  // string:tiara_click_copy_more "더보기"
                    E9.w.G(s8, commentConfig4, d0, s9, ActionKind.ClickContent, s10, s11, false, String.valueOf(commentUiModel0.getCommentSeq()), null, null);
                }
            }
            else if(e0 instanceof I1) {
                CommentConfig commentConfig5 = ((I1)e0).b;
                CommentUiModel commentUiModel1 = ((I1)e0).c;
                int v = ((I1)e0).a.ordinal();
                if(v == 0) {
                    goto label_145;
                }
                N n0 = this.a;
                switch(v) {
                    case 1: {
                        if(commentUiModel1.isReply()) {
                            Y1 y10 = new Y1(0, k1);
                            q.g(commentConfig5, "config");
                            if(!z) {
                                k0.invoke(s40);
                                return;
                            }
                            k0.invoke(new r4(((StringProviderImpl)d0).a(0x7F130798), ((StringProviderImpl)d0).a(0x7F130020), ((StringProviderImpl)d0).a(0x7F130227), new o(a0, n0, commentConfig5, commentUiModel1, k0, d0, y10), null, null, 100));  // string:notice "알림"
                            return;
                        }
                        Y1 y11 = new Y1(1, k1);
                        q.g(commentConfig5, "config");
                        if(!z) {
                            k0.invoke(s40);
                            return;
                        }
                        k0.invoke(new r4(((StringProviderImpl)d0).a(0x7F130798), ((StringProviderImpl)d0).a(0x7F1301DE), ((StringProviderImpl)d0).a(0x7F130227), new o(a0, n0, commentConfig5, commentUiModel1, k0, d0, y11, 0), null, null, 100));  // string:notice "알림"
                        return;
                    }
                    case 2: {
                        q.g(commentConfig5, "config");
                        q.g(commentUiModel1, "comment");
                        if(!z) {
                            k0.invoke(s40);
                            return;
                        }
                        if(commentConfig5.isBreakMember()) {
                            u.b(commentConfig5, ((StringProviderImpl)d0).a(0x7F1300D0), k0);  // string:alert_dlg_title_info "안내"
                            return;
                        }
                        break;
                    }
                    case 3: 
                    case 4: {
                        boolean z1 = commentUiModel1.isPinned();
                        Y1 y12 = new Y1(2, k1);
                        q.g(commentConfig5, "config");
                        if(!z) {
                            k0.invoke(s40);
                            return;
                        }
                        k0.invoke(new r4(((StringProviderImpl)d0).a(0x7F130798), ((StringProviderImpl)d0).a((z1 ? 0x7F13084A : 0x7F130849)), ((StringProviderImpl)d0).a(0x7F130227), new Ua.p(a0, n0, commentConfig5, commentUiModel1, z1, y12, k0, d0), null, null, 100));  // string:notice "알림"
                        return;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                String s12 = commentConfig5.getReportWindowUrl();
                if(s12 != null && s12.length() != 0) {
                    Uri.Builder uri$Builder0 = Uri.parse(commentConfig5.getReportWindowUrl()).buildUpon();
                    uri$Builder0.appendQueryParameter("templateType", "m.list");
                    uri$Builder0.appendQueryParameter("cmtPocType", "m.web");
                    MelonAppBase.Companion.getClass();
                    uri$Builder0.appendQueryParameter("pocId", t.a().getMelonCpId());
                    uri$Builder0.appendQueryParameter("chnlSeq", String.valueOf(commentConfig5.getChannelSeq()));
                    uri$Builder0.appendQueryParameter("contsRefValue", commentConfig5.getContentRefValue());
                    uri$Builder0.appendQueryParameter("cmtSeq", String.valueOf(commentUiModel1.getCommentSeq()));
                    Navigator.openUrl(uri$Builder0.build().toString(), OpenType.FullScreenWithBar);
                    return;
                label_145:
                    String s13 = commentConfig5.getContentRefValue();
                    q.g(s13, "contentRefValue");
                    h4 h41 = new h4();
                    h41.setArguments(f.j(new m[]{new m("key_channel_seq", commentConfig5.getChannelSeq()), new m("key_content_ref_value", s13), new m("key_cmt_config", commentConfig5), new m("key_cmt_mode", o4.b), new m("key_cmt_seq", commentUiModel1.getCommentSeq())}));
                    Navigator.INSTANCE.open(h41);
                }
            }
            else if(e0 instanceof P1) {
                CommentConfig commentConfig6 = this.d;
                if(commentConfig6 != null) {
                    k0.invoke(new Q1(commentConfig6, ((P1)e0).b));
                    s s14 = (s)p0.a;
                    CommentConfig commentConfig7 = this.d;
                    String s15 = ((StringProviderImpl)d0).a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    String s16 = (String)p0.b;
                    String s17 = ((StringProviderImpl)d0).a(0x7F130D17);  // string:tiara_click_copy_comment_reply "답글"
                    E9.w.G(s14, commentConfig7, d0, s15, ActionKind.ClickContent, s16, s17, false, String.valueOf(((P1)e0).b.getCommentSeq()), null, null);
                }
            }
            else {
                if(e0 instanceof N1) {
                    BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new b2(z, e0, d0, this, k0, k1, p0, null), 2, null);
                    return;
                }
                if(e0 instanceof L1) {
                    BuildersKt__Builders_commonKt.launch$default(a0, Dispatchers.getIO(), null, new c2(z, e0, d0, this, k0, k1, p0, null), 2, null);
                    return;
                }
                if(e0 instanceof u1) {
                    Navigator.INSTANCE.openPhotoUrl(false, ((u1)e0).a, null);
                    E9.w.G(((s)p0.a), this.d, d0, ((StringProviderImpl)d0).a(0x7F130DC9), ActionKind.ClickContent, ((String)p0.b), null, false, ((u1)e0).b, ((u1)e0).a, null);  // string:tiara_common_action_name_move_page "페이지이동"
                    return;
                }
                if(e0 instanceof v1) {
                    Navigator.openSongInfo(((v1)e0).a);
                    s s18 = (s)p0.a;
                    CommentConfig commentConfig8 = this.d;
                    String s19 = ((StringProviderImpl)d0).a(0x7F130F01);  // string:tiara_meta_type_song "곡"
                    E9.w.n(s18, commentConfig8, d0, ActionKind.ClickContent, null, ((v1)e0).a, s19, ((v1)e0).b);
                    return;
                }
                if(e0 instanceof w1) {
                    q0.d(new com.melon.ui.m(((w1)e0).a, ((w1)e0).c, null, null, 0x30), a0, k0);
                    s s20 = (s)p0.a;
                    CommentConfig commentConfig9 = this.d;
                    String s21 = ((StringProviderImpl)d0).a(0x7F130F01);  // string:tiara_meta_type_song "곡"
                    E9.w.n(s20, commentConfig9, d0, ActionKind.PlayMusic, null, ((w1)e0).a, s21, ((w1)e0).b);
                    return;
                }
                if(e0 instanceof q1) {
                    Navigator.openAlbumInfo(((q1)e0).a);
                    s s22 = (s)p0.a;
                    CommentConfig commentConfig10 = this.d;
                    String s23 = ((StringProviderImpl)d0).a(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
                    E9.w.n(s22, commentConfig10, d0, ActionKind.ClickContent, null, ((q1)e0).a, s23, ((q1)e0).b);
                    return;
                }
                if(e0 instanceof r1) {
                    Navigator.openArtistInfo(((r1)e0).a);
                    s s24 = (s)p0.a;
                    CommentConfig commentConfig11 = this.d;
                    String s25 = ((StringProviderImpl)d0).a(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                    E9.w.n(s24, commentConfig11, d0, ActionKind.ClickContent, null, ((r1)e0).a, s25, ((r1)e0).b);
                    return;
                }
                if(e0 instanceof x1) {
                    q0.d(new com.melon.ui.o(((x1)e0).a, ((x1)e0).c, null, 36), a0, k0);
                    s s26 = (s)p0.a;
                    CommentConfig commentConfig12 = this.d;
                    String s27 = ((StringProviderImpl)d0).a(0x7F130EFE);  // string:tiara_meta_type_mv "영상"
                    E9.w.n(s26, commentConfig12, d0, ActionKind.ClickContent, null, ((x1)e0).a, s27, ((x1)e0).b);
                    return;
                }
                if(e0 instanceof t1) {
                    Navigator.openUrl(((t1)e0).a, OpenType.Browser);
                    E9.w.G(((s)p0.a), this.d, d0, ((StringProviderImpl)d0).a(0x7F130DC9), ActionKind.ClickContent, ((String)p0.b), null, false, ((t1)e0).b, ((t1)e0).a, null);  // string:tiara_common_action_name_move_page "페이지이동"
                    return;
                }
                if(e0 instanceof s1) {
                    Navigator.openUrl(((s1)e0).a, OpenType.Browser);
                    return;
                }
                if(e0 instanceof D1) {
                    k0.invoke(new r4(((StringProviderImpl)d0).a(0x7F1300D0), ((StringProviderImpl)d0).a(0x7F1301DA), null, new Z1(k1, e0, this, 0), null, null, 108));  // string:alert_dlg_title_info "안내"
                }
            }
        }
    }

    public final boolean f() {
        return this.b != null && (this.c != null && !Tf.o.H0(this.c));
    }

    public static void g(String s, String s1, boolean z) {
        if(z) {
            Navigator.openArtistInfo(s1);
            return;
        }
        if(!StringIds.a(s, StringIds.i)) {
            if(StringIds.a(s, StringIds.j)) {
                Navigator.openMelGunsCollection();
                return;
            }
            Navigator.openUserMain(s);
        }
    }

    public final Object h(c c0) {
        CommentConfig commentConfig1;
        d2 d20;
        if(c0 instanceof d2) {
            d20 = (d2)c0;
            int v = d20.D;
            if((v & 0x80000000) == 0) {
                d20 = new d2(this, c0);
            }
            else {
                d20.D = v ^ 0x80000000;
            }
        }
        else {
            d20 = new d2(this, c0);
        }
        Object object0 = d20.w;
        ne.a a0 = ne.a.a;
        N n0 = this.a;
        H h0 = H.a;
        switch(d20.D) {
            case 0: {
                n.D(object0);
                int v1 = this.b();
                String s = this.d();
                d20.D = 1;
                object0 = n0.g(v1, 0, s, d20);
                if(object0 == a0) {
                    return a0;
                }
                goto label_23;
            }
            case 1: {
                n.D(object0);
            label_23:
                if(((Ua.Q)object0) instanceof P) {
                    CommentConfig commentConfig0 = (CommentConfig)((P)(((Ua.Q)object0))).a;
                    this.d = commentConfig0;
                    if(commentConfig0 != null) {
                        CmtHelper.setLatestComment(this.b(), this.d(), commentConfig0.getStartSeq());
                        int v2 = this.b();
                        String s1 = this.d();
                        d20.r = commentConfig0;
                        d20.D = 2;
                        Object object1 = n0.f(v2, s1, commentConfig0.getPageNo(), 3, -1, 0, 0, d20);
                        if(object1 == a0) {
                            return a0;
                        }
                        commentConfig1 = commentConfig0;
                        object0 = object1;
                        goto label_40;
                    }
                }
                break;
            }
            case 2: {
                commentConfig1 = d20.r;
                n.D(object0);
            label_40:
                if(((Ua.Q)object0) instanceof P) {
                    CommentListUiModel commentListUiModel0 = (CommentListUiModel)((P)(((Ua.Q)object0))).a;
                    ArrayList arrayList0 = new ArrayList();
                    Iterable iterable0 = commentListUiModel0.getCmtList();
                    ArrayList arrayList1 = new ArrayList(je.q.Q(10, iterable0));
                    int v3 = 0;
                    for(Object object2: iterable0) {
                        if(v3 >= 0) {
                            arrayList1.add(B.a.n(((CommentUiModel)object2), commentConfig1, v3 == k.s(commentListUiModel0.getCmtList()), 0, 4));
                            ++v3;
                            continue;
                        }
                        k.O();
                        throw null;
                    }
                    arrayList0.addAll(arrayList1);
                    Q2 q20 = new Q2(commentConfig1.getCount(), arrayList0);
                    this.g.setValue(q20);
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return h0;
    }

    public final Object i(c c0) {
        e2 e20;
        if(c0 instanceof e2) {
            e20 = (e2)c0;
            int v = e20.B;
            if((v & 0x80000000) == 0) {
                e20 = new e2(this, c0);
            }
            else {
                e20.B = v ^ 0x80000000;
            }
        }
        else {
            e20 = new e2(this, c0);
        }
        Object object0 = e20.r;
        ne.a a0 = ne.a.a;
        switch(e20.B) {
            case 0: {
                n.D(object0);
                Integer integer0 = CmtHelper.getLatestComment(this.b(), this.d());
                int v1 = this.b();
                String s = this.d();
                e20.B = 1;
                object0 = this.a.h(v1, (integer0 == null ? -1 : ((int)integer0)), s, e20);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((Ua.Q)object0) instanceof P) {
            this.e.setValue(((P)(((Ua.Q)object0))).a);
            return H.a;
        }
        if(!(((Ua.Q)object0) instanceof O)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return H.a;
    }

    public final Object j(boolean z, boolean z1, c c0) {
        f2 f20;
        if(c0 instanceof f2) {
            f20 = (f2)c0;
            int v = f20.E;
            if((v & 0x80000000) == 0) {
                f20 = new f2(this, c0);
            }
            else {
                f20.E = v ^ 0x80000000;
            }
        }
        else {
            f20 = new f2(this, c0);
        }
        Object object0 = f20.B;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(f20.E) {
            case 0: {
                n.D(object0);
                if(z) {
                    f20.r = true;
                    f20.w = z1;
                    f20.E = 1;
                    if(this.i(f20) == a0) {
                        return a0;
                    }
                }
                break;
            }
            case 1: {
                z1 = f20.w;
                z = f20.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(z1) {
            f20.r = z;
            f20.w = true;
            f20.E = 2;
            if(this.h(f20) == a0) {
                return a0;
            }
        }
        return h0;
    }

    public final void k(List list0) {
        if(list0.isEmpty()) {
            return;
        }
        Q2 q20 = (Q2)this.g.getValue();
        Q2 q21 = q20 == null ? null : new Q2(q20.a, list0);
        this.g.setValue(q21);
    }

    public final O2 l(O2 o20, V3 v30) {
        m m1;
        m m0;
        q.g(o20, "item");
        CommentUiModel commentUiModel0 = o20.a;
        q.g(v30, "commentAction");
        if(v30 instanceof T3) {
            int v = ((T3)v30).e;
            int v1 = ((T3)v30).d;
            boolean z = ((T3)v30).b;
            O1 o10 = ((T3)v30).a;
            if(commentUiModel0.getCommentSeq() == ((T3)v30).c) {
                CommentUiModel commentUiModel1 = o20.a;
                O1 o11 = O1.a;
                if(o10 != o11 || !z || commentUiModel1.isRecommendStatus()) {
                    m0 = o10 != o11 || z || !commentUiModel1.isRecommendStatus() ? new m(commentUiModel1.getRecommendCount(), Boolean.valueOf(commentUiModel1.isRecommendStatus())) : new m(v1, Boolean.FALSE);
                }
                else {
                    m0 = new m(v1, Boolean.TRUE);
                }
                int v2 = ((Number)m0.a).intValue();
                boolean z1 = ((Boolean)m0.b).booleanValue();
                O1 o12 = O1.b;
                if(o10 == o12 && z && !commentUiModel1.isNotRecommendStatus()) {
                    m1 = new m(v, Boolean.TRUE);
                    return O2.a(o20, CommentUiModel.copy$default(commentUiModel1, 0, false, null, false, null, false, false, false, false, false, false, 0, false, false, null, null, 0, false, false, 0, null, false, null, null, v2, ((Number)m1.a).intValue(), z1, ((Boolean)m1.b).booleanValue(), 0, null, false, false, ((T3)v30).f, ((T3)v30).g, 0xF0FFFFFF, 0, null), false, 14);
                }
                if(o10 == o12 && !z && commentUiModel1.isNotRecommendStatus()) {
                    m1 = new m(v, Boolean.FALSE);
                    return O2.a(o20, CommentUiModel.copy$default(commentUiModel1, 0, false, null, false, null, false, false, false, false, false, false, 0, false, false, null, null, 0, false, false, 0, null, false, null, null, v2, ((Number)m1.a).intValue(), z1, ((Boolean)m1.b).booleanValue(), 0, null, false, false, ((T3)v30).f, ((T3)v30).g, 0xF0FFFFFF, 0, null), false, 14);
                }
                m1 = new m(commentUiModel1.getNotRecommendCount(), Boolean.valueOf(commentUiModel1.isNotRecommendStatus()));
                return O2.a(o20, CommentUiModel.copy$default(commentUiModel1, 0, false, null, false, null, false, false, false, false, false, false, 0, false, false, null, null, 0, false, false, 0, null, false, null, null, v2, ((Number)m1.a).intValue(), z1, ((Boolean)m1.b).booleanValue(), 0, null, false, false, ((T3)v30).f, ((T3)v30).g, 0xF0FFFFFF, 0, null), false, 14);
            }
        }
        else if(v30 instanceof U3 && commentUiModel0.getCommentSeq() == ((U3)v30).a) {
            int v3 = commentUiModel0.getReplyCount();
            return ((U3)v30).d ? O2.a(o20, CommentUiModel.copy$default(commentUiModel0, 0, false, null, false, null, false, false, false, false, false, false, 0, false, false, null, null, 0, false, false, 0, null, false, null, null, 0, 0, false, false, v3 + 1, null, false, false, false, null, 0xEFFFFFFF, 3, null), false, 14) : O2.a(o20, CommentUiModel.copy$default(commentUiModel0, 0, false, null, false, null, false, false, false, false, false, false, 0, false, false, null, null, 0, false, false, 0, null, false, null, null, 0, 0, false, false, v3 - 1, null, false, false, false, null, 0xEFFFFFFF, 3, null), false, 14);
        }
        return o20;
    }
}

