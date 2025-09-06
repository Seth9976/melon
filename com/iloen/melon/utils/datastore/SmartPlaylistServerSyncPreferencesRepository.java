package com.iloen.melon.utils.datastore;

import A8.b;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.SpServerSyncPreferences;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import java.io.IOException;
import k8.t;
import k8.w1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import l2.i;
import ne.a;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0013\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0013\u0010\n\u001A\b\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0013\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u000B\u0010\u0005J\u0018\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u0003H\u0086@¢\u0006\u0004\b\u000E\u0010\u000FJ\u0018\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0006H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\bH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u0003H\u0086@¢\u0006\u0004\b\u0017\u0010\u000FJ\u001C\u0010\u0019\u001A\u00020\r2\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0004\b\u0019\u0010\u000FJ\u001C\u0010\u001A\u001A\u00020\r2\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0004\b\u001A\u0010\u000FJ\u001C\u0010\u001B\u001A\u00020\r2\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0004\b\u001B\u0010\u000FJ\u001C\u0010\u001C\u001A\u00020\r2\n\b\u0002\u0010\u0018\u001A\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0004\b\u001C\u0010\u000FJ\u0010\u0010\u001D\u001A\u00020\rH\u0086@¢\u0006\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/utils/datastore/SmartPlaylistServerSyncPreferencesRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "", "getMemberKeyFlow", "()Lkotlinx/coroutines/flow/Flow;", "", "getVersionDateFlow", "", "getVersionThresholdFlow", "getNotSentEditCount", "getLastHistoryReqDate", "memberKey", "Lie/H;", "updateMemberKey", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "versionDate", "updateVersionDate", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "versionThreshold", "updateVersionThreshold", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "date", "updateLastHistoryReqDate", "tag", "incrementNotSentEditCount", "decrementNotSentEditCount", "clearNotSentEditCount", "clearAndIncrementNotSentEditCount", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SmartPlaylistServerSyncPreferencesRepository {
    public static final int $stable;
    @NotNull
    public static final SmartPlaylistServerSyncPreferencesRepository INSTANCE;
    public static final LogU a;
    public static final Mutex b;

    static {
        SmartPlaylistServerSyncPreferencesRepository.INSTANCE = new SmartPlaylistServerSyncPreferencesRepository();  // 初始化器: Ljava/lang/Object;-><init>()V
        SmartPlaylistServerSyncPreferencesRepository.a = new LogU("SmartPlaylistServerSyncPreferencesRepository");
        SmartPlaylistServerSyncPreferencesRepository.b = MutexKt.Mutex$default(false, 1, null);
        SmartPlaylistServerSyncPreferencesRepository.$stable = 8;
    }

    public final Object a(Continuation continuation0) {
        LogU logU1;
        SmartPlaylistServerSyncPreferencesRepository.debugAfterUpdate.1 smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10;
        if(continuation0 instanceof SmartPlaylistServerSyncPreferencesRepository.debugAfterUpdate.1) {
            smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10 = (SmartPlaylistServerSyncPreferencesRepository.debugAfterUpdate.1)continuation0;
            int v = smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10.D;
            if((v & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10 = new SmartPlaylistServerSyncPreferencesRepository.debugAfterUpdate.1(this, continuation0);
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10.D = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10 = new SmartPlaylistServerSyncPreferencesRepository.debugAfterUpdate.1(this, continuation0);
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10.w;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10.D) {
            case 0: {
                n.D(object0);
                Flow flow0 = SmartPlaylistServerSyncPreferencesRepository.b().getData();
                LogU logU0 = SmartPlaylistServerSyncPreferencesRepository.a;
                smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10.r = logU0;
                smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10.D = 1;
                object0 = FlowKt.first(flow0, smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10);
                if(object0 == a0) {
                    return a0;
                }
                logU1 = logU0;
                break;
            }
            case 1: {
                logU1 = smartPlaylistServerSyncPreferencesRepository$debugAfterUpdate$10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(logU1, "debugAfterUpdate() " + object0, null, false, 6, null);
        return H.a;
    }

    public static final i access$getDataStore(SmartPlaylistServerSyncPreferencesRepository smartPlaylistServerSyncPreferencesRepository0) {
        smartPlaylistServerSyncPreferencesRepository0.getClass();
        return SmartPlaylistServerSyncPreferencesRepository.b();
    }

    public static i b() {
        MelonAppBase.Companion.getClass();
        return SmartPlaylistServerSyncPrefSerializerKt.getSmartPlaylistServerSyncDataStore(t.a().getContext());
    }

    @Nullable
    public final Object clear(@NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clear.1 smartPlaylistServerSyncPreferencesRepository$clear$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clear.1) {
            smartPlaylistServerSyncPreferencesRepository$clear$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clear.1)continuation0;
            int v = smartPlaylistServerSyncPreferencesRepository$clear$10.B;
            if((v & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$clear$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.clear(this);
                    }
                };
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$clear$10.B = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$clear$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.clear(this);
                }
            };
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$clear$10.r;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$clear$10.B) {
            case 0: {
                n.D(object0);
                i i0 = SmartPlaylistServerSyncPreferencesRepository.b();
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clear.2 smartPlaylistServerSyncPreferencesRepository$clear$20 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    public Object r;

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clear.2(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(SpServerSyncPreferences spServerSyncPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clear.2)this.create(spServerSyncPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((SpServerSyncPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)this.r;
                        n.D(object0);
                        w1 w10 = (w1)spServerSyncPreferences0.toBuilder();
                        w10.c();
                        return w10.a();
                    }
                };
                smartPlaylistServerSyncPreferencesRepository$clear$10.B = 1;
                if(i0.a(smartPlaylistServerSyncPreferencesRepository$clear$20, smartPlaylistServerSyncPreferencesRepository$clear$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        smartPlaylistServerSyncPreferencesRepository$clear$10.B = 2;
        return this.a(smartPlaylistServerSyncPreferencesRepository$clear$10) == a0 ? a0 : H.a;
    }

    @Nullable
    public final Object clearAndIncrementNotSentEditCount(@Nullable String s, @NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex0;
        String s1;
        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearAndIncrementNotSentEditCount.1 smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearAndIncrementNotSentEditCount.1) {
            smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearAndIncrementNotSentEditCount.1)continuation0;
            int v = smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.G;
            if((v & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object D;
                    public int G;
                    public String r;
                    public Mutex w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.D = object0;
                        this.G |= 0x80000000;
                        return continuation0.clearAndIncrementNotSentEditCount(null, this);
                    }
                };
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.G = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object D;
                public int G;
                public String r;
                public Mutex w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.D = object0;
                    this.G |= 0x80000000;
                    return continuation0.clearAndIncrementNotSentEditCount(null, this);
                }
            };
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.D;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.G) {
            case 0: {
                n.D(object0);
                s1 = s;
                smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.r = s1;
                mutex0 = SmartPlaylistServerSyncPreferencesRepository.b;
                smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.w = mutex0;
                v1 = 0;
                smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.B = 0;
                smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.G = 1;
                if(mutex0.lock(null, smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10) == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                int v2 = smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.B;
                Mutex mutex1 = smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.w;
                String s2 = smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.r;
                n.D(object0);
                s1 = s2;
                v1 = v2;
                mutex0 = mutex1;
                try {
                label_30:
                    LogU.debug$default(SmartPlaylistServerSyncPreferencesRepository.a, "clearAndIncrementNotSentEditCount()-" + s1, null, false, 6, null);
                    com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearAndIncrementNotSentEditCount.2.1 smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$2$10 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        public int r;

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearAndIncrementNotSentEditCount.2.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearAndIncrementNotSentEditCount.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.r) {
                                case 0: {
                                    n.D(object0);
                                    i i0 = SmartPlaylistServerSyncPreferencesRepository.access$getDataStore(SmartPlaylistServerSyncPreferencesRepository.INSTANCE);
                                    com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearAndIncrementNotSentEditCount.2.1.1 smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$2$1$10 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                        public Object r;

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearAndIncrementNotSentEditCount.2.1.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                            continuation1.r = object0;
                                            return continuation1;
                                        }

                                        public final Object invoke(SpServerSyncPreferences spServerSyncPreferences0, Continuation continuation0) {
                                            return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearAndIncrementNotSentEditCount.2.1.1)this.create(spServerSyncPreferences0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((SpServerSyncPreferences)object0), ((Continuation)object1));
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)this.r;
                                            n.D(object0);
                                            w1 w10 = (w1)spServerSyncPreferences0.toBuilder();
                                            w10.i(1);
                                            return w10.a();
                                        }
                                    };
                                    this.r = 1;
                                    if(i0.a(smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$2$1$10, this) == a0) {
                                        return a0;
                                    }
                                    break;
                                }
                                case 1: {
                                    n.D(object0);
                                    break;
                                }
                                case 2: {
                                    n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                            this.r = 2;
                            return SmartPlaylistServerSyncPreferencesRepository.INSTANCE.a(this) == a0 ? a0 : H.a;
                        }
                    };
                    smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.r = null;
                    smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.w = mutex0;
                    smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.B = v1;
                    smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.G = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$2$10, smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable0;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                try {
                    mutex2 = smartPlaylistServerSyncPreferencesRepository$clearAndIncrementNotSentEditCount$10.w;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
                mutex2.unlock(null);
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return H.a;
    }

    public static Object clearAndIncrementNotSentEditCount$default(SmartPlaylistServerSyncPreferencesRepository smartPlaylistServerSyncPreferencesRepository0, String s, Continuation continuation0, int v, Object object0) {
        if((v & 1) != 0) {
            s = "";
        }
        return smartPlaylistServerSyncPreferencesRepository0.clearAndIncrementNotSentEditCount(s, continuation0);
    }

    @Nullable
    public final Object clearNotSentEditCount(@Nullable String s, @NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex0;
        String s1;
        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearNotSentEditCount.1 smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearNotSentEditCount.1) {
            smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearNotSentEditCount.1)continuation0;
            int v = smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.G;
            if((v & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object D;
                    public int G;
                    public String r;
                    public Mutex w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.D = object0;
                        this.G |= 0x80000000;
                        return continuation0.clearNotSentEditCount(null, this);
                    }
                };
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.G = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object D;
                public int G;
                public String r;
                public Mutex w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.D = object0;
                    this.G |= 0x80000000;
                    return continuation0.clearNotSentEditCount(null, this);
                }
            };
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.D;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.G) {
            case 0: {
                n.D(object0);
                s1 = s;
                smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.r = s1;
                mutex0 = SmartPlaylistServerSyncPreferencesRepository.b;
                smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.w = mutex0;
                v1 = 0;
                smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.B = 0;
                smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.G = 1;
                if(mutex0.lock(null, smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10) == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                int v2 = smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.B;
                Mutex mutex1 = smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.w;
                String s2 = smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.r;
                n.D(object0);
                s1 = s2;
                v1 = v2;
                mutex0 = mutex1;
                try {
                label_30:
                    LogU.debug$default(SmartPlaylistServerSyncPreferencesRepository.a, "clearNotSendEditCount()-" + s1, null, false, 6, null);
                    com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearNotSentEditCount.2.1 smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$2$10 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        public int r;

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearNotSentEditCount.2.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearNotSentEditCount.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.r) {
                                case 0: {
                                    n.D(object0);
                                    i i0 = SmartPlaylistServerSyncPreferencesRepository.access$getDataStore(SmartPlaylistServerSyncPreferencesRepository.INSTANCE);
                                    com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearNotSentEditCount.2.1.1 smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$2$1$10 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                        public Object r;

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearNotSentEditCount.2.1.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                            continuation1.r = object0;
                                            return continuation1;
                                        }

                                        public final Object invoke(SpServerSyncPreferences spServerSyncPreferences0, Continuation continuation0) {
                                            return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.clearNotSentEditCount.2.1.1)this.create(spServerSyncPreferences0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((SpServerSyncPreferences)object0), ((Continuation)object1));
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)this.r;
                                            n.D(object0);
                                            w1 w10 = (w1)spServerSyncPreferences0.toBuilder();
                                            w10.i(0);
                                            return w10.a();
                                        }
                                    };
                                    this.r = 1;
                                    if(i0.a(smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$2$1$10, this) == a0) {
                                        return a0;
                                    }
                                    break;
                                }
                                case 1: {
                                    n.D(object0);
                                    break;
                                }
                                case 2: {
                                    n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                            this.r = 2;
                            return SmartPlaylistServerSyncPreferencesRepository.INSTANCE.a(this) == a0 ? a0 : H.a;
                        }
                    };
                    smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.r = null;
                    smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.w = mutex0;
                    smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.B = v1;
                    smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.G = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$2$10, smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable0;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                try {
                    mutex2 = smartPlaylistServerSyncPreferencesRepository$clearNotSentEditCount$10.w;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
                mutex2.unlock(null);
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return H.a;
    }

    public static Object clearNotSentEditCount$default(SmartPlaylistServerSyncPreferencesRepository smartPlaylistServerSyncPreferencesRepository0, String s, Continuation continuation0, int v, Object object0) {
        if((v & 1) != 0) {
            s = "";
        }
        return smartPlaylistServerSyncPreferencesRepository0.clearNotSentEditCount(s, continuation0);
    }

    @Nullable
    public final Object decrementNotSentEditCount(@Nullable String s, @NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex0;
        String s1;
        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.decrementNotSentEditCount.1 smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.decrementNotSentEditCount.1) {
            smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.decrementNotSentEditCount.1)continuation0;
            int v = smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.G;
            if((v & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object D;
                    public int G;
                    public String r;
                    public Mutex w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.D = object0;
                        this.G |= 0x80000000;
                        return continuation0.decrementNotSentEditCount(null, this);
                    }
                };
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.G = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object D;
                public int G;
                public String r;
                public Mutex w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.D = object0;
                    this.G |= 0x80000000;
                    return continuation0.decrementNotSentEditCount(null, this);
                }
            };
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.D;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.G) {
            case 0: {
                n.D(object0);
                s1 = s;
                smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.r = s1;
                mutex0 = SmartPlaylistServerSyncPreferencesRepository.b;
                smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.w = mutex0;
                v1 = 0;
                smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.B = 0;
                smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.G = 1;
                if(mutex0.lock(null, smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10) == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                int v2 = smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.B;
                Mutex mutex1 = smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.w;
                String s2 = smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.r;
                n.D(object0);
                s1 = s2;
                v1 = v2;
                mutex0 = mutex1;
                try {
                label_30:
                    LogU.debug$default(SmartPlaylistServerSyncPreferencesRepository.a, "decrementNotSendEditCount()-" + s1, null, false, 6, null);
                    com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.decrementNotSentEditCount.2.1 smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$2$10 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        public int r;

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.decrementNotSentEditCount.2.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.decrementNotSentEditCount.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.r) {
                                case 0: {
                                    n.D(object0);
                                    i i0 = SmartPlaylistServerSyncPreferencesRepository.access$getDataStore(SmartPlaylistServerSyncPreferencesRepository.INSTANCE);
                                    com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.decrementNotSentEditCount.2.1.1 smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$2$1$10 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                        public Object r;

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.decrementNotSentEditCount.2.1.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                            continuation1.r = object0;
                                            return continuation1;
                                        }

                                        public final Object invoke(SpServerSyncPreferences spServerSyncPreferences0, Continuation continuation0) {
                                            return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.decrementNotSentEditCount.2.1.1)this.create(spServerSyncPreferences0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((SpServerSyncPreferences)object0), ((Continuation)object1));
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)this.r;
                                            n.D(object0);
                                            int v = spServerSyncPreferences0.getNotSentEditCount() - 1;
                                            if(!b.d() && v < 0) {
                                                throw new IllegalStateException("Check failed.");
                                            }
                                            if(v < 0) {
                                                v = 0;
                                            }
                                            w1 w10 = (w1)spServerSyncPreferences0.toBuilder();
                                            w10.i(v);
                                            return w10.a();
                                        }
                                    };
                                    this.r = 1;
                                    if(i0.a(smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$2$1$10, this) == a0) {
                                        return a0;
                                    }
                                    break;
                                }
                                case 1: {
                                    n.D(object0);
                                    break;
                                }
                                case 2: {
                                    n.D(object0);
                                    return H.a;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                            this.r = 2;
                            return SmartPlaylistServerSyncPreferencesRepository.INSTANCE.a(this) == a0 ? a0 : H.a;
                        }
                    };
                    smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.r = null;
                    smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.w = mutex0;
                    smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.B = v1;
                    smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.G = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$2$10, smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10) == a0) {
                        return a0;
                    }
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    mutex2.unlock(null);
                    throw throwable0;
                }
                mutex2 = mutex0;
                break;
            }
            case 2: {
                try {
                    mutex2 = smartPlaylistServerSyncPreferencesRepository$decrementNotSentEditCount$10.w;
                    n.D(object0);
                    break;
                }
                catch(Throwable throwable0) {
                }
                mutex2.unlock(null);
                throw throwable0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        return H.a;
    }

    public static Object decrementNotSentEditCount$default(SmartPlaylistServerSyncPreferencesRepository smartPlaylistServerSyncPreferencesRepository0, String s, Continuation continuation0, int v, Object object0) {
        if((v & 1) != 0) {
            s = "";
        }
        return smartPlaylistServerSyncPreferencesRepository0.decrementNotSentEditCount(s, continuation0);
    }

    @NotNull
    public final Flow getLastHistoryReqDate() {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getLastHistoryReqDate..inlined.map.1.2 smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getLastHistoryReqDate..inlined.map.1.2.1 smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getLastHistoryReqDate..inlined.map.1.2.1) {
                            smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getLastHistoryReqDate..inlined.map.1.2.1)continuation0;
                            int v = smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    public Object r;
                                    public int w;

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        this.r = object0;
                                        this.w |= 0x80000000;
                                        return continuation0.emit(null, this);
                                    }
                                };
                            }
                            else {
                                smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                public Object r;
                                public int w;

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    this.r = object0;
                                    this.w |= 0x80000000;
                                    return continuation0.emit(null, this);
                                }
                            };
                        }
                        Object object1 = smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10.w = 1;
                                return this.a.emit("", smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                            }
                            case 1: {
                                n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                Object object0 = this.a.collect(smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/SpServerSyncPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$1", f = "SmartPlaylistServerSyncPreferencesRepository.kt", l = {0x4F}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getLastHistoryReqDate.1 extends oe.i implements o {
            public Throwable B;
            public int r;
            public FlowCollector w;

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getLastHistoryReqDate.1 smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$10 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getLastHistoryReqDate.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$10.w = flowCollector0;
                smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$10.B = throwable0;
                return smartPlaylistServerSyncPreferencesRepository$getLastHistoryReqDate$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector0 = this.w;
                Throwable throwable0 = this.B;
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable0 instanceof IOException)) {
                            throw throwable0;
                        }
                        LogU.error$default(SmartPlaylistServerSyncPreferencesRepository.a, "getLastHistoryReqDate()", throwable0, false, 4, null);
                        SpServerSyncPreferences spServerSyncPreferences0 = SmartPlaylistServerSyncPrefSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(spServerSyncPreferences0, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    @NotNull
    public final Flow getMemberKeyFlow() {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getMemberKeyFlow..inlined.map.1.2 smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getMemberKeyFlow..inlined.map.1.2.1 smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getMemberKeyFlow..inlined.map.1.2.1) {
                            smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getMemberKeyFlow..inlined.map.1.2.1)continuation0;
                            int v = smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    public Object r;
                                    public int w;

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        this.r = object0;
                                        this.w |= 0x80000000;
                                        return continuation0.emit(null, this);
                                    }
                                };
                            }
                            else {
                                smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                public Object r;
                                public int w;

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    this.r = object0;
                                    this.w |= 0x80000000;
                                    return continuation0.emit(null, this);
                                }
                            };
                        }
                        Object object1 = smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10.w = 1;
                                return this.a.emit("", smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                            }
                            case 1: {
                                n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                Object object0 = this.a.collect(smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/SpServerSyncPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$1", f = "SmartPlaylistServerSyncPreferencesRepository.kt", l = {35}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getMemberKeyFlow.1 extends oe.i implements o {
            public Throwable B;
            public int r;
            public FlowCollector w;

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getMemberKeyFlow.1 smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$10 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getMemberKeyFlow.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$10.w = flowCollector0;
                smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$10.B = throwable0;
                return smartPlaylistServerSyncPreferencesRepository$getMemberKeyFlow$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector0 = this.w;
                Throwable throwable0 = this.B;
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable0 instanceof IOException)) {
                            throw throwable0;
                        }
                        LogU.error$default(SmartPlaylistServerSyncPreferencesRepository.a, "getMemberKeyFlow()", throwable0, false, 4, null);
                        SpServerSyncPreferences spServerSyncPreferences0 = SmartPlaylistServerSyncPrefSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(spServerSyncPreferences0, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    @NotNull
    public final Flow getNotSentEditCount() {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getNotSentEditCount..inlined.map.1.2 smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getNotSentEditCount..inlined.map.1.2.1 smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getNotSentEditCount..inlined.map.1.2.1) {
                            smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getNotSentEditCount..inlined.map.1.2.1)continuation0;
                            int v = smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    public Object r;
                                    public int w;

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        this.r = object0;
                                        this.w |= 0x80000000;
                                        return continuation0.emit(null, this);
                                    }
                                };
                            }
                            else {
                                smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                public Object r;
                                public int w;

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    this.r = object0;
                                    this.w |= 0x80000000;
                                    return continuation0.emit(null, this);
                                }
                            };
                        }
                        Object object1 = smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10.w = 1;
                                return this.a.emit(new Integer(((SpServerSyncPreferences)object0).getNotSentEditCount()), smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                            }
                            case 1: {
                                n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                Object object0 = this.a.collect(smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/SpServerSyncPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$1", f = "SmartPlaylistServerSyncPreferencesRepository.kt", l = {68}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getNotSentEditCount.1 extends oe.i implements o {
            public Throwable B;
            public int r;
            public FlowCollector w;

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getNotSentEditCount.1 smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$10 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getNotSentEditCount.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$10.w = flowCollector0;
                smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$10.B = throwable0;
                return smartPlaylistServerSyncPreferencesRepository$getNotSentEditCount$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector0 = this.w;
                Throwable throwable0 = this.B;
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable0 instanceof IOException)) {
                            throw throwable0;
                        }
                        LogU.error$default(SmartPlaylistServerSyncPreferencesRepository.a, "getNotSentEditCount()", throwable0, false, 4, null);
                        SpServerSyncPreferences spServerSyncPreferences0 = SmartPlaylistServerSyncPrefSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(spServerSyncPreferences0, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    @NotNull
    public final Flow getVersionDateFlow() {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionDateFlow..inlined.map.1.2 smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionDateFlow..inlined.map.1.2.1 smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionDateFlow..inlined.map.1.2.1) {
                            smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionDateFlow..inlined.map.1.2.1)continuation0;
                            int v = smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    public Object r;
                                    public int w;

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        this.r = object0;
                                        this.w |= 0x80000000;
                                        return continuation0.emit(null, this);
                                    }
                                };
                            }
                            else {
                                smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                public Object r;
                                public int w;

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    this.r = object0;
                                    this.w |= 0x80000000;
                                    return continuation0.emit(null, this);
                                }
                            };
                        }
                        Object object1 = smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                Long long0 = new Long(((SpServerSyncPreferences)object0).getVersionDate());
                                smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10.w = 1;
                                return this.a.emit(long0, smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                            }
                            case 1: {
                                n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                Object object0 = this.a.collect(smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/SpServerSyncPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$1", f = "SmartPlaylistServerSyncPreferencesRepository.kt", l = {46}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionDateFlow.1 extends oe.i implements o {
            public Throwable B;
            public int r;
            public FlowCollector w;

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionDateFlow.1 smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$10 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionDateFlow.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$10.w = flowCollector0;
                smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$10.B = throwable0;
                return smartPlaylistServerSyncPreferencesRepository$getVersionDateFlow$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector0 = this.w;
                Throwable throwable0 = this.B;
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable0 instanceof IOException)) {
                            throw throwable0;
                        }
                        LogU.error$default(SmartPlaylistServerSyncPreferencesRepository.a, "getVersionDateFlow()", throwable0, false, 4, null);
                        SpServerSyncPreferences spServerSyncPreferences0 = SmartPlaylistServerSyncPrefSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(spServerSyncPreferences0, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    @NotNull
    public final Flow getVersionThresholdFlow() {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionThresholdFlow..inlined.map.1.2 smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionThresholdFlow..inlined.map.1.2.1 smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionThresholdFlow..inlined.map.1.2.1) {
                            smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionThresholdFlow..inlined.map.1.2.1)continuation0;
                            int v = smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                    public Object r;
                                    public int w;

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        this.r = object0;
                                        this.w |= 0x80000000;
                                        return continuation0.emit(null, this);
                                    }
                                };
                            }
                            else {
                                smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                public Object r;
                                public int w;

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    this.r = object0;
                                    this.w |= 0x80000000;
                                    return continuation0.emit(null, this);
                                }
                            };
                        }
                        Object object1 = smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                Integer integer0 = new Integer(((SpServerSyncPreferences)object0).getVersionThreshold());
                                smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10.w = 1;
                                return this.a.emit(integer0, smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$2$10) == a0 ? a0 : H.a;
                            }
                            case 1: {
                                n.D(object1);
                                return H.a;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                Object object0 = this.a.collect(smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/SpServerSyncPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$1", f = "SmartPlaylistServerSyncPreferencesRepository.kt", l = {57}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionThresholdFlow.1 extends oe.i implements o {
            public Throwable B;
            public int r;
            public FlowCollector w;

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionThresholdFlow.1 smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$10 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.getVersionThresholdFlow.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$10.w = flowCollector0;
                smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$10.B = throwable0;
                return smartPlaylistServerSyncPreferencesRepository$getVersionThresholdFlow$10.invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                FlowCollector flowCollector0 = this.w;
                Throwable throwable0 = this.B;
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        if(!(throwable0 instanceof IOException)) {
                            throw throwable0;
                        }
                        LogU.error$default(SmartPlaylistServerSyncPreferencesRepository.a, "getVersionThresholdFlow()", throwable0, false, 4, null);
                        SpServerSyncPreferences spServerSyncPreferences0 = SmartPlaylistServerSyncPrefSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(spServerSyncPreferences0, this) == a0 ? a0 : H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    @Nullable
    public final Object incrementNotSentEditCount(@Nullable String s, @NotNull Continuation continuation0) {
        Mutex mutex2;
        int v1;
        Mutex mutex0;
        String s1;
        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.incrementNotSentEditCount.1 smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.incrementNotSentEditCount.1) {
            smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.incrementNotSentEditCount.1)continuation0;
            int v = smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.G;
            if((v & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object D;
                    public int G;
                    public String r;
                    public Mutex w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.D = object0;
                        this.G |= 0x80000000;
                        return continuation0.incrementNotSentEditCount(null, this);
                    }
                };
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.G = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object D;
                public int G;
                public String r;
                public Mutex w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.D = object0;
                    this.G |= 0x80000000;
                    return continuation0.incrementNotSentEditCount(null, this);
                }
            };
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.D;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.G) {
            case 0: {
                n.D(object0);
                s1 = s;
                smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.r = s1;
                mutex0 = SmartPlaylistServerSyncPreferencesRepository.b;
                smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.w = mutex0;
                v1 = 0;
                smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.B = 0;
                smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.G = 1;
                if(mutex0.lock(null, smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10) == a0) {
                    return a0;
                }
                goto label_30;
            }
            case 1: {
                int v2 = smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.B;
                Mutex mutex1 = smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.w;
                String s2 = smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.r;
                n.D(object0);
                s1 = s2;
                v1 = v2;
                mutex0 = mutex1;
                try {
                label_30:
                    LogU.debug$default(SmartPlaylistServerSyncPreferencesRepository.a, "incrementNotSentEditCount()-" + s1, null, false, 6, null);
                    com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.incrementNotSentEditCount.2.1 smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$2$10 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        public int r;

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.incrementNotSentEditCount.2.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.incrementNotSentEditCount.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            a a0 = a.a;
                            switch(this.r) {
                                case 0: {
                                    n.D(object0);
                                    i i0 = SmartPlaylistServerSyncPreferencesRepository.access$getDataStore(SmartPlaylistServerSyncPreferencesRepository.INSTANCE);
                                    com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.incrementNotSentEditCount.2.1.1 smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$2$1$10 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                        public Object r;

                                        @Override  // oe.a
                                        public final Continuation create(Object object0, Continuation continuation0) {
                                            Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.incrementNotSentEditCount.2.1.1(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                                            continuation1.r = object0;
                                            return continuation1;
                                        }

                                        public final Object invoke(SpServerSyncPreferences spServerSyncPreferences0, Continuation continuation0) {
                                            return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.incrementNotSentEditCount.2.1.1)this.create(spServerSyncPreferences0, continuation0)).invokeSuspend(H.a);
                                        }

                                        @Override  // we.n
                                        public Object invoke(Object object0, Object object1) {
                                            return this.invoke(((SpServerSyncPreferences)object0), ((Continuation)object1));
                                        }

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)this.r;
                                            n.D(object0);
                                            w1 w10 = (w1)spServerSyncPreferences0.toBuilder();
                                            w10.i(spServerSyncPreferences0.getNotSentEditCount() + 1);
                                            return w10.a();
                                        }
                                    };
                                    this.r = 1;
                                    Object object1 = i0.a(smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$2$1$10, this);
                                    return object1 == a0 ? a0 : object1;
                                }
                                case 1: {
                                    n.D(object0);
                                    return object0;
                                }
                                default: {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                            }
                        }
                    };
                    smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.r = null;
                    smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.w = mutex0;
                    smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.B = v1;
                    smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.G = 2;
                    object0 = BuildersKt.withContext(Dispatchers.getIO(), smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$2$10, smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10);
                }
                catch(Throwable throwable0) {
                    mutex2 = mutex0;
                    break;
                }
                if(object0 == a0) {
                    return a0;
                }
                mutex2 = mutex0;
                goto label_47;
            }
            case 2: {
                try {
                    mutex2 = smartPlaylistServerSyncPreferencesRepository$incrementNotSentEditCount$10.w;
                    n.D(object0);
                label_47:
                    SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)object0;
                    goto label_52;
                }
                catch(Throwable throwable0) {
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        mutex2.unlock(null);
        throw throwable0;
    label_52:
        mutex2.unlock(null);
        return H.a;
    }

    public static Object incrementNotSentEditCount$default(SmartPlaylistServerSyncPreferencesRepository smartPlaylistServerSyncPreferencesRepository0, String s, Continuation continuation0, int v, Object object0) {
        if((v & 1) != 0) {
            s = "";
        }
        return smartPlaylistServerSyncPreferencesRepository0.incrementNotSentEditCount(s, continuation0);
    }

    @Nullable
    public final Object updateLastHistoryReqDate(@NotNull String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateLastHistoryReqDate.1 smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateLastHistoryReqDate.1) {
            smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateLastHistoryReqDate.1)continuation0;
            int v = smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10.B;
            if((v & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.updateLastHistoryReqDate(null, this);
                    }
                };
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10.B = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.updateLastHistoryReqDate(null, this);
                }
            };
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10.r;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10.B) {
            case 0: {
                n.D(object0);
                i i0 = SmartPlaylistServerSyncPreferencesRepository.b();
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateLastHistoryReqDate.2 smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$20 = new we.n(null) {
                    public Object r;
                    public final String w;

                    {
                        this.w = s;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateLastHistoryReqDate.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(SpServerSyncPreferences spServerSyncPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateLastHistoryReqDate.2)this.create(spServerSyncPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((SpServerSyncPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)this.r;
                        n.D(object0);
                        w1 w10 = (w1)spServerSyncPreferences0.toBuilder();
                        w10.d();
                        ((SpServerSyncPreferences)w10.b).setLastHistoryReqDate(this.w);
                        return w10.a();
                    }
                };
                smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10.B = 1;
                if(i0.a(smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$20, smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10.B = 2;
        return this.a(smartPlaylistServerSyncPreferencesRepository$updateLastHistoryReqDate$10) == a0 ? a0 : H.a;
    }

    @Nullable
    public final Object updateMemberKey(@NotNull String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateMemberKey.1 smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateMemberKey.1) {
            smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateMemberKey.1)continuation0;
            int v = smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10.B;
            if((v & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.updateMemberKey(null, this);
                    }
                };
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10.B = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.updateMemberKey(null, this);
                }
            };
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10.r;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10.B) {
            case 0: {
                n.D(object0);
                i i0 = SmartPlaylistServerSyncPreferencesRepository.b();
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateMemberKey.2 smartPlaylistServerSyncPreferencesRepository$updateMemberKey$20 = new we.n(null) {
                    public Object r;
                    public final String w;

                    {
                        this.w = s;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateMemberKey.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(SpServerSyncPreferences spServerSyncPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateMemberKey.2)this.create(spServerSyncPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((SpServerSyncPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)this.r;
                        n.D(object0);
                        w1 w10 = (w1)spServerSyncPreferences0.toBuilder();
                        w10.d();
                        ((SpServerSyncPreferences)w10.b).setMemberKey(this.w);
                        return w10.a();
                    }
                };
                smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10.B = 1;
                if(i0.a(smartPlaylistServerSyncPreferencesRepository$updateMemberKey$20, smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10.B = 2;
        return this.a(smartPlaylistServerSyncPreferencesRepository$updateMemberKey$10) == a0 ? a0 : H.a;
    }

    @Nullable
    public final Object updateVersionDate(long v, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionDate.1 smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionDate.1) {
            smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionDate.1)continuation0;
            int v1 = smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10.D;
            if((v1 & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int D;
                    public long r;
                    public Object w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.w = object0;
                        this.D |= 0x80000000;
                        return continuation0.updateVersionDate(0L, this);
                    }
                };
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10.D = v1 ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int D;
                public long r;
                public Object w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.w = object0;
                    this.D |= 0x80000000;
                    return continuation0.updateVersionDate(0L, this);
                }
            };
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10.w;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10.D) {
            case 0: {
                n.D(object0);
                i i0 = SmartPlaylistServerSyncPreferencesRepository.b();
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionDate.2 smartPlaylistServerSyncPreferencesRepository$updateVersionDate$20 = new we.n(null) {
                    public Object r;
                    public final long w;

                    {
                        this.w = v;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionDate.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(SpServerSyncPreferences spServerSyncPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionDate.2)this.create(spServerSyncPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((SpServerSyncPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)this.r;
                        n.D(object0);
                        w1 w10 = (w1)spServerSyncPreferences0.toBuilder();
                        w10.d();
                        ((SpServerSyncPreferences)w10.b).setVersionDate(this.w);
                        return w10.a();
                    }
                };
                smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10.r = v;
                smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10.D = 1;
                if(i0.a(smartPlaylistServerSyncPreferencesRepository$updateVersionDate$20, smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10.r = v;
        smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10.D = 2;
        return this.a(smartPlaylistServerSyncPreferencesRepository$updateVersionDate$10) == a0 ? a0 : H.a;
    }

    @Nullable
    public final Object updateVersionThreshold(int v, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionThreshold.1 smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionThreshold.1) {
            smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10 = (com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionThreshold.1)continuation0;
            int v1 = smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10.D;
            if((v1 & 0x80000000) == 0) {
                smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int D;
                    public int r;
                    public Object w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.w = object0;
                        this.D |= 0x80000000;
                        return continuation0.updateVersionThreshold(0, this);
                    }
                };
            }
            else {
                smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10.D = v1 ^ 0x80000000;
            }
        }
        else {
            smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int D;
                public int r;
                public Object w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.w = object0;
                    this.D |= 0x80000000;
                    return continuation0.updateVersionThreshold(0, this);
                }
            };
        }
        Object object0 = smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10.w;
        a a0 = a.a;
        switch(smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10.D) {
            case 0: {
                n.D(object0);
                i i0 = SmartPlaylistServerSyncPreferencesRepository.b();
                com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionThreshold.2 smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$20 = new we.n(null) {
                    public Object r;
                    public final int w;

                    {
                        this.w = v;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionThreshold.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(SpServerSyncPreferences spServerSyncPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository.updateVersionThreshold.2)this.create(spServerSyncPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((SpServerSyncPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        SpServerSyncPreferences spServerSyncPreferences0 = (SpServerSyncPreferences)this.r;
                        n.D(object0);
                        w1 w10 = (w1)spServerSyncPreferences0.toBuilder();
                        w10.d();
                        ((SpServerSyncPreferences)w10.b).setVersionThreshold(this.w);
                        return w10.a();
                    }
                };
                smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10.r = v;
                smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10.D = 1;
                if(i0.a(smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$20, smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10.r;
                n.D(object0);
                break;
            }
            case 2: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10.r = v;
        smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10.D = 2;
        return this.a(smartPlaylistServerSyncPreferencesRepository$updateVersionThreshold$10) == a0 ? a0 : H.a;
    }
}

