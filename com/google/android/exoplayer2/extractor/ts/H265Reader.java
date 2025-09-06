package com.google.android.exoplayer2.extractor.ts;

import b3.Z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Collections;

public final class H265Reader implements ElementaryStreamReader {
    static final class SampleReader {
        private static final int FIRST_SLICE_FLAG_OFFSET = 2;
        private boolean isFirstPrefixNalUnit;
        private boolean isFirstSlice;
        private boolean lookingForFirstSliceFlag;
        private int nalUnitBytesRead;
        private boolean nalUnitHasKeyframeData;
        private long nalUnitPosition;
        private long nalUnitTimeUs;
        private final TrackOutput output;
        private boolean readingPrefix;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;

        public SampleReader(TrackOutput trackOutput0) {
            this.output = trackOutput0;
        }

        public void endNalUnit(long v, int v1, boolean z) {
            if(this.readingPrefix && this.isFirstSlice) {
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                this.readingPrefix = false;
                return;
            }
            if(!this.isFirstPrefixNalUnit && !this.isFirstSlice) {
                return;
            }
            if(z && this.readingSample) {
                this.outputSample(v1 + ((int)(v - this.nalUnitPosition)));
            }
            this.samplePosition = this.nalUnitPosition;
            this.sampleTimeUs = this.nalUnitTimeUs;
            this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
            this.readingSample = true;
        }

        // 去混淆评级： 低(20)
        private static boolean isPrefixNalUnit(int v) {
            return 0x20 <= v && v <= 35 || v == 39;
        }

        private static boolean isVclBodyNalUnit(int v) {
            return v < 0x20 || v == 40;
        }

        private void outputSample(int v) {
            this.output.sampleMetadata(this.sampleTimeUs, ((int)this.sampleIsKeyframe), ((int)(this.nalUnitPosition - this.samplePosition)), v, null);
        }

        public void readNalUnitData(byte[] arr_b, int v, int v1) {
            if(this.lookingForFirstSliceFlag) {
                int v2 = this.nalUnitBytesRead;
                int v3 = v + 2 - v2;
                if(v3 < v1) {
                    this.isFirstSlice = (arr_b[v3] & 0x80) != 0;
                    this.lookingForFirstSliceFlag = false;
                    return;
                }
                this.nalUnitBytesRead = v1 - v + v2;
            }
        }

        public void reset() {
            this.lookingForFirstSliceFlag = false;
            this.isFirstSlice = false;
            this.isFirstPrefixNalUnit = false;
            this.readingSample = false;
            this.readingPrefix = false;
        }

        public void startNalUnit(long v, int v1, int v2, long v3, boolean z) {
            boolean z1 = false;
            this.isFirstSlice = false;
            this.isFirstPrefixNalUnit = false;
            this.nalUnitTimeUs = v3;
            this.nalUnitBytesRead = 0;
            this.nalUnitPosition = v;
            if(!SampleReader.isVclBodyNalUnit(v2)) {
                if(this.readingSample && !this.readingPrefix) {
                    if(z) {
                        this.outputSample(v1);
                    }
                    this.readingSample = false;
                }
                if(SampleReader.isPrefixNalUnit(v2)) {
                    this.isFirstPrefixNalUnit = !this.readingPrefix;
                    this.readingPrefix = true;
                }
            }
            boolean z2 = v2 >= 16 && v2 <= 21;
            this.nalUnitHasKeyframeData = z2;
            if(z2 || v2 <= 9) {
                z1 = true;
            }
            this.lookingForFirstSliceFlag = z1;
        }
    }

    private static final int AUD_NUT = 35;
    private static final int BLA_W_LP = 16;
    private static final int CRA_NUT = 21;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final String TAG = "H265Reader";
    private static final int VPS_NUT = 0x20;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final NalUnitTargetBuffer pps;
    private final boolean[] prefixFlags;
    private final NalUnitTargetBuffer prefixSei;
    private SampleReader sampleReader;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper;
    private final NalUnitTargetBuffer sps;
    private final NalUnitTargetBuffer suffixSei;
    private long totalBytesWritten;
    private final NalUnitTargetBuffer vps;

    public H265Reader(SeiReader seiReader0) {
        this.seiReader = seiReader0;
        this.prefixFlags = new boolean[3];
        this.vps = new NalUnitTargetBuffer(0x20, 0x80);
        this.sps = new NalUnitTargetBuffer(33, 0x80);
        this.pps = new NalUnitTargetBuffer(34, 0x80);
        this.prefixSei = new NalUnitTargetBuffer(39, 0x80);
        this.suffixSei = new NalUnitTargetBuffer(40, 0x80);
        this.seiWrapper = new ParsableByteArray();
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        while(parsableByteArray0.bytesLeft() > 0) {
            int v = parsableByteArray0.getPosition();
            int v1 = parsableByteArray0.limit();
            byte[] arr_b = parsableByteArray0.data;
            this.totalBytesWritten += (long)parsableByteArray0.bytesLeft();
            this.output.sampleData(parsableByteArray0, parsableByteArray0.bytesLeft());
            while(v < v1) {
                int v2 = NalUnitUtil.findNalUnit(arr_b, v, v1, this.prefixFlags);
                if(v2 == v1) {
                    this.nalUnitData(arr_b, v, v1);
                    return;
                }
                int v3 = NalUnitUtil.getH265NalUnitType(arr_b, v2);
                int v4 = v2 - v;
                if(v4 > 0) {
                    this.nalUnitData(arr_b, v, v2);
                }
                int v5 = v1 - v2;
                long v6 = this.totalBytesWritten - ((long)v5);
                this.endNalUnit(v6, v5, (v4 >= 0 ? 0 : -v4), this.pesTimeUs);
                this.startNalUnit(v6, v5, v3, this.pesTimeUs);
                v = v2 + 3;
            }
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        tsPayloadReader$TrackIdGenerator0.generateNewId();
        this.formatId = tsPayloadReader$TrackIdGenerator0.getFormatId();
        TrackOutput trackOutput0 = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 2);
        this.output = trackOutput0;
        this.sampleReader = new SampleReader(trackOutput0);
        this.seiReader.createTracks(extractorOutput0, tsPayloadReader$TrackIdGenerator0);
    }

    private void endNalUnit(long v, int v1, int v2, long v3) {
        this.sampleReader.endNalUnit(v, v1, this.hasOutputFormat);
        if(!this.hasOutputFormat) {
            this.vps.endNalUnit(v2);
            this.sps.endNalUnit(v2);
            this.pps.endNalUnit(v2);
            if(this.vps.isCompleted() && this.sps.isCompleted() && this.pps.isCompleted()) {
                this.output.format(H265Reader.parseMediaFormat(this.formatId, this.vps, this.sps, this.pps));
                this.hasOutputFormat = true;
            }
        }
        if(this.prefixSei.endNalUnit(v2)) {
            int v4 = NalUnitUtil.unescapeStream(this.prefixSei.nalData, this.prefixSei.nalLength);
            this.seiWrapper.reset(this.prefixSei.nalData, v4);
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(v3, this.seiWrapper);
        }
        if(this.suffixSei.endNalUnit(v2)) {
            int v5 = NalUnitUtil.unescapeStream(this.suffixSei.nalData, this.suffixSei.nalLength);
            this.seiWrapper.reset(this.suffixSei.nalData, v5);
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(v3, this.seiWrapper);
        }
    }

    private void nalUnitData(byte[] arr_b, int v, int v1) {
        this.sampleReader.readNalUnitData(arr_b, v, v1);
        if(!this.hasOutputFormat) {
            this.vps.appendToNalUnit(arr_b, v, v1);
            this.sps.appendToNalUnit(arr_b, v, v1);
            this.pps.appendToNalUnit(arr_b, v, v1);
        }
        this.prefixSei.appendToNalUnit(arr_b, v, v1);
        this.suffixSei.appendToNalUnit(arr_b, v, v1);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        this.pesTimeUs = v;
    }

    private static Format parseMediaFormat(String s, NalUnitTargetBuffer nalUnitTargetBuffer0, NalUnitTargetBuffer nalUnitTargetBuffer1, NalUnitTargetBuffer nalUnitTargetBuffer2) {
        int v = nalUnitTargetBuffer0.nalLength;
        byte[] arr_b = new byte[nalUnitTargetBuffer1.nalLength + v + nalUnitTargetBuffer2.nalLength];
        System.arraycopy(nalUnitTargetBuffer0.nalData, 0, arr_b, 0, v);
        System.arraycopy(nalUnitTargetBuffer1.nalData, 0, arr_b, nalUnitTargetBuffer0.nalLength, nalUnitTargetBuffer1.nalLength);
        System.arraycopy(nalUnitTargetBuffer2.nalData, 0, arr_b, nalUnitTargetBuffer0.nalLength + nalUnitTargetBuffer1.nalLength, nalUnitTargetBuffer2.nalLength);
        ParsableNalUnitBitArray parsableNalUnitBitArray0 = new ParsableNalUnitBitArray(nalUnitTargetBuffer1.nalData, 0, nalUnitTargetBuffer1.nalLength);
        parsableNalUnitBitArray0.skipBits(44);
        int v2 = parsableNalUnitBitArray0.readBits(3);
        parsableNalUnitBitArray0.skipBit();
        parsableNalUnitBitArray0.skipBits(88);
        parsableNalUnitBitArray0.skipBits(8);
        int v4 = 0;
        for(int v3 = 0; v3 < v2; ++v3) {
            if(parsableNalUnitBitArray0.readBit()) {
                v4 += 89;
            }
            if(parsableNalUnitBitArray0.readBit()) {
                v4 += 8;
            }
        }
        parsableNalUnitBitArray0.skipBits(v4);
        if(v2 > 0) {
            parsableNalUnitBitArray0.skipBits((8 - v2) * 2);
        }
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        int v5 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        if(v5 == 3) {
            parsableNalUnitBitArray0.skipBit();
        }
        int v6 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        int v7 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        if(parsableNalUnitBitArray0.readBit()) {
            v6 -= (parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt() + parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt()) * (v5 == 1 || v5 == 2 ? 2 : 1);
            v7 -= (parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt() + parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt()) * (v5 == 1 ? 2 : 1);
        }
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        int v8 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        for(int v9 = parsableNalUnitBitArray0.readBit() ? 0 : v2; v9 <= v2; ++v9) {
            parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        }
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        if(parsableNalUnitBitArray0.readBit() && parsableNalUnitBitArray0.readBit()) {
            H265Reader.skipScalingList(parsableNalUnitBitArray0);
        }
        parsableNalUnitBitArray0.skipBits(2);
        if(parsableNalUnitBitArray0.readBit()) {
            parsableNalUnitBitArray0.skipBits(8);
            parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray0.skipBit();
        }
        H265Reader.skipShortTermRefPicSets(parsableNalUnitBitArray0);
        if(parsableNalUnitBitArray0.readBit()) {
            for(int v1 = 0; v1 < parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt(); ++v1) {
                parsableNalUnitBitArray0.skipBits(v8 + 5);
            }
        }
        parsableNalUnitBitArray0.skipBits(2);
        if(parsableNalUnitBitArray0.readBit() && parsableNalUnitBitArray0.readBit()) {
            int v10 = parsableNalUnitBitArray0.readBits(8);
            if(v10 == 0xFF) {
                int v11 = parsableNalUnitBitArray0.readBits(16);
                int v12 = parsableNalUnitBitArray0.readBits(16);
                return v11 == 0 || v12 == 0 ? Format.createVideoSampleFormat(s, "video/hevc", null, -1, -1, v6, v7, -1.0f, Collections.singletonList(arr_b), -1, 1.0f, null) : Format.createVideoSampleFormat(s, "video/hevc", null, -1, -1, v6, v7, -1.0f, Collections.singletonList(arr_b), -1, ((float)v11) / ((float)v12), null);
            }
            float[] arr_f = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
            if(v10 < arr_f.length) {
                float f = arr_f[v10];
                return Format.createVideoSampleFormat(s, "video/hevc", null, -1, -1, v6, v7, -1.0f, Collections.singletonList(arr_b), -1, f, null);
            }
            Z.q(46, v10, "Unexpected aspect_ratio_idc value: ", "H265Reader");
            return Format.createVideoSampleFormat(s, "video/hevc", null, -1, -1, v6, v7, -1.0f, Collections.singletonList(arr_b), -1, 1.0f, null);
        }
        return Format.createVideoSampleFormat(s, "video/hevc", null, -1, -1, v6, v7, -1.0f, Collections.singletonList(arr_b), -1, 1.0f, null);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.vps.reset();
        this.sps.reset();
        this.pps.reset();
        this.prefixSei.reset();
        this.suffixSei.reset();
        this.sampleReader.reset();
        this.totalBytesWritten = 0L;
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray0) {
        for(int v = 0; v < 4; ++v) {
            for(int v1 = 0; true; v1 += v2) {
                int v2 = 1;
                if(v1 >= 6) {
                    break;
                }
                if(parsableNalUnitBitArray0.readBit()) {
                    int v3 = Math.min(0x40, 1 << (v << 1) + 4);
                    if(v > 1) {
                        parsableNalUnitBitArray0.readSignedExpGolombCodedInt();
                    }
                    for(int v4 = 0; v4 < v3; ++v4) {
                        parsableNalUnitBitArray0.readSignedExpGolombCodedInt();
                    }
                }
                else {
                    parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
                }
                if(v == 3) {
                    v2 = 3;
                }
            }
        }
    }

    private static void skipShortTermRefPicSets(ParsableNalUnitBitArray parsableNalUnitBitArray0) {
        int v = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
        boolean z = false;
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            if(v1 != 0) {
                z = parsableNalUnitBitArray0.readBit();
            }
            if(z) {
                parsableNalUnitBitArray0.skipBit();
                parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
                for(int v3 = 0; v3 <= v2; ++v3) {
                    if(parsableNalUnitBitArray0.readBit()) {
                        parsableNalUnitBitArray0.skipBit();
                    }
                }
            }
            else {
                int v4 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
                int v5 = parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
                for(int v6 = 0; v6 < v4; ++v6) {
                    parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray0.skipBit();
                }
                for(int v7 = 0; v7 < v5; ++v7) {
                    parsableNalUnitBitArray0.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray0.skipBit();
                }
                v2 = v4 + v5;
            }
        }
    }

    private void startNalUnit(long v, int v1, int v2, long v3) {
        this.sampleReader.startNalUnit(v, v1, v2, v3, this.hasOutputFormat);
        if(!this.hasOutputFormat) {
            this.vps.startNalUnit(v2);
            this.sps.startNalUnit(v2);
            this.pps.startNalUnit(v2);
        }
        this.prefixSei.startNalUnit(v2);
        this.suffixSei.startNalUnit(v2);
    }
}

