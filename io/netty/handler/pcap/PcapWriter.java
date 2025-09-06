package io.netty.handler.pcap;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.io.OutputStream;

final class PcapWriter implements Closeable {
    private static final InternalLogger logger;
    private final OutputStream outputStream;
    private final PcapWriteHandler pcapWriteHandler;

    static {
        PcapWriter.logger = InternalLoggerFactory.getInstance(PcapWriter.class);
    }

    public PcapWriter(PcapWriteHandler pcapWriteHandler0) {
        this.pcapWriteHandler = pcapWriteHandler0;
        this.outputStream = pcapWriteHandler0.outputStream();
        if(!pcapWriteHandler0.sharedOutputStream()) {
            PcapHeaders.writeGlobalHeader(pcapWriteHandler0.outputStream());
        }
    }

    @Override
    public void close() {
        if(this.pcapWriteHandler.state() == State.CLOSED) {
            PcapWriter.logger.debug("PcapWriter is already closed");
            return;
        }
        if(this.pcapWriteHandler.sharedOutputStream()) {
            synchronized(this.outputStream) {
                this.outputStream.flush();
            }
        }
        else {
            this.outputStream.flush();
            this.outputStream.close();
        }
        this.pcapWriteHandler.markClosed();
        PcapWriter.logger.debug("PcapWriter is now closed");
    }

    @Override
    public String toString() {
        return "PcapWriter{outputStream=" + this.outputStream + '}';
    }

    public void writePacket(ByteBuf byteBuf0, ByteBuf byteBuf1) {
        if(this.pcapWriteHandler.state() == State.CLOSED) {
            PcapWriter.logger.debug("Pcap Write attempted on closed PcapWriter");
        }
        long v = System.currentTimeMillis();
        PcapHeaders.writePacketHeader(byteBuf0, ((int)(v / 1000L)), ((int)(v % 1000L * 1000L)), byteBuf1.readableBytes(), byteBuf1.readableBytes());
        if(this.pcapWriteHandler.sharedOutputStream()) {
            synchronized(this.outputStream) {
                int v2 = byteBuf0.readableBytes();
                byteBuf0.readBytes(this.outputStream, v2);
                int v3 = byteBuf1.readableBytes();
                byteBuf1.readBytes(this.outputStream, v3);
            }
            return;
        }
        int v4 = byteBuf0.readableBytes();
        byteBuf0.readBytes(this.outputStream, v4);
        int v5 = byteBuf1.readableBytes();
        byteBuf1.readBytes(this.outputStream, v5);
    }
}

