package io.netty.channel;

import io.netty.util.internal.ThrowableUtil;
import java.nio.channels.ClosedChannelException;

final class StacklessClosedChannelException extends ClosedChannelException {
    private static final long serialVersionUID = 0xE1436DA781EC5C00L;

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public static StacklessClosedChannelException newInstance(Class class0, String s) {
        return (StacklessClosedChannelException)ThrowableUtil.unknownStackTrace(new StacklessClosedChannelException(), class0, s);
    }
}

