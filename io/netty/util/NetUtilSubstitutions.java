package io.netty.util;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.InjectAccessors;
import com.oracle.svm.core.annotate.TargetClass;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Collection;

@TargetClass(NetUtil.class)
final class NetUtilSubstitutions {
    static final class NetUtilLocalhost4Accessor {
        public static Inet4Address get() {
            return NetUtilLocalhost4LazyHolder.access$000();
        }

        public static void set(Inet4Address inet4Address0) {
        }
    }

    static final class NetUtilLocalhost4LazyHolder {
        private static final Inet4Address LOCALHOST4;

        static {
            NetUtilLocalhost4LazyHolder.LOCALHOST4 = NetUtilInitializations.createLocalhost4();
        }
    }

    static final class NetUtilLocalhost6Accessor {
        public static Inet6Address get() {
            return NetUtilLocalhost6LazyHolder.access$100();
        }

        public static void set(Inet6Address inet6Address0) {
        }
    }

    static final class NetUtilLocalhost6LazyHolder {
        private static final Inet6Address LOCALHOST6;

        static {
            NetUtilLocalhost6LazyHolder.LOCALHOST6 = NetUtilInitializations.createLocalhost6();
        }
    }

    static final class NetUtilLocalhostAccessor {
        public static InetAddress get() {
            return NetUtilLocalhostLazyHolder.access$200();
        }

        public static void set(InetAddress inetAddress0) {
        }
    }

    static final class NetUtilLocalhostLazyHolder {
        private static final InetAddress LOCALHOST;

        static {
            NetUtilLocalhostLazyHolder.LOCALHOST = NetUtilInitializations.determineLoopback(NetUtilNetworkInterfacesLazyHolder.access$300(), NetUtilLocalhost4LazyHolder.LOCALHOST4, NetUtilLocalhost6LazyHolder.LOCALHOST6).address();
        }

        public static InetAddress access$200() {
            return NetUtilLocalhostLazyHolder.LOCALHOST;
        }
    }

    static final class NetUtilNetworkInterfacesAccessor {
        public static Collection get() {
            return NetUtilNetworkInterfacesLazyHolder.access$300();
        }

        public static void set(Collection collection0) {
        }
    }

    static final class NetUtilNetworkInterfacesLazyHolder {
        private static final Collection NETWORK_INTERFACES;

        static {
            NetUtilNetworkInterfacesLazyHolder.NETWORK_INTERFACES = NetUtilInitializations.networkInterfaces();
        }

        public static Collection access$300() {
            return NetUtilNetworkInterfacesLazyHolder.NETWORK_INTERFACES;
        }
    }

    @Alias
    @InjectAccessors(NetUtilLocalhostAccessor.class)
    public static InetAddress LOCALHOST;
    @Alias
    @InjectAccessors(NetUtilLocalhost4Accessor.class)
    public static Inet4Address LOCALHOST4;
    @Alias
    @InjectAccessors(NetUtilLocalhost6Accessor.class)
    public static Inet6Address LOCALHOST6;
    @Alias
    @InjectAccessors(NetUtilNetworkInterfacesAccessor.class)
    public static Collection NETWORK_INTERFACES;

}

