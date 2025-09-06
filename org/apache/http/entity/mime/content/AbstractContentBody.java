package org.apache.http.entity.mime.content;

import java.nio.charset.Charset;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

public abstract class AbstractContentBody implements ContentBody {
    private final ContentType contentType;

    @Deprecated
    public AbstractContentBody(String s) {
        this(ContentType.parse(s));
    }

    public AbstractContentBody(ContentType contentType0) {
        Args.notNull(contentType0, "Content type");
        this.contentType = contentType0;
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public String getCharset() {
        Charset charset0 = this.contentType.getCharset();
        return charset0 == null ? null : charset0.name();
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public String getMediaType() {
        String s = this.contentType.getMimeType();
        int v = s.indexOf(0x2F);
        return v == -1 ? s : s.substring(0, v);
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public String getMimeType() {
        return this.contentType.getMimeType();
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public String getSubType() {
        String s = this.contentType.getMimeType();
        int v = s.indexOf(0x2F);
        return v == -1 ? null : s.substring(v + 1);
    }
}

