package com.kakao.sdk.common.util;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.ApplicationInfoFlags;
import android.content.pm.PackageManager.ResolveInfoFlags;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.iloen.melon.playback.Actor;
import com.melon.ui.popup.AnimationPopupDialogFragment.DisplayPosition;
import java.io.Serializable;
import java.util.List;

public abstract class a {
    public static int a() {
        return MediaStore.getPickImagesMaxLimit();
    }

    public static ApplicationInfo b(PackageManager packageManager0, String s, PackageManager.ApplicationInfoFlags packageManager$ApplicationInfoFlags0) {
        return packageManager0.getApplicationInfo(s, packageManager$ApplicationInfoFlags0);
    }

    public static PackageManager.ApplicationInfoFlags c() {
        return PackageManager.ApplicationInfoFlags.of(0x80L);
    }

    public static PackageManager.ResolveInfoFlags d() {
        return PackageManager.ResolveInfoFlags.of(0x10000L);
    }

    public static ResolveInfo e(PackageManager packageManager0, Intent intent0, PackageManager.ResolveInfoFlags packageManager$ResolveInfoFlags0) {
        return packageManager0.resolveActivity(intent0, packageManager$ResolveInfoFlags0);
    }

    public static AccessibilityNodeInfo.AccessibilityAction f() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
    }

    public static OnBackInvokedDispatcher g(View view0) {
        return view0.findOnBackInvokedDispatcher();
    }

    public static Serializable h(Intent intent0) {
        return intent0.getSerializableExtra("com.iloen.melon.intent.extra.actor", Actor.class);
    }

    public static Object i(Bundle bundle0) {
        return bundle0.getParcelable("KEY_DISPLAY_POSITION", DisplayPosition.class);
    }

    public static List j(PackageManager packageManager0, Intent intent0, PackageManager.ResolveInfoFlags packageManager$ResolveInfoFlags0) {
        return packageManager0.queryIntentServices(intent0, packageManager$ResolveInfoFlags0);
    }

    public static List k(AudioManager audioManager0, AudioAttributes audioAttributes0) {
        return audioManager0.getAudioDevicesForAttributes(audioAttributes0);
    }

    public static void l(OnBackInvokedDispatcher onBackInvokedDispatcher0, int v, OnBackInvokedCallback onBackInvokedCallback0) {
        onBackInvokedDispatcher0.registerOnBackInvokedCallback(v, onBackInvokedCallback0);
    }

    public static PackageManager.ResolveInfoFlags m() {
        return PackageManager.ResolveInfoFlags.of(0L);
    }

    public static List n(AudioManager audioManager0, AudioAttributes audioAttributes0) {
        return audioManager0.getDirectProfilesForAttributes(audioAttributes0);
    }
}

