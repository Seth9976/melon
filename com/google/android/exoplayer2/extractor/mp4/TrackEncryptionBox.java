package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

public final class TrackEncryptionBox {
    private static final String TAG = "TrackEncryptionBox";
    public final CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;
    public final String schemeType;

    public TrackEncryptionBox(boolean z, String s, int v, byte[] arr_b, int v1, int v2, byte[] arr_b1) {
        Assertions.checkArgument(((boolean)((arr_b1 == null ? 1 : 0) ^ (v == 0 ? 1 : 0))));
        this.isEncrypted = z;
        this.schemeType = s;
        this.perSampleIvSize = v;
        this.defaultInitializationVector = arr_b1;
        this.cryptoData = new CryptoData(TrackEncryptionBox.schemeToCryptoMode(s), arr_b, v1, v2);
    }

    private static int schemeToCryptoMode(String s) {
        if(s == null) {
            return 1;
        }
        switch(s) {
            case "cbc1": {
                return 2;
            }
            case "cbcs": {
                return 2;
            }
            case "cenc": {
                return 1;
            }
            case "cens": {
                return 1;
            }
            default: {
                Log.w("TrackEncryptionBox", "Unsupported protection scheme type \'" + s + "\'. Assuming AES-CTR crypto mode.");
                return 1;
            }
        }
    }
}

