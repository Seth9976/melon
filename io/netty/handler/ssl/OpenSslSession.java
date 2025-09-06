package io.netty.handler.ssl;

import java.security.cert.Certificate;
import javax.net.ssl.SSLSession;

interface OpenSslSession extends SSLSession {
    OpenSslSessionContext getSessionContext();

    void handshakeFinished(byte[] arg1, String arg2, String arg3, byte[] arg4, byte[][] arg5, long arg6, long arg7);

    OpenSslSessionId sessionId();

    void setLocalCertificate(Certificate[] arg1);

    void setSessionId(OpenSslSessionId arg1);

    void tryExpandApplicationBufferSize(int arg1);
}

