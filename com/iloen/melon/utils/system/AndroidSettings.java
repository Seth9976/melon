package com.iloen.melon.utils.system;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings.Global;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.MelonSettingInfo;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\bR\u001A\u0010\n\u001A\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000B\u0010\f\u001A\u0004\b\n\u0010\u0004R\u001A\u0010\r\u001A\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000E\u0010\f\u001A\u0004\b\r\u0010\u0004R\u001A\u0010\u000F\u001A\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\f\u001A\u0004\b\u000F\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/utils/system/AndroidSettings;", "", "", "canDrawOverlays", "()Z", "Landroid/content/Context;", "context", "isAutoTimeChecked", "(Landroid/content/Context;)Z", "isAnimationDisabled", "isAirplaneMode", "isAirplaneMode$annotations", "()V", "isDisplayedTimeType12", "isDisplayedTimeType12$annotations", "isAutoRotation", "isAutoRotation$annotations", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AndroidSettings {
    public static final int $stable;
    @NotNull
    public static final AndroidSettings INSTANCE;

    static {
        AndroidSettings.INSTANCE = new AndroidSettings();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static final boolean canDrawOverlays() {
        MelonAppBase.Companion.getClass();
        return Settings.canDrawOverlays(t.a().getContext());
    }

    public static final boolean isAirplaneMode() {
        MelonAppBase.Companion.getClass();
        return Settings.System.getInt(t.a().getContext().getContentResolver(), "airplane_mode_on", 0) == 1;
    }

    public static void isAirplaneMode$annotations() {
    }

    public static final boolean isAnimationDisabled(@NotNull Context context0) {
        q.g(context0, "context");
        ContentResolver contentResolver0 = context0.getContentResolver();
        return Settings.Global.getFloat(contentResolver0, "animator_duration_scale", 1.0f) == 0.0f || Settings.Global.getFloat(contentResolver0, "transition_animation_scale", 1.0f) == 0.0f || Settings.Global.getFloat(contentResolver0, "window_animation_scale", 1.0f) == 0.0f;
    }

    public static final boolean isAutoRotation() {
        MelonAppBase.Companion.getClass();
        return Settings.System.getInt(t.a().getContext().getContentResolver(), "accelerometer_rotation", 0) == 1;
    }

    public static void isAutoRotation$annotations() {
    }

    public static final boolean isAutoTimeChecked(@NotNull Context context0) {
        q.g(context0, "context");
        MelonSettingInfo.isIgnoreAutoTimeCheck();
        try {
            Object object0 = context0.getSystemService("phone");
            q.e(object0, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            switch(((TelephonyManager)object0).getPhoneType()) {
                case 0: 
                case 2: {
                    break;
                }
                default: {
                    AndroidSettings.INSTANCE.getClass();
                    MelonAppBase.Companion.getClass();
                    if(Settings.System.getInt(t.a().getContext().getContentResolver(), "auto_time") <= 0) {
                        return false;
                    }
                }
            }
            return true;
        }
        catch(Settings.SettingNotFoundException unused_ex) {
            return false;
        }
    }

    public static final boolean isDisplayedTimeType12() {
        MelonAppBase.Companion.getClass();
        String s = Settings.System.getString(t.a().getContext().getContentResolver(), "time_12_24");
        return s != null && s.length() != 0 && s.equals("12");
    }

    public static void isDisplayedTimeType12$annotations() {
    }
}

