package org.apache.http.entity.mime.content;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.Consts;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

public class StringBody extends AbstractContentBody {
    private final byte[] content;

    @Deprecated
    public StringBody(String s) {
        this(s, "text/plain", Consts.ASCII);
    }

    @Deprecated
    public StringBody(String s, String s1, Charset charset0) {
        this(s, ContentType.create(s1, charset0));
    }

    @Deprecated
    public StringBody(String s, Charset charset0) {
        this(s, "text/plain", charset0);
    }

    public StringBody(String s, ContentType contentType0) {
        super(contentType0);
        Args.notNull(s, "Text");
        Charset charset0 = contentType0.getCharset();
        if(charset0 == null) {
            charset0 = Consts.ASCII;
        }
        String s1 = charset0.name();
        try {
            this.content = s.getBytes(s1);
        }
        catch(UnsupportedEncodingException unused_ex) {
            throw new UnsupportedCharsetException(s1);
        }
    }

    @Deprecated
    public static StringBody create(String s) {
        return StringBody.create(s, null, null);
    }

    @Deprecated
    public static StringBody create(String s, String s1, Charset charset0) {
        try {
            return new StringBody(s, s1, charset0);
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new IllegalArgumentException("Charset " + charset0 + " is not supported", unsupportedEncodingException0);
        }
    }

    @Deprecated
    public static StringBody create(String s, Charset charset0) {
        return StringBody.create(s, null, charset0);
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return (long)this.content.length;
    }

    @Override  // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return null;
    }

    public Reader getReader() {
        Charset charset0 = this.getContentType().getCharset();
        ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(this.content);
        if(charset0 == null) {
            charset0 = Consts.ASCII;
        }
        return new InputStreamReader(byteArrayInputStream0, charset0);
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "8bit";
    }

    @Override  // org.apache.http.entity.mime.content.ContentBody
    public void writeTo(OutputStream outputStream0) {
        Args.notNull(outputStream0, "Output stream");
        ByteArrayInputStream byteArrayInputStream0 = new ByteArrayInputStream(this.content);
        byte[] arr_b = new byte[0x1000];
        int v;
        while((v = byteArrayInputStream0.read(arr_b)) != -1) {
            outputStream0.write(arr_b, 0, v);
        }
        outputStream0.flush();
    }
}

