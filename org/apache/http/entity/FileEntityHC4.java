package org.apache.http.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class FileEntityHC4 extends AbstractHttpEntityHC4 implements Cloneable {
    protected final File file;

    public FileEntityHC4(File file0) {
        this.file = (File)Args.notNull(file0, "File");
    }

    @Deprecated
    public FileEntityHC4(File file0, String s) {
        this.file = (File)Args.notNull(file0, "File");
        this.setContentType(s);
    }

    public FileEntityHC4(File file0, ContentType contentType0) {
        this.file = (File)Args.notNull(file0, "File");
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
        return new FileInputStream(this.file);
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.file.length();
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
        try(FileInputStream fileInputStream0 = new FileInputStream(this.file)) {
            byte[] arr_b = new byte[0x1000];
            int v;
            while((v = fileInputStream0.read(arr_b)) != -1) {
                outputStream0.write(arr_b, 0, v);
            }
            outputStream0.flush();
        }
    }
}

