package com.kakao.emoticon.controller;

import com.kakao.emoticon.net.EmoticonApiError;
import com.kakao.emoticon.net.EmoticonApiErrorHandler;
import com.kakao.emoticon.net.EmoticonApiService;
import com.kakao.emoticon.net.EmoticonApiServiceImpl;
import com.kakao.emoticon.net.response.EmoticonConfig;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import me.i;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J¦\u0001\u0010\u0011\u001A\u00020\u0004\"\b\b\u0000\u0010\u0007*\u00020\u00012\u001C\u0010\n\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\"\u0010\r\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000B2&\b\u0002\u0010\u000F\u001A \b\u0001\u0012\u0004\u0012\u00020\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000B2 \b\u0002\u0010\u0010\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012JG\u0010\u0016\u001A\u00020\f2&\b\u0002\u0010\u000F\u001A \b\u0001\u0012\u0004\u0012\u00020\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000B2\n\u0010\u0015\u001A\u00060\u0013j\u0002`\u0014H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u001A\u0010\u001C\u001A\u00020\u001B8\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u0012\u0004\b\u001E\u0010\u0003R\u0018\u0010\u001F\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001F\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/kakao/emoticon/controller/EmoticonLoadLauncher;", "", "<init>", "()V", "Lkotlinx/coroutines/Job;", "requestEmoticonConfigIfNeed", "()Lkotlinx/coroutines/Job;", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "task", "Lkotlin/Function2;", "Lie/H;", "successBlock", "Lcom/kakao/emoticon/net/EmoticonApiError;", "failBlock", "finishBlock", "launch", "(Lwe/k;Lwe/n;Lwe/n;Lwe/k;)Lkotlinx/coroutines/Job;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onFailure", "(Lwe/n;Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "configContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getConfigContext$annotations", "configJob", "Lkotlinx/coroutines/Job;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonLoadLauncher {
    public static final EmoticonLoadLauncher INSTANCE;
    private static final ExecutorCoroutineDispatcher configContext;
    private static Job configJob;
    private static final CoroutineScope scope;

    static {
        EmoticonLoadLauncher.INSTANCE = new EmoticonLoadLauncher();
        EmoticonLoadLauncher.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        EmoticonLoadLauncher.configContext = ThreadPoolDispatcherKt.newSingleThreadContext("config");
    }

    public static final Job access$getConfigJob$p(EmoticonLoadLauncher emoticonLoadLauncher0) {
        return EmoticonLoadLauncher.configJob;
    }

    public static final void access$setConfigJob$p(EmoticonLoadLauncher emoticonLoadLauncher0, Job job0) {
        EmoticonLoadLauncher.configJob = job0;
    }

    private static void getConfigContext$annotations() {
    }

    @NotNull
    public final Job launch(@NotNull k k0, @NotNull n n0, @Nullable n n1, @Nullable k k1) {
        q.g(k0, "task");
        q.g(n0, "successBlock");
        if(!EmoticonManager.INSTANCE.isValidEmoticonConfig() && (EmoticonLoadLauncher.configJob == null || !EmoticonLoadLauncher.configJob.isActive())) {
            EmoticonLoadLauncher.configJob = this.requestEmoticonConfigIfNeed();
        }
        com.kakao.emoticon.controller.EmoticonLoadLauncher.launch.1 emoticonLoadLauncher$launch$10 = new n(k0, n0, k1, null) {
            final n $failBlock;
            final k $finishBlock;
            final n $successBlock;
            final k $task;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            private CoroutineScope p$;

            {
                this.$failBlock = n0;
                this.$task = k0;
                this.$successBlock = n1;
                this.$finishBlock = k1;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonLoadLauncher.launch.1(this.$failBlock, this.$task, this.$successBlock, this.$finishBlock, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonLoadLauncher.launch.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                Object object3;
                Object object2;
                Object object1;
                CoroutineScope coroutineScope2;
                CoroutineScope coroutineScope1;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        coroutineScope1 = this.p$;
                        Job job0 = EmoticonLoadLauncher.access$getConfigJob$p(EmoticonLoadLauncher.INSTANCE);
                        if(job0 == null) {
                            goto label_16;
                        }
                        else {
                            this.L$0 = coroutineScope1;
                            this.label = 1;
                            if(job0.join(this) != a0) {
                                goto label_16;
                            }
                        }
                        break;
                    }
                    case 1: {
                        coroutineScope1 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                    label_16:
                        EmoticonLoadLauncher emoticonLoadLauncher0 = EmoticonLoadLauncher.INSTANCE;
                        Job job1 = EmoticonLoadLauncher.access$getConfigJob$p(emoticonLoadLauncher0);
                        if(job1 == null || !job1.isCancelled()) {
                            goto label_26;
                        }
                        else {
                            Exception exception0 = new Exception("configException");
                            this.L$0 = coroutineScope1;
                            this.label = 2;
                            if(emoticonLoadLauncher0.onFailure(this.$failBlock, exception0, this) != a0) {
                                goto label_26;
                            }
                        }
                        break;
                    }
                    case 2: {
                        coroutineScope1 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                        try {
                        label_26:
                            this.L$0 = coroutineScope1;
                            this.label = 3;
                            object0 = this.$task.invoke(this);
                            if(object0 != a0) {
                                coroutineScope2 = coroutineScope1;
                                object1 = object0;
                                goto label_50;
                            }
                            break;
                        }
                        catch(Exception exception1) {
                            goto label_35;
                        }
                        coroutineScope2 = coroutineScope1;
                        object1 = object0;
                        goto label_50;
                    }
                    case 3: {
                        coroutineScope1 = (CoroutineScope)this.L$0;
                        try {
                            d5.n.D(object0);
                        }
                        catch(Exception exception1) {
                        label_35:
                            this.L$0 = coroutineScope1;
                            this.L$1 = exception1;
                            this.label = 4;
                            if(EmoticonLoadLauncher.INSTANCE.onFailure(this.$failBlock, exception1, this) != a0) {
                                coroutineScope2 = coroutineScope1;
                                object1 = null;
                                goto label_50;
                            }
                            break;
                        }
                        coroutineScope2 = coroutineScope1;
                        object1 = object0;
                        goto label_50;
                    }
                    case 4: {
                        Exception exception2 = (Exception)this.L$1;
                        coroutineScope1 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                        coroutineScope2 = coroutineScope1;
                        object1 = null;
                    label_50:
                        if(object1 != null) {
                            try {
                                this.L$0 = coroutineScope2;
                                this.L$1 = object1;
                                this.L$2 = object1;
                                this.label = 5;
                                if(this.$successBlock.invoke(object1, this) != a0) {
                                    object3 = object1;
                                    object1 = object3;
                                    goto label_84;
                                }
                                break;
                            }
                            catch(Exception exception3) {
                                object2 = object1;
                                goto label_70;
                            }
                            object3 = object1;
                            object1 = object3;
                        }
                        goto label_84;
                    }
                    case 5: {
                        Object object4 = this.L$2;
                        object3 = this.L$1;
                        coroutineScope2 = (CoroutineScope)this.L$0;
                        try {
                            d5.n.D(object0);
                            object1 = object3;
                            goto label_84;
                        }
                        catch(Exception exception3) {
                            object2 = object4;
                            object1 = object3;
                        }
                    label_70:
                        this.L$0 = coroutineScope2;
                        this.L$1 = object1;
                        this.L$2 = object2;
                        this.L$3 = exception3;
                        this.label = 6;
                        if(EmoticonLoadLauncher.INSTANCE.onFailure(this.$failBlock, exception3, this) != a0) {
                            goto label_84;
                        }
                        break;
                    }
                    case 6: {
                        Exception exception4 = (Exception)this.L$3;
                        object1 = this.L$1;
                        CoroutineScope coroutineScope3 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                        coroutineScope2 = coroutineScope3;
                        try {
                        label_84:
                            k k0 = this.$finishBlock;
                            if(k0 == null) {
                                return H.a;
                            }
                            this.L$0 = coroutineScope2;
                            this.L$1 = object1;
                            this.label = 7;
                            if(k0.invoke(this) != a0) {
                                return H.a;
                            }
                            break;
                        }
                        catch(Exception unused_ex) {
                            return H.a;
                        }
                    }
                    case 7: {
                        CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                        try {
                            d5.n.D(object0);
                        }
                        catch(Exception unused_ex) {
                        }
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return a0;
            }
        };
        return BuildersKt__Builders_commonKt.launch$default(EmoticonLoadLauncher.scope, null, null, emoticonLoadLauncher$launch$10, 3, null);
    }

    public static Job launch$default(EmoticonLoadLauncher emoticonLoadLauncher0, k k0, n n0, n n1, k k1, int v, Object object0) {
        if((v & 4) != 0) {
            n1 = null;
        }
        if((v & 8) != 0) {
            k1 = null;
        }
        return emoticonLoadLauncher0.launch(k0, n0, n1, k1);
    }

    @Nullable
    public final Object onFailure(@Nullable n n0, @NotNull Exception exception0, @NotNull Continuation continuation0) {
        com.kakao.emoticon.controller.EmoticonLoadLauncher.onFailure.1 emoticonLoadLauncher$onFailure$10;
        if(continuation0 instanceof com.kakao.emoticon.controller.EmoticonLoadLauncher.onFailure.1) {
            emoticonLoadLauncher$onFailure$10 = (com.kakao.emoticon.controller.EmoticonLoadLauncher.onFailure.1)continuation0;
            int v = emoticonLoadLauncher$onFailure$10.label;
            if((v & 0x80000000) == 0) {
                emoticonLoadLauncher$onFailure$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.onFailure(null, null, this);
                    }
                };
            }
            else {
                emoticonLoadLauncher$onFailure$10.label = v ^ 0x80000000;
            }
        }
        else {
            emoticonLoadLauncher$onFailure$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.onFailure(null, null, this);
                }
            };
        }
        Object object0 = emoticonLoadLauncher$onFailure$10.result;
        a a0 = a.a;
        switch(emoticonLoadLauncher$onFailure$10.label) {
            case 0: {
                d5.n.D(object0);
                try {
                    EmoticonApiError emoticonApiError0 = EmoticonApiErrorHandler.INSTANCE.createErrorFromException(exception0);
                    if(n0 != null) {
                        emoticonLoadLauncher$onFailure$10.L$0 = this;
                        emoticonLoadLauncher$onFailure$10.L$1 = n0;
                        emoticonLoadLauncher$onFailure$10.L$2 = exception0;
                        emoticonLoadLauncher$onFailure$10.L$3 = emoticonApiError0;
                        emoticonLoadLauncher$onFailure$10.label = 1;
                        if(n0.invoke(emoticonApiError0, emoticonLoadLauncher$onFailure$10) == a0) {
                            return a0;
                        }
                    }
                }
                catch(Exception unused_ex) {
                }
                return H.a;
            }
            case 1: {
                EmoticonApiError emoticonApiError1 = (EmoticonApiError)emoticonLoadLauncher$onFailure$10.L$3;
                Exception exception1 = (Exception)emoticonLoadLauncher$onFailure$10.L$2;
                n n1 = (n)emoticonLoadLauncher$onFailure$10.L$1;
                EmoticonLoadLauncher emoticonLoadLauncher0 = (EmoticonLoadLauncher)emoticonLoadLauncher$onFailure$10.L$0;
                try {
                    d5.n.D(object0);
                }
                catch(Exception unused_ex) {
                }
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    public static Object onFailure$default(EmoticonLoadLauncher emoticonLoadLauncher0, n n0, Exception exception0, Continuation continuation0, int v, Object object0) {
        if((v & 1) != 0) {
            n0 = null;
        }
        return emoticonLoadLauncher0.onFailure(n0, exception0, continuation0);
    }

    private final Job requestEmoticonConfigIfNeed() {
        com.kakao.emoticon.controller.EmoticonLoadLauncher.requestEmoticonConfigIfNeed..inlined.CoroutineExceptionHandler.1 emoticonLoadLauncher$requestEmoticonConfigIfNeed$$inlined$CoroutineExceptionHandler$10 = new CoroutineExceptionHandler(/*ERROR_MISSING_ARG_0/*) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(@NotNull i i0, @NotNull Throwable throwable0) {
                stringBuilder0.toString();
            }
        };
        return BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(EmoticonLoadLauncher.configContext.plus(emoticonLoadLauncher$requestEmoticonConfigIfNeed$$inlined$CoroutineExceptionHandler$10)), null, null, new n() {
            Object L$0;
            Object L$1;
            int label;
            private CoroutineScope p$;

            {
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonLoadLauncher.requestEmoticonConfigIfNeed.2(continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonLoadLauncher.requestEmoticonConfigIfNeed.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        CoroutineScope coroutineScope0 = this.p$;
                        EmoticonManager emoticonManager0 = EmoticonManager.INSTANCE;
                        if(!emoticonManager0.isValidEmoticonConfig()) {
                            EmoticonApiService emoticonApiService0 = EmoticonApiServiceImpl.INSTANCE.getApiClass();
                            this.L$0 = coroutineScope0;
                            this.L$1 = emoticonManager0;
                            this.label = 1;
                            object0 = emoticonApiService0.getConfig(this);
                            if(object0 == a0) {
                                return a0;
                            }
                            emoticonManager0.setEmoticonConfig(((EmoticonConfig)object0));
                            return H.a;
                        }
                        break;
                    }
                    case 1: {
                        EmoticonManager emoticonManager1 = (EmoticonManager)this.L$1;
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                        emoticonManager1.setEmoticonConfig(((EmoticonConfig)object0));
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        }, 3, null);
    }
}

