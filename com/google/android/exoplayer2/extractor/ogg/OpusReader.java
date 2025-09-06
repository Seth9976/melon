package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class OpusReader extends StreamReader {
    private static final int DEFAULT_SEEK_PRE_ROLL_SAMPLES = 0xF00;
    private static final int OPUS_CODE = 0x4F707573;
    private static final byte[] OPUS_SIGNATURE = null;
    private static final int SAMPLE_RATE = 48000;
    private boolean headerRead;

    static {
        OpusReader.OPUS_SIGNATURE = new byte[]{0x4F, 0x70, 0x75, 0x73, 72, 101, 97, 100};
    }

    private long getPacketDurationUs(byte[] arr_b) {
        int v = 2;
        int v1 = arr_b[0] & 0xFF;
        int v2 = arr_b[0] & 3;
        if(v2 == 0) {
            v = 1;
        }
        else if(v2 != 1 && v2 != 2) {
            v = arr_b[1] & 0x3F;
        }
        int v3 = v1 >> 3 & 3;
        if(v1 >> 3 >= 16) {
            return ((long)v) * ((long)(2500 << v3));
        }
        if(v1 >> 3 >= 12) {
            return ((long)v) * ((long)(10000 << (v1 >> 3 & 1)));
        }
        return v3 == 3 ? ((long)v) * 60000L : ((long)v) * ((long)(10000 << v3));
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public long preparePayload(ParsableByteArray parsableByteArray0) {
        return this.convertTimeToGranule(this.getPacketDurationUs(parsableByteArray0.data));
    }

    private void putNativeOrderLong(List list0, int v) {
        list0.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((long)v) * 1000000000L / 48000L).array());
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public boolean readHeaders(ParsableByteArray parsableByteArray0, long v, SetupData streamReader$SetupData0) {
        boolean z = true;
        if(!this.headerRead) {
            byte[] arr_b = Arrays.copyOf(parsableByteArray0.data, parsableByteArray0.limit());
            int v1 = arr_b[9] & 0xFF;
            int v2 = (arr_b[11] & 0xFF) << 8 | arr_b[10] & 0xFF;
            ArrayList arrayList0 = new ArrayList(3);
            arrayList0.add(arr_b);
            this.putNativeOrderLong(arrayList0, v2);
            this.putNativeOrderLong(arrayList0, 0xF00);
            streamReader$SetupData0.format = Format.createAudioSampleFormat(null, "audio/opus", null, -1, -1, v1, 48000, arrayList0, null, 0, null);
            this.headerRead = true;
            return true;
        }
        if(parsableByteArray0.readInt() != 0x4F707573) {
            z = false;
        }
        parsableByteArray0.setPosition(0);
        return z;
    }

    @Override  // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z) {
        super.reset(z);
        if(z) {
            this.headerRead = false;
        }
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray0) {
        byte[] arr_b = OpusReader.OPUS_SIGNATURE;
        if(parsableByteArray0.bytesLeft() < arr_b.length) {
            return false;
        }
        byte[] arr_b1 = new byte[arr_b.length];
        parsableByteArray0.readBytes(arr_b1, 0, arr_b.length);
        return Arrays.equals(arr_b1, arr_b);
    }
}

