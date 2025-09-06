package com.iloen.melon.utils.log;

import De.I;
import Eb.b;
import Eb.h;
import H0.e;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Build;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.player.MediaCodecInfoCompat;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.melon.log.db.LogDatabase;
import com.melon.utils.system.DeviceData;
import d8.d;
import e.k;
import ie.H;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import u9.a;
import va.e0;
import va.o;
import we.n;
import z6.f;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/utils/log/DevLog;", "", "", "tag", "<init>", "(Ljava/lang/String;)V", "message", "Lie/H;", "put", "a", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DevLog {
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0007\u00A2\u0006\u0004\b\u0005\u0010\u0006J?\u0010\u0011\u001A\u00020\f2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u00020\u000F\u0012\u0004\u0012\u00020\f0\u000E\u00A2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001A\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001A\u0010\u0014R\u0014\u0010\u001B\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001B\u0010\u0014R\u0014\u0010\u001C\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u0014R\u0014\u0010\u001E\u001A\u00020\u001D8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b\u001E\u0010\u001FR\u0014\u0010!\u001A\u00020 8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b!\u0010\"R0\u0010%\u001A\u001E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040#j\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`$8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001A\u00020\'8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b(\u0010)\u00A8\u0006*"}, d2 = {"Lcom/iloen/melon/utils/log/DevLog$Companion;", "", "", "name", "Lcom/iloen/melon/utils/log/DevLog;", "get", "(Ljava/lang/String;)Lcom/iloen/melon/utils/log/DevLog;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", "targetUri", "Lkotlin/Function0;", "Lie/H;", "onComplete", "Lkotlin/Function1;", "", "onError", "writeLog", "(Landroid/content/Context;Landroid/net/Uri;Lwe/a;Lwe/k;)V", "ACCOUNT", "Ljava/lang/String;", "DCF", "DLNA", "CAST", "AUDIOFOCUS", "LOCAL_AUDIO", "AUTO_PLAY", "PLAYBACK_PROCEDURE", "MUTEX_LOCK_UTIL", "", "DEFAULT_LIMIT_SIZE", "I", "", "DURATION_ARCHIVE_DEV_LOG", "J", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "Ljava/util/HashMap;", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static Context a() {
            return Y.a(MelonAppBase.Companion);
        }

        public static final Context access$getContext(Companion devLog$Companion0) {
            devLog$Companion0.getClass();
            return Companion.a();
        }

        public static final void access$removeOldLog(Companion devLog$Companion0) {
            devLog$Companion0.getClass();
            long v = TimeUnit.DAYS.toMillis(7L);
            Context context0 = Companion.a();
            ((b)LogDatabase.c.h(context0).b.getValue()).a(System.currentTimeMillis() - v);
        }

        public static final void access$writeAppSettingInfo(Companion devLog$Companion0, BufferedWriter bufferedWriter0) {
            devLog$Companion0.getClass();
            StringBuilder stringBuilder0 = new StringBuilder("Song\n");
            stringBuilder0.append("DataNetwork: " + MelonSettingInfo.getStreamingFileLte());
            stringBuilder0.append("\n");
            stringBuilder0.append("Wifi: " + MelonSettingInfo.getStreamingFileWiFi());
            stringBuilder0.append("\n");
            String s = "WiFi/LTE";
            if(((e0)o.a()).j().getHasFlacStProd()) {
                stringBuilder0.append("FlacType: " + (MelonSettingInfo.getCdStreamingType() == 1 ? "WiFi" : "WiFi/LTE"));
                stringBuilder0.append("\n");
            }
            if(MediaCodecInfoCompat.isAc4Supported()) {
                stringBuilder0.append("SpatialUse: " + MelonSettingInfo.isUseSpatialStreaming());
                stringBuilder0.append("\n");
                if(MelonSettingInfo.getSpatialStreamingType() == 1) {
                    s = "WiFi";
                }
                stringBuilder0.append("SpatialType: " + s);
                stringBuilder0.append("\n");
            }
            stringBuilder0.append("\nPremiumPlayback\n");
            stringBuilder0.append("DownloadOnlyWiFi: " + MelonSettingInfo.getPremiumOfflineDownloadOnlyWiFi());
            stringBuilder0.append("\n\nNowPlaylist\n");
            stringBuilder0.append("AddPosition: " + MelonSettingInfo.getPlayListAddPosition());
            stringBuilder0.append("\n");
            stringBuilder0.append("UseRemoveDuplicated: " + MelonSettingInfo.getUseRemoveDuplicatedPlaylist());
            stringBuilder0.append("\n");
            stringBuilder0.append("CurrentListKeep: " + MelonSettingInfo.getCurrentListKeepOption());
            stringBuilder0.append("\n\nVideo\n");
            stringBuilder0.append("DataNetwork: " + MelonSettingInfo.getMusicVideoBitrate3G());
            stringBuilder0.append("\n");
            stringBuilder0.append("Wifi: " + MelonSettingInfo.getMusicVideoBitrateWifi());
            stringBuilder0.append("\n\nBackgroundAutoPlay\n");
            stringBuilder0.append("DataNetwork: " + MelonSettingInfo.getUseDataForBgAutoPlay());
            stringBuilder0.append("\n");
            stringBuilder0.append("Wifi: " + MelonSettingInfo.getUseWifiForBgAutoPlay());
            stringBuilder0.append("\n\n");
            stringBuilder0.append("UseLockScreen: " + MelonSettingInfo.isUseLockScreen());
            stringBuilder0.append("\n\nDownloadSong\n");
            stringBuilder0.append("DownloadBitrate: " + MelonSettingInfo.getDownloadBitrate());
            stringBuilder0.append("\n");
            if(StorageUtils.isScopedStorage()) {
                a a0 = a.c.o("dcf");
                if(a0.c()) {
                    String s1 = a0.b().getLastPathSegment();
                    if(s1 == null) {
                        s1 = "";
                    }
                    stringBuilder0.append("DownloadFolder: " + s1);
                    stringBuilder0.append("\n");
                }
                else {
                    stringBuilder0.append("DownloadFolder: No permission\n");
                }
            }
            stringBuilder0.append("\n");
            stringBuilder0.append("UseDataNetwork: " + MelonSettingInfo.isUseDataNetwork());
            stringBuilder0.append("\n\nUseCache\n");
            stringBuilder0.append("CacheEnabled: " + Ob.b.b());
            stringBuilder0.append("\n");
            stringBuilder0.append("CacheStorage: " + e.b0(Ob.b.a()));
            stringBuilder0.append("\n\nAdvance\n");
            stringBuilder0.append("KeepScreenOnDuringPlayback: " + MelonSettingInfo.isKeepScreenOnDuringPlayback());
            stringBuilder0.append("\n");
            stringBuilder0.append("AlbumImageBlock: " + MelonSettingInfo.isUseAlbumImageBlock());
            stringBuilder0.append("\n");
            stringBuilder0.append("FloatingLyric: " + MelonSettingInfo.isUseLaboratoryFloatingLyric());
            stringBuilder0.append("\n");
            stringBuilder0.append("\nLaboratory\n");
            stringBuilder0.append("InstantPlay: " + MelonSettingInfo.isUseInstantPlay());
            stringBuilder0.append("\n");
            stringBuilder0.append("ErrorReport: " + MelonSettingInfo.isUseErrorReport());
            stringBuilder0.append("\n\n");
            bufferedWriter0.write(stringBuilder0.toString());
        }

        public static final void access$writeDeviceInfo(Companion devLog$Companion0, BufferedWriter bufferedWriter0) {
            devLog$Companion0.getClass();
            StringBuilder stringBuilder0 = new StringBuilder();
            stringBuilder0.append("Model: " + Build.MODEL);
            stringBuilder0.append("\n");
            stringBuilder0.append("Release: " + Build.VERSION.RELEASE);
            stringBuilder0.append("\n");
            DevLog.Companion.getClass();
            stringBuilder0.append("AppVer: " + AppUtils.getVersionName(Companion.a()));
            stringBuilder0.append("\n");
            MelonAppBase.Companion.getClass();
            t.a().getDeviceData().getClass();
            stringBuilder0.append("DRM: " + DeviceData.d().a);
            stringBuilder0.append("\n");
            stringBuilder0.append("SKT: " + t.a().getDeviceData().f().a);
            stringBuilder0.append("\n");
            stringBuilder0.append("PowerSaveMode: " + SystemSettingUtils.isPowerSaveMode(Companion.a()));
            stringBuilder0.append("\n");
            stringBuilder0.append("IgnoringBatteryOptimizations: " + SystemSettingUtils.isIgnoringBatteryOptimizations(Companion.a()));
            stringBuilder0.append("\n");
            stringBuilder0.append("BackgroundRestricted: " + SystemSettingUtils.isBackgroundRestricted(Companion.a()));
            stringBuilder0.append("\n");
            stringBuilder0.append("AvailableBackgroundData: " + SystemSettingUtils.isAvailableBackgroundData(Companion.a()));
            stringBuilder0.append("\n");
            stringBuilder0.append("NotificationsEnabled: " + SystemSettingUtils.areNotificationsEnabled(Companion.a()));
            stringBuilder0.append("\nTalkbackEnabled(enabledPackageNames):\n");
            int v = 0;
            for(Object object0: AppUtils.INSTANCE.getAccessibilityTalkbackOnInfos()) {
                if(v >= 0) {
                    stringBuilder0.append(v + 1 + " " + ((String)object0));
                    stringBuilder0.append("\n");
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
            stringBuilder0.append("\n");
            bufferedWriter0.write(stringBuilder0.toString());
        }

        public static final void access$writeSection(Companion devLog$Companion0, BufferedWriter bufferedWriter0, String s) {
            devLog$Companion0.getClass();
            bufferedWriter0.write("------ " + s + " ------" + "\n");
        }

        @NotNull
        public final DevLog get(@NotNull String s) {
            q.g(s, "name");
            DevLog devLog0 = (DevLog)DevLog.b.get(s);
            if(devLog0 == null) {
                synchronized(this) {
                    DevLog devLog1 = (DevLog)DevLog.b.get(s);
                    if(devLog1 == null) {
                        devLog1 = new DevLog(s);
                        DevLog.b.put(s, devLog1);
                    }
                    return devLog1;
                }
            }
            return devLog0;
        }

        public final void writeLog(@NotNull Context context0, @NotNull Uri uri0, @NotNull we.a a0, @NotNull we.k k0) {
            q.g(context0, "context");
            q.g(uri0, "targetUri");
            q.g(a0, "onComplete");
            q.g(k0, "onError");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(DevLog.c), null, null, new n(uri0, k0, a0, System.currentTimeMillis(), null) {
                public final we.k B;
                public final we.a D;
                public final long E;
                public final Context r;
                public final Uri w;

                {
                    this.r = context0;
                    this.w = uri0;
                    this.B = k0;
                    this.D = a0;
                    this.E = v;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.utils.log.DevLog.Companion.writeLog.1(this.r, this.w, this.B, this.D, this.E, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.utils.log.DevLog.Companion.writeLog.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    we.k k0 = this.B;
                    d5.n.D(object0);
                    try {
                        OutputStream outputStream0 = this.r.getContentResolver().openOutputStream(this.w);
                        if(outputStream0 == null) {
                            k0.invoke(new RuntimeException("Failed to create log file."));
                            return H.a;
                        }
                        we.a a0 = this.D;
                        long v = this.E;
                        try {
                            BufferedWriter bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(outputStream0));
                            try {
                                Companion.access$writeSection(DevLog.Companion, bufferedWriter0, "device & app info");
                                Companion.access$writeDeviceInfo(DevLog.Companion, bufferedWriter0);
                                Companion.access$writeAppSettingInfo(DevLog.Companion, bufferedWriter0);
                                for(Object object1: DevLog.b.entrySet()) {
                                    String s = (String)((Map.Entry)object1).getKey();
                                    DevLog devLog0 = (DevLog)((Map.Entry)object1).getValue();
                                    Companion.access$writeSection(DevLog.Companion, bufferedWriter0, s);
                                    DevLog.access$write(devLog0, bufferedWriter0, v);
                                    bufferedWriter0.newLine();
                                }
                            }
                            catch(Throwable throwable1) {
                                d.l(bufferedWriter0, throwable1);
                                throw throwable1;
                            }
                            bufferedWriter0.close();
                            a0.invoke();
                        }
                        catch(Throwable throwable0) {
                            d.l(outputStream0, throwable0);
                            throw throwable0;
                        }
                        outputStream0.close();
                    }
                    catch(Exception exception0) {
                        H0.b.w("writeLogImpl() error : ", exception0.getMessage(), LogU.Companion, "DevLog");
                        k0.invoke(exception0);
                    }
                    return H.a;
                }
            }, 3, null);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ACCOUNT = "Account";
    @NotNull
    public static final String AUDIOFOCUS = "AudioFocus";
    @NotNull
    public static final String AUTO_PLAY = "AutoPlay";
    @NotNull
    public static final String CAST = "Cast";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String DCF = "Dcf";
    @NotNull
    public static final String DLNA = "Dlna";
    @NotNull
    public static final String LOCAL_AUDIO = "Local Audio";
    @NotNull
    public static final String MUTEX_LOCK_UTIL = "MutexLockUtil";
    @NotNull
    public static final String PLAYBACK_PROCEDURE = "Playback Procedure";
    public final String a;
    public static final HashMap b;
    public static final CoroutineDispatcher c;

    static {
        DevLog.Companion = new Companion(null);
        DevLog.b = new HashMap();
        CoroutineDispatcher coroutineDispatcher0 = Dispatchers.getIO();
        DevLog.c = coroutineDispatcher0;
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineDispatcher0), null, null, new DevLog.Companion.1(2, null), 3, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    public DevLog(@NotNull String s) {
        q.g(s, "tag");
        super();
        this.a = s;
    }

    public static final b access$getDao(DevLog devLog0) {
        devLog0.getClass();
        Context context0 = Companion.access$getContext(DevLog.Companion);
        return (b)LogDatabase.c.h(context0).b.getValue();
    }

    public static final void access$write(DevLog devLog0, BufferedWriter bufferedWriter0, long v) {
        devLog0.getClass();
        Context context0 = Companion.access$getContext(DevLog.Companion);
        f f0 = LogDatabase.c;
        b b0 = (b)f0.h(context0).b.getValue();
        String s = devLog0.a;
        int v1 = b0.d(v, s);
        for(int v2 = 0; v2 < v1 / 100 + 1; ++v2) {
            for(Object object0: ((b)f0.h(Companion.access$getContext(DevLog.Companion)).b.getValue()).c(v2, v, s)) {
                bufferedWriter0.write(I.b0(((h)object0).b) + " " + ((h)object0).c + " " + ((h)object0).d + "\n");
            }
        }
    }

    @NotNull
    public static final DevLog get(@NotNull String s) {
        return DevLog.Companion.get(s);
    }

    @NotNull
    public final String getTag() {
        return this.a;
    }

    public final void put(@NotNull String s) {
        q.g(s, "message");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(DevLog.c), null, null, new n(this, s, null) {
            public final String B;
            public final long r;
            public final DevLog w;

            {
                this.r = v;
                this.w = devLog0;
                this.B = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.log.DevLog.put.1(this.r, this.w, this.B, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.log.DevLog.put.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                d5.n.D(object0);
                String s = this.w.getTag();
                q.g(s, "tag");
                h h0 = new h(this.r, s, this.B);
                DevLog.access$getDao(this.w).b(h0);
                return H.a;
            }
        }, 3, null);
    }
}

