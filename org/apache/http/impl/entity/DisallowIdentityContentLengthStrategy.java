package org.apache.http.impl.entity;

import org.apache.http.HttpMessage;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;

@Immutable
public class DisallowIdentityContentLengthStrategy implements ContentLengthStrategy {
    public static final DisallowIdentityContentLengthStrategy INSTANCE;
    private final ContentLengthStrategy contentLengthStrategy;

    static {
        DisallowIdentityContentLengthStrategy.INSTANCE = new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategyHC4(0));
    }

    public DisallowIdentityContentLengthStrategy(ContentLengthStrategy contentLengthStrategy0) {
        this.contentLengthStrategy = contentLengthStrategy0;
    }

    @Override  // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage httpMessage0) {
        long v = this.contentLengthStrategy.determineLength(httpMessage0);
        if(v == -1L) {
            throw new ProtocolException("Identity transfer encoding cannot be used");
        }
        return v;
    }
}

