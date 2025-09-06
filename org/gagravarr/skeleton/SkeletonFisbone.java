package org.gagravarr.skeleton;

import U4.x;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;

public class SkeletonFisbone extends HighLevelOggStreamPacket implements SkeletonPacket {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final int MESSAGE_HEADER_OFFSET;
    private long baseGranule;
    private String contentType;
    private byte granuleShift;
    private long granulerateDenominator;
    private long granulerateNumerator;
    private int messageHeaderOffset;
    private Map messageHeaders;
    private int numHeaderPackets;
    private int preroll;
    private int serialNumber;

    static {
        SkeletonFisbone.MESSAGE_HEADER_OFFSET = 52 - SkeletonPacket.MAGIC_FISBONE_BYTES.length;
    }

    public SkeletonFisbone() {
        this.messageHeaders = new HashMap();
        this.messageHeaderOffset = SkeletonFisbone.MESSAGE_HEADER_OFFSET;
        this.contentType = "application/octet-stream";
    }

    public SkeletonFisbone(OggPacket oggPacket0) {
        super(oggPacket0);
        this.messageHeaders = new HashMap();
        byte[] arr_b = this.getData();
        if(!IOUtils.byteRangeMatches(SkeletonPacket.MAGIC_FISBONE_BYTES, arr_b, 0)) {
            throw new IllegalArgumentException("Invalid type, not a Skeleton Fisbone Header");
        }
        int v = (int)IOUtils.getInt4(arr_b, 8);
        this.messageHeaderOffset = v;
        if(v == SkeletonFisbone.MESSAGE_HEADER_OFFSET) {
            this.serialNumber = (int)IOUtils.getInt4(arr_b, 12);
            this.numHeaderPackets = (int)IOUtils.getInt4(arr_b, 16);
            this.granulerateNumerator = IOUtils.getInt8(arr_b, 20);
            this.granulerateDenominator = IOUtils.getInt8(arr_b, 28);
            this.baseGranule = IOUtils.getInt8(arr_b, 36);
            this.preroll = (int)IOUtils.getInt4(arr_b, 44);
            this.granuleShift = arr_b[0x30];
            String s = IOUtils.getUTF8(arr_b, 52, arr_b.length - 52);
            if(!s.contains("Content-Type")) {
                throw new IllegalArgumentException("No Content Type header found in " + s);
            }
            StringTokenizer stringTokenizer0 = new StringTokenizer(s, "\r\n");
            while(stringTokenizer0.hasMoreElements()) {
                String s1 = stringTokenizer0.nextToken();
                int v1 = s1.indexOf(": ");
                String s2 = s1.substring(0, v1);
                String s3 = s1.substring(v1 + 2);
                this.messageHeaders.put(s2, s3);
                if("Content-Type".equals(s2)) {
                    this.contentType = s3;
                }
            }
            return;
        }
        StringBuilder stringBuilder0 = new StringBuilder("Unsupported Skeleton message offset ");
        throw new IllegalArgumentException(x.g(this.messageHeaderOffset, " detected", stringBuilder0));
    }

    public long getBaseGranule() {
        return this.baseGranule;
    }

    public String getContentType() {
        return this.contentType;
    }

    public byte getGranuleShift() {
        return this.granuleShift;
    }

    public long getGranulerateDenominator() {
        return this.granulerateDenominator;
    }

    public long getGranulerateNumerator() {
        return this.granulerateNumerator;
    }

    public Map getMessageHeaders() {
        return this.messageHeaders;
    }

    public int getNumHeaderPackets() {
        return this.numHeaderPackets;
    }

    public int getPreroll() {
        return this.preroll;
    }

    public int getSerialNumber() {
        return this.serialNumber;
    }

    public void setBaseGranule(long v) {
        this.baseGranule = v;
    }

    public void setContentType(String s) {
        this.contentType = s;
        this.messageHeaders.put("Content-Type", s);
    }

    public void setGranuleShift(byte b) {
        this.granuleShift = b;
    }

    public void setGranulerateDenominator(long v) {
        this.granulerateDenominator = v;
    }

    public void setGranulerateNumerator(long v) {
        this.granulerateNumerator = v;
    }

    public void setNumHeaderPackets(int v) {
        this.numHeaderPackets = v;
    }

    public void setPreroll(int v) {
        this.preroll = v;
    }

    public void setSerialNumber(int v) {
        this.serialNumber = v;
    }

    @Override  // org.gagravarr.ogg.HighLevelOggStreamPacket, org.gagravarr.ogg.OggStreamPacket
    public OggPacket write() {
        StringBuffer stringBuffer0 = new StringBuffer();
        for(Object object0: this.messageHeaders.keySet()) {
            stringBuffer0.append(((String)object0));
            stringBuffer0.append(": ");
            stringBuffer0.append(((String)this.messageHeaders.get(((String)object0))));
            stringBuffer0.append("\r\n");
        }
        byte[] arr_b = IOUtils.toUTF8Bytes(stringBuffer0.toString());
        byte[] arr_b1 = new byte[arr_b.length + 52];
        System.arraycopy(SkeletonPacket.MAGIC_FISBONE_BYTES, 0, arr_b1, 0, 8);
        IOUtils.putInt4(arr_b1, 8, ((long)this.messageHeaderOffset));
        IOUtils.putInt4(arr_b1, 12, ((long)this.serialNumber));
        IOUtils.putInt4(arr_b1, 16, ((long)this.numHeaderPackets));
        IOUtils.putInt8(arr_b1, 20, this.granulerateNumerator);
        IOUtils.putInt8(arr_b1, 28, this.granulerateDenominator);
        IOUtils.putInt8(arr_b1, 36, this.baseGranule);
        IOUtils.putInt4(arr_b1, 44, ((long)this.preroll));
        arr_b1[0x30] = this.granuleShift;
        System.arraycopy(arr_b, 0, arr_b1, 52, arr_b.length);
        this.setData(arr_b1);
        return super.write();
    }
}

