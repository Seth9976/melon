package org.apache.http.message;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;

@Deprecated
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List allHeaders;
    protected int currentIndex;
    protected String headerName;
    protected int lastIndex;

    public BasicListHeaderIterator(List list0, String s) {
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

