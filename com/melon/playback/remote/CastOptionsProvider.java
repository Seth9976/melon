package com.melon.playback.remote;

import android.content.Context;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.media.CastMediaOptions.Builder;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.iloen.melon.utils.MelonSettingInfo;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0017J\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\u000B"}, d2 = {"Lcom/melon/playback/remote/CastOptionsProvider;", "Lcom/google/android/gms/cast/framework/OptionsProvider;", "<init>", "()V", "getCastOptions", "Lcom/google/android/gms/cast/framework/CastOptions;", "context", "Landroid/content/Context;", "getAdditionalSessionProviders", "", "Lcom/google/android/gms/cast/framework/SessionProvider;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CastOptionsProvider implements OptionsProvider {
    @Override  // com.google.android.gms.cast.framework.OptionsProvider
    @NotNull
    public List getAdditionalSessionProviders(@NotNull Context context0) {
        q.g(context0, "context");
        return w.a;
    }

    @Override  // com.google.android.gms.cast.framework.OptionsProvider
    @NotNull
    public CastOptions getCastOptions(@NotNull Context context0) {
        q.g(context0, "context");
        CastMediaOptions castMediaOptions0 = new Builder().setMediaSessionEnabled(false).build();
        q.f(castMediaOptions0, "build(...)");
        CastOptions castOptions0 = new com.google.android.gms.cast.framework.CastOptions.Builder().setResumeSavedSession(false).setReceiverApplicationId(context0.getString((MelonSettingInfo.getGoogleCastDebugEnable() ? 0x7F130488 : 0x7F13048A))).setStopReceiverApplicationWhenEndingSession(true).setRemoteToLocalEnabled(true).setLaunchOptions(new com.google.android.gms.cast.LaunchOptions.Builder().setRelaunchIfRunning(true).build()).setCastMediaOptions(castMediaOptions0).build();  // string:googlecast_debug_melon_receiver_id "1EE2A640"
        q.f(castOptions0, "build(...)");
        return castOptions0;
    }
}

