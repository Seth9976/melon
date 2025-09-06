package org.gagravarr.ogg;

import U4.x;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

public class OggPage {
    public class OggPacketIterator implements Iterator {
        private int currentLV;
        private int currentOffset;
        private OggPacketData prevPart;

        private OggPacketIterator(OggPacketData oggPacketData0) {
            this.currentLV = 0;
            this.currentOffset = 0;
            this.prevPart = oggPacketData0;
        }

        public OggPacketIterator(OggPacketData oggPacketData0, org.gagravarr.ogg.OggPage.1 oggPage$10) {
            this(oggPacketData0);
        }

        @Override
        public boolean hasNext() {
            return this.currentLV >= OggPage.this.numLVs ? this.currentLV == 0 && OggPage.this.numLVs == 0 : true;
        }

        @Override
        public Object next() {
            return this.next();
        }

        public OggPacketData next() {
            OggPacketData oggPacketData1;
            int v = this.currentLV;
            boolean z = false;
            int v1 = 0;
            int v2 = 0;
            boolean z1 = false;
            while(v < OggPage.this.numLVs) {
                int v3 = IOUtils.toInt(OggPage.this.lvs[v]);
                v1 += v3;
                ++v2;
                if(v3 < 0xFF) {
                    break;
                }
                if(v == OggPage.this.numLVs - 1 && v3 == 0xFF) {
                    z1 = true;
                }
                ++v;
            }
            byte[] arr_b = new byte[v1];
            for(int v4 = this.currentLV; v4 < this.currentLV + v2; ++v4) {
                int v5 = (v4 - this.currentLV) * 0xFF;
                System.arraycopy(OggPage.this.data, this.currentOffset + v5, arr_b, v5, IOUtils.toInt(OggPage.this.lvs[v4]));
            }
            OggPacketData oggPacketData0 = this.prevPart;
            if(oggPacketData0 != null) {
                byte[] arr_b1 = oggPacketData0.getData();
                byte[] arr_b2 = new byte[arr_b1.length + v1];
                System.arraycopy(this.prevPart.getData(), 0, arr_b2, 0, arr_b1.length);
                System.arraycopy(arr_b, 0, arr_b2, arr_b1.length, v1);
                this.prevPart = null;
                arr_b = arr_b2;
            }
            if(z1) {
                oggPacketData1 = new OggPacketData(arr_b);
            }
            else {
                boolean z2 = OggPage.this.isBOS && this.currentLV == 0;
                if(OggPage.this.isEOS && this.currentLV + v2 == OggPage.this.numLVs) {
                    z = true;
                }
                oggPacketData1 = new OggPacket(OggPage.this, arr_b, z2, z);
            }
            int v6 = this.currentLV + v2;
            this.currentLV = v6;
            this.currentOffset += v1;
            if(v6 == 0) {
                this.currentLV = 1;
            }
            return oggPacketData1;
        }

        @Override
        public void remove() {
            throw new IllegalStateException("Remove not supported");
        }
    }

    private long checksum;
    private byte[] data;
    private long granulePosition;
    private boolean isBOS;
    private boolean isContinue;
    private boolean isEOS;
    private byte[] lvs;
    private int numLVs;
    private int seqNum;
    private int sid;
    private ByteArrayOutputStream tmpData;

    public OggPage(int v, int v1) {
        this.numLVs = 0;
        this.lvs = new byte[0xFF];
        this.sid = v;
        this.seqNum = v1;
        this.tmpData = new ByteArrayOutputStream();
    }

    public OggPage(InputStream inputStream0) {
        this.numLVs = 0;
        this.lvs = new byte[0xFF];
        int v = inputStream0.read();
        if(v != 0) {
            throw new IllegalArgumentException("Found Ogg page in format " + v + " but we only support version 0");
        }
        int v1 = inputStream0.read();
        if((v1 & 1) == 1) {
            this.isContinue = true;
        }
        if((v1 & 2) == 2) {
            this.isBOS = true;
        }
        if((v1 & 4) == 4) {
            this.isEOS = true;
        }
        this.granulePosition = IOUtils.getInt(inputStream0.read(), inputStream0.read(), inputStream0.read(), inputStream0.read(), inputStream0.read(), inputStream0.read(), inputStream0.read(), inputStream0.read());
        this.sid = (int)IOUtils.getInt(inputStream0.read(), inputStream0.read(), inputStream0.read(), inputStream0.read());
        this.seqNum = (int)IOUtils.getInt(inputStream0.read(), inputStream0.read(), inputStream0.read(), inputStream0.read());
        this.checksum = IOUtils.getInt(inputStream0.read(), inputStream0.read(), inputStream0.read(), inputStream0.read());
        int v2 = inputStream0.read();
        this.numLVs = v2;
        byte[] arr_b = new byte[v2];
        this.lvs = arr_b;
        IOUtils.readFully(inputStream0, arr_b);
        byte[] arr_b1 = new byte[this.getDataSize()];
        this.data = arr_b1;
        IOUtils.readFully(inputStream0, arr_b1);
    }

    public int addPacket(OggPacket oggPacket0, int v) {
        if(oggPacket0.isBeginningOfStream()) {
            this.isBOS = true;
        }
        if(oggPacket0.isEndOfStream()) {
            this.isEOS = true;
        }
        byte[] arr_b = oggPacket0.getData();
        for(int v1 = this.numLVs; v1 < 0xFF; ++v1) {
            int v2 = arr_b.length - v < 0xFF ? arr_b.length - v : 0xFF;
            byte[] arr_b1 = this.lvs;
            arr_b1[v1] = IOUtils.fromInt(v2);
            this.tmpData.write(oggPacket0.getData(), v, v2);
            ++this.numLVs;
            v += v2;
            if(v2 < 0xFF) {
                return v;
            }
        }
        return v;
    }

    public long getChecksum() {
        return this.checksum;
    }

    public byte[] getData() {
        if(this.tmpData != null && (this.data == null || this.tmpData.size() != this.data.length)) {
            this.data = this.tmpData.toByteArray();
        }
        return this.data;
    }

    public int getDataSize() {
        int v1 = 0;
        for(int v = 0; v < this.numLVs; ++v) {
            v1 += IOUtils.toInt(this.lvs[v]);
        }
        return v1;
    }

    public long getGranulePosition() {
        return this.granulePosition;
    }

    public byte[] getHeader() {
        byte[] arr_b = new byte[this.numLVs + 27];
        arr_b[0] = 0x4F;
        arr_b[1] = 103;
        arr_b[2] = 103;
        arr_b[3] = 83;
        arr_b[4] = 0;
        byte b = this.isContinue ? 1 : 0;
        if(this.isBOS) {
            b = (byte)(b + 2);
        }
        if(this.isEOS) {
            b = (byte)(b + 4);
        }
        arr_b[5] = b;
        IOUtils.putInt8(arr_b, 6, this.granulePosition);
        IOUtils.putInt4(arr_b, 14, ((long)this.sid));
        IOUtils.putInt4(arr_b, 18, ((long)this.seqNum));
        arr_b[26] = IOUtils.fromInt(this.numLVs);
        System.arraycopy(this.lvs, 0, arr_b, 27, this.numLVs);
        return arr_b;
    }

    public int getNumLVs() {
        return this.numLVs;
    }

    public OggPacketIterator getPacketIterator() {
        return new OggPacketIterator(this, null, null);
    }

    public OggPacketIterator getPacketIterator(OggPacketData oggPacketData0) {
        return new OggPacketIterator(this, oggPacketData0, null);
    }

    public int getPageSize() {
        return this.getDataSize() + (this.numLVs + 27);
    }

    public int getSequenceNumber() {
        return this.seqNum;
    }

    public int getSid() {
        return this.sid;
    }

    public boolean hasContinuation() {
        return this.numLVs == 0 ? false : IOUtils.toInt(this.lvs[this.numLVs - 1]) == 0xFF;
    }

    public boolean hasSpaceFor(int v) {
        return this.numLVs + ((int)Math.ceil(((double)v) / 255.0)) <= 0xFF;
    }

    public boolean isChecksumValid() {
        if(Long.compare(this.checksum, 0L) == 0) {
            return true;
        }
        int v = CRCUtils.getCRC(this.getHeader());
        byte[] arr_b = this.data;
        if(arr_b != null && arr_b.length > 0) {
            v = CRCUtils.getCRC(arr_b, v);
        }
        return this.checksum == ((long)v);
    }

    public boolean isContinuation() {
        return this.isContinue;
    }

    public void setGranulePosition(long v) {
        this.granulePosition = v;
    }

    public void setIsContinuation() {
        this.isContinue = true;
    }

    public void setIsEOS() {
        this.isEOS = true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("Ogg Page - ");
        stringBuilder0.append(this.getSid());
        stringBuilder0.append(" @ ");
        stringBuilder0.append(this.getSequenceNumber());
        stringBuilder0.append(" - ");
        return x.g(this.numLVs, " LVs", stringBuilder0);
    }

    public void writeHeader(OutputStream outputStream0) {
        byte[] arr_b = this.getHeader();
        this.getData();
        int v = CRCUtils.getCRC(arr_b);
        byte[] arr_b1 = this.data;
        if(arr_b1 != null && arr_b1.length > 0) {
            v = CRCUtils.getCRC(arr_b1, v);
        }
        IOUtils.putInt4(arr_b, 22, ((long)v));
        this.checksum = (long)v;
        outputStream0.write(arr_b);
    }

    class org.gagravarr.ogg.OggPage.1 {
    }

}

