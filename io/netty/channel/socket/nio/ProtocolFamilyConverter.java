package io.netty.channel.socket.nio;

import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.util.internal.SuppressJava6Requirement;
import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;

final class ProtocolFamilyConverter {
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static ProtocolFamily convert(InternetProtocolFamily internetProtocolFamily0) {
        switch(io.netty.channel.socket.nio.ProtocolFamilyConverter.1.$SwitchMap$io$netty$channel$socket$InternetProtocolFamily[internetProtocolFamily0.ordinal()]) {
            case 1: {
                return StandardProtocolFamily.INET;
            }
            case 2: {
                return StandardProtocolFamily.INET6;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
}

