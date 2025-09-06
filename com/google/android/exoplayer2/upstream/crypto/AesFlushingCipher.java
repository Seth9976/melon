package com.google.android.exoplayer2.upstream.crypto;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesFlushingCipher {
    private final int blockSize;
    private final Cipher cipher;
    private final byte[] flushedBlock;
    private int pendingXorBytes;
    private final byte[] zerosBlock;

    public AesFlushingCipher(int v, byte[] arr_b, long v1, long v2) {
        try {
            Cipher cipher0 = Cipher.getInstance("AES/CTR/NoPadding");
            this.cipher = cipher0;
            int v3 = cipher0.getBlockSize();
            this.blockSize = v3;
            this.zerosBlock = new byte[v3];
            this.flushedBlock = new byte[v3];
            int v4 = (int)(v2 % ((long)v3));
            cipher0.init(v, new SecretKeySpec(arr_b, Util.splitAtFirst(cipher0.getAlgorithm(), "/")[0]), new IvParameterSpec(this.getInitializationVector(v1, v2 / ((long)v3))));
            if(v4 != 0) {
                this.updateInPlace(new byte[v4], 0, v4);
            }
        }
        catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException noSuchAlgorithmException0) {
            throw new RuntimeException(noSuchAlgorithmException0);
        }
    }

    private byte[] getInitializationVector(long v, long v1) {
        return ByteBuffer.allocate(16).putLong(v).putLong(v1).array();
    }

    private int nonFlushingUpdate(byte[] arr_b, int v, int v1, byte[] arr_b1, int v2) {
        try {
            return this.cipher.update(arr_b, v, v1, arr_b1, v2);
        }
        catch(ShortBufferException shortBufferException0) {
            throw new RuntimeException(shortBufferException0);
        }
    }

    public void update(byte[] arr_b, int v, int v1, byte[] arr_b1, int v2) {
        int v3;
        while((v3 = this.pendingXorBytes) > 0) {
            arr_b1[v2] = (byte)(arr_b[v] ^ this.flushedBlock[this.blockSize - v3]);
            ++v2;
            ++v;
            this.pendingXorBytes = v3 - 1;
            --v1;
            if(v1 == 0) {
                return;
            }
        }
        int v4 = this.nonFlushingUpdate(arr_b, v, v1, arr_b1, v2);
        if(v1 != v4) {
            int v5 = v1 - v4;
            int v6 = 0;
            boolean z = true;
            Assertions.checkState(v5 < this.blockSize);
            int v7 = v2 + v4;
            int v8 = this.blockSize - v5;
            this.pendingXorBytes = v8;
            if(this.nonFlushingUpdate(this.zerosBlock, 0, v8, this.flushedBlock, 0) != this.blockSize) {
                z = false;
            }
            Assertions.checkState(z);
            while(v6 < v5) {
                arr_b1[v7] = this.flushedBlock[v6];
                ++v6;
                ++v7;
            }
        }
    }

    public void updateInPlace(byte[] arr_b, int v, int v1) {
        this.update(arr_b, v, v1, arr_b, v);
    }
}

