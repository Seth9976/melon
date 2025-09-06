package com.google.android.exoplayer2;

import A7.d;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import b3.Z;
import com.google.android.exoplayer2.source.MediaPeriod.Callback;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector.InvalidationListener;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

final class ExoPlayerImplInternal implements Handler.Callback, PlaybackParameterListener, Sender, Callback, MediaSourceCaller, InvalidationListener {
    static final class MediaSourceRefreshInfo {
        public final MediaSource source;
        public final Timeline timeline;

        public MediaSourceRefreshInfo(MediaSource mediaSource0, Timeline timeline0) {
            this.source = mediaSource0;
            this.timeline = timeline0;
        }
    }

    static final class PendingMessageInfo implements Comparable {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage0) {
            this.message = playerMessage0;
        }

        public int compareTo(PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo0) {
            Object object0 = this.resolvedPeriodUid;
            if((object0 == null ? 1 : 0) != (exoPlayerImplInternal$PendingMessageInfo0.resolvedPeriodUid == null ? 1 : 0)) {
                return object0 == null ? 1 : -1;
            }
            if(object0 == null) {
                return 0;
            }
            int v = this.resolvedPeriodIndex - exoPlayerImplInternal$PendingMessageInfo0.resolvedPeriodIndex;
            return v == 0 ? Util.compareLong(this.resolvedPeriodTimeUs, exoPlayerImplInternal$PendingMessageInfo0.resolvedPeriodTimeUs) : v;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((PendingMessageInfo)object0));
        }

        public void setResolvedPosition(int v, long v1, Object object0) {
            this.resolvedPeriodIndex = v;
            this.resolvedPeriodTimeUs = v1;
            this.resolvedPeriodUid = object0;
        }
    }

    static final class PlaybackInfoUpdate {
        private int discontinuityReason;
        private PlaybackInfo lastPlaybackInfo;
        private int operationAcks;
        private boolean positionDiscontinuity;

        private PlaybackInfoUpdate() {
        }

        public PlaybackInfoUpdate(com.google.android.exoplayer2.ExoPlayerImplInternal.1 exoPlayerImplInternal$10) {
        }

        public static int access$100(PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate0) {
            return exoPlayerImplInternal$PlaybackInfoUpdate0.operationAcks;
        }

        public static boolean access$200(PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate0) {
            return exoPlayerImplInternal$PlaybackInfoUpdate0.positionDiscontinuity;
        }

        public static int access$300(PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate0) {
            return exoPlayerImplInternal$PlaybackInfoUpdate0.discontinuityReason;
        }

        public boolean hasPendingUpdate(PlaybackInfo playbackInfo0) {
            return playbackInfo0 != this.lastPlaybackInfo || this.operationAcks > 0 || this.positionDiscontinuity;
        }

        public void incrementPendingOperationAcks(int v) {
            this.operationAcks += v;
        }

        public void reset(PlaybackInfo playbackInfo0) {
            this.lastPlaybackInfo = playbackInfo0;
            this.operationAcks = 0;
            this.positionDiscontinuity = false;
        }

        public void setPositionDiscontinuity(int v) {
            boolean z = true;
            if(this.positionDiscontinuity && this.discontinuityReason != 4) {
                if(v != 4) {
                    z = false;
                }
                Assertions.checkArgument(z);
                return;
            }
            this.positionDiscontinuity = true;
            this.discontinuityReason = v;
        }
    }

    static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline0, int v, long v1) {
            this.timeline = timeline0;
            this.windowIndex = v;
            this.windowPositionUs = v1;
        }
    }

    private static final int ACTIVE_INTERVAL_MS = 10;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_PERIOD_PREPARED = 9;
    public static final int MSG_PLAYBACK_INFO_CHANGED = 0;
    public static final int MSG_PLAYBACK_PARAMETERS_CHANGED = 1;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 17;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_REFRESH_SOURCE_INFO = 8;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 15;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 16;
    private static final int MSG_SET_FOREGROUND_MODE = 14;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 12;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 13;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 10;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 11;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private Renderer[] enabledRenderers;
    private final Handler eventHandler;
    private boolean foregroundMode;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private MediaSource mediaSource;
    private int nextPendingMessageIndexHint;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList pendingMessages;
    private int pendingPrepareCount;
    private final Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private final PlaybackInfoUpdate playbackInfoUpdate;
    private final MediaPeriodQueue queue;
    private boolean rebuffering;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Window window;

    public ExoPlayerImplInternal(Renderer[] arr_renderer, TrackSelector trackSelector0, TrackSelectorResult trackSelectorResult0, LoadControl loadControl0, BandwidthMeter bandwidthMeter0, boolean z, int v, boolean z1, Handler handler0, Clock clock0) {
        this.renderers = arr_renderer;
        this.trackSelector = trackSelector0;
        this.emptyTrackSelectorResult = trackSelectorResult0;
        this.loadControl = loadControl0;
        this.bandwidthMeter = bandwidthMeter0;
        this.playWhenReady = z;
        this.repeatMode = v;
        this.shuffleModeEnabled = z1;
        this.eventHandler = handler0;
        this.clock = clock0;
        this.queue = new MediaPeriodQueue();
        this.backBufferDurationUs = loadControl0.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl0.retainBackBufferFromKeyframe();
        this.seekParameters = SeekParameters.DEFAULT;
        this.playbackInfo = PlaybackInfo.createDummy(0x8000000000000001L, trackSelectorResult0);
        this.playbackInfoUpdate = new PlaybackInfoUpdate(null);
        this.rendererCapabilities = new RendererCapabilities[arr_renderer.length];
        for(int v1 = 0; v1 < arr_renderer.length; ++v1) {
            arr_renderer[v1].setIndex(v1);
            this.rendererCapabilities[v1] = arr_renderer[v1].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock0);
        this.pendingMessages = new ArrayList();
        this.enabledRenderers = new Renderer[0];
        this.window = new Window();
        this.period = new Period();
        trackSelector0.init(this, bandwidthMeter0);
        HandlerThread handlerThread0 = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.internalPlaybackThread = handlerThread0;
        handlerThread0.start();
        this.handler = clock0.createHandler(handlerThread0.getLooper(), this);
        this.deliverPendingMessageAtStartPositionRequired = true;
    }

    private PlaybackInfo copyWithNewPosition(MediaPeriodId mediaSource$MediaPeriodId0, long v, long v1) {
        this.deliverPendingMessageAtStartPositionRequired = true;
        return this.playbackInfo.copyWithNewPosition(mediaSource$MediaPeriodId0, v, v1, this.getTotalBufferedDurationUs());
    }

    private void deliverMessage(PlayerMessage playerMessage0) {
        if(playerMessage0.isCanceled()) {
            return;
        }
        try {
            playerMessage0.getTarget().handleMessage(playerMessage0.getType(), playerMessage0.getPayload());
        }
        finally {
            playerMessage0.markAsProcessed(true);
        }
    }

    private void disableRenderer(Renderer renderer0) {
        this.mediaClock.onRendererDisabled(renderer0);
        this.ensureStopped(renderer0);
        renderer0.disable();
    }

    private void doSomeWork() {
        boolean z3;
        int v5;
        long v = this.clock.uptimeMillis();
        this.updatePeriods();
        if(this.playbackInfo.playbackState == 1 || this.playbackInfo.playbackState == 4) {
            this.handler.removeMessages(2);
            return;
        }
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
        if(mediaPeriodHolder0 == null) {
            this.scheduleNextWork(v, 10L);
            return;
        }
        TraceUtil.beginSection("doSomeWork");
        this.updatePlaybackPositions();
        if(mediaPeriodHolder0.prepared) {
            long v2 = SystemClock.elapsedRealtime();
            mediaPeriodHolder0.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            int v3 = 1;
            boolean z = true;
            for(int v4 = 0; true; ++v4) {
                Renderer[] arr_renderer = this.renderers;
                if(v4 >= arr_renderer.length) {
                    break;
                }
                Renderer renderer0 = arr_renderer[v4];
                if(renderer0.getState() != 0) {
                    renderer0.render(this.rendererPositionUs, v2 * 1000L);
                    v3 = v3 == 0 || !renderer0.isEnded() ? 0 : 1;
                    boolean z1 = mediaPeriodHolder0.sampleStreams[v4] != renderer0.getStream();
                    boolean z2 = z1 || !z1 && mediaPeriodHolder0.getNext() != null && renderer0.hasReadStreamToEnd() || renderer0.isReady() || renderer0.isEnded();
                    z = z && z2;
                    if(!z2) {
                        renderer0.maybeThrowStreamError();
                    }
                }
            }
            v5 = v3;
            z3 = z;
        }
        else {
            mediaPeriodHolder0.mediaPeriod.maybeThrowPrepareError();
            v5 = 1;
            z3 = true;
        }
        long v6 = mediaPeriodHolder0.info.durationUs;
        if(v5 != 0 && mediaPeriodHolder0.prepared && (v6 == 0x8000000000000001L || v6 <= this.playbackInfo.positionUs) && mediaPeriodHolder0.info.isFinal) {
            this.setState(4);
            this.stopRenderers();
        }
        else if(this.playbackInfo.playbackState == 2 && this.shouldTransitionToReadyState(z3)) {
            this.setState(3);
            if(this.playWhenReady) {
                this.startRenderers();
            }
        }
        else if(this.playbackInfo.playbackState == 3) {
            if(this.enabledRenderers.length != 0) {
                if(!z3) {
                    this.rebuffering = this.playWhenReady;
                    this.setState(2);
                    this.stopRenderers();
                }
            }
            else if(this.isTimelineReady()) {
            }
            else {
                this.rebuffering = this.playWhenReady;
                this.setState(2);
                this.stopRenderers();
            }
        }
        if(this.playbackInfo.playbackState == 2) {
            Renderer[] arr_renderer1 = this.enabledRenderers;
            for(int v1 = 0; v1 < arr_renderer1.length; ++v1) {
                arr_renderer1[v1].maybeThrowStreamError();
            }
        }
        if(!this.playWhenReady || this.playbackInfo.playbackState != 3) {
            int v7 = this.playbackInfo.playbackState;
            if(v7 == 2) {
                this.scheduleNextWork(v, 10L);
            }
            else if(this.enabledRenderers.length != 0 && v7 != 4) {
                this.scheduleNextWork(v, 1000L);
            }
            else {
                this.handler.removeMessages(2);
            }
        }
        else {
            this.scheduleNextWork(v, 10L);
        }
        TraceUtil.endSection();
    }

    private void enableRenderer(int v, boolean z, int v1) {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
        Renderer renderer0 = this.renderers[v];
        this.enabledRenderers[v1] = renderer0;
        if(renderer0.getState() == 0) {
            TrackSelectorResult trackSelectorResult0 = mediaPeriodHolder0.getTrackSelectorResult();
            RendererConfiguration rendererConfiguration0 = trackSelectorResult0.rendererConfigurations[v];
            Format[] arr_format = ExoPlayerImplInternal.getFormats(trackSelectorResult0.selections.get(v));
            boolean z1 = this.playWhenReady && this.playbackInfo.playbackState == 3;
            renderer0.enable(rendererConfiguration0, arr_format, mediaPeriodHolder0.sampleStreams[v], this.rendererPositionUs, !z && z1, mediaPeriodHolder0.getRendererOffset());
            this.mediaClock.onRendererEnabled(renderer0);
            if(z1) {
                renderer0.start();
            }
        }
    }

    private void enableRenderers(boolean[] arr_z, int v) {
        this.enabledRenderers = new Renderer[v];
        TrackSelectorResult trackSelectorResult0 = this.queue.getPlayingPeriod().getTrackSelectorResult();
        for(int v2 = 0; v2 < this.renderers.length; ++v2) {
            if(!trackSelectorResult0.isRendererEnabled(v2)) {
                this.renderers[v2].reset();
            }
        }
        int v3 = 0;
        for(int v1 = 0; v1 < this.renderers.length; ++v1) {
            if(trackSelectorResult0.isRendererEnabled(v1)) {
                this.enableRenderer(v1, arr_z[v1], v3);
                ++v3;
            }
        }
    }

    private void ensureStopped(Renderer renderer0) {
        if(renderer0.getState() == 2) {
            renderer0.stop();
        }
    }

    private String getExoPlaybackExceptionMessage(ExoPlaybackException exoPlaybackException0) {
        if(exoPlaybackException0.type != 1) {
            return "Playback error.";
        }
        String s = Util.getTrackTypeString(this.renderers[exoPlaybackException0.rendererIndex].getTrackType());
        String s1 = String.valueOf(exoPlaybackException0.rendererFormat);
        String s2 = RendererCapabilities.getFormatSupportString(exoPlaybackException0.rendererFormatSupport);
        StringBuilder stringBuilder0 = new StringBuilder(Z.e(s1.length() + Z.e(67, s), s2));
        stringBuilder0.append("Renderer error: index=");
        stringBuilder0.append(exoPlaybackException0.rendererIndex);
        stringBuilder0.append(", type=");
        stringBuilder0.append(s);
        return d.n(stringBuilder0, ", format=", s1, ", rendererSupport=", s2);
    }

    private static Format[] getFormats(TrackSelection trackSelection0) {
        int v1 = trackSelection0 == null ? 0 : trackSelection0.length();
        Format[] arr_format = new Format[v1];
        for(int v = 0; v < v1; ++v) {
            arr_format[v] = trackSelection0.getFormat(v);
        }
        return arr_format;
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getReadingPeriod();
        if(mediaPeriodHolder0 == null) {
            return 0L;
        }
        long v = mediaPeriodHolder0.getRendererOffset();
        if(!mediaPeriodHolder0.prepared) {
            return v;
        }
        for(int v1 = 0; true; ++v1) {
            Renderer[] arr_renderer = this.renderers;
            if(v1 >= arr_renderer.length) {
                break;
            }
            if(arr_renderer[v1].getState() != 0 && this.renderers[v1].getStream() == mediaPeriodHolder0.sampleStreams[v1]) {
                long v2 = this.renderers[v1].getReadingPositionUs();
                if(v2 == 0x8000000000000000L) {
                    return 0x8000000000000000L;
                }
                v = Math.max(v2, v);
            }
        }
        return v;
    }

    private Pair getPeriodPosition(Timeline timeline0, int v, long v1) {
        return timeline0.getPeriodPosition(this.window, this.period, v, v1);
    }

    public Looper getPlaybackLooper() {
        return this.internalPlaybackThread.getLooper();
    }

    private long getTotalBufferedDurationUs() {
        return this.getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private long getTotalBufferedDurationUs(long v) {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getLoadingPeriod();
        return mediaPeriodHolder0 == null ? 0L : Math.max(0L, v - mediaPeriodHolder0.toPeriodTime(this.rendererPositionUs));
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod0) {
        if(!this.queue.isLoading(mediaPeriod0)) {
            return;
        }
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        this.maybeContinueLoading();
    }

    private void handleLoadingMediaPeriodChanged(boolean z) {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getLoadingPeriod();
        MediaPeriodId mediaSource$MediaPeriodId0 = mediaPeriodHolder0 == null ? this.playbackInfo.periodId : mediaPeriodHolder0.info.id;
        boolean z1 = this.playbackInfo.loadingMediaPeriodId.equals(mediaSource$MediaPeriodId0);
        if(!z1) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaSource$MediaPeriodId0);
        }
        PlaybackInfo playbackInfo0 = this.playbackInfo;
        playbackInfo0.bufferedPositionUs = mediaPeriodHolder0 == null ? playbackInfo0.positionUs : mediaPeriodHolder0.getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = this.getTotalBufferedDurationUs();
        if((!z1 || z) && mediaPeriodHolder0 != null && mediaPeriodHolder0.prepared) {
            this.updateLoadControlTrackSelection(mediaPeriodHolder0.getTrackGroups(), mediaPeriodHolder0.getTrackSelectorResult());
        }
    }

    @Override  // android.os.Handler$Callback
    public boolean handleMessage(Message message0) {
        try {
            switch(message0.what) {
                case 0: {
                    this.prepareInternal(((MediaSource)message0.obj), message0.arg1 != 0, message0.arg2 != 0);
                    break;
                }
                case 1: {
                    this.setPlayWhenReadyInternal(message0.arg1 != 0);
                    break;
                }
                case 2: {
                    this.doSomeWork();
                    break;
                }
                case 3: {
                    this.seekToInternal(((SeekPosition)message0.obj));
                    break;
                }
                case 4: {
                    this.setPlaybackParametersInternal(((PlaybackParameters)message0.obj));
                    break;
                }
                case 5: {
                    this.setSeekParametersInternal(((SeekParameters)message0.obj));
                    break;
                }
                case 6: {
                    this.stopInternal(false, message0.arg1 != 0, true);
                    break;
                }
                case 7: {
                    this.releaseInternal();
                    return true;
                }
                case 8: {
                    this.handleSourceInfoRefreshed(((MediaSourceRefreshInfo)message0.obj));
                    break;
                }
                case 9: {
                    this.handlePeriodPrepared(((MediaPeriod)message0.obj));
                    break;
                }
                case 10: {
                    this.handleContinueLoadingRequested(((MediaPeriod)message0.obj));
                    break;
                }
                case 11: {
                    this.reselectTracksInternal();
                    break;
                }
                case 12: {
                    this.setRepeatModeInternal(message0.arg1);
                    break;
                }
                case 13: {
                    this.setShuffleModeEnabledInternal(message0.arg1 != 0);
                    break;
                }
                case 14: {
                    this.setForegroundModeInternal(message0.arg1 != 0, ((AtomicBoolean)message0.obj));
                    break;
                }
                case 15: {
                    this.sendMessageInternal(((PlayerMessage)message0.obj));
                    break;
                }
                case 16: {
                    this.sendMessageToTargetThread(((PlayerMessage)message0.obj));
                    break;
                }
                case 17: {
                    this.handlePlaybackParameters(((PlaybackParameters)message0.obj), message0.arg1 != 0);
                    break;
                }
                default: {
                    return false;
                }
            }
            this.maybeNotifyPlaybackInfoChanged();
            return true;
        }
        catch(ExoPlaybackException exoPlaybackException0) {
        }
        catch(IOException iOException0) {
            goto label_49;
        }
        catch(RuntimeException | OutOfMemoryError runtimeException0) {
            goto label_54;
        }
        Log.e("ExoPlayerImplInternal", this.getExoPlaybackExceptionMessage(exoPlaybackException0), exoPlaybackException0);
        this.stopInternal(true, false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackException0);
        this.maybeNotifyPlaybackInfoChanged();
        return true;
    label_49:
        Log.e("ExoPlayerImplInternal", "Source error", iOException0);
        this.stopInternal(false, false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(ExoPlaybackException.createForSource(iOException0));
        this.maybeNotifyPlaybackInfoChanged();
        return true;
    label_54:
        Log.e("ExoPlayerImplInternal", "Internal runtime error", runtimeException0);
        ExoPlaybackException exoPlaybackException1 = runtimeException0 instanceof OutOfMemoryError ? ExoPlaybackException.createForOutOfMemoryError(((OutOfMemoryError)runtimeException0)) : ExoPlaybackException.createForUnexpected(runtimeException0);
        this.stopInternal(true, false, false);
        this.playbackInfo = this.playbackInfo.copyWithPlaybackError(exoPlaybackException1);
        this.maybeNotifyPlaybackInfoChanged();
        return true;
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod0) {
        if(!this.queue.isLoading(mediaPeriod0)) {
            return;
        }
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getLoadingPeriod();
        mediaPeriodHolder0.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline);
        this.updateLoadControlTrackSelection(mediaPeriodHolder0.getTrackGroups(), mediaPeriodHolder0.getTrackSelectorResult());
        if(mediaPeriodHolder0 == this.queue.getPlayingPeriod()) {
            this.resetRendererPosition(mediaPeriodHolder0.info.startPositionUs);
            this.updatePlayingPeriodRenderers(null);
        }
        this.maybeContinueLoading();
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters0, boolean z) {
        this.eventHandler.obtainMessage(1, ((int)z), 0, playbackParameters0).sendToTarget();
        this.updateTrackSelectionPlaybackSpeed(playbackParameters0.speed);
        Renderer[] arr_renderer = this.renderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            Renderer renderer0 = arr_renderer[v];
            if(renderer0 != null) {
                renderer0.setOperatingRate(playbackParameters0.speed);
            }
        }
    }

    private void handleSourceInfoRefreshEndedPlayback() {
        if(this.playbackInfo.playbackState != 1) {
            this.setState(4);
        }
        this.resetInternal(false, false, true, false, true);
    }

    private void handleSourceInfoRefreshed(MediaSourceRefreshInfo exoPlayerImplInternal$MediaSourceRefreshInfo0) {
        long v2;
        MediaPeriodId mediaSource$MediaPeriodId1;
        long v1;
        if(exoPlayerImplInternal$MediaSourceRefreshInfo0.source != this.mediaSource) {
            return;
        }
        this.playbackInfoUpdate.incrementPendingOperationAcks(this.pendingPrepareCount);
        this.pendingPrepareCount = 0;
        Timeline timeline0 = this.playbackInfo.timeline;
        Timeline timeline1 = exoPlayerImplInternal$MediaSourceRefreshInfo0.timeline;
        this.queue.setTimeline(timeline1);
        this.playbackInfo = this.playbackInfo.copyWithTimeline(timeline1);
        this.resolvePendingMessagePositions();
        MediaPeriodId mediaSource$MediaPeriodId0 = this.playbackInfo.periodId;
        long v = mediaSource$MediaPeriodId0.isAd() ? this.playbackInfo.contentPositionUs : this.playbackInfo.positionUs;
        SeekPosition exoPlayerImplInternal$SeekPosition0 = this.pendingInitialSeekPosition;
        if(exoPlayerImplInternal$SeekPosition0 != null) {
            Pair pair0 = this.resolveSeekPosition(exoPlayerImplInternal$SeekPosition0, true);
            this.pendingInitialSeekPosition = null;
            if(pair0 == null) {
                this.handleSourceInfoRefreshEndedPlayback();
                return;
            }
            v1 = (long)(((Long)pair0.second));
            mediaSource$MediaPeriodId1 = this.queue.resolveMediaPeriodIdForAds(pair0.first, v1);
            v2 = v1;
        }
        else if(v == 0x8000000000000001L && !timeline1.isEmpty()) {
            Pair pair1 = this.getPeriodPosition(timeline1, timeline1.getFirstWindowIndex(this.shuffleModeEnabled), 0x8000000000000001L);
            MediaPeriodId mediaSource$MediaPeriodId2 = this.queue.resolveMediaPeriodIdForAds(pair1.first, ((long)(((Long)pair1.second))));
            v2 = mediaSource$MediaPeriodId2.isAd() ? 0x8000000000000001L : ((long)(((Long)pair1.second)));
            mediaSource$MediaPeriodId1 = mediaSource$MediaPeriodId2;
        }
        else if(timeline1.getIndexOfPeriod(mediaSource$MediaPeriodId0.periodUid) == -1) {
            Object object0 = this.resolveSubsequentPeriod(mediaSource$MediaPeriodId0.periodUid, timeline0, timeline1);
            if(object0 == null) {
                this.handleSourceInfoRefreshEndedPlayback();
                return;
            }
            Pair pair2 = this.getPeriodPosition(timeline1, timeline1.getPeriodByUid(object0, this.period).windowIndex, 0x8000000000000001L);
            v1 = (long)(((Long)pair2.second));
            mediaSource$MediaPeriodId1 = this.queue.resolveMediaPeriodIdForAds(pair2.first, v1);
            v2 = v1;
        }
        else {
            MediaPeriodId mediaSource$MediaPeriodId3 = this.queue.resolveMediaPeriodIdForAds(this.playbackInfo.periodId.periodUid, v);
            if(!this.playbackInfo.periodId.isAd() && !mediaSource$MediaPeriodId3.isAd()) {
                mediaSource$MediaPeriodId3 = this.playbackInfo.periodId;
            }
            mediaSource$MediaPeriodId1 = mediaSource$MediaPeriodId3;
            v2 = v;
        }
        if(!this.playbackInfo.periodId.equals(mediaSource$MediaPeriodId1) || v != v2) {
            MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
            if(mediaPeriodHolder0 != null) {
                while(mediaPeriodHolder0.getNext() != null) {
                    mediaPeriodHolder0 = mediaPeriodHolder0.getNext();
                    if(mediaPeriodHolder0.info.id.equals(mediaSource$MediaPeriodId1)) {
                        mediaPeriodHolder0.info = this.queue.getUpdatedMediaPeriodInfo(mediaPeriodHolder0.info);
                    }
                }
            }
            this.playbackInfo = this.copyWithNewPosition(mediaSource$MediaPeriodId1, this.seekToPeriodPosition(mediaSource$MediaPeriodId1, (mediaSource$MediaPeriodId1.isAd() ? 0L : v2)), v2);
        }
        else {
            long v3 = this.rendererPositionUs;
            long v4 = this.getMaxRendererReadPositionUs();
            if(!this.queue.updateQueuedPeriods(v3, v4)) {
                this.seekToCurrentPosition(false);
            }
        }
        this.handleLoadingMediaPeriodChanged(false);
    }

    private boolean hasReadingPeriodFinishedReading() {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getReadingPeriod();
        if(!mediaPeriodHolder0.prepared) {
            return false;
        }
        int v = 0;
        while(true) {
            Renderer[] arr_renderer = this.renderers;
            if(v >= arr_renderer.length) {
                break;
            }
            Renderer renderer0 = arr_renderer[v];
            SampleStream sampleStream0 = mediaPeriodHolder0.sampleStreams[v];
            if(renderer0.getStream() == sampleStream0 && (sampleStream0 == null || renderer0.hasReadStreamToEnd())) {
                ++v;
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean isLoadingPossible() {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getLoadingPeriod();
        return mediaPeriodHolder0 == null ? false : mediaPeriodHolder0.getNextLoadPositionUs() != 0x8000000000000000L;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
        long v = mediaPeriodHolder0.info.durationUs;
        return mediaPeriodHolder0.prepared && (v == 0x8000000000000001L || this.playbackInfo.positionUs < v);
    }

    private void lambda$sendMessageToTargetThread$0(PlayerMessage playerMessage0) {
        try {
            this.deliverMessage(playerMessage0);
        }
        catch(ExoPlaybackException exoPlaybackException0) {
            Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", exoPlaybackException0);
            throw new RuntimeException(exoPlaybackException0);
        }
    }

    private void maybeContinueLoading() {
        boolean z = this.shouldContinueLoading();
        this.shouldContinueLoading = z;
        if(z) {
            this.queue.getLoadingPeriod().continueLoading(this.rendererPositionUs);
        }
        this.updateIsLoading();
    }

    private void maybeNotifyPlaybackInfoChanged() {
        if(this.playbackInfoUpdate.hasPendingUpdate(this.playbackInfo)) {
            this.eventHandler.obtainMessage(0, PlaybackInfoUpdate.access$100(this.playbackInfoUpdate), (PlaybackInfoUpdate.access$200(this.playbackInfoUpdate) ? PlaybackInfoUpdate.access$300(this.playbackInfoUpdate) : -1), this.playbackInfo).sendToTarget();
            this.playbackInfoUpdate.reset(this.playbackInfo);
        }
    }

    private void maybeThrowSourceInfoRefreshError() {
        if(this.queue.getLoadingPeriod() != null) {
            Renderer[] arr_renderer = this.enabledRenderers;
            for(int v = 0; v < arr_renderer.length; ++v) {
                if(!arr_renderer[v].hasReadStreamToEnd()) {
                    return;
                }
            }
        }
        this.mediaSource.maybeThrowSourceInfoRefreshError();
    }

    private void maybeTriggerPendingMessages(long v, long v1) {
        PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo1;
        if(!this.pendingMessages.isEmpty() && !this.playbackInfo.periodId.isAd()) {
            PlaybackInfo playbackInfo0 = this.playbackInfo;
            if(playbackInfo0.startPositionUs == v && this.deliverPendingMessageAtStartPositionRequired) {
                --v;
            }
            this.deliverPendingMessageAtStartPositionRequired = false;
            int v2 = playbackInfo0.timeline.getIndexOfPeriod(playbackInfo0.periodId.periodUid);
            int v3 = Math.min(this.nextPendingMessageIndexHint, this.pendingMessages.size());
            PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo0 = v3 <= 0 ? null : ((PendingMessageInfo)this.pendingMessages.get(v3 - 1));
            while(exoPlayerImplInternal$PendingMessageInfo0 != null && (exoPlayerImplInternal$PendingMessageInfo0.resolvedPeriodIndex > v2 || exoPlayerImplInternal$PendingMessageInfo0.resolvedPeriodIndex == v2 && exoPlayerImplInternal$PendingMessageInfo0.resolvedPeriodTimeUs > v)) {
                exoPlayerImplInternal$PendingMessageInfo0 = v3 - 1 <= 0 ? null : ((PendingMessageInfo)this.pendingMessages.get(v3 - 2));
                --v3;
            }
            if(v3 < this.pendingMessages.size()) {
                exoPlayerImplInternal$PendingMessageInfo1 = (PendingMessageInfo)this.pendingMessages.get(v3);
                goto label_16;
            }
            while(true) {
                exoPlayerImplInternal$PendingMessageInfo1 = null;
            label_16:
                if(exoPlayerImplInternal$PendingMessageInfo1 == null || exoPlayerImplInternal$PendingMessageInfo1.resolvedPeriodUid == null || exoPlayerImplInternal$PendingMessageInfo1.resolvedPeriodIndex >= v2 && (exoPlayerImplInternal$PendingMessageInfo1.resolvedPeriodIndex != v2 || exoPlayerImplInternal$PendingMessageInfo1.resolvedPeriodTimeUs > v)) {
                    break;
                }
                ++v3;
                if(v3 >= this.pendingMessages.size()) {
                    continue;
                }
                exoPlayerImplInternal$PendingMessageInfo1 = (PendingMessageInfo)this.pendingMessages.get(v3);
                goto label_16;
            }
            while(exoPlayerImplInternal$PendingMessageInfo1 != null && exoPlayerImplInternal$PendingMessageInfo1.resolvedPeriodUid != null && exoPlayerImplInternal$PendingMessageInfo1.resolvedPeriodIndex == v2 && (exoPlayerImplInternal$PendingMessageInfo1.resolvedPeriodTimeUs > v && exoPlayerImplInternal$PendingMessageInfo1.resolvedPeriodTimeUs <= v1)) {
                try {
                    this.sendMessageToTarget(exoPlayerImplInternal$PendingMessageInfo1.message);
                }
                catch(Throwable throwable0) {
                    if(exoPlayerImplInternal$PendingMessageInfo1.message.getDeleteAfterDelivery() || exoPlayerImplInternal$PendingMessageInfo1.message.isCanceled()) {
                        this.pendingMessages.remove(v3);
                    }
                    throw throwable0;
                }
                if(exoPlayerImplInternal$PendingMessageInfo1.message.getDeleteAfterDelivery() || exoPlayerImplInternal$PendingMessageInfo1.message.isCanceled()) {
                    this.pendingMessages.remove(v3);
                }
                else {
                    ++v3;
                }
                exoPlayerImplInternal$PendingMessageInfo1 = v3 < this.pendingMessages.size() ? ((PendingMessageInfo)this.pendingMessages.get(v3)) : null;
            }
            this.nextPendingMessageIndexHint = v3;
        }
    }

    private void maybeUpdateLoadingPeriod() {
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if(this.queue.shouldLoadNextMediaPeriod()) {
            MediaPeriodInfo mediaPeriodInfo0 = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
            if(mediaPeriodInfo0 == null) {
                this.maybeThrowSourceInfoRefreshError();
            }
            else {
                Allocator allocator0 = this.loadControl.getAllocator();
                MediaPeriodHolder mediaPeriodHolder0 = this.queue.enqueueNextMediaPeriodHolder(this.rendererCapabilities, this.trackSelector, allocator0, this.mediaSource, mediaPeriodInfo0, this.emptyTrackSelectorResult);
                mediaPeriodHolder0.mediaPeriod.prepare(this, mediaPeriodInfo0.startPositionUs);
                if(this.queue.getPlayingPeriod() == mediaPeriodHolder0) {
                    this.resetRendererPosition(mediaPeriodHolder0.getStartPositionRendererTime());
                }
                this.handleLoadingMediaPeriodChanged(false);
            }
        }
        if(this.shouldContinueLoading) {
            this.shouldContinueLoading = this.isLoadingPossible();
            this.updateIsLoading();
            return;
        }
        this.maybeContinueLoading();
    }

    private void maybeUpdatePlayingPeriod() {
        for(boolean z = false; this.shouldAdvancePlayingPeriod(); z = true) {
            if(z) {
                this.maybeNotifyPlaybackInfoChanged();
            }
            MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
            if(mediaPeriodHolder0 == this.queue.getReadingPeriod()) {
                this.setAllRendererStreamsFinal();
            }
            MediaPeriodHolder mediaPeriodHolder1 = this.queue.advancePlayingPeriod();
            this.updatePlayingPeriodRenderers(mediaPeriodHolder0);
            this.playbackInfo = this.copyWithNewPosition(mediaPeriodHolder1.info.id, mediaPeriodHolder1.info.startPositionUs, mediaPeriodHolder1.info.contentPositionUs);
            this.playbackInfoUpdate.setPositionDiscontinuity((mediaPeriodHolder0.info.isLastInTimelinePeriod ? 0 : 3));
            this.updatePlaybackPositions();
        }
    }

    private void maybeUpdateReadingPeriod() {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getReadingPeriod();
        if(mediaPeriodHolder0 != null) {
            if(mediaPeriodHolder0.getNext() != null) {
                if(this.hasReadingPeriodFinishedReading() && mediaPeriodHolder0.getNext().prepared) {
                    TrackSelectorResult trackSelectorResult0 = mediaPeriodHolder0.getTrackSelectorResult();
                    MediaPeriodHolder mediaPeriodHolder1 = this.queue.advanceReadingPeriod();
                    TrackSelectorResult trackSelectorResult1 = mediaPeriodHolder1.getTrackSelectorResult();
                    if(mediaPeriodHolder1.mediaPeriod.readDiscontinuity() != 0x8000000000000001L) {
                        this.setAllRendererStreamsFinal();
                        return;
                    }
                    for(int v1 = 0; true; ++v1) {
                        Renderer[] arr_renderer1 = this.renderers;
                        if(v1 >= arr_renderer1.length) {
                            break;
                        }
                        Renderer renderer1 = arr_renderer1[v1];
                        if(trackSelectorResult0.isRendererEnabled(v1) && !renderer1.isCurrentStreamFinal()) {
                            TrackSelection trackSelection0 = trackSelectorResult1.selections.get(v1);
                            boolean z = trackSelectorResult1.isRendererEnabled(v1);
                            boolean z1 = this.rendererCapabilities[v1].getTrackType() == 6;
                            if(!z || !trackSelectorResult1.rendererConfigurations[v1].equals(trackSelectorResult0.rendererConfigurations[v1]) || z1) {
                                renderer1.setCurrentStreamFinal();
                            }
                            else {
                                renderer1.replaceStream(ExoPlayerImplInternal.getFormats(trackSelection0), mediaPeriodHolder1.sampleStreams[v1], mediaPeriodHolder1.getRendererOffset());
                            }
                        }
                    }
                }
            }
            else if(mediaPeriodHolder0.info.isFinal) {
                for(int v = 0; true; ++v) {
                    Renderer[] arr_renderer = this.renderers;
                    if(v >= arr_renderer.length) {
                        break;
                    }
                    Renderer renderer0 = arr_renderer[v];
                    SampleStream sampleStream0 = mediaPeriodHolder0.sampleStreams[v];
                    if(sampleStream0 != null && renderer0.getStream() == sampleStream0 && renderer0.hasReadStreamToEnd()) {
                        renderer0.setCurrentStreamFinal();
                    }
                }
            }
        }
    }

    private void notifyTrackSelectionDiscontinuity() {
        for(MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod(); mediaPeriodHolder0 != null; mediaPeriodHolder0 = mediaPeriodHolder0.getNext()) {
            TrackSelection[] arr_trackSelection = mediaPeriodHolder0.getTrackSelectorResult().selections.getAll();
            for(int v = 0; v < arr_trackSelection.length; ++v) {
                TrackSelection trackSelection0 = arr_trackSelection[v];
                if(trackSelection0 != null) {
                    trackSelection0.onDiscontinuity();
                }
            }
        }
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod0) {
        this.handler.obtainMessage(10, mediaPeriod0).sendToTarget();
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader$Callback
    public void onContinueLoadingRequested(SequenceableLoader sequenceableLoader0) {
        this.onContinueLoadingRequested(((MediaPeriod)sequenceableLoader0));
    }

    @Override  // com.google.android.exoplayer2.DefaultMediaClock$PlaybackParameterListener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters0) {
        this.sendPlaybackParametersChangedInternal(playbackParameters0, false);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod$Callback
    public void onPrepared(MediaPeriod mediaPeriod0) {
        this.handler.obtainMessage(9, mediaPeriod0).sendToTarget();
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller
    public void onSourceInfoRefreshed(MediaSource mediaSource0, Timeline timeline0) {
        MediaSourceRefreshInfo exoPlayerImplInternal$MediaSourceRefreshInfo0 = new MediaSourceRefreshInfo(mediaSource0, timeline0);
        this.handler.obtainMessage(8, exoPlayerImplInternal$MediaSourceRefreshInfo0).sendToTarget();
    }

    @Override  // com.google.android.exoplayer2.trackselection.TrackSelector$InvalidationListener
    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(11);
    }

    public void prepare(MediaSource mediaSource0, boolean z, boolean z1) {
        this.handler.obtainMessage(0, ((int)z), ((int)z1), mediaSource0).sendToTarget();
    }

    private void prepareInternal(MediaSource mediaSource0, boolean z, boolean z1) {
        ++this.pendingPrepareCount;
        this.resetInternal(false, true, z, z1, true);
        this.loadControl.onPrepared();
        this.mediaSource = mediaSource0;
        this.setState(2);
        mediaSource0.prepareSource(this, this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    public void release() {
        synchronized(this) {
            if(!this.released && this.internalPlaybackThread.isAlive()) {
                this.handler.sendEmptyMessage(7);
                boolean z = false;
                while(!this.released) {
                    try {
                        this.wait();
                    }
                    catch(InterruptedException unused_ex) {
                        z = true;
                    }
                }
                if(z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private void releaseInternal() {
        this.resetInternal(true, true, true, true, false);
        this.loadControl.onReleased();
        this.setState(1);
        this.internalPlaybackThread.quit();
        synchronized(this) {
            this.released = true;
            this.notifyAll();
        }
    }

    private void reselectTracksInternal() {
        float f = this.mediaClock.getPlaybackParameters().speed;
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder1 = this.queue.getReadingPeriod();
        boolean z = true;
        while(mediaPeriodHolder0 != null && mediaPeriodHolder0.prepared) {
            TrackSelectorResult trackSelectorResult0 = mediaPeriodHolder0.selectTracks(f, this.playbackInfo.timeline);
            if(!trackSelectorResult0.isEquivalent(mediaPeriodHolder0.getTrackSelectorResult())) {
                if(z) {
                    MediaPeriodHolder mediaPeriodHolder2 = this.queue.getPlayingPeriod();
                    boolean z1 = this.queue.removeAfter(mediaPeriodHolder2);
                    boolean[] arr_z = new boolean[this.renderers.length];
                    long v = mediaPeriodHolder2.applyTrackSelection(trackSelectorResult0, this.playbackInfo.positionUs, z1, arr_z);
                    if(this.playbackInfo.playbackState != 4 && v != this.playbackInfo.positionUs) {
                        this.playbackInfo = this.copyWithNewPosition(this.playbackInfo.periodId, v, this.playbackInfo.contentPositionUs);
                        this.playbackInfoUpdate.setPositionDiscontinuity(4);
                        this.resetRendererPosition(v);
                    }
                    boolean[] arr_z1 = new boolean[this.renderers.length];
                    int v2 = 0;
                    for(int v1 = 0; true; ++v1) {
                        Renderer[] arr_renderer = this.renderers;
                        if(v1 >= arr_renderer.length) {
                            break;
                        }
                        Renderer renderer0 = arr_renderer[v1];
                        boolean z2 = renderer0.getState() != 0;
                        arr_z1[v1] = z2;
                        SampleStream sampleStream0 = mediaPeriodHolder2.sampleStreams[v1];
                        if(sampleStream0 != null) {
                            ++v2;
                        }
                        if(z2) {
                            if(sampleStream0 != renderer0.getStream()) {
                                this.disableRenderer(renderer0);
                            }
                            else if(arr_z[v1]) {
                                renderer0.resetPosition(this.rendererPositionUs);
                            }
                        }
                    }
                    this.playbackInfo = this.playbackInfo.copyWithTrackInfo(mediaPeriodHolder2.getTrackGroups(), mediaPeriodHolder2.getTrackSelectorResult());
                    this.enableRenderers(arr_z1, v2);
                }
                else {
                    this.queue.removeAfter(mediaPeriodHolder0);
                    if(mediaPeriodHolder0.prepared) {
                        mediaPeriodHolder0.applyTrackSelection(trackSelectorResult0, Math.max(mediaPeriodHolder0.info.startPositionUs, mediaPeriodHolder0.toPeriodTime(this.rendererPositionUs)), false);
                    }
                }
                this.handleLoadingMediaPeriodChanged(true);
                if(this.playbackInfo.playbackState == 4) {
                    break;
                }
                this.maybeContinueLoading();
                this.updatePlaybackPositions();
                this.handler.sendEmptyMessage(2);
                return;
            }
            if(mediaPeriodHolder0 == mediaPeriodHolder1) {
                z = false;
            }
            mediaPeriodHolder0 = mediaPeriodHolder0.getNext();
        }
    }

    private void resetInternal(boolean z, boolean z1, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        this.handler.removeMessages(2);
        this.rebuffering = false;
        this.mediaClock.stop();
        this.rendererPositionUs = 0L;
        Renderer[] arr_renderer = this.enabledRenderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            Renderer renderer0 = arr_renderer[v];
            try {
                this.disableRenderer(renderer0);
            }
            catch(ExoPlaybackException | RuntimeException exoPlaybackException0) {
                Log.e("ExoPlayerImplInternal", "Disable failed.", exoPlaybackException0);
            }
        }
        if(z) {
            Renderer[] arr_renderer1 = this.renderers;
            for(int v1 = 0; v1 < arr_renderer1.length; ++v1) {
                Renderer renderer1 = arr_renderer1[v1];
                try {
                    renderer1.reset();
                }
                catch(RuntimeException runtimeException0) {
                    Log.e("ExoPlayerImplInternal", "Reset failed.", runtimeException0);
                }
            }
        }
        this.enabledRenderers = new Renderer[0];
        if(z2) {
            this.pendingInitialSeekPosition = null;
            z5 = true;
        }
        else if(z3) {
            if(this.pendingInitialSeekPosition == null && !this.playbackInfo.timeline.isEmpty()) {
                this.playbackInfo.timeline.getPeriodByUid(this.playbackInfo.periodId.periodUid, this.period);
                this.pendingInitialSeekPosition = new SeekPosition(Timeline.EMPTY, this.period.windowIndex, this.period.getPositionInWindowUs() + this.playbackInfo.positionUs);
            }
            z5 = true;
        }
        else {
            z5 = false;
        }
        this.queue.clear(!z3);
        this.shouldContinueLoading = false;
        if(z3) {
            this.queue.setTimeline(Timeline.EMPTY);
            for(Object object0: this.pendingMessages) {
                ((PendingMessageInfo)object0).message.markAsProcessed(false);
            }
            this.pendingMessages.clear();
        }
        MediaPeriodId mediaSource$MediaPeriodId0 = z5 ? this.playbackInfo.getDummyFirstMediaPeriodId(this.shuffleModeEnabled, this.window, this.period) : this.playbackInfo.periodId;
        long v2 = 0x8000000000000001L;
        long v3 = z5 ? 0x8000000000000001L : this.playbackInfo.positionUs;
        if(!z5) {
            v2 = this.playbackInfo.contentPositionUs;
        }
        this.playbackInfo = new PlaybackInfo((z3 ? Timeline.EMPTY : this.playbackInfo.timeline), mediaSource$MediaPeriodId0, v3, v2, this.playbackInfo.playbackState, (z4 ? null : this.playbackInfo.playbackError), false, (z3 ? TrackGroupArray.EMPTY : this.playbackInfo.trackGroups), (z3 ? this.emptyTrackSelectorResult : this.playbackInfo.trackSelectorResult), mediaSource$MediaPeriodId0, v3, 0L, v3);
        if(z1) {
            MediaSource mediaSource0 = this.mediaSource;
            if(mediaSource0 != null) {
                try {
                    mediaSource0.releaseSource(this);
                }
                catch(RuntimeException runtimeException1) {
                    Log.e("ExoPlayerImplInternal", "Failed to release child source.", runtimeException1);
                }
                this.mediaSource = null;
            }
        }
    }

    private void resetRendererPosition(long v) {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
        if(mediaPeriodHolder0 != null) {
            v = mediaPeriodHolder0.toRendererTime(v);
        }
        this.rendererPositionUs = v;
        this.mediaClock.resetPosition(v);
        Renderer[] arr_renderer = this.enabledRenderers;
        for(int v1 = 0; v1 < arr_renderer.length; ++v1) {
            arr_renderer[v1].resetPosition(this.rendererPositionUs);
        }
        this.notifyTrackSelectionDiscontinuity();
    }

    private boolean resolvePendingMessagePosition(PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo0) {
        Object object0 = exoPlayerImplInternal$PendingMessageInfo0.resolvedPeriodUid;
        if(object0 == null) {
            Pair pair0 = this.resolveSeekPosition(new SeekPosition(exoPlayerImplInternal$PendingMessageInfo0.message.getTimeline(), exoPlayerImplInternal$PendingMessageInfo0.message.getWindowIndex(), C.msToUs(exoPlayerImplInternal$PendingMessageInfo0.message.getPositionMs())), false);
            if(pair0 == null) {
                return false;
            }
            exoPlayerImplInternal$PendingMessageInfo0.setResolvedPosition(this.playbackInfo.timeline.getIndexOfPeriod(pair0.first), ((long)(((Long)pair0.second))), pair0.first);
            return true;
        }
        int v = this.playbackInfo.timeline.getIndexOfPeriod(object0);
        if(v == -1) {
            return false;
        }
        exoPlayerImplInternal$PendingMessageInfo0.resolvedPeriodIndex = v;
        return true;
    }

    private void resolvePendingMessagePositions() {
        for(int v = this.pendingMessages.size() - 1; v >= 0; --v) {
            if(!this.resolvePendingMessagePosition(((PendingMessageInfo)this.pendingMessages.get(v)))) {
                ((PendingMessageInfo)this.pendingMessages.get(v)).message.markAsProcessed(false);
                this.pendingMessages.remove(v);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    private Pair resolveSeekPosition(SeekPosition exoPlayerImplInternal$SeekPosition0, boolean z) {
        Pair pair0;
        Timeline timeline0 = this.playbackInfo.timeline;
        Timeline timeline1 = exoPlayerImplInternal$SeekPosition0.timeline;
        if(timeline0.isEmpty()) {
            return null;
        }
        Timeline timeline2 = timeline1.isEmpty() ? timeline0 : timeline1;
        try {
            pair0 = timeline2.getPeriodPosition(this.window, this.period, exoPlayerImplInternal$SeekPosition0.windowIndex, exoPlayerImplInternal$SeekPosition0.windowPositionUs);
            if(timeline0 == timeline2) {
                return pair0;
            }
        }
        catch(IndexOutOfBoundsException unused_ex) {
            return null;
        }
        if(timeline0.getIndexOfPeriod(pair0.first) != -1) {
            return pair0;
        }
        if(z) {
            Object object0 = this.resolveSubsequentPeriod(pair0.first, timeline2, timeline0);
            return object0 == null ? null : this.getPeriodPosition(timeline0, timeline0.getPeriodByUid(object0, this.period).windowIndex, 0x8000000000000001L);
        }
        return null;
    }

    private Object resolveSubsequentPeriod(Object object0, Timeline timeline0, Timeline timeline1) {
        int v = timeline0.getIndexOfPeriod(object0);
        int v1 = timeline0.getPeriodCount();
        int v3 = v;
        int v4 = -1;
        for(int v2 = 0; v2 < v1 && v4 == -1; ++v2) {
            v3 = timeline0.getNextPeriodIndex(v3, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if(v3 == -1) {
                break;
            }
            v4 = timeline1.getIndexOfPeriod(timeline0.getUidOfPeriod(v3));
        }
        return v4 == -1 ? null : timeline1.getUidOfPeriod(v4);
    }

    private void scheduleNextWork(long v, long v1) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, v + v1);
    }

    public void seekTo(Timeline timeline0, int v, long v1) {
        SeekPosition exoPlayerImplInternal$SeekPosition0 = new SeekPosition(timeline0, v, v1);
        this.handler.obtainMessage(3, exoPlayerImplInternal$SeekPosition0).sendToTarget();
    }

    private void seekToCurrentPosition(boolean z) {
        MediaPeriodId mediaSource$MediaPeriodId0 = this.queue.getPlayingPeriod().info.id;
        long v = this.seekToPeriodPosition(mediaSource$MediaPeriodId0, this.playbackInfo.positionUs, true);
        if(v != this.playbackInfo.positionUs) {
            this.playbackInfo = this.copyWithNewPosition(mediaSource$MediaPeriodId0, v, this.playbackInfo.contentPositionUs);
            if(z) {
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
    }

    private void seekToInternal(SeekPosition exoPlayerImplInternal$SeekPosition0) {
        long v7;
        MediaPeriodId mediaSource$MediaPeriodId1;
        long v6;
        MediaPeriodHolder mediaPeriodHolder0;
        long v5;
        long v4;
        long v2;
        long v1;
        int v;
        MediaPeriodId mediaSource$MediaPeriodId0;
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        Pair pair0 = this.resolveSeekPosition(exoPlayerImplInternal$SeekPosition0, true);
        if(pair0 == null) {
            mediaSource$MediaPeriodId0 = this.playbackInfo.getDummyFirstMediaPeriodId(this.shuffleModeEnabled, this.window, this.period);
            v = 1;
            v1 = 0x8000000000000001L;
            v2 = 0x8000000000000001L;
        }
        else {
            Object object0 = pair0.first;
            long v3 = (long)(((Long)pair0.second));
            mediaSource$MediaPeriodId0 = this.queue.resolveMediaPeriodIdForAds(object0, v3);
            if(mediaSource$MediaPeriodId0.isAd()) {
                v2 = 0L;
                v1 = v3;
                v = 1;
            }
            else {
                v2 = (long)(((Long)pair0.second));
                v1 = v3;
                v = exoPlayerImplInternal$SeekPosition0.windowPositionUs == 0x8000000000000001L ? 1 : 0;
            }
        }
        if(this.mediaSource == null || this.pendingPrepareCount > 0) {
            try {
                v4 = v1;
                this.pendingInitialSeekPosition = exoPlayerImplInternal$SeekPosition0;
                v5 = v2;
                goto label_67;
            }
            catch(Throwable throwable0) {
                goto label_61;
            }
        }
        else if(v2 == 0x8000000000000001L) {
            try {
                this.setState(4);
                this.resetInternal(false, false, true, false, true);
                v4 = v1;
                v5 = 0x8000000000000001L;
                goto label_67;
            }
            catch(Throwable throwable0) {
                mediaSource$MediaPeriodId1 = mediaSource$MediaPeriodId0;
                v7 = v1;
                goto label_63;
            }
        }
        else {
            try {
                if(mediaSource$MediaPeriodId0.equals(this.playbackInfo.periodId)) {
                    mediaPeriodHolder0 = this.queue.getPlayingPeriod();
                    if(mediaPeriodHolder0 == null) {
                        goto label_38;
                    }
                    else {
                        goto label_33;
                    }
                    goto label_44;
                }
                else {
                    v4 = v1;
                    v5 = this.seekToPeriodPosition(mediaSource$MediaPeriodId0, v2);
                    v |= (v2 == v5 ? 0 : 1);
                    goto label_67;
                }
                goto label_70;
            }
            catch(Throwable throwable0) {
                v4 = v1;
                goto label_61;
            }
            try {
            label_33:
                if(!mediaPeriodHolder0.prepared || v2 == 0L) {
                    v6 = v2;
                    goto label_44;
                label_38:
                    v6 = v2;
                }
                else {
                    v6 = mediaPeriodHolder0.mediaPeriod.getAdjustedSeekPositionUs(v2, this.seekParameters);
                }
            }
            catch(Throwable throwable0) {
                mediaSource$MediaPeriodId1 = mediaSource$MediaPeriodId0;
                v7 = v1;
                goto label_63;
            }
            try {
            label_44:
                if(C.usToMs(v6) == C.usToMs(this.playbackInfo.positionUs)) {
                    goto label_49;
                }
                else {
                    v4 = v1;
                    v5 = this.seekToPeriodPosition(mediaSource$MediaPeriodId0, v6);
                    v |= (v2 == v5 ? 0 : 1);
                    goto label_67;
                }
                goto label_70;
            }
            catch(Throwable throwable0) {
                v4 = v1;
                goto label_61;
            }
        label_49:
            this.playbackInfo = this.copyWithNewPosition(mediaSource$MediaPeriodId0, this.playbackInfo.positionUs, v1);
            if(v == 0) {
                return;
            }
            goto label_70;
            try {
                v4 = v1;
                v5 = this.seekToPeriodPosition(mediaSource$MediaPeriodId0, v6);
                v |= (v2 == v5 ? 0 : 1);
                goto label_67;
            }
            catch(Throwable throwable0) {
            }
        label_61:
            v7 = v4;
            mediaSource$MediaPeriodId1 = mediaSource$MediaPeriodId0;
        label_63:
            this.playbackInfo = this.copyWithNewPosition(mediaSource$MediaPeriodId1, v2, v7);
            if(v != 0) {
                this.playbackInfoUpdate.setPositionDiscontinuity(2);
            }
            throw throwable0;
        label_67:
            this.playbackInfo = this.copyWithNewPosition(mediaSource$MediaPeriodId0, v5, v4);
            if(v == 0) {
                return;
            }
        }
    label_70:
        this.playbackInfoUpdate.setPositionDiscontinuity(2);
    }

    private long seekToPeriodPosition(MediaPeriodId mediaSource$MediaPeriodId0, long v) {
        return this.queue.getPlayingPeriod() == this.queue.getReadingPeriod() ? this.seekToPeriodPosition(mediaSource$MediaPeriodId0, v, false) : this.seekToPeriodPosition(mediaSource$MediaPeriodId0, v, true);
    }

    private long seekToPeriodPosition(MediaPeriodId mediaSource$MediaPeriodId0, long v, boolean z) {
        this.stopRenderers();
        this.rebuffering = false;
        if(this.playbackInfo.playbackState != 1 && !this.playbackInfo.timeline.isEmpty()) {
            this.setState(2);
        }
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder1;
        for(mediaPeriodHolder1 = mediaPeriodHolder0; mediaPeriodHolder1 != null; mediaPeriodHolder1 = this.queue.advancePlayingPeriod()) {
            if(mediaSource$MediaPeriodId0.equals(mediaPeriodHolder1.info.id) && mediaPeriodHolder1.prepared) {
                this.queue.removeAfter(mediaPeriodHolder1);
                break;
            }
        }
        if(z || mediaPeriodHolder0 != mediaPeriodHolder1 || mediaPeriodHolder1 != null && mediaPeriodHolder1.toRendererTime(v) < 0L) {
            Renderer[] arr_renderer = this.enabledRenderers;
            for(int v1 = 0; v1 < arr_renderer.length; ++v1) {
                this.disableRenderer(arr_renderer[v1]);
            }
            this.enabledRenderers = new Renderer[0];
            if(mediaPeriodHolder1 != null) {
                mediaPeriodHolder1.setRendererOffset(0L);
            }
            mediaPeriodHolder0 = null;
        }
        if(mediaPeriodHolder1 == null) {
            this.queue.clear(true);
            this.playbackInfo = this.playbackInfo.copyWithTrackInfo(TrackGroupArray.EMPTY, this.emptyTrackSelectorResult);
            this.resetRendererPosition(v);
        }
        else {
            this.updatePlayingPeriodRenderers(mediaPeriodHolder0);
            if(mediaPeriodHolder1.hasEnabledTracks) {
                v = mediaPeriodHolder1.mediaPeriod.seekToUs(v);
                mediaPeriodHolder1.mediaPeriod.discardBuffer(v - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
            }
            this.resetRendererPosition(v);
            this.maybeContinueLoading();
        }
        this.handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return v;
    }

    @Override  // com.google.android.exoplayer2.PlayerMessage$Sender
    public void sendMessage(PlayerMessage playerMessage0) {
        synchronized(this) {
            if(!this.released && this.internalPlaybackThread.isAlive()) {
                this.handler.obtainMessage(15, playerMessage0).sendToTarget();
                return;
            }
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            playerMessage0.markAsProcessed(false);
        }
    }

    private void sendMessageInternal(PlayerMessage playerMessage0) {
        if(playerMessage0.getPositionMs() == 0x8000000000000001L) {
            this.sendMessageToTarget(playerMessage0);
            return;
        }
        if(this.mediaSource != null && this.pendingPrepareCount <= 0) {
            PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo0 = new PendingMessageInfo(playerMessage0);
            if(this.resolvePendingMessagePosition(exoPlayerImplInternal$PendingMessageInfo0)) {
                this.pendingMessages.add(exoPlayerImplInternal$PendingMessageInfo0);
                Collections.sort(this.pendingMessages);
                return;
            }
            playerMessage0.markAsProcessed(false);
            return;
        }
        PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo1 = new PendingMessageInfo(playerMessage0);
        this.pendingMessages.add(exoPlayerImplInternal$PendingMessageInfo1);
    }

    private void sendMessageToTarget(PlayerMessage playerMessage0) {
        if(playerMessage0.getHandler().getLooper() == this.handler.getLooper()) {
            this.deliverMessage(playerMessage0);
            if(this.playbackInfo.playbackState != 2 && this.playbackInfo.playbackState != 3) {
                return;
            }
            this.handler.sendEmptyMessage(2);
            return;
        }
        this.handler.obtainMessage(16, playerMessage0).sendToTarget();
    }

    private void sendMessageToTargetThread(PlayerMessage playerMessage0) {
        Handler handler0 = playerMessage0.getHandler();
        if(!handler0.getLooper().getThread().isAlive()) {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage0.markAsProcessed(false);
            return;
        }
        handler0.post(new com.google.android.exoplayer2.d(1, this, playerMessage0));
    }

    private void sendPlaybackParametersChangedInternal(PlaybackParameters playbackParameters0, boolean z) {
        this.handler.obtainMessage(17, ((int)z), 0, playbackParameters0).sendToTarget();
    }

    private void setAllRendererStreamsFinal() {
        Renderer[] arr_renderer = this.renderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            Renderer renderer0 = arr_renderer[v];
            if(renderer0.getStream() != null) {
                renderer0.setCurrentStreamFinal();
            }
        }
    }

    public void setForegroundMode(boolean z) {
        boolean z1 = false;
        synchronized(this) {
            if(!this.released && this.internalPlaybackThread.isAlive()) {
                if(z) {
                    this.handler.obtainMessage(14, 1, 0).sendToTarget();
                }
                else {
                    AtomicBoolean atomicBoolean0 = new AtomicBoolean();
                    this.handler.obtainMessage(14, 0, 0, atomicBoolean0).sendToTarget();
                    while(!atomicBoolean0.get()) {
                        try {
                            this.wait();
                        }
                        catch(InterruptedException unused_ex) {
                            z1 = true;
                        }
                    }
                    if(z1) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    private void setForegroundModeInternal(boolean z, AtomicBoolean atomicBoolean0) {
        if(this.foregroundMode != z) {
            this.foregroundMode = z;
            if(!z) {
                Renderer[] arr_renderer = this.renderers;
                for(int v = 0; v < arr_renderer.length; ++v) {
                    Renderer renderer0 = arr_renderer[v];
                    if(renderer0.getState() == 0) {
                        renderer0.reset();
                    }
                }
            }
        }
        if(atomicBoolean0 != null) {
            synchronized(this) {
                atomicBoolean0.set(true);
                this.notifyAll();
            }
        }
    }

    public void setPlayWhenReady(boolean z) {
        this.handler.obtainMessage(1, ((int)z), 0).sendToTarget();
    }

    private void setPlayWhenReadyInternal(boolean z) {
        this.rebuffering = false;
        this.playWhenReady = z;
        if(!z) {
            this.stopRenderers();
            this.updatePlaybackPositions();
            return;
        }
        int v = this.playbackInfo.playbackState;
        if(v == 3) {
            this.startRenderers();
            this.handler.sendEmptyMessage(2);
            return;
        }
        if(v == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters0) {
        this.handler.obtainMessage(4, playbackParameters0).sendToTarget();
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters0) {
        this.mediaClock.setPlaybackParameters(playbackParameters0);
        this.sendPlaybackParametersChangedInternal(this.mediaClock.getPlaybackParameters(), true);
    }

    public void setRepeatMode(int v) {
        this.handler.obtainMessage(12, v, 0).sendToTarget();
    }

    private void setRepeatModeInternal(int v) {
        this.repeatMode = v;
        if(!this.queue.updateRepeatMode(v)) {
            this.seekToCurrentPosition(true);
        }
        this.handleLoadingMediaPeriodChanged(false);
    }

    public void setSeekParameters(SeekParameters seekParameters0) {
        this.handler.obtainMessage(5, seekParameters0).sendToTarget();
    }

    private void setSeekParametersInternal(SeekParameters seekParameters0) {
        this.seekParameters = seekParameters0;
    }

    public void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(13, ((int)z), 0).sendToTarget();
    }

    private void setShuffleModeEnabledInternal(boolean z) {
        this.shuffleModeEnabled = z;
        if(!this.queue.updateShuffleModeEnabled(z)) {
            this.seekToCurrentPosition(true);
        }
        this.handleLoadingMediaPeriodChanged(false);
    }

    private void setState(int v) {
        PlaybackInfo playbackInfo0 = this.playbackInfo;
        if(playbackInfo0.playbackState != v) {
            this.playbackInfo = playbackInfo0.copyWithPlaybackState(v);
        }
    }

    private boolean shouldAdvancePlayingPeriod() {
        if(!this.playWhenReady) {
            return false;
        }
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
        if(mediaPeriodHolder0 == null) {
            return false;
        }
        MediaPeriodHolder mediaPeriodHolder1 = mediaPeriodHolder0.getNext();
        if(mediaPeriodHolder1 == null) {
            return false;
        }
        return mediaPeriodHolder0 != this.queue.getReadingPeriod() || this.hasReadingPeriodFinishedReading() ? this.rendererPositionUs >= mediaPeriodHolder1.getStartPositionRendererTime() : false;
    }

    private boolean shouldContinueLoading() {
        if(!this.isLoadingPossible()) {
            return false;
        }
        long v = this.getTotalBufferedDurationUs(this.queue.getLoadingPeriod().getNextLoadPositionUs());
        PlaybackParameters playbackParameters0 = this.mediaClock.getPlaybackParameters();
        return this.loadControl.shouldContinueLoading(v, playbackParameters0.speed);
    }

    private boolean shouldTransitionToReadyState(boolean z) {
        if(this.enabledRenderers.length == 0) {
            return this.isTimelineReady();
        }
        if(!z) {
            return false;
        }
        if(!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getLoadingPeriod();
        if(!mediaPeriodHolder0.isFullyBuffered() || !mediaPeriodHolder0.info.isFinal) {
            long v = this.getTotalBufferedDurationUs();
            PlaybackParameters playbackParameters0 = this.mediaClock.getPlaybackParameters();
            return this.loadControl.shouldStartPlayback(v, playbackParameters0.speed, this.rebuffering);
        }
        return true;
    }

    private void startRenderers() {
        this.rebuffering = false;
        this.mediaClock.start();
        Renderer[] arr_renderer = this.enabledRenderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            arr_renderer[v].start();
        }
    }

    public void stop(boolean z) {
        this.handler.obtainMessage(6, ((int)z), 0).sendToTarget();
    }

    private void stopInternal(boolean z, boolean z1, boolean z2) {
        this.resetInternal(z || !this.foregroundMode, true, z1, z1, z1);
        this.playbackInfoUpdate.incrementPendingOperationAcks(this.pendingPrepareCount + ((int)z2));
        this.pendingPrepareCount = 0;
        this.loadControl.onStopped();
        this.setState(1);
    }

    private void stopRenderers() {
        this.mediaClock.stop();
        Renderer[] arr_renderer = this.enabledRenderers;
        for(int v = 0; v < arr_renderer.length; ++v) {
            this.ensureStopped(arr_renderer[v]);
        }
    }

    private void updateIsLoading() {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getLoadingPeriod();
        boolean z = this.shouldContinueLoading || mediaPeriodHolder0 != null && mediaPeriodHolder0.mediaPeriod.isLoading();
        PlaybackInfo playbackInfo0 = this.playbackInfo;
        if(z != playbackInfo0.isLoading) {
            this.playbackInfo = playbackInfo0.copyWithIsLoading(z);
        }
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray0, TrackSelectorResult trackSelectorResult0) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray0, trackSelectorResult0.selections);
    }

    private void updatePeriods() {
        MediaSource mediaSource0 = this.mediaSource;
        if(mediaSource0 == null) {
            return;
        }
        if(this.pendingPrepareCount > 0) {
            mediaSource0.maybeThrowSourceInfoRefreshError();
            return;
        }
        this.maybeUpdateLoadingPeriod();
        this.maybeUpdateReadingPeriod();
        this.maybeUpdatePlayingPeriod();
    }

    private void updatePlaybackPositions() {
        MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod();
        if(mediaPeriodHolder0 == null) {
            return;
        }
        long v = mediaPeriodHolder0.prepared ? mediaPeriodHolder0.mediaPeriod.readDiscontinuity() : 0x8000000000000001L;
        if(v == 0x8000000000000001L) {
            long v1 = this.mediaClock.syncAndGetPositionUs(mediaPeriodHolder0 != this.queue.getReadingPeriod());
            this.rendererPositionUs = v1;
            long v2 = mediaPeriodHolder0.toPeriodTime(v1);
            this.maybeTriggerPendingMessages(this.playbackInfo.positionUs, v2);
            this.playbackInfo.positionUs = v2;
        }
        else {
            this.resetRendererPosition(v);
            if(v != this.playbackInfo.positionUs) {
                this.playbackInfo = this.copyWithNewPosition(this.playbackInfo.periodId, v, this.playbackInfo.contentPositionUs);
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
        PlaybackInfo playbackInfo0 = this.playbackInfo;
        playbackInfo0.bufferedPositionUs = this.queue.getLoadingPeriod().getBufferedPositionUs();
        this.playbackInfo.totalBufferedDurationUs = this.getTotalBufferedDurationUs();
    }

    private void updatePlayingPeriodRenderers(MediaPeriodHolder mediaPeriodHolder0) {
        MediaPeriodHolder mediaPeriodHolder1 = this.queue.getPlayingPeriod();
        if(mediaPeriodHolder1 != null && mediaPeriodHolder0 != mediaPeriodHolder1) {
            boolean[] arr_z = new boolean[this.renderers.length];
            int v1 = 0;
            for(int v = 0; true; ++v) {
                Renderer[] arr_renderer = this.renderers;
                if(v >= arr_renderer.length) {
                    break;
                }
                Renderer renderer0 = arr_renderer[v];
                arr_z[v] = renderer0.getState() != 0;
                if(mediaPeriodHolder1.getTrackSelectorResult().isRendererEnabled(v)) {
                    ++v1;
                }
                if(arr_z[v] && (!mediaPeriodHolder1.getTrackSelectorResult().isRendererEnabled(v) || renderer0.isCurrentStreamFinal() && renderer0.getStream() == mediaPeriodHolder0.sampleStreams[v])) {
                    this.disableRenderer(renderer0);
                }
            }
            this.playbackInfo = this.playbackInfo.copyWithTrackInfo(mediaPeriodHolder1.getTrackGroups(), mediaPeriodHolder1.getTrackSelectorResult());
            this.enableRenderers(arr_z, v1);
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f) {
        for(MediaPeriodHolder mediaPeriodHolder0 = this.queue.getPlayingPeriod(); mediaPeriodHolder0 != null; mediaPeriodHolder0 = mediaPeriodHolder0.getNext()) {
            TrackSelection[] arr_trackSelection = mediaPeriodHolder0.getTrackSelectorResult().selections.getAll();
            for(int v = 0; v < arr_trackSelection.length; ++v) {
                TrackSelection trackSelection0 = arr_trackSelection[v];
                if(trackSelection0 != null) {
                    trackSelection0.onPlaybackSpeed(f);
                }
            }
        }
    }

    class com.google.android.exoplayer2.ExoPlayerImplInternal.1 {
    }

}

