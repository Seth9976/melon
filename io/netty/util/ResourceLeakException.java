package io.netty.util;

import java.util.Arrays;

@Deprecated
public class ResourceLeakException extends RuntimeException {
    private final StackTraceElement[] cachedStackTrace;
    private static final long serialVersionUID = 0x63BB69B56D4A8F48L;

    public ResourceLeakException() {
        this.cachedStackTrace = this.getStackTrace();
    }

    public ResourceLeakException(String s) {
        super(s);
        this.cachedStackTrace = this.getStackTrace();
    }

    public ResourceLeakException(String s, Throwable throwable0) {
        super(s, throwable0);
        this.cachedStackTrace = this.getStackTrace();
    }

    public ResourceLeakException(Throwable throwable0) {
        super(throwable0);
        this.cachedStackTrace = this.getStackTrace();
    }

    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof ResourceLeakException)) {
            return false;
        }
        return object0 == this ? true : Arrays.equals(this.cachedStackTrace, ((ResourceLeakException)object0).cachedStackTrace);
    }

    @Override
    public int hashCode() {
        StackTraceElement[] arr_stackTraceElement = this.cachedStackTrace;
        int v1 = 0;
        for(int v = 0; v < arr_stackTraceElement.length; ++v) {
            v1 = v1 * 0x1F + arr_stackTraceElement[v].hashCode();
        }
        return v1;
    }
}

