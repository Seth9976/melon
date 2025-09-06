package org.apache.http.client.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapperHC4;
import org.apache.http.util.Args;

abstract class DecompressingEntity extends HttpEntityWrapperHC4 {
    private static final int BUFFER_SIZE = 0x800;
    private InputStream content;

    public DecompressingEntity(HttpEntity httpEntity0) {
        super(httpEntity0);
    }

    public abstract InputStream decorate(InputStream arg1);

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public InputStream getContent() {
        if(this.wrappedEntity.isStreaming()) {
            if(this.content == null) {
                this.content = this.getDecompressingStream();
            }
            return this.content;
        }
        return this.getDecompressingStream();
    }

    private InputStream getDecompressingStream() {
        return new LazyDecompressingInputStream(this.wrappedEntity.getContent(), this);
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public void writeTo(OutputStream outputStream0) {
        Args.notNull(outputStream0, "Output stream");
        try(InputStream inputStream0 = this.getContent()) {
            byte[] arr_b = new byte[0x800];
            int v;
            while((v = inputStream0.read(arr_b)) != -1) {
                outputStream0.write(arr_b, 0, v);
            }
        }
    }
}

