package com.google.android.exoplayer2.text.webvtt;

import U4.x;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebvttCueParser {
    static final class StartTag {
        private static final String[] NO_CLASSES;
        public final String[] classes;
        public final String name;
        public final int position;
        public final String voice;

        static {
            StartTag.NO_CLASSES = new String[0];
        }

        private StartTag(String s, int v, String s1, String[] arr_s) {
            this.position = v;
            this.name = s;
            this.voice = s1;
            this.classes = arr_s;
        }

        public static StartTag buildStartTag(String s, int v) {
            String s2;
            String s1 = s.trim();
            Assertions.checkArgument(!s1.isEmpty());
            int v1 = s1.indexOf(" ");
            if(v1 == -1) {
                s2 = "";
            }
            else {
                String s3 = s1.substring(v1).trim();
                s1 = s1.substring(0, v1);
                s2 = s3;
            }
            String[] arr_s = Util.split(s1, "\\.");
            String s4 = arr_s[0];
            return arr_s.length <= 1 ? new StartTag(s4, v, s2, StartTag.NO_CLASSES) : new StartTag(s4, v, s2, ((String[])Util.nullSafeArrayCopyOfRange(arr_s, 1, arr_s.length)));
        }

        public static StartTag buildWholeCueVirtualTag() {
            return new StartTag("", 0, "", new String[0]);
        }
    }

    static final class StyleMatch implements Comparable {
        public final int score;
        public final WebvttCssStyle style;

        public StyleMatch(int v, WebvttCssStyle webvttCssStyle0) {
            this.score = v;
            this.style = webvttCssStyle0;
        }

        public int compareTo(StyleMatch webvttCueParser$StyleMatch0) {
            return this.score - webvttCueParser$StyleMatch0.score;
        }

        @Override
        public int compareTo(Object object0) {
            return this.compareTo(((StyleMatch)object0));
        }
    }

    private static final char CHAR_AMPERSAND = '&';
    private static final char CHAR_GREATER_THAN = '>';
    private static final char CHAR_LESS_THAN = '<';
    private static final char CHAR_SEMI_COLON = ';';
    private static final char CHAR_SLASH = '/';
    private static final char CHAR_SPACE = ' ';
    public static final Pattern CUE_HEADER_PATTERN = null;
    private static final Pattern CUE_SETTING_PATTERN = null;
    private static final String ENTITY_AMPERSAND = "amp";
    private static final String ENTITY_GREATER_THAN = "gt";
    private static final String ENTITY_LESS_THAN = "lt";
    private static final String ENTITY_NON_BREAK_SPACE = "nbsp";
    private static final int STYLE_BOLD = 1;
    private static final int STYLE_ITALIC = 2;
    private static final String TAG = "WebvttCueParser";
    private static final String TAG_BOLD = "b";
    private static final String TAG_CLASS = "c";
    private static final String TAG_ITALIC = "i";
    private static final String TAG_LANG = "lang";
    private static final String TAG_UNDERLINE = "u";
    private static final String TAG_VOICE = "v";
    private final StringBuilder textBuilder;

    static {
        WebvttCueParser.CUE_HEADER_PATTERN = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
        WebvttCueParser.CUE_SETTING_PATTERN = Pattern.compile("(\\S+?):(\\S+)");
    }

    public WebvttCueParser() {
        this.textBuilder = new StringBuilder();
    }

    private static void applyEntity(String s, SpannableStringBuilder spannableStringBuilder0) {
        s.getClass();
        switch(s) {
            case "amp": {
                spannableStringBuilder0.append('&');
                return;
            }
            case "gt": {
                spannableStringBuilder0.append('>');
                return;
            }
            case "lt": {
                spannableStringBuilder0.append('<');
                return;
            }
            case "nbsp": {
                spannableStringBuilder0.append(' ');
                return;
            }
            default: {
                Log.w("WebvttCueParser", "ignoring unsupported entity: \'&" + s + ";\'");
            }
        }
    }

    private static void applySpansForTag(String s, StartTag webvttCueParser$StartTag0, SpannableStringBuilder spannableStringBuilder0, List list0, List list1) {
        int v = webvttCueParser$StartTag0.position;
        int v1 = spannableStringBuilder0.length();
        webvttCueParser$StartTag0.name.getClass();
        switch(webvttCueParser$StartTag0.name) {
            case "": {
                break;
            }
            case "b": {
                x.t(1, spannableStringBuilder0, v, v1, 33);
                break;
            }
            case "c": {
                break;
            }
            case "i": {
                x.t(2, spannableStringBuilder0, v, v1, 33);
                break;
            }
            case "lang": 
            case "v": {
                break;
            }
            case "u": {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), v, v1, 33);
                break;
            }
            default: {
                return;
            }
        }
        list1.clear();
        WebvttCueParser.getApplicableStyles(list0, s, webvttCueParser$StartTag0, list1);
        int v3 = list1.size();
        for(int v2 = 0; v2 < v3; ++v2) {
            WebvttCueParser.applyStyleToText(spannableStringBuilder0, ((StyleMatch)list1.get(v2)).style, v, v1);
        }
    }

    private static void applyStyleToText(SpannableStringBuilder spannableStringBuilder0, WebvttCssStyle webvttCssStyle0, int v, int v1) {
        if(webvttCssStyle0 != null) {
            if(webvttCssStyle0.getStyle() != -1) {
                spannableStringBuilder0.setSpan(new StyleSpan(webvttCssStyle0.getStyle()), v, v1, 33);
            }
            if(webvttCssStyle0.isLinethrough()) {
                spannableStringBuilder0.setSpan(new StrikethroughSpan(), v, v1, 33);
            }
            if(webvttCssStyle0.isUnderline()) {
                spannableStringBuilder0.setSpan(new UnderlineSpan(), v, v1, 33);
            }
            if(webvttCssStyle0.hasFontColor()) {
                spannableStringBuilder0.setSpan(new ForegroundColorSpan(webvttCssStyle0.getFontColor()), v, v1, 33);
            }
            if(webvttCssStyle0.hasBackgroundColor()) {
                spannableStringBuilder0.setSpan(new BackgroundColorSpan(webvttCssStyle0.getBackgroundColor()), v, v1, 33);
            }
            if(webvttCssStyle0.getFontFamily() != null) {
                spannableStringBuilder0.setSpan(new TypefaceSpan(webvttCssStyle0.getFontFamily()), v, v1, 33);
            }
            Layout.Alignment layout$Alignment0 = webvttCssStyle0.getTextAlign();
            if(layout$Alignment0 != null) {
                spannableStringBuilder0.setSpan(new AlignmentSpan.Standard(layout$Alignment0), v, v1, 33);
            }
            switch(webvttCssStyle0.getFontSizeUnit()) {
                case 1: {
                    spannableStringBuilder0.setSpan(new AbsoluteSizeSpan(((int)webvttCssStyle0.getFontSize()), true), v, v1, 33);
                    return;
                }
                case 2: {
                    spannableStringBuilder0.setSpan(new RelativeSizeSpan(webvttCssStyle0.getFontSize()), v, v1, 33);
                    return;
                }
                case 3: {
                    spannableStringBuilder0.setSpan(new RelativeSizeSpan(webvttCssStyle0.getFontSize() / 100.0f), v, v1, 33);
                }
            }
        }
    }

    private static int findEndOfTag(String s, int v) {
        int v1 = s.indexOf(62, v);
        return v1 == -1 ? s.length() : v1 + 1;
    }

    private static void getApplicableStyles(List list0, String s, StartTag webvttCueParser$StartTag0, List list1) {
        int v = list0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            WebvttCssStyle webvttCssStyle0 = (WebvttCssStyle)list0.get(v1);
            int v2 = webvttCssStyle0.getSpecificityScore(s, webvttCueParser$StartTag0.name, webvttCueParser$StartTag0.classes, webvttCueParser$StartTag0.voice);
            if(v2 > 0) {
                list1.add(new StyleMatch(v2, webvttCssStyle0));
            }
        }
        Collections.sort(list1);
    }

    private static String getTagName(String s) {
        String s1 = s.trim();
        Assertions.checkArgument(!s1.isEmpty());
        return Util.splitAtFirst(s1, "[ \\.]")[0];
    }

    private static boolean isSupportedTag(String s) {
        s.getClass();
        switch(s) {
            case "b": 
            case "c": 
            case "i": 
            case "lang": 
            case "u": 
            case "v": {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    private static boolean parseCue(String s, Matcher matcher0, ParsableByteArray parsableByteArray0, Builder webvttCue$Builder0, StringBuilder stringBuilder0, List list0) {
        try {
            webvttCue$Builder0.setStartTime(WebvttParserUtil.parseTimestampUs(matcher0.group(1))).setEndTime(WebvttParserUtil.parseTimestampUs(matcher0.group(2)));
        }
        catch(NumberFormatException unused_ex) {
            String s1 = matcher0.group();
            Log.w("WebvttCueParser", (s1.length() == 0 ? new String("Skipping cue with bad header: ") : "Skipping cue with bad header: " + s1));
            return false;
        }
        WebvttCueParser.parseCueSettingsList(matcher0.group(3), webvttCue$Builder0);
        stringBuilder0.setLength(0);
        for(String s2 = parsableByteArray0.readLine(); !TextUtils.isEmpty(s2); s2 = parsableByteArray0.readLine()) {
            if(stringBuilder0.length() > 0) {
                stringBuilder0.append("\n");
            }
            stringBuilder0.append(s2.trim());
        }
        WebvttCueParser.parseCueText(s, stringBuilder0.toString(), webvttCue$Builder0, list0);
        return true;
    }

    public boolean parseCue(ParsableByteArray parsableByteArray0, Builder webvttCue$Builder0, List list0) {
        String s = parsableByteArray0.readLine();
        if(s == null) {
            return false;
        }
        Pattern pattern0 = WebvttCueParser.CUE_HEADER_PATTERN;
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.matches()) {
            return WebvttCueParser.parseCue(null, matcher0, parsableByteArray0, webvttCue$Builder0, this.textBuilder, list0);
        }
        String s1 = parsableByteArray0.readLine();
        if(s1 == null) {
            return false;
        }
        Matcher matcher1 = pattern0.matcher(s1);
        return matcher1.matches() ? WebvttCueParser.parseCue(s.trim(), matcher1, parsableByteArray0, webvttCue$Builder0, this.textBuilder, list0) : false;
    }

    public static void parseCueSettingsList(String s, Builder webvttCue$Builder0) {
        Matcher matcher0 = WebvttCueParser.CUE_SETTING_PATTERN.matcher(s);
        while(matcher0.find()) {
            String s1 = matcher0.group(1);
            String s2 = matcher0.group(2);
            try {
                if(!"line".equals(s1)) {
                    if("align".equals(s1)) {
                        webvttCue$Builder0.setTextAlignment(WebvttCueParser.parseTextAlignment(s2));
                    }
                    else if("position".equals(s1)) {
                        WebvttCueParser.parsePositionAttribute(s2, webvttCue$Builder0);
                    }
                    else if("size".equals(s1)) {
                        webvttCue$Builder0.setWidth(WebvttParserUtil.parsePercentage(s2));
                    }
                    else {
                        Log.w("WebvttCueParser", "Unknown cue setting " + s1 + ":" + s2);
                    }
                    continue;
                }
                WebvttCueParser.parseLineAttribute(s2, webvttCue$Builder0);
            }
            catch(NumberFormatException unused_ex) {
                String s3 = matcher0.group();
                Log.w("WebvttCueParser", (s3.length() == 0 ? new String("Skipping bad cue setting: ") : "Skipping bad cue setting: " + s3));
            }
        }
    }

    public static void parseCueText(String s, String s1, Builder webvttCue$Builder0, List list0) {
        int v5;
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder();
        ArrayDeque arrayDeque0 = new ArrayDeque();
        ArrayList arrayList0 = new ArrayList();
        int v = 0;
        while(v < s1.length()) {
            int v1 = s1.charAt(v);
            switch(v1) {
                case 38: {
                    ++v;
                    int v2 = s1.indexOf(59, v);
                    int v3 = s1.indexOf(0x20, v);
                    if(v2 == -1) {
                        v2 = v3;
                    }
                    else if(v3 != -1) {
                        v2 = Math.min(v2, v3);
                    }
                    if(v2 == -1) {
                        spannableStringBuilder0.append('&');
                    }
                    else {
                        WebvttCueParser.applyEntity(s1.substring(v, v2), spannableStringBuilder0);
                        if(v2 == v3) {
                            spannableStringBuilder0.append(" ");
                        }
                        v = v2 + 1;
                    }
                    continue;
                }
                case 60: {
                    int v4 = 1;
                    v5 = v + 1;
                    if(v5 < s1.length()) {
                        boolean z = s1.charAt(v5) == 0x2F;
                        v5 = WebvttCueParser.findEndOfTag(s1, v5);
                        int v6 = v5 - 2;
                        boolean z1 = s1.charAt(v6) == 0x2F;
                        if(z) {
                            v4 = 2;
                        }
                        if(!z1) {
                            v6 = v5 - 1;
                        }
                        String s2 = s1.substring(v + v4, v6);
                        if(!s2.trim().isEmpty()) {
                            String s3 = WebvttCueParser.getTagName(s2);
                            if(WebvttCueParser.isSupportedTag(s3)) {
                                if(z) {
                                    while(true) {
                                        if(arrayDeque0.isEmpty()) {
                                            break;
                                        }
                                        StartTag webvttCueParser$StartTag0 = (StartTag)arrayDeque0.pop();
                                        WebvttCueParser.applySpansForTag(s, webvttCueParser$StartTag0, spannableStringBuilder0, list0, arrayList0);
                                        if(webvttCueParser$StartTag0.name.equals(s3)) {
                                            break;
                                        }
                                    }
                                }
                                else if(!z1) {
                                    arrayDeque0.push(StartTag.buildStartTag(s2, spannableStringBuilder0.length()));
                                }
                            }
                        }
                    }
                    break;
                }
                default: {
                    spannableStringBuilder0.append(((char)v1));
                    ++v;
                    continue;
                }
            }
            v = v5;
        }
        while(!arrayDeque0.isEmpty()) {
            WebvttCueParser.applySpansForTag(s, ((StartTag)arrayDeque0.pop()), spannableStringBuilder0, list0, arrayList0);
        }
        WebvttCueParser.applySpansForTag(s, StartTag.buildWholeCueVirtualTag(), spannableStringBuilder0, list0, arrayList0);
        webvttCue$Builder0.setText(spannableStringBuilder0);
    }

    private static void parseLineAttribute(String s, Builder webvttCue$Builder0) {
        int v = s.indexOf(44);
        if(v != -1) {
            webvttCue$Builder0.setLineAnchor(WebvttCueParser.parsePositionAnchor(s.substring(v + 1)));
            s = s.substring(0, v);
        }
        if(s.endsWith("%")) {
            webvttCue$Builder0.setLine(WebvttParserUtil.parsePercentage(s)).setLineType(0);
            return;
        }
        int v1 = Integer.parseInt(s);
        if(v1 < 0) {
            --v1;
        }
        webvttCue$Builder0.setLine(((float)v1)).setLineType(1);
    }

    private static int parsePositionAnchor(String s) {
        s.getClass();
        switch(s) {
            case "center": {
                return 1;
            }
            case "end": {
                return 2;
            }
            case "middle": {
                return 1;
            }
            case "start": {
                return 0;
            }
            default: {
                Log.w("WebvttCueParser", (s.length() == 0 ? new String("Invalid anchor value: ") : "Invalid anchor value: " + s));
                return 0x80000000;
            }
        }
    }

    private static void parsePositionAttribute(String s, Builder webvttCue$Builder0) {
        int v = s.indexOf(44);
        if(v != -1) {
            webvttCue$Builder0.setPositionAnchor(WebvttCueParser.parsePositionAnchor(s.substring(v + 1)));
            s = s.substring(0, v);
        }
        webvttCue$Builder0.setPosition(WebvttParserUtil.parsePercentage(s));
    }

    private static int parseTextAlignment(String s) {
        s.getClass();
        switch(s) {
            case "center": {
                return 2;
            }
            case "end": {
                return 3;
            }
            case "left": {
                return 4;
            }
            case "middle": {
                return 2;
            }
            case "right": {
                return 5;
            }
            case "start": {
                return 1;
            }
            default: {
                Log.w("WebvttCueParser", (s.length() == 0 ? new String("Invalid alignment value: ") : "Invalid alignment value: " + s));
                return 2;
            }
        }
    }
}

