package org.apache.http.entity.mime;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class HttpMultipart extends AbstractMultipartForm {
    private final HttpMultipartMode mode;
    private final List parts;

    public HttpMultipart(String s, String s1) {
        this(s, null, s1);
    }

    public HttpMultipart(String s, Charset charset0, String s1) {
        this(s, charset0, s1, HttpMultipartMode.STRICT);
    }

    public HttpMultipart(String s, Charset charset0, String s1, HttpMultipartMode httpMultipartMode0) {
        super(s, charset0, s1);
        this.mode = httpMultipartMode0;
        this.parts = new ArrayList();
    }

    public void addBodyPart(FormBodyPart formBodyPart0) {
        if(formBodyPart0 == null) {
            return;
        }
        this.parts.add(formBodyPart0);
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public void formatMultipartHeader(FormBodyPart formBodyPart0, OutputStream outputStream0) {
        Header header0 = formBodyPart0.getHeader();
        if(org.apache.http.entity.mime.HttpMultipart.1.$SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[this.mode.ordinal()] != 1) {
            for(Object object0: header0) {
                AbstractMultipartForm.writeField(((MinimalField)object0), outputStream0);
            }
            return;
        }
        AbstractMultipartForm.writeField(header0.getField("Content-Disposition"), this.charset, outputStream0);
        if(formBodyPart0.getBody().getFilename() != null) {
            AbstractMultipartForm.writeField(header0.getField("Content-Type"), this.charset, outputStream0);
        }
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public List getBodyParts() {
        return this.parts;
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public String getBoundary() {
        return super.getBoundary();
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public Charset getCharset() {
        return super.getCharset();
    }

    public HttpMultipartMode getMode() {
        return this.mode;
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public String getSubType() {
        return super.getSubType();
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public long getTotalLength() {
        return super.getTotalLength();
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public void writeTo(OutputStream outputStream0) {
        super.writeTo(outputStream0);
    }

    class org.apache.http.entity.mime.HttpMultipart.1 {
        static final int[] $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode;

        static {
            int[] arr_v = new int[HttpMultipartMode.values().length];
            org.apache.http.entity.mime.HttpMultipart.1.$SwitchMap$org$apache$http$entity$mime$HttpMultipartMode = arr_v;
            try {
                arr_v[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
        }
    }

}

