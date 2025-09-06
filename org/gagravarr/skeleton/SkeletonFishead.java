package org.gagravarr.skeleton;

import U4.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;

public class SkeletonFishead extends HighLevelOggStreamPacket implements SkeletonPacket {
    private long baseTimeDenominator;
    private long baseTimeNumerator;
    private long contentOffset;
    private long presentationTimeDenominator;
    private long presentationTimeNumerator;
    private long segmentLength;
    private String utc;
    private int versionMajor;
    private int versionMinor;

    public SkeletonFishead() {
        this.versionMajor = 4;
        this.versionMinor = 0;
    }

    public SkeletonFishead(OggPacket oggPacket0) {
        super(oggPacket0);
        byte[] arr_b = this.getData();
        if(!IOUtils.byteRangeMatches(SkeletonPacket.MAGIC_FISHEAD_BYTES, arr_b, 0)) {
            throw new IllegalArgumentException("Invalid type, not a Skeleton Fishead Header");
        }
        this.versionMajor = IOUtils.getInt2(arr_b, 8);
        this.versionMinor = IOUtils.getInt2(arr_b, 10);
        if(this.versionMajor >= 3 && this.versionMajor <= 4) {
            this.presentationTimeNumerator = IOUtils.getInt8(arr_b, 12);
            this.presentationTimeDenominator = IOUtils.getInt8(arr_b, 20);
            this.baseTimeNumerator = IOUtils.getInt8(arr_b, 28);
            this.baseTimeDenominator = IOUtils.getInt8(arr_b, 36);
            this.utc = arr_b[44] != 0 || arr_b[45] != 0 ? IOUtils.getUTF8(arr_b, 44, 20) : null;
            if(this.versionMajor == 4) {
                this.segmentLength = IOUtils.getInt8(arr_b, 0x40);
                this.contentOffset = IOUtils.getInt8(arr_b, 72);
            }
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Unsupported Skeleton version ");
        throw new IllegalArgumentException(x.g(this.versionMajor, " detected", stringBuilder0));
    }

    public long getBaseTimeDenominator() {
        return this.baseTimeDenominator;
    }

    public long getBaseTimeNumerator() {
        return this.baseTimeNumerator;
    }

    public long getContentOffset() {
        return this.contentOffset;
    }

    public long getPresentationTimeDenominator() {
        return this.presentationTimeDenominator;
    }

    public long getPresentationTimeNumerator() {
        return this.presentationTimeNumerator;
    }

    public long getSegmentLength() {
        return this.segmentLength;
    }

    public String getUtc() {
        return this.utc;
    }

    public String getVersion() {
        return this.versionMajor + "." + this.versionMinor;
    }

    public int getVersionMajor() {
        return this.versionMajor;
    }

    public int getVersionMinor() {
        return this.versionMinor;
    }

    public void setBaseTimeDenominator(long v) {
        this.baseTimeDenominator = v;
    }

    public void setBaseTimeNumerator(long v) {
        this.baseTimeNumerator = v;
    }

    public void setContentOffset(long v) {
        this.contentOffset = v;
    }

    public void setPresentationTimeDenominator(long v) {
        this.presentationTimeDenominator = v;
    }

    public void setPresentationTimeNumerator(long v) {
        this.presentationTimeNumerator = v;
    }

    public void setSegmentLength(long v) {
        this.segmentLength = v;
    }

    public void setUtc(String s) {
        if(s == null) {
            this.utc = null;
            return;
        }
        if(s.length() != 20) {
            throw new IllegalArgumentException("Must be of the form YYYYMMDDTHHMMSS.sssZ");
        }
    }

    public void setUtc(Date date0) {
        this.utc = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSSZ").format(date0);
    }

    public void setVersionMajor(int v) {
        this.versionMajor = v;
    }

    public void setVersionMinor(int v) {
        this.versionMinor = v;
    }

    @Override  // org.gagravarr.ogg.HighLevelOggStreamPacket, org.gagravarr.ogg.OggStreamPacket
    public OggPacket write() {
        byte[] arr_b = new byte[(this.versionMajor == 4 ? 80 : 0x40)];
        IOUtils.putUTF8(arr_b, 0, "fishead\u0000");
        IOUtils.putInt2(arr_b, 8, this.versionMajor);
        IOUtils.putInt2(arr_b, 10, this.versionMinor);
        IOUtils.putInt8(arr_b, 12, this.presentationTimeNumerator);
        IOUtils.putInt8(arr_b, 20, this.presentationTimeDenominator);
        IOUtils.putInt8(arr_b, 28, this.baseTimeNumerator);
        IOUtils.putInt8(arr_b, 36, this.baseTimeDenominator);
        String s = this.utc;
        if(s != null) {
            IOUtils.putUTF8(arr_b, 44, s);
        }
        if(this.versionMajor == 4) {
            IOUtils.putInt8(arr_b, 0x40, this.segmentLength);
            IOUtils.putInt8(arr_b, 72, this.contentOffset);
        }
        this.setData(arr_b);
        return super.write();
    }
}

