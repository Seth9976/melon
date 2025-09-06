package org.apache.http;

import java.io.Serializable;

@Deprecated
public class ProtocolVersion implements Serializable {
    protected final int major;
    protected final int minor;
    protected final String protocol;

    public ProtocolVersion(String s, int v, int v1) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public Object clone() {
        throw new RuntimeException("Stub!");
    }

    public int compareToVersion(ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final boolean equals(Object object0) {
        throw new RuntimeException("Stub!");
    }

    public ProtocolVersion forVersion(int v, int v1) {
        throw new RuntimeException("Stub!");
    }

    public final int getMajor() {
        throw new RuntimeException("Stub!");
    }

    public final int getMinor() {
        throw new RuntimeException("Stub!");
    }

    public final String getProtocol() {
        throw new RuntimeException("Stub!");
    }

    public final boolean greaterEquals(ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public final int hashCode() {
        throw new RuntimeException("Stub!");
    }

    public boolean isComparable(ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    public final boolean lessEquals(ProtocolVersion protocolVersion0) {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String toString() {
        throw new RuntimeException("Stub!");
    }
}

