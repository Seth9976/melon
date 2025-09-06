package org.apache.http.message;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HeaderIterator;

@Deprecated
public class BasicHeaderElementIterator implements HeaderElementIterator {
    public BasicHeaderElementIterator(HeaderIterator headerIterator0) {
        throw new RuntimeException("Stub!");
    }

    public BasicHeaderElementIterator(HeaderIterator headerIterator0, HeaderValueParser headerValueParser0) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderElementIterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final Object next() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.HeaderElementIterator
    public HeaderElement nextElement() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void remove() {
        throw new RuntimeException("Stub!");
    }
}

