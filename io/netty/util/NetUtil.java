package io.netty.util;

import H0.b;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Collection;
import jeb.synthetic.TWR;

public final class NetUtil {
    static final class SoMaxConnAction implements PrivilegedAction {
        private SoMaxConnAction() {
        }

        public SoMaxConnAction(io.netty.util.NetUtil.1 netUtil$10) {
        }

        public Integer run() {
            Exception exception1;
            Integer integer0;
            BufferedReader bufferedReader1;
            int v = 0x80;
            File file0 = new File("/proc/sys/net/core/somaxconn");
            BufferedReader bufferedReader0 = null;
            try {
                if(file0.exists()) {
                    bufferedReader1 = new BufferedReader(new FileReader(file0));
                    goto label_26;
                }
                else {
                    if(SystemPropertyUtil.getBoolean("io.netty.net.somaxconn.trySysctl", false)) {
                        integer0 = NetUtil.sysctlGetInt("kern.ipc.somaxconn");
                        if(integer0 == null) {
                            integer0 = NetUtil.sysctlGetInt("kern.ipc.soacceptqueue");
                            if(integer0 != null) {
                                v = (int)integer0;
                            }
                        }
                        else {
                            v = (int)integer0;
                        }
                    }
                    else {
                        integer0 = null;
                    }
                    if(integer0 == null) {
                        NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file0, v);
                    }
                    goto label_40;
                }
                return v;
            }
            catch(Exception exception0) {
                bufferedReader1 = null;
                exception1 = exception0;
                goto label_32;
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(null, throwable0);
                throw throwable0;
            }
            try {
            label_26:
                v = Integer.parseInt(bufferedReader1.readLine());
                if(NetUtil.logger.isDebugEnabled()) {
                    NetUtil.logger.debug("{}: {}", file0, v);
                }
                bufferedReader0 = bufferedReader1;
            }
            catch(Exception exception1) {
                try {
                label_32:
                    if(NetUtil.logger.isDebugEnabled()) {
                        NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", new Object[]{file0, v, exception1});
                    }
                }
                catch(Throwable throwable0) {
                    goto label_38;
                }
                if(bufferedReader1 != null) {
                    try {
                        bufferedReader1.close();
                        return v;
                    }
                    catch(Exception unused_ex) {
                    }
                }
                return v;
            }
            catch(Throwable throwable0) {
            label_38:
                TWR.safeClose$NT(bufferedReader1, throwable0);
                throw throwable0;
            }
        label_40:
            if(bufferedReader0 != null) {
                try {
                    bufferedReader0.close();
                    return v;
                }
                catch(Exception unused_ex) {
                }
            }
            return v;
        }

        @Override
        public Object run() {
            return this.run();
        }
    }

    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final boolean IPV4_PREFERRED = false;
    private static final int IPV4_SEPARATORS = 3;
    private static final boolean IPV6_ADDRESSES_PREFERRED = false;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_WORD_COUNT = 8;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final Collection NETWORK_INTERFACES;
    public static final int SOMAXCONN;
    private static final InternalLogger logger;

    static {
        boolean z = SystemPropertyUtil.getBoolean("java.net.preferIPv4Stack", false);
        NetUtil.IPV4_PREFERRED = z;
        InternalLogger internalLogger0 = InternalLoggerFactory.getInstance(NetUtil.class);
        NetUtil.logger = internalLogger0;
        NetUtil.IPV6_ADDRESSES_PREFERRED = false;
        internalLogger0.debug("-Djava.net.preferIPv4Stack: {}", Boolean.valueOf(z));
        internalLogger0.debug("-Djava.net.preferIPv6Addresses: {}", "false");
        Collection collection0 = NetUtilInitializations.networkInterfaces();
        NetUtil.NETWORK_INTERFACES = collection0;
        Inet4Address inet4Address0 = NetUtilInitializations.createLocalhost4();
        NetUtil.LOCALHOST4 = inet4Address0;
        Inet6Address inet6Address0 = NetUtilInitializations.createLocalhost6();
        NetUtil.LOCALHOST6 = inet6Address0;
        NetworkIfaceAndInetAddress netUtilInitializations$NetworkIfaceAndInetAddress0 = NetUtilInitializations.determineLoopback(collection0, inet4Address0, inet6Address0);
        NetUtil.LOOPBACK_IF = netUtilInitializations$NetworkIfaceAndInetAddress0.iface();
        NetUtil.LOCALHOST = netUtilInitializations$NetworkIfaceAndInetAddress0.address();
        NetUtil.SOMAXCONN = (int)(((Integer)AccessController.doPrivileged(new SoMaxConnAction(null))));
    }

    public static String bytesToIpAddress(byte[] arr_b) {
        return NetUtil.bytesToIpAddress(arr_b, 0, arr_b.length);
    }

    public static String bytesToIpAddress(byte[] arr_b, int v, int v1) {
        switch(v1) {
            case 4: {
                return (arr_b[v] & 0xFF) + '.' + (arr_b[v + 1] & 0xFF) + '.' + (arr_b[v + 2] & 0xFF) + '.' + (arr_b[v + 3] & 0xFF);
            }
            case 16: {
                return NetUtil.toAddressString(arr_b, v, false);
            }
            default: {
                throw new IllegalArgumentException("length: " + v1 + " (expected: 4 or 16)");
            }
        }
    }

    public static byte[] createByteArrayFromIpAddressString(String s) {
        if(NetUtil.isValidIpV4Address(s)) {
            return NetUtil.validIpV4ToBytes(s);
        }
        if(NetUtil.isValidIpV6Address(s)) {
            if(s.charAt(0) == 91) {
                s = b.d(1, 1, s);
            }
            int v = s.indexOf(37);
            if(v >= 0) {
                s = s.substring(0, v);
            }
            return NetUtil.getIPv6ByName(s, true);
        }
        return null;
    }

    public static InetAddress createInetAddressFromIpAddressString(String s) {
        if(NetUtil.isValidIpV4Address(s)) {
            byte[] arr_b = NetUtil.validIpV4ToBytes(s);
            try {
                return InetAddress.getByAddress(arr_b);
            }
            catch(UnknownHostException unknownHostException0) {
                throw new IllegalStateException(unknownHostException0);
            }
        }
        if(NetUtil.isValidIpV6Address(s)) {
            if(s.charAt(0) == 91) {
                s = b.d(1, 1, s);
            }
            int v = s.indexOf(37);
            if(v >= 0) {
                try {
                    int v1 = Integer.parseInt(s.substring(v + 1));
                    byte[] arr_b1 = NetUtil.getIPv6ByName(s.substring(0, v), true);
                    if(arr_b1 == null) {
                        return null;
                    }
                    try {
                        return Inet6Address.getByAddress(null, arr_b1, v1);
                    }
                    catch(UnknownHostException unknownHostException1) {
                        throw new IllegalStateException(unknownHostException1);
                    }
                }
                catch(NumberFormatException unused_ex) {
                    return null;
                }
            }
            byte[] arr_b2 = NetUtil.getIPv6ByName(s, true);
            if(arr_b2 == null) {
                return null;
            }
            try {
                return InetAddress.getByAddress(arr_b2);
            }
            catch(UnknownHostException unknownHostException2) {
                throw new IllegalStateException(unknownHostException2);
            }
        }
        return null;
    }

    private static int decimalDigit(String s, int v) {
        return s.charAt(v) - 0x30;
    }

    public static Inet6Address getByName(CharSequence charSequence0) {
        return NetUtil.getByName(charSequence0, true);
    }

    public static Inet6Address getByName(CharSequence charSequence0, boolean z) {
        byte[] arr_b = NetUtil.getIPv6ByName(charSequence0, z);
        if(arr_b == null) {
            return null;
        }
        try {
            return Inet6Address.getByAddress(null, arr_b, -1);
        }
        catch(UnknownHostException unknownHostException0) {
            throw new RuntimeException(unknownHostException0);
        }
    }

    // 去混淆评级： 低(20)
    public static String getHostname(InetSocketAddress inetSocketAddress0) {
        return inetSocketAddress0.getHostName();
    }

    public static byte[] getIPv6ByName(CharSequence charSequence0, boolean z) {
        int v18;
        boolean z1;
        byte[] arr_b = new byte[16];
        int v = charSequence0.length();
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = -1;
        int v5 = 0;
        int v6 = 0;
        int v7 = 0;
        int v8 = 0;
        while(true) {
            z1 = true;
            if(v1 >= v) {
                break;
            }
            int v9 = charSequence0.charAt(v1);
            switch(v9) {
                case 46: {
                    ++v3;
                    int v10 = v1 - v4;
                    if(v10 <= 3 && v4 >= 0 && v3 <= 3 && (v5 <= 0 || v6 + v7 >= 12) && v1 + 1 < v && v6 < 16 && (v3 != 1 || z && (v6 == 0 || NetUtil.isValidIPv4Mapped(arr_b, v6, v2, v7)) && (v10 != 3 || NetUtil.isValidNumericChar(charSequence0.charAt(v1 - 1)) && NetUtil.isValidNumericChar(charSequence0.charAt(v1 - 2)) && NetUtil.isValidNumericChar(charSequence0.charAt(v1 - 3))) && (v10 != 2 || NetUtil.isValidNumericChar(charSequence0.charAt(v1 - 1)) && NetUtil.isValidNumericChar(charSequence0.charAt(v1 - 2))) && (v10 != 1 || NetUtil.isValidNumericChar(charSequence0.charAt(v1 - 1))))) {
                        int v11 = v8 << (3 - v10 << 2);
                        int v12 = (v11 >> 4 & 15) * 10 + (v11 & 15) * 100 + (v11 >> 8 & 15);
                        if(v12 > 0xFF) {
                            return null;
                        }
                        arr_b[v6] = (byte)v12;
                        ++v6;
                        v4 = -1;
                        v8 = 0;
                        break;
                    }
                    return null;
                }
                case 58: {
                    int v13 = v1 - v4;
                    if(v13 > 4 || v3 > 0 || v5 + 1 > 8) {
                        return null;
                    }
                    int v14 = v6 + 1;
                    if(v14 >= 16) {
                        return null;
                    }
                    int v15 = v8 << (4 - v13 << 2);
                    if(v7 > 0) {
                        v7 -= 2;
                    }
                    arr_b[v6] = (byte)((v15 & 15) << 4 | v15 >> 4 & 15);
                    v6 += 2;
                    arr_b[v14] = (byte)((v15 >> 8 & 15) << 4 | v15 >> 12 & 15);
                    if(v1 + 1 >= v || charSequence0.charAt(v1 + 1) != 58) {
                        ++v5;
                    }
                    else {
                        if(v2 == 0 && (v1 + 2 >= v || charSequence0.charAt(v1 + 2) != 58)) {
                            v5 += 2;
                            v7 = 14 - v6;
                            ++v1;
                            v2 = v6;
                            v4 = -1;
                            v8 = 0;
                            break;
                        }
                        return null;
                    }
                    v4 = -1;
                    v8 = 0;
                    break;
                }
                default: {
                    if(NetUtil.isValidHexChar(((char)v9)) && (v3 <= 0 || NetUtil.isValidNumericChar(((char)v9)))) {
                        if(v4 < 0) {
                            v4 = v1;
                        }
                        else if(v1 - v4 > 4) {
                            return null;
                        }
                        v8 += StringUtil.decodeHexNibble(((char)v9)) << (v1 - v4 << 2);
                        break;
                    }
                    return null;
                }
            }
            ++v1;
        }
        if(v2 <= 0) {
            z1 = false;
        }
        if(v3 > 0) {
            if(v4 > 0 && v1 - v4 > 3 || v3 != 3 || v6 >= 16 || v5 != 0 && (v5 < 2 || (z1 || v5 != 6 || charSequence0.charAt(0) == 58) && (!z1 || v5 >= 8 || charSequence0.charAt(0) == 58 && v2 > 2))) {
                return null;
            }
            int v16 = v8 << (3 - (v1 - v4) << 2);
            int v17 = (v16 >> 4 & 15) * 10 + (v16 & 15) * 100 + (v16 >> 8 & 15);
            if(v17 > 0xFF) {
                return null;
            }
            v18 = v6 + 1;
            arr_b[v6] = (byte)v17;
        }
        else if((v4 <= 0 || v1 - v4 <= 4) && v5 >= 2 && (z1 || v5 + 1 == 8 && charSequence0.charAt(0) != 58 && charSequence0.charAt(v - 1) != 58) && (!z1 || v5 <= 8 && (v5 != 8 || (v2 > 2 || charSequence0.charAt(0) == 58) && (v2 < 14 || charSequence0.charAt(v - 1) == 58))) && v6 + 1 < 16 && (v4 >= 0 || charSequence0.charAt(v - 2) == 58) && (v2 <= 2 || charSequence0.charAt(0) != 58)) {
            if(v4 >= 0) {
                int v19 = v1 - v4;
                if(v19 <= 4) {
                    v8 <<= 4 - v19 << 2;
                }
            }
            arr_b[v6] = (byte)((v8 & 15) << 4 | v8 >> 4 & 15);
            v18 = v6 + 2;
            arr_b[v6 + 1] = (byte)((v8 >> 8 & 15) << 4 | v8 >> 12 & 15);
        }
        else {
            return null;
        }
        if(v18 < 16) {
            int v20 = v18 - v2;
            System.arraycopy(arr_b, v2, arr_b, 16 - v20, v20);
            Arrays.fill(arr_b, v2, 16 - v20, 0);
        }
        if(v3 > 0) {
            arr_b[11] = -1;
            arr_b[10] = -1;
        }
        return arr_b;
    }

    private static boolean inRangeEndExclusive(int v, int v1, int v2) {
        return v >= v1 && v < v2;
    }

    public static String intToIpAddress(int v) {
        return (v >> 24 & 0xFF) + '.' + (v >> 16 & 0xFF) + '.' + (v >> 8 & 0xFF) + '.' + (v & 0xFF);
    }

    public static int ipv4AddressToInt(Inet4Address inet4Address0) {
        byte[] arr_b = inet4Address0.getAddress();
        return arr_b[3] & 0xFF | ((arr_b[0] & 0xFF) << 24 | (arr_b[1] & 0xFF) << 16 | (arr_b[2] & 0xFF) << 8);
    }

    private static byte ipv4WordToByte(String s, int v, int v1) {
        int v2 = NetUtil.decimalDigit(s, v);
        if(v + 1 == v1) {
            return (byte)v2;
        }
        int v3 = v2 * 10 + NetUtil.decimalDigit(s, v + 1);
        return v + 2 == v1 ? ((byte)v3) : ((byte)(v3 * 10 + NetUtil.decimalDigit(s, v + 2)));
    }

    public static boolean isIpV4StackPreferred() {
        return NetUtil.IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return NetUtil.IPV6_ADDRESSES_PREFERRED;
    }

    // 去混淆评级： 低(30)
    private static boolean isValidHexChar(char c) {
        return c >= 0x30 && c <= 57 || c >= 65 && c <= 70 || c >= 97 && c <= 102;
    }

    private static boolean isValidIPv4Mapped(byte[] arr_b, int v, int v1, int v2) {
        boolean z = v2 + v1 >= 14;
        return v <= 12 && v >= 2 && (!z || v1 < 12) && NetUtil.isValidIPv4MappedSeparators(arr_b[v - 1], arr_b[v - 2], z) && PlatformDependent.isZero(arr_b, 0, v - 3);
    }

    private static boolean isValidIPv4MappedChar(char c) {
        return c == 70 || c == 102;
    }

    // 去混淆评级： 低(20)
    private static boolean isValidIPv4MappedSeparators(byte b, byte b1, boolean z) {
        return b == b1 && (b == 0 || !z && b1 == -1);
    }

    private static boolean isValidIpV4Address(AsciiString asciiString0, int v, int v1) {
        if(v1 - v <= 15 && v1 - v >= 7) {
            int v2 = asciiString0.indexOf('.', v + 1);
            if(v2 > 0 && NetUtil.isValidIpV4Word(asciiString0, v, v2)) {
                int v3 = asciiString0.indexOf('.', v2 + 2);
                if(v3 > 0 && NetUtil.isValidIpV4Word(asciiString0, v2 + 1, v3)) {
                    int v4 = asciiString0.indexOf('.', v3 + 2);
                    return v4 > 0 && NetUtil.isValidIpV4Word(asciiString0, v3 + 1, v4) && NetUtil.isValidIpV4Word(asciiString0, v4 + 1, v1);
                }
            }
        }
        return false;
    }

    public static boolean isValidIpV4Address(CharSequence charSequence0) {
        return NetUtil.isValidIpV4Address(charSequence0, 0, charSequence0.length());
    }

    private static boolean isValidIpV4Address(CharSequence charSequence0, int v, int v1) {
        if(charSequence0 instanceof String) {
            return NetUtil.isValidIpV4Address(((String)charSequence0), v, v1);
        }
        return charSequence0 instanceof AsciiString ? NetUtil.isValidIpV4Address(((AsciiString)charSequence0), v, v1) : NetUtil.isValidIpV4Address0(charSequence0, v, v1);
    }

    public static boolean isValidIpV4Address(String s) {
        return NetUtil.isValidIpV4Address(s, 0, s.length());
    }

    private static boolean isValidIpV4Address(String s, int v, int v1) {
        if(v1 - v <= 15 && v1 - v >= 7) {
            int v2 = s.indexOf(46, v + 1);
            if(v2 > 0 && NetUtil.isValidIpV4Word(s, v, v2)) {
                int v3 = s.indexOf(46, v2 + 2);
                if(v3 > 0 && NetUtil.isValidIpV4Word(s, v2 + 1, v3)) {
                    int v4 = s.indexOf(46, v3 + 2);
                    return v4 > 0 && NetUtil.isValidIpV4Word(s, v3 + 1, v4) && NetUtil.isValidIpV4Word(s, v4 + 1, v1);
                }
            }
        }
        return false;
    }

    private static boolean isValidIpV4Address0(CharSequence charSequence0, int v, int v1) {
        if(v1 - v <= 15 && v1 - v >= 7) {
            int v2 = AsciiString.indexOf(charSequence0, '.', v + 1);
            if(v2 > 0 && NetUtil.isValidIpV4Word(charSequence0, v, v2)) {
                int v3 = AsciiString.indexOf(charSequence0, '.', v2 + 2);
                if(v3 > 0 && NetUtil.isValidIpV4Word(charSequence0, v2 + 1, v3)) {
                    int v4 = AsciiString.indexOf(charSequence0, '.', v3 + 2);
                    return v4 > 0 && NetUtil.isValidIpV4Word(charSequence0, v3 + 1, v4) && NetUtil.isValidIpV4Word(charSequence0, v4 + 1, v1);
                }
            }
        }
        return false;
    }

    private static boolean isValidIpV4Word(CharSequence charSequence0, int v, int v1) {
        int v2 = v1 - v;
        if(v2 >= 1 && v2 <= 3) {
            int v3 = charSequence0.charAt(v);
            if(v3 >= 0x30) {
                if(v2 == 3) {
                    int v4 = charSequence0.charAt(v + 1);
                    if(v4 >= 0x30) {
                        int v5 = charSequence0.charAt(v + 2);
                        return v5 >= 0x30 && (v3 <= 49 && v4 <= 57 && v5 <= 57 || v3 == 50 && v4 <= 53 && (v5 <= 53 || v4 < 53 && v5 <= 57));
                    }
                    return false;
                }
                return v3 <= 57 && (v2 == 1 || NetUtil.isValidNumericChar(charSequence0.charAt(v + 1)));
            }
        }
        return false;
    }

    public static boolean isValidIpV6Address(CharSequence charSequence0) {
        int v5;
        int v3;
        int v = charSequence0.length();
        int v1 = 2;
        if(v < 2) {
            return false;
        }
        int v2 = charSequence0.charAt(0);
        if(v2 == 91) {
            --v;
            if(charSequence0.charAt(v) != 93) {
                return false;
            }
            v2 = charSequence0.charAt(1);
            v3 = 1;
        }
        else {
            v3 = 0;
        }
        if(v2 == 58) {
            if(charSequence0.charAt(v3 + 1) != 58) {
                return false;
            }
            int v4 = v3;
            v3 += 2;
            v5 = v4;
        }
        else {
            v5 = -1;
            v1 = 0;
        }
        int v6 = 0;
        int v7 = v3;
        while(v7 < v) {
            int v8 = charSequence0.charAt(v7);
            if(NetUtil.isValidHexChar(((char)v8))) {
                if(v6 < 4) {
                    ++v6;
                    ++v7;
                    continue;
                }
                return false;
            }
            else if(v8 != 37) {
                switch(v8) {
                    case 46: {
                        if(v5 < 0 && v1 != 6 || v1 == 7 && v5 >= v3 || v1 > 7) {
                            return false;
                        }
                        int v9 = v7 - v6;
                        int v10 = v9 - 2;
                        if(NetUtil.isValidIPv4MappedChar(charSequence0.charAt(v10))) {
                            if(NetUtil.isValidIPv4MappedChar(charSequence0.charAt(v9 - 3)) && NetUtil.isValidIPv4MappedChar(charSequence0.charAt(v9 - 4)) && NetUtil.isValidIPv4MappedChar(charSequence0.charAt(v9 - 5))) {
                                v10 = v9 - 7;
                                goto label_43;
                            }
                            return false;
                        }
                    label_43:
                        while(v10 >= v3) {
                            switch(charSequence0.charAt(v10)) {
                                case 0x30: 
                                case 58: {
                                    --v10;
                                    continue;
                                }
                                default: {
                                    return false;
                                }
                            }
                        }
                        int v11 = AsciiString.indexOf(charSequence0, '%', v9 + 7);
                        if(v11 >= 0) {
                            v = v11;
                        }
                        return NetUtil.isValidIpV4Address(charSequence0, v9, v);
                    }
                    case 58: {
                        if(v1 > 7) {
                            return false;
                        }
                        if(charSequence0.charAt(v7 - 1) == 58) {
                            if(v5 >= 0) {
                                return false;
                            }
                            v5 = v7 - 1;
                        }
                        else {
                            v6 = 0;
                        }
                        ++v1;
                        break;
                    }
                    default: {
                        return false;
                    }
                }
            }
            else {
                goto label_63;
            }
            ++v7;
            continue;
        label_63:
            v = v7;
            if(true) {
                break;
            }
        }
        return v5 >= 0 ? v5 + 2 == v || v6 > 0 && (v1 < 8 || v5 <= v3) : v1 == 7 && v6 > 0;
    }

    public static boolean isValidIpV6Address(String s) {
        return NetUtil.isValidIpV6Address(s);
    }

    private static boolean isValidNumericChar(char c) {
        return c >= 0x30 && c <= 57;
    }

    private static StringBuilder newSocketAddressStringBuilder(String s, String s1, boolean z) {
        int v = s.length();
        if(z) {
            StringBuilder stringBuilder0 = new StringBuilder(s1.length() + (v + 1));
            stringBuilder0.append(s);
            return stringBuilder0;
        }
        StringBuilder stringBuilder1 = new StringBuilder(s1.length() + (v + 3));
        if(v > 1 && s.charAt(0) == 91 && s.charAt(v - 1) == 93) {
            stringBuilder1.append(s);
            return stringBuilder1;
        }
        stringBuilder1.append('[');
        stringBuilder1.append(s);
        stringBuilder1.append(']');
        return stringBuilder1;
    }

    private static Integer sysctlGetInt(String s) {
        Integer integer0;
        Process process0 = new ProcessBuilder(new String[]{"sysctl", s}).start();
        try {
            BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(process0.getInputStream()));
            try {
                String s1 = bufferedReader0.readLine();
                if(s1 != null && s1.startsWith(s)) {
                    int v1 = s1.length() - 1;
                    while(true) {
                        if(v1 <= s.length()) {
                            break;
                        }
                        if(Character.isDigit(s1.charAt(v1))) {
                            --v1;
                            continue;
                        }
                        integer0 = Integer.valueOf(s1.substring(v1 + 1));
                        goto label_16;
                    }
                }
                goto label_19;
            }
            catch(Throwable throwable0) {
                bufferedReader0.close();
                throw throwable0;
            }
        label_16:
            bufferedReader0.close();
            return integer0;
        label_19:
            bufferedReader0.close();
            return null;
        }
        finally {
            process0.destroy();
        }
    }

    public static String toAddressString(InetAddress inetAddress0) {
        return NetUtil.toAddressString(inetAddress0, false);
    }

    public static String toAddressString(InetAddress inetAddress0, boolean z) {
        if(inetAddress0 instanceof Inet4Address) {
            return inetAddress0.getHostAddress();
        }
        if(!(inetAddress0 instanceof Inet6Address)) {
            throw new IllegalArgumentException("Unhandled type: " + inetAddress0);
        }
        return NetUtil.toAddressString(inetAddress0.getAddress(), 0, z);
    }

    private static String toAddressString(byte[] arr_b, int v, boolean z) {
        int v2;
        int[] arr_v = new int[8];
        boolean z1 = false;
        for(int v1 = 0; true; ++v1) {
            v2 = 1;
            if(v1 >= 8) {
                break;
            }
            int v3 = (v1 << 1) + v;
            arr_v[v1] = arr_b[v3 + 1] & 0xFF | (arr_b[v3] & 0xFF) << 8;
        }
        int v4 = -1;
        int v5 = -1;
        int v6 = -1;
        int v7 = 0;
        for(int v8 = 0; v8 < 8; ++v8) {
            if(arr_v[v8] != 0) {
                if(v5 >= 0) {
                    int v9 = v8 - v5;
                    if(v9 > v7) {
                        v7 = v9;
                    }
                    else {
                        v5 = v6;
                    }
                    v6 = v5;
                    v5 = -1;
                }
            }
            else if(v5 < 0) {
                v5 = v8;
            }
        }
        if(v5 < 0 || 8 - v5 <= v7) {
            v5 = v6;
        }
        else {
            v7 = 8 - v5;
        }
        if(v7 == 1) {
            v7 = 0;
        }
        else {
            v4 = v5;
        }
        int v10 = v7 + v4;
        StringBuilder stringBuilder0 = new StringBuilder(39);
        if(v10 < 0) {
            stringBuilder0.append(Integer.toHexString(arr_v[0]));
            while(v2 < 8) {
                stringBuilder0.append(':');
                stringBuilder0.append(Integer.toHexString(arr_v[v2]));
                ++v2;
            }
            return stringBuilder0.toString();
        }
        if(NetUtil.inRangeEndExclusive(0, v4, v10)) {
            stringBuilder0.append("::");
            if(z && v10 == 5 && arr_v[5] == 0xFFFF) {
                z1 = true;
            }
        }
        else {
            stringBuilder0.append(Integer.toHexString(arr_v[0]));
        }
        while(v2 < 8) {
            if(!NetUtil.inRangeEndExclusive(v2, v4, v10)) {
                if(!NetUtil.inRangeEndExclusive(v2 - 1, v4, v10)) {
                    if(!z1 || v2 == 6) {
                        stringBuilder0.append(':');
                    }
                    else {
                        stringBuilder0.append('.');
                    }
                }
                if(!z1 || v2 <= 5) {
                    stringBuilder0.append(Integer.toHexString(arr_v[v2]));
                }
                else {
                    stringBuilder0.append(arr_v[v2] >> 8);
                    stringBuilder0.append('.');
                    stringBuilder0.append(arr_v[v2] & 0xFF);
                }
            }
            else if(!NetUtil.inRangeEndExclusive(v2 - 1, v4, v10)) {
                stringBuilder0.append("::");
            }
            ++v2;
        }
        return stringBuilder0.toString();
    }

    public static String toSocketAddressString(String s, int v) {
        String s1 = String.valueOf(v);
        StringBuilder stringBuilder0 = NetUtil.newSocketAddressStringBuilder(s, s1, !NetUtil.isValidIpV6Address(s));
        stringBuilder0.append(':');
        stringBuilder0.append(s1);
        return stringBuilder0.toString();
    }

    public static String toSocketAddressString(InetSocketAddress inetSocketAddress0) {
        StringBuilder stringBuilder0;
        String s = String.valueOf(inetSocketAddress0.getPort());
        if(inetSocketAddress0.isUnresolved()) {
            String s1 = NetUtil.getHostname(inetSocketAddress0);
            stringBuilder0 = NetUtil.newSocketAddressStringBuilder(s1, s, !NetUtil.isValidIpV6Address(s1));
        }
        else {
            InetAddress inetAddress0 = inetSocketAddress0.getAddress();
            stringBuilder0 = NetUtil.newSocketAddressStringBuilder(NetUtil.toAddressString(inetAddress0), s, inetAddress0 instanceof Inet4Address);
        }
        stringBuilder0.append(':');
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    public static byte[] validIpV4ToBytes(String s) {
        int v = s.indexOf(46, 1);
        int v1 = s.indexOf(46, v + 2);
        int v2 = s.indexOf(46, v1 + 2);
        return new byte[]{NetUtil.ipv4WordToByte(s, 0, v), NetUtil.ipv4WordToByte(s, v + 1, v1), NetUtil.ipv4WordToByte(s, v1 + 1, v2), NetUtil.ipv4WordToByte(s, v2 + 1, s.length())};
    }

    class io.netty.util.NetUtil.1 {
    }

}

