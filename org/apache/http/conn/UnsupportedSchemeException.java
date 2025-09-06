package org.apache.http.conn;

import java.io.IOException;
import org.apache.http.annotation.Immutable;

@Immutable
public class UnsupportedSchemeException extends IOException {
    private static final long serialVersionUID = 0x31EB9082E346C694L;

    public UnsupportedSchemeException(String s) {
        super(s);
    }
}

