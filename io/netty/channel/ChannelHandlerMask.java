package io.netty.channel;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketAddress;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Map;
import java.util.WeakHashMap;

final class ChannelHandlerMask {
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD})
    @interface Skip {
    }

    private static final FastThreadLocal MASKS = null;
    private static final int MASK_ALL_INBOUND = 0x1FF;
    private static final int MASK_ALL_OUTBOUND = 0x1FE01;
    static final int MASK_BIND = 0x200;
    static final int MASK_CHANNEL_ACTIVE = 8;
    static final int MASK_CHANNEL_INACTIVE = 16;
    static final int MASK_CHANNEL_READ = 0x20;
    static final int MASK_CHANNEL_READ_COMPLETE = 0x40;
    static final int MASK_CHANNEL_REGISTERED = 2;
    static final int MASK_CHANNEL_UNREGISTERED = 4;
    static final int MASK_CHANNEL_WRITABILITY_CHANGED = 0x100;
    static final int MASK_CLOSE = 0x1000;
    static final int MASK_CONNECT = 0x400;
    static final int MASK_DEREGISTER = 0x2000;
    static final int MASK_DISCONNECT = 0x800;
    static final int MASK_EXCEPTION_CAUGHT = 1;
    static final int MASK_FLUSH = 0x10000;
    static final int MASK_ONLY_INBOUND = 510;
    static final int MASK_ONLY_OUTBOUND = 0x1FE00;
    static final int MASK_READ = 0x4000;
    static final int MASK_USER_EVENT_TRIGGERED = 0x80;
    static final int MASK_WRITE = 0x8000;
    private static final InternalLogger logger;

    static {
        ChannelHandlerMask.logger = InternalLoggerFactory.getInstance(ChannelHandlerMask.class);
        ChannelHandlerMask.MASKS = new FastThreadLocal() {
            @Override  // io.netty.util.concurrent.FastThreadLocal
            public Object initialValue() {
                return this.initialValue();
            }

            public Map initialValue() {
                return new WeakHashMap(0x20);
            }
        };
    }

    private static boolean isSkippable(Class class0, String s, Class[] arr_class) {
        return ((Boolean)AccessController.doPrivileged(new PrivilegedExceptionAction() {
            public Boolean run() {
                try {
                    return Boolean.valueOf(class0.getMethod(s, arr_class).isAnnotationPresent(Skip.class));
                }
                catch(NoSuchMethodException noSuchMethodException0) {
                    if(ChannelHandlerMask.logger.isDebugEnabled()) {
                        ChannelHandlerMask.logger.debug("Class {} missing method {}, assume we can not skip execution", new Object[]{class0, s, noSuchMethodException0});
                    }
                    return false;
                }
            }

            @Override
            public Object run() {
                return this.run();
            }
        })).booleanValue();
    }

    public static int mask(Class class0) {
        Map map0 = (Map)ChannelHandlerMask.MASKS.get();
        Integer integer0 = (Integer)map0.get(class0);
        if(integer0 == null) {
            integer0 = ChannelHandlerMask.mask0(class0);
            map0.put(class0, integer0);
        }
        return (int)integer0;
    }

    private static int mask0(Class class0) {
        int v;
        try {
            Class class1 = SocketAddress.class;
            Class class2 = ChannelPromise.class;
            v = 1;
            Class class3 = Object.class;
            Class class4 = ChannelHandlerContext.class;
            if(ChannelInboundHandler.class.isAssignableFrom(class0)) {
                if(ChannelHandlerMask.isSkippable(class0, "channelRegistered", new Class[]{class4})) {
                    v = 509;
                }
                if(ChannelHandlerMask.isSkippable(class0, "channelUnregistered", new Class[]{class4})) {
                    v &= -5;
                }
                if(ChannelHandlerMask.isSkippable(class0, "channelActive", new Class[]{class4})) {
                    v &= -9;
                }
                if(ChannelHandlerMask.isSkippable(class0, "channelInactive", new Class[]{class4})) {
                    v &= -17;
                }
                if(ChannelHandlerMask.isSkippable(class0, "channelRead", new Class[]{class4, class3})) {
                    v &= -33;
                }
                if(ChannelHandlerMask.isSkippable(class0, "channelReadComplete", new Class[]{class4})) {
                    v &= -65;
                }
                if(ChannelHandlerMask.isSkippable(class0, "channelWritabilityChanged", new Class[]{class4})) {
                    v &= 0xFFFFFEFF;
                }
                if(ChannelHandlerMask.isSkippable(class0, "userEventTriggered", new Class[]{class4, class3})) {
                    v &= 0xFFFFFF7F;
                }
            }
            if(ChannelOutboundHandler.class.isAssignableFrom(class0)) {
                v |= 0x1FE01;
                v = ChannelHandlerMask.isSkippable(class0, "bind", new Class[]{class4, class1, class2}) ? v & 0xFFFFFDFF : v | 0x1FE01;
                if(ChannelHandlerMask.isSkippable(class0, "connect", new Class[]{class4, class1, class1, class2})) {
                    v &= 0xFFFFFBFF;
                }
                if(ChannelHandlerMask.isSkippable(class0, "disconnect", new Class[]{class4, class2})) {
                    v &= 0xFFFFF7FF;
                }
                if(ChannelHandlerMask.isSkippable(class0, "close", new Class[]{class4, class2})) {
                    v &= 0xFFFFEFFF;
                }
                if(ChannelHandlerMask.isSkippable(class0, "deregister", new Class[]{class4, class2})) {
                    v &= 0xFFFFDFFF;
                }
                if(ChannelHandlerMask.isSkippable(class0, "read", new Class[]{class4})) {
                    v &= 0xFFFFBFFF;
                }
                if(ChannelHandlerMask.isSkippable(class0, "write", new Class[]{class4, class3, class2})) {
                    v &= 0xFFFF7FFF;
                }
                if(ChannelHandlerMask.isSkippable(class0, "flush", new Class[]{class4})) {
                    v &= 0xFFFEFFFF;
                }
            }
            return ChannelHandlerMask.isSkippable(class0, "exceptionCaught", new Class[]{class4, Throwable.class}) ? v & -2 : v;
        }
        catch(Exception exception0) {
        }
        PlatformDependent.throwException(exception0);
        return v;
    }
}

