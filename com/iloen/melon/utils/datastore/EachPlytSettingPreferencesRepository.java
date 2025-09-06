package com.iloen.melon.utils.datastore;

import com.iloen.melon.EachPlytSettingPreferences;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import ie.m;
import java.io.IOException;
import java.util.List;
import k8.r;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import l2.i;
import ne.a;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.o;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B\u0015\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\tH\u0086@¢\u0006\u0004\b\f\u0010\rJ$\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\tH\u0086@¢\u0006\u0004\b\u000F\u0010\u0010J$\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u00112\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\tH\u0086@¢\u0006\u0004\b\u0013\u0010\u0014J0\u0010\u0017\u001A\u00020\u000B2\u0012\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00152\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\tH\u0086@¢\u0006\u0004\b\u0017\u0010\u0018J*\u0010\u001B\u001A\u00020\u000B2\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\t0\u00192\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\tH\u0086@¢\u0006\u0004\b\u001B\u0010\u001CR\u001D\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00070\u001D8\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!R\u001D\u0010%\u001A\b\u0012\u0004\u0012\u00020\t0\u001D8\u0006¢\u0006\f\n\u0004\b#\u0010\u001F\u001A\u0004\b$\u0010!R\u001D\u0010(\u001A\b\u0012\u0004\u0012\u00020\u00110\u001D8\u0006¢\u0006\f\n\u0004\b&\u0010\u001F\u001A\u0004\b\'\u0010!R)\u0010+\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00150\u001D8\u0006¢\u0006\f\n\u0004\b)\u0010\u001F\u001A\u0004\b*\u0010!R#\u0010\u001A\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u001D8\u0006¢\u0006\f\n\u0004\b,\u0010\u001F\u001A\u0004\b-\u0010!¨\u0006/"}, d2 = {"Lcom/iloen/melon/utils/datastore/EachPlytSettingPreferencesRepository;", "", "Ll2/i;", "Lcom/iloen/melon/EachPlytSettingPreferences;", "dataStore", "<init>", "(Ll2/i;)V", "", "sortType", "", "reason", "Lie/H;", "updateSortType", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uniqueId", "updateLastUniqueId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "playedTime", "updatePlayedTime", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lie/m;", "sectionRepeat", "updateSectionRepeat", "(Lie/m;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "selectedRepeatUniqueIdList", "updateSelectedRepeatUniqueIdList", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "c", "Lkotlinx/coroutines/flow/Flow;", "getSortTypeFlow", "()Lkotlinx/coroutines/flow/Flow;", "sortTypeFlow", "d", "getLastUniqueIdFlow", "lastUniqueIdFlow", "e", "getPlayedTimeFlow", "playedTimeFlow", "f", "getSectionRepeatFlow", "sectionRepeatFlow", "g", "getSelectedRepeatUniqueIdList", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EachPlytSettingPreferencesRepository {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/utils/datastore/EachPlytSettingPreferencesRepository$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "DEBUG", "Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final i a;
    public final LogU b;
    public final com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.1 c;
    public final com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.2 d;
    public final com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.3 e;
    public final com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.4 f;
    public final com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.5 g;

    static {
        EachPlytSettingPreferencesRepository.Companion = new Companion(null);
        EachPlytSettingPreferencesRepository.$stable = 8;
    }

    public EachPlytSettingPreferencesRepository(@NotNull i i0) {
        q.g(i0, "dataStore");
        super();
        this.a = i0;
        this.b = new LogU("EachPlytSettingPreferencesRepository");
        this.c = new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.1.2 eachPlytSettingPreferencesRepository$special$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.1.2.1 eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.1.2.1) {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.1.2.1)continuation0;
                            int v = eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                Integer integer0 = new Integer(((EachPlytSettingPreferences)object0).getSortType());
                                eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10.w = 1;
                                return this.a.emit(integer0, eachPlytSettingPreferencesRepository$special$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                Object object0 = this.a.collect(eachPlytSettingPreferencesRepository$special$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };
        this.d = new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.2.2 eachPlytSettingPreferencesRepository$special$$inlined$map$2$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.2.2.1 eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.2.2.1) {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.2.2.1)continuation0;
                            int v = eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10.w;
                            if((v & 0x80000000) == 0) {
                                eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10.r;
                        a a0 = a.a;
                        switch(eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10.w) {
                            case 0: {
                                n.D(object1);
                                eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10.w = 1;
                                return this.a.emit("", eachPlytSettingPreferencesRepository$special$$inlined$map$2$2$10) == a0 ? a0 : H.a;
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
                Object object0 = this.a.collect(eachPlytSettingPreferencesRepository$special$$inlined$map$2$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };
        this.e = new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.3.2 eachPlytSettingPreferencesRepository$special$$inlined$map$3$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.3.2.1 eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.3.2.1) {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.3.2.1)continuation0;
                            int v = eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10.w;
                            if((v & 0x80000000) == 0) {
                                eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10.r;
                        a a0 = a.a;
                        switch(eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10.w) {
                            case 0: {
                                n.D(object1);
                                Long long0 = new Long(((EachPlytSettingPreferences)object0).getPlayedTime());
                                eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10.w = 1;
                                return this.a.emit(long0, eachPlytSettingPreferencesRepository$special$$inlined$map$3$2$10) == a0 ? a0 : H.a;
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
                Object object0 = this.a.collect(eachPlytSettingPreferencesRepository$special$$inlined$map$3$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };
        this.f = new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.4.2 eachPlytSettingPreferencesRepository$special$$inlined$map$4$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.4.2.1 eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.4.2.1) {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.4.2.1)continuation0;
                            int v = eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10.w;
                            if((v & 0x80000000) == 0) {
                                eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10.r;
                        a a0 = a.a;
                        switch(eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10.w) {
                            case 0: {
                                n.D(object1);
                                m m0 = new m(new Integer(((EachPlytSettingPreferences)object0).getSectionRepeatStartPos()), new Integer(((EachPlytSettingPreferences)object0).getSectionRepeatEndPos()));
                                eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10.w = 1;
                                return this.a.emit(m0, eachPlytSettingPreferencesRepository$special$$inlined$map$4$2$10) == a0 ? a0 : H.a;
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
                Object object0 = this.a.collect(eachPlytSettingPreferencesRepository$special$$inlined$map$4$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };
        this.g = new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.5.2 eachPlytSettingPreferencesRepository$special$$inlined$map$5$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.5.2.1 eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.5.2.1) {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.special..inlined.map.5.2.1)continuation0;
                            int v = eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10.w;
                            if((v & 0x80000000) == 0) {
                                eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10.r;
                        a a0 = a.a;
                        switch(eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10.w) {
                            case 0: {
                                n.D(object1);
                                List list0 = ((EachPlytSettingPreferences)object0).getSelectedRepeatUniqueIdList();
                                eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10.w = 1;
                                return this.a.emit(list0, eachPlytSettingPreferencesRepository$special$$inlined$map$5$2$10) == a0 ? a0 : H.a;
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
                Object object0 = this.a.collect(eachPlytSettingPreferencesRepository$special$$inlined$map$5$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/EachPlytSettingPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository$lastUniqueIdFlow$1", f = "EachPlytSettingPreferencesRepository.kt", l = {40}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.lastUniqueIdFlow.1 extends oe.i implements o {
            public Throwable B;
            public final EachPlytSettingPreferencesRepository D;
            public int r;
            public FlowCollector w;

            public com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.lastUniqueIdFlow.1(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, Continuation continuation0) {
                this.D = eachPlytSettingPreferencesRepository0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.lastUniqueIdFlow.1 eachPlytSettingPreferencesRepository$lastUniqueIdFlow$10 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.lastUniqueIdFlow.1(this.D, continuation0);
                eachPlytSettingPreferencesRepository$lastUniqueIdFlow$10.w = flowCollector0;
                eachPlytSettingPreferencesRepository$lastUniqueIdFlow$10.B = throwable0;
                return eachPlytSettingPreferencesRepository$lastUniqueIdFlow$10.invokeSuspend(H.a);
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
                        LogU.error$default(EachPlytSettingPreferencesRepository.access$getLog$p(this.D), "lastUniqueIdFlow", throwable0, false, 4, null);
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = EachPlytSettingPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(eachPlytSettingPreferences0, this) == a0 ? a0 : H.a;
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


        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/EachPlytSettingPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository$playedTimeFlow$1", f = "EachPlytSettingPreferencesRepository.kt", l = {52}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.playedTimeFlow.1 extends oe.i implements o {
            public Throwable B;
            public final EachPlytSettingPreferencesRepository D;
            public int r;
            public FlowCollector w;

            public com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.playedTimeFlow.1(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, Continuation continuation0) {
                this.D = eachPlytSettingPreferencesRepository0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.playedTimeFlow.1 eachPlytSettingPreferencesRepository$playedTimeFlow$10 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.playedTimeFlow.1(this.D, continuation0);
                eachPlytSettingPreferencesRepository$playedTimeFlow$10.w = flowCollector0;
                eachPlytSettingPreferencesRepository$playedTimeFlow$10.B = throwable0;
                return eachPlytSettingPreferencesRepository$playedTimeFlow$10.invokeSuspend(H.a);
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
                        LogU.error$default(EachPlytSettingPreferencesRepository.access$getLog$p(this.D), "timePosFlow", throwable0, false, 4, null);
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = EachPlytSettingPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(eachPlytSettingPreferences0, this) == a0 ? a0 : H.a;
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


        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/EachPlytSettingPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository$sectionRepeatFlow$1", f = "EachPlytSettingPreferencesRepository.kt", l = {0x3F}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.sectionRepeatFlow.1 extends oe.i implements o {
            public Throwable B;
            public final EachPlytSettingPreferencesRepository D;
            public int r;
            public FlowCollector w;

            public com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.sectionRepeatFlow.1(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, Continuation continuation0) {
                this.D = eachPlytSettingPreferencesRepository0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.sectionRepeatFlow.1 eachPlytSettingPreferencesRepository$sectionRepeatFlow$10 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.sectionRepeatFlow.1(this.D, continuation0);
                eachPlytSettingPreferencesRepository$sectionRepeatFlow$10.w = flowCollector0;
                eachPlytSettingPreferencesRepository$sectionRepeatFlow$10.B = throwable0;
                return eachPlytSettingPreferencesRepository$sectionRepeatFlow$10.invokeSuspend(H.a);
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
                        LogU.error$default(EachPlytSettingPreferencesRepository.access$getLog$p(this.D), "sectionRepeatFlow", throwable0, false, 4, null);
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = EachPlytSettingPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(eachPlytSettingPreferences0, this) == a0 ? a0 : H.a;
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


        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/EachPlytSettingPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository$selectedRepeatUniqueIdList$1", f = "EachPlytSettingPreferencesRepository.kt", l = {74}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.selectedRepeatUniqueIdList.1 extends oe.i implements o {
            public Throwable B;
            public final EachPlytSettingPreferencesRepository D;
            public int r;
            public FlowCollector w;

            public com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.selectedRepeatUniqueIdList.1(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, Continuation continuation0) {
                this.D = eachPlytSettingPreferencesRepository0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.selectedRepeatUniqueIdList.1 eachPlytSettingPreferencesRepository$selectedRepeatUniqueIdList$10 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.selectedRepeatUniqueIdList.1(this.D, continuation0);
                eachPlytSettingPreferencesRepository$selectedRepeatUniqueIdList$10.w = flowCollector0;
                eachPlytSettingPreferencesRepository$selectedRepeatUniqueIdList$10.B = throwable0;
                return eachPlytSettingPreferencesRepository$selectedRepeatUniqueIdList$10.invokeSuspend(H.a);
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
                        LogU.error$default(EachPlytSettingPreferencesRepository.access$getLog$p(this.D), "selectedRepeatUniqueIdList", throwable0, false, 4, null);
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = EachPlytSettingPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(eachPlytSettingPreferences0, this) == a0 ? a0 : H.a;
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


        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001A\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/EachPlytSettingPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository$sortTypeFlow$1", f = "EachPlytSettingPreferencesRepository.kt", l = {29}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.sortTypeFlow.1 extends oe.i implements o {
            public Throwable B;
            public final EachPlytSettingPreferencesRepository D;
            public int r;
            public FlowCollector w;

            public com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.sortTypeFlow.1(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, Continuation continuation0) {
                this.D = eachPlytSettingPreferencesRepository0;
                super(3, continuation0);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.sortTypeFlow.1 eachPlytSettingPreferencesRepository$sortTypeFlow$10 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.sortTypeFlow.1(this.D, continuation0);
                eachPlytSettingPreferencesRepository$sortTypeFlow$10.w = flowCollector0;
                eachPlytSettingPreferencesRepository$sortTypeFlow$10.B = throwable0;
                return eachPlytSettingPreferencesRepository$sortTypeFlow$10.invokeSuspend(H.a);
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
                        LogU.error$default(EachPlytSettingPreferencesRepository.access$getLog$p(this.D), "sortTypeFlow", throwable0, false, 4, null);
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = EachPlytSettingPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(eachPlytSettingPreferences0, this) == a0 ? a0 : H.a;
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

    public static final Object access$debugAfterUpdate(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, Continuation continuation0) {
        LogU logU1;
        EachPlytSettingPreferencesRepository.debugAfterUpdate.1 eachPlytSettingPreferencesRepository$debugAfterUpdate$10;
        eachPlytSettingPreferencesRepository0.getClass();
        if(continuation0 instanceof EachPlytSettingPreferencesRepository.debugAfterUpdate.1) {
            eachPlytSettingPreferencesRepository$debugAfterUpdate$10 = (EachPlytSettingPreferencesRepository.debugAfterUpdate.1)continuation0;
            int v = eachPlytSettingPreferencesRepository$debugAfterUpdate$10.D;
            if((v & 0x80000000) == 0) {
                eachPlytSettingPreferencesRepository$debugAfterUpdate$10 = new EachPlytSettingPreferencesRepository.debugAfterUpdate.1(eachPlytSettingPreferencesRepository0, continuation0);
            }
            else {
                eachPlytSettingPreferencesRepository$debugAfterUpdate$10.D = v ^ 0x80000000;
            }
        }
        else {
            eachPlytSettingPreferencesRepository$debugAfterUpdate$10 = new EachPlytSettingPreferencesRepository.debugAfterUpdate.1(eachPlytSettingPreferencesRepository0, continuation0);
        }
        Object object0 = eachPlytSettingPreferencesRepository$debugAfterUpdate$10.w;
        a a0 = a.a;
        switch(eachPlytSettingPreferencesRepository$debugAfterUpdate$10.D) {
            case 0: {
                n.D(object0);
                LogU logU0 = eachPlytSettingPreferencesRepository0.b;
                Flow flow0 = eachPlytSettingPreferencesRepository0.a.getData();
                eachPlytSettingPreferencesRepository$debugAfterUpdate$10.r = logU0;
                eachPlytSettingPreferencesRepository$debugAfterUpdate$10.D = 1;
                Object object1 = FlowKt.first(flow0, eachPlytSettingPreferencesRepository$debugAfterUpdate$10);
                if(object1 == a0) {
                    return a0;
                }
                logU1 = logU0;
                object0 = object1;
                break;
            }
            case 1: {
                LogU logU2 = eachPlytSettingPreferencesRepository$debugAfterUpdate$10.r;
                n.D(object0);
                logU1 = logU2;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(logU1, "debugAfterUpdate() " + object0, null, false, 6, null);
        return H.a;
    }

    public static final LogU access$getLog$p(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0) {
        return eachPlytSettingPreferencesRepository0.b;
    }

    @NotNull
    public final Flow getLastUniqueIdFlow() {
        return this.d;
    }

    @NotNull
    public final Flow getPlayedTimeFlow() {
        return this.e;
    }

    @NotNull
    public final Flow getSectionRepeatFlow() {
        return this.f;
    }

    @NotNull
    public final Flow getSelectedRepeatUniqueIdList() {
        return this.g;
    }

    @NotNull
    public final Flow getSortTypeFlow() {
        return this.c;
    }

    @Nullable
    public final Object updateLastUniqueId(@NotNull String s, @Nullable String s1, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateLastUniqueId.1 eachPlytSettingPreferencesRepository$updateLastUniqueId$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateLastUniqueId.1) {
            eachPlytSettingPreferencesRepository$updateLastUniqueId$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateLastUniqueId.1)continuation0;
            int v = eachPlytSettingPreferencesRepository$updateLastUniqueId$10.E;
            if((v & 0x80000000) == 0) {
                eachPlytSettingPreferencesRepository$updateLastUniqueId$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public Object B;
                    public int E;
                    public String r;
                    public String w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.B = object0;
                        this.E |= 0x80000000;
                        return continuation0.updateLastUniqueId(null, null, this);
                    }
                };
            }
            else {
                eachPlytSettingPreferencesRepository$updateLastUniqueId$10.E = v ^ 0x80000000;
            }
        }
        else {
            eachPlytSettingPreferencesRepository$updateLastUniqueId$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public Object B;
                public int E;
                public String r;
                public String w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.B = object0;
                    this.E |= 0x80000000;
                    return continuation0.updateLastUniqueId(null, null, this);
                }
            };
        }
        Object object0 = eachPlytSettingPreferencesRepository$updateLastUniqueId$10.B;
        a a0 = a.a;
        switch(eachPlytSettingPreferencesRepository$updateLastUniqueId$10.E) {
            case 0: {
                n.D(object0);
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateLastUniqueId.2 eachPlytSettingPreferencesRepository$updateLastUniqueId$20 = new we.n(null) {
                    public Object r;
                    public final String w;

                    {
                        this.w = s;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateLastUniqueId.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(EachPlytSettingPreferences eachPlytSettingPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateLastUniqueId.2)this.create(eachPlytSettingPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((EachPlytSettingPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = (EachPlytSettingPreferences)this.r;
                        n.D(object0);
                        r r0 = (r)eachPlytSettingPreferences0.toBuilder();
                        r0.d();
                        ((EachPlytSettingPreferences)r0.b).setLastUniqueId(this.w);
                        return r0.a();
                    }
                };
                eachPlytSettingPreferencesRepository$updateLastUniqueId$10.r = s;
                eachPlytSettingPreferencesRepository$updateLastUniqueId$10.w = s1;
                eachPlytSettingPreferencesRepository$updateLastUniqueId$10.E = 1;
                if(this.a.a(eachPlytSettingPreferencesRepository$updateLastUniqueId$20, eachPlytSettingPreferencesRepository$updateLastUniqueId$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                s1 = eachPlytSettingPreferencesRepository$updateLastUniqueId$10.w;
                s = eachPlytSettingPreferencesRepository$updateLastUniqueId$10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.b, "updateLastUniqueId() " + s + ", " + s1, null, false, 6, null);
        return H.a;
    }

    public static Object updateLastUniqueId$default(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, String s, String s1, Continuation continuation0, int v, Object object0) {
        if((v & 2) != 0) {
            s1 = null;
        }
        return eachPlytSettingPreferencesRepository0.updateLastUniqueId(s, s1, continuation0);
    }

    @Nullable
    public final Object updatePlayedTime(long v, @Nullable String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updatePlayedTime.1 eachPlytSettingPreferencesRepository$updatePlayedTime$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updatePlayedTime.1) {
            eachPlytSettingPreferencesRepository$updatePlayedTime$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updatePlayedTime.1)continuation0;
            int v1 = eachPlytSettingPreferencesRepository$updatePlayedTime$10.E;
            if((v1 & 0x80000000) == 0) {
                eachPlytSettingPreferencesRepository$updatePlayedTime$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public Object B;
                    public int E;
                    public long r;
                    public String w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.B = object0;
                        this.E |= 0x80000000;
                        return continuation0.updatePlayedTime(0L, null, this);
                    }
                };
            }
            else {
                eachPlytSettingPreferencesRepository$updatePlayedTime$10.E = v1 ^ 0x80000000;
            }
        }
        else {
            eachPlytSettingPreferencesRepository$updatePlayedTime$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public Object B;
                public int E;
                public long r;
                public String w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.B = object0;
                    this.E |= 0x80000000;
                    return continuation0.updatePlayedTime(0L, null, this);
                }
            };
        }
        Object object0 = eachPlytSettingPreferencesRepository$updatePlayedTime$10.B;
        a a0 = a.a;
        switch(eachPlytSettingPreferencesRepository$updatePlayedTime$10.E) {
            case 0: {
                n.D(object0);
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updatePlayedTime.2 eachPlytSettingPreferencesRepository$updatePlayedTime$20 = new we.n(null) {
                    public Object r;
                    public final long w;

                    {
                        this.w = v;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updatePlayedTime.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(EachPlytSettingPreferences eachPlytSettingPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updatePlayedTime.2)this.create(eachPlytSettingPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((EachPlytSettingPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = (EachPlytSettingPreferences)this.r;
                        n.D(object0);
                        r r0 = (r)eachPlytSettingPreferences0.toBuilder();
                        r0.d();
                        ((EachPlytSettingPreferences)r0.b).setPlayedTime(this.w);
                        return r0.a();
                    }
                };
                eachPlytSettingPreferencesRepository$updatePlayedTime$10.w = s;
                eachPlytSettingPreferencesRepository$updatePlayedTime$10.r = v;
                eachPlytSettingPreferencesRepository$updatePlayedTime$10.E = 1;
                if(this.a.a(eachPlytSettingPreferencesRepository$updatePlayedTime$20, eachPlytSettingPreferencesRepository$updatePlayedTime$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = eachPlytSettingPreferencesRepository$updatePlayedTime$10.r;
                s = eachPlytSettingPreferencesRepository$updatePlayedTime$10.w;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.b, "updatePlayedTime() " + v + ", " + s, null, false, 6, null);
        return H.a;
    }

    public static Object updatePlayedTime$default(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, long v, String s, Continuation continuation0, int v1, Object object0) {
        if((v1 & 2) != 0) {
            s = null;
        }
        return eachPlytSettingPreferencesRepository0.updatePlayedTime(v, s, continuation0);
    }

    @Nullable
    public final Object updateSectionRepeat(@NotNull m m0, @Nullable String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSectionRepeat.1 eachPlytSettingPreferencesRepository$updateSectionRepeat$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSectionRepeat.1) {
            eachPlytSettingPreferencesRepository$updateSectionRepeat$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSectionRepeat.1)continuation0;
            int v = eachPlytSettingPreferencesRepository$updateSectionRepeat$10.E;
            if((v & 0x80000000) == 0) {
                eachPlytSettingPreferencesRepository$updateSectionRepeat$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public Object B;
                    public int E;
                    public m r;
                    public String w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.B = object0;
                        this.E |= 0x80000000;
                        return continuation0.updateSectionRepeat(null, null, this);
                    }
                };
            }
            else {
                eachPlytSettingPreferencesRepository$updateSectionRepeat$10.E = v ^ 0x80000000;
            }
        }
        else {
            eachPlytSettingPreferencesRepository$updateSectionRepeat$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public Object B;
                public int E;
                public m r;
                public String w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.B = object0;
                    this.E |= 0x80000000;
                    return continuation0.updateSectionRepeat(null, null, this);
                }
            };
        }
        Object object0 = eachPlytSettingPreferencesRepository$updateSectionRepeat$10.B;
        a a0 = a.a;
        switch(eachPlytSettingPreferencesRepository$updateSectionRepeat$10.E) {
            case 0: {
                n.D(object0);
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSectionRepeat.2 eachPlytSettingPreferencesRepository$updateSectionRepeat$20 = new we.n(null) {
                    public Object r;
                    public final m w;

                    {
                        this.w = m0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSectionRepeat.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(EachPlytSettingPreferences eachPlytSettingPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSectionRepeat.2)this.create(eachPlytSettingPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((EachPlytSettingPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = (EachPlytSettingPreferences)this.r;
                        n.D(object0);
                        r r0 = (r)eachPlytSettingPreferences0.toBuilder();
                        r0.d();
                        ((EachPlytSettingPreferences)r0.b).setSectionRepeatStartPos(((Number)this.w.a).intValue());
                        r0.d();
                        ((EachPlytSettingPreferences)r0.b).setSectionRepeatEndPos(((Number)this.w.b).intValue());
                        return r0.a();
                    }
                };
                eachPlytSettingPreferencesRepository$updateSectionRepeat$10.r = m0;
                eachPlytSettingPreferencesRepository$updateSectionRepeat$10.w = s;
                eachPlytSettingPreferencesRepository$updateSectionRepeat$10.E = 1;
                if(this.a.a(eachPlytSettingPreferencesRepository$updateSectionRepeat$20, eachPlytSettingPreferencesRepository$updateSectionRepeat$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                s = eachPlytSettingPreferencesRepository$updateSectionRepeat$10.w;
                m0 = eachPlytSettingPreferencesRepository$updateSectionRepeat$10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.b, "updateSectionRepeat() " + m0 + ", " + s, null, false, 6, null);
        return H.a;
    }

    public static Object updateSectionRepeat$default(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, m m0, String s, Continuation continuation0, int v, Object object0) {
        if((v & 2) != 0) {
            s = null;
        }
        return eachPlytSettingPreferencesRepository0.updateSectionRepeat(m0, s, continuation0);
    }

    @Nullable
    public final Object updateSelectedRepeatUniqueIdList(@NotNull List list0, @Nullable String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSelectedRepeatUniqueIdList.1 eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSelectedRepeatUniqueIdList.1) {
            eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSelectedRepeatUniqueIdList.1)continuation0;
            int v = eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10.E;
            if((v & 0x80000000) == 0) {
                eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public Object B;
                    public int E;
                    public List r;
                    public String w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.B = object0;
                        this.E |= 0x80000000;
                        return continuation0.updateSelectedRepeatUniqueIdList(null, null, this);
                    }
                };
            }
            else {
                eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10.E = v ^ 0x80000000;
            }
        }
        else {
            eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public Object B;
                public int E;
                public List r;
                public String w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.B = object0;
                    this.E |= 0x80000000;
                    return continuation0.updateSelectedRepeatUniqueIdList(null, null, this);
                }
            };
        }
        Object object0 = eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10.B;
        a a0 = a.a;
        switch(eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10.E) {
            case 0: {
                n.D(object0);
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSelectedRepeatUniqueIdList.2 eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$20 = new we.n(null) {
                    public Object r;
                    public final List w;

                    {
                        this.w = list0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSelectedRepeatUniqueIdList.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(EachPlytSettingPreferences eachPlytSettingPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSelectedRepeatUniqueIdList.2)this.create(eachPlytSettingPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((EachPlytSettingPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = (EachPlytSettingPreferences)this.r;
                        n.D(object0);
                        r r0 = (r)eachPlytSettingPreferences0.toBuilder();
                        r0.d();
                        ((EachPlytSettingPreferences)r0.b).clearSelectedRepeatUniqueId();
                        r0.d();
                        ((EachPlytSettingPreferences)r0.b).addAllSelectedRepeatUniqueId(this.w);
                        return r0.a();
                    }
                };
                eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10.r = list0;
                eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10.w = s;
                eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10.E = 1;
                if(this.a.a(eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$20, eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                s = eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10.w;
                list0 = eachPlytSettingPreferencesRepository$updateSelectedRepeatUniqueIdList$10.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.b, "updateSelectedRepeatUniqueIdList() " + list0 + ", " + s, null, false, 6, null);
        return H.a;
    }

    public static Object updateSelectedRepeatUniqueIdList$default(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, List list0, String s, Continuation continuation0, int v, Object object0) {
        if((v & 2) != 0) {
            s = null;
        }
        return eachPlytSettingPreferencesRepository0.updateSelectedRepeatUniqueIdList(list0, s, continuation0);
    }

    @Nullable
    public final Object updateSortType(int v, @Nullable String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSortType.1 eachPlytSettingPreferencesRepository$updateSortType$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSortType.1) {
            eachPlytSettingPreferencesRepository$updateSortType$10 = (com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSortType.1)continuation0;
            int v1 = eachPlytSettingPreferencesRepository$updateSortType$10.E;
            if((v1 & 0x80000000) == 0) {
                eachPlytSettingPreferencesRepository$updateSortType$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public Object B;
                    public int E;
                    public int r;
                    public String w;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.B = object0;
                        this.E |= 0x80000000;
                        return continuation0.updateSortType(0, null, this);
                    }
                };
            }
            else {
                eachPlytSettingPreferencesRepository$updateSortType$10.E = v1 ^ 0x80000000;
            }
        }
        else {
            eachPlytSettingPreferencesRepository$updateSortType$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public Object B;
                public int E;
                public int r;
                public String w;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.B = object0;
                    this.E |= 0x80000000;
                    return continuation0.updateSortType(0, null, this);
                }
            };
        }
        Object object0 = eachPlytSettingPreferencesRepository$updateSortType$10.B;
        a a0 = a.a;
        switch(eachPlytSettingPreferencesRepository$updateSortType$10.E) {
            case 0: {
                n.D(object0);
                com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSortType.2 eachPlytSettingPreferencesRepository$updateSortType$20 = new we.n(null) {
                    public Object r;
                    public final int w;

                    {
                        this.w = v;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSortType.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(EachPlytSettingPreferences eachPlytSettingPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository.updateSortType.2)this.create(eachPlytSettingPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((EachPlytSettingPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        EachPlytSettingPreferences eachPlytSettingPreferences0 = (EachPlytSettingPreferences)this.r;
                        n.D(object0);
                        r r0 = (r)eachPlytSettingPreferences0.toBuilder();
                        r0.d();
                        ((EachPlytSettingPreferences)r0.b).setSortType(this.w);
                        return r0.a();
                    }
                };
                eachPlytSettingPreferencesRepository$updateSortType$10.w = s;
                eachPlytSettingPreferencesRepository$updateSortType$10.r = v;
                eachPlytSettingPreferencesRepository$updateSortType$10.E = 1;
                if(this.a.a(eachPlytSettingPreferencesRepository$updateSortType$20, eachPlytSettingPreferencesRepository$updateSortType$10) == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                v = eachPlytSettingPreferencesRepository$updateSortType$10.r;
                s = eachPlytSettingPreferencesRepository$updateSortType$10.w;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        LogU.debug$default(this.b, "updateSortType() " + v + ", " + s, null, false, 6, null);
        return H.a;
    }

    public static Object updateSortType$default(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, int v, String s, Continuation continuation0, int v1, Object object0) {
        if((v1 & 2) != 0) {
            s = null;
        }
        return eachPlytSettingPreferencesRepository0.updateSortType(v, s, continuation0);
    }
}

