package org.apache.http.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public final class NetUtils {
    public static void formatAddress(StringBuilder stringBuilder0, SocketAddress socketAddress0) {
        Args.notNull(stringBuilder0, "Buffer");
        Args.notNull(socketAddress0, "Socket address");
        if(socketAddress0 instanceof InetSocketAddress) {
            InetAddress inetAddress0 = ((InetSocketAddress)socketAddress0).getAddress();
            if(inetAddress0 != null) {
                inetAddress0 = inetAddress0.getHostAddress();
            }
            stringBuilder0.append(inetAddress0);
            stringBuilder0.append(':');
            stringBuilder0.append(((InetSocketAddress)socketAddress0).getPort());
            return;
        }
        stringBuilder0.append(socketAddress0);
    }
}

