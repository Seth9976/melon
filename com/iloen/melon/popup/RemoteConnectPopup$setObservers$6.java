package com.iloen.melon.popup;

import J8.C2;
import android.content.Context;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.VolumeUtils.Companion;
import com.iloen.melon.utils.system.VolumeUtils;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.popup.RemoteConnectPopup$setObservers$6", f = "RemoteConnectPopup.kt", l = {0xF0}, m = "invokeSuspend")
final class RemoteConnectPopup.setObservers.6 extends i implements n {
    public int r;
    public final RemoteConnectPopup w;

    public RemoteConnectPopup.setObservers.6(RemoteConnectPopup remoteConnectPopup0, Continuation continuation0) {
        this.w = remoteConnectPopup0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new RemoteConnectPopup.setObservers.6(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((RemoteConnectPopup.setObservers.6)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                SharedFlow sharedFlow0 = VolumeUtils.Companion.getVolumeEventFlow();
                com.iloen.melon.popup.RemoteConnectPopup.setObservers.6.1 remoteConnectPopup$setObservers$6$10 = new n(null) {
                    public int r;
                    public final RemoteConnectPopup w;

                    {
                        this.w = remoteConnectPopup0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.popup.RemoteConnectPopup.setObservers.6.1(this.w, continuation0);
                        continuation1.r = ((Number)object0).intValue();
                        return continuation1;
                    }

                    public final Object invoke(int v, Continuation continuation0) {
                        return ((com.iloen.melon.popup.RemoteConnectPopup.setObservers.6.1)this.create(v, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((Number)object0).intValue(), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        int v = this.r;
                        d5.n.D(object0);
                        LogU.debug$default(this.w.j, "volumeEventFlow.collectLatest() volume: " + v, null, false, 6, null);
                        C2 c20 = this.w.k;
                        if(c20 != null) {
                            Context context0 = c20.i.getContext();
                            int v1 = Companion.getMaxVolume$default(VolumeUtils.Companion, context0, null, 2, null);
                            c20.i.setMax(v1);
                            c20.i.setProgress(v);
                            c20.i.invalidate();
                            return H.a;
                        }
                        q.m("binding");
                        throw null;
                    }
                };
                this.r = 1;
                return FlowKt.collectLatest(sharedFlow0, remoteConnectPopup$setObservers$6$10, this) == a0 ? a0 : H.a;
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

