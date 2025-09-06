package com.iloen.melon.popup;

import Dc.i;
import Nc.f;
import Ub.s;
import android.content.Context;
import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.lifecycle.m0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.e1;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventRemotePlayer.EventType;
import com.iloen.melon.eventbus.EventRemotePlayer;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.system.VolumeUtils;
import com.melon.playback.manager.CastHelper;
import d3.g;
import e.k;
import i.n.i.b.a.s.e.M3;
import ic.c;
import ic.d;
import ic.e;
import ie.r;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import je.p;
import je.w;
import k8.t;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ob.z;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;
import we.n;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 <2\u00020\u0001:\u0002<=B!\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\r\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\n\u00A2\u0006\u0004\b\r\u0010\fJ\r\u0010\u000F\u001A\u00020\u000E\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0016\u001A\u00020\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\u0019\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u0010J\u0017\u0010 \u001A\u00020\u000E2\u0006\u0010\u001F\u001A\u00020\u001EH\u0007\u00A2\u0006\u0004\b \u0010!J\r\u0010\"\u001A\u00020\u000E\u00A2\u0006\u0004\b\"\u0010\u0010R%\u0010*\u001A\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010$0$0#8\u0006\u00A2\u0006\f\n\u0004\b&\u0010\'\u001A\u0004\b(\u0010)R#\u0010.\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150+0#8\u0006\u00A2\u0006\f\n\u0004\b,\u0010\'\u001A\u0004\b-\u0010)R\u001D\u00102\u001A\b\u0012\u0004\u0012\u00020\n0/8\u0006\u00A2\u0006\f\n\u0004\b0\u00101\u001A\u0004\b2\u00103R\u0017\u00108\u001A\b\u0012\u0004\u0012\u000205048F\u00A2\u0006\u0006\u001A\u0004\b6\u00107R\u0017\u0010;\u001A\b\u0012\u0004\u0012\u000209048F\u00A2\u0006\u0006\u001A\u0004\b:\u00107\u00A8\u0006>"}, d2 = {"Lcom/iloen/melon/popup/RemoteConnectPopupViewModel;", "Landroidx/lifecycle/m0;", "LUb/s;", "remotePlayerManager", "Lkc/s2;", "playlistManager", "Lob/z;", "playerUseCase", "<init>", "(LUb/s;Lkc/s2;Lob/z;)V", "", "isSearching", "()Z", "isRemoteConnected", "Lie/H;", "searchDevice", "()V", "Lic/e;", "device", "isSelectedDeviceConnected", "(Lic/e;)Z", "Lcom/iloen/melon/popup/DeviceInfo;", "deviceInfo", "selectDevice", "(Lcom/iloen/melon/popup/DeviceInfo;)V", "", "reason", "disconnectDevice", "(Ljava/lang/String;)V", "onCleared", "Lcom/iloen/melon/eventbus/EventRemotePlayer;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventRemotePlayer;)V", "onDismissPopup", "Landroidx/lifecycle/L;", "Lcom/iloen/melon/popup/RemoteConnectPopupViewModel$Status;", "kotlin.jvm.PlatformType", "f", "Landroidx/lifecycle/L;", "getStatus", "()Landroidx/lifecycle/L;", "status", "", "i", "getRemoteDevices", "remoteDevices", "Lkotlinx/coroutines/flow/StateFlow;", "k", "Lkotlinx/coroutines/flow/StateFlow;", "isPlaying", "()Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/lifecycle/K;", "", "getDismissEvent", "()Landroidx/lifecycle/K;", "dismissEvent", "Lcom/iloen/melon/popup/VolumeInfo;", "getVolumeInfo", "volumeInfo", "Companion", "Status", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class RemoteConnectPopupViewModel extends m0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/popup/RemoteConnectPopupViewModel$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "MAX_SEARCH_SEC", "J", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/popup/RemoteConnectPopupViewModel$Status;", "", "INIT", "IDLE", "SEARCH", "CONNECTED", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static enum Status {
        INIT,
        IDLE,
        SEARCH,
        CONNECTED;

        public static final Status[] a;
        public static final b b;

        static {
            Status.a = arr_remoteConnectPopupViewModel$Status;
            q.g(arr_remoteConnectPopupViewModel$Status, "entries");
            Status.b = new b(arr_remoteConnectPopupViewModel$Status);
        }

        @NotNull
        public static a getEntries() {
            return Status.b;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[EventType.values().length];
            try {
                arr_v[EventType.FOUND_DEVICE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[EventType.LOST_DEVICE.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[EventType.STOP_SEARCH.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final s a;
    public final s2 b;
    public final z c;
    public final LogU d;
    public final CoroutineScope e;
    public final L f;
    public final r g;
    public final L h;
    public final L i;
    public final MutableStateFlow j;
    public final StateFlow k;
    public Job l;
    public boolean m;

    static {
        RemoteConnectPopupViewModel.Companion = new Companion(null);
        RemoteConnectPopupViewModel.$stable = 8;
    }

    @Inject
    public RemoteConnectPopupViewModel(@NotNull s s0, @NotNull s2 s20, @NotNull z z0) {
        q.g(s0, "remotePlayerManager");
        q.g(s20, "playlistManager");
        q.g(z0, "playerUseCase");
        super();
        this.a = s0;
        this.b = s20;
        this.c = z0;
        LogU logU0 = new LogU("RemoteConnectPopupViewModel");
        logU0.setCategory(Category.Playback);
        logU0.setUseThreadInfo(true);
        this.d = logU0;
        CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.e = coroutineScope0;
        this.f = new L(Status.INIT);  // 初始化器: Landroidx/lifecycle/K;-><init>(Ljava/lang/Object;)V
        this.g = g.Q(new H(2));
        L l0 = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this.h = l0;
        this.i = new L(w.a);  // 初始化器: Landroidx/lifecycle/K;-><init>(Ljava/lang/Object;)V
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.j = mutableStateFlow0;
        this.k = FlowKt.asStateFlow(mutableStateFlow0);
        EventBusHelper.register(this);
        MelonAppBase.Companion.getClass();
        Context context0 = t.a().getContext();
        int v = com.iloen.melon.utils.system.VolumeUtils.Companion.getMaxVolume$default(VolumeUtils.Companion, context0, null, 2, null);
        MelonAppBase.Companion.getClass();
        Context context1 = t.a().getContext();
        int v1 = com.iloen.melon.utils.system.VolumeUtils.Companion.getVolume$default(VolumeUtils.Companion, context1, "RemoteConnectPopupViewModel", null, 4, null);
        if(v1 > v) {
            v1 = v;
        }
        LogU.debug$default(logU0, "syncVolume() - maxVolume = " + v + ", curVolume = " + v1, null, false, 6, null);
        VolumeInfo volumeInfo0 = new VolumeInfo(v1, v);
        if(!q.b(l0.getValue(), volumeInfo0)) {
            l0.setValue(volumeInfo0);
        }
        this.searchDevice();
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
            public int r;
            public final RemoteConnectPopupViewModel w;

            {
                this.w = remoteConnectPopupViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.popup.RemoteConnectPopupViewModel.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.popup.RemoteConnectPopupViewModel.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = ((d3)RemoteConnectPopupViewModel.access$getPlaylistManager$p(this.w)).i();
                        com.iloen.melon.popup.RemoteConnectPopupViewModel.1.1 remoteConnectPopupViewModel$1$10 = new n(null) {
                            public Object r;
                            public final RemoteConnectPopupViewModel w;

                            {
                                this.w = remoteConnectPopupViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.popup.RemoteConnectPopupViewModel.1.1(this.w, continuation0);
                                continuation1.r = object0;
                                return continuation1;
                            }

                            public final Object invoke(PlaylistId playlistId0, Continuation continuation0) {
                                return ((com.iloen.melon.popup.RemoteConnectPopupViewModel.1.1)this.create(playlistId0, continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((PlaylistId)object0), ((Continuation)object1));
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                PlaylistId playlistId0 = (PlaylistId)this.r;
                                d5.n.D(object0);
                                RemoteConnectPopupViewModel.access$setVideoContents$p(this.w, false);
                                return ie.H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, remoteConnectPopupViewModel$1$10, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(null) {
            public int r;
            public final RemoteConnectPopupViewModel w;

            {
                this.w = remoteConnectPopupViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.popup.RemoteConnectPopupViewModel.2(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.popup.RemoteConnectPopupViewModel.2)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        Flow flow0 = RemoteConnectPopupViewModel.access$getPlayerUseCase$p(this.w).h();
                        com.iloen.melon.popup.RemoteConnectPopupViewModel.2.1 remoteConnectPopupViewModel$2$10 = new n(null) {
                            public boolean r;
                            public final RemoteConnectPopupViewModel w;

                            {
                                this.w = remoteConnectPopupViewModel0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                Continuation continuation1 = new com.iloen.melon.popup.RemoteConnectPopupViewModel.2.1(this.w, continuation0);
                                continuation1.r = ((Boolean)object0).booleanValue();
                                return continuation1;
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return ((com.iloen.melon.popup.RemoteConnectPopupViewModel.2.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(ie.H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                boolean z = this.r;
                                d5.n.D(object0);
                                RemoteConnectPopupViewModel.access$get_isPlaying$p(this.w).setValue(Boolean.valueOf(z));
                                return ie.H.a;
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, remoteConnectPopupViewModel$2$10, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
    }

    public static final z access$getPlayerUseCase$p(RemoteConnectPopupViewModel remoteConnectPopupViewModel0) {
        return remoteConnectPopupViewModel0.c;
    }

    public static final s2 access$getPlaylistManager$p(RemoteConnectPopupViewModel remoteConnectPopupViewModel0) {
        return remoteConnectPopupViewModel0.b;
    }

    public static final Job access$getSearchJob$p(RemoteConnectPopupViewModel remoteConnectPopupViewModel0) {
        return remoteConnectPopupViewModel0.l;
    }

    public static final MutableStateFlow access$get_isPlaying$p(RemoteConnectPopupViewModel remoteConnectPopupViewModel0) {
        return remoteConnectPopupViewModel0.j;
    }

    public static final void access$setVideoContents$p(RemoteConnectPopupViewModel remoteConnectPopupViewModel0, boolean z) {
        remoteConnectPopupViewModel0.m = z;
    }

    public final void b(List list0) {
        List list1 = (List)this.i.getValue();
        ArrayList arrayList0 = list1 == null ? new ArrayList() : new ArrayList(list1);
        arrayList0.addAll(list0);
        LogU.debug$default(this.d, "addRemoteDevices() updatedRemoteDevices: " + arrayList0, null, false, 6, null);
        this.i.setValue(arrayList0);
    }

    public final DeviceInfo c(e e0) {
        if(this.m) {
            if(e0 instanceof ic.b) {
                if(((ic.b)e0).a.n != 1) {
                    LogU.debug$default(this.d, "getDeviceInfo() - video not available", null, false, 6, null);
                    return null;
                }
            }
            else if(e0 instanceof c) {
                LogU.debug$default(this.d, "getDeviceInfo() - video not available", null, false, 6, null);
                return null;
            }
        }
        if(e0 instanceof ic.b) {
            String s = ((ic.b)e0).a.d;
            q.f(s, "getName(...)");
            return new DeviceInfo(e0, s);
        }
        return e0 instanceof c ? new DeviceInfo(e0, ((c)e0).a.a.l) : null;
    }

    public final void disconnectDevice(@NotNull String s) {
        q.g(s, "reason");
        ((Ub.t)this.a).a(s);
        ((e1)this.g.getValue()).setValue(null);
    }

    @NotNull
    public final K getDismissEvent() {
        return (e1)this.g.getValue();
    }

    @NotNull
    public final L getRemoteDevices() {
        return this.i;
    }

    @NotNull
    public final L getStatus() {
        return this.f;
    }

    @NotNull
    public final K getVolumeInfo() {
        return this.h;
    }

    @NotNull
    public final StateFlow isPlaying() {
        return this.k;
    }

    public final boolean isRemoteConnected() {
        return ((Ub.t)this.a).f();
    }

    public final boolean isSearching() {
        return this.l != null && this.l.isActive();
    }

    public final boolean isSelectedDeviceConnected(@NotNull e e0) {
        q.g(e0, "device");
        return ((Ub.t)this.a).h(e0);
    }

    @Override  // androidx.lifecycle.m0
    public void onCleared() {
        LogU.debug$default(this.d, "onCleared", null, false, 6, null);
        EventBusHelper.unregister(this);
    }

    public final void onDismissPopup() {
        LogU.debug$default(this.d, "onRelease", null, false, 6, null);
        for(Object object0: ((Ub.t)this.a).e) {
            ((Ub.r)object0).b();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull EventRemotePlayer eventRemotePlayer0) {
        ArrayList arrayList0;
        q.g(eventRemotePlayer0, "event");
        LogU.debug$default(this.d, "EventRemotePlayer: " + eventRemotePlayer0, null, false, 6, null);
        EventType eventRemotePlayer$EventType0 = eventRemotePlayer0.getType();
        switch((eventRemotePlayer$EventType0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[eventRemotePlayer$EventType0.ordinal()])) {
            case 1: {
                e e0 = eventRemotePlayer0.getRemoteDevice();
                q.f(e0, "getRemoteDevice(...)");
                DeviceInfo deviceInfo0 = this.c(e0);
                if(deviceInfo0 != null) {
                    this.b(k.z(deviceInfo0));
                    return;
                }
                break;
            }
            case 2: {
                e e1 = eventRemotePlayer0.getRemoteDevice();
                q.f(e1, "getRemoteDevice(...)");
                DeviceInfo deviceInfo1 = this.c(e1);
                if(deviceInfo1 != null) {
                    L l0 = this.i;
                    List list0 = (List)l0.getValue();
                    if(list0 == null) {
                        arrayList0 = w.a;
                    }
                    else {
                        arrayList0 = new ArrayList();
                        for(Object object0: list0) {
                            if(!q.b(((DeviceInfo)object0), deviceInfo1)) {
                                arrayList0.add(object0);
                            }
                        }
                    }
                    l0.setValue(arrayList0);
                    return;
                }
                break;
            }
            case 3: {
                this.f.setValue(Status.IDLE);
            }
        }
    }

    public final void searchDevice() {
        LogU.debug$default(this.d, "searchDevice()", null, false, 6, null);
        this.i.setValue(w.a);
        boolean z = this.isRemoteConnected();
        L l0 = this.f;
        if(z) {
            l0.setValue(Status.CONNECTED);
        }
        else {
            l0.setValue(Status.SEARCH);
        }
        Job job0 = this.l;
        if(job0 != null) {
            JobKt__JobKt.cancel$default(job0, "search", null, 2, null);
        }
        RemoteConnectPopupViewModel.updateStatus.1 remoteConnectPopupViewModel$updateStatus$10 = new RemoteConnectPopupViewModel.updateStatus.1(this, null);
        this.l = BuildersKt__Builders_commonKt.launch$default(this.e, null, null, remoteConnectPopupViewModel$updateStatus$10, 3, null);
        ArrayList arrayList0 = new ArrayList();
        ((Ub.t)this.a).getClass();
        ArrayList arrayList1 = new ArrayList();
        for(Object object0: ((Ub.t)this.a).e) {
            arrayList1.addAll(((Ub.r)object0).a());
        }
        for(Object object1: arrayList1) {
            DeviceInfo deviceInfo0 = this.c(((e)object1));
            if(deviceInfo0 != null) {
                arrayList0.add(deviceInfo0);
            }
        }
        this.b(p.P0(arrayList0));
    }

    public final void selectDevice(@NotNull DeviceInfo deviceInfo0) {
        q.g(deviceInfo0, "deviceInfo");
        Ub.t t0 = (Ub.t)this.a;
        if(t0.h(deviceInfo0.getDevice())) {
            LogU.debug$default(this.d, "selectDevice() - already connected", null, false, 6, null);
            return;
        }
        e e0 = deviceInfo0.getDevice();
        if(!(e0 instanceof c)) {
            if(e0 instanceof ic.b && MelonSettingInfo.isUseSpatialStreaming()) {
                Playable playable0 = ((d3)this.b).f();
                if(playable0 == null || !playable0.isTypeOfMv()) {
                    ToastManager.show(0x7F1308CD);  // string:remoteconnect_not_support_spartial "연결 기기에선 돌비를 지원하지 않아 기본 음질로 재생됩니다."
                }
            }
        }
        else if(MelonSettingInfo.isUseSpatialStreaming()) {
            ToastManager.show(0x7F1308CD);  // string:remoteconnect_not_support_spartial "연결 기기에선 돌비를 지원하지 않아 기본 음질로 재생됩니다."
        }
        e e1 = deviceInfo0.getDevice();
        CastHelper castHelper0 = t0.b;
        q.g(e1, "device");
        LogU.info$default(t0.d, "connect() device: " + e1, null, false, 6, null);
        if(t0.h(e1)) {
            LogU.debug$default(t0.d, "connect() - already connected", null, false, 6, null);
        }
        else {
            if(e1 instanceof ic.b) {
                t0.a("Connect for cast");
                castHelper0.getClass();
                LogU.debug$default(castHelper0.b, "connect routeInfo: " + ((ic.b)e1).a, null, false, 6, null);
                castHelper0.h.getClass();
                ((ic.b)e1).a.l(true);
                castHelper0.j(castHelper0.h, ((ic.b)e1).a, "connect");
                ((e1)this.g.getValue()).setValue(null);
                return;
            }
            if(e1 instanceof c) {
                i i0 = new i(18, t0, ((c)e1));
                if(t0.c()) {
                    castHelper0.f("Connect for dlna", i0);
                    ((e1)this.g.getValue()).setValue(null);
                    return;
                }
                t0.a("Connect for dlna");
                i0.invoke();
            }
            else if(e1 instanceof d) {
                f f0 = new f(t0, 16);
                if(t0.c()) {
                    castHelper0.f("Connect for mobile", f0);
                }
                else {
                    t0.a("Connect for mobile");
                    f0.invoke();
                }
            }
            else {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        ((e1)this.g.getValue()).setValue(null);
    }
}

