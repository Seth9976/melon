package org.gagravarr.ogg;

import com.iloen.melon.utils.a;
import java.io.Closeable;
import java.util.ArrayList;

public class OggPacketWriter implements Closeable {
    private ArrayList buffer;
    private boolean closed;
    private long currentGranulePosition;
    private boolean doneFirstPacket;
    private OggFile file;
    private int sequenceNumber;
    private int sid;

    public OggPacketWriter(OggFile oggFile0, int v) {
        this.closed = false;
        this.doneFirstPacket = false;
        this.currentGranulePosition = 0L;
        this.buffer = new ArrayList();
        this.file = oggFile0;
        this.sid = v;
        this.sequenceNumber = 0;
    }

    public void bufferPacket(OggPacket oggPacket0) {
        if(this.closed) {
            throw new IllegalStateException("Can\'t buffer packets on a closed stream!");
        }
        if(!this.doneFirstPacket) {
            oggPacket0.setIsBOS();
            this.doneFirstPacket = true;
        }
        byte[] arr_b = oggPacket0.getData();
        boolean z = arr_b.length == 0;
        OggPage oggPage0 = this.getCurrentPage(false);
        int v = 0;
        while(v < arr_b.length || z) {
            v = oggPage0.addPacket(oggPacket0, v);
            if(v < arr_b.length) {
                OggPage oggPage1 = this.getCurrentPage(true);
                oggPage1.setIsContinuation();
                oggPage0 = oggPage1;
            }
            z = false;
        }
        oggPacket0.setParent(oggPage0);
    }

    public void bufferPacket(OggPacket oggPacket0, boolean z) {
        this.bufferPacket(oggPacket0);
        if(z) {
            this.flush();
        }
    }

    @Override
    public void close() {
        if(this.buffer.size() > 0) {
            ((OggPage)a.i(1, this.buffer)).setIsEOS();
        }
        else {
            OggPacket oggPacket0 = new OggPacket(new byte[0]);
            oggPacket0.setIsEOS();
            this.bufferPacket(oggPacket0);
        }
        this.flush();
        this.closed = true;
    }

    public void flush() {
        if(this.closed) {
            throw new IllegalStateException("Can\'t flush packets on a closed stream!");
        }
        OggPage[] arr_oggPage = (OggPage[])this.buffer.toArray(new OggPage[this.buffer.size()]);
        this.file.writePages(arr_oggPage);
        this.buffer.clear();
    }

    public long getCurrentGranulePosition() {
        return this.currentGranulePosition;
    }

    private OggPage getCurrentPage(boolean z) {
        if(this.buffer.size() != 0 && !z) {
            return (OggPage)a.i(1, this.buffer);
        }
        int v = this.sequenceNumber;
        this.sequenceNumber = v + 1;
        OggPage oggPage0 = new OggPage(this.sid, v);
        long v1 = this.currentGranulePosition;
        if(v1 > 0L) {
            oggPage0.setGranulePosition(v1);
        }
        this.buffer.add(oggPage0);
        return oggPage0;
    }

    public int getSid() {
        return this.sid;
    }

    public int getSizePendingFlush() {
        int v = 0;
        for(Object object0: this.buffer) {
            v += ((OggPage)object0).getDataSize();
        }
        return v;
    }

    public void setGranulePosition(long v) {
        this.currentGranulePosition = v;
        for(Object object0: this.buffer) {
            ((OggPage)object0).setGranulePosition(v);
        }
    }
}

