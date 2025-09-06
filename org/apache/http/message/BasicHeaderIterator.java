package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;

@Deprecated
public class BasicHeaderIterator implements HeaderIterator {
    protected final Header[] allHeaders;
    protected int currentIndex;
    protected String headerName;

    public BasicHeaderIterator(Header[] arr_header, String s) {
        this.allHeaders = null;
        throw new RuntimeException("Stub!");
    }

    public boolean filterHeader(int v) {
        throw new RuntimeException("Stub!");
    }

    public int findNext(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderIterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final Object next() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderIterator
    public Header nextHeader() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void remove() {
        throw new RuntimeException("Stub!");
    }
}

