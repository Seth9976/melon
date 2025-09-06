package org.gagravarr.theora;

import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;

public class TheoraInfo extends HighLevelOggStreamPacket implements TheoraPacket {
    private int colourSpace;
    private int frameHeightMB;
    private long frameNumBlocks;
    private long frameNumMacroBlocks;
    private long frameNumSuperBlocks;
    private long frameRateDenominator;
    private long frameRateNumerator;
    private int frameWidthMB;
    private int keyFrameNumberGranuleShift;
    private int majorVersion;
    private int minorVersion;
    private long nominalBitrate;
    private long pictureRegionHeight;
    private long pictureRegionWidth;
    private int pictureRegionXOffset;
    private int pictureRegionYOffset;
    private long pixelAspectDenomerator;
    private long pixelAspectNumerator;
    private int pixelFormat;
    private int qualityHint;
    private int revisionVersion;

    public TheoraInfo() {
        this.majorVersion = 3;
        this.minorVersion = 2;
        this.revisionVersion = 1;
    }

    public TheoraInfo(OggPacket oggPacket0) {
        super(oggPacket0);
        byte[] arr_b = this.getData();
        int v = arr_b[7];
        this.majorVersion = v;
        this.minorVersion = arr_b[8];
        this.revisionVersion = arr_b[9];
        if(v != 3) {
            throw new IllegalArgumentException("Unsupported Theora version 3.2.1 detected");
        }
        this.frameWidthMB = IOUtils.getInt2BE(arr_b, 10);
        this.frameHeightMB = IOUtils.getInt2BE(arr_b, 12);
        this.pictureRegionWidth = IOUtils.getInt3BE(arr_b, 14);
        this.pictureRegionHeight = IOUtils.getInt3BE(arr_b, 17);
        this.pictureRegionXOffset = arr_b[20];
        this.pictureRegionYOffset = arr_b[21];
        this.frameRateNumerator = IOUtils.getInt4BE(arr_b, 22);
        this.frameRateDenominator = IOUtils.getInt4BE(arr_b, 26);
        this.pixelAspectNumerator = IOUtils.getInt3BE(arr_b, 30);
        this.pixelAspectDenomerator = IOUtils.getInt3BE(arr_b, 33);
        this.colourSpace = arr_b[36];
        this.nominalBitrate = IOUtils.getInt3BE(arr_b, 37);
        int v1 = IOUtils.getInt2BE(arr_b, 40);
        this.qualityHint = v1 >> 10;
        this.keyFrameNumberGranuleShift = v1 >> 5 & 0x1F;
        this.pixelFormat = v1 >> 3 & 3;
    }

    public int getColourSpace() {
        return this.colourSpace;
    }

    public int getFrameHeight() {
        return this.frameHeightMB << 4;
    }

    public int getFrameHeightMB() {
        return this.frameHeightMB;
    }

    public long getFrameNumBlocks() {
        return this.frameNumBlocks;
    }

    public long getFrameNumMacroBlocks() {
        return this.frameNumMacroBlocks;
    }

    public long getFrameNumSuperBlocks() {
        return this.frameNumSuperBlocks;
    }

    public long getFrameRateDenominator() {
        return this.frameRateDenominator;
    }

    public long getFrameRateNumerator() {
        return this.frameRateNumerator;
    }

    public int getFrameWidth() {
        return this.frameWidthMB << 4;
    }

    public int getFrameWidthMB() {
        return this.frameWidthMB;
    }

    public int getKeyFrameNumberGranuleShift() {
        return this.keyFrameNumberGranuleShift;
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public long getNominalBitrate() {
        return this.nominalBitrate;
    }

    public long getPictureRegionHeight() {
        return this.pictureRegionHeight;
    }

    public long getPictureRegionWidth() {
        return this.pictureRegionWidth;
    }

    public int getPictureRegionXOffset() {
        return this.pictureRegionXOffset;
    }

    public int getPictureRegionYOffset() {
        return this.pictureRegionYOffset;
    }

    public long getPixelAspectDenomerator() {
        return this.pixelAspectDenomerator;
    }

    public long getPixelAspectNumerator() {
        return this.pixelAspectNumerator;
    }

    public int getPixelFormat() {
        return this.pixelFormat;
    }

    public int getQualityHint() {
        return this.qualityHint;
    }

    public int getRevisionVersion() {
        return this.revisionVersion;
    }

    public String getVersion() [...] // 潜在的解密器

    public void setColourSpace(int v) {
        this.colourSpace = v;
    }

    public void setFrameHeightMB(int v) {
        this.frameHeightMB = v;
    }

    public void setFrameNumBlocks(long v) {
        this.frameNumBlocks = v;
    }

    public void setFrameNumMacroBlocks(long v) {
        this.frameNumMacroBlocks = v;
    }

    public void setFrameNumSuperBlocks(long v) {
        this.frameNumSuperBlocks = v;
    }

    public void setFrameRateDenominator(long v) {
        this.frameRateDenominator = v;
    }

    public void setFrameRateNumerator(long v) {
        this.frameRateNumerator = v;
    }

    public void setFrameWidthMB(int v) {
        this.frameWidthMB = v;
    }

    public void setKeyFrameNumberGranuleShift(int v) {
        this.keyFrameNumberGranuleShift = v;
    }

    public void setNominalBitrate(long v) {
        this.nominalBitrate = v;
    }

    public void setPictureRegionHeight(long v) {
        this.pictureRegionHeight = v;
    }

    public void setPictureRegionWidth(long v) {
        this.pictureRegionWidth = v;
    }

    public void setPictureRegionXOffset(int v) {
        this.pictureRegionXOffset = v;
    }

    public void setPictureRegionYOffset(int v) {
        this.pictureRegionYOffset = v;
    }

    public void setPixelAspectDenomerator(long v) {
        this.pixelAspectDenomerator = v;
    }

    public void setPixelAspectNumerator(long v) {
        this.pixelAspectNumerator = v;
    }

    public void setPixelFormat(int v) {
        this.pixelFormat = v;
    }

    public void setQualityHint(int v) {
        this.qualityHint = v;
    }

    @Override  // org.gagravarr.ogg.HighLevelOggStreamPacket, org.gagravarr.ogg.OggStreamPacket
    public OggPacket write() {
        byte[] arr_b = new byte[42];
        TheoraPacketFactory.populateMetadataHeader(arr_b, 0x80, 42);
        arr_b[7] = IOUtils.fromInt(this.majorVersion);
        arr_b[8] = IOUtils.fromInt(this.minorVersion);
        arr_b[9] = IOUtils.fromInt(this.revisionVersion);
        IOUtils.putInt2BE(arr_b, 10, this.frameWidthMB);
        IOUtils.putInt2BE(arr_b, 12, this.frameHeightMB);
        IOUtils.putInt3BE(arr_b, 14, this.pictureRegionWidth);
        IOUtils.putInt3BE(arr_b, 17, this.pictureRegionHeight);
        arr_b[20] = IOUtils.fromInt(this.pictureRegionXOffset);
        arr_b[21] = IOUtils.fromInt(this.pictureRegionYOffset);
        IOUtils.putInt4BE(arr_b, 22, this.frameRateNumerator);
        IOUtils.putInt4BE(arr_b, 26, this.frameRateDenominator);
        IOUtils.putInt3BE(arr_b, 30, this.pixelAspectNumerator);
        IOUtils.putInt3BE(arr_b, 33, this.pixelAspectDenomerator);
        arr_b[36] = IOUtils.fromInt(this.colourSpace);
        IOUtils.putInt3BE(arr_b, 37, this.nominalBitrate);
        IOUtils.putInt2BE(arr_b, 40, ((this.qualityHint << 6) + this.keyFrameNumberGranuleShift << 2) + this.pixelFormat << 3);
        this.setData(arr_b);
        return super.write();
    }
}

