package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

final class HlsMediaChunk extends MediaChunk {
    private static final PositionHolder DUMMY_POSITION_HOLDER = null;
    public static final String PRIV_TIMESTAMP_FRAME_OWNER = "com.apple.streaming.transportStreamTimestamp";
    public final int discontinuitySequenceNumber;
    private final DrmInitData drmInitData;
    private Extractor extractor;
    private final HlsExtractorFactory extractorFactory;
    private final boolean hasGapTag;
    private final Id3Decoder id3Decoder;
    private boolean initDataLoadRequired;
    private final DataSource initDataSource;
    private final DataSpec initDataSpec;
    private final boolean initSegmentEncrypted;
    private boolean isExtractorReusable;
    private final boolean isMasterTimestampSource;
    private volatile boolean loadCanceled;
    private boolean loadCompleted;
    private final boolean mediaSegmentEncrypted;
    private final List muxedCaptionFormats;
    private int nextLoadPosition;
    private HlsSampleStreamWrapper output;
    public final Uri playlistUrl;
    private final Extractor previousExtractor;
    private final ParsableByteArray scratchId3Data;
    private final boolean shouldSpliceIn;
    private final TimestampAdjuster timestampAdjuster;
    public final int uid;
    private static final AtomicInteger uidSource;

    static {
        HlsMediaChunk.DUMMY_POSITION_HOLDER = new PositionHolder();
        HlsMediaChunk.uidSource = new AtomicInteger();
    }

    private HlsMediaChunk(HlsExtractorFactory hlsExtractorFactory0, DataSource dataSource0, DataSpec dataSpec0, Format format0, boolean z, DataSource dataSource1, DataSpec dataSpec1, boolean z1, Uri uri0, List list0, int v, Object object0, long v1, long v2, long v3, int v4, boolean z2, boolean z3, TimestampAdjuster timestampAdjuster0, DrmInitData drmInitData0, Extractor extractor0, Id3Decoder id3Decoder0, ParsableByteArray parsableByteArray0, boolean z4) {
        super(dataSource0, dataSpec0, format0, v, object0, v1, v2, v3);
        this.mediaSegmentEncrypted = z;
        this.discontinuitySequenceNumber = v4;
        this.initDataSpec = dataSpec1;
        this.initDataSource = dataSource1;
        this.initDataLoadRequired = dataSpec1 != null;
        this.initSegmentEncrypted = z1;
        this.playlistUrl = uri0;
        this.isMasterTimestampSource = z3;
        this.timestampAdjuster = timestampAdjuster0;
        this.hasGapTag = z2;
        this.extractorFactory = hlsExtractorFactory0;
        this.muxedCaptionFormats = list0;
        this.drmInitData = drmInitData0;
        this.previousExtractor = extractor0;
        this.id3Decoder = id3Decoder0;
        this.scratchId3Data = parsableByteArray0;
        this.shouldSpliceIn = z4;
        this.uid = HlsMediaChunk.uidSource.getAndIncrement();
    }

    private static DataSource buildDataSource(DataSource dataSource0, byte[] arr_b, byte[] arr_b1) {
        if(arr_b != null) {
            Assertions.checkNotNull(arr_b1);
            return new Aes128DataSource(dataSource0, arr_b, arr_b1);
        }
        return dataSource0;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public void cancelLoad() {
        this.loadCanceled = true;
    }

    public static HlsMediaChunk createInstance(HlsExtractorFactory hlsExtractorFactory0, DataSource dataSource0, Format format0, long v, HlsMediaPlaylist hlsMediaPlaylist0, int v1, Uri uri0, List list0, int v2, Object object0, boolean z, TimestampAdjusterProvider timestampAdjusterProvider0, HlsMediaChunk hlsMediaChunk0, byte[] arr_b, byte[] arr_b1) {
        ParsableByteArray parsableByteArray0;
        Id3Decoder id3Decoder0;
        boolean z3;
        Extractor extractor0;
        DataSource dataSource2;
        DataSpec dataSpec1;
        boolean z1;
        Segment hlsMediaPlaylist$Segment0 = (Segment)hlsMediaPlaylist0.segments.get(v1);
        DataSpec dataSpec0 = new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist0.baseUri, hlsMediaPlaylist$Segment0.url), hlsMediaPlaylist$Segment0.byterangeOffset, hlsMediaPlaylist$Segment0.byterangeLength, null);
        DataSource dataSource1 = HlsMediaChunk.buildDataSource(dataSource0, arr_b, (arr_b == null ? HlsMediaChunk.getEncryptionIvArray(((String)Assertions.checkNotNull(hlsMediaPlaylist$Segment0.encryptionIV))) : null));
        Segment hlsMediaPlaylist$Segment1 = hlsMediaPlaylist$Segment0.initializationSegment;
        if(hlsMediaPlaylist$Segment1 == null) {
            dataSource2 = null;
            dataSpec1 = null;
            z1 = false;
        }
        else {
            byte[] arr_b2 = arr_b1 == null ? HlsMediaChunk.getEncryptionIvArray(((String)Assertions.checkNotNull(hlsMediaPlaylist$Segment1.encryptionIV))) : null;
            z1 = arr_b1 != null;
            dataSpec1 = new DataSpec(UriUtil.resolveToUri(hlsMediaPlaylist0.baseUri, hlsMediaPlaylist$Segment1.url), hlsMediaPlaylist$Segment1.byterangeOffset, hlsMediaPlaylist$Segment1.byterangeLength, null);
            dataSource2 = HlsMediaChunk.buildDataSource(dataSource0, arr_b1, arr_b2);
        }
        long v3 = v + hlsMediaPlaylist$Segment0.relativeStartTimeUs;
        long v4 = v3 + hlsMediaPlaylist$Segment0.durationUs;
        int v5 = hlsMediaPlaylist0.discontinuitySequence + hlsMediaPlaylist$Segment0.relativeDiscontinuitySequence;
        if(hlsMediaChunk0 == null) {
            extractor0 = null;
            z3 = false;
            id3Decoder0 = new Id3Decoder();
            parsableByteArray0 = new ParsableByteArray(10);
        }
        else {
            boolean z2 = !uri0.equals(hlsMediaChunk0.playlistUrl) || !hlsMediaChunk0.loadCompleted;
            extractor0 = !hlsMediaChunk0.isExtractorReusable || hlsMediaChunk0.discontinuitySequenceNumber != v5 || z2 ? null : hlsMediaChunk0.extractor;
            z3 = z2;
            id3Decoder0 = hlsMediaChunk0.id3Decoder;
            parsableByteArray0 = hlsMediaChunk0.scratchId3Data;
        }
        TimestampAdjuster timestampAdjuster0 = timestampAdjusterProvider0.getAdjuster(v5);
        return new HlsMediaChunk(hlsExtractorFactory0, dataSource1, dataSpec0, format0, arr_b != null, dataSource2, dataSpec1, z1, uri0, list0, v2, object0, v3, v4, hlsMediaPlaylist0.mediaSequence + ((long)v1), v5, hlsMediaPlaylist$Segment0.hasGapTag, z, timestampAdjuster0, hlsMediaPlaylist$Segment0.drmInitData, extractor0, id3Decoder0, parsableByteArray0, z3);
    }

    @RequiresNonNull({"output"})
    private void feedDataToExtractor(DataSource dataSource0, DataSpec dataSpec0, boolean z) {
        DataSpec dataSpec1;
        int v1;
        if(z) {
            v1 = this.nextLoadPosition == 0 ? 0 : 1;
            dataSpec1 = dataSpec0;
        }
        else {
            dataSpec1 = dataSpec0.subrange(((long)this.nextLoadPosition));
            v1 = 0;
        }
        try {
            DefaultExtractorInput defaultExtractorInput0 = this.prepareExtraction(dataSource0, dataSpec1);
            if(v1 != 0) {
                defaultExtractorInput0.skipFully(this.nextLoadPosition);
            }
            for(int v = 0; v == 0 && !this.loadCanceled; v = this.extractor.read(defaultExtractorInput0, HlsMediaChunk.DUMMY_POSITION_HOLDER)) {
                try {
                }
                catch(Throwable throwable0) {
                    this.nextLoadPosition = (int)(defaultExtractorInput0.getPosition() - dataSpec0.absoluteStreamPosition);
                    throw throwable0;
                }
            }
            this.nextLoadPosition = (int)(defaultExtractorInput0.getPosition() - dataSpec0.absoluteStreamPosition);
        }
        finally {
            Util.closeQuietly(dataSource0);
        }
    }

    private static byte[] getEncryptionIvArray(String s) {
        if(Util.toLowerInvariant(s).startsWith("0x")) {
            s = s.substring(2);
        }
        byte[] arr_b = new BigInteger(s, 16).toByteArray();
        byte[] arr_b1 = new byte[16];
        int v = arr_b.length <= 16 ? 0 : arr_b.length - 16;
        System.arraycopy(arr_b, v, arr_b1, 16 - arr_b.length + v, arr_b.length - v);
        return arr_b1;
    }

    public void init(HlsSampleStreamWrapper hlsSampleStreamWrapper0) {
        this.output = hlsSampleStreamWrapper0;
        hlsSampleStreamWrapper0.init(this.uid, this.shouldSpliceIn);
    }

    @Override  // com.google.android.exoplayer2.source.chunk.MediaChunk
    public boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public void load() {
        Assertions.checkNotNull(this.output);
        if(this.extractor == null) {
            Extractor extractor0 = this.previousExtractor;
            if(extractor0 != null) {
                this.extractor = extractor0;
                this.isExtractorReusable = true;
                this.initDataLoadRequired = false;
            }
        }
        this.maybeLoadInitData();
        if(!this.loadCanceled) {
            if(!this.hasGapTag) {
                this.loadMedia();
            }
            this.loadCompleted = true;
        }
    }

    @RequiresNonNull({"output"})
    private void loadMedia() {
        if(!this.isMasterTimestampSource) {
            this.timestampAdjuster.waitUntilInitialized();
        }
        else if(this.timestampAdjuster.getFirstSampleTimestampUs() == 0x7FFFFFFFFFFFFFFFL) {
            this.timestampAdjuster.setFirstSampleTimestampUs(this.startTimeUs);
        }
        this.feedDataToExtractor(this.dataSource, this.dataSpec, this.mediaSegmentEncrypted);
    }

    @RequiresNonNull({"output"})
    private void maybeLoadInitData() {
        if(!this.initDataLoadRequired) {
            return;
        }
        Assertions.checkNotNull(this.initDataSource);
        Assertions.checkNotNull(this.initDataSpec);
        this.feedDataToExtractor(this.initDataSource, this.initDataSpec, this.initSegmentEncrypted);
        this.nextLoadPosition = 0;
        this.initDataLoadRequired = false;
    }

    private long peekId3PrivTimestamp(ExtractorInput extractorInput0) {
        extractorInput0.resetPeekPosition();
        try {
            extractorInput0.peekFully(this.scratchId3Data.data, 0, 10);
        }
        catch(EOFException unused_ex) {
            return 0x8000000000000001L;
        }
        this.scratchId3Data.reset(10);
        if(this.scratchId3Data.readUnsignedInt24() != 4801587) {
            return 0x8000000000000001L;
        }
        this.scratchId3Data.skipBytes(3);
        int v = this.scratchId3Data.readSynchSafeInt();
        if(v + 10 > this.scratchId3Data.capacity()) {
            byte[] arr_b = this.scratchId3Data.data;
            this.scratchId3Data.reset(v + 10);
            System.arraycopy(arr_b, 0, this.scratchId3Data.data, 0, 10);
        }
        extractorInput0.peekFully(this.scratchId3Data.data, 10, v);
        Metadata metadata0 = this.id3Decoder.decode(this.scratchId3Data.data, v);
        if(metadata0 == null) {
            return 0x8000000000000001L;
        }
        int v1 = metadata0.length();
        for(int v2 = 0; v2 < v1; ++v2) {
            Entry metadata$Entry0 = metadata0.get(v2);
            if(metadata$Entry0 instanceof PrivFrame && "com.apple.streaming.transportStreamTimestamp".equals(((PrivFrame)metadata$Entry0).owner)) {
                System.arraycopy(((PrivFrame)metadata$Entry0).privateData, 0, this.scratchId3Data.data, 0, 8);
                this.scratchId3Data.reset(8);
                return this.scratchId3Data.readLong() & 0x1FFFFFFFFL;
            }
        }
        return 0x8000000000000001L;
    }

    @EnsuresNonNull({"extractor"})
    @RequiresNonNull({"output"})
    private DefaultExtractorInput prepareExtraction(DataSource dataSource0, DataSpec dataSpec0) {
        long v = dataSource0.open(dataSpec0);
        DefaultExtractorInput defaultExtractorInput0 = new DefaultExtractorInput(dataSource0, dataSpec0.absoluteStreamPosition, v);
        if(this.extractor == null) {
            long v1 = this.peekId3PrivTimestamp(defaultExtractorInput0);
            defaultExtractorInput0.resetPeekPosition();
            Map map0 = dataSource0.getResponseHeaders();
            Result hlsExtractorFactory$Result0 = this.extractorFactory.createExtractor(this.previousExtractor, dataSpec0.uri, this.trackFormat, this.muxedCaptionFormats, this.timestampAdjuster, map0, defaultExtractorInput0);
            this.extractor = hlsExtractorFactory$Result0.extractor;
            this.isExtractorReusable = hlsExtractorFactory$Result0.isReusable;
            if(hlsExtractorFactory$Result0.isPackedAudioExtractor) {
                this.output.setSampleOffsetUs((v1 == 0x8000000000000001L ? this.startTimeUs : this.timestampAdjuster.adjustTsTimestamp(v1)));
            }
            else {
                this.output.setSampleOffsetUs(0L);
            }
            this.output.onNewExtractor();
            this.extractor.init(this.output);
        }
        this.output.setDrmInitData(this.drmInitData);
        return defaultExtractorInput0;
    }
}

