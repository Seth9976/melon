package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;

final class TCPPacket {
    static enum TCPFlag {
        FIN(1),
        SYN(2),
        RST(4),
        PSH(8),
        ACK(16),
        URG(0x20),
        ECE(0x40),
        CWR(0x80);

        private final int value;

        private TCPFlag(int v1) {
            this.value = v1;
        }

        public static int getFlag(TCPFlag[] arr_tCPPacket$TCPFlag) {
            int v1 = 0;
            for(int v = 0; v < arr_tCPPacket$TCPFlag.length; ++v) {
                v1 |= arr_tCPPacket$TCPFlag[v].value;
            }
            return v1;
        }
    }

    private static final short OFFSET = 0x5000;

    public static void writePacket(ByteBuf byteBuf0, ByteBuf byteBuf1, int v, int v1, int v2, int v3, TCPFlag[] arr_tCPPacket$TCPFlag) {
        byteBuf0.writeShort(v2);
        byteBuf0.writeShort(v3);
        byteBuf0.writeInt(v);
        byteBuf0.writeInt(v1);
        byteBuf0.writeShort(TCPFlag.getFlag(arr_tCPPacket$TCPFlag) | 0x5000);
        byteBuf0.writeShort(0xFFFF);
        byteBuf0.writeShort(1);
        byteBuf0.writeShort(0);
        if(byteBuf1 != null) {
            byteBuf0.writeBytes(byteBuf1);
        }
    }
}

