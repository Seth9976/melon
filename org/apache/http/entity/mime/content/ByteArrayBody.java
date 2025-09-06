package org.apache.http.entity.mime.content;

import java.io.OutputStream;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    public ByteArrayBody(byte[] arr_b, String s) {
        this(arr_b, "application/octet-stream", s);
    }

    @Deprecated
    public ByteArrayBody(byte[] arr_b, String s, String s1) {
        this(arr_b, ContentType.create(s), s1);
    }

    public ByteArrayBody(byte[] arr_b, ContentType contentType0, String s) {
        super(contentType0);
        Args.notNull(arr_b, "byte[]");
        this.data = arr_b;
        this.filename = s;
    }

    @Override  // org.apache.http.entity.mime.content.AbstractContentBody
    public String getCharset() {
        return null;
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return (long)this.data.length;
    }

    @Override  // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override  // org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream0) {
        outputStream0.write(this.data);
    }
}

