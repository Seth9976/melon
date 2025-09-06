package com.iloen.melon.player.googlecast;

import android.content.Context;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions.Builder;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.iloen.melon.utils.MelonSettingInfo;
import java.util.List;

public class CastOptionsProvider implements OptionsProvider {
    @Override  // com.google.android.gms.cast.framework.OptionsProvider
    public List getAdditionalSessionProviders(Context context0) {
        return null;
    }

    @Override  // com.google.android.gms.cast.framework.OptionsProvider
    public CastOptions getCastOptions(Context context0) {
        NotificationOptions notificationOptions0 = new Builder().setTargetActivityClassName("com.iloen.melon.MusicBrowserActivity").build();
        CastMediaOptions castMediaOptions0 = new com.google.android.gms.cast.framework.media.CastMediaOptions.Builder().setNotificationOptions(notificationOptions0).setMediaSessionEnabled(false).build();
        com.google.android.gms.cast.framework.CastOptions.Builder castOptions$Builder0 = new com.google.android.gms.cast.framework.CastOptions.Builder();
        return MelonSettingInfo.getGoogleCastDebugEnable() ? castOptions$Builder0.setReceiverApplicationId("1EE2A640").setRemoteToLocalEnabled(true).setLaunchOptions(new com.google.android.gms.cast.LaunchOptions.Builder().setRelaunchIfRunning(true).build()).setCastMediaOptions(castMediaOptions0).build() : castOptions$Builder0.setReceiverApplicationId("D109AB2A").setRemoteToLocalEnabled(true).setLaunchOptions(new com.google.android.gms.cast.LaunchOptions.Builder().setRelaunchIfRunning(true).build()).setCastMediaOptions(castMediaOptions0).build();
    }
}

