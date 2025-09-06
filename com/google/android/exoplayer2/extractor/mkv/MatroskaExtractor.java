package com.google.android.exoplayer2.extractor.mkv;

import android.util.Pair;
import android.util.SparseArray;
import com.facebook.appevents.b;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
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
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.HevcConfig;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class MatroskaExtractor implements Extractor {
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    final class InnerEbmlProcessor implements EbmlProcessor {
        private InnerEbmlProcessor() {
        }

        public InnerEbmlProcessor(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.1 matroskaExtractor$10) {
        }

        @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void binaryElement(int v, int v1, ExtractorInput extractorInput0) {
            MatroskaExtractor.this.binaryElement(v, v1, extractorInput0);
        }

        @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void endMasterElement(int v) {
            MatroskaExtractor.this.endMasterElement(v);
        }

        @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void floatElement(int v, double f) {
            MatroskaExtractor.this.floatElement(v, f);
        }

        @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public int getElementType(int v) {
            return MatroskaExtractor.this.getElementType(v);
        }

        @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void integerElement(int v, long v1) {
            MatroskaExtractor.this.integerElement(v, v1);
        }

        @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public boolean isLevel1Element(int v) {
            return MatroskaExtractor.this.isLevel1Element(v);
        }

        @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void startMasterElement(int v, long v1, long v2) {
            MatroskaExtractor.this.startMasterElement(v, v1, v2);
        }

        @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlProcessor
        public void stringElement(int v, String s) {
            MatroskaExtractor.this.stringElement(v, s);
        }
    }

    static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        public int audioBitDepth;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        private String language;
        public int maxBlockAdditionId;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public String name;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public float projectionPosePitch;
        public float projectionPoseRoll;
        public float projectionPoseYaw;
        public int projectionType;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        private Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionType = -1;
            this.projectionPoseYaw = 0.0f;
            this.projectionPosePitch = 0.0f;
            this.projectionPoseRoll = 0.0f;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0L;
            this.seekPreRollNs = 0L;
            this.flagDefault = true;
            this.language = "eng";
        }

        public Track(com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.1 matroskaExtractor$10) {
        }

        public static String access$202(Track matroskaExtractor$Track0, String s) {
            matroskaExtractor$Track0.language = s;
            return s;
        }

        private byte[] getHdrStaticInfo() {
            if(this.primaryRChromaticityX != -1.0f && this.primaryRChromaticityY != -1.0f && this.primaryGChromaticityX != -1.0f && this.primaryGChromaticityY != -1.0f && this.primaryBChromaticityX != -1.0f && this.primaryBChromaticityY != -1.0f && this.whitePointChromaticityX != -1.0f && this.whitePointChromaticityY != -1.0f && this.maxMasteringLuminance != -1.0f && this.minMasteringLuminance != -1.0f) {
                byte[] arr_b = new byte[25];
                ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b).order(ByteOrder.LITTLE_ENDIAN);
                byteBuffer0.put(0);
                byteBuffer0.putShort(((short)(((int)(this.primaryRChromaticityX * 50000.0f + 0.5f)))));
                byteBuffer0.putShort(((short)(((int)(this.primaryRChromaticityY * 50000.0f + 0.5f)))));
                byteBuffer0.putShort(((short)(((int)(this.primaryGChromaticityX * 50000.0f + 0.5f)))));
                byteBuffer0.putShort(((short)(((int)(this.primaryGChromaticityY * 50000.0f + 0.5f)))));
                byteBuffer0.putShort(((short)(((int)(this.primaryBChromaticityX * 50000.0f + 0.5f)))));
                byteBuffer0.putShort(((short)(((int)(this.primaryBChromaticityY * 50000.0f + 0.5f)))));
                byteBuffer0.putShort(((short)(((int)(this.whitePointChromaticityX * 50000.0f + 0.5f)))));
                byteBuffer0.putShort(((short)(((int)(this.whitePointChromaticityY * 50000.0f + 0.5f)))));
                byteBuffer0.putShort(((short)(((int)(this.maxMasteringLuminance + 0.5f)))));
                byteBuffer0.putShort(((short)(((int)(this.minMasteringLuminance + 0.5f)))));
                byteBuffer0.putShort(((short)this.maxContentLuminance));
                byteBuffer0.putShort(((short)this.maxFrameAverageLuminance));
                return arr_b;
            }
            return null;
        }

        public void initializeOutput(ExtractorOutput extractorOutput0, int v) {
            int v10;
            ColorInfo colorInfo0;
            float f;
            int v7;
            Format format0;
            List list3;
            String s2;
            List list0;
            List list2;
            String s4;
            int v6;
            List list1;
            String s3;
            int v5;
            int v4;
            int v3;
            int v2;
            String s = this.codecId;
            s.getClass();
            int v1 = -1;
            switch(s) {
                case "A_AAC": {
                    v2 = 13;
                    break;
                }
                case "A_AC3": {
                    v2 = 14;
                    break;
                }
                case "A_DTS": {
                    v2 = 15;
                    break;
                }
                case "A_DTS/EXPRESS": {
                    v2 = 21;
                    break;
                }
                case "A_DTS/LOSSLESS": {
                    v2 = 12;
                    break;
                }
                case "A_EAC3": {
                    v2 = 27;
                    break;
                }
                case "A_FLAC": {
                    v2 = 28;
                    break;
                }
                case "A_MPEG/L2": {
                    v2 = 5;
                    break;
                }
                case "A_MPEG/L3": {
                    v2 = 6;
                    break;
                }
                case "A_MS/ACM": {
                    v2 = 2;
                    break;
                }
                case "A_OPUS": {
                    v2 = 29;
                    break;
                }
                case "A_PCM/INT/LIT": {
                    v2 = 22;
                    break;
                }
                case "A_TRUEHD": {
                    v2 = 3;
                    break;
                }
                case "A_VORBIS": {
                    v2 = 4;
                    break;
                }
                case "S_DVBSUB": {
                    v2 = 8;
                    break;
                }
                case "S_HDMV/PGS": {
                    v2 = 19;
                    break;
                }
                case "S_TEXT/ASS": {
                    v2 = 23;
                    break;
                }
                case "S_TEXT/UTF8": {
                    v2 = 25;
                    break;
                }
                case "S_VOBSUB": {
                    v2 = 11;
                    break;
                }
                case "V_AV1": {
                    v2 = 16;
                    break;
                }
                case "V_MPEG2": {
                    v2 = 26;
                    break;
                }
                case "V_MPEG4/ISO/AP": {
                    v2 = 0;
                    break;
                }
                case "V_MPEG4/ISO/ASP": {
                    v2 = 9;
                    break;
                }
                case "V_MPEG4/ISO/AVC": {
                    v2 = 10;
                    break;
                }
                case "V_MPEG4/ISO/SP": {
                    v2 = 1;
                    break;
                }
                case "V_MPEGH/ISO/HEVC": {
                    v2 = 24;
                    break;
                }
                case "V_MS/VFW/FOURCC": {
                    v2 = 7;
                    break;
                }
                case "V_THEORA": {
                    v2 = 20;
                    break;
                }
                case "V_VP8": {
                    v2 = 17;
                    break;
                }
                case "V_VP9": {
                    v2 = 18;
                    break;
                }
                default: {
                    v2 = -1;
                }
            }
            String s1 = "audio/raw";
            switch(v2) {
                case 2: {
                    if(Track.parseMsAcmCodecPrivate(new ParsableByteArray(this.codecPrivate))) {
                        v3 = Util.getPcmEncoding(this.audioBitDepth);
                        if(v3 == 0) {
                            Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                            s3 = "audio/x-unknown";
                            v4 = -1;
                            v5 = -1;
                        }
                        else {
                            v4 = v3;
                            v5 = -1;
                            s3 = s1;
                        }
                    }
                    else {
                        Log.w("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                        s3 = "audio/x-unknown";
                        v4 = -1;
                        v5 = -1;
                    }
                    list2 = null;
                    break;
                }
                case 3: {
                    this.trueHdSampleRechunker = new TrueHdSampleRechunker();
                    s1 = "audio/true-hd";
                    goto label_160;
                }
                case 4: {
                    list1 = Track.parseVorbisCodecPrivate(this.codecPrivate);
                    s2 = "audio/vorbis";
                    v6 = 0x2000;
                    goto label_179;
                }
                case 5: {
                    s4 = "audio/mpeg-L2";
                    goto label_92;
                }
                case 6: {
                    s4 = "audio/mpeg";
                label_92:
                    v4 = -1;
                    s3 = s4;
                    list2 = null;
                    v5 = 0x1000;
                    break;
                }
                case 7: {
                    Pair pair0 = Track.parseFourCcPrivate(new ParsableByteArray(this.codecPrivate));
                    s2 = (String)pair0.first;
                    list0 = (List)pair0.second;
                    list2 = list0;
                    v4 = -1;
                    v5 = -1;
                    s3 = s2;
                    break;
                }
                case 8: {
                    list2 = Collections.singletonList(new byte[]{this.codecPrivate[0], this.codecPrivate[1], this.codecPrivate[2], this.codecPrivate[3]});
                    v4 = -1;
                    v5 = -1;
                    s3 = "application/dvbsubs";
                    break;
                }
                case 0: 
                case 1: 
                case 9: {
                    list0 = this.codecPrivate == null ? null : Collections.singletonList(this.codecPrivate);
                    s2 = "video/mp4v-es";
                    list2 = list0;
                    v4 = -1;
                    v5 = -1;
                    s3 = s2;
                    break;
                }
                case 10: {
                    AvcConfig avcConfig0 = AvcConfig.parse(new ParsableByteArray(this.codecPrivate));
                    list3 = avcConfig0.initializationData;
                    this.nalUnitLengthFieldLength = avcConfig0.nalUnitLengthFieldLength;
                    s2 = "video/avc";
                    list2 = list3;
                    v4 = -1;
                    v5 = -1;
                    s3 = s2;
                    break;
                }
                case 11: {
                    list2 = Collections.singletonList(this.codecPrivate);
                    v4 = -1;
                    v5 = -1;
                    s3 = "application/vobsub";
                    break;
                }
                case 12: {
                    s1 = "audio/vnd.dts.hd";
                    goto label_160;
                }
                case 13: {
                    list0 = Collections.singletonList(this.codecPrivate);
                    s2 = "audio/mp4a-latm";
                    list2 = list0;
                    v4 = -1;
                    v5 = -1;
                    s3 = s2;
                    break;
                }
                case 14: {
                    s1 = "audio/ac3";
                    goto label_160;
                }
                case 16: {
                    s1 = "video/av01";
                    goto label_160;
                }
                case 17: {
                    s1 = "video/x-vnd.on2.vp8";
                    goto label_160;
                }
                case 18: {
                    s1 = "video/x-vnd.on2.vp9";
                    goto label_160;
                }
                case 19: {
                    v4 = -1;
                    v5 = -1;
                    s3 = "application/pgs";
                    list2 = null;
                    break;
                }
                case 20: {
                    s1 = "video/x-unknown";
                    goto label_160;
                }
                case 15: 
                case 21: {
                    s1 = "audio/vnd.dts";
                    goto label_160;
                }
                case 22: {
                    v3 = Util.getPcmEncoding(this.audioBitDepth);
                    if(v3 == 0) {
                        Log.w("MatroskaExtractor", "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        s3 = "audio/x-unknown";
                        v4 = -1;
                        v5 = -1;
                    }
                    else {
                        v4 = v3;
                        v5 = -1;
                        s3 = s1;
                    }
                    list2 = null;
                    break;
                }
                case 23: {
                    s3 = "text/x-ssa";
                    v4 = -1;
                    v5 = -1;
                    list2 = null;
                    break;
                }
                case 24: {
                    HevcConfig hevcConfig0 = HevcConfig.parse(new ParsableByteArray(this.codecPrivate));
                    list3 = hevcConfig0.initializationData;
                    this.nalUnitLengthFieldLength = hevcConfig0.nalUnitLengthFieldLength;
                    s2 = "video/hevc";
                    list2 = list3;
                    v4 = -1;
                    v5 = -1;
                    s3 = s2;
                    break;
                }
                case 25: {
                    s3 = "application/x-subrip";
                    v4 = -1;
                    v5 = -1;
                    list2 = null;
                    break;
                }
                case 26: {
                    s1 = "video/mpeg2";
                    goto label_160;
                }
                case 27: {
                    s1 = "audio/eac3";
                label_160:
                    v4 = -1;
                    v5 = -1;
                    s3 = s1;
                    list2 = null;
                    break;
                }
                case 28: {
                    list0 = Collections.singletonList(this.codecPrivate);
                    s2 = "audio/flac";
                    list2 = list0;
                    v4 = -1;
                    v5 = -1;
                    s3 = s2;
                    break;
                }
                case 29: {
                    list1 = new ArrayList(3);
                    ((ArrayList)list1).add(this.codecPrivate);
                    ByteBuffer byteBuffer0 = ByteBuffer.allocate(8);
                    ByteOrder byteOrder0 = ByteOrder.LITTLE_ENDIAN;
                    ((ArrayList)list1).add(byteBuffer0.order(byteOrder0).putLong(this.codecDelayNs).array());
                    ((ArrayList)list1).add(ByteBuffer.allocate(8).order(byteOrder0).putLong(this.seekPreRollNs).array());
                    s2 = "audio/opus";
                    v6 = 5760;
                label_179:
                    list2 = list1;
                    v5 = v6;
                    v4 = -1;
                    s3 = s2;
                    break;
                }
                default: {
                    throw new ParserException("Unrecognized codec identifier.");
                }
            }
            boolean z = this.flagDefault;
            if(MimeTypes.isAudio(s3)) {
                format0 = Format.createAudioSampleFormat(Integer.toString(v), s3, null, -1, v5, this.channelCount, this.sampleRate, v4, list2, this.drmInitData, z, this.language);
                v7 = 1;
            }
            else if(MimeTypes.isVideo(s3)) {
                if(this.displayUnit == 0) {
                    this.displayWidth = this.displayWidth == -1 ? this.width : this.displayWidth;
                    this.displayHeight = this.displayHeight == -1 ? this.height : this.displayHeight;
                }
                int v8 = this.displayWidth;
                if(v8 == -1) {
                    f = -1.0f;
                }
                else {
                    int v9 = this.displayHeight;
                    f = v9 == -1 ? -1.0f : ((float)(this.height * v8)) / ((float)(this.width * v9));
                }
                if(this.hasColorInfo) {
                    byte[] arr_b = this.getHdrStaticInfo();
                    colorInfo0 = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, arr_b);
                }
                else {
                    colorInfo0 = null;
                }
                if("htc_video_rotA-000".equals(this.name)) {
                    v1 = 0;
                }
                else if("htc_video_rotA-090".equals(this.name)) {
                    v1 = 90;
                }
                else if("htc_video_rotA-180".equals(this.name)) {
                    v1 = 180;
                }
                else if("htc_video_rotA-270".equals(this.name)) {
                    v1 = 270;
                }
                if(this.projectionType != 0 || Float.compare(this.projectionPoseYaw, 0.0f) != 0 || Float.compare(this.projectionPosePitch, 0.0f) != 0) {
                    v10 = v1;
                }
                else if(Float.compare(this.projectionPoseRoll, 0.0f) == 0) {
                    v10 = 0;
                }
                else if(Float.compare(this.projectionPosePitch, 90.0f) == 0) {
                    v10 = 90;
                }
                else if(Float.compare(this.projectionPosePitch, -180.0f) == 0 || Float.compare(this.projectionPosePitch, 180.0f) == 0) {
                    v10 = 180;
                }
                else if(Float.compare(this.projectionPosePitch, -90.0f) == 0) {
                    v10 = 270;
                }
                else {
                    v10 = v1;
                }
                format0 = Format.createVideoSampleFormat(Integer.toString(v), s3, null, -1, v5, this.width, this.height, -1.0f, list2, v10, f, this.projectionData, this.stereoMode, colorInfo0, this.drmInitData);
                v7 = 2;
            }
            else {
                if("application/x-subrip".equals(s3)) {
                    format0 = Format.createTextSampleFormat(Integer.toString(v), s3, z, this.language, this.drmInitData);
                }
                else if("text/x-ssa".equals(s3)) {
                    ArrayList arrayList0 = new ArrayList(2);
                    arrayList0.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                    arrayList0.add(this.codecPrivate);
                    format0 = Format.createTextSampleFormat(Integer.toString(v), s3, null, -1, z, this.language, -1, this.drmInitData, 0x7FFFFFFFFFFFFFFFL, arrayList0);
                }
                else {
                    if(!"application/vobsub".equals(s3) && !"application/pgs".equals(s3) && !"application/dvbsubs".equals(s3)) {
                        throw new ParserException("Unexpected MIME type.");
                    }
                    format0 = Format.createImageSampleFormat(Integer.toString(v), s3, null, -1, z, list2, this.language, this.drmInitData);
                }
                v7 = 3;
            }
            TrackOutput trackOutput0 = extractorOutput0.track(this.number, v7);
            this.output = trackOutput0;
            trackOutput0.format(format0);
        }

        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker matroskaExtractor$TrueHdSampleRechunker0 = this.trueHdSampleRechunker;
            if(matroskaExtractor$TrueHdSampleRechunker0 != null) {
                matroskaExtractor$TrueHdSampleRechunker0.outputPendingSampleMetadata(this);
            }
        }

        private static Pair parseFourCcPrivate(ParsableByteArray parsableByteArray0) {
            try {
                parsableByteArray0.skipBytes(16);
                long v = parsableByteArray0.readLittleEndianUnsignedInt();
                if(Long.compare(v, 1482049860L) == 0) {
                    return new Pair("video/divx", null);
                }
                if(v == 0x33363248L) {
                    return new Pair("video/3gpp", null);
                }
                if(v == 0x31435657L) {
                    int v1 = parsableByteArray0.getPosition() + 20;
                    byte[] arr_b = parsableByteArray0.data;
                    while(v1 < arr_b.length - 4) {
                        if(arr_b[v1] == 0 && arr_b[v1 + 1] == 0 && arr_b[v1 + 2] == 1 && arr_b[v1 + 3] == 15) {
                            return new Pair("video/wvc1", Collections.singletonList(Arrays.copyOfRange(arr_b, v1, arr_b.length)));
                        }
                        ++v1;
                    }
                    throw new ParserException("Failed to find FourCC VC1 initialization data");
                }
            }
            catch(ArrayIndexOutOfBoundsException unused_ex) {
                throw new ParserException("Error parsing FourCC private data");
            }
            Log.w("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
            return new Pair("video/x-unknown", null);
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray0) {
            try {
                int v = parsableByteArray0.readLittleEndianUnsignedShort();
                if(v == 1) {
                    return true;
                }
                if(v != 0xFFFE) {
                    return false;
                }
                parsableByteArray0.setPosition(24);
                return parsableByteArray0.readLong() != MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits() || parsableByteArray0.readLong() != MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits() ? false : true;
            }
            catch(ArrayIndexOutOfBoundsException unused_ex) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        private static List parseVorbisCodecPrivate(byte[] arr_b) {
            try {
                if(arr_b[0] != 2) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int v = 0;
                int v1 = 1;
                int v2;
                while((v2 = arr_b[v1]) == -1) {
                    v += 0xFF;
                    ++v1;
                }
                int v3 = v1 + 1;
                int v4 = v + v2;
                int v5 = 0;
                int v6;
                while((v6 = arr_b[v3]) == -1) {
                    v5 += 0xFF;
                    ++v3;
                }
                if(arr_b[v3 + 1] != 1) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] arr_b1 = new byte[v4];
                System.arraycopy(arr_b, v3 + 1, arr_b1, 0, v4);
                int v7 = v3 + 1 + v4;
                if(arr_b[v7] != 3) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                int v8 = v7 + (v5 + v6);
                if(arr_b[v8] != 5) {
                    throw new ParserException("Error parsing vorbis codec private");
                }
                byte[] arr_b2 = new byte[arr_b.length - v8];
                System.arraycopy(arr_b, v8, arr_b2, 0, arr_b.length - v8);
                List list0 = new ArrayList(2);
                ((ArrayList)list0).add(arr_b1);
                ((ArrayList)list0).add(arr_b2);
                return list0;
            }
            catch(ArrayIndexOutOfBoundsException unused_ex) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        public void reset() {
            TrueHdSampleRechunker matroskaExtractor$TrueHdSampleRechunker0 = this.trueHdSampleRechunker;
            if(matroskaExtractor$TrueHdSampleRechunker0 != null) {
                matroskaExtractor$TrueHdSampleRechunker0.reset();
            }
        }
    }

    static final class TrueHdSampleRechunker {
        private int chunkFlags;
        private int chunkOffset;
        private int chunkSampleCount;
        private int chunkSize;
        private long chunkTimeUs;
        private boolean foundSyncframe;
        private final byte[] syncframePrefix;

        public TrueHdSampleRechunker() {
            this.syncframePrefix = new byte[10];
        }

        public void outputPendingSampleMetadata(Track matroskaExtractor$Track0) {
            if(this.chunkSampleCount > 0) {
                matroskaExtractor$Track0.output.sampleMetadata(this.chunkTimeUs, this.chunkFlags, this.chunkSize, this.chunkOffset, matroskaExtractor$Track0.cryptoData);
                this.chunkSampleCount = 0;
            }
        }

        public void reset() {
            this.foundSyncframe = false;
            this.chunkSampleCount = 0;
        }

        public void sampleMetadata(Track matroskaExtractor$Track0, long v, int v1, int v2, int v3) {
            if(this.foundSyncframe) {
                int v4 = this.chunkSampleCount;
                this.chunkSampleCount = v4 + 1;
                if(v4 == 0) {
                    this.chunkTimeUs = v;
                    this.chunkFlags = v1;
                    this.chunkSize = 0;
                }
                this.chunkSize += v2;
                this.chunkOffset = v3;
                if(v4 + 1 >= 16) {
                    this.outputPendingSampleMetadata(matroskaExtractor$Track0);
                }
            }
        }

        public void startSample(ExtractorInput extractorInput0) {
            if(!this.foundSyncframe) {
                extractorInput0.peekFully(this.syncframePrefix, 0, 10);
                extractorInput0.resetPeekPosition();
                if(Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) != 0) {
                    this.foundSyncframe = true;
                }
            }
        }
    }

    private static final int BLOCK_ADDITIONAL_ID_VP9_ITU_T_35 = 4;
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_AV1 = "V_AV1";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final ExtractorsFactory FACTORY = null;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_DIVX = 1482049860;
    private static final int FOURCC_COMPRESSION_H263 = 0x33363248;
    private static final int FOURCC_COMPRESSION_VC1 = 0x31435657;
    private static final int ID_AUDIO = 0xE1;
    private static final int ID_AUDIO_BIT_DEPTH = 0x6264;
    private static final int ID_BLOCK = 0xA1;
    private static final int ID_BLOCK_ADDITIONAL = 0xA5;
    private static final int ID_BLOCK_ADDITIONS = 30113;
    private static final int ID_BLOCK_ADD_ID = 0xEE;
    private static final int ID_BLOCK_DURATION = 0x9B;
    private static final int ID_BLOCK_GROUP = 0xA0;
    private static final int ID_BLOCK_MORE = 0xA6;
    private static final int ID_CHANNELS = 0x9F;
    private static final int ID_CLUSTER = 0x1F43B675;
    private static final int ID_CODEC_DELAY = 0x56AA;
    private static final int ID_CODEC_ID = 0x86;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 0x55B0;
    private static final int ID_COLOUR_PRIMARIES = 0x55BB;
    private static final int ID_COLOUR_RANGE = 0x55B9;
    private static final int ID_COLOUR_TRANSFER = 0x55BA;
    private static final int ID_CONTENT_COMPRESSION = 0x5034;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 0x4255;
    private static final int ID_CONTENT_ENCODING = 0x6240;
    private static final int ID_CONTENT_ENCODINGS = 0x6D80;
    private static final int ID_CONTENT_ENCODING_ORDER = 0x5031;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 0x5035;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 0x1C53BB6B;
    private static final int ID_CUE_CLUSTER_POSITION = 0xF1;
    private static final int ID_CUE_POINT = 0xBB;
    private static final int ID_CUE_TIME = 0xB3;
    private static final int ID_CUE_TRACK_POSITIONS = 0xB7;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 0x54B2;
    private static final int ID_DISPLAY_WIDTH = 0x54B0;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 0x4489;
    private static final int ID_EBML = 0x1A45DFA3;
    private static final int ID_EBML_READ_VERSION = 0x42F7;
    private static final int ID_FLAG_DEFAULT = 0x88;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 0x22B59C;
    private static final int ID_LUMNINANCE_MAX = 0x55D9;
    private static final int ID_LUMNINANCE_MIN = 0x55DA;
    private static final int ID_MASTERING_METADATA = 0x55D0;
    private static final int ID_MAX_BLOCK_ADDITION_ID = 0x55EE;
    private static final int ID_MAX_CLL = 0x55BC;
    private static final int ID_MAX_FALL = 0x55BD;
    private static final int ID_NAME = 0x536E;
    private static final int ID_PIXEL_HEIGHT = 0xBA;
    private static final int ID_PIXEL_WIDTH = 0xB0;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 0x55D5;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 0x55D6;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 0x55D3;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 0x55D4;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 0x55D1;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_POSE_PITCH = 30324;
    private static final int ID_PROJECTION_POSE_ROLL = 30325;
    private static final int ID_PROJECTION_POSE_YAW = 30323;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_PROJECTION_TYPE = 30321;
    private static final int ID_REFERENCE_BLOCK = 0xFB;
    private static final int ID_SAMPLING_FREQUENCY = 0xB5;
    private static final int ID_SEEK = 0x4DBB;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 0x53AB;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 0x18538067;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 0xA3;
    private static final int ID_STEREO_MODE = 0x53B8;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 0xE7;
    private static final int ID_TRACKS = 0x1654AE6B;
    private static final int ID_TRACK_ENTRY = 0xAE;
    private static final int ID_TRACK_NUMBER = 0xD7;
    private static final int ID_TRACK_TYPE = 0x83;
    private static final int ID_VIDEO = 0xE0;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 0x55D7;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 0x55D8;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final byte[] SSA_DIALOGUE_FORMAT = null;
    private static final byte[] SSA_PREFIX = null;
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000L;
    private static final byte[] SUBRIP_PREFIX = null;
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000L;
    private static final String TAG = "MatroskaExtractor";
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 0x2000;
    private static final int WAVE_FORMAT_EXTENSIBLE = 0xFFFE;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    private static final UUID WAVE_SUBFORMAT_PCM;
    private final ParsableByteArray blockAdditionalData;
    private int blockAdditionalId;
    private long blockDurationUs;
    private int blockFlags;
    private boolean blockHasReferenceBlock;
    private int blockSampleCount;
    private int blockSampleIndex;
    private int[] blockSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private boolean haveOutputSample;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;

    static {
        MatroskaExtractor.FACTORY = new b(15);
        MatroskaExtractor.SUBRIP_PREFIX = new byte[]{49, 10, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 44, 0x30, 0x30, 0x30, 0x20, 45, 45, 62, 0x20, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 44, 0x30, 0x30, 0x30, 10};
        MatroskaExtractor.SSA_DIALOGUE_FORMAT = new byte[]{70, 0x6F, 0x72, 109, 97, 0x74, 58, 0x20, 83, 0x74, 97, 0x72, 0x74, 44, 0x20, 69, 110, 100, 44, 0x20, 82, 101, 97, 100, 0x4F, 0x72, 100, 101, 0x72, 44, 0x20, 76, 97, 0x79, 101, 0x72, 44, 0x20, 83, 0x74, 0x79, 108, 101, 44, 0x20, 78, 97, 109, 101, 44, 0x20, 77, 97, 0x72, 103, 105, 110, 76, 44, 0x20, 77, 97, 0x72, 103, 105, 110, 82, 44, 0x20, 77, 97, 0x72, 103, 105, 110, 86, 44, 0x20, 69, 102, 102, 101, 99, 0x74, 44, 0x20, 84, 101, 120, 0x74};
        MatroskaExtractor.SSA_PREFIX = new byte[]{68, 105, 97, 108, 0x6F, 103, 0x75, 101, 58, 0x20, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 44, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 58, 0x30, 0x30, 44};
        MatroskaExtractor.WAVE_SUBFORMAT_PCM = new UUID(0x100000000001000L, 0x800000AA00389B71L);
    }

    public MatroskaExtractor() {
        this(0);
    }

    public MatroskaExtractor(int v) {
        this(new DefaultEbmlReader(), v);
    }

    public MatroskaExtractor(EbmlReader ebmlReader0, int v) {
        this.segmentContentPosition = -1L;
        this.timecodeScale = 0x8000000000000001L;
        this.durationTimecode = 0x8000000000000001L;
        this.durationUs = 0x8000000000000001L;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = 0x8000000000000001L;
        this.reader = ebmlReader0;
        ebmlReader0.init(new InnerEbmlProcessor(this, null));
        this.seekForCuesEnabled = (v & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
        this.blockAdditionalData = new ParsableByteArray();
    }

    public static Extractor[] a() {
        return MatroskaExtractor.lambda$static$0();
    }

    public void binaryElement(int v, int v1, ExtractorInput extractorInput0) {
        long v15;
        int v12;
        int v9;
        int v7;
        if(v == 0xA1 || v == 0xA3) {
            if(this.blockState == 0) {
                this.blockTrackNumber = (int)this.varintReader.readUnsignedVarint(extractorInput0, false, true, 8);
                this.blockTrackNumberLength = this.varintReader.getLastLength();
                this.blockDurationUs = 0x8000000000000001L;
                this.blockState = 1;
                this.scratch.reset();
            }
            Track matroskaExtractor$Track4 = (Track)this.tracks.get(this.blockTrackNumber);
            if(matroskaExtractor$Track4 == null) {
                extractorInput0.skipFully(v1 - this.blockTrackNumberLength);
                this.blockState = 0;
                return;
            }
            if(this.blockState == 1) {
                this.readScratch(extractorInput0, 3);
                int v2 = (this.scratch.data[2] & 6) >> 1;
                if(v2 == 0) {
                    this.blockSampleCount = 1;
                    int[] arr_v = MatroskaExtractor.ensureArrayCapacity(this.blockSampleSizes, 1);
                    this.blockSampleSizes = arr_v;
                    arr_v[0] = v1 - this.blockTrackNumberLength - 3;
                    goto label_121;
                }
                else {
                    int v3 = 4;
                    this.readScratch(extractorInput0, 4);
                    int v4 = (this.scratch.data[3] & 0xFF) + 1;
                    this.blockSampleCount = v4;
                    int[] arr_v1 = MatroskaExtractor.ensureArrayCapacity(this.blockSampleSizes, v4);
                    this.blockSampleSizes = arr_v1;
                    if(v2 == 2) {
                        Arrays.fill(arr_v1, 0, this.blockSampleCount, (v1 - this.blockTrackNumberLength - 4) / this.blockSampleCount);
                        goto label_121;
                    }
                    else if(v2 == 1) {
                        int v5 = 0;
                        int v6 = 0;
                        while(true) {
                            v7 = this.blockSampleCount;
                            if(v5 >= v7 - 1) {
                                break;
                            }
                            this.blockSampleSizes[v5] = 0;
                            while(true) {
                                this.readScratch(extractorInput0, v3 + 1);
                                int v8 = this.scratch.data[v3] & 0xFF;
                                int[] arr_v2 = this.blockSampleSizes;
                                v9 = arr_v2[v5] + v8;
                                arr_v2[v5] = v9;
                                if(v8 != 0xFF) {
                                    break;
                                }
                                ++v3;
                            }
                            v6 += v9;
                            ++v5;
                            ++v3;
                        }
                        this.blockSampleSizes[v7 - 1] = v1 - this.blockTrackNumberLength - v3 - v6;
                        goto label_121;
                    }
                    else {
                        if(v2 != 3) {
                            throw new ParserException("Unexpected lacing value: " + v2);
                        }
                        int v10 = 0;
                        int v11 = 0;
                        while(true) {
                            v12 = this.blockSampleCount;
                            if(v10 >= v12 - 1) {
                                goto label_120;
                            }
                            this.blockSampleSizes[v10] = 0;
                            int v13 = v3 + 1;
                            this.readScratch(extractorInput0, v13);
                            if(this.scratch.data[v3] == 0) {
                                throw new ParserException("No valid varint length mask found");
                            }
                            int v14 = 0;
                            while(true) {
                                v15 = 0L;
                                if(v14 < 8) {
                                    int v16 = 1 << 7 - v14;
                                    if((this.scratch.data[v3] & v16) == 0) {
                                        ++v14;
                                        continue;
                                    }
                                    else {
                                        v13 += v14;
                                        this.readScratch(extractorInput0, v13);
                                        v15 = (long)(this.scratch.data[v3] & 0xFF & ~v16);
                                        for(int v17 = v3 + 1; v17 < v13; ++v17) {
                                            v15 = v15 << 8 | ((long)(this.scratch.data[v17] & 0xFF));
                                        }
                                        if(v10 > 0) {
                                            v15 -= (1L << v14 * 7 + 6) - 1L;
                                        }
                                    }
                                }
                                break;
                            }
                            v3 = v13;
                            if(v15 < 0xFFFFFFFF80000000L || v15 > 0x7FFFFFFFL) {
                                break;
                            }
                            int v18 = (int)v15;
                            int[] arr_v3 = this.blockSampleSizes;
                            if(v10 != 0) {
                                v18 += arr_v3[v10 - 1];
                            }
                            arr_v3[v10] = v18;
                            v11 += v18;
                            ++v10;
                        }
                        throw new ParserException("EBML lacing sample size out of range.");
                    label_120:
                        this.blockSampleSizes[v12 - 1] = v1 - this.blockTrackNumberLength - v3 - v11;
                    label_121:
                        byte[] arr_b4 = this.scratch.data;
                        this.blockTimeUs = this.clusterTimecodeUs + this.scaleTimecodeToUs(((long)(arr_b4[1] & 0xFF | arr_b4[0] << 8)));
                        int v19 = this.scratch.data[2];
                        this.blockFlags = (matroskaExtractor$Track4.type == 2 || v == 0xA3 && (v19 & 0x80) == 0x80 ? 1 : 0) | ((v19 & 8) == 8 ? 0 : 0x80000000);
                        this.blockState = 2;
                        this.blockSampleIndex = 0;
                    }
                }
            }
            if(v == 0xA3) {
                int v20;
                while((v20 = this.blockSampleIndex) < this.blockSampleCount) {
                    int v21 = this.writeSampleData(extractorInput0, matroskaExtractor$Track4, this.blockSampleSizes[v20]);
                    this.commitSampleToOutput(matroskaExtractor$Track4, this.blockTimeUs + ((long)(this.blockSampleIndex * matroskaExtractor$Track4.defaultSampleDurationNs / 1000)), this.blockFlags, v21, 0);
                    ++this.blockSampleIndex;
                }
                this.blockState = 0;
                return;
            }
            int v22;
            while((v22 = this.blockSampleIndex) < this.blockSampleCount) {
                int[] arr_v4 = this.blockSampleSizes;
                arr_v4[v22] = this.writeSampleData(extractorInput0, matroskaExtractor$Track4, arr_v4[v22]);
                ++this.blockSampleIndex;
            }
        }
        else {
            switch(v) {
                case 0xA5: {
                    goto label_28;
                }
                case 0x4255: {
                    goto label_23;
                }
                case 18402: {
                    goto label_18;
                }
                case 0x53AB: {
                    goto label_13;
                }
                case 25506: {
                    goto label_8;
                }
                case 30322: {
                    goto label_3;
                }
            }
            throw new ParserException("Unexpected id: " + v);
        label_3:
            Track matroskaExtractor$Track0 = this.currentTrack;
            byte[] arr_b = new byte[v1];
            matroskaExtractor$Track0.projectionData = arr_b;
            extractorInput0.readFully(arr_b, 0, v1);
            return;
        label_8:
            Track matroskaExtractor$Track1 = this.currentTrack;
            byte[] arr_b1 = new byte[v1];
            matroskaExtractor$Track1.codecPrivate = arr_b1;
            extractorInput0.readFully(arr_b1, 0, v1);
            return;
        label_13:
            Arrays.fill(this.seekEntryIdBytes.data, 0);
            extractorInput0.readFully(this.seekEntryIdBytes.data, 4 - v1, v1);
            this.seekEntryIdBytes.setPosition(0);
            this.seekEntryId = (int)this.seekEntryIdBytes.readUnsignedInt();
            return;
        label_18:
            byte[] arr_b2 = new byte[v1];
            extractorInput0.readFully(arr_b2, 0, v1);
            Track matroskaExtractor$Track2 = this.currentTrack;
            matroskaExtractor$Track2.cryptoData = new CryptoData(1, arr_b2, 0, 0);
            return;
        label_23:
            Track matroskaExtractor$Track3 = this.currentTrack;
            byte[] arr_b3 = new byte[v1];
            matroskaExtractor$Track3.sampleStrippedBytes = arr_b3;
            extractorInput0.readFully(arr_b3, 0, v1);
            return;
        label_28:
            if(this.blockState == 2) {
                this.handleBlockAdditionalData(((Track)this.tracks.get(this.blockTrackNumber)), this.blockAdditionalId, extractorInput0, v1);
            }
        }
    }

    private SeekMap buildSeekMap() {
        if(Long.compare(this.segmentContentPosition, -1L) != 0 && this.durationUs != 0x8000000000000001L && (this.cueTimesUs != null && this.cueTimesUs.size() != 0) && (this.cueClusterPositions != null && this.cueClusterPositions.size() == this.cueTimesUs.size())) {
            int v = this.cueTimesUs.size();
            int[] arr_v = new int[v];
            long[] arr_v1 = new long[v];
            long[] arr_v2 = new long[v];
            long[] arr_v3 = new long[v];
            for(int v2 = 0; v2 < v; ++v2) {
                arr_v3[v2] = this.cueTimesUs.get(v2);
                long v3 = this.segmentContentPosition;
                arr_v1[v2] = this.cueClusterPositions.get(v2) + v3;
            }
            for(int v1 = 0; v1 < v - 1; ++v1) {
                arr_v[v1] = (int)(arr_v1[v1 + 1] - arr_v1[v1]);
                arr_v2[v1] = arr_v3[v1 + 1] - arr_v3[v1];
            }
            arr_v[v - 1] = (int)(this.segmentContentPosition + this.segmentContentSize - arr_v1[v - 1]);
            long v4 = this.durationUs - arr_v3[v - 1];
            arr_v2[v - 1] = v4;
            if(v4 <= 0L) {
                Log.w("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + v4);
                arr_v = Arrays.copyOf(arr_v, v - 1);
                arr_v1 = Arrays.copyOf(arr_v1, v - 1);
                arr_v2 = Arrays.copyOf(arr_v2, v - 1);
                arr_v3 = Arrays.copyOf(arr_v3, v - 1);
            }
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
            return new ChunkIndex(arr_v, arr_v1, arr_v2, arr_v3);
        }
        this.cueTimesUs = null;
        this.cueClusterPositions = null;
        return new Unseekable(this.durationUs);
    }

    private void commitSampleToOutput(Track matroskaExtractor$Track0, long v, int v1, int v2, int v3) {
        int v6;
        int v4;
        TrueHdSampleRechunker matroskaExtractor$TrueHdSampleRechunker0 = matroskaExtractor$Track0.trueHdSampleRechunker;
        if(matroskaExtractor$TrueHdSampleRechunker0 == null) {
            if(!"S_TEXT/UTF8".equals(matroskaExtractor$Track0.codecId) && !"S_TEXT/ASS".equals(matroskaExtractor$Track0.codecId)) {
                v4 = v2;
            }
            else if(this.blockSampleCount > 1) {
                Log.w("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                v4 = v2;
            }
            else {
                long v5 = this.blockDurationUs;
                if(v5 == 0x8000000000000001L) {
                    Log.w("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    v4 = v2;
                }
                else {
                    MatroskaExtractor.setSubtitleEndTime(matroskaExtractor$Track0.codecId, v5, this.subtitleSample.data);
                    matroskaExtractor$Track0.output.sampleData(this.subtitleSample, this.subtitleSample.limit());
                    v4 = this.subtitleSample.limit() + v2;
                }
            }
            if((0x10000000 & v1) == 0) {
                v6 = v1;
            }
            else if(this.blockSampleCount > 1) {
                v6 = v1 & 0xEFFFFFFF;
            }
            else {
                int v7 = this.blockAdditionalData.limit();
                matroskaExtractor$Track0.output.sampleData(this.blockAdditionalData, v7);
                v4 += v7;
                v6 = v1;
            }
            matroskaExtractor$Track0.output.sampleMetadata(v, v6, v4, v3, matroskaExtractor$Track0.cryptoData);
        }
        else {
            matroskaExtractor$TrueHdSampleRechunker0.sampleMetadata(matroskaExtractor$Track0, v, v1, v2, v3);
        }
        this.haveOutputSample = true;
    }

    public void endMasterElement(int v) {
        switch(v) {
            case 0xA0: {
                if(this.blockState == 2) {
                    int v2 = 0;
                    for(int v1 = 0; v1 < this.blockSampleCount; ++v1) {
                        v2 += this.blockSampleSizes[v1];
                    }
                    Object object0 = this.tracks.get(this.blockTrackNumber);
                    int v3 = 0;
                    while(v3 < this.blockSampleCount) {
                        long v4 = this.blockTimeUs + ((long)(((Track)object0).defaultSampleDurationNs * v3 / 1000));
                        int v5 = v3 != 0 || this.blockHasReferenceBlock ? this.blockFlags : this.blockFlags | 1;
                        int v6 = this.blockSampleSizes[v3];
                        int v7 = v2 - v6;
                        this.commitSampleToOutput(((Track)object0), v4, v5, v6, v7);
                        ++v3;
                        v2 = v7;
                    }
                    this.blockState = 0;
                    return;
                }
                break;
            }
            case 0xAE: {
                if(MatroskaExtractor.isCodecSupported(this.currentTrack.codecId)) {
                    this.currentTrack.initializeOutput(this.extractorOutput, this.currentTrack.number);
                    this.tracks.put(this.currentTrack.number, this.currentTrack);
                }
                this.currentTrack = null;
                return;
            }
            case 0x4DBB: {
                int v8 = this.seekEntryId;
                if(v8 == -1) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
                long v9 = this.seekEntryPosition;
                if(v9 == -1L) {
                    throw new ParserException("Mandatory element SeekID or SeekPosition not found");
                }
                if(v8 == 0x1C53BB6B) {
                    this.cuesContentPosition = v9;
                    return;
                }
                break;
            }
            case 0x6240: {
                Track matroskaExtractor$Track0 = this.currentTrack;
                if(matroskaExtractor$Track0.hasContentEncryption) {
                    if(matroskaExtractor$Track0.cryptoData == null) {
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    matroskaExtractor$Track0.drmInitData = new DrmInitData(new SchemeData[]{new SchemeData(C.UUID_NIL, "video/webm", this.currentTrack.cryptoData.encryptionKey)});
                    return;
                }
                break;
            }
            case 0x6D80: {
                if(this.currentTrack.hasContentEncryption && this.currentTrack.sampleStrippedBytes != null) {
                    throw new ParserException("Combining encryption and compression is not supported");
                }
                break;
            }
            case 357149030: {
                if(this.timecodeScale == 0x8000000000000001L) {
                    this.timecodeScale = 1000000L;
                }
                long v10 = this.durationTimecode;
                if(v10 != 0x8000000000000001L) {
                    this.durationUs = this.scaleTimecodeToUs(v10);
                    return;
                }
                break;
            }
            case 0x1654AE6B: {
                if(this.tracks.size() == 0) {
                    throw new ParserException("No valid tracks were found");
                }
                this.extractorOutput.endTracks();
                return;
            }
            case 0x1C53BB6B: {
                if(!this.sentSeekMap) {
                    this.extractorOutput.seekMap(this.buildSeekMap());
                    this.sentSeekMap = true;
                    return;
                }
                break;
            }
        }
    }

    private static int[] ensureArrayCapacity(int[] arr_v, int v) {
        if(arr_v == null) {
            return new int[v];
        }
        return arr_v.length < v ? new int[Math.max(arr_v.length * 2, v)] : arr_v;
    }

    private int finishWriteSampleData() {
        int v = this.sampleBytesWritten;
        this.resetWriteSampleData();
        return v;
    }

    public void floatElement(int v, double f) {
        switch(v) {
            case 0xB5: {
                this.currentTrack.sampleRate = (int)f;
                return;
            }
            case 0x4489: {
                this.durationTimecode = (long)f;
                return;
            }
            case 0x55D1: {
                this.currentTrack.primaryRChromaticityX = (float)f;
                return;
            }
            case 21970: {
                this.currentTrack.primaryRChromaticityY = (float)f;
                return;
            }
            case 0x55D3: {
                this.currentTrack.primaryGChromaticityX = (float)f;
                return;
            }
            case 0x55D4: {
                this.currentTrack.primaryGChromaticityY = (float)f;
                return;
            }
            case 0x55D5: {
                this.currentTrack.primaryBChromaticityX = (float)f;
                return;
            }
            case 0x55D6: {
                this.currentTrack.primaryBChromaticityY = (float)f;
                return;
            }
            case 0x55D7: {
                this.currentTrack.whitePointChromaticityX = (float)f;
                return;
            }
            case 0x55D8: {
                this.currentTrack.whitePointChromaticityY = (float)f;
                return;
            }
            case 0x55D9: {
                this.currentTrack.maxMasteringLuminance = (float)f;
                return;
            }
            case 0x55DA: {
                this.currentTrack.minMasteringLuminance = (float)f;
                return;
            }
            case 30323: {
                this.currentTrack.projectionPoseYaw = (float)f;
                return;
            }
            case 30324: {
                this.currentTrack.projectionPosePitch = (float)f;
                return;
            }
            case 30325: {
                this.currentTrack.projectionPoseRoll = (float)f;
            }
        }
    }

    private static byte[] formatSubtitleTimecode(long v, String s, long v1) {
        Assertions.checkArgument(v != 0x8000000000000001L);
        long v2 = v - ((long)(((int)(v / 3600000000L)) * 3600)) * 1000000L;
        long v3 = v2 - ((long)(((int)(v2 / 60000000L)) * 60)) * 1000000L;
        return Util.getUtf8Bytes(String.format(Locale.US, s, ((int)(v / 3600000000L)), ((int)(v2 / 60000000L)), ((int)(v3 / 1000000L)), ((int)((v3 - ((long)(((int)(v3 / 1000000L)))) * 1000000L) / v1))));
    }

    public int getElementType(int v) {
        switch(v) {
            case 0xA1: 
            case 0xA3: 
            case 0xA5: 
            case 0x4255: 
            case 18402: 
            case 0x53AB: 
            case 25506: 
            case 30322: {
                return 4;
            }
            case 0xB5: 
            case 0x4489: 
            case 0x55D1: 
            case 21970: 
            case 0x55D3: 
            case 0x55D4: 
            case 0x55D5: 
            case 0x55D6: 
            case 0x55D7: 
            case 0x55D8: 
            case 0x55D9: 
            case 0x55DA: 
            case 30323: 
            case 30324: 
            case 30325: {
                return 5;
            }
            case 0x86: 
            case 17026: 
            case 0x536E: 
            case 0x22B59C: {
                return 3;
            }
            case 0x83: 
            case 0x88: 
            case 0x9B: 
            case 0x9F: 
            case 0xB0: 
            case 0xB3: 
            case 0xBA: 
            case 0xD7: 
            case 0xE7: 
            case 0xEE: 
            case 0xF1: 
            case 0xFB: 
            case 16980: 
            case 17029: 
            case 0x42F7: 
            case 18401: 
            case 18408: 
            case 0x5031: 
            case 20530: 
            case 21420: 
            case 0x53B8: 
            case 0x54B0: 
            case 0x54B2: 
            case 21690: 
            case 21930: 
            case 0x55B9: 
            case 0x55BA: 
            case 0x55BB: 
            case 0x55BC: 
            case 0x55BD: 
            case 0x55EE: 
            case 0x56AA: 
            case 22203: 
            case 0x6264: 
            case 30321: 
            case 2352003: 
            case 2807729: {
                return 2;
            }
            case 0xA0: 
            case 0xA6: 
            case 0xAE: 
            case 0xB7: 
            case 0xBB: 
            case 0xE0: 
            case 0xE1: 
            case 18407: 
            case 0x4DBB: 
            case 0x5034: 
            case 0x5035: 
            case 0x55B0: 
            case 0x55D0: 
            case 0x6240: 
            case 0x6D80: 
            case 30113: 
            case 30320: 
            case 290298740: 
            case 357149030: 
            case 0x1654AE6B: 
            case 0x18538067: 
            case 0x1A45DFA3: 
            case 0x1C53BB6B: 
            case 0x1F43B675: {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }

    public void handleBlockAdditionalData(Track matroskaExtractor$Track0, int v, ExtractorInput extractorInput0, int v1) {
        if(v == 4 && "V_VP9".equals(matroskaExtractor$Track0.codecId)) {
            this.blockAdditionalData.reset(v1);
            extractorInput0.readFully(this.blockAdditionalData.data, 0, v1);
            return;
        }
        extractorInput0.skipFully(v1);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public final void init(ExtractorOutput extractorOutput0) {
        this.extractorOutput = extractorOutput0;
    }

    public void integerElement(int v, long v1) {
        switch(v) {
            case 0x5031: {
                if(v1 != 0L) {
                    throw new ParserException("ContentEncodingOrder " + v1 + " not supported");
                }
                break;
            }
            case 20530: {
                if(v1 != 1L) {
                    throw new ParserException("ContentEncodingScope " + v1 + " not supported");
                }
                break;
            }
            default: {
                boolean z = false;
            alab1:
                switch(v) {
                    case 0x83: {
                        this.currentTrack.type = (int)v1;
                        return;
                    }
                    case 0x88: {
                        Track matroskaExtractor$Track0 = this.currentTrack;
                        if(v1 == 1L) {
                            z = true;
                        }
                        matroskaExtractor$Track0.flagDefault = z;
                        return;
                    }
                    case 0x9B: {
                        this.blockDurationUs = this.scaleTimecodeToUs(v1);
                        return;
                    }
                    case 0x9F: {
                        this.currentTrack.channelCount = (int)v1;
                        return;
                    }
                    case 0xB0: {
                        this.currentTrack.width = (int)v1;
                        return;
                    }
                    case 0xB3: {
                        this.cueTimesUs.add(this.scaleTimecodeToUs(v1));
                        return;
                    }
                    case 0xBA: {
                        this.currentTrack.height = (int)v1;
                        return;
                    }
                    case 0xD7: {
                        this.currentTrack.number = (int)v1;
                        return;
                    }
                    case 0xE7: {
                        this.clusterTimecodeUs = this.scaleTimecodeToUs(v1);
                        return;
                    }
                    case 0xEE: {
                        this.blockAdditionalId = (int)v1;
                        return;
                    }
                    case 0xF1: {
                        if(!this.seenClusterPositionForCurrentCuePoint) {
                            this.cueClusterPositions.add(v1);
                            this.seenClusterPositionForCurrentCuePoint = true;
                            return;
                        }
                        break;
                    }
                    case 0xFB: {
                        this.blockHasReferenceBlock = true;
                        return;
                    }
                    case 16980: {
                        if(v1 != 3L) {
                            throw new ParserException("ContentCompAlgo " + v1 + " not supported");
                        }
                        break;
                    }
                    case 17029: {
                        if(v1 < 1L || v1 > 2L) {
                            throw new ParserException("DocTypeReadVersion " + v1 + " not supported");
                        }
                        break;
                    }
                    case 0x42F7: {
                        if(v1 != 1L) {
                            throw new ParserException("EBMLReadVersion " + v1 + " not supported");
                        }
                        break;
                    }
                    case 18401: {
                        if(v1 != 5L) {
                            throw new ParserException("ContentEncAlgo " + v1 + " not supported");
                        }
                        break;
                    }
                    case 18408: {
                        if(v1 != 1L) {
                            throw new ParserException("AESSettingsCipherMode " + v1 + " not supported");
                        }
                        break;
                    }
                    case 21420: {
                        this.seekEntryPosition = v1 + this.segmentContentPosition;
                        return;
                    }
                    case 0x53B8: {
                        switch(((int)v1)) {
                            case 0: {
                                this.currentTrack.stereoMode = 0;
                                return;
                            }
                            case 1: {
                                this.currentTrack.stereoMode = 2;
                                return;
                            }
                            case 3: {
                                this.currentTrack.stereoMode = 1;
                                return;
                            }
                        }
                        if(((int)v1) == 15) {
                            this.currentTrack.stereoMode = 3;
                            return;
                        }
                        break;
                    }
                    case 0x54B0: {
                        this.currentTrack.displayWidth = (int)v1;
                        return;
                    }
                    case 0x54B2: {
                        this.currentTrack.displayUnit = (int)v1;
                        return;
                    }
                    case 21690: {
                        this.currentTrack.displayHeight = (int)v1;
                        return;
                    }
                    case 21930: {
                        Track matroskaExtractor$Track1 = this.currentTrack;
                        if(v1 == 1L) {
                            z = true;
                        }
                        matroskaExtractor$Track1.flagForced = z;
                        return;
                    }
                    case 0x55B9: {
                        switch(((int)v1)) {
                            case 1: {
                                this.currentTrack.colorRange = 2;
                                return;
                            }
                            case 2: {
                                this.currentTrack.colorRange = 1;
                                return;
                            }
                            default: {
                                return;
                            }
                        }
                    }
                    case 0x55BA: {
                        switch(((int)v1)) {
                            case 1: {
                                this.currentTrack.colorTransfer = 3;
                                return;
                            }
                            case 16: {
                                this.currentTrack.colorTransfer = 6;
                                return;
                            label_52:
                                switch(((int)v1)) {
                                    case 6: 
                                    case 7: {
                                        this.currentTrack.colorTransfer = 3;
                                        return;
                                    }
                                    case 18: {
                                        this.currentTrack.colorTransfer = 7;
                                        return;
                                    }
                                    default: {
                                        return;
                                    }
                                }
                            }
                            default: {
                                goto label_52;
                            }
                        }
                    }
                    case 0x55BB: {
                        Track matroskaExtractor$Track2 = this.currentTrack;
                        matroskaExtractor$Track2.hasColorInfo = true;
                        switch(((int)v1)) {
                            case 1: {
                                matroskaExtractor$Track2.colorSpace = 1;
                                return;
                            }
                            case 4: {
                                break;
                            }
                            case 9: {
                                matroskaExtractor$Track2.colorSpace = 6;
                                return;
                            label_117:
                                if(((int)v1) == 5 || ((int)v1) == 6 || ((int)v1) == 7) {
                                    break;
                                }
                                break alab1;
                            }
                            default: {
                                goto label_117;
                            }
                        }
                        matroskaExtractor$Track2.colorSpace = 2;
                        return;
                    }
                    case 0x55BC: {
                        this.currentTrack.maxContentLuminance = (int)v1;
                        return;
                    }
                    case 0x55BD: {
                        this.currentTrack.maxFrameAverageLuminance = (int)v1;
                        return;
                    }
                    case 0x55EE: {
                        this.currentTrack.maxBlockAdditionId = (int)v1;
                        return;
                    }
                    case 0x56AA: {
                        this.currentTrack.codecDelayNs = v1;
                        return;
                    }
                    case 22203: {
                        this.currentTrack.seekPreRollNs = v1;
                        return;
                    }
                    case 0x6264: {
                        this.currentTrack.audioBitDepth = (int)v1;
                        return;
                    }
                    case 30321: {
                        switch(((int)v1)) {
                            case 0: {
                                this.currentTrack.projectionType = 0;
                                return;
                            }
                            case 1: {
                                this.currentTrack.projectionType = 1;
                                return;
                            }
                            case 2: {
                                this.currentTrack.projectionType = 2;
                                return;
                            }
                            case 3: {
                                this.currentTrack.projectionType = 3;
                                return;
                            }
                            default: {
                                return;
                            }
                        }
                    }
                    case 2352003: {
                        this.currentTrack.defaultSampleDurationNs = (int)v1;
                        return;
                    }
                    case 2807729: {
                        this.timecodeScale = v1;
                    }
                }
            }
        }
    }

    // 去混淆评级： 高(300)
    private static boolean isCodecSupported(String s) {
        return "V_VP8".equals(s) || "V_VP9".equals(s) || "V_AV1".equals(s) || "V_MPEG2".equals(s) || "V_MPEG4/ISO/SP".equals(s) || "V_MPEG4/ISO/ASP".equals(s) || "V_MPEG4/ISO/AP".equals(s) || "V_MPEG4/ISO/AVC".equals(s) || "V_MPEGH/ISO/HEVC".equals(s) || "V_MS/VFW/FOURCC".equals(s) || "V_THEORA".equals(s) || "A_OPUS".equals(s) || "A_VORBIS".equals(s) || "A_AAC".equals(s) || "A_MPEG/L2".equals(s) || "A_MPEG/L3".equals(s) || "A_AC3".equals(s) || "A_EAC3".equals(s) || "A_TRUEHD".equals(s) || "A_DTS".equals(s) || "A_DTS/EXPRESS".equals(s) || "A_DTS/LOSSLESS".equals(s) || "A_FLAC".equals(s) || "A_MS/ACM".equals(s) || "A_PCM/INT/LIT".equals(s) || "S_TEXT/UTF8".equals(s) || "S_TEXT/ASS".equals(s) || "S_VOBSUB".equals(s) || "S_HDMV/PGS".equals(s) || "S_DVBSUB".equals(s);
    }

    public boolean isLevel1Element(int v) {
        return v == 357149030 || v == 0x1654AE6B || v == 0x1C53BB6B || v == 0x1F43B675;
    }

    private static Extractor[] lambda$static$0() {
        return new Extractor[]{new MatroskaExtractor()};
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder0, long v) {
        if(this.seekForCues) {
            this.seekPositionAfterBuildingCues = v;
            positionHolder0.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if(this.sentSeekMap) {
            long v1 = this.seekPositionAfterBuildingCues;
            if(v1 != -1L) {
                positionHolder0.position = v1;
                this.seekPositionAfterBuildingCues = -1L;
                return true;
            }
        }
        return false;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public final int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        this.haveOutputSample = false;
        boolean z = true;
        while(z) {
            z = this.reader.read(extractorInput0);
            if(z && this.maybeSeekForCues(positionHolder0, extractorInput0.getPosition())) {
                return 1;
            }
            if(false) {
                break;
            }
        }
        for(int v = 0; v < this.tracks.size(); ++v) {
            ((Track)this.tracks.valueAt(v)).outputPendingSampleMetadata();
        }
        return -1;
    }

    private void readScratch(ExtractorInput extractorInput0, int v) {
        if(this.scratch.limit() >= v) {
            return;
        }
        if(this.scratch.capacity() < v) {
            byte[] arr_b = Arrays.copyOf(this.scratch.data, Math.max(this.scratch.data.length * 2, v));
            this.scratch.reset(arr_b, this.scratch.limit());
        }
        extractorInput0.readFully(this.scratch.data, this.scratch.limit(), v - this.scratch.limit());
        this.scratch.setLimit(v);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public final void release() {
    }

    private void resetWriteSampleData() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset();
    }

    private long scaleTimecodeToUs(long v) {
        long v1 = this.timecodeScale;
        if(v1 == 0x8000000000000001L) {
            throw new ParserException("Can\'t scale timecode prior to timecodeScale being set.");
        }
        return Util.scaleLargeTimestamp(v, v1, 1000L);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        this.clusterTimecodeUs = 0x8000000000000001L;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        this.resetWriteSampleData();
        for(int v2 = 0; v2 < this.tracks.size(); ++v2) {
            ((Track)this.tracks.valueAt(v2)).reset();
        }
    }

    private static void setSubtitleEndTime(String s, long v, byte[] arr_b) {
        int v1;
        byte[] arr_b1;
        s.getClass();
        if(s.equals("S_TEXT/ASS")) {
            arr_b1 = MatroskaExtractor.formatSubtitleTimecode(v, "%01d:%02d:%02d:%02d", 10000L);
            v1 = 21;
        }
        else {
            if(!s.equals("S_TEXT/UTF8")) {
                throw new IllegalArgumentException();
            }
            arr_b1 = MatroskaExtractor.formatSubtitleTimecode(v, "%02d:%02d:%02d,%03d", 1000L);
            v1 = 19;
        }
        System.arraycopy(arr_b1, 0, arr_b, v1, arr_b1.length);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public final boolean sniff(ExtractorInput extractorInput0) {
        return new Sniffer().sniff(extractorInput0);
    }

    public void startMasterElement(int v, long v1, long v2) {
        switch(v) {
            case 0xA0: {
                this.blockHasReferenceBlock = false;
                return;
            }
            case 0xAE: {
                this.currentTrack = new Track(null);
                return;
            }
            case 0xBB: {
                this.seenClusterPositionForCurrentCuePoint = false;
                return;
            }
            case 0x4DBB: {
                this.seekEntryId = -1;
                this.seekEntryPosition = -1L;
                return;
            }
            case 0x5035: {
                this.currentTrack.hasContentEncryption = true;
                return;
            }
            case 0x55D0: {
                this.currentTrack.hasColorInfo = true;
                return;
            }
            case 0x18538067: {
                if(this.segmentContentPosition != -1L && this.segmentContentPosition != v1) {
                    throw new ParserException("Multiple Segment elements not supported");
                }
                this.segmentContentPosition = v1;
                this.segmentContentSize = v2;
                return;
            }
            case 0x1C53BB6B: {
                this.cueTimesUs = new LongArray();
                this.cueClusterPositions = new LongArray();
                return;
            }
            case 0x1F43B675: {
                if(!this.sentSeekMap) {
                    if(this.seekForCuesEnabled && this.cuesContentPosition != -1L) {
                        this.seekForCues = true;
                        return;
                    }
                    this.extractorOutput.seekMap(new Unseekable(this.durationUs));
                    this.sentSeekMap = true;
                }
            }
        }
    }

    public void stringElement(int v, String s) {
        switch(v) {
            case 0x86: {
                this.currentTrack.codecId = s;
                return;
            }
            case 17026: {
                if(!"webm".equals(s) && !"matroska".equals(s)) {
                    throw new ParserException("DocType " + s + " not supported");
                }
                return;
            }
            case 0x536E: {
                this.currentTrack.name = s;
                return;
            }
            case 0x22B59C: {
                Track.access$202(this.currentTrack, s);
            }
        }
    }

    private int writeSampleData(ExtractorInput extractorInput0, Track matroskaExtractor$Track0, int v) {
        if("S_TEXT/UTF8".equals(matroskaExtractor$Track0.codecId)) {
            this.writeSubtitleSampleData(extractorInput0, MatroskaExtractor.SUBRIP_PREFIX, v);
            return this.finishWriteSampleData();
        }
        if("S_TEXT/ASS".equals(matroskaExtractor$Track0.codecId)) {
            this.writeSubtitleSampleData(extractorInput0, MatroskaExtractor.SSA_PREFIX, v);
            return this.finishWriteSampleData();
        }
        TrackOutput trackOutput0 = matroskaExtractor$Track0.output;
        boolean z = true;
        if(!this.sampleEncodingHandled) {
            if(matroskaExtractor$Track0.hasContentEncryption) {
                this.blockFlags &= 0xBFFFFFFF;
                int v1 = 0x80;
                if(!this.sampleSignalByteRead) {
                    extractorInput0.readFully(this.scratch.data, 0, 1);
                    ++this.sampleBytesRead;
                    byte b = this.scratch.data[0];
                    if((b & 0x80) == 0x80) {
                        throw new ParserException("Extension bit is set in signal byte");
                    }
                    this.sampleSignalByte = b;
                    this.sampleSignalByteRead = true;
                }
                int v2 = this.sampleSignalByte;
                if((v2 & 1) == 1) {
                    boolean z1 = (v2 & 2) == 2;
                    this.blockFlags |= 0x40000000;
                    if(!this.sampleInitializationVectorRead) {
                        extractorInput0.readFully(this.encryptionInitializationVector.data, 0, 8);
                        this.sampleBytesRead += 8;
                        this.sampleInitializationVectorRead = true;
                        ParsableByteArray parsableByteArray0 = this.scratch;
                        byte[] arr_b = parsableByteArray0.data;
                        if(!z1) {
                            v1 = 0;
                        }
                        arr_b[0] = (byte)(v1 | 8);
                        parsableByteArray0.setPosition(0);
                        trackOutput0.sampleData(this.scratch, 1);
                        ++this.sampleBytesWritten;
                        this.encryptionInitializationVector.setPosition(0);
                        trackOutput0.sampleData(this.encryptionInitializationVector, 8);
                        this.sampleBytesWritten += 8;
                    }
                    if(z1) {
                        if(!this.samplePartitionCountRead) {
                            extractorInput0.readFully(this.scratch.data, 0, 1);
                            ++this.sampleBytesRead;
                            this.scratch.setPosition(0);
                            this.samplePartitionCount = this.scratch.readUnsignedByte();
                            this.samplePartitionCountRead = true;
                        }
                        int v3 = this.samplePartitionCount * 4;
                        this.scratch.reset(v3);
                        extractorInput0.readFully(this.scratch.data, 0, v3);
                        this.sampleBytesRead += v3;
                        int v4 = (short)(this.samplePartitionCount / 2 + 1);
                        int v5 = v4 * 6 + 2;
                        if(this.encryptionSubsampleDataBuffer == null || this.encryptionSubsampleDataBuffer.capacity() < v5) {
                            this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(v5);
                        }
                        this.encryptionSubsampleDataBuffer.position(0);
                        this.encryptionSubsampleDataBuffer.putShort(((short)v4));
                        int v6 = 0;
                        int v7;
                        for(v7 = 0; true; v7 = v9) {
                            int v8 = this.samplePartitionCount;
                            if(v6 >= v8) {
                                break;
                            }
                            int v9 = this.scratch.readUnsignedIntToInt();
                            if(v6 % 2 == 0) {
                                this.encryptionSubsampleDataBuffer.putShort(((short)(v9 - v7)));
                            }
                            else {
                                this.encryptionSubsampleDataBuffer.putInt(v9 - v7);
                            }
                            ++v6;
                        }
                        int v10 = v - this.sampleBytesRead - v7;
                        if(v8 % 2 == 1) {
                            this.encryptionSubsampleDataBuffer.putInt(v10);
                        }
                        else {
                            this.encryptionSubsampleDataBuffer.putShort(((short)v10));
                            this.encryptionSubsampleDataBuffer.putInt(0);
                        }
                        byte[] arr_b1 = this.encryptionSubsampleDataBuffer.array();
                        this.encryptionSubsampleData.reset(arr_b1, v5);
                        trackOutput0.sampleData(this.encryptionSubsampleData, v5);
                        this.sampleBytesWritten += v5;
                    }
                }
            }
            else {
                byte[] arr_b2 = matroskaExtractor$Track0.sampleStrippedBytes;
                if(arr_b2 != null) {
                    this.sampleStrippedBytes.reset(arr_b2, arr_b2.length);
                }
            }
            if(matroskaExtractor$Track0.maxBlockAdditionId > 0) {
                this.blockFlags |= 0x10000000;
                this.blockAdditionalData.reset();
                this.scratch.reset(4);
                byte[] arr_b3 = this.scratch.data;
                arr_b3[0] = (byte)(v >> 24 & 0xFF);
                arr_b3[1] = (byte)(v >> 16 & 0xFF);
                arr_b3[2] = (byte)(v >> 8 & 0xFF);
                arr_b3[3] = (byte)(v & 0xFF);
                trackOutput0.sampleData(this.scratch, 4);
                this.sampleBytesWritten += 4;
            }
            this.sampleEncodingHandled = true;
        }
        int v11 = this.sampleStrippedBytes.limit() + v;
        if("V_MPEG4/ISO/AVC".equals(matroskaExtractor$Track0.codecId) || "V_MPEGH/ISO/HEVC".equals(matroskaExtractor$Track0.codecId)) {
            byte[] arr_b4 = this.nalLength.data;
            arr_b4[0] = 0;
            arr_b4[1] = 0;
            arr_b4[2] = 0;
            int v14 = matroskaExtractor$Track0.nalUnitLengthFieldLength;
            while(this.sampleBytesRead < v11) {
                int v15 = this.sampleCurrentNalBytesRemaining;
                if(v15 == 0) {
                    this.writeToTarget(extractorInput0, arr_b4, 4 - v14, v14);
                    this.sampleBytesRead += v14;
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput0.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                }
                else {
                    int v16 = this.writeToOutput(extractorInput0, trackOutput0, v15);
                    this.sampleBytesRead += v16;
                    this.sampleBytesWritten += v16;
                    this.sampleCurrentNalBytesRemaining -= v16;
                }
            }
        }
        else {
            if(matroskaExtractor$Track0.trueHdSampleRechunker != null) {
                if(this.sampleStrippedBytes.limit() != 0) {
                    z = false;
                }
                Assertions.checkState(z);
                matroskaExtractor$Track0.trueHdSampleRechunker.startSample(extractorInput0);
            }
            int v12;
            while((v12 = this.sampleBytesRead) < v11) {
                int v13 = this.writeToOutput(extractorInput0, trackOutput0, v11 - v12);
                this.sampleBytesRead += v13;
                this.sampleBytesWritten += v13;
            }
        }
        if("A_VORBIS".equals(matroskaExtractor$Track0.codecId)) {
            this.vorbisNumPageSamples.setPosition(0);
            trackOutput0.sampleData(this.vorbisNumPageSamples, 4);
            this.sampleBytesWritten += 4;
        }
        return this.finishWriteSampleData();
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput0, byte[] arr_b, int v) {
        int v1 = arr_b.length + v;
        if(this.subtitleSample.capacity() < v1) {
            this.subtitleSample.data = Arrays.copyOf(arr_b, v1 + v);
        }
        else {
            System.arraycopy(arr_b, 0, this.subtitleSample.data, 0, arr_b.length);
        }
        extractorInput0.readFully(this.subtitleSample.data, arr_b.length, v);
        this.subtitleSample.reset(v1);
    }

    private int writeToOutput(ExtractorInput extractorInput0, TrackOutput trackOutput0, int v) {
        int v1 = this.sampleStrippedBytes.bytesLeft();
        if(v1 > 0) {
            int v2 = Math.min(v, v1);
            trackOutput0.sampleData(this.sampleStrippedBytes, v2);
            return v2;
        }
        return trackOutput0.sampleData(extractorInput0, v, false);
    }

    private void writeToTarget(ExtractorInput extractorInput0, byte[] arr_b, int v, int v1) {
        int v2 = Math.min(v1, this.sampleStrippedBytes.bytesLeft());
        extractorInput0.readFully(arr_b, v + v2, v1 - v2);
        if(v2 > 0) {
            this.sampleStrippedBytes.readBytes(arr_b, v, v2);
        }
    }

    class com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.1 {
    }

}

