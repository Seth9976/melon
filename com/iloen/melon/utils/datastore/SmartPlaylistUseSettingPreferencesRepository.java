package com.iloen.melon.utils.datastore;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.SpMemberSettingPreferences;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.log.error.MelonDebugUtils;
import d5.n;
import ie.H;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import k8.t;
import k8.u1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.c;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;
import we.o;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J\u001B\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u0002H\u0086@¢\u0006\u0004\b\b\u0010\tJ6\u0010\r\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u001C\u0010\f\u001A\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000B\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086@¢\u0006\u0004\b\r\u0010\u000EJ \u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u0005H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/utils/datastore/SmartPlaylistUseSettingPreferencesRepository;", "", "", "memberKey", "Lkotlinx/coroutines/flow/Flow;", "", "getUseSmartPlaylistFlow", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getUseSmartPlaylist", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "set", "getUseSmartPlaylistOrSet", "(Ljava/lang/String;Lwe/k;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "use", "Lie/H;", "updateUseSmartPlaylist", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SmartPlaylistUseSettingPreferencesRepository {
    public static final int $stable;
    @NotNull
    public static final SmartPlaylistUseSettingPreferencesRepository INSTANCE;
    public static final LogU a;

    static {
        SmartPlaylistUseSettingPreferencesRepository.INSTANCE = new SmartPlaylistUseSettingPreferencesRepository();  // 初始化器: Ljava/lang/Object;-><init>()V
        SmartPlaylistUseSettingPreferencesRepository.a = new LogU("SmartPlaylistUsePreferencesRepository");
        SmartPlaylistUseSettingPreferencesRepository.$stable = 8;
    }

    @Nullable
    public final Object getUseSmartPlaylist(@NotNull String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylist.1 smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylist.1) {
            smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10 = (com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylist.1)continuation0;
            int v = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10.B;
            if((v & 0x80000000) == 0) {
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.getUseSmartPlaylist(null, this);
                    }
                };
            }
            else {
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10.B = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.getUseSmartPlaylist(null, this);
                }
            };
        }
        Object object0 = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10.r;
        a a0 = a.a;
        switch(smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10.B) {
            case 0: {
                n.D(object0);
                Flow flow0 = this.getUseSmartPlaylistFlow(s);
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10.B = 1;
                object0 = FlowKt.firstOrNull(flow0, smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylist$10);
                if(object0 == a0) {
                    return a0;
                }
                return ((Boolean)object0) == null ? false : Boolean.valueOf(((Boolean)object0).booleanValue());
            }
            case 1: {
                n.D(object0);
                return ((Boolean)object0) == null ? false : Boolean.valueOf(((Boolean)object0).booleanValue());
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @NotNull
    public final Flow getUseSmartPlaylistFlow(@NotNull String s) {
        q.g(s, "memberKey");
        MelonAppBase.Companion.getClass();
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistFlow..inlined.map.1.2 smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistFlow..inlined.map.1.2.1 smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistFlow..inlined.map.1.2.1) {
                            smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistFlow..inlined.map.1.2.1)continuation0;
                            int v = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                Boolean boolean0 = (Boolean)((SpMemberSettingPreferences)object0).getSpMemberSettingsMap().get(this.b);
                                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10.w = 1;
                                return this.b.emit(Boolean.valueOf((boolean0 == null ? false : boolean0.booleanValue())), smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                Object object0 = s.collect(smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/SpMemberSettingPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$1", f = "SmartPlaylistUseSettingPreferencesRepository.kt", l = {0x1F}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistFlow.1 extends i implements o {
            public Throwable B;
            public final String D;
            public int r;
            public FlowCollector w;

            public com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistFlow.1(String s, Continuation continuation0) {
                this.D = s;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistFlow.1 smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$10 = new com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistFlow.1(this.D, continuation0);
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$10.w = flowCollector0;
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$10.B = throwable0;
                return smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistFlow$10.invokeSuspend(H.a);
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
                        LogU.error$default(SmartPlaylistUseSettingPreferencesRepository.a, "getUseSmartPlaylistFlow(" + this.D + ")", throwable0, false, 4, null);
                        SpMemberSettingPreferences spMemberSettingPreferences0 = SmartPlaylistUseSettingPrefSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(spMemberSettingPreferences0, this) == a0 ? a0 : H.a;
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
    public final Object getUseSmartPlaylistOrSet(@NotNull String s, @NotNull k k0, @NotNull Continuation continuation0) {
        boolean z2;
        com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistOrSet.1 smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistOrSet.1) {
            smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10 = (com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.getUseSmartPlaylistOrSet.1)continuation0;
            int v = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.G;
            if((v & 0x80000000) == 0) {
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public boolean B;
                    public Object D;
                    public int G;
                    public String r;
                    public k w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.D = object0;
                        this.G |= 0x80000000;
                        return continuation0.getUseSmartPlaylistOrSet(null, null, this);
                    }
                };
            }
            else {
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.G = v ^ 0x80000000;
            }
        }
        else {
            smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public boolean B;
                public Object D;
                public int G;
                public String r;
                public k w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.D = object0;
                    this.G |= 0x80000000;
                    return continuation0.getUseSmartPlaylistOrSet(null, null, this);
                }
            };
        }
        Object object0 = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.D;
        a a0 = a.a;
        boolean z = true;
        switch(smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.G) {
            case 0: {
                n.D(object0);
                if(s.length() == 0) {
                    MelonDebugUtils.INSTANCE.errorLogOrException(SmartPlaylistUseSettingPreferencesRepository.a, "getUseSmartPlaylistOrSet(" + s + ")");
                }
                MelonAppBase.Companion.getClass();
                Flow flow0 = SmartPlaylistUseSettingPrefSerializerKt.getSmartPlaylistUseSettingDataStore(t.a().getContext()).getData();
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.r = s;
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.w = k0;
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.G = 1;
                object0 = FlowKt.firstOrNull(flow0, smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_28;
            }
            case 1: {
                k0 = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.w;
                s = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.r;
                n.D(object0);
            label_28:
                Map map0 = ((SpMemberSettingPreferences)object0) == null ? null : ((SpMemberSettingPreferences)object0).getSpMemberSettingsMap();
                Boolean boolean0 = map0 == null ? null : ((Boolean)map0.get(s));
                if(boolean0 != null) {
                    return Boolean.valueOf(boolean0.booleanValue());
                }
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.r = s;
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.w = null;
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.G = 2;
                object0 = k0.invoke(smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_40;
            }
            case 2: {
                s = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.r;
                n.D(object0);
            label_40:
                boolean z1 = ((Boolean)object0).booleanValue();
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.r = null;
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.w = null;
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.B = z1;
                smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.G = 3;
                if(this.updateUseSmartPlaylist(s, z1, smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10) == a0) {
                    return a0;
                }
                z2 = z1;
                break;
            }
            case 3: {
                z2 = smartPlaylistUseSettingPreferencesRepository$getUseSmartPlaylistOrSet$10.B;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(!z2) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    @Nullable
    public final Object updateUseSmartPlaylist(@NotNull String s, boolean z, @NotNull Continuation continuation0) {
        if(s.length() == 0) {
            MelonDebugUtils.INSTANCE.errorLogOrException(SmartPlaylistUseSettingPreferencesRepository.a, "updateUseSmartPlaylist(" + s + ")");
        }
        MelonAppBase.Companion.getClass();
        Object object0 = SmartPlaylistUseSettingPrefSerializerKt.getSmartPlaylistUseSettingDataStore(t.a().getContext()).a(new we.n(z, null) {
            public final boolean B;
            public Object r;
            public final String w;

            {
                this.w = s;
                this.B = z;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.updateUseSmartPlaylist.2(this.w, this.B, continuation0);
                continuation1.r = object0;
                return continuation1;
            }

            public final Object invoke(SpMemberSettingPreferences spMemberSettingPreferences0, Continuation continuation0) {
                return ((com.iloen.melon.utils.datastore.SmartPlaylistUseSettingPreferencesRepository.updateUseSmartPlaylist.2)this.create(spMemberSettingPreferences0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((SpMemberSettingPreferences)object0), ((Continuation)object1));
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                SpMemberSettingPreferences spMemberSettingPreferences0 = (SpMemberSettingPreferences)this.r;
                n.D(object0);
                u1 u10 = (u1)spMemberSettingPreferences0.toBuilder();
                Map map0 = Collections.unmodifiableMap(((SpMemberSettingPreferences)u10.b).getSpMemberSettingsMap());
                String s = this.w;
                Boolean boolean0 = (Boolean)map0.get(s);
                boolean z = this.B;
                if(boolean0 == null) {
                    u10.d();
                    ((SpMemberSettingPreferences)u10.b).getMutableSpMemberSettingsMap().put(s, Boolean.valueOf(z));
                    return (SpMemberSettingPreferences)u10.a();
                }
                u10.d();
                ((SpMemberSettingPreferences)u10.b).getMutableSpMemberSettingsMap().put(s, Boolean.valueOf(z));
                return (SpMemberSettingPreferences)u10.a();
            }
        }, continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

