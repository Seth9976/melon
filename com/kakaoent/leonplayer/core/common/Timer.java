package com.kakaoent.leonplayer.core.common;

import ie.H;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import me.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.n;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0019\u0012\u0010\u0010\u0005\u001A\f\u0012\u0004\u0012\u00020\u00030\u0002j\u0002`\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001D\u0010\u000B\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\r\u001A\u00020\u0003¢\u0006\u0004\b\r\u0010\u000ER\u0018\u0010\u0010\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001A\u00020\b8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001A\u00020\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R:\u0010\u0019\u001A&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003 \u0018*\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00040\u0002j\u0002`\u00040\u00178\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\"\u0010\u001D\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00048BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001CR\u0014\u0010!\u001A\u00020\u001E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u001F\u0010 ¨\u0006#"}, d2 = {"Lcom/kakaoent/leonplayer/core/common/Timer;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Function0;", "Lie/H;", "Lcom/kakaoent/leonplayer/core/common/Action;", "ticker", "<init>", "(Lwe/a;)V", "", "current", "duration", "start", "(II)V", "stop", "()V", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "interval", "I", "", "liveTrigger", "Z", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "actionRef", "Ljava/lang/ref/WeakReference;", "getAction", "()Lwe/a;", "action", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "Companion", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Timer implements CoroutineScope {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/leonplayer/core/common/Timer$Companion;", "", "()V", "DEFAULT_INTERVAL", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    private static final int DEFAULT_INTERVAL = 100;
    @NotNull
    private WeakReference actionRef;
    private int interval;
    @Nullable
    private Job job;
    private boolean liveTrigger;

    static {
        Timer.Companion = new Companion(null);
    }

    public Timer(@NotNull a a0) {
        q.g(a0, "ticker");
        super();
        this.interval = 100;
        this.liveTrigger = true;
        this.actionRef = new WeakReference(a0);
    }

    private final a getAction() {
        return (a)this.actionRef.get();
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    public final void start(int v, int v1) {
        this.job = BuildersKt__Builders_commonKt.launch$default(this, null, null, new n(this, v, null) {
            final int $current;
            final int $duration;
            int I$0;
            int label;

            {
                this.$duration = v;
                Timer.this = timer0;
                this.$current = v1;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new com.kakaoent.leonplayer.core.common.Timer.start.1(this.$duration, Timer.this, this.$current, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                return ((com.kakaoent.leonplayer.core.common.Timer.start.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                int v;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        if(this.$duration == -1) {
                            Timer.this.liveTrigger = true;
                        label_16:
                            while(Timer.this.liveTrigger) {
                                this.label = 1;
                                if(DelayKt.delay(100L, this) == a0) {
                                    return a0;
                                }
                            label_19:
                                com.kakaoent.leonplayer.core.common.Timer.start.1.1 timer$start$1$10 = new n(null) {
                                    int label;

                                    {
                                        Timer.this = timer0;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    @NotNull
                                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                                        return new com.kakaoent.leonplayer.core.common.Timer.start.1.1(Timer.this, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    @Nullable
                                    public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                                        return ((com.kakaoent.leonplayer.core.common.Timer.start.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    @Nullable
                                    public final Object invokeSuspend(@NotNull Object object0) {
                                        if(this.label != 0) {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                        d5.n.D(object0);
                                        a a0 = Timer.this.getAction();
                                        if(a0 != null) {
                                            a0.invoke();
                                            return H.a;
                                        }
                                        return null;
                                    }
                                };
                                this.label = 2;
                                if(BuildersKt.withContext(Dispatchers.getMain(), timer$start$1$10, this) != a0) {
                                    continue;
                                }
                                return a0;
                            }
                            Job job0 = Timer.this.job;
                            if(job0 != null) {
                                DefaultImpls.cancel$default(job0, null, 1, null);
                                return H.a;
                            }
                        }
                        else {
                            v = this.$current;
                        label_28:
                            while(v < this.$duration) {
                                this.I$0 = v;
                                this.label = 3;
                                if(DelayKt.delay(100L, this) != a0) {
                                label_32:
                                    v += Timer.this.interval;
                                    com.kakaoent.leonplayer.core.common.Timer.start.1.2 timer$start$1$20 = new n(null) {
                                        int label;

                                        {
                                            Timer.this = timer0;
                                            super(2, continuation0);
                                        }

                                        @Override  // oe.a
                                        @NotNull
                                        public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                                            return new com.kakaoent.leonplayer.core.common.Timer.start.1.2(Timer.this, continuation0);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                        }

                                        @Nullable
                                        public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                                            return ((com.kakaoent.leonplayer.core.common.Timer.start.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // oe.a
                                        @Nullable
                                        public final Object invokeSuspend(@NotNull Object object0) {
                                            if(this.label != 0) {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                            d5.n.D(object0);
                                            a a0 = Timer.this.getAction();
                                            if(a0 != null) {
                                                a0.invoke();
                                                return H.a;
                                            }
                                            return null;
                                        }
                                    };
                                    this.I$0 = v;
                                    this.label = 4;
                                    if(BuildersKt.withContext(Dispatchers.getMain(), timer$start$1$20, this) != a0) {
                                        continue;
                                    }
                                }
                                return a0;
                            }
                            Job job1 = Timer.this.job;
                            if(job1 != null) {
                                DefaultImpls.cancel$default(job1, null, 1, null);
                            }
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        goto label_19;
                    }
                    case 2: {
                        d5.n.D(object0);
                        goto label_16;
                    }
                    case 3: {
                        v = this.I$0;
                        d5.n.D(object0);
                        goto label_32;
                    }
                    case 4: {
                        v = this.I$0;
                        d5.n.D(object0);
                        goto label_28;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        }, 3, null);
    }

    public final void stop() {
        this.liveTrigger = false;
        Job job0 = this.job;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        this.job = null;
    }
}

