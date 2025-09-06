package org.apache.http.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.util.Args;

@NotThreadSafe
public class SerializableEntityHC4 extends AbstractHttpEntityHC4 {
    private Serializable objRef;
    private byte[] objSer;

    public SerializableEntityHC4(Serializable serializable0) {
        Args.notNull(serializable0, "Source object");
        this.objRef = serializable0;
    }

    public SerializableEntityHC4(Serializable serializable0, boolean z) {
        Args.notNull(serializable0, "Source object");
        if(z) {
            this.createBytes(serializable0);
            return;
        }
        this.objRef = serializable0;
    }

    private void createBytes(Serializable serializable0) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(byteArrayOutputStream0);
        objectOutputStream0.writeObject(serializable0);
        objectOutputStream0.flush();
        this.objSer = byteArrayOutputStream0.toByteArray();
    }

    @Override  // org.apache.http.HttpEntity
    public InputStream getContent() {
        if(this.objSer == null) {
            this.createBytes(this.objRef);
        }
        return new ByteArrayInputStream(this.objSer);
    }

    @Override  // org.apache.http.HttpEntity
    public long getContentLength() {
        return this.objSer == null ? -1L : ((long)this.objSer.length);
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return true;
    }

    @Override  // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return this.objSer == null;
    }

    @Override  // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream0) {
        Args.notNull(outputStream0, "Output stream");
        byte[] arr_b = this.objSer;
        if(arr_b == null) {
            ObjectOutputStream objectOutputStream0 = new ObjectOutputStream(outputStream0);
            objectOutputStream0.writeObject(this.objRef);
            objectOutputStream0.flush();
            return;
        }
        outputStream0.write(arr_b);
        outputStream0.flush();
    }
}

