package io.netty.handler.ssl;

import io.netty.internal.tcnative.SessionTicketKey;

public final class OpenSslSessionTicketKey {
    public static final int AES_KEY_SIZE = 16;
    public static final int HMAC_KEY_SIZE = 16;
    public static final int NAME_SIZE = 16;
    public static final int TICKET_KEY_SIZE = 0x30;
    final SessionTicketKey key;

    public OpenSslSessionTicketKey(byte[] arr_b, byte[] arr_b1, byte[] arr_b2) {
        this.key = new SessionTicketKey(((byte[])arr_b.clone()), ((byte[])arr_b1.clone()), ((byte[])arr_b2.clone()));
    }

    public byte[] aesKey() {
        return (byte[])this.key.getAesKey().clone();
    }

    public byte[] hmacKey() {
        return (byte[])this.key.getHmacKey().clone();
    }

    public byte[] name() {
        return (byte[])this.key.getName().clone();
    }
}

