package com.iloen.melon.utils;

import A8.b;
import android.content.Context;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.constants.AppVersionInfo;
import com.iloen.melon.constants.ListKeepOption;
import com.iloen.melon.utils.cipher.MelonCryptoManager;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.log.error.ErrorReport;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.AndroidSettings;
import com.iloen.melon.utils.system.AppUtils;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import k8.o;
import kotlin.jvm.internal.q;
import ob.z;
import p9.e;
import u9.c;

public class MelonSettingInfo {
    public static AddPosition a;
    public static AddPosition b;
    public static AddPosition c;
    public static ListKeepOption d;
    public static boolean e;
    public static AppVersionInfo f;
    public static final boolean[] g;

    static {
        MelonSettingInfo.g = new boolean[7];
    }

    public static AppVersionInfo getAppVersionInfo() {
        return MelonSettingInfo.f;
    }

    public static int getAudioLoudnessType() {
        return MelonPrefs.getInstance().getInt("GAUDIO_LOUDNESS_TYPE", 3);
    }

    public static float getAudioTargetLoudness() {
        return MelonPrefs.getInstance().getFloat("GAUDIO_TARGET_LOUDNESS", -14.0f);
    }

    public static Set getAutoPlayCheckValue() {
        return MelonPrefs.getInstance().getStringSet("AutoPlayCheckValue", new HashSet());
    }

    public static long getAutoPlayTime() {
        return MelonPrefs.getInstance().getLong("AutoPlayTime", 0L);
    }

    public static int getAutoPlayVolume() {
        return MelonPrefs.getInstance().getInt("AutoPlayVolume", 0);
    }

    public static boolean[] getAutoPlayWeekSetting() {
        return MelonSettingInfo.g;
    }

    public static String getCacheStorageType() {
        return MelonPrefs.getInstance().getString("CacheStorageType", "1GB");
    }

    public static int getCdStreamingType() {
        return MelonPrefs.getInstance().getInt("CdStreamingType", 1);
    }

    public static ListKeepOption getCurrentListKeepOption() {
        return MelonSettingInfo.d;
    }

    public static AddPosition getDjPlayListAddPosition() {
        AddPosition addPosition0 = MelonSettingInfo.c;
        AddPosition addPosition1 = AddPosition.d;
        if(addPosition1 == addPosition0) {
            return addPosition1;
        }
        return AddPosition.c == addPosition0 ? AddPosition.c : AddPosition.b;
    }

    public static String getDownloadBitrate() {
        if("128K".equals(MelonPrefs.getInstance().getString("DownloadBitrate", "192K"))) {
            MelonSettingInfo.setDownloadBitrate("192K");
        }
        return MelonPrefs.getInstance().getString("DownloadBitrate", "192K");
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public static boolean getGaudioGmasterEnable() {
        return b.e() ? false : MelonPrefs.getInstance().getBoolean("GAUDIO_GMASTER_ENABLE", false);
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public static boolean getGaudioSpatialAudioEnable() {
        return b.e() ? false : MelonPrefs.getInstance().getBoolean("GAUDIO_SPATIAL_AUDIO_ENABLE", false);
    }

    // 去混淆评级： 低(20)
    public static boolean getGoogleCastDebugEnable() {
        return b.e() ? false : MelonPrefs.getInstance().getBoolean("GOOGLECAST_DEBUG_ENABLE", false);
    }

    public static int getLaboratoryFloatingLyricAlpha() {
        return MelonPrefs.getInstance().getInt("FloatingLyricTransparency", 30);
    }

    public static int getLaboratoryFloatingLyricFontIndex() {
        return MelonPrefs.getInstance().getInt("FloatingLyricFontIndex", 0);
    }

    @Deprecated
    public static float getLaboratoryFloatingLyricFontSize() {
        return MelonPrefs.getInstance().getFloat("FloatingLyricFontSize", 13.0f);
    }

    public static int getLaboratoryFloatingLyricSkinType() {
        return MelonPrefs.getInstance().getInt("FloatingLyricSkin", 0);
    }

    public static String getLastOpenedFolder() {
        File file0 = c.c();
        return MelonPrefs.getInstance().getString("LastOpenedFolder", FileUtils.getSafetyPath(file0) + "/");
    }

    public static boolean getLeakCanaryMode() {
        return MelonPrefs.getInstance().getBoolean("KEY_LEAKCANAR", false);
    }

    public static String getLine1Number() {
        String s = MelonPrefs.getInstance().getString("Line1Number", "");
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        try {
            return MelonCryptoManager.melonCrypto(0, s);
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    public static boolean getLocationPermission() {
        return MelonPrefs.getInstance().getBoolean("USER_LOCATION_PERMISSION", false);
    }

    public static int getLyricTextLevel() {
        return MelonPrefs.getInstance().getInt("lyric_text_size_level", 1);
    }

    public static boolean getMcacheNewLogicEnable() {
        return MelonPrefs.getInstance().getBoolean("MCACHE_NEW_LOGIC_ENABLE_V2", !b.e());
    }

    public static long getMelonTimer() {
        return MelonPrefs.getInstance().getLong("MelonTimer", 0L);
    }

    public static String getMusicVideoBitrate3G() {
        return MelonPrefs.getInstance().getString("MusicVideoBitrate3G", "700K");
    }

    public static String getMusicVideoBitrateWifi() {
        return MelonPrefs.getInstance().getString("MusicVideoBitrateWifi", "1M");
    }

    public static AddPosition getNormalPlayListAddPosition() {
        AddPosition addPosition0 = MelonSettingInfo.b;
        AddPosition addPosition1 = AddPosition.d;
        if(addPosition1 == addPosition0) {
            return addPosition1;
        }
        return AddPosition.c == addPosition0 ? AddPosition.c : AddPosition.b;
    }

    public static String getOfflineMemberKey() {
        return MelonPrefs.getInstance().getString("MemberKey", "");
    }

    public static AddPosition getPlayListAddPosition() {
        AddPosition addPosition0 = MelonSettingInfo.a;
        AddPosition addPosition1 = AddPosition.d;
        if(addPosition1 == addPosition0) {
            return addPosition1;
        }
        return AddPosition.c == addPosition0 ? AddPosition.c : AddPosition.b;
    }

    public static int getPlaybackErrorCount() {
        return MelonPrefs.getInstance().getInt("playbackErrorCount", 3);
    }

    public static int getPlaybackRetryCount() {
        return MelonPrefs.getInstance().getInt("playbackRetryCount", 3);
    }

    public static boolean getPremiumOfflineDownloadOnlyWiFi() {
        return MelonPrefs.getInstance().getBoolean("premiumOfflineDownloadPopupOnlyWiFi", false);
    }

    public static boolean getPremiumOfflineDownloadPopupShown() {
        return MelonPrefs.getInstance().getBoolean("premiumOfflineDownloadPopupShown", false);
    }

    public static String getPremiumOfflineDownloadType() {
        return MelonPrefs.getInstance().getString("premiumOfflineDownloadType", "AAC128");
    }

    public static boolean getPushAlertMannerMode() {
        return MelonPrefs.getInstance().getBoolean("PushAlertManner", false);
    }

    public static int getSpatialStreamingType() {
        return MelonPrefs.getInstance().getInt("SpatialStreamingType", 1);
    }

    public static String getStreamingFileLte() {
        return MelonPrefs.getInstance().getString("StreamingFileLTE", "AAC");
    }

    public static String getStreamingFileWiFi() {
        return MelonPrefs.getInstance().getString("StreamingFileWiFi", "AAC128");
    }

    public static boolean getUseAutoPlayByExternal() {
        return MelonPrefs.getInstance().getBoolean("USE_AUTO_PLAY_BY_EXTERNAL", true);
    }

    public static boolean getUseDataForBgAutoPlay() {
        return MelonPrefs.getInstance().getBoolean("dataForBackgroundAutoPlay", true);
    }

    public static boolean getUseMarketingPushAlert() {
        return MelonPrefs.getInstance().getBoolean("UseMarketingPushAlert", false);
    }

    public static boolean getUsePushAlert() {
        return MelonPrefs.getInstance().getBoolean("UsePushAlert", true);
    }

    public static boolean getUseRemoveDuplicatedPlaylist() {
        return MelonPrefs.getInstance().getBoolean("USE_REMOVE_DUPLICATED_PLAYLIST", false);
    }

    public static boolean getUseWifiForBgAutoPlay() {
        return MelonPrefs.getInstance().getBoolean("wifiForBackgroundAutoPlay", true);
    }

    public static String getVirtualMin() {
        return MelonPrefs.getInstance().getString("virtualMin", "");
    }

    public static boolean getWebViewContentsDebugging() {
        return MelonPrefs.getInstance().getBoolean("webViewContentsDebugging", b.a().equalsIgnoreCase("DEBUG"));
    }

    public static int incrementAndGetPushNotificationId() {
        int v = 501;
        int v1 = MelonPrefs.getInstance().getInt("PUSH_NOTIFICATION_ID", 501);
        MelonPrefs melonPrefs0 = MelonPrefs.getInstance();
        if(v1 + 1 <= 599) {
            v = v1 + 1;
        }
        melonPrefs0.setInt("PUSH_NOTIFICATION_ID", v);
        return v1;
    }

    public static boolean isAllWeekRepeatAutoPlay() {
        return MelonPrefs.getInstance().getBoolean("AutoPlayPlayAllWeekRepeat", false);
    }

    public static boolean isAudioLoudnessTransparentMode() {
        return MelonPrefs.getInstance().getBoolean("GAUDIO_LOUDNESS_TRANSPARENT_MODE", false);
    }

    public static boolean isBlockIapConfirmRequest() {
        return MelonPrefs.getInstance().getBoolean("BLOCK_IAP_CONFIRM_REQEUST", false);
    }

    @Deprecated
    public static boolean isBlockRemoteConnection() {
        return MelonPrefs.getInstance().getBoolean("BLOCK_REMOTE_CONNECTION", true);
    }

    public static boolean isBlockedAutoPlayByExternal(Context context0) {
        if(!MelonSettingInfo.getUseAutoPlayByExternal()) {
            q.g(context0, "context");
            Context context1 = context0.getApplicationContext();
            q.d(context1);
            z z0 = ((o)(((Ma.o)com.google.firebase.b.B(context1, Ma.o.class)))).k();
            return z0.d(z0.c.a()).c.isEmpty();
        }
        return false;
    }

    public static boolean isEqualizerStatusOn() {
        return MelonPrefs.getInstance().getInt("EqualizerStatus", 0) == 2;
    }

    public static boolean isForceOfflineProductExpired() {
        return MelonPrefs.getInstance().getBoolean("forceOfflineProductExpired", false);
    }

    public static boolean isIgnoreAutoTimeCheck() {
        return MelonPrefs.getInstance().getBoolean("ignoreAutoTimeCheck", false);
    }

    public static boolean isKeepAudioFocus() {
        return MelonPrefs.getInstance().getBoolean("KEEP_AUDIO_FOCUS", false);
    }

    public static boolean isKeepScreenOnDuringPlayback() {
        return MelonPrefs.getInstance().getBoolean("KEEP_SCREEN_ON_DURING_PLAYBACK", false);
    }

    public static boolean isLowMemoryMode() {
        return MelonPrefs.getInstance().getBoolean("USE_LOW_MEMORY_MODE", false);
    }

    @Deprecated
    public static boolean isMVDialogCheck() {
        return MelonPrefs.getInstance().getBoolean("MVPopupHidden", false);
    }

    public static boolean isOfflineModeNP() {
        return MelonPrefs.getInstance().getBoolean("premiumOfflineDownloadSong", false);
    }

    public static boolean isOfflineModeSP() {
        return MelonPrefs.getInstance().getBoolean("premiumOfflineDownloadSmartPlaylist", false);
    }

    public static boolean isRepeatModeVideoAuto() {
        return MelonPrefs.getInstance().getBoolean("REPEAT_MODE_VIDEO_AUTO", false);
    }

    public static boolean isRepeatModeVideoOne() {
        return MelonPrefs.getInstance().getBoolean("REPEAT_MODE_VIDEO_ONE", false);
    }

    public static boolean isStreamCacheEnabled() {
        return MelonPrefs.getInstance().getBoolean("ApplyCaching", true);
    }

    public static boolean isUseAlbumImageBlock() {
        if(MelonPrefs.getInstance().contains("UseLaboratoryAlbumImage")) {
            MelonSettingInfo.setUseAlbumImageBlock(MelonSettingInfo.isUseLaboratoryAlbumImage());
            MelonPrefs.getInstance().removeAndCommit("UseLaboratoryAlbumImage");
        }
        return MelonPrefs.getInstance().getBoolean("USE_ALBUM_IMAGE_BLOCK", false);
    }

    public static boolean isUseAutoPlay() {
        return MelonPrefs.getInstance().getBoolean("UseAutoPlayState", false);
    }

    public static boolean isUseDataNetwork() {
        return MelonPrefs.getInstance().getBoolean("Use3g", false);
    }

    public static boolean isUseErrorReport() {
        return ErrorReport.isUseErrorReport();
    }

    public static boolean isUseHighContrastMode() {
        return MelonPrefs.getInstance().getBoolean("USE_HIGH_CONTRAST_MODE", false);
    }

    public static boolean isUseInstantPlay() {
        return MelonPrefs.getInstance().getBoolean("USE_INSTANT_PLAY", false);
    }

    public static boolean isUseLaboratoryAlbumImage() {
        return MelonPrefs.getInstance().getBoolean("UseLaboratoryAlbumImage", false);
    }

    public static boolean isUseLaboratoryFloatingLyric() {
        return AndroidSettings.canDrawOverlays() ? MelonPrefs.getInstance().getBoolean("FloatingLyricUse", false) : false;
    }

    public static boolean isUseLockScreen() {
        return AndroidSettings.canDrawOverlays() ? MelonPrefs.getInstance().getBoolean("UseLockScreen", true) : false;
    }

    public static boolean isUseSpatialStreaming() {
        return MelonPrefs.getInstance().getBoolean("UseSpatialStreaming", false);
    }

    public static void loadSettings(Context context0) {
        int v1 = MelonPrefs.getInstance().getInt("PrefUpgradeVersion", 0);
        Z.r(v1, "upgradePrefs() version:", "MelonSettingInfo");
        if(4 > v1) {
            LogU.d("MelonSettingInfo", "upgradePrefs() versionCode:" + AppUtils.getVersionCode(context0));
            String s = MelonPrefs.getInstance().getString("MusicVideoBitrate3G", "700K");
            LogU.d("MelonSettingInfo", "upgradePrefs() - MusicVideo(3G) : " + s);
            if("500K".equals(s)) {
                MelonPrefs.getInstance().setString("MusicVideoBitrate3G", "700K");
            }
            String s1 = MelonPrefs.getInstance().getString("MusicVideoBitrateWifi", "1M");
            LogU.d("MelonSettingInfo", "upgradePrefs() - MusicVideo(WiFi) : " + s1);
            if("500K".equals(s1)) {
                MelonPrefs.getInstance().setString("MusicVideoBitrateWifi", "700K");
            }
            if(v1 < 3 && MelonPrefs.getInstance().contains("StreamingFileWiFi")) {
                MelonSettingInfo.setStreamingFileWiFi("AAC128");
            }
            if(v1 < 4 && MelonPrefs.getInstance().contains("NOTIFICATION_REMAIN_TIME")) {
                int v2 = MelonPrefs.getInstance().getInt("NOTIFICATION_REMAIN_TIME", 1);
                MelonSettingInfo.setNotificationExposureTime(TimeUnit.MILLISECONDS.convert(((long)v2), TimeUnit.MINUTES));
                MelonPrefs.getInstance().removeAndCommit("NOTIFICATION_REMAIN_TIME");
            }
            MelonPrefs.getInstance().setInt("PrefUpgradeVersion", 4);
        }
        if(MelonPrefs.getInstance().contains("StreamingFile")) {
            String s2 = MelonPrefs.getInstance().getString("StreamingFile", "AAC");
            MelonPrefs.getInstance().removeAndCommit("StreamingFile");
            LogU.d("MelonSettingInfo", "upgradePrefs() streaming quality file: " + s2);
            if("HD".equalsIgnoreCase(s2) || "HQ".equalsIgnoreCase(s2)) {
                MelonSettingInfo.setStreamingFileLte("MP3320");
            }
            else if("MP3".equalsIgnoreCase(s2)) {
                MelonSettingInfo.setStreamingFileLte("AAC128");
            }
            else {
                MelonSettingInfo.setStreamingFileLte("AAC");
            }
        }
        MelonPrefs melonPrefs0 = MelonPrefs.getInstance();
        MelonSettingInfo.a = AddPosition.a(melonPrefs0.getString("PlayListAddPosition", "add_first"));
        MelonSettingInfo.b = AddPosition.a(melonPrefs0.getString("NormalPlayListAddPosition", "add_first"));
        MelonSettingInfo.c = AddPosition.a(melonPrefs0.getString("DjPlayListAddPosition", "add_first"));
        String s3 = melonPrefs0.getString("PlayListKeepOption", "oldlist_keep");
        if(s3 != null) {
            ListKeepOption[] arr_listKeepOption = ListKeepOption.values();
            int v3 = 0;
            while(v3 < arr_listKeepOption.length) {
                ListKeepOption listKeepOption0 = arr_listKeepOption[v3];
                if(s3.equals(listKeepOption0.a)) {
                    try {
                        MelonSettingInfo.d = listKeepOption0;
                        if(melonPrefs0.contains("Use3g")) {
                            MelonSettingInfo.e = melonPrefs0.getBoolean("Use3g", true);
                        }
                        else {
                            MelonSettingInfo.setUseDataNetwork(true);
                        }
                    }
                    catch(Exception unused_ex) {
                        try {
                            try {
                                String s4 = melonPrefs0.getString("Use3g", "");
                                MelonSettingInfo.e = s4 == null || !s4.equals("No");
                                goto label_60;
                            }
                            catch(Exception unused_ex) {
                            }
                            MelonSettingInfo.e = true;
                        }
                        catch(Throwable throwable0) {
                            MelonSettingInfo.setUseDataNetwork(MelonSettingInfo.e);
                            throw throwable0;
                        }
                        MelonSettingInfo.setUseDataNetwork(true);
                        goto label_61;
                    label_60:
                        MelonSettingInfo.setUseDataNetwork(MelonSettingInfo.e);
                    }
                label_61:
                    String[] arr_s = melonPrefs0.getString("AutoPlayPlayWeekRepeatState", "false,false,false,false,false,false,false").split(",");
                    for(int v = 0; v < arr_s.length; ++v) {
                        MelonSettingInfo.g[v] = arr_s[v].equals("true");
                    }
                    return;
                }
                ++v3;
            }
        }
        throw new IllegalArgumentException("undefined enum value: " + s3);
    }

    public static void setAppVersionInfo(AppVersionInfo appVersionInfo0) {
        MelonSettingInfo.f = appVersionInfo0;
    }

    public static void setAudioLoudnessTransparentMode(boolean z) {
        MelonPrefs.getInstance().setBoolean("GAUDIO_LOUDNESS_TRANSPARENT_MODE", z);
    }

    public static void setAudioLoudnessType(int v) {
        MelonPrefs.getInstance().setInt("GAUDIO_LOUDNESS_TYPE", v);
    }

    public static void setAudioTargetLoudness(float f) {
        MelonPrefs.getInstance().setFloat("GAUDIO_TARGET_LOUDNESS", f);
    }

    public static void setBlockIapConfirmRequest(boolean z) {
        MelonPrefs.getInstance().setBoolean("BLOCK_IAP_CONFIRM_REQEUST", z);
    }

    public static void setCacheStorageType(String s) {
        MelonPrefs.getInstance().setString("CacheStorageType", s);
    }

    public static void setCdStreamingType(int v) {
        MelonPrefs.getInstance().setInt("CdStreamingType", v);
    }

    public static void setCurrentListKeepOption(ListKeepOption listKeepOption0) {
        MelonSettingInfo.d = listKeepOption0;
        MelonPrefs.getInstance().setString("PlayListKeepOption", MelonSettingInfo.d.a);
    }

    public static void setDjPlayListAddPosition(AddPosition addPosition0) {
        MelonSettingInfo.c = addPosition0;
        MelonPrefs.getInstance().setString("DjPlayListAddPosition", MelonSettingInfo.c.a);
    }

    public static void setDownloadBitrate(String s) {
        MelonPrefs.getInstance().setString("DownloadBitrate", s);
    }

    public static void setEqualizerStatusOn(boolean z) {
        MelonPrefs.getInstance().setInt("EqualizerStatus", (z ? 2 : 0));
    }

    public static void setForceOfflineProductExpired(boolean z) {
        MelonPrefs.getInstance().setBoolean("forceOfflineProductExpired", z);
    }

    @Deprecated
    public static void setGaudioGmasterEnable(boolean z) {
        MelonPrefs.getInstance().setBoolean("GAUDIO_GMASTER_ENABLE", z);
    }

    @Deprecated
    public static void setGaudioSpatialAudioEnable(boolean z) {
        MelonPrefs.getInstance().setBoolean("GAUDIO_SPATIAL_AUDIO_ENABLE", z);
    }

    public static void setGoogleCastDebugEnable(boolean z) {
        MelonPrefs.getInstance().setBoolean("GOOGLECAST_DEBUG_ENABLE", z);
    }

    public static void setIgnoreAutoTimeCheck(boolean z) {
        MelonPrefs.getInstance().setBoolean("ignoreAutoTimeCheck", z);
    }

    public static void setKeepAudioFocus(boolean z) {
        MelonPrefs.getInstance().setBoolean("KEEP_AUDIO_FOCUS", z);
    }

    public static void setKeepScreenOnDuringPlayback(boolean z) {
        MelonPrefs.getInstance().setBoolean("KEEP_SCREEN_ON_DURING_PLAYBACK", z);
    }

    public static void setLaboratoryFloatingLyricAlpha(int v) {
        MelonPrefs.getInstance().setInt("FloatingLyricTransparency", v);
    }

    public static void setLaboratoryFloatingLyricFontIndex(int v) {
        MelonPrefs.getInstance().setInt("FloatingLyricFontIndex", v);
    }

    public static void setLaboratoryFloatingLyricSkinType(int v) {
        MelonPrefs.getInstance().setInt("FloatingLyricSkin", v);
    }

    public static void setLastOpenedFolder(String s) {
        MelonPrefs.getInstance().setString("LastOpenedFolder", s);
    }

    public static void setLeakCanaryMode(boolean z) {
        MelonPrefs.getInstance().setBoolean("KEY_LEAKCANAR", z);
    }

    public static void setLine1Number(String s) {
        try {
            String s1 = MelonCryptoManager.melonCrypto(1, s);
            if(!TextUtils.isEmpty(s1)) {
                MelonPrefs.getInstance().setString("Line1Number", s1);
            }
        }
        catch(Exception unused_ex) {
        }
    }

    public static void setLowMemoryMode(boolean z) {
        MelonPrefs.getInstance().setBoolean("USE_LOW_MEMORY_MODE", z);
    }

    public static void setLyricTextLevel(int v) {
        MelonPrefs.getInstance().setInt("lyric_text_size_level", v);
    }

    @Deprecated
    public static void setMVDialogCheck(boolean z) {
        MelonPrefs.getInstance().setBoolean("MVPopupHidden", z);
    }

    public static void setMcacheNewLogicEnable(boolean z) {
        MelonPrefs.getInstance().setBoolean("MCACHE_NEW_LOGIC_ENABLE_V2", z);
    }

    public static void setMelonTimer(long v) {
        MelonPrefs.getInstance().setLong("MelonTimer", v);
    }

    public static void setMusicVideoBitrate3G(String s) {
        MelonPrefs.getInstance().setString("MusicVideoBitrate3G", s);
    }

    public static void setMusicVideoBitrateWifi(String s) {
        MelonPrefs.getInstance().setString("MusicVideoBitrateWifi", s);
    }

    public static void setNormalPlayListAddPosition(AddPosition addPosition0) {
        MelonSettingInfo.b = addPosition0;
        MelonPrefs.getInstance().setString("NormalPlayListAddPosition", MelonSettingInfo.b.a);
    }

    public static void setNotificationExposureTime(long v) {
        MelonPrefs.getInstance().setLong("NOTIFICATION_PLAYER_EXPOSURE_TIME", v);
    }

    public static void setOfflineMemberKey(String s) {
        MelonPrefs.getInstance().setString("MemberKey", s);
    }

    public static void setOfflineModeNP(boolean z) {
        MelonPrefs.getInstance().setBoolean("premiumOfflineDownloadSong", z);
    }

    public static void setOfflineModeSP(boolean z) {
        MelonPrefs.getInstance().setBoolean("premiumOfflineDownloadSmartPlaylist", z);
    }

    public static void setPlayListAddPosition(AddPosition addPosition0) {
        MelonSettingInfo.a = addPosition0;
        MelonPrefs.getInstance().setString("PlayListAddPosition", addPosition0.a);
    }

    public static void setPlaybackErrorCount(String s) {
        if(!TextUtils.isEmpty(s) && TextUtils.isDigitsOnly(s)) {
            MelonPrefs.getInstance().setInt("playbackErrorCount", ((int)Integer.valueOf(s)));
        }
    }

    public static void setPlaybackRetryCount(String s) {
        if(!TextUtils.isEmpty(s) && TextUtils.isDigitsOnly(s)) {
            MelonPrefs.getInstance().setInt("playbackRetryCount", ((int)Integer.valueOf(s)));
        }
    }

    public static void setPremiumOfflineDownloadOnlyWiFi(boolean z) {
        MelonPrefs.getInstance().setBoolean("premiumOfflineDownloadPopupOnlyWiFi", z);
    }

    public static void setPremiumOfflineDownloadPopupShown(boolean z) {
        MelonPrefs.getInstance().setBoolean("premiumOfflineDownloadPopupShown", z);
    }

    public static void setPushAlertMannerMode(boolean z) {
        MelonPrefs.getInstance().setBoolean("PushAlertManner", z);
        e e0 = new e();
        e0.a = 3;
        e0.execute(null);
    }

    public static void setPushAlertMannerModePref(boolean z) {
        MelonPrefs.getInstance().setBoolean("PushAlertManner", z);
    }

    public static void setRepeatModeVideoAuto(boolean z) {
        MelonPrefs.getInstance().setBoolean("REPEAT_MODE_VIDEO_AUTO", z);
    }

    public static void setRepeatModeVideoOne(boolean z) {
        MelonPrefs.getInstance().setBoolean("REPEAT_MODE_VIDEO_ONE", z);
    }

    public static void setSpatialStreamingType(int v) {
        MelonPrefs.getInstance().setInt("SpatialStreamingType", v);
    }

    public static void setStreamCacheEnabled(boolean z) {
        MelonPrefs.getInstance().setBoolean("ApplyCaching", z);
    }

    public static void setStreamingFileLte(String s) {
        MelonPrefs.getInstance().setString("StreamingFileLTE", s);
    }

    public static void setStreamingFileWiFi(String s) {
        MelonPrefs.getInstance().setString("StreamingFileWiFi", s);
    }

    public static void setUseAlbumImageBlock(boolean z) {
        MelonPrefs.getInstance().setBoolean("USE_ALBUM_IMAGE_BLOCK", z);
    }

    public static void setUseAutoPlay(boolean z) {
        MelonPrefs.getInstance().setBoolean("UseAutoPlayState", z);
    }

    public static void setUseAutoPlayByExternal(boolean z) {
        MelonPrefs.getInstance().setBoolean("USE_AUTO_PLAY_BY_EXTERNAL", z);
    }

    public static void setUseDataForBgAutoPlay(boolean z) {
        MelonPrefs.getInstance().setBoolean("dataForBackgroundAutoPlay", z);
    }

    public static void setUseDataNetwork(boolean z) {
        MelonSettingInfo.e = z;
        MelonPrefs.getInstance().setBoolean("Use3g", z);
    }

    public static void setUseErrorReport(boolean z) {
        ErrorReport.setUseErrorReport(z);
    }

    public static void setUseHighContrastMode(boolean z) {
        MelonPrefs.getInstance().setBoolean("USE_HIGH_CONTRAST_MODE", z);
    }

    public static void setUseInstantPlay(boolean z) {
        MelonPrefs.getInstance().setBoolean("USE_INSTANT_PLAY", z);
    }

    public static void setUseLaboratoryFloatingLyric(boolean z) {
        MelonPrefs.getInstance().setBoolean("FloatingLyricUse", z);
    }

    public static void setUseLockScreen(boolean z) {
        MelonPrefs.getInstance().setBoolean("UseLockScreen", z);
    }

    public static void setUseMarketingPushAlert(boolean z) {
        MelonPrefs.getInstance().setBoolean("UseMarketingPushAlert", z);
        if(!z && !MelonSettingInfo.getUsePushAlert()) {
            MelonSettingInfo.setPushAlertMannerModePref(false);
        }
        e e0 = new e();
        e0.a = 2;
        e0.execute("M");
    }

    public static void setUsePushAlert(boolean z) {
        MelonPrefs.getInstance().setBoolean("UsePushAlert", z);
        if(!z && !MelonSettingInfo.getUseMarketingPushAlert()) {
            MelonSettingInfo.setPushAlertMannerModePref(false);
        }
        e e0 = new e();
        e0.a = 2;
        e0.execute("N");
    }

    public static void setUsePushAlertPref(boolean z) {
        MelonPrefs.getInstance().setBoolean("UsePushAlert", z);
    }

    public static void setUsePushAndMarketingPushAlert(boolean z) {
        MelonPrefs.getInstance().setBoolean("UsePushAlert", z);
        MelonPrefs.getInstance().setBoolean("UseMarketingPushAlert", z);
        if(!z) {
            MelonSettingInfo.setPushAlertMannerModePref(false);
        }
        e e0 = new e();
        e0.a = 2;
        e0.execute("M");
    }

    public static void setUseRemoveDuplicatedPlaylist(boolean z) {
        MelonPrefs.getInstance().setBoolean("USE_REMOVE_DUPLICATED_PLAYLIST", z);
    }

    public static void setUseSpatialStreaming(boolean z) {
        MelonPrefs.getInstance().setBoolean("UseSpatialStreaming", z);
    }

    public static void setUseWifiForBgAutoPlay(boolean z) {
        MelonPrefs.getInstance().setBoolean("wifiForBackgroundAutoPlay", z);
    }

    public static void setVirtualMin(String s) {
        MelonPrefs.getInstance().setString("virtualMin", s);
    }

    public static void setWebViewContentsDebugging(boolean z) {
        MelonPrefs.getInstance().setBoolean("webViewContentsDebugging", z);
    }
}

