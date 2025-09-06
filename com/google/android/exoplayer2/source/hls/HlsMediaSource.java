package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.PrimaryPlaylistListener;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public final class HlsMediaSource extends BaseMediaSource implements PrimaryPlaylistListener {
    public static final class Factory implements MediaSourceFactory {
        private boolean allowChunklessPreparation;
        private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
        private DrmSessionManager drmSessionManager;
        private HlsExtractorFactory extractorFactory;
        private final HlsDataSourceFactory hlsDataSourceFactory;
        private boolean isCreateCalled;
        private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
        private int metadataType;
        private HlsPlaylistParserFactory playlistParserFactory;
        private com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory playlistTrackerFactory;
        private List streamKeys;
        private Object tag;
        private boolean useSessionKeys;

        public Factory(HlsDataSourceFactory hlsDataSourceFactory0) {
            this.hlsDataSourceFactory = (HlsDataSourceFactory)Assertions.checkNotNull(hlsDataSourceFactory0);
            this.playlistParserFactory = new DefaultHlsPlaylistParserFactory();
            this.playlistTrackerFactory = DefaultHlsPlaylistTracker.FACTORY;
            this.extractorFactory = HlsExtractorFactory.DEFAULT;
            this.drmSessionManager = DrmSessionManager.getDummyDrmSessionManager();
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
            this.compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
            this.metadataType = 1;
        }

        public Factory(com.google.android.exoplayer2.upstream.DataSource.Factory dataSource$Factory0) {
            this(new DefaultHlsDataSourceFactory(dataSource$Factory0));
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceFactory
        public MediaSource createMediaSource(Uri uri0) {
            return this.createMediaSource(uri0);
        }

        public HlsMediaSource createMediaSource(Uri uri0) {
            this.isCreateCalled = true;
            List list0 = this.streamKeys;
            if(list0 != null) {
                this.playlistParserFactory = new FilteringHlsPlaylistParserFactory(this.playlistParserFactory, list0);
            }
            HlsExtractorFactory hlsExtractorFactory0 = this.extractorFactory;
            CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory0 = this.compositeSequenceableLoaderFactory;
            DrmSessionManager drmSessionManager0 = this.drmSessionManager;
            LoadErrorHandlingPolicy loadErrorHandlingPolicy0 = this.loadErrorHandlingPolicy;
            HlsPlaylistTracker hlsPlaylistTracker0 = this.playlistTrackerFactory.createTracker(this.hlsDataSourceFactory, loadErrorHandlingPolicy0, this.playlistParserFactory);
            return new HlsMediaSource(uri0, this.hlsDataSourceFactory, hlsExtractorFactory0, compositeSequenceableLoaderFactory0, drmSessionManager0, loadErrorHandlingPolicy0, hlsPlaylistTracker0, this.allowChunklessPreparation, this.metadataType, this.useSessionKeys, this.tag, null);
        }

        @Deprecated
        public HlsMediaSource createMediaSource(Uri uri0, Handler handler0, MediaSourceEventListener mediaSourceEventListener0) {
            HlsMediaSource hlsMediaSource0 = this.createMediaSource(uri0);
            if(handler0 != null && mediaSourceEventListener0 != null) {
                hlsMediaSource0.addEventListener(handler0, mediaSourceEventListener0);
            }
            return hlsMediaSource0;
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceFactory
        public int[] getSupportedTypes() {
            return new int[]{2};
        }

        public Factory setAllowChunklessPreparation(boolean z) {
            Assertions.checkState(!this.isCreateCalled);
            this.allowChunklessPreparation = z;
            return this;
        }

        public Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory0) {
            Assertions.checkState(!this.isCreateCalled);
            this.compositeSequenceableLoaderFactory = (CompositeSequenceableLoaderFactory)Assertions.checkNotNull(compositeSequenceableLoaderFactory0);
            return this;
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceFactory
        public MediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager0) {
            return this.setDrmSessionManager(drmSessionManager0);
        }

        public Factory setDrmSessionManager(DrmSessionManager drmSessionManager0) {
            Assertions.checkState(!this.isCreateCalled);
            if(drmSessionManager0 == null) {
                drmSessionManager0 = DrmSessionManager.getDummyDrmSessionManager();
            }
            this.drmSessionManager = drmSessionManager0;
            return this;
        }

        public Factory setExtractorFactory(HlsExtractorFactory hlsExtractorFactory0) {
            Assertions.checkState(!this.isCreateCalled);
            this.extractorFactory = (HlsExtractorFactory)Assertions.checkNotNull(hlsExtractorFactory0);
            return this;
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy0) {
            Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
            return this;
        }

        public Factory setMetadataType(int v) {
            Assertions.checkState(!this.isCreateCalled);
            this.metadataType = v;
            return this;
        }

        @Deprecated
        public Factory setMinLoadableRetryCount(int v) {
            Assertions.checkState(!this.isCreateCalled);
            this.loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy(v);
            return this;
        }

        public Factory setPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory0) {
            Assertions.checkState(!this.isCreateCalled);
            this.playlistParserFactory = (HlsPlaylistParserFactory)Assertions.checkNotNull(hlsPlaylistParserFactory0);
            return this;
        }

        public Factory setPlaylistTrackerFactory(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory hlsPlaylistTracker$Factory0) {
            Assertions.checkState(!this.isCreateCalled);
            this.playlistTrackerFactory = (com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.Factory)Assertions.checkNotNull(hlsPlaylistTracker$Factory0);
            return this;
        }

        @Override  // com.google.android.exoplayer2.source.MediaSourceFactory
        public MediaSourceFactory setStreamKeys(List list0) {
            return this.setStreamKeys(list0);
        }

        public Factory setStreamKeys(List list0) {
            Assertions.checkState(!this.isCreateCalled);
            this.streamKeys = list0;
            return this;
        }

        public Factory setTag(Object object0) {
            Assertions.checkState(!this.isCreateCalled);
            this.tag = object0;
            return this;
        }

        public Factory setUseSessionKeys(boolean z) {
            this.useSessionKeys = z;
            return this;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface MetadataType {
    }

    public static final int METADATA_TYPE_EMSG = 3;
    public static final int METADATA_TYPE_ID3 = 1;
    private final boolean allowChunklessPreparation;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final HlsDataSourceFactory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final HlsExtractorFactory extractorFactory;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Uri manifestUri;
    private TransferListener mediaTransferListener;
    private final int metadataType;
    private final HlsPlaylistTracker playlistTracker;
    private final Object tag;
    private final boolean useSessionKeys;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.hls");
    }

    private HlsMediaSource(Uri uri0, HlsDataSourceFactory hlsDataSourceFactory0, HlsExtractorFactory hlsExtractorFactory0, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory0, DrmSessionManager drmSessionManager0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, HlsPlaylistTracker hlsPlaylistTracker0, boolean z, int v, boolean z1, Object object0) {
        this.manifestUri = uri0;
        this.dataSourceFactory = hlsDataSourceFactory0;
        this.extractorFactory = hlsExtractorFactory0;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory0;
        this.drmSessionManager = drmSessionManager0;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.playlistTracker = hlsPlaylistTracker0;
        this.allowChunklessPreparation = z;
        this.metadataType = v;
        this.useSessionKeys = z1;
        this.tag = object0;
    }

    public HlsMediaSource(Uri uri0, HlsDataSourceFactory hlsDataSourceFactory0, HlsExtractorFactory hlsExtractorFactory0, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory0, DrmSessionManager drmSessionManager0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, HlsPlaylistTracker hlsPlaylistTracker0, boolean z, int v, boolean z1, Object object0, com.google.android.exoplayer2.source.hls.HlsMediaSource.1 hlsMediaSource$10) {
        this(uri0, hlsDataSourceFactory0, hlsExtractorFactory0, compositeSequenceableLoaderFactory0, drmSessionManager0, loadErrorHandlingPolicy0, hlsPlaylistTracker0, z, v, z1, object0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaPeriodId mediaSource$MediaPeriodId0, Allocator allocator0, long v) {
        EventDispatcher mediaSourceEventListener$EventDispatcher0 = this.createEventDispatcher(mediaSource$MediaPeriodId0);
        return new HlsMediaPeriod(this.extractorFactory, this.playlistTracker, this.dataSourceFactory, this.mediaTransferListener, this.drmSessionManager, this.loadErrorHandlingPolicy, mediaSourceEventListener$EventDispatcher0, allocator0, this.compositeSequenceableLoaderFactory, this.allowChunklessPreparation, this.metadataType, this.useSessionKeys);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public Object getTag() {
        return this.tag;
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void maybeThrowSourceInfoRefreshError() {
        this.playlistTracker.maybeThrowPrimaryPlaylistRefreshError();
    }

    @Override  // com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PrimaryPlaylistListener
    public void onPrimaryPlaylistRefreshed(HlsMediaPlaylist hlsMediaPlaylist0) {
        SinglePeriodTimeline singlePeriodTimeline0;
        long v9;
        long v7;
        long v = hlsMediaPlaylist0.hasProgramDateTime ? C.usToMs(hlsMediaPlaylist0.startTimeUs) : 0x8000000000000001L;
        long v1 = hlsMediaPlaylist0.playlistType == 1 || hlsMediaPlaylist0.playlistType == 2 ? v : 0x8000000000000001L;
        long v2 = hlsMediaPlaylist0.startOffsetUs;
        HlsManifest hlsManifest0 = new HlsManifest(((HlsMasterPlaylist)Assertions.checkNotNull(this.playlistTracker.getMasterPlaylist())), hlsMediaPlaylist0);
        if(this.playlistTracker.isLive()) {
            long v3 = this.playlistTracker.getInitialStartTimeUs();
            long v4 = hlsMediaPlaylist0.startTimeUs - v3;
            long v5 = hlsMediaPlaylist0.hasEndTag ? hlsMediaPlaylist0.durationUs + v4 : 0x8000000000000001L;
            List list0 = hlsMediaPlaylist0.segments;
            if(v2 != 0x8000000000000001L) {
                v7 = v4;
                v9 = v5;
            }
            else if(!list0.isEmpty()) {
                int v6 = Math.max(0, list0.size() - 3);
                v7 = v4;
                long v8 = hlsMediaPlaylist0.durationUs - hlsMediaPlaylist0.targetDurationUs * 2L;
                while(v6 > 0 && ((Segment)list0.get(v6)).relativeStartTimeUs > v8) {
                    --v6;
                }
                v2 = ((Segment)list0.get(v6)).relativeStartTimeUs;
                v9 = v5;
            }
            else {
                v7 = v4;
                v9 = v5;
                v2 = 0L;
            }
            singlePeriodTimeline0 = new SinglePeriodTimeline(v1, v, v9, hlsMediaPlaylist0.durationUs, v7, v2, true, !hlsMediaPlaylist0.hasEndTag, true, hlsManifest0, this.tag);
        }
        else {
            singlePeriodTimeline0 = new SinglePeriodTimeline(v1, v, hlsMediaPlaylist0.durationUs, hlsMediaPlaylist0.durationUs, 0L, (v2 == 0x8000000000000001L ? 0L : v2), true, false, false, hlsManifest0, this.tag);
        }
        this.refreshSourceInfo(singlePeriodTimeline0);
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void prepareSourceInternal(TransferListener transferListener0) {
        this.mediaTransferListener = transferListener0;
        this.drmSessionManager.prepare();
        EventDispatcher mediaSourceEventListener$EventDispatcher0 = this.createEventDispatcher(null);
        this.playlistTracker.start(this.manifestUri, mediaSourceEventListener$EventDispatcher0, this);
    }

    @Override  // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod0) {
        ((HlsMediaPeriod)mediaPeriod0).release();
    }

    @Override  // com.google.android.exoplayer2.source.BaseMediaSource
    public void releaseSourceInternal() {
        this.playlistTracker.stop();
        this.drmSessionManager.release();
    }

    class com.google.android.exoplayer2.source.hls.HlsMediaSource.1 {
    }

}

