package org.apache.http.entity.mime;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.util.Args;

public class MultipartEntityBuilder {
    private static final String DEFAULT_SUBTYPE = "form-data";
    private static final char[] MULTIPART_CHARS;
    private List bodyParts;
    private String boundary;
    private Charset charset;
    private HttpMultipartMode mode;
    private String subType;

    static {
        MultipartEntityBuilder.MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public MultipartEntityBuilder() {
        this.subType = "form-data";
        this.mode = HttpMultipartMode.STRICT;
        this.boundary = null;
        this.charset = null;
        this.bodyParts = null;
    }

    public MultipartEntityBuilder addBinaryBody(String s, File file0) {
        return file0 == null ? this.addBinaryBody(s, null, ContentType.DEFAULT_BINARY, null) : this.addBinaryBody(s, file0, ContentType.DEFAULT_BINARY, file0.getName());
    }

    public MultipartEntityBuilder addBinaryBody(String s, File file0, ContentType contentType0, String s1) {
        return this.addPart(s, new FileBody(file0, contentType0, s1));
    }

    public MultipartEntityBuilder addBinaryBody(String s, InputStream inputStream0) {
        return this.addBinaryBody(s, inputStream0, ContentType.DEFAULT_BINARY, null);
    }

    public MultipartEntityBuilder addBinaryBody(String s, InputStream inputStream0, ContentType contentType0, String s1) {
        return this.addPart(s, new InputStreamBody(inputStream0, contentType0, s1));
    }

    public MultipartEntityBuilder addBinaryBody(String s, byte[] arr_b) {
        return this.addBinaryBody(s, arr_b, ContentType.DEFAULT_BINARY, null);
    }

    public MultipartEntityBuilder addBinaryBody(String s, byte[] arr_b, ContentType contentType0, String s1) {
        return this.addPart(s, new ByteArrayBody(arr_b, contentType0, s1));
    }

    public MultipartEntityBuilder addPart(String s, ContentBody contentBody0) {
        Args.notNull(s, "Name");
        Args.notNull(contentBody0, "Content body");
        return this.addPart(new FormBodyPart(s, contentBody0));
    }

    public MultipartEntityBuilder addPart(FormBodyPart formBodyPart0) {
        if(formBodyPart0 == null) {
            return this;
        }
        if(this.bodyParts == null) {
            this.bodyParts = new ArrayList();
        }
        this.bodyParts.add(formBodyPart0);
        return this;
    }

    public MultipartEntityBuilder addTextBody(String s, String s1) {
        return this.addTextBody(s, s1, ContentType.DEFAULT_TEXT);
    }

    public MultipartEntityBuilder addTextBody(String s, String s1, ContentType contentType0) {
        return this.addPart(s, new StringBody(s1, contentType0));
    }

    public HttpEntity build() {
        return this.buildEntity();
    }

    public MultipartFormEntity buildEntity() {
        HttpBrowserCompatibleMultipart httpBrowserCompatibleMultipart0;
        String s = this.subType == null ? "form-data" : this.subType;
        Charset charset0 = this.charset;
        String s1 = this.boundary == null ? "6zTlmk-SRSzGZ1PmdICf5_BAmXLZzzv3U1tLFh3B" : this.boundary;
        List list0 = this.bodyParts == null ? Collections.EMPTY_LIST : new ArrayList(this.bodyParts);
        switch(org.apache.http.entity.mime.MultipartEntityBuilder.1.$SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[(this.mode == null ? HttpMultipartMode.STRICT : this.mode).ordinal()]) {
            case 1: {
                httpBrowserCompatibleMultipart0 = new HttpBrowserCompatibleMultipart(s, charset0, s1, list0);
                return new MultipartFormEntity(httpBrowserCompatibleMultipart0, this.generateContentType(s1, charset0), httpBrowserCompatibleMultipart0.getTotalLength());
            }
            case 2: {
                httpBrowserCompatibleMultipart0 = new HttpRFC6532Multipart(s, charset0, s1, list0);
                return new MultipartFormEntity(httpBrowserCompatibleMultipart0, this.generateContentType(s1, charset0), httpBrowserCompatibleMultipart0.getTotalLength());
            }
            default: {
                httpBrowserCompatibleMultipart0 = new HttpStrictMultipart(s, charset0, s1, list0);
                return new MultipartFormEntity(httpBrowserCompatibleMultipart0, this.generateContentType(s1, charset0), httpBrowserCompatibleMultipart0.getTotalLength());
            }
        }
    }

    public static MultipartEntityBuilder create() {
        return new MultipartEntityBuilder();
    }

    private String generateBoundary() [...] // 潜在的解密器

    private String generateContentType(String s, Charset charset0) {
        StringBuilder stringBuilder0 = new StringBuilder("multipart/form-data; boundary=");
        stringBuilder0.append(s);
        if(charset0 != null) {
            stringBuilder0.append("; charset=");
            stringBuilder0.append(charset0.name());
        }
        return stringBuilder0.toString();
    }

    public MultipartEntityBuilder setBoundary(String s) {
        this.boundary = s;
        return this;
    }

    public MultipartEntityBuilder setCharset(Charset charset0) {
        this.charset = charset0;
        return this;
    }

    public MultipartEntityBuilder setLaxMode() {
        this.mode = HttpMultipartMode.BROWSER_COMPATIBLE;
        return this;
    }

    public MultipartEntityBuilder setMode(HttpMultipartMode httpMultipartMode0) {
        this.mode = httpMultipartMode0;
        return this;
    }

    public MultipartEntityBuilder setStrictMode() {
        this.mode = HttpMultipartMode.STRICT;
        return this;
    }
}

