package io.netty.handler.logging;

import U4.x;
import b3.Z;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;
import k8.Y;

@Sharable
public class LoggingHandler extends ChannelDuplexHandler {
    private static final LogLevel DEFAULT_LEVEL;
    private final ByteBufFormat byteBufFormat;
    protected final InternalLogLevel internalLevel;
    private final LogLevel level;
    protected final InternalLogger logger;

    static {
        LoggingHandler.DEFAULT_LEVEL = LogLevel.DEBUG;
    }

    public LoggingHandler() {
        this(LoggingHandler.DEFAULT_LEVEL);
    }

    public LoggingHandler(ByteBufFormat byteBufFormat0) {
        this(LoggingHandler.DEFAULT_LEVEL, byteBufFormat0);
    }

    public LoggingHandler(LogLevel logLevel0) {
        this(logLevel0, ByteBufFormat.HEX_DUMP);
    }

    public LoggingHandler(LogLevel logLevel0, ByteBufFormat byteBufFormat0) {
        this.level = (LogLevel)ObjectUtil.checkNotNull(logLevel0, "level");
        this.byteBufFormat = (ByteBufFormat)ObjectUtil.checkNotNull(byteBufFormat0, "byteBufFormat");
        this.logger = InternalLoggerFactory.getInstance(this.getClass());
        this.internalLevel = logLevel0.toInternalLevel();
    }

    public LoggingHandler(Class class0) {
        this(class0, LoggingHandler.DEFAULT_LEVEL);
    }

    public LoggingHandler(Class class0, LogLevel logLevel0) {
        this(class0, logLevel0, ByteBufFormat.HEX_DUMP);
    }

    public LoggingHandler(Class class0, LogLevel logLevel0, ByteBufFormat byteBufFormat0) {
        ObjectUtil.checkNotNull(class0, "clazz");
        this.level = (LogLevel)ObjectUtil.checkNotNull(logLevel0, "level");
        this.byteBufFormat = (ByteBufFormat)ObjectUtil.checkNotNull(byteBufFormat0, "byteBufFormat");
        this.logger = InternalLoggerFactory.getInstance(class0);
        this.internalLevel = logLevel0.toInternalLevel();
    }

    public LoggingHandler(String s) {
        this(s, LoggingHandler.DEFAULT_LEVEL);
    }

    public LoggingHandler(String s, LogLevel logLevel0) {
        this(s, logLevel0, ByteBufFormat.HEX_DUMP);
    }

    public LoggingHandler(String s, LogLevel logLevel0, ByteBufFormat byteBufFormat0) {
        ObjectUtil.checkNotNull(s, "name");
        this.level = (LogLevel)ObjectUtil.checkNotNull(logLevel0, "level");
        this.byteBufFormat = (ByteBufFormat)ObjectUtil.checkNotNull(byteBufFormat0, "byteBufFormat");
        this.logger = InternalLoggerFactory.getInstance(s);
        this.internalLevel = logLevel0.toInternalLevel();
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void bind(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, ChannelPromise channelPromise0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "BIND", socketAddress0);
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.bind(socketAddress0, channelPromise0);
    }

    public ByteBufFormat byteBufFormat() {
        return this.byteBufFormat;
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelActive(ChannelHandlerContext channelHandlerContext0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "ACTIVE");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.fireChannelActive();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelInactive(ChannelHandlerContext channelHandlerContext0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "INACTIVE");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.fireChannelInactive();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRead(ChannelHandlerContext channelHandlerContext0, Object object0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "READ", object0);
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.fireChannelRead(object0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "READ COMPLETE");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.fireChannelReadComplete();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelRegistered(ChannelHandlerContext channelHandlerContext0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "REGISTERED");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.fireChannelRegistered();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelUnregistered(ChannelHandlerContext channelHandlerContext0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "UNREGISTERED");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.fireChannelUnregistered();
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "WRITABILITY CHANGED");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.fireChannelWritabilityChanged();
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void close(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "CLOSE");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.close(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void connect(ChannelHandlerContext channelHandlerContext0, SocketAddress socketAddress0, SocketAddress socketAddress1, ChannelPromise channelPromise0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "CONNECT", socketAddress0, socketAddress1);
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.connect(socketAddress0, socketAddress1, channelPromise0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void deregister(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "DEREGISTER");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.deregister(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void disconnect(ChannelHandlerContext channelHandlerContext0, ChannelPromise channelPromise0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "DISCONNECT");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.disconnect(channelPromise0);
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext0, Throwable throwable0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "EXCEPTION", throwable0);
            this.logger.log(this.internalLevel, s, throwable0);
        }
        channelHandlerContext0.fireExceptionCaught(throwable0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void flush(ChannelHandlerContext channelHandlerContext0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "FLUSH");
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.flush();
    }

    public String format(ChannelHandlerContext channelHandlerContext0, String s) {
        return channelHandlerContext0.channel().toString() + ' ' + s;
    }

    public String format(ChannelHandlerContext channelHandlerContext0, String s, Object object0) {
        if(object0 instanceof ByteBuf) {
            return this.formatByteBuf(channelHandlerContext0, s, ((ByteBuf)object0));
        }
        return object0 instanceof ByteBufHolder ? this.formatByteBufHolder(channelHandlerContext0, s, ((ByteBufHolder)object0)) : LoggingHandler.formatSimple(channelHandlerContext0, s, object0);
    }

    public String format(ChannelHandlerContext channelHandlerContext0, String s, Object object0, Object object1) {
        if(object1 == null) {
            return LoggingHandler.formatSimple(channelHandlerContext0, s, object0);
        }
        String s1 = channelHandlerContext0.channel().toString();
        String s2 = String.valueOf(object0);
        String s3 = object1.toString();
        StringBuilder stringBuilder0 = new StringBuilder(s3.length() + Z.d(Z.d(s1.length() + 1, 2, s), 2, s2));
        stringBuilder0.append(s1);
        stringBuilder0.append(' ');
        stringBuilder0.append(s);
        stringBuilder0.append(": ");
        return Y.l(stringBuilder0, s2, ", ", s3);
    }

    private String formatByteBuf(ChannelHandlerContext channelHandlerContext0, String s, ByteBuf byteBuf0) {
        String s1 = channelHandlerContext0.channel().toString();
        int v = byteBuf0.readableBytes();
        int v1 = 1;
        if(v == 0) {
            return s1 + ' ' + s + ": 0B";
        }
        int v2 = Z.d(s1.length() + 1, 13, s);
        ByteBufFormat byteBufFormat0 = ByteBufFormat.HEX_DUMP;
        if(this.byteBufFormat == byteBufFormat0) {
            if(v % 15 == 0) {
                v1 = 0;
            }
            v2 = v / 16 * 80 + v1 * 80 + v2 + 322;
        }
        StringBuilder stringBuilder0 = new StringBuilder(v2);
        stringBuilder0.append(s1);
        stringBuilder0.append(' ');
        stringBuilder0.append(s);
        stringBuilder0.append(": ");
        stringBuilder0.append(v);
        stringBuilder0.append('B');
        if(this.byteBufFormat == byteBufFormat0) {
            stringBuilder0.append("\n");
            ByteBufUtil.appendPrettyHexDump(stringBuilder0, byteBuf0);
        }
        return stringBuilder0.toString();
    }

    private String formatByteBufHolder(ChannelHandlerContext channelHandlerContext0, String s, ByteBufHolder byteBufHolder0) {
        String s1 = channelHandlerContext0.channel().toString();
        String s2 = byteBufHolder0.toString();
        ByteBuf byteBuf0 = byteBufHolder0.content();
        int v = byteBuf0.readableBytes();
        int v1 = 1;
        if(v == 0) {
            StringBuilder stringBuilder0 = new StringBuilder(Z.d(Z.d(s1.length() + 1, 2, s), 4, s2));
            stringBuilder0.append(s1);
            stringBuilder0.append(' ');
            stringBuilder0.append(s);
            stringBuilder0.append(", ");
            return x.m(stringBuilder0, s2, ", 0B");
        }
        int v2 = Z.d(Z.d(s1.length() + 1, 2, s), 13, s2);
        ByteBufFormat byteBufFormat0 = ByteBufFormat.HEX_DUMP;
        if(this.byteBufFormat == byteBufFormat0) {
            if(v % 15 == 0) {
                v1 = 0;
            }
            v2 = v / 16 * 80 + v1 * 80 + v2 + 322;
        }
        StringBuilder stringBuilder1 = new StringBuilder(v2);
        stringBuilder1.append(s1);
        stringBuilder1.append(' ');
        stringBuilder1.append(s);
        stringBuilder1.append(": ");
        stringBuilder1.append(s2);
        stringBuilder1.append(", ");
        stringBuilder1.append(v);
        stringBuilder1.append('B');
        if(this.byteBufFormat == byteBufFormat0) {
            stringBuilder1.append("\n");
            ByteBufUtil.appendPrettyHexDump(stringBuilder1, byteBuf0);
        }
        return stringBuilder1.toString();
    }

    private static String formatSimple(ChannelHandlerContext channelHandlerContext0, String s, Object object0) {
        return channelHandlerContext0.channel().toString() + ' ' + s + ": " + object0;
    }

    public LogLevel level() {
        return this.level;
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext0, Object object0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "USER_EVENT", object0);
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.fireUserEventTriggered(object0);
    }

    @Override  // io.netty.channel.ChannelDuplexHandler
    public void write(ChannelHandlerContext channelHandlerContext0, Object object0, ChannelPromise channelPromise0) {
        if(this.logger.isEnabled(this.internalLevel)) {
            String s = this.format(channelHandlerContext0, "WRITE", object0);
            this.logger.log(this.internalLevel, s);
        }
        channelHandlerContext0.write(object0, channelPromise0);
    }
}

