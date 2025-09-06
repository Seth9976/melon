package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtilsHC4;

@NotThreadSafe
public class BufferedHttpEntityHC4 extends HttpEntityWrapperHC4 {
    private final byte[] buffer;

    public BufferedHttpEntityHC4(HttpEntity httpEntity0) {
        super(httpEntity0);
        if(httpEntity0.isRepeatable() && httpEntity0.getContentLength() >= 0L) {
            this.buffer = null;
            return;
        }
        this.buffer = EntityUtilsHC4.toByteArray(httpEntity0);
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public InputStream getContent() {
        return this.buffer != null ? new ByteArrayInputStream(this.buffer) : super.getContent();
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public long getContentLength() {
        return this.buffer == null ? super.getContentLength() : ((long)this.buffer.length);
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public boolean isChunked() {
        return this.buffer == null && super.isChunked();
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public boolean isRepeatable() {
        return true;
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public boolean isStreaming() {
        return this.buffer == null && super.isStreaming();
    }

    @Override  // org.apache.http.entity.HttpEntityWrapperHC4
    public void writeTo(OutputStream outputStream0) {
        Args.notNull(outputStream0, "Output stream");
        byte[] arr_b = this.buffer;
        if(arr_b != null) {
            outputStream0.write(arr_b);
            return;
        }
        super.writeTo(outputStream0);
    }
}

