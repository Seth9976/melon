package Ua;

import Ac.A1;
import Ac.O1;
import Ac.T3;
import Nc.f;
import Pc.d;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.melon.net.res.v3.CancelRecmRes.Result.RecmInfo;
import com.melon.net.res.v3.CommentApiModel.MemberInfoBase;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.CommentUiModel;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.q4;
import com.melon.ui.s4;
import com.melon.ui.t4;
import d5.n;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.jvm.internal.q;
import ne.a;
import oe.c;
import va.e0;
import va.o;
import we.k;

public final class u {
    public static final u a;

    static {
        u.a = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final void a(String s, d d0, k k0) {
        String s1 = ((StringProviderImpl)d0).a(0x7F1300D0);  // string:alert_dlg_title_info "안내"
        if(s == null) {
            s = ((StringProviderImpl)d0).a(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }
        k0.invoke(new q4(4, s1, s, ((StringProviderImpl)d0).a(0x7F130227), new f(k0)));  // string:confirm "확인"
    }

    public static void b(CommentConfig commentConfig0, String s, k k0) {
        q.g(k0, "sendUiEventAction");
        String s1 = null;
        String s2 = commentConfig0 == null ? null : commentConfig0.getBreakMemberGuideUrl();
        String s3 = "";
        if(s2 != null && s2.length() != 0) {
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            if(commentConfig0 != null) {
                s1 = commentConfig0.getBreakMemberGuideAppScheme();
            }
            if(s1 != null) {
                s3 = s1;
            }
            melonLinkInfo0.c = s3;
            MelonLinkExecutor.open(melonLinkInfo0);
            return;
        }
        if(commentConfig0 != null) {
            s1 = commentConfig0.getBreakMemberGuideText();
        }
        k0.invoke(new q4(28, s, (s1 == null ? "" : s1), null, null));
    }

    public final Object c(boolean z, CommentConfig commentConfig0, CommentUiModel commentUiModel0, O1 o10, d d0, N n0, k k0, k k1, c c0) {
        t t0;
        if(c0 instanceof t) {
            t0 = (t)c0;
            int v = t0.N;
            if((v & 0x80000000) == 0) {
                t0 = new t(this, c0);
            }
            else {
                t0.N = v ^ 0x80000000;
            }
        }
        else {
            t0 = new t(this, c0);
        }
        Object object0 = t0.I;
        a a0 = a.a;
        H h0 = H.a;
        String s = null;
        switch(t0.N) {
            case 0: {
                n.D(object0);
                if(!z) {
                    k0.invoke(s4.a);
                    return h0;
                }
                switch(o10.ordinal()) {
                    case 0: {
                        if(commentUiModel0.isNotRecommendStatus()) {
                            k0.invoke(new t4(((StringProviderImpl)d0).a(0x7F1301D7)));  // string:cmt_already_nonrecm_msg "이미 비추천한 댓글입니다."
                            return h0;
                        }
                        break;
                    }
                    case 1: {
                        if(commentUiModel0.isRecommendStatus()) {
                            k0.invoke(new t4(((StringProviderImpl)d0).a(0x7F1301D8)));  // string:cmt_already_recm_msg "이미 추천한 댓글입니다."
                            return h0;
                        }
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                if(commentConfig0.isBreakMember()) {
                    u.b(commentConfig0, ((StringProviderImpl)d0).a(0x7F1300D0), k0);  // string:alert_dlg_title_info "안내"
                    return h0;
                }
                if(e1.u.v(((e0)o.a()).j()).equals(commentUiModel0.getMemberKey())) {
                    k0.invoke(new t4(((StringProviderImpl)d0).a(0x7F1301ED)));  // string:cmt_self_can_not_recm_norecm_msg "본인이 작성한 글은 추천 또는 비추천 할 수 없습니다."
                    return h0;
                }
                if(o10 == O1.a && commentUiModel0.isRecommendStatus()) {
                    goto label_46;
                }
                O1 o11 = O1.b;
                if(o10 == o11 && commentUiModel0.isNotRecommendStatus()) {
                    goto label_46;
                }
                t0.r = commentConfig0;
                t0.w = commentUiModel0;
                t0.B = o10;
                t0.D = d0;
                t0.E = (kotlin.jvm.internal.n)k0;
                t0.G = k1;
                t0.N = 2;
                object0 = n0.o(commentConfig0.getChannelSeq(), commentConfig0.getContentRefValue(), commentUiModel0.getCommentSeq(), o10 == o11, t0);
                if(object0 == a0) {
                    return a0;
                label_46:
                    t0.r = commentConfig0;
                    t0.w = commentUiModel0;
                    t0.B = o10;
                    t0.D = d0;
                    t0.E = (kotlin.jvm.internal.n)k0;
                    t0.G = k1;
                    t0.N = 1;
                    object0 = n0.r(commentConfig0.getChannelSeq(), commentConfig0.getContentRefValue(), commentUiModel0.getCommentSeq(), o10 == O1.b, t0);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_69;
                }
                break;
            }
            case 1: {
                k k2 = t0.G;
                k k3 = (k)t0.E;
                d d1 = t0.D;
                O1 o12 = t0.B;
                CommentUiModel commentUiModel1 = t0.w;
                CommentConfig commentConfig1 = t0.r;
                n.D(object0);
                k1 = k2;
                commentConfig0 = commentConfig1;
                k0 = k3;
                commentUiModel0 = commentUiModel1;
                d0 = d1;
                o10 = o12;
            label_69:
                if(((Q)object0) instanceof P) {
                    RecmInfo cancelRecmRes$Result$RecmInfo0 = (RecmInfo)((P)(((Q)object0))).a;
                    String s1 = cancelRecmRes$Result$RecmInfo0.getMessage();
                    if(s1 != null && s1.length() != 0) {
                        k0.invoke(new t4((cancelRecmRes$Result$RecmInfo0.getMessage() == null ? "" : cancelRecmRes$Result$RecmInfo0.getMessage())));
                    }
                    int v1 = commentUiModel0.getCommentSeq();
                    int v2 = commentConfig0.getChannelSeq();
                    String s2 = commentConfig0.getContentRefValue();
                    int v3 = commentUiModel0.getRecommendCount();
                    Integer integer0 = o10 == O1.a ? new Integer(cancelRecmRes$Result$RecmInfo0.getRecmChgCount()) : null;
                    int v4 = integer0 == null ? 0 : ((int)integer0);
                    int v5 = commentUiModel0.getNotRecommendCount();
                    Integer integer1 = o10 == O1.b ? new Integer(cancelRecmRes$Result$RecmInfo0.getNonRecmChgCount()) : null;
                    int v6 = integer1 == null ? 0 : ((int)integer1);
                    boolean z1 = cancelRecmRes$Result$RecmInfo0.getRecommenderInfo() != null;
                    MemberInfoBase commentApiModel$MemberInfoBase0 = cancelRecmRes$Result$RecmInfo0.getRecommenderInfo();
                    if(commentApiModel$MemberInfoBase0 != null) {
                        s = commentApiModel$MemberInfoBase0.getMyPageImg();
                    }
                    T3 t30 = new T3(o10, false, v1, v3 + v4, v5 + v6, z1, (s == null ? "" : s), v2, s2);
                    k1.invoke(t30);
                    k0.invoke(new A1(t30));
                    return h0;
                }
                if(!(((Q)object0) instanceof O)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                String s3 = ((O)(((Q)object0))).b;
                if(s3 == null) {
                    s3 = ((StringProviderImpl)d0).a(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                }
                k0.invoke(new t4(s3));
                return h0;
            }
            case 2: {
                k k4 = t0.G;
                k k5 = (k)t0.E;
                d d2 = t0.D;
                O1 o13 = t0.B;
                CommentUiModel commentUiModel2 = t0.w;
                CommentConfig commentConfig2 = t0.r;
                n.D(object0);
                k1 = k4;
                commentConfig0 = commentConfig2;
                k0 = k5;
                commentUiModel0 = commentUiModel2;
                d0 = d2;
                o10 = o13;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((Q)object0) instanceof P) {
            com.melon.net.res.v3.InsertRecmRes.Result.RecmInfo insertRecmRes$Result$RecmInfo0 = (com.melon.net.res.v3.InsertRecmRes.Result.RecmInfo)((P)(((Q)object0))).a;
            String s4 = insertRecmRes$Result$RecmInfo0.getMessage();
            if(s4 != null && s4.length() != 0) {
                k0.invoke(new t4((insertRecmRes$Result$RecmInfo0.getMessage() == null ? "" : insertRecmRes$Result$RecmInfo0.getMessage())));
            }
            int v7 = commentUiModel0.getCommentSeq();
            int v8 = commentConfig0.getChannelSeq();
            String s5 = commentConfig0.getContentRefValue();
            int v9 = commentUiModel0.getRecommendCount();
            Integer integer2 = o10 == O1.a ? new Integer(insertRecmRes$Result$RecmInfo0.getRecmChgCount()) : null;
            int v10 = integer2 == null ? 0 : ((int)integer2);
            int v11 = commentUiModel0.getNotRecommendCount();
            Integer integer3 = o10 == O1.b ? new Integer(insertRecmRes$Result$RecmInfo0.getNonRecmChgCount()) : null;
            int v12 = integer3 == null ? 0 : ((int)integer3);
            boolean z2 = insertRecmRes$Result$RecmInfo0.getRecommenderInfo() != null;
            MemberInfoBase commentApiModel$MemberInfoBase1 = insertRecmRes$Result$RecmInfo0.getRecommenderInfo();
            if(commentApiModel$MemberInfoBase1 != null) {
                s = commentApiModel$MemberInfoBase1.getMyPageImg();
            }
            T3 t31 = new T3(o10, true, v7, v9 + v10, v11 + v12, z2, (s == null ? "" : s), v8, s5);
            k1.invoke(t31);
            k0.invoke(new A1(t31));
            return h0;
        }
        if(!(((Q)object0) instanceof O)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        String s6 = ((O)(((Q)object0))).b;
        if(s6 == null) {
            s6 = ((StringProviderImpl)d0).a(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }
        k0.invoke(new t4(s6));
        return h0;
    }
}

