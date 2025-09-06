package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import java.util.Arrays;

@TargetApi(21)
public final class AudioCapabilities {
    public static final AudioCapabilities DEFAULT_AUDIO_CAPABILITIES = null;
    private static final int DEFAULT_MAX_CHANNEL_COUNT = 8;
    private static final AudioCapabilities EXTERNAL_SURROUND_SOUND_CAPABILITIES = null;
    private static final String EXTERNAL_SURROUND_SOUND_KEY = "external_surround_sound_enabled";
    private final int maxChannelCount;
    private final int[] supportedEncodings;

    static {
        AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES = new AudioCapabilities(new int[]{2}, 8);
        AudioCapabilities.EXTERNAL_SURROUND_SOUND_CAPABILITIES = new AudioCapabilities(new int[]{2, 5, 6}, 8);
    }

    public AudioCapabilities(int[] arr_v, int v) {
        if(arr_v == null) {
            this.supportedEncodings = new int[0];
        }
        else {
            int[] arr_v1 = Arrays.copyOf(arr_v, arr_v.length);
            this.supportedEncodings = arr_v1;
            Arrays.sort(arr_v1);
        }
        this.maxChannelCount = v;
    }

    private static boolean deviceMaySetExternalSurroundSoundGlobalSetting() [...] // 潜在的解密器

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof AudioCapabilities ? Arrays.equals(this.supportedEncodings, ((AudioCapabilities)object0).supportedEncodings) && this.maxChannelCount == ((AudioCapabilities)object0).maxChannelCount : false;
    }

    public static AudioCapabilities getCapabilities(Context context0) {
        return AudioCapabilities.getCapabilities(context0, context0.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")));
    }

    // 去混淆评级： 低(30)
    @SuppressLint({"InlinedApi"})
    public static AudioCapabilities getCapabilities(Context context0, Intent intent0) {
        return intent0 == null || intent0.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0 ? AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES : new AudioCapabilities(intent0.getIntArrayExtra("android.media.extra.ENCODINGS"), intent0.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 8));
    }

    // 去混淆评级： 低(40)
    public static Uri getExternalSurroundSoundGlobalSettingUri() {
        return null;
    }

    public int getMaxChannelCount() {
        return this.maxChannelCount;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.supportedEncodings) * 0x1F + this.maxChannelCount;
    }

    public boolean supportsEncoding(int v) {
        return Arrays.binarySearch(this.supportedEncodings, v) >= 0;
    }

    @Override
    public String toString() {
        String s = Arrays.toString(this.supportedEncodings);
        return "AudioCapabilities[maxChannelCount=" + this.maxChannelCount + ", supportedEncodings=" + s + "]";
    }
}

