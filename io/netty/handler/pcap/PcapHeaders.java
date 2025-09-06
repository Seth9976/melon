package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import java.io.OutputStream;

final class PcapHeaders {
    private static final byte[] GLOBAL_HEADER;

    static {
        PcapHeaders.GLOBAL_HEADER = new byte[]{(byte)0xA1, -78, -61, -44, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, 0, 0, 0, 1};
    }

    public static void writeGlobalHeader(OutputStream outputStream0) {
        outputStream0.write(PcapHeaders.GLOBAL_HEADER);
    }

    public static void writePacketHeader(ByteBuf byteBuf0, int v, int v1, int v2, int v3) {
        byteBuf0.writeInt(v);
        byteBuf0.writeInt(v1);
        byteBuf0.writeInt(v2);
        byteBuf0.writeInt(v3);
    }
}

