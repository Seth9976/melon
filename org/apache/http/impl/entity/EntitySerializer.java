package org.apache.http.impl.entity;

import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionOutputBuffer;

@Deprecated
public class EntitySerializer {
    public EntitySerializer(ContentLengthStrategy contentLengthStrategy0) {
        throw new RuntimeException("Stub!");
    }

    public OutputStream doSerialize(SessionOutputBuffer sessionOutputBuffer0, HttpMessage httpMessage0) {
        throw new RuntimeException("Stub!");
    }

    public void serialize(SessionOutputBuffer sessionOutputBuffer0, HttpMessage httpMessage0, HttpEntity httpEntity0) {
        throw new RuntimeException("Stub!");
    }
}

