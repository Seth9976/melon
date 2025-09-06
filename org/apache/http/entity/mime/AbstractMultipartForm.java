package org.apache.http.entity.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;

abstract class AbstractMultipartForm {
    private static final ByteArrayBuffer CR_LF;
    private static final ByteArrayBuffer FIELD_SEP;
    private static final ByteArrayBuffer TWO_DASHES;
    private final String boundary;
    protected final Charset charset;
    private final String subType;

    static {
        AbstractMultipartForm.FIELD_SEP = AbstractMultipartForm.encode(MIME.DEFAULT_CHARSET, ": ");
        AbstractMultipartForm.CR_LF = AbstractMultipartForm.encode(MIME.DEFAULT_CHARSET, "\r\n");
        AbstractMultipartForm.TWO_DASHES = AbstractMultipartForm.encode(MIME.DEFAULT_CHARSET, "--");
    }

    public AbstractMultipartForm(String s, String s1) {
        this(s, null, s1);
    }

    public AbstractMultipartForm(String s, Charset charset0, String s1) {
        Args.notNull(s, "Multipart subtype");
        Args.notNull(s1, "Multipart boundary");
        this.subType = s;
        if(charset0 == null) {
            charset0 = MIME.DEFAULT_CHARSET;
        }
        this.charset = charset0;
        this.boundary = s1;
    }

    public void doWriteTo(OutputStream outputStream0, boolean z) {
        String s = this.getBoundary();
        ByteArrayBuffer byteArrayBuffer0 = AbstractMultipartForm.encode(this.charset, s);
        for(Object object0: this.getBodyParts()) {
            FormBodyPart formBodyPart0 = (FormBodyPart)object0;
            AbstractMultipartForm.writeBytes(AbstractMultipartForm.TWO_DASHES, outputStream0);
            AbstractMultipartForm.writeBytes(byteArrayBuffer0, outputStream0);
            ByteArrayBuffer byteArrayBuffer1 = AbstractMultipartForm.CR_LF;
            AbstractMultipartForm.writeBytes(byteArrayBuffer1, outputStream0);
            this.formatMultipartHeader(formBodyPart0, outputStream0);
            AbstractMultipartForm.writeBytes(byteArrayBuffer1, outputStream0);
            if(z) {
                formBodyPart0.getBody().writeTo(outputStream0);
            }
            AbstractMultipartForm.writeBytes(byteArrayBuffer1, outputStream0);
        }
        AbstractMultipartForm.writeBytes(AbstractMultipartForm.TWO_DASHES, outputStream0);
        AbstractMultipartForm.writeBytes(byteArrayBuffer0, outputStream0);
        AbstractMultipartForm.writeBytes(AbstractMultipartForm.TWO_DASHES, outputStream0);
        AbstractMultipartForm.writeBytes(AbstractMultipartForm.CR_LF, outputStream0);
    }

    private static ByteArrayBuffer encode(Charset charset0, String s) {
        ByteBuffer byteBuffer0 = charset0.encode(CharBuffer.wrap(s));
        ByteArrayBuffer byteArrayBuffer0 = new ByteArrayBuffer(byteBuffer0.remaining());
        byteArrayBuffer0.append(byteBuffer0.array(), byteBuffer0.position(), byteBuffer0.remaining());
        return byteArrayBuffer0;
    }

    public abstract void formatMultipartHeader(FormBodyPart arg1, OutputStream arg2);

    public abstract List getBodyParts();

    public String getBoundary() {
        return this.boundary;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getSubType() {
        return this.subType;
    }

    public long getTotalLength() {
        long v = 0L;
        for(Object object0: this.getBodyParts()) {
            long v1 = ((FormBodyPart)object0).getBody().getContentLength();
            if(v1 >= 0L) {
                v += v1;
                continue;
            }
            return -1L;
        }
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            this.doWriteTo(byteArrayOutputStream0, false);
            return v + ((long)byteArrayOutputStream0.toByteArray().length);
        }
        catch(IOException unused_ex) {
            return -1L;
        }
    }

    private static void writeBytes(String s, OutputStream outputStream0) {
        AbstractMultipartForm.writeBytes(AbstractMultipartForm.encode(MIME.DEFAULT_CHARSET, s), outputStream0);
    }

    private static void writeBytes(String s, Charset charset0, OutputStream outputStream0) {
        AbstractMultipartForm.writeBytes(AbstractMultipartForm.encode(charset0, s), outputStream0);
    }

    private static void writeBytes(ByteArrayBuffer byteArrayBuffer0, OutputStream outputStream0) {
        outputStream0.write(byteArrayBuffer0.buffer(), 0, byteArrayBuffer0.length());
    }

    public static void writeField(MinimalField minimalField0, OutputStream outputStream0) {
        AbstractMultipartForm.writeBytes(minimalField0.getName(), outputStream0);
        AbstractMultipartForm.writeBytes(AbstractMultipartForm.FIELD_SEP, outputStream0);
        AbstractMultipartForm.writeBytes(minimalField0.getBody(), outputStream0);
        AbstractMultipartForm.writeBytes(AbstractMultipartForm.CR_LF, outputStream0);
    }

    public static void writeField(MinimalField minimalField0, Charset charset0, OutputStream outputStream0) {
        AbstractMultipartForm.writeBytes(minimalField0.getName(), charset0, outputStream0);
        AbstractMultipartForm.writeBytes(AbstractMultipartForm.FIELD_SEP, outputStream0);
        AbstractMultipartForm.writeBytes(minimalField0.getBody(), charset0, outputStream0);
        AbstractMultipartForm.writeBytes(AbstractMultipartForm.CR_LF, outputStream0);
    }

    public void writeTo(OutputStream outputStream0) {
        this.doWriteTo(outputStream0, true);
    }
}

