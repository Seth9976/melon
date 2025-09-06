package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;
import java.nio.ByteBuffer;

public interface AudioSink {
    public static final class ConfigurationException extends Exception {
        public ConfigurationException(String s) {
            super(s);
        }

        public ConfigurationException(Throwable throwable0) {
            super(throwable0);
        }
    }

    public static final class InitializationException extends Exception {
        public final int audioTrackState;

        public InitializationException(int v, int v1, int v2, int v3) {
            super("AudioTrack init failed: " + v + ", Config(" + v1 + ", " + v2 + ", " + v3 + ")");
            this.audioTrackState = v;
        }
    }

    public interface Listener {
        void onAudioSessionId(int arg1);

        void onPositionDiscontinuity();

        void onUnderrun(int arg1, long arg2, long arg3);
    }

    public static final class WriteException extends Exception {
        public final int errorCode;

        public WriteException(int v) {
            super("AudioTrack write failed: " + v);
            this.errorCode = v;
        }
    }

    public static final long CURRENT_POSITION_NOT_SET = 0x8000000000000000L;

    void configure(int arg1, int arg2, int arg3, int arg4, int[] arg5, int arg6, int arg7);

    void disableTunneling();

    void enableTunnelingV21(int arg1);

    void flush();

    long getCurrentPositionUs(boolean arg1);

    PlaybackParameters getPlaybackParameters();

    boolean handleBuffer(ByteBuffer arg1, long arg2);

    void handleDiscontinuity();

    boolean hasPendingData();

    boolean isEnded();

    void pause();

    void play();

    void playToEndOfStream();

    void reset();

    void setAudioAttributes(AudioAttributes arg1);

    void setAudioSessionId(int arg1);

    void setAuxEffectInfo(AuxEffectInfo arg1);

    void setListener(Listener arg1);

    void setPlaybackParameters(PlaybackParameters arg1);

    void setVolume(float arg1);

    boolean supportsOutput(int arg1, int arg2);
}

