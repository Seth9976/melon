package org.apache.http;

import java.io.IOException;

public class ContentTooLongException extends IOException {
    private static final long serialVersionUID = 0xF32C453E51F4FCE9L;

    public ContentTooLongException(String s) {
        super(s);
    }
}

