package com.iloen.melon.player.video;

import com.iloen.melon.playback.Playable;
import eb.n;
import i.n.i.b.a.s.e.M3;
import ie.H;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J3\u0010\u000E\u001A\u00020\r2\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001A\u00020\t2\u000E\u0010\f\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000B0\u0006¢\u0006\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R$\u0010\u001B\u001A\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/player/video/VideoPipPvLogManager;", "", "Leb/n;", "pvLogUseCase", "<init>", "(Leb/n;)V", "Lkotlinx/coroutines/flow/StateFlow;", "", "isPip", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/iloen/melon/playback/Playable;", "currentPlayable", "Lie/H;", "init", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/flow/StateFlow;)V", "a", "Leb/n;", "getPvLogUseCase", "()Leb/n;", "Lkotlinx/coroutines/Job;", "b", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "job", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoPipPvLogManager {
    public static final int $stable = 8;
    public final n a;
    public Job b;

    @Inject
    public VideoPipPvLogManager(@NotNull n n0) {
        q.g(n0, "pvLogUseCase");
        super();
        this.a = n0;
    }

    public static final Object access$performPVLogging(VideoPipPvLogManager videoPipPvLogManager0, Playable playable0, Continuation continuation0) {
        String s = "videoPlayerPipVod";
        if(playable0 != null) {
            videoPipPvLogManager0.getClass();
            if(playable0.isOnAir()) {
                s = "videoPlayerPipLive";
            }
            else if(playable0.isLivePreView()) {
                s = "videoPlayerPipLiveTrailer";
            }
        }
        Object object0 = videoPipPvLogManager0.a.e(s, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Nullable
    public final Job getJob() {
        return this.b;
    }

    @NotNull
    public final n getPvLogUseCase() {
        return this.a;
    }

    public final void init(@NotNull StateFlow stateFlow0, @NotNull CoroutineScope coroutineScope0, @NotNull StateFlow stateFlow1) {
        q.g(stateFlow0, "isPip");
        q.g(coroutineScope0, "scope");
        q.g(stateFlow1, "currentPlayable");
        Job job0 = this.b;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        this.b = BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new we.n(this, stateFlow1, null) {
            public final VideoPipPvLogManager B;
            public final StateFlow D;
            public int r;
            public final StateFlow w;

            {
                this.w = stateFlow0;
                this.B = videoPipPvLogManager0;
                this.D = stateFlow1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.video.VideoPipPvLogManager.init.1(this.w, this.B, this.D, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.video.VideoPipPvLogManager.init.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.player.video.VideoPipPvLogManager.init.1.1 videoPipPvLogManager$init$1$10 = new FlowCollector() {
                            public final VideoPipPvLogManager a;
                            public final StateFlow b;

                            {
                                VideoPipPvLogManager videoPipPvLogManager0 = this.D;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                                this.a = videoPipPvLogManager0;
                                this.b = stateFlow0;
                            }

                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public Object emit(Object object0, Continuation continuation0) {
                                return this.emit(((Boolean)object0).booleanValue(), continuation0);
                            }

                            public final Object emit(boolean z, Continuation continuation0) {
                                H h0 = H.a;
                                if(z) {
                                    Playable playable0 = (Playable)this.b.getValue();
                                    Object object0 = VideoPipPvLogManager.access$performPVLogging(this.a, playable0, continuation0);
                                    if(object0 == a.a) {
                                        return object0;
                                    }
                                }
                                return h0;
                            }
                        };
                        this.r = 1;
                        if(this.w.collect(videoPipPvLogManager$init$1$10, this) == a0) {
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
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }, 3, null);
    }

    public final void setJob(@Nullable Job job0) {
        this.b = job0;
    }
}

