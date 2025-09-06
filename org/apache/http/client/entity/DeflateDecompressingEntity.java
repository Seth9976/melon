package org.apache.http.client.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class DeflateDecompressingEntity extends DecompressingEntity {
    public DeflateDecompressingEntity(HttpEntity httpEntity0) {
        super(httpEntity0);
    }

    @Override  // org.apache.http.client.entity.DecompressingEntity
    public InputStream decorate(InputStream inputStream0) {
        return new DeflateInputStream(inputStream0);
    }

    @Override  // org.apache.http.client.entity.DecompressingEntity
    public InputStream getContent() {
        return super.getContent();
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public Header getContentEncoding() {
        return null;
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public long getContentLength() {
        return -1L;
    }

    @Override  // org.apache.http.client.entity.DecompressingEntity
    public void writeTo(OutputStream outputStream0) {
        super.writeTo(outputStream0);
    }
}

