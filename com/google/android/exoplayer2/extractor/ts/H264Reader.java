package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil.PpsData;
import com.google.android.exoplayer2.util.NalUnitUtil.SpsData;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.ArrayList;
import java.util.Arrays;

public final class H264Reader implements ElementaryStreamReader {
    static final class SampleReader {
        static final class SliceHeaderData {
            private static final int SLICE_TYPE_ALL_I = 7;
            private static final int SLICE_TYPE_I = 2;
            private boolean bottomFieldFlag;
            private boolean bottomFieldFlagPresent;
            private int deltaPicOrderCnt0;
            private int deltaPicOrderCnt1;
            private int deltaPicOrderCntBottom;
            private boolean fieldPicFlag;
            private int frameNum;
            private boolean hasSliceType;
            private boolean idrPicFlag;
            private int idrPicId;
            private boolean isComplete;
            private int nalRefIdc;
            private int picOrderCntLsb;
            private int picParameterSetId;
            private int sliceType;
            private SpsData spsData;

            private SliceHeaderData() {
            }

            public SliceHeaderData(com.google.android.exoplayer2.extractor.ts.H264Reader.1 h264Reader$10) {
            }

            public static boolean access$100(SliceHeaderData h264Reader$SampleReader$SliceHeaderData0, SliceHeaderData h264Reader$SampleReader$SliceHeaderData1) {
                return h264Reader$SampleReader$SliceHeaderData0.isFirstVclNalUnitOfPicture(h264Reader$SampleReader$SliceHeaderData1);
            }

            public void clear() {
                this.hasSliceType = false;
                this.isComplete = false;
            }

            private boolean isFirstVclNalUnitOfPicture(SliceHeaderData h264Reader$SampleReader$SliceHeaderData0) {
                if(this.isComplete) {
                    if(h264Reader$SampleReader$SliceHeaderData0.isComplete && this.frameNum == h264Reader$SampleReader$SliceHeaderData0.frameNum && this.picParameterSetId == h264Reader$SampleReader$SliceHeaderData0.picParameterSetId && this.fieldPicFlag == h264Reader$SampleReader$SliceHeaderData0.fieldPicFlag && (!this.bottomFieldFlagPresent || !h264Reader$SampleReader$SliceHeaderData0.bottomFieldFlagPresent || this.bottomFieldFlag == h264Reader$SampleReader$SliceHeaderData0.bottomFieldFlag) && (this.nalRefIdc == h264Reader$SampleReader$SliceHeaderData0.nalRefIdc || this.nalRefIdc != 0 && h264Reader$SampleReader$SliceHeaderData0.nalRefIdc != 0)) {
                        int v = this.spsData.picOrderCountType;
                        return v == 0 && h264Reader$SampleReader$SliceHeaderData0.spsData.picOrderCountType == 0 && (this.picOrderCntLsb != h264Reader$SampleReader$SliceHeaderData0.picOrderCntLsb || this.deltaPicOrderCntBottom != h264Reader$SampleReader$SliceHeaderData0.deltaPicOrderCntBottom) || v == 1 && h264Reader$SampleReader$SliceHeaderData0.spsData.picOrderCountType == 1 && (this.deltaPicOrderCnt0 != h264Reader$SampleReader$SliceHeaderData0.deltaPicOrderCnt0 || this.deltaPicOrderCnt1 != h264Reader$SampleReader$SliceHeaderData0.deltaPicOrderCnt1) || (this.idrPicFlag != h264Reader$SampleReader$SliceHeaderData0.idrPicFlag || this.idrPicFlag && h264Reader$SampleReader$SliceHeaderData0.idrPicFlag && this.idrPicId != h264Reader$SampleReader$SliceHeaderData0.idrPicId);
                    }
                    return true;
                }
                return false;
            }

            public boolean isISlice() {
                return this.hasSliceType && (this.sliceType == 2 || this.sliceType == 7);
            }

            public void setAll(SpsData nalUnitUtil$SpsData0, int v, int v1, int v2, int v3, boolean z, boolean z1, boolean z2, boolean z3, int v4, int v5, int v6, int v7, int v8) {
                this.spsData = nalUnitUtil$SpsData0;
                this.nalRefIdc = v;
                this.sliceType = v1;
                this.frameNum = v2;
                this.picParameterSetId = v3;
                this.fieldPicFlag = z;
                this.bottomFieldFlagPresent = z1;
                this.bottomFieldFlag = z2;
                this.idrPicFlag = z3;
                this.idrPicId = v4;
                this.picOrderCntLsb = v5;
                this.deltaPicOrderCntBottom = v6;
                this.deltaPicOrderCnt0 = v7;
                this.deltaPicOrderCnt1 = v8;
                this.isComplete = true;
                this.hasSliceType = true;
            }

            public void setSliceType(int v) {
                this.sliceType = v;
                this.hasSliceType = true;
            }
        }

        private static final int DEFAULT_BUFFER_SIZE = 0x80;
        private static final int NAL_UNIT_TYPE_AUD = 9;
        private static final int NAL_UNIT_TYPE_IDR = 5;
        private static final int NAL_UNIT_TYPE_NON_IDR = 1;
        private static final int NAL_UNIT_TYPE_PARTITION_A = 2;
        private final boolean allowNonIdrKeyframes;
        private final ParsableNalUnitBitArray bitArray;
        private byte[] buffer;
        private int bufferLength;
        private final boolean detectAccessUnits;
        private boolean isFilling;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private int nalUnitType;
        private final TrackOutput output;
        private final SparseArray pps;
        private SliceHeaderData previousSliceHeader;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private SliceHeaderData sliceHeader;
        private final SparseArray sps;

        public SampleReader(TrackOutput trackOutput0, boolean z, boolean z1) {
            this.output = trackOutput0;
            this.allowNonIdrKeyframes = z;
            this.detectAccessUnits = z1;
            this.sps = new SparseArray();
            this.pps = new SparseArray();
            this.previousSliceHeader = new SliceHeaderData(null);
            this.sliceHeader = new SliceHeaderData(null);
            byte[] arr_b = new byte[0x80];
            this.buffer = arr_b;
            this.bitArray = new ParsableNalUnitBitArray(arr_b, 0, 0);
            this.reset();
        }

        public void appendToNalUnit(byte[] arr_b, int v, int v1) {
            boolean z2;
            boolean z1;
            boolean z;
            int v9;
            int v15;
            int v14;
            int v13;
            int v12;
            if(this.isFilling) {
                int v2 = v1 - v;
                byte[] arr_b1 = this.buffer;
                int v3 = this.bufferLength;
                if(arr_b1.length < v3 + v2) {
                    this.buffer = Arrays.copyOf(arr_b1, (v3 + v2) * 2);
                }
                System.arraycopy(arr_b, v, this.buffer, this.bufferLength, v2);
                int v4 = this.bufferLength + v2;
                this.bufferLength = v4;
                this.bitArray.reset(this.buffer, 0, v4);
                if(this.bitArray.canReadBits(8)) {
                    this.bitArray.skipBit();
                    int v5 = this.bitArray.readBits(2);
                    this.bitArray.skipBits(5);
                    if(this.bitArray.canReadExpGolombCodedNum()) {
                        this.bitArray.readUnsignedExpGolombCodedInt();
                        if(this.bitArray.canReadExpGolombCodedNum()) {
                            int v6 = this.bitArray.readUnsignedExpGolombCodedInt();
                            if(!this.detectAccessUnits) {
                                this.isFilling = false;
                                this.sliceHeader.setSliceType(v6);
                                return;
                            }
                            if(this.bitArray.canReadExpGolombCodedNum()) {
                                int v7 = this.bitArray.readUnsignedExpGolombCodedInt();
                                if(this.pps.indexOfKey(v7) < 0) {
                                    this.isFilling = false;
                                    return;
                                }
                                PpsData nalUnitUtil$PpsData0 = (PpsData)this.pps.get(v7);
                                Object object0 = this.sps.get(nalUnitUtil$PpsData0.seqParameterSetId);
                                if(!((SpsData)object0).separateColorPlaneFlag) {
                                label_32:
                                    if(this.bitArray.canReadBits(((SpsData)object0).frameNumLength)) {
                                        int v8 = this.bitArray.readBits(((SpsData)object0).frameNumLength);
                                        if(((SpsData)object0).frameMbsOnlyFlag) {
                                            z = false;
                                            z1 = false;
                                            z2 = false;
                                        label_49:
                                            boolean z3 = this.nalUnitType == 5;
                                            if(!z3) {
                                                v9 = 0;
                                            label_55:
                                                int v10 = ((SpsData)object0).picOrderCountType;
                                                if(v10 != 0) {
                                                    if(v10 != 1 || ((SpsData)object0).deltaPicOrderAlwaysZeroFlag) {
                                                        goto label_85;
                                                    }
                                                    if(this.bitArray.canReadExpGolombCodedNum()) {
                                                        int v16 = this.bitArray.readSignedExpGolombCodedInt();
                                                        if(!nalUnitUtil$PpsData0.bottomFieldPicOrderInFramePresentFlag || z) {
                                                            v14 = v16;
                                                            v13 = 0;
                                                            v12 = 0;
                                                            v15 = 0;
                                                            this.sliceHeader.setAll(((SpsData)object0), v5, v6, v8, v7, z, z1, z2, z3, v9, v13, v12, v14, v15);
                                                            this.isFilling = false;
                                                            return;
                                                        label_85:
                                                            v13 = 0;
                                                            v12 = 0;
                                                            v14 = 0;
                                                            v15 = 0;
                                                            this.sliceHeader.setAll(((SpsData)object0), v5, v6, v8, v7, z, z1, z2, z3, v9, v13, v12, v14, v15);
                                                            this.isFilling = false;
                                                        }
                                                        else if(this.bitArray.canReadExpGolombCodedNum()) {
                                                            v15 = this.bitArray.readSignedExpGolombCodedInt();
                                                            v14 = v16;
                                                            v13 = 0;
                                                            v12 = 0;
                                                            this.sliceHeader.setAll(((SpsData)object0), v5, v6, v8, v7, z, z1, z2, z3, v9, v13, v12, v14, v15);
                                                            this.isFilling = false;
                                                        }
                                                    }
                                                }
                                                else if(this.bitArray.canReadBits(((SpsData)object0).picOrderCntLsbLength)) {
                                                    int v11 = this.bitArray.readBits(((SpsData)object0).picOrderCntLsbLength);
                                                    if(!nalUnitUtil$PpsData0.bottomFieldPicOrderInFramePresentFlag || z) {
                                                        v13 = v11;
                                                        v12 = 0;
                                                        v14 = 0;
                                                        v15 = 0;
                                                        this.sliceHeader.setAll(((SpsData)object0), v5, v6, v8, v7, z, z1, z2, z3, v9, v13, v12, v14, v15);
                                                        this.isFilling = false;
                                                    }
                                                    else if(this.bitArray.canReadExpGolombCodedNum()) {
                                                        v12 = this.bitArray.readSignedExpGolombCodedInt();
                                                        v13 = v11;
                                                        v14 = 0;
                                                        v15 = 0;
                                                        this.sliceHeader.setAll(((SpsData)object0), v5, v6, v8, v7, z, z1, z2, z3, v9, v13, v12, v14, v15);
                                                        this.isFilling = false;
                                                    }
                                                }
                                            }
                                            else if(this.bitArray.canReadExpGolombCodedNum()) {
                                                v9 = this.bitArray.readUnsignedExpGolombCodedInt();
                                                goto label_55;
                                            }
                                        }
                                        else if(this.bitArray.canReadBits(1)) {
                                            if(!this.bitArray.readBit()) {
                                                z = false;
                                                z1 = false;
                                                z2 = false;
                                                goto label_49;
                                            }
                                            else if(this.bitArray.canReadBits(1)) {
                                                z = true;
                                                z1 = true;
                                                z2 = this.bitArray.readBit();
                                                goto label_49;
                                            }
                                        }
                                    }
                                }
                                else if(this.bitArray.canReadBits(2)) {
                                    this.bitArray.skipBits(2);
                                    goto label_32;
                                }
                            }
                        }
                    }
                }
            }
        }

        public boolean endNalUnit(long v, int v1, boolean z, boolean z1) {
            boolean z2 = false;
            if(this.nalUnitType == 9 || this.detectAccessUnits && SliceHeaderData.access$100(this.sliceHeader, this.previousSliceHeader)) {
                if(z && this.readingSample) {
                    this.outputSample(v1 + ((int)(v - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.sampleIsKeyframe = false;
                this.readingSample = true;
            }
            if(this.allowNonIdrKeyframes) {
                z1 = this.sliceHeader.isISlice();
            }
            boolean z3 = this.sampleIsKeyframe;
            if(this.nalUnitType == 5 || z1 && this.nalUnitType == 1) {
                z2 = true;
            }
            boolean z4 = z3 | z2;
            this.sampleIsKeyframe = z4;
            return z4;
        }

        public boolean needsSpsPps() {
            return this.detectAccessUnits;
        }

        private void outputSample(int v) {
            this.output.sampleMetadata(this.sampleTimeUs, ((int)this.sampleIsKeyframe), ((int)(this.nalUnitStartPosition - this.samplePosition)), v, null);
        }

        public void putPps(PpsData nalUnitUtil$PpsData0) {
            this.pps.append(nalUnitUtil$PpsData0.picParameterSetId, nalUnitUtil$PpsData0);
        }

        public void putSps(SpsData nalUnitUtil$SpsData0) {
            this.sps.append(nalUnitUtil$SpsData0.seqParameterSetId, nalUnitUtil$SpsData0);
        }

        public void reset() {
            this.isFilling = false;
            this.readingSample = false;
            this.sliceHeader.clear();
        }

        public void startNalUnit(long v, int v1, long v2) {
            this.nalUnitType = v1;
            this.nalUnitTimeUs = v2;
            this.nalUnitStartPosition = v;
            if(this.allowNonIdrKeyframes && v1 == 1 || this.detectAccessUnits && (v1 == 1 || v1 == 5 || v1 == 2)) {
                SliceHeaderData h264Reader$SampleReader$SliceHeaderData0 = this.previousSliceHeader;
                this.previousSliceHeader = this.sliceHeader;
                this.sliceHeader = h264Reader$SampleReader$SliceHeaderData0;
                h264Reader$SampleReader$SliceHeaderData0.clear();
                this.bufferLength = 0;
                this.isFilling = true;
            }
        }
    }

    private static final int NAL_UNIT_TYPE_PPS = 8;
    private static final int NAL_UNIT_TYPE_SEI = 6;
    private static final int NAL_UNIT_TYPE_SPS = 7;
    private final boolean allowNonIdrKeyframes;
    private final boolean detectAccessUnits;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final NalUnitTargetBuffer pps;
    private final boolean[] prefixFlags;
    private boolean randomAccessIndicator;
    private SampleReader sampleReader;
    private final NalUnitTargetBuffer sei;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper;
    private final NalUnitTargetBuffer sps;
    private long totalBytesWritten;

    public H264Reader(SeiReader seiReader0, boolean z, boolean z1) {
        this.seiReader = seiReader0;
        this.allowNonIdrKeyframes = z;
        this.detectAccessUnits = z1;
        this.prefixFlags = new boolean[3];
        this.sps = new NalUnitTargetBuffer(7, 0x80);
        this.pps = new NalUnitTargetBuffer(8, 0x80);
        this.sei = new NalUnitTargetBuffer(6, 0x80);
        this.seiWrapper = new ParsableByteArray();
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        byte[] arr_b = parsableByteArray0.data;
        this.totalBytesWritten += (long)parsableByteArray0.bytesLeft();
        this.output.sampleData(parsableByteArray0, parsableByteArray0.bytesLeft());
        int v2;
        while((v2 = NalUnitUtil.findNalUnit(arr_b, v, v1, this.prefixFlags)) != v1) {
            int v3 = NalUnitUtil.getNalUnitType(arr_b, v2);
            int v4 = v2 - v;
            if(v4 > 0) {
                this.nalUnitData(arr_b, v, v2);
            }
            int v5 = v1 - v2;
            long v6 = this.totalBytesWritten - ((long)v5);
            this.endNalUnit(v6, v5, (v4 >= 0 ? 0 : -v4), this.pesTimeUs);
            this.startNalUnit(v6, v3, this.pesTimeUs);
            v = v2 + 3;
        }
        this.nalUnitData(arr_b, v, v1);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        tsPayloadReader$TrackIdGenerator0.generateNewId();
        this.formatId = tsPayloadReader$TrackIdGenerator0.getFormatId();
        TrackOutput trackOutput0 = extractorOutput0.track(tsPayloadReader$TrackIdGenerator0.getTrackId(), 2);
        this.output = trackOutput0;
        this.sampleReader = new SampleReader(trackOutput0, this.allowNonIdrKeyframes, this.detectAccessUnits);
        this.seiReader.createTracks(extractorOutput0, tsPayloadReader$TrackIdGenerator0);
    }

    private void endNalUnit(long v, int v1, int v2, long v3) {
        if(!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.endNalUnit(v2);
            this.pps.endNalUnit(v2);
            if(this.hasOutputFormat) {
                if(this.sps.isCompleted()) {
                    SpsData nalUnitUtil$SpsData1 = NalUnitUtil.parseSpsNalUnit(this.sps.nalData, 3, this.sps.nalLength);
                    this.sampleReader.putSps(nalUnitUtil$SpsData1);
                    this.sps.reset();
                }
                else if(this.pps.isCompleted()) {
                    PpsData nalUnitUtil$PpsData1 = NalUnitUtil.parsePpsNalUnit(this.pps.nalData, 3, this.pps.nalLength);
                    this.sampleReader.putPps(nalUnitUtil$PpsData1);
                    this.pps.reset();
                }
            }
            else if(this.sps.isCompleted() && this.pps.isCompleted()) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(Arrays.copyOf(this.sps.nalData, this.sps.nalLength));
                arrayList0.add(Arrays.copyOf(this.pps.nalData, this.pps.nalLength));
                SpsData nalUnitUtil$SpsData0 = NalUnitUtil.parseSpsNalUnit(this.sps.nalData, 3, this.sps.nalLength);
                PpsData nalUnitUtil$PpsData0 = NalUnitUtil.parsePpsNalUnit(this.pps.nalData, 3, this.pps.nalLength);
                this.output.format(Format.createVideoSampleFormat(this.formatId, "video/avc", CodecSpecificDataUtil.buildAvcCodecString(nalUnitUtil$SpsData0.profileIdc, nalUnitUtil$SpsData0.constraintsFlagsAndReservedZero2Bits, nalUnitUtil$SpsData0.levelIdc), -1, -1, nalUnitUtil$SpsData0.width, nalUnitUtil$SpsData0.height, -1.0f, arrayList0, -1, nalUnitUtil$SpsData0.pixelWidthAspectRatio, null));
                this.hasOutputFormat = true;
                this.sampleReader.putSps(nalUnitUtil$SpsData0);
                this.sampleReader.putPps(nalUnitUtil$PpsData0);
                this.sps.reset();
                this.pps.reset();
            }
        }
        if(this.sei.endNalUnit(v2)) {
            int v4 = NalUnitUtil.unescapeStream(this.sei.nalData, this.sei.nalLength);
            this.seiWrapper.reset(this.sei.nalData, v4);
            this.seiWrapper.setPosition(4);
            this.seiReader.consume(v3, this.seiWrapper);
        }
        if(this.sampleReader.endNalUnit(v, v1, this.hasOutputFormat, this.randomAccessIndicator)) {
            this.randomAccessIndicator = false;
        }
    }

    private void nalUnitData(byte[] arr_b, int v, int v1) {
        if(!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.appendToNalUnit(arr_b, v, v1);
            this.pps.appendToNalUnit(arr_b, v, v1);
        }
        this.sei.appendToNalUnit(arr_b, v, v1);
        this.sampleReader.appendToNalUnit(arr_b, v, v1);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long v, int v1) {
        this.pesTimeUs = v;
        this.randomAccessIndicator |= (v1 & 2) != 0;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.sps.reset();
        this.pps.reset();
        this.sei.reset();
        this.sampleReader.reset();
        this.totalBytesWritten = 0L;
        this.randomAccessIndicator = false;
    }

    private void startNalUnit(long v, int v1, long v2) {
        if(!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.startNalUnit(v1);
            this.pps.startNalUnit(v1);
        }
        this.sei.startNalUnit(v1);
        this.sampleReader.startNalUnit(v, v1, v2);
    }

    class com.google.android.exoplayer2.extractor.ts.H264Reader.1 {
    }

}

