package org.apache.http.client.entity;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapperHC4;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.Args;

public class GzipCompressingEntity extends HttpEntityWrapperHC4 {
    private static final String GZIP_CODEC = "gzip";

    public GzipCompressingEntity(HttpEntity httpEntity0) {
        super(httpEntity0);
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public InputStream getContent() {
        throw new UnsupportedOperationException();
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public Header getContentEncoding() {
        return new BasicHeader("Content-Encoding", "gzip");
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public long getContentLength() {
        return -1L;
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public boolean isChunked() {
        return true;
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public void writeTo(OutputStream outputStream0) {
        Args.notNull(outputStream0, "Output stream");
        GZIPOutputStream gZIPOutputStream0 = new GZIPOutputStream(outputStream0);
        this.wrappedEntity.writeTo(gZIPOutputStream0);
        gZIPOutputStream0.close();
    }
}

