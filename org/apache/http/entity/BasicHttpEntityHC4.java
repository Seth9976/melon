package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

@NotThreadSafe
public class BasicHttpEntityHC4 extends AbstractHttpEntityHC4 {
    private InputStream content;
    private long length;

    public BasicHttpEntityHC4() {
        this.length = -1L;
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
        Asserts.check(this.content != null, "Content has not been provided");
        return this.content;
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.length;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.content != null;
    }

    public void setContent(InputStream inputStream0) {
        this.content = inputStream0;
    }

    public void setContentLength(long v) {
        this.length = v;
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        Args.notNull(outputStream0, "Output stream");
        try(InputStream inputStream0 = this.getContent()) {
            byte[] arr_b = new byte[0x1000];
            int v;
            while((v = inputStream0.read(arr_b)) != -1) {
                outputStream0.write(arr_b, 0, v);
            }
        }
    }
}

