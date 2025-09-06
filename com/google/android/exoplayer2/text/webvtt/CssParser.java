package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class CssParser {
    private static final String PROPERTY_BGCOLOR = "background-color";
    private static final String PROPERTY_FONT_FAMILY = "font-family";
    private static final String PROPERTY_FONT_STYLE = "font-style";
    private static final String PROPERTY_FONT_WEIGHT = "font-weight";
    private static final String PROPERTY_TEXT_DECORATION = "text-decoration";
    private static final String RULE_END = "}";
    private static final String RULE_START = "{";
    private static final String VALUE_BOLD = "bold";
    private static final String VALUE_ITALIC = "italic";
    private static final String VALUE_UNDERLINE = "underline";
    private static final Pattern VOICE_NAME_PATTERN;
    private final StringBuilder stringBuilder;
    private final ParsableByteArray styleInput;

    static {
        CssParser.VOICE_NAME_PATTERN = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    }

    public CssParser() {
        this.styleInput = new ParsableByteArray();
        this.stringBuilder = new StringBuilder();
    }

    private void applySelectorToStyle(WebvttCssStyle webvttCssStyle0, String s) {
        if(!"".equals(s)) {
            int v = s.indexOf(91);
            if(v != -1) {
                Matcher matcher0 = CssParser.VOICE_NAME_PATTERN.matcher(s.substring(v));
                if(matcher0.matches()) {
                    webvttCssStyle0.setTargetVoice(matcher0.group(1));
                }
                s = s.substring(0, v);
            }
            String[] arr_s = Util.split(s, "\\.");
            String s1 = arr_s[0];
            int v1 = s1.indexOf(35);
            if(v1 == -1) {
                webvttCssStyle0.setTargetTagName(s1);
            }
            else {
                webvttCssStyle0.setTargetTagName(s1.substring(0, v1));
                webvttCssStyle0.setTargetId(s1.substring(v1 + 1));
            }
            if(arr_s.length > 1) {
                webvttCssStyle0.setTargetClasses(((String[])Util.nullSafeArrayCopyOfRange(arr_s, 1, arr_s.length)));
            }
        }
    }

    private static boolean maybeSkipComment(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        byte[] arr_b = parsableByteArray0.data;
        if(v + 2 <= v1 && arr_b[v] == 0x2F) {
            int v2 = v + 2;
            if(arr_b[v + 1] == 42) {
                while(v2 + 1 < v1) {
                    if(((char)arr_b[v2]) == 42 && ((char)arr_b[v2 + 1]) == 0x2F) {
                        v2 += 2;
                        v1 = v2;
                    }
                    else {
                        ++v2;
                    }
                }
                parsableByteArray0.skipBytes(v1 - parsableByteArray0.getPosition());
                return true;
            }
        }
        return false;
    }

    private static boolean maybeSkipWhitespace(ParsableByteArray parsableByteArray0) {
        switch(CssParser.peekCharAtPosition(parsableByteArray0, parsableByteArray0.getPosition())) {
            case 9: 
            case 10: 
            case 12: 
            case 13: 
            case 0x20: {
                parsableByteArray0.skipBytes(1);
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public List parseBlock(ParsableByteArray parsableByteArray0) {
        this.stringBuilder.setLength(0);
        CssParser.skipStyleBlock(parsableByteArray0);
        this.styleInput.reset(parsableByteArray0.data, parsableByteArray0.getPosition());
        this.styleInput.setPosition(parsableByteArray0.getPosition());
        List list0 = new ArrayList();
        while(true) {
            String s = CssParser.parseSelector(this.styleInput, this.stringBuilder);
            if(s == null || !"{".equals(CssParser.parseNextToken(this.styleInput, this.stringBuilder))) {
                break;
            }
            WebvttCssStyle webvttCssStyle0 = new WebvttCssStyle();
            this.applySelectorToStyle(webvttCssStyle0, s);
            String s1 = null;
            for(int v = 0; v == 0; v = v2) {
                int v1 = this.styleInput.getPosition();
                String s2 = CssParser.parseNextToken(this.styleInput, this.stringBuilder);
                int v2 = s2 == null || "}".equals(s2) ? 1 : 0;
                if(v2 == 0) {
                    this.styleInput.setPosition(v1);
                    CssParser.parseStyleDeclaration(this.styleInput, webvttCssStyle0, this.stringBuilder);
                }
                s1 = s2;
            }
            if("}".equals(s1)) {
                ((ArrayList)list0).add(webvttCssStyle0);
            }
        }
        return list0;
    }

    private static String parseIdentifier(ParsableByteArray parsableByteArray0, StringBuilder stringBuilder0) {
        boolean z = false;
        stringBuilder0.setLength(0);
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        while(v < v1 && !z) {
            int v2 = (char)parsableByteArray0.data[v];
            if((v2 < 65 || v2 > 90) && (v2 < 97 || v2 > 0x7A) && (v2 < 0x30 || v2 > 57) && (v2 != 35 && v2 != 45 && v2 != 46 && v2 != 0x5F)) {
                z = true;
            }
            else {
                ++v;
                stringBuilder0.append(((char)v2));
            }
        }
        parsableByteArray0.skipBytes(v - parsableByteArray0.getPosition());
        return stringBuilder0.toString();
    }

    public static String parseNextToken(ParsableByteArray parsableByteArray0, StringBuilder stringBuilder0) {
        CssParser.skipWhitespaceAndComments(parsableByteArray0);
        if(parsableByteArray0.bytesLeft() == 0) {
            return null;
        }
        String s = CssParser.parseIdentifier(parsableByteArray0, stringBuilder0);
        return !"".equals(s) ? s : ((char)parsableByteArray0.readUnsignedByte());
    }

    private static String parsePropertyValue(ParsableByteArray parsableByteArray0, StringBuilder stringBuilder0) {
        StringBuilder stringBuilder1 = new StringBuilder();
        boolean z = false;
        while(!z) {
            int v = parsableByteArray0.getPosition();
            String s = CssParser.parseNextToken(parsableByteArray0, stringBuilder0);
            if(s == null) {
                return null;
            }
            if(!"}".equals(s) && !";".equals(s)) {
                stringBuilder1.append(s);
            }
            else {
                parsableByteArray0.setPosition(v);
                z = true;
            }
        }
        return stringBuilder1.toString();
    }

    private static String parseSelector(ParsableByteArray parsableByteArray0, StringBuilder stringBuilder0) {
        CssParser.skipWhitespaceAndComments(parsableByteArray0);
        if(parsableByteArray0.bytesLeft() < 5) {
            return null;
        }
        if(!"::cue".equals(parsableByteArray0.readString(5))) {
            return null;
        }
        int v = parsableByteArray0.getPosition();
        String s = CssParser.parseNextToken(parsableByteArray0, stringBuilder0);
        if(s == null) {
            return null;
        }
        if("{".equals(s)) {
            parsableByteArray0.setPosition(v);
            return "";
        }
        String s1 = "(".equals(s) ? CssParser.readCueTarget(parsableByteArray0) : null;
        return ")".equals(CssParser.parseNextToken(parsableByteArray0, stringBuilder0)) ? s1 : null;
    }

    private static void parseStyleDeclaration(ParsableByteArray parsableByteArray0, WebvttCssStyle webvttCssStyle0, StringBuilder stringBuilder0) {
        CssParser.skipWhitespaceAndComments(parsableByteArray0);
        String s = CssParser.parseIdentifier(parsableByteArray0, stringBuilder0);
        if(!"".equals(s) && ":".equals(CssParser.parseNextToken(parsableByteArray0, stringBuilder0))) {
            CssParser.skipWhitespaceAndComments(parsableByteArray0);
            String s1 = CssParser.parsePropertyValue(parsableByteArray0, stringBuilder0);
            if(s1 != null && !"".equals(s1)) {
                int v = parsableByteArray0.getPosition();
                String s2 = CssParser.parseNextToken(parsableByteArray0, stringBuilder0);
                if(";".equals(s2)) {
                label_11:
                    if("color".equals(s)) {
                        webvttCssStyle0.setFontColor(ColorParser.parseCssColor(s1));
                        return;
                    }
                    if("background-color".equals(s)) {
                        webvttCssStyle0.setBackgroundColor(ColorParser.parseCssColor(s1));
                        return;
                    }
                    if(!"text-decoration".equals(s)) {
                        if("font-family".equals(s)) {
                            webvttCssStyle0.setFontFamily(s1);
                            return;
                        }
                        if("font-weight".equals(s)) {
                            if("bold".equals(s1)) {
                                webvttCssStyle0.setBold(true);
                            }
                        }
                        else if("font-style".equals(s) && "italic".equals(s1)) {
                            webvttCssStyle0.setItalic(true);
                        }
                    }
                    else if("underline".equals(s1)) {
                        webvttCssStyle0.setUnderline(true);
                    }
                }
                else if("}".equals(s2)) {
                    parsableByteArray0.setPosition(v);
                    goto label_11;
                }
            }
        }
    }

    private static char peekCharAtPosition(ParsableByteArray parsableByteArray0, int v) {
        return (char)parsableByteArray0.data[v];
    }

    private static String readCueTarget(ParsableByteArray parsableByteArray0) {
        int v = parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.limit();
        boolean z = false;
        while(v < v1 && !z) {
            z = ((char)parsableByteArray0.data[v]) == 41;
            ++v;
        }
        return parsableByteArray0.readString(v - 1 - parsableByteArray0.getPosition()).trim();
    }

    public static void skipStyleBlock(ParsableByteArray parsableByteArray0) {
        while(!TextUtils.isEmpty(parsableByteArray0.readLine())) {
        }
    }

    public static void skipWhitespaceAndComments(ParsableByteArray parsableByteArray0) {
    alab1:
        while(true) {
            for(boolean z = true; true; z = false) {
                if(parsableByteArray0.bytesLeft() <= 0 || !z) {
                    break alab1;
                }
                if(CssParser.maybeSkipWhitespace(parsableByteArray0) || CssParser.maybeSkipComment(parsableByteArray0)) {
                    break;
                }
            }
        }
    }
}

