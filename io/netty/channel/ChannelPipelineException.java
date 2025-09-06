package io.netty.channel;

public class ChannelPipelineException extends ChannelException {
    private static final long serialVersionUID = 0x2EE53D0A6E3D079CL;

    public ChannelPipelineException() {
    }

    public ChannelPipelineException(String s) {
        super(s);
    }

    public ChannelPipelineException(String s, Throwable throwable0) {
        super(s, throwable0);
    }

    public ChannelPipelineException(Throwable throwable0) {
        super(throwable0);
    }
}

