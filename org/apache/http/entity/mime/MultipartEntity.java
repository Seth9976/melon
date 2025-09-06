package org.apache.http.entity.mime;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.content.ContentBody;

@Deprecated
public class MultipartEntity implements HttpEntity {
    private static final char[] MULTIPART_CHARS;
    private final MultipartEntityBuilder builder;
    private volatile MultipartFormEntity entity;

    static {
        MultipartEntity.MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public MultipartEntity() {
        this(HttpMultipartMode.STRICT, null, null);
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode0) {
        this(httpMultipartMode0, null, null);
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode0, String s, Charset charset0) {
        this.builder = new MultipartEntityBuilder().setMode(httpMultipartMode0).setCharset(charset0).setBoundary(s);
        this.entity = null;
    }

    public void addPart(String s, ContentBody contentBody0) {
        this.addPart(new FormBodyPart(s, contentBody0));
    }

    public void addPart(FormBodyPart formBodyPart0) {
        this.builder.addPart(formBodyPart0);
        this.entity = null;
    }

    @Override  // org.apache.http.HttpEntity
    public void consumeContent() {
        if(this.isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    public String generateBoundary() {
        StringBuilder stringBuilder0 = new StringBuilder();
        Random random0 = new Random();
        int v = random0.nextInt(11);
        for(int v1 = 0; v1 < v + 30; ++v1) {
            stringBuilder0.append(MultipartEntity.MULTIPART_CHARS[random0.nextInt(MultipartEntity.MULTIPART_CHARS.length)]);
        }
        return stringBuilder0.toString();
    }

    public String generateContentType(String s, Charset charset0) {
        StringBuilder stringBuilder0 = new StringBuilder("multipart/form-data; boundary=");
        stringBuilder0.append(s);
        if(charset0 != null) {
            stringBuilder0.append("; charset=");
            stringBuilder0.append(charset0.name());
        }
        return stringBuilder0.toString();
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return this.getEntity().getContentEncoding();
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.getEntity().getContentLength();
    }

    @Override  // org.apache.http.HttpEntity
    public Header getContentType() {
        return this.getEntity().getContentType();
    }

    private MultipartFormEntity getEntity() {
        if(this.entity == null) {
            this.entity = this.builder.buildEntity();
        }
        return this.entity;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isChunked() {
        return this.getEntity().isChunked();
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return this.getEntity().isRepeatable();
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.getEntity().isStreaming();
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        this.getEntity().writeTo(outputStream0);
    }
}

