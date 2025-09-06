package Mb;

import Ib.a;
import Ib.b;
import Pc.d;
import Q8.g;
import Q8.h;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPremiumDownload.EventPremiumDownloadItem;
import com.iloen.melon.eventbus.EventPremiumDownload;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.interfaces.StringProviderImpl;
import d5.n;
import ie.H;
import java.util.List;
import jeb.synthetic.FIN;
import k8.Y;
import k9.e;
import k9.j;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import oe.c;
import oe.i;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import we.k;

public final class v {
    public final d a;
    public final a b;
    public final T2.a c;
    public final k d;
    public final CoroutineDispatcher e;
    public boolean f;
    public final LogU g;
    public boolean h;
    public int i;
    public final MutableStateFlow j;
    public final StateFlow k;
    public final MutableStateFlow l;
    public final StateFlow m;

    public v(d d0, a a0, T2.a a1, k k0) {
        this.a = d0;
        this.b = a0;
        this.c = a1;
        this.d = k0;
        this.e = Dispatchers.getIO();
        this.g = LogU.Companion.create("OfflinePlaylistHelper", true, Category.UI);
        this.i = -1;
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(b.c);
        this.j = mutableStateFlow0;
        this.k = FlowKt.asStateFlow(mutableStateFlow0);
        MutableStateFlow mutableStateFlow1 = StateFlowKt.MutableStateFlow("");
        this.l = mutableStateFlow1;
        this.m = FlowKt.asStateFlow(mutableStateFlow1);
        EventBusHelper.register(this);
        Job job0 = (Job)a1.a.get(Job.Key);
        if(job0 != null) {
            job0.invokeOnCompletion(new Mb.a(this, 0));
        }
    }

    public final void a() {
        if(((b)this.k.getValue()).a) {
            s s0 = new s(this, null);
            BuildersKt__Builders_commonKt.launch$default(this.c, null, null, s0, 3, null);
        }
    }

    public static boolean b(String s) {
        q.g(s, "contentId");
        return e.c(s, "1").booleanValue();
    }

    public final void c() {
        if(NetUtils.isConnected()) {
            Mb.a a0 = new Mb.a(this, 1);
            Lb.a a1 = new Lb.a(((StringProviderImpl)this.a).a(0x7F1300D0), a0, ((StringProviderImpl)this.a).a(0x7F130865));  // string:alert_dlg_title_info "안내"
            this.d.invoke(a1);
        }
    }

    public final Object d(i i0) {
        H h0 = H.a;
        if(this.f) {
            LogU.debug$default(this.g, "processOfflineScenario is started already.", null, false, 6, null);
            return h0;
        }
        this.f = true;
        int v = j.a();
        LogU.debug$default(this.g, "processPremiumScenario state: " + Y.B(v), null, false, 6, null);
        int v1 = Mb.b.a[e0.b.b(v)];
        d d0 = this.a;
        switch(v1) {
            case 1: {
                LogU.debug$default(this.g, "checkOfflineDevice", null, false, 6, null);
                if(!NetUtils.isConnected()) {
                    this.f = false;
                    v.g(this, ((StringProviderImpl)d0).a(0x7F1300D0), ((StringProviderImpl)d0).a(0x7F130864));  // string:alert_dlg_title_info "안내"
                    return h0;
                }
                LogU.debug$default(this.g, "requestStreamingDeviceInfo", null, false, 6, null);
                p p0 = new p(this, null);
                BuildersKt__Builders_commonKt.launch$default(this.c, Dispatchers.getIO(), null, p0, 2, null);
                return h0;
            }
            case 2: {
                if(NetUtils.isConnected()) {
                    this.f = false;
                    return h0;
                }
                this.f = false;
                v.g(this, ((StringProviderImpl)d0).a(0x7F1300D0), ((StringProviderImpl)d0).a(0x7F130864));  // string:alert_dlg_title_info "안내"
                return h0;
            }
            case 3: {
                Object object0 = this.e(i0);
                return object0 == ne.a.a ? object0 : h0;
            }
            case 4: {
                this.c();
                return h0;
            }
            default: {
                this.c();
                return h0;
            }
        }
    }

    public final Object e(c c0) {
        Mb.d d0;
        if(c0 instanceof Mb.d) {
            d0 = (Mb.d)c0;
            int v = d0.B;
            if((v & 0x80000000) == 0) {
                d0 = new Mb.d(this, c0);
            }
            else {
                d0.B = v ^ 0x80000000;
            }
        }
        else {
            d0 = new Mb.d(this, c0);
        }
        Object object0 = d0.r;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(d0.B) {
            case 0: {
                n.D(object0);
                d0.B = 1;
                object0 = this.b.isOfflineModeFromLocalData(d0);
                if(object0 == a0) {
                    return a0;
                }
                goto label_22;
            }
            case 1: {
                n.D(object0);
            label_22:
                if(!((Boolean)object0).booleanValue()) {
                    b b0 = (b)this.k.getValue();
                    b.b.getClass();
                    q.g(b0, "state");
                    if(b0 != b.h) {
                        this.f = false;
                        d0.B = 3;
                        return this.j(d0) == a0 ? a0 : h0;
                    }
                }
                this.f = false;
                d0.B = 2;
                if(this.i(d0) == a0) {
                    return a0;
                }
                ToastManager.show(0x7F130869);  // string:premium_scenario_turn_off "오프라인 재생모드를 해제합니다."
                return h0;
            }
            case 2: {
                break;
            }
            case 3: {
                n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n.D(object0);
        ToastManager.show(0x7F130869);  // string:premium_scenario_turn_off "오프라인 재생모드를 해제합니다."
        return h0;
    }

    public final Object f(String s, c c0) {
        Mb.e e0;
        if(c0 instanceof Mb.e) {
            e0 = (Mb.e)c0;
            int v = e0.D;
            if((v & 0x80000000) == 0) {
                e0 = new Mb.e(this, c0);
            }
            else {
                e0.D = v ^ 0x80000000;
            }
        }
        else {
            e0 = new Mb.e(this, c0);
        }
        Object object0 = e0.w;
        ne.a a0 = ne.a.a;
        switch(e0.D) {
            case 0: {
                n.D(object0);
                f f0 = new f(this, null);
                e0.r = s;
                e0.D = 1;
                object0 = BuildersKt.withContext(this.e, f0, e0);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                s = e0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        boolean z = ((Boolean)object0).booleanValue();
        LogU.debug$default(this.g, "refreshOfflineState stateFromLocal: " + z + ", fromCall: " + s, null, false, 6, null);
        this.j.setValue((z ? b.e : b.g));
        return H.a;
    }

    public static void g(v v0, String s, String s1) {
        Lb.a a0 = new Lb.a(s, null, s1);
        v0.d.invoke(a0);
    }

    public final Object h(c c0) {
        boolean z2;
        Mb.q q0;
        if(c0 instanceof Mb.q) {
            q0 = (Mb.q)c0;
            int v = q0.D;
            if((v & 0x80000000) == 0) {
                q0 = new Mb.q(this, c0);
            }
            else {
                q0.D = v ^ 0x80000000;
            }
        }
        else {
            q0 = new Mb.q(this, c0);
        }
        Object object0 = q0.w;
        ne.a a0 = ne.a.a;
        boolean z = true;
        switch(q0.D) {
            case 0: {
                n.D(object0);
                boolean z1 = ((b)this.k.getValue()).a;
                r r0 = new r(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                q0.r = z1;
                q0.D = 1;
                Object object1 = BuildersKt.withContext(this.e, r0, q0);
                if(object1 == a0) {
                    return a0;
                }
                z2 = z1;
                object0 = object1;
                break;
            }
            case 1: {
                z2 = q0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!z2 || !((Boolean)object0).booleanValue()) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final Object i(c c0) {
        t t0;
        if(c0 instanceof t) {
            t0 = (t)c0;
            int v = t0.B;
            if((v & 0x80000000) == 0) {
                t0 = new t(this, c0);
            }
            else {
                t0.B = v ^ 0x80000000;
            }
        }
        else {
            t0 = new t(this, c0);
        }
        Object object0 = t0.r;
        ne.a a0 = ne.a.a;
        switch(t0.B) {
            case 0: {
                n.D(object0);
                t0.B = 1;
                H h0 = this.b.setOfflineModeToLocalData(false, t0);
                if(h0 != a0) {
                    h0 = H.a;
                }
                if(h0 == a0) {
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
        List list0 = this.b.getPlayableList();
        g g0 = Q8.d.a;
        g0.getClass();
        LogU.i("PremiumDownloadManager", "removeList()");
        if(list0 != null && !list0.isEmpty()) {
            h h1 = g0.a;
            __monitor_enter(h1);
            int v1 = FIN.finallyOpen$NT();
            if(list0.isEmpty()) {
                FIN.finallyExec$NT(v1);
            }
            else {
                for(Object object1: list0) {
                    h1.k(((Playable)object1));
                }
                FIN.finallyCodeBegin$NT(v1);
                __monitor_exit(h1);
                FIN.finallyCodeEnd$NT(v1);
            }
            for(Object object2: list0) {
                Q8.a a1 = g0.e == null ? null : g0.e.d;
                if(a1 != null && ((Playable)object2) != null) {
                    a1.b = true;
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        MelonSettingInfo.setPremiumOfflineDownloadPopupShown(false);
        return H.a;
    }

    public final Object j(c c0) {
        u u0;
        if(c0 instanceof u) {
            u0 = (u)c0;
            int v = u0.B;
            if((v & 0x80000000) == 0) {
                u0 = new u(this, c0);
            }
            else {
                u0.B = v ^ 0x80000000;
            }
        }
        else {
            u0 = new u(this, c0);
        }
        Object object0 = u0.r;
        ne.a a0 = ne.a.a;
        H h0 = H.a;
        switch(u0.B) {
            case 0: {
                n.D(object0);
                u0.B = 1;
                H h1 = this.b.setOfflineModeToLocalData(true, u0);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 == a0) {
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
        s s0 = new s(this, null);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, s0, 3, null);
        return h0;
    }

    public final void k(b b0, String s) {
        q.g(s, "fromCall");
        LogU.debug$default(this.g, "updateOfflineState state: " + b0 + ", fromCall: " + s, null, false, 6, null);
        this.j.setValue(b0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventPremiumDownload eventPremiumDownload0) {
        q.g(eventPremiumDownload0, "event");
        String s = eventPremiumDownload0.eventType.name();
        LogU.debug$default(this.g, "EventPremiumDownload() event: " + s, null, false, 6, null);
        if(eventPremiumDownload0.equals(EventPremiumDownload.UpdateButtonUI)) {
            Mb.c c0 = new Mb.c(this, s, null);
            BuildersKt__Builders_commonKt.launch$default(this.c, null, null, c0, 3, null);
            return;
        }
        boolean z = eventPremiumDownload0.equals(EventPremiumDownload.Finish);
        StateFlow stateFlow0 = this.k;
        if(z) {
            if(((b)stateFlow0.getValue()).a) {
                this.k(b.f, s);
            }
        }
        else if(eventPremiumDownload0 instanceof EventPremiumDownloadItem) {
            LogU.debug$default(this.g, "EventPremiumDownloadItem() item: " + eventPremiumDownload0.eventType.name() + " cType: " + ((EventPremiumDownloadItem)eventPremiumDownload0).cType + ", cId: " + ((EventPremiumDownloadItem)eventPremiumDownload0).cId + ", e: " + ((EventPremiumDownloadItem)eventPremiumDownload0).exception, null, false, 6, null);
            switch((eventPremiumDownload0.eventType == null ? -1 : Mb.b.b[eventPremiumDownload0.eventType.ordinal()])) {
                case 1: {
                    if(((b)stateFlow0.getValue()).a && NetUtils.isConnected()) {
                        this.k(b.h, s);
                        return;
                    }
                    break;
                }
                case 2: {
                    if(((b)stateFlow0.getValue()).a) {
                        String s1 = ((EventPremiumDownloadItem)eventPremiumDownload0).cId;
                        q.f(s1, "cId");
                        this.l.setValue(s1);
                        return;
                    }
                    break;
                }
                case 3: {
                    StringBuilder stringBuilder0 = new StringBuilder();
                    Cb.i.a(stringBuilder0, "EventPremiumDownloadItem() error: " + ((EventPremiumDownloadItem)eventPremiumDownload0).exception);
                    Cb.i.a(stringBuilder0, "cId: " + ((EventPremiumDownloadItem)eventPremiumDownload0).cId);
                    LogU.debug$default(this.g, stringBuilder0.toString(), null, false, 6, null);
                }
            }
        }
    }
}

