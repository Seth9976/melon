package io.netty.channel.socket.nio;

import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ProtocolFamily;
import java.nio.channels.Channel;
import java.nio.channels.spi.SelectorProvider;

final class SelectorProviderUtil {
    private static final InternalLogger logger;

    static {
        SelectorProviderUtil.logger = InternalLoggerFactory.getInstance(SelectorProviderUtil.class);
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static Method findOpenMethod(String s) {
        if(PlatformDependent.javaVersion() >= 15) {
            try {
                return SelectorProvider.class.getMethod(s, ProtocolFamily.class);
            }
            catch(Throwable throwable0) {
                SelectorProviderUtil.logger.debug("SelectorProvider.{}(ProtocolFamily) not available, will use default", s, throwable0);
            }
        }
        return null;
    }

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static Channel newChannel(Method method0, SelectorProvider selectorProvider0, InternetProtocolFamily internetProtocolFamily0) {
        if(internetProtocolFamily0 != null && method0 != null) {
            try {
                return (Channel)method0.invoke(selectorProvider0, ProtocolFamilyConverter.convert(internetProtocolFamily0));
            }
            catch(InvocationTargetException invocationTargetException0) {
                throw new IOException(invocationTargetException0);
            }
            catch(IllegalAccessException illegalAccessException0) {
                throw new IOException(illegalAccessException0);
            }
        }
        return null;
    }
}

