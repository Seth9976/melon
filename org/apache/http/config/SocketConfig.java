package org.apache.http.config;

import androidx.appcompat.app.o;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class SocketConfig implements Cloneable {
    public static class Builder {
        private boolean soKeepAlive;
        private int soLinger;
        private boolean soReuseAddress;
        private int soTimeout;
        private boolean tcpNoDelay;

        public Builder() {
            this.soLinger = -1;
            this.tcpNoDelay = true;
        }

        public SocketConfig build() {
            return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay);
        }

        public Builder setSoKeepAlive(boolean z) {
            this.soKeepAlive = z;
            return this;
        }

        public Builder setSoLinger(int v) {
            this.soLinger = v;
            return this;
        }

        public Builder setSoReuseAddress(boolean z) {
            this.soReuseAddress = z;
            return this;
        }

        public Builder setSoTimeout(int v) {
            this.soTimeout = v;
            return this;
        }

        public Builder setTcpNoDelay(boolean z) {
            this.tcpNoDelay = z;
            return this;
        }
    }

    public static final SocketConfig DEFAULT;
    private final boolean soKeepAlive;
    private final int soLinger;
    private final boolean soReuseAddress;
    private final int soTimeout;
    private final boolean tcpNoDelay;

    static {
        SocketConfig.DEFAULT = new Builder().build();
    }

    public SocketConfig(int v, boolean z, int v1, boolean z1, boolean z2) {
        this.soTimeout = v;
        this.soReuseAddress = z;
        this.soLinger = v1;
        this.soKeepAlive = z1;
        this.tcpNoDelay = z2;
    }

    @Override
    public Object clone() {
        return this.clone();
    }

    public SocketConfig clone() {
        return (SocketConfig)super.clone();
    }

    public static Builder copy(SocketConfig socketConfig0) {
        Args.notNull(socketConfig0, "Socket config");
        return new Builder().setSoTimeout(socketConfig0.getSoTimeout()).setSoReuseAddress(socketConfig0.isSoReuseAddress()).setSoLinger(socketConfig0.getSoLinger()).setSoKeepAlive(socketConfig0.isSoKeepAlive()).setTcpNoDelay(socketConfig0.isTcpNoDelay());
    }

    public static Builder custom() {
        return new Builder();
    }

    public int getSoLinger() {
        return this.soLinger;
    }

    public int getSoTimeout() {
        return this.soTimeout;
    }

    public boolean isSoKeepAlive() {
        return this.soKeepAlive;
    }

    public boolean isSoReuseAddress() {
        return this.soReuseAddress;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[soTimeout=");
        stringBuilder0.append(this.soTimeout);
        stringBuilder0.append(", soReuseAddress=");
        stringBuilder0.append(this.soReuseAddress);
        stringBuilder0.append(", soLinger=");
        stringBuilder0.append(this.soLinger);
        stringBuilder0.append(", soKeepAlive=");
        stringBuilder0.append(this.soKeepAlive);
        stringBuilder0.append(", tcpNoDelay=");
        return o.s(stringBuilder0, this.tcpNoDelay, "]");
    }
}

