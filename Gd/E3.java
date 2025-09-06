package gd;

import Ac.m4;
import Pc.e;
import Za.b;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.DJGUIDEBTNS;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.NEWDJ;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.OPTION;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.POPULARDJPLAYLISTS;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJLIST;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJPLAYLISTS;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.RECMDJ;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.RESPONSE;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.TAGBOARDLIST.TAGLIST;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.TAGBOARDLIST;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.TPO1.SUBCONTENTLIST;
import com.iloen.melon.net.v6x.response.DjHomeMainRes.TPO1;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.ResponseBase;
import com.melon.ui.K4;
import com.melon.ui.Q;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.s4;
import d5.n;
import ea.c;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import ne.a;
import p8.f;
import p8.g;
import p8.s;
import va.e0;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lgd/e3;", "Lcom/melon/ui/k1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class e3 extends k1 {
    public final c a;
    public final b b;
    public final k c;
    public final Q d;
    public final StringProviderImpl e;
    public final LogU f;
    public Context g;
    public static final int h;

    public e3(c c0, b b0, k k0, Q q0, StringProviderImpl stringProviderImpl0) {
        q.g(k0, "loginUseCase");
        super();
        this.a = c0;
        this.b = b0;
        this.c = k0;
        this.d = q0;
        this.e = stringProviderImpl0;
        LogU logU0 = new LogU("MelonDjHomeMainViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.f = logU0;
    }

    public static m4 c(e3 e30, d1 d10) {
        ArrayList arrayList10;
        ArrayList arrayList9;
        ArrayList arrayList8;
        w w3;
        w w2;
        w w1;
        ArrayList arrayList6;
        ArrayList arrayList5;
        ArrayList arrayList4;
        ArrayList arrayList3;
        ArrayList arrayList2;
        String s5;
        ArrayList arrayList1;
        q.g(d10, "fetchResult");
        if(d10 instanceof c1) {
            ResponseBase responseBase0 = ((c1)d10).a;
            RESPONSE djHomeMainRes$RESPONSE0 = responseBase0 instanceof RESPONSE ? ((RESPONSE)responseBase0) : null;
            ArrayList arrayList0 = new ArrayList();
            w w0 = w.a;
            if(djHomeMainRes$RESPONSE0 != null) {
                TPO1 djHomeMainRes$TPO10 = djHomeMainRes$RESPONSE0.tpo1;
                if(djHomeMainRes$TPO10 != null) {
                    String s = djHomeMainRes$TPO10.subContentTitle;
                    List list0 = djHomeMainRes$TPO10.subContentList;
                    if(list0 == null) {
                        arrayList1 = w0;
                    }
                    else {
                        arrayList1 = new ArrayList(je.q.Q(10, list0));
                        for(Object object0: list0) {
                            String s1 = ((SUBCONTENTLIST)object0).offerImgUrl;
                            String s2 = ((SUBCONTENTLIST)object0).offerTitle;
                            String s3 = ((SUBCONTENTLIST)object0).offerIntordCont;
                            OPTION djHomeMainRes$OPTION0 = ((SUBCONTENTLIST)object0).option;
                            if(djHomeMainRes$OPTION0 == null) {
                                s5 = null;
                            }
                            else {
                                String s4 = djHomeMainRes$OPTION0.title;
                                s5 = s4 == null ? e30.e.a(0x7F130B65) : s4;  // string:talkback_link "링크"
                            }
                            OPTION djHomeMainRes$OPTION1 = ((SUBCONTENTLIST)object0).option;
                            arrayList1.add(new A(s1, s2, s3, s5, (djHomeMainRes$OPTION1 == null ? null : djHomeMainRes$OPTION1.contsTypeCode), (djHomeMainRes$OPTION1 == null ? null : djHomeMainRes$OPTION1.contsId), ((SUBCONTENTLIST)object0).plylstSeq, ((SUBCONTENTLIST)object0).plylsttitle, ((SUBCONTENTLIST)object0).ownernickname));
                        }
                    }
                    arrayList0.add(new B2(s, arrayList1));
                }
            }
            if(djHomeMainRes$RESPONSE0 != null) {
                TAGBOARDLIST djHomeMainRes$TAGBOARDLIST0 = djHomeMainRes$RESPONSE0.tagBoardList;
                if(djHomeMainRes$TAGBOARDLIST0 != null) {
                    String s6 = djHomeMainRes$TAGBOARDLIST0.subContentTitle;
                    List list1 = djHomeMainRes$TAGBOARDLIST0.subContentList;
                    if(list1 == null) {
                        arrayList2 = w0;
                    }
                    else {
                        arrayList2 = new ArrayList(je.q.Q(10, list1));
                        for(Object object1: list1) {
                            String s7 = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.TAGBOARDLIST.SUBCONTENTLIST)object1).tabTitle;
                            String s8 = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.TAGBOARDLIST.SUBCONTENTLIST)object1).tabTagTypeCode;
                            List list2 = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.TAGBOARDLIST.SUBCONTENTLIST)object1).tagList;
                            if(list2 == null) {
                                arrayList3 = w0;
                            }
                            else {
                                arrayList3 = new ArrayList(je.q.Q(10, list2));
                                for(Object object2: list2) {
                                    arrayList3.add(new C(((TAGLIST)object2).imgUrl, ((TAGLIST)object2).tagSeq, ((TAGLIST)object2).tagName, ((TAGLIST)object2).isLike));
                                }
                            }
                            arrayList2.add(new z(s7, s8, arrayList3));
                        }
                    }
                    arrayList0.add(new B2(s6, arrayList2));
                }
            }
            if(djHomeMainRes$RESPONSE0 != null) {
                POPULARDJPLAYLISTS djHomeMainRes$POPULARDJPLAYLISTS0 = djHomeMainRes$RESPONSE0.popularDjplayLists;
                if(djHomeMainRes$POPULARDJPLAYLISTS0 != null) {
                    String s9 = djHomeMainRes$POPULARDJPLAYLISTS0.subContentTitle;
                    List list3 = djHomeMainRes$POPULARDJPLAYLISTS0.subContentList;
                    if(list3 == null) {
                        arrayList4 = w0;
                    }
                    else {
                        arrayList4 = new ArrayList(je.q.Q(10, list3));
                        for(Object object3: list3) {
                            com.iloen.melon.net.v6x.response.DjHomeMainRes.POPULARDJPLAYLISTS.SUBCONTENTLIST djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0 = (com.iloen.melon.net.v6x.response.DjHomeMainRes.POPULARDJPLAYLISTS.SUBCONTENTLIST)object3;
                            arrayList4.add(new v((djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.thumbimg == null || djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.thumbimg.length() == 0 ? djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.thumbImgUrl : djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.thumbimg), djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.plylsttitle, (djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.memberNickname == null || djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.memberNickname.length() <= 0 ? djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.ownernickname : djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.memberNickname), djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.rankType, djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.currentRank, djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.rankGap, djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.plylstseq, djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.plylsttitle, djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.ownernickname, djHomeMainRes$POPULARDJPLAYLISTS$SUBCONTENTLIST0.ownermemberkey));
                        }
                    }
                    arrayList0.add(new B2(s9, arrayList4));
                }
            }
            if(djHomeMainRes$RESPONSE0 != null) {
                RECMDJ djHomeMainRes$RECMDJ0 = djHomeMainRes$RESPONSE0.recmDj;
                if(djHomeMainRes$RECMDJ0 != null) {
                    String s10 = djHomeMainRes$RECMDJ0.subContentTitle;
                    List list4 = djHomeMainRes$RECMDJ0.subContentList;
                    if(list4 == null) {
                        arrayList5 = w0;
                    }
                    else {
                        arrayList5 = new ArrayList(je.q.Q(10, list4));
                        for(Object object4: list4) {
                            arrayList5.add(new y(((com.iloen.melon.net.v6x.response.DjHomeMainRes.RECMDJ.SUBCONTENTLIST)object4).myPageImg, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.RECMDJ.SUBCONTENTLIST)object4).memberkey, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.RECMDJ.SUBCONTENTLIST)object4).memberNickName, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.RECMDJ.SUBCONTENTLIST)object4).isMyFriend, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.RECMDJ.SUBCONTENTLIST)object4).followerCnt, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.RECMDJ.SUBCONTENTLIST)object4).offerIntrodCont));
                        }
                    }
                    arrayList0.add(new B2(s10, arrayList5));
                }
            }
            if(djHomeMainRes$RESPONSE0 == null) {
                w3 = w0;
            }
            else {
                POWERDJLIST djHomeMainRes$POWERDJLIST0 = djHomeMainRes$RESPONSE0.powerDjList;
                if(djHomeMainRes$POWERDJLIST0 == null) {
                    w3 = w0;
                }
                else {
                    String s11 = djHomeMainRes$POWERDJLIST0.subContentTitle;
                    List list5 = djHomeMainRes$POWERDJLIST0.subContentList;
                    if(list5 == null) {
                        w3 = w0;
                        arrayList6 = w3;
                    }
                    else {
                        arrayList6 = new ArrayList(je.q.Q(10, list5));
                        for(Object object5: list5) {
                            String s12 = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJLIST.SUBCONTENTLIST)object5).myPageImg;
                            String s13 = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJLIST.SUBCONTENTLIST)object5).memberkey;
                            String s14 = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJLIST.SUBCONTENTLIST)object5).memberNickName;
                            String s15 = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJLIST.SUBCONTENTLIST)object5).followerCnt;
                            String s16 = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJLIST.SUBCONTENTLIST)object5).offerIntrodCont;
                            boolean z = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJLIST.SUBCONTENTLIST)object5).isMyFriend;
                            List list6 = ((com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJLIST.SUBCONTENTLIST)object5).djPlayListList;
                            if(list6 == null) {
                                w1 = w0;
                                w2 = w1;
                            }
                            else {
                                ArrayList arrayList7 = new ArrayList(je.q.Q(10, list6));
                                for(Object object6: list6) {
                                    arrayList7.add(new gd.k(((PLAYLIST)object6).thumbimg, ((PLAYLIST)object6).plylsttitle, ((PLAYLIST)object6).plylstseq, ((PLAYLIST)object6).ownernickname));
                                }
                                w1 = w0;
                                w2 = arrayList7;
                            }
                            arrayList6.add(new x(s12, s13, s14, s15, s16, w2, z));
                            w0 = w1;
                        }
                        w3 = w0;
                    }
                    arrayList0.add(new B2(s11, arrayList6));
                }
            }
            if(djHomeMainRes$RESPONSE0 != null) {
                POWERDJPLAYLISTS djHomeMainRes$POWERDJPLAYLISTS0 = djHomeMainRes$RESPONSE0.powerDjPlayLists;
                if(djHomeMainRes$POWERDJPLAYLISTS0 != null) {
                    String s17 = djHomeMainRes$POWERDJPLAYLISTS0.subContentTitle;
                    List list7 = djHomeMainRes$POWERDJPLAYLISTS0.subContentList;
                    if(list7 == null) {
                        arrayList8 = w3;
                    }
                    else {
                        arrayList8 = new ArrayList(je.q.Q(10, list7));
                        for(Object object7: list7) {
                            com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJPLAYLISTS.SUBCONTENTLIST djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0 = (com.iloen.melon.net.v6x.response.DjHomeMainRes.POWERDJPLAYLISTS.SUBCONTENTLIST)object7;
                            arrayList8.add(new gd.w((djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.thumbimg == null || djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.thumbimg.length() == 0 ? djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.thumbImgUrl : djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.thumbimg), djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.plylsttitle, djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.ownermemberkey, (djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.memberNickname == null || djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.memberNickname.length() <= 0 ? djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.ownernickname : djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.memberNickname), djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.plylstseq, djHomeMainRes$POWERDJPLAYLISTS$SUBCONTENTLIST0.ownernickname));
                        }
                    }
                    arrayList0.add(new B2(s17, arrayList8));
                }
            }
            if(djHomeMainRes$RESPONSE0 != null) {
                NEWDJ djHomeMainRes$NEWDJ0 = djHomeMainRes$RESPONSE0.newDj;
                if(djHomeMainRes$NEWDJ0 != null) {
                    String s18 = djHomeMainRes$NEWDJ0.subContentTitle;
                    List list8 = djHomeMainRes$NEWDJ0.subContentList;
                    if(list8 == null) {
                        arrayList9 = w3;
                    }
                    else {
                        arrayList9 = new ArrayList(je.q.Q(10, list8));
                        for(Object object8: list8) {
                            arrayList9.add(new u(((com.iloen.melon.net.v6x.response.DjHomeMainRes.NEWDJ.SUBCONTENTLIST)object8).myPageImg, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.NEWDJ.SUBCONTENTLIST)object8).memberDjIconType, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.NEWDJ.SUBCONTENTLIST)object8).memberNickName, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.NEWDJ.SUBCONTENTLIST)object8).memberkey, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.NEWDJ.SUBCONTENTLIST)object8).isOfficial, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.NEWDJ.SUBCONTENTLIST)object8).offerIntrodCont, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.NEWDJ.SUBCONTENTLIST)object8).plylstCnt));
                        }
                    }
                    arrayList0.add(new B2(s18, arrayList9));
                }
            }
            if(djHomeMainRes$RESPONSE0 != null) {
                DJGUIDEBTNS djHomeMainRes$DJGUIDEBTNS0 = djHomeMainRes$RESPONSE0.djGuideBtns;
                if(djHomeMainRes$DJGUIDEBTNS0 != null) {
                    String s19 = djHomeMainRes$DJGUIDEBTNS0.subContentTitle;
                    List list9 = djHomeMainRes$DJGUIDEBTNS0.subContentList;
                    if(list9 == null) {
                        arrayList10 = w3;
                    }
                    else {
                        arrayList10 = new ArrayList(je.q.Q(10, list9));
                        for(Object object9: list9) {
                            arrayList10.add(new t(((com.iloen.melon.net.v6x.response.DjHomeMainRes.DJGUIDEBTNS.SUBCONTENTLIST)object9).title, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.DJGUIDEBTNS.SUBCONTENTLIST)object9).linkurl, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.DJGUIDEBTNS.SUBCONTENTLIST)object9).linktype, ((com.iloen.melon.net.v6x.response.DjHomeMainRes.DJGUIDEBTNS.SUBCONTENTLIST)object9).scheme));
                        }
                    }
                    arrayList0.add(new B2(s19, arrayList10));
                }
            }
            return new E2(arrayList0);
        }
        if(d10 instanceof Z0) {
            return new C2(((Z0)d10).a);
        }
        if(d10 instanceof a1) {
            e30.cancelFetch();
            return null;
        }
        if(!(d10 instanceof b1)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return new D2(((b1)d10).a);
    }

    public final Context d() {
        Context context0 = this.g;
        if(context0 != null) {
            return context0;
        }
        q.m("context");
        throw null;
    }

    public final f e() {
        String s = null;
        if(this.getTiaraProperty() == null) {
            return null;
        }
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        s s1 = this.getTiaraProperty();
        f0.b = s1 == null ? null : s1.a;
        s s2 = this.getTiaraProperty();
        f0.c = s2 == null ? null : s2.b;
        s s3 = this.getTiaraProperty();
        if(s3 != null) {
            s = s3.c;
        }
        f0.I = s;
        return f0;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        String s;
        L0 l01;
        a3 a30;
        if(continuation0 instanceof a3) {
            a30 = (a3)continuation0;
            int v = a30.E;
            if((v & 0x80000000) == 0) {
                a30 = new a3(this, ((oe.c)continuation0));
            }
            else {
                a30.E = v ^ 0x80000000;
            }
        }
        else {
            a30 = new a3(this, ((oe.c)continuation0));
        }
        Object object0 = a30.B;
        a a0 = a.a;
        switch(a30.E) {
            case 0: {
                n.D(object0);
                LogU.info$default(this.f, "onFetchStart() type: " + g10, null, false, 6, null);
                L0 l00 = this.getProgressUpdater();
                c c0 = this.a;
                if(l00 == null) {
                    a30.r = null;
                    a30.w = null;
                    a30.E = 1;
                    object0 = c0.g(a30);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_40;
                }
                else {
                    l00.a("MelonDjHomeMainViewModel true", true);
                    try {
                        a30.r = l00;
                        a30.w = "MelonDjHomeMainViewModel";
                        a30.E = 2;
                        object0 = c0.g(a30);
                    }
                    catch(Throwable throwable0) {
                        l01 = l00;
                        s = "MelonDjHomeMainViewModel";
                        Y.v(s, " false", l01, false);
                        throw throwable0;
                    }
                    if(object0 == a0) {
                        return a0;
                    }
                    l01 = l00;
                    s = "MelonDjHomeMainViewModel";
                    goto label_48;
                }
                break;
            }
            case 1: {
                n.D(object0);
            label_40:
                K4 k40 = this.handleDefaultHttpResponseResult(((Na.f)object0), new dd.z(this, 20));
                if(k40 != null) {
                    LogU.info$default(this.f, "uiState: " + k40, null, false, 6, null);
                    this.updateUiState(new Cd.t(k40, 22));
                    return H.a;
                }
                break;
            }
            case 2: {
                try {
                    s = a30.w;
                    l01 = a30.r;
                    n.D(object0);
                label_48:
                    K4 k41 = this.handleDefaultHttpResponseResult(((Na.f)object0), new dd.z(this, 20));
                    if(k41 != null) {
                        LogU.info$default(this.f, "uiState: " + k41, null, false, 6, null);
                        this.updateUiState(new Cd.t(k41, 22));
                    }
                }
                catch(Throwable throwable0) {
                    Y.v(s, " false", l01, false);
                    throw throwable0;
                }
                Y.v(s, " false", l01, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        StringProviderImpl stringProviderImpl0 = this.e;
        if(e0 instanceof W2) {
            A a0 = ((W2)e0).a;
            String s = a0.f;
            String s1 = a0.e;
            if(q.b(s1, "N10082")) {
                Navigator navigator0 = Navigator.INSTANCE;
                String s2 = this.getMenuId();
                if(s2.length() == 0) {
                    s2 = "1000002296";
                }
                navigator0.openStationListen(s, s2);
                f f0 = this.e();
                if(f0 == null) {
                    return;
                }
                Context context0 = this.d();
                ActionKind actionKind0 = ActionKind.PlayMusic;
                int v = ((W2)e0).b;
                String s3 = stringProviderImpl0.a(0x7F130EDE);  // string:tiara_melon_dj_layer1_tpo_recommend "TPO추천"
                String s4 = a0.f;
                if(s1 == null) {
                    s1 = "";
                }
                com.google.firebase.b.O(f0, context0, null, s3, actionKind0, null, v, s4, p8.b.a(s1), a0.d, "", null, false, 0, 7186);
                return;
            }
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.a = s1;
            melonLinkInfo0.n = s;
            melonLinkInfo0.o = s1;
            MelonLinkExecutor.open(melonLinkInfo0);
            ActionKind actionKind1 = q.b(s1, "N10003") ? ActionKind.PlayVideo : ActionKind.ClickContent;
            f f1 = this.e();
            if(f1 == null) {
                return;
            }
            Context context1 = this.d();
            int v1 = ((W2)e0).b;
            String s5 = stringProviderImpl0.a(0x7F130EDE);  // string:tiara_melon_dj_layer1_tpo_recommend "TPO추천"
            String s6 = a0.f;
            if(s1 == null) {
                s1 = "";
            }
            com.google.firebase.b.O(f1, context1, null, s5, actionKind1, null, v1, s6, p8.b.a(s1), a0.d, "", null, false, 0, 7186);
            return;
        }
        Q q0 = this.d;
        if(e0 instanceof X2) {
            A a1 = ((X2)e0).a;
            String s7 = a1.g;
            if(s7 != null) {
                q0.d(new com.melon.ui.k(s7, this.getMenuId(), null, 0x20), f0.h(this), new gd.Z0(1, this, e3.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 25));
            }
            f f2 = this.e();
            if(f2 == null) {
                return;
            }
            Context context2 = this.d();
            String s8 = stringProviderImpl0.a(0x7F130EDE);  // string:tiara_melon_dj_layer1_tpo_recommend "TPO추천"
            String s9 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f2, context2, null, s8, ActionKind.PlayMusic, null, ((X2)e0).b, a1.g, s9, a1.h, a1.i, null, false, 0, 7186);
            return;
        }
        if(e0 instanceof V2) {
            A a2 = ((V2)e0).a;
            Navigator.openDjPlaylistDetail(a2.g);
            f f3 = this.e();
            if(f3 == null) {
                return;
            }
            Context context3 = this.d();
            String s10 = stringProviderImpl0.a(0x7F130EDE);  // string:tiara_melon_dj_layer1_tpo_recommend "TPO추천"
            String s11 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f3, context3, null, s10, ActionKind.ClickContent, null, ((V2)e0).b, a2.g, s11, a2.h, a2.i, null, false, 0, 7186);
            return;
        }
        if(e0 instanceof U2) {
            f f4 = this.e();
            if(f4 == null) {
                return;
            }
            com.google.firebase.b.O(f4, this.d(), ((U2)e0).a, ((U2)e0).b, null, ((U2)e0).c, 0, null, null, null, null, null, false, 0, 0x1FE0);
            return;
        }
        if(e0 instanceof S2) {
            Navigator.INSTANCE.openMelonDJThemeGenre();
            f f5 = this.e();
            if(f5 == null) {
                return;
            }
            com.google.firebase.b.O(f5, this.d(), null, ((S2)e0).a, null, ((S2)e0).b, 0, null, null, null, null, null, false, 0, 8170);
            return;
        }
        if(e0 instanceof T2) {
            Navigator.openMelonDJTagHubDetail(((T2)e0).b);
            f f6 = this.e();
            if(f6 == null) {
                return;
            }
            com.google.firebase.b.O(f6, this.d(), null, stringProviderImpl0.a(0x7F130EDC), ActionKind.ClickContent, null, ((T2)e0).c, ((T2)e0).b, null, ((T2)e0).a, null, null, false, 0, 7826);  // string:tiara_melon_dj_layer1_tag_playlist "태그플레이리스트"
            return;
        }
        if(e0 instanceof H2) {
            v v2 = ((H2)e0).a;
            Navigator.openDjPlaylistDetail(v2.g);
            f f7 = this.e();
            if(f7 == null) {
                return;
            }
            Context context4 = this.d();
            String s12 = stringProviderImpl0.a(0x7F130ED6);  // string:tiara_melon_dj_layer1_popular_playlist "인기플레이리스트"
            String s13 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f7, context4, null, s12, ActionKind.ClickContent, null, ((H2)e0).b, v2.g, s13, v2.h, v2.i, null, false, 0, 7186);
            return;
        }
        if(e0 instanceof I2) {
            v v3 = ((I2)e0).a;
            String s14 = v3.g;
            if(s14 != null) {
                q0.d(new com.melon.ui.k(s14, this.getMenuId(), null, 0x20), f0.h(this), new gd.Z0(1, this, e3.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 26));
            }
            f f8 = this.e();
            if(f8 == null) {
                return;
            }
            Context context5 = this.d();
            String s15 = stringProviderImpl0.a(0x7F130ED6);  // string:tiara_melon_dj_layer1_popular_playlist "인기플레이리스트"
            String s16 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f8, context5, null, s15, ActionKind.PlayMusic, null, ((I2)e0).b, v3.g, s16, v3.h, v3.i, null, false, 0, 7186);
            return;
        }
        if(e0 instanceof J2) {
            Navigator.INSTANCE.openMelonDjPopular();
            f f9 = this.e();
            if(f9 == null) {
                return;
            }
            com.google.firebase.b.O(f9, this.d(), null, ((J2)e0).a, null, ((J2)e0).b, 0, null, null, null, null, null, false, 0, 8170);
            return;
        }
        if(e0 instanceof R2) {
            y y0 = ((R2)e0).a;
            Navigator.openUserMain(y0.b);
            f f10 = this.e();
            if(f10 == null) {
                return;
            }
            com.google.firebase.b.O(f10, this.d(), null, stringProviderImpl0.a(0x7F130EDB), ActionKind.ClickContent, null, ((R2)e0).b, null, null, null, y0.c, null, false, 0, 7634);  // string:tiara_melon_dj_layer1_special_dj "이주의DJ"
            return;
        }
        if(e0 instanceof Z2) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new b3(this, e0, null), 2, null);
            return;
        }
        if(e0 instanceof M2) {
            x x0 = ((M2)e0).a;
            Navigator.openUserMain(x0.b);
            f f11 = this.e();
            if(f11 == null) {
                return;
            }
            com.google.firebase.b.O(f11, this.d(), null, stringProviderImpl0.a(0x7F130ED7), ActionKind.ClickContent, null, 0, null, null, null, x0.c, null, false, ((M2)e0).b, 0xDF2);  // string:tiara_melon_dj_layer1_power_dj "파워DJ"
            return;
        }
        if(e0 instanceof N2) {
            Navigator.INSTANCE.openMelonPowerDj();
            f f12 = this.e();
            if(f12 == null) {
                return;
            }
            com.google.firebase.b.O(f12, this.d(), null, ((N2)e0).a, null, ((N2)e0).b, 0, null, null, null, null, null, false, 0, 8170);
            return;
        }
        if(e0 instanceof Y2) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new c3(this, e0, null), 2, null);
            return;
        }
        if(e0 instanceof L2) {
            gd.k k0 = ((L2)e0).a;
            Navigator.openDjPlaylistDetail(k0.c);
            f f13 = this.e();
            if(f13 == null) {
                return;
            }
            Context context6 = this.d();
            String s17 = stringProviderImpl0.a(0x7F130ED7);  // string:tiara_melon_dj_layer1_power_dj "파워DJ"
            String s18 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f13, context6, null, s17, ActionKind.ClickContent, null, 0, k0.c, s18, k0.b, k0.d, null, false, ((L2)e0).b, 3090);
            return;
        }
        if(e0 instanceof K2) {
            gd.k k1 = ((K2)e0).a;
            String s19 = k1.c;
            if(s19 != null) {
                q0.d(new com.melon.ui.k(s19, this.getMenuId(), null, 0x20), f0.h(this), new gd.Z0(1, this, e3.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 27));
            }
            f f14 = this.e();
            if(f14 == null) {
                return;
            }
            Context context7 = this.d();
            String s20 = stringProviderImpl0.a(0x7F130ED7);  // string:tiara_melon_dj_layer1_power_dj "파워DJ"
            String s21 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f14, context7, null, s20, ActionKind.PlayMusic, null, ((K2)e0).c, k1.c, s21, k1.b, k1.d, null, false, ((K2)e0).b, 3090);
            return;
        }
        if(e0 instanceof Q2) {
            H3 h30 = d3.g.U("POWERDJ", null);
            Navigator.INSTANCE.open(h30);
            f f15 = this.e();
            if(f15 == null) {
                return;
            }
            com.google.firebase.b.O(f15, this.d(), null, ((Q2)e0).a, null, ((Q2)e0).b, 0, null, null, null, null, null, false, 0, 8170);
            return;
        }
        if(e0 instanceof P2) {
            gd.w w0 = ((P2)e0).a;
            String s22 = w0.e;
            if(s22 != null) {
                q0.d(new com.melon.ui.k(s22, this.getMenuId(), null, 0x20), f0.h(this), new gd.Z0(1, this, e3.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 28));
            }
            f f16 = this.e();
            if(f16 == null) {
                return;
            }
            Context context8 = this.d();
            String s23 = stringProviderImpl0.a(0x7F130ED8);  // string:tiara_melon_dj_layer1_power_dj_playlist "파워DJ의플레이리스트"
            String s24 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f16, context8, null, s23, ActionKind.PlayMusic, null, ((P2)e0).b, w0.e, s24, w0.b, w0.f, null, false, 0, 7186);
            return;
        }
        if(e0 instanceof O2) {
            gd.w w1 = ((O2)e0).a;
            Navigator.openDjPlaylistDetail(w1.e);
            f f17 = this.e();
            if(f17 == null) {
                return;
            }
            Context context9 = this.d();
            String s25 = stringProviderImpl0.a(0x7F130ED8);  // string:tiara_melon_dj_layer1_power_dj_playlist "파워DJ의플레이리스트"
            String s26 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f17, context9, null, s25, ActionKind.ClickContent, null, ((O2)e0).b, w1.e, s26, w1.b, w1.f, null, false, 0, 7186);
            return;
        }
        if(e0 instanceof G2) {
            u u0 = ((G2)e0).a;
            boolean z = TextUtils.isEmpty(u0.d);
            Navigator.openUserMainIncludeSelf(u0.d, z);
            f f18 = this.e();
            if(f18 == null) {
                return;
            }
            com.google.firebase.b.O(f18, this.d(), null, stringProviderImpl0.a(0x7F130ED5), ActionKind.ClickContent, null, ((G2)e0).b, null, null, null, u0.c, null, false, 0, 7634);  // string:tiara_melon_dj_layer1_new_dj "반가워요DJ"
            return;
        }
        if(e0 instanceof F2) {
            t t0 = ((F2)e0).a;
            if(((F2)e0).b && !((e0)this.c).m()) {
                this.sendUiEvent(s4.a);
                return;
            }
            MelonLinkInfo melonLinkInfo1 = new MelonLinkInfo();
            melonLinkInfo1.a = t0.c;
            melonLinkInfo1.b = t0.b;
            melonLinkInfo1.c = t0.d;
            MelonLinkExecutor.open(melonLinkInfo1);
            f f19 = this.e();
            if(f19 != null) {
                com.google.firebase.b.O(f19, this.d(), null, stringProviderImpl0.a(0x7F130ED3), null, t0.a, 0, null, null, null, null, null, false, 0, 8170);  // string:tiara_melon_dj_layer1_info_apply "안내및신청하기"
            }
            return;
        }
        super.onUserEvent(e0);
    }
}

