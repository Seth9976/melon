package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import java.util.Arrays;

final class OpenSslSessionId {
    static final OpenSslSessionId NULL_ID;
    private final int hashCode;
    private final byte[] id;

    static {
        OpenSslSessionId.NULL_ID = new OpenSslSessionId(EmptyArrays.EMPTY_BYTES);
    }

    public OpenSslSessionId(byte[] arr_b) {
        this.id = arr_b;
        this.hashCode = Arrays.hashCode(arr_b);
    }

    public byte[] cloneBytes() {
        return (byte[])this.id.clone();
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof OpenSslSessionId ? Arrays.equals(this.id, ((OpenSslSessionId)object0).id) : false;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }

    @Override
    public String toString() {
        return "OpenSslSessionId{id=" + Arrays.toString(this.id) + '}';
    }
}

