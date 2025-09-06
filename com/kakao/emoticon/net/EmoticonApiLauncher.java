package com.kakao.emoticon.net;

import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J¦\u0001\u0010\u000F\u001A\u00020\u000E\"\b\b\u0000\u0010\u0004*\u00020\u00012\u001C\u0010\u0007\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\"\u0010\n\u001A\u001E\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2&\b\u0002\u0010\f\u001A \b\u0001\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b2 \b\u0002\u0010\r\u001A\u001A\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0005ø\u0001\u0000¢\u0006\u0004\b\u000F\u0010\u0010JG\u0010\u0014\u001A\u00020\t2&\b\u0002\u0010\f\u001A \b\u0001\u0012\u0004\u0012\u00020\u000B\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\b2\n\u0010\u0013\u001A\u00060\u0011j\u0002`\u0012H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001A\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/kakao/emoticon/net/EmoticonApiLauncher;", "", "<init>", "()V", "T", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "api", "Lkotlin/Function2;", "Lie/H;", "successBlock", "Lcom/kakao/emoticon/net/EmoticonApiError;", "failBlock", "finishBlock", "Lkotlinx/coroutines/Job;", "launchMain", "(Lwe/k;Lwe/n;Lwe/n;Lwe/k;)Lkotlinx/coroutines/Job;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onFailure", "(Lwe/n;Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonApiLauncher {
    public static final EmoticonApiLauncher INSTANCE;
    private static final CoroutineScope scope;

    static {
        EmoticonApiLauncher.INSTANCE = new EmoticonApiLauncher();
        EmoticonApiLauncher.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    @NotNull
    public final Job launchMain(@NotNull k k0, @NotNull n n0, @Nullable n n1, @Nullable k k1) {
        q.g(k0, "api");
        q.g(n0, "successBlock");
        com.kakao.emoticon.net.EmoticonApiLauncher.launchMain.1 emoticonApiLauncher$launchMain$10 = new n(n1, n0, k1, null) {
            final k $api;
            final n $failBlock;
            final k $finishBlock;
            final n $successBlock;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            private CoroutineScope p$;

            {
                this.$api = k0;
                this.$failBlock = n0;
                this.$successBlock = n1;
                this.$finishBlock = k1;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.net.EmoticonApiLauncher.launchMain.1(this.$api, this.$failBlock, this.$successBlock, this.$finishBlock, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.net.EmoticonApiLauncher.launchMain.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                CoroutineScope coroutineScope2;
                Object object1;
                Object object4;
                CoroutineScope coroutineScope3;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        coroutineScope3 = this.p$;
                        try {
                            this.L$0 = coroutineScope3;
                            this.label = 1;
                            object0 = this.$api.invoke(this);
                        }
                        catch(Exception exception3) {
                        label_39:
                            this.L$0 = coroutineScope3;
                            this.L$1 = exception3;
                            this.label = 2;
                            if(EmoticonApiLauncher.INSTANCE.onFailure(this.$failBlock, exception3, this) != a0) {
                                coroutineScope2 = coroutineScope3;
                                object1 = null;
                                goto label_49;
                            }
                            break;
                        }
                        if(object0 != a0) {
                        label_47:
                            coroutineScope2 = coroutineScope3;
                            object1 = object0;
                        label_49:
                            if(object1 == null) {
                                try {
                                label_64:
                                    k k0 = this.$finishBlock;
                                    if(k0 == null) {
                                        return H.a;
                                    }
                                    this.L$0 = coroutineScope2;
                                    this.L$1 = object1;
                                    this.label = 5;
                                    if(k0.invoke(this) != a0) {
                                        return H.a;
                                    }
                                }
                                catch(Exception unused_ex) {
                                    return H.a;
                                }
                            }
                            else {
                                try {
                                    this.L$0 = coroutineScope2;
                                    this.L$1 = object1;
                                    this.L$2 = object1;
                                    this.label = 3;
                                    if(this.$successBlock.invoke(object1, this) != a0) {
                                        goto label_64;
                                    }
                                    break;
                                }
                                catch(Exception exception1) {
                                    object4 = object1;
                                }
                            label_58:
                                this.L$0 = coroutineScope2;
                                this.L$1 = object1;
                                this.L$2 = object4;
                                this.L$3 = exception1;
                                this.label = 4;
                                if(EmoticonApiLauncher.INSTANCE.onFailure(this.$failBlock, exception1, this) != a0) {
                                    goto label_64;
                                }
                            }
                        }
                        break;
                    }
                    case 1: {
                        coroutineScope3 = (CoroutineScope)this.L$0;
                        try {
                            d5.n.D(object0);
                            goto label_47;
                        }
                        catch(Exception exception3) {
                            goto label_39;
                        }
                    }
                    case 2: {
                        Exception exception2 = (Exception)this.L$1;
                        coroutineScope3 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                        coroutineScope2 = coroutineScope3;
                        object1 = null;
                        goto label_49;
                    }
                    case 3: {
                        Object object2 = this.L$2;
                        Object object3 = this.L$1;
                        coroutineScope2 = (CoroutineScope)this.L$0;
                        try {
                            d5.n.D(object0);
                        }
                        catch(Exception exception1) {
                            object4 = object2;
                            object1 = object3;
                            goto label_58;
                        }
                        object1 = object3;
                        goto label_64;
                    }
                    case 4: {
                        Exception exception0 = (Exception)this.L$3;
                        object1 = this.L$1;
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                        coroutineScope2 = coroutineScope1;
                        goto label_64;
                    }
                    case 5: {
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
        return BuildersKt__Builders_commonKt.launch$default(EmoticonApiLauncher.scope, null, null, emoticonApiLauncher$launchMain$10, 3, null);
    }

    public static Job launchMain$default(EmoticonApiLauncher emoticonApiLauncher0, k k0, n n0, n n1, k k1, int v, Object object0) {
        if((v & 4) != 0) {
            n1 = null;
        }
        if((v & 8) != 0) {
            k1 = null;
        }
        return emoticonApiLauncher0.launchMain(k0, n0, n1, k1);
    }

    @Nullable
    public final Object onFailure(@Nullable n n0, @NotNull Exception exception0, @NotNull Continuation continuation0) {
        com.kakao.emoticon.net.EmoticonApiLauncher.onFailure.1 emoticonApiLauncher$onFailure$10;
        if(continuation0 instanceof com.kakao.emoticon.net.EmoticonApiLauncher.onFailure.1) {
            emoticonApiLauncher$onFailure$10 = (com.kakao.emoticon.net.EmoticonApiLauncher.onFailure.1)continuation0;
            int v = emoticonApiLauncher$onFailure$10.label;
            if((v & 0x80000000) == 0) {
                emoticonApiLauncher$onFailure$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                emoticonApiLauncher$onFailure$10.label = v ^ 0x80000000;
            }
        }
        else {
            emoticonApiLauncher$onFailure$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = emoticonApiLauncher$onFailure$10.result;
        a a0 = a.a;
        switch(emoticonApiLauncher$onFailure$10.label) {
            case 0: {
                d5.n.D(object0);
                try {
                    EmoticonApiError emoticonApiError0 = EmoticonApiErrorHandler.INSTANCE.createErrorFromException(exception0);
                    if(n0 != null) {
                        emoticonApiLauncher$onFailure$10.L$0 = this;
                        emoticonApiLauncher$onFailure$10.L$1 = n0;
                        emoticonApiLauncher$onFailure$10.L$2 = exception0;
                        emoticonApiLauncher$onFailure$10.L$3 = emoticonApiError0;
                        emoticonApiLauncher$onFailure$10.label = 1;
                        if(n0.invoke(emoticonApiError0, emoticonApiLauncher$onFailure$10) == a0) {
                            return a0;
                        }
                    }
                }
                catch(Exception unused_ex) {
                }
                return H.a;
            }
            case 1: {
                EmoticonApiError emoticonApiError1 = (EmoticonApiError)emoticonApiLauncher$onFailure$10.L$3;
                Exception exception1 = (Exception)emoticonApiLauncher$onFailure$10.L$2;
                n n1 = (n)emoticonApiLauncher$onFailure$10.L$1;
                EmoticonApiLauncher emoticonApiLauncher0 = (EmoticonApiLauncher)emoticonApiLauncher$onFailure$10.L$0;
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

    public static Object onFailure$default(EmoticonApiLauncher emoticonApiLauncher0, n n0, Exception exception0, Continuation continuation0, int v, Object object0) {
        if((v & 1) != 0) {
            n0 = null;
        }
        return emoticonApiLauncher0.onFailure(n0, exception0, continuation0);
    }
}

