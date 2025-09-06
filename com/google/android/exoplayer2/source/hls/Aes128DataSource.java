package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class Aes128DataSource implements DataSource {
    private CipherInputStream cipherInputStream;
    private final byte[] encryptionIv;
    private final byte[] encryptionKey;
    private final DataSource upstream;

    public Aes128DataSource(DataSource dataSource0, byte[] arr_b, byte[] arr_b1) {
        this.upstream = dataSource0;
        this.encryptionKey = arr_b;
        this.encryptionIv = arr_b1;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public final void addTransferListener(TransferListener transferListener0) {
        this.upstream.addTransferListener(transferListener0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if(this.cipherInputStream != null) {
            this.cipherInputStream = null;
            this.upstream.close();
        }
    }

    public Cipher getCipherInstance() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public final Map getResponseHeaders() {
        return this.upstream.getResponseHeaders();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public final Uri getUri() {
        return this.upstream.getUri();
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public final long open(DataSpec dataSpec0) {
        Cipher cipher0;
        try {
            cipher0 = this.getCipherInstance();
        }
        catch(NoSuchAlgorithmException | NoSuchPaddingException noSuchAlgorithmException0) {
            throw new RuntimeException(noSuchAlgorithmException0);
        }
        SecretKeySpec secretKeySpec0 = new SecretKeySpec(this.encryptionKey, "AES");
        IvParameterSpec ivParameterSpec0 = new IvParameterSpec(this.encryptionIv);
        try {
            cipher0.init(2, secretKeySpec0, ivParameterSpec0);
        }
        catch(InvalidKeyException | InvalidAlgorithmParameterException invalidKeyException0) {
            throw new RuntimeException(invalidKeyException0);
        }
        DataSourceInputStream dataSourceInputStream0 = new DataSourceInputStream(this.upstream, dataSpec0);
        this.cipherInputStream = new CipherInputStream(dataSourceInputStream0, cipher0);
        dataSourceInputStream0.open();
        return -1L;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public final int read(byte[] arr_b, int v, int v1) {
        Assertions.checkNotNull(this.cipherInputStream);
        int v2 = this.cipherInputStream.read(arr_b, v, v1);
        return v2 >= 0 ? v2 : -1;
    }
}

