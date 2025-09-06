package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

final class EthernetPacket {
    private static final byte[] DUMMY_DESTINATION_MAC_ADDRESS = null;
    private static final byte[] DUMMY_SOURCE_MAC_ADDRESS = null;
    private static final int V4 = 0x800;
    private static final int V6 = 0x86DD;

    static {
        EthernetPacket.DUMMY_SOURCE_MAC_ADDRESS = new byte[]{0, 0, 94, 0, 83, 0};
        EthernetPacket.DUMMY_DESTINATION_MAC_ADDRESS = new byte[]{0, 0, 94, 0, 83, -1};
    }

    public static void writeIPv4(ByteBuf byteBuf0, ByteBuf byteBuf1) {
        EthernetPacket.writePacket(byteBuf0, byteBuf1, EthernetPacket.DUMMY_SOURCE_MAC_ADDRESS, EthernetPacket.DUMMY_DESTINATION_MAC_ADDRESS, 0x800);
    }

    public static void writeIPv6(ByteBuf byteBuf0, ByteBuf byteBuf1) {
        EthernetPacket.writePacket(byteBuf0, byteBuf1, EthernetPacket.DUMMY_SOURCE_MAC_ADDRESS, EthernetPacket.DUMMY_DESTINATION_MAC_ADDRESS, 0x86DD);
    }

    private static void writePacket(ByteBuf byteBuf0, ByteBuf byteBuf1, byte[] arr_b, byte[] arr_b1, int v) {
        byteBuf0.writeBytes(arr_b1);
        byteBuf0.writeBytes(arr_b);
        byteBuf0.writeShort(v);
        byteBuf0.writeBytes(byteBuf1);
    }
}

