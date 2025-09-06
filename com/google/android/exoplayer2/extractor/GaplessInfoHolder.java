package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GaplessInfoHolder {
    private static final Pattern GAPLESS_COMMENT_PATTERN = null;
    private static final String GAPLESS_DESCRIPTION = "iTunSMPB";
    private static final String GAPLESS_DOMAIN = "com.apple.iTunes";
    public int encoderDelay;
    public int encoderPadding;

    static {
        GaplessInfoHolder.GAPLESS_COMMENT_PATTERN = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    }

    public GaplessInfoHolder() {
        this.encoderDelay = -1;
        this.encoderPadding = -1;
    }

    public boolean hasGaplessInfo() {
        return this.encoderDelay != -1 && this.encoderPadding != -1;
    }

    private boolean setFromComment(String s) {
        Matcher matcher0 = GaplessInfoHolder.GAPLESS_COMMENT_PATTERN.matcher(s);
        if(matcher0.find()) {
            try {
                int v = Integer.parseInt(matcher0.group(1), 16);
                int v1 = Integer.parseInt(matcher0.group(2), 16);
                if(v > 0 || v1 > 0) {
                    this.encoderDelay = v;
                    this.encoderPadding = v1;
                    return true;
                }
                return false;
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return false;
    }

    public boolean setFromMetadata(Metadata metadata0) {
        for(int v = 0; v < metadata0.length(); ++v) {
            Entry metadata$Entry0 = metadata0.get(v);
            if(metadata$Entry0 instanceof CommentFrame) {
                if("iTunSMPB".equals(((CommentFrame)metadata$Entry0).description) && this.setFromComment(((CommentFrame)metadata$Entry0).text)) {
                    return true;
                }
            }
            else if(metadata$Entry0 instanceof InternalFrame && "com.apple.iTunes".equals(((InternalFrame)metadata$Entry0).domain) && "iTunSMPB".equals(((InternalFrame)metadata$Entry0).description) && this.setFromComment(((InternalFrame)metadata$Entry0).text)) {
                return true;
            }
        }
        return false;
    }

    public boolean setFromXingHeaderValue(int v) {
        if(v >> 12 <= 0 && (v & 0xFFF) <= 0) {
            return false;
        }
        this.encoderDelay = v >> 12;
        this.encoderPadding = v & 0xFFF;
        return true;
    }
}

