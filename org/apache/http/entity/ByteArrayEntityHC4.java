package org.apache.http.entity;

import androidx.appcompat.app.o;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class ByteArrayEntityHC4 extends AbstractHttpEntityHC4 implements Cloneable {
    private final byte[] b;
    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    public ByteArrayEntityHC4(byte[] arr_b) {
        this(arr_b, null);
    }

    public ByteArrayEntityHC4(byte[] arr_b, int v, int v1) {
        this(arr_b, v, v1, null);
    }

    public ByteArrayEntityHC4(byte[] arr_b, int v, int v1, ContentType contentType0) {
        Args.notNull(arr_b, "Source byte array");
        if(v >= 0 && v <= arr_b.length && v1 >= 0 && (v + v1 >= 0 && v + v1 <= arr_b.length)) {
            this.content = arr_b;
            this.b = arr_b;
            this.off = v;
            this.len = v1;
            if(contentType0 != null) {
                this.setContentType(contentType0.toString());
            }
            return;
        }
        StringBuilder stringBuilder0 = o.t(v, v1, "off: ", " len: ", " b.length: ");
        stringBuilder0.append(arr_b.length);
        throw new IndexOutOfBoundsException(stringBuilder0.toString());
    }

    public ByteArrayEntityHC4(byte[] arr_b, ContentType contentType0) {
        Args.notNull(arr_b, "Source byte array");
        this.content = arr_b;
        this.b = arr_b;
        this.off = 0;
        this.len = arr_b.length;
        if(contentType0 != null) {
            this.setContentType(contentType0.toString());
        }
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
        return new ByteArrayInputStream(this.b, this.off, this.len);
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        return (long)this.len;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        Args.notNull(outputStream0, "Output stream");
        outputStream0.write(this.b, this.off, this.len);
        outputStream0.flush();
    }
}

