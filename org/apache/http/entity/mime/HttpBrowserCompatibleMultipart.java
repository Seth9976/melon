package org.apache.http.entity.mime;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

class HttpBrowserCompatibleMultipart extends AbstractMultipartForm {
    private final List parts;

    public HttpBrowserCompatibleMultipart(String s, Charset charset0, String s1, List list0) {
        super(s, charset0, s1);
        this.parts = list0;
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public void formatMultipartHeader(FormBodyPart formBodyPart0, OutputStream outputStream0) {
        Header header0 = formBodyPart0.getHeader();
        AbstractMultipartForm.writeField(header0.getField("Content-Disposition"), this.charset, outputStream0);
        if(formBodyPart0.getBody().getFilename() != null) {
            AbstractMultipartForm.writeField(header0.getField("Content-Type"), this.charset, outputStream0);
        }
    }

    @Override  // org.apache.http.entity.mime.AbstractMultipartForm
    public List getBodyParts() {
        return this.parts;
    }
}

