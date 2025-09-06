package com.iloen.melon.playback;

import Cb.i;
import H0.b;
import H0.e;
import U4.x;
import ac.f;
import ac.m;
import ac.w;
import ac.z;
import android.content.Context;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.drm.MelonFile;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.mcp.Area;
import com.iloen.melon.net.mcp.request.EpPlayReReq.Body;
import com.iloen.melon.net.mcp.request.EpPlayReReq.Params;
import com.iloen.melon.net.mcp.request.EpPlayReReq;
import com.iloen.melon.net.mcp.response.EpPlayBaseRes;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogConstantsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.iloen.melon.utils.system.VolumeUtils.Companion;
import com.iloen.melon.utils.system.VolumeUtils;
import com.iloen.melon.utils.time.LapTime;
import e1.u;
import ie.H;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;
import we.n;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00C7\u0002\u0018\u00002\u00020\u0001:\u00018B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ7\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001A\u00020\u00122\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0015\u001A\u00020\u00072\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0019\u0010\u0003J\r\u0010\u001A\u001A\u00020\u0007\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u0015\u0010\u001B\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u001B\u0010\u0018J\r\u0010\u001C\u001A\u00020\u0007\u00A2\u0006\u0004\b\u001C\u0010\u0003R\u0014\u0010\u001D\u001A\u00020\n8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010 \u001A\u00020\u001F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001A\u00020\"8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b#\u0010$R\"\u0010%\u001A\u00020\u00128\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b%\u0010&\u001A\u0004\b%\u0010\'\"\u0004\b(\u0010)R\u0016\u0010*\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010-\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b-\u0010+R\u0018\u0010\u000E\u001A\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u000E\u0010.R\u001C\u00101\u001A\n\u0012\u0006\u0012\u0004\u0018\u0001000/8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00102R\u001F\u00104\u001A\n\u0012\u0006\u0012\u0004\u0018\u000100038\u0006\u00A2\u0006\f\n\u0004\b4\u00105\u001A\u0004\b6\u00107\u00A8\u00069"}, d2 = {"Lcom/iloen/melon/playback/EpPlayLogger;", "", "<init>", "()V", "", "position", "listenedTime", "Lie/H;", "updateAccumulatedTime", "(JJ)V", "", "url", "action", "Lac/w;", "analytics", "accumulatedTimeToSec", "sendPlayEventAndPolling", "(Ljava/lang/String;Ljava/lang/String;Lac/w;JJ)V", "", "isNeedSendLog", "(Lac/w;)Z", "setAnalytics", "(Lac/w;J)V", "updateCurrentPosition", "(J)V", "play", "pause", "seek", "logout", "TAG", "Ljava/lang/String;", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lcom/iloen/melon/utils/time/LapTime;", "lapTime", "Lcom/iloen/melon/utils/time/LapTime;", "isUseSmartPlaylist", "Z", "()Z", "setUseSmartPlaylist", "(Z)V", "lastPollingTimeToSec", "J", "currentPosition", "accumulatedTime", "Lac/w;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/iloen/melon/playback/EpPlayLogger$DebugReqInfo;", "_debugReqInfo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "debugReqInfo", "Lkotlinx/coroutines/flow/StateFlow;", "getDebugReqInfo", "()Lkotlinx/coroutines/flow/StateFlow;", "DebugReqInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EpPlayLogger {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001A\u00020\bHÆ\u0003J1\u0010\u0016\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001A\u00020\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001A\u001A\u00020\u001BHÖ\u0001J\t\u0010\u001C\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/playback/EpPlayLogger$DebugReqInfo;", "", "reqTimeStampInfo", "Ljava/time/OffsetDateTime;", "action", "", "playableName", "playPosition", "", "<init>", "(Ljava/time/OffsetDateTime;Ljava/lang/String;Ljava/lang/String;J)V", "getReqTimeStampInfo", "()Ljava/time/OffsetDateTime;", "getAction", "()Ljava/lang/String;", "getPlayableName", "getPlayPosition", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DebugReqInfo {
        public static final int $stable = 8;
        @NotNull
        private final String action;
        private final long playPosition;
        @NotNull
        private final String playableName;
        @NotNull
        private final OffsetDateTime reqTimeStampInfo;

        public DebugReqInfo(@NotNull OffsetDateTime offsetDateTime0, @NotNull String s, @NotNull String s1, long v) {
            q.g(offsetDateTime0, "reqTimeStampInfo");
            q.g(s, "action");
            q.g(s1, "playableName");
            super();
            this.reqTimeStampInfo = offsetDateTime0;
            this.action = s;
            this.playableName = s1;
            this.playPosition = v;
        }

        @NotNull
        public final OffsetDateTime component1() {
            return this.reqTimeStampInfo;
        }

        @NotNull
        public final String component2() {
            return this.action;
        }

        @NotNull
        public final String component3() {
            return this.playableName;
        }

        public final long component4() {
            return this.playPosition;
        }

        @NotNull
        public final DebugReqInfo copy(@NotNull OffsetDateTime offsetDateTime0, @NotNull String s, @NotNull String s1, long v) {
            q.g(offsetDateTime0, "reqTimeStampInfo");
            q.g(s, "action");
            q.g(s1, "playableName");
            return new DebugReqInfo(offsetDateTime0, s, s1, v);
        }

        public static DebugReqInfo copy$default(DebugReqInfo epPlayLogger$DebugReqInfo0, OffsetDateTime offsetDateTime0, String s, String s1, long v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                offsetDateTime0 = epPlayLogger$DebugReqInfo0.reqTimeStampInfo;
            }
            if((v1 & 2) != 0) {
                s = epPlayLogger$DebugReqInfo0.action;
            }
            if((v1 & 4) != 0) {
                s1 = epPlayLogger$DebugReqInfo0.playableName;
            }
            if((v1 & 8) != 0) {
                v = epPlayLogger$DebugReqInfo0.playPosition;
            }
            return epPlayLogger$DebugReqInfo0.copy(offsetDateTime0, s, s1, v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DebugReqInfo)) {
                return false;
            }
            if(!q.b(this.reqTimeStampInfo, ((DebugReqInfo)object0).reqTimeStampInfo)) {
                return false;
            }
            if(!q.b(this.action, ((DebugReqInfo)object0).action)) {
                return false;
            }
            return q.b(this.playableName, ((DebugReqInfo)object0).playableName) ? this.playPosition == ((DebugReqInfo)object0).playPosition : false;
        }

        @NotNull
        public final String getAction() {
            return this.action;
        }

        public final long getPlayPosition() {
            return this.playPosition;
        }

        @NotNull
        public final String getPlayableName() {
            return this.playableName;
        }

        @NotNull
        public final OffsetDateTime getReqTimeStampInfo() {
            return this.reqTimeStampInfo;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(this.playPosition) + x.b(x.b(this.reqTimeStampInfo.hashCode() * 0x1F, 0x1F, this.action), 0x1F, this.playableName);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("DebugReqInfo(reqTimeStampInfo=");
            stringBuilder0.append(this.reqTimeStampInfo);
            stringBuilder0.append(", action=");
            stringBuilder0.append(this.action);
            stringBuilder0.append(", playableName=");
            b.t(this.playPosition, this.playableName, ", playPosition=", stringBuilder0);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    public static final int $stable;
    @NotNull
    public static final EpPlayLogger INSTANCE;
    @NotNull
    private static final String TAG;
    @NotNull
    private static final MutableStateFlow _debugReqInfo;
    private static long accumulatedTime;
    @Nullable
    private static w analytics;
    private static long currentPosition;
    @NotNull
    private static final StateFlow debugReqInfo;
    private static boolean isUseSmartPlaylist;
    @NotNull
    private static final LapTime lapTime;
    private static long lastPollingTimeToSec;
    @NotNull
    private static final LogU log;

    static {
        EpPlayLogger.INSTANCE = new EpPlayLogger();
        EpPlayLogger.TAG = "EpPlayLogger";
        EpPlayLogger.log = LogU.Companion.create("EpPlayLogger", true, Category.None);
        EpPlayLogger.lapTime = new LapTime("EpPlayLogger");
        MutableStateFlow mutableStateFlow0 = StateFlowKt.MutableStateFlow(null);
        EpPlayLogger._debugReqInfo = mutableStateFlow0;
        EpPlayLogger.debugReqInfo = mutableStateFlow0;
        EpPlayLogger.$stable = 8;
    }

    public static final long access$getAccumulatedTime$p() [...] // 潜在的解密器

    public static final long access$getCurrentPosition$p() [...] // 潜在的解密器

    public static final long access$getLastPollingTimeToSec$p() [...] // 潜在的解密器

    public static void b(VolleyError volleyError0) {
        EpPlayLogger.sendPlayEventAndPolling$lambda$3(volleyError0);
    }

    @NotNull
    public final StateFlow getDebugReqInfo() {
        return EpPlayLogger.debugReqInfo;
    }

    // 去混淆评级： 低(20)
    private final boolean isNeedSendLog(w w0) {
        return w0 != null && (w0.d != null && w0.d.a && w0.d.c);
    }

    public final boolean isUseSmartPlaylist() {
        return EpPlayLogger.isUseSmartPlaylist;
    }

    public final void logout() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n() {
            int label;

            {
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.EpPlayLogger.logout.1(continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.EpPlayLogger.logout.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                w w0 = EpPlayLogger.analytics;
                if(w0 != null) {
                    Y.o(0L, "logout() currentPosition: ", ", listenedTimeToSec: ").append(0L);
                    LogU.debug$default(EpPlayLogger.log, "logout() currentPosition: 0, listenedTimeToSec: 0", null, false, 6, null);
                    EpPlayLogger.INSTANCE.sendPlayEventAndPolling("/re.json", "pause", w0, 0L, 0L);
                }
                return H.a;
            }
        }, 3, null);
    }

    public final void pause() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n() {
            int label;

            {
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.EpPlayLogger.pause.1(continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.EpPlayLogger.pause.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                w w0 = EpPlayLogger.analytics;
                if(w0 != null) {
                    Y.o(0L, "pause() currentPosition: ", ", listenedTimeToSec: ").append(0L);
                    LogU.debug$default(EpPlayLogger.log, "pause() currentPosition: 0, listenedTimeToSec: 0", null, false, 6, null);
                    EpPlayLogger.INSTANCE.sendPlayEventAndPolling("/re.json", "pause", w0, 0L, 0L);
                }
                return H.a;
            }
        }, 3, null);
    }

    public final void play() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n() {
            int label;

            {
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.EpPlayLogger.play.1(continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.EpPlayLogger.play.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                w w0 = EpPlayLogger.analytics;
                if(w0 != null) {
                    Y.o(0L, "play() currentPosition: ", ", listenedTimeToSec: ").append(0L);
                    LogU.debug$default(EpPlayLogger.log, "play() currentPosition: 0, listenedTimeToSec: 0", null, false, 6, null);
                    EpPlayLogger.INSTANCE.sendPlayEventAndPolling("/re.json", "play", w0, 0L, 0L);
                }
                return H.a;
            }
        }, 3, null);
    }

    public final void seek(long v) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(null) {
            final long $position;
            int label;

            {
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.EpPlayLogger.seek.1(this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.EpPlayLogger.seek.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                w w0 = EpPlayLogger.analytics;
                if(w0 != null) {
                    long v = EpPlayLogger.lapTime.getTotalElapsedTime();
                    StringBuilder stringBuilder0 = Y.o(this.$position, "seek() currentPosition: ", ", previousTotalElapsedTime: ");
                    stringBuilder0.append(v);
                    LogU.debug$default(EpPlayLogger.log, stringBuilder0.toString(), null, false, 6, null);
                    long v1 = EpPlayLogger.lapTime.start(this.$position, v).getTotalElapsedTime();
                    EpPlayLogger.INSTANCE.updateAccumulatedTime(this.$position, v1);
                    EpPlayLogger.INSTANCE.sendPlayEventAndPolling("/re.json", "play", w0, this.$position, EpPlayLogger.access$getAccumulatedTime$p() / 1000L);
                }
                return H.a;
            }
        }, 3, null);
    }

    private final void sendPlayEventAndPolling(String s, String s1, w w0, long v, long v1) {
        String s9;
        String s8;
        String s7;
        String s6;
        String s5;
        String s4;
        z z0 = w0.c;
        m m0 = w0.b;
        if(z0.c.length() == 0) {
            LogU.debug$default(EpPlayLogger.log, "sendPlayEventAndPolling() playToken is invalid", null, false, 6, null);
            return;
        }
        if(!this.isNeedSendLog(w0)) {
            LogU.debug$default(EpPlayLogger.log, "sendPlayEventAndPolling() isNeedSendLog: false", null, false, 6, null);
            return;
        }
        OffsetDateTime offsetDateTime0 = Instant.ofEpochMilli(System.currentTimeMillis()).atOffset(ZoneOffset.ofHours(9));
        LogU logU0 = EpPlayLogger.log;
        LogU.debug$default(logU0, "sendPlayEventAndPolling() timeStamp:20250906123214086", null, false, 6, null);
        Area area0 = new Area();
        area0.smartListType = w0.d.d;
        area0.listType = w0.d.e;
        area0.contsId = w0.d.f;
        area0.contsTypeCode = w0.d.g;
        area0.seedContsId = w0.d.h;
        area0.seedContsTypeCode = w0.d.i;
        e e0 = m0.m;
        CType cType0 = m0.c;
        String s2 = m0.b;
        area0.trackId = m0.a;
        area0.position = String.valueOf(v / 1000L);
        area0.cId = s2;
        area0.cType = cType0.toString();
        MelonAppBase.Companion.getClass();
        area0.pcId = DeviceIdentifier.id(t.a().getDeviceData().a);
        Body epPlayReReq$Body0 = new Body();
        epPlayReReq$Body0.area = area0;
        epPlayReReq$Body0.timestamp = "20250906123214086";
        epPlayReReq$Body0.action = s1;
        epPlayReReq$Body0.accumulatedTime = String.valueOf(v1);
        epPlayReReq$Body0.playToken = z0.c;
        epPlayReReq$Body0.pinterval = String.valueOf(z0.d);
        epPlayReReq$Body0.cpId = t.a().getMelonCpId();
        epPlayReReq$Body0.cpKey = t.a().getMelonCpKey();
        epPlayReReq$Body0.cId = s2;
        epPlayReReq$Body0.cType = cType0.getValue();
        epPlayReReq$Body0.menuId = m0.j;
        epPlayReReq$Body0.orgMenuId = m0.k;
        epPlayReReq$Body0.bitrate = m0.f;
        epPlayReReq$Body0.metaType = m0.g;
        epPlayReReq$Body0.loggingToken = z0.a;
        String s3 = "";
        epPlayReReq$Body0.locPl = e0 instanceof f ? "1" : "";
        epPlayReReq$Body0.initDate = m0.e;
        epPlayReReq$Body0.freeYn = m0.i;
        StatsElementsBase statsElementsBase0 = StatsElementsBase.toStatsElementsBase(m0.l);
        if(statsElementsBase0 == null) {
            s4 = "";
        }
        else {
            s4 = statsElementsBase0.impressionId;
            if(s4 == null) {
                s4 = "";
            }
        }
        epPlayReReq$Body0.impressionId = s4;
        if(statsElementsBase0 == null) {
            s5 = "";
        }
        else {
            s5 = statsElementsBase0.parentContsId;
            if(s5 == null) {
                s5 = "";
            }
        }
        epPlayReReq$Body0.parentContsId = s5;
        if(statsElementsBase0 == null) {
            s6 = "";
        }
        else {
            s6 = statsElementsBase0.parentContsType;
            if(s6 == null) {
                s6 = "";
            }
        }
        epPlayReReq$Body0.parentContsType = s6;
        if(statsElementsBase0 == null) {
            s7 = "";
        }
        else {
            s7 = statsElementsBase0.seedContsId;
            if(s7 == null) {
                s7 = "";
            }
        }
        epPlayReReq$Body0.seedContsId = s7;
        if(statsElementsBase0 == null) {
            s8 = "";
        }
        else {
            s8 = statsElementsBase0.seedContsTypeCode;
            if(s8 == null) {
                s8 = "";
            }
        }
        epPlayReReq$Body0.seedContsTypeCode = s8;
        if(statsElementsBase0 == null) {
            s9 = "";
        }
        else {
            s9 = statsElementsBase0.rangeCode;
            if(s9 == null) {
                s9 = "";
            }
        }
        epPlayReReq$Body0.rangeCode = s9;
        epPlayReReq$Body0.networkType = "wifi";
        if(q.b(epPlayReReq$Body0.locPl, "1") && e0 instanceof f) {
            MelonFile melonFile0 = ((f)e0).e;
            if(melonFile0 != null) {
                switch(FilenameUtils.getFileType(melonFile0.b())) {
                    case 0x102: {
                        s3 = "MP3";
                        break;
                    }
                    case 0x202: {
                        s3 = "FLAC";
                        break;
                    }
                    case 0x402: {
                        s3 = "DCF";
                    }
                }
                epPlayReReq$Body0.mediaType = s3;
            }
        }
        Context context0 = t.a().getContext();
        epPlayReReq$Body0.volume = String.valueOf(Companion.getVolume$default(VolumeUtils.Companion, context0, "EpPlayLogger", null, 4, null));
        Params epPlayReReq$Params0 = new Params();
        epPlayReReq$Params0.action = s1;
        epPlayReReq$Params0.cId = s2;
        epPlayReReq$Params0.cType = cType0.toString();
        epPlayReReq$Params0.timestamp = "20250906123214086";
        LogU.debug$default(logU0, "sendPlayEventAndPolling() EpPlayReReq fire!!", null, false, 6, null);
        RequestBuilder.newInstance(new EpPlayReReq(t.a().getContext(), s, epPlayReReq$Params0, epPlayReReq$Body0)).tag("EpPlayLogger").listener(new Listener() {
            public void onResponse(EpPlayBaseRes epPlayBaseRes0) {
                LogU.debug$default(EpPlayLogger.log, "EpPlayReReq: response timeStamp " + this.$timeStamp + " - result:" + (epPlayBaseRes0 == null ? null : epPlayBaseRes0.result), null, false, 6, null);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((EpPlayBaseRes)object0));
            }
        }).errorListener(new com.iloen.melon.fragments.musicmessage.e(19)).request();
        if(!A8.b.e()) {
            LogConstantsKt.buildDebug(logU0, true, new a("20250906123214086", s1, area0, w0, v, v1));
            DebugReqInfo epPlayLogger$DebugReqInfo0 = new DebugReqInfo(offsetDateTime0, s1, m0.d, v);
            EpPlayLogger._debugReqInfo.setValue(epPlayLogger$DebugReqInfo0);
        }
    }

    private static final void sendPlayEventAndPolling$lambda$3(VolleyError volleyError0) {
        LogU.error$default(EpPlayLogger.log, "EpPlayReReq", volleyError0, false, 4, null);
    }

    private static final H sendPlayEventAndPolling$lambda$4(String s, String s1, Area area0, w w0, long v, long v1, StringBuilder stringBuilder0) {
        q.g(stringBuilder0, "$this$buildDebug");
        stringBuilder0.append("EpPlayReReq: request timeStamp " + s);
        i.a(stringBuilder0, "action:" + s1);
        i.a(stringBuilder0, "playlist:" + area0.smartListType);
        i.a(stringBuilder0, "smartPlaylistInfo:" + area0.listType);
        i.a(stringBuilder0, "trackId:" + area0.trackId);
        i.a(stringBuilder0, "cId:" + area0.cId);
        i.a(stringBuilder0, "contentName:" + w0.b.d);
        i.a(stringBuilder0, "position:" + v + ",");
        i.a(stringBuilder0, "accumulatedTimeToSec:" + v1);
        i.a(stringBuilder0, "memberKey:" + u.v(((e0)o.a()).j()));
        return H.a;
    }

    public final void setAnalytics(@Nullable w w0, long v) {
        String s;
        LogU logU0 = EpPlayLogger.log;
        if(w0 == null) {
            s = null;
        }
        else {
            m m0 = w0.b;
            s = m0 == null ? null : m0.d;
        }
        LogU.debug$default(logU0, "setAnalytics() analytics: " + s, null, false, 6, null);
        EpPlayLogger.lapTime.reset();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(w0, null) {
            final w $analytics;
            final long $position;
            int label;

            {
                this.$position = v;
                this.$analytics = w0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.EpPlayLogger.setAnalytics.1(this.$position, this.$analytics, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.EpPlayLogger.setAnalytics.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                EpPlayLogger.currentPosition = this.$position;
                EpPlayLogger.lastPollingTimeToSec = 0L;
                EpPlayLogger.accumulatedTime = 0L;
                H h0 = H.a;
                if(!EpPlayLogger.INSTANCE.isNeedSendLog(this.$analytics)) {
                    LogU.debug$default(EpPlayLogger.log, "setAnalytics() isNeedSendLog: false", null, false, 6, null);
                    EpPlayLogger.analytics = null;
                    return h0;
                }
                EpPlayLogger.analytics = this.$analytics;
                EpPlayLogger.lapTime.start(EpPlayLogger.access$getCurrentPosition$p(), 0L);
                return h0;
            }
        }, 3, null);
    }

    public final void setUseSmartPlaylist(boolean z) {
        EpPlayLogger.isUseSmartPlaylist = z;
    }

    private final void updateAccumulatedTime(long v, long v1) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(v1, null) {
            final long $listenedTime;
            final long $position;
            int label;

            {
                this.$position = v;
                this.$listenedTime = v1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.EpPlayLogger.updateAccumulatedTime.1(this.$position, this.$listenedTime, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.EpPlayLogger.updateAccumulatedTime.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(EpPlayLogger.analytics != null) {
                    EpPlayLogger.currentPosition = this.$position;
                    EpPlayLogger.accumulatedTime = this.$listenedTime;
                }
                return H.a;
            }
        }, 3, null);
    }

    public final void updateCurrentPosition(long v) {
        this.updateAccumulatedTime(v, EpPlayLogger.lapTime.lap(v).getTotalElapsedTime());
    }
}

