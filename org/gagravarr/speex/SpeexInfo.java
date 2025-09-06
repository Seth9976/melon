package org.gagravarr.speex;

import U4.x;
import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioInfoHeader;

public class SpeexInfo extends HighLevelOggStreamPacket implements OggAudioInfoHeader, SpeexPacket {
    private int bitrate;
    private int channels;
    private int extraHeaders;
    private int frameSize;
    private int framesPerPacket;
    private int mode;
    private int modeBitstreamVersion;
    private long rate;
    private int reserved1;
    private int reserved2;
    private int vbr;
    private int versionId;
    private String versionString;

    public SpeexInfo() {
        this.versionString = "Gagravarr Ogg v0.6";
        this.versionId = 1;
    }

    public SpeexInfo(OggPacket oggPacket0) {
        super(oggPacket0);
        byte[] arr_b = this.getData();
        if(!IOUtils.byteRangeMatches(SpeexPacket.MAGIC_HEADER_BYTES, arr_b, 0)) {
            throw new IllegalArgumentException("Invalid type, not a Speex Header");
        }
        this.versionString = IOUtils.removeNullPadding(IOUtils.getUTF8(arr_b, 8, 20));
        this.versionId = (int)IOUtils.getInt4(arr_b, 28);
        int v = (int)IOUtils.getInt4(arr_b, 0x20);
        if(v == arr_b.length) {
            this.rate = IOUtils.getInt4(arr_b, 36);
            this.mode = (int)IOUtils.getInt4(arr_b, 40);
            this.modeBitstreamVersion = (int)IOUtils.getInt4(arr_b, 44);
            this.channels = (int)IOUtils.getInt4(arr_b, 0x30);
            this.bitrate = (int)IOUtils.getInt4(arr_b, 52);
            this.frameSize = (int)IOUtils.getInt4(arr_b, 56);
            this.vbr = (int)IOUtils.getInt4(arr_b, 60);
            this.framesPerPacket = (int)IOUtils.getInt4(arr_b, 0x40);
            this.extraHeaders = (int)IOUtils.getInt4(arr_b, 68);
            this.reserved1 = (int)IOUtils.getInt4(arr_b, 72);
            this.reserved2 = (int)IOUtils.getInt4(arr_b, 76);
            return;
        }
        StringBuilder stringBuilder0 = x.n(v, "Invalid Speex Header, expected ", " bytes, found ");
        stringBuilder0.append(arr_b.length);
        throw new IllegalArgumentException(stringBuilder0.toString());
    }

    public int getBitrate() {
        return this.bitrate;
    }

    public int getChannels() {
        return this.channels;
    }

    public int getExtraHeaders() {
        return this.extraHeaders;
    }

    public int getFrameSize() {
        return this.frameSize;
    }

    public int getFramesPerPacket() {
        return this.framesPerPacket;
    }

    public int getMode() {
        return this.mode;
    }

    public int getModeBitstreamVersion() {
        return this.modeBitstreamVersion;
    }

    public long getRate() {
        return this.rate;
    }

    public int getReserved1() {
        return this.reserved1;
    }

    public int getReserved2() {
        return this.reserved2;
    }

    public int getVbr() {
        return this.vbr;
    }

    public int getVersionId() {
        return this.versionId;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioInfoHeader
    public String getVersionString() {
        return this.versionString;
    }

    public void setBitrate(int v) {
        this.bitrate = v;
    }

    public void setChannels(int v) {
        this.channels = v;
    }

    public void setFrameSize(int v) {
        this.frameSize = v;
    }

    public void setFramesPerPacket(int v) {
        this.framesPerPacket = v;
    }

    public void setMode(int v) {
        this.mode = v;
    }

    public void setModeBitstreamVersion(int v) {
        this.modeBitstreamVersion = v;
    }

    public void setRate(long v) {
        this.rate = v;
    }

    public void setVbr(int v) {
        this.vbr = v;
    }

    public void setVersionId(int v) {
        this.versionId = v;
    }

    public void setVersionString(String s) {
        if(s.length() > 20) {
            s = s.substring(0, 20);
        }
        this.versionString = s;
    }

    @Override  // org.gagravarr.ogg.HighLevelOggStreamPacket, org.gagravarr.ogg.OggStreamPacket
    public OggPacket write() {
        byte[] arr_b = new byte[80];
        System.arraycopy(SpeexPacket.MAGIC_HEADER_BYTES, 0, arr_b, 0, 8);
        IOUtils.putUTF8(arr_b, 8, this.versionString);
        IOUtils.putInt4(arr_b, 28, ((long)this.versionId));
        IOUtils.putInt4(arr_b, 0x20, 80L);
        IOUtils.putInt4(arr_b, 36, this.rate);
        IOUtils.putInt4(arr_b, 40, ((long)this.mode));
        IOUtils.putInt4(arr_b, 44, ((long)this.modeBitstreamVersion));
        IOUtils.putInt4(arr_b, 0x30, ((long)this.channels));
        IOUtils.putInt4(arr_b, 52, ((long)this.bitrate));
        IOUtils.putInt4(arr_b, 56, ((long)this.frameSize));
        IOUtils.putInt4(arr_b, 60, ((long)this.vbr));
        IOUtils.putInt4(arr_b, 0x40, ((long)this.framesPerPacket));
        IOUtils.putInt4(arr_b, 68, ((long)this.extraHeaders));
        IOUtils.putInt4(arr_b, 72, ((long)this.reserved1));
        IOUtils.putInt4(arr_b, 76, ((long)this.reserved2));
        this.setData(arr_b);
        return super.write();
    }
}

