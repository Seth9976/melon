package io.netty.buffer;

import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteBufOutputStream extends OutputStream implements DataOutput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int startIndex;
    private DataOutputStream utf8out;

    public ByteBufOutputStream(ByteBuf byteBuf0) {
        this.buffer = (ByteBuf)ObjectUtil.checkNotNull(byteBuf0, "buffer");
        this.startIndex = byteBuf0.writerIndex();
    }

    public ByteBuf buffer() {
        return this.buffer;
    }

    @Override
    public void close() {
        DataOutputStream dataOutputStream0;
        if(!this.closed) {
            try {
                this.closed = true;
                super.close();
                dataOutputStream0 = this.utf8out;
            }
            catch(Throwable throwable0) {
                if(this.utf8out != null) {
                    this.utf8out.close();
                }
                throw throwable0;
            }
            if(dataOutputStream0 != null) {
                dataOutputStream0.close();
            }
        }
    }

    @Override
    public void write(int v) {
        this.buffer.writeByte(v);
    }

    @Override
    public void write(byte[] arr_b) {
        this.buffer.writeBytes(arr_b);
    }

    @Override
    public void write(byte[] arr_b, int v, int v1) {
        if(v1 == 0) {
            return;
        }
        this.buffer.writeBytes(arr_b, v, v1);
    }

    @Override
    public void writeBoolean(boolean z) {
        this.buffer.writeBoolean(z);
    }

    @Override
    public void writeByte(int v) {
        this.buffer.writeByte(v);
    }

    @Override
    public void writeBytes(String s) {
        this.buffer.writeCharSequence(s, CharsetUtil.US_ASCII);
    }

    @Override
    public void writeChar(int v) {
        this.buffer.writeChar(v);
    }

    @Override
    public void writeChars(String s) {
        int v = s.length();
        for(int v1 = 0; v1 < v; ++v1) {
            this.buffer.writeChar(s.charAt(v1));
        }
    }

    @Override
    public void writeDouble(double f) {
        this.buffer.writeDouble(f);
    }

    @Override
    public void writeFloat(float f) {
        this.buffer.writeFloat(f);
    }

    @Override
    public void writeInt(int v) {
        this.buffer.writeInt(v);
    }

    @Override
    public void writeLong(long v) {
        this.buffer.writeLong(v);
    }

    @Override
    public void writeShort(int v) {
        this.buffer.writeShort(((int)(((short)v))));
    }

    @Override
    public void writeUTF(String s) {
        DataOutputStream dataOutputStream0 = this.utf8out;
        if(dataOutputStream0 == null) {
            if(this.closed) {
                throw new IOException("The stream is closed");
            }
            dataOutputStream0 = new DataOutputStream(this);
            this.utf8out = dataOutputStream0;
        }
        dataOutputStream0.writeUTF(s);
    }

    public int writtenBytes() {
        return this.buffer.writerIndex() - this.startIndex;
    }
}

