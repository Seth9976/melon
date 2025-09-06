package com.iloen.melon.utils.datastore;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference;
import d5.n;
import ie.H;
import java.io.IOException;
import k8.r1;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import l2.i;
import ne.a;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001J\u001E\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\t\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0002H\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\bH\u0086@¢\u0006\u0004\b\u000B\u0010\fR\u001D\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000E0\r8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/utils/datastore/OfflineCacheCheckDatePrefRepository;", "", "", "playlistKey", "Lkotlinx/coroutines/flow/Flow;", "getOfflineCacheExpireDate", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "date", "Lie/H;", "updateOfflineCacheDate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetOfflineCacheDate", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ll2/i;", "Lcom/iloen/melon/OfflineCacheCheckDatePref$OfflineCacheCheckDatePreference;", "a", "Ll2/i;", "getDataStore", "()Ll2/i;", "dataStore", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class OfflineCacheCheckDatePrefRepository {
    public static final int $stable;
    @NotNull
    public static final OfflineCacheCheckDatePrefRepository INSTANCE;
    public static final i a;

    static {
        OfflineCacheCheckDatePrefRepository.INSTANCE = new OfflineCacheCheckDatePrefRepository();  // 初始化器: Ljava/lang/Object;-><init>()V
        MelonAppBase.Companion.getClass();
        OfflineCacheCheckDatePrefRepository.a = OfflineCacheCheckDatePrefSerializerKt.getOfflineCacheCheckDatePrf(t.a().getContext());
        OfflineCacheCheckDatePrefRepository.$stable = 8;
    }

    @NotNull
    public final i getDataStore() {
        return OfflineCacheCheckDatePrefRepository.a;
    }

    @Nullable
    public final Object getOfflineCacheExpireDate(@NotNull String s, @NotNull Continuation continuation0) {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.getOfflineCacheExpireDate..inlined.map.1.2 offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.getOfflineCacheExpireDate..inlined.map.1.2.1 offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.getOfflineCacheExpireDate..inlined.map.1.2.1) {
                            offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.getOfflineCacheExpireDate..inlined.map.1.2.1)continuation0;
                            int v = offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                String s = (String)((OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)object0).getPlaylistCheckDateMap().get(this.b);
                                if(s == null) {
                                    s = "-1";
                                }
                                offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10.w = 1;
                                return this.b.emit(s, offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                Object object0 = s.collect(offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/OfflineCacheCheckDatePref$OfflineCacheCheckDatePreference;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$2", f = "OfflineCacheCheckDatePrefRepository.kt", l = {14}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.getOfflineCacheExpireDate.2 extends oe.i implements o {
            public Throwable B;
            public int r;
            public FlowCollector w;

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.getOfflineCacheExpireDate.2 offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$20 = new com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.getOfflineCacheExpireDate.2(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$20.w = flowCollector0;
                offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$20.B = throwable0;
                return offlineCacheCheckDatePrefRepository$getOfflineCacheExpireDate$20.invokeSuspend(H.a);
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
                        OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0 = OfflineCacheCheckDatePrefSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0, this) == a0 ? a0 : H.a;
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
    public final Object resetOfflineCacheDate(@NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.resetOfflineCacheDate.2 offlineCacheCheckDatePrefRepository$resetOfflineCacheDate$20 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
            public Object r;

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.resetOfflineCacheDate.2(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                continuation1.r = object0;
                return continuation1;
            }

            public final Object invoke(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0, Continuation continuation0) {
                return ((com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.resetOfflineCacheDate.2)this.create(offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)object0), ((Continuation)object1));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0 = (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)this.r;
                n.D(object0);
                r1 r10 = (r1)offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0.toBuilder();
                r10.d();
                ((OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)r10.b).getMutablePlaylistCheckDateMap().clear();
                return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)r10.a();
            }
        };
        Object object0 = OfflineCacheCheckDatePrefRepository.a.a(offlineCacheCheckDatePrefRepository$resetOfflineCacheDate$20, continuation0);
        return object0 == a.a ? object0 : H.a;
    }

    @Nullable
    public final Object updateOfflineCacheDate(@NotNull String s, @NotNull String s1, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.updateOfflineCacheDate.2 offlineCacheCheckDatePrefRepository$updateOfflineCacheDate$20 = new we.n(s1, null) {
            public final String B;
            public Object r;
            public final String w;

            {
                this.w = s;
                this.B = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.updateOfflineCacheDate.2(this.w, this.B, continuation0);
                continuation1.r = object0;
                return continuation1;
            }

            public final Object invoke(OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0, Continuation continuation0) {
                return ((com.iloen.melon.utils.datastore.OfflineCacheCheckDatePrefRepository.updateOfflineCacheDate.2)this.create(offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)object0), ((Continuation)object1));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0 = (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)this.r;
                n.D(object0);
                r1 r10 = (r1)offlineCacheCheckDatePref$OfflineCacheCheckDatePreference0.toBuilder();
                r10.getClass();
                this.w.getClass();
                this.B.getClass();
                r10.d();
                ((OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)r10.b).getMutablePlaylistCheckDateMap().put(this.w, this.B);
                return (OfflineCacheCheckDatePref.OfflineCacheCheckDatePreference)r10.a();
            }
        };
        Object object0 = OfflineCacheCheckDatePrefRepository.a.a(offlineCacheCheckDatePrefRepository$updateOfflineCacheDate$20, continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

