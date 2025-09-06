package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

public final class VorbisUtil {
    static final class CodeBook {
        public final int dimensions;
        public final int entries;
        public final boolean isOrdered;
        public final long[] lengthMap;
        public final int lookupType;

        public CodeBook(int v, int v1, long[] arr_v, int v2, boolean z) {
            this.dimensions = v;
            this.entries = v1;
            this.lengthMap = arr_v;
            this.lookupType = v2;
            this.isOrdered = z;
        }
    }

    public static final class CommentHeader {
        public final String[] comments;
        public final int length;
        public final String vendor;

        public CommentHeader(String s, String[] arr_s, int v) {
            this.vendor = s;
            this.comments = arr_s;
            this.length = v;
        }
    }

    public static final class Mode {
        public final boolean blockFlag;
        public final int mapping;
        public final int transformType;
        public final int windowType;

        public Mode(boolean z, int v, int v1, int v2) {
            this.blockFlag = z;
            this.windowType = v;
            this.transformType = v1;
            this.mapping = v2;
        }
    }

    public static final class VorbisIdHeader {
        public final int bitrateMax;
        public final int bitrateMin;
        public final int bitrateNominal;
        public final int blockSize0;
        public final int blockSize1;
        public final int channels;
        public final byte[] data;
        public final boolean framingFlag;
        public final long sampleRate;
        public final long version;

        public VorbisIdHeader(long v, int v1, long v2, int v3, int v4, int v5, int v6, int v7, boolean z, byte[] arr_b) {
            this.version = v;
            this.channels = v1;
            this.sampleRate = v2;
            this.bitrateMax = v3;
            this.bitrateNominal = v4;
            this.bitrateMin = v5;
            this.blockSize0 = v6;
            this.blockSize1 = v7;
            this.framingFlag = z;
            this.data = arr_b;
        }

        public int getApproximateBitrate() {
            return this.bitrateNominal == 0 ? (this.bitrateMin + this.bitrateMax) / 2 : this.bitrateNominal;
        }
    }

    private static final String TAG = "VorbisUtil";

    public static int iLog(int v) {
        int v1 = 0;
        while(v > 0) {
            ++v1;
            v >>>= 1;
        }
        return v1;
    }

    private static long mapType1QuantValues(long v, long v1) {
        return (long)Math.floor(Math.pow(v, 1.0 / ((double)v1)));
    }

    private static CodeBook readBook(VorbisBitArray vorbisBitArray0) {
        if(vorbisBitArray0.readBits(24) != 0x564342) {
            throw new ParserException("expected code book to start with [0x56, 0x43, 0x42] at " + vorbisBitArray0.getPosition());
        }
        int v = vorbisBitArray0.readBits(16);
        int v1 = vorbisBitArray0.readBits(24);
        long[] arr_v = new long[v1];
        boolean z = vorbisBitArray0.readBit();
        long v2 = 0L;
        if(z) {
            int v4 = vorbisBitArray0.readBits(5) + 1;
            int v5 = 0;
            while(v5 < v1) {
                int v6 = vorbisBitArray0.readBits(VorbisUtil.iLog(v1 - v5));
                for(int v7 = 0; v7 < v6 && v5 < v1; ++v7) {
                    arr_v[v5] = (long)v4;
                    ++v5;
                }
                ++v4;
            }
        }
        else {
            boolean z1 = vorbisBitArray0.readBit();
            for(int v3 = 0; v3 < v1; ++v3) {
                if(!z1) {
                    arr_v[v3] = (long)(vorbisBitArray0.readBits(5) + 1);
                }
                else if(vorbisBitArray0.readBit()) {
                    arr_v[v3] = (long)(vorbisBitArray0.readBits(5) + 1);
                }
                else {
                    arr_v[v3] = 0L;
                }
            }
        }
        int v8 = vorbisBitArray0.readBits(4);
        if(v8 > 2) {
            throw new ParserException("lookup type greater than 2 not decodable: " + v8);
        }
        if(v8 == 1 || v8 == 2) {
            vorbisBitArray0.skipBits(0x20);
            vorbisBitArray0.skipBits(0x20);
            int v9 = vorbisBitArray0.readBits(4);
            vorbisBitArray0.skipBits(1);
            if(v8 != 1) {
                v2 = ((long)v1) * ((long)v);
            }
            else if(v != 0) {
                v2 = VorbisUtil.mapType1QuantValues(v1, v);
            }
            vorbisBitArray0.skipBits(((int)(v2 * ((long)(v9 + 1)))));
        }
        return new CodeBook(v, v1, arr_v, v8, z);
    }

    private static void readFloors(VorbisBitArray vorbisBitArray0) {
        int v = vorbisBitArray0.readBits(6);
        for(int v1 = 0; v1 < v + 1; ++v1) {
            int v2 = vorbisBitArray0.readBits(16);
        alab1:
            switch(v2) {
                case 0: {
                    vorbisBitArray0.skipBits(8);
                    vorbisBitArray0.skipBits(16);
                    vorbisBitArray0.skipBits(16);
                    vorbisBitArray0.skipBits(6);
                    vorbisBitArray0.skipBits(8);
                    int v3 = vorbisBitArray0.readBits(4);
                    for(int v4 = 0; v4 < v3 + 1; ++v4) {
                        vorbisBitArray0.skipBits(8);
                    }
                    break;
                }
                case 1: {
                    int v5 = vorbisBitArray0.readBits(5);
                    int[] arr_v = new int[v5];
                    int v6 = -1;
                    for(int v7 = 0; v7 < v5; ++v7) {
                        int v8 = vorbisBitArray0.readBits(4);
                        arr_v[v7] = v8;
                        if(v8 > v6) {
                            v6 = v8;
                        }
                    }
                    int v9 = v6 + 1;
                    int[] arr_v1 = new int[v9];
                    for(int v10 = 0; v10 < v9; ++v10) {
                        arr_v1[v10] = vorbisBitArray0.readBits(3) + 1;
                        int v11 = vorbisBitArray0.readBits(2);
                        if(v11 > 0) {
                            vorbisBitArray0.skipBits(8);
                        }
                        for(int v12 = 0; v12 < 1 << v11; ++v12) {
                            vorbisBitArray0.skipBits(8);
                        }
                    }
                    vorbisBitArray0.skipBits(2);
                    int v13 = vorbisBitArray0.readBits(4);
                    int v15 = 0;
                    for(int v14 = 0; true; ++v14) {
                        if(v14 >= v5) {
                            break alab1;
                        }
                        v15 += arr_v1[arr_v[v14]];
                        for(int v16 = 0; v16 < v15; ++v16) {
                            vorbisBitArray0.skipBits(v13);
                        }
                    }
                }
                default: {
                    throw new ParserException("floor type greater than 1 not decodable: " + v2);
                }
            }
        }
    }

    private static void readMappings(int v, VorbisBitArray vorbisBitArray0) {
        int v1 = vorbisBitArray0.readBits(6);
        for(int v2 = 0; v2 < v1 + 1; ++v2) {
            int v3 = vorbisBitArray0.readBits(16);
            if(v3 == 0) {
                int v4 = vorbisBitArray0.readBit() ? vorbisBitArray0.readBits(4) + 1 : 1;
                if(vorbisBitArray0.readBit()) {
                    int v5 = vorbisBitArray0.readBits(8);
                    for(int v6 = 0; v6 < v5 + 1; ++v6) {
                        vorbisBitArray0.skipBits(VorbisUtil.iLog(v - 1));
                        vorbisBitArray0.skipBits(VorbisUtil.iLog(v - 1));
                    }
                }
                if(vorbisBitArray0.readBits(2) != 0) {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
                if(v4 > 1) {
                    for(int v7 = 0; v7 < v; ++v7) {
                        vorbisBitArray0.skipBits(4);
                    }
                }
                for(int v8 = 0; v8 < v4; ++v8) {
                    vorbisBitArray0.skipBits(8);
                    vorbisBitArray0.skipBits(8);
                    vorbisBitArray0.skipBits(8);
                }
            }
            else {
                Log.e("VorbisUtil", "mapping type other than 0 not supported: " + v3);
            }
        }
    }

    private static Mode[] readModes(VorbisBitArray vorbisBitArray0) {
        int v = vorbisBitArray0.readBits(6);
        Mode[] arr_vorbisUtil$Mode = new Mode[v + 1];
        for(int v1 = 0; v1 < v + 1; ++v1) {
            arr_vorbisUtil$Mode[v1] = new Mode(vorbisBitArray0.readBit(), vorbisBitArray0.readBits(16), vorbisBitArray0.readBits(16), vorbisBitArray0.readBits(8));
        }
        return arr_vorbisUtil$Mode;
    }

    private static void readResidues(VorbisBitArray vorbisBitArray0) {
        int v = vorbisBitArray0.readBits(6);
        for(int v1 = 0; v1 < v + 1; ++v1) {
            if(vorbisBitArray0.readBits(16) > 2) {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
            vorbisBitArray0.skipBits(24);
            vorbisBitArray0.skipBits(24);
            vorbisBitArray0.skipBits(24);
            int v2 = vorbisBitArray0.readBits(6);
            vorbisBitArray0.skipBits(8);
            int[] arr_v = new int[v2 + 1];
            for(int v3 = 0; v3 < v2 + 1; ++v3) {
                int v4 = vorbisBitArray0.readBits(3);
                arr_v[v3] = (vorbisBitArray0.readBit() ? vorbisBitArray0.readBits(5) : 0) * 8 + v4;
            }
            for(int v5 = 0; v5 < v2 + 1; ++v5) {
                for(int v6 = 0; v6 < 8; ++v6) {
                    if((arr_v[v5] & 1 << v6) != 0) {
                        vorbisBitArray0.skipBits(8);
                    }
                }
            }
        }
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray0) {
        return VorbisUtil.readVorbisCommentHeader(parsableByteArray0, true, true);
    }

    public static CommentHeader readVorbisCommentHeader(ParsableByteArray parsableByteArray0, boolean z, boolean z1) {
        if(z) {
            VorbisUtil.verifyVorbisHeaderCapturePattern(3, parsableByteArray0, false);
        }
        String s = parsableByteArray0.readString(((int)parsableByteArray0.readLittleEndianUnsignedInt()));
        long v1 = parsableByteArray0.readLittleEndianUnsignedInt();
        String[] arr_s = new String[((int)v1)];
        int v2 = s.length() + 15;
        for(int v = 0; ((long)v) < v1; ++v) {
            String s1 = parsableByteArray0.readString(((int)parsableByteArray0.readLittleEndianUnsignedInt()));
            arr_s[v] = s1;
            v2 = v2 + 4 + s1.length();
        }
        if(z1 && (parsableByteArray0.readUnsignedByte() & 1) == 0) {
            throw new ParserException("framing bit expected to be set");
        }
        return new CommentHeader(s, arr_s, v2 + 1);
    }

    public static VorbisIdHeader readVorbisIdentificationHeader(ParsableByteArray parsableByteArray0) {
        VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray0, false);
        long v = parsableByteArray0.readLittleEndianUnsignedInt();
        int v1 = parsableByteArray0.readUnsignedByte();
        long v2 = parsableByteArray0.readLittleEndianUnsignedInt();
        int v3 = parsableByteArray0.readLittleEndianInt();
        int v4 = parsableByteArray0.readLittleEndianInt();
        int v5 = parsableByteArray0.readLittleEndianInt();
        int v6 = parsableByteArray0.readUnsignedByte();
        int v7 = (int)Math.pow(2.0, v6 & 15);
        int v8 = (int)Math.pow(2.0, (v6 & 0xF0) >> 4);
        return (parsableByteArray0.readUnsignedByte() & 1) <= 0 ? new VorbisIdHeader(v, v1, v2, v3, v4, v5, v7, v8, false, Arrays.copyOf(parsableByteArray0.data, parsableByteArray0.limit())) : new VorbisIdHeader(v, v1, v2, v3, v4, v5, v7, v8, true, Arrays.copyOf(parsableByteArray0.data, parsableByteArray0.limit()));
    }

    public static Mode[] readVorbisModes(ParsableByteArray parsableByteArray0, int v) {
        VorbisUtil.verifyVorbisHeaderCapturePattern(5, parsableByteArray0, false);
        int v2 = parsableByteArray0.readUnsignedByte();
        VorbisBitArray vorbisBitArray0 = new VorbisBitArray(parsableByteArray0.data);
        vorbisBitArray0.skipBits(parsableByteArray0.getPosition() * 8);
        for(int v3 = 0; v3 < v2 + 1; ++v3) {
            VorbisUtil.readBook(vorbisBitArray0);
        }
        int v4 = vorbisBitArray0.readBits(6);
        for(int v1 = 0; v1 < v4 + 1; ++v1) {
            if(vorbisBitArray0.readBits(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        VorbisUtil.readFloors(vorbisBitArray0);
        VorbisUtil.readResidues(vorbisBitArray0);
        VorbisUtil.readMappings(v, vorbisBitArray0);
        Mode[] arr_vorbisUtil$Mode = VorbisUtil.readModes(vorbisBitArray0);
        if(!vorbisBitArray0.readBit()) {
            throw new ParserException("framing bit after modes not set as expected");
        }
        return arr_vorbisUtil$Mode;
    }

    public static boolean verifyVorbisHeaderCapturePattern(int v, ParsableByteArray parsableByteArray0, boolean z) {
        if(parsableByteArray0.bytesLeft() < 7) {
            if(!z) {
                throw new ParserException("too short header: " + parsableByteArray0.bytesLeft());
            }
            return false;
        }
        if(parsableByteArray0.readUnsignedByte() != v) {
            if(z) {
                return false;
            }
            String s = Integer.toHexString(v);
            throw new ParserException((s.length() == 0 ? new String("expected header type ") : "expected header type " + s));
        }
        if(parsableByteArray0.readUnsignedByte() == 0x76 && parsableByteArray0.readUnsignedByte() == 0x6F && parsableByteArray0.readUnsignedByte() == 0x72 && parsableByteArray0.readUnsignedByte() == 98 && parsableByteArray0.readUnsignedByte() == 105 && parsableByteArray0.readUnsignedByte() == 0x73) {
            return true;
        }
        if(!z) {
            throw new ParserException("expected characters \'vorbis\'");
        }
        return false;
    }
}

