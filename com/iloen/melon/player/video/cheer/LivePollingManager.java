package com.iloen.melon.player.video.cheer;

import com.iloen.melon.utils.log.LogU;
import ie.H;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import ne.a;
import org.jetbrains.annotations.NotNull;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u001C\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(BK\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0011\u001A\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010J\r\u0010\u0013\u001A\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R#\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001CR#\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u001D\u0010\u001A\u001A\u0004\b\u001E\u0010\u001CR#\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u001F\u0010\u001A\u001A\u0004\b \u0010\u001CR\"\u0010\'\u001A\u00020\u00058\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/iloen/melon/player/video/cheer/LivePollingManager;", "", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "", "Lie/H;", "setLikeCnt", "setViewCnt", "", "setDataVisible", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lwe/k;Lwe/k;Lwe/k;)V", "", "id", "startPolling", "(Ljava/lang/String;)V", "reason", "stopPolling", "clickCheerBtn", "()V", "a", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "b", "Lwe/k;", "getSetLikeCnt", "()Lwe/k;", "c", "getSetViewCnt", "d", "getSetDataVisible", "j", "J", "getTotalCnt", "()J", "setTotalCnt", "(J)V", "totalCnt", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LivePollingManager {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/video/cheer/LivePollingManager$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "ONE_SECOND_MIL", "J", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final CoroutineScope a;
    public final k b;
    public final k c;
    public final k d;
    public final LogU e;
    public String f;
    public Job g;
    public long h;
    public long i;
    public long j;

    static {
        LivePollingManager.Companion = new Companion(null);
        LivePollingManager.$stable = 8;
    }

    public LivePollingManager(@NotNull CoroutineScope coroutineScope0, @NotNull k k0, @NotNull k k1, @NotNull k k2) {
        q.g(coroutineScope0, "scope");
        q.g(k0, "setLikeCnt");
        q.g(k1, "setViewCnt");
        q.g(k2, "setDataVisible");
        super();
        this.a = coroutineScope0;
        this.b = k0;
        this.c = k1;
        this.d = k2;
        this.e = new LogU("LivePollingManager");
        this.f = "";
        this.h = 10L;
    }

    public static final void access$calculateRealCnt(LivePollingManager livePollingManager0, long v) {
        long v1 = livePollingManager0.j + livePollingManager0.i;
        if(v1 > v) {
            v = v1;
        }
        livePollingManager0.j = v;
        StringBuilder stringBuilder0 = Y.o(v1, "calculateRealCnt(), localCnt = ", " , reaCnt = ");
        stringBuilder0.append(v);
        LogU.debug$default(livePollingManager0.e, stringBuilder0.toString(), null, false, 6, null);
        livePollingManager0.b.invoke(v);
    }

    public static final long access$getCumulativeCnt$p(LivePollingManager livePollingManager0) {
        return livePollingManager0.i;
    }

    public static final void access$requestInsertLikeCnt(LivePollingManager livePollingManager0) {
        LivePollingManager.requestInsertLikeCnt.1 livePollingManager$requestInsertLikeCnt$10 = new LivePollingManager.requestInsertLikeCnt.1(livePollingManager0, null);
        BuildersKt__Builders_commonKt.launch$default(livePollingManager0.a, null, null, livePollingManager$requestInsertLikeCnt$10, 3, null);
    }

    public static final Object access$requestLivePolling(LivePollingManager livePollingManager0, Continuation continuation0) {
        livePollingManager0.getClass();
        Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new LivePollingManager.requestLivePolling.2(livePollingManager0, null), continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    public static final void access$setCumulativeCnt$p(LivePollingManager livePollingManager0, long v) {
        livePollingManager0.i = v;
    }

    public final void clickCheerBtn() {
        ++this.i;
    }

    @NotNull
    public final CoroutineScope getScope() {
        return this.a;
    }

    @NotNull
    public final k getSetDataVisible() {
        return this.d;
    }

    @NotNull
    public final k getSetLikeCnt() {
        return this.b;
    }

    @NotNull
    public final k getSetViewCnt() {
        return this.c;
    }

    public final long getTotalCnt() {
        return this.j;
    }

    public final void setTotalCnt(long v) {
        this.j = v;
    }

    public final void startPolling(@NotNull String s) {
        q.g(s, "id");
        LogU.debug$default(this.e, "startPolling", null, false, 6, null);
        if(!s.equals(this.f)) {
            this.i = 0L;
        }
        this.f = s;
        Job job0 = this.g;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        com.iloen.melon.player.video.cheer.LivePollingManager.startPolling.1 livePollingManager$startPolling$10 = new n(null) {
            public final LivePollingManager B;
            public int r;
            public Object w;

            {
                this.B = livePollingManager0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.player.video.cheer.LivePollingManager.startPolling.1(this.B, continuation0);
                continuation1.w = object0;
                return continuation1;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.cheer.LivePollingManager.startPolling.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
                a a0 = a.a;
                LivePollingManager livePollingManager0 = this.B;
                switch(this.r) {
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    case 0: 
                    case 2: {
                        d5.n.D(object0);
                        goto label_11;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                do {
                    this.w = coroutineScope0;
                    this.r = 2;
                    if(DelayKt.delay(livePollingManager0.h * 1000L, this) == a0) {
                        break;
                    }
                label_11:
                    if(!CoroutineScopeKt.isActive(coroutineScope0)) {
                        return H.a;
                    }
                    this.w = coroutineScope0;
                    this.r = 1;
                }
                while(LivePollingManager.access$requestLivePolling(livePollingManager0, this) != a0);
                return a0;
            }
        };
        this.g = BuildersKt__Builders_commonKt.launch$default(this.a, Dispatchers.getIO(), null, livePollingManager$startPolling$10, 2, null);
    }

    public final void stopPolling(@NotNull String s) {
        q.g(s, "reason");
        LogU.debug$default(this.e, "stopPolling - " + s, null, false, 6, null);
        Job job0 = this.g;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
    }
}

