package org.apache.http.entity.mime;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

class HttpStrictMultipart extends AbstractMultipartForm {
    private final List parts;

    public HttpStrictMultipart(String s, Charset charset0, String s1, List list0) {
        super(s, charset0, s1);
        this.parts = list0;
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public void formatMultipartHeader(FormBodyPart formBodyPart0, OutputStream outputStream0) {
        for(Object object0: formBodyPart0.getHeader()) {
            AbstractMultipartForm.writeField(((MinimalField)object0), outputStream0);
        }
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public List getBodyParts() {
        return this.parts;
    }
}

