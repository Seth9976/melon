package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import b3.Z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers {
    static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray0, ParsableByteArray parsableByteArray1, boolean z) {
            this.stsc = parsableByteArray0;
            this.chunkOffsets = parsableByteArray1;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray1.setPosition(12);
            this.length = parsableByteArray1.readUnsignedIntToInt();
            parsableByteArray0.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray0.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray0.readInt() == 1, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            int v = this.index + 1;
            this.index = v;
            if(v == this.length) {
                return false;
            }
            this.offset = this.chunkOffsetsAreLongs ? this.chunkOffsets.readUnsignedLongToLong() : this.chunkOffsets.readUnsignedInt();
            if(this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int v1 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = v1;
                this.nextSamplesPerChunkChangeIndex = v1 <= 0 ? -1 : this.stsc.readUnsignedIntToInt() - 1;
            }
            return true;
        }
    }

    interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int v) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[v];
            this.requiredSampleTransformation = 0;
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(LeafAtom atom$LeafAtom0) {
            this.data = atom$LeafAtom0.data;
            atom$LeafAtom0.data.setPosition(12);
            this.fixedSampleSize = atom$LeafAtom0.data.readUnsignedIntToInt();
            this.sampleCount = atom$LeafAtom0.data.readUnsignedIntToInt();
        }

        @Override  // com.google.android.exoplayer2.extractor.mp4.AtomParsers$SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override  // com.google.android.exoplayer2.extractor.mp4.AtomParsers$SampleSizeBox
        public boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }

        @Override  // com.google.android.exoplayer2.extractor.mp4.AtomParsers$SampleSizeBox
        public int readNextSampleSize() {
            return this.fixedSampleSize == 0 ? this.data.readUnsignedIntToInt() : this.fixedSampleSize;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(LeafAtom atom$LeafAtom0) {
            this.data = atom$LeafAtom0.data;
            atom$LeafAtom0.data.setPosition(12);
            this.fieldSize = atom$LeafAtom0.data.readUnsignedIntToInt() & 0xFF;
            this.sampleCount = atom$LeafAtom0.data.readUnsignedIntToInt();
        }

        @Override  // com.google.android.exoplayer2.extractor.mp4.AtomParsers$SampleSizeBox
        public int getSampleCount() {
            return this.sampleCount;
        }

        @Override  // com.google.android.exoplayer2.extractor.mp4.AtomParsers$SampleSizeBox
        public boolean isFixedSampleSize() {
            return false;
        }

        @Override  // com.google.android.exoplayer2.extractor.mp4.AtomParsers$SampleSizeBox
        public int readNextSampleSize() {
            int v = this.fieldSize;
            if(v == 8) {
                return this.data.readUnsignedByte();
            }
            if(v == 16) {
                return this.data.readUnsignedShort();
            }
            int v1 = this.sampleIndex;
            this.sampleIndex = v1 + 1;
            if(v1 % 2 == 0) {
                int v2 = this.data.readUnsignedByte();
                this.currentByte = v2;
                return (v2 & 0xF0) >> 4;
            }
            return this.currentByte & 15;
        }
    }

    static final class TkhdData {
        private final long duration;
        private final int id;
        private final int rotationDegrees;

        public TkhdData(int v, long v1, int v2) {
            this.id = v;
            this.duration = v1;
            this.rotationDegrees = v2;
        }

        public static long access$000(TkhdData atomParsers$TkhdData0) {
            return atomParsers$TkhdData0.duration;
        }

        public static int access$100(TkhdData atomParsers$TkhdData0) {
            return atomParsers$TkhdData0.id;
        }

        public static int access$200(TkhdData atomParsers$TkhdData0) {
            return atomParsers$TkhdData0.rotationDegrees;
        }
    }

    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 0x636C6370;
    private static final int TYPE_mdta = 0x6D647461;
    private static final int TYPE_meta = 0x6D657461;
    private static final int TYPE_sbtl = 0x7362746C;
    private static final int TYPE_soun = 0x736F756E;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 0x76696465;
    private static final byte[] opusMagic;

    static {
        AtomParsers.opusMagic = new byte[]{0x4F, 0x70, 0x75, 0x73, 72, 101, 97, 100};
    }

    private static boolean canApplyEditWithGaplessInfo(long[] arr_v, long v, long v1, long v2) {
        return arr_v[0] <= v1 && v1 < arr_v[Util.constrainValue(4, 0, arr_v.length - 1)] && arr_v[Util.constrainValue(arr_v.length - 4, 0, arr_v.length - 1)] < v2 && v2 <= v;
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray0, int v, int v1) {
        for(int v2 = parsableByteArray0.getPosition(); v2 - v < v1; v2 += v3) {
            parsableByteArray0.setPosition(v2);
            int v3 = parsableByteArray0.readInt();
            Assertions.checkArgument(v3 > 0, "childAtomSize should be positive");
            if(parsableByteArray0.readInt() == 1702061171) {
                return v2;
            }
        }
        return -1;
    }

    private static int getTrackTypeForHdlr(int v) {
        switch(v) {
            case 0x6D657461: {
                return 4;
            }
            case 0x736F756E: {
                return 1;
            }
            case 0x636C6370: 
            case 0x7362746C: 
            case 1937072756: 
            case 1952807028: {
                return 3;
            }
            case 0x76696465: {
                return 2;
            }
            default: {
                return -1;
            }
        }
    }

    private static void parseAudioSampleEntry(ParsableByteArray parsableByteArray0, int v, int v1, int v2, int v3, String s, boolean z, DrmInitData drmInitData0, StsdData atomParsers$StsdData0, int v4) {
        int v7;
        int v6;
        int v19;
        int v18;
        DrmInitData drmInitData2;
        int v17;
        String s1;
        int v11;
        int v5;
        parsableByteArray0.setPosition(v1 + 16);
        if(z) {
            v5 = parsableByteArray0.readUnsignedShort();
            parsableByteArray0.skipBytes(6);
        }
        else {
            parsableByteArray0.skipBytes(8);
            v5 = 0;
        }
        if(v5 == 0 || v5 == 1) {
            int v8 = parsableByteArray0.readUnsignedShort();
            parsableByteArray0.skipBytes(6);
            v6 = parsableByteArray0.readUnsignedFixedPoint1616();
            if(v5 == 1) {
                parsableByteArray0.skipBytes(16);
            }
            v7 = v8;
        label_20:
            int v9 = parsableByteArray0.getPosition();
            List list0 = null;
            int v10 = v;
            if(v10 == 1701733217) {
                Pair pair0 = AtomParsers.parseSampleEntryEncryptionData(parsableByteArray0, v1, v2);
                if(pair0 != null) {
                    v10 = (int)(((Integer)pair0.first));
                    drmInitData0 = drmInitData0 == null ? null : drmInitData0.copyWithSchemeType(((TrackEncryptionBox)pair0.second).schemeType);
                    atomParsers$StsdData0.trackEncryptionBoxes[v4] = (TrackEncryptionBox)pair0.second;
                }
                parsableByteArray0.setPosition(v9);
            }
            DrmInitData drmInitData1 = drmInitData0;
            switch(v10) {
                case 0x2E6D7033: {
                    s1 = "audio/mpeg";
                    v11 = -1;
                    break;
                }
                case 0x4F707573: {
                    s1 = "audio/opus";
                    v11 = -1;
                    break;
                }
                case 0x61632D33: {
                    s1 = "audio/ac3";
                    v11 = -1;
                    break;
                }
                case 0x61632D34: {
                    s1 = "audio/ac4";
                    v11 = -1;
                    break;
                }
                case 0x616C6163: {
                    s1 = "audio/alac";
                    v11 = -1;
                    break;
                }
                case 0x616C6177: {
                    s1 = "audio/g711-alaw";
                    v11 = -1;
                    break;
                }
                case 0x64747363: {
                    s1 = "audio/vnd.dts";
                    v11 = -1;
                    break;
                }
                case 0x64747365: {
                    s1 = "audio/vnd.dts.hd;profile=lbr";
                    v11 = -1;
                    break;
                }
                case 1685353320: 
                case 0x6474736C: {
                    s1 = "audio/vnd.dts.hd";
                    v11 = -1;
                    break;
                }
                case 1700998451: {
                    s1 = "audio/eac3";
                    v11 = -1;
                    break;
                }
                case 0x664C6143: {
                    s1 = "audio/flac";
                    v11 = -1;
                    break;
                }
                case 1935764850: {
                    s1 = "audio/3gpp";
                    v11 = -1;
                    break;
                }
                case 0x73617762: {
                    s1 = "audio/amr-wb";
                    v11 = -1;
                    break;
                }
                case 0x6C70636D: 
                case 0x736F7774: {
                    s1 = "audio/raw";
                    v11 = 2;
                    break;
                }
                case 0x74776F73: {
                    v11 = 0x10000000;
                    s1 = "audio/raw";
                    break;
                }
                case 1970037111: {
                    s1 = "audio/g711-mlaw";
                    v11 = -1;
                    break;
                }
                default: {
                    v11 = -1;
                    s1 = null;
                }
            }
            String s2 = s1;
            int v12 = v6;
            int v13 = v7;
            int v14 = v9;
            byte[] arr_b = null;
            while(v14 - v1 < v2) {
                parsableByteArray0.setPosition(v14);
                int v15 = parsableByteArray0.readInt();
                Assertions.checkArgument(v15 > 0, "childAtomSize should be positive");
                int v16 = parsableByteArray0.readInt();
                if(v16 == 1702061171) {
                    drmInitData2 = drmInitData1;
                    v18 = v15;
                    v19 = v12;
                    v17 = v14;
                }
                else {
                    if(z) {
                        switch(v16) {
                            case 1684103987: {
                                parsableByteArray0.setPosition(v14 + 8);
                                atomParsers$StsdData0.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray0, Integer.toString(v3), s, drmInitData1);
                                goto label_148;
                            }
                            case 1684103988: {
                                parsableByteArray0.setPosition(v14 + 8);
                                atomParsers$StsdData0.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray0, Integer.toString(v3), s, drmInitData1);
                                goto label_148;
                            }
                            case 1684305011: {
                                goto label_140;
                            }
                            case 0x64656333: {
                                goto label_146;
                            }
                            case 2002876005: {
                                v17 = v14;
                                drmInitData2 = drmInitData1;
                                v18 = v15;
                                v19 = v12;
                                goto label_158;
                            }
                        }
                    }
                    else {
                        switch(v16) {
                            case 1684103987: {
                                parsableByteArray0.setPosition(v14 + 8);
                                atomParsers$StsdData0.format = Ac3Util.parseAc3AnnexFFormat(parsableByteArray0, Integer.toString(v3), s, drmInitData1);
                                goto label_148;
                            }
                            case 1684103988: {
                                parsableByteArray0.setPosition(v14 + 8);
                                atomParsers$StsdData0.format = Ac4Util.parseAc4AnnexEFormat(parsableByteArray0, Integer.toString(v3), s, drmInitData1);
                                goto label_148;
                            }
                            case 1684305011: {
                                goto label_140;
                            }
                            case 0x64656333: {
                                goto label_146;
                            }
                        }
                    }
                    drmInitData2 = drmInitData1;
                    v18 = v15;
                    int v20 = v12;
                    if(v16 == 0x644F7073) {
                        byte[] arr_b1 = new byte[AtomParsers.opusMagic.length + (v18 - 8)];
                        System.arraycopy(AtomParsers.opusMagic, 0, arr_b1, 0, AtomParsers.opusMagic.length);
                        v17 = v14;
                        parsableByteArray0.setPosition(v17 + 8);
                        parsableByteArray0.readBytes(arr_b1, AtomParsers.opusMagic.length, v18 - 8);
                        arr_b = arr_b1;
                    }
                    else {
                        v17 = v14;
                        if(v16 == 0x64664C61) {
                            byte[] arr_b2 = new byte[v18 - 8];
                            arr_b2[0] = 102;
                            arr_b2[1] = 76;
                            arr_b2[2] = 97;
                            arr_b2[3] = 67;
                            parsableByteArray0.setPosition(v17 + 12);
                            parsableByteArray0.readBytes(arr_b2, 4, v18 - 12);
                            arr_b = arr_b2;
                        }
                        else if(v16 == 0x616C6163) {
                            byte[] arr_b3 = new byte[v18 - 12];
                            parsableByteArray0.setPosition(v17 + 12);
                            parsableByteArray0.readBytes(arr_b3, 0, v18 - 12);
                            Pair pair1 = CodecSpecificDataUtil.parseAlacAudioSpecificConfig(arr_b3);
                            int v21 = (int)(((Integer)pair1.first));
                            arr_b = arr_b3;
                            v13 = (int)(((Integer)pair1.second));
                            v12 = v21;
                            goto label_170;
                        label_140:
                            drmInitData2 = drmInitData1;
                            v20 = v12;
                            v18 = v15;
                            atomParsers$StsdData0.format = Format.createAudioSampleFormat(Integer.toString(v3), s2, null, -1, -1, v13, v20, null, drmInitData2, 0, s);
                            v17 = v14;
                            v12 = v20;
                            goto label_170;
                        label_146:
                            parsableByteArray0.setPosition(v14 + 8);
                            atomParsers$StsdData0.format = Ac3Util.parseEAc3AnnexFFormat(parsableByteArray0, Integer.toString(v3), s, drmInitData1);
                        label_148:
                            v17 = v14;
                            drmInitData2 = drmInitData1;
                            v18 = v15;
                            v20 = v12;
                        }
                    }
                    v12 = v20;
                    goto label_170;
                }
            label_158:
                int v22 = v16 == 1702061171 ? v17 : AtomParsers.findEsdsPosition(parsableByteArray0, v17, v18);
                if(v22 == -1) {
                    v12 = v19;
                }
                else {
                    Pair pair2 = AtomParsers.parseEsdsFromParent(parsableByteArray0, v22);
                    s2 = (String)pair2.first;
                    arr_b = (byte[])pair2.second;
                    if("audio/mp4a-latm".equals(s2)) {
                        Pair pair3 = CodecSpecificDataUtil.parseAacAudioSpecificConfig(arr_b);
                        int v23 = (int)(((Integer)pair3.first));
                        v13 = (int)(((Integer)pair3.second));
                        v12 = v23;
                    }
                }
            label_170:
                v14 = v17 + v18;
                drmInitData1 = drmInitData2;
            }
            if(atomParsers$StsdData0.format == null && s2 != null) {
                String s3 = Integer.toString(v3);
                if(arr_b != null) {
                    list0 = Collections.singletonList(arr_b);
                }
                atomParsers$StsdData0.format = Format.createAudioSampleFormat(s3, s2, null, -1, -1, v13, v12, v11, list0, drmInitData1, 0, s);
            }
        }
        else if(v5 == 2) {
            parsableByteArray0.skipBytes(16);
            v6 = (int)Math.round(parsableByteArray0.readDouble());
            v7 = parsableByteArray0.readUnsignedIntToInt();
            parsableByteArray0.skipBytes(20);
            goto label_20;
        }
    }

    public static Pair parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray0, int v, int v1) {
        int v2 = v + 8;
        boolean z = false;
        int v3 = -1;
        int v4 = 0;
        String s = null;
        Integer integer0 = null;
        while(v2 - v < v1) {
            parsableByteArray0.setPosition(v2);
            int v5 = parsableByteArray0.readInt();
            int v6 = parsableByteArray0.readInt();
            if(v6 == 0x66726D61) {
                integer0 = parsableByteArray0.readInt();
            }
            else {
                switch(v6) {
                    case 0x73636869: {
                        v3 = v2;
                        v4 = v5;
                        break;
                    }
                    case 0x7363686D: {
                        parsableByteArray0.skipBytes(4);
                        s = parsableByteArray0.readString(4);
                    }
                }
            }
            v2 += v5;
        }
        if(!"cenc".equals(s) && !"cbc1".equals(s) && !"cens".equals(s) && !"cbcs".equals(s)) {
            return null;
        }
        Assertions.checkArgument(integer0 != null, "frma atom is mandatory");
        Assertions.checkArgument(v3 != -1, "schi atom is mandatory");
        TrackEncryptionBox trackEncryptionBox0 = AtomParsers.parseSchiFromParent(parsableByteArray0, v3, v4, s);
        if(trackEncryptionBox0 != null) {
            z = true;
        }
        Assertions.checkArgument(z, "tenc atom is mandatory");
        return Pair.create(integer0, trackEncryptionBox0);
    }

    private static Pair parseEdts(ContainerAtom atom$ContainerAtom0) {
        if(atom$ContainerAtom0 != null) {
            LeafAtom atom$LeafAtom0 = atom$ContainerAtom0.getLeafAtomOfType(1701606260);
            if(atom$LeafAtom0 != null) {
                ParsableByteArray parsableByteArray0 = atom$LeafAtom0.data;
                parsableByteArray0.setPosition(8);
                int v = Atom.parseFullAtomVersion(parsableByteArray0.readInt());
                int v1 = parsableByteArray0.readUnsignedIntToInt();
                long[] arr_v = new long[v1];
                long[] arr_v1 = new long[v1];
                for(int v2 = 0; v2 < v1; ++v2) {
                    arr_v[v2] = v == 1 ? parsableByteArray0.readUnsignedLongToLong() : parsableByteArray0.readUnsignedInt();
                    arr_v1[v2] = v == 1 ? parsableByteArray0.readLong() : ((long)parsableByteArray0.readInt());
                    if(parsableByteArray0.readShort() != 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    parsableByteArray0.skipBytes(2);
                }
                return Pair.create(arr_v, arr_v1);
            }
        }
        return Pair.create(null, null);
    }

    private static Pair parseEsdsFromParent(ParsableByteArray parsableByteArray0, int v) {
        parsableByteArray0.setPosition(v + 12);
        parsableByteArray0.skipBytes(1);
        AtomParsers.parseExpandableClassSize(parsableByteArray0);
        parsableByteArray0.skipBytes(2);
        int v1 = parsableByteArray0.readUnsignedByte();
        if((v1 & 0x80) != 0) {
            parsableByteArray0.skipBytes(2);
        }
        if((v1 & 0x40) != 0) {
            parsableByteArray0.skipBytes(parsableByteArray0.readUnsignedShort());
        }
        if((v1 & 0x20) != 0) {
            parsableByteArray0.skipBytes(2);
        }
        parsableByteArray0.skipBytes(1);
        AtomParsers.parseExpandableClassSize(parsableByteArray0);
        String s = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray0.readUnsignedByte());
        if(!"audio/mpeg".equals(s) && !"audio/vnd.dts".equals(s) && !"audio/vnd.dts.hd".equals(s)) {
            parsableByteArray0.skipBytes(12);
            parsableByteArray0.skipBytes(1);
            int v2 = AtomParsers.parseExpandableClassSize(parsableByteArray0);
            byte[] arr_b = new byte[v2];
            parsableByteArray0.readBytes(arr_b, 0, v2);
            return Pair.create(s, arr_b);
        }
        return Pair.create(s, null);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.readUnsignedByte();
        int v1;
        for(v1 = v & 0x7F; (v & 0x80) == 0x80; v1 = v1 << 7 | v & 0x7F) {
            v = parsableByteArray0.readUnsignedByte();
        }
        return v1;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.setPosition(16);
        return parsableByteArray0.readInt();
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray0, int v) {
        parsableByteArray0.skipBytes(8);
        ArrayList arrayList0 = new ArrayList();
        while(parsableByteArray0.getPosition() < v) {
            Entry metadata$Entry0 = MetadataUtil.parseIlstElement(parsableByteArray0);
            if(metadata$Entry0 != null) {
                arrayList0.add(metadata$Entry0);
            }
        }
        return arrayList0.isEmpty() ? null : new Metadata(arrayList0);
    }

    private static Pair parseMdhd(ParsableByteArray parsableByteArray0) {
        int v = 8;
        parsableByteArray0.setPosition(8);
        int v1 = Atom.parseFullAtomVersion(parsableByteArray0.readInt());
        parsableByteArray0.skipBytes((v1 == 0 ? 8 : 16));
        long v2 = parsableByteArray0.readUnsignedInt();
        if(v1 == 0) {
            v = 4;
        }
        parsableByteArray0.skipBytes(v);
        int v3 = parsableByteArray0.readUnsignedShort();
        return Pair.create(v2, ((char)((v3 >> 10 & 0x1F) + 0x60)) + ((char)((v3 >> 5 & 0x1F) + 0x60)) + ((char)((v3 & 0x1F) + 0x60)));
    }

    public static Metadata parseMdtaFromMeta(ContainerAtom atom$ContainerAtom0) {
        LeafAtom atom$LeafAtom0 = atom$ContainerAtom0.getLeafAtomOfType(0x68646C72);
        LeafAtom atom$LeafAtom1 = atom$ContainerAtom0.getLeafAtomOfType(1801812339);
        LeafAtom atom$LeafAtom2 = atom$ContainerAtom0.getLeafAtomOfType(0x696C7374);
        if(atom$LeafAtom0 != null && atom$LeafAtom1 != null && atom$LeafAtom2 != null && AtomParsers.parseHdlr(atom$LeafAtom0.data) == 0x6D647461) {
            ParsableByteArray parsableByteArray0 = atom$LeafAtom1.data;
            parsableByteArray0.setPosition(12);
            int v = parsableByteArray0.readInt();
            String[] arr_s = new String[v];
            for(int v1 = 0; v1 < v; ++v1) {
                int v2 = parsableByteArray0.readInt();
                parsableByteArray0.skipBytes(4);
                arr_s[v1] = parsableByteArray0.readString(v2 - 8);
            }
            ParsableByteArray parsableByteArray1 = atom$LeafAtom2.data;
            parsableByteArray1.setPosition(8);
            ArrayList arrayList0 = new ArrayList();
            while(parsableByteArray1.bytesLeft() > 8) {
                int v3 = parsableByteArray1.getPosition();
                int v4 = parsableByteArray1.readInt();
                int v5 = parsableByteArray1.readInt() - 1;
                if(v5 < 0 || v5 >= v) {
                    Z.q(52, v5, "Skipped metadata with unknown key index: ", "AtomParsers");
                }
                else {
                    MdtaMetadataEntry mdtaMetadataEntry0 = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray1, v3 + v4, arr_s[v5]);
                    if(mdtaMetadataEntry0 != null) {
                        arrayList0.add(mdtaMetadataEntry0);
                    }
                }
                parsableByteArray1.setPosition(v3 + v4);
            }
            return arrayList0.isEmpty() ? null : new Metadata(arrayList0);
        }
        return null;
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray0) {
        int v = 8;
        parsableByteArray0.setPosition(8);
        if(Atom.parseFullAtomVersion(parsableByteArray0.readInt()) != 0) {
            v = 16;
        }
        parsableByteArray0.skipBytes(v);
        return parsableByteArray0.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray0, int v) {
        parsableByteArray0.setPosition(v + 8);
        return ((float)parsableByteArray0.readUnsignedIntToInt()) / ((float)parsableByteArray0.readUnsignedIntToInt());
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray0, int v, int v1) {
        for(int v2 = v + 8; v2 - v < v1; v2 += v3) {
            parsableByteArray0.setPosition(v2);
            int v3 = parsableByteArray0.readInt();
            if(parsableByteArray0.readInt() == 0x70726F6A) {
                return Arrays.copyOfRange(parsableByteArray0.data, v2, v3 + v2);
            }
        }
        return null;
    }

    private static Pair parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray0, int v, int v1) {
        for(int v2 = parsableByteArray0.getPosition(); v2 - v < v1; v2 += v3) {
            parsableByteArray0.setPosition(v2);
            int v3 = parsableByteArray0.readInt();
            Assertions.checkArgument(v3 > 0, "childAtomSize should be positive");
            if(parsableByteArray0.readInt() == 0x73696E66) {
                Pair pair0 = AtomParsers.parseCommonEncryptionSinfFromParent(parsableByteArray0, v2, v3);
                if(pair0 != null) {
                    return pair0;
                }
            }
        }
        return null;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray0, int v, int v1, String s) {
        int v6;
        int v5;
        for(int v2 = v + 8; true; v2 += v3) {
            byte[] arr_b = null;
            if(v2 - v >= v1) {
                break;
            }
            parsableByteArray0.setPosition(v2);
            int v3 = parsableByteArray0.readInt();
            if(parsableByteArray0.readInt() == 1952804451) {
                int v4 = Atom.parseFullAtomVersion(parsableByteArray0.readInt());
                parsableByteArray0.skipBytes(1);
                if(v4 == 0) {
                    parsableByteArray0.skipBytes(1);
                    v5 = 0;
                    v6 = 0;
                }
                else {
                    int v7 = parsableByteArray0.readUnsignedByte();
                    v6 = v7 & 15;
                    v5 = (v7 & 0xF0) >> 4;
                }
                boolean z = parsableByteArray0.readUnsignedByte() == 1;
                int v8 = parsableByteArray0.readUnsignedByte();
                byte[] arr_b1 = new byte[16];
                parsableByteArray0.readBytes(arr_b1, 0, 16);
                if(z && v8 == 0) {
                    int v9 = parsableByteArray0.readUnsignedByte();
                    arr_b = new byte[v9];
                    parsableByteArray0.readBytes(arr_b, 0, v9);
                }
                return new TrackEncryptionBox(z, s, v8, arr_b1, v5, v6, arr_b);
            }
        }
        return null;
    }

    public static TrackSampleTable parseStbl(Track track0, ContainerAtom atom$ContainerAtom0, GaplessInfoHolder gaplessInfoHolder0) {
        int v43;
        int v42;
        long v25;
        boolean z2;
        int v21;
        int v14;
        int v12;
        int[] arr_v3;
        long[] arr_v2;
        int[] arr_v1;
        long[] arr_v;
        int v6;
        int v4;
        boolean z;
        StszSampleSizeBox atomParsers$StszSampleSizeBox0;
        LeafAtom atom$LeafAtom0 = atom$ContainerAtom0.getLeafAtomOfType(1937011578);
        if(atom$LeafAtom0 == null) {
            LeafAtom atom$LeafAtom1 = atom$ContainerAtom0.getLeafAtomOfType(1937013298);
            if(atom$LeafAtom1 == null) {
                throw new ParserException("Track has no sample table size information");
            }
            atomParsers$StszSampleSizeBox0 = new Stz2SampleSizeBox(atom$LeafAtom1);
        }
        else {
            atomParsers$StszSampleSizeBox0 = new StszSampleSizeBox(atom$LeafAtom0);
        }
        int v = atomParsers$StszSampleSizeBox0.getSampleCount();
        if(v == 0) {
            return new TrackSampleTable(track0, new long[0], new int[0], 0, new long[0], new int[0], 0x8000000000000001L);
        }
        LeafAtom atom$LeafAtom2 = atom$ContainerAtom0.getLeafAtomOfType(1937007471);
        if(atom$LeafAtom2 == null) {
            atom$LeafAtom2 = atom$ContainerAtom0.getLeafAtomOfType(0x636F3634);
            z = true;
        }
        else {
            z = false;
        }
        ParsableByteArray parsableByteArray0 = atom$ContainerAtom0.getLeafAtomOfType(1937011555).data;
        ParsableByteArray parsableByteArray1 = atom$ContainerAtom0.getLeafAtomOfType(1937011827).data;
        LeafAtom atom$LeafAtom3 = atom$ContainerAtom0.getLeafAtomOfType(1937011571);
        ParsableByteArray parsableByteArray2 = null;
        ParsableByteArray parsableByteArray3 = atom$LeafAtom3 == null ? null : atom$LeafAtom3.data;
        LeafAtom atom$LeafAtom4 = atom$ContainerAtom0.getLeafAtomOfType(0x63747473);
        ParsableByteArray parsableByteArray4 = atom$LeafAtom4 == null ? null : atom$LeafAtom4.data;
        ChunkIterator atomParsers$ChunkIterator0 = new ChunkIterator(parsableByteArray0, atom$LeafAtom2.data, z);
        parsableByteArray1.setPosition(12);
        int v1 = parsableByteArray1.readUnsignedIntToInt();
        int v2 = parsableByteArray1.readUnsignedIntToInt();
        int v3 = parsableByteArray1.readUnsignedIntToInt();
        if(parsableByteArray4 == null) {
            v4 = 0;
        }
        else {
            parsableByteArray4.setPosition(12);
            v4 = parsableByteArray4.readUnsignedIntToInt();
        }
        int v5 = -1;
        if(parsableByteArray3 == null) {
            v6 = 0;
        }
        else {
            parsableByteArray3.setPosition(12);
            v6 = parsableByteArray3.readUnsignedIntToInt();
            if(v6 > 0) {
                v5 = parsableByteArray3.readUnsignedIntToInt() - 1;
                parsableByteArray2 = parsableByteArray3;
            }
        }
        if(!atomParsers$StszSampleSizeBox0.isFixedSampleSize() || !"audio/raw".equals(track0.format.sampleMimeType) || v1 - 1 != 0 || v4 != 0 || v6 != 0) {
            arr_v = new long[v];
            arr_v1 = new int[v];
            arr_v2 = new long[v];
            arr_v3 = new int[v];
            int v7 = v1 - 1;
            int v8 = v5;
            int v9 = v4;
            int v10 = v3;
            int v11 = v2;
            v12 = 0;
            int v13 = 0;
            v14 = 0;
            int v15 = 0;
            int v16 = 0;
            long v17 = 0L;
            long v18 = 0L;
            while(true) {
                if(v12 >= v) {
                    goto label_108;
                }
                long v19 = v18;
                int v20 = v15;
                boolean z1 = true;
                while(v20 == 0) {
                    z1 = atomParsers$ChunkIterator0.moveNext();
                    if(!z1) {
                        break;
                    }
                    v19 = atomParsers$ChunkIterator0.offset;
                    v20 = atomParsers$ChunkIterator0.numSamples;
                }
                if(z1) {
                    if(parsableByteArray4 != null) {
                        int v22 = v16;
                        while(v22 == 0 && v9 > 0) {
                            v22 = parsableByteArray4.readUnsignedIntToInt();
                            v13 = parsableByteArray4.readInt();
                            --v9;
                        }
                        v16 = v22 - 1;
                    }
                    arr_v[v12] = v19;
                    int v23 = atomParsers$StszSampleSizeBox0.readNextSampleSize();
                    arr_v1[v12] = v23;
                    if(v23 > v14) {
                        v14 = v23;
                    }
                    arr_v2[v12] = v17 + ((long)v13);
                    arr_v3[v12] = parsableByteArray2 == null ? 1 : 0;
                    if(v12 == v8) {
                        arr_v3[v12] = 1;
                        --v6;
                        if(v6 > 0) {
                            v8 = parsableByteArray2.readUnsignedIntToInt() - 1;
                        }
                    }
                    v17 += (long)v10;
                    --v11;
                    if(v11 == 0 && v7 > 0) {
                        --v7;
                        v11 = parsableByteArray1.readUnsignedIntToInt();
                        v10 = parsableByteArray1.readInt();
                    }
                    long v24 = v19 + ((long)arr_v1[v12]);
                    v15 = v20 - 1;
                    ++v12;
                    v18 = v24;
                    continue;
                label_108:
                    v21 = v15;
                    v12 = v;
                }
                else {
                    Log.w("AtomParsers", "Unexpected end of chunk data");
                    arr_v = Arrays.copyOf(arr_v, v12);
                    arr_v1 = Arrays.copyOf(arr_v1, v12);
                    arr_v2 = Arrays.copyOf(arr_v2, v12);
                    arr_v3 = Arrays.copyOf(arr_v3, v12);
                    v21 = v20;
                }
                break;
            }
            while(true) {
                z2 = true;
                if(v9 <= 0) {
                    break;
                }
                if(parsableByteArray4.readUnsignedIntToInt() != 0) {
                    z2 = false;
                    break;
                }
                parsableByteArray4.readInt();
                --v9;
            }
            if(v6 != 0 || v11 != 0 || v21 != 0 || v7 != 0 || v16 != 0 || !z2) {
                Log.w("AtomParsers", "Inconsistent stbl box for track " + track0.id + ": remainingSynchronizationSamples " + v6 + ", remainingSamplesAtTimestampDelta " + v11 + ", remainingSamplesInChunk " + v21 + ", remainingTimestampDeltaChanges " + v7 + ", remainingSamplesAtTimestampOffset " + v16 + (z2 ? "" : ", ctts invalid"));
            }
            v25 = v17 + ((long)v13);
        }
        else {
            long[] arr_v4 = new long[atomParsers$ChunkIterator0.length];
            int[] arr_v5 = new int[atomParsers$ChunkIterator0.length];
            while(atomParsers$ChunkIterator0.moveNext()) {
                int v26 = atomParsers$ChunkIterator0.index;
                arr_v4[v26] = atomParsers$ChunkIterator0.offset;
                arr_v5[v26] = atomParsers$ChunkIterator0.numSamples;
            }
            Results fixedSampleSizeRechunker$Results0 = FixedSampleSizeRechunker.rechunk(Util.getPcmFrameSize(track0.format.pcmEncoding, track0.format.channelCount), arr_v4, arr_v5, ((long)v3));
            arr_v = fixedSampleSizeRechunker$Results0.offsets;
            arr_v1 = fixedSampleSizeRechunker$Results0.sizes;
            v14 = fixedSampleSizeRechunker$Results0.maximumSize;
            arr_v2 = fixedSampleSizeRechunker$Results0.timestamps;
            arr_v3 = fixedSampleSizeRechunker$Results0.flags;
            v25 = fixedSampleSizeRechunker$Results0.duration;
            v12 = v;
        }
        long v27 = Util.scaleLargeTimestamp(v25, 1000000L, track0.timescale);
        long[] arr_v6 = track0.editListDurations;
        if(arr_v6 == null) {
            Util.scaleLargeTimestampsInPlace(arr_v2, 1000000L, track0.timescale);
            return new TrackSampleTable(track0, arr_v, arr_v1, v14, arr_v2, arr_v3, v27);
        }
        if(arr_v6.length == 1 && track0.type == 1 && arr_v2.length >= 2) {
            long v28 = track0.editListMediaTimes[0];
            long v29 = v28 + Util.scaleLargeTimestamp(arr_v6[0], track0.timescale, track0.movieTimescale);
            if(AtomParsers.canApplyEditWithGaplessInfo(arr_v2, v25, v28, v29)) {
                long v30 = Util.scaleLargeTimestamp(v28 - arr_v2[0], track0.format.sampleRate, track0.timescale);
                long v31 = Util.scaleLargeTimestamp(v25 - v29, track0.format.sampleRate, track0.timescale);
                if((v30 != 0L || v31 != 0L) && v30 <= 0x7FFFFFFFL && v31 <= 0x7FFFFFFFL) {
                    gaplessInfoHolder0.encoderDelay = (int)v30;
                    gaplessInfoHolder0.encoderPadding = (int)v31;
                    Util.scaleLargeTimestampsInPlace(arr_v2, 1000000L, track0.timescale);
                    return new TrackSampleTable(track0, arr_v, arr_v1, v14, arr_v2, arr_v3, Util.scaleLargeTimestamp(track0.editListDurations[0], 1000000L, track0.movieTimescale));
                }
            }
        }
        long[] arr_v7 = track0.editListDurations;
        if(arr_v7.length == 1 && arr_v7[0] == 0L) {
            long v32 = track0.editListMediaTimes[0];
            for(int v33 = 0; v33 < arr_v2.length; ++v33) {
                arr_v2[v33] = Util.scaleLargeTimestamp(arr_v2[v33] - v32, 1000000L, track0.timescale);
            }
            return new TrackSampleTable(track0, arr_v, arr_v1, v14, arr_v2, arr_v3, Util.scaleLargeTimestamp(v25 - v32, 1000000L, track0.timescale));
        }
        boolean z3 = track0.type == 1;
        int[] arr_v8 = new int[arr_v7.length];
        int[] arr_v9 = new int[arr_v7.length];
        int v35 = 0;
        int v36 = 0;
        int v37 = 0;
        for(int v34 = 0; true; v34 = v39 + 1) {
            long[] arr_v10 = track0.editListDurations;
            if(v34 >= arr_v10.length) {
                break;
            }
            int v39 = v34;
            long v40 = track0.editListMediaTimes[v39];
            if(v40 != -1L) {
                long v41 = Util.scaleLargeTimestamp(arr_v10[v39], track0.timescale, track0.movieTimescale);
                arr_v8[v39] = Util.binarySearchFloor(arr_v2, v40, true, true);
                arr_v9[v39] = Util.binarySearchCeil(arr_v2, v40 + v41, z3, false);
                while(true) {
                    v42 = arr_v8[v39];
                    v43 = arr_v9[v39];
                    if(v42 >= v43 || (arr_v3[v42] & 1) != 0) {
                        break;
                    }
                    arr_v8[v39] = v42 + 1;
                }
                v36 += v43 - v42;
                v35 |= v37 != v42;
                v37 = v43;
            }
        }
        int v44 = v36 == v12 ? false : 1;
        int v45 = v35 | v44;
        long[] arr_v11 = v45 == 0 ? arr_v : new long[v36];
        int[] arr_v12 = v45 == 0 ? arr_v1 : new int[v36];
        int v46 = v45 == 0 ? v14 : false;
        int[] arr_v13 = v45 == 0 ? arr_v3 : new int[v36];
        long[] arr_v14 = new long[v36];
        int v47 = v46;
        long v48 = 0L;
        int v49 = false;
        for(int v38 = false; v38 < track0.editListDurations.length; ++v38) {
            long v50 = track0.editListMediaTimes[v38];
            int v51 = arr_v8[v38];
            int v52 = arr_v9[v38];
            if(v45 != 0) {
                int v53 = v52 - v51;
                System.arraycopy(arr_v, v51, arr_v11, v49, v53);
                System.arraycopy(arr_v1, v51, arr_v12, v49, v53);
                System.arraycopy(arr_v3, v51, arr_v13, v49, v53);
            }
            while(v51 < v52) {
                arr_v14[v49] = Util.scaleLargeTimestamp(v48, 1000000L, track0.movieTimescale) + Util.scaleLargeTimestamp(Math.max(0L, arr_v2[v51] - v50), 1000000L, track0.timescale);
                if(v45 != 0 && arr_v12[v49] > v47) {
                    v47 = arr_v1[v51];
                }
                ++v49;
                ++v51;
            }
            v48 += track0.editListDurations[v38];
        }
        return new TrackSampleTable(track0, arr_v11, arr_v12, v47, arr_v14, arr_v13, Util.scaleLargeTimestamp(v48, 1000000L, track0.movieTimescale));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray0, int v, int v1, String s, DrmInitData drmInitData0, boolean z) {
        parsableByteArray0.setPosition(12);
        int v2 = parsableByteArray0.readInt();
        StsdData atomParsers$StsdData0 = new StsdData(v2);
        for(int v3 = 0; v3 < v2; ++v3) {
            int v4 = parsableByteArray0.getPosition();
            int v5 = parsableByteArray0.readInt();
            Assertions.checkArgument(v5 > 0, "childAtomSize should be positive");
            int v6 = parsableByteArray0.readInt();
            switch(v6) {
                case 0x63616D6D: {
                    atomParsers$StsdData0.format = Format.createSampleFormat(Integer.toString(v), "application/x-camera-motion", null, -1, null);
                    break;
                }
                case 0x2E6D7033: 
                case 0x4F707573: 
                case 0x61632D33: 
                case 0x61632D34: 
                case 0x616C6163: 
                case 0x616C6177: 
                case 0x64747363: 
                case 0x64747365: 
                case 1685353320: 
                case 0x6474736C: 
                case 1700998451: 
                case 1701733217: 
                case 0x664C6143: 
                case 0x6C70636D: 
                case 0x6D703461: 
                case 1935764850: 
                case 0x73617762: 
                case 0x736F7774: 
                case 0x74776F73: 
                case 1970037111: {
                    AtomParsers.parseAudioSampleEntry(parsableByteArray0, v6, v4, v5, v, s, z, drmInitData0, atomParsers$StsdData0, v3);
                    break;
                }
                case 0x61763031: 
                case 0x61766331: 
                case 0x61766333: 
                case 0x64766131: 
                case 0x64766176: 
                case 0x64766831: 
                case 0x64766865: 
                case 1701733238: 
                case 0x68657631: 
                case 1752589105: 
                case 1836070006: 
                case 1932670515: 
                case 0x76703038: 
                case 0x76703039: {
                    AtomParsers.parseVideoSampleEntry(parsableByteArray0, v6, v4, v5, v, v1, drmInitData0, atomParsers$StsdData0, v3);
                    break;
                }
                case 1414810956: 
                case 0x63363038: 
                case 1937010800: 
                case 1954034535: 
                case 2004251764: {
                    AtomParsers.parseTextSampleEntry(parsableByteArray0, v6, v4, v5, v, s, atomParsers$StsdData0);
                }
            }
            parsableByteArray0.setPosition(v4 + v5);
        }
        return atomParsers$StsdData0;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray0, int v, int v1, int v2, int v3, String s, StsdData atomParsers$StsdData0) {
        parsableByteArray0.setPosition(v1 + 16);
        String s1 = "application/ttml+xml";
        List list0 = null;
        long v4 = 0x7FFFFFFFFFFFFFFFL;
        switch(v) {
            case 1414810956: {
                break;
            }
            case 0x63363038: {
                atomParsers$StsdData0.requiredSampleTransformation = 1;
                s1 = "application/x-mp4-cea-608";
                break;
            }
            case 1937010800: {
                v4 = 0L;
                break;
            }
            case 1954034535: {
                byte[] arr_b = new byte[v2 - 16];
                parsableByteArray0.readBytes(arr_b, 0, v2 - 16);
                list0 = Collections.singletonList(arr_b);
                s1 = "application/x-quicktime-tx3g";
                break;
            }
            case 2004251764: {
                s1 = "application/x-mp4-vtt";
                break;
            }
            default: {
                throw new IllegalStateException();
            }
        }
        atomParsers$StsdData0.format = Format.createTextSampleFormat(Integer.toString(v3), s1, null, -1, 0, s, -1, null, v4, list0);
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray0) {
        long v6;
        int v = 8;
        parsableByteArray0.setPosition(8);
        int v1 = Atom.parseFullAtomVersion(parsableByteArray0.readInt());
        parsableByteArray0.skipBytes((v1 == 0 ? 8 : 16));
        int v2 = parsableByteArray0.readInt();
        parsableByteArray0.skipBytes(4);
        int v3 = parsableByteArray0.getPosition();
        if(v1 == 0) {
            v = 4;
        }
        int v4 = 0;
        for(int v5 = 0; true; ++v5) {
            v6 = 0x8000000000000001L;
            if(v5 >= v) {
                parsableByteArray0.skipBytes(v);
                break;
            }
            if(parsableByteArray0.data[v3 + v5] != -1) {
                long v7 = v1 == 0 ? parsableByteArray0.readUnsignedInt() : parsableByteArray0.readUnsignedLongToLong();
                if(v7 == 0L) {
                    break;
                }
                v6 = v7;
                break;
            }
        }
        parsableByteArray0.skipBytes(16);
        int v8 = parsableByteArray0.readInt();
        int v9 = parsableByteArray0.readInt();
        parsableByteArray0.skipBytes(4);
        int v10 = parsableByteArray0.readInt();
        int v11 = parsableByteArray0.readInt();
        if(v8 == 0 && v9 == 0x10000 && v10 == 0xFFFF0000 && v11 == 0) {
            return new TkhdData(v2, v6, 90);
        }
        if(v8 == 0 && v9 == 0xFFFF0000 && v10 == 0x10000 && v11 == 0) {
            return new TkhdData(v2, v6, 270);
        }
        if(v8 == 0xFFFF0000 && v9 == 0 && v10 == 0 && v11 == 0xFFFF0000) {
            v4 = 180;
        }
        return new TkhdData(v2, v6, v4);
    }

    public static Track parseTrak(ContainerAtom atom$ContainerAtom0, LeafAtom atom$LeafAtom0, long v, DrmInitData drmInitData0, boolean z, boolean z1) {
        ContainerAtom atom$ContainerAtom1 = atom$ContainerAtom0.getContainerAtomOfType(0x6D646961);
        int v1 = AtomParsers.getTrackTypeForHdlr(AtomParsers.parseHdlr(atom$ContainerAtom1.getLeafAtomOfType(0x68646C72).data));
        if(v1 == -1) {
            return null;
        }
        TkhdData atomParsers$TkhdData0 = AtomParsers.parseTkhd(atom$ContainerAtom0.getLeafAtomOfType(0x746B6864).data);
        long v2 = 0x8000000000000001L;
        long v3 = v == 0x8000000000000001L ? TkhdData.access$000(atomParsers$TkhdData0) : v;
        long v4 = AtomParsers.parseMvhd(atom$LeafAtom0.data);
        if(v3 != 0x8000000000000001L) {
            v2 = Util.scaleLargeTimestamp(v3, 1000000L, v4);
        }
        ContainerAtom atom$ContainerAtom2 = atom$ContainerAtom1.getContainerAtomOfType(1835626086).getContainerAtomOfType(1937007212);
        Pair pair0 = AtomParsers.parseMdhd(atom$ContainerAtom1.getLeafAtomOfType(0x6D646864).data);
        StsdData atomParsers$StsdData0 = AtomParsers.parseStsd(atom$ContainerAtom2.getLeafAtomOfType(1937011556).data, TkhdData.access$100(atomParsers$TkhdData0), TkhdData.access$200(atomParsers$TkhdData0), ((String)pair0.second), drmInitData0, z1);
        if(!z) {
            Pair pair1 = AtomParsers.parseEdts(atom$ContainerAtom0.getContainerAtomOfType(1701082227));
            return atomParsers$StsdData0.format == null ? null : new Track(TkhdData.access$100(atomParsers$TkhdData0), v1, ((long)(((Long)pair0.first))), v4, v2, atomParsers$StsdData0.format, atomParsers$StsdData0.requiredSampleTransformation, atomParsers$StsdData0.trackEncryptionBoxes, atomParsers$StsdData0.nalUnitLengthFieldLength, ((long[])pair1.first), ((long[])pair1.second));
        }
        return atomParsers$StsdData0.format == null ? null : new Track(TkhdData.access$100(atomParsers$TkhdData0), v1, ((long)(((Long)pair0.first))), v4, v2, atomParsers$StsdData0.format, atomParsers$StsdData0.requiredSampleTransformation, atomParsers$StsdData0.trackEncryptionBoxes, atomParsers$StsdData0.nalUnitLengthFieldLength, null, null);
    }

    public static Metadata parseUdta(LeafAtom atom$LeafAtom0, boolean z) {
        if(z) {
            return null;
        }
        ParsableByteArray parsableByteArray0 = atom$LeafAtom0.data;
        parsableByteArray0.setPosition(8);
        while(parsableByteArray0.bytesLeft() >= 8) {
            int v = parsableByteArray0.getPosition();
            int v1 = parsableByteArray0.readInt();
            if(parsableByteArray0.readInt() == 0x6D657461) {
                parsableByteArray0.setPosition(v);
                return AtomParsers.parseUdtaMeta(parsableByteArray0, v + v1);
            }
            parsableByteArray0.setPosition(v + v1);
        }
        return null;
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray0, int v) {
        parsableByteArray0.skipBytes(12);
        while(parsableByteArray0.getPosition() < v) {
            int v1 = parsableByteArray0.getPosition();
            int v2 = parsableByteArray0.readInt();
            if(parsableByteArray0.readInt() == 0x696C7374) {
                parsableByteArray0.setPosition(v1);
                return AtomParsers.parseIlst(parsableByteArray0, v1 + v2);
            }
            parsableByteArray0.setPosition(v1 + v2);
        }
        return null;
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray0, int v, int v1, int v2, int v3, int v4, DrmInitData drmInitData0, StsdData atomParsers$StsdData0, int v5) {
        parsableByteArray0.setPosition(v1 + 16);
        parsableByteArray0.skipBytes(16);
        int v6 = parsableByteArray0.readUnsignedShort();
        int v7 = parsableByteArray0.readUnsignedShort();
        parsableByteArray0.skipBytes(50);
        int v8 = parsableByteArray0.getPosition();
        String s = null;
        int v9 = v;
        if(v9 == 1701733238) {
            Pair pair0 = AtomParsers.parseSampleEntryEncryptionData(parsableByteArray0, v1, v2);
            if(pair0 != null) {
                v9 = (int)(((Integer)pair0.first));
                drmInitData0 = drmInitData0 == null ? null : drmInitData0.copyWithSchemeType(((TrackEncryptionBox)pair0.second).schemeType);
                atomParsers$StsdData0.trackEncryptionBoxes[v5] = (TrackEncryptionBox)pair0.second;
            }
            parsableByteArray0.setPosition(v8);
        }
        float f = 1.0f;
        String s1 = null;
        List list0 = null;
        byte[] arr_b = null;
        int v10 = -1;
        while(v8 - v1 < v2) {
            parsableByteArray0.setPosition(v8);
            int v11 = parsableByteArray0.getPosition();
            int v12 = parsableByteArray0.readInt();
            if(v12 == 0 && parsableByteArray0.getPosition() - v1 == v2) {
                break;
            }
            Assertions.checkArgument(v12 > 0, "childAtomSize should be positive");
            switch(parsableByteArray0.readInt()) {
                case 0x61763143: {
                    Assertions.checkState(s1 == null);
                    s1 = "video/av01";
                    break;
                }
                case 1681012275: {
                    Assertions.checkState(s1 == null);
                    s1 = "video/3gpp";
                    break;
                }
                case 1685480259: 
                case 0x64767643: {
                    DolbyVisionConfig dolbyVisionConfig0 = DolbyVisionConfig.parse(parsableByteArray0);
                    if(dolbyVisionConfig0 != null) {
                        s = dolbyVisionConfig0.codecs;
                        s1 = "video/dolby-vision";
                    }
                    break;
                }
                case 1702061171: {
                    Assertions.checkState(s1 == null);
                    Pair pair1 = AtomParsers.parseEsdsFromParent(parsableByteArray0, v11);
                    s1 = (String)pair1.first;
                    list0 = Collections.singletonList(((byte[])pair1.second));
                    break;
                }
                case 0x68766343: {
                    Assertions.checkState(s1 == null);
                    parsableByteArray0.setPosition(v11 + 8);
                    HevcConfig hevcConfig0 = HevcConfig.parse(parsableByteArray0);
                    atomParsers$StsdData0.nalUnitLengthFieldLength = hevcConfig0.nalUnitLengthFieldLength;
                    list0 = hevcConfig0.initializationData;
                    s1 = "video/hevc";
                    break;
                }
                case 0x70617370: {
                    f = AtomParsers.parsePaspFromParent(parsableByteArray0, v11);
                    break;
                }
                case 0x73743364: {
                    int v13 = parsableByteArray0.readUnsignedByte();
                    parsableByteArray0.skipBytes(3);
                    if(v13 == 0) {
                        switch(parsableByteArray0.readUnsignedByte()) {
                            case 0: {
                                v10 = 0;
                                break;
                            }
                            case 1: {
                                v10 = 1;
                                break;
                            }
                            case 2: {
                                v10 = 1;
                                break;
                            }
                            case 3: {
                                v10 = 3;
                            }
                        }
                    }
                    break;
                }
                case 0x73763364: {
                    arr_b = AtomParsers.parseProjFromParent(parsableByteArray0, v11, v12);
                    break;
                }
                case 0x76706343: {
                    Assertions.checkState(s1 == null);
                    s1 = v9 == 0x76703038 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                }
            }
            v8 += v12;
        }
        if(s1 == null) {
            return;
        }
        atomParsers$StsdData0.format = Format.createVideoSampleFormat(Integer.toString(v3), s1, s, -1, -1, v6, v7, -1.0f, list0, v4, f, arr_b, v10, null, drmInitData0);
    }
}

