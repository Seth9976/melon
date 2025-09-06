package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

final class UDPPacket {
    private static final short UDP_HEADER_SIZE = 8;

    public static void writePacket(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, int v1) {
        byteBuf0.writeShort(v);
        byteBuf0.writeShort(v1);
        byteBuf0.writeShort(byteBuf1.readableBytes() + 8);
        byteBuf0.writeShort(1);
        byteBuf0.writeBytes(byteBuf1);
    }
}

