package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IcyDecoder implements MetadataDecoder {
    private static final Pattern METADATA_ELEMENT = null;
    private static final String STREAM_KEY_NAME = "streamtitle";
    private static final String STREAM_KEY_URL = "streamurl";
    private final CharsetDecoder iso88591Decoder;
    private final CharsetDecoder utf8Decoder;

    static {
        IcyDecoder.METADATA_ELEMENT = Pattern.compile("(.+?)=\'(.*?)\';", 0x20);
    }

    public IcyDecoder() {
        this.utf8Decoder = Charset.forName("UTF-8").newDecoder();
        this.iso88591Decoder = Charset.forName("ISO-8859-1").newDecoder();
    }

    @Override  // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer0) {
        ByteBuffer byteBuffer0 = (ByteBuffer)Assertions.checkNotNull(metadataInputBuffer0.data);
        String s = this.decodeToString(byteBuffer0);
        byte[] arr_b = new byte[byteBuffer0.limit()];
        byteBuffer0.get(arr_b);
        String s1 = null;
        if(s == null) {
            return new Metadata(new Entry[]{new IcyInfo(arr_b, null, null)});
        }
        Matcher matcher0 = IcyDecoder.METADATA_ELEMENT.matcher(s);
        String s2 = null;
        for(int v = 0; matcher0.find(v); v = matcher0.end()) {
            String s3 = Util.toLowerInvariant(matcher0.group(1));
            String s4 = matcher0.group(2);
            s3.getClass();
            if(s3.equals("streamurl")) {
                s2 = s4;
            }
            else if(s3.equals("streamtitle")) {
                s1 = s4;
            }
        }
        return new Metadata(new Entry[]{new IcyInfo(arr_b, s1, s2)});
    }

    private String decodeToString(ByteBuffer byteBuffer0) {
        String s;
        try {
            s = this.utf8Decoder.decode(byteBuffer0).toString();
        }
        catch(CharacterCodingException unused_ex) {
            this.utf8Decoder.reset();
            byteBuffer0.rewind();
            try {
                return this.iso88591Decoder.decode(byteBuffer0).toString();
            }
            catch(CharacterCodingException unused_ex) {
                return null;
            }
            finally {
                this.iso88591Decoder.reset();
                byteBuffer0.rewind();
            }
        }
        finally {
            this.utf8Decoder.reset();
            byteBuffer0.rewind();
        }
        return s;
    }
}

