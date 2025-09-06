package io.netty.util.internal;

import com.iloen.melon.custom.l1;
import io.netty.util.NetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class MacAddressUtil {
    private static final int EUI48_MAC_ADDRESS_LENGTH = 6;
    private static final int EUI64_MAC_ADDRESS_LENGTH = 8;
    private static final InternalLogger logger;

    static {
        MacAddressUtil.logger = InternalLoggerFactory.getInstance(MacAddressUtil.class);
    }

    public static byte[] bestAvailableMac() {
        byte[] arr_b1;
        byte[] arr_b = EmptyArrays.EMPTY_BYTES;
        InetAddress inetAddress0 = NetUtil.LOCALHOST4;
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        for(Object object0: NetUtil.NETWORK_INTERFACES) {
            NetworkInterface networkInterface0 = (NetworkInterface)object0;
            Enumeration enumeration0 = SocketUtils.addressesFromNetworkInterface(networkInterface0);
            if(enumeration0.hasMoreElements()) {
                InetAddress inetAddress1 = (InetAddress)enumeration0.nextElement();
                if(!inetAddress1.isLoopbackAddress()) {
                    linkedHashMap0.put(networkInterface0, inetAddress1);
                }
            }
        }
        for(Object object1: linkedHashMap0.entrySet()) {
            NetworkInterface networkInterface1 = (NetworkInterface)((Map.Entry)object1).getKey();
            InetAddress inetAddress2 = (InetAddress)((Map.Entry)object1).getValue();
            if(!networkInterface1.isVirtual()) {
                try {
                    arr_b1 = SocketUtils.hardwareAddressFromNetworkInterface(networkInterface1);
                }
                catch(SocketException socketException0) {
                    MacAddressUtil.logger.debug("Failed to get the hardware address of a network interface: {}", networkInterface1, socketException0);
                    continue;
                }
                int v = MacAddressUtil.compareAddresses(arr_b, arr_b1);
                if(v < 0) {
                    inetAddress0 = inetAddress2;
                    arr_b = arr_b1;
                }
                else if(v == 0) {
                    int v1 = MacAddressUtil.compareAddresses(inetAddress0, inetAddress2);
                    if(v1 < 0 || v1 == 0 && arr_b.length < arr_b1.length) {
                        inetAddress0 = inetAddress2;
                        arr_b = arr_b1;
                    }
                }
            }
        }
        if(arr_b == EmptyArrays.EMPTY_BYTES) {
            return null;
        }
        if(arr_b.length == 6) {
            byte[] arr_b2 = new byte[8];
            System.arraycopy(arr_b, 0, arr_b2, 0, 3);
            arr_b2[3] = -1;
            arr_b2[4] = -2;
            System.arraycopy(arr_b, 3, arr_b2, 5, 3);
            return arr_b2;
        }
        return Arrays.copyOf(arr_b, 8);
    }

    private static int compareAddresses(InetAddress inetAddress0, InetAddress inetAddress1) {
        return MacAddressUtil.scoreAddress(inetAddress0) - MacAddressUtil.scoreAddress(inetAddress1);
    }

    public static int compareAddresses(byte[] arr_b, byte[] arr_b1) {
        if(arr_b1 != null && arr_b1.length >= 6) {
            int v = 0;
            while(v < arr_b1.length) {
                switch(arr_b1[v]) {
                    case 0: 
                    case 1: {
                        ++v;
                        continue;
                    }
                    default: {
                        int v1 = arr_b1[0];
                        if((v1 & 1) != 0) {
                            return 1;
                        }
                        if((v1 & 2) == 0) {
                            return arr_b.length == 0 || (arr_b[0] & 2) != 0 ? -1 : 0;
                        }
                        return arr_b.length == 0 || (arr_b[0] & 2) != 0 ? 0 : 1;
                    }
                }
            }
        }
        return 1;
    }

    public static byte[] defaultMachineId() {
        byte[] arr_b = MacAddressUtil.bestAvailableMac();
        if(arr_b == null) {
            arr_b = new byte[8];
            PlatformDependent.threadLocalRandom().nextBytes(arr_b);
            String s = MacAddressUtil.formatAddress(arr_b);
            MacAddressUtil.logger.warn("Failed to find a usable hardware address from the network interfaces; using random bytes: {}", s);
        }
        return arr_b;
    }

    public static String formatAddress(byte[] arr_b) {
        StringBuilder stringBuilder0 = new StringBuilder(24);
        for(int v = 0; v < arr_b.length; ++v) {
            stringBuilder0.append(String.format("%02x:", ((int)(arr_b[v] & 0xFF))));
        }
        return l1.q(stringBuilder0, 1, 0);
    }

    public static byte[] parseMAC(String s) {
        byte[] arr_b;
        int v;
        switch(s.length()) {
            case 17: {
                v = s.charAt(2);
                MacAddressUtil.validateMacSeparator(((char)v));
                arr_b = new byte[6];
                break;
            }
            case 23: {
                v = s.charAt(2);
                MacAddressUtil.validateMacSeparator(((char)v));
                arr_b = new byte[8];
                break;
            }
            default: {
                throw new IllegalArgumentException("value is not supported [MAC-48, EUI-48, EUI-64]");
            }
        }
        int v1 = arr_b.length - 1;
        int v2 = 0;
        int v3;
        for(v3 = 0; v2 < v1; v3 += 3) {
            arr_b[v2] = StringUtil.decodeHexByte(s, v3);
            if(s.charAt(v3 + 2) != v) {
                throw new IllegalArgumentException("expected separator \'" + ((char)v) + " but got \'" + s.charAt(v3 + 2) + "\' at index: " + (v3 + 2));
            }
            ++v2;
        }
        arr_b[v1] = StringUtil.decodeHexByte(s, v3);
        return arr_b;
    }

    private static int scoreAddress(InetAddress inetAddress0) {
        if(!inetAddress0.isAnyLocalAddress() && !inetAddress0.isLoopbackAddress()) {
            if(inetAddress0.isMulticastAddress()) {
                return 1;
            }
            if(inetAddress0.isLinkLocalAddress()) {
                return 2;
            }
            return inetAddress0.isSiteLocalAddress() ? 3 : 4;
        }
        return 0;
    }

    private static void validateMacSeparator(char c) {
        if(c != 45 && c != 58) {
            throw new IllegalArgumentException("unsupported separator: " + c + " (expected: [:-])");
        }
    }
}

