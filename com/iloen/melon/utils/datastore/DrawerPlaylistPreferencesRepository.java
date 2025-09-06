package com.iloen.melon.utils.datastore;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.MusicDrawerPreferences.DrawerPlytInfo;
import com.iloen.melon.MusicDrawerPreferences;
import com.iloen.melon.d;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import java.io.IOException;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0013\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\u0005J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0004\b\u000B\u0010\fJ\u0018\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u0003H\u0086@¢\u0006\u0004\b\u000E\u0010\u000FJ\u0018\u0010\u0011\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u0003H\u0086@¢\u0006\u0004\b\u0011\u0010\u000FJ\u0010\u0010\u0012\u001A\u00020\nH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/utils/datastore/DrawerPlaylistPreferencesRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "", "getViewMode", "()Lkotlinx/coroutines/flow/Flow;", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "getDrawerPlytInfo", "getLastTab", "drawerPlaylistInfo", "Lie/H;", "updateDrawerPlytInfo", "(Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tab", "updateLastTab", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "viewMode", "updateViewMode", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlaylistPreferencesRepository {
    public static final int $stable;
    @NotNull
    public static final DrawerPlaylistPreferencesRepository INSTANCE;
    public static final LogU a;

    static {
        DrawerPlaylistPreferencesRepository.INSTANCE = new DrawerPlaylistPreferencesRepository();  // 初始化器: Ljava/lang/Object;-><init>()V
        DrawerPlaylistPreferencesRepository.a = new LogU("DrawerPlaylistPreferencesRepository");
        DrawerPlaylistPreferencesRepository.$stable = 8;
    }

    public final Object a(Continuation continuation0) {
        LogU logU1;
        DrawerPlaylistPreferencesRepository.debugAfterUpdate.1 drawerPlaylistPreferencesRepository$debugAfterUpdate$10;
        if(continuation0 instanceof DrawerPlaylistPreferencesRepository.debugAfterUpdate.1) {
            drawerPlaylistPreferencesRepository$debugAfterUpdate$10 = (DrawerPlaylistPreferencesRepository.debugAfterUpdate.1)continuation0;
            int v = drawerPlaylistPreferencesRepository$debugAfterUpdate$10.D;
            if((v & 0x80000000) == 0) {
                drawerPlaylistPreferencesRepository$debugAfterUpdate$10 = new DrawerPlaylistPreferencesRepository.debugAfterUpdate.1(this, continuation0);
            }
            else {
                drawerPlaylistPreferencesRepository$debugAfterUpdate$10.D = v ^ 0x80000000;
            }
        }
        else {
            drawerPlaylistPreferencesRepository$debugAfterUpdate$10 = new DrawerPlaylistPreferencesRepository.debugAfterUpdate.1(this, continuation0);
        }
        Object object0 = drawerPlaylistPreferencesRepository$debugAfterUpdate$10.w;
        a a0 = a.a;
        switch(drawerPlaylistPreferencesRepository$debugAfterUpdate$10.D) {
            case 0: {
                n.D(object0);
                Flow flow0 = DrawerPlaylistPreferencesRepository.b().getData();
                LogU logU0 = DrawerPlaylistPreferencesRepository.a;
                drawerPlaylistPreferencesRepository$debugAfterUpdate$10.r = logU0;
                drawerPlaylistPreferencesRepository$debugAfterUpdate$10.D = 1;
                object0 = FlowKt.first(flow0, drawerPlaylistPreferencesRepository$debugAfterUpdate$10);
                if(object0 == a0) {
                    return a0;
                }
                logU1 = logU0;
                break;
            }
            case 1: {
                logU1 = drawerPlaylistPreferencesRepository$debugAfterUpdate$10.r;
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

    public static final Object access$debugAfterUpdate(DrawerPlaylistPreferencesRepository drawerPlaylistPreferencesRepository0, Continuation continuation0) {
        return drawerPlaylistPreferencesRepository0.a(continuation0);
    }

    public static i b() {
        MelonAppBase.Companion.getClass();
        return DrawerPlaylistPreferencesSerializerKt.getDrawerPlaylistDataStore(t.a().getContext());
    }

    @Nullable
    public final Object clear(@NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.clear.1 drawerPlaylistPreferencesRepository$clear$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.clear.1) {
            drawerPlaylistPreferencesRepository$clear$10 = (com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.clear.1)continuation0;
            int v = drawerPlaylistPreferencesRepository$clear$10.B;
            if((v & 0x80000000) == 0) {
                drawerPlaylistPreferencesRepository$clear$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                drawerPlaylistPreferencesRepository$clear$10.B = v ^ 0x80000000;
            }
        }
        else {
            drawerPlaylistPreferencesRepository$clear$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = drawerPlaylistPreferencesRepository$clear$10.r;
        a a0 = a.a;
        switch(drawerPlaylistPreferencesRepository$clear$10.B) {
            case 0: {
                n.D(object0);
                i i0 = DrawerPlaylistPreferencesRepository.b();
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.clear.2 drawerPlaylistPreferencesRepository$clear$20 = new we.n(null) {  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                    public Object r;

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.clear.2(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(MusicDrawerPreferences musicDrawerPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.clear.2)this.create(musicDrawerPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((MusicDrawerPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        MusicDrawerPreferences musicDrawerPreferences0 = (MusicDrawerPreferences)this.r;
                        n.D(object0);
                        com.iloen.melon.c c0 = (com.iloen.melon.c)musicDrawerPreferences0.toBuilder();
                        c0.c();
                        return c0.a();
                    }
                };
                drawerPlaylistPreferencesRepository$clear$10.B = 1;
                if(i0.a(drawerPlaylistPreferencesRepository$clear$20, drawerPlaylistPreferencesRepository$clear$10) == a0) {
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
        drawerPlaylistPreferencesRepository$clear$10.B = 2;
        return this.a(drawerPlaylistPreferencesRepository$clear$10) == a0 ? a0 : H.a;
    }

    @NotNull
    public final Flow getDrawerPlytInfo() {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getDrawerPlytInfo..inlined.map.1.2 drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getDrawerPlytInfo..inlined.map.1.2.1 drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getDrawerPlytInfo..inlined.map.1.2.1) {
                            drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getDrawerPlytInfo..inlined.map.1.2.1)continuation0;
                            int v = drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                DrawerPlytInfo musicDrawerPreferences$DrawerPlytInfo0 = ((MusicDrawerPreferences)object0).getLastDrawerPlytInfo();
                                String s = null;
                                if(musicDrawerPreferences$DrawerPlytInfo0.getLandingFrom() > -1) {
                                    switch(musicDrawerPreferences$DrawerPlytInfo0.getLandingFrom()) {
                                        case 0: {
                                            s = "RECENT";
                                            break;
                                        }
                                        case 1: {
                                            s = "LIKE";
                                            break;
                                        }
                                        case 2: {
                                            s = "MADE_BY_ME";
                                            break;
                                        }
                                        case 3: {
                                            s = "DJ";
                                        }
                                    }
                                }
                                q.f("", "getContsId(...)");
                                q.f("", "getContsTypeCode(...)");
                                q.f("", "getSeedContsId(...)");
                                q.f("", "getSeedContsTypeCode(...)");
                                q.f("", "getMenuId(...)");
                                q.f("", "getTitle(...)");
                                DrawerPlaylistInfo drawerPlaylistInfo0 = new DrawerPlaylistInfo((s == null ? "MADE_BY_ME" : s), "", "", "", "", "", "", null, 0x80, null);
                                drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10.w = 1;
                                return this.a.emit(drawerPlaylistInfo0, drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                Object object0 = this.a.collect(drawerPlaylistPreferencesRepository$getDrawerPlytInfo$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001A\u00020\u0005*\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/MusicDrawerPreferences;", "Lcom/iloen/melon/utils/datastore/DrawerPlaylistPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository$getDrawerPlytInfo$1", f = "DrawerPlaylistPreferencesRepository.kt", l = {42}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getDrawerPlytInfo.1 extends oe.i implements o {
            public Throwable B;
            public int r;
            public FlowCollector w;

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getDrawerPlytInfo.1 drawerPlaylistPreferencesRepository$getDrawerPlytInfo$10 = new com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getDrawerPlytInfo.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                drawerPlaylistPreferencesRepository$getDrawerPlytInfo$10.w = flowCollector0;
                drawerPlaylistPreferencesRepository$getDrawerPlytInfo$10.B = throwable0;
                return drawerPlaylistPreferencesRepository$getDrawerPlytInfo$10.invokeSuspend(H.a);
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
                        LogU.Companion.e("DrawerPlaylistPreferencesRepository", "Error reading preferences.", throwable0);
                        MusicDrawerPreferences musicDrawerPreferences0 = MusicDrawerPreferences.getDefaultInstance();
                        q.f(musicDrawerPreferences0, "getDefaultInstance(...)");
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(musicDrawerPreferences0, this) == a0 ? a0 : H.a;
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
    public final Flow getLastTab() {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getLastTab..inlined.map.1.2 drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getLastTab..inlined.map.1.2.1 drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getLastTab..inlined.map.1.2.1) {
                            drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getLastTab..inlined.map.1.2.1)continuation0;
                            int v = drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10.w = 1;
                                return this.a.emit("MADE_BY_ME", drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                Object object0 = this.a.collect(drawerPlaylistPreferencesRepository$getLastTab$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001A\u00020\u0005*\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/MusicDrawerPreferences;", "Lcom/iloen/melon/utils/datastore/DrawerPlaylistPreferences;", "", "exception", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository$getLastTab$1", f = "DrawerPlaylistPreferencesRepository.kt", l = {74}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getLastTab.1 extends oe.i implements o {
            public Throwable B;
            public int r;
            public FlowCollector w;

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getLastTab.1 drawerPlaylistPreferencesRepository$getLastTab$10 = new com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getLastTab.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                drawerPlaylistPreferencesRepository$getLastTab$10.w = flowCollector0;
                drawerPlaylistPreferencesRepository$getLastTab$10.B = throwable0;
                return drawerPlaylistPreferencesRepository$getLastTab$10.invokeSuspend(H.a);
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
                        LogU.Companion.e("DrawerPlaylistPreferencesRepository", "Error reading preferences.", throwable0);
                        MusicDrawerPreferences musicDrawerPreferences0 = MusicDrawerPreferences.getDefaultInstance();
                        q.f(musicDrawerPreferences0, "getDefaultInstance(...)");
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(musicDrawerPreferences0, this) == a0 ? a0 : H.a;
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
    public final Flow getViewMode() {
        return new Flow() {
            @Override  // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getViewMode..inlined.map.1.2 drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$20 = new FlowCollector() {
                    @Override  // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object object0, Continuation continuation0) {
                        com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getViewMode..inlined.map.1.2.1 drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10;
                        if(continuation0 instanceof com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getViewMode..inlined.map.1.2.1) {
                            drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10 = (com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getViewMode..inlined.map.1.2.1)continuation0;
                            int v = drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10.w;
                            if((v & 0x80000000) == 0) {
                                drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                                drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10.w = v ^ 0x80000000;
                            }
                        }
                        else {
                            drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
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
                        Object object1 = drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10.r;
                        a a0 = a.a;
                        switch(drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10.w) {
                            case 0: {
                                n.D(object1);
                                drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10.w = 1;
                                return this.a.emit("LIST", drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$2$10) == a0 ? a0 : H.a;
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
                Object object0 = this.a.collect(drawerPlaylistPreferencesRepository$getViewMode$$inlined$map$1$20, continuation0);
                return object0 == a.a ? object0 : H.a;
            }
        };

        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001A\u00020\u0005*\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u00002\u0006\u0010\u0004\u001A\u00020\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/iloen/melon/MusicDrawerPreferences;", "Lcom/iloen/melon/utils/datastore/DrawerPlaylistPreferences;", "", "exeption", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository$getViewMode$1", f = "DrawerPlaylistPreferencesRepository.kt", l = {29}, m = "invokeSuspend")
        final class com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getViewMode.1 extends oe.i implements o {
            public Throwable B;
            public int r;
            public FlowCollector w;

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((FlowCollector)object0), ((Throwable)object1), ((Continuation)object2));
            }

            public final Object invoke(FlowCollector flowCollector0, Throwable throwable0, Continuation continuation0) {
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getViewMode.1 drawerPlaylistPreferencesRepository$getViewMode$10 = new com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.getViewMode.1(3, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                drawerPlaylistPreferencesRepository$getViewMode$10.w = flowCollector0;
                drawerPlaylistPreferencesRepository$getViewMode$10.B = throwable0;
                return drawerPlaylistPreferencesRepository$getViewMode$10.invokeSuspend(H.a);
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
                        MusicDrawerPreferences musicDrawerPreferences0 = DrawerPlaylistPreferencesSerializer.INSTANCE.createDefaultValue();
                        this.w = null;
                        this.B = null;
                        this.r = 1;
                        return flowCollector0.emit(musicDrawerPreferences0, this) == a0 ? a0 : H.a;
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
    public final Object updateDrawerPlytInfo(@Nullable DrawerPlaylistInfo drawerPlaylistInfo0, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateDrawerPlytInfo.1 drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateDrawerPlytInfo.1) {
            drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10 = (com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateDrawerPlytInfo.1)continuation0;
            int v = drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10.B;
            if((v & 0x80000000) == 0) {
                drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.updateDrawerPlytInfo(null, this);
                    }
                };
            }
            else {
                drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10.B = v ^ 0x80000000;
            }
        }
        else {
            drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.updateDrawerPlytInfo(null, this);
                }
            };
        }
        Object object0 = drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10.r;
        a a0 = a.a;
        switch(drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10.B) {
            case 0: {
                n.D(object0);
                i i0 = DrawerPlaylistPreferencesRepository.b();
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateDrawerPlytInfo.2 drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$20 = new we.n(null) {
                    public Object r;
                    public final DrawerPlaylistInfo w;

                    {
                        this.w = drawerPlaylistInfo0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateDrawerPlytInfo.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(MusicDrawerPreferences musicDrawerPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateDrawerPlytInfo.2)this.create(musicDrawerPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((MusicDrawerPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        String s6;
                        String s5;
                        String s4;
                        String s3;
                        String s2;
                        String s;
                        MusicDrawerPreferences musicDrawerPreferences0 = (MusicDrawerPreferences)this.r;
                        n.D(object0);
                        com.iloen.melon.c c0 = (com.iloen.melon.c)musicDrawerPreferences0.toBuilder();
                        d d0 = (d)musicDrawerPreferences0.getLastDrawerPlytInfo().toBuilder();
                        d0.d();
                        DrawerPlytInfo.i(((DrawerPlytInfo)d0.b));
                        DrawerPlaylistInfo drawerPlaylistInfo0 = this.w;
                        if(drawerPlaylistInfo0 == null) {
                            s = "MADE_BY_ME";
                        }
                        else {
                            s = drawerPlaylistInfo0.getLandingFrom();
                            if(s == null) {
                                s = "MADE_BY_ME";
                            }
                        }
                        d0.d();
                        ((DrawerPlytInfo)d0.b).setLandingFromStr(s);
                        String s1 = "";
                        if(drawerPlaylistInfo0 == null) {
                            s2 = "";
                        }
                        else {
                            s2 = drawerPlaylistInfo0.getContsId();
                            if(s2 == null) {
                                s2 = "";
                            }
                        }
                        d0.d();
                        ((DrawerPlytInfo)d0.b).setContsId(s2);
                        if(drawerPlaylistInfo0 == null) {
                            s3 = "";
                        }
                        else {
                            s3 = drawerPlaylistInfo0.getContsTypeCode();
                            if(s3 == null) {
                                s3 = "";
                            }
                        }
                        d0.d();
                        ((DrawerPlytInfo)d0.b).setContsTypeCode(s3);
                        if(drawerPlaylistInfo0 == null) {
                            s4 = "";
                        }
                        else {
                            s4 = drawerPlaylistInfo0.getSeedContsId();
                            if(s4 == null) {
                                s4 = "";
                            }
                        }
                        d0.d();
                        ((DrawerPlytInfo)d0.b).setSeedContsId(s4);
                        if(drawerPlaylistInfo0 == null) {
                            s5 = "";
                        }
                        else {
                            s5 = drawerPlaylistInfo0.getSeedContsTypeCode();
                            if(s5 == null) {
                                s5 = "";
                            }
                        }
                        d0.d();
                        ((DrawerPlytInfo)d0.b).setSeedContsTypeCode(s5);
                        if(drawerPlaylistInfo0 == null) {
                            s6 = "";
                        }
                        else {
                            s6 = drawerPlaylistInfo0.getMenuId();
                            if(s6 == null) {
                                s6 = "";
                            }
                        }
                        d0.d();
                        ((DrawerPlytInfo)d0.b).setMenuId(s6);
                        if(drawerPlaylistInfo0 != null) {
                            String s7 = drawerPlaylistInfo0.getTitle();
                            if(s7 != null) {
                                s1 = s7;
                            }
                        }
                        d0.d();
                        ((DrawerPlytInfo)d0.b).setTitle(s1);
                        boolean z = drawerPlaylistInfo0 == null ? false : drawerPlaylistInfo0.isOwner();
                        d0.d();
                        ((DrawerPlytInfo)d0.b).setIsOwner(z);
                        DrawerPlytInfo musicDrawerPreferences$DrawerPlytInfo0 = (DrawerPlytInfo)d0.a();
                        c0.d();
                        ((MusicDrawerPreferences)c0.b).setLastDrawerPlytInfo(musicDrawerPreferences$DrawerPlytInfo0);
                        return c0.a();
                    }
                };
                drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10.B = 1;
                if(i0.a(drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$20, drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10) == a0) {
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
        drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10.B = 2;
        return this.a(drawerPlaylistPreferencesRepository$updateDrawerPlytInfo$10) == a0 ? a0 : H.a;
    }

    @Nullable
    public final Object updateLastTab(@NotNull String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateLastTab.1 drawerPlaylistPreferencesRepository$updateLastTab$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateLastTab.1) {
            drawerPlaylistPreferencesRepository$updateLastTab$10 = (com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateLastTab.1)continuation0;
            int v = drawerPlaylistPreferencesRepository$updateLastTab$10.B;
            if((v & 0x80000000) == 0) {
                drawerPlaylistPreferencesRepository$updateLastTab$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.updateLastTab(null, this);
                    }
                };
            }
            else {
                drawerPlaylistPreferencesRepository$updateLastTab$10.B = v ^ 0x80000000;
            }
        }
        else {
            drawerPlaylistPreferencesRepository$updateLastTab$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.updateLastTab(null, this);
                }
            };
        }
        Object object0 = drawerPlaylistPreferencesRepository$updateLastTab$10.r;
        a a0 = a.a;
        switch(drawerPlaylistPreferencesRepository$updateLastTab$10.B) {
            case 0: {
                n.D(object0);
                i i0 = DrawerPlaylistPreferencesRepository.b();
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateLastTab.2 drawerPlaylistPreferencesRepository$updateLastTab$20 = new we.n(null) {
                    public Object r;
                    public final String w;

                    {
                        this.w = s;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateLastTab.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(MusicDrawerPreferences musicDrawerPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateLastTab.2)this.create(musicDrawerPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((MusicDrawerPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        MusicDrawerPreferences musicDrawerPreferences0 = (MusicDrawerPreferences)this.r;
                        n.D(object0);
                        com.iloen.melon.c c0 = (com.iloen.melon.c)musicDrawerPreferences0.toBuilder();
                        c0.d();
                        ((MusicDrawerPreferences)c0.b).setLastTab(this.w);
                        return c0.a();
                    }
                };
                drawerPlaylistPreferencesRepository$updateLastTab$10.B = 1;
                if(i0.a(drawerPlaylistPreferencesRepository$updateLastTab$20, drawerPlaylistPreferencesRepository$updateLastTab$10) == a0) {
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
        drawerPlaylistPreferencesRepository$updateLastTab$10.B = 2;
        return this.a(drawerPlaylistPreferencesRepository$updateLastTab$10) == a0 ? a0 : H.a;
    }

    @Nullable
    public final Object updateViewMode(@NotNull String s, @NotNull Continuation continuation0) {
        com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateViewMode.1 drawerPlaylistPreferencesRepository$updateViewMode$10;
        if(continuation0 instanceof com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateViewMode.1) {
            drawerPlaylistPreferencesRepository$updateViewMode$10 = (com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateViewMode.1)continuation0;
            int v = drawerPlaylistPreferencesRepository$updateViewMode$10.B;
            if((v & 0x80000000) == 0) {
                drawerPlaylistPreferencesRepository$updateViewMode$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    public int B;
                    public Object r;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.r = object0;
                        this.B |= 0x80000000;
                        return continuation0.updateViewMode(null, this);
                    }
                };
            }
            else {
                drawerPlaylistPreferencesRepository$updateViewMode$10.B = v ^ 0x80000000;
            }
        }
        else {
            drawerPlaylistPreferencesRepository$updateViewMode$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                public int B;
                public Object r;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.r = object0;
                    this.B |= 0x80000000;
                    return continuation0.updateViewMode(null, this);
                }
            };
        }
        Object object0 = drawerPlaylistPreferencesRepository$updateViewMode$10.r;
        a a0 = a.a;
        switch(drawerPlaylistPreferencesRepository$updateViewMode$10.B) {
            case 0: {
                n.D(object0);
                i i0 = DrawerPlaylistPreferencesRepository.b();
                com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateViewMode.2 drawerPlaylistPreferencesRepository$updateViewMode$20 = new we.n(null) {
                    public Object r;
                    public final String w;

                    {
                        this.w = s;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        Continuation continuation1 = new com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateViewMode.2(this.w, continuation0);
                        continuation1.r = object0;
                        return continuation1;
                    }

                    public final Object invoke(MusicDrawerPreferences musicDrawerPreferences0, Continuation continuation0) {
                        return ((com.iloen.melon.utils.datastore.DrawerPlaylistPreferencesRepository.updateViewMode.2)this.create(musicDrawerPreferences0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((MusicDrawerPreferences)object0), ((Continuation)object1));
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        MusicDrawerPreferences musicDrawerPreferences0 = (MusicDrawerPreferences)this.r;
                        n.D(object0);
                        com.iloen.melon.c c0 = (com.iloen.melon.c)musicDrawerPreferences0.toBuilder();
                        c0.d();
                        ((MusicDrawerPreferences)c0.b).setViewModeStr(this.w);
                        return c0.a();
                    }
                };
                drawerPlaylistPreferencesRepository$updateViewMode$10.B = 1;
                if(i0.a(drawerPlaylistPreferencesRepository$updateViewMode$20, drawerPlaylistPreferencesRepository$updateViewMode$10) == a0) {
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
        drawerPlaylistPreferencesRepository$updateViewMode$10.B = 2;
        return this.a(drawerPlaylistPreferencesRepository$updateViewMode$10) == a0 ? a0 : H.a;
    }
}

