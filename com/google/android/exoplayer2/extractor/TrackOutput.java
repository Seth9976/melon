package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

public interface TrackOutput {
    public static final class CryptoData {
        public final int clearBlocks;
        public final int cryptoMode;
        public final int encryptedBlocks;
        public final byte[] encryptionKey;

        public CryptoData(int v, byte[] arr_b, int v1, int v2) {
            this.cryptoMode = v;
            this.encryptionKey = arr_b;
            this.encryptedBlocks = v1;
            this.clearBlocks = v2;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(object0 != null) {
                Class class0 = object0.getClass();
                return CryptoData.class == class0 && this.cryptoMode == ((CryptoData)object0).cryptoMode && this.encryptedBlocks == ((CryptoData)object0).encryptedBlocks && this.clearBlocks == ((CryptoData)object0).clearBlocks && Arrays.equals(this.encryptionKey, ((CryptoData)object0).encryptionKey);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return ((Arrays.hashCode(this.encryptionKey) + this.cryptoMode * 0x1F) * 0x1F + this.encryptedBlocks) * 0x1F + this.clearBlocks;
        }
    }

    void format(Format arg1);

    int sampleData(ExtractorInput arg1, int arg2, boolean arg3);

    void sampleData(ParsableByteArray arg1, int arg2);

    void sampleMetadata(long arg1, int arg2, int arg3, int arg4, CryptoData arg5);
}

