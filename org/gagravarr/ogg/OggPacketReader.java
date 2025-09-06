package org.gagravarr.ogg;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class OggPacketReader {
    private InputStream inp;
    private Iterator it;
    private OggPacket nextPacket;

    public OggPacketReader(InputStream inputStream0) {
        this.inp = inputStream0;
    }

    public OggPacket getNextPacket() {
        OggPacketData oggPacketData0;
        OggPacket oggPacket0 = this.nextPacket;
        if(oggPacket0 != null) {
            this.nextPacket = null;
            return oggPacket0;
        }
        if(this.it == null || !this.it.hasNext()) {
            oggPacketData0 = null;
        }
        else {
            Object object0 = this.it.next();
            oggPacketData0 = (OggPacketData)object0;
            if(oggPacketData0 instanceof OggPacket) {
                return (OggPacket)oggPacketData0;
            }
        }
        int v = 0;
        boolean z = false;
        int v1 = -1;
        while(v < 0x10000 && !z) {
            int v2 = this.inp.read();
            if(v2 == -1) {
                return null;
            }
            switch(v1) {
                case -1: {
                    if(v2 == 0x4F) {
                        v1 = 0;
                    }
                    break;
                }
                case 0: {
                    v1 = v2 == 103 ? 1 : -1;
                    break;
                }
                case 1: {
                    v1 = v2 == 103 ? 2 : -1;
                    break;
                }
                case 2: {
                    if(v2 == 83) {
                        z = true;
                    }
                    else {
                        v1 = -1;
                    }
                }
            }
            if(!z) {
                ++v;
            }
        }
        if(!z) {
            throw new IOException("Next ogg packet header not found after searching " + v + " bytes");
        }
        if(v - 3 > 0) {
            System.err.println("Warning - had to skip " + (v - 3) + " bytes of junk data before finding the next packet header");
        }
        OggPage oggPage0 = new OggPage(this.inp);
        if(!oggPage0.isChecksumValid()) {
            System.err.println("Warning - invalid checksum on page " + oggPage0.getSequenceNumber() + " of stream " + Integer.toHexString(oggPage0.getSid()) + " (" + oggPage0.getSid() + ")");
        }
        this.it = oggPage0.getPacketIterator(oggPacketData0);
        return this.getNextPacket();
    }

    public OggPacket getNextPacketWithSid(int v) {
        OggPacket oggPacket0;
        while((oggPacket0 = this.getNextPacket()) != null) {
            if(oggPacket0.getSid() == v) {
                return oggPacket0;
            }
        }
        return null;
    }

    public void skipToGranulePosition(int v, long v1) {
        OggPacket oggPacket0;
        while((oggPacket0 = this.getNextPacket()) != null) {
            if(oggPacket0.getSid() == v && oggPacket0.getGranulePosition() >= v1) {
                this.nextPacket = oggPacket0;
                return;
            }
        }
    }

    public void skipToSequenceNumber(int v, int v1) {
        OggPacket oggPacket0;
        while((oggPacket0 = this.getNextPacket()) != null) {
            if(oggPacket0.getSid() == v && oggPacket0.getSequenceNumber() >= v1) {
                this.nextPacket = oggPacket0;
                return;
            }
        }
    }

    public void unreadPacket(OggPacket oggPacket0) {
        if(this.nextPacket != null) {
            throw new IllegalStateException("Can\'t un-read twice");
        }
        this.nextPacket = oggPacket0;
    }
}

