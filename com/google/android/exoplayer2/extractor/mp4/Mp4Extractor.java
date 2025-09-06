package com.google.android.exoplayer2.extractor.mp4;

import com.facebook.appevents.b;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.SeekPoints;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;

public final class Mp4Extractor implements Extractor, SeekMap {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track0, TrackSampleTable trackSampleTable0, TrackOutput trackOutput0) {
            this.track = track0;
            this.sampleTable = trackSampleTable0;
            this.trackOutput = trackOutput0;
        }
    }

    private static final int BRAND_QUICKTIME = 0x71742020;
    public static final ExtractorsFactory FACTORY = null;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 0xA00000L;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 0x40000L;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private long[][] accumulatedSampleSizes;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final ArrayDeque containerAtoms;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private int firstVideoTrackIndex;
    private final int flags;
    private boolean isQuickTime;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private final ParsableByteArray scratch;
    private Mp4Track[] tracks;

    static {
        Mp4Extractor.FACTORY = new b(19);
    }

    public Mp4Extractor() {
        this(0);
    }

    public Mp4Extractor(int v) {
        this.flags = v;
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new ArrayDeque();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.scratch = new ParsableByteArray();
        this.sampleTrackIndex = -1;
    }

    public static Extractor[] a() {
        return Mp4Extractor.lambda$static$0();
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Track[] arr_mp4Extractor$Mp4Track) {
        long[][] arr2_v = new long[arr_mp4Extractor$Mp4Track.length][];
        int[] arr_v = new int[arr_mp4Extractor$Mp4Track.length];
        long[] arr_v1 = new long[arr_mp4Extractor$Mp4Track.length];
        boolean[] arr_z = new boolean[arr_mp4Extractor$Mp4Track.length];
        for(int v = 0; v < arr_mp4Extractor$Mp4Track.length; ++v) {
            arr2_v[v] = new long[arr_mp4Extractor$Mp4Track[v].sampleTable.sampleCount];
            arr_v1[v] = arr_mp4Extractor$Mp4Track[v].sampleTable.timestampsUs[0];
        }
        long v1 = 0L;
        int v2 = 0;
        while(v2 < arr_mp4Extractor$Mp4Track.length) {
            long v3 = 0x7FFFFFFFFFFFFFFFL;
            int v4 = -1;
            for(int v5 = 0; v5 < arr_mp4Extractor$Mp4Track.length; ++v5) {
                if(!arr_z[v5]) {
                    long v6 = arr_v1[v5];
                    if(v6 <= v3) {
                        v4 = v5;
                        v3 = v6;
                    }
                }
            }
            int v7 = arr_v[v4];
            long[] arr_v2 = arr2_v[v4];
            arr_v2[v7] = v1;
            TrackSampleTable trackSampleTable0 = arr_mp4Extractor$Mp4Track[v4].sampleTable;
            v1 += (long)trackSampleTable0.sizes[v7];
            int v8 = v7 + 1;
            arr_v[v4] = v8;
            if(v8 < arr_v2.length) {
                arr_v1[v4] = trackSampleTable0.timestampsUs[v8];
            }
            else {
                arr_z[v4] = true;
                ++v2;
            }
        }
        return arr2_v;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public SeekPoints getSeekPoints(long v) {
        long v7;
        long v5;
        Mp4Track[] arr_mp4Extractor$Mp4Track = this.tracks;
        if(arr_mp4Extractor$Mp4Track.length == 0) {
            return new SeekPoints(SeekPoint.START);
        }
        int v1 = this.firstVideoTrackIndex;
        long v2 = -1L;
        if(v1 == -1) {
            v5 = 0x7FFFFFFFFFFFFFFFL;
            v7 = 0x8000000000000001L;
        }
        else {
            TrackSampleTable trackSampleTable0 = arr_mp4Extractor$Mp4Track[v1].sampleTable;
            int v3 = Mp4Extractor.getSynchronizationSampleIndex(trackSampleTable0, v);
            if(v3 == -1) {
                return new SeekPoints(SeekPoint.START);
            }
            long v4 = trackSampleTable0.timestampsUs[v3];
            v5 = trackSampleTable0.offsets[v3];
            if(v4 >= v || v3 >= trackSampleTable0.sampleCount - 1) {
                v7 = 0x8000000000000001L;
            }
            else {
                int v6 = trackSampleTable0.getIndexOfLaterOrEqualSynchronizationSample(v);
                if(v6 == -1 || v6 == v3) {
                    v7 = 0x8000000000000001L;
                }
                else {
                    v7 = trackSampleTable0.timestampsUs[v6];
                    v2 = trackSampleTable0.offsets[v6];
                }
            }
            v = v4;
        }
        for(int v8 = 0; true; ++v8) {
            Mp4Track[] arr_mp4Extractor$Mp4Track1 = this.tracks;
            if(v8 >= arr_mp4Extractor$Mp4Track1.length) {
                break;
            }
            if(v8 != this.firstVideoTrackIndex) {
                TrackSampleTable trackSampleTable1 = arr_mp4Extractor$Mp4Track1[v8].sampleTable;
                long v9 = Mp4Extractor.maybeAdjustSeekOffset(trackSampleTable1, v, v5);
                if(v7 != 0x8000000000000001L) {
                    v2 = Mp4Extractor.maybeAdjustSeekOffset(trackSampleTable1, v7, v2);
                }
                v5 = v9;
            }
        }
        SeekPoint seekPoint0 = new SeekPoint(v, v5);
        return v7 == 0x8000000000000001L ? new SeekPoints(seekPoint0) : new SeekPoints(seekPoint0, new SeekPoint(v7, v2));
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable trackSampleTable0, long v) {
        int v1 = trackSampleTable0.getIndexOfEarlierOrEqualSynchronizationSample(v);
        return v1 == -1 ? trackSampleTable0.getIndexOfLaterOrEqualSynchronizationSample(v) : v1;
    }

    private int getTrackIndexOfNextReadSample(long v) {
        int v1 = -1;
        int v2 = -1;
        long v4 = 0x7FFFFFFFFFFFFFFFL;
        int v5 = 1;
        long v6 = 0x7FFFFFFFFFFFFFFFL;
        int v7 = 1;
        long v8 = 0x7FFFFFFFFFFFFFFFL;
        for(int v3 = 0; true; ++v3) {
            Mp4Track[] arr_mp4Extractor$Mp4Track = this.tracks;
            if(v3 >= arr_mp4Extractor$Mp4Track.length) {
                break;
            }
            Mp4Track mp4Extractor$Mp4Track0 = arr_mp4Extractor$Mp4Track[v3];
            int v9 = mp4Extractor$Mp4Track0.sampleIndex;
            TrackSampleTable trackSampleTable0 = mp4Extractor$Mp4Track0.sampleTable;
            if(v9 != trackSampleTable0.sampleCount) {
                long v10 = trackSampleTable0.offsets[v9];
                long v11 = this.accumulatedSampleSizes[v3][v9];
                long v12 = v10 - v;
                int v13 = v12 < 0L || v12 >= 0x40000L ? 1 : 0;
                if(v13 == 0 && v7 != 0 || v13 == v7 && v12 < v8) {
                    v7 = v13;
                    v6 = v11;
                    v2 = v3;
                    v8 = v12;
                }
                if(v11 < v4) {
                    v5 = v13;
                    v4 = v11;
                    v1 = v3;
                }
            }
        }
        return v4 == 0x7FFFFFFFFFFFFFFFL || v5 == 0 || v6 < v4 + 0xA00000L ? v2 : v1;
    }

    private ArrayList getTrackSampleTables(ContainerAtom atom$ContainerAtom0, GaplessInfoHolder gaplessInfoHolder0, boolean z) {
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < atom$ContainerAtom0.containerChildren.size(); ++v) {
            ContainerAtom atom$ContainerAtom1 = (ContainerAtom)atom$ContainerAtom0.containerChildren.get(v);
            if(atom$ContainerAtom1.type == 1953653099) {
                Track track0 = AtomParsers.parseTrak(atom$ContainerAtom1, atom$ContainerAtom0.getLeafAtomOfType(0x6D766864), 0x8000000000000001L, null, z, this.isQuickTime);
                if(track0 != null) {
                    TrackSampleTable trackSampleTable0 = AtomParsers.parseStbl(track0, atom$ContainerAtom1.getContainerAtomOfType(0x6D646961).getContainerAtomOfType(1835626086).getContainerAtomOfType(1937007212), gaplessInfoHolder0);
                    if(trackSampleTable0.sampleCount != 0) {
                        arrayList0.add(trackSampleTable0);
                    }
                }
            }
        }
        return arrayList0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
    }

    @Override  // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new Mp4Extractor()};
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable trackSampleTable0, long v, long v1) {
        int v2 = Mp4Extractor.getSynchronizationSampleIndex(trackSampleTable0, v);
        return v2 == -1 ? v1 : Math.min(trackSampleTable0.offsets[v2], v1);
    }

    private void maybeSkipRemainingMetaAtomHeaderBytes(ExtractorInput extractorInput0) {
        this.scratch.reset(8);
        extractorInput0.peekFully(this.scratch.data, 0, 8);
        this.scratch.skipBytes(4);
        if(this.scratch.readInt() == 0x68646C72) {
            extractorInput0.resetPeekPosition();
            return;
        }
        extractorInput0.skipFully(4);
    }

    private void processAtomEnded(long v) {
        while(!this.containerAtoms.isEmpty() && ((ContainerAtom)this.containerAtoms.peek()).endPosition == v) {
            ContainerAtom atom$ContainerAtom0 = (ContainerAtom)this.containerAtoms.pop();
            if(atom$ContainerAtom0.type == 0x6D6F6F76) {
                this.processMoovAtom(atom$ContainerAtom0);
                this.containerAtoms.clear();
                this.parserState = 2;
            }
            else if(!this.containerAtoms.isEmpty()) {
                ((ContainerAtom)this.containerAtoms.peek()).add(atom$ContainerAtom0);
            }
        }
        if(this.parserState != 2) {
            this.enterReadingAtomHeaderState();
        }
    }

    private static boolean processFtypAtom(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.setPosition(8);
        if(parsableByteArray0.readInt() == 0x71742020) {
            return true;
        }
        parsableByteArray0.skipBytes(4);
        while(parsableByteArray0.bytesLeft() > 0) {
            if(parsableByteArray0.readInt() == 0x71742020) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    private void processMoovAtom(ContainerAtom atom$ContainerAtom0) {
        Metadata metadata1;
        ArrayList arrayList0 = new ArrayList();
        GaplessInfoHolder gaplessInfoHolder0 = new GaplessInfoHolder();
        LeafAtom atom$LeafAtom0 = atom$ContainerAtom0.getLeafAtomOfType(0x75647461);
        Metadata metadata0 = null;
        if(atom$LeafAtom0 == null) {
            metadata1 = null;
        }
        else {
            metadata1 = AtomParsers.parseUdta(atom$LeafAtom0, this.isQuickTime);
            if(metadata1 != null) {
                gaplessInfoHolder0.setFromMetadata(metadata1);
            }
        }
        ContainerAtom atom$ContainerAtom1 = atom$ContainerAtom0.getContainerAtomOfType(0x6D657461);
        if(atom$ContainerAtom1 != null) {
            metadata0 = AtomParsers.parseMdtaFromMeta(atom$ContainerAtom1);
        }
        ArrayList arrayList1 = this.getTrackSampleTables(atom$ContainerAtom0, gaplessInfoHolder0, (this.flags & 1) != 0);
        int v = arrayList1.size();
        int v2 = -1;
        long v3 = 0x8000000000000001L;
        for(int v1 = 0; v1 < v; ++v1) {
            TrackSampleTable trackSampleTable0 = (TrackSampleTable)arrayList1.get(v1);
            Track track0 = trackSampleTable0.track;
            long v4 = track0.durationUs == 0x8000000000000001L ? trackSampleTable0.durationUs : track0.durationUs;
            v3 = Math.max(v3, v4);
            Mp4Track mp4Extractor$Mp4Track0 = new Mp4Track(track0, trackSampleTable0, this.extractorOutput.track(v1, track0.type));
            Format format0 = track0.format.copyWithMaxInputSize(trackSampleTable0.maximumSize + 30);
            if(track0.type == 2 && v4 > 0L) {
                int v5 = trackSampleTable0.sampleCount;
                if(v5 > 1) {
                    format0 = format0.copyWithFrameRate(((float)v5) / (((float)v4) / 1000000.0f));
                }
            }
            Format format1 = MetadataUtil.getFormatWithMetadata(track0.type, format0, metadata1, metadata0, gaplessInfoHolder0);
            mp4Extractor$Mp4Track0.trackOutput.format(format1);
            if(track0.type == 2 && v2 == -1) {
                v2 = arrayList0.size();
            }
            arrayList0.add(mp4Extractor$Mp4Track0);
        }
        this.firstVideoTrackIndex = v2;
        this.durationUs = v3;
        Mp4Track[] arr_mp4Extractor$Mp4Track = (Mp4Track[])arrayList0.toArray(new Mp4Track[0]);
        this.tracks = arr_mp4Extractor$Mp4Track;
        this.accumulatedSampleSizes = Mp4Extractor.calculateAccumulatedSampleSizes(arr_mp4Extractor$Mp4Track);
        this.extractorOutput.endTracks();
        this.extractorOutput.seekMap(this);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
    alab1:
        while(true) {
            switch(this.parserState) {
                case 0: {
                    if(this.readAtomHeader(extractorInput0)) {
                        break;
                    }
                    return -1;
                }
                case 1: {
                    if(!this.readAtomPayload(extractorInput0, positionHolder0)) {
                        break;
                    }
                    break alab1;
                }
                case 2: {
                    return this.readSample(extractorInput0, positionHolder0);
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        return 1;
    }

    private boolean readAtomHeader(ExtractorInput extractorInput0) {
        if(this.atomHeaderBytesRead == 0) {
            if(!extractorInput0.readFully(this.atomHeader.data, 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long v = this.atomSize;
        if(v == 1L) {
            extractorInput0.readFully(this.atomHeader.data, 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        }
        else if(v == 0L) {
            long v1 = extractorInput0.getLength();
            if(v1 == -1L && !this.containerAtoms.isEmpty()) {
                v1 = ((ContainerAtom)this.containerAtoms.peek()).endPosition;
            }
            if(v1 != -1L) {
                this.atomSize = v1 - extractorInput0.getPosition() + ((long)this.atomHeaderBytesRead);
            }
        }
        if(this.atomSize < ((long)this.atomHeaderBytesRead)) {
            throw new ParserException("Atom size less than header length (unsupported).");
        }
        if(Mp4Extractor.shouldParseContainerAtom(this.atomType)) {
            long v2 = extractorInput0.getPosition() + this.atomSize - ((long)this.atomHeaderBytesRead);
            if(this.atomSize != ((long)this.atomHeaderBytesRead) && this.atomType == 0x6D657461) {
                this.maybeSkipRemainingMetaAtomHeaderBytes(extractorInput0);
            }
            ContainerAtom atom$ContainerAtom0 = new ContainerAtom(this.atomType, v2);
            this.containerAtoms.push(atom$ContainerAtom0);
            if(this.atomSize == ((long)this.atomHeaderBytesRead)) {
                this.processAtomEnded(v2);
                return true;
            }
            this.enterReadingAtomHeaderState();
            return true;
        }
        if(Mp4Extractor.shouldParseLeafAtom(this.atomType)) {
            Assertions.checkState(this.atomHeaderBytesRead == 8);
            Assertions.checkState(this.atomSize <= 0x7FFFFFFFL);
            ParsableByteArray parsableByteArray0 = new ParsableByteArray(((int)this.atomSize));
            this.atomData = parsableByteArray0;
            System.arraycopy(this.atomHeader.data, 0, parsableByteArray0.data, 0, 8);
            this.parserState = 1;
            return true;
        }
        this.atomData = null;
        this.parserState = 1;
        return true;
    }

    private boolean readAtomPayload(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        boolean z;
        long v = this.atomSize - ((long)this.atomHeaderBytesRead);
        long v1 = extractorInput0.getPosition();
        ParsableByteArray parsableByteArray0 = this.atomData;
        if(parsableByteArray0 != null) {
            extractorInput0.readFully(parsableByteArray0.data, this.atomHeaderBytesRead, ((int)v));
            if(this.atomType == 0x66747970) {
                this.isQuickTime = Mp4Extractor.processFtypAtom(this.atomData);
            }
            else if(!this.containerAtoms.isEmpty()) {
                ((ContainerAtom)this.containerAtoms.peek()).add(new LeafAtom(this.atomType, this.atomData));
            }
            z = false;
        }
        else if(v < 0x40000L) {
            extractorInput0.skipFully(((int)v));
            z = false;
        }
        else {
            positionHolder0.position = extractorInput0.getPosition() + v;
            z = true;
        }
        this.processAtomEnded(v1 + v);
        return z && this.parserState != 2;
    }

    private int readSample(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        long v = extractorInput0.getPosition();
        if(this.sampleTrackIndex == -1) {
            int v1 = this.getTrackIndexOfNextReadSample(v);
            this.sampleTrackIndex = v1;
            if(v1 == -1) {
                return -1;
            }
        }
        Mp4Track mp4Extractor$Mp4Track0 = this.tracks[this.sampleTrackIndex];
        TrackOutput trackOutput0 = mp4Extractor$Mp4Track0.trackOutput;
        int v2 = mp4Extractor$Mp4Track0.sampleIndex;
        long v3 = mp4Extractor$Mp4Track0.sampleTable.offsets[v2];
        int v4 = mp4Extractor$Mp4Track0.sampleTable.sizes[v2];
        long v5 = v3 - v + ((long)this.sampleBytesRead);
        if(Long.compare(v5, 0L) < 0 || v5 >= 0x40000L) {
            positionHolder0.position = v3;
            return 1;
        }
        if(mp4Extractor$Mp4Track0.track.sampleTransformation == 1) {
            v5 += 8L;
            v4 -= 8;
        }
        extractorInput0.skipFully(((int)v5));
        Track track0 = mp4Extractor$Mp4Track0.track;
        int v6 = track0.nalUnitLengthFieldLength;
        if(v6 == 0) {
            if("audio/ac4".equals(track0.format.sampleMimeType)) {
                if(this.sampleBytesWritten == 0) {
                    Ac4Util.getAc4SampleHeader(v4, this.scratch);
                    trackOutput0.sampleData(this.scratch, 7);
                    this.sampleBytesWritten += 7;
                }
                v4 += 7;
            }
            int v10;
            while((v10 = this.sampleBytesWritten) < v4) {
                int v11 = trackOutput0.sampleData(extractorInput0, v4 - v10, false);
                this.sampleBytesRead += v11;
                this.sampleBytesWritten += v11;
                this.sampleCurrentNalBytesRemaining -= v11;
            }
        }
        else {
            byte[] arr_b = this.nalLength.data;
            arr_b[0] = 0;
            arr_b[1] = 0;
            arr_b[2] = 0;
            while(this.sampleBytesWritten < v4) {
                int v7 = this.sampleCurrentNalBytesRemaining;
                if(v7 == 0) {
                    extractorInput0.readFully(arr_b, 4 - v6, v6);
                    this.sampleBytesRead += v6;
                    this.nalLength.setPosition(0);
                    int v8 = this.nalLength.readInt();
                    if(v8 < 0) {
                        throw new ParserException("Invalid NAL length");
                    }
                    this.sampleCurrentNalBytesRemaining = v8;
                    this.nalStartCode.setPosition(0);
                    trackOutput0.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                    v4 += 4 - v6;
                }
                else {
                    int v9 = trackOutput0.sampleData(extractorInput0, v7, false);
                    this.sampleBytesRead += v9;
                    this.sampleBytesWritten += v9;
                    this.sampleCurrentNalBytesRemaining -= v9;
                }
            }
        }
        trackOutput0.sampleMetadata(mp4Extractor$Mp4Track0.sampleTable.timestampsUs[v2], mp4Extractor$Mp4Track0.sampleTable.flags[v2], v4, 0, null);
        ++mp4Extractor$Mp4Track0.sampleIndex;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        if(v == 0L) {
            this.enterReadingAtomHeaderState();
            return;
        }
        if(this.tracks != null) {
            this.updateSampleIndices(v1);
        }
    }

    private static boolean shouldParseContainerAtom(int v) {
        switch(v) {
            case 1701082227: 
            case 0x6D646961: 
            case 0x6D657461: 
            case 1835626086: 
            case 0x6D6F6F76: 
            case 1937007212: 
            case 1953653099: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    private static boolean shouldParseLeafAtom(int v) {
        switch(v) {
            case 0x636F3634: 
            case 0x63747473: 
            case 1701606260: 
            case 0x66747970: 
            case 0x68646C72: 
            case 0x696C7374: 
            case 1801812339: 
            case 0x6D646864: 
            case 0x6D766864: 
            case 1937007471: 
            case 1937011555: 
            case 1937011556: 
            case 1937011571: 
            case 1937011578: 
            case 1937011827: 
            case 1937013298: 
            case 0x746B6864: 
            case 0x75647461: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        return Sniffer.sniffUnfragmented(extractorInput0);
    }

    private void updateSampleIndices(long v) {
        Mp4Track[] arr_mp4Extractor$Mp4Track = this.tracks;
        for(int v1 = 0; v1 < arr_mp4Extractor$Mp4Track.length; ++v1) {
            Mp4Track mp4Extractor$Mp4Track0 = arr_mp4Extractor$Mp4Track[v1];
            TrackSampleTable trackSampleTable0 = mp4Extractor$Mp4Track0.sampleTable;
            int v2 = trackSampleTable0.getIndexOfEarlierOrEqualSynchronizationSample(v);
            if(v2 == -1) {
                v2 = trackSampleTable0.getIndexOfLaterOrEqualSynchronizationSample(v);
            }
            mp4Extractor$Mp4Track0.sampleIndex = v2;
        }
    }
}

