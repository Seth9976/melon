package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class CeaUtil {
    private static final int COUNTRY_CODE = 0xB5;
    private static final int PAYLOAD_TYPE_CC = 4;
    private static final int PROVIDER_CODE_ATSC = 49;
    private static final int PROVIDER_CODE_DIRECTV = 0x2F;
    private static final String TAG = "CeaUtil";
    public static final int USER_DATA_IDENTIFIER_GA94 = 1195456820;
    public static final int USER_DATA_TYPE_CODE_MPEG_CC = 3;

    public static void consume(long v, ParsableByteArray parsableByteArray0, TrackOutput[] arr_trackOutput) {
        int v9;
        while(parsableByteArray0.bytesLeft() > 1) {
            int v1 = CeaUtil.readNon255TerminatedValue(parsableByteArray0);
            int v2 = CeaUtil.readNon255TerminatedValue(parsableByteArray0);
            int v3 = parsableByteArray0.getPosition() + v2;
            if(v2 == -1 || v2 > parsableByteArray0.bytesLeft()) {
                Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                v3 = parsableByteArray0.limit();
            }
            else if(v1 == 4 && v2 >= 8) {
                int v4 = parsableByteArray0.readUnsignedByte();
                int v5 = parsableByteArray0.readUnsignedShort();
                int v6 = v5 == 49 ? parsableByteArray0.readInt() : 0;
                int v7 = parsableByteArray0.readUnsignedByte();
                if(v5 == 0x2F) {
                    parsableByteArray0.skipBytes(1);
                }
                int v8 = v4 != 0xB5 || v5 != 0x2F && v5 != 49 || v7 != 3 ? 0 : 1;
                if(v5 == 49) {
                    if(v6 != 1195456820) {
                        v9 = 0;
                    }
                    v8 &= v9;
                }
                if(v8 != 0) {
                    CeaUtil.consumeCcData(v, parsableByteArray0, arr_trackOutput);
                }
            }
            v9 = 1;
            parsableByteArray0.setPosition(v3);
        }
    }

    public static void consumeCcData(long v, ParsableByteArray parsableByteArray0, TrackOutput[] arr_trackOutput) {
        int v1 = parsableByteArray0.readUnsignedByte();
        if((v1 & 0x40) != 0) {
            parsableByteArray0.skipBytes(1);
            int v2 = (v1 & 0x1F) * 3;
            int v3 = parsableByteArray0.getPosition();
            for(int v4 = 0; v4 < arr_trackOutput.length; ++v4) {
                TrackOutput trackOutput0 = arr_trackOutput[v4];
                parsableByteArray0.setPosition(v3);
                trackOutput0.sampleData(parsableByteArray0, v2);
                trackOutput0.sampleMetadata(v, 1, v2, 0, null);
            }
        }
    }

    private static int readNon255TerminatedValue(ParsableByteArray parsableByteArray0) {
        int v = 0;
        do {
            if(parsableByteArray0.bytesLeft() == 0) {
                return -1;
            }
            int v1 = parsableByteArray0.readUnsignedByte();
            v += v1;
        }
        while(v1 == 0xFF);
        return v;
    }
}

