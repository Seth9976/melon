package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.util.NetUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;

final class SslUtils {
    static final String[] DEFAULT_CIPHER_SUITES = null;
    static final String[] DEFAULT_TLSV13_CIPHER_SUITES = null;
    static final short DTLS_1_0 = (short)0xFEFF;
    static final short DTLS_1_2 = (short)0xFEFD;
    static final short DTLS_1_3 = -260;
    static final short DTLS_RECORD_HEADER_LENGTH = 13;
    static final int GMSSL_PROTOCOL_VERSION = 0x101;
    static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    static final int NOT_ENCRYPTED = -2;
    static final int NOT_ENOUGH_DATA = -1;
    static final int SSL_CONTENT_TYPE_ALERT = 21;
    static final int SSL_CONTENT_TYPE_APPLICATION_DATA = 23;
    static final int SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC = 20;
    static final int SSL_CONTENT_TYPE_EXTENSION_HEARTBEAT = 24;
    static final int SSL_CONTENT_TYPE_HANDSHAKE = 22;
    static final int SSL_RECORD_HEADER_LENGTH = 5;
    static final Set TLSV13_CIPHERS;
    static final String[] TLSV13_CIPHER_SUITES;
    private static final boolean TLSV1_3_JDK_DEFAULT_ENABLED;
    private static final boolean TLSV1_3_JDK_SUPPORTED;
    private static final InternalLogger logger;

    static {
        SslUtils.logger = InternalLoggerFactory.getInstance(SslUtils.class);
        SslUtils.TLSV13_CIPHERS = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(new String[]{"TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_128_CCM_8_SHA256", "TLS_AES_128_CCM_SHA256"})));
        String[] arr_s = {"TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384"};
        SslUtils.TLSV13_CIPHER_SUITES = arr_s;
        boolean z = SslUtils.isTLSv13SupportedByJDK0(null);
        SslUtils.TLSV1_3_JDK_SUPPORTED = z;
        SslUtils.TLSV1_3_JDK_DEFAULT_ENABLED = SslUtils.isTLSv13EnabledByJDK0(null);
        SslUtils.DEFAULT_TLSV13_CIPHER_SUITES = z ? arr_s : EmptyArrays.EMPTY_STRINGS;
        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
        linkedHashSet0.add("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        linkedHashSet0.add("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        linkedHashSet0.add("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        linkedHashSet0.add("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        linkedHashSet0.add("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        linkedHashSet0.add("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        linkedHashSet0.add("TLS_RSA_WITH_AES_128_GCM_SHA256");
        linkedHashSet0.add("TLS_RSA_WITH_AES_128_CBC_SHA");
        linkedHashSet0.add("TLS_RSA_WITH_AES_256_CBC_SHA");
        Collections.addAll(linkedHashSet0, SslUtils.DEFAULT_TLSV13_CIPHER_SUITES);
        SslUtils.DEFAULT_CIPHER_SUITES = (String[])linkedHashSet0.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    public static void addIfSupported(Set set0, List list0, String[] arr_s) {
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            if(set0.contains(s)) {
                list0.add(s);
            }
        }
    }

    public static boolean arrayContains(String[] arr_s, String s) {
        for(int v = 0; v < arr_s.length; ++v) {
            if(s.equals(arr_s[v])) {
                return true;
            }
        }
        return false;
    }

    public static int getEncryptedPacketLength(ByteBuf byteBuf0, int v) {
        int v5;
        int v2;
        int v1 = 0;
        switch(byteBuf0.getUnsignedByte(v)) {
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: {
                v2 = 1;
                break;
            }
            default: {
                v2 = 0;
            }
        }
        if(v2 == 0) {
            v5 = 0;
        }
        else {
            int v3 = byteBuf0.getUnsignedByte(v + 1);
            int v4 = byteBuf0.getShort(v + 1);
            if(v3 == 3) {
            label_17:
                v5 = SslUtils.unsignedShortBE(byteBuf0, v + 3) + 5;
                if(v5 > 5) {
                    v1 = v2;
                }
            }
            else {
                switch(v4) {
                    case -260: 
                    case 0xFFFFFEFD: 
                    case 0xFFFFFEFF: {
                        if(byteBuf0.readableBytes() < v + 13) {
                            return -1;
                        }
                        v5 = SslUtils.unsignedShortBE(byteBuf0, v + 11) + 13;
                        v1 = v2;
                        break;
                    }
                    case 0x101: {
                        goto label_17;
                    }
                    default: {
                        v5 = 0;
                    }
                }
            }
        }
        if(v1 == 0) {
            int v6 = (byteBuf0.getUnsignedByte(v) & 0x80) == 0 ? 3 : 2;
            switch(byteBuf0.getUnsignedByte(v + v6 + 1)) {
                case 2: 
                case 3: {
                    int v7 = v6 == 2 ? (SslUtils.shortBE(byteBuf0, v) & 0x7FFF) + 2 : (SslUtils.shortBE(byteBuf0, v) & 0x3FFF) + 3;
                    return v7 > v6 ? v7 : -1;
                }
                default: {
                    return -2;
                }
            }
        }
        return v5;
    }

    private static int getEncryptedPacketLength(ByteBuffer byteBuffer0) {
        int v3;
        int v2;
        int v = byteBuffer0.position();
        int v1 = 0;
        switch(SslUtils.unsignedByte(byteBuffer0.get(v))) {
            case 20: 
            case 21: 
            case 22: 
            case 23: 
            case 24: {
                v2 = 1;
                break;
            }
            default: {
                v2 = 0;
            }
        }
        if(v2 == 0) {
            v3 = 0;
        }
        else if(SslUtils.unsignedByte(byteBuffer0.get(v + 1)) != 3 && byteBuffer0.getShort(v + 1) != 0x101) {
            v3 = 0;
        }
        else {
            v3 = SslUtils.unsignedShortBE(byteBuffer0, v + 3) + 5;
            if(v3 > 5) {
                v1 = v2;
            }
        }
        if(v1 == 0) {
            int v4 = (SslUtils.unsignedByte(byteBuffer0.get(v)) & 0x80) == 0 ? 3 : 2;
            switch(SslUtils.unsignedByte(byteBuffer0.get(v + v4 + 1))) {
                case 2: 
                case 3: {
                    int v5 = v4 == 2 ? (SslUtils.shortBE(byteBuffer0, v) & 0x7FFF) + 2 : (SslUtils.shortBE(byteBuffer0, v) & 0x3FFF) + 3;
                    return v5 > v4 ? v5 : -1;
                }
                default: {
                    return -2;
                }
            }
        }
        return v3;
    }

    public static int getEncryptedPacketLength(ByteBuffer[] arr_byteBuffer, int v) {
        ByteBuffer byteBuffer0 = arr_byteBuffer[v];
        if(byteBuffer0.remaining() >= 5) {
            return SslUtils.getEncryptedPacketLength(byteBuffer0);
        }
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(5);
        while(true) {
            ByteBuffer byteBuffer2 = arr_byteBuffer[v].duplicate();
            if(byteBuffer2.remaining() > byteBuffer1.remaining()) {
                byteBuffer2.limit(byteBuffer1.remaining() + byteBuffer2.position());
            }
            byteBuffer1.put(byteBuffer2);
            if(!byteBuffer1.hasRemaining()) {
                break;
            }
            ++v;
        }
        byteBuffer1.flip();
        return SslUtils.getEncryptedPacketLength(byteBuffer1);
    }

    // 去混淆评级： 低(20)
    public static SSLContext getSSLContext(String s) {
        SSLContext sSLContext0 = StringUtil.isNullOrEmpty(s) ? SSLContext.getInstance("TLSv1.2") : SSLContext.getInstance("TLSv1.2", s);
        sSLContext0.init(null, new TrustManager[0], null);
        return sSLContext0;
    }

    private static String getTlsVersion() [...] // 潜在的解密器

    public static void handleHandshakeFailure(ChannelHandlerContext channelHandlerContext0, Throwable throwable0, boolean z) {
        channelHandlerContext0.flush();
        if(z) {
            channelHandlerContext0.fireUserEventTriggered(new SslHandshakeCompletionEvent(throwable0));
        }
        channelHandlerContext0.close();
    }

    public static boolean isTLSv13Cipher(String s) {
        return SslUtils.TLSV13_CIPHERS.contains(s);
    }

    public static boolean isTLSv13EnabledByJDK(Provider provider0) {
        return provider0 == null ? SslUtils.TLSV1_3_JDK_DEFAULT_ENABLED : SslUtils.isTLSv13EnabledByJDK0(provider0);
    }

    private static boolean isTLSv13EnabledByJDK0(Provider provider0) {
        try {
            return SslUtils.arrayContains(SslUtils.newInitContext(provider0).getDefaultSSLParameters().getProtocols(), "TLSv1.3");
        }
        catch(Throwable throwable0) {
            SslUtils.logger.debug("Unable to detect if JDK SSLEngine with provider {} enables TLSv1.3 by default, assuming no", provider0, throwable0);
            return false;
        }
    }

    public static boolean isTLSv13SupportedByJDK(Provider provider0) {
        return provider0 == null ? false : SslUtils.isTLSv13SupportedByJDK0(provider0);
    }

    private static boolean isTLSv13SupportedByJDK0(Provider provider0) {
        try {
            return SslUtils.arrayContains(SslUtils.newInitContext(provider0).getSupportedSSLParameters().getProtocols(), "TLSv1.3");
        }
        catch(Throwable throwable0) {
            SslUtils.logger.debug("Unable to detect if JDK SSLEngine with provider {} supports TLSv1.3, assuming no", provider0, throwable0);
            return false;
        }
    }

    // 去混淆评级： 低(40)
    public static boolean isValidHostNameForSNI(String s) {
        return s != null && s.indexOf(46) > 0 && !s.endsWith(".") && !s.startsWith("/") && !NetUtil.isValidIpV4Address(s) && !NetUtil.isValidIpV6Address(s);
    }

    private static SSLContext newInitContext(Provider provider0) {
        SSLContext sSLContext0 = provider0 == null ? SSLContext.getInstance("TLS") : SSLContext.getInstance("TLS", provider0);
        sSLContext0.init(null, new TrustManager[0], null);
        return sSLContext0;
    }

    private static short shortBE(ByteBuf byteBuf0, int v) {
        short v1 = byteBuf0.getShort(v);
        return byteBuf0.order() == ByteOrder.LITTLE_ENDIAN ? Short.reverseBytes(v1) : v1;
    }

    private static short shortBE(ByteBuffer byteBuffer0, int v) {
        return byteBuffer0.order() == ByteOrder.BIG_ENDIAN ? byteBuffer0.getShort(v) : ByteBufUtil.swapShort(byteBuffer0.getShort(v));
    }

    public static ByteBuf toBase64(ByteBufAllocator byteBufAllocator0, ByteBuf byteBuf0) {
        ByteBuf byteBuf1 = Base64.encode(byteBuf0, byteBuf0.readerIndex(), byteBuf0.readableBytes(), true, Base64Dialect.STANDARD, byteBufAllocator0);
        byteBuf0.readerIndex(byteBuf0.writerIndex());
        return byteBuf1;
    }

    // 去混淆评级： 低(20)
    public static SSLHandshakeException toSSLHandshakeException(Throwable throwable0) {
        return throwable0 instanceof SSLHandshakeException ? ((SSLHandshakeException)throwable0) : ((SSLHandshakeException)new SSLHandshakeException(throwable0.getMessage()).initCause(throwable0));
    }

    private static short unsignedByte(byte b) {
        return (short)(b & 0xFF);
    }

    private static int unsignedShortBE(ByteBuf byteBuf0, int v) {
        int v1 = byteBuf0.getUnsignedShort(v);
        return byteBuf0.order() == ByteOrder.LITTLE_ENDIAN ? Integer.reverseBytes(v1) >>> 16 : v1;
    }

    private static int unsignedShortBE(ByteBuffer byteBuffer0, int v) {
        return SslUtils.shortBE(byteBuffer0, v) & 0xFFFF;
    }

    public static void useFallbackCiphersIfDefaultIsEmpty(List list0, Iterable iterable0) {
        if(list0.isEmpty()) {
            for(Object object0: iterable0) {
                String s = (String)object0;
                if(!s.startsWith("SSL_") && !s.contains("_RC4_")) {
                    list0.add(s);
                }
            }
        }
    }

    public static void useFallbackCiphersIfDefaultIsEmpty(List list0, String[] arr_s) {
        SslUtils.useFallbackCiphersIfDefaultIsEmpty(list0, Arrays.asList(arr_s));
    }

    public static void zeroout(ByteBuf byteBuf0) {
        if(!byteBuf0.isReadOnly()) {
            byteBuf0.setZero(0, byteBuf0.capacity());
        }
    }

    public static void zerooutAndRelease(ByteBuf byteBuf0) {
        SslUtils.zeroout(byteBuf0);
        byteBuf0.release();
    }
}

