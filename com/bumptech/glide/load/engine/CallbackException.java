package com.bumptech.glide.load.engine;

final class CallbackException extends RuntimeException {
    private static final long serialVersionUID = 0x977CDF443D744495L;

    public CallbackException(Throwable throwable0) {
        super("Unexpected exception thrown by non-Glide code", throwable0);
    }
}

