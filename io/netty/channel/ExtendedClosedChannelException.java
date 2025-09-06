package io.netty.channel;

import java.nio.channels.ClosedChannelException;

final class ExtendedClosedChannelException extends ClosedChannelException {
    public ExtendedClosedChannelException(Throwable throwable0) {
        if(throwable0 != null) {
            this.initCause(throwable0);
        }
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}

