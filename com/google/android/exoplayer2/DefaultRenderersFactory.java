package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000L;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private long allowedVideoJoiningTimeMs;
    private final Context context;
    private DrmSessionManager drmSessionManager;
    private boolean enableDecoderFallback;
    private int extensionRendererMode;
    private MediaCodecSelector mediaCodecSelector;
    private boolean playClearSamplesWithoutKeys;

    public DefaultRenderersFactory(Context context0) {
        this.context = context0;
        this.extensionRendererMode = 0;
        this.allowedVideoJoiningTimeMs = 5000L;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }

    @Deprecated
    public DefaultRenderersFactory(Context context0, int v) {
        this(context0, v, 5000L);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context0, int v, long v1) {
        this(context0, null, v, v1);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context0, DrmSessionManager drmSessionManager0) {
        this(context0, drmSessionManager0, 0);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context0, DrmSessionManager drmSessionManager0, int v) {
        this(context0, drmSessionManager0, v, 5000L);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context0, DrmSessionManager drmSessionManager0, int v, long v1) {
        this.context = context0;
        this.extensionRendererMode = v;
        this.allowedVideoJoiningTimeMs = v1;
        this.drmSessionManager = drmSessionManager0;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }

    public AudioProcessor[] buildAudioProcessors() {
        return new AudioProcessor[0];
    }

    public void buildAudioRenderers(Context context0, int v, MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, boolean z, boolean z1, AudioProcessor[] arr_audioProcessor, Handler handler0, AudioRendererEventListener audioRendererEventListener0, ArrayList arrayList0) {
        int v2;
        Renderer renderer0;
        int v1;
        Class class0 = AudioProcessor[].class;
        Class class1 = AudioRendererEventListener.class;
        Class class2 = Handler.class;
        arrayList0.add(new MediaCodecAudioRenderer(context0, mediaCodecSelector0, drmSessionManager0, z, z1, handler0, audioRendererEventListener0, new DefaultAudioSink(AudioCapabilities.getCapabilities(context0), arr_audioProcessor)));
        if(v != 0) {
            try {
                try {
                    v1 = v == 2 ? arrayList0.size() - 1 : arrayList0.size();
                    renderer0 = (Renderer)Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(class2, class1, class0).newInstance(handler0, audioRendererEventListener0, arr_audioProcessor);
                    v2 = v1 + 1;
                }
                catch(ClassNotFoundException unused_ex) {
                    goto label_12;
                }
                try {
                    arrayList0.add(v1, renderer0);
                    Log.i("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                    goto label_16;
                }
                catch(ClassNotFoundException unused_ex) {
                    v1 = v2;
                }
            label_12:
                v2 = v1;
            }
            catch(Exception exception0) {
                throw new RuntimeException("Error instantiating Opus extension", exception0);
            }
            try {
            label_16:
                Renderer renderer1 = new LibflacAudioRenderer(handler0, audioRendererEventListener0, arr_audioProcessor);
                try {
                    arrayList0.add(v2, renderer1);
                    Log.i("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                }
                catch(ClassNotFoundException unused_ex) {
                }
            }
            catch(Exception exception1) {
                throw new RuntimeException("Error instantiating FLAC extension", exception1);
            }
            try {
                arrayList0.add(v2 + 1, ((Renderer)Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(class2, class1, class0).newInstance(handler0, audioRendererEventListener0, arr_audioProcessor)));
                Log.i("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                return;
            }
            catch(ClassNotFoundException unused_ex) {
                return;
            }
            catch(Exception exception2) {
            }
            throw new RuntimeException("Error instantiating FFmpeg extension", exception2);
        }
    }

    public void buildCameraMotionRenderers(Context context0, int v, ArrayList arrayList0) {
        arrayList0.add(new CameraMotionRenderer());
    }

    public void buildMetadataRenderers(Context context0, MetadataOutput metadataOutput0, Looper looper0, int v, ArrayList arrayList0) {
        arrayList0.add(new MetadataRenderer(metadataOutput0, looper0));
    }

    public void buildMiscellaneousRenderers(Context context0, Handler handler0, int v, ArrayList arrayList0) {
    }

    public void buildTextRenderers(Context context0, TextOutput textOutput0, Looper looper0, int v, ArrayList arrayList0) {
        arrayList0.add(new TextRenderer(textOutput0, looper0));
    }

    public void buildVideoRenderers(Context context0, int v, MediaCodecSelector mediaCodecSelector0, DrmSessionManager drmSessionManager0, boolean z, boolean z1, Handler handler0, VideoRendererEventListener videoRendererEventListener0, long v1, ArrayList arrayList0) {
        int v3;
        int v2;
        Class class0 = Integer.TYPE;
        Class class1 = Long.TYPE;
        Class class2 = Handler.class;
        Class class3 = VideoRendererEventListener.class;
        arrayList0.add(new MediaCodecVideoRenderer(context0, mediaCodecSelector0, v1, drmSessionManager0, z, z1, handler0, videoRendererEventListener0, 50));
        if(v != 0) {
            try {
                v2 = v == 2 ? arrayList0.size() - 1 : arrayList0.size();
                Renderer renderer0 = (Renderer)Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(class1, class2, class3, class0).newInstance(v1, handler0, videoRendererEventListener0, 50);
                v3 = v2 + 1;
                try {
                    arrayList0.add(v2, renderer0);
                    Log.i("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                }
                catch(ClassNotFoundException unused_ex) {
                    v2 = v3;
                    v3 = v2;
                }
            }
            catch(ClassNotFoundException unused_ex) {
                v3 = v2;
            }
            catch(Exception exception0) {
                throw new RuntimeException("Error instantiating VP9 extension", exception0);
            }
            try {
                arrayList0.add(v3, ((Renderer)Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(class1, class2, class3, class0).newInstance(v1, handler0, videoRendererEventListener0, 50)));
                Log.i("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                return;
            }
            catch(ClassNotFoundException exception1) {
            }
            catch(Exception unused_ex) {
                return;
            }
            throw new RuntimeException("Error instantiating AV1 extension", exception1);
        }
    }

    @Override  // com.google.android.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler0, VideoRendererEventListener videoRendererEventListener0, AudioRendererEventListener audioRendererEventListener0, TextOutput textOutput0, MetadataOutput metadataOutput0, DrmSessionManager drmSessionManager0) {
        DrmSessionManager drmSessionManager1 = drmSessionManager0 == null ? this.drmSessionManager : drmSessionManager0;
        ArrayList arrayList0 = new ArrayList();
        this.buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, drmSessionManager1, this.playClearSamplesWithoutKeys, this.enableDecoderFallback, handler0, videoRendererEventListener0, this.allowedVideoJoiningTimeMs, arrayList0);
        this.buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, drmSessionManager1, this.playClearSamplesWithoutKeys, this.enableDecoderFallback, this.buildAudioProcessors(), handler0, audioRendererEventListener0, arrayList0);
        Looper looper0 = handler0.getLooper();
        this.buildTextRenderers(this.context, textOutput0, looper0, this.extensionRendererMode, arrayList0);
        Looper looper1 = handler0.getLooper();
        this.buildMetadataRenderers(this.context, metadataOutput0, looper1, this.extensionRendererMode, arrayList0);
        this.buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList0);
        return (Renderer[])arrayList0.toArray(new Renderer[0]);
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long v) {
        this.allowedVideoJoiningTimeMs = v;
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean z) {
        this.enableDecoderFallback = z;
        return this;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int v) {
        this.extensionRendererMode = v;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector0) {
        this.mediaCodecSelector = mediaCodecSelector0;
        return this;
    }

    public DefaultRenderersFactory setPlayClearSamplesWithoutKeys(boolean z) {
        this.playClearSamplesWithoutKeys = z;
        return this;
    }
}

