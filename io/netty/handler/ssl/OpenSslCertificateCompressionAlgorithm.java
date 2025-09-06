package io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

public interface OpenSslCertificateCompressionAlgorithm {
    int algorithmId();

    byte[] compress(SSLEngine arg1, byte[] arg2);

    byte[] decompress(SSLEngine arg1, int arg2, byte[] arg3);
}

