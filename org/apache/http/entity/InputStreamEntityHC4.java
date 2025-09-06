package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class InputStreamEntityHC4 extends AbstractHttpEntityHC4 {
    private final InputStream content;
    private final long length;

    public InputStreamEntityHC4(InputStream inputStream0) {
        this(inputStream0, -1L);
    }

    public InputStreamEntityHC4(InputStream inputStream0, long v) {
        this(inputStream0, v, null);
    }

    public InputStreamEntityHC4(InputStream inputStream0, long v, ContentType contentType0) {
        this.content = (InputStream)Args.notNull(inputStream0, "Source input stream");
        this.length = v;
        if(contentType0 != null) {
            this.setContentType(contentType0.toString());
        }
    }

    public InputStreamEntityHC4(InputStream inputStream0, ContentType contentType0) {
        this(inputStream0, -1L, contentType0);
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
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
        return true;
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        Args.notNull(outputStream0, "Output stream");
        try(InputStream inputStream0 = this.content) {
            byte[] arr_b = new byte[0x1000];
            long v = this.length;
            if(Long.compare(v, 0L) < 0) {
                int v1;
                while((v1 = inputStream0.read(arr_b)) != -1) {
                    outputStream0.write(arr_b, 0, v1);
                }
            }
            else {
                while(true) {
                    if(v <= 0L) {
                        break;
                    }
                    int v2 = inputStream0.read(arr_b, 0, ((int)Math.min(0x1000L, v)));
                    if(v2 == -1) {
                        break;
                    }
                    outputStream0.write(arr_b, 0, v2);
                    v -= (long)v2;
                }
            }
        }
    }
}

