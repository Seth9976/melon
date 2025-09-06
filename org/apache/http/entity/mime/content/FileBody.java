package org.apache.http.entity.mime.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.ContentType;
import org.apache.http.util.Args;

public class FileBody extends AbstractContentBody {
    private final File file;
    private final String filename;

    public FileBody(File file0) {
        String s = file0 == null ? null : file0.getName();
        this(file0, ContentType.DEFAULT_BINARY, s);
    }

    @Deprecated
    public FileBody(File file0, String s) {
        this(file0, ContentType.create(s), null);
    }

    @Deprecated
    public FileBody(File file0, String s, String s1) {
        this(file0, null, s, s1);
    }

    @Deprecated
    public FileBody(File file0, String s, String s1, String s2) {
        this(file0, ContentType.create(s1, s2), s);
    }

    public FileBody(File file0, ContentType contentType0) {
        this(file0, contentType0, null);
    }

    public FileBody(File file0, ContentType contentType0, String s) {
        super(contentType0);
        Args.notNull(file0, "File");
        this.file = file0;
        this.filename = s;
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public long getContentLength() {
        return this.file.length();
    }

    public File getFile() {
        return this.file;
    }

    @Override  // org.apache.http.entity.mime.content.ContentBody
    public String getFilename() {
        return this.filename;
    }

    public InputStream getInputStream() {
        return new FileInputStream(this.file);
    }

    @Override  // org.apache.http.entity.mime.content.ContentDescriptor
    public String getTransferEncoding() {
        return "binary";
    }

    @Override  // org.apache.http.entity.mime.content.ContentBody
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

