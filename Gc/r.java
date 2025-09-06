package gc;

import A8.b;
import Nb.z0;
import Sb.a;
import U4.F;
import Vb.L;
import Vb.o0;
import Vb.t0;
import Yb.f;
import Yb.g;
import Yb.h;
import Yb.k;
import Yb.m;
import Yb.p;
import android.app.Service;
import b3.E;
import com.iloen.melon.drm.DcfError;
import com.iloen.melon.drm.DcfFile;
import com.iloen.melon.eventbus.EventAlertDialog;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventDrmAutoExtensionNotAllowed;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.AndroidSettings;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.utils.lifecycle.AppVisibilityManagerImpl;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import jc.j;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import va.e0;
import va.e;
import va.o;
import we.n;

public final class r extends i implements n {
    public final z0 B;
    public final a D;
    public final E E;
    public int r;
    public final y w;

    public r(y y0, z0 z00, a a0, E e0, Continuation continuation0) {
        this.w = y0;
        this.B = z00;
        this.D = a0;
        this.E = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        H h1;
        List list0;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                y y0 = this.w;
                LogU logU0 = y0.l;
                StringBuilder stringBuilder0 = new StringBuilder();
                StringBuilder stringBuilder1 = new StringBuilder();
                a a1 = this.D;
                stringBuilder1.append("[" + a1.b() + "] " + a1.getMessage());
                String s = a1.a();
                if(s.length() <= 0) {
                    s = null;
                }
                if(s != null) {
                    Cb.i.a(stringBuilder1, "Error: " + s);
                }
                stringBuilder0.append("handleError() " + stringBuilder1.toString());
                if(!b.d()) {
                    StackTraceElement[] arr_stackTraceElement = a1.getStackTrace();
                    if(7 >= arr_stackTraceElement.length) {
                        list0 = je.n.z0(arr_stackTraceElement);
                    }
                    else {
                        ArrayList arrayList0 = new ArrayList(7);
                        int v1 = 0;
                        for(int v = 0; v < arr_stackTraceElement.length; ++v) {
                            arrayList0.add(arr_stackTraceElement[v]);
                            ++v1;
                            if(v1 == 7) {
                                break;
                            }
                        }
                        list0 = arrayList0;
                    }
                    for(Object object1: list0) {
                        String s1 = ((StackTraceElement)object1).toString();
                        q.f(s1, "toString(...)");
                        Cb.i.a(stringBuilder0, s1);
                    }
                }
                LogU.error$default(logU0, stringBuilder0.toString(), null, false, 6, null);
                t0 t00 = ((o0)y0).F;
                Service service0 = ((o0)y0).j;
                E e0 = this.E;
                j.c(("handleMediaPlayerException() " + F.D(e0) + ", " + a1));
                if(a1 instanceof g) {
                    if(((AppVisibilityManagerImpl)t00.a).e) {
                        NetUtils.showNetworkInfoPopupIfNotConnected(service0);
                    }
                    else {
                        ToastManager.showShort(0x7F1300AE);  // string:alert_dlg_body_mobile_data_network_check_toast "데이터 네트워크 차단 시\n단말에 저장된 콘텐츠만 
                                                             // 재생됩니다."
                    }
                    y.K0(((o0)y0), false, 0, null, "handleMediaPlayerException() CheckNetworkException", 7);
                    h1 = h0;
                }
                else if(a1 instanceof m) {
                    LogU.error$default(((o0)y0).e1(), e.b("handleDrmException() ", ((m)a1).getMessage()), null, false, 6, null);
                    if(((m)a1) instanceof k) {
                        DcfError dcfError0 = ((k)(((m)a1))).d;
                        Mc.q q0 = new Mc.q(((o0)y0), 26);
                        if(AndroidSettings.isAirplaneMode()) {
                            ToastManager.show(0x7F1302AD);  // string:dcf_check_airplane_mode "DCF 파일 재생을 위해 설정에서 비행기모드를 해제한 후 이용해주세요."
                            ((o0)y0).q1();
                        }
                        else {
                            String s2 = dcfError0.getMessage();
                            if(s2 == null) {
                                s2 = "DCF 파일의 재생 기간을 연장하지 못하였습니다.";
                                q.f("DCF 파일의 재생 기간을 연장하지 못하였습니다.", "getString(...)");
                            }
                            if(dcfError0.a != -101) {
                                DcfFile dcfFile0 = dcfError0.b;
                                if(dcfFile0 != null) {
                                    R8.r.d(1, dcfFile0.c(), s2);
                                }
                                q0.invoke(s2);
                            }
                            else if(NetUtils.checkDataNetwork() == 2) {
                                q.f("네트워크에 연결되어 있지 않아 기간 연장을 진행할 수 없습니다.", "getString(...)");
                                q0.invoke("네트워크에 연결되어 있지 않아 기간 연장을 진행할 수 없습니다.");
                            }
                            else {
                                if(!NetUtils.isConnected()) {
                                    s2 = "네트워크에 연결되어 있지 않아 기간 연장을 진행할 수 없습니다.";
                                }
                                else if(!((e0)o.a()).m()) {
                                    s2 = "DCF 파일의 재생 기간 연장은 로그인이 필요합니다. 로그인 후 다시 시도해 주세요.";
                                }
                                q.d(s2);
                                q0.invoke(s2);
                            }
                        }
                    }
                    else if(((AppVisibilityManagerImpl)t00.a).e) {
                        if(((m)a1) instanceof h) {
                            EventBusHelper.post(new EventDrmAutoExtensionNotAllowed(((h)(((m)a1)))));
                        }
                        else {
                            ToastManager.show("DCF 파일의 재생 기간을 연장하지 못하였습니다.");
                        }
                        y.K0(((o0)y0), false, 0, null, "handleDrmException() Fail to extend DCF", 7);
                    }
                    else {
                        ToastManager.show("DCF 파일의 재생 기간을 연장하지 못하였습니다.");
                        ((o0)y0).q1();
                    }
                    h1 = h0;
                }
                else if(a1 instanceof Yb.r) {
                    LogU.error$default(((o0)y0).e1(), e.b("handleOfflineModeException() ", ((Yb.r)a1).getMessage()), null, false, 6, null);
                    if(((Yb.r)a1) instanceof Yb.q) {
                        ToastManager.show(0x7F1302B2);  // string:dcf_error_not_allow_manual_timeset "재생 권한 확인을 위해 기기 설정에서 시간정보를 자동으로 변경해주세요."
                    }
                    else {
                        if(!(((Yb.r)a1) instanceof p)) {
                            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                        }
                        EventBusHelper.post(new EventAlertDialog("안내", "오프라인 재생을 위한 인증 정보를 확인 할 수 없습니다.\n\n네트워크 통신 상태에서 기기인증 여부를 확인해주세요."));
                    }
                    y.K0(((o0)y0), false, 0, null, e.b("handleOfflineModeException() ", ((Yb.r)a1).getMessage()), 7);
                    h1 = h0;
                }
                else if(a1 instanceof Yb.n) {
                    f f0 = ((Yb.n)a1).c;
                    LogConstantsKt.buildDebug$default(((o0)y0).e1(), false, new Mc.q(f0, 25), 1, null);
                    int v2 = !(f0.b instanceof Yb.e) || !q.b(((E)f0.b.a), ((o0)y0).W()) ? -1 : ((o0)y0).L();
                    if(q.b(f0.a, Yb.a.a)) {
                        ((o0)y0).q1();
                    }
                    else {
                        y.K0(((o0)y0), false, 0, null, e.b("handleMelonNotificationException() ", ((Yb.n)a1).getMessage()), 7);
                    }
                    if(v2 != -1) {
                        L l0 = new L(((o0)y0), v2, null);
                        BuildersKt__Builders_commonKt.launch$default(((o0)y0).u, ((o0)y0).v, null, l0, 2, null);
                    }
                    h1 = h0;
                }
                else {
                    z0 z00 = this.B;
                    if(a1 instanceof Yb.o) {
                        ((o0)y0).k1(((Yb.o)a1), z00, e0);
                        h1 = h0;
                    }
                    else {
                        h1 = ((o0)y0).i1(z00, a1, e0, this);
                        if(h1 != ne.a.a) {
                            h1 = h0;
                        }
                    }
                }
                if(h1 != ne.a.a) {
                    h1 = h0;
                }
                return h1 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

