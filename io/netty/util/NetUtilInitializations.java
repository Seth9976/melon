package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SocketUtils;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

final class NetUtilInitializations {
    static final class NetworkIfaceAndInetAddress {
        private final InetAddress address;
        private final NetworkInterface iface;

        public NetworkIfaceAndInetAddress(NetworkInterface networkInterface0, InetAddress inetAddress0) {
            this.iface = networkInterface0;
            this.address = inetAddress0;
        }

        public InetAddress address() {
            return this.address;
        }

        public NetworkInterface iface() {
            return this.iface;
        }
    }

    private static final InternalLogger logger;

    static {
        NetUtilInitializations.logger = InternalLoggerFactory.getInstance(NetUtilInitializations.class);
    }

    public static Inet4Address createLocalhost4() {
        try {
            return (Inet4Address)InetAddress.getByAddress("localhost", new byte[]{0x7F, 0, 0, 1});
        }
        catch(Exception exception0) {
            PlatformDependent.throwException(exception0);
            return null;
        }
    }

    public static Inet6Address createLocalhost6() {
        try {
            return (Inet6Address)InetAddress.getByAddress("localhost", new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
        }
        catch(Exception exception0) {
            PlatformDependent.throwException(exception0);
            return null;
        }
    }

    public static NetworkIfaceAndInetAddress determineLoopback(Collection collection0, Inet4Address inet4Address0, Inet6Address inet6Address0) {
        InetAddress inetAddress1;
        NetworkInterface networkInterface1;
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: collection0) {
            NetworkInterface networkInterface0 = (NetworkInterface)object0;
            if(SocketUtils.addressesFromNetworkInterface(networkInterface0).hasMoreElements()) {
                arrayList0.add(networkInterface0);
            }
        }
        for(Object object1: arrayList0) {
            networkInterface1 = (NetworkInterface)object1;
            Enumeration enumeration0 = SocketUtils.addressesFromNetworkInterface(networkInterface1);
        label_13:
            if(!enumeration0.hasMoreElements()) {
                continue;
            }
            InetAddress inetAddress0 = (InetAddress)enumeration0.nextElement();
            if(!inetAddress0.isLoopbackAddress()) {
                goto label_13;
            }
            inetAddress1 = inetAddress0;
            goto label_20;
        }
        networkInterface1 = null;
        inetAddress1 = null;
    label_20:
        if(networkInterface1 == null) {
            try {
                for(Object object2: arrayList0) {
                    NetworkInterface networkInterface2 = (NetworkInterface)object2;
                    if(networkInterface2.isLoopback()) {
                        Enumeration enumeration1 = SocketUtils.addressesFromNetworkInterface(networkInterface2);
                        if(enumeration1.hasMoreElements()) {
                            networkInterface1 = networkInterface2;
                            inetAddress1 = (InetAddress)enumeration1.nextElement();
                            networkInterface1 = networkInterface2;
                            break;
                        }
                        if(false) {
                            break;
                        }
                    }
                }
                if(networkInterface1 == null) {
                    NetUtilInitializations.logger.warn("Failed to find the loopback interface");
                }
            }
            catch(SocketException socketException0) {
                NetUtilInitializations.logger.warn("Failed to find the loopback interface", socketException0);
            }
        }
        if(networkInterface1 != null) {
            Object[] arr_object = {networkInterface1.getName(), networkInterface1.getDisplayName(), inetAddress1.getHostAddress()};
            NetUtilInitializations.logger.debug("Loopback interface: {} ({}, {})", arr_object);
            return new NetworkIfaceAndInetAddress(networkInterface1, inetAddress1);
        }
        if(inetAddress1 == null) {
            try {
                if(NetworkInterface.getByInetAddress(inet6Address0) == null) {
                    inet6Address0 = null;
                }
                else {
                    NetUtilInitializations.logger.debug("Using hard-coded IPv6 localhost address: {}", inet6Address0);
                }
            }
            catch(Exception unused_ex) {
                NetUtilInitializations.logger.debug("Using hard-coded IPv4 localhost address: {}", inet4Address0);
                return new NetworkIfaceAndInetAddress(null, inet4Address0);
            }
            catch(Throwable throwable0) {
                NetUtilInitializations.logger.debug("Using hard-coded IPv4 localhost address: {}", inet4Address0);
                throw throwable0;
            }
            if(inet6Address0 == null) {
                NetUtilInitializations.logger.debug("Using hard-coded IPv4 localhost address: {}", inet4Address0);
                return new NetworkIfaceAndInetAddress(null, inet4Address0);
            }
            return new NetworkIfaceAndInetAddress(null, inet6Address0);
        }
        return new NetworkIfaceAndInetAddress(null, inetAddress1);
    }

    public static Collection networkInterfaces() {
        ArrayList arrayList0 = new ArrayList();
        try {
            Enumeration enumeration0 = NetworkInterface.getNetworkInterfaces();
            if(enumeration0 != null) {
                while(enumeration0.hasMoreElements()) {
                    arrayList0.add(enumeration0.nextElement());
                }
            }
        }
        catch(SocketException socketException0) {
            NetUtilInitializations.logger.warn("Failed to retrieve the list of available network interfaces", socketException0);
        }
        return Collections.unmodifiableList(arrayList0);
    }
}

