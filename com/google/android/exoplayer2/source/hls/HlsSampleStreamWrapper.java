package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher;
import com.google.android.exoplayer2.source.SampleQueue.UpstreamFormatChangedListener;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SequenceableLoader;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader.Callback;
import com.google.android.exoplayer2.upstream.Loader.LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader.Loadable;
import com.google.android.exoplayer2.upstream.Loader.ReleaseCallback;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsSampleStreamWrapper implements ExtractorOutput, UpstreamFormatChangedListener, SequenceableLoader, Callback, ReleaseCallback {
    public interface com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback extends com.google.android.exoplayer2.source.SequenceableLoader.Callback {
        void onPlaylistRefreshRequired(Uri arg1);

        void onPrepared();
    }

    static class EmsgUnwrappingTrackOutput implements TrackOutput {
        private static final Format EMSG_FORMAT = null;
        private static final Format ID3_FORMAT = null;
        private static final String TAG = "EmsgUnwrappingTrackOutput";
        private byte[] buffer;
        private int bufferPosition;
        private final TrackOutput delegate;
        private final Format delegateFormat;
        private final EventMessageDecoder emsgDecoder;
        private Format format;

        static {
            EmsgUnwrappingTrackOutput.ID3_FORMAT = Format.createSampleFormat(null, "application/id3", 0x7FFFFFFFFFFFFFFFL);
            EmsgUnwrappingTrackOutput.EMSG_FORMAT = Format.createSampleFormat(null, "application/x-emsg", 0x7FFFFFFFFFFFFFFFL);
        }

        public EmsgUnwrappingTrackOutput(TrackOutput trackOutput0, int v) {
            this.emsgDecoder = new EventMessageDecoder();
            this.delegate = trackOutput0;
            switch(v) {
                case 1: {
                    this.delegateFormat = EmsgUnwrappingTrackOutput.ID3_FORMAT;
                    break;
                }
                case 3: {
                    this.delegateFormat = EmsgUnwrappingTrackOutput.EMSG_FORMAT;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown metadataType: " + v);
                }
            }
            this.buffer = new byte[0];
            this.bufferPosition = 0;
        }

        private boolean emsgContainsExpectedWrappedFormat(EventMessage eventMessage0) {
            Format format0 = eventMessage0.getWrappedMetadataFormat();
            return format0 != null && Util.areEqual(this.delegateFormat.sampleMimeType, format0.sampleMimeType);
        }

        private void ensureBufferCapacity(int v) {
            byte[] arr_b = this.buffer;
            if(arr_b.length < v) {
                this.buffer = Arrays.copyOf(arr_b, v / 2 + v);
            }
        }

        @Override  // com.google.android.exoplayer2.extractor.TrackOutput
        public void format(Format format0) {
            this.format = format0;
            this.delegate.format(this.delegateFormat);
        }

        private ParsableByteArray getSampleAndTrimBuffer(int v, int v1) {
            int v2 = this.bufferPosition - v1;
            ParsableByteArray parsableByteArray0 = new ParsableByteArray(Arrays.copyOfRange(this.buffer, v2 - v, v2));
            System.arraycopy(this.buffer, v2, this.buffer, 0, v1);
            this.bufferPosition = v1;
            return parsableByteArray0;
        }

        @Override  // com.google.android.exoplayer2.extractor.TrackOutput
        public int sampleData(ExtractorInput extractorInput0, int v, boolean z) {
            this.ensureBufferCapacity(this.bufferPosition + v);
            int v1 = extractorInput0.read(this.buffer, this.bufferPosition, v);
            if(v1 == -1) {
                if(!z) {
                    throw new EOFException();
                }
                return -1;
            }
            this.bufferPosition += v1;
            return v1;
        }

        @Override  // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleData(ParsableByteArray parsableByteArray0, int v) {
            this.ensureBufferCapacity(this.bufferPosition + v);
            parsableByteArray0.readBytes(this.buffer, this.bufferPosition, v);
            this.bufferPosition += v;
        }

        @Override  // com.google.android.exoplayer2.extractor.TrackOutput
        public void sampleMetadata(long v, int v1, int v2, int v3, CryptoData trackOutput$CryptoData0) {
            Assertions.checkNotNull(this.format);
            ParsableByteArray parsableByteArray0 = this.getSampleAndTrimBuffer(v2, v3);
            if(!Util.areEqual(this.format.sampleMimeType, this.delegateFormat.sampleMimeType)) {
                if("application/x-emsg".equals(this.format.sampleMimeType)) {
                    EventMessage eventMessage0 = this.emsgDecoder.decode(parsableByteArray0);
                    if(!this.emsgContainsExpectedWrappedFormat(eventMessage0)) {
                        Format format0 = eventMessage0.getWrappedMetadataFormat();
                        Log.w("EmsgUnwrappingTrackOutput", "Ignoring EMSG. Expected it to contain wrapped " + this.delegateFormat.sampleMimeType + " but actual wrapped format: " + format0);
                        return;
                    }
                    parsableByteArray0 = new ParsableByteArray(((byte[])Assertions.checkNotNull(eventMessage0.getWrappedMetadataBytes())));
                    goto label_14;
                }
                String s = String.valueOf(this.format.sampleMimeType);
                Log.w("EmsgUnwrappingTrackOutput", (s.length() == 0 ? new String("Ignoring sample for unsupported format: ") : "Ignoring sample for unsupported format: " + s));
                return;
            }
        label_14:
            int v4 = parsableByteArray0.bytesLeft();
            this.delegate.sampleData(parsableByteArray0, v4);
            this.delegate.sampleMetadata(v, v1, v4, v3, trackOutput$CryptoData0);
        }
    }

    static final class FormatAdjustingSampleQueue extends SampleQueue {
        private DrmInitData drmInitData;
        private final Map overridingDrmInitData;

        public FormatAdjustingSampleQueue(Allocator allocator0, Looper looper0, DrmSessionManager drmSessionManager0, Map map0) {
            super(allocator0, looper0, drmSessionManager0);
            this.overridingDrmInitData = map0;
        }

        private Metadata getAdjustedMetadata(Metadata metadata0) {
            if(metadata0 == null) {
                return null;
            }
            int v = metadata0.length();
            int v2;
            for(v2 = 0; true; ++v2) {
                if(v2 >= v) {
                    v2 = -1;
                    break;
                }
                Entry metadata$Entry0 = metadata0.get(v2);
                if(metadata$Entry0 instanceof PrivFrame && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame)metadata$Entry0).owner)) {
                    break;
                }
            }
            if(v2 == -1) {
                return metadata0;
            }
            if(v == 1) {
                return null;
            }
            Entry[] arr_metadata$Entry = new Entry[v - 1];
            for(int v1 = 0; v1 < v; ++v1) {
                if(v1 != v2) {
                    arr_metadata$Entry[(v1 >= v2 ? v1 - 1 : v1)] = metadata0.get(v1);
                }
            }
            return new Metadata(arr_metadata$Entry);
        }

        @Override  // com.google.android.exoplayer2.source.SampleQueue
        public Format getAdjustedUpstreamFormat(Format format0) {
            DrmInitData drmInitData0 = this.drmInitData == null ? format0.drmInitData : this.drmInitData;
            if(drmInitData0 != null) {
                DrmInitData drmInitData1 = (DrmInitData)this.overridingDrmInitData.get(drmInitData0.schemeType);
                if(drmInitData1 != null) {
                    drmInitData0 = drmInitData1;
                }
            }
            return super.getAdjustedUpstreamFormat(format0.copyWithAdjustments(drmInitData0, this.getAdjustedMetadata(format0.metadata)));
        }

        public void setDrmInitData(DrmInitData drmInitData0) {
            this.drmInitData = drmInitData0;
            this.invalidateUpstreamFormatAdjustment();
        }
    }

    private static final Set MAPPABLE_TYPES = null;
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_FATAL = -2;
    public static final int SAMPLE_QUEUE_INDEX_NO_MAPPING_NON_FATAL = -3;
    public static final int SAMPLE_QUEUE_INDEX_PENDING = -1;
    private static final String TAG = "HlsSampleStreamWrapper";
    private final Allocator allocator;
    private final com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback callback;
    private final HlsChunkSource chunkSource;
    private int chunkUid;
    private Format downstreamTrackFormat;
    private DrmInitData drmInitData;
    private final DrmSessionManager drmSessionManager;
    private TrackOutput emsgUnwrappingTrackOutput;
    private int enabledTrackGroupCount;
    private final EventDispatcher eventDispatcher;
    private final Handler handler;
    private boolean haveAudioVideoSampleQueues;
    private final ArrayList hlsSampleStreams;
    private long lastSeekPositionUs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final Loader loader;
    private boolean loadingFinished;
    private final Runnable maybeFinishPrepareRunnable;
    private final ArrayList mediaChunks;
    private final int metadataType;
    private final Format muxedAudioFormat;
    private final HlsChunkHolder nextChunkHolder;
    private final Runnable onTracksEndedRunnable;
    private Set optionalTrackGroups;
    private final Map overridingDrmInitData;
    private long pendingResetPositionUs;
    private boolean pendingResetUpstreamFormats;
    private boolean prepared;
    private int primarySampleQueueIndex;
    private int primarySampleQueueType;
    private int primaryTrackGroupIndex;
    private final List readOnlyMediaChunks;
    private boolean released;
    private long sampleOffsetUs;
    private SparseIntArray sampleQueueIndicesByType;
    private boolean[] sampleQueueIsAudioVideoFlags;
    private Set sampleQueueMappingDoneByType;
    private int[] sampleQueueTrackIds;
    private FormatAdjustingSampleQueue[] sampleQueues;
    private boolean sampleQueuesBuilt;
    private boolean[] sampleQueuesEnabledStates;
    private boolean seenFirstTrackSelection;
    private int[] trackGroupToSampleQueueIndex;
    private TrackGroupArray trackGroups;
    private final int trackType;
    private boolean tracksEnded;
    private Format upstreamTrackFormat;

    static {
        HlsSampleStreamWrapper.MAPPABLE_TYPES = Collections.unmodifiableSet(new HashSet(Arrays.asList(new Integer[]{1, 2, 4})));
    }

    public HlsSampleStreamWrapper(int v, com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper.Callback hlsSampleStreamWrapper$Callback0, HlsChunkSource hlsChunkSource0, Map map0, Allocator allocator0, long v1, Format format0, DrmSessionManager drmSessionManager0, LoadErrorHandlingPolicy loadErrorHandlingPolicy0, EventDispatcher mediaSourceEventListener$EventDispatcher0, int v2) {
        this.trackType = v;
        this.callback = hlsSampleStreamWrapper$Callback0;
        this.chunkSource = hlsChunkSource0;
        this.overridingDrmInitData = map0;
        this.allocator = allocator0;
        this.muxedAudioFormat = format0;
        this.drmSessionManager = drmSessionManager0;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy0;
        this.eventDispatcher = mediaSourceEventListener$EventDispatcher0;
        this.metadataType = v2;
        this.loader = new Loader("Loader:HlsSampleStreamWrapper");
        this.nextChunkHolder = new HlsChunkHolder();
        this.sampleQueueTrackIds = new int[0];
        this.sampleQueueMappingDoneByType = new HashSet(HlsSampleStreamWrapper.MAPPABLE_TYPES.size());
        this.sampleQueueIndicesByType = new SparseIntArray(HlsSampleStreamWrapper.MAPPABLE_TYPES.size());
        this.sampleQueues = new FormatAdjustingSampleQueue[0];
        this.sampleQueueIsAudioVideoFlags = new boolean[0];
        this.sampleQueuesEnabledStates = new boolean[0];
        ArrayList arrayList0 = new ArrayList();
        this.mediaChunks = arrayList0;
        this.readOnlyMediaChunks = Collections.unmodifiableList(arrayList0);
        this.hlsSampleStreams = new ArrayList();
        this.maybeFinishPrepareRunnable = new a(this, 0);
        this.onTracksEndedRunnable = new a(this, 1);
        this.handler = new Handler();
        this.lastSeekPositionUs = v1;
        this.pendingResetPositionUs = v1;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups"})
    private void assertIsPrepared() {
        Assertions.checkState(this.prepared);
        Assertions.checkNotNull(this.trackGroups);
        Assertions.checkNotNull(this.optionalTrackGroups);
    }

    public int bindSampleQueueToSampleStream(int v) {
        this.assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int v1 = this.trackGroupToSampleQueueIndex[v];
        if(v1 == -1) {
            return this.optionalTrackGroups.contains(this.trackGroups.get(v)) ? -3 : -2;
        }
        boolean[] arr_z = this.sampleQueuesEnabledStates;
        if(arr_z[v1]) {
            return -2;
        }
        arr_z[v1] = true;
        return v1;
    }

    @EnsuresNonNull({"trackGroups", "optionalTrackGroups", "trackGroupToSampleQueueIndex"})
    private void buildTracksFromSampleStreams() {
        int v = this.sampleQueues.length;
        boolean z = false;
        int v1 = 6;
        int v2 = -1;
        for(int v3 = 0; true; ++v3) {
            int v4 = 2;
            if(v3 >= v) {
                break;
            }
            String s = this.sampleQueues[v3].getUpstreamFormat().sampleMimeType;
            if(!MimeTypes.isVideo(s)) {
                if(MimeTypes.isAudio(s)) {
                    v4 = 1;
                }
                else {
                    v4 = MimeTypes.isText(s) ? 3 : 6;
                }
            }
            if(HlsSampleStreamWrapper.getTrackTypeScore(v4) > HlsSampleStreamWrapper.getTrackTypeScore(v1)) {
                v2 = v3;
                v1 = v4;
            }
            else if(v4 == v1 && v2 != -1) {
                v2 = -1;
            }
        }
        TrackGroup trackGroup0 = this.chunkSource.getTrackGroup();
        int v5 = trackGroup0.length;
        this.primaryTrackGroupIndex = -1;
        this.trackGroupToSampleQueueIndex = new int[v];
        for(int v6 = 0; v6 < v; ++v6) {
            this.trackGroupToSampleQueueIndex[v6] = v6;
        }
        TrackGroup[] arr_trackGroup = new TrackGroup[v];
        for(int v7 = 0; v7 < v; ++v7) {
            Format format0 = this.sampleQueues[v7].getUpstreamFormat();
            if(v7 == v2) {
                Format[] arr_format = new Format[v5];
                if(v5 == 1) {
                    arr_format[0] = format0.copyWithManifestFormatInfo(trackGroup0.getFormat(0));
                }
                else {
                    for(int v8 = 0; v8 < v5; ++v8) {
                        arr_format[v8] = HlsSampleStreamWrapper.deriveFormat(trackGroup0.getFormat(v8), format0, true);
                    }
                }
                arr_trackGroup[v7] = new TrackGroup(arr_format);
                this.primaryTrackGroupIndex = v7;
            }
            else {
                arr_trackGroup[v7] = new TrackGroup(new Format[]{HlsSampleStreamWrapper.deriveFormat((v1 != 2 || !MimeTypes.isAudio(format0.sampleMimeType) ? null : this.muxedAudioFormat), format0, false)});
            }
        }
        this.trackGroups = this.createTrackGroupArrayWithDrmInfo(arr_trackGroup);
        if(this.optionalTrackGroups == null) {
            z = true;
        }
        Assertions.checkState(z);
        this.optionalTrackGroups = Collections.EMPTY_SET;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean continueLoading(long v) {
        long v1;
        List list0;
        if(!this.loadingFinished && !this.loader.isLoading() && !this.loader.hasFatalError()) {
            if(this.isPendingReset()) {
                list0 = Collections.EMPTY_LIST;
                v1 = this.pendingResetPositionUs;
            }
            else {
                list0 = this.readOnlyMediaChunks;
                HlsMediaChunk hlsMediaChunk0 = this.getLastMediaChunk();
                v1 = hlsMediaChunk0.isLoadCompleted() ? hlsMediaChunk0.endTimeUs : Math.max(this.lastSeekPositionUs, hlsMediaChunk0.startTimeUs);
            }
            this.chunkSource.getNextChunk(v, v1, list0, this.prepared || !list0.isEmpty(), this.nextChunkHolder);
            boolean z = this.nextChunkHolder.endOfStream;
            Chunk chunk0 = this.nextChunkHolder.chunk;
            Uri uri0 = this.nextChunkHolder.playlistUrl;
            this.nextChunkHolder.clear();
            if(z) {
                this.pendingResetPositionUs = 0x8000000000000001L;
                this.loadingFinished = true;
                return true;
            }
            if(chunk0 == null) {
                if(uri0 != null) {
                    this.callback.onPlaylistRefreshRequired(uri0);
                }
                return false;
            }
            if(HlsSampleStreamWrapper.isMediaChunk(chunk0)) {
                this.pendingResetPositionUs = 0x8000000000000001L;
                ((HlsMediaChunk)chunk0).init(this);
                this.mediaChunks.add(((HlsMediaChunk)chunk0));
                this.upstreamTrackFormat = ((HlsMediaChunk)chunk0).trackFormat;
            }
            int v2 = this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(chunk0.type);
            long v3 = this.loader.startLoading(chunk0, this, v2);
            this.eventDispatcher.loadStarted(chunk0.dataSpec, chunk0.type, this.trackType, chunk0.trackFormat, chunk0.trackSelectionReason, chunk0.trackSelectionData, chunk0.startTimeUs, chunk0.endTimeUs, v3);
            return true;
        }
        return false;
    }

    public void continuePreparing() {
        if(!this.prepared) {
            this.continueLoading(this.lastSeekPositionUs);
        }
    }

    private static DummyTrackOutput createDummyTrackOutput(int v, int v1) {
        Log.w("HlsSampleStreamWrapper", "Unmapped track with id " + v + " of type " + v1);
        return new DummyTrackOutput();
    }

    private SampleQueue createSampleQueue(int v, int v1) {
        int v2 = this.sampleQueues.length;
        boolean z = v1 == 1 || v1 == 2;
        Looper looper0 = this.handler.getLooper();
        SampleQueue sampleQueue0 = new FormatAdjustingSampleQueue(this.allocator, looper0, this.drmSessionManager, this.overridingDrmInitData);
        if(z) {
            ((FormatAdjustingSampleQueue)sampleQueue0).setDrmInitData(this.drmInitData);
        }
        sampleQueue0.setSampleOffsetUs(this.sampleOffsetUs);
        sampleQueue0.sourceId(this.chunkUid);
        sampleQueue0.setUpstreamFormatChangeListener(this);
        int[] arr_v = Arrays.copyOf(this.sampleQueueTrackIds, v2 + 1);
        this.sampleQueueTrackIds = arr_v;
        arr_v[v2] = v;
        this.sampleQueues = (FormatAdjustingSampleQueue[])Util.nullSafeArrayAppend(this.sampleQueues, sampleQueue0);
        boolean[] arr_z = Arrays.copyOf(this.sampleQueueIsAudioVideoFlags, v2 + 1);
        this.sampleQueueIsAudioVideoFlags = arr_z;
        arr_z[v2] = z;
        this.haveAudioVideoSampleQueues |= z;
        this.sampleQueueMappingDoneByType.add(v1);
        this.sampleQueueIndicesByType.append(v1, v2);
        if(HlsSampleStreamWrapper.getTrackTypeScore(v1) > HlsSampleStreamWrapper.getTrackTypeScore(this.primarySampleQueueType)) {
            this.primarySampleQueueIndex = v2;
            this.primarySampleQueueType = v1;
        }
        this.sampleQueuesEnabledStates = Arrays.copyOf(this.sampleQueuesEnabledStates, v2 + 1);
        return sampleQueue0;
    }

    private TrackGroupArray createTrackGroupArrayWithDrmInfo(TrackGroup[] arr_trackGroup) {
        for(int v = 0; v < arr_trackGroup.length; ++v) {
            TrackGroup trackGroup0 = arr_trackGroup[v];
            Format[] arr_format = new Format[trackGroup0.length];
            for(int v1 = 0; v1 < trackGroup0.length; ++v1) {
                Format format0 = trackGroup0.getFormat(v1);
                DrmInitData drmInitData0 = format0.drmInitData;
                if(drmInitData0 != null) {
                    format0 = format0.copyWithExoMediaCryptoType(this.drmSessionManager.getExoMediaCryptoType(drmInitData0));
                }
                arr_format[v1] = format0;
            }
            arr_trackGroup[v] = new TrackGroup(arr_format);
        }
        return new TrackGroupArray(arr_trackGroup);
    }

    private static Format deriveFormat(Format format0, Format format1, boolean z) {
        if(format0 == null) {
            return format1;
        }
        int v = z ? format0.bitrate : -1;
        int v1 = format0.channelCount == -1 ? format1.channelCount : format0.channelCount;
        int v2 = MimeTypes.getTrackType(format1.sampleMimeType);
        String s = Util.getCodecsOfType(format0.codecs, v2);
        String s1 = MimeTypes.getMediaMimeType(s);
        if(s1 == null) {
            s1 = format1.sampleMimeType;
        }
        return format1.copyWithContainerInfo(format0.id, format0.label, s1, s, format0.metadata, v, format0.width, format0.height, v1, format0.selectionFlags, format0.language);
    }

    public void discardBuffer(long v, boolean z) {
        if(this.sampleQueuesBuilt && !this.isPendingReset()) {
            for(int v1 = 0; v1 < this.sampleQueues.length; ++v1) {
                this.sampleQueues[v1].discardTo(v, z, this.sampleQueuesEnabledStates[v1]);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
        this.tracksEnded = true;
        this.handler.post(this.onTracksEndedRunnable);
    }

    private boolean finishedReadingChunk(HlsMediaChunk hlsMediaChunk0) {
        int v = hlsMediaChunk0.uid;
        for(int v1 = 0; v1 < this.sampleQueues.length; ++v1) {
            if(this.sampleQueuesEnabledStates[v1] && this.sampleQueues[v1].peekSourceId() == v) {
                return false;
            }
        }
        return true;
    }

    private static boolean formatsMatch(Format format0, Format format1) {
        String s = format0.sampleMimeType;
        String s1 = format1.sampleMimeType;
        int v = MimeTypes.getTrackType(s);
        if(v != 3) {
            return v == MimeTypes.getTrackType(s1);
        }
        if(!Util.areEqual(s, s1)) {
            return false;
        }
        return "application/cea-608".equals(s) || "application/cea-708".equals(s) ? format0.accessibilityChannel == format1.accessibilityChannel : true;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public long getBufferedPositionUs() {
        if(this.loadingFinished) {
            return 0x8000000000000000L;
        }
        if(this.isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        long v = this.lastSeekPositionUs;
        HlsMediaChunk hlsMediaChunk0 = this.getLastMediaChunk();
        if(!hlsMediaChunk0.isLoadCompleted()) {
            hlsMediaChunk0 = this.mediaChunks.size() <= 1 ? null : ((HlsMediaChunk)com.iloen.melon.utils.a.i(2, this.mediaChunks));
        }
        if(hlsMediaChunk0 != null) {
            v = Math.max(v, hlsMediaChunk0.endTimeUs);
        }
        if(this.sampleQueuesBuilt) {
            FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
            for(int v1 = 0; v1 < arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length; ++v1) {
                v = Math.max(v, arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v1].getLargestQueuedTimestampUs());
            }
        }
        return v;
    }

    private HlsMediaChunk getLastMediaChunk() {
        return (HlsMediaChunk)com.iloen.melon.utils.a.i(1, this.mediaChunks);
    }

    private TrackOutput getMappedTrackOutput(int v, int v1) {
        Assertions.checkArgument(HlsSampleStreamWrapper.MAPPABLE_TYPES.contains(v1));
        int v2 = this.sampleQueueIndicesByType.get(v1, -1);
        if(v2 == -1) {
            return null;
        }
        if(this.sampleQueueMappingDoneByType.add(v1)) {
            this.sampleQueueTrackIds[v2] = v;
        }
        return this.sampleQueueTrackIds[v2] == v ? this.sampleQueues[v2] : HlsSampleStreamWrapper.createDummyTrackOutput(v, v1);
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        if(this.isPendingReset()) {
            return this.pendingResetPositionUs;
        }
        return this.loadingFinished ? 0x8000000000000000L : this.getLastMediaChunk().endTimeUs;
    }

    public int getPrimaryTrackGroupIndex() {
        return this.primaryTrackGroupIndex;
    }

    public TrackGroupArray getTrackGroups() {
        this.assertIsPrepared();
        return this.trackGroups;
    }

    private static int getTrackTypeScore(int v) {
        if(v != 1) {
            switch(v) {
                case 2: {
                    return 3;
                }
                case 3: {
                    return 1;
                }
                default: {
                    return 0;
                }
            }
        }
        return 2;
    }

    public void init(int v, boolean z) {
        this.chunkUid = v;
        FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
        for(int v2 = 0; v2 < arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length; ++v2) {
            arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v2].sourceId(v);
        }
        if(z) {
            FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue1 = this.sampleQueues;
            for(int v1 = 0; v1 < arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue1.length; ++v1) {
                arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue1[v1].splice();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public boolean isLoading() {
        return this.loader.isLoading();
    }

    private static boolean isMediaChunk(Chunk chunk0) {
        return chunk0 instanceof HlsMediaChunk;
    }

    private boolean isPendingReset() {
        return this.pendingResetPositionUs != 0x8000000000000001L;
    }

    // 去混淆评级： 低(20)
    public boolean isReady(int v) {
        return !this.isPendingReset() && this.sampleQueues[v].isReady(this.loadingFinished);
    }

    @EnsuresNonNull({"trackGroupToSampleQueueIndex"})
    @RequiresNonNull({"trackGroups"})
    private void mapSampleQueuesToMatchTrackGroups() {
        int v = this.trackGroups.length;
        int[] arr_v = new int[v];
        this.trackGroupToSampleQueueIndex = arr_v;
        Arrays.fill(arr_v, -1);
        for(int v1 = 0; v1 < v; ++v1) {
            for(int v2 = 0; true; ++v2) {
                FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
                if(v2 >= arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length) {
                    break;
                }
                if(HlsSampleStreamWrapper.formatsMatch(arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v2].getUpstreamFormat(), this.trackGroups.get(v1).getFormat(0))) {
                    this.trackGroupToSampleQueueIndex[v1] = v2;
                    break;
                }
            }
        }
        for(Object object0: this.hlsSampleStreams) {
            ((HlsSampleStream)object0).bindSampleQueue();
        }
    }

    private void maybeFinishPrepare() {
        if(!this.released && this.trackGroupToSampleQueueIndex == null && this.sampleQueuesBuilt) {
            FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
            for(int v = 0; true; ++v) {
                if(v >= arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length) {
                    if(this.trackGroups != null) {
                        this.mapSampleQueuesToMatchTrackGroups();
                        return;
                    }
                    this.buildTracksFromSampleStreams();
                    this.setIsPrepared();
                    this.callback.onPrepared();
                    break;
                }
                if(arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v].getUpstreamFormat() == null) {
                    break;
                }
            }
        }
    }

    public void maybeThrowError() {
        this.loader.maybeThrowError();
        this.chunkSource.maybeThrowError();
    }

    public void maybeThrowError(int v) {
        this.maybeThrowError();
        this.sampleQueues[v].maybeThrowError();
    }

    public void maybeThrowPrepareError() {
        this.maybeThrowError();
        if(this.loadingFinished && !this.prepared) {
            throw new ParserException("Loading finished before preparation is complete.");
        }
    }

    public void onLoadCanceled(Chunk chunk0, long v, long v1, boolean z) {
        Uri uri0 = chunk0.getUri();
        Map map0 = chunk0.getResponseHeaders();
        long v2 = chunk0.bytesLoaded();
        this.eventDispatcher.loadCanceled(chunk0.dataSpec, uri0, map0, chunk0.type, this.trackType, chunk0.trackFormat, chunk0.trackSelectionReason, chunk0.trackSelectionData, chunk0.startTimeUs, chunk0.endTimeUs, v, v1, v2);
        if(!z) {
            this.resetSampleQueues();
            if(this.enabledTrackGroupCount > 0) {
                this.callback.onContinueLoadingRequested(this);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCanceled(Loadable loader$Loadable0, long v, long v1, boolean z) {
        this.onLoadCanceled(((Chunk)loader$Loadable0), v, v1, z);
    }

    public void onLoadCompleted(Chunk chunk0, long v, long v1) {
        this.chunkSource.onChunkLoadCompleted(chunk0);
        Uri uri0 = chunk0.getUri();
        Map map0 = chunk0.getResponseHeaders();
        long v2 = chunk0.bytesLoaded();
        this.eventDispatcher.loadCompleted(chunk0.dataSpec, uri0, map0, chunk0.type, this.trackType, chunk0.trackFormat, chunk0.trackSelectionReason, chunk0.trackSelectionData, chunk0.startTimeUs, chunk0.endTimeUs, v, v1, v2);
        if(!this.prepared) {
            this.continueLoading(this.lastSeekPositionUs);
            return;
        }
        this.callback.onContinueLoadingRequested(this);
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public void onLoadCompleted(Loadable loader$Loadable0, long v, long v1) {
        this.onLoadCompleted(((Chunk)loader$Loadable0), v, v1);
    }

    public LoadErrorAction onLoadError(Chunk chunk0, long v, long v1, IOException iOException0, int v2) {
        LoadErrorAction loader$LoadErrorAction0;
        long v3 = chunk0.bytesLoaded();
        boolean z = HlsSampleStreamWrapper.isMediaChunk(chunk0);
        long v4 = this.loadErrorHandlingPolicy.getBlacklistDurationMsFor(chunk0.type, v1, iOException0, v2);
        boolean z1 = false;
        boolean z2 = Long.compare(v4, 0x8000000000000001L) == 0 ? false : this.chunkSource.maybeBlacklistTrack(chunk0, v4);
        if(z2) {
            if(z && v3 == 0L) {
                if(((HlsMediaChunk)this.mediaChunks.remove(this.mediaChunks.size() - 1)) == chunk0) {
                    z1 = true;
                }
                Assertions.checkState(z1);
                if(this.mediaChunks.isEmpty()) {
                    this.pendingResetPositionUs = this.lastSeekPositionUs;
                }
            }
            loader$LoadErrorAction0 = Loader.DONT_RETRY;
        }
        else {
            long v5 = this.loadErrorHandlingPolicy.getRetryDelayMsFor(chunk0.type, v1, iOException0, v2);
            loader$LoadErrorAction0 = v5 == 0x8000000000000001L ? Loader.DONT_RETRY_FATAL : Loader.createRetryAction(false, v5);
        }
        Uri uri0 = chunk0.getUri();
        Map map0 = chunk0.getResponseHeaders();
        boolean z3 = loader$LoadErrorAction0.isRetry();
        this.eventDispatcher.loadError(chunk0.dataSpec, uri0, map0, chunk0.type, this.trackType, chunk0.trackFormat, chunk0.trackSelectionReason, chunk0.trackSelectionData, chunk0.startTimeUs, chunk0.endTimeUs, v, v1, v3, iOException0, !z3);
        if(z2) {
            if(!this.prepared) {
                this.continueLoading(this.lastSeekPositionUs);
                return loader$LoadErrorAction0;
            }
            this.callback.onContinueLoadingRequested(this);
        }
        return loader$LoadErrorAction0;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Callback
    public LoadErrorAction onLoadError(Loadable loader$Loadable0, long v, long v1, IOException iOException0, int v2) {
        return this.onLoadError(((Chunk)loader$Loadable0), v, v1, iOException0, v2);
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$ReleaseCallback
    public void onLoaderReleased() {
        FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
        for(int v = 0; v < arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length; ++v) {
            arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v].release();
        }
    }

    public void onNewExtractor() {
        this.sampleQueueMappingDoneByType.clear();
    }

    public boolean onPlaylistError(Uri uri0, long v) {
        return this.chunkSource.onPlaylistError(uri0, v);
    }

    private void onTracksEnded() {
        this.sampleQueuesBuilt = true;
        this.maybeFinishPrepare();
    }

    @Override  // com.google.android.exoplayer2.source.SampleQueue$UpstreamFormatChangedListener
    public void onUpstreamFormatChanged(Format format0) {
        this.handler.post(this.maybeFinishPrepareRunnable);
    }

    public void prepareWithMasterPlaylistInfo(TrackGroup[] arr_trackGroup, int v, int[] arr_v) {
        this.trackGroups = this.createTrackGroupArrayWithDrmInfo(arr_trackGroup);
        this.optionalTrackGroups = new HashSet();
        for(int v1 = 0; v1 < arr_v.length; ++v1) {
            this.optionalTrackGroups.add(this.trackGroups.get(arr_v[v1]));
        }
        this.primaryTrackGroupIndex = v;
        Objects.requireNonNull(this.callback);
        a a0 = new a(this.callback, 2);
        this.handler.post(a0);
        this.setIsPrepared();
    }

    public int readData(int v, FormatHolder formatHolder0, DecoderInputBuffer decoderInputBuffer0, boolean z) {
        int v1 = 0;
        if(this.isPendingReset()) {
            return -3;
        }
        if(!this.mediaChunks.isEmpty()) {
            int v2;
            for(v2 = 0; v2 < this.mediaChunks.size() - 1 && this.finishedReadingChunk(((HlsMediaChunk)this.mediaChunks.get(v2))); ++v2) {
            }
            Util.removeRange(this.mediaChunks, 0, v2);
            HlsMediaChunk hlsMediaChunk0 = (HlsMediaChunk)this.mediaChunks.get(0);
            Format format0 = hlsMediaChunk0.trackFormat;
            if(!format0.equals(this.downstreamTrackFormat)) {
                this.eventDispatcher.downstreamFormatChanged(this.trackType, format0, hlsMediaChunk0.trackSelectionReason, hlsMediaChunk0.trackSelectionData, hlsMediaChunk0.startTimeUs);
            }
            this.downstreamTrackFormat = format0;
        }
        int v3 = this.sampleQueues[v].read(formatHolder0, decoderInputBuffer0, z, this.loadingFinished, this.lastSeekPositionUs);
        if(v3 == -5) {
            Format format1 = (Format)Assertions.checkNotNull(formatHolder0.format);
            if(v == this.primarySampleQueueIndex) {
                int v4 = this.sampleQueues[v].peekSourceId();
                while(v1 < this.mediaChunks.size() && ((HlsMediaChunk)this.mediaChunks.get(v1)).uid != v4) {
                    ++v1;
                }
                format1 = format1.copyWithManifestFormatInfo((v1 >= this.mediaChunks.size() ? ((Format)Assertions.checkNotNull(this.upstreamTrackFormat)) : ((HlsMediaChunk)this.mediaChunks.get(v1)).trackFormat));
            }
            formatHolder0.format = format1;
        }
        return v3;
    }

    @Override  // com.google.android.exoplayer2.source.SequenceableLoader
    public void reevaluateBuffer(long v) {
    }

    public void release() {
        if(this.prepared) {
            FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
            for(int v = 0; v < arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length; ++v) {
                arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v].preRelease();
            }
        }
        this.loader.release(this);
        this.handler.removeCallbacksAndMessages(null);
        this.released = true;
        this.hlsSampleStreams.clear();
    }

    private void resetSampleQueues() {
        FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
        for(int v = 0; v < arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length; ++v) {
            arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v].reset(this.pendingResetUpstreamFormats);
        }
        this.pendingResetUpstreamFormats = false;
    }

    private boolean seekInsideBufferUs(long v) {
        for(int v1 = 0; v1 < this.sampleQueues.length; ++v1) {
            if(!this.sampleQueues[v1].seekTo(v, false) && (this.sampleQueueIsAudioVideoFlags[v1] || !this.haveAudioVideoSampleQueues)) {
                return false;
            }
        }
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap0) {
    }

    public boolean seekToUs(long v, boolean z) {
        this.lastSeekPositionUs = v;
        if(this.isPendingReset()) {
            this.pendingResetPositionUs = v;
            return true;
        }
        if(this.sampleQueuesBuilt && !z && this.seekInsideBufferUs(v)) {
            return false;
        }
        this.pendingResetPositionUs = v;
        this.loadingFinished = false;
        this.mediaChunks.clear();
        if(this.loader.isLoading()) {
            this.loader.cancelLoading();
            return true;
        }
        this.loader.clearFatalError();
        this.resetSampleQueues();
        return true;
    }

    public boolean selectTracks(TrackSelection[] arr_trackSelection, boolean[] arr_z, SampleStream[] arr_sampleStream, boolean[] arr_z1, long v, boolean z) {
        boolean z3;
        long v5;
        this.assertIsPrepared();
        int v1 = this.enabledTrackGroupCount;
        int v2 = 0;
        for(int v3 = 0; v3 < arr_trackSelection.length; ++v3) {
            HlsSampleStream hlsSampleStream0 = (HlsSampleStream)arr_sampleStream[v3];
            if(hlsSampleStream0 != null && (arr_trackSelection[v3] == null || !arr_z[v3])) {
                --this.enabledTrackGroupCount;
                hlsSampleStream0.unbindSampleQueue();
                arr_sampleStream[v3] = null;
            }
        }
        boolean z1 = z || (this.seenFirstTrackSelection ? v1 == 0 : v != this.lastSeekPositionUs);
        TrackSelection trackSelection0 = this.chunkSource.getTrackSelection();
        boolean z2 = z1;
        TrackSelection trackSelection1 = trackSelection0;
        for(int v4 = 0; true; ++v4) {
            v5 = 0L;
            if(v4 >= arr_trackSelection.length) {
                break;
            }
            TrackSelection trackSelection2 = arr_trackSelection[v4];
            if(trackSelection2 != null) {
                int v6 = this.trackGroups.indexOf(trackSelection2.getTrackGroup());
                if(v6 == this.primaryTrackGroupIndex) {
                    this.chunkSource.setTrackSelection(trackSelection2);
                    trackSelection1 = trackSelection2;
                }
                if(arr_sampleStream[v4] == null) {
                    ++this.enabledTrackGroupCount;
                    HlsSampleStream hlsSampleStream1 = new HlsSampleStream(this, v6);
                    arr_sampleStream[v4] = hlsSampleStream1;
                    arr_z1[v4] = true;
                    if(this.trackGroupToSampleQueueIndex != null) {
                        hlsSampleStream1.bindSampleQueue();
                        if(!z2) {
                            FormatAdjustingSampleQueue hlsSampleStreamWrapper$FormatAdjustingSampleQueue0 = this.sampleQueues[this.trackGroupToSampleQueueIndex[v6]];
                            z2 = !hlsSampleStreamWrapper$FormatAdjustingSampleQueue0.seekTo(v, true) && hlsSampleStreamWrapper$FormatAdjustingSampleQueue0.getReadIndex() != 0;
                        }
                    }
                }
            }
        }
        if(this.enabledTrackGroupCount == 0) {
            this.chunkSource.reset();
            this.downstreamTrackFormat = null;
            this.pendingResetUpstreamFormats = true;
            this.mediaChunks.clear();
            if(this.loader.isLoading()) {
                if(this.sampleQueuesBuilt) {
                    FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
                    while(v2 < arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length) {
                        arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v2].discardToEnd();
                        ++v2;
                    }
                }
                this.loader.cancelLoading();
            }
            else {
                this.resetSampleQueues();
            }
        }
        else {
            if(this.mediaChunks.isEmpty() || Util.areEqual(trackSelection1, trackSelection0)) {
                z3 = z;
            }
            else if(!this.seenFirstTrackSelection) {
                if(v < 0L) {
                    v5 = -v;
                }
                HlsMediaChunk hlsMediaChunk0 = this.getLastMediaChunk();
                MediaChunkIterator[] arr_mediaChunkIterator = this.chunkSource.createMediaChunkIterators(hlsMediaChunk0, v);
                trackSelection1.updateSelectedTrack(v, v5, 0x8000000000000001L, this.readOnlyMediaChunks, arr_mediaChunkIterator);
                int v7 = this.chunkSource.getTrackGroup().indexOf(hlsMediaChunk0.trackFormat);
                if(trackSelection1.getSelectedIndexInTrackGroup() == v7) {
                    z3 = z;
                    goto label_69;
                }
                goto label_64;
            }
            else {
            label_64:
                this.pendingResetUpstreamFormats = true;
                z3 = true;
                z2 = true;
            }
        label_69:
            if(z2) {
                this.seekToUs(v, z3);
                while(v2 < arr_sampleStream.length) {
                    if(arr_sampleStream[v2] != null) {
                        arr_z1[v2] = true;
                    }
                    ++v2;
                }
            }
        }
        this.updateSampleStreams(arr_sampleStream);
        this.seenFirstTrackSelection = true;
        return z2;
    }

    public void setDrmInitData(DrmInitData drmInitData0) {
        if(!Util.areEqual(this.drmInitData, drmInitData0)) {
            this.drmInitData = drmInitData0;
            for(int v = 0; true; ++v) {
                FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
                if(v >= arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length) {
                    break;
                }
                if(this.sampleQueueIsAudioVideoFlags[v]) {
                    arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v].setDrmInitData(drmInitData0);
                }
            }
        }
    }

    @RequiresNonNull({"trackGroups", "optionalTrackGroups"})
    private void setIsPrepared() {
        this.prepared = true;
    }

    public void setIsTimestampMaster(boolean z) {
        this.chunkSource.setIsTimestampMaster(z);
    }

    public void setSampleOffsetUs(long v) {
        if(this.sampleOffsetUs != v) {
            this.sampleOffsetUs = v;
            FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
            for(int v1 = 0; v1 < arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length; ++v1) {
                arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v1].setSampleOffsetUs(v);
            }
        }
    }

    public int skipData(int v, long v1) {
        if(this.isPendingReset()) {
            return 0;
        }
        FormatAdjustingSampleQueue hlsSampleStreamWrapper$FormatAdjustingSampleQueue0 = this.sampleQueues[v];
        return !this.loadingFinished || v1 <= hlsSampleStreamWrapper$FormatAdjustingSampleQueue0.getLargestQueuedTimestampUs() ? hlsSampleStreamWrapper$FormatAdjustingSampleQueue0.advanceTo(v1) : hlsSampleStreamWrapper$FormatAdjustingSampleQueue0.advanceToEnd();
    }

    @Override  // com.google.android.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int v, int v1) {
        TrackOutput trackOutput0;
        if(HlsSampleStreamWrapper.MAPPABLE_TYPES.contains(v1)) {
            trackOutput0 = this.getMappedTrackOutput(v, v1);
        }
        else {
            for(int v2 = 0; true; ++v2) {
                trackOutput0 = null;
                FormatAdjustingSampleQueue[] arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue = this.sampleQueues;
                if(v2 >= arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue.length) {
                    break;
                }
                if(this.sampleQueueTrackIds[v2] == v) {
                    trackOutput0 = arr_hlsSampleStreamWrapper$FormatAdjustingSampleQueue[v2];
                    break;
                }
            }
        }
        if(trackOutput0 == null) {
            if(this.tracksEnded) {
                return HlsSampleStreamWrapper.createDummyTrackOutput(v, v1);
            }
            trackOutput0 = this.createSampleQueue(v, v1);
        }
        if(v1 == 4) {
            if(this.emsgUnwrappingTrackOutput == null) {
                this.emsgUnwrappingTrackOutput = new EmsgUnwrappingTrackOutput(trackOutput0, this.metadataType);
            }
            return this.emsgUnwrappingTrackOutput;
        }
        return trackOutput0;
    }

    public void unbindSampleQueue(int v) {
        this.assertIsPrepared();
        Assertions.checkNotNull(this.trackGroupToSampleQueueIndex);
        int v1 = this.trackGroupToSampleQueueIndex[v];
        Assertions.checkState(this.sampleQueuesEnabledStates[v1]);
        this.sampleQueuesEnabledStates[v1] = false;
    }

    private void updateSampleStreams(SampleStream[] arr_sampleStream) {
        this.hlsSampleStreams.clear();
        for(int v = 0; v < arr_sampleStream.length; ++v) {
            SampleStream sampleStream0 = arr_sampleStream[v];
            if(sampleStream0 != null) {
                this.hlsSampleStreams.add(((HlsSampleStream)sampleStream0));
            }
        }
    }
}

