package org.gagravarr.opus;

import U4.x;
import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioInfoHeader;

public class OpusInfo extends HighLevelOggStreamPacket implements OggAudioInfoHeader, OpusPacket {
    private byte[] channelMapping;
    private byte channelMappingFamily;
    private int channels;
    private int majorVersion;
    private int minorVersion;
    private int outputGain;
    private int preSkip;
    private long rate;
    private byte streamCount;
    private byte twoChannelStreamCount;
    private byte version;

    public OpusInfo() {
        this.version = 1;
    }

    public OpusInfo(OggPacket oggPacket0) {
        super(oggPacket0);
        byte[] arr_b = this.getData();
        if(!IOUtils.byteRangeMatches(OpusPacket.MAGIC_HEADER_BYTES, arr_b, 0)) {
            throw new IllegalArgumentException("Invalid type, not a Opus Header");
        }
        this.version = arr_b[8];
        this.parseVersion();
        if(this.majorVersion == 0) {
            this.channels = arr_b[9];
            this.preSkip = IOUtils.getInt2(arr_b, 10);
            this.rate = IOUtils.getInt4(arr_b, 12);
            this.outputGain = IOUtils.getInt2(arr_b, 16);
            this.channelMappingFamily = arr_b[18];
            if(arr_b[18] != 0) {
                this.streamCount = arr_b[19];
                this.twoChannelStreamCount = arr_b[20];
                int v = this.channels;
                byte[] arr_b1 = new byte[v];
                this.channelMapping = arr_b1;
                System.arraycopy(arr_b, 21, arr_b1, 0, v);
            }
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Unsupported Opus version ");
        stringBuilder0.append(((int)this.version));
        stringBuilder0.append(" at major version ");
        throw new IllegalArgumentException(x.g(this.majorVersion, " detected", stringBuilder0));
    }

    public byte[] getChannelMapping() {
        return this.channelMapping;
    }

    public byte getChannelMappingFamily() {
        return this.channelMappingFamily;
    }

    public int getChannels() {
        return this.channels;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public int getOutputGain() {
        return this.outputGain;
    }

    public int getPreSkip() {
        return this.preSkip;
    }

    public long getRate() {
        return this.rate;
    }

    public byte getStreamCount() {
        return this.streamCount;
    }

    public byte getTwoChannelStreamCount() {
        return this.twoChannelStreamCount;
    }

    public byte getVersion() {
        return this.version;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioInfoHeader
    public String getVersionString() {
        return this.majorVersion + "." + this.minorVersion;
    }

    private void parseVersion() {
        this.minorVersion = this.version & 15;
        this.majorVersion = this.version >> 4;
    }

    public void setChannels(int v) {
        this.channels = v;
    }

    public void setOutputGain(int v) {
        this.outputGain = v;
    }

    public void setPreSkip(int v) {
        this.preSkip = v;
    }

    public void setRate(long v) {
        this.rate = v;
    }

    @Override  // org.gagravarr.ogg.HighLevelOggStreamPacket, org.gagravarr.ogg.OggStreamPacket
    public OggPacket write() {
        byte[] arr_b = new byte[(this.channelMappingFamily == 0 ? 19 : this.channels + 21)];
        System.arraycopy(OpusPacket.MAGIC_HEADER_BYTES, 0, arr_b, 0, 8);
        arr_b[8] = this.version;
        arr_b[9] = (byte)this.channels;
        IOUtils.putInt2(arr_b, 10, this.preSkip);
        IOUtils.putInt4(arr_b, 12, this.rate);
        IOUtils.putInt2(arr_b, 16, this.outputGain);
        byte b = this.channelMappingFamily;
        arr_b[18] = b;
        if(b != 0) {
            arr_b[19] = this.streamCount;
            arr_b[20] = this.twoChannelStreamCount;
            System.arraycopy(this.channelMapping, 0, arr_b, 21, this.channels);
        }
        this.setData(arr_b);
        return super.write();
    }
}

