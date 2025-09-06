package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;

@Deprecated
public final class ExoPlayerFactory {
    @Deprecated
    public static ExoPlayer newInstance(Context context0, Renderer[] arr_renderer, TrackSelector trackSelector0) {
        return ExoPlayerFactory.newInstance(context0, arr_renderer, trackSelector0, new DefaultLoadControl());
    }

    @Deprecated
    public static ExoPlayer newInstance(Context context0, Renderer[] arr_renderer, TrackSelector trackSelector0, LoadControl loadControl0) {
        return ExoPlayerFactory.newInstance(context0, arr_renderer, trackSelector0, loadControl0, Util.getLooper());
    }

    @Deprecated
    public static ExoPlayer newInstance(Context context0, Renderer[] arr_renderer, TrackSelector trackSelector0, LoadControl loadControl0, Looper looper0) {
        return ExoPlayerFactory.newInstance(context0, arr_renderer, trackSelector0, loadControl0, DefaultBandwidthMeter.getSingletonInstance(context0), looper0);
    }

    @Deprecated
    public static ExoPlayer newInstance(Context context0, Renderer[] arr_renderer, TrackSelector trackSelector0, LoadControl loadControl0, BandwidthMeter bandwidthMeter0, Looper looper0) {
        return new ExoPlayerImpl(arr_renderer, trackSelector0, loadControl0, bandwidthMeter0, Clock.DEFAULT, looper0);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0) {
        return ExoPlayerFactory.newSimpleInstance(context0, new DefaultTrackSelector(context0));
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0) {
        return ExoPlayerFactory.newSimpleInstance(context0, renderersFactory0, trackSelector0, new DefaultLoadControl());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0) {
        return ExoPlayerFactory.newSimpleInstance(context0, renderersFactory0, trackSelector0, loadControl0, null, Util.getLooper());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0) {
        return ExoPlayerFactory.newSimpleInstance(context0, renderersFactory0, trackSelector0, loadControl0, drmSessionManager0, Util.getLooper());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0, Looper looper0) {
        return ExoPlayerFactory.newSimpleInstance(context0, renderersFactory0, trackSelector0, loadControl0, drmSessionManager0, new AnalyticsCollector(Clock.DEFAULT), looper0);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0, AnalyticsCollector analyticsCollector0) {
        return ExoPlayerFactory.newSimpleInstance(context0, renderersFactory0, trackSelector0, loadControl0, drmSessionManager0, analyticsCollector0, Util.getLooper());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0, AnalyticsCollector analyticsCollector0, Looper looper0) {
        return ExoPlayerFactory.newSimpleInstance(context0, renderersFactory0, trackSelector0, loadControl0, drmSessionManager0, DefaultBandwidthMeter.getSingletonInstance(context0), analyticsCollector0, looper0);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0, BandwidthMeter bandwidthMeter0) {
        return ExoPlayerFactory.newSimpleInstance(context0, renderersFactory0, trackSelector0, loadControl0, drmSessionManager0, bandwidthMeter0, new AnalyticsCollector(Clock.DEFAULT), Util.getLooper());
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0, BandwidthMeter bandwidthMeter0, AnalyticsCollector analyticsCollector0, Looper looper0) {
        return new SimpleExoPlayer(context0, renderersFactory0, trackSelector0, loadControl0, drmSessionManager0, bandwidthMeter0, analyticsCollector0, Clock.DEFAULT, looper0);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, RenderersFactory renderersFactory0, TrackSelector trackSelector0, DrmSessionManager drmSessionManager0) {
        return ExoPlayerFactory.newSimpleInstance(context0, renderersFactory0, trackSelector0, new DefaultLoadControl(), drmSessionManager0);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, TrackSelector trackSelector0) {
        return ExoPlayerFactory.newSimpleInstance(context0, new DefaultRenderersFactory(context0), trackSelector0);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, TrackSelector trackSelector0, LoadControl loadControl0) {
        return ExoPlayerFactory.newSimpleInstance(context0, new DefaultRenderersFactory(context0), trackSelector0, loadControl0);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0) {
        return ExoPlayerFactory.newSimpleInstance(context0, new DefaultRenderersFactory(context0), trackSelector0, loadControl0, drmSessionManager0);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0, int v) {
        return ExoPlayerFactory.newSimpleInstance(context0, new DefaultRenderersFactory(context0).setExtensionRendererMode(v), trackSelector0, loadControl0, drmSessionManager0);
    }

    @Deprecated
    public static SimpleExoPlayer newSimpleInstance(Context context0, TrackSelector trackSelector0, LoadControl loadControl0, DrmSessionManager drmSessionManager0, int v, long v1) {
        return ExoPlayerFactory.newSimpleInstance(context0, new DefaultRenderersFactory(context0).setExtensionRendererMode(v).setAllowedVideoJoiningTimeMs(v1), trackSelector0, loadControl0, drmSessionManager0);
    }
}

