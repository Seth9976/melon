package org.apache.http.entity.mime.content;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

public class InputStreamBody extends AbstractContentBody {
    private final String filename;
    private final InputStream in;

    public InputStreamBody(InputStream inputStream0, String s) {
        this(inputStream0, ContentType.DEFAULT_BINARY, s);
    }

    @Deprecated
    public InputStreamBody(InputStream inputStream0, String s, String s1) {
        this(inputStream0, ContentType.create(s), s1);
    }

    public InputStreamBody(InputStream inputStream0, ContentType contentType0) {
        this(inputStream0, contentType0, null);
    }

    public InputStreamBody(InputStream inputStream0, ContentType contentType0, String s) {
        super(contentType0);
        Args.notNull(inputStream0, "Input stream");
        this.in = inputStream0;
        this.filename = s;
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return -1L;
    }

    @Override  // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return this.in;
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override  // org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream0) {
        Args.notNull(outputStream0, "Output stream");
        try {
            byte[] arr_b = new byte[0x1000];
            int v1;
            while((v1 = this.in.read(arr_b)) != -1) {
                outputStream0.write(arr_b, 0, v1);
            }
            outputStream0.flush();
        }
        finally {
            this.in.close();
        }
    }
}

