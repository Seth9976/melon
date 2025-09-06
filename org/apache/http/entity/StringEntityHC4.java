package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class StringEntityHC4 extends AbstractHttpEntityHC4 implements Cloneable {
    protected final byte[] content;

    public StringEntityHC4(String s) {
        this(s, ContentType.DEFAULT_TEXT);
    }

    public StringEntityHC4(String s, String s1) {
        this(s, ContentType.create("text/plain", s1));
    }

    @Deprecated
    public StringEntityHC4(String s, String s1, String s2) {
        Args.notNull(s, "Source string");
        if(s1 == null) {
            s1 = "text/plain";
        }
        if(s2 == null) {
            s2 = "ISO-8859-1";
        }
        this.content = s.getBytes(s2);
        this.setContentType(s1 + "; charset=" + s2);
    }

    public StringEntityHC4(String s, Charset charset0) {
        this(s, ContentType.create("text/plain", charset0));
    }

    public StringEntityHC4(String s, ContentType contentType0) {
        Args.notNull(s, "Source string");
        Charset charset0 = contentType0 == null ? null : contentType0.getCharset();
        if(charset0 == null) {
            charset0 = Charset.forName("ISO-8859-1");
        }
        try {
            this.content = s.getBytes(charset0.name());
        }
        catch(UnsupportedEncodingException unused_ex) {
            throw new UnsupportedCharsetException(charset0.name());
        }
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
        return new ByteArrayInputStream(this.content);
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        return (long)this.content.length;
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
        outputStream0.write(this.content);
        outputStream0.flush();
    }
}

