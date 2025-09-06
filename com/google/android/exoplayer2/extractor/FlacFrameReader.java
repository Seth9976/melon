package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.FlacStreamMetadata;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

public final class FlacFrameReader {
    public static final class SampleNumberHolder {
        public long sampleNumber;

    }

    private static boolean checkAndReadBlockSizeSamples(ParsableByteArray parsableByteArray0, FlacStreamMetadata flacStreamMetadata0, int v) {
        int v1 = FlacFrameReader.readFrameBlockSizeSamplesFromKey(parsableByteArray0, v);
        return v1 != -1 && v1 <= flacStreamMetadata0.maxBlockSizeSamples;
    }

    private static boolean checkAndReadCrc(ParsableByteArray parsableByteArray0, int v) {
        return parsableByteArray0.readUnsignedByte() == Util.crc8(parsableByteArray0.data, v, parsableByteArray0.getPosition() - 1, 0);
    }

    private static boolean checkAndReadFirstSampleNumber(ParsableByteArray parsableByteArray0, FlacStreamMetadata flacStreamMetadata0, boolean z, SampleNumberHolder flacFrameReader$SampleNumberHolder0) {
        long v;
        try {
            v = parsableByteArray0.readUtf8EncodedLong();
        }
        catch(NumberFormatException unused_ex) {
            return false;
        }
        if(!z) {
            v *= (long)flacStreamMetadata0.maxBlockSizeSamples;
        }
        flacFrameReader$SampleNumberHolder0.sampleNumber = v;
        return true;
    }

    // 去混淆评级： 低(35)
    public static boolean checkAndReadFrameHeader(ParsableByteArray parsableByteArray0, FlacStreamMetadata flacStreamMetadata0, int v, SampleNumberHolder flacFrameReader$SampleNumberHolder0) {
        long v1 = parsableByteArray0.readUnsignedInt();
        return Long.compare(v1 >>> 16, v) == 0 ? FlacFrameReader.checkChannelAssignment(((int)(v1 >> 4 & 15L)), flacStreamMetadata0) && FlacFrameReader.checkBitsPerSample(((int)(v1 >> 1 & 7L)), flacStreamMetadata0) && (v1 & 1L) != 1L && FlacFrameReader.checkAndReadFirstSampleNumber(parsableByteArray0, flacStreamMetadata0, Long.compare(v1 >>> 16 & 1L, 1L) == 0, flacFrameReader$SampleNumberHolder0) && FlacFrameReader.checkAndReadBlockSizeSamples(parsableByteArray0, flacStreamMetadata0, ((int)(v1 >> 12 & 15L))) && FlacFrameReader.checkAndReadSampleRate(parsableByteArray0, flacStreamMetadata0, ((int)(v1 >> 8 & 15L))) && FlacFrameReader.checkAndReadCrc(parsableByteArray0, parsableByteArray0.getPosition()) : false;
    }

    private static boolean checkAndReadSampleRate(ParsableByteArray parsableByteArray0, FlacStreamMetadata flacStreamMetadata0, int v) {
        int v1 = flacStreamMetadata0.sampleRate;
        if(v == 0) {
            return true;
        }
        if(v <= 11) {
            return v == flacStreamMetadata0.sampleRateLookupKey;
        }
        if(v == 12) {
            return parsableByteArray0.readUnsignedByte() * 1000 == v1;
        }
        if(v <= 14) {
            int v2 = parsableByteArray0.readUnsignedShort();
            if(v == 14) {
                v2 *= 10;
            }
            return v2 == v1;
        }
        return false;
    }

    private static boolean checkBitsPerSample(int v, FlacStreamMetadata flacStreamMetadata0) {
        return v == 0 ? true : v == flacStreamMetadata0.bitsPerSampleLookupKey;
    }

    private static boolean checkChannelAssignment(int v, FlacStreamMetadata flacStreamMetadata0) {
        return v > 7 ? v <= 10 && flacStreamMetadata0.channels == 2 : v == flacStreamMetadata0.channels - 1;
    }

    public static boolean checkFrameHeaderFromPeek(ExtractorInput extractorInput0, FlacStreamMetadata flacStreamMetadata0, int v, SampleNumberHolder flacFrameReader$SampleNumberHolder0) {
        long v1 = extractorInput0.getPeekPosition();
        byte[] arr_b = new byte[2];
        extractorInput0.peekFully(arr_b, 0, 2);
        if(((arr_b[0] & 0xFF) << 8 | arr_b[1] & 0xFF) != v) {
            extractorInput0.resetPeekPosition();
            extractorInput0.advancePeekPosition(((int)(v1 - extractorInput0.getPosition())));
            return false;
        }
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(16);
        System.arraycopy(arr_b, 0, parsableByteArray0.data, 0, 2);
        parsableByteArray0.setLimit(ExtractorUtil.peekToLength(extractorInput0, parsableByteArray0.data, 2, 14));
        extractorInput0.resetPeekPosition();
        extractorInput0.advancePeekPosition(((int)(v1 - extractorInput0.getPosition())));
        return FlacFrameReader.checkAndReadFrameHeader(parsableByteArray0, flacStreamMetadata0, v, flacFrameReader$SampleNumberHolder0);
    }

    public static long getFirstSampleNumber(ExtractorInput extractorInput0, FlacStreamMetadata flacStreamMetadata0) {
        extractorInput0.resetPeekPosition();
        boolean z = true;
        extractorInput0.advancePeekPosition(1);
        byte[] arr_b = new byte[1];
        extractorInput0.peekFully(arr_b, 0, 1);
        if((arr_b[0] & 1) != 1) {
            z = false;
        }
        extractorInput0.advancePeekPosition(2);
        ParsableByteArray parsableByteArray0 = new ParsableByteArray((z ? 7 : 6));
        parsableByteArray0.setLimit(ExtractorUtil.peekToLength(extractorInput0, parsableByteArray0.data, 0, (z ? 7 : 6)));
        extractorInput0.resetPeekPosition();
        SampleNumberHolder flacFrameReader$SampleNumberHolder0 = new SampleNumberHolder();
        if(!FlacFrameReader.checkAndReadFirstSampleNumber(parsableByteArray0, flacStreamMetadata0, z, flacFrameReader$SampleNumberHolder0)) {
            throw new ParserException();
        }
        return flacFrameReader$SampleNumberHolder0.sampleNumber;
    }

    public static int readFrameBlockSizeSamplesFromKey(ParsableByteArray parsableByteArray0, int v) {
        switch(v) {
            case 1: {
                return 0xC0;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return 0x240 << v - 2;
            }
            case 6: {
                return parsableByteArray0.readUnsignedByte() + 1;
            }
            case 7: {
                return parsableByteArray0.readUnsignedShort() + 1;
            }
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: {
                return 0x100 << v - 8;
            }
            default: {
                return -1;
            }
        }
    }
}

