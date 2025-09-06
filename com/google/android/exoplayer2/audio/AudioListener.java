package com.google.android.exoplayer2.audio;

public interface AudioListener {
    default void onAudioAttributesChanged(AudioAttributes audioAttributes0) {
    }

    default void onAudioSessionId(int v) {
    }

    default void onVolumeChanged(float f) {
    }
}

