package com.google.android.exoplayer2.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SubripDecoder extends SimpleSubtitleDecoder {
    private static final String ALIGN_BOTTOM_LEFT = "{\\an1}";
    private static final String ALIGN_BOTTOM_MID = "{\\an2}";
    private static final String ALIGN_BOTTOM_RIGHT = "{\\an3}";
    private static final String ALIGN_MID_LEFT = "{\\an4}";
    private static final String ALIGN_MID_MID = "{\\an5}";
    private static final String ALIGN_MID_RIGHT = "{\\an6}";
    private static final String ALIGN_TOP_LEFT = "{\\an7}";
    private static final String ALIGN_TOP_MID = "{\\an8}";
    private static final String ALIGN_TOP_RIGHT = "{\\an9}";
    private static final float END_FRACTION = 0.92f;
    private static final float MID_FRACTION = 0.5f;
    private static final float START_FRACTION = 0.08f;
    private static final String SUBRIP_ALIGNMENT_TAG = "\\{\\\\an[1-9]\\}";
    private static final Pattern SUBRIP_TAG_PATTERN = null;
    private static final String SUBRIP_TIMECODE = "(?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?";
    private static final Pattern SUBRIP_TIMING_LINE = null;
    private static final String TAG = "SubripDecoder";
    private final ArrayList tags;
    private final StringBuilder textBuilder;

    static {
        SubripDecoder.SUBRIP_TIMING_LINE = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
        SubripDecoder.SUBRIP_TAG_PATTERN = Pattern.compile("\\{\\\\.*?\\}");
    }

    public SubripDecoder() {
        super("SubripDecoder");
        this.textBuilder = new StringBuilder();
        this.tags = new ArrayList();
    }

    private Cue buildCue(Spanned spanned0, String s) {
        int v;
        int v1;
        if(s == null) {
            return new Cue(spanned0);
        }
        switch(s) {
            case "{\an1}": {
                v1 = 0;
                break;
            }
            case "{\an2}": {
                v = 6;
                v1 = v == 5 ? 2 : 1;
                break;
            }
            case "{\an3}": {
                v1 = 2;
                break;
            }
            case "{\an4}": {
                v1 = 0;
                break;
            }
            case "{\an5}": {
                v = 7;
                v1 = v == 5 ? 2 : 1;
                break;
            }
            case "{\an6}": {
                v1 = 2;
                break;
            }
            case "{\an7}": {
                v1 = 0;
                break;
            }
            case "{\an8}": {
                v = 8;
                v1 = v == 5 ? 2 : 1;
                break;
            }
            case "{\an9}": {
                v = 5;
                v1 = v == 5 ? 2 : 1;
                break;
            }
            default: {
                v = -1;
                v1 = v == 5 ? 2 : 1;
                break;
            }
        }
        switch(s) {
            case "{\an1}": {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(2), 0, 2, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
            case "{\an2}": {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(2), 0, 2, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
            case "{\an3}": {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(2), 0, 2, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
            case "{\an4}": {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(1), 0, 1, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
            case "{\an5}": {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(1), 0, 1, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
            case "{\an6}": {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(1), 0, 1, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
            case "{\an7}": {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(0), 0, 0, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
            case "{\an8}": {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(0), 0, 0, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
            case "{\an9}": {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(0), 0, 0, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
            default: {
                return new Cue(spanned0, null, SubripDecoder.getFractionalPositionForAnchorType(1), 0, 1, SubripDecoder.getFractionalPositionForAnchorType(v1), v1, -3.402823E+38f);
            }
        }
    }

    @Override  // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] arr_b, int v, boolean z) {
        String s4;
        ArrayList arrayList0 = new ArrayList();
        LongArray longArray0 = new LongArray();
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(arr_b, v);
        String s;
        while((s = parsableByteArray0.readLine()) != null) {
            if(s.length() != 0) {
                try {
                    Integer.parseInt(s);
                }
                catch(NumberFormatException unused_ex) {
                    Log.w("SubripDecoder", (s.length() == 0 ? new String("Skipping invalid index: ") : "Skipping invalid index: " + s));
                    continue;
                }
                String s1 = parsableByteArray0.readLine();
                if(s1 == null) {
                    Log.w("SubripDecoder", "Unexpected end");
                    break;
                }
                Matcher matcher0 = SubripDecoder.SUBRIP_TIMING_LINE.matcher(s1);
                if(matcher0.matches()) {
                    longArray0.add(SubripDecoder.parseTimecode(matcher0, 1));
                    longArray0.add(SubripDecoder.parseTimecode(matcher0, 6));
                    int v1 = 0;
                    this.textBuilder.setLength(0);
                    this.tags.clear();
                    for(String s2 = parsableByteArray0.readLine(); !TextUtils.isEmpty(s2); s2 = parsableByteArray0.readLine()) {
                        if(this.textBuilder.length() > 0) {
                            this.textBuilder.append("<br>");
                        }
                        String s3 = this.processLine(s2, this.tags);
                        this.textBuilder.append(s3);
                    }
                    Spanned spanned0 = Html.fromHtml(this.textBuilder.toString());
                    while(true) {
                        s4 = null;
                        if(v1 < this.tags.size()) {
                            String s5 = (String)this.tags.get(v1);
                            if(s5.matches("\\{\\\\an[1-9]\\}")) {
                                s4 = s5;
                            }
                            else {
                                ++v1;
                                continue;
                            }
                        }
                        break;
                    }
                    arrayList0.add(this.buildCue(spanned0, s4));
                    arrayList0.add(Cue.EMPTY);
                }
                else {
                    Log.w("SubripDecoder", (s1.length() == 0 ? new String("Skipping invalid timing: ") : "Skipping invalid timing: " + s1));
                }
            }
        }
        Cue[] arr_cue = new Cue[arrayList0.size()];
        arrayList0.toArray(arr_cue);
        return new SubripSubtitle(arr_cue, longArray0.toArray());
    }

    public static float getFractionalPositionForAnchorType(int v) {
        switch(v) {
            case 0: {
                return 0.08f;
            }
            case 1: {
                return 0.5f;
            }
            case 2: {
                return 0.92f;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    private static long parseTimecode(Matcher matcher0, int v) {
        String s = matcher0.group(v + 1);
        long v1 = s == null ? 0L : Long.parseLong(s) * 3600000L;
        long v2 = Long.parseLong(matcher0.group(v + 2));
        long v3 = Long.parseLong(matcher0.group(v + 3)) * 1000L + (v2 * 60000L + v1);
        String s1 = matcher0.group(v + 4);
        if(s1 != null) {
            v3 += Long.parseLong(s1);
        }
        return v3 * 1000L;
    }

    private String processLine(String s, ArrayList arrayList0) {
        String s1 = s.trim();
        StringBuilder stringBuilder0 = new StringBuilder(s1);
        Matcher matcher0 = SubripDecoder.SUBRIP_TAG_PATTERN.matcher(s1);
        for(int v = 0; matcher0.find(); v += v2) {
            String s2 = matcher0.group();
            arrayList0.add(s2);
            int v1 = matcher0.start();
            int v2 = s2.length();
            stringBuilder0.replace(v1 - v, v1 - v + v2, "");
        }
        return stringBuilder0.toString();
    }
}

