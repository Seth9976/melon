package io.netty.handler.ssl;

import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.internal.ReflectionUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Field;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSession;

public abstract class SslMasterKeyHandler extends ChannelInboundHandlerAdapter {
    static final class WiresharkSslMasterKeyHandler extends SslMasterKeyHandler {
        private static final InternalLogger wireshark_logger;

        static {
            WiresharkSslMasterKeyHandler.wireshark_logger = InternalLoggerFactory.getInstance("io.netty.wireshark");
        }

        private WiresharkSslMasterKeyHandler() {
        }

        public WiresharkSslMasterKeyHandler(io.netty.handler.ssl.SslMasterKeyHandler.1 sslMasterKeyHandler$10) {
        }

        @Override  // io.netty.handler.ssl.SslMasterKeyHandler
        public void accept(SecretKey secretKey0, SSLSession sSLSession0) {
            if(secretKey0.getEncoded().length != 0x30) {
                throw new IllegalArgumentException("An invalid length master key was provided.");
            }
            String s = ByteBufUtil.hexDump(sSLSession0.getId()).toLowerCase();
            String s1 = ByteBufUtil.hexDump(secretKey0.getEncoded()).toLowerCase();
            WiresharkSslMasterKeyHandler.wireshark_logger.warn("RSA Session-ID:{} Master-Key:{}", s, s1);
        }
    }

    private static final Class SSL_SESSIONIMPL_CLASS = null;
    private static final Field SSL_SESSIONIMPL_MASTER_SECRET_FIELD = null;
    public static final String SYSTEM_PROP_KEY = "io.netty.ssl.masterKeyHandler";
    private static final Throwable UNAVAILABILITY_CAUSE;
    private static final InternalLogger logger;

    static {
        Field field1;
        Throwable throwable1;
        Class class0;
        SslMasterKeyHandler.logger = InternalLoggerFactory.getInstance(SslMasterKeyHandler.class);
        Field field0 = null;
        try {
            class0 = Class.forName("sun.security.ssl.SSLSessionImpl");
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            field1 = null;
            goto label_14;
        }
        try {
            field0 = class0.getDeclaredField("masterSecret");
            throwable1 = ReflectionUtil.trySetAccessible(field0, true);
            SslMasterKeyHandler.UNAVAILABILITY_CAUSE = throwable1;
            SslMasterKeyHandler.SSL_SESSIONIMPL_CLASS = class0;
            SslMasterKeyHandler.SSL_SESSIONIMPL_MASTER_SECRET_FIELD = field0;
            return;
        }
        catch(Throwable throwable1) {
            field1 = field0;
            field0 = class0;
        }
    label_14:
        InternalLogger internalLogger0 = SslMasterKeyHandler.logger;
        if(internalLogger0.isTraceEnabled()) {
            internalLogger0.debug("sun.security.ssl.SSLSessionImpl is unavailable.", throwable1);
        }
        else {
            internalLogger0.debug("sun.security.ssl.SSLSessionImpl is unavailable: {}", throwable1.getMessage());
        }
        class0 = field0;
        field0 = field1;
        SslMasterKeyHandler.UNAVAILABILITY_CAUSE = throwable1;
        SslMasterKeyHandler.SSL_SESSIONIMPL_CLASS = class0;
        SslMasterKeyHandler.SSL_SESSIONIMPL_MASTER_SECRET_FIELD = field0;
    }

    public abstract void accept(SecretKey arg1, SSLSession arg2);

    public static void ensureSunSslEngineAvailability() {
        Throwable throwable0 = SslMasterKeyHandler.UNAVAILABILITY_CAUSE;
        if(throwable0 != null) {
            throw new IllegalStateException("Failed to find SSLSessionImpl on classpath", throwable0);
        }
    }

    public static boolean isSunSslEngineAvailable() [...] // 潜在的解密器

    public boolean masterKeyHandlerEnabled() {
        return SystemPropertyUtil.getBoolean("io.netty.ssl.masterKeyHandler", false);
    }

    public static SslMasterKeyHandler newWireSharkSslMasterKeyHandler() {
        return new WiresharkSslMasterKeyHandler(null);
    }

    public static Throwable sunSslEngineUnavailabilityCause() {
        return SslMasterKeyHandler.UNAVAILABILITY_CAUSE;
    }

    @Override  // io.netty.channel.ChannelInboundHandlerAdapter
    public final void userEventTriggered(ChannelHandlerContext channelHandlerContext0, Object object0) {
        SecretKey secretKey0;
        if(object0 == SslHandshakeCompletionEvent.SUCCESS && this.masterKeyHandlerEnabled()) {
            SSLEngine sSLEngine0 = ((SslHandler)channelHandlerContext0.pipeline().get(SslHandler.class)).engine();
            SSLSession sSLSession0 = sSLEngine0.getSession();
            if(SslMasterKeyHandler.isSunSslEngineAvailable() && sSLSession0.getClass().equals(SslMasterKeyHandler.SSL_SESSIONIMPL_CLASS)) {
                try {
                    secretKey0 = (SecretKey)SslMasterKeyHandler.SSL_SESSIONIMPL_MASTER_SECRET_FIELD.get(sSLSession0);
                }
                catch(IllegalAccessException illegalAccessException0) {
                    throw new IllegalArgumentException("Failed to access the field \'masterSecret\' via reflection.", illegalAccessException0);
                }
                this.accept(secretKey0, sSLSession0);
            }
            else if(OpenSsl.isAvailable() && sSLEngine0 instanceof ReferenceCountedOpenSslEngine) {
                this.accept(((ReferenceCountedOpenSslEngine)sSLEngine0).masterKey(), sSLSession0);
            }
        }
        channelHandlerContext0.fireUserEventTriggered(object0);
    }

    class io.netty.handler.ssl.SslMasterKeyHandler.1 {
    }

}

