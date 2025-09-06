package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

final class IPPacket {
    private static final int IPV6_VERSION_TRAFFIC_FLOW = 60000000;
    private static final byte MAX_TTL = -1;
    private static final byte TCP = 6;
    private static final byte UDP = 17;
    private static final short V4_HEADER_SIZE = 20;

    private static void writePacketv4(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, int v1, int v2) {
        byteBuf0.writeByte(69);
        byteBuf0.writeByte(0);
        byteBuf0.writeShort(byteBuf1.readableBytes() + 20);
        byteBuf0.writeShort(0);
        byteBuf0.writeShort(0);
        byteBuf0.writeByte(-1);
        byteBuf0.writeByte(v);
        byteBuf0.writeShort(0);
        byteBuf0.writeInt(v1);
        byteBuf0.writeInt(v2);
        byteBuf0.writeBytes(byteBuf1);
    }

    private static void writePacketv6(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, byte[] arr_b, byte[] arr_b1) {
        byteBuf0.writeInt(60000000);
        byteBuf0.writeShort(byteBuf1.readableBytes());
        byteBuf0.writeByte(v & 0xFF);
        byteBuf0.writeByte(-1);
        byteBuf0.writeBytes(arr_b);
        byteBuf0.writeBytes(arr_b1);
        byteBuf0.writeBytes(byteBuf1);
    }

    public static void writeTCPv4(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, int v1) {
        IPPacket.writePacketv4(byteBuf0, byteBuf1, 6, v, v1);
    }

    public static void writeTCPv6(ByteBuf byteBuf0, ByteBuf byteBuf1, byte[] arr_b, byte[] arr_b1) {
        IPPacket.writePacketv6(byteBuf0, byteBuf1, 6, arr_b, arr_b1);
    }

    public static void writeUDPv4(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, int v1) {
        IPPacket.writePacketv4(byteBuf0, byteBuf1, 17, v, v1);
    }

    public static void writeUDPv6(ByteBuf byteBuf0, ByteBuf byteBuf1, byte[] arr_b, byte[] arr_b1) {
        IPPacket.writePacketv6(byteBuf0, byteBuf1, 17, arr_b, arr_b1);
    }
}

