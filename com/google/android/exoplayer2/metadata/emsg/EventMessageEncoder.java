package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class EventMessageEncoder {
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final DataOutputStream dataOutputStream;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(0x200);
        this.byteArrayOutputStream = byteArrayOutputStream0;
        this.dataOutputStream = new DataOutputStream(byteArrayOutputStream0);
    }

    public byte[] encode(EventMessage eventMessage0) {
        this.byteArrayOutputStream.reset();
        try {
            EventMessageEncoder.writeNullTerminatedString(this.dataOutputStream, eventMessage0.schemeIdUri);
            EventMessageEncoder.writeNullTerminatedString(this.dataOutputStream, (eventMessage0.value == null ? "" : eventMessage0.value));
            EventMessageEncoder.writeUnsignedInt(this.dataOutputStream, eventMessage0.durationMs);
            EventMessageEncoder.writeUnsignedInt(this.dataOutputStream, eventMessage0.id);
            this.dataOutputStream.write(eventMessage0.messageData);
            this.dataOutputStream.flush();
            return this.byteArrayOutputStream.toByteArray();
        }
        catch(IOException iOException0) {
            throw new RuntimeException(iOException0);
        }
    }

    private static void writeNullTerminatedString(DataOutputStream dataOutputStream0, String s) {
        dataOutputStream0.writeBytes(s);
        dataOutputStream0.writeByte(0);
    }

    private static void writeUnsignedInt(DataOutputStream dataOutputStream0, long v) {
        dataOutputStream0.writeByte(((int)(v >>> 24)) & 0xFF);
        dataOutputStream0.writeByte(((int)(v >>> 16)) & 0xFF);
        dataOutputStream0.writeByte(((int)(v >>> 8)) & 0xFF);
        dataOutputStream0.writeByte(((int)v) & 0xFF);
    }
}

