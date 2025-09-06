package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.os.SystemClock;
import b3.Z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunkIterator;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.DataChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist.Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class HlsChunkSource {
    static final class EncryptionKeyChunk extends DataChunk {
        private byte[] result;

        public EncryptionKeyChunk(DataSource dataSource0, DataSpec dataSpec0, Format format0, int v, Object object0, byte[] arr_b) {
            super(dataSource0, dataSpec0, 3, format0, v, object0, arr_b);
        }

        @Override  // com.google.android.exoplayer2.source.chunk.DataChunk
        public void consume(byte[] arr_b, int v) {
            this.result = Arrays.copyOf(arr_b, v);
        }

        public byte[] getResult() {
            return this.result;
        }
    }

    public static final class HlsChunkHolder {
        public Chunk chunk;
        public boolean endOfStream;
        public Uri playlistUrl;

        public HlsChunkHolder() {
            this.clear();
        }

        public void clear() {
            this.chunk = null;
            this.endOfStream = false;
            this.playlistUrl = null;
        }
    }

    static final class HlsMediaPlaylistSegmentIterator extends BaseMediaChunkIterator {
        private final HlsMediaPlaylist playlist;
        private final long startOfPlaylistInPeriodUs;

        public HlsMediaPlaylistSegmentIterator(HlsMediaPlaylist hlsMediaPlaylist0, long v, int v1) {
            super(((long)v1), ((long)(hlsMediaPlaylist0.segments.size() - 1)));
            this.playlist = hlsMediaPlaylist0;
            this.startOfPlaylistInPeriodUs = v;
        }

        @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkEndTimeUs() {
            this.checkInBounds();
            Segment hlsMediaPlaylist$Segment0 = (Segment)this.playlist.segments.get(((int)this.getCurrentIndex()));
            return this.startOfPlaylistInPeriodUs + hlsMediaPlaylist$Segment0.relativeStartTimeUs + hlsMediaPlaylist$Segment0.durationUs;
        }

        @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public long getChunkStartTimeUs() {
            this.checkInBounds();
            Segment hlsMediaPlaylist$Segment0 = (Segment)this.playlist.segments.get(((int)this.getCurrentIndex()));
            return this.startOfPlaylistInPeriodUs + hlsMediaPlaylist$Segment0.relativeStartTimeUs;
        }

        @Override  // com.google.android.exoplayer2.source.chunk.MediaChunkIterator
        public DataSpec getDataSpec() {
            this.checkInBounds();
            Segment hlsMediaPlaylist$Segment0 = (Segment)this.playlist.segments.get(((int)this.getCurrentIndex()));
            return new DataSpec(UriUtil.resolveToUri(this.playlist.baseUri, hlsMediaPlaylist$Segment0.url), hlsMediaPlaylist$Segment0.byterangeOffset, hlsMediaPlaylist$Segment0.byterangeLength, null);
        }
    }

    static final class InitializationTrackSelection extends BaseTrackSelection {
        private int selectedIndex;

        public InitializationTrackSelection(TrackGroup trackGroup0, int[] arr_v) {
            super(trackGroup0, arr_v);
            this.selectedIndex = this.indexOf(trackGroup0.getFormat(0));
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectedIndex() {
            return this.selectedIndex;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public Object getSelectionData() {
            return null;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public int getSelectionReason() {
            return 0;
        }

        @Override  // com.google.android.exoplayer2.trackselection.TrackSelection
        public void updateSelectedTrack(long v, long v1, long v2, List list0, MediaChunkIterator[] arr_mediaChunkIterator) {
            long v3 = SystemClock.elapsedRealtime();
            if(!this.isBlacklisted(this.selectedIndex, v3)) {
                return;
            }
            for(int v4 = this.length - 1; v4 >= 0; --v4) {
                if(!this.isBlacklisted(v4, v3)) {
                    this.selectedIndex = v4;
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    private static final int KEY_CACHE_SIZE = 4;
    private final DataSource encryptionDataSource;
    private Uri expectedPlaylistUrl;
    private final HlsExtractorFactory extractorFactory;
    private IOException fatalError;
    private boolean independentSegments;
    private boolean isTimestampMaster;
    private final FullSegmentEncryptionKeyCache keyCache;
    private long liveEdgeInPeriodTimeUs;
    private final DataSource mediaDataSource;
    private final List muxedCaptionFormats;
    private final Format[] playlistFormats;
    private final HlsPlaylistTracker playlistTracker;
    private final Uri[] playlistUrls;
    private byte[] scratchSpace;
    private boolean seenExpectedPlaylistError;
    private final TimestampAdjusterProvider timestampAdjusterProvider;
    private final TrackGroup trackGroup;
    private TrackSelection trackSelection;

    public HlsChunkSource(HlsExtractorFactory hlsExtractorFactory0, HlsPlaylistTracker hlsPlaylistTracker0, Uri[] arr_uri, Format[] arr_format, HlsDataSourceFactory hlsDataSourceFactory0, TransferListener transferListener0, TimestampAdjusterProvider timestampAdjusterProvider0, List list0) {
        this.extractorFactory = hlsExtractorFactory0;
        this.playlistTracker = hlsPlaylistTracker0;
        this.playlistUrls = arr_uri;
        this.playlistFormats = arr_format;
        this.timestampAdjusterProvider = timestampAdjusterProvider0;
        this.muxedCaptionFormats = list0;
        this.keyCache = new FullSegmentEncryptionKeyCache(4);
        this.scratchSpace = Util.EMPTY_BYTE_ARRAY;
        this.liveEdgeInPeriodTimeUs = 0x8000000000000001L;
        DataSource dataSource0 = hlsDataSourceFactory0.createDataSource(1);
        this.mediaDataSource = dataSource0;
        if(transferListener0 != null) {
            dataSource0.addTransferListener(transferListener0);
        }
        this.encryptionDataSource = hlsDataSourceFactory0.createDataSource(3);
        this.trackGroup = new TrackGroup(arr_format);
        int[] arr_v = new int[arr_uri.length];
        for(int v = 0; v < arr_uri.length; ++v) {
            arr_v[v] = v;
        }
        this.trackSelection = new InitializationTrackSelection(this.trackGroup, arr_v);
    }

    public MediaChunkIterator[] createMediaChunkIterators(HlsMediaChunk hlsMediaChunk0, long v) {
        int v1 = hlsMediaChunk0 == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk0.trackFormat);
        int v2 = this.trackSelection.length();
        MediaChunkIterator[] arr_mediaChunkIterator = new MediaChunkIterator[v2];
        for(int v3 = 0; v3 < v2; ++v3) {
            int v4 = this.trackSelection.getIndexInTrackGroup(v3);
            Uri uri0 = this.playlistUrls[v4];
            if(this.playlistTracker.isSnapshotValid(uri0)) {
                HlsMediaPlaylist hlsMediaPlaylist0 = this.playlistTracker.getPlaylistSnapshot(uri0, false);
                Assertions.checkNotNull(hlsMediaPlaylist0);
                long v5 = this.playlistTracker.getInitialStartTimeUs();
                long v6 = hlsMediaPlaylist0.startTimeUs - v5;
                long v7 = this.getChunkMediaSequence(hlsMediaChunk0, v4 != v1, hlsMediaPlaylist0, v6, v);
                long v8 = hlsMediaPlaylist0.mediaSequence;
                arr_mediaChunkIterator[v3] = v7 < v8 ? MediaChunkIterator.EMPTY : new HlsMediaPlaylistSegmentIterator(hlsMediaPlaylist0, v6, ((int)(v7 - v8)));
            }
            else {
                arr_mediaChunkIterator[v3] = MediaChunkIterator.EMPTY;
            }
        }
        return arr_mediaChunkIterator;
    }

    private long getChunkMediaSequence(HlsMediaChunk hlsMediaChunk0, boolean z, HlsMediaPlaylist hlsMediaPlaylist0, long v, long v1) {
        if(hlsMediaChunk0 != null && !z) {
            return hlsMediaChunk0.getNextChunkIndex();
        }
        long v2 = hlsMediaPlaylist0.durationUs + v;
        if(hlsMediaChunk0 != null && !this.independentSegments) {
            v1 = hlsMediaChunk0.startTimeUs;
        }
        if(!hlsMediaPlaylist0.hasEndTag && v1 >= v2) {
            return hlsMediaPlaylist0.mediaSequence + ((long)hlsMediaPlaylist0.segments.size());
        }
        Long long0 = (long)(v1 - v);
        return !this.playlistTracker.isLive() || hlsMediaChunk0 == null ? ((long)Util.binarySearchFloor(hlsMediaPlaylist0.segments, long0, true, true)) + hlsMediaPlaylist0.mediaSequence : ((long)Util.binarySearchFloor(hlsMediaPlaylist0.segments, long0, true, false)) + hlsMediaPlaylist0.mediaSequence;
    }

    private static Uri getFullEncryptionKeyUri(HlsMediaPlaylist hlsMediaPlaylist0, Segment hlsMediaPlaylist$Segment0) {
        if(hlsMediaPlaylist$Segment0 != null) {
            return hlsMediaPlaylist$Segment0.fullSegmentEncryptionKeyUri == null ? null : UriUtil.resolveToUri(hlsMediaPlaylist0.baseUri, hlsMediaPlaylist$Segment0.fullSegmentEncryptionKeyUri);
        }
        return null;
    }

    public void getNextChunk(long v, long v1, List list0, boolean z, HlsChunkHolder hlsChunkSource$HlsChunkHolder0) {
        int v11;
        HlsMediaPlaylist hlsMediaPlaylist1;
        HlsMediaChunk hlsMediaChunk0 = list0.isEmpty() ? null : ((HlsMediaChunk)Z.h(1, list0));
        int v2 = hlsMediaChunk0 == null ? -1 : this.trackGroup.indexOf(hlsMediaChunk0.trackFormat);
        long v3 = v1 - v;
        long v4 = this.resolveTimeToLiveEdgeUs(v);
        if(hlsMediaChunk0 != null && !this.independentSegments) {
            long v5 = hlsMediaChunk0.getDurationUs();
            v3 = Math.max(0L, v3 - v5);
            if(v4 != 0x8000000000000001L) {
                v4 = Math.max(0L, v4 - v5);
            }
        }
        MediaChunkIterator[] arr_mediaChunkIterator = this.createMediaChunkIterators(hlsMediaChunk0, v1);
        this.trackSelection.updateSelectedTrack(v, v3, v4, list0, arr_mediaChunkIterator);
        int v6 = this.trackSelection.getSelectedIndexInTrackGroup();
        boolean z1 = v2 != v6;
        Uri uri0 = this.playlistUrls[v6];
        if(!this.playlistTracker.isSnapshotValid(uri0)) {
            hlsChunkSource$HlsChunkHolder0.playlistUrl = uri0;
            this.seenExpectedPlaylistError &= uri0.equals(this.expectedPlaylistUrl);
            this.expectedPlaylistUrl = uri0;
            return;
        }
        HlsMediaPlaylist hlsMediaPlaylist0 = this.playlistTracker.getPlaylistSnapshot(uri0, true);
        Assertions.checkNotNull(hlsMediaPlaylist0);
        this.independentSegments = hlsMediaPlaylist0.hasIndependentSegments;
        this.updateLiveEdgeTimeUs(hlsMediaPlaylist0);
        long v7 = this.playlistTracker.getInitialStartTimeUs();
        long v8 = hlsMediaPlaylist0.startTimeUs - v7;
        long v9 = this.getChunkMediaSequence(hlsMediaChunk0, z1, hlsMediaPlaylist0, v8, v1);
        if(v9 >= hlsMediaPlaylist0.mediaSequence || hlsMediaChunk0 == null || !z1) {
            hlsMediaPlaylist1 = hlsMediaPlaylist0;
            v11 = v6;
        }
        else {
            uri0 = this.playlistUrls[v2];
            hlsMediaPlaylist1 = this.playlistTracker.getPlaylistSnapshot(uri0, true);
            Assertions.checkNotNull(hlsMediaPlaylist1);
            long v10 = this.playlistTracker.getInitialStartTimeUs();
            v8 = hlsMediaPlaylist1.startTimeUs - v10;
            v9 = hlsMediaChunk0.getNextChunkIndex();
            v11 = v2;
        }
        long v12 = hlsMediaPlaylist1.mediaSequence;
        if(v9 < v12) {
            this.fatalError = new BehindLiveWindowException();
            return;
        }
        int v13 = (int)(v9 - v12);
        int v14 = hlsMediaPlaylist1.segments.size();
        if(v13 >= v14) {
            if(hlsMediaPlaylist1.hasEndTag) {
                if(z || v14 == 0) {
                    hlsChunkSource$HlsChunkHolder0.endOfStream = true;
                    return;
                }
                v13 = v14 - 1;
                goto label_54;
            }
            hlsChunkSource$HlsChunkHolder0.playlistUrl = uri0;
            this.seenExpectedPlaylistError &= uri0.equals(this.expectedPlaylistUrl);
            this.expectedPlaylistUrl = uri0;
            return;
        }
    label_54:
        this.seenExpectedPlaylistError = false;
        this.expectedPlaylistUrl = null;
        Segment hlsMediaPlaylist$Segment0 = (Segment)hlsMediaPlaylist1.segments.get(v13);
        Uri uri1 = HlsChunkSource.getFullEncryptionKeyUri(hlsMediaPlaylist1, hlsMediaPlaylist$Segment0.initializationSegment);
        Chunk chunk0 = this.maybeCreateEncryptionChunkFor(uri1, v11);
        hlsChunkSource$HlsChunkHolder0.chunk = chunk0;
        if(chunk0 == null) {
            Uri uri2 = HlsChunkSource.getFullEncryptionKeyUri(hlsMediaPlaylist1, hlsMediaPlaylist$Segment0);
            Chunk chunk1 = this.maybeCreateEncryptionChunkFor(uri2, v11);
            hlsChunkSource$HlsChunkHolder0.chunk = chunk1;
            if(chunk1 == null) {
                Format format0 = this.playlistFormats[v11];
                int v15 = this.trackSelection.getSelectionReason();
                Object object0 = this.trackSelection.getSelectionData();
                boolean z2 = this.isTimestampMaster;
                byte[] arr_b = this.keyCache.get(uri2);
                byte[] arr_b1 = this.keyCache.get(uri1);
                hlsChunkSource$HlsChunkHolder0.chunk = HlsMediaChunk.createInstance(this.extractorFactory, this.mediaDataSource, format0, v8, hlsMediaPlaylist1, v13, uri0, this.muxedCaptionFormats, v15, object0, z2, this.timestampAdjusterProvider, hlsMediaChunk0, arr_b, arr_b1);
            }
        }
    }

    public TrackGroup getTrackGroup() {
        return this.trackGroup;
    }

    public TrackSelection getTrackSelection() {
        return this.trackSelection;
    }

    public boolean maybeBlacklistTrack(Chunk chunk0, long v) {
        return this.trackSelection.blacklist(this.trackSelection.indexOf(this.trackGroup.indexOf(chunk0.trackFormat)), v);
    }

    private Chunk maybeCreateEncryptionChunkFor(Uri uri0, int v) {
        if(uri0 == null) {
            return null;
        }
        byte[] arr_b = this.keyCache.remove(uri0);
        if(arr_b != null) {
            this.keyCache.put(uri0, arr_b);
            return null;
        }
        DataSpec dataSpec0 = new DataSpec(uri0, 0L, -1L, null, 1);
        Format format0 = this.playlistFormats[v];
        int v1 = this.trackSelection.getSelectionReason();
        Object object0 = this.trackSelection.getSelectionData();
        return new EncryptionKeyChunk(this.encryptionDataSource, dataSpec0, format0, v1, object0, this.scratchSpace);
    }

    public void maybeThrowError() {
        IOException iOException0 = this.fatalError;
        if(iOException0 != null) {
            throw iOException0;
        }
        Uri uri0 = this.expectedPlaylistUrl;
        if(uri0 != null && this.seenExpectedPlaylistError) {
            this.playlistTracker.maybeThrowPlaylistRefreshError(uri0);
        }
    }

    public void onChunkLoadCompleted(Chunk chunk0) {
        if(chunk0 instanceof EncryptionKeyChunk) {
            this.scratchSpace = ((EncryptionKeyChunk)chunk0).getDataHolder();
            byte[] arr_b = (byte[])Assertions.checkNotNull(((EncryptionKeyChunk)chunk0).getResult());
            this.keyCache.put(((EncryptionKeyChunk)chunk0).dataSpec.uri, arr_b);
        }
    }

    public boolean onPlaylistError(Uri uri0, long v) {
        int v1;
        for(v1 = 0; true; ++v1) {
            Uri[] arr_uri = this.playlistUrls;
            if(v1 >= arr_uri.length) {
                v1 = -1;
                break;
            }
            if(arr_uri[v1].equals(uri0)) {
                break;
            }
        }
        if(v1 == -1) {
            return true;
        }
        int v2 = this.trackSelection.indexOf(v1);
        if(v2 == -1) {
            return true;
        }
        boolean z = this.seenExpectedPlaylistError;
        this.seenExpectedPlaylistError = uri0.equals(this.expectedPlaylistUrl) | z;
        return v == 0x8000000000000001L || this.trackSelection.blacklist(v2, v);
    }

    public void reset() {
        this.fatalError = null;
    }

    private long resolveTimeToLiveEdgeUs(long v) {
        return this.liveEdgeInPeriodTimeUs == 0x8000000000000001L ? 0x8000000000000001L : this.liveEdgeInPeriodTimeUs - v;
    }

    public void setIsTimestampMaster(boolean z) {
        this.isTimestampMaster = z;
    }

    public void setTrackSelection(TrackSelection trackSelection0) {
        this.trackSelection = trackSelection0;
    }

    private void updateLiveEdgeTimeUs(HlsMediaPlaylist hlsMediaPlaylist0) {
        this.liveEdgeInPeriodTimeUs = hlsMediaPlaylist0.hasEndTag ? 0x8000000000000001L : hlsMediaPlaylist0.getEndTimeUs() - this.playlistTracker.getInitialStartTimeUs();
    }
}

