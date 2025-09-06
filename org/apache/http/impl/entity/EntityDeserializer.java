package org.apache.http.impl.entity;

import org.apache.http.HttpEntity;
import org.apache.http.HttpMessage;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.io.SessionInputBuffer;

@Deprecated
public class EntityDeserializer {
    public EntityDeserializer(ContentLengthStrategy contentLengthStrategy0) {
        throw new RuntimeException("Stub!");
    }

    public HttpEntity deserialize(SessionInputBuffer sessionInputBuffer0, HttpMessage httpMessage0) {
        throw new RuntimeException("Stub!");
    }

    public BasicHttpEntity doDeserialize(SessionInputBuffer sessionInputBuffer0, HttpMessage httpMessage0) {
        throw new RuntimeException("Stub!");
    }
}

