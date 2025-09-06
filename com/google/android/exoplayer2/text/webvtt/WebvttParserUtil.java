package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttParserUtil {
    private static final Pattern COMMENT = null;
    private static final String WEBVTT_HEADER = "WEBVTT";

    static {
        WebvttParserUtil.COMMENT = Pattern.compile("^NOTE([ \t].*)?$");
    }

    public static Matcher findNextCueHeader(ParsableByteArray parsableByteArray0) {
        String s;
    alab1:
        while(true) {
            do {
                s = parsableByteArray0.readLine();
                if(s == null) {
                    break alab1;
                }
                if(!WebvttParserUtil.COMMENT.matcher(s).matches()) {
                    goto label_6;
                }
            label_3:
                String s1 = parsableByteArray0.readLine();
            }
            while(s1 == null || s1.isEmpty());
            goto label_3;
        label_6:
            Matcher matcher0 = WebvttCueParser.CUE_HEADER_PATTERN.matcher(s);
            if(matcher0.matches()) {
                return matcher0;
            }
        }
        return null;
    }

    public static boolean isWebvttHeaderLine(ParsableByteArray parsableByteArray0) {
        String s = parsableByteArray0.readLine();
        return s != null && s.startsWith("WEBVTT");
    }

    public static float parsePercentage(String s) {
        if(!s.endsWith("%")) {
            throw new NumberFormatException("Percentages must end with %");
        }
        return Float.parseFloat(s.substring(0, s.length() - 1)) / 100.0f;
    }

    public static long parseTimestampUs(String s) {
        String[] arr_s = Util.splitAtFirst(s, "\\.");
        String[] arr_s1 = Util.split(arr_s[0], ":");
        long v1 = 0L;
        for(int v = 0; v < arr_s1.length; ++v) {
            v1 = v1 * 60L + Long.parseLong(arr_s1[v]);
        }
        return (arr_s.length == 2 ? v1 * 1000L + Long.parseLong(arr_s[1]) : v1 * 1000L) * 1000L;
    }

    public static void validateWebvttHeaderLine(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.getPosition();
        if(!WebvttParserUtil.isWebvttHeaderLine(parsableByteArray0)) {
            parsableByteArray0.setPosition(v);
            String s = parsableByteArray0.readLine();
            throw new ParserException((s.length() == 0 ? new String("Expected WEBVTT. Got ") : "Expected WEBVTT. Got " + s));
        }
    }
}

