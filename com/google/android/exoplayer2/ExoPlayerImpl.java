package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import b3.Z;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.concurrent.CopyOnWriteArrayList;

final class ExoPlayerImpl extends BasePlayer implements ExoPlayer {
    static final class PlaybackInfoUpdate implements Runnable {
        private final boolean isLoadingChanged;
        private final boolean isPlayingChanged;
        private final CopyOnWriteArrayList listenerSnapshot;
        private final boolean playWhenReady;
        private final boolean playbackErrorChanged;
        private final PlaybackInfo playbackInfo;
        private final boolean playbackStateChanged;
        private final boolean positionDiscontinuity;
        private final int positionDiscontinuityReason;
        private final boolean seekProcessed;
        private final int timelineChangeReason;
        private final boolean timelineChanged;
        private final TrackSelector trackSelector;
        private final boolean trackSelectorResultChanged;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo0, PlaybackInfo playbackInfo1, CopyOnWriteArrayList copyOnWriteArrayList0, TrackSelector trackSelector0, boolean z, int v, int v1, boolean z1, boolean z2, boolean z3) {
            this.playbackInfo = playbackInfo0;
            this.listenerSnapshot = new CopyOnWriteArrayList(copyOnWriteArrayList0);
            this.trackSelector = trackSelector0;
            this.positionDiscontinuity = z;
            this.positionDiscontinuityReason = v;
            this.timelineChangeReason = v1;
            this.seekProcessed = z1;
            this.playWhenReady = z2;
            this.isPlayingChanged = z3;
            boolean z4 = false;
            this.playbackStateChanged = playbackInfo1.playbackState != playbackInfo0.playbackState;
            this.playbackErrorChanged = playbackInfo1.playbackError != playbackInfo0.playbackError && playbackInfo0.playbackError != null;
            this.timelineChanged = playbackInfo1.timeline != playbackInfo0.timeline;
            this.isLoadingChanged = playbackInfo1.isLoading != playbackInfo0.isLoading;
            if(playbackInfo1.trackSelectorResult != playbackInfo0.trackSelectorResult) {
                z4 = true;
            }
            this.trackSelectorResultChanged = z4;
        }

        private void lambda$run$0(EventListener player$EventListener0) {
            player$EventListener0.onTimelineChanged(this.playbackInfo.timeline, this.timelineChangeReason);
        }

        private void lambda$run$1(EventListener player$EventListener0) {
            player$EventListener0.onPositionDiscontinuity(this.positionDiscontinuityReason);
        }

        private void lambda$run$2(EventListener player$EventListener0) {
            player$EventListener0.onPlayerError(this.playbackInfo.playbackError);
        }

        private void lambda$run$3(EventListener player$EventListener0) {
            player$EventListener0.onTracksChanged(this.playbackInfo.trackGroups, this.playbackInfo.trackSelectorResult.selections);
        }

        private void lambda$run$4(EventListener player$EventListener0) {
            player$EventListener0.onLoadingChanged(this.playbackInfo.isLoading);
        }

        private void lambda$run$5(EventListener player$EventListener0) {
            player$EventListener0.onPlayerStateChanged(this.playWhenReady, this.playbackInfo.playbackState);
        }

        private void lambda$run$6(EventListener player$EventListener0) {
            player$EventListener0.onIsPlayingChanged(this.playbackInfo.playbackState == 3);
        }

        @Override
        public void run() {
            if(this.timelineChanged || this.timelineChangeReason == 0) {
                h h0 = new h(this, 0);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, h0);
            }
            if(this.positionDiscontinuity) {
                h h1 = new h(this, 1);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, h1);
            }
            if(this.playbackErrorChanged) {
                h h2 = new h(this, 2);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, h2);
            }
            if(this.trackSelectorResultChanged) {
                this.trackSelector.onSelectionActivated(this.playbackInfo.trackSelectorResult.info);
                h h3 = new h(this, 3);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, h3);
            }
            if(this.isLoadingChanged) {
                h h4 = new h(this, 4);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, h4);
            }
            if(this.playbackStateChanged) {
                h h5 = new h(this, 5);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, h5);
            }
            if(this.isPlayingChanged) {
                h h6 = new h(this, 6);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, h6);
            }
            if(this.seekProcessed) {
                g g0 = new g(1);
                ExoPlayerImpl.invokeAll(this.listenerSnapshot, g0);
            }
        }
    }

    private static final String TAG = "ExoPlayerImpl";
    final TrackSelectorResult emptyTrackSelectorResult;
    private final Handler eventHandler;
    private boolean foregroundMode;
    private boolean hasPendingPrepare;
    private boolean hasPendingSeek;
    private final ExoPlayerImplInternal internalPlayer;
    private final Handler internalPlayerHandler;
    private final CopyOnWriteArrayList listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private MediaSource mediaSource;
    private final ArrayDeque pendingListenerNotifications;
    private int pendingOperationAcks;
    private int pendingSetPlaybackParametersAcks;
    private final Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private PlaybackParameters playbackParameters;
    private int playbackSuppressionReason;
    private final Renderer[] renderers;
    private int repeatMode;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(Renderer[] arr_renderer, TrackSelector trackSelector0, LoadControl loadControl0, BandwidthMeter bandwidthMeter0, Clock clock0, Looper looper0) {
        String s = Integer.toHexString(System.identityHashCode(this));
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(30, s), Util.DEVICE_DEBUG_INFO), "Init ", s, " [ExoPlayerLib/2.11.7] [", Util.DEVICE_DEBUG_INFO);
        stringBuilder0.append("]");
        Log.i("ExoPlayerImpl", stringBuilder0.toString());
        Assertions.checkState(arr_renderer.length > 0);
        this.renderers = (Renderer[])Assertions.checkNotNull(arr_renderer);
        this.trackSelector = (TrackSelector)Assertions.checkNotNull(trackSelector0);
        this.playWhenReady = false;
        this.repeatMode = 0;
        this.shuffleModeEnabled = false;
        this.listeners = new CopyOnWriteArrayList();
        TrackSelectorResult trackSelectorResult0 = new TrackSelectorResult(new RendererConfiguration[arr_renderer.length], new TrackSelection[arr_renderer.length], null);
        this.emptyTrackSelectorResult = trackSelectorResult0;
        this.period = new Period();
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.seekParameters = SeekParameters.DEFAULT;
        this.playbackSuppressionReason = 0;
        com.google.android.exoplayer2.ExoPlayerImpl.1 exoPlayerImpl$10 = new Handler(looper0) {
            @Override  // android.os.Handler
            public void handleMessage(Message message0) {
                ExoPlayerImpl.this.handleEvent(message0);
            }
        };
        this.eventHandler = exoPlayerImpl$10;
        this.playbackInfo = PlaybackInfo.createDummy(0L, trackSelectorResult0);
        this.pendingListenerNotifications = new ArrayDeque();
        ExoPlayerImplInternal exoPlayerImplInternal0 = new ExoPlayerImplInternal(arr_renderer, trackSelector0, trackSelectorResult0, loadControl0, bandwidthMeter0, false, 0, false, exoPlayerImpl$10, clock0);
        this.internalPlayer = exoPlayerImplInternal0;
        this.internalPlayerHandler = new Handler(exoPlayerImplInternal0.getPlaybackLooper());
    }

    @Override  // com.google.android.exoplayer2.Player
    public void addListener(EventListener player$EventListener0) {
        ListenerHolder basePlayer$ListenerHolder0 = new ListenerHolder(player$EventListener0);
        this.listeners.addIfAbsent(basePlayer$ListenerHolder0);
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public PlayerMessage createMessage(Target playerMessage$Target0) {
        Timeline timeline0 = this.playbackInfo.timeline;
        int v = this.getCurrentWindowIndex();
        return new PlayerMessage(this.internalPlayer, playerMessage$Target0, timeline0, v, this.internalPlayerHandler);
    }

    @Override  // com.google.android.exoplayer2.Player
    public Looper getApplicationLooper() {
        return this.eventHandler.getLooper();
    }

    @Override  // com.google.android.exoplayer2.Player
    public AudioComponent getAudioComponent() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getBufferedPosition() {
        if(this.isPlayingAd()) {
            return this.playbackInfo.loadingMediaPeriodId.equals(this.playbackInfo.periodId) ? C.usToMs(this.playbackInfo.bufferedPositionUs) : this.getDuration();
        }
        return this.getContentBufferedPosition();
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getContentBufferedPosition() {
        if(this.shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        PlaybackInfo playbackInfo0 = this.playbackInfo;
        if(playbackInfo0.loadingMediaPeriodId.windowSequenceNumber != playbackInfo0.periodId.windowSequenceNumber) {
            int v = this.getCurrentWindowIndex();
            return playbackInfo0.timeline.getWindow(v, this.window).getDurationMs();
        }
        long v1 = playbackInfo0.bufferedPositionUs;
        if(this.playbackInfo.loadingMediaPeriodId.isAd()) {
            Period timeline$Period0 = this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.loadingMediaPeriodId.periodUid, this.period);
            long v2 = timeline$Period0.getAdGroupTimeUs(this.playbackInfo.loadingMediaPeriodId.adGroupIndex);
            if(v2 == 0x8000000000000000L) {
                return this.periodPositionUsToWindowPositionMs(this.playbackInfo.loadingMediaPeriodId, timeline$Period0.durationUs);
            }
            v1 = v2;
        }
        return this.periodPositionUsToWindowPositionMs(this.playbackInfo.loadingMediaPeriodId, v1);
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getContentPosition() {
        if(this.isPlayingAd()) {
            this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period);
            PlaybackInfo playbackInfo0 = this.playbackInfo;
            if(playbackInfo0.contentPositionUs == 0x8000000000000001L) {
                int v = this.getCurrentWindowIndex();
                return playbackInfo0.timeline.getWindow(v, this.window).getDefaultPositionMs();
            }
            long v1 = this.period.getPositionInWindowMs();
            return C.usToMs(this.playbackInfo.contentPositionUs) + v1;
        }
        return this.getCurrentPosition();
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.Player
    public int getCurrentAdGroupIndex() {
        return this.isPlayingAd() ? this.playbackInfo.periodId.adGroupIndex : -1;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.Player
    public int getCurrentAdIndexInAdGroup() {
        return this.isPlayingAd() ? this.playbackInfo.periodId.adIndexInAdGroup : -1;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.Player
    public int getCurrentPeriodIndex() {
        return this.shouldMaskPosition() ? this.maskingPeriodIndex : this.playbackInfo.timeline.getIndexOfPeriod(this.playbackInfo.periodId.periodUid);
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getCurrentPosition() {
        if(this.shouldMaskPosition()) {
            return this.maskingWindowPositionMs;
        }
        return this.playbackInfo.periodId.isAd() ? C.usToMs(this.playbackInfo.positionUs) : this.periodPositionUsToWindowPositionMs(this.playbackInfo.periodId, this.playbackInfo.positionUs);
    }

    @Override  // com.google.android.exoplayer2.Player
    public Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    @Override  // com.google.android.exoplayer2.Player
    public TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    @Override  // com.google.android.exoplayer2.Player
    public TrackSelectionArray getCurrentTrackSelections() {
        return this.playbackInfo.trackSelectorResult.selections;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.Player
    public int getCurrentWindowIndex() {
        return this.shouldMaskPosition() ? this.maskingWindowIndex : this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period).windowIndex;
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getDuration() {
        if(this.isPlayingAd()) {
            MediaPeriodId mediaSource$MediaPeriodId0 = this.playbackInfo.periodId;
            this.playbackInfo.timeline.getPeriodByUid(mediaSource$MediaPeriodId0.periodUid, this.period);
            return C.usToMs(this.period.getAdDurationUs(mediaSource$MediaPeriodId0.adGroupIndex, mediaSource$MediaPeriodId0.adIndexInAdGroup));
        }
        return this.getContentDuration();
    }

    @Override  // com.google.android.exoplayer2.Player
    public MetadataComponent getMetadataComponent() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.Player
    public boolean getPlayWhenReady() {
        return this.playWhenReady;
    }

    @Override  // com.google.android.exoplayer2.Player
    public ExoPlaybackException getPlaybackError() {
        return this.playbackInfo.playbackError;
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    @Override  // com.google.android.exoplayer2.Player
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getPlaybackSuppressionReason() {
        return this.playbackSuppressionReason;
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getRendererCount() {
        return this.renderers.length;
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getRendererType(int v) {
        return this.renderers[v].getTrackType();
    }

    @Override  // com.google.android.exoplayer2.Player
    public int getRepeatMode() {
        return this.repeatMode;
    }

    private PlaybackInfo getResetPlaybackInfo(boolean z, boolean z1, boolean z2, int v) {
        MediaPeriodId mediaSource$MediaPeriodId0;
        long v1 = 0L;
        boolean z3 = false;
        if(z) {
            this.maskingWindowIndex = 0;
            this.maskingPeriodIndex = 0;
            this.maskingWindowPositionMs = 0L;
        }
        else {
            this.maskingWindowIndex = this.getCurrentWindowIndex();
            this.maskingPeriodIndex = this.getCurrentPeriodIndex();
            this.maskingWindowPositionMs = this.getCurrentPosition();
        }
        if(!z && !z1) {
            mediaSource$MediaPeriodId0 = this.playbackInfo.periodId;
        }
        else {
            z3 = true;
            mediaSource$MediaPeriodId0 = this.playbackInfo.getDummyFirstMediaPeriodId(this.shuffleModeEnabled, this.window, this.period);
        }
        if(!z3) {
            v1 = this.playbackInfo.positionUs;
        }
        long v2 = z3 ? 0x8000000000000001L : this.playbackInfo.contentPositionUs;
        Timeline timeline0 = z1 ? Timeline.EMPTY : this.playbackInfo.timeline;
        ExoPlaybackException exoPlaybackException0 = z2 ? null : this.playbackInfo.playbackError;
        TrackGroupArray trackGroupArray0 = z1 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups;
        return z1 ? new PlaybackInfo(timeline0, mediaSource$MediaPeriodId0, v1, v2, v, exoPlaybackException0, false, trackGroupArray0, this.emptyTrackSelectorResult, mediaSource$MediaPeriodId0, v1, 0L, v1) : new PlaybackInfo(timeline0, mediaSource$MediaPeriodId0, v1, v2, v, exoPlaybackException0, false, trackGroupArray0, this.playbackInfo.trackSelectorResult, mediaSource$MediaPeriodId0, v1, 0L, v1);
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public SeekParameters getSeekParameters() {
        return this.seekParameters;
    }

    @Override  // com.google.android.exoplayer2.Player
    public boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    @Override  // com.google.android.exoplayer2.Player
    public TextComponent getTextComponent() {
        return null;
    }

    @Override  // com.google.android.exoplayer2.Player
    public long getTotalBufferedDuration() {
        return C.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    @Override  // com.google.android.exoplayer2.Player
    public VideoComponent getVideoComponent() {
        return null;
    }

    public void handleEvent(Message message0) {
        boolean z = false;
        switch(message0.what) {
            case 0: {
                PlaybackInfo playbackInfo0 = (PlaybackInfo)message0.obj;
                int v = message0.arg1;
                int v1 = message0.arg2;
                if(v1 != -1) {
                    z = true;
                }
                this.handlePlaybackInfo(playbackInfo0, v, z, v1);
                return;
            }
            case 1: {
                PlaybackParameters playbackParameters0 = (PlaybackParameters)message0.obj;
                if(message0.arg1 != 0) {
                    z = true;
                }
                this.handlePlaybackParameters(playbackParameters0, z);
                return;
            }
            default: {
                throw new IllegalStateException();
            }
        }
    }

    private void handlePlaybackInfo(PlaybackInfo playbackInfo0, int v, boolean z, int v1) {
        int v2 = this.pendingOperationAcks - v;
        this.pendingOperationAcks = v2;
        if(v2 == 0) {
            PlaybackInfo playbackInfo1 = playbackInfo0.startPositionUs == 0x8000000000000001L ? playbackInfo0.copyWithNewPosition(playbackInfo0.periodId, 0L, playbackInfo0.contentPositionUs, playbackInfo0.totalBufferedDurationUs) : playbackInfo0;
            if(!this.playbackInfo.timeline.isEmpty() && playbackInfo1.timeline.isEmpty()) {
                this.maskingPeriodIndex = 0;
                this.maskingWindowIndex = 0;
                this.maskingWindowPositionMs = 0L;
            }
            int v3 = this.hasPendingPrepare ? 0 : 2;
            boolean z1 = this.hasPendingSeek;
            this.hasPendingPrepare = false;
            this.hasPendingSeek = false;
            this.updatePlaybackInfo(playbackInfo1, z, v1, v3, z1);
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters0, boolean z) {
        if(z) {
            --this.pendingSetPlaybackParametersAcks;
        }
        if(this.pendingSetPlaybackParametersAcks == 0 && !this.playbackParameters.equals(playbackParameters0)) {
            this.playbackParameters = playbackParameters0;
            this.notifyListeners(new b(playbackParameters0, 0));
        }
    }

    private static void invokeAll(CopyOnWriteArrayList copyOnWriteArrayList0, ListenerInvocation basePlayer$ListenerInvocation0) {
        for(Object object0: copyOnWriteArrayList0) {
            ((ListenerHolder)object0).invoke(basePlayer$ListenerInvocation0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player
    public boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.Player
    public boolean isPlayingAd() {
        return !this.shouldMaskPosition() && this.playbackInfo.periodId.isAd();
    }

    private static void lambda$handlePlaybackParameters$5(PlaybackParameters playbackParameters0, EventListener player$EventListener0) {
        player$EventListener0.onPlaybackParametersChanged(playbackParameters0);
    }

    private static void lambda$seekTo$3(EventListener player$EventListener0) {
        player$EventListener0.onPositionDiscontinuity(1);
    }

    private static void lambda$setPlayWhenReady$0(boolean z, boolean z1, int v, boolean z2, int v1, boolean z3, boolean z4, EventListener player$EventListener0) {
        if(z) {
            player$EventListener0.onPlayerStateChanged(z1, v);
        }
        if(z2) {
            player$EventListener0.onPlaybackSuppressionReasonChanged(v1);
        }
        if(z3) {
            player$EventListener0.onIsPlayingChanged(z4);
        }
    }

    private static void lambda$setPlaybackParameters$4(PlaybackParameters playbackParameters0, EventListener player$EventListener0) {
        player$EventListener0.onPlaybackParametersChanged(playbackParameters0);
    }

    private static void lambda$setRepeatMode$1(int v, EventListener player$EventListener0) {
        player$EventListener0.onRepeatModeChanged(v);
    }

    private static void lambda$setShuffleModeEnabled$2(boolean z, EventListener player$EventListener0) {
        player$EventListener0.onShuffleModeEnabledChanged(z);
    }

    private void notifyListeners(ListenerInvocation basePlayer$ListenerInvocation0) {
        this.notifyListeners(new d(0, new CopyOnWriteArrayList(this.listeners), basePlayer$ListenerInvocation0));
    }

    private void notifyListeners(Runnable runnable0) {
        this.pendingListenerNotifications.addLast(runnable0);
        if(this.pendingListenerNotifications.isEmpty()) {
            while(!this.pendingListenerNotifications.isEmpty()) {
                ((Runnable)this.pendingListenerNotifications.peekFirst()).run();
                this.pendingListenerNotifications.removeFirst();
            }
        }
    }

    private long periodPositionUsToWindowPositionMs(MediaPeriodId mediaSource$MediaPeriodId0, long v) {
        long v1 = C.usToMs(v);
        this.playbackInfo.timeline.getPeriodByUid(mediaSource$MediaPeriodId0.periodUid, this.period);
        return this.period.getPositionInWindowMs() + v1;
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource0) {
        this.prepare(mediaSource0, true, true);
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void prepare(MediaSource mediaSource0, boolean z, boolean z1) {
        this.mediaSource = mediaSource0;
        PlaybackInfo playbackInfo0 = this.getResetPlaybackInfo(z, z1, true, 2);
        this.hasPendingPrepare = true;
        ++this.pendingOperationAcks;
        this.internalPlayer.prepare(mediaSource0, z, z1);
        this.updatePlaybackInfo(playbackInfo0, false, 4, 1, false);
    }

    @Override  // com.google.android.exoplayer2.Player
    public void release() {
        String s = Integer.toHexString(System.identityHashCode(this));
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(36, s), Util.DEVICE_DEBUG_INFO), "goog.exo.core"), "Release ", s, " [ExoPlayerLib/2.11.7] [", Util.DEVICE_DEBUG_INFO);
        stringBuilder0.append("] [");
        stringBuilder0.append("goog.exo.core");
        stringBuilder0.append("]");
        Log.i("ExoPlayerImpl", stringBuilder0.toString());
        this.mediaSource = null;
        this.internalPlayer.release();
        this.eventHandler.removeCallbacksAndMessages(null);
        this.playbackInfo = this.getResetPlaybackInfo(false, false, false, 1);
    }

    @Override  // com.google.android.exoplayer2.Player
    public void removeListener(EventListener player$EventListener0) {
        for(Object object0: this.listeners) {
            ListenerHolder basePlayer$ListenerHolder0 = (ListenerHolder)object0;
            if(basePlayer$ListenerHolder0.listener.equals(player$EventListener0)) {
                basePlayer$ListenerHolder0.release();
                this.listeners.remove(basePlayer$ListenerHolder0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void retry() {
        MediaSource mediaSource0 = this.mediaSource;
        if(mediaSource0 != null && this.playbackInfo.playbackState == 1) {
            this.prepare(mediaSource0, false, false);
        }
    }

    @Override  // com.google.android.exoplayer2.Player
    public void seekTo(int v, long v1) {
        Timeline timeline0 = this.playbackInfo.timeline;
        if(v < 0 || !timeline0.isEmpty() && v >= timeline0.getWindowCount()) {
            throw new IllegalSeekPositionException(timeline0, v, v1);
        }
        this.hasPendingSeek = true;
        ++this.pendingOperationAcks;
        if(this.isPlayingAd()) {
            Log.w("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.eventHandler.obtainMessage(0, 1, -1, this.playbackInfo).sendToTarget();
            return;
        }
        this.maskingWindowIndex = v;
        if(timeline0.isEmpty()) {
            this.maskingWindowPositionMs = v1 == 0x8000000000000001L ? 0L : v1;
            this.maskingPeriodIndex = 0;
        }
        else {
            long v2 = v1 == 0x8000000000000001L ? timeline0.getWindow(v, this.window).getDefaultPositionUs() : C.msToUs(v1);
            Pair pair0 = timeline0.getPeriodPosition(this.window, this.period, v, v2);
            this.maskingWindowPositionMs = C.usToMs(v2);
            this.maskingPeriodIndex = timeline0.getIndexOfPeriod(pair0.first);
        }
        this.internalPlayer.seekTo(timeline0, v, C.msToUs(v1));
        this.notifyListeners(new g(0));
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void setForegroundMode(boolean z) {
        if(this.foregroundMode != z) {
            this.foregroundMode = z;
            this.internalPlayer.setForegroundMode(z);
        }
    }

    @Override  // com.google.android.exoplayer2.Player
    public void setPlayWhenReady(boolean z) {
        this.setPlayWhenReady(z, 0);
    }

    public void setPlayWhenReady(boolean z, int v) {
        boolean z1 = this.isPlaying();
        boolean z2 = z && v == 0;
        if((this.playWhenReady && this.playbackSuppressionReason == 0) != z2) {
            this.internalPlayer.setPlayWhenReady(z2);
        }
        boolean z3 = this.playWhenReady != z;
        boolean z4 = this.playbackSuppressionReason != v;
        this.playWhenReady = z;
        this.playbackSuppressionReason = v;
        boolean z5 = this.isPlaying();
        boolean z6 = z1 != z5;
        if(!z3 && !z4 && !z6) {
            return;
        }
        this.notifyListeners(new e(z3, z, this.playbackInfo.playbackState, z4, v, z6, z5));
    }

    @Override  // com.google.android.exoplayer2.Player
    public void setPlaybackParameters(PlaybackParameters playbackParameters0) {
        if(playbackParameters0 == null) {
            playbackParameters0 = PlaybackParameters.DEFAULT;
        }
        if(this.playbackParameters.equals(playbackParameters0)) {
            return;
        }
        ++this.pendingSetPlaybackParametersAcks;
        this.playbackParameters = playbackParameters0;
        this.internalPlayer.setPlaybackParameters(playbackParameters0);
        this.notifyListeners(new b(playbackParameters0, 1));
    }

    @Override  // com.google.android.exoplayer2.Player
    public void setRepeatMode(int v) {
        if(this.repeatMode != v) {
            this.repeatMode = v;
            this.internalPlayer.setRepeatMode(v);
            this.notifyListeners(new f(v));
        }
    }

    @Override  // com.google.android.exoplayer2.ExoPlayer
    public void setSeekParameters(SeekParameters seekParameters0) {
        if(seekParameters0 == null) {
            seekParameters0 = SeekParameters.DEFAULT;
        }
        if(!this.seekParameters.equals(seekParameters0)) {
            this.seekParameters = seekParameters0;
            this.internalPlayer.setSeekParameters(seekParameters0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player
    public void setShuffleModeEnabled(boolean z) {
        if(this.shuffleModeEnabled != z) {
            this.shuffleModeEnabled = z;
            this.internalPlayer.setShuffleModeEnabled(z);
            this.notifyListeners(new c(z));
        }
    }

    private boolean shouldMaskPosition() {
        return this.playbackInfo.timeline.isEmpty() || this.pendingOperationAcks > 0;
    }

    @Override  // com.google.android.exoplayer2.Player
    public void stop(boolean z) {
        if(z) {
            this.mediaSource = null;
        }
        PlaybackInfo playbackInfo0 = this.getResetPlaybackInfo(z, z, z, 1);
        ++this.pendingOperationAcks;
        this.internalPlayer.stop(z);
        this.updatePlaybackInfo(playbackInfo0, false, 4, 1, false);
    }

    private void updatePlaybackInfo(PlaybackInfo playbackInfo0, boolean z, int v, int v1, boolean z1) {
        boolean z2 = this.isPlaying();
        PlaybackInfo playbackInfo1 = this.playbackInfo;
        this.playbackInfo = playbackInfo0;
        boolean z3 = this.isPlaying();
        this.notifyListeners(new PlaybackInfoUpdate(playbackInfo0, playbackInfo1, this.listeners, this.trackSelector, z, v, v1, z1, this.playWhenReady, z2 != z3));
    }
}

