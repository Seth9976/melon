package gd;

import Ac.m4;
import Cd.t;
import H8.q;
import Pc.a;
import Pc.b;
import Pc.e;
import android.content.Context;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v6x.response.PowerDjListRes.RESPONSE.POWERDJLIST;
import com.iloen.melon.net.v6x.response.PowerDjListRes.RESPONSE;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.H4;
import com.melon.ui.L2;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.b3;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.f1;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.q4;
import d3.g;
import d5.n;
import e1.u;
import h7.u0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import oe.c;
import p8.f;
import p8.s;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lgd/d5;", "Lcom/melon/ui/k1;", "LPc/a;", "Lgd/L4;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class d5 extends k1 implements a {
    public final b a;
    public final StringProviderImpl b;
    public final x9.a c;
    public final q d;
    public final Za.b e;
    public final b3 f;
    public int g;
    public int h;
    public final LogU i;
    public Context j;
    public String k;
    public final r l;
    public final r m;
    public static final int n;

    public d5(StringProviderImpl stringProviderImpl0, x9.a a0, q q0, Za.b b0, b3 b30) {
        this.a = new b();
        this.b = stringProviderImpl0;
        this.c = a0;
        this.d = q0;
        this.e = b0;
        this.f = b30;
        LogU logU0 = new LogU("FetchViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.i = logU0;
        this.l = g.Q(new V4(this, 0));
        this.m = g.Q(new V4(this, 1));
    }

    @Override  // Pc.a
    public final boolean a() {
        return this.a.b;
    }

    public static m4 c(d5 d50, g1 g10, d1 d10) {
        b b0 = d50.a;
        kotlin.jvm.internal.q.g(d10, "fetchResult");
        if(d10 instanceof c1) {
            RESPONSE powerDjListRes$RESPONSE0 = (RESPONSE)((c1)d10).a;
            d50.k = powerDjListRes$RESPONSE0.powerDjListToolTip;
            StringProviderImpl stringProviderImpl0 = d50.b;
            ArrayList arrayList0 = new ArrayList();
            if(g10 instanceof f1) {
                String s = String.format(stringProviderImpl0.a(0x7F130657), Arrays.copyOf(new Object[]{powerDjListRes$RESPONSE0.powerDjCnt}, 1));  // string:melondj_power_dj_list_act_count "%1$s명의 파워DJ가 활동 중입니다."
                int v = d50.g;
                Object object0 = d50.m.getValue();
                arrayList0.add(new K4(v, d50.h, s, ((List)object0), ((List)d50.l.getValue())));
            }
            String s1 = u.v(((e0)o.a()).j());
            ArrayList arrayList1 = powerDjListRes$RESPONSE0.powerDjList;
            kotlin.jvm.internal.q.f(arrayList1, "powerDjList");
            ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
            for(Object object1: arrayList1) {
                String s2 = ((POWERDJLIST)object1).memberkey;
                String s3 = ((POWERDJLIST)object1).memberDjIconType;
                String s4 = StringUtils.getFriendDisplayName(s2, ((POWERDJLIST)object1).memberNickName);
                boolean z = ((POWERDJLIST)object1).isOfficial;
                arrayList2.add(Boolean.valueOf(arrayList0.add(new J4(s2, s3, s4, ((POWERDJLIST)object1).djTitle, String.format(stringProviderImpl0.a(0x7F130444), Arrays.copyOf(new Object[]{((POWERDJLIST)object1).followerCnt}, 1)), ((POWERDJLIST)object1).myPageImg, s1, z, ((POWERDJLIST)object1).isMyFriend))));  // string:follower_with_count "팔로워 %s"
            }
            b0.d(arrayList0, powerDjListRes$RESPONSE0.hasMore);
            return new O4(p.P0(b0.a));
        }
        if(d10 instanceof Z0) {
            return new M4(((Z0)d10).a);
        }
        if(d10 instanceof a1) {
            d50.cancelFetch();
            return null;
        }
        if(!(d10 instanceof b1)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return new N4(((b1)d10).a);
    }

    public final Context d() {
        Context context0 = this.j;
        if(context0 != null) {
            return context0;
        }
        kotlin.jvm.internal.q.m("context");
        throw null;
    }

    public final f e() {
        String s = null;
        if(this.getTiaraProperty() == null) {
            return null;
        }
        f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
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
        g1 g11;
        String s1;
        com.melon.ui.K4 k40;
        L0 l01;
        Object object1;
        String s;
        L0 l00;
        W4 w40;
        if(continuation0 instanceof W4) {
            w40 = (W4)continuation0;
            int v = w40.G;
            if((v & 0x80000000) == 0) {
                w40 = new W4(this, ((c)continuation0));
            }
            else {
                w40.G = v ^ 0x80000000;
            }
        }
        else {
            w40 = new W4(this, ((c)continuation0));
        }
        Object object0 = w40.D;
        ne.a a0 = ne.a.a;
        switch(w40.G) {
            case 0: {
                n.D(object0);
                l00 = this.getProgressUpdater();
                s = "FetchViewModel";
                b b0 = this.a;
                if(l00 == null) {
                    if(g10 instanceof f1) {
                        b0.c();
                    }
                    Deferred deferred0 = u0.j(this, Dispatchers.getDefault(), new X4(this, null), 2);
                    w40.r = g10;
                    w40.w = null;
                    w40.B = null;
                    w40.G = 1;
                    object0 = deferred0.await(w40);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_44;
                }
                else {
                    l00.a("FetchViewModel true", true);
                    try {
                        if(g10 instanceof f1) {
                            b0.c();
                        }
                        Deferred deferred1 = u0.j(this, Dispatchers.getDefault(), new X4(this, null), 2);
                        w40.r = g10;
                        w40.w = l00;
                        w40.B = "FetchViewModel";
                        w40.G = 2;
                        object1 = deferred1.await(w40);
                        if(object1 == a0) {
                            return a0;
                        }
                        l01 = l00;
                        k40 = this.handleDefaultHttpResponseResult(((Na.f)object1), new l(23, this, g10));
                        goto label_57;
                    }
                    catch(Throwable throwable0) {
                        l01 = l00;
                        throwable1 = throwable0;
                        s1 = s;
                        goto label_67;
                    }
                    return a0;
                }
                break;
            }
            case 1: {
                g10 = w40.r;
                n.D(object0);
            label_44:
                com.melon.ui.K4 k41 = this.handleDefaultHttpResponseResult(((Na.f)object0), new l(23, this, g10));
                if(k41 != null) {
                    this.updateUiState(new t(k41, 26));
                    return H.a;
                }
                break;
            }
            case 2: {
                try {
                    s1 = w40.B;
                    l01 = w40.w;
                    g11 = w40.r;
                    n.D(object0);
                    s = s1;
                }
                catch(Throwable throwable1) {
                    goto label_67;
                }
                try {
                    k40 = this.handleDefaultHttpResponseResult(((Na.f)object0), new l(23, this, g11));
                label_57:
                    if(k40 != null) {
                        this.updateUiState(new t(k40, 26));
                    }
                    goto label_69;
                }
                catch(Throwable throwable1) {
                    while(true) {
                        try {
                            s1 = s;
                            goto label_67;
                        }
                        catch(Throwable throwable0) {
                        }
                        break;
                    }
                }
                l01 = l00;
                throwable1 = throwable0;
                s1 = s;
            label_67:
                Y.v(s1, " false", l01, false);
                throw throwable1;
            label_69:
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
        kotlin.jvm.internal.q.g(e0, "userEvent");
        StringProviderImpl stringProviderImpl0 = this.b;
        if(e0 instanceof T4) {
            String s = this.k;
            if(s == null || s.length() <= 0) {
                return;
            }
            this.sendUiEvent(new q4(28, ((T4)e0).a, s, null, null));
            f f0 = this.e();
            if(f0 == null) {
                return;
            }
            com.google.firebase.b.O(f0, this.d(), null, stringProviderImpl0.a(0x7F130DF3), null, stringProviderImpl0.a(0x7F130D3B), 0, null, null, null, null, null, false, 0, 8170);  // string:tiara_common_layer1_gnb "GNB"
            return;
        }
        if(e0 instanceof Q4) {
            J4 j40 = ((Q4)e0).a;
            Navigator.openUserMain(j40.a);
            f f1 = this.e();
            if(f1 != null) {
                com.google.firebase.b.O(f1, this.d(), null, stringProviderImpl0.a(0x7F130ED4), ActionKind.ClickContent, null, ((Q4)e0).b, null, null, null, j40.c, null, false, this.g, 0xDD2);  // string:tiara_melon_dj_layer1_list "리스트"
            }
            return;
        }
        if(e0 instanceof P4) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new Y4(e0, this, null), 2, null);
            return;
        }
        if(e0 instanceof R4) {
            this.sendUiEvent(new H4(((R4)e0).a, this.h));
            return;
        }
        if(e0 instanceof S4) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new Z4(e0, this, null), 2, null);
            return;
        }
        if(e0 instanceof U4) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new a5(e0, this, null), 2, null);
            return;
        }
        if(e0 instanceof L2) {
            T2.a a0 = f0.h(this);
            boolean z = ((e0)o.a()).m();
            j3 j30 = new j3(1, this, d5.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 27);
            L0 l00 = this.getProgressUpdater();
            this.f.b(((L2)e0), a0, z, j30, l00);
            return;
        }
        super.onUserEvent(e0);
    }
}

