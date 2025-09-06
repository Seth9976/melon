package com.airbnb.lottie.compose;

import G.f;
import androidx.compose.foundation.B0;
import androidx.compose.foundation.z0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.b1;
import androidx.compose.runtime.w;
import com.airbnb.lottie.LottieComposition;
import d5.n;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonCancellable;
import me.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b@\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J2\u0010\r\u001A\u00020\f2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0096@\u00A2\u0006\u0004\b\r\u0010\u000EJl\u0010\u001A\u001A\u00020\f2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u00062\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\nH\u0096@\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0018\u0010\u001C\u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\bH\u0082@\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010 \u001A\u00020\n2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\b \u0010!J\u001D\u0010\"\u001A\u00020\u0006*\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b$\u0010%R+\u0010)\u001A\u00020\n2\u0006\u0010&\u001A\u00020\n8V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R+\u0010\t\u001A\u00020\b2\u0006\u0010&\u001A\u00020\b8V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b-\u0010(\u001A\u0004\b.\u0010/\"\u0004\b0\u00101R+\u0010\u000F\u001A\u00020\b2\u0006\u0010&\u001A\u00020\b8V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b2\u0010(\u001A\u0004\b3\u0010/\"\u0004\b4\u00101R+\u0010\u0010\u001A\u00020\n2\u0006\u0010&\u001A\u00020\n8V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b5\u0010(\u001A\u0004\b6\u0010*\"\u0004\b7\u0010,R/\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010&\u001A\u0004\u0018\u00010\u00128V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b8\u0010(\u001A\u0004\b9\u0010:\"\u0004\b;\u0010<R+\u0010\u0011\u001A\u00020\u00062\u0006\u0010&\u001A\u00020\u00068V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\b=\u0010(\u001A\u0004\b>\u0010?\"\u0004\b@\u0010%R+\u0010\u0019\u001A\u00020\n2\u0006\u0010&\u001A\u00020\n8V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bA\u0010(\u001A\u0004\bB\u0010*\"\u0004\bC\u0010,R\u001B\u0010G\u001A\u00020\u00068BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bD\u0010E\u001A\u0004\bF\u0010?R/\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010&\u001A\u0004\u0018\u00010\u00048V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bH\u0010(\u001A\u0004\bI\u0010J\"\u0004\bK\u0010LR+\u0010P\u001A\u00020\u00062\u0006\u0010&\u001A\u00020\u00068B@BX\u0082\u008E\u0002\u00A2\u0006\u0012\n\u0004\bM\u0010(\u001A\u0004\bN\u0010?\"\u0004\bO\u0010%R+\u0010\u0007\u001A\u00020\u00062\u0006\u0010&\u001A\u00020\u00068V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bQ\u0010(\u001A\u0004\bR\u0010?\"\u0004\bS\u0010%R+\u0010Y\u001A\u00020\u001E2\u0006\u0010&\u001A\u00020\u001E8V@RX\u0096\u008E\u0002\u00A2\u0006\u0012\n\u0004\bT\u0010(\u001A\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001B\u0010\\\u001A\u00020\u00068BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bZ\u0010E\u001A\u0004\b[\u0010?R\u001B\u0010^\u001A\u00020\n8VX\u0096\u0084\u0002\u00A2\u0006\f\n\u0004\b]\u0010E\u001A\u0004\b^\u0010*R\u0014\u0010`\u001A\u00020_8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010d\u001A\u00020\u00068VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bb\u0010c\u00A8\u0006e"}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimatableImpl;", "Lcom/airbnb/lottie/compose/LottieAnimatable;", "<init>", "()V", "Lcom/airbnb/lottie/LottieComposition;", "composition", "", "progress", "", "iteration", "", "resetLastFrameNanos", "Lie/H;", "snapTo", "(Lcom/airbnb/lottie/LottieComposition;FIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "iterations", "reverseOnRepeat", "speed", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "clipSpec", "initialProgress", "continueFromPreviousAnimate", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "cancellationBehavior", "ignoreSystemAnimationsDisabled", "useCompositionFrameRate", "animate", "(Lcom/airbnb/lottie/LottieComposition;IIZFLcom/airbnb/lottie/compose/LottieClipSpec;FZLcom/airbnb/lottie/compose/LottieCancellationBehavior;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doFrame", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "frameNanos", "onFrame", "(IJ)Z", "roundToCompositionFrameRate", "(FLcom/airbnb/lottie/LottieComposition;)F", "updateProgress", "(F)V", "<set-?>", "isPlaying$delegate", "Landroidx/compose/runtime/b0;", "isPlaying", "()Z", "setPlaying", "(Z)V", "iteration$delegate", "getIteration", "()I", "setIteration", "(I)V", "iterations$delegate", "getIterations", "setIterations", "reverseOnRepeat$delegate", "getReverseOnRepeat", "setReverseOnRepeat", "clipSpec$delegate", "getClipSpec", "()Lcom/airbnb/lottie/compose/LottieClipSpec;", "setClipSpec", "(Lcom/airbnb/lottie/compose/LottieClipSpec;)V", "speed$delegate", "getSpeed", "()F", "setSpeed", "useCompositionFrameRate$delegate", "getUseCompositionFrameRate", "setUseCompositionFrameRate", "frameSpeed$delegate", "Landroidx/compose/runtime/b1;", "getFrameSpeed", "frameSpeed", "composition$delegate", "getComposition", "()Lcom/airbnb/lottie/LottieComposition;", "setComposition", "(Lcom/airbnb/lottie/LottieComposition;)V", "progressRaw$delegate", "getProgressRaw", "setProgressRaw", "progressRaw", "progress$delegate", "getProgress", "setProgress", "lastFrameNanos$delegate", "getLastFrameNanos", "()J", "setLastFrameNanos", "(J)V", "lastFrameNanos", "endProgress$delegate", "getEndProgress", "endProgress", "isAtEnd$delegate", "isAtEnd", "Landroidx/compose/foundation/B0;", "mutex", "Landroidx/compose/foundation/B0;", "getValue", "()Ljava/lang/Float;", "value", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
final class LottieAnimatableImpl implements LottieAnimatable {
    @NotNull
    private final b0 clipSpec$delegate;
    @NotNull
    private final b0 composition$delegate;
    @NotNull
    private final b1 endProgress$delegate;
    @NotNull
    private final b1 frameSpeed$delegate;
    @NotNull
    private final b1 isAtEnd$delegate;
    @NotNull
    private final b0 isPlaying$delegate;
    @NotNull
    private final b0 iteration$delegate;
    @NotNull
    private final b0 iterations$delegate;
    @NotNull
    private final b0 lastFrameNanos$delegate;
    @NotNull
    private final B0 mutex;
    @NotNull
    private final b0 progress$delegate;
    @NotNull
    private final b0 progressRaw$delegate;
    @NotNull
    private final b0 reverseOnRepeat$delegate;
    @NotNull
    private final b0 speed$delegate;
    @NotNull
    private final b0 useCompositionFrameRate$delegate;

    public LottieAnimatableImpl() {
        this.isPlaying$delegate = w.s(Boolean.FALSE);
        this.iteration$delegate = w.s(1);
        this.iterations$delegate = w.s(1);
        this.reverseOnRepeat$delegate = w.s(Boolean.FALSE);
        this.clipSpec$delegate = w.s(null);
        this.speed$delegate = w.s(1.0f);
        this.useCompositionFrameRate$delegate = w.s(Boolean.FALSE);
        this.frameSpeed$delegate = w.i(new a() {
            {
                LottieAnimatableImpl.this = lottieAnimatableImpl0;
                super(0);
            }

            @NotNull
            public final Float invoke() {
                return !LottieAnimatableImpl.this.getReverseOnRepeat() || LottieAnimatableImpl.this.getIteration() % 2 != 0 ? LottieAnimatableImpl.this.getSpeed() : ((float)(-LottieAnimatableImpl.this.getSpeed()));
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
        this.composition$delegate = w.s(null);
        this.progressRaw$delegate = w.s(0.0f);
        this.progress$delegate = w.s(0.0f);
        this.lastFrameNanos$delegate = w.s(0x8000000000000000L);
        this.endProgress$delegate = w.i(new a() {
            {
                LottieAnimatableImpl.this = lottieAnimatableImpl0;
                super(0);
            }

            @NotNull
            public final Float invoke() {
                LottieComposition lottieComposition0 = LottieAnimatableImpl.this.getComposition();
                float f = 0.0f;
                if(lottieComposition0 != null) {
                    if(LottieAnimatableImpl.this.getSpeed() < 0.0f) {
                        LottieClipSpec lottieClipSpec0 = LottieAnimatableImpl.this.getClipSpec();
                        return lottieClipSpec0 == null ? 0.0f : lottieClipSpec0.getMinProgress$lottie_compose_release(lottieComposition0);
                    }
                    LottieClipSpec lottieClipSpec1 = LottieAnimatableImpl.this.getClipSpec();
                    if(lottieClipSpec1 != null) {
                        return lottieClipSpec1.getMaxProgress$lottie_compose_release(lottieComposition0);
                    }
                    f = 1.0f;
                }
                return f;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
        this.isAtEnd$delegate = w.i(new a() {
            {
                LottieAnimatableImpl.this = lottieAnimatableImpl0;
                super(0);
            }

            @NotNull
            public final Boolean invoke() {
                return LottieAnimatableImpl.this.getIteration() != LottieAnimatableImpl.this.getIterations() || LottieAnimatableImpl.this.getProgress() != LottieAnimatableImpl.this.getEndProgress() ? false : true;
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }
        });
        this.mutex = new B0();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimatable
    @Nullable
    public Object animate(@Nullable LottieComposition lottieComposition0, int v, int v1, boolean z, float f, @Nullable LottieClipSpec lottieClipSpec0, float f1, boolean z1, @NotNull LottieCancellationBehavior lottieCancellationBehavior0, boolean z2, boolean z3, @NotNull Continuation continuation0) {
        com.airbnb.lottie.compose.LottieAnimatableImpl.animate.2 lottieAnimatableImpl$animate$20 = new k(v, v1, z, f, lottieClipSpec0, lottieComposition0, f1, z3, z1, lottieCancellationBehavior0, null) {
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
            public final class WhenMappings {
                public static final int[] $EnumSwitchMapping$0;

                static {
                    int[] arr_v = new int[LottieCancellationBehavior.values().length];
                    try {
                        arr_v[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
                    }
                    catch(NoSuchFieldError unused_ex) {
                    }
                    try {
                        arr_v[LottieCancellationBehavior.Immediately.ordinal()] = 2;
                    }
                    catch(NoSuchFieldError unused_ex) {
                    }
                    WhenMappings.$EnumSwitchMapping$0 = arr_v;
                }
            }

            final LottieCancellationBehavior $cancellationBehavior;
            final LottieClipSpec $clipSpec;
            final LottieComposition $composition;
            final boolean $continueFromPreviousAnimate;
            final float $initialProgress;
            final int $iteration;
            final int $iterations;
            final boolean $reverseOnRepeat;
            final float $speed;
            final boolean $useCompositionFrameRate;
            int label;

            {
                LottieAnimatableImpl.this = lottieAnimatableImpl0;
                this.$iteration = v;
                this.$iterations = v1;
                this.$reverseOnRepeat = z;
                this.$speed = f;
                this.$clipSpec = lottieClipSpec0;
                this.$composition = lottieComposition0;
                this.$initialProgress = f1;
                this.$useCompositionFrameRate = z1;
                this.$continueFromPreviousAnimate = z2;
                this.$cancellationBehavior = lottieCancellationBehavior0;
                super(1, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@NotNull Continuation continuation0) {
                return new com.airbnb.lottie.compose.LottieAnimatableImpl.animate.2(LottieAnimatableImpl.this, this.$iteration, this.$iterations, this.$reverseOnRepeat, this.$speed, this.$clipSpec, this.$composition, this.$initialProgress, this.$useCompositionFrameRate, this.$continueFromPreviousAnimate, this.$cancellationBehavior, continuation0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            @Nullable
            public final Object invoke(@Nullable Continuation continuation0) {
                return ((com.airbnb.lottie.compose.LottieAnimatableImpl.animate.2)this.create(continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                NonCancellable nonCancellable0;
                ne.a a0 = ne.a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        LottieAnimatableImpl.this.setIteration(this.$iteration);
                        LottieAnimatableImpl.this.setIterations(this.$iterations);
                        LottieAnimatableImpl.this.setReverseOnRepeat(this.$reverseOnRepeat);
                        LottieAnimatableImpl.this.setSpeed(this.$speed);
                        LottieAnimatableImpl.this.setClipSpec(this.$clipSpec);
                        LottieAnimatableImpl.this.setComposition(this.$composition);
                        LottieAnimatableImpl.this.updateProgress(this.$initialProgress);
                        LottieAnimatableImpl.this.setUseCompositionFrameRate(this.$useCompositionFrameRate);
                        if(!this.$continueFromPreviousAnimate) {
                            LottieAnimatableImpl.this.setLastFrameNanos(0x8000000000000000L);
                        }
                        if(this.$composition == null) {
                            LottieAnimatableImpl.this.setPlaying(false);
                            return h0;
                        }
                        if(Float.isInfinite(this.$speed)) {
                            float f = LottieAnimatableImpl.this.getEndProgress();
                            LottieAnimatableImpl.this.updateProgress(f);
                            LottieAnimatableImpl.this.setPlaying(false);
                            LottieAnimatableImpl.this.setIteration(this.$iterations);
                            return h0;
                        }
                        LottieAnimatableImpl.this.setPlaying(true);
                        try {
                            switch(WhenMappings.$EnumSwitchMapping$0[this.$cancellationBehavior.ordinal()]) {
                                case 1: {
                                    nonCancellable0 = NonCancellable.INSTANCE;
                                    break;
                                }
                                case 2: {
                                    nonCancellable0 = j.a;
                                    break;
                                }
                                default: {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                            }
                            Job job0 = JobKt.getJob(this.getContext());
                            com.airbnb.lottie.compose.LottieAnimatableImpl.animate.2.1 lottieAnimatableImpl$animate$2$10 = new we.n(job0, this.$iterations, this.$iteration, LottieAnimatableImpl.this, null) {
                                @Metadata(k = 3, mv = {1, 9, 0}, xi = 0x30)
                                public final class com.airbnb.lottie.compose.LottieAnimatableImpl.animate.2.1.WhenMappings {
                                    public static final int[] $EnumSwitchMapping$0;

                                    static {
                                        int[] arr_v = new int[LottieCancellationBehavior.values().length];
                                        try {
                                            arr_v[LottieCancellationBehavior.OnIterationFinish.ordinal()] = 1;
                                        }
                                        catch(NoSuchFieldError unused_ex) {
                                        }
                                        com.airbnb.lottie.compose.LottieAnimatableImpl.animate.2.1.WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                    }
                                }

                                final LottieCancellationBehavior $cancellationBehavior;
                                final int $iteration;
                                final int $iterations;
                                final Job $parentJob;
                                int label;

                                {
                                    this.$cancellationBehavior = lottieCancellationBehavior0;
                                    this.$parentJob = job0;
                                    this.$iterations = v;
                                    this.$iteration = v1;
                                    LottieAnimatableImpl.this = lottieAnimatableImpl0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                @NotNull
                                public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                                    return new com.airbnb.lottie.compose.LottieAnimatableImpl.animate.2.1(this.$cancellationBehavior, this.$parentJob, this.$iterations, this.$iteration, LottieAnimatableImpl.this, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                @Nullable
                                public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                                    return ((com.airbnb.lottie.compose.LottieAnimatableImpl.animate.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                @Nullable
                                public final Object invokeSuspend(@NotNull Object object0) {
                                    int v;
                                    ne.a a0 = ne.a.a;
                                    switch(this.label) {
                                        case 0: {
                                            n.D(object0);
                                            goto label_8;
                                        }
                                        case 1: {
                                            n.D(object0);
                                            break;
                                        }
                                        default: {
                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                        }
                                    }
                                    do {
                                        if(!((Boolean)object0).booleanValue()) {
                                            return H.a;
                                        }
                                    label_8:
                                        if(com.airbnb.lottie.compose.LottieAnimatableImpl.animate.2.1.WhenMappings.$EnumSwitchMapping$0[this.$cancellationBehavior.ordinal()] != 1) {
                                            v = this.$iterations;
                                        }
                                        else if(this.$parentJob.isActive()) {
                                            v = this.$iterations;
                                        }
                                        else {
                                            v = this.$iteration;
                                        }
                                        this.label = 1;
                                        object0 = LottieAnimatableImpl.this.doFrame(v, this);
                                    }
                                    while(object0 != a0);
                                    return a0;
                                }
                            };
                            this.label = 1;
                            if(BuildersKt.withContext(nonCancellable0, lottieAnimatableImpl$animate$2$10, this) == a0) {
                                return a0;
                            label_35:
                                n.D(object0);
                            }
                            JobKt.ensureActive(this.getContext());
                            goto label_41;
                        }
                        catch(Throwable throwable0) {
                        }
                        break;
                    }
                    case 1: {
                        goto label_35;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                LottieAnimatableImpl.this.setPlaying(false);
                throw throwable0;
            label_41:
                LottieAnimatableImpl.this.setPlaying(false);
                return h0;
            }
        };
        this.mutex.getClass();
        Object object0 = CoroutineScopeKt.coroutineScope(new z0(this.mutex, lottieAnimatableImpl$animate$20, null), continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    private final Object doFrame(int v, Continuation continuation0) {
        if(v == 0x7FFFFFFF) {
            return f.t(new k(0x7FFFFFFF) {
                final int $iterations;

                {
                    LottieAnimatableImpl.this = lottieAnimatableImpl0;
                    this.$iterations = v;
                    super(1);
                }

                @NotNull
                public final Boolean invoke(long v) {
                    return Boolean.valueOf(LottieAnimatableImpl.this.onFrame(this.$iterations, v));
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    return this.invoke(((Number)object0).longValue());
                }
            }, continuation0);
        }
        com.airbnb.lottie.compose.LottieAnimatableImpl.doFrame.3 lottieAnimatableImpl$doFrame$30 = new k(v) {
            final int $iterations;

            {
                LottieAnimatableImpl.this = lottieAnimatableImpl0;
                this.$iterations = v;
                super(1);
            }

            @NotNull
            public final Boolean invoke(long v) {
                return Boolean.valueOf(LottieAnimatableImpl.this.onFrame(this.$iterations, v));
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Number)object0).longValue());
            }
        };
        return w.l(continuation0.getContext()).c(lottieAnimatableImpl$doFrame$30, continuation0);
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    @Nullable
    public LottieClipSpec getClipSpec() {
        return (LottieClipSpec)this.clipSpec$delegate.getValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    @Nullable
    public LottieComposition getComposition() {
        return (LottieComposition)this.composition$delegate.getValue();
    }

    private final float getEndProgress() {
        return ((Number)this.endProgress$delegate.getValue()).floatValue();
    }

    private final float getFrameSpeed() {
        return ((Number)this.frameSpeed$delegate.getValue()).floatValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    public int getIteration() {
        return ((Number)this.iteration$delegate.getValue()).intValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    public int getIterations() {
        return ((Number)this.iterations$delegate.getValue()).intValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    public long getLastFrameNanos() {
        return ((Number)this.lastFrameNanos$delegate.getValue()).longValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    public float getProgress() {
        return ((Number)this.progress$delegate.getValue()).floatValue();
    }

    private final float getProgressRaw() {
        return ((Number)this.progressRaw$delegate.getValue()).floatValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    public boolean getReverseOnRepeat() {
        return ((Boolean)this.reverseOnRepeat$delegate.getValue()).booleanValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    public float getSpeed() {
        return ((Number)this.speed$delegate.getValue()).floatValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    public boolean getUseCompositionFrameRate() {
        return ((Boolean)this.useCompositionFrameRate$delegate.getValue()).booleanValue();
    }

    @NotNull
    public Float getValue() {
        return this.getProgress();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimatable
    public Object getValue() {
        return this.getValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    public boolean isAtEnd() {
        return ((Boolean)this.isAtEnd$delegate.getValue()).booleanValue();
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimationState
    public boolean isPlaying() {
        return ((Boolean)this.isPlaying$delegate.getValue()).booleanValue();
    }

    private final boolean onFrame(int v, long v1) {
        LottieComposition lottieComposition0 = this.getComposition();
        if(lottieComposition0 == null) {
            return true;
        }
        long v2 = this.getLastFrameNanos() == 0x8000000000000000L ? 0L : v1 - this.getLastFrameNanos();
        this.setLastFrameNanos(v1);
        LottieClipSpec lottieClipSpec0 = this.getClipSpec();
        float f = lottieClipSpec0 == null ? 0.0f : lottieClipSpec0.getMinProgress$lottie_compose_release(lottieComposition0);
        LottieClipSpec lottieClipSpec1 = this.getClipSpec();
        float f1 = lottieClipSpec1 == null ? 1.0f : lottieClipSpec1.getMaxProgress$lottie_compose_release(lottieComposition0);
        float f2 = ((float)(v2 / 1000000L)) / lottieComposition0.getDuration() * this.getFrameSpeed();
        float f3 = this.getFrameSpeed() < 0.0f ? f - (this.getProgressRaw() + f2) : this.getProgressRaw() + f2 - f1;
        if(Float.compare(f, f1) == 0) {
            this.updateProgress(f);
            return false;
        }
        if(f3 < 0.0f) {
            this.updateProgress(P4.a.i(this.getProgressRaw(), f, f1) + f2);
            return true;
        }
        float f4 = f1 - f;
        int v3 = (int)(f3 / f4);
        if(this.getIteration() + (v3 + 1) > v) {
            this.updateProgress(this.getEndProgress());
            this.setIteration(v);
            return false;
        }
        this.setIteration(this.getIteration() + (v3 + 1));
        float f5 = f3 - ((float)v3) * f4;
        this.updateProgress((this.getFrameSpeed() < 0.0f ? f1 - f5 : f + f5));
        return true;
    }

    private final float roundToCompositionFrameRate(float f, LottieComposition lottieComposition0) {
        return lottieComposition0 == null ? f : f - f % (1.0f / lottieComposition0.getFrameRate());
    }

    private void setClipSpec(LottieClipSpec lottieClipSpec0) {
        this.clipSpec$delegate.setValue(lottieClipSpec0);
    }

    private void setComposition(LottieComposition lottieComposition0) {
        this.composition$delegate.setValue(lottieComposition0);
    }

    private void setIteration(int v) {
        this.iteration$delegate.setValue(v);
    }

    private void setIterations(int v) {
        this.iterations$delegate.setValue(v);
    }

    private void setLastFrameNanos(long v) {
        this.lastFrameNanos$delegate.setValue(v);
    }

    private void setPlaying(boolean z) {
        this.isPlaying$delegate.setValue(Boolean.valueOf(z));
    }

    private void setProgress(float f) {
        this.progress$delegate.setValue(f);
    }

    private final void setProgressRaw(float f) {
        this.progressRaw$delegate.setValue(f);
    }

    private void setReverseOnRepeat(boolean z) {
        this.reverseOnRepeat$delegate.setValue(Boolean.valueOf(z));
    }

    private void setSpeed(float f) {
        this.speed$delegate.setValue(f);
    }

    private void setUseCompositionFrameRate(boolean z) {
        this.useCompositionFrameRate$delegate.setValue(Boolean.valueOf(z));
    }

    @Override  // com.airbnb.lottie.compose.LottieAnimatable
    @Nullable
    public Object snapTo(@Nullable LottieComposition lottieComposition0, float f, int v, boolean z, @NotNull Continuation continuation0) {
        com.airbnb.lottie.compose.LottieAnimatableImpl.snapTo.2 lottieAnimatableImpl$snapTo$20 = new k(lottieComposition0, f, v, z, null) {
            final LottieComposition $composition;
            final int $iteration;
            final float $progress;
            final boolean $resetLastFrameNanos;
            int label;

            {
                LottieAnimatableImpl.this = lottieAnimatableImpl0;
                this.$composition = lottieComposition0;
                this.$progress = f;
                this.$iteration = v;
                this.$resetLastFrameNanos = z;
                super(1, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@NotNull Continuation continuation0) {
                return new com.airbnb.lottie.compose.LottieAnimatableImpl.snapTo.2(LottieAnimatableImpl.this, this.$composition, this.$progress, this.$iteration, this.$resetLastFrameNanos, continuation0);
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            @Nullable
            public final Object invoke(@Nullable Continuation continuation0) {
                return ((com.airbnb.lottie.compose.LottieAnimatableImpl.snapTo.2)this.create(continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                LottieAnimatableImpl.this.setComposition(this.$composition);
                LottieAnimatableImpl.this.updateProgress(this.$progress);
                LottieAnimatableImpl.this.setIteration(this.$iteration);
                LottieAnimatableImpl.this.setPlaying(false);
                if(this.$resetLastFrameNanos) {
                    LottieAnimatableImpl.this.setLastFrameNanos(0x8000000000000000L);
                }
                return H.a;
            }
        };
        this.mutex.getClass();
        Object object0 = CoroutineScopeKt.coroutineScope(new z0(this.mutex, lottieAnimatableImpl$snapTo$20, null), continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    private final void updateProgress(float f) {
        this.setProgressRaw(f);
        if(this.getUseCompositionFrameRate()) {
            f = this.roundToCompositionFrameRate(f, this.getComposition());
        }
        this.setProgress(f);
    }
}

