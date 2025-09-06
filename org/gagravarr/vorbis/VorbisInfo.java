package org.gagravarr.vorbis;

import U4.x;
import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioInfoHeader;

public class VorbisInfo extends HighLevelOggStreamPacket implements OggAudioInfoHeader, VorbisPacket {
    private int bitrateLower;
    private int bitrateNominal;
    private int bitrateUpper;
    private int blocksizes;
    private int channels;
    private long rate;
    private int version;

    public VorbisInfo() {
        this.version = 0;
    }

    public VorbisInfo(OggPacket oggPacket0) {
        super(oggPacket0);
        byte[] arr_b = this.getData();
        int v = (int)IOUtils.getInt4(arr_b, 7);
        this.version = v;
        if(v == 0) {
            this.channels = arr_b[11];
            this.rate = IOUtils.getInt4(arr_b, 12);
            this.bitrateUpper = (int)IOUtils.getInt4(arr_b, 16);
            this.bitrateNominal = (int)IOUtils.getInt4(arr_b, 20);
            this.bitrateLower = (int)IOUtils.getInt4(arr_b, 24);
            this.blocksizes = IOUtils.toInt(arr_b[28]);
            if(arr_b[29] == 0) {
                throw new IllegalArgumentException("Framing bit not set, invalid");
            }
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Unsupported vorbis version ");
        throw new IllegalArgumentException(x.g(this.version, " detected", stringBuilder0));
    }

    public int getBitrateLower() {
        return this.bitrateLower;
    }

    public int getBitrateNominal() {
        return this.bitrateNominal;
    }

    public int getBitrateUpper() {
        return this.bitrateUpper;
    }

    public int getBlocksize0() {
        return (int)Math.pow(2.0, this.blocksizes & 15);
    }

    public int getBlocksize1() {
        return (int)Math.pow(2.0, (this.blocksizes & 0xF0) >> 4);
    }

    public int getChannels() {
        return this.channels;
    }

    @Override  // org.gagravarr.vorbis.VorbisPacket
    public int getHeaderSize() {
        return 7;
    }

    public long getRate() {
        return this.rate;
    }

    public int getVersion() {
        return this.version;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioInfoHeader
    public String getVersionString() {
        return Integer.toString(this.version);
    }

    @Override  // org.gagravarr.vorbis.VorbisPacket
    public void populateMetadataHeader(byte[] arr_b, int v) {
        VorbisPacketFactory.populateMetadataHeader(arr_b, 1, v);
    }

    public void setBitrateLower(int v) {
        this.bitrateLower = v;
    }

    public void setBitrateNominal(int v) {
        this.bitrateNominal = v;
    }

    public void setBitrateUpper(int v) {
        this.bitrateUpper = v;
    }

    public void setBlocksize0(int v) {
        this.blocksizes = (this.blocksizes & 0xF0) + ((int)(Math.log(v) / 0.693147));
    }

    public void setBlocksize1(int v) {
        this.blocksizes = (this.blocksizes & 15) + (((int)(Math.log(v) / 0.693147)) << 4);
    }

    public void setChannels(int v) {
        this.channels = v;
    }

    public void setRate(long v) {
        this.rate = v;
    }

    @Override  // org.gagravarr.ogg.HighLevelOggStreamPacket, org.gagravarr.ogg.OggStreamPacket
    public OggPacket write() {
        byte[] arr_b = new byte[30];
        this.populateMetadataHeader(arr_b, 30);
        IOUtils.putInt4(arr_b, 7, ((long)this.version));
        arr_b[11] = IOUtils.fromInt(this.channels);
        IOUtils.putInt4(arr_b, 12, this.rate);
        IOUtils.putInt4(arr_b, 16, ((long)this.bitrateUpper));
        IOUtils.putInt4(arr_b, 20, ((long)this.bitrateNominal));
        IOUtils.putInt4(arr_b, 24, ((long)this.bitrateLower));
        arr_b[28] = IOUtils.fromInt(this.blocksizes);
        arr_b[29] = 1;
        this.setData(arr_b);
        return super.write();
    }
}

