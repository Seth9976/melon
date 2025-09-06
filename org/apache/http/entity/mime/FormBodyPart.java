package org.apache.http.entity.mime;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.content.AbstractContentBody;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.util.Args;

public class FormBodyPart {
    private final ContentBody body;
    private final Header header;
    private final String name;

    public FormBodyPart(String s, ContentBody contentBody0) {
        Args.notNull(s, "Name");
        Args.notNull(contentBody0, "Body");
        this.name = s;
        this.body = contentBody0;
        this.header = new Header();
        this.generateContentDisp(contentBody0);
        this.generateContentType(contentBody0);
        this.generateTransferEncoding(contentBody0);
    }

    public void addField(String s, String s1) {
        Args.notNull(s, "Field name");
        MinimalField minimalField0 = new MinimalField(s, s1);
        this.header.addField(minimalField0);
    }

    public void generateContentDisp(ContentBody contentBody0) {
        StringBuilder stringBuilder0 = new StringBuilder("form-data; name=\"");
        stringBuilder0.append(this.getName());
        stringBuilder0.append("\"");
        if(contentBody0.getFilename() != null) {
            stringBuilder0.append("; filename=\"");
            stringBuilder0.append(contentBody0.getFilename());
            stringBuilder0.append("\"");
        }
        this.addField("Content-Disposition", stringBuilder0.toString());
    }

    public void generateContentType(ContentBody contentBody0) {
        ContentType contentType0 = contentBody0 instanceof AbstractContentBody ? ((AbstractContentBody)contentBody0).getContentType() : null;
        if(contentType0 != null) {
            this.addField("Content-Type", contentType0.toString());
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(contentBody0.getMimeType());
        if(contentBody0.getCharset() != null) {
            stringBuilder0.append("; charset=");
            stringBuilder0.append(contentBody0.getCharset());
        }
        this.addField("Content-Type", stringBuilder0.toString());
    }

    public void generateTransferEncoding(ContentBody contentBody0) {
        this.addField("Content-Transfer-Encoding", contentBody0.getTransferEncoding());
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public String getName() {
        return this.name;
    }
}

