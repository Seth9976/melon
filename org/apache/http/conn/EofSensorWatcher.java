package org.apache.http.conn;

import java.io.InputStream;

@Deprecated
public interface EofSensorWatcher {
    boolean eofDetected(InputStream arg1);

    boolean streamAbort(InputStream arg1);

    boolean streamClosed(InputStream arg1);
}

