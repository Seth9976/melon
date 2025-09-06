package com.google.android.exoplayer2.analytics;

import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline.Window;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaSourceEventListener.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.iloen.melon.utils.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class AnalyticsCollector implements EventListener, AudioListener, AudioRendererEventListener, DefaultDrmSessionEventListener, MetadataOutput, MediaSourceEventListener, com.google.android.exoplayer2.upstream.BandwidthMeter.EventListener, VideoListener, VideoRendererEventListener {
    static final class MediaPeriodInfo {
        public final MediaPeriodId mediaPeriodId;
        public final Timeline timeline;
        public final int windowIndex;

        public MediaPeriodInfo(MediaPeriodId mediaSource$MediaPeriodId0, Timeline timeline0, int v) {
            this.mediaPeriodId = mediaSource$MediaPeriodId0;
            this.timeline = timeline0;
            this.windowIndex = v;
        }
    }

    static final class MediaPeriodQueueTracker {
        private boolean isSeeking;
        private MediaPeriodInfo lastPlayingMediaPeriod;
        private MediaPeriodInfo lastReportedPlayingMediaPeriod;
        private final HashMap mediaPeriodIdToInfo;
        private final ArrayList mediaPeriodInfoQueue;
        private final Period period;
        private MediaPeriodInfo readingMediaPeriod;
        private Timeline timeline;

        public MediaPeriodQueueTracker() {
            this.mediaPeriodInfoQueue = new ArrayList();
            this.mediaPeriodIdToInfo = new HashMap();
            this.period = new Period();
            this.timeline = Timeline.EMPTY;
        }

        public static ArrayList access$000(MediaPeriodQueueTracker analyticsCollector$MediaPeriodQueueTracker0) {
            return analyticsCollector$MediaPeriodQueueTracker0.mediaPeriodInfoQueue;
        }

        public MediaPeriodInfo getLastReportedPlayingMediaPeriod() {
            return this.lastReportedPlayingMediaPeriod;
        }

        // 去混淆评级： 低(20)
        public MediaPeriodInfo getLoadingMediaPeriod() {
            return this.mediaPeriodInfoQueue.isEmpty() ? null : ((MediaPeriodInfo)a.i(1, this.mediaPeriodInfoQueue));
        }

        public MediaPeriodInfo getMediaPeriodInfo(MediaPeriodId mediaSource$MediaPeriodId0) {
            return (MediaPeriodInfo)this.mediaPeriodIdToInfo.get(mediaSource$MediaPeriodId0);
        }

        // 去混淆评级： 低(30)
        public MediaPeriodInfo getPlayingMediaPeriod() {
            return this.mediaPeriodInfoQueue.isEmpty() || this.timeline.isEmpty() || this.isSeeking ? null : ((MediaPeriodInfo)this.mediaPeriodInfoQueue.get(0));
        }

        public MediaPeriodInfo getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public boolean isSeeking() {
            return this.isSeeking;
        }

        public void onMediaPeriodCreated(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
            int v1 = this.timeline.getIndexOfPeriod(mediaSource$MediaPeriodId0.periodUid);
            Timeline timeline0 = v1 == -1 ? this.timeline : Timeline.EMPTY;
            if(v1 != -1) {
                v = this.timeline.getPeriod(v1, this.period).windowIndex;
            }
            MediaPeriodInfo analyticsCollector$MediaPeriodInfo0 = new MediaPeriodInfo(mediaSource$MediaPeriodId0, timeline0, v);
            this.mediaPeriodInfoQueue.add(analyticsCollector$MediaPeriodInfo0);
            this.mediaPeriodIdToInfo.put(mediaSource$MediaPeriodId0, analyticsCollector$MediaPeriodInfo0);
            this.lastPlayingMediaPeriod = (MediaPeriodInfo)this.mediaPeriodInfoQueue.get(0);
            if(this.mediaPeriodInfoQueue.size() == 1 && !this.timeline.isEmpty()) {
                this.lastReportedPlayingMediaPeriod = this.lastPlayingMediaPeriod;
            }
        }

        public boolean onMediaPeriodReleased(MediaPeriodId mediaSource$MediaPeriodId0) {
            MediaPeriodInfo analyticsCollector$MediaPeriodInfo0 = (MediaPeriodInfo)this.mediaPeriodIdToInfo.remove(mediaSource$MediaPeriodId0);
            if(analyticsCollector$MediaPeriodInfo0 == null) {
                return false;
            }
            this.mediaPeriodInfoQueue.remove(analyticsCollector$MediaPeriodInfo0);
            if(this.readingMediaPeriod != null && mediaSource$MediaPeriodId0.equals(this.readingMediaPeriod.mediaPeriodId)) {
                this.readingMediaPeriod = this.mediaPeriodInfoQueue.isEmpty() ? null : ((MediaPeriodInfo)this.mediaPeriodInfoQueue.get(0));
            }
            if(!this.mediaPeriodInfoQueue.isEmpty()) {
                this.lastPlayingMediaPeriod = (MediaPeriodInfo)this.mediaPeriodInfoQueue.get(0);
            }
            return true;
        }

        public void onPositionDiscontinuity(int v) {
            this.lastReportedPlayingMediaPeriod = this.lastPlayingMediaPeriod;
        }

        public void onReadingStarted(MediaPeriodId mediaSource$MediaPeriodId0) {
            this.readingMediaPeriod = (MediaPeriodInfo)this.mediaPeriodIdToInfo.get(mediaSource$MediaPeriodId0);
        }

        public void onSeekProcessed() {
            this.isSeeking = false;
            this.lastReportedPlayingMediaPeriod = this.lastPlayingMediaPeriod;
        }

        public void onSeekStarted() {
            this.isSeeking = true;
        }

        public void onTimelineChanged(Timeline timeline0) {
            for(int v = 0; v < this.mediaPeriodInfoQueue.size(); ++v) {
                MediaPeriodInfo analyticsCollector$MediaPeriodInfo0 = this.updateMediaPeriodInfoToNewTimeline(((MediaPeriodInfo)this.mediaPeriodInfoQueue.get(v)), timeline0);
                this.mediaPeriodInfoQueue.set(v, analyticsCollector$MediaPeriodInfo0);
                this.mediaPeriodIdToInfo.put(analyticsCollector$MediaPeriodInfo0.mediaPeriodId, analyticsCollector$MediaPeriodInfo0);
            }
            MediaPeriodInfo analyticsCollector$MediaPeriodInfo1 = this.readingMediaPeriod;
            if(analyticsCollector$MediaPeriodInfo1 != null) {
                this.readingMediaPeriod = this.updateMediaPeriodInfoToNewTimeline(analyticsCollector$MediaPeriodInfo1, timeline0);
            }
            this.timeline = timeline0;
            this.lastReportedPlayingMediaPeriod = this.lastPlayingMediaPeriod;
        }

        public MediaPeriodInfo tryResolveWindowIndex(int v) {
            MediaPeriodInfo analyticsCollector$MediaPeriodInfo0 = null;
            for(int v1 = 0; v1 < this.mediaPeriodInfoQueue.size(); ++v1) {
                MediaPeriodInfo analyticsCollector$MediaPeriodInfo1 = (MediaPeriodInfo)this.mediaPeriodInfoQueue.get(v1);
                int v2 = this.timeline.getIndexOfPeriod(analyticsCollector$MediaPeriodInfo1.mediaPeriodId.periodUid);
                if(v2 != -1 && this.timeline.getPeriod(v2, this.period).windowIndex == v) {
                    if(analyticsCollector$MediaPeriodInfo0 != null) {
                        return null;
                    }
                    analyticsCollector$MediaPeriodInfo0 = analyticsCollector$MediaPeriodInfo1;
                }
            }
            return analyticsCollector$MediaPeriodInfo0;
        }

        private MediaPeriodInfo updateMediaPeriodInfoToNewTimeline(MediaPeriodInfo analyticsCollector$MediaPeriodInfo0, Timeline timeline0) {
            int v = timeline0.getIndexOfPeriod(analyticsCollector$MediaPeriodInfo0.mediaPeriodId.periodUid);
            if(v == -1) {
                return analyticsCollector$MediaPeriodInfo0;
            }
            Period timeline$Period0 = timeline0.getPeriod(v, this.period);
            return new MediaPeriodInfo(analyticsCollector$MediaPeriodInfo0.mediaPeriodId, timeline0, timeline$Period0.windowIndex);
        }
    }

    private final Clock clock;
    private final CopyOnWriteArraySet listeners;
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker;
    private Player player;
    private final Window window;

    public AnalyticsCollector(Clock clock0) {
        this.clock = (Clock)Assertions.checkNotNull(clock0);
        this.listeners = new CopyOnWriteArraySet();
        this.mediaPeriodQueueTracker = new MediaPeriodQueueTracker();
        this.window = new Window();
    }

    public void addListener(AnalyticsListener analyticsListener0) {
        this.listeners.add(analyticsListener0);
    }

    private EventTime generateEventTime(MediaPeriodInfo analyticsCollector$MediaPeriodInfo0) {
        Assertions.checkNotNull(this.player);
        if(analyticsCollector$MediaPeriodInfo0 == null) {
            int v = this.player.getCurrentWindowIndex();
            MediaPeriodInfo analyticsCollector$MediaPeriodInfo1 = this.mediaPeriodQueueTracker.tryResolveWindowIndex(v);
            if(analyticsCollector$MediaPeriodInfo1 == null) {
                Timeline timeline0 = this.player.getCurrentTimeline();
                if(v >= timeline0.getWindowCount()) {
                    timeline0 = Timeline.EMPTY;
                }
                return this.generateEventTime(timeline0, v, null);
            }
            analyticsCollector$MediaPeriodInfo0 = analyticsCollector$MediaPeriodInfo1;
        }
        return this.generateEventTime(analyticsCollector$MediaPeriodInfo0.timeline, analyticsCollector$MediaPeriodInfo0.windowIndex, analyticsCollector$MediaPeriodInfo0.mediaPeriodId);
    }

    @RequiresNonNull({"player"})
    public EventTime generateEventTime(Timeline timeline0, int v, MediaPeriodId mediaSource$MediaPeriodId0) {
        if(timeline0.isEmpty()) {
            mediaSource$MediaPeriodId0 = null;
        }
        long v1 = this.clock.elapsedRealtime();
        boolean z = timeline0 == this.player.getCurrentTimeline() && v == this.player.getCurrentWindowIndex();
        long v2 = 0L;
        if(mediaSource$MediaPeriodId0 != null && mediaSource$MediaPeriodId0.isAd()) {
            if(z && this.player.getCurrentAdGroupIndex() == mediaSource$MediaPeriodId0.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaSource$MediaPeriodId0.adIndexInAdGroup) {
                v2 = this.player.getCurrentPosition();
            }
            return new EventTime(v1, timeline0, v, mediaSource$MediaPeriodId0, v2, this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
        }
        if(z) {
            return new EventTime(v1, timeline0, v, mediaSource$MediaPeriodId0, this.player.getContentPosition(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
        }
        return timeline0.isEmpty() ? new EventTime(v1, timeline0, v, mediaSource$MediaPeriodId0, 0L, this.player.getCurrentPosition(), this.player.getTotalBufferedDuration()) : new EventTime(v1, timeline0, v, mediaSource$MediaPeriodId0, timeline0.getWindow(v, this.window).getDefaultPositionMs(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    private EventTime generateLastReportedPlayingMediaPeriodEventTime() {
        return this.generateEventTime(this.mediaPeriodQueueTracker.getLastReportedPlayingMediaPeriod());
    }

    private EventTime generateLoadingMediaPeriodEventTime() {
        return this.generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private EventTime generateMediaPeriodEventTime(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
        Assertions.checkNotNull(this.player);
        if(mediaSource$MediaPeriodId0 != null) {
            MediaPeriodInfo analyticsCollector$MediaPeriodInfo0 = this.mediaPeriodQueueTracker.getMediaPeriodInfo(mediaSource$MediaPeriodId0);
            return analyticsCollector$MediaPeriodInfo0 == null ? this.generateEventTime(Timeline.EMPTY, v, mediaSource$MediaPeriodId0) : this.generateEventTime(analyticsCollector$MediaPeriodInfo0);
        }
        Timeline timeline0 = this.player.getCurrentTimeline();
        if(v >= timeline0.getWindowCount()) {
            timeline0 = Timeline.EMPTY;
        }
        return this.generateEventTime(timeline0, v, null);
    }

    private EventTime generatePlayingMediaPeriodEventTime() {
        return this.generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private EventTime generateReadingMediaPeriodEventTime() {
        return this.generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    public Set getListeners() {
        return Collections.unmodifiableSet(this.listeners);
    }

    public final void notifySeekStarted() {
        if(!this.mediaPeriodQueueTracker.isSeeking()) {
            EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
            this.mediaPeriodQueueTracker.onSeekStarted();
            for(Object object0: this.listeners) {
                ((AnalyticsListener)object0).onSeekStarted(analyticsListener$EventTime0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioListener
    public void onAudioAttributesChanged(AudioAttributes audioAttributes0) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onAudioAttributesChanged(analyticsListener$EventTime0, audioAttributes0);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDecoderInitialized(String s, long v, long v1) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDecoderInitialized(analyticsListener$EventTime0, 1, s, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioDisabled(DecoderCounters decoderCounters0) {
        EventTime analyticsListener$EventTime0 = this.generateLastReportedPlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDecoderDisabled(analyticsListener$EventTime0, 1, decoderCounters0);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioEnabled(DecoderCounters decoderCounters0) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDecoderEnabled(analyticsListener$EventTime0, 1, decoderCounters0);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioInputFormatChanged(Format format0) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDecoderInputFormatChanged(analyticsListener$EventTime0, 1, format0);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener, com.google.android.exoplayer2.audio.AudioListener
    public final void onAudioSessionId(int v) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onAudioSessionId(analyticsListener$EventTime0, v);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioRendererEventListener
    public final void onAudioSinkUnderrun(int v, long v1, long v2) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onAudioUnderrun(analyticsListener$EventTime0, v, v1, v2);
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener
    public final void onBandwidthSample(int v, long v1, long v2) {
        EventTime analyticsListener$EventTime0 = this.generateLoadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onBandwidthEstimate(analyticsListener$EventTime0, v, v1, v2);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onDownstreamFormatChanged(int v, MediaPeriodId mediaSource$MediaPeriodId0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
        EventTime analyticsListener$EventTime0 = this.generateMediaPeriodEventTime(v, mediaSource$MediaPeriodId0);
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDownstreamFormatChanged(analyticsListener$EventTime0, mediaSourceEventListener$MediaLoadData0);
        }
    }

    @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmKeysLoaded() {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDrmKeysLoaded(analyticsListener$EventTime0);
        }
    }

    @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmKeysRemoved() {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDrmKeysRemoved(analyticsListener$EventTime0);
        }
    }

    @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmKeysRestored() {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDrmKeysRestored(analyticsListener$EventTime0);
        }
    }

    @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmSessionAcquired() {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDrmSessionAcquired(analyticsListener$EventTime0);
        }
    }

    @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmSessionManagerError(Exception exception0) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDrmSessionManagerError(analyticsListener$EventTime0, exception0);
        }
    }

    @Override  // com.google.android.exoplayer2.drm.DefaultDrmSessionEventListener
    public final void onDrmSessionReleased() {
        EventTime analyticsListener$EventTime0 = this.generateLastReportedPlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDrmSessionReleased(analyticsListener$EventTime0);
        }
    }

    @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onDroppedFrames(int v, long v1) {
        EventTime analyticsListener$EventTime0 = this.generateLastReportedPlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDroppedVideoFrames(analyticsListener$EventTime0, v, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public void onIsPlayingChanged(boolean z) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onIsPlayingChanged(analyticsListener$EventTime0, z);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCanceled(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
        EventTime analyticsListener$EventTime0 = this.generateMediaPeriodEventTime(v, mediaSource$MediaPeriodId0);
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onLoadCanceled(analyticsListener$EventTime0, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadCompleted(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
        EventTime analyticsListener$EventTime0 = this.generateMediaPeriodEventTime(v, mediaSource$MediaPeriodId0);
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onLoadCompleted(analyticsListener$EventTime0, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadError(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0, IOException iOException0, boolean z) {
        EventTime analyticsListener$EventTime0 = this.generateMediaPeriodEventTime(v, mediaSource$MediaPeriodId0);
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onLoadError(analyticsListener$EventTime0, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0, iOException0, z);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onLoadStarted(int v, MediaPeriodId mediaSource$MediaPeriodId0, LoadEventInfo mediaSourceEventListener$LoadEventInfo0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
        EventTime analyticsListener$EventTime0 = this.generateMediaPeriodEventTime(v, mediaSource$MediaPeriodId0);
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onLoadStarted(analyticsListener$EventTime0, mediaSourceEventListener$LoadEventInfo0, mediaSourceEventListener$MediaLoadData0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onLoadingChanged(boolean z) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onLoadingChanged(analyticsListener$EventTime0, z);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onMediaPeriodCreated(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
        this.mediaPeriodQueueTracker.onMediaPeriodCreated(v, mediaSource$MediaPeriodId0);
        EventTime analyticsListener$EventTime0 = this.generateMediaPeriodEventTime(v, mediaSource$MediaPeriodId0);
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onMediaPeriodCreated(analyticsListener$EventTime0);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onMediaPeriodReleased(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
        EventTime analyticsListener$EventTime0 = this.generateMediaPeriodEventTime(v, mediaSource$MediaPeriodId0);
        if(this.mediaPeriodQueueTracker.onMediaPeriodReleased(mediaSource$MediaPeriodId0)) {
            for(Object object0: this.listeners) {
                ((AnalyticsListener)object0).onMediaPeriodReleased(analyticsListener$EventTime0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.metadata.MetadataOutput
    public final void onMetadata(Metadata metadata0) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onMetadata(analyticsListener$EventTime0, metadata0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters0) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onPlaybackParametersChanged(analyticsListener$EventTime0, playbackParameters0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public void onPlaybackSuppressionReasonChanged(int v) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onPlaybackSuppressionReasonChanged(analyticsListener$EventTime0, v);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onPlayerError(ExoPlaybackException exoPlaybackException0) {
        EventTime analyticsListener$EventTime0 = this.generateLastReportedPlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onPlayerError(analyticsListener$EventTime0, exoPlaybackException0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onPlayerStateChanged(boolean z, int v) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onPlayerStateChanged(analyticsListener$EventTime0, z, v);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onPositionDiscontinuity(int v) {
        this.mediaPeriodQueueTracker.onPositionDiscontinuity(v);
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onPositionDiscontinuity(analyticsListener$EventTime0, v);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onReadingStarted(int v, MediaPeriodId mediaSource$MediaPeriodId0) {
        this.mediaPeriodQueueTracker.onReadingStarted(mediaSource$MediaPeriodId0);
        EventTime analyticsListener$EventTime0 = this.generateMediaPeriodEventTime(v, mediaSource$MediaPeriodId0);
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onReadingStarted(analyticsListener$EventTime0);
        }
    }

    @Override  // com.google.android.exoplayer2.video.VideoListener
    public final void onRenderedFirstFrame() {
    }

    @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onRenderedFirstFrame(Surface surface0) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onRenderedFirstFrame(analyticsListener$EventTime0, surface0);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onRepeatModeChanged(int v) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onRepeatModeChanged(analyticsListener$EventTime0, v);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onSeekProcessed() {
        if(this.mediaPeriodQueueTracker.isSeeking()) {
            this.mediaPeriodQueueTracker.onSeekProcessed();
            EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
            for(Object object0: this.listeners) {
                ((AnalyticsListener)object0).onSeekProcessed(analyticsListener$EventTime0);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onShuffleModeEnabledChanged(boolean z) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onShuffleModeChanged(analyticsListener$EventTime0, z);
        }
    }

    @Override  // com.google.android.exoplayer2.video.VideoListener
    public void onSurfaceSizeChanged(int v, int v1) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onSurfaceSizeChanged(analyticsListener$EventTime0, v, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onTimelineChanged(Timeline timeline0, int v) {
        this.mediaPeriodQueueTracker.onTimelineChanged(timeline0);
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onTimelineChanged(analyticsListener$EventTime0, v);
        }
    }

    @Override  // com.google.android.exoplayer2.Player$EventListener
    public final void onTracksChanged(TrackGroupArray trackGroupArray0, TrackSelectionArray trackSelectionArray0) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onTracksChanged(analyticsListener$EventTime0, trackGroupArray0, trackSelectionArray0);
        }
    }

    @Override  // com.google.android.exoplayer2.source.MediaSourceEventListener
    public final void onUpstreamDiscarded(int v, MediaPeriodId mediaSource$MediaPeriodId0, MediaLoadData mediaSourceEventListener$MediaLoadData0) {
        EventTime analyticsListener$EventTime0 = this.generateMediaPeriodEventTime(v, mediaSource$MediaPeriodId0);
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onUpstreamDiscarded(analyticsListener$EventTime0, mediaSourceEventListener$MediaLoadData0);
        }
    }

    @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDecoderInitialized(String s, long v, long v1) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDecoderInitialized(analyticsListener$EventTime0, 2, s, v1);
        }
    }

    @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoDisabled(DecoderCounters decoderCounters0) {
        EventTime analyticsListener$EventTime0 = this.generateLastReportedPlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDecoderDisabled(analyticsListener$EventTime0, 2, decoderCounters0);
        }
    }

    @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoEnabled(DecoderCounters decoderCounters0) {
        EventTime analyticsListener$EventTime0 = this.generatePlayingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDecoderEnabled(analyticsListener$EventTime0, 2, decoderCounters0);
        }
    }

    @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener
    public final void onVideoInputFormatChanged(Format format0) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onDecoderInputFormatChanged(analyticsListener$EventTime0, 2, format0);
        }
    }

    @Override  // com.google.android.exoplayer2.video.VideoRendererEventListener, com.google.android.exoplayer2.video.VideoListener
    public final void onVideoSizeChanged(int v, int v1, int v2, float f) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onVideoSizeChanged(analyticsListener$EventTime0, v, v1, v2, f);
        }
    }

    @Override  // com.google.android.exoplayer2.audio.AudioListener
    public void onVolumeChanged(float f) {
        EventTime analyticsListener$EventTime0 = this.generateReadingMediaPeriodEventTime();
        for(Object object0: this.listeners) {
            ((AnalyticsListener)object0).onVolumeChanged(analyticsListener$EventTime0, f);
        }
    }

    public void removeListener(AnalyticsListener analyticsListener0) {
        this.listeners.remove(analyticsListener0);
    }

    public final void resetForNewMediaSource() {
        for(Object object0: new ArrayList(MediaPeriodQueueTracker.access$000(this.mediaPeriodQueueTracker))) {
            this.onMediaPeriodReleased(((MediaPeriodInfo)object0).windowIndex, ((MediaPeriodInfo)object0).mediaPeriodId);
        }
    }

    public void setPlayer(Player player0) {
        Assertions.checkState(this.player == null || MediaPeriodQueueTracker.access$000(this.mediaPeriodQueueTracker).isEmpty());
        this.player = (Player)Assertions.checkNotNull(player0);
    }
}

