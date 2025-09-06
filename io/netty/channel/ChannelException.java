package io.netty.channel;

import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;

public class ChannelException extends RuntimeException {
    static final class StacklessChannelException extends ChannelException {
        private static final long serialVersionUID = 0xA76531CD9135AFEDL;

        public StacklessChannelException(String s, Throwable throwable0) {
            super(s, throwable0);
        }

        public StacklessChannelException(String s, Throwable throwable0, boolean z) {
            super(s, throwable0, z);
        }

        @Override
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    static final boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 2908618315971075004L;

    public ChannelException() {
    }

    public ChannelException(String s) {
        super(s);
    }

    public ChannelException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    @SuppressJava6Requirement(reason = "uses Java 7+ RuntimeException.<init>(String, Throwable, boolean, boolean) but is guarded by version checks")
    public ChannelException(String s, Throwable throwable0, boolean z) {
        super(s, throwable0, false, true);
    }

    public ChannelException(Throwable throwable0) {
        super(throwable0);
    }

    // 去混淆评级： 低(20)
    public static ChannelException newStatic(String s, Class class0, String s1) {
        return (ChannelException)ThrowableUtil.unknownStackTrace(new StacklessChannelException(s, null), class0, s1);
    }
}

