package com.iloen.melon.utils.log;

import H0.b;
import H0.e;
import U4.F;
import U4.x;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build;
import android.util.Log;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.task.ReportService.Reporter;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.AndroidSettings;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.DeviceIdentifier;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.melon.utils.system.DeviceData;
import k8.t;
import kc.d3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.a;
import y8.f;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A\u001F\u0010\u0005\u001A\u00020\u00042\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "tag", "", "reportAppPreferenceIfNeed", "(Landroid/content/Context;Ljava/lang/String;)Z", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class MelonDevReportKt {
    public static final boolean reportAppPreferenceIfNeed(@Nullable Context context0, @NotNull String s) {
        q.g(s, "tag");
        boolean z = false;
        if(context0 == null) {
            return false;
        }
        long v = System.currentTimeMillis();
        long v1 = (v - MelonPrefs.getInstance().getLong("REPORT_APP_PREFERENCE", 0L)) / 60L / 60L / 1000L;
        if(v1 < 12L) {
            LogU.Companion.d(s, b.g(v1, "reportAppPreference() gap under 12 hour. no report. gap(", ")"));
            return false;
        }
        MelonPrefs.getInstance().setLong("REPORT_APP_PREFERENCE", v);
        StringBuilder stringBuilder0 = new StringBuilder("ID: ");
        MelonAppBase.Companion.getClass();
        stringBuilder0.append(DeviceIdentifier.id(t.a().getDeviceData().a));
        Context context1 = t.a().getContext();
        if(context1 != null) {
            stringBuilder0.append(", MODEL:");
            stringBuilder0.append(Build.MODEL);
            stringBuilder0.append(", RELEASE:");
            stringBuilder0.append(Build.VERSION.RELEASE);
            stringBuilder0.append(", APPVER:");
            stringBuilder0.append(AppUtils.getVersionName(context1));
            stringBuilder0.append(", DRM:");
            t.a().getDeviceData().getClass();
            stringBuilder0.append(DeviceData.d());
            stringBuilder0.append(", SKT:");
            stringBuilder0.append(t.a().getDeviceData().f());
        }
        boolean z1 = SystemSettingUtils.isPowerSaveMode(context0);
        boolean z2 = SystemSettingUtils.isIgnoringBatteryOptimizations(context0);
        boolean z3 = SystemSettingUtils.isBackgroundRestricted(context0);
        boolean z4 = SystemSettingUtils.isAvailableBackgroundData(context0);
        boolean z5 = SystemSettingUtils.areNotificationsEnabled(context0);
        stringBuilder0.append(", isPowerSaveMode: ");
        stringBuilder0.append(z1);
        stringBuilder0.append(", IgnoreBatteryOptimizations: ");
        x.y(stringBuilder0, z2, ", isBackgroundRestricted: ", z3, ", BackgroundData: ");
        stringBuilder0.append(z4);
        stringBuilder0.append(", NotificationsEnabled: ");
        stringBuilder0.append(z5);
        stringBuilder0.append(", PlayerType: EXO, EQEnabled: ");
        stringBuilder0.append(MelonSettingInfo.isEqualizerStatusOn());
        stringBuilder0.append(", LoudnessNormalizationEnabled: ");
        if(f.b().c.loudnessType != LoudnessType.kOff) {
            z = true;
        }
        stringBuilder0.append(z);
        stringBuilder0.append(", MobileDataEnabled: ");
        stringBuilder0.append(MelonSettingInfo.isUseDataNetwork());
        stringBuilder0.append(", useSP: ");
        stringBuilder0.append(((d3)F.z(context0)).m());
        stringBuilder0.append(", AnimationDisabled: ");
        stringBuilder0.append(AndroidSettings.isAnimationDisabled(context0));
        Log.d(s, "reportDeviceInfo() " + stringBuilder0);
        Type logReportReq$Type0 = Type.APP;
        LogLevel logReportReq$LogLevel0 = LogLevel.INFO;
        Reporter reportService$Reporter0 = Reporter.createReporter(logReportReq$Type0, logReportReq$LogLevel0);
        reportService$Reporter0.setMessage(stringBuilder0.toString());
        reportService$Reporter0.report();
        StringBuilder stringBuilder1 = new StringBuilder("AddPosition: ");
        stringBuilder1.append(MelonSettingInfo.getPlayListAddPosition());
        stringBuilder1.append(", UseRemoveDuplicated: ");
        stringBuilder1.append(MelonSettingInfo.getUseRemoveDuplicatedPlaylist());
        stringBuilder1.append(", CurrentListKeep: ");
        stringBuilder1.append(MelonSettingInfo.getCurrentListKeepOption());
        stringBuilder1.append(", ");
        if(StorageUtils.isScopedStorage()) {
            a a0 = a.c.o("dcf");
            if(a0.c()) {
                stringBuilder1.append("DownloadFolder: ");
                String s1 = a0.b().getLastPathSegment();
                if(s1 == null) {
                    s1 = "";
                }
                stringBuilder1.append(s1);
                stringBuilder1.append(", ");
            }
            else {
                stringBuilder1.append("DownloadFolder: No permission, ");
            }
        }
        stringBuilder1.append("CacheEnabled: ");
        stringBuilder1.append(Ob.b.b());
        stringBuilder1.append(", CacheStorage: ");
        stringBuilder1.append(e.b0(Ob.b.a()));
        stringBuilder1.append(", KeepScreenOnDuringPlayback: ");
        stringBuilder1.append(MelonSettingInfo.isKeepScreenOnDuringPlayback());
        stringBuilder1.append(", AlbumImageBlock: ");
        stringBuilder1.append(MelonSettingInfo.isUseAlbumImageBlock());
        stringBuilder1.append(", FloatingLyric: ");
        stringBuilder1.append(MelonSettingInfo.isUseLaboratoryFloatingLyric());
        stringBuilder1.append(", KeepAudioFocus: ");
        stringBuilder1.append(MelonSettingInfo.isKeepAudioFocus());
        Log.d(s, "reportAppSettingInfo() " + stringBuilder1);
        Reporter reportService$Reporter1 = Reporter.createReporter(logReportReq$Type0, logReportReq$LogLevel0);
        reportService$Reporter1.setMessage(stringBuilder1.toString());
        reportService$Reporter1.report();
        return true;
    }
}

