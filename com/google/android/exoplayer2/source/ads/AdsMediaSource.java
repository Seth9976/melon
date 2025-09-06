package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.appevents.c;
import com.google.android.exoplayer2.Timeline.Period;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MaskingMediaPeriod.PrepareErrorListener;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class AdsMediaSource extends CompositeMediaSource {
    public static final class AdLoadException extends IOException {
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public static final int TYPE_AD = 0;
        public static final int TYPE_AD_GROUP = 1;
        public static final int TYPE_ALL_ADS = 2;
        public static final int TYPE_UNEXPECTED = 3;
        public final int type;

        private AdLoadException(int v, Exception exception0) {
            super(exception0);
            this.type = v;
        }

        public static AdLoadException createForAd(Exception exception0) {
            return new AdLoadException(0, exception0);
        }

        public static AdLoadException createForAdGroup(Exception exception0, int v) {
            return new AdLoadException(1, new IOException("Failed to load ad group " + v, exception0));
        }

        public static AdLoadException createForAllAds(Exception exception0) {
            return new AdLoadException(2, exception0);
        }

        public static AdLoadException createForUnexpected(RuntimeException runtimeException0) {
            return new AdLoadException(3, runtimeException0);
        }

        public RuntimeException getRuntimeExceptionForUnexpected() {
            Assertions.checkState(this.type == 3);
            return (RuntimeException)Assertions.checkNotNull(this.getCause());
        }
    }

    final class AdMediaSourceHolder {
        private final List activeMediaPeriods;
        private final MediaSource adMediaSource;
        private Timeline timeline;

        public AdMediaSourceHolder(MediaSource mediaSource0) {
            this.adMediaSource = mediaSource0;
            this.activeMediaPeriods = new ArrayList();
        }

        public MediaPeriod createMediaPeriod(Uri uri0, MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
            MediaPeriod mediaPeriod0 = new MaskingMediaPeriod(this.adMediaSource, mediaSource$MediaPeriodId0, allocator0, v);
            ((MaskingMediaPeriod)mediaPeriod0).setPrepareErrorListener(new AdPrepareErrorListener(AdsMediaSource.this, uri0, mediaSource$MediaPeriodId0.adGroupIndex, mediaSource$MediaPeriodId0.adIndexInAdGroup));
            this.activeMediaPeriods.add(mediaPeriod0);
            Timeline timeline0 = this.timeline;
            if(timeline0 != null) {
                ((MaskingMediaPeriod)mediaPeriod0).createPeriod(new MediaPeriodId(timeline0.getUidOfPeriod(0), mediaSource$MediaPeriodId0.windowSequenceNumber));
            }
            return mediaPeriod0;
        }

        public long getDurationUs() {
            return this.timeline == null ? 0x8000000000000001L : this.timeline.getPeriod(0, AdsMediaSource.this.period).getDurationUs();
        }

        public void handleSourceInfoRefresh(Timeline timeline0) {
            Assertions.checkArgument(timeline0.getPeriodCount() == 1);
            if(this.timeline == null) {
                Object object0 = timeline0.getUidOfPeriod(0);
                for(int v = 0; v < this.activeMediaPeriods.size(); ++v) {
                    MaskingMediaPeriod maskingMediaPeriod0 = (MaskingMediaPeriod)this.activeMediaPeriods.get(v);
                    maskingMediaPeriod0.createPeriod(new MediaPeriodId(object0, maskingMediaPeriod0.id.windowSequenceNumber));
                }
            }
            this.timeline = timeline0;
        }

        public boolean isInactive() {
            return this.activeMediaPeriods.isEmpty();
        }

        public void releaseMediaPeriod(MaskingMediaPeriod maskingMediaPeriod0) {
            this.activeMediaPeriods.remove(maskingMediaPeriod0);
            maskingMediaPeriod0.releasePeriod();
        }
    }

    final class AdPrepareErrorListener implements PrepareErrorListener {
        private final int adGroupIndex;
        private final int adIndexInAdGroup;
        private final Uri adUri;

        public AdPrepareErrorListener(Uri uri0, int v, int v1) {
            this.adUri = uri0;
            this.adGroupIndex = v;
            this.adIndexInAdGroup = v1;
        }

        public static void a(AdPrepareErrorListener adsMediaSource$AdPrepareErrorListener0, IOException iOException0) {
            adsMediaSource$AdPrepareErrorListener0.lambda$onPrepareError$0(iOException0);
        }

        private void lambda$onPrepareError$0(IOException iOException0) {
            AdsMediaSource.this.adsLoader.handlePrepareError(this.adGroupIndex, this.adIndexInAdGroup, iOException0);
        }

        @Override  // com.google.android.exoplayer2.source.MaskingMediaPeriod$PrepareErrorListener
        public void onPrepareError(MediaPeriodId mediaSource$MediaPeriodId0, IOException iOException0) {
            EventDispatcher mediaSourceEventListener$EventDispatcher0 = AdsMediaSource.this.createEventDispatcher(mediaSource$MediaPeriodId0);
            DataSpec dataSpec0 = new DataSpec(this.adUri);
            Map map0 = Collections.EMPTY_MAP;
            AdLoadException adsMediaSource$AdLoadException0 = AdLoadException.createForAd(iOException0);
            mediaSourceEventListener$EventDispatcher0.loadError(dataSpec0, this.adUri, map0, 6, -1L, 0L, 0L, adsMediaSource$AdLoadException0, true);
            a a0 = new a(1, this, iOException0);
            AdsMediaSource.this.mainHandler.post(a0);
        }
    }

    final class ComponentListener implements EventListener {
        private final Handler playerHandler;
        private volatile boolean released;

        public ComponentListener() {
            this.playerHandler = new Handler();
        }

        public static void a(ComponentListener adsMediaSource$ComponentListener0, AdPlaybackState adPlaybackState0) {
            adsMediaSource$ComponentListener0.lambda$onAdPlaybackState$0(adPlaybackState0);
        }

        private void lambda$onAdPlaybackState$0(AdPlaybackState adPlaybackState0) {
            if(this.released) {
                return;
            }
            AdsMediaSource.this.onAdPlaybackState(adPlaybackState0);
        }

        @Override  // com.google.android.exoplayer2.source.ads.AdsLoader$EventListener
        public void onAdLoadError(AdLoadException adsMediaSource$AdLoadException0, DataSpec dataSpec0) {
            if(this.released) {
                return;
            }
            EventDispatcher mediaSourceEventListener$EventDispatcher0 = AdsMediaSource.this.createEventDispatcher(null);
            Map map0 = Collections.EMPTY_MAP;
            long v = SystemClock.elapsedRealtime();
            mediaSourceEventListener$EventDispatcher0.loadError(dataSpec0, dataSpec0.uri, map0, 6, v, 0L, 0L, adsMediaSource$AdLoadException0, true);
        }

        @Override  // com.google.android.exoplayer2.source.ads.AdsLoader$EventListener
        public void onAdPlaybackState(AdPlaybackState adPlaybackState0) {
            if(this.released) {
                return;
            }
            a a0 = new a(this, adPlaybackState0);
            this.playerHandler.post(a0);
        }

        public void release() {
            this.released = true;
            this.playerHandler.removeCallbacksAndMessages(null);
        }
    }

    private static final MediaPeriodId DUMMY_CONTENT_MEDIA_PERIOD_ID;
    private final MediaSourceFactory adMediaSourceFactory;
    private AdMediaSourceHolder[][] adMediaSourceHolders;
    private AdPlaybackState adPlaybackState;
    private final AdViewProvider adViewProvider;
    private final AdsLoader adsLoader;
    private ComponentListener componentListener;
    private final MediaSource contentMediaSource;
    private Timeline contentTimeline;
    private final Handler mainHandler;
    private final Period period;

    static {
        AdsMediaSource.DUMMY_CONTENT_MEDIA_PERIOD_ID = new MediaPeriodId(new Object());
    }

    public AdsMediaSource(MediaSource mediaSource0, MediaSourceFactory mediaSourceFactory0, AdsLoader adsLoader0, AdViewProvider adsLoader$AdViewProvider0) {
        this.contentMediaSource = mediaSource0;
        this.adMediaSourceFactory = mediaSourceFactory0;
        this.adsLoader = adsLoader0;
        this.adViewProvider = adsLoader$AdViewProvider0;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.period = new Period();
        this.adMediaSourceHolders = new AdMediaSourceHolder[0][];
        adsLoader0.setSupportedContentTypes(mediaSourceFactory0.getSupportedTypes());
    }

    public AdsMediaSource(MediaSource mediaSource0, Factory dataSource$Factory0, AdsLoader adsLoader0, AdViewProvider adsLoader$AdViewProvider0) {
        this(mediaSource0, new com.google.android.exoplayer2.source.ProgressiveMediaSource.Factory(dataSource$Factory0), adsLoader0, adsLoader$AdViewProvider0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        AdPlaybackState adPlaybackState0 = (AdPlaybackState)Assertions.checkNotNull(this.adPlaybackState);
        if(adPlaybackState0.adGroupCount > 0 && mediaSource$MediaPeriodId0.isAd()) {
            int v1 = mediaSource$MediaPeriodId0.adGroupIndex;
            int v2 = mediaSource$MediaPeriodId0.adIndexInAdGroup;
            Object object0 = Assertions.checkNotNull(adPlaybackState0.adGroups[v1].uris[v2]);
            AdMediaSourceHolder[][] arr2_adsMediaSource$AdMediaSourceHolder = this.adMediaSourceHolders;
            AdMediaSourceHolder[] arr_adsMediaSource$AdMediaSourceHolder = arr2_adsMediaSource$AdMediaSourceHolder[v1];
            if(arr_adsMediaSource$AdMediaSourceHolder.length <= v2) {
                arr2_adsMediaSource$AdMediaSourceHolder[v1] = (AdMediaSourceHolder[])Arrays.copyOf(arr_adsMediaSource$AdMediaSourceHolder, v2 + 1);
            }
            AdMediaSourceHolder adsMediaSource$AdMediaSourceHolder0 = this.adMediaSourceHolders[v1][v2];
            if(adsMediaSource$AdMediaSourceHolder0 == null) {
                MediaSource mediaSource0 = this.adMediaSourceFactory.createMediaSource(((Uri)object0));
                AdMediaSourceHolder adsMediaSource$AdMediaSourceHolder1 = new AdMediaSourceHolder(this, mediaSource0);
                this.adMediaSourceHolders[v1][v2] = adsMediaSource$AdMediaSourceHolder1;
                this.prepareChildSource(mediaSource$MediaPeriodId0, mediaSource0);
                return adsMediaSource$AdMediaSourceHolder1.createMediaPeriod(((Uri)object0), mediaSource$MediaPeriodId0, allocator0, v);
            }
            return adsMediaSource$AdMediaSourceHolder0.createMediaPeriod(((Uri)object0), mediaSource$MediaPeriodId0, allocator0, v);
        }
        MediaPeriod mediaPeriod0 = new MaskingMediaPeriod(this.contentMediaSource, mediaSource$MediaPeriodId0, allocator0, v);
        ((MaskingMediaPeriod)mediaPeriod0).createPeriod(mediaSource$MediaPeriodId0);
        return mediaPeriod0;
    }

    private long[][] getAdDurationsUs() {
        long[][] arr2_v = new long[this.adMediaSourceHolders.length][];
        for(int v = 0; true; ++v) {
            AdMediaSourceHolder[][] arr2_adsMediaSource$AdMediaSourceHolder = this.adMediaSourceHolders;
            if(v >= arr2_adsMediaSource$AdMediaSourceHolder.length) {
                break;
            }
            arr2_v[v] = new long[arr2_adsMediaSource$AdMediaSourceHolder[v].length];
            for(int v1 = 0; true; ++v1) {
                AdMediaSourceHolder[] arr_adsMediaSource$AdMediaSourceHolder = this.adMediaSourceHolders[v];
                if(v1 >= arr_adsMediaSource$AdMediaSourceHolder.length) {
                    break;
                }
                AdMediaSourceHolder adsMediaSource$AdMediaSourceHolder0 = arr_adsMediaSource$AdMediaSourceHolder[v1];
                long[] arr_v = arr2_v[v];
                arr_v[v1] = adsMediaSource$AdMediaSourceHolder0 == null ? 0x8000000000000001L : adsMediaSource$AdMediaSourceHolder0.getDurationUs();
            }
        }
        return arr2_v;
    }

    // 去混淆评级： 低(20)
    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaPeriodId mediaSource$MediaPeriodId0, MediaPeriodId mediaSource$MediaPeriodId1) {
        return mediaSource$MediaPeriodId0.isAd() ? mediaSource$MediaPeriodId0 : mediaSource$MediaPeriodId1;
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Object object0, MediaPeriodId mediaSource$MediaPeriodId0) {
        return this.getMediaPeriodIdForChildMediaPeriodId(((MediaPeriodId)object0), mediaSource$MediaPeriodId0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.contentMediaSource.getTag();
    }

    private void lambda$prepareSourceInternal$0(ComponentListener adsMediaSource$ComponentListener0) {
        this.adsLoader.start(adsMediaSource$ComponentListener0, this.adViewProvider);
    }

    private void maybeUpdateSourceInfo() {
        Timeline timeline0 = this.contentTimeline;
        AdPlaybackState adPlaybackState0 = this.adPlaybackState;
        if(adPlaybackState0 != null && timeline0 != null) {
            AdPlaybackState adPlaybackState1 = adPlaybackState0.withAdDurationsUs(this.getAdDurationsUs());
            this.adPlaybackState = adPlaybackState1;
            if(adPlaybackState1.adGroupCount != 0) {
                timeline0 = new SinglePeriodAdTimeline(timeline0, this.adPlaybackState);
            }
            this.refreshSourceInfo(timeline0);
        }
    }

    private void onAdPlaybackState(AdPlaybackState adPlaybackState0) {
        if(this.adPlaybackState == null) {
            AdMediaSourceHolder[][] arr2_adsMediaSource$AdMediaSourceHolder = new AdMediaSourceHolder[adPlaybackState0.adGroupCount][];
            this.adMediaSourceHolders = arr2_adsMediaSource$AdMediaSourceHolder;
            Arrays.fill(arr2_adsMediaSource$AdMediaSourceHolder, new AdMediaSourceHolder[0]);
        }
        this.adPlaybackState = adPlaybackState0;
        this.maybeUpdateSourceInfo();
    }

    public void onChildSourceInfoRefreshed(MediaPeriodId mediaSource$MediaPeriodId0, MediaSource mediaSource0, Timeline timeline0) {
        boolean z = true;
        if(mediaSource$MediaPeriodId0.isAd()) {
            ((AdMediaSourceHolder)Assertions.checkNotNull(this.adMediaSourceHolders[mediaSource$MediaPeriodId0.adGroupIndex][mediaSource$MediaPeriodId0.adIndexInAdGroup])).handleSourceInfoRefresh(timeline0);
        }
        else {
            if(timeline0.getPeriodCount() != 1) {
                z = false;
            }
            Assertions.checkArgument(z);
            this.contentTimeline = timeline0;
        }
        this.maybeUpdateSourceInfo();
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(Object object0, MediaSource mediaSource0, Timeline timeline0) {
        this.onChildSourceInfoRefreshed(((MediaPeriodId)object0), mediaSource0, timeline0);
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        super.prepareSourceInternal(transferListener0);
        ComponentListener adsMediaSource$ComponentListener0 = new ComponentListener(this);
        this.componentListener = adsMediaSource$ComponentListener0;
        this.prepareChildSource(AdsMediaSource.DUMMY_CONTENT_MEDIA_PERIOD_ID, this.contentMediaSource);
        a a0 = new a(0, this, adsMediaSource$ComponentListener0);
        this.mainHandler.post(a0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        MediaPeriodId mediaSource$MediaPeriodId0 = ((MaskingMediaPeriod)mediaPeriod0).id;
        if(mediaSource$MediaPeriodId0.isAd()) {
            AdMediaSourceHolder adsMediaSource$AdMediaSourceHolder0 = (AdMediaSourceHolder)Assertions.checkNotNull(this.adMediaSourceHolders[mediaSource$MediaPeriodId0.adGroupIndex][mediaSource$MediaPeriodId0.adIndexInAdGroup]);
            adsMediaSource$AdMediaSourceHolder0.releaseMediaPeriod(((MaskingMediaPeriod)mediaPeriod0));
            if(adsMediaSource$AdMediaSourceHolder0.isInactive()) {
                this.releaseChildSource(mediaSource$MediaPeriodId0);
                this.adMediaSourceHolders[mediaSource$MediaPeriodId0.adGroupIndex][mediaSource$MediaPeriodId0.adIndexInAdGroup] = null;
            }
            return;
        }
        ((MaskingMediaPeriod)mediaPeriod0).releasePeriod();
    }

    @Override  // com.google.android.exoplayer2.source.CompositeMediaSource
    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        ((ComponentListener)Assertions.checkNotNull(this.componentListener)).release();
        this.componentListener = null;
        this.contentTimeline = null;
        this.adPlaybackState = null;
        this.adMediaSourceHolders = new AdMediaSourceHolder[0][];
        Objects.requireNonNull(this.adsLoader);
        c c0 = new c(this.adsLoader, 12);
        this.mainHandler.post(c0);
    }
}

