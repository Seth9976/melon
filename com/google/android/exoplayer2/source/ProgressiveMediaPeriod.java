package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.StatsDataSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class ProgressiveMediaPeriod implements ExtractorOutput, MediaPeriod, UpstreamFormatChangedListener, Callback, ReleaseCallback {
    final class ExtractingLoadable implements Listener, Loadable {
        private final StatsDataSource dataSource;
        private DataSpec dataSpec;
        private final ExtractorHolder extractorHolder;
        private final ExtractorOutput extractorOutput;
        private TrackOutput icyTrackOutput;
        private long length;
        private volatile boolean loadCanceled;
        private final ConditionVariable loadCondition;
        private boolean pendingExtractorSeek;
        private final PositionHolder positionHolder;
        private long seekTimeUs;
        private boolean seenIcyMetadata;
        private final Uri uri;

        public ExtractingLoadable(Uri uri0, DataSource dataSource0, ExtractorHolder progressiveMediaPeriod$ExtractorHolder0, ExtractorOutput extractorOutput0, ConditionVariable conditionVariable0) {
            this.uri = uri0;
            this.dataSource = new StatsDataSource(dataSource0);
            this.extractorHolder = progressiveMediaPeriod$ExtractorHolder0;
            this.extractorOutput = extractorOutput0;
            this.loadCondition = conditionVariable0;
            this.positionHolder = new PositionHolder();
            this.pendingExtractorSeek = true;
            this.length = -1L;
            this.dataSpec = this.buildDataSpec(0L);
        }

        public static DataSpec access$100(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0) {
            return progressiveMediaPeriod$ExtractingLoadable0.dataSpec;
        }

        public static StatsDataSource access$200(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0) {
            return progressiveMediaPeriod$ExtractingLoadable0.dataSource;
        }

        public static long access$300(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0) {
            return progressiveMediaPeriod$ExtractingLoadable0.seekTimeUs;
        }

        public static long access$400(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0) {
            return progressiveMediaPeriod$ExtractingLoadable0.length;
        }

        public static void access$500(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0, long v, long v1) {
            progressiveMediaPeriod$ExtractingLoadable0.setLoadPosition(v, v1);
        }

        private DataSpec buildDataSpec(long v) {
            return new DataSpec(this.uri, v, -1L, ProgressiveMediaPeriod.this.customCacheKey, 6, ProgressiveMediaPeriod.ICY_METADATA_HEADERS);
        }

        @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
        public void cancelLoad() {
            this.loadCanceled = true;
        }

        @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
        public void load() {
            DefaultExtractorInput defaultExtractorInput1;
            Uri uri0;
            long v1;
            DefaultExtractorInput defaultExtractorInput0;
            int v = 0;
            while(v == 0 && !this.loadCanceled) {
                try {
                    defaultExtractorInput0 = null;
                    v1 = this.positionHolder.position;
                    DataSpec dataSpec0 = this.buildDataSpec(v1);
                    this.dataSpec = dataSpec0;
                    long v2 = this.dataSource.open(dataSpec0);
                    this.length = v2;
                    if(v2 != -1L) {
                        this.length = v2 + v1;
                    }
                    uri0 = (Uri)Assertions.checkNotNull(this.dataSource.getUri());
                    IcyHeaders icyHeaders0 = IcyHeaders.parse(this.dataSource.getResponseHeaders());
                    ProgressiveMediaPeriod.this.icyHeaders = icyHeaders0;
                    StatsDataSource statsDataSource0 = this.dataSource;
                    if(ProgressiveMediaPeriod.this.icyHeaders != null && ProgressiveMediaPeriod.this.icyHeaders.metadataInterval != -1) {
                        statsDataSource0 = new IcyDataSource(this.dataSource, ProgressiveMediaPeriod.this.icyHeaders.metadataInterval, this);
                        TrackOutput trackOutput0 = ProgressiveMediaPeriod.this.icyTrack();
                        this.icyTrackOutput = trackOutput0;
                        trackOutput0.format(ProgressiveMediaPeriod.ICY_FORMAT);
                    }
                    defaultExtractorInput1 = new DefaultExtractorInput(statsDataSource0, v1, this.length);
                    goto label_23;
                }
                catch(Throwable throwable0) {
                }
                goto label_39;
                try {
                label_23:
                    Extractor extractor0 = this.extractorHolder.selectExtractor(defaultExtractorInput1, this.extractorOutput, uri0);
                    if(ProgressiveMediaPeriod.this.icyHeaders != null && extractor0 instanceof Mp3Extractor) {
                        ((Mp3Extractor)extractor0).disableSeeking();
                    }
                    if(this.pendingExtractorSeek) {
                        extractor0.seek(v1, this.seekTimeUs);
                        this.pendingExtractorSeek = false;
                    }
                    while(true) {
                        if(v != 0 || this.loadCanceled) {
                            goto label_43;
                        }
                        this.loadCondition.block();
                        v = extractor0.read(defaultExtractorInput1, this.positionHolder);
                        if(defaultExtractorInput1.getPosition() > ProgressiveMediaPeriod.this.continueLoadingCheckIntervalBytes + v1) {
                            v1 = defaultExtractorInput1.getPosition();
                            this.loadCondition.close();
                            ProgressiveMediaPeriod.this.handler.post(ProgressiveMediaPeriod.this.onContinueLoadingRequestedRunnable);
                        }
                    }
                }
                catch(Throwable throwable0) {
                    defaultExtractorInput0 = defaultExtractorInput1;
                }
            label_39:
                if(v != 1 && defaultExtractorInput0 != null) {
                    this.positionHolder.position = defaultExtractorInput0.getPosition();
                }
                Util.closeQuietly(this.dataSource);
                throw throwable0;
            label_43:
                if(v == 1) {
                    v = 0;
                }
                else {
                    this.positionHolder.position = defaultExtractorInput1.getPosition();
                }
                Util.closeQuietly(this.dataSource);
            }
        }

        @Override  // com.google.android.exoplayer2.source.IcyDataSource$Listener
        public void onIcyMetadata(ParsableByteArray parsableByteArray0) {
            long v = this.seenIcyMetadata ? Math.max(ProgressiveMediaPeriod.this.getLargestQueuedTimestampUs(), this.seekTimeUs) : this.seekTimeUs;
            int v1 = parsableByteArray0.bytesLeft();
            Object object0 = Assertions.checkNotNull(this.icyTrackOutput);
            ((TrackOutput)object0).sampleData(parsableByteArray0, v1);
            ((TrackOutput)object0).sampleMetadata(v, 1, v1, 0, null);
            this.seenIcyMetadata = true;
        }

        private void setLoadPosition(long v, long v1) {
            this.positionHolder.position = v;
            this.seekTimeUs = v1;
            this.pendingExtractorSeek = true;
            this.seenIcyMetadata = false;
        }
    }

    static final class ExtractorHolder {
        private Extractor extractor;
        private final Extractor[] extractors;

        public ExtractorHolder(Extractor[] arr_extractor) {
            this.extractors = arr_extractor;
        }

        public void release() {
            Extractor extractor0 = this.extractor;
            if(extractor0 != null) {
                extractor0.release();
                this.extractor = null;
            }
        }

        public Extractor selectExtractor(ExtractorInput extractorInput0, ExtractorOutput extractorOutput0, Uri uri0) {
            Extractor extractor0 = this.extractor;
            if(extractor0 != null) {
                return extractor0;
            }
            Extractor[] arr_extractor = this.extractors;
            if(arr_extractor.length == 1) {
                this.extractor = arr_extractor[0];
            }
            else {
                for(int v = 0; v < arr_extractor.length; ++v) {
                    Extractor extractor1 = arr_extractor[v];
                    try {
                        if(extractor1.sniff(extractorInput0)) {
                            this.extractor = extractor1;
                            break;
                        }
                    }
                    catch(EOFException unused_ex) {
                    }
                    finally {
                        extractorInput0.resetPeekPosition();
                    }
                }
                if(this.extractor == null) {
                    throw new UnrecognizedInputFormatException("None of the available extractors (" + Util.getCommaDelimitedSimpleClassNames(this.extractors) + ") could read the stream.", uri0);
                }
            }
            this.extractor.init(extractorOutput0);
            return this.extractor;
        }
    }

    interface com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener {
        void onSourceInfoRefreshed(long arg1, boolean arg2, boolean arg3);
    }

    static final class PreparedState {
        public final SeekMap seekMap;
        public final boolean[] trackEnabledStates;
        public final boolean[] trackIsAudioVideoFlags;
        public final boolean[] trackNotifiedDownstreamFormats;
        public final TrackGroupArray tracks;

        public PreparedState(SeekMap seekMap0, TrackGroupArray trackGroupArray0, boolean[] arr_z) {
            this.seekMap = seekMap0;
            this.tracks = trackGroupArray0;
            this.trackIsAudioVideoFlags = arr_z;
            this.trackEnabledStates = new boolean[trackGroupArray0.length];
            this.trackNotifiedDownstreamFormats = new boolean[trackGroupArray0.length];
        }
    }

    final class SampleStreamImpl implements SampleStream {
        private final int track;

        public SampleStreamImpl(int v) {
            this.track = v;
        }

        public static int access$000(SampleStreamImpl progressiveMediaPeriod$SampleStreamImpl0) {
            return progressiveMediaPeriod$SampleStreamImpl0.track;
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public boolean isReady() {
            return ProgressiveMediaPeriod.this.isReady(this.track);
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public void maybeThrowError() {
            ProgressiveMediaPeriod.this.maybeThrowError(this.track);
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int readData(FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
            return ProgressiveMediaPeriod.this.readData(this.track, formatHolder0, decoderInputBuffer0, z);
        }

        @Override  // com.google.android.exoplayer2.source.SampleStream
        public int skipData(long v) {
            return ProgressiveMediaPeriod.this.skipData(this.track, v);
        }
    }

    static final class TrackId {
        public final int id;
        public final boolean isIcyTrack;

        public TrackId(int v, boolean z) {
            this.id = v;
            this.isIcyTrack = z;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return TrackId.class == class0 && this.id == ((TrackId)object0).id && this.isIcyTrack == ((TrackId)object0).isIcyTrack;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.id * 0x1F + this.isIcyTrack;
        }
    }

    private static final long DEFAULT_LAST_SAMPLE_DURATION_US = 10000L;
    private static final Format ICY_FORMAT;
    private static final Map ICY_METADATA_HEADERS;
    private final Allocator allocator;
    private com.google.android.exoplayer2.source.MediaPeriod.Callback callback;
    private final long continueLoadingCheckIntervalBytes;
    private final String customCacheKey;
    private final DataSource dataSource;
    private int dataType;
    private final DrmSessionManager drmSessionManager;
    private long durationUs;
    private int enabledTrackCount;
    private final EventDispatcher eventDispatcher;
    private int extractedSamplesCountAtStartOfLoad;
    private final ExtractorHolder extractorHolder;
    private final Handler handler;
    private boolean haveAudioVideoTracks;
    private IcyHeaders icyHeaders;
    private boolean isLive;
    private long lastSeekPositionUs;
    private long length;
    private final com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener listener;
    private final ConditionVariable loadCondition;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader;
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private boolean notifiedReadingStarted;
    private boolean notifyDiscontinuity;
    private final Runnable onContinueLoadingRequestedRunnable;
    private boolean pendingDeferredRetry;
    private long pendingResetPositionUs;
    private boolean prepared;
    private PreparedState preparedState;
    private boolean released;
    private TrackId[] sampleQueueTrackIds;
    private SampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private SeekMap seekMap;
    private boolean seenFirstTrackSelection;
    private final Uri uri;

    static {
        ProgressiveMediaPeriod.ICY_METADATA_HEADERS = ProgressiveMediaPeriod.createIcyMetadataHeaders();
        ProgressiveMediaPeriod.ICY_FORMAT = Format.createSampleFormat("icy", "application/x-icy", 0x7FFFFFFFFFFFFFFFL);
    }

    public ProgressiveMediaPeriod(Uri uri0, DataSource dataSource0, Extractor[] arr_extractor, DrmSessionManager drmSessionManager0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, EventDispatcher mediaSourceEventListener$EventDispatcher0, com.google.android.exoplayer2.source.ProgressiveMediaPeriod.Listener progressiveMediaPeriod$Listener0, Allocator allocator0, String s, int v) {
        this.uri = uri0;
        this.dataSource = dataSource0;
        this.drmSessionManager = drmSessionManager0;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.eventDispatcher = mediaSourceEventListener$EventDispatcher0;
        this.listener = progressiveMediaPeriod$Listener0;
        this.allocator = allocator0;
        this.customCacheKey = s;
        this.continueLoadingCheckIntervalBytes = (long)v;
        this.loader = new Loader("Loader:ProgressiveMediaPeriod");
        this.extractorHolder = new ExtractorHolder(arr_extractor);
        this.loadCondition = new ConditionVariable();
        this.maybeFinishPrepareRunnable = new e(this, 0);
        this.onContinueLoadingRequestedRunnable = new e(this, 1);
        this.handler = new Handler();
        this.sampleQueueTrackIds = new TrackId[0];
        this.sampleQueues = new SampleQueue[0];
        this.pendingResetPositionUs = 0x8000000000000001L;
        this.length = -1L;
        this.durationUs = 0x8000000000000001L;
        this.dataType = 1;
        mediaSourceEventListener$EventDispatcher0.mediaPeriodCreated();
    }

    private boolean configureRetry(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0, int v) {
        if(Long.compare(this.length, -1L) == 0 && (this.seekMap == null || this.seekMap.getDurationUs() == 0x8000000000000001L)) {
            if(this.prepared && !this.suppressRead()) {
                this.pendingDeferredRetry = true;
                return false;
            }
            this.notifyDiscontinuity = this.prepared;
            this.lastSeekPositionUs = 0L;
            this.extractedSamplesCountAtStartOfLoad = 0;
            SampleQueue[] arr_sampleQueue = this.sampleQueues;
            for(int v1 = 0; v1 < arr_sampleQueue.length; ++v1) {
                arr_sampleQueue[v1].reset();
            }
            ExtractingLoadable.access$500(progressiveMediaPeriod$ExtractingLoadable0, 0L, 0L);
            return true;
        }
        this.extractedSamplesCountAtStartOfLoad = v;
        return true;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean continueLoading(long v) {
        if(!this.loadingFinished && !this.loader.hasFatalError() && !this.pendingDeferredRetry && (!this.prepared || this.enabledTrackCount != 0)) {
            boolean z = this.loadCondition.open();
            if(!this.loader.isLoading()) {
                this.startLoading();
                return true;
            }
            return z;
        }
        return false;
    }

    private void copyLengthFromLoader(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0) {
        if(this.length == -1L) {
            this.length = ExtractingLoadable.access$400(progressiveMediaPeriod$ExtractingLoadable0);
        }
    }

    private static Map createIcyMetadataHeaders() {
        HashMap hashMap0 = new HashMap();
        hashMap0.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(hashMap0);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void discardBuffer(long v, boolean z) {
        if(!this.isPendingReset()) {
            boolean[] arr_z = this.getPreparedState().trackEnabledStates;
            for(int v1 = 0; v1 < this.sampleQueues.length; ++v1) {
                this.sampleQueues[v1].discardTo(v, z, arr_z[v1]);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.sampleQueuesBuilt = true;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long v, SeekParameters seekParameters0) {
        SeekMap seekMap0 = this.getPreparedState().seekMap;
        if(!seekMap0.isSeekable()) {
            return 0L;
        }
        SeekPoints seekMap$SeekPoints0 = seekMap0.getSeekPoints(v);
        return Util.resolveSeekPositionUs(v, seekParameters0, seekMap$SeekPoints0.first.timeUs, seekMap$SeekPoints0.second.timeUs);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getBufferedPositionUs() {
        long v1;
        boolean[] arr_z = this.getPreparedState().trackIsAudioVideoFlags;
        if(this.loadingFinished) {
            return 0x8000000000000000L;
        }
        if(this.isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        if(this.haveAudioVideoTracks) {
            v1 = 0x7FFFFFFFFFFFFFFFL;
            for(int v = 0; v < this.sampleQueues.length; ++v) {
                if(arr_z[v] && !this.sampleQueues[v].isLastSampleQueued()) {
                    v1 = Math.min(v1, this.sampleQueues[v].getLargestQueuedTimestampUs());
                }
            }
        }
        else {
            v1 = 0x7FFFFFFFFFFFFFFFL;
        }
        if(v1 == 0x7FFFFFFFFFFFFFFFL) {
            v1 = this.getLargestQueuedTimestampUs();
        }
        return v1 == 0x8000000000000000L ? this.lastSeekPositionUs : v1;
    }

    private int getExtractedSamplesCount() {
        SampleQueue[] arr_sampleQueue = this.sampleQueues;
        int v1 = 0;
        for(int v = 0; v < arr_sampleQueue.length; ++v) {
            v1 += arr_sampleQueue[v].getWriteIndex();
        }
        return v1;
    }

    private long getLargestQueuedTimestampUs() {
        SampleQueue[] arr_sampleQueue = this.sampleQueues;
        long v = 0x8000000000000000L;
        for(int v1 = 0; v1 < arr_sampleQueue.length; ++v1) {
            v = Math.max(v, arr_sampleQueue[v1].getLargestQueuedTimestampUs());
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long getNextLoadPositionUs() {
        return this.enabledTrackCount == 0 ? 0x8000000000000000L : this.getBufferedPositionUs();
    }

    private PreparedState getPreparedState() {
        return (PreparedState)Assertions.checkNotNull(this.preparedState);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.getPreparedState().tracks;
    }

    public TrackOutput icyTrack() {
        return this.prepareTrackOutput(new TrackId(0, true));
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public boolean isLoading() {
        return this.loader.isLoading() && this.loadCondition.isOpen();
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != 0x8000000000000001L;
    }

    // 去混淆评级： 低(20)
    public boolean isReady(int v) {
        return !this.suppressRead() && this.sampleQueues[v].isReady(this.loadingFinished);
    }

    private void lambda$new$0() {
        if(!this.released) {
            ((com.google.android.exoplayer2.source.MediaPeriod.Callback)Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    private void maybeFinishPrepare() {
        SeekMap seekMap0 = this.seekMap;
        if(!this.released && !this.prepared && this.sampleQueuesBuilt && seekMap0 != null) {
            SampleQueue[] arr_sampleQueue = this.sampleQueues;
            boolean z = false;
            for(int v = 0; true; ++v) {
                if(v >= arr_sampleQueue.length) {
                    this.loadCondition.close();
                    int v1 = this.sampleQueues.length;
                    TrackGroup[] arr_trackGroup = new TrackGroup[v1];
                    boolean[] arr_z = new boolean[v1];
                    this.durationUs = seekMap0.getDurationUs();
                    for(int v2 = 0; v2 < v1; ++v2) {
                        Format format0 = this.sampleQueues[v2].getUpstreamFormat();
                        boolean z1 = MimeTypes.isAudio(format0.sampleMimeType);
                        boolean z2 = z1 || MimeTypes.isVideo(format0.sampleMimeType);
                        arr_z[v2] = z2;
                        this.haveAudioVideoTracks |= z2;
                        IcyHeaders icyHeaders0 = this.icyHeaders;
                        if(icyHeaders0 != null) {
                            if(z1 || this.sampleQueueTrackIds[v2].isIcyTrack) {
                                format0 = format0.copyWithMetadata((format0.metadata == null ? new Metadata(new Entry[]{icyHeaders0}) : format0.metadata.copyWithAppendedEntries(new Entry[]{icyHeaders0})));
                            }
                            if(z1 && format0.bitrate == -1) {
                                int v3 = icyHeaders0.bitrate;
                                if(v3 != -1) {
                                    format0 = format0.copyWithBitrate(v3);
                                }
                            }
                        }
                        DrmInitData drmInitData0 = format0.drmInitData;
                        if(drmInitData0 != null) {
                            format0 = format0.copyWithExoMediaCryptoType(this.drmSessionManager.getExoMediaCryptoType(drmInitData0));
                        }
                        arr_trackGroup[v2] = new TrackGroup(new Format[]{format0});
                    }
                    if(this.length == -1L && seekMap0.getDurationUs() == 0x8000000000000001L) {
                        z = true;
                    }
                    this.isLive = z;
                    this.dataType = z ? 7 : 1;
                    this.preparedState = new PreparedState(seekMap0, new TrackGroupArray(arr_trackGroup), arr_z);
                    this.prepared = true;
                    long v4 = this.durationUs;
                    boolean z3 = seekMap0.isSeekable();
                    this.listener.onSourceInfoRefreshed(v4, z3, this.isLive);
                    ((com.google.android.exoplayer2.source.MediaPeriod.Callback)Assertions.checkNotNull(this.callback)).onPrepared(this);
                    break;
                }
                if(arr_sampleQueue[v].getUpstreamFormat() == null) {
                    break;
                }
            }
        }
    }

    private void maybeNotifyDownstreamFormat(int v) {
        PreparedState progressiveMediaPeriod$PreparedState0 = this.getPreparedState();
        boolean[] arr_z = progressiveMediaPeriod$PreparedState0.trackNotifiedDownstreamFormats;
        if(!arr_z[v]) {
            Format format0 = progressiveMediaPeriod$PreparedState0.tracks.get(v).getFormat(0);
            int v1 = MimeTypes.getTrackType(format0.sampleMimeType);
            this.eventDispatcher.downstreamFormatChanged(v1, format0, 0, null, this.lastSeekPositionUs);
            arr_z[v] = true;
        }
    }

    private void maybeStartDeferredRetry(int v) {
        boolean[] arr_z = this.getPreparedState().trackIsAudioVideoFlags;
        if(this.pendingDeferredRetry && arr_z[v] && !this.sampleQueues[v].isReady(false)) {
            this.pendingResetPositionUs = 0L;
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = true;
            this.lastSeekPositionUs = 0L;
            this.extractedSamplesCountAtStartOfLoad = 0;
            SampleQueue[] arr_sampleQueue = this.sampleQueues;
            for(int v1 = 0; v1 < arr_sampleQueue.length; ++v1) {
                arr_sampleQueue[v1].reset();
            }
            ((com.google.android.exoplayer2.source.MediaPeriod.Callback)Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
        }
    }

    public void maybeThrowError() {
        int v = this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType);
        this.loader.maybeThrowError(v);
    }

    public void maybeThrowError(int v) {
        this.sampleQueues[v].maybeThrowError();
        this.maybeThrowError();
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void maybeThrowPrepareError() {
        this.maybeThrowError();
        if(this.loadingFinished && !this.prepared) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    public void onLoadCanceled(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0, long v, long v1, boolean z) {
        this.eventDispatcher.loadCanceled(ExtractingLoadable.access$100(progressiveMediaPeriod$ExtractingLoadable0), ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable0).getLastOpenedUri(), ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable0).getLastResponseHeaders(), 1, -1, null, 0, null, ExtractingLoadable.access$300(progressiveMediaPeriod$ExtractingLoadable0), this.durationUs, v, v1, ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable0).getBytesRead());
        if(!z) {
            this.copyLengthFromLoader(progressiveMediaPeriod$ExtractingLoadable0);
            SampleQueue[] arr_sampleQueue = this.sampleQueues;
            for(int v2 = 0; v2 < arr_sampleQueue.length; ++v2) {
                arr_sampleQueue[v2].reset();
            }
            if(this.enabledTrackCount > 0) {
                ((com.google.android.exoplayer2.source.MediaPeriod.Callback)Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCanceled(Loadable loader$Loadable0, long v, long v1, boolean z) {
        this.onLoadCanceled(((ExtractingLoadable)loader$Loadable0), v, v1, z);
    }

    public void onLoadCompleted(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0, long v, long v1) {
        if(this.durationUs == 0x8000000000000001L) {
            SeekMap seekMap0 = this.seekMap;
            if(seekMap0 != null) {
                boolean z = seekMap0.isSeekable();
                long v2 = this.getLargestQueuedTimestampUs();
                long v3 = v2 == 0x8000000000000000L ? 0L : v2 + 10000L;
                this.durationUs = v3;
                this.listener.onSourceInfoRefreshed(v3, z, this.isLive);
            }
        }
        this.eventDispatcher.loadCompleted(ExtractingLoadable.access$100(progressiveMediaPeriod$ExtractingLoadable0), ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable0).getLastOpenedUri(), ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable0).getLastResponseHeaders(), 1, -1, null, 0, null, ExtractingLoadable.access$300(progressiveMediaPeriod$ExtractingLoadable0), this.durationUs, v, v1, ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable0).getBytesRead());
        this.copyLengthFromLoader(progressiveMediaPeriod$ExtractingLoadable0);
        this.loadingFinished = true;
        ((com.google.android.exoplayer2.source.MediaPeriod.Callback)Assertions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCompleted(Loadable loader$Loadable0, long v, long v1) {
        this.onLoadCompleted(((ExtractingLoadable)loader$Loadable0), v, v1);
    }

    public LoadErrorAction onLoadError(ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0, long v, long v1, IOException iOException0, int v2) {
        LoadErrorAction loader$LoadErrorAction0;
        this.copyLengthFromLoader(progressiveMediaPeriod$ExtractingLoadable0);
        long v3 = this.loadErrorHandlingPolicy.getRetryDelayMsFor(this.dataType, v1, iOException0, v2);
        if(Long.compare(v3, 0x8000000000000001L) == 0) {
            loader$LoadErrorAction0 = Loader.DONT_RETRY_FATAL;
        }
        else {
            int v4 = this.getExtractedSamplesCount();
            boolean z = v4 > this.extractedSamplesCountAtStartOfLoad;
            loader$LoadErrorAction0 = this.configureRetry(progressiveMediaPeriod$ExtractingLoadable0, v4) ? Loader.createRetryAction(z, v3) : Loader.DONT_RETRY;
        }
        long v5 = this.durationUs;
        boolean z1 = loader$LoadErrorAction0.isRetry();
        this.eventDispatcher.loadError(ExtractingLoadable.access$100(progressiveMediaPeriod$ExtractingLoadable0), ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable0).getLastOpenedUri(), ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable0).getLastResponseHeaders(), 1, -1, null, 0, null, ExtractingLoadable.access$300(progressiveMediaPeriod$ExtractingLoadable0), v5, v, v1, ExtractingLoadable.access$200(progressiveMediaPeriod$ExtractingLoadable0).getBytesRead(), iOException0, !z1);
        return loader$LoadErrorAction0;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public LoadErrorAction onLoadError(Loadable loader$Loadable0, long v, long v1, IOException iOException0, int v2) {
        return this.onLoadError(((ExtractingLoadable)loader$Loadable0), v, v1, iOException0, v2);
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$ReleaseCallback
    public void onLoaderReleased() {
        SampleQueue[] arr_sampleQueue = this.sampleQueues;
        for(int v = 0; v < arr_sampleQueue.length; ++v) {
            arr_sampleQueue[v].release();
        }
        this.extractorHolder.release();
    }

    @Override  // com.google.android.exoplayer2.source.SampleQueue$UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format0) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void prepare(com.google.android.exoplayer2.source.MediaPeriod.Callback mediaPeriod$Callback0, long v) {
        this.callback = mediaPeriod$Callback0;
        this.loadCondition.open();
        this.startLoading();
    }

    private TrackOutput prepareTrackOutput(TrackId progressiveMediaPeriod$TrackId0) {
        int v = this.sampleQueues.length;
        for(int v1 = 0; v1 < v; ++v1) {
            if(progressiveMediaPeriod$TrackId0.equals(this.sampleQueueTrackIds[v1])) {
                return this.sampleQueues[v1];
            }
        }
        Looper looper0 = this.handler.getLooper();
        SampleQueue sampleQueue0 = new SampleQueue(this.allocator, looper0, this.drmSessionManager);
        sampleQueue0.setUpstreamFormatChangeListener(this);
        TrackId[] arr_progressiveMediaPeriod$TrackId = (TrackId[])Arrays.copyOf(this.sampleQueueTrackIds, v + 1);
        arr_progressiveMediaPeriod$TrackId[v] = progressiveMediaPeriod$TrackId0;
        this.sampleQueueTrackIds = arr_progressiveMediaPeriod$TrackId;
        SampleQueue[] arr_sampleQueue = (SampleQueue[])Arrays.copyOf(this.sampleQueues, v + 1);
        arr_sampleQueue[v] = sampleQueue0;
        this.sampleQueues = arr_sampleQueue;
        return sampleQueue0;
    }

    public int readData(int v, FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
        if(this.suppressRead()) {
            return -3;
        }
        this.maybeNotifyDownstreamFormat(v);
        int v1 = this.sampleQueues[v].read(formatHolder0, decoderInputBuffer0, z, this.loadingFinished, this.lastSeekPositionUs);
        if(v1 == -3) {
            this.maybeStartDeferredRetry(v);
        }
        return v1;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long readDiscontinuity() {
        if(!this.notifiedReadingStarted) {
            this.eventDispatcher.readingStarted();
            this.notifiedReadingStarted = true;
        }
        if(this.notifyDiscontinuity && (this.loadingFinished || this.getExtractedSamplesCount() > this.extractedSamplesCountAtStartOfLoad)) {
            this.notifyDiscontinuity = false;
            return this.lastSeekPositionUs;
        }
        return 0x8000000000000001L;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public void reevaluateBuffer(long v) {
    }

    public void release() {
        if(this.prepared) {
            SampleQueue[] arr_sampleQueue = this.sampleQueues;
            for(int v = 0; v < arr_sampleQueue.length; ++v) {
                arr_sampleQueue[v].preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.callback = null;
        this.released = true;
        this.eventDispatcher.mediaPeriodReleased();
    }

    private boolean seekInsideBufferUs(boolean[] arr_z, long v) {
        for(int v1 = 0; v1 < this.sampleQueues.length; ++v1) {
            if(!this.sampleQueues[v1].seekTo(v, false) && (arr_z[v1] || !this.haveAudioVideoTracks)) {
                return false;
            }
        }
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap0) {
        if(this.icyHeaders != null) {
            seekMap0 = new Unseekable(0x8000000000000001L);
        }
        this.seekMap = seekMap0;
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long seekToUs(long v) {
        PreparedState progressiveMediaPeriod$PreparedState0 = this.getPreparedState();
        boolean[] arr_z = progressiveMediaPeriod$PreparedState0.trackIsAudioVideoFlags;
        if(!progressiveMediaPeriod$PreparedState0.seekMap.isSeekable()) {
            v = 0L;
        }
        this.notifyDiscontinuity = false;
        this.lastSeekPositionUs = v;
        if(this.isPendingReset()) {
            this.pendingResetPositionUs = v;
            return v;
        }
        if(this.dataType == 7 || !this.seekInsideBufferUs(arr_z, v)) {
            this.pendingDeferredRetry = false;
            this.pendingResetPositionUs = v;
            this.loadingFinished = false;
            if(this.loader.isLoading()) {
                this.loader.cancelLoading();
                return v;
            }
            this.loader.clearFatalError();
            SampleQueue[] arr_sampleQueue = this.sampleQueues;
            for(int v1 = 0; v1 < arr_sampleQueue.length; ++v1) {
                arr_sampleQueue[v1].reset();
            }
        }
        return v;
    }

    @Override  // com.google.android.exoplayer2.source.MediaPeriod
    public long selectTracks(TrackSelection[] arr_trackSelection, boolean[] arr_z, SampleStream[] arr_sampleStream, boolean[] arr_z1, long v) {
        boolean z;
        PreparedState progressiveMediaPeriod$PreparedState0 = this.getPreparedState();
        TrackGroupArray trackGroupArray0 = progressiveMediaPeriod$PreparedState0.tracks;
        boolean[] arr_z2 = progressiveMediaPeriod$PreparedState0.trackEnabledStates;
        int v1 = this.enabledTrackCount;
        int v2 = 0;
        for(int v3 = 0; v3 < arr_trackSelection.length; ++v3) {
            SampleStream sampleStream0 = arr_sampleStream[v3];
            if(sampleStream0 != null && (arr_trackSelection[v3] == null || !arr_z[v3])) {
                int v4 = SampleStreamImpl.access$000(((SampleStreamImpl)sampleStream0));
                Assertions.checkState(arr_z2[v4]);
                --this.enabledTrackCount;
                arr_z2[v4] = false;
                arr_sampleStream[v3] = null;
            }
        }
        if(!this.seenFirstTrackSelection) {
            z = v != 0L;
        }
        else if(v1 == 0) {
            z = true;
        }
        else {
            z = false;
        }
        for(int v5 = 0; v5 < arr_trackSelection.length; ++v5) {
            if(arr_sampleStream[v5] == null) {
                TrackSelection trackSelection0 = arr_trackSelection[v5];
                if(trackSelection0 != null) {
                    Assertions.checkState(trackSelection0.length() == 1);
                    Assertions.checkState(trackSelection0.getIndexInTrackGroup(0) == 0);
                    int v6 = trackGroupArray0.indexOf(trackSelection0.getTrackGroup());
                    Assertions.checkState(!arr_z2[v6]);
                    ++this.enabledTrackCount;
                    arr_z2[v6] = true;
                    arr_sampleStream[v5] = new SampleStreamImpl(this, v6);
                    arr_z1[v5] = true;
                    if(!z) {
                        SampleQueue sampleQueue0 = this.sampleQueues[v6];
                        z = !sampleQueue0.seekTo(v, true) && sampleQueue0.getReadIndex() != 0;
                    }
                }
            }
        }
        if(this.enabledTrackCount == 0) {
            this.pendingDeferredRetry = false;
            this.notifyDiscontinuity = false;
            if(this.loader.isLoading()) {
                SampleQueue[] arr_sampleQueue = this.sampleQueues;
                while(v2 < arr_sampleQueue.length) {
                    arr_sampleQueue[v2].discardToEnd();
                    ++v2;
                }
                this.loader.cancelLoading();
            }
            else {
                SampleQueue[] arr_sampleQueue1 = this.sampleQueues;
                while(v2 < arr_sampleQueue1.length) {
                    arr_sampleQueue1[v2].reset();
                    ++v2;
                }
            }
        }
        else if(z) {
            v = this.seekToUs(v);
            while(v2 < arr_sampleStream.length) {
                if(arr_sampleStream[v2] != null) {
                    arr_z1[v2] = true;
                }
                ++v2;
            }
        }
        this.seenFirstTrackSelection = true;
        return v;
    }

    public int skipData(int v, long v1) {
        if(this.suppressRead()) {
            return 0;
        }
        this.maybeNotifyDownstreamFormat(v);
        SampleQueue sampleQueue0 = this.sampleQueues[v];
        int v2 = !this.loadingFinished || v1 <= sampleQueue0.getLargestQueuedTimestampUs() ? sampleQueue0.advanceTo(v1) : sampleQueue0.advanceToEnd();
        if(v2 == 0) {
            this.maybeStartDeferredRetry(v);
        }
        return v2;
    }

    private void startLoading() {
        ExtractingLoadable progressiveMediaPeriod$ExtractingLoadable0 = new ExtractingLoadable(this, this.uri, this.dataSource, this.extractorHolder, this, this.loadCondition);
        if(this.prepared) {
            SeekMap seekMap0 = this.getPreparedState().seekMap;
            Assertions.checkState(this.isPendingReset());
            if(this.durationUs != 0x8000000000000001L && this.pendingResetPositionUs > this.durationUs) {
                this.loadingFinished = true;
                this.pendingResetPositionUs = 0x8000000000000001L;
                return;
            }
            ExtractingLoadable.access$500(progressiveMediaPeriod$ExtractingLoadable0, seekMap0.getSeekPoints(this.pendingResetPositionUs).first.position, this.pendingResetPositionUs);
            this.pendingResetPositionUs = 0x8000000000000001L;
        }
        this.extractedSamplesCountAtStartOfLoad = this.getExtractedSamplesCount();
        int v = this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(this.dataType);
        long v1 = this.loader.startLoading(progressiveMediaPeriod$ExtractingLoadable0, this, v);
        this.eventDispatcher.loadStarted(ExtractingLoadable.access$100(progressiveMediaPeriod$ExtractingLoadable0), 1, -1, null, 0, null, ExtractingLoadable.access$300(progressiveMediaPeriod$ExtractingLoadable0), this.durationUs, v1);
    }

    // 去混淆评级： 低(20)
    private boolean suppressRead() {
        return this.notifyDiscontinuity || this.isPendingReset();
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int v, int v1) {
        return this.prepareTrackOutput(new TrackId(v, false));
    }
}

