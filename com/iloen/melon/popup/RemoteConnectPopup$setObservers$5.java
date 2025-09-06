package com.iloen.melon.popup;

import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.popup.RemoteConnectPopup$setObservers$5", f = "RemoteConnectPopup.kt", l = {0xE3}, m = "invokeSuspend")
final class RemoteConnectPopup.setObservers.5 extends i implements n {
    public int r;
    public final RemoteConnectPopup w;

    public RemoteConnectPopup.setObservers.5(RemoteConnectPopup remoteConnectPopup0, Continuation continuation0) {
        this.w = remoteConnectPopup0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new RemoteConnectPopup.setObservers.5(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((RemoteConnectPopup.setObservers.5)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                StateFlow stateFlow0 = RemoteConnectPopup.access$getViewModel(this.w).isPlaying();
                com.iloen.melon.popup.RemoteConnectPopup.setObservers.5.1 remoteConnectPopup$setObservers$5$10 = new n(null) {
                    public boolean r;
                    public final RemoteConnectPopup w;

                    {
                        this.w = remoteConnectPopup0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.popup.RemoteConnectPopup.setObservers.5.1(this.w, continuation0);
                        continuation1.r = ((Boolean)object0).booleanValue();
                        return continuation1;
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                    }

                    public final Object invoke(boolean z, Continuation continuation0) {
                        return ((com.iloen.melon.popup.RemoteConnectPopup.setObservers.5.1)this.create(Boolean.valueOf(z), continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        boolean z = this.r;
                        d5.n.D(object0);
                        RemoteConnectPopup remoteConnectPopup0 = this.w;
                        List list0 = RemoteConnectPopup.access$getDeviceAdapter(remoteConnectPopup0).getCurrentList();
                        q.f(list0, "getCurrentList(...)");
                        ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
                        for(Object object1: list0) {
                            DeviceInfoWrapper deviceInfoWrapper0 = (DeviceInfoWrapper)object1;
                            if(deviceInfoWrapper0.isConnected()) {
                                deviceInfoWrapper0 = DeviceInfoWrapper.copy$default(deviceInfoWrapper0, null, false, z, 3, null);
                            }
                            arrayList0.add(deviceInfoWrapper0);
                        }
                        RemoteConnectPopup.access$getDeviceAdapter(remoteConnectPopup0).submitList(arrayList0);
                        return H.a;
                    }
                };
                this.r = 1;
                return FlowKt.collectLatest(stateFlow0, remoteConnectPopup$setObservers$5$10, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

