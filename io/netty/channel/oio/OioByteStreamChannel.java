package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.util.internal.ObjectUtil;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.WritableByteChannel;
import jeb.synthetic.TWR;

@Deprecated
public abstract class OioByteStreamChannel extends AbstractOioByteChannel {
    private static final InputStream CLOSED_IN;
    private static final OutputStream CLOSED_OUT;
    private InputStream is;
    private OutputStream os;
    private WritableByteChannel outChannel;

    static {
        OioByteStreamChannel.CLOSED_IN = new InputStream() {
            @Override
            public int read() {
                return -1;
            }
        };
        OioByteStreamChannel.CLOSED_OUT = new OutputStream() {
            @Override
            public void write(int v) {
                throw new ClosedChannelException();
            }
        };
    }

    public OioByteStreamChannel(Channel channel0) {
        super(channel0);
    }

    public final void activate(InputStream inputStream0, OutputStream outputStream0) {
        if(this.is != null) {
            throw new IllegalStateException("input was set already");
        }
        if(this.os != null) {
            throw new IllegalStateException("output was set already");
        }
        this.is = (InputStream)ObjectUtil.checkNotNull(inputStream0, "is");
        this.os = (OutputStream)ObjectUtil.checkNotNull(outputStream0, "os");
        if(this.readWhenInactive) {
            this.eventLoop().execute(this.readTask);
            this.readWhenInactive = false;
        }
    }

    @Override  // io.netty.channel.oio.AbstractOioByteChannel
    public int available() {
        try {
            return this.is.available();
        }
        catch(IOException unused_ex) {
            return 0;
        }
    }

    private static void checkEOF(FileRegion fileRegion0) {
        if(fileRegion0.transferred() < fileRegion0.count()) {
            throw new EOFException("Expected to be able to write " + fileRegion0.count() + " bytes, but only wrote " + fileRegion0.transferred());
        }
    }

    @Override  // io.netty.channel.AbstractChannel
    public void doClose() {
        InputStream inputStream0 = this.is;
        OutputStream outputStream0 = this.os;
        this.is = OioByteStreamChannel.CLOSED_IN;
        this.os = OioByteStreamChannel.CLOSED_OUT;
        if(inputStream0 != null) {
            try {
                inputStream0.close();
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(outputStream0, throwable0);
                throw throwable0;
            }
        }
        if(outputStream0 != null) {
            outputStream0.close();
        }
    }

    @Override  // io.netty.channel.oio.AbstractOioByteChannel
    public int doReadBytes(ByteBuf byteBuf0) {
        Handle recvByteBufAllocator$Handle0 = this.unsafe().recvBufAllocHandle();
        recvByteBufAllocator$Handle0.attemptedBytesRead(Math.max(1, Math.min(this.available(), byteBuf0.maxWritableBytes())));
        return byteBuf0.writeBytes(this.is, recvByteBufAllocator$Handle0.attemptedBytesRead());
    }

    @Override  // io.netty.channel.oio.AbstractOioByteChannel
    public void doWriteBytes(ByteBuf byteBuf0) {
        OutputStream outputStream0 = this.os;
        if(outputStream0 == null) {
            throw new NotYetConnectedException();
        }
        byteBuf0.readBytes(outputStream0, byteBuf0.readableBytes());
    }

    @Override  // io.netty.channel.oio.AbstractOioByteChannel
    public void doWriteFileRegion(FileRegion fileRegion0) {
        OutputStream outputStream0 = this.os;
        if(outputStream0 == null) {
            throw new NotYetConnectedException();
        }
        if(this.outChannel == null) {
            this.outChannel = Channels.newChannel(outputStream0);
        }
        long v = 0L;
        do {
            long v1 = fileRegion0.transferTo(this.outChannel, v);
            if(v1 == -1L) {
                OioByteStreamChannel.checkEOF(fileRegion0);
                return;
            }
            v += v1;
        }
        while(v < fileRegion0.count());
    }

    @Override  // io.netty.channel.Channel
    public boolean isActive() {
        return this.is != null && this.is != OioByteStreamChannel.CLOSED_IN && (this.os != null && this.os != OioByteStreamChannel.CLOSED_OUT);
    }
}

