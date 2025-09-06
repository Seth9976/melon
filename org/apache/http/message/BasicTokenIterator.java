package org.apache.http.message;

import org.apache.http.HeaderIterator;
import org.apache.http.TokenIterator;

@Deprecated
public class BasicTokenIterator implements TokenIterator {
    public static final String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
    protected String currentHeader;
    protected String currentToken;
    protected final HeaderIterator headerIt;
    protected int searchPos;

    public BasicTokenIterator(HeaderIterator headerIterator0) {
        throw new RuntimeException("Stub!");
    }

    public String createToken(String s, int v, int v1) {
        throw new RuntimeException("Stub!");
    }

    public int findNext(int v) {
        throw new RuntimeException("Stub!");
    }

    public int findTokenEnd(int v) {
        throw new RuntimeException("Stub!");
    }

    public int findTokenSeparator(int v) {
        throw new RuntimeException("Stub!");
    }

    public int findTokenStart(int v) {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.TokenIterator
    public boolean hasNext() {
        throw new RuntimeException("Stub!");
    }

    public boolean isHttpSeparator(char c) {
        throw new RuntimeException("Stub!");
    }

    public boolean isTokenChar(char c) {
        throw new RuntimeException("Stub!");
    }

    public boolean isTokenSeparator(char c) {
        throw new RuntimeException("Stub!");
    }

    public boolean isWhitespace(char c) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final Object next() {
        throw new RuntimeException("Stub!");
    }

    @Override  // org.apache.http.TokenIterator
    public String nextToken() {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final void remove() {
        throw new RuntimeException("Stub!");
    }
}

