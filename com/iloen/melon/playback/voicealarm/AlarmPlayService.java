package com.iloen.melon.playback.voicealarm;

import Ba.L;
import Ba.S;
import E9.w;
import Ma.l;
import P1.c;
import U4.F;
import Vc.B;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import android.webkit.URLUtil;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.alarm.MusicAlarmParcelable;
import com.iloen.melon.mcache.CacheUrlBuilder;
import com.iloen.melon.mcache.MelonStreamCacheManager;
import com.iloen.melon.mcache.error.MCacheError;
import com.iloen.melon.net.v4x.response.StreamGetPathRes.RESPONSE.GetPathInfo;
import com.iloen.melon.net.v4x.response.StreamGetPathRes;
import com.iloen.melon.playback.IPlayer;
import com.iloen.melon.playback.OemMusicPlayer;
import com.iloen.melon.playback.PlayerState;
import com.iloen.melon.playback.ServiceUtilKt;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.IntentUtils;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.preference.MusicAlarmPrefsHelper;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.net.ApiResult;
import com.melon.net.ApiResultKt;
import com.melon.net.res.VoiceAlarm.Track;
import com.melon.net.res.VoiceAlarm.TrackDto;
import com.melon.net.res.VoiceAlarmAlbumTracksRes.Response;
import com.melon.net.res.VoiceAlarmAlbumTracksRes;
import com.melon.playback.MelonIntentService;
import d3.g;
import e1.u;
import ie.H;
import ie.j;
import java.util.List;
import java.util.concurrent.CancellationException;
import k8.Y;
import k8.o;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import o8.d;
import o8.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 n2\u00020\u00012\u00020\u0002:\u0001nB\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u000B\u0010\u0004J\u000F\u0010\f\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\f\u0010\u0004J)\u0010\u0010\u001A\u00020\r2\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u00122\u0012\u0010\u0016\u001A\u000E\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\n0\u0014H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\n2\u0006\u0010\u0019\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0019\u0010\u001E\u001A\u00020\n2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJC\u0010\'\u001A\u00020\n2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\u0006\u0010 \u001A\u00020\r2\u0006\u0010!\u001A\u00020\r2\b\u0010#\u001A\u0004\u0018\u00010\"2\u000E\u0010&\u001A\n\u0018\u00010$j\u0004\u0018\u0001`%H\u0016\u00A2\u0006\u0004\b\'\u0010(J\u0019\u0010)\u001A\u00020\n2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001CH\u0016\u00A2\u0006\u0004\b)\u0010\u001FJ\u0017\u0010+\u001A\u00020\n2\u0006\u0010*\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b-\u0010\u0004J\u000F\u0010.\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b.\u0010\u0004J\u000F\u0010/\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b/\u0010\u0004J\u000F\u00100\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b0\u0010\u0004J\u000F\u00102\u001A\u000201H\u0016\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b4\u00105J\u000F\u00106\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b6\u00105J\'\u0010:\u001A\u00020\n2\u0006\u00107\u001A\u00020\r2\u0006\u00108\u001A\u00020\r2\u0006\u00109\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b:\u0010;J\u0017\u0010<\u001A\u00020\n2\u0006\u00109\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b<\u0010,J\u0017\u0010=\u001A\u00020\n2\u0006\u00109\u001A\u00020\"H\u0016\u00A2\u0006\u0004\b=\u0010,J\u000F\u0010>\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b>\u0010\u0004J\u0017\u0010?\u001A\u00020\n2\u0006\u0010\u0013\u001A\u00020\u0012H\u0002\u00A2\u0006\u0004\b?\u0010@J\u000F\u0010A\u001A\u00020\nH\u0002\u00A2\u0006\u0004\bA\u0010\u0004R\u0014\u0010C\u001A\u00020B8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u001B\u0010J\u001A\u00020E8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bF\u0010G\u001A\u0004\bH\u0010IR\u001B\u0010O\u001A\u00020K8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bL\u0010G\u001A\u0004\bM\u0010NR\u0018\u0010P\u001A\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001A\u00020\r8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010SR$\u0010T\u001A\u0004\u0018\u00010\u001C8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bT\u0010U\u001A\u0004\bV\u0010W\"\u0004\bX\u0010\u001FR\"\u0010Z\u001A\u00020Y8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\bZ\u0010[\u001A\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010a\u001A\u0004\u0018\u00010`8\u0016@\u0016X\u0096\u000E\u00A2\u0006\u0012\n\u0004\ba\u0010b\u001A\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010h\u001A\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\bh\u0010i\u001A\u0004\bj\u0010k\"\u0004\bl\u0010m\u00A8\u0006o"}, d2 = {"Lcom/iloen/melon/playback/voicealarm/AlarmPlayService;", "Landroidx/lifecycle/LifecycleService;", "Lcom/iloen/melon/playback/voicealarm/VoiceAlarmPlay;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "Lie/H;", "onCreate", "onDestroy", "", "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "Lcom/melon/net/res/VoiceAlarm$Track;", "track", "Lkotlin/Function1;", "Lcom/iloen/melon/net/v4x/response/StreamGetPathRes;", "onSucess", "getAlarmPath", "(Lcom/melon/net/res/VoiceAlarm$Track;Lwe/k;)V", "res", "completeGetPath", "(Lcom/iloen/melon/net/v4x/response/StreamGetPathRes;)V", "Lcom/iloen/melon/playback/IPlayer;", "player", "onPrepared", "(Lcom/iloen/melon/playback/IPlayer;)V", "what", "extra", "", "msg", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "onError", "(Lcom/iloen/melon/playback/IPlayer;IILjava/lang/String;Ljava/lang/Exception;)V", "onCompletion", "url", "startPrepare", "(Ljava/lang/String;)V", "stopPlay", "audioFocusLoss", "playerInit", "playerRelease", "", "isPlaying", "()Z", "getCurrentPosition", "()I", "getDuration", "permil", "position", "trackId", "onPlaybackPositionUpdate", "(IILjava/lang/String;)V", "onPlaybackStart", "onPlaybackStop", "sendIsPlayingBroadCast", "requestVoiceTrackPlay", "(Lcom/melon/net/res/VoiceAlarm$Track;)V", "requestPlayMusic", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lo8/a;", "alarmNotificationManager$delegate", "Lie/j;", "getAlarmNotificationManager", "()Lo8/a;", "alarmNotificationManager", "Landroid/content/BroadcastReceiver;", "broadcastReceiver$delegate", "getBroadcastReceiver", "()Landroid/content/BroadcastReceiver;", "broadcastReceiver", "voiceTrack", "Lcom/melon/net/res/VoiceAlarm$Track;", "rt", "I", "iPlayer", "Lcom/iloen/melon/playback/IPlayer;", "getIPlayer", "()Lcom/iloen/melon/playback/IPlayer;", "setIPlayer", "Lcom/iloen/melon/playback/PlayerState;", "currentState", "Lcom/iloen/melon/playback/PlayerState;", "getCurrentState", "()Lcom/iloen/melon/playback/PlayerState;", "setCurrentState", "(Lcom/iloen/melon/playback/PlayerState;)V", "Lcom/iloen/melon/playback/voicealarm/VoiceTrackAudioFocusHelper;", "audioFocusHelper", "Lcom/iloen/melon/playback/voicealarm/VoiceTrackAudioFocusHelper;", "getAudioFocusHelper", "()Lcom/iloen/melon/playback/voicealarm/VoiceTrackAudioFocusHelper;", "setAudioFocusHelper", "(Lcom/iloen/melon/playback/voicealarm/VoiceTrackAudioFocusHelper;)V", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AlarmPlayService extends Hilt_AlarmPlayService implements VoiceAlarmPlay {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/playback/voicealarm/AlarmPlayService$Companion;", "", "<init>", "()V", "TAG", "", "PREPARING_TIMEOUT_INCREMENT", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    private static final long PREPARING_TIMEOUT_INCREMENT;
    @NotNull
    private static final String TAG;
    @NotNull
    private final j alarmNotificationManager$delegate;
    @Nullable
    private VoiceTrackAudioFocusHelper audioFocusHelper;
    @NotNull
    private final j broadcastReceiver$delegate;
    @Nullable
    private CoroutineScope coroutineScope;
    @NotNull
    private PlayerState currentState;
    @Nullable
    private IPlayer iPlayer;
    @NotNull
    private final LogU log;
    private int rt;
    @Nullable
    private Track voiceTrack;

    static {
        AlarmPlayService.Companion = new Companion(null);
        AlarmPlayService.$stable = 8;
        AlarmPlayService.TAG = "AlarmPlayService";
        AlarmPlayService.PREPARING_TIMEOUT_INCREMENT = 5000L;
    }

    public AlarmPlayService() {
        this.log = LogU.Companion.create("AlarmPlayService", true, Category.Playback);
        this.alarmNotificationManager$delegate = g.Q(new a(this, 0));
        this.broadcastReceiver$delegate = g.Q(new a(this, 1));
        this.currentState = PlayerState.End;

        @Metadata(d1 = {"\u0000\u001D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/iloen/melon/playback/voicealarm/AlarmPlayService$broadcastReceiver$2$1", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Lie/H;", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.playback.voicealarm.AlarmPlayService.broadcastReceiver.2.1 extends BroadcastReceiver {
            public com.iloen.melon.playback.voicealarm.AlarmPlayService.broadcastReceiver.2.1(AlarmPlayService alarmPlayService0) {
            }

            @Override  // android.content.BroadcastReceiver
            public void onReceive(Context context0, Intent intent0) {
                String s = intent0 == null ? null : intent0.getAction();
                LogU.debug$default(AlarmPlayService.access$getLog$p(AlarmPlayService.this), "onReceive() action: " + s, null, false, 6, null);
                if(q.b(s, "com.iloen.melon.intent.action.playservice.checkvoicetrackplay")) {
                    AlarmPlayService.access$sendIsPlayingBroadCast(AlarmPlayService.this);
                }
            }
        }

    }

    public static final long access$getPREPARING_TIMEOUT_INCREMENT$cp() [...] // 潜在的解密器

    public static final void access$sendIsPlayingBroadCast(AlarmPlayService alarmPlayService0) {
        alarmPlayService0.sendIsPlayingBroadCast();
    }

    private static final o8.a alarmNotificationManager_delegate$lambda$0(AlarmPlayService alarmPlayService0) {
        q.g(alarmPlayService0, "context");
        return new o8.a(alarmPlayService0);
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void audioFocusLoss() {
        LogU.debug$default(this.log, "audioFocusLoss()", null, false, 6, null);
        this.stopPlay();
    }

    private static final com.iloen.melon.playback.voicealarm.AlarmPlayService.broadcastReceiver.2.1 broadcastReceiver_delegate$lambda$1(AlarmPlayService alarmPlayService0) {
        return new com.iloen.melon.playback.voicealarm.AlarmPlayService.broadcastReceiver.2.1(alarmPlayService0);
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void completeGetPath(@NotNull StreamGetPathRes streamGetPathRes0) {
        q.g(streamGetPathRes0, "res");
        LogU.debug$default(this.log, "completeGetPath() res: " + streamGetPathRes0, null, false, 6, null);
        String s = this.voiceTrack == null ? null : this.voiceTrack.getTrackId();
        GetPathInfo streamGetPathRes$RESPONSE$GetPathInfo0 = streamGetPathRes0.response.getpathinfo;
        if(streamGetPathRes$RESPONSE$GetPathInfo0 == null || (streamGetPathRes$RESPONSE$GetPathInfo0.cid == null || streamGetPathRes$RESPONSE$GetPathInfo0.cid.length() == 0 || !ClassUtils.equals(streamGetPathRes$RESPONSE$GetPathInfo0.cid, s))) {
            throw new Exception("completeGetPath() need check cid: " + s + " or pathInfo: " + streamGetPathRes$RESPONSE$GetPathInfo0);
        }
        String s1 = streamGetPathRes$RESPONSE$GetPathInfo0.protocoltype;
        String s2 = streamGetPathRes$RESPONSE$GetPathInfo0.path;
        if(s1 == null || s1.length() == 0 || !"MCACHE".equals(s1)) {
            q.d(s2);
        }
        else {
            try {
                if(!MelonStreamCacheManager.getInstance().isRunning()) {
                    MelonStreamCacheManager.getInstance().startCaching();
                }
                String s3 = MelonStreamCacheManager.getInstance().convertProxyUri(new CacheUrlBuilder(streamGetPathRes$RESPONSE$GetPathInfo0.path, streamGetPathRes$RESPONSE$GetPathInfo0.cid).cacheEnable(MelonSettingInfo.isStreamCacheEnabled()).bitrate(streamGetPathRes$RESPONSE$GetPathInfo0.bitrate).metaType(streamGetPathRes$RESPONSE$GetPathInfo0.metatype).build(), streamGetPathRes$RESPONSE$GetPathInfo0.c);
                q.f(s3, "convertProxyUri(...)");
                if(!URLUtil.isNetworkUrl(s3)) {
                    throw new MCacheError("Wrong mcache path: " + s3 + ", src:" + s2);
                }
                s2 = s3;
            }
            catch(Exception exception0) {
                LogU.error$default(this.log, "mcache path error", exception0, false, 4, null);
                throw new MCacheError("mcache path exception:" + exception0 + ", src:" + s2);
            }
        }
        if(s2.length() == 0) {
            throw new Exception("completeGetPath() StreamPath is invalid");
        }
        this.startPrepare(s2);
    }

    private final o8.a getAlarmNotificationManager() {
        return (o8.a)this.alarmNotificationManager$delegate.getValue();
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void getAlarmPath(@NotNull Track voiceAlarm$Track0, @NotNull k k0) {
        q.g(voiceAlarm$Track0, "track");
        q.g(k0, "onSucess");
        LogU.debug$default(this.log, "getAlarmPath() voiceTrack: " + voiceAlarm$Track0, null, false, 6, null);
        CoroutineScope coroutineScope0 = this.coroutineScope;
        if(coroutineScope0 != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new n(this, k0, null) {
                final k $onSucess;
                final Track $track;
                Object L$0;
                int label;

                {
                    this.$track = voiceAlarm$Track0;
                    AlarmPlayService.this = alarmPlayService0;
                    this.$onSucess = k0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.playback.voicealarm.AlarmPlayService.getAlarmPath.1(this.$track, AlarmPlayService.this, this.$onSucess, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.playback.voicealarm.AlarmPlayService.getAlarmPath.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    Exception exception2;
                    Object object1;
                    Integer integer0;
                    String s1;
                    L l0;
                    String s;
                    ne.a a0 = ne.a.a;
                    H h0 = H.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            try {
                                s = "";
                                MelonAppBase.Companion.getClass();
                                l0 = ((o)(((l)w.s(t.a().getContext(), l.class)))).n();
                                s1 = this.$track.getTrackId();
                                if(s1 == null) {
                                    s1 = "";
                                }
                                String s2 = this.$track.getAlbumId();
                                if(s2 != null) {
                                    s = s2;
                                }
                            }
                            catch(Exception exception0) {
                                goto label_38;
                            }
                            if(AlarmPlayService.this.rt > 0) {
                                try {
                                    integer0 = new Integer(AlarmPlayService.this.rt);
                                }
                                catch(Exception exception1) {
                                    exception2 = exception1;
                                    goto label_39;
                                }
                            }
                            else {
                                integer0 = null;
                            }
                            try {
                                String s3 = NetUtils.INSTANCE.getSongMetaType(false);
                                String s4 = NetUtils.INSTANCE.getSongBitrate(false);
                                this.label = 1;
                                object1 = l0.c(s1, "99", "1000003202", s, integer0, s3, s4, "", "wifi", "N", this);
                                if(object1 != a0) {
                                    goto label_30;
                                }
                                return a0;
                            }
                            catch(Exception exception0) {
                                goto label_38;
                            }
                            goto label_30;
                        }
                        case 1: {
                            try {
                                d5.n.D(object0);
                                object1 = object0;
                            }
                            catch(Exception exception1) {
                                exception2 = exception1;
                                goto label_39;
                            }
                            try {
                            label_30:
                                StreamGetPathRes streamGetPathRes0 = (StreamGetPathRes)ApiResultKt.getOrThrow(((ApiResult)object1));
                                if(!Cb.j.c(streamGetPathRes0.notification)) {
                                    Cb.j.b(streamGetPathRes0.notification, false, 3);
                                    AlarmPlayService.this.requestPlayMusic();
                                    return h0;
                                }
                                this.$onSucess.invoke(streamGetPathRes0);
                                return h0;
                            }
                            catch(Exception exception0) {
                            label_38:
                                exception2 = exception0;
                            }
                        label_39:
                            LogU.error$default(AlarmPlayService.this.log, "getAlarmPath() FAILED", exception2, false, 4, null);
                            if(exception2 instanceof CancellationException) {
                                return h0;
                            }
                            int v = MelonSettingInfo.getPlaybackRetryCount();
                            if(AlarmPlayService.this.rt >= v) {
                                AlarmPlayService.this.rt = 0;
                                AlarmPlayService.this.requestPlayMusic();
                                return h0;
                            }
                            ++AlarmPlayService.this.rt;
                            this.L$0 = null;
                            this.label = 2;
                            if(DelayKt.delay(5000L * ((long)AlarmPlayService.this.rt), this) == a0) {
                                return a0;
                            }
                            AlarmPlayService.this.getAlarmPath(this.$track, this.$onSucess);
                            return h0;
                        }
                        case 2: {
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    Exception exception3 = (Exception)this.L$0;
                    d5.n.D(object0);
                    AlarmPlayService.this.getAlarmPath(this.$track, this.$onSucess);
                    return h0;
                }
            }, 3, null);
        }
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    @Nullable
    public VoiceTrackAudioFocusHelper getAudioFocusHelper() {
        return this.audioFocusHelper;
    }

    private final BroadcastReceiver getBroadcastReceiver() {
        return (BroadcastReceiver)this.broadcastReceiver$delegate.getValue();
    }

    @Nullable
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public int getCurrentPosition() {
        IPlayer iPlayer0 = this.getIPlayer();
        return iPlayer0 == null ? 0 : iPlayer0.getCurrentPosition();
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    @NotNull
    public PlayerState getCurrentState() {
        return this.currentState;
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public int getDuration() {
        IPlayer iPlayer0 = this.getIPlayer();
        return iPlayer0 == null ? 0 : iPlayer0.getDuration();
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    @Nullable
    public IPlayer getIPlayer() {
        return this.iPlayer;
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public boolean isPlaying() {
        IPlayer iPlayer0 = this.getIPlayer();
        return iPlayer0 == null ? false : iPlayer0.isPlaying();
    }

    @Override  // androidx.lifecycle.LifecycleService
    @Nullable
    public IBinder onBind(@NotNull Intent intent0) {
        q.g(intent0, "intent");
        return super.onBind(intent0);
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void onBufferingChange(boolean z) {
        VoiceAlarmPlay.super.onBufferingChange(z);
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onCompletion(@Nullable IPlayer iPlayer0) {
        this.setCurrentState(PlayerState.PlaybackCompleted);
        Track voiceAlarm$Track0 = this.voiceTrack;
        if(voiceAlarm$Track0 != null) {
            q.d(voiceAlarm$Track0);
            this.requestVoiceTrackPlay(voiceAlarm$Track0);
        }
    }

    @Override  // com.iloen.melon.playback.voicealarm.Hilt_AlarmPlayService
    public void onCreate() {
        super.onCreate();
        VoiceTrackAudioFocusHelper voiceTrackAudioFocusHelper0 = new VoiceTrackAudioFocusHelper(this, this);
        voiceTrackAudioFocusHelper0.init();
        this.setAudioFocusHelper(voiceTrackAudioFocusHelper0);
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.iloen.melon.intent.action.playservice.checkvoicetrackplay");
        c.registerReceiver(this, this.getBroadcastReceiver(), intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION", null, 4);
    }

    @Override  // androidx.lifecycle.LifecycleService
    public void onDestroy() {
        super.onDestroy();
        CoroutineScope coroutineScope0 = this.coroutineScope;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, null, 1, null);
        }
        this.coroutineScope = null;
        VoiceTrackAudioFocusHelper voiceTrackAudioFocusHelper0 = this.getAudioFocusHelper();
        if(voiceTrackAudioFocusHelper0 != null) {
            voiceTrackAudioFocusHelper0.destroy();
        }
        this.setAudioFocusHelper(null);
        this.unregisterReceiver(this.getBroadcastReceiver());
        this.playerRelease();
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void onDisplayChange(@Nullable IPlayer iPlayer0, int v, int v1) {
        VoiceAlarmPlay.super.onDisplayChange(iPlayer0, v, v1);
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onError(@Nullable IPlayer iPlayer0, int v, int v1, @Nullable String s, @Nullable Exception exception0) {
        this.setCurrentState(PlayerState.Error);
        if(this.rt < MelonSettingInfo.getPlaybackRetryCount()) {
            Track voiceAlarm$Track0 = this.voiceTrack;
            if(voiceAlarm$Track0 != null) {
                ++this.rt;
                q.d(voiceAlarm$Track0);
                this.requestVoiceTrackPlay(voiceAlarm$Track0);
                return;
            }
        }
        this.rt = 0;
        this.requestPlayMusic();
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void onPcm(@Nullable IPlayer iPlayer0, @Nullable byte[] arr_b, int v, int v1, int v2, int v3) {
        VoiceAlarmPlay.super.onPcm(iPlayer0, arr_b, v, v1, v2, v3);
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void onPlaybackPositionUpdate(int v, int v1, @NotNull String s) {
        q.g(s, "trackId");
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void onPlaybackStart(@NotNull String s) {
        q.g(s, "trackId");
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void onPlaybackStop(@NotNull String s) {
        q.g(s, "trackId");
    }

    @Override  // com.iloen.melon.playback.IPlayerEventListener
    public void onPrepared(@Nullable IPlayer iPlayer0) {
        VoiceTrackAudioFocusHelper voiceTrackAudioFocusHelper0 = this.getAudioFocusHelper();
        Integer integer0 = voiceTrackAudioFocusHelper0 == null ? null : voiceTrackAudioFocusHelper0.requestFocus();
        if(integer0 != null && ((int)integer0) == 1) {
            this.setCurrentState(PlayerState.Prepared);
            if(iPlayer0 != null) {
                iPlayer0.play();
            }
            this.sendIsPlayingBroadCast();
            return;
        }
        LogU.debug$default(this.log, "AudioFocus is not granted", null, false, 6, null);
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void onSeekComplete(@Nullable IPlayer iPlayer0) {
        VoiceAlarmPlay.super.onSeekComplete(iPlayer0);
    }

    @Override  // androidx.lifecycle.LifecycleService
    public int onStartCommand(@Nullable Intent intent0, int v, int v1) {
        String s;
        d d0;
        LogU.debug$default(this.log, "onStartCommand() intent: " + intent0, null, false, 6, null);
        Job job0 = null;
        if(q.b((intent0 == null ? null : intent0.getAction()), "com.iloen.melon.intent.action.ALARM_STOP")) {
            this.stopPlay();
            this.sendIsPlayingBroadCast();
            this.stopForeground(1);
            this.stopSelf();
            return super.onStartCommand(intent0, v, v1);
        }
        if(intent0 == null) {
            d0 = null;
        }
        else {
            MusicAlarmParcelable musicAlarmParcelable0 = (MusicAlarmParcelable)F.w(intent0, "com.iloen.melon.intent.extra.musicalarm", MusicAlarmParcelable.class);
            d0 = musicAlarmParcelable0 == null ? null : e.h(musicAlarmParcelable0);
        }
        d5.t.n();
        if(d0 == null) {
            s = "알람이 울렸습니다.";
            q.f("알람이 울렸습니다.", "getString(...)");
        }
        else {
            s = e.a(d0);
        }
        Notification notification0 = this.getAlarmNotificationManager().a(s);
        if(notification0 != null) {
            ServiceUtilKt.startForegroundMediaPlayback(this, 13001, notification0);
        }
        if(d0 != null) {
            ToastManager.show(e.a(d0));
        }
        MusicAlarmPrefsHelper musicAlarmPrefsHelper0 = MusicAlarmPrefsHelper.INSTANCE;
        if(!musicAlarmPrefsHelper0.isSendMusicAlarmListLog()) {
            musicAlarmPrefsHelper0.sendMusicAlarmListLog();
        }
        LogU.debug$default(this.log, "onStartCommand() musicAlarm: " + d0, null, false, 6, null);
        if((d0 == null ? null : d0.m) == null) {
            this.requestPlayMusic();
            return super.onStartCommand(intent0, v, v1);
        }
        CoroutineScope coroutineScope0 = this.coroutineScope;
        if(coroutineScope0 != null) {
            CoroutineScopeKt.cancel$default(coroutineScope0, null, 1, null);
        }
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.rt = 0;
        Track voiceAlarm$Track0 = d0.m;
        if(voiceAlarm$Track0 == null) {
            this.requestPlayMusic();
        }
        else {
            String s1 = voiceAlarm$Track0.getTrackId();
            CoroutineScope coroutineScope1 = this.coroutineScope;
            if(coroutineScope1 != null) {
                job0 = BuildersKt__Builders_commonKt.launch$default(coroutineScope1, null, null, new n(this, s, voiceAlarm$Track0, null) {
                    final String $notiMsg;
                    final Track $track;
                    final String $trackId;
                    int label;

                    {
                        this.$trackId = s;
                        AlarmPlayService.this = alarmPlayService0;
                        this.$notiMsg = s1;
                        this.$track = voiceAlarm$Track0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.playback.voicealarm.AlarmPlayService.onStartCommand.3.1(this.$trackId, AlarmPlayService.this, this.$notiMsg, this.$track, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.playback.voicealarm.AlarmPlayService.onStartCommand.3.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        String s4;
                        TrackDto voiceAlarm$TrackDto0;
                        ne.a a0 = ne.a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                try {
                                    MelonAppBase.Companion.getClass();
                                    S s0 = (S)((o)(((l)w.s(t.a().getContext(), l.class)))).S.get();
                                    String s1 = u.v(((e0)va.o.a()).j());
                                    this.label = 1;
                                    object0 = s0.b(s1, this.$trackId, this);
                                    if(object0 == a0) {
                                        return a0;
                                    label_11:
                                        d5.n.D(object0);
                                    }
                                    VoiceAlarmAlbumTracksRes voiceAlarmAlbumTracksRes0 = (VoiceAlarmAlbumTracksRes)ApiResultKt.getOrThrow(((ApiResult)object0));
                                    Response voiceAlarmAlbumTracksRes$Response0 = voiceAlarmAlbumTracksRes0.getResponse();
                                    String s2 = null;
                                    if(voiceAlarmAlbumTracksRes$Response0 == null) {
                                        voiceAlarm$TrackDto0 = null;
                                    }
                                    else {
                                        List list0 = voiceAlarmAlbumTracksRes$Response0.getTrackList();
                                        voiceAlarm$TrackDto0 = list0 == null ? null : ((TrackDto)list0.get(0));
                                    }
                                    if(voiceAlarm$TrackDto0 != null && q.b(voiceAlarm$TrackDto0.getStatus(), "0")) {
                                        o8.a a1 = AlarmPlayService.this.getAlarmNotificationManager();
                                        String s3 = e.e(this.$track);
                                        Notification notification0 = a1.a(this.$notiMsg + "(" + s3 + ")");
                                        if(notification0 != null) {
                                            ServiceUtilKt.startForegroundMediaPlayback(AlarmPlayService.this, 13001, notification0);
                                        }
                                        AlarmPlayService.this.voiceTrack = this.$track;
                                        AlarmPlayService.this.requestVoiceTrackPlay(this.$track);
                                        return H.a;
                                    }
                                    if(voiceAlarm$TrackDto0 == null) {
                                        s4 = "상품 이용기간이 종료되었습니다.";
                                        q.f("상품 이용기간이 종료되었습니다.", "getString(...)");
                                    }
                                    else {
                                        s4 = voiceAlarm$TrackDto0.getMessage();
                                        if(s4 == null) {
                                            s4 = "상품 이용기간이 종료되었습니다.";
                                            q.f("상품 이용기간이 종료되었습니다.", "getString(...)");
                                        }
                                    }
                                    Notification notification1 = AlarmPlayService.this.getAlarmNotificationManager().a(this.$notiMsg + "(" + s4 + ")");
                                    if(notification1 != null) {
                                        ServiceUtilKt.startForegroundMediaPlayback(AlarmPlayService.this, 13001, notification1);
                                    }
                                    com.iloen.melon.net.HttpResponse.Notification httpResponse$Notification0 = voiceAlarmAlbumTracksRes0.notification;
                                    if(httpResponse$Notification0 != null) {
                                        s2 = httpResponse$Notification0.message;
                                    }
                                    throw new Exception(s2);
                                }
                                catch(Exception exception0) {
                                    break;
                                }
                            }
                            case 1: {
                                goto label_11;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        LogU.error$default(AlarmPlayService.this.log, "getVoiceAlarmTrack() FAILED", exception0, false, 4, null);
                        if(!(exception0 instanceof CancellationException)) {
                            AlarmPlayService.this.requestPlayMusic();
                        }
                        return H.a;
                    }
                }, 3, null);
            }
            if(job0 == null) {
                this.requestPlayMusic();
                return super.onStartCommand(intent0, v, v1);
            }
        }
        return super.onStartCommand(intent0, v, v1);
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void playerInit() {
        LogU.debug$default(this.log, "playerInit()", null, false, 6, null);
        if(this.getIPlayer() != null) {
            return;
        }
        this.setIPlayer(new OemMusicPlayer());
        IPlayer iPlayer0 = this.getIPlayer();
        if(iPlayer0 != null) {
            iPlayer0.initialize(this);
        }
        this.setCurrentState(PlayerState.Idle);
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void playerRelease() {
        if(this.getIPlayer() == null) {
            return;
        }
        IPlayer iPlayer0 = this.getIPlayer();
        if(iPlayer0 != null) {
            iPlayer0.release();
        }
        this.setIPlayer(null);
    }

    private final void requestPlayMusic() {
        Intent intent0 = new Intent(Y.a(MelonAppBase.Companion), MelonIntentService.class);
        intent0.setAction("com.iloen.melon.intent.action.playservice.autoplay");
        ServiceUtilKt.startForegroundServiceWithLog(this, intent0, "AlarmPlayService - playback failed");
    }

    private final void requestVoiceTrackPlay(Track voiceAlarm$Track0) {
        LogU.debug$default(this.log, "requestVoiceTrackPlay() voiceTrack: " + voiceAlarm$Track0, null, false, 6, null);
        this.stopPlay();
        VoiceTrackAudioFocusHelper voiceTrackAudioFocusHelper0 = this.getAudioFocusHelper();
        if(voiceTrackAudioFocusHelper0 != null && voiceTrackAudioFocusHelper0.isCallState()) {
            ToastManager.showShort(0x7F130796);  // string:not_play_on_busy "통화중에는 재생할 수 없습니다."
            return;
        }
        this.playerInit();
        this.getAlarmPath(voiceAlarm$Track0, new B(this, 20));
    }

    private static final H requestVoiceTrackPlay$lambda$8(AlarmPlayService alarmPlayService0, StreamGetPathRes streamGetPathRes0) {
        q.g(streamGetPathRes0, "res");
        alarmPlayService0.completeGetPath(streamGetPathRes0);
        return H.a;
    }

    private final void sendIsPlayingBroadCast() {
        Intent intent0 = new Intent();
        Q1.c.Z(intent0, "com.iloen.melon.intent.action.playservice.isvoicetrackplay", 2);
        intent0.putExtra("isVoiceTrackPlaying", this.isPlaying());
        IntentUtils.sendBroadcast(this, intent0);
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void setAudioFocusHelper(@Nullable VoiceTrackAudioFocusHelper voiceTrackAudioFocusHelper0) {
        this.audioFocusHelper = voiceTrackAudioFocusHelper0;
    }

    public final void setCoroutineScope(@Nullable CoroutineScope coroutineScope0) {
        this.coroutineScope = coroutineScope0;
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void setCurrentState(@NotNull PlayerState playerState0) {
        q.g(playerState0, "<set-?>");
        this.currentState = playerState0;
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void setIPlayer(@Nullable IPlayer iPlayer0) {
        this.iPlayer = iPlayer0;
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void startPrepare(@NotNull String s) {
        q.g(s, "url");
        LogU.debug$default(this.log, "startPrepare() url: " + s, null, false, 6, null);
        if(this.getCurrentState() != PlayerState.Idle && this.getCurrentState() != PlayerState.Stopped && this.getCurrentState() != PlayerState.PlaybackCompleted) {
            return;
        }
        IPlayer iPlayer0 = this.getIPlayer();
        if(iPlayer0 != null) {
            iPlayer0.setData(Uri.parse(s));
        }
        this.setCurrentState(PlayerState.Preparing);
    }

    @Override  // com.iloen.melon.playback.voicealarm.VoiceAlarmPlay
    public void stopPlay() {
        LogU.debug$default(this.log, "stopPlay()", null, false, 6, null);
        IPlayer iPlayer0 = this.getIPlayer();
        if(iPlayer0 != null) {
            iPlayer0.stop();
        }
        this.setCurrentState(PlayerState.Stopped);
        this.playerRelease();
    }
}

