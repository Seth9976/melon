package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.TextureView;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, AudioComponent, MetadataComponent, TextComponent, VideoComponent {
    public static final class Builder {
        private AnalyticsCollector analyticsCollector;
        private BandwidthMeter bandwidthMeter;
        private boolean buildCalled;
        private Clock clock;
        private final Context context;
        private LoadControl loadControl;
        private Looper looper;
        private final RenderersFactory renderersFactory;
        private TrackSelector trackSelector;
        private boolean useLazyPreparation;

        public Builder(Context context0) {
            this(context0, new DefaultRenderersFactory(context0));
        }

        public Builder(Context context0, RenderersFactory renderersFactory0) {
            this(context0, renderersFactory0, new DefaultTrackSelector(context0), new DefaultLoadControl(), DefaultBandwidthMeter.getSingletonInstance(context0), Util.getLooper(), new AnalyticsCollector(Clock.DEFAULT), true, Clock.DEFAULT);
        }

        public Builder(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0, BandwidthMeter bandwidthMeter0, Looper looper0, AnalyticsCollector analyticsCollector0, boolean z, Clock clock0) {
            this.context = context0;
            this.renderersFactory = renderersFactory0;
            this.trackSelector = trackSelector0;
            this.loadControl = loadControl0;
            this.bandwidthMeter = bandwidthMeter0;
            this.looper = looper0;
            this.analyticsCollector = analyticsCollector0;
            this.useLazyPreparation = z;
            this.clock = clock0;
        }

        public SimpleExoPlayer build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            return new SimpleExoPlayer(this.context, this.renderersFactory, this.trackSelector, this.loadControl, this.bandwidthMeter, this.analyticsCollector, this.clock, this.looper);
        }

        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector0) {
            Assertions.checkState(!this.buildCalled);
            this.analyticsCollector = analyticsCollector0;
            return this;
        }

        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter0) {
            Assertions.checkState(!this.buildCalled);
            this.bandwidthMeter = bandwidthMeter0;
            return this;
        }

        public Builder setClock(Clock clock0) {
            Assertions.checkState(!this.buildCalled);
            this.clock = clock0;
            return this;
        }

        public Builder setLoadControl(LoadControl loadControl0) {
            Assertions.checkState(!this.buildCalled);
            this.loadControl = loadControl0;
            return this;
        }

        public Builder setLooper(Looper looper0) {
            Assertions.checkState(!this.buildCalled);
            this.looper = looper0;
            return this;
        }

        public Builder setTrackSelector(TrackSelector trackSelector0) {
            Assertions.checkState(!this.buildCalled);
            this.trackSelector = trackSelector0;
            return this;
        }

        public Builder setUseLazyPreparation(boolean z) {
            Assertions.checkState(!this.buildCalled);
            this.useLazyPreparation = z;
            return this;
        }
    }

    final class ComponentListener implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, EventListener, PlayerControl, com.google.android.exoplayer2.Player.EventListener, AudioRendererEventListener, MetadataOutput, TextOutput, VideoRendererEventListener {
        private ComponentListener() {
        }

        public ComponentListener(com.google.android.exoplayer2.SimpleExoPlayer.1 simpleExoPlayer$10) {
        }

        @Override  // com.google.android.exoplayer2.AudioFocusManager$PlayerControl
        public void executePlayerCommand(int v) {
            boolean z = SimpleExoPlayer.this.getPlayWhenReady();
            SimpleExoPlayer.this.updatePlayWhenReady(z, v);
        }

        @Override  // com.google.android.exoplayer2.AudioBecomingNoisyManager$EventListener
        public void onAudioBecomingNoisy() {
            SimpleExoPlayer.this.setPlayWhenReady(false);
        }

        @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDecoderInitialized(String s, long v, long v1) {
            for(Object object0: SimpleExoPlayer.this.audioDebugListeners) {
                ((AudioRendererEventListener)object0).onAudioDecoderInitialized(s, v, v1);
            }
        }

        @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioDisabled(DecoderCounters decoderCounters0) {
            for(Object object0: SimpleExoPlayer.this.audioDebugListeners) {
                ((AudioRendererEventListener)object0).onAudioDisabled(decoderCounters0);
            }
            SimpleExoPlayer.this.audioFormat = null;
            SimpleExoPlayer.this.audioDecoderCounters = null;
            SimpleExoPlayer.this.audioSessionId = 0;
        }

        @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioEnabled(DecoderCounters decoderCounters0) {
            SimpleExoPlayer.this.audioDecoderCounters = decoderCounters0;
            for(Object object0: SimpleExoPlayer.this.audioDebugListeners) {
                ((AudioRendererEventListener)object0).onAudioEnabled(decoderCounters0);
            }
        }

        @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioInputFormatChanged(Format format0) {
            SimpleExoPlayer.this.audioFormat = format0;
            for(Object object0: SimpleExoPlayer.this.audioDebugListeners) {
                ((AudioRendererEventListener)object0).onAudioInputFormatChanged(format0);
            }
        }

        @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSessionId(int v) {
            if(SimpleExoPlayer.this.audioSessionId != v) {
                SimpleExoPlayer.this.audioSessionId = v;
                for(Object object0: SimpleExoPlayer.this.audioListeners) {
                    AudioListener audioListener0 = (AudioListener)object0;
                    if(!SimpleExoPlayer.this.audioDebugListeners.contains(audioListener0)) {
                        audioListener0.onAudioSessionId(v);
                    }
                }
                for(Object object1: SimpleExoPlayer.this.audioDebugListeners) {
                    ((AudioRendererEventListener)object1).onAudioSessionId(v);
                }
            }
        }

        @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
        public void onAudioSinkUnderrun(int v, long v1, long v2) {
            for(Object object0: SimpleExoPlayer.this.audioDebugListeners) {
                ((AudioRendererEventListener)object0).onAudioSinkUnderrun(v, v1, v2);
            }
        }

        @Override  // com.google.android.exoplayer2.text.TextOutput
        public void onCues(List list0) {
            SimpleExoPlayer.this.currentCues = list0;
            for(Object object0: SimpleExoPlayer.this.textOutputs) {
                ((TextOutput)object0).onCues(list0);
            }
        }

        @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onDroppedFrames(int v, long v1) {
            for(Object object0: SimpleExoPlayer.this.videoDebugListeners) {
                ((VideoRendererEventListener)object0).onDroppedFrames(v, v1);
            }
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onLoadingChanged(boolean z) {
            if(SimpleExoPlayer.this.priorityTaskManager != null) {
                if(z && !SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                    SimpleExoPlayer.this.priorityTaskManager.add(0);
                    SimpleExoPlayer.this.isPriorityTaskManagerRegistered = true;
                    return;
                }
                if(!z && SimpleExoPlayer.this.isPriorityTaskManagerRegistered) {
                    SimpleExoPlayer.this.priorityTaskManager.remove(0);
                    SimpleExoPlayer.this.isPriorityTaskManagerRegistered = false;
                }
            }
        }

        @Override  // com.google.android.exoplayer2.metadata.MetadataOutput
        public void onMetadata(Metadata metadata0) {
            for(Object object0: SimpleExoPlayer.this.metadataOutputs) {
                ((MetadataOutput)object0).onMetadata(metadata0);
            }
        }

        @Override  // com.google.android.exoplayer2.Player$EventListener
        public void onPlayerStateChanged(boolean z, int v) {
            SimpleExoPlayer.this.updateWakeAndWifiLock();
        }

        @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onRenderedFirstFrame(Surface surface0) {
            if(SimpleExoPlayer.this.surface == surface0) {
                for(Object object0: SimpleExoPlayer.this.videoListeners) {
                    ((VideoListener)object0).onRenderedFirstFrame();
                }
            }
            for(Object object1: SimpleExoPlayer.this.videoDebugListeners) {
                ((VideoRendererEventListener)object1).onRenderedFirstFrame(surface0);
            }
        }

        @Override  // android.view.TextureView$SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture0, int v, int v1) {
            Surface surface0 = new Surface(surfaceTexture0);
            SimpleExoPlayer.this.setVideoSurfaceInternal(surface0, true);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(v, v1);
        }

        @Override  // android.view.TextureView$SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture0) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, true);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
            return true;
        }

        @Override  // android.view.TextureView$SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture0, int v, int v1) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(v, v1);
        }

        @Override  // android.view.TextureView$SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture0) {
        }

        @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDecoderInitialized(String s, long v, long v1) {
            for(Object object0: SimpleExoPlayer.this.videoDebugListeners) {
                ((VideoRendererEventListener)object0).onVideoDecoderInitialized(s, v, v1);
            }
        }

        @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoDisabled(DecoderCounters decoderCounters0) {
            for(Object object0: SimpleExoPlayer.this.videoDebugListeners) {
                ((VideoRendererEventListener)object0).onVideoDisabled(decoderCounters0);
            }
            SimpleExoPlayer.this.videoFormat = null;
            SimpleExoPlayer.this.videoDecoderCounters = null;
        }

        @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoEnabled(DecoderCounters decoderCounters0) {
            SimpleExoPlayer.this.videoDecoderCounters = decoderCounters0;
            for(Object object0: SimpleExoPlayer.this.videoDebugListeners) {
                ((VideoRendererEventListener)object0).onVideoEnabled(decoderCounters0);
            }
        }

        @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoInputFormatChanged(Format format0) {
            SimpleExoPlayer.this.videoFormat = format0;
            for(Object object0: SimpleExoPlayer.this.videoDebugListeners) {
                ((VideoRendererEventListener)object0).onVideoInputFormatChanged(format0);
            }
        }

        @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
        public void onVideoSizeChanged(int v, int v1, int v2, float f) {
            for(Object object0: SimpleExoPlayer.this.videoListeners) {
                VideoListener videoListener0 = (VideoListener)object0;
                if(!SimpleExoPlayer.this.videoDebugListeners.contains(videoListener0)) {
                    videoListener0.onVideoSizeChanged(v, v1, v2, f);
                }
            }
            for(Object object1: SimpleExoPlayer.this.videoDebugListeners) {
                ((VideoRendererEventListener)object1).onVideoSizeChanged(v, v1, v2, f);
            }
        }

        @Override  // com.google.android.exoplayer2.AudioFocusManager$PlayerControl
        public void setVolumeMultiplier(float f) {
            SimpleExoPlayer.this.sendVolumeToRenderers();
        }

        @Override  // android.view.SurfaceHolder$Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder0, int v, int v1, int v2) {
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(v1, v2);
        }

        @Override  // android.view.SurfaceHolder$Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder0) {
            Surface surface0 = surfaceHolder0.getSurface();
            SimpleExoPlayer.this.setVideoSurfaceInternal(surface0, false);
        }

        @Override  // android.view.SurfaceHolder$Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder0) {
            SimpleExoPlayer.this.setVideoSurfaceInternal(null, false);
            SimpleExoPlayer.this.maybeNotifySurfaceSizeChanged(0, 0);
        }
    }

    @Deprecated
    public interface com.google.android.exoplayer2.SimpleExoPlayer.VideoListener extends VideoListener {
    }

    private static final String TAG = "SimpleExoPlayer";
    private final AnalyticsCollector analyticsCollector;
    private AudioAttributes audioAttributes;
    private final AudioBecomingNoisyManager audioBecomingNoisyManager;
    private final CopyOnWriteArraySet audioDebugListeners;
    private DecoderCounters audioDecoderCounters;
    private final AudioFocusManager audioFocusManager;
    private Format audioFormat;
    private final CopyOnWriteArraySet audioListeners;
    private int audioSessionId;
    private float audioVolume;
    private final BandwidthMeter bandwidthMeter;
    private CameraMotionListener cameraMotionListener;
    private final ComponentListener componentListener;
    private List currentCues;
    private final Handler eventHandler;
    private boolean hasNotifiedFullWrongThreadWarning;
    private boolean isPriorityTaskManagerRegistered;
    private MediaSource mediaSource;
    private final CopyOnWriteArraySet metadataOutputs;
    private boolean ownsSurface;
    private final ExoPlayerImpl player;
    private boolean playerReleased;
    private PriorityTaskManager priorityTaskManager;
    protected final Renderer[] renderers;
    private Surface surface;
    private int surfaceHeight;
    private SurfaceHolder surfaceHolder;
    private int surfaceWidth;
    private final CopyOnWriteArraySet textOutputs;
    private TextureView textureView;
    private final CopyOnWriteArraySet videoDebugListeners;
    private DecoderCounters videoDecoderCounters;
    private VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer;
    private Format videoFormat;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    private final CopyOnWriteArraySet videoListeners;
    private int videoScalingMode;
    private final WakeLockManager wakeLockManager;
    private final WifiLockManager wifiLockManager;

    @Deprecated
    public SimpleExoPlayer(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0, BandwidthMeter bandwidthMeter0, AnalyticsCollector analyticsCollector0, Clock clock0, Looper looper0) {
        this.bandwidthMeter = bandwidthMeter0;
        this.analyticsCollector = analyticsCollector0;
        ComponentListener simpleExoPlayer$ComponentListener0 = new ComponentListener(this, null);
        this.componentListener = simpleExoPlayer$ComponentListener0;
        CopyOnWriteArraySet copyOnWriteArraySet0 = new CopyOnWriteArraySet();
        this.videoListeners = copyOnWriteArraySet0;
        CopyOnWriteArraySet copyOnWriteArraySet1 = new CopyOnWriteArraySet();
        this.audioListeners = copyOnWriteArraySet1;
        this.textOutputs = new CopyOnWriteArraySet();
        this.metadataOutputs = new CopyOnWriteArraySet();
        CopyOnWriteArraySet copyOnWriteArraySet2 = new CopyOnWriteArraySet();
        this.videoDebugListeners = copyOnWriteArraySet2;
        CopyOnWriteArraySet copyOnWriteArraySet3 = new CopyOnWriteArraySet();
        this.audioDebugListeners = copyOnWriteArraySet3;
        Handler handler0 = new Handler(looper0);
        this.eventHandler = handler0;
        Renderer[] arr_renderer = renderersFactory0.createRenderers(handler0, simpleExoPlayer$ComponentListener0, simpleExoPlayer$ComponentListener0, simpleExoPlayer$ComponentListener0, simpleExoPlayer$ComponentListener0, drmSessionManager0);
        this.renderers = arr_renderer;
        this.audioVolume = 1.0f;
        this.audioSessionId = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.videoScalingMode = 1;
        this.currentCues = Collections.EMPTY_LIST;
        ExoPlayerImpl exoPlayerImpl0 = new ExoPlayerImpl(arr_renderer, trackSelector0, loadControl0, bandwidthMeter0, clock0, looper0);
        this.player = exoPlayerImpl0;
        analyticsCollector0.setPlayer(exoPlayerImpl0);
        exoPlayerImpl0.addListener(analyticsCollector0);
        exoPlayerImpl0.addListener(simpleExoPlayer$ComponentListener0);
        copyOnWriteArraySet2.add(analyticsCollector0);
        copyOnWriteArraySet0.add(analyticsCollector0);
        copyOnWriteArraySet3.add(analyticsCollector0);
        copyOnWriteArraySet1.add(analyticsCollector0);
        this.addMetadataOutput(analyticsCollector0);
        bandwidthMeter0.addEventListener(handler0, analyticsCollector0);
        if(drmSessionManager0 instanceof DefaultDrmSessionManager) {
            ((DefaultDrmSessionManager)drmSessionManager0).addListener(handler0, analyticsCollector0);
        }
        this.audioBecomingNoisyManager = new AudioBecomingNoisyManager(context0, handler0, simpleExoPlayer$ComponentListener0);
        this.audioFocusManager = new AudioFocusManager(context0, handler0, simpleExoPlayer$ComponentListener0);
        this.wakeLockManager = new WakeLockManager(context0);
        this.wifiLockManager = new WifiLockManager(context0);
    }

    public SimpleExoPlayer(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0, BandwidthMeter bandwidthMeter0, AnalyticsCollector analyticsCollector0, Clock clock0, Looper looper0) {
        this(context0, renderersFactory0, trackSelector0, loadControl0, DrmSessionManager.getDummyDrmSessionManager(), bandwidthMeter0, analyticsCollector0, clock0, looper0);
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener0) {
        this.verifyApplicationThread();
        this.analyticsCollector.addListener(analyticsListener0);
    }

    @Deprecated
    public void addAudioDebugListener(AudioRendererEventListener audioRendererEventListener0) {
        this.audioDebugListeners.add(audioRendererEventListener0);
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public void addAudioListener(AudioListener audioListener0) {
        this.audioListeners.add(audioListener0);
    }

    @Override  // com.google.android.exoplayer2.Player
    public void addListener(com.google.android.exoplayer2.Player.EventListener player$EventListener0) {
        this.verifyApplicationThread();
        this.player.addListener(player$EventListener0);
    }

    @Override  // com.google.android.exoplayer2.Player$MetadataComponent
    public void addMetadataOutput(MetadataOutput metadataOutput0) {
        this.metadataOutputs.add(metadataOutput0);
    }

    @Override  // com.google.android.exoplayer2.Player$TextComponent
    public void addTextOutput(TextOutput textOutput0) {
        if(!this.currentCues.isEmpty()) {
            textOutput0.onCues(this.currentCues);
        }
        this.textOutputs.add(textOutput0);
    }

    @Deprecated
    public void addVideoDebugListener(VideoRendererEventListener videoRendererEventListener0) {
        this.videoDebugListeners.add(videoRendererEventListener0);
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void addVideoListener(VideoListener videoListener0) {
        this.videoListeners.add(videoListener0);
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public void clearAuxEffectInfo() {
        this.setAuxEffectInfo(new AuxEffectInfo(0, 0.0f));
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener0) {
        this.verifyApplicationThread();
        if(this.cameraMotionListener == cameraMotionListener0) {
            Renderer[] arr_renderer = this.renderers;
            for(int v = 0; v < arr_renderer.length; ++v) {
                Renderer renderer0 = arr_renderer[v];
                if(renderer0.getTrackType() == 5) {
                    this.player.createMessage(renderer0).setType(7).setPayload(null).send();
                }
            }
        }
    }

    @Deprecated
    public void clearMetadataOutput(MetadataOutput metadataOutput0) {
        this.removeMetadataOutput(metadataOutput0);
    }

    @Deprecated
    public void clearTextOutput(TextOutput textOutput0) {
        this.removeTextOutput(textOutput0);
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void clearVideoDecoderOutputBufferRenderer() {
        this.verifyApplicationThread();
        this.setVideoDecoderOutputBufferRendererInternal(null);
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void clearVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer0) {
        this.verifyApplicationThread();
        if(videoDecoderOutputBufferRenderer0 != null && videoDecoderOutputBufferRenderer0 == this.videoDecoderOutputBufferRenderer) {
            this.clearVideoDecoderOutputBufferRenderer();
        }
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener0) {
        this.verifyApplicationThread();
        if(this.videoFrameMetadataListener == videoFrameMetadataListener0) {
            Renderer[] arr_renderer = this.renderers;
            for(int v = 0; v < arr_renderer.length; ++v) {
                Renderer renderer0 = arr_renderer[v];
                if(renderer0.getTrackType() == 2) {
                    this.player.createMessage(renderer0).setType(6).setPayload(null).send();
                }
            }
        }
    }

    @Deprecated
    public void clearVideoListener(com.google.android.exoplayer2.SimpleExoPlayer.VideoListener simpleExoPlayer$VideoListener0) {
        this.removeVideoListener(simpleExoPlayer$VideoListener0);
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void clearVideoSurface() {
        this.verifyApplicationThread();
        this.removeSurfaceCallbacks();
        this.setVideoSurfaceInternal(null, false);
        this.maybeNotifySurfaceSizeChanged(0, 0);
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void clearVideoSurface(Surface surface0) {
        this.verifyApplicationThread();
        if(surface0 != null && surface0 == this.surface) {
            this.clearVideoSurface();
        }
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder0) {
        this.verifyApplicationThread();
        if(surfaceHolder0 != null && surfaceHolder0 == this.surfaceHolder) {
            this.setVideoSurfaceHolder(null);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void clearVideoSurfaceView(SurfaceView surfaceView0) {
        this.clearVideoSurfaceHolder((surfaceView0 == null ? null : surfaceView0.getHolder()));
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void clearVideoTextureView(TextureView textureView0) {
        this.verifyApplicationThread();
        if(textureView0 != null && textureView0 == this.textureView) {
            this.setVideoTextureView(null);
        }
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage createMessage(Target playerMessage$Target0) {
        this.verifyApplicationThread();
        return this.player.createMessage(playerMessage$Target0);
    }

    public AnalyticsCollector getAnalyticsCollector() {
        return this.analyticsCollector;
    }

    @Override  // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    @Override  // com.google.android.exoplayer2.Player
    public AudioComponent getAudioComponent() {
        return this;
    }

    public DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    public Format getAudioFormat() {
        return this.audioFormat;
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    @Deprecated
    public int getAudioStreamType() {
        return Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        this.verifyApplicationThread();
        return this.player.getBufferedPosition();
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        this.verifyApplicationThread();
        return this.player.getContentBufferedPosition();
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        this.verifyApplicationThread();
        return this.player.getContentPosition();
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        this.verifyApplicationThread();
        return this.player.getCurrentAdGroupIndex();
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        this.verifyApplicationThread();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        this.verifyApplicationThread();
        return this.player.getCurrentPeriodIndex();
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        this.verifyApplicationThread();
        return this.player.getCurrentPosition();
    }

    @Override  // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        this.verifyApplicationThread();
        return this.player.getCurrentTimeline();
    }

    @Override  // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        this.verifyApplicationThread();
        return this.player.getCurrentTrackGroups();
    }

    @Override  // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        this.verifyApplicationThread();
        return this.player.getCurrentTrackSelections();
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        this.verifyApplicationThread();
        return this.player.getCurrentWindowIndex();
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getDuration() {
        this.verifyApplicationThread();
        return this.player.getDuration();
    }

    @Override  // com.google.android.exoplayer2.Player
    public MetadataComponent getMetadataComponent() {
        return this;
    }

    @Override  // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        this.verifyApplicationThread();
        return this.player.getPlayWhenReady();
    }

    @Override  // com.google.android.exoplayer2.Player
    public ExoPlaybackException getPlaybackError() {
        this.verifyApplicationThread();
        return this.player.getPlaybackError();
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        return this.player.getPlaybackLooper();
    }

    @Override  // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        this.verifyApplicationThread();
        return this.player.getPlaybackParameters();
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        this.verifyApplicationThread();
        return this.player.getPlaybackState();
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        this.verifyApplicationThread();
        return this.player.getPlaybackSuppressionReason();
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        this.verifyApplicationThread();
        return this.player.getRendererCount();
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getRendererType(int v) {
        this.verifyApplicationThread();
        return this.player.getRendererType(v);
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        this.verifyApplicationThread();
        return this.player.getRepeatMode();
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public SeekParameters getSeekParameters() {
        this.verifyApplicationThread();
        return this.player.getSeekParameters();
    }

    @Override  // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        this.verifyApplicationThread();
        return this.player.getShuffleModeEnabled();
    }

    @Override  // com.google.android.exoplayer2.Player
    public TextComponent getTextComponent() {
        return this;
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        this.verifyApplicationThread();
        return this.player.getTotalBufferedDuration();
    }

    @Override  // com.google.android.exoplayer2.Player
    public VideoComponent getVideoComponent() {
        return this;
    }

    public DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    public Format getVideoFormat() {
        return this.videoFormat;
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public int getVideoScalingMode() {
        return this.videoScalingMode;
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public float getVolume() {
        return this.audioVolume;
    }

    @Override  // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        this.verifyApplicationThread();
        return this.player.isLoading();
    }

    @Override  // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        this.verifyApplicationThread();
        return this.player.isPlayingAd();
    }

    private void maybeNotifySurfaceSizeChanged(int v, int v1) {
        if(v != this.surfaceWidth || v1 != this.surfaceHeight) {
            this.surfaceWidth = v;
            this.surfaceHeight = v1;
            for(Object object0: this.videoListeners) {
                ((VideoListener)object0).onSurfaceSizeChanged(v, v1);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource0) {
        this.prepare(mediaSource0, true, true);
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource0, boolean z, boolean z1) {
        this.verifyApplicationThread();
        MediaSource mediaSource1 = this.mediaSource;
        if(mediaSource1 != null) {
            mediaSource1.removeEventListener(this.analyticsCollector);
            this.analyticsCollector.resetForNewMediaSource();
        }
        this.mediaSource = mediaSource0;
        mediaSource0.addEventListener(this.eventHandler, this.analyticsCollector);
        boolean z2 = this.getPlayWhenReady();
        this.updatePlayWhenReady(z2, this.audioFocusManager.updateAudioFocus(z2, 2));
        this.player.prepare(mediaSource0, z, z1);
    }

    @Override  // com.google.android.exoplayer2.Player
    public void release() {
        this.verifyApplicationThread();
        this.audioBecomingNoisyManager.setEnabled(false);
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        this.audioFocusManager.release();
        this.player.release();
        this.removeSurfaceCallbacks();
        Surface surface0 = this.surface;
        if(surface0 != null) {
            if(this.ownsSurface) {
                surface0.release();
            }
            this.surface = null;
        }
        MediaSource mediaSource0 = this.mediaSource;
        if(mediaSource0 != null) {
            mediaSource0.removeEventListener(this.analyticsCollector);
            this.mediaSource = null;
        }
        if(this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager)Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
        this.bandwidthMeter.removeEventListener(this.analyticsCollector);
        this.currentCues = Collections.EMPTY_LIST;
        this.playerReleased = true;
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener0) {
        this.verifyApplicationThread();
        this.analyticsCollector.removeListener(analyticsListener0);
    }

    @Deprecated
    public void removeAudioDebugListener(AudioRendererEventListener audioRendererEventListener0) {
        this.audioDebugListeners.remove(audioRendererEventListener0);
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public void removeAudioListener(AudioListener audioListener0) {
        this.audioListeners.remove(audioListener0);
    }

    @Override  // com.google.android.exoplayer2.Player
    public void removeListener(com.google.android.exoplayer2.Player.EventListener player$EventListener0) {
        this.verifyApplicationThread();
        this.player.removeListener(player$EventListener0);
    }

    @Override  // com.google.android.exoplayer2.Player$MetadataComponent
    public void removeMetadataOutput(MetadataOutput metadataOutput0) {
        this.metadataOutputs.remove(metadataOutput0);
    }

    private void removeSurfaceCallbacks() {
        TextureView textureView0 = this.textureView;
        if(textureView0 != null) {
            if(textureView0.getSurfaceTextureListener() == this.componentListener) {
                this.textureView.setSurfaceTextureListener(null);
            }
            else {
                Log.w("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            }
            this.textureView = null;
        }
        SurfaceHolder surfaceHolder0 = this.surfaceHolder;
        if(surfaceHolder0 != null) {
            surfaceHolder0.removeCallback(this.componentListener);
            this.surfaceHolder = null;
        }
    }

    @Override  // com.google.android.exoplayer2.Player$TextComponent
    public void removeTextOutput(TextOutput textOutput0) {
        this.textOutputs.remove(textOutput0);
    }

    @Deprecated
    public void removeVideoDebugListener(VideoRendererEventListener videoRendererEventListener0) {
        this.videoDebugListeners.remove(videoRendererEventListener0);
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void removeVideoListener(VideoListener videoListener0) {
        this.videoListeners.remove(videoListener0);
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void retry() {
        this.verifyApplicationThread();
        if(this.mediaSource != null && (this.getPlaybackError() != null || this.getPlaybackState() == 1)) {
            this.prepare(this.mediaSource, false, false);
        }
    }

    @Override  // com.google.android.exoplayer2.Player
    public void seekTo(int v, long v1) {
        this.verifyApplicationThread();
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(v, v1);
    }

    private void sendVolumeToRenderers() {
        float f = this.audioVolume;
        float f1 = this.audioFocusManager.getVolumeMultiplier();
        Renderer[] arr_renderer = this.renderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            Renderer renderer0 = arr_renderer[v];
            if(renderer0.getTrackType() == 1) {
                this.player.createMessage(renderer0).setType(2).setPayload(((float)(f * f1))).send();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public void setAudioAttributes(AudioAttributes audioAttributes0) {
        this.setAudioAttributes(audioAttributes0, false);
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public void setAudioAttributes(AudioAttributes audioAttributes0, boolean z) {
        this.verifyApplicationThread();
        if(this.playerReleased) {
            return;
        }
        if(!Util.areEqual(this.audioAttributes, audioAttributes0)) {
            this.audioAttributes = audioAttributes0;
            Renderer[] arr_renderer = this.renderers;
            for(int v = 0; v < arr_renderer.length; ++v) {
                Renderer renderer0 = arr_renderer[v];
                if(renderer0.getTrackType() == 1) {
                    this.player.createMessage(renderer0).setType(3).setPayload(audioAttributes0).send();
                }
            }
            for(Object object0: this.audioListeners) {
                ((AudioListener)object0).onAudioAttributesChanged(audioAttributes0);
            }
        }
        AudioFocusManager audioFocusManager0 = this.audioFocusManager;
        if(!z) {
            audioAttributes0 = null;
        }
        audioFocusManager0.setAudioAttributes(audioAttributes0);
        boolean z1 = this.getPlayWhenReady();
        int v1 = this.getPlaybackState();
        this.updatePlayWhenReady(z1, this.audioFocusManager.updateAudioFocus(z1, v1));
    }

    @Deprecated
    public void setAudioDebugListener(AudioRendererEventListener audioRendererEventListener0) {
        Set set0 = Collections.singleton(this.analyticsCollector);
        this.audioDebugListeners.retainAll(set0);
        if(audioRendererEventListener0 != null) {
            this.addAudioDebugListener(audioRendererEventListener0);
        }
    }

    @Deprecated
    public void setAudioStreamType(int v) {
        this.setAudioAttributes(new com.google.android.exoplayer2.audio.AudioAttributes.Builder().setUsage(Util.getAudioUsageForStreamType(v)).setContentType(Util.getAudioContentTypeForStreamType(v)).build());
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo0) {
        this.verifyApplicationThread();
        Renderer[] arr_renderer = this.renderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            Renderer renderer0 = arr_renderer[v];
            if(renderer0.getTrackType() == 1) {
                this.player.createMessage(renderer0).setType(5).setPayload(auxEffectInfo0).send();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void setCameraMotionListener(CameraMotionListener cameraMotionListener0) {
        this.verifyApplicationThread();
        this.cameraMotionListener = cameraMotionListener0;
        Renderer[] arr_renderer = this.renderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            Renderer renderer0 = arr_renderer[v];
            if(renderer0.getTrackType() == 5) {
                this.player.createMessage(renderer0).setType(7).setPayload(cameraMotionListener0).send();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z) {
        this.player.setForegroundMode(z);
    }

    public void setHandleAudioBecomingNoisy(boolean z) {
        this.verifyApplicationThread();
        if(this.playerReleased) {
            return;
        }
        this.audioBecomingNoisyManager.setEnabled(z);
    }

    @Deprecated
    public void setHandleWakeLock(boolean z) {
        this.setWakeMode(((int)z));
    }

    @Deprecated
    public void setMetadataOutput(MetadataOutput metadataOutput0) {
        Set set0 = Collections.singleton(this.analyticsCollector);
        this.metadataOutputs.retainAll(set0);
        if(metadataOutput0 != null) {
            this.addMetadataOutput(metadataOutput0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        this.verifyApplicationThread();
        int v = this.getPlaybackState();
        this.updatePlayWhenReady(z, this.audioFocusManager.updateAudioFocus(z, v));
    }

    @Override  // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(PlaybackParameters playbackParameters0) {
        this.verifyApplicationThread();
        this.player.setPlaybackParameters(playbackParameters0);
    }

    @TargetApi(23)
    @Deprecated
    public void setPlaybackParams(PlaybackParams playbackParams0) {
        PlaybackParameters playbackParameters0;
        if(playbackParams0 == null) {
            playbackParameters0 = null;
        }
        else {
            playbackParams0.allowDefaults();
            playbackParameters0 = new PlaybackParameters(playbackParams0.getSpeed(), playbackParams0.getPitch());
        }
        this.setPlaybackParameters(playbackParameters0);
    }

    public void setPriorityTaskManager(PriorityTaskManager priorityTaskManager0) {
        this.verifyApplicationThread();
        if(Util.areEqual(this.priorityTaskManager, priorityTaskManager0)) {
            return;
        }
        if(this.isPriorityTaskManagerRegistered) {
            ((PriorityTaskManager)Assertions.checkNotNull(this.priorityTaskManager)).remove(0);
        }
        if(priorityTaskManager0 == null || !this.isLoading()) {
            this.isPriorityTaskManagerRegistered = false;
        }
        else {
            priorityTaskManager0.add(0);
            this.isPriorityTaskManagerRegistered = true;
        }
        this.priorityTaskManager = priorityTaskManager0;
    }

    @Override  // com.google.android.exoplayer2.Player
    public void setRepeatMode(int v) {
        this.verifyApplicationThread();
        this.player.setRepeatMode(v);
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(SeekParameters seekParameters0) {
        this.verifyApplicationThread();
        this.player.setSeekParameters(seekParameters0);
    }

    @Override  // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        this.verifyApplicationThread();
        this.player.setShuffleModeEnabled(z);
    }

    @Deprecated
    public void setTextOutput(TextOutput textOutput0) {
        this.textOutputs.clear();
        if(textOutput0 != null) {
            this.addTextOutput(textOutput0);
        }
    }

    @Deprecated
    public void setVideoDebugListener(VideoRendererEventListener videoRendererEventListener0) {
        Set set0 = Collections.singleton(this.analyticsCollector);
        this.videoDebugListeners.retainAll(set0);
        if(videoRendererEventListener0 != null) {
            this.addVideoDebugListener(videoRendererEventListener0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void setVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer0) {
        this.verifyApplicationThread();
        if(videoDecoderOutputBufferRenderer0 != null) {
            this.clearVideoSurface();
        }
        this.setVideoDecoderOutputBufferRendererInternal(videoDecoderOutputBufferRenderer0);
    }

    private void setVideoDecoderOutputBufferRendererInternal(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer0) {
        Renderer[] arr_renderer = this.renderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            Renderer renderer0 = arr_renderer[v];
            if(renderer0.getTrackType() == 2) {
                this.player.createMessage(renderer0).setType(8).setPayload(videoDecoderOutputBufferRenderer0).send();
            }
        }
        this.videoDecoderOutputBufferRenderer = videoDecoderOutputBufferRenderer0;
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener0) {
        this.verifyApplicationThread();
        this.videoFrameMetadataListener = videoFrameMetadataListener0;
        Renderer[] arr_renderer = this.renderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            Renderer renderer0 = arr_renderer[v];
            if(renderer0.getTrackType() == 2) {
                this.player.createMessage(renderer0).setType(6).setPayload(videoFrameMetadataListener0).send();
            }
        }
    }

    @Deprecated
    public void setVideoListener(com.google.android.exoplayer2.SimpleExoPlayer.VideoListener simpleExoPlayer$VideoListener0) {
        this.videoListeners.clear();
        if(simpleExoPlayer$VideoListener0 != null) {
            this.addVideoListener(simpleExoPlayer$VideoListener0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void setVideoScalingMode(int v) {
        this.verifyApplicationThread();
        this.videoScalingMode = v;
        Renderer[] arr_renderer = this.renderers;
        for(int v1 = 0; v1 < arr_renderer.length; ++v1) {
            Renderer renderer0 = arr_renderer[v1];
            if(renderer0.getTrackType() == 2) {
                this.player.createMessage(renderer0).setType(4).setPayload(v).send();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void setVideoSurface(Surface surface0) {
        this.verifyApplicationThread();
        this.removeSurfaceCallbacks();
        if(surface0 != null) {
            this.clearVideoDecoderOutputBufferRenderer();
        }
        int v = 0;
        this.setVideoSurfaceInternal(surface0, false);
        if(surface0 != null) {
            v = -1;
        }
        this.maybeNotifySurfaceSizeChanged(v, v);
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder0) {
        this.verifyApplicationThread();
        this.removeSurfaceCallbacks();
        if(surfaceHolder0 != null) {
            this.clearVideoDecoderOutputBufferRenderer();
        }
        this.surfaceHolder = surfaceHolder0;
        if(surfaceHolder0 == null) {
            this.setVideoSurfaceInternal(null, false);
            this.maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        surfaceHolder0.addCallback(this.componentListener);
        Surface surface0 = surfaceHolder0.getSurface();
        if(surface0 != null && surface0.isValid()) {
            this.setVideoSurfaceInternal(surface0, false);
            Rect rect0 = surfaceHolder0.getSurfaceFrame();
            this.maybeNotifySurfaceSizeChanged(rect0.width(), rect0.height());
            return;
        }
        this.setVideoSurfaceInternal(null, false);
        this.maybeNotifySurfaceSizeChanged(0, 0);
    }

    private void setVideoSurfaceInternal(Surface surface0, boolean z) {
        ArrayList arrayList0 = new ArrayList();
        Renderer[] arr_renderer = this.renderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            Renderer renderer0 = arr_renderer[v];
            if(renderer0.getTrackType() == 2) {
                arrayList0.add(this.player.createMessage(renderer0).setType(1).setPayload(surface0).send());
            }
        }
        if(this.surface != null && this.surface != surface0) {
            try {
                for(Object object0: arrayList0) {
                    ((PlayerMessage)object0).blockUntilDelivered();
                }
            }
            catch(InterruptedException unused_ex) {
                Thread.currentThread().interrupt();
            }
            if(this.ownsSurface) {
                this.surface.release();
            }
        }
        this.surface = surface0;
        this.ownsSurface = z;
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void setVideoSurfaceView(SurfaceView surfaceView0) {
        this.setVideoSurfaceHolder((surfaceView0 == null ? null : surfaceView0.getHolder()));
    }

    @Override  // com.google.android.exoplayer2.Player$VideoComponent
    public void setVideoTextureView(TextureView textureView0) {
        this.verifyApplicationThread();
        this.removeSurfaceCallbacks();
        if(textureView0 != null) {
            this.clearVideoDecoderOutputBufferRenderer();
        }
        this.textureView = textureView0;
        if(textureView0 == null) {
            this.setVideoSurfaceInternal(null, true);
            this.maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        if(textureView0.getSurfaceTextureListener() != null) {
            Log.w("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
        }
        textureView0.setSurfaceTextureListener(this.componentListener);
        SurfaceTexture surfaceTexture0 = textureView0.isAvailable() ? textureView0.getSurfaceTexture() : null;
        if(surfaceTexture0 == null) {
            this.setVideoSurfaceInternal(null, true);
            this.maybeNotifySurfaceSizeChanged(0, 0);
            return;
        }
        this.setVideoSurfaceInternal(new Surface(surfaceTexture0), true);
        this.maybeNotifySurfaceSizeChanged(textureView0.getWidth(), textureView0.getHeight());
    }

    @Override  // com.google.android.exoplayer2.Player$AudioComponent
    public void setVolume(float f) {
        this.verifyApplicationThread();
        float f1 = Util.constrainValue(f, 0.0f, 1.0f);
        if(this.audioVolume != f1) {
            this.audioVolume = f1;
            this.sendVolumeToRenderers();
            for(Object object0: this.audioListeners) {
                ((AudioListener)object0).onVolumeChanged(f1);
            }
        }
    }

    public void setWakeMode(int v) {
        switch(v) {
            case 0: {
                this.wakeLockManager.setEnabled(false);
                this.wifiLockManager.setEnabled(false);
                return;
            }
            case 1: {
                this.wakeLockManager.setEnabled(true);
                this.wifiLockManager.setEnabled(false);
                return;
            }
            case 2: {
                this.wakeLockManager.setEnabled(true);
                this.wifiLockManager.setEnabled(true);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.Player
    public void stop(boolean z) {
        this.verifyApplicationThread();
        boolean z1 = this.getPlayWhenReady();
        this.audioFocusManager.updateAudioFocus(z1, 1);
        this.player.stop(z);
        MediaSource mediaSource0 = this.mediaSource;
        if(mediaSource0 != null) {
            mediaSource0.removeEventListener(this.analyticsCollector);
            this.analyticsCollector.resetForNewMediaSource();
            if(z) {
                this.mediaSource = null;
            }
        }
        this.currentCues = Collections.EMPTY_LIST;
    }

    private void updatePlayWhenReady(boolean z, int v) {
        int v1 = 0;
        boolean z1 = z && v != -1;
        if(z1 && v != 1) {
            v1 = 1;
        }
        this.player.setPlayWhenReady(z1, v1);
    }

    private void updateWakeAndWifiLock() {
        switch(this.getPlaybackState()) {
            case 2: 
            case 3: {
                boolean z = this.getPlayWhenReady();
                this.wakeLockManager.setStayAwake(z);
                boolean z1 = this.getPlayWhenReady();
                this.wifiLockManager.setStayAwake(z1);
                return;
            }
            case 1: 
            case 4: {
                this.wakeLockManager.setStayAwake(false);
                this.wifiLockManager.setStayAwake(false);
                return;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    private void verifyApplicationThread() {
        if(Looper.myLooper() != this.getApplicationLooper()) {
            Log.w("SimpleExoPlayer", "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", (this.hasNotifiedFullWrongThreadWarning ? null : new IllegalStateException()));
            this.hasNotifiedFullWrongThreadWarning = true;
        }
    }

    class com.google.android.exoplayer2.SimpleExoPlayer.1 {
    }

}

