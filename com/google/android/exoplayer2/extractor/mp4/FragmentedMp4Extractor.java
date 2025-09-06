package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import b3.Z;
import com.facebook.appevents.b;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.text.cea.CeaUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class FragmentedMp4Extractor implements Extractor {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    static final class MetadataSampleInfo {
        public final long presentationTimeDeltaUs;
        public final int size;

        public MetadataSampleInfo(long v, int v1) {
            this.presentationTimeDeltaUs = v;
            this.size = v1;
        }
    }

    static final class TrackBundle {
        private static final int SINGLE_SUBSAMPLE_ENCRYPTION_DATA_LENGTH = 8;
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        private final ParsableByteArray defaultInitializationVector;
        public DefaultSampleValues defaultSampleValues;
        private final ParsableByteArray encryptionSignalByte;
        public int firstSampleToOutputIndex;
        public final TrackFragment fragment;
        public final TrackOutput output;
        public final ParsableByteArray scratch;
        public Track track;

        public TrackBundle(TrackOutput trackOutput0) {
            this.output = trackOutput0;
            this.fragment = new TrackFragment();
            this.scratch = new ParsableByteArray();
            this.encryptionSignalByte = new ParsableByteArray(1);
            this.defaultInitializationVector = new ParsableByteArray();
        }

        public static TrackEncryptionBox access$100(TrackBundle fragmentedMp4Extractor$TrackBundle0) {
            return fragmentedMp4Extractor$TrackBundle0.getEncryptionBoxIfEncrypted();
        }

        private TrackEncryptionBox getEncryptionBoxIfEncrypted() {
            TrackEncryptionBox trackEncryptionBox0 = this.fragment.trackEncryptionBox == null ? this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex) : this.fragment.trackEncryptionBox;
            return trackEncryptionBox0 == null || !trackEncryptionBox0.isEncrypted ? null : trackEncryptionBox0;
        }

        public void init(Track track0, DefaultSampleValues defaultSampleValues0) {
            this.track = (Track)Assertions.checkNotNull(track0);
            this.defaultSampleValues = (DefaultSampleValues)Assertions.checkNotNull(defaultSampleValues0);
            this.output.format(track0.format);
            this.reset();
        }

        public boolean next() {
            ++this.currentSampleIndex;
            int v = this.currentSampleInTrackRun + 1;
            this.currentSampleInTrackRun = v;
            int v1 = this.currentTrackRunIndex;
            if(v == this.fragment.trunLength[v1]) {
                this.currentTrackRunIndex = v1 + 1;
                this.currentSampleInTrackRun = 0;
                return false;
            }
            return true;
        }

        public int outputSampleEncryptionData(int v, int v1) {
            ParsableByteArray parsableByteArray0;
            TrackEncryptionBox trackEncryptionBox0 = this.getEncryptionBoxIfEncrypted();
            if(trackEncryptionBox0 == null) {
                return 0;
            }
            int v2 = trackEncryptionBox0.perSampleIvSize;
            if(v2 == 0) {
                this.defaultInitializationVector.reset(trackEncryptionBox0.defaultInitializationVector, trackEncryptionBox0.defaultInitializationVector.length);
                v2 = trackEncryptionBox0.defaultInitializationVector.length;
                parsableByteArray0 = this.defaultInitializationVector;
            }
            else {
                parsableByteArray0 = this.fragment.sampleEncryptionData;
            }
            boolean z = this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex);
            boolean z1 = z || v1 != 0;
            this.encryptionSignalByte.data[0] = (byte)((z1 ? 0x80 : 0) | v2);
            this.encryptionSignalByte.setPosition(0);
            this.output.sampleData(this.encryptionSignalByte, 1);
            this.output.sampleData(parsableByteArray0, v2);
            if(!z1) {
                return v2 + 1;
            }
            if(!z) {
                this.scratch.reset(8);
                byte[] arr_b = this.scratch.data;
                arr_b[0] = 0;
                arr_b[1] = 1;
                arr_b[2] = (byte)(v1 >> 8 & 0xFF);
                arr_b[3] = (byte)(v1 & 0xFF);
                arr_b[4] = (byte)(v >> 24 & 0xFF);
                arr_b[5] = (byte)(v >> 16 & 0xFF);
                arr_b[6] = (byte)(v >> 8 & 0xFF);
                arr_b[7] = (byte)(v & 0xFF);
                this.output.sampleData(this.scratch, 8);
                return v2 + 9;
            }
            ParsableByteArray parsableByteArray1 = this.fragment.sampleEncryptionData;
            int v3 = parsableByteArray1.readUnsignedShort();
            parsableByteArray1.skipBytes(-2);
            int v4 = v3 * 6 + 2;
            if(v1 != 0) {
                this.scratch.reset(v4);
                this.scratch.readBytes(parsableByteArray1.data, 0, v4);
                parsableByteArray1.skipBytes(v4);
                parsableByteArray1 = this.scratch;
                byte[] arr_b1 = parsableByteArray1.data;
                int v5 = ((arr_b1[2] & 0xFF) << 8 | arr_b1[3] & 0xFF) + v1;
                arr_b1[2] = (byte)(v5 >> 8 & 0xFF);
                arr_b1[3] = (byte)(v5 & 0xFF);
            }
            this.output.sampleData(parsableByteArray1, v4);
            return v2 + 1 + v4;
        }

        public void reset() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
        }

        public void seek(long v) {
            for(int v1 = this.currentSampleIndex; v1 < this.fragment.sampleCount && this.fragment.getSamplePresentationTimeUs(v1) < v; ++v1) {
                if(this.fragment.sampleIsSyncFrameTable[v1]) {
                    this.firstSampleToOutputIndex = v1;
                }
            }
        }

        private void skipSampleEncryptionData() {
            TrackEncryptionBox trackEncryptionBox0 = this.getEncryptionBoxIfEncrypted();
            if(trackEncryptionBox0 != null) {
                ParsableByteArray parsableByteArray0 = this.fragment.sampleEncryptionData;
                int v = trackEncryptionBox0.perSampleIvSize;
                if(v != 0) {
                    parsableByteArray0.skipBytes(v);
                }
                if(this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex)) {
                    parsableByteArray0.skipBytes(parsableByteArray0.readUnsignedShort() * 6);
                }
            }
        }

        public void updateDrmInitData(DrmInitData drmInitData0) {
            TrackEncryptionBox trackEncryptionBox0 = this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
            Format format0 = this.track.format.copyWithDrmInitData(drmInitData0.copyWithSchemeType((trackEncryptionBox0 == null ? null : trackEncryptionBox0.schemeType)));
            this.output.format(format0);
        }
    }

    private static final Format EMSG_FORMAT = null;
    public static final ExtractorsFactory FACTORY = null;
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    private static final int FLAG_SIDELOADED = 8;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = null;
    private static final int SAMPLE_GROUP_TYPE_seig = 1936025959;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] cea608TrackOutputs;
    private final List closedCaptionFormats;
    private final ArrayDeque containerAtoms;
    private TrackBundle currentTrackBundle;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final EventMessageEncoder eventMessageEncoder;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalBuffer;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private final ParsableByteArray scratch;
    private final byte[] scratchBytes;
    private long segmentIndexEarliestPresentationTimeUs;
    private final Track sideloadedTrack;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray trackBundles;

    static {
        FragmentedMp4Extractor.FACTORY = new b(18);
        FragmentedMp4Extractor.PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = new byte[]{-94, 57, 0x4F, 82, 90, -101, 0x4F, 20, -94, 68, 108, 66, 0x7C, 100, (byte)0x8D, -12};
        FragmentedMp4Extractor.EMSG_FORMAT = Format.createSampleFormat(null, "application/x-emsg", 0x7FFFFFFFFFFFFFFFL);
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    public FragmentedMp4Extractor(int v) {
        this(v, null);
    }

    public FragmentedMp4Extractor(int v, TimestampAdjuster timestampAdjuster0) {
        this(v, timestampAdjuster0, null, Collections.EMPTY_LIST);
    }

    public FragmentedMp4Extractor(int v, TimestampAdjuster timestampAdjuster0, Track track0) {
        this(v, timestampAdjuster0, track0, Collections.EMPTY_LIST);
    }

    public FragmentedMp4Extractor(int v, TimestampAdjuster timestampAdjuster0, Track track0, List list0) {
        this(v, timestampAdjuster0, track0, list0, null);
    }

    public FragmentedMp4Extractor(int v, TimestampAdjuster timestampAdjuster0, Track track0, List list0, TrackOutput trackOutput0) {
        this.flags = v | (track0 == null ? 0 : 8);
        this.timestampAdjuster = timestampAdjuster0;
        this.sideloadedTrack = track0;
        this.closedCaptionFormats = Collections.unmodifiableList(list0);
        this.additionalEmsgTrackOutput = trackOutput0;
        this.eventMessageEncoder = new EventMessageEncoder();
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.nalBuffer = new ParsableByteArray();
        byte[] arr_b = new byte[16];
        this.scratchBytes = arr_b;
        this.scratch = new ParsableByteArray(arr_b);
        this.containerAtoms = new ArrayDeque();
        this.pendingMetadataSampleInfos = new ArrayDeque();
        this.trackBundles = new SparseArray();
        this.durationUs = 0x8000000000000001L;
        this.pendingSeekTimeUs = 0x8000000000000001L;
        this.segmentIndexEarliestPresentationTimeUs = 0x8000000000000001L;
        this.enterReadingAtomHeaderState();
    }

    public static Extractor[] a() {
        return FragmentedMp4Extractor.lambda$static$0();
    }

    private static int checkNonNegative(int v) {
        if(v < 0) {
            throw new ParserException("Unexpected negtive value: " + v);
        }
        return v;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private DefaultSampleValues getDefaultSampleValues(SparseArray sparseArray0, int v) {
        return sparseArray0.size() == 1 ? ((DefaultSampleValues)sparseArray0.valueAt(0)) : ((DefaultSampleValues)Assertions.checkNotNull(((DefaultSampleValues)sparseArray0.get(v))));
    }

    private static DrmInitData getDrmInitDataFromAtoms(List list0) {
        int v = list0.size();
        List list1 = null;
        for(int v1 = 0; v1 < v; ++v1) {
            LeafAtom atom$LeafAtom0 = (LeafAtom)list0.get(v1);
            if(atom$LeafAtom0.type == 0x70737368) {
                if(list1 == null) {
                    list1 = new ArrayList();
                }
                byte[] arr_b = atom$LeafAtom0.data.data;
                UUID uUID0 = PsshAtomUtil.parseUuid(arr_b);
                if(uUID0 == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                }
                else {
                    ((ArrayList)list1).add(new SchemeData(uUID0, "video/mp4", arr_b));
                }
            }
        }
        return list1 == null ? null : new DrmInitData(list1);
    }

    private static TrackBundle getNextFragmentRun(SparseArray sparseArray0) {
        int v = sparseArray0.size();
        TrackBundle fragmentedMp4Extractor$TrackBundle0 = null;
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        for(int v2 = 0; v2 < v; ++v2) {
            TrackBundle fragmentedMp4Extractor$TrackBundle1 = (TrackBundle)sparseArray0.valueAt(v2);
            int v3 = fragmentedMp4Extractor$TrackBundle1.currentTrackRunIndex;
            TrackFragment trackFragment0 = fragmentedMp4Extractor$TrackBundle1.fragment;
            if(v3 != trackFragment0.trunCount) {
                long v4 = trackFragment0.trunDataPosition[v3];
                if(v4 < v1) {
                    fragmentedMp4Extractor$TrackBundle0 = fragmentedMp4Extractor$TrackBundle1;
                    v1 = v4;
                }
            }
        }
        return fragmentedMp4Extractor$TrackBundle0;
    }

    private static TrackBundle getTrackBundle(SparseArray sparseArray0, int v) {
        return sparseArray0.size() == 1 ? ((TrackBundle)sparseArray0.valueAt(0)) : ((TrackBundle)sparseArray0.get(v));
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
        Track track0 = this.sideloadedTrack;
        if(track0 != null) {
            TrackBundle fragmentedMp4Extractor$TrackBundle0 = new TrackBundle(extractorOutput0.track(0, track0.type));
            DefaultSampleValues defaultSampleValues0 = new DefaultSampleValues(0, 0, 0, 0);
            fragmentedMp4Extractor$TrackBundle0.init(this.sideloadedTrack, defaultSampleValues0);
            this.trackBundles.put(0, fragmentedMp4Extractor$TrackBundle0);
            this.maybeInitExtraTracks();
            this.extractorOutput.endTracks();
        }
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new FragmentedMp4Extractor()};
    }

    private void maybeInitExtraTracks() {
        int v1;
        if(this.emsgTrackOutputs == null) {
            TrackOutput[] arr_trackOutput = new TrackOutput[2];
            this.emsgTrackOutputs = arr_trackOutput;
            TrackOutput trackOutput0 = this.additionalEmsgTrackOutput;
            if(trackOutput0 == null) {
                v1 = 0;
            }
            else {
                arr_trackOutput[0] = trackOutput0;
                v1 = 1;
            }
            if((this.flags & 4) != 0) {
                arr_trackOutput[v1] = this.extractorOutput.track(this.trackBundles.size(), 4);
                ++v1;
            }
            TrackOutput[] arr_trackOutput1 = (TrackOutput[])Arrays.copyOf(this.emsgTrackOutputs, v1);
            this.emsgTrackOutputs = arr_trackOutput1;
            for(int v2 = 0; v2 < arr_trackOutput1.length; ++v2) {
                arr_trackOutput1[v2].format(FragmentedMp4Extractor.EMSG_FORMAT);
            }
        }
        if(this.cea608TrackOutputs == null) {
            this.cea608TrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
            for(int v = 0; v < this.cea608TrackOutputs.length; ++v) {
                TrackOutput trackOutput1 = this.extractorOutput.track(this.trackBundles.size() + 1 + v, 3);
                trackOutput1.format(((Format)this.closedCaptionFormats.get(v)));
                this.cea608TrackOutputs[v] = trackOutput1;
            }
        }
    }

    public Track modifyTrack(Track track0) {
        return track0;
    }

    private void onContainerAtomRead(ContainerAtom atom$ContainerAtom0) {
        int v = atom$ContainerAtom0.type;
        if(v == 0x6D6F6F76) {
            this.onMoovContainerAtomRead(atom$ContainerAtom0);
            return;
        }
        if(v == 0x6D6F6F66) {
            this.onMoofContainerAtomRead(atom$ContainerAtom0);
            return;
        }
        if(!this.containerAtoms.isEmpty()) {
            ((ContainerAtom)this.containerAtoms.peek()).add(atom$ContainerAtom0);
        }
    }

    private void onEmsgLeafAtomRead(ParsableByteArray parsableByteArray0) {
        long v6;
        long v5;
        long v4;
        long v2;
        String s1;
        String s;
        if(this.emsgTrackOutputs != null && this.emsgTrackOutputs.length != 0) {
            parsableByteArray0.setPosition(8);
            int v = Atom.parseFullAtomVersion(parsableByteArray0.readInt());
            switch(v) {
                case 0: {
                    s = (String)Assertions.checkNotNull(parsableByteArray0.readNullTerminatedString());
                    s1 = (String)Assertions.checkNotNull(parsableByteArray0.readNullTerminatedString());
                    long v1 = parsableByteArray0.readUnsignedInt();
                    v2 = Util.scaleLargeTimestamp(parsableByteArray0.readUnsignedInt(), 1000000L, v1);
                    long v3 = this.segmentIndexEarliestPresentationTimeUs == 0x8000000000000001L ? 0x8000000000000001L : this.segmentIndexEarliestPresentationTimeUs + v2;
                    v4 = Util.scaleLargeTimestamp(parsableByteArray0.readUnsignedInt(), 1000L, v1);
                    v5 = parsableByteArray0.readUnsignedInt();
                    v6 = v3;
                    break;
                }
                case 1: {
                    long v7 = parsableByteArray0.readUnsignedInt();
                    v6 = Util.scaleLargeTimestamp(parsableByteArray0.readUnsignedLongToLong(), 1000000L, v7);
                    long v8 = Util.scaleLargeTimestamp(parsableByteArray0.readUnsignedInt(), 1000L, v7);
                    long v9 = parsableByteArray0.readUnsignedInt();
                    s = (String)Assertions.checkNotNull(parsableByteArray0.readNullTerminatedString());
                    s1 = (String)Assertions.checkNotNull(parsableByteArray0.readNullTerminatedString());
                    v4 = v8;
                    v5 = v9;
                    v2 = 0x8000000000000001L;
                    break;
                }
                default: {
                    Z.q(46, v, "Skipping unsupported emsg version: ", "FragmentedMp4Extractor");
                    return;
                }
            }
            byte[] arr_b = new byte[parsableByteArray0.bytesLeft()];
            parsableByteArray0.readBytes(arr_b, 0, parsableByteArray0.bytesLeft());
            EventMessage eventMessage0 = new EventMessage(s, s1, v4, v5, arr_b);
            ParsableByteArray parsableByteArray1 = new ParsableByteArray(this.eventMessageEncoder.encode(eventMessage0));
            int v11 = parsableByteArray1.bytesLeft();
            TrackOutput[] arr_trackOutput = this.emsgTrackOutputs;
            for(int v12 = 0; v12 < arr_trackOutput.length; ++v12) {
                TrackOutput trackOutput0 = arr_trackOutput[v12];
                parsableByteArray1.setPosition(0);
                trackOutput0.sampleData(parsableByteArray1, v11);
            }
            if(v6 == 0x8000000000000001L) {
                MetadataSampleInfo fragmentedMp4Extractor$MetadataSampleInfo0 = new MetadataSampleInfo(v2, v11);
                this.pendingMetadataSampleInfos.addLast(fragmentedMp4Extractor$MetadataSampleInfo0);
                this.pendingMetadataSampleBytes += v11;
                return;
            }
            TimestampAdjuster timestampAdjuster0 = this.timestampAdjuster;
            if(timestampAdjuster0 != null) {
                v6 = timestampAdjuster0.adjustSampleTimestamp(v6);
            }
            TrackOutput[] arr_trackOutput1 = this.emsgTrackOutputs;
            for(int v10 = 0; v10 < arr_trackOutput1.length; ++v10) {
                arr_trackOutput1[v10].sampleMetadata(v6, 1, v11, 0, null);
            }
        }
    }

    private void onLeafAtomRead(LeafAtom atom$LeafAtom0, long v) {
        if(!this.containerAtoms.isEmpty()) {
            ((ContainerAtom)this.containerAtoms.peek()).add(atom$LeafAtom0);
            return;
        }
        int v1 = atom$LeafAtom0.type;
        if(v1 == 1936286840) {
            Pair pair0 = FragmentedMp4Extractor.parseSidx(atom$LeafAtom0.data, v);
            this.segmentIndexEarliestPresentationTimeUs = (long)(((Long)pair0.first));
            this.extractorOutput.seekMap(((SeekMap)pair0.second));
            this.haveOutputSeekMap = true;
            return;
        }
        if(v1 == 1701671783) {
            this.onEmsgLeafAtomRead(atom$LeafAtom0.data);
        }
    }

    private void onMoofContainerAtomRead(ContainerAtom atom$ContainerAtom0) {
        FragmentedMp4Extractor.parseMoof(atom$ContainerAtom0, this.trackBundles, this.flags, this.scratchBytes);
        DrmInitData drmInitData0 = FragmentedMp4Extractor.getDrmInitDataFromAtoms(atom$ContainerAtom0.leafChildren);
        if(drmInitData0 != null) {
            int v1 = this.trackBundles.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                ((TrackBundle)this.trackBundles.valueAt(v2)).updateDrmInitData(drmInitData0);
            }
        }
        if(this.pendingSeekTimeUs != 0x8000000000000001L) {
            int v3 = this.trackBundles.size();
            for(int v = 0; v < v3; ++v) {
                ((TrackBundle)this.trackBundles.valueAt(v)).seek(this.pendingSeekTimeUs);
            }
            this.pendingSeekTimeUs = 0x8000000000000001L;
        }
    }

    private void onMoovContainerAtomRead(ContainerAtom atom$ContainerAtom0) {
        int v = 0;
        boolean z = true;
        Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
        DrmInitData drmInitData0 = FragmentedMp4Extractor.getDrmInitDataFromAtoms(atom$ContainerAtom0.leafChildren);
        ContainerAtom atom$ContainerAtom1 = atom$ContainerAtom0.getContainerAtomOfType(0x6D766578);
        SparseArray sparseArray0 = new SparseArray();
        int v1 = atom$ContainerAtom1.leafChildren.size();
        long v2 = 0x8000000000000001L;
        for(int v3 = 0; v3 < v1; ++v3) {
            LeafAtom atom$LeafAtom0 = (LeafAtom)atom$ContainerAtom1.leafChildren.get(v3);
            int v4 = atom$LeafAtom0.type;
            if(v4 == 0x74726578) {
                Pair pair0 = FragmentedMp4Extractor.parseTrex(atom$LeafAtom0.data);
                sparseArray0.put(((int)(((Integer)pair0.first))), ((DefaultSampleValues)pair0.second));
            }
            else if(v4 == 1835362404) {
                v2 = FragmentedMp4Extractor.parseMehd(atom$LeafAtom0.data);
            }
        }
        SparseArray sparseArray1 = new SparseArray();
        int v5 = atom$ContainerAtom0.containerChildren.size();
        for(int v6 = 0; v6 < v5; ++v6) {
            ContainerAtom atom$ContainerAtom2 = (ContainerAtom)atom$ContainerAtom0.containerChildren.get(v6);
            if(atom$ContainerAtom2.type == 1953653099) {
                Track track0 = this.modifyTrack(AtomParsers.parseTrak(atom$ContainerAtom2, atom$ContainerAtom0.getLeafAtomOfType(0x6D766864), v2, drmInitData0, (this.flags & 16) != 0, false));
                if(track0 != null) {
                    sparseArray1.put(track0.id, track0);
                }
            }
        }
        int v7 = sparseArray1.size();
        if(this.trackBundles.size() == 0) {
            while(v < v7) {
                Track track1 = (Track)sparseArray1.valueAt(v);
                TrackBundle fragmentedMp4Extractor$TrackBundle0 = new TrackBundle(this.extractorOutput.track(v, track1.type));
                fragmentedMp4Extractor$TrackBundle0.init(track1, this.getDefaultSampleValues(sparseArray0, track1.id));
                this.trackBundles.put(track1.id, fragmentedMp4Extractor$TrackBundle0);
                this.durationUs = Math.max(this.durationUs, track1.durationUs);
                ++v;
            }
            this.maybeInitExtraTracks();
            this.extractorOutput.endTracks();
            return;
        }
        if(this.trackBundles.size() != v7) {
            z = false;
        }
        Assertions.checkState(z);
        while(v < v7) {
            Track track2 = (Track)sparseArray1.valueAt(v);
            ((TrackBundle)this.trackBundles.get(track2.id)).init(track2, this.getDefaultSampleValues(sparseArray0, track2.id));
            ++v;
        }
    }

    private void outputPendingMetadataSamples(long v) {
        while(!this.pendingMetadataSampleInfos.isEmpty()) {
            MetadataSampleInfo fragmentedMp4Extractor$MetadataSampleInfo0 = (MetadataSampleInfo)this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= fragmentedMp4Extractor$MetadataSampleInfo0.size;
            long v1 = fragmentedMp4Extractor$MetadataSampleInfo0.presentationTimeDeltaUs + v;
            TimestampAdjuster timestampAdjuster0 = this.timestampAdjuster;
            if(timestampAdjuster0 != null) {
                v1 = timestampAdjuster0.adjustSampleTimestamp(v1);
            }
            long v2 = v1;
            TrackOutput[] arr_trackOutput = this.emsgTrackOutputs;
            for(int v3 = 0; v3 < arr_trackOutput.length; ++v3) {
                arr_trackOutput[v3].sampleMetadata(v2, 1, fragmentedMp4Extractor$MetadataSampleInfo0.size, this.pendingMetadataSampleBytes, null);
            }
        }
    }

    private static long parseMehd(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray0.readInt()) == 0 ? parsableByteArray0.readUnsignedInt() : parsableByteArray0.readUnsignedLongToLong();
    }

    private static void parseMoof(ContainerAtom atom$ContainerAtom0, SparseArray sparseArray0, int v, byte[] arr_b) {
        int v1 = atom$ContainerAtom0.containerChildren.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            ContainerAtom atom$ContainerAtom1 = (ContainerAtom)atom$ContainerAtom0.containerChildren.get(v2);
            if(atom$ContainerAtom1.type == 1953653094) {
                FragmentedMp4Extractor.parseTraf(atom$ContainerAtom1, sparseArray0, v, arr_b);
            }
        }
    }

    private static void parseSaio(ParsableByteArray parsableByteArray0, TrackFragment trackFragment0) {
        parsableByteArray0.setPosition(8);
        int v = parsableByteArray0.readInt();
        if((v & 1) == 1) {
            parsableByteArray0.skipBytes(8);
        }
        int v1 = parsableByteArray0.readUnsignedIntToInt();
        if(v1 != 1) {
            throw new ParserException("Unexpected saio entry count: " + v1);
        }
        trackFragment0.auxiliaryDataPosition += ((v >> 24 & 0xFF) == 0 ? parsableByteArray0.readUnsignedInt() : parsableByteArray0.readUnsignedLongToLong());
    }

    private static void parseSaiz(TrackEncryptionBox trackEncryptionBox0, ParsableByteArray parsableByteArray0, TrackFragment trackFragment0) {
        int v4;
        int v = trackEncryptionBox0.perSampleIvSize;
        parsableByteArray0.setPosition(8);
        boolean z = true;
        if((Atom.parseFullAtomFlags(parsableByteArray0.readInt()) & 1) == 1) {
            parsableByteArray0.skipBytes(8);
        }
        int v1 = parsableByteArray0.readUnsignedByte();
        int v2 = parsableByteArray0.readUnsignedIntToInt();
        if(v2 != trackFragment0.sampleCount) {
            throw new ParserException("Length mismatch: " + v2 + ", " + trackFragment0.sampleCount);
        }
        if(v1 == 0) {
            boolean[] arr_z = trackFragment0.sampleHasSubsampleEncryptionTable;
            v4 = 0;
            for(int v3 = 0; v3 < v2; ++v3) {
                int v5 = parsableByteArray0.readUnsignedByte();
                v4 += v5;
                arr_z[v3] = v5 > v;
            }
        }
        else {
            if(v1 <= v) {
                z = false;
            }
            v4 = v1 * v2;
            Arrays.fill(trackFragment0.sampleHasSubsampleEncryptionTable, 0, v2, z);
        }
        trackFragment0.initEncryptionData(v4);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray0, int v, TrackFragment trackFragment0) {
        parsableByteArray0.setPosition(v + 8);
        int v1 = Atom.parseFullAtomFlags(parsableByteArray0.readInt());
        if((v1 & 1) != 0) {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        int v2 = parsableByteArray0.readUnsignedIntToInt();
        if(v2 != trackFragment0.sampleCount) {
            throw new ParserException("Length mismatch: " + v2 + ", " + trackFragment0.sampleCount);
        }
        Arrays.fill(trackFragment0.sampleHasSubsampleEncryptionTable, 0, v2, (v1 & 2) != 0);
        trackFragment0.initEncryptionData(parsableByteArray0.bytesLeft());
        trackFragment0.fillEncryptionData(parsableByteArray0);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray0, TrackFragment trackFragment0) {
        FragmentedMp4Extractor.parseSenc(parsableByteArray0, 0, trackFragment0);
    }

    private static void parseSgpd(ParsableByteArray parsableByteArray0, ParsableByteArray parsableByteArray1, String s, TrackFragment trackFragment0) {
        byte[] arr_b1;
        parsableByteArray0.setPosition(8);
        int v = parsableByteArray0.readInt();
        if(parsableByteArray0.readInt() == 1936025959) {
            if((v >> 24 & 0xFF) == 1) {
                parsableByteArray0.skipBytes(4);
            }
            if(parsableByteArray0.readInt() != 1) {
                throw new ParserException("Entry count in sbgp != 1 (unsupported).");
            }
            parsableByteArray1.setPosition(8);
            int v1 = parsableByteArray1.readInt();
            if(parsableByteArray1.readInt() == 1936025959) {
                int v2 = v1 >> 24 & 0xFF;
                if(v2 == 1) {
                    if(parsableByteArray1.readUnsignedInt() == 0L) {
                        throw new ParserException("Variable length description in sgpd found (unsupported)");
                    }
                }
                else if(v2 >= 2) {
                    parsableByteArray1.skipBytes(4);
                }
                if(parsableByteArray1.readUnsignedInt() != 1L) {
                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                }
                parsableByteArray1.skipBytes(1);
                int v3 = parsableByteArray1.readUnsignedByte();
                if(parsableByteArray1.readUnsignedByte() == 1) {
                    int v4 = parsableByteArray1.readUnsignedByte();
                    byte[] arr_b = new byte[16];
                    parsableByteArray1.readBytes(arr_b, 0, 16);
                    if(v4 == 0) {
                        int v5 = parsableByteArray1.readUnsignedByte();
                        arr_b1 = new byte[v5];
                        parsableByteArray1.readBytes(arr_b1, 0, v5);
                    }
                    else {
                        arr_b1 = null;
                    }
                    trackFragment0.definesEncryptionData = true;
                    trackFragment0.trackEncryptionBox = new TrackEncryptionBox(true, s, v4, arr_b, (v3 & 0xF0) >> 4, v3 & 15, arr_b1);
                }
            }
        }
    }

    private static Pair parseSidx(ParsableByteArray parsableByteArray0, long v) {
        long v4;
        long v3;
        parsableByteArray0.setPosition(8);
        int v1 = Atom.parseFullAtomVersion(parsableByteArray0.readInt());
        parsableByteArray0.skipBytes(4);
        long v2 = parsableByteArray0.readUnsignedInt();
        if(v1 == 0) {
            v3 = parsableByteArray0.readUnsignedInt();
            v4 = parsableByteArray0.readUnsignedInt();
        }
        else {
            v3 = parsableByteArray0.readUnsignedLongToLong();
            v4 = parsableByteArray0.readUnsignedLongToLong();
        }
        long v5 = Util.scaleLargeTimestamp(v3, 1000000L, v2);
        parsableByteArray0.skipBytes(2);
        int v6 = parsableByteArray0.readUnsignedShort();
        int[] arr_v = new int[v6];
        long[] arr_v1 = new long[v6];
        long[] arr_v2 = new long[v6];
        long[] arr_v3 = new long[v6];
        long v7 = v4 + v;
        long v8 = v5;
        for(int v9 = 0; v9 < v6; ++v9) {
            int v10 = parsableByteArray0.readInt();
            if((0x80000000 & v10) != 0) {
                throw new ParserException("Unhandled indirect reference");
            }
            long v11 = parsableByteArray0.readUnsignedInt();
            arr_v[v9] = v10 & 0x7FFFFFFF;
            arr_v1[v9] = v7;
            arr_v3[v9] = v8;
            v3 += v11;
            v8 = Util.scaleLargeTimestamp(v3, 1000000L, v2);
            arr_v2[v9] = v8 - arr_v3[v9];
            parsableByteArray0.skipBytes(4);
            v7 += (long)arr_v[v9];
        }
        return Pair.create(v5, new ChunkIndex(arr_v, arr_v1, arr_v2, arr_v3));
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray0.readInt()) == 1 ? parsableByteArray0.readUnsignedLongToLong() : parsableByteArray0.readUnsignedInt();
    }

    private static TrackBundle parseTfhd(ParsableByteArray parsableByteArray0, SparseArray sparseArray0) {
        parsableByteArray0.setPosition(8);
        int v = Atom.parseFullAtomFlags(parsableByteArray0.readInt());
        TrackBundle fragmentedMp4Extractor$TrackBundle0 = FragmentedMp4Extractor.getTrackBundle(sparseArray0, parsableByteArray0.readInt());
        if(fragmentedMp4Extractor$TrackBundle0 == null) {
            return null;
        }
        if((v & 1) != 0) {
            long v1 = parsableByteArray0.readUnsignedLongToLong();
            fragmentedMp4Extractor$TrackBundle0.fragment.dataPosition = v1;
            fragmentedMp4Extractor$TrackBundle0.fragment.auxiliaryDataPosition = v1;
        }
        DefaultSampleValues defaultSampleValues0 = fragmentedMp4Extractor$TrackBundle0.defaultSampleValues;
        fragmentedMp4Extractor$TrackBundle0.fragment.header = new DefaultSampleValues(((v & 2) == 0 ? defaultSampleValues0.sampleDescriptionIndex : parsableByteArray0.readInt() - 1), ((v & 8) == 0 ? defaultSampleValues0.duration : parsableByteArray0.readInt()), ((v & 16) == 0 ? defaultSampleValues0.size : parsableByteArray0.readInt()), ((v & 0x20) == 0 ? defaultSampleValues0.flags : parsableByteArray0.readInt()));
        return fragmentedMp4Extractor$TrackBundle0;
    }

    private static void parseTraf(ContainerAtom atom$ContainerAtom0, SparseArray sparseArray0, int v, byte[] arr_b) {
        TrackBundle fragmentedMp4Extractor$TrackBundle0 = FragmentedMp4Extractor.parseTfhd(atom$ContainerAtom0.getLeafAtomOfType(0x74666864).data, sparseArray0);
        if(fragmentedMp4Extractor$TrackBundle0 != null) {
            TrackFragment trackFragment0 = fragmentedMp4Extractor$TrackBundle0.fragment;
            long v1 = trackFragment0.nextFragmentDecodeTime;
            fragmentedMp4Extractor$TrackBundle0.reset();
            if(atom$ContainerAtom0.getLeafAtomOfType(0x74666474) != null && (v & 2) == 0) {
                v1 = FragmentedMp4Extractor.parseTfdt(atom$ContainerAtom0.getLeafAtomOfType(0x74666474).data);
            }
            FragmentedMp4Extractor.parseTruns(atom$ContainerAtom0, fragmentedMp4Extractor$TrackBundle0, v1, v);
            TrackEncryptionBox trackEncryptionBox0 = fragmentedMp4Extractor$TrackBundle0.track.getSampleDescriptionEncryptionBox(trackFragment0.header.sampleDescriptionIndex);
            LeafAtom atom$LeafAtom0 = atom$ContainerAtom0.getLeafAtomOfType(0x7361697A);
            if(atom$LeafAtom0 != null) {
                FragmentedMp4Extractor.parseSaiz(trackEncryptionBox0, atom$LeafAtom0.data, trackFragment0);
            }
            LeafAtom atom$LeafAtom1 = atom$ContainerAtom0.getLeafAtomOfType(0x7361696F);
            if(atom$LeafAtom1 != null) {
                FragmentedMp4Extractor.parseSaio(atom$LeafAtom1.data, trackFragment0);
            }
            LeafAtom atom$LeafAtom2 = atom$ContainerAtom0.getLeafAtomOfType(1936027235);
            if(atom$LeafAtom2 != null) {
                FragmentedMp4Extractor.parseSenc(atom$LeafAtom2.data, trackFragment0);
            }
            LeafAtom atom$LeafAtom3 = atom$ContainerAtom0.getLeafAtomOfType(0x73626770);
            LeafAtom atom$LeafAtom4 = atom$ContainerAtom0.getLeafAtomOfType(0x73677064);
            if(atom$LeafAtom3 != null && atom$LeafAtom4 != null) {
                FragmentedMp4Extractor.parseSgpd(atom$LeafAtom3.data, atom$LeafAtom4.data, (trackEncryptionBox0 == null ? null : trackEncryptionBox0.schemeType), trackFragment0);
            }
            int v2 = atom$ContainerAtom0.leafChildren.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                LeafAtom atom$LeafAtom5 = (LeafAtom)atom$ContainerAtom0.leafChildren.get(v3);
                if(atom$LeafAtom5.type == 1970628964) {
                    FragmentedMp4Extractor.parseUuid(atom$LeafAtom5.data, trackFragment0, arr_b);
                }
            }
        }
    }

    private static Pair parseTrex(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.setPosition(12);
        return Pair.create(parsableByteArray0.readInt(), new DefaultSampleValues(parsableByteArray0.readInt() - 1, parsableByteArray0.readInt(), parsableByteArray0.readInt(), parsableByteArray0.readInt()));
    }

    private static int parseTrun(TrackBundle fragmentedMp4Extractor$TrackBundle0, int v, long v1, int v2, ParsableByteArray parsableByteArray0, int v3) {
        int v18;
        int v17;
        int v16;
        int v15;
        parsableByteArray0.setPosition(8);
        int v4 = Atom.parseFullAtomFlags(parsableByteArray0.readInt());
        Track track0 = fragmentedMp4Extractor$TrackBundle0.track;
        TrackFragment trackFragment0 = fragmentedMp4Extractor$TrackBundle0.fragment;
        DefaultSampleValues defaultSampleValues0 = trackFragment0.header;
        int[] arr_v = trackFragment0.trunLength;
        arr_v[v] = parsableByteArray0.readUnsignedIntToInt();
        long[] arr_v1 = trackFragment0.trunDataPosition;
        long v5 = trackFragment0.dataPosition;
        arr_v1[v] = v5;
        if((v4 & 1) != 0) {
            arr_v1[v] = v5 + ((long)parsableByteArray0.readInt());
        }
        boolean z = (v4 & 4) != 0;
        int v6 = z ? parsableByteArray0.readInt() : defaultSampleValues0.flags;
        long v7 = track0.editListDurations == null || track0.editListDurations.length != 1 || track0.editListDurations[0] != 0L ? 0L : Util.scaleLargeTimestamp(track0.editListMediaTimes[0], 1000000L, track0.timescale);
        int[] arr_v2 = trackFragment0.sampleSizeTable;
        int[] arr_v3 = trackFragment0.sampleCompositionTimeOffsetUsTable;
        long[] arr_v4 = trackFragment0.sampleDecodingTimeUsTable;
        boolean[] arr_z = trackFragment0.sampleIsSyncFrameTable;
        int v8 = track0.type != 2 || (v2 & 1) == 0 ? 0 : 1;
        int v9 = v3 + trackFragment0.trunLength[v];
        long v10 = track0.timescale;
        int v11 = v3;
        long v12 = v <= 0 ? v1 : trackFragment0.nextFragmentDecodeTime;
        while(v11 < v9) {
            int v13 = FragmentedMp4Extractor.checkNonNegative(((v4 & 0x100) == 0 ? parsableByteArray0.readInt() : defaultSampleValues0.duration));
            int v14 = FragmentedMp4Extractor.checkNonNegative(((v4 & 0x200) == 0 ? parsableByteArray0.readInt() : defaultSampleValues0.size));
            if(v11 == 0 && z) {
                v15 = v8;
                v16 = v6;
            }
            else if((v4 & 0x400) == 0) {
                v15 = v8;
                v16 = defaultSampleValues0.flags;
            }
            else {
                v15 = v8;
                v16 = parsableByteArray0.readInt();
            }
            if((v4 & 0x800) == 0) {
                v17 = v16;
                v18 = v9;
                arr_v3[v11] = 0;
            }
            else {
                v17 = v16;
                v18 = v9;
                arr_v3[v11] = (int)(((long)parsableByteArray0.readInt()) * 1000000L / v10);
            }
            arr_v4[v11] = Util.scaleLargeTimestamp(v12, 1000000L, v10) - v7;
            arr_v2[v11] = v14;
            arr_z[v11] = (v17 >> 16 & 1) == 0 && (v15 == 0 || v11 == 0);
            v12 += (long)v13;
            ++v11;
            v8 = v15;
            v9 = v18;
        }
        trackFragment0.nextFragmentDecodeTime = v12;
        return v9;
    }

    private static void parseTruns(ContainerAtom atom$ContainerAtom0, TrackBundle fragmentedMp4Extractor$TrackBundle0, long v, int v1) {
        List list0 = atom$ContainerAtom0.leafChildren;
        int v2 = list0.size();
        int v3 = 0;
        int v5 = 0;
        int v6 = 0;
        for(int v4 = 0; v4 < v2; ++v4) {
            LeafAtom atom$LeafAtom0 = (LeafAtom)list0.get(v4);
            if(atom$LeafAtom0.type == 0x7472756E) {
                atom$LeafAtom0.data.setPosition(12);
                int v7 = atom$LeafAtom0.data.readUnsignedIntToInt();
                if(v7 > 0) {
                    v6 += v7;
                    ++v5;
                }
            }
        }
        fragmentedMp4Extractor$TrackBundle0.currentTrackRunIndex = 0;
        fragmentedMp4Extractor$TrackBundle0.currentSampleInTrackRun = 0;
        fragmentedMp4Extractor$TrackBundle0.currentSampleIndex = 0;
        fragmentedMp4Extractor$TrackBundle0.fragment.initTables(v5, v6);
        int v8 = 0;
        for(int v9 = 0; v9 < v2; ++v9) {
            LeafAtom atom$LeafAtom1 = (LeafAtom)list0.get(v9);
            if(atom$LeafAtom1.type == 0x7472756E) {
                v8 = FragmentedMp4Extractor.parseTrun(fragmentedMp4Extractor$TrackBundle0, v3, v, v1, atom$LeafAtom1.data, v8);
                ++v3;
            }
        }
    }

    private static void parseUuid(ParsableByteArray parsableByteArray0, TrackFragment trackFragment0, byte[] arr_b) {
        parsableByteArray0.setPosition(8);
        parsableByteArray0.readBytes(arr_b, 0, 16);
        if(!Arrays.equals(arr_b, FragmentedMp4Extractor.PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            return;
        }
        FragmentedMp4Extractor.parseSenc(parsableByteArray0, 16, trackFragment0);
    }

    private void processAtomEnded(long v) {
        while(!this.containerAtoms.isEmpty() && ((ContainerAtom)this.containerAtoms.peek()).endPosition == v) {
            this.onContainerAtomRead(((ContainerAtom)this.containerAtoms.pop()));
        }
        this.enterReadingAtomHeaderState();
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        while(true) {
            switch(this.parserState) {
                case 0: {
                    if(this.readAtomHeader(extractorInput0)) {
                        break;
                    }
                    return -1;
                }
                case 1: {
                    this.readAtomPayload(extractorInput0);
                    break;
                }
                case 2: {
                    this.readEncryptionData(extractorInput0);
                    break;
                }
                default: {
                    if(!this.readSample(extractorInput0)) {
                        break;
                    }
                    return 0;
                }
            }
        }
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
        long v2 = extractorInput0.getPosition() - ((long)this.atomHeaderBytesRead);
        if(this.atomType == 0x6D6F6F66) {
            int v3 = this.trackBundles.size();
            for(int v4 = 0; v4 < v3; ++v4) {
                TrackFragment trackFragment0 = ((TrackBundle)this.trackBundles.valueAt(v4)).fragment;
                trackFragment0.atomPosition = v2;
                trackFragment0.auxiliaryDataPosition = v2;
                trackFragment0.dataPosition = v2;
            }
        }
        int v5 = this.atomType;
        if(v5 == 1835295092) {
            this.currentTrackBundle = null;
            this.endOfMdatPosition = this.atomSize + v2;
            if(!this.haveOutputSeekMap) {
                this.extractorOutput.seekMap(new Unseekable(this.durationUs, v2));
                this.haveOutputSeekMap = true;
            }
            this.parserState = 2;
            return true;
        }
        if(FragmentedMp4Extractor.shouldParseContainerAtom(v5)) {
            long v6 = extractorInput0.getPosition() + this.atomSize - 8L;
            ContainerAtom atom$ContainerAtom0 = new ContainerAtom(this.atomType, v6);
            this.containerAtoms.push(atom$ContainerAtom0);
            if(this.atomSize == ((long)this.atomHeaderBytesRead)) {
                this.processAtomEnded(v6);
                return true;
            }
            this.enterReadingAtomHeaderState();
            return true;
        }
        if(FragmentedMp4Extractor.shouldParseLeafAtom(this.atomType)) {
            if(this.atomHeaderBytesRead != 8) {
                throw new ParserException("Leaf atom defines extended atom size (unsupported).");
            }
            long v7 = this.atomSize;
            if(v7 > 0x7FFFFFFFL) {
                throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
            }
            ParsableByteArray parsableByteArray0 = new ParsableByteArray(((int)v7));
            this.atomData = parsableByteArray0;
            System.arraycopy(this.atomHeader.data, 0, parsableByteArray0.data, 0, 8);
            this.parserState = 1;
            return true;
        }
        if(this.atomSize > 0x7FFFFFFFL) {
            throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
        }
        this.atomData = null;
        this.parserState = 1;
        return true;
    }

    private void readAtomPayload(ExtractorInput extractorInput0) {
        int v = ((int)this.atomSize) - this.atomHeaderBytesRead;
        ParsableByteArray parsableByteArray0 = this.atomData;
        if(parsableByteArray0 == null) {
            extractorInput0.skipFully(v);
        }
        else {
            extractorInput0.readFully(parsableByteArray0.data, 8, v);
            this.onLeafAtomRead(new LeafAtom(this.atomType, this.atomData), extractorInput0.getPosition());
        }
        this.processAtomEnded(extractorInput0.getPosition());
    }

    private void readEncryptionData(ExtractorInput extractorInput0) {
        int v = this.trackBundles.size();
        TrackBundle fragmentedMp4Extractor$TrackBundle0 = null;
        long v1 = 0x7FFFFFFFFFFFFFFFL;
        for(int v2 = 0; v2 < v; ++v2) {
            TrackFragment trackFragment0 = ((TrackBundle)this.trackBundles.valueAt(v2)).fragment;
            if(trackFragment0.sampleEncryptionDataNeedsFill) {
                long v3 = trackFragment0.auxiliaryDataPosition;
                if(v3 < v1) {
                    fragmentedMp4Extractor$TrackBundle0 = (TrackBundle)this.trackBundles.valueAt(v2);
                    v1 = v3;
                }
            }
        }
        if(fragmentedMp4Extractor$TrackBundle0 == null) {
            this.parserState = 3;
            return;
        }
        int v4 = (int)(v1 - extractorInput0.getPosition());
        if(v4 < 0) {
            throw new ParserException("Offset to encryption data was negative.");
        }
        extractorInput0.skipFully(v4);
        fragmentedMp4Extractor$TrackBundle0.fragment.fillEncryptionData(extractorInput0);
    }

    private boolean readSample(ExtractorInput extractorInput0) {
        CryptoData trackOutput$CryptoData0;
        int v9;
        if(this.parserState == 3) {
            if(this.currentTrackBundle == null) {
                TrackBundle fragmentedMp4Extractor$TrackBundle0 = FragmentedMp4Extractor.getNextFragmentRun(this.trackBundles);
                if(fragmentedMp4Extractor$TrackBundle0 == null) {
                    int v = (int)(this.endOfMdatPosition - extractorInput0.getPosition());
                    if(v < 0) {
                        throw new ParserException("Offset to end of mdat was negative.");
                    }
                    extractorInput0.skipFully(v);
                    this.enterReadingAtomHeaderState();
                    return false;
                }
                int v1 = (int)(fragmentedMp4Extractor$TrackBundle0.fragment.trunDataPosition[fragmentedMp4Extractor$TrackBundle0.currentTrackRunIndex] - extractorInput0.getPosition());
                if(v1 < 0) {
                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                    v1 = 0;
                }
                extractorInput0.skipFully(v1);
                this.currentTrackBundle = fragmentedMp4Extractor$TrackBundle0;
            }
            TrackBundle fragmentedMp4Extractor$TrackBundle1 = this.currentTrackBundle;
            int v2 = fragmentedMp4Extractor$TrackBundle1.currentSampleIndex;
            int v3 = fragmentedMp4Extractor$TrackBundle1.fragment.sampleSizeTable[v2];
            this.sampleSize = v3;
            if(v2 < fragmentedMp4Extractor$TrackBundle1.firstSampleToOutputIndex) {
                extractorInput0.skipFully(v3);
                this.currentTrackBundle.skipSampleEncryptionData();
                if(!this.currentTrackBundle.next()) {
                    this.currentTrackBundle = null;
                }
                this.parserState = 3;
                return true;
            }
            if(fragmentedMp4Extractor$TrackBundle1.track.sampleTransformation == 1) {
                this.sampleSize = v3 - 8;
                extractorInput0.skipFully(8);
            }
            if("audio/ac4".equals(this.currentTrackBundle.track.format.sampleMimeType)) {
                this.sampleBytesWritten = this.currentTrackBundle.outputSampleEncryptionData(this.sampleSize, 7);
                Ac4Util.getAc4SampleHeader(this.sampleSize, this.scratch);
                this.currentTrackBundle.output.sampleData(this.scratch, 7);
                this.sampleBytesWritten += 7;
            }
            else {
                this.sampleBytesWritten = this.currentTrackBundle.outputSampleEncryptionData(this.sampleSize, 0);
            }
            this.sampleSize += this.sampleBytesWritten;
            this.parserState = 4;
            this.sampleCurrentNalBytesRemaining = 0;
        }
        TrackFragment trackFragment0 = this.currentTrackBundle.fragment;
        Track track0 = this.currentTrackBundle.track;
        TrackOutput trackOutput0 = this.currentTrackBundle.output;
        int v4 = this.currentTrackBundle.currentSampleIndex;
        long v5 = trackFragment0.getSamplePresentationTimeUs(v4);
        TimestampAdjuster timestampAdjuster0 = this.timestampAdjuster;
        if(timestampAdjuster0 != null) {
            v5 = timestampAdjuster0.adjustSampleTimestamp(v5);
        }
        int v6 = track0.nalUnitLengthFieldLength;
        if(v6 == 0) {
            while(true) {
                int v11 = this.sampleBytesWritten;
                int v12 = this.sampleSize;
                if(v11 >= v12) {
                    break;
                }
                int v13 = trackOutput0.sampleData(extractorInput0, v12 - v11, false);
                this.sampleBytesWritten += v13;
            }
        }
        else {
            byte[] arr_b = this.nalPrefix.data;
            arr_b[0] = 0;
            arr_b[1] = 0;
            arr_b[2] = 0;
            while(this.sampleBytesWritten < this.sampleSize) {
                int v7 = this.sampleCurrentNalBytesRemaining;
                if(v7 == 0) {
                    extractorInput0.readFully(arr_b, 4 - v6, v6 + 1);
                    this.nalPrefix.setPosition(0);
                    int v8 = this.nalPrefix.readInt();
                    if(v8 < 1) {
                        throw new ParserException("Invalid NAL length");
                    }
                    this.sampleCurrentNalBytesRemaining = v8 - 1;
                    this.nalStartCode.setPosition(0);
                    trackOutput0.sampleData(this.nalStartCode, 4);
                    trackOutput0.sampleData(this.nalPrefix, 1);
                    this.processSeiNalUnitPayload = this.cea608TrackOutputs.length <= 0 || !NalUnitUtil.isNalUnitSei(track0.format.sampleMimeType, arr_b[4]) ? 0 : 1;
                    this.sampleBytesWritten += 5;
                    this.sampleSize += 4 - v6;
                }
                else {
                    if(this.processSeiNalUnitPayload) {
                        this.nalBuffer.reset(v7);
                        extractorInput0.readFully(this.nalBuffer.data, 0, this.sampleCurrentNalBytesRemaining);
                        trackOutput0.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
                        v9 = this.sampleCurrentNalBytesRemaining;
                        int v10 = NalUnitUtil.unescapeStream(this.nalBuffer.data, this.nalBuffer.limit());
                        this.nalBuffer.setPosition(((int)"video/hevc".equals(track0.format.sampleMimeType)));
                        this.nalBuffer.setLimit(v10);
                        CeaUtil.consume(v5, this.nalBuffer, this.cea608TrackOutputs);
                    }
                    else {
                        v9 = trackOutput0.sampleData(extractorInput0, v7, false);
                    }
                    this.sampleBytesWritten += v9;
                    this.sampleCurrentNalBytesRemaining -= v9;
                }
            }
        }
        boolean z = trackFragment0.sampleIsSyncFrameTable[v4];
        TrackEncryptionBox trackEncryptionBox0 = TrackBundle.access$100(this.currentTrackBundle);
        if(trackEncryptionBox0 == null) {
            trackOutput$CryptoData0 = null;
        }
        else {
            z |= 0x40000000;
            trackOutput$CryptoData0 = trackEncryptionBox0.cryptoData;
        }
        trackOutput0.sampleMetadata(v5, ((int)z), this.sampleSize, 0, trackOutput$CryptoData0);
        this.outputPendingMetadataSamples(v5);
        if(!this.currentTrackBundle.next()) {
            this.currentTrackBundle = null;
        }
        this.parserState = 3;
        return true;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        int v2 = this.trackBundles.size();
        for(int v3 = 0; v3 < v2; ++v3) {
            ((TrackBundle)this.trackBundles.valueAt(v3)).reset();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.pendingSeekTimeUs = v1;
        this.containerAtoms.clear();
        this.enterReadingAtomHeaderState();
    }

    private static boolean shouldParseContainerAtom(int v) {
        switch(v) {
            case 1701082227: 
            case 0x6D646961: 
            case 1835626086: 
            case 0x6D6F6F66: 
            case 0x6D6F6F76: 
            case 0x6D766578: 
            case 1937007212: 
            case 1953653094: 
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
            case 1701606260: 
            case 1701671783: 
            case 0x68646C72: 
            case 0x6D646864: 
            case 1835362404: 
            case 0x6D766864: 
            case 0x70737368: 
            case 0x7361696F: 
            case 0x7361697A: 
            case 0x73626770: 
            case 1936027235: 
            case 0x73677064: 
            case 1936286840: 
            case 1937011556: 
            case 0x74666474: 
            case 0x74666864: 
            case 0x746B6864: 
            case 0x74726578: 
            case 0x7472756E: 
            case 1970628964: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        return Sniffer.sniffFragmented(extractorInput0);
    }
}

