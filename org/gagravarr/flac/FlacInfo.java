package org.gagravarr.flac;

import java.io.OutputStream;
import org.gagravarr.ogg.IOUtils;

public class FlacInfo extends FlacMetadataBlock {
    private int bitsPerSample;
    private int maximumBlockSize;
    private int maximumFrameSize;
    private int minimumBlockSize;
    private int minimumFrameSize;
    private int numChannels;
    private long numberOfSamples;
    private int sampleRate;
    private byte[] signature;

    public FlacInfo() {
        super(0);
        this.signature = new byte[16];
    }

    public FlacInfo(byte[] arr_b, int v) {
        super(0);
        this.minimumBlockSize = IOUtils.getIntBE(IOUtils.toInt(arr_b[v]), IOUtils.toInt(arr_b[v + 1]));
        this.maximumBlockSize = IOUtils.getIntBE(IOUtils.toInt(arr_b[v + 2]), IOUtils.toInt(arr_b[v + 3]));
        this.minimumFrameSize = (int)IOUtils.getIntBE(IOUtils.toInt(arr_b[v + 4]), IOUtils.toInt(arr_b[v + 5]), IOUtils.toInt(arr_b[v + 6]));
        this.maximumFrameSize = (int)IOUtils.getIntBE(IOUtils.toInt(arr_b[v + 7]), IOUtils.toInt(arr_b[v + 8]), IOUtils.toInt(arr_b[v + 9]));
        int[] arr_v = new int[8];
        for(int v1 = 0; v1 < 8; ++v1) {
            arr_v[v1] = IOUtils.toInt(arr_b[v1 + (v + 10)]);
        }
        this.sampleRate = (arr_v[0] << 12) + (arr_v[1] << 4) + ((arr_v[2] & 0xF0) >> 4);
        this.numChannels = ((arr_v[2] & 14) >> 1) + 1;
        this.bitsPerSample = ((arr_v[2] & 1) << 4) + ((arr_v[3] & 0xF0) >> 4) + 1;
        this.numberOfSamples = (long)(((arr_v[3] & 15) << 30) + (arr_v[4] << 24) + (arr_v[5] << 16) + (arr_v[6] << 8) + arr_v[7]);
        byte[] arr_b1 = new byte[16];
        this.signature = arr_b1;
        System.arraycopy(arr_b, v + 18, arr_b1, 0, 16);
    }

    public int getBitsPerSample() {
        return this.bitsPerSample;
    }

    public int getMaximumBlockSize() {
        return this.maximumBlockSize;
    }

    public int getMaximumFrameSize() {
        return this.maximumFrameSize;
    }

    public int getMinimumBlockSize() {
        return this.minimumBlockSize;
    }

    public int getMinimumFrameSize() {
        return this.minimumFrameSize;
    }

    public int getNumChannels() {
        return this.numChannels;
    }

    public long getNumberOfSamples() {
        return this.numberOfSamples;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public void setBitsPerSample(int v) {
        this.bitsPerSample = v;
    }

    public void setMaximumBlockSize(int v) {
        this.maximumBlockSize = v;
    }

    public void setMaximumFrameSize(int v) {
        this.maximumFrameSize = v;
    }

    public void setMinimumBlockSize(int v) {
        this.minimumBlockSize = v;
    }

    public void setMinimumFrameSize(int v) {
        this.minimumFrameSize = v;
    }

    public void setNumChannels(int v) {
        this.numChannels = v;
    }

    public void setNumberOfSamples(long v) {
        this.numberOfSamples = v;
    }

    public void setSampleRate(int v) {
        this.sampleRate = v;
    }

    public void setSignature(byte[] arr_b) {
        this.signature = arr_b;
    }

    @Override  // org.gagravarr.flac.FlacMetadataBlock
    public void write(OutputStream outputStream0) {
        IOUtils.writeInt2BE(outputStream0, this.minimumBlockSize);
        IOUtils.writeInt2BE(outputStream0, this.maximumBlockSize);
        IOUtils.writeInt3BE(outputStream0, ((long)this.minimumFrameSize));
        IOUtils.writeInt3BE(outputStream0, ((long)this.maximumFrameSize));
        outputStream0.write(new byte[8]);
        outputStream0.write(this.signature);
    }
}

