package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import b3.Z;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

final class WavHeaderReader {
    static final class ChunkHeader {
        public static final int SIZE_IN_BYTES = 8;
        public final int id;
        public final long size;

        private ChunkHeader(int v, long v1) {
            this.id = v;
            this.size = v1;
        }

        public static ChunkHeader peek(ExtractorInput extractorInput0, ParsableByteArray parsableByteArray0) {
            extractorInput0.peekFully(parsableByteArray0.data, 0, 8);
            parsableByteArray0.setPosition(0);
            return new ChunkHeader(parsableByteArray0.readInt(), parsableByteArray0.readLittleEndianUnsignedInt());
        }
    }

    private static final String TAG = "WavHeaderReader";

    public static WavHeader peek(ExtractorInput extractorInput0) {
        Assertions.checkNotNull(extractorInput0);
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(16);
        if(ChunkHeader.peek(extractorInput0, parsableByteArray0).id != 1380533830) {
            return null;
        }
        extractorInput0.peekFully(parsableByteArray0.data, 0, 4);
        parsableByteArray0.setPosition(0);
        int v = parsableByteArray0.readInt();
        if(v != 0x57415645) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + v);
            return null;
        }
        ChunkHeader wavHeaderReader$ChunkHeader0;
        for(wavHeaderReader$ChunkHeader0 = ChunkHeader.peek(extractorInput0, parsableByteArray0); wavHeaderReader$ChunkHeader0.id != 0x666D7420; wavHeaderReader$ChunkHeader0 = ChunkHeader.peek(extractorInput0, parsableByteArray0)) {
            extractorInput0.advancePeekPosition(((int)wavHeaderReader$ChunkHeader0.size));
        }
        Assertions.checkState(wavHeaderReader$ChunkHeader0.size >= 16L);
        extractorInput0.peekFully(parsableByteArray0.data, 0, 16);
        parsableByteArray0.setPosition(0);
        int v1 = parsableByteArray0.readLittleEndianUnsignedShort();
        int v2 = parsableByteArray0.readLittleEndianUnsignedShort();
        int v3 = parsableByteArray0.readLittleEndianUnsignedIntToInt();
        int v4 = parsableByteArray0.readLittleEndianUnsignedIntToInt();
        int v5 = parsableByteArray0.readLittleEndianUnsignedShort();
        int v6 = parsableByteArray0.readLittleEndianUnsignedShort();
        int v7 = ((int)wavHeaderReader$ChunkHeader0.size) - 16;
        if(v7 > 0) {
            byte[] arr_b = new byte[v7];
            extractorInput0.peekFully(arr_b, 0, v7);
            return new WavHeader(v1, v2, v3, v4, v5, v6, arr_b);
        }
        return new WavHeader(v1, v2, v3, v4, v5, v6, Util.EMPTY_BYTE_ARRAY);
    }

    public static Pair skipToData(ExtractorInput extractorInput0) {
        Assertions.checkNotNull(extractorInput0);
        extractorInput0.resetPeekPosition();
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(8);
        ChunkHeader wavHeaderReader$ChunkHeader0;
        for(wavHeaderReader$ChunkHeader0 = ChunkHeader.peek(extractorInput0, parsableByteArray0); true; wavHeaderReader$ChunkHeader0 = ChunkHeader.peek(extractorInput0, parsableByteArray0)) {
            int v = wavHeaderReader$ChunkHeader0.id;
            switch(v) {
                case 1684108385: {
                    extractorInput0.skipFully(8);
                    long v1 = extractorInput0.getPosition();
                    long v2 = wavHeaderReader$ChunkHeader0.size + v1;
                    long v3 = extractorInput0.getLength();
                    if(v3 != -1L && v2 > v3) {
                        Log.w("WavHeaderReader", "Data exceeds input length: " + v2 + ", " + v3);
                        v2 = v3;
                    }
                    return Pair.create(v1, v2);
                }
                case 1380533830: 
                case 0x666D7420: {
                    break;
                }
                default: {
                    Z.q(39, v, "Ignoring unknown WAV chunk: ", "WavHeaderReader");
                    break;
                }
            }
            long v4 = wavHeaderReader$ChunkHeader0.id == 1380533830 ? 12L : wavHeaderReader$ChunkHeader0.size + 8L;
            if(v4 > 0x7FFFFFFFL) {
                break;
            }
            extractorInput0.skipFully(((int)v4));
        }
        throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + wavHeaderReader$ChunkHeader0.id);
    }
}

