package io.netty.handler.ssl;

public final class OpenSslContextOption extends SslContextOption {
    public static final OpenSslContextOption ASYNC_PRIVATE_KEY_METHOD;
    public static final OpenSslContextOption CERTIFICATE_COMPRESSION_ALGORITHMS;
    public static final OpenSslContextOption MAX_CERTIFICATE_LIST_BYTES;
    public static final OpenSslContextOption PRIVATE_KEY_METHOD;
    public static final OpenSslContextOption TLS_FALSE_START;
    public static final OpenSslContextOption USE_TASKS;

    static {
        OpenSslContextOption.USE_TASKS = new OpenSslContextOption("USE_TASKS");
        OpenSslContextOption.TLS_FALSE_START = new OpenSslContextOption("TLS_FALSE_START");
        OpenSslContextOption.PRIVATE_KEY_METHOD = new OpenSslContextOption("PRIVATE_KEY_METHOD");
        OpenSslContextOption.ASYNC_PRIVATE_KEY_METHOD = new OpenSslContextOption("ASYNC_PRIVATE_KEY_METHOD");
        OpenSslContextOption.CERTIFICATE_COMPRESSION_ALGORITHMS = new OpenSslContextOption("CERTIFICATE_COMPRESSION_ALGORITHMS");
        OpenSslContextOption.MAX_CERTIFICATE_LIST_BYTES = new OpenSslContextOption("MAX_CERTIFICATE_LIST_BYTES");
    }

    private OpenSslContextOption(String s) {
        super(s);
    }
}

