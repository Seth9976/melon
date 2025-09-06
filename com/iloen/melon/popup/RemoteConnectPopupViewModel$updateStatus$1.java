package com.iloen.melon.popup;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import ne.a;
import oe.e;
import oe.i;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.popup.RemoteConnectPopupViewModel$updateStatus$1", f = "RemoteConnectPopupViewModel.kt", l = {0xB0}, m = "invokeSuspend")
final class RemoteConnectPopupViewModel.updateStatus.1 extends i implements n {
    public int r;
    public final RemoteConnectPopupViewModel w;

    public RemoteConnectPopupViewModel.updateStatus.1(RemoteConnectPopupViewModel remoteConnectPopupViewModel0, Continuation continuation0) {
        this.w = remoteConnectPopupViewModel0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new RemoteConnectPopupViewModel.updateStatus.1(this.w, continuation0);
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((RemoteConnectPopupViewModel.updateStatus.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                if(DelayKt.delay(15000L, this) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        RemoteConnectPopupViewModel remoteConnectPopupViewModel0 = this.w;
        Job job0 = RemoteConnectPopupViewModel.access$getSearchJob$p(remoteConnectPopupViewModel0);
        if(job0 != null) {
            JobKt__JobKt.cancel$default(job0, "search finished", null, 2, null);
        }
        remoteConnectPopupViewModel0.getStatus().setValue((remoteConnectPopupViewModel0.isRemoteConnected() ? Status.CONNECTED : Status.IDLE));
        return H.a;
    }
}

