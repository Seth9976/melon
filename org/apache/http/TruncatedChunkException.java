package org.apache.http;

public class TruncatedChunkException extends MalformedChunkCodingException {
    private static final long serialVersionUID = 0xFFAC7D2D707069DCL;

    public TruncatedChunkException(String s) {
        super(s);
    }
}

