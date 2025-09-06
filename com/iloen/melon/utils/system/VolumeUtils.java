package com.iloen.melon.utils.system;

import Ma.m;
import P4.a;
import Ub.s;
import Ub.t;
import android.content.Context;
import android.media.AudioManager;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventRemotePlayer.EventGoogleCast;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import k8.Y;
import k8.o;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/utils/system/VolumeUtils;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VolumeUtils {
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\t\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\n2\b\u0010\b\u001A\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u000F\u001A\u00020\n2\b\u0010\b\u001A\u0004\u0018\u00010\u0007\u00A2\u0006\u0004\b\u000F\u0010\u000EJ+\u0010\u0014\u001A\u00020\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\u0013\u001A\u00020\u0012H\u0007\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u001F\u0010\u0016\u001A\u00020\u00042\b\u0010\b\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001A\u00020\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0013\u001A\u00020\u0012H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019R\u001D\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00020\u001A8\u0006\u00A2\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u00108\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00028\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u00028\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001A\u00020\u00028\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001A\u00020\u00028\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010\'\u001A\u00020&8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\'\u0010(R\u0014\u0010)\u001A\u00020&8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b)\u0010(R\u0014\u0010+\u001A\u00020*8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u001A\u0010.\u001A\b\u0012\u0004\u0012\u00020\u00020-8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001A\u0002008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00102\u00A8\u00063"}, d2 = {"Lcom/iloen/melon/utils/system/VolumeUtils$Companion;", "", "", "volume", "Lie/H;", "emit", "(I)V", "Landroid/content/Context;", "context", "keyCode", "", "onVolumeKeyDown", "(Landroid/content/Context;I)Z", "shouldConsumeVolumeUpEvent", "(Landroid/content/Context;)Z", "shouldConsumeVolumeDownEvent", "", "fromCall", "LUb/s;", "paramRemotePlayerManager", "getVolume", "(Landroid/content/Context;Ljava/lang/String;LUb/s;)I", "setVolumeFromProgress", "(Landroid/content/Context;I)V", "getMaxVolume", "(Landroid/content/Context;LUb/s;)I", "Lkotlinx/coroutines/flow/SharedFlow;", "volumeEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getVolumeEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "TAG", "Ljava/lang/String;", "VOLUME_UNIT", "I", "VOLUME_UNIT_DLNA", "VOLUME_MAX_UNIT_CAST", "VOLUME_MAX_UNIT_DLNA", "", "CAST_RAW_VOLUME_MINIMUM", "D", "CAST_RAW_VOLUME_MAXIMUM", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_volumeEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static AudioManager a(Context context0) {
            Object object0 = context0.getSystemService("audio");
            q.e(object0, "null cannot be cast to non-null type android.media.AudioManager");
            return (AudioManager)object0;
        }

        public static s b() {
            return (s)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).z.get();
        }

        public static void c(Companion volumeUtils$Companion0, Context context0, int v) {
            int v4;
            int v3;
            AudioManager audioManager0 = Companion.a(context0);
            int v1 = Companion.getMaxVolume$default(volumeUtils$Companion0, context0, null, 2, null);
            if(((t)Companion.b()).c()) {
                double f = a.h(((t)Companion.b()).b(), 0.0, 1.0);
                double f1 = ((double)v) / ((double)v1);
                D d0 = new D();  // 初始化器: Ljava/lang/Object;-><init>()V
                double f2 = ((double)ye.a.W((f + f1) * 100.0)) / 100.0;
                d0.a = f2;
                int v2 = ye.a.U(((double)ye.a.W(f2 * 100.0)) / 100.0 * ((double)v1));
                v3 = a.j(v2, 0, v1);
                if(v3 == 0) {
                    d0.a = 0.0;
                }
                else if(v3 == v1) {
                    d0.a = 1.0;
                }
                LogConstantsKt.buildDebug$default(VolumeUtils.a, false, new b(v1, f, d0, v, f1, v2, v3), 1, null);
                ((t)Companion.b()).j(d0.a);
            }
            else if(((t)Companion.b()).e()) {
                t t0 = (t)Companion.b();
                if(t0.e()) {
                    L8.s s0 = t0.c.i;
                    v4 = s0 == null ? 0 : s0.i;
                }
                else {
                    LogU.debug$default(t0.d, "not connected dlna device", null, false, 6, null);
                    v4 = 0;
                }
                int v5 = a.j(v4 + v, 0, v1);
                v3 = a.j(v5, 0, v1);
                LogConstantsKt.buildDebug$default(VolumeUtils.a, false, new c(v4, v5, v, v3), 1, null);
                ((t)Companion.b()).k(v5);
            }
            else {
                int v6 = audioManager0.getStreamVolume(3) + v;
                v3 = a.j(v6, 0, v1);
                if(v6 > 0) {
                    audioManager0.adjustStreamVolume(3, 100, 0);
                }
                else {
                    audioManager0.setStreamVolume(3, 0, 0);
                }
                LogConstantsKt.buildDebug$default(VolumeUtils.a, false, new Bd.m(v3, 5), 1, null);
            }
            EventBusHelper.post(EventGoogleCast.DEVICE_VOLUME_CHANGE);
            volumeUtils$Companion0.emit(v3);
        }

        public final void emit(int v) {
            BuildersKt__Builders_commonKt.launch$default(VolumeUtils.access$getCoroutineScope$cp(), null, null, new n(null) {
                public int r;
                public final int w;

                {
                    this.w = v;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.utils.system.VolumeUtils.Companion.emit.1(this.w, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.utils.system.VolumeUtils.Companion.emit.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.r) {
                        case 0: {
                            d5.n.D(object0);
                            this.r = 1;
                            return VolumeUtils.b.emit(new Integer(this.w), this) == a0 ? a0 : H.a;
                        }
                        case 1: {
                            d5.n.D(object0);
                            return H.a;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                }
            }, 3, null);
        }

        public final int getMaxVolume(@Nullable Context context0, @NotNull s s0) {
            q.g(s0, "paramRemotePlayerManager");
            if(context0 == null) {
                return 0;
            }
            return ((t)s0).e() ? 100 : Companion.a(context0).getStreamMaxVolume(3);
        }

        public static int getMaxVolume$default(Companion volumeUtils$Companion0, Context context0, s s0, int v, Object object0) {
            if((v & 2) != 0) {
                volumeUtils$Companion0.getClass();
                s0 = Companion.b();
            }
            return volumeUtils$Companion0.getMaxVolume(context0, s0);
        }

        public final int getVolume(@Nullable Context context0, @NotNull String s, @NotNull s s1) {
            q.g(s, "fromCall");
            q.g(s1, "paramRemotePlayerManager");
            if(context0 == null) {
                LogU.debug$default(VolumeUtils.a, "getVolume() context is null fromCall: " + s, null, false, 6, null);
                return 0;
            }
            LogU.debug$default(VolumeUtils.a, "getVolume() fromCall: " + s, null, false, 6, null);
            if(((t)s1).c()) {
                return ye.a.U(((double)ye.a.W(((t)s1).b() * 100.0)) / 100.0 * ((double)Companion.getMaxVolume$default(this, context0, null, 2, null)));
            }
            if(((t)s1).e()) {
                if(!((t)s1).e()) {
                    LogU.debug$default(((t)s1).d, "not connected dlna device", null, false, 6, null);
                    return 0;
                }
                L8.s s2 = ((t)s1).c.i;
                return s2 == null ? 0 : s2.i;
            }
            return Companion.a(context0).getStreamVolume(3);
        }

        public static int getVolume$default(Companion volumeUtils$Companion0, Context context0, String s, s s1, int v, Object object0) {
            if((v & 4) != 0) {
                volumeUtils$Companion0.getClass();
                s1 = Companion.b();
            }
            return volumeUtils$Companion0.getVolume(context0, s, s1);
        }

        @NotNull
        public final SharedFlow getVolumeEventFlow() {
            return VolumeUtils.c;
        }

        public final boolean onVolumeKeyDown(@NotNull Context context0, int v) {
            q.g(context0, "context");
            LogU.debug$default(VolumeUtils.a, "onVolumeKeyDown() - keyCode: " + v, null, false, 6, null);
            boolean z = ((t)Companion.b()).f();
            switch(v) {
                case 24: {
                    this.shouldConsumeVolumeUpEvent(context0);
                    return z;
                }
                case 25: {
                    this.shouldConsumeVolumeDownEvent(context0);
                    return z;
                }
                default: {
                    return false;
                }
            }
        }

        public final void setVolumeFromProgress(@Nullable Context context0, int v) {
            if(context0 != null) {
                AudioManager audioManager0 = Companion.a(context0);
                int v1 = Companion.getMaxVolume$default(this, context0, null, 2, null);
                int v2 = a.j(v, 0, v1);
                if(v1 > 0) {
                    if(((t)Companion.b()).c()) {
                        ((t)Companion.b()).j(((double)v2) / ((double)v1));
                    }
                    else if(((t)Companion.b()).e()) {
                        ((t)Companion.b()).k(v2);
                    }
                    else {
                        if(v > 0) {
                            audioManager0.adjustStreamVolume(3, 100, 0);
                        }
                        else {
                            audioManager0.setStreamVolume(3, 0, 0);
                        }
                        audioManager0.setStreamVolume(3, v2, 0);
                    }
                    EventBusHelper.post(EventGoogleCast.DEVICE_VOLUME_CHANGE);
                    this.emit(v);
                }
            }
        }

        public final boolean shouldConsumeVolumeDownEvent(@Nullable Context context0) {
            int v = 1;
            if(context0 == null) {
                return true;
            }
            if(((t)Companion.b()).e()) {
                v = 5;
            }
            Companion.c(this, context0, -v);
            return ((t)Companion.b()).f();
        }

        public final boolean shouldConsumeVolumeUpEvent(@Nullable Context context0) {
            int v = 1;
            if(context0 == null) {
                return true;
            }
            if(((t)Companion.b()).e()) {
                v = 5;
            }
            Companion.c(this, context0, v);
            return ((t)Companion.b()).f();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public static final LogU a;
    public static final MutableSharedFlow b;
    public static final SharedFlow c;
    public static final CoroutineScope d;

    static {
        VolumeUtils.Companion = new Companion(null);
        VolumeUtils.a = Z.g("VolumeUtils", true);
        MutableSharedFlow mutableSharedFlow0 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null);
        VolumeUtils.b = mutableSharedFlow0;
        VolumeUtils.c = FlowKt.asSharedFlow(mutableSharedFlow0);
        VolumeUtils.d = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static final CoroutineScope access$getCoroutineScope$cp() {
        return VolumeUtils.d;
    }

    public static final int getMaxVolume(@Nullable Context context0, @NotNull s s0) {
        return VolumeUtils.Companion.getMaxVolume(context0, s0);
    }

    public static final int getVolume(@Nullable Context context0, @NotNull String s, @NotNull s s1) {
        return VolumeUtils.Companion.getVolume(context0, s, s1);
    }

    public static final boolean onVolumeKeyDown(@NotNull Context context0, int v) {
        return VolumeUtils.Companion.onVolumeKeyDown(context0, v);
    }
}

