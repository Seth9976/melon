package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface Player {
    public interface AudioComponent {
        void addAudioListener(AudioListener arg1);

        void clearAuxEffectInfo();

        AudioAttributes getAudioAttributes();

        int getAudioSessionId();

        float getVolume();

        void removeAudioListener(AudioListener arg1);

        @Deprecated
        void setAudioAttributes(AudioAttributes arg1);

        void setAudioAttributes(AudioAttributes arg1, boolean arg2);

        void setAuxEffectInfo(AuxEffectInfo arg1);

        void setVolume(float arg1);
    }

    @Deprecated
    public static abstract class DefaultEventListener implements EventListener {
        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onTimelineChanged(Timeline timeline0, int v) {
            if(timeline0.getWindowCount() == 1) {
                Object object0 = timeline0.getWindow(0, new Window()).manifest;
            }
        }

        @Deprecated
        public void onTimelineChanged(Timeline timeline0, Object object0) {
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onTimelineChanged(Timeline timeline0, Object object0, int v) {
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DiscontinuityReason {
    }

    public interface EventListener {
        default void onIsPlayingChanged(boolean z) {
        }

        default void onLoadingChanged(boolean z) {
        }

        default void onPlaybackParametersChanged(PlaybackParameters playbackParameters0) {
        }

        default void onPlaybackSuppressionReasonChanged(int v) {
        }

        default void onPlayerError(ExoPlaybackException exoPlaybackException0) {
        }

        default void onPlayerStateChanged(boolean z, int v) {
        }

        default void onPositionDiscontinuity(int v) {
        }

        default void onRepeatModeChanged(int v) {
        }

        default void onSeekProcessed() {
        }

        default void onShuffleModeEnabledChanged(boolean z) {
        }

        default void onTimelineChanged(Timeline timeline0, int v) {
            this.onTimelineChanged(timeline0, (timeline0.getWindowCount() == 1 ? timeline0.getWindow(0, new Window()).manifest : null), v);
        }

        @Deprecated
        default void onTimelineChanged(Timeline timeline0, Object object0, int v) {
        }

        default void onTracksChanged(TrackGroupArray trackGroupArray0, TrackSelectionArray trackSelectionArray0) {
        }
    }

    public interface MetadataComponent {
        void addMetadataOutput(MetadataOutput arg1);

        void removeMetadataOutput(MetadataOutput arg1);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackSuppressionReason {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatMode {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public interface TextComponent {
        void addTextOutput(TextOutput arg1);

        void removeTextOutput(TextOutput arg1);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimelineChangeReason {
    }

    public interface VideoComponent {
        void addVideoListener(VideoListener arg1);

        void clearCameraMotionListener(CameraMotionListener arg1);

        void clearVideoDecoderOutputBufferRenderer();

        void clearVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer arg1);

        void clearVideoFrameMetadataListener(VideoFrameMetadataListener arg1);

        void clearVideoSurface();

        void clearVideoSurface(Surface arg1);

        void clearVideoSurfaceHolder(SurfaceHolder arg1);

        void clearVideoSurfaceView(SurfaceView arg1);

        void clearVideoTextureView(TextureView arg1);

        int getVideoScalingMode();

        void removeVideoListener(VideoListener arg1);

        void setCameraMotionListener(CameraMotionListener arg1);

        void setVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer arg1);

        void setVideoFrameMetadataListener(VideoFrameMetadataListener arg1);

        void setVideoScalingMode(int arg1);

        void setVideoSurface(Surface arg1);

        void setVideoSurfaceHolder(SurfaceHolder arg1);

        void setVideoSurfaceView(SurfaceView arg1);

        void setVideoTextureView(TextureView arg1);
    }

    public static final int DISCONTINUITY_REASON_AD_INSERTION = 3;
    public static final int DISCONTINUITY_REASON_INTERNAL = 4;
    public static final int DISCONTINUITY_REASON_PERIOD_TRANSITION = 0;
    public static final int DISCONTINUITY_REASON_SEEK = 1;
    public static final int DISCONTINUITY_REASON_SEEK_ADJUSTMENT = 2;
    public static final int PLAYBACK_SUPPRESSION_REASON_NONE = 0;
    public static final int PLAYBACK_SUPPRESSION_REASON_TRANSIENT_AUDIO_FOCUS_LOSS = 1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_OFF = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;
    public static final int TIMELINE_CHANGE_REASON_DYNAMIC = 2;
    public static final int TIMELINE_CHANGE_REASON_PREPARED = 0;
    public static final int TIMELINE_CHANGE_REASON_RESET = 1;

    void addListener(EventListener arg1);

    Looper getApplicationLooper();

    AudioComponent getAudioComponent();

    int getBufferedPercentage();

    long getBufferedPosition();

    long getContentBufferedPosition();

    long getContentDuration();

    long getContentPosition();

    int getCurrentAdGroupIndex();

    int getCurrentAdIndexInAdGroup();

    Object getCurrentManifest();

    int getCurrentPeriodIndex();

    long getCurrentPosition();

    Object getCurrentTag();

    Timeline getCurrentTimeline();

    TrackGroupArray getCurrentTrackGroups();

    TrackSelectionArray getCurrentTrackSelections();

    int getCurrentWindowIndex();

    long getDuration();

    MetadataComponent getMetadataComponent();

    int getNextWindowIndex();

    boolean getPlayWhenReady();

    ExoPlaybackException getPlaybackError();

    PlaybackParameters getPlaybackParameters();

    int getPlaybackState();

    int getPlaybackSuppressionReason();

    int getPreviousWindowIndex();

    int getRendererCount();

    int getRendererType(int arg1);

    int getRepeatMode();

    boolean getShuffleModeEnabled();

    TextComponent getTextComponent();

    long getTotalBufferedDuration();

    VideoComponent getVideoComponent();

    boolean hasNext();

    boolean hasPrevious();

    boolean isCurrentWindowDynamic();

    boolean isCurrentWindowLive();

    boolean isCurrentWindowSeekable();

    boolean isLoading();

    boolean isPlaying();

    boolean isPlayingAd();

    void next();

    void previous();

    void release();

    void removeListener(EventListener arg1);

    void seekTo(int arg1, long arg2);

    void seekTo(long arg1);

    void seekToDefaultPosition();

    void seekToDefaultPosition(int arg1);

    void setPlayWhenReady(boolean arg1);

    void setPlaybackParameters(PlaybackParameters arg1);

    void setRepeatMode(int arg1);

    void setShuffleModeEnabled(boolean arg1);

    void stop();

    void stop(boolean arg1);
}

