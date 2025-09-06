package org.apache.http.client.entity;

import java.io.InputStream;
import org.apache.http.annotation.NotThreadSafe;

@NotThreadSafe
class LazyDecompressingInputStream extends InputStream {
    private final DecompressingEntity decompressingEntity;
    private final InputStream wrappedStream;
    private InputStream wrapperStream;

    public LazyDecompressingInputStream(InputStream inputStream0, DecompressingEntity decompressingEntity0) {
        this.wrappedStream = inputStream0;
        this.decompressingEntity = decompressingEntity0;
    }

    @Override
    public int available() {
        this.initWrapper();
        return this.wrapperStream.available();
    }

    @Override
    public void close() {
        try {
            InputStream inputStream0 = this.wrapperStream;
            if(inputStream0 != null) {
                inputStream0.close();
            }
        }
        finally {
            this.wrappedStream.close();
        }
    }

    private void initWrapper() {
        if(this.wrapperStream == null) {
            this.wrapperStream = this.decompressingEntity.decorate(this.wrappedStream);
        }
    }

    @Override
    public boolean markSupported() {
        return false;
    }

    @Override
    public int read() {
        this.initWrapper();
        return this.wrapperStream.read();
    }

    @Override
    public int read(byte[] arr_b) {
        this.initWrapper();
        return this.wrapperStream.read(arr_b);
    }

    @Override
    public int read(byte[] arr_b, int v, int v1) {
        this.initWrapper();
        return this.wrapperStream.read(arr_b, v, v1);
    }

    @Override
    public long skip(long v) {
        this.initWrapper();
        return this.wrapperStream.skip(v);
    }
}

