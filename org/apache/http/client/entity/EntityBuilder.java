package org.apache.http.client.entity;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.entity.AbstractHttpEntityHC4;
import org.apache.http.entity.BasicHttpEntityHC4;
import org.apache.http.entity.ByteArrayEntityHC4;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntityHC4;
import org.apache.http.entity.InputStreamEntityHC4;
import org.apache.http.entity.SerializableEntityHC4;
import org.apache.http.entity.StringEntityHC4;

@NotThreadSafe
public class EntityBuilder {
    private byte[] binary;
    private boolean chunked;
    private String contentEncoding;
    private ContentType contentType;
    private File file;
    private boolean gzipCompress;
    private List parameters;
    private Serializable serializable;
    private InputStream stream;
    private String text;

    public HttpEntity build() {
        HttpEntity httpEntity0;
        String s = this.text;
        if(s == null) {
            byte[] arr_b = this.binary;
            if(arr_b == null) {
                InputStream inputStream0 = this.stream;
                if(inputStream0 == null) {
                    List list0 = this.parameters;
                    if(list0 == null) {
                        Serializable serializable0 = this.serializable;
                        if(serializable0 == null) {
                            File file0 = this.file;
                            httpEntity0 = file0 == null ? new BasicHttpEntityHC4() : new FileEntityHC4(file0, this.getContentOrDefault(ContentType.DEFAULT_BINARY));
                        }
                        else {
                            httpEntity0 = new SerializableEntityHC4(serializable0);
                            ((AbstractHttpEntityHC4)httpEntity0).setContentType(ContentType.DEFAULT_BINARY.toString());
                        }
                    }
                    else {
                        httpEntity0 = new UrlEncodedFormEntityHC4(list0, (this.contentType == null ? null : this.contentType.getCharset()));
                    }
                }
                else {
                    httpEntity0 = new InputStreamEntityHC4(inputStream0, 1L, this.getContentOrDefault(ContentType.DEFAULT_BINARY));
                }
            }
            else {
                httpEntity0 = new ByteArrayEntityHC4(arr_b, this.getContentOrDefault(ContentType.DEFAULT_BINARY));
            }
        }
        else {
            httpEntity0 = new StringEntityHC4(s, this.getContentOrDefault(ContentType.DEFAULT_TEXT));
        }
        if(((AbstractHttpEntityHC4)httpEntity0).getContentType() != null) {
            ContentType contentType0 = this.contentType;
            if(contentType0 != null) {
                ((AbstractHttpEntityHC4)httpEntity0).setContentType(contentType0.toString());
            }
        }
        ((AbstractHttpEntityHC4)httpEntity0).setContentEncoding(this.contentEncoding);
        ((AbstractHttpEntityHC4)httpEntity0).setChunked(this.chunked);
        return this.gzipCompress ? new GzipCompressingEntity(httpEntity0) : httpEntity0;
    }

    public EntityBuilder chunked() {
        this.chunked = true;
        return this;
    }

    private void clearContent() {
        this.text = null;
        this.binary = null;
        this.stream = null;
        this.parameters = null;
        this.serializable = null;
        this.file = null;
    }

    public static EntityBuilder create() {
        return new EntityBuilder();
    }

    public byte[] getBinary() {
        return this.binary;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    private ContentType getContentOrDefault(ContentType contentType0) {
        return this.contentType == null ? contentType0 : this.contentType;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public File getFile() {
        return this.file;
    }

    public List getParameters() {
        return this.parameters;
    }

    public Serializable getSerializable() {
        return this.serializable;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public String getText() {
        return this.text;
    }

    public EntityBuilder gzipCompress() {
        this.gzipCompress = true;
        return this;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public boolean isGzipCompress() {
        return this.gzipCompress;
    }

    public EntityBuilder setBinary(byte[] arr_b) {
        this.clearContent();
        this.binary = arr_b;
        return this;
    }

    public EntityBuilder setContentEncoding(String s) {
        this.contentEncoding = s;
        return this;
    }

    public EntityBuilder setContentType(ContentType contentType0) {
        this.contentType = contentType0;
        return this;
    }

    public EntityBuilder setFile(File file0) {
        this.clearContent();
        this.file = file0;
        return this;
    }

    public EntityBuilder setParameters(List list0) {
        this.clearContent();
        this.parameters = list0;
        return this;
    }

    public EntityBuilder setParameters(NameValuePair[] arr_nameValuePair) {
        return this.setParameters(Arrays.asList(arr_nameValuePair));
    }

    public EntityBuilder setSerializable(Serializable serializable0) {
        this.clearContent();
        this.serializable = serializable0;
        return this;
    }

    public EntityBuilder setStream(InputStream inputStream0) {
        this.clearContent();
        this.stream = inputStream0;
        return this;
    }

    public EntityBuilder setText(String s) {
        this.clearContent();
        this.text = s;
        return this;
    }
}

