package io.netty.channel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface ChannelHandler {
    @Documented
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE})
    public @interface Sharable {
    }

    @Deprecated
    void exceptionCaught(ChannelHandlerContext arg1, Throwable arg2);

    void handlerAdded(ChannelHandlerContext arg1);

    void handlerRemoved(ChannelHandlerContext arg1);
}

