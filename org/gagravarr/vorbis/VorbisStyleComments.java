package org.gagravarr.vorbis;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.audio.OggAudioTagsHeader;

public abstract class VorbisStyleComments extends HighLevelOggStreamPacket implements OggAudioTagsHeader {
    public static final String KEY_ALBUM = "album";
    public static final String KEY_ARTIST = "artist";
    public static final String KEY_DATE = "date";
    public static final String KEY_GENRE = "genre";
    public static final String KEY_TITLE = "title";
    public static final String KEY_TRACKNUMBER = "tracknumber";
    private Map comments;
    private String vendor;

    public VorbisStyleComments() {
        this.comments = new HashMap();
        this.vendor = "Gagravarr.org Java Vorbis Tools v0.6 20140509";
    }

    public VorbisStyleComments(OggPacket oggPacket0, int v) {
        super(oggPacket0);
        this.comments = new HashMap();
        byte[] arr_b = oggPacket0.getData();
        int v1 = this.getInt4(arr_b, v);
        this.vendor = IOUtils.getUTF8(arr_b, v + 4, v1);
        int v2 = v + 4 + v1;
        int v3 = this.getInt4(arr_b, v2);
        int v4 = v2 + 4;
        for(int v5 = 0; v5 < v3; ++v5) {
            int v6 = this.getInt4(arr_b, v4);
            String s = IOUtils.getUTF8(arr_b, v4 + 4, v6);
            v4 = v4 + 4 + v6;
            int v7 = s.indexOf(61);
            if(v7 == -1) {
                System.err.println("Warning - unable to parse comment \'" + s + "\'");
            }
            else {
                this.addComment(VorbisStyleComments.normaliseTag(s.substring(0, v7)), s.substring(v7 + 1));
            }
        }
        if(v4 < arr_b.length && arr_b[v4] == 0) {
            throw new IllegalArgumentException("Framing bit not set, invalid");
        }
    }

    public void addComment(String s, String s1) {
        String s2 = VorbisStyleComments.normaliseTag(s);
        if(!this.comments.containsKey(s2)) {
            this.comments.put(s2, new ArrayList());
        }
        ((List)this.comments.get(s2)).add(s1);
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioTagsHeader
    public String getAlbum() {
        return this.getSingleComment("album");
    }

    public Map getAllComments() {
        return this.comments;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioTagsHeader
    public String getArtist() {
        return this.getSingleComment("artist");
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioTagsHeader
    public List getComments(String s) {
        List list0 = (List)this.comments.get(VorbisStyleComments.normaliseTag(s));
        return list0 == null ? new ArrayList() : list0;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioTagsHeader
    public String getDate() {
        return this.getSingleComment("date");
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioTagsHeader
    public String getGenre() {
        return this.getSingleComment("genre");
    }

    public abstract int getHeaderSize();

    public int getInt4(byte[] arr_b, int v) {
        return (int)IOUtils.getInt4(arr_b, v);
    }

    public String getSingleComment(String s) {
        List list0 = (List)this.comments.get(s);
        return list0 == null || list0.size() <= 0 ? null : ((String)list0.get(0));
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioTagsHeader
    public String getTitle() {
        return this.getSingleComment("title");
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioTagsHeader
    public String getTrackNumber() {
        return this.getSingleComment("tracknumber");
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioTagsHeader
    public int getTrackNumberNumeric() {
        String s = this.getTrackNumber();
        if(s == null) {
            return -1;
        }
        try {
            return Integer.parseInt(s);
        }
        catch(NumberFormatException unused_ex) {
            return -1;
        }
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioTagsHeader
    public String getVendor() {
        return this.vendor;
    }

    public static String normaliseTag(String s) {
        StringBuffer stringBuffer0 = new StringBuffer();
        char[] arr_c = s.toLowerCase().toCharArray();
        for(int v = 0; v < arr_c.length; ++v) {
            int v1 = arr_c[v];
            if(v1 >= 0x20 && v1 <= 0x7D && v1 != 61) {
                stringBuffer0.append(((char)v1));
            }
        }
        return stringBuffer0.toString();
    }

    public abstract void populateMetadataFooter(OutputStream arg1);

    public abstract void populateMetadataHeader(byte[] arg1, int arg2);

    public void removeAllComments() {
        this.comments.clear();
    }

    public void removeComments(String s) {
        this.comments.remove(VorbisStyleComments.normaliseTag(s));
    }

    public void setComments(String s, List list0) {
        String s1 = VorbisStyleComments.normaliseTag(s);
        if(this.comments.containsKey(s1)) {
            this.comments.remove(s1);
        }
        this.comments.put(s1, list0);
    }

    public void setVendor(String s) {
        this.vendor = s;
    }

    @Override  // org.gagravarr.ogg.HighLevelOggStreamPacket, org.gagravarr.ogg.OggStreamPacket
    public OggPacket write() {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream0.write(new byte[this.getHeaderSize()]);
            IOUtils.writeUTF8WithLength(byteArrayOutputStream0, this.vendor);
            int v1 = 0;
            for(Object object0: this.comments.values()) {
                v1 += ((List)object0).size();
            }
            IOUtils.writeInt4(byteArrayOutputStream0, ((long)v1));
            String[] arr_s = (String[])this.comments.keySet().toArray(new String[this.comments.size()]);
            Arrays.sort(arr_s);
            for(int v = 0; v < arr_s.length; ++v) {
                String s = arr_s[v];
                for(Object object1: ((List)this.comments.get(s))) {
                    IOUtils.writeUTF8WithLength(byteArrayOutputStream0, s + '=' + ((String)object1));
                }
            }
            this.populateMetadataFooter(byteArrayOutputStream0);
        }
        catch(IOException iOException0) {
            throw new RuntimeException(iOException0);
        }
        byte[] arr_b = byteArrayOutputStream0.toByteArray();
        this.populateMetadataHeader(arr_b, arr_b.length);
        this.setData(arr_b);
        return super.write();
    }
}

