package org.apache.http.impl.execchain;

import java.io.InterruptedIOException;
import org.apache.http.annotation.Immutable;

@Immutable
public class RequestAbortedException extends InterruptedIOException {
    private static final long serialVersionUID = 0x4506AA3106436180L;

    public RequestAbortedException(String s) {
        super(s);
    }

    public RequestAbortedException(String s, Throwable throwable0) {
        super(s);
        if(throwable0 != null) {
            this.initCause(throwable0);
        }
    }
}

