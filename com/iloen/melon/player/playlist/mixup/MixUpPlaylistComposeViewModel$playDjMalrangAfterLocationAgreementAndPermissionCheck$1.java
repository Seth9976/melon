package com.iloen.melon.player.playlist.mixup;

import E9.h;
import Na.f;
import androidx.lifecycle.f0;
import com.iloen.melon.utils.log.LogU;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.I4;
import ie.H;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.e;
import oe.i;
import pc.N0;
import pc.P0;
import pc.c;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
@e(c = "com.iloen.melon.player.playlist.mixup.MixUpPlaylistComposeViewModel$playDjMalrangAfterLocationAgreementAndPermissionCheck$1", f = "MixUpPlaylistComposeViewModel.kt", l = {787}, m = "invokeSuspend")
final class MixUpPlaylistComposeViewModel.playDjMalrangAfterLocationAgreementAndPermissionCheck.1 extends i implements n {
    public boolean B;
    public int D;
    public Object E;
    public final MixUpPlaylistComposeViewModel G;
    public final boolean I;
    public final boolean M;
    public c r;
    public String w;

    public MixUpPlaylistComposeViewModel.playDjMalrangAfterLocationAgreementAndPermissionCheck.1(MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0, boolean z, boolean z1, Continuation continuation0) {
        this.G = mixUpPlaylistComposeViewModel0;
        this.I = z;
        this.M = z1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new MixUpPlaylistComposeViewModel.playDjMalrangAfterLocationAgreementAndPermissionCheck.1(this.G, this.I, this.M, continuation0);
        continuation1.E = object0;
        return continuation1;
    }

    @Override  // we.n
    public Object invoke(Object object0, Object object1) {
        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
    }

    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
        return ((MixUpPlaylistComposeViewModel.playDjMalrangAfterLocationAgreementAndPermissionCheck.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        N0 n00;
        boolean z;
        Object object1;
        String s;
        c c0;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.E;
        a a0 = a.a;
        H h0 = H.a;
        MixUpPlaylistComposeViewModel mixUpPlaylistComposeViewModel0 = this.G;
        switch(this.D) {
            case 0: {
                d5.n.D(object0);
                c0 = (c)mixUpPlaylistComposeViewModel0.getMixUpInfoStateFlow().getValue();
                if(c0 == null) {
                    return h0;
                }
                s = !this.I || !this.M ? "N" : "Y";
                if(s.equals("Y")) {
                    this.E = coroutineScope0;
                    this.r = c0;
                    this.w = s;
                    this.B = c0 instanceof DjMalrangInfo;
                    this.D = 1;
                    object1 = db.c.a(MixUpPlaylistComposeViewModel.access$getLocationUseCase$p(mixUpPlaylistComposeViewModel0), this);
                    if(object1 == a0) {
                        return a0;
                    }
                    z = c0 instanceof DjMalrangInfo;
                    goto label_34;
                }
                else if(c0 instanceof DjMalrangInfo) {
                    n00 = new N0(s, null, null, null, ((DjMalrangInfo)c0).e, ((DjMalrangInfo)c0).f, ((DjMalrangInfo)c0).g, null, 0x8E);
                }
                else {
                    n00 = new P0(false, s, null, null, null, null, 0x7D);
                }
                break;
            }
            case 1: {
                z = this.B;
                String s1 = this.w;
                c c1 = this.r;
                d5.n.D(object0);
                s = s1;
                c0 = c1;
                object1 = object0;
            label_34:
                db.a a1 = (db.a)h.H(((f)object1));
                String s2 = null;
                String s3 = String.valueOf((a1 == null ? null : new Double(a1.a)));
                String s4 = String.valueOf((a1 == null ? null : new Double(a1.b)));
                long v = a1 == null ? Cb.i.c(coroutineScope0) : a1.c;
                try {
                    s2 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA).format(new Date(v));
                }
                catch(Exception exception0) {
                    LogU.error$default(MixUpPlaylistComposeViewModel.access$getLog$p(mixUpPlaylistComposeViewModel0), va.e.a(v, "Error parsing timestamp: "), exception0, false, 4, null);
                }
                if(z) {
                    q.e(c0, "null cannot be cast to non-null type com.melon.playlist.mixup.DjMalrangInfo");
                    n00 = new N0(s, s3, s4, s2, ((DjMalrangInfo)c0).e, ((DjMalrangInfo)c0).f, ((DjMalrangInfo)c0).g, null, 0x80);
                }
                else {
                    n00 = new P0(false, s, s3, s4, s2, null, 97);
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        MixUpPlaylistComposeViewModel.access$getAddPlayUserEventHelper$p(mixUpPlaylistComposeViewModel0).d(new com.melon.ui.i(mixUpPlaylistComposeViewModel0.getMenuId(), n00), f0.h(mixUpPlaylistComposeViewModel0), new k(0, MixUpPlaylistComposeViewModel.class, mixUpPlaylistComposeViewModel0, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((I4)object0));
                return H.a;
            }

            public final void invoke(I4 i40) {
                q.g(i40, "p0");
                MixUpPlaylistComposeViewModel.access$sendUiEvent(((MixUpPlaylistComposeViewModel)this.receiver), i40);
            }
        });
        return h0;
    }
}

