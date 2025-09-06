package org.apache.http.entity;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public class FileEntity extends AbstractHttpEntity {
    protected final File file;

    public FileEntity(File file0, String s) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isStreaming() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        throw new RuntimeException("Stub!");
    }
}

