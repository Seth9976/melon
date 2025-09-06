package com.google.android.exoplayer2.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo.Pattern;
import android.media.MediaCodec.CryptoInfo;
import com.google.android.exoplayer2.util.Util;

public final class CryptoInfo {
    @TargetApi(24)
    static final class PatternHolderV24 {
        private final MediaCodec.CryptoInfo frameworkCryptoInfo;
        private final MediaCodec.CryptoInfo.Pattern pattern;

        private PatternHolderV24(MediaCodec.CryptoInfo mediaCodec$CryptoInfo0) {
            this.frameworkCryptoInfo = mediaCodec$CryptoInfo0;
            this.pattern = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        public PatternHolderV24(MediaCodec.CryptoInfo mediaCodec$CryptoInfo0, com.google.android.exoplayer2.decoder.CryptoInfo.1 cryptoInfo$10) {
            this(mediaCodec$CryptoInfo0);
        }

        public static void access$100(PatternHolderV24 cryptoInfo$PatternHolderV240, int v, int v1) {
            cryptoInfo$PatternHolderV240.set(v, v1);
        }

        private void set(int v, int v1) {
            this.pattern.set(v, v1);
            this.frameworkCryptoInfo.setPattern(this.pattern);
        }
    }

    public int clearBlocks;
    public int encryptedBlocks;
    private final MediaCodec.CryptoInfo frameworkCryptoInfo;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    private final PatternHolderV24 patternHolder;

    public CryptoInfo() {
        MediaCodec.CryptoInfo mediaCodec$CryptoInfo0 = new MediaCodec.CryptoInfo();
        this.frameworkCryptoInfo = mediaCodec$CryptoInfo0;
        this.patternHolder = Util.SDK_INT < 24 ? null : new PatternHolderV24(mediaCodec$CryptoInfo0, null);
    }

    public MediaCodec.CryptoInfo getFrameworkCryptoInfo() {
        return this.frameworkCryptoInfo;
    }

    @Deprecated
    public MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return this.getFrameworkCryptoInfo();
    }

    public void set(int v, int[] arr_v, int[] arr_v1, byte[] arr_b, byte[] arr_b1, int v1, int v2, int v3) {
        this.numSubSamples = v;
        this.numBytesOfClearData = arr_v;
        this.numBytesOfEncryptedData = arr_v1;
        this.key = arr_b;
        this.iv = arr_b1;
        this.mode = v1;
        this.encryptedBlocks = v2;
        this.clearBlocks = v3;
        this.frameworkCryptoInfo.numSubSamples = v;
        this.frameworkCryptoInfo.numBytesOfClearData = arr_v;
        this.frameworkCryptoInfo.numBytesOfEncryptedData = arr_v1;
        this.frameworkCryptoInfo.key = arr_b;
        this.frameworkCryptoInfo.iv = arr_b1;
        this.frameworkCryptoInfo.mode = v1;
        if(Util.SDK_INT >= 24) {
            PatternHolderV24.access$100(this.patternHolder, v2, v3);
        }
    }

    class com.google.android.exoplayer2.decoder.CryptoInfo.1 {
    }

}

