package com.google.android.exoplayer2.text.ttml;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.XmlPullParserUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class TtmlDecoder extends SimpleSubtitleDecoder {
    static final class CellResolution {
        final int columns;
        final int rows;

        public CellResolution(int v, int v1) {
            this.columns = v;
            this.rows = v1;
        }
    }

    static final class FrameAndTickRate {
        final float effectiveFrameRate;
        final int subFrameRate;
        final int tickRate;

        public FrameAndTickRate(float f, int v, int v1) {
            this.effectiveFrameRate = f;
            this.subFrameRate = v;
            this.tickRate = v1;
        }
    }

    static final class TtsExtent {
        final int height;
        final int width;

        public TtsExtent(int v, int v1) {
            this.width = v;
            this.height = v1;
        }
    }

    private static final String ATTR_BEGIN = "begin";
    private static final String ATTR_DURATION = "dur";
    private static final String ATTR_END = "end";
    private static final String ATTR_IMAGE = "backgroundImage";
    private static final String ATTR_REGION = "region";
    private static final String ATTR_STYLE = "style";
    private static final Pattern CELL_RESOLUTION = null;
    private static final Pattern CLOCK_TIME = null;
    private static final CellResolution DEFAULT_CELL_RESOLUTION = null;
    private static final FrameAndTickRate DEFAULT_FRAME_AND_TICK_RATE = null;
    private static final int DEFAULT_FRAME_RATE = 30;
    private static final Pattern FONT_SIZE = null;
    private static final Pattern OFFSET_TIME = null;
    private static final Pattern PERCENTAGE_COORDINATES = null;
    private static final Pattern PIXEL_COORDINATES = null;
    private static final String TAG = "TtmlDecoder";
    private static final String TTP = "http://www.w3.org/ns/ttml#parameter";
    private final XmlPullParserFactory xmlParserFactory;

    static {
        TtmlDecoder.CLOCK_TIME = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
        TtmlDecoder.OFFSET_TIME = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
        TtmlDecoder.FONT_SIZE = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
        TtmlDecoder.PERCENTAGE_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
        TtmlDecoder.PIXEL_COORDINATES = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
        TtmlDecoder.CELL_RESOLUTION = Pattern.compile("^(\\d+) (\\d+)$");
        TtmlDecoder.DEFAULT_FRAME_AND_TICK_RATE = new FrameAndTickRate(30.0f, 1, 1);
        TtmlDecoder.DEFAULT_CELL_RESOLUTION = new CellResolution(0x20, 15);
    }

    public TtmlDecoder() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory xmlPullParserFactory0 = XmlPullParserFactory.newInstance();
            this.xmlParserFactory = xmlPullParserFactory0;
            xmlPullParserFactory0.setNamespaceAware(true);
        }
        catch(XmlPullParserException xmlPullParserException0) {
            throw new RuntimeException("Couldn\'t create XmlPullParserFactory instance", xmlPullParserException0);
        }
    }

    private TtmlStyle createIfNull(TtmlStyle ttmlStyle0) {
        return ttmlStyle0 == null ? new TtmlStyle() : ttmlStyle0;
    }

    @Override  // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] arr_b, int v, boolean z) {
        try {
            XmlPullParser xmlPullParser0 = this.xmlParserFactory.newPullParser();
            HashMap hashMap0 = new HashMap();
            HashMap hashMap1 = new HashMap();
            HashMap hashMap2 = new HashMap();
            TtsExtent ttmlDecoder$TtsExtent0 = null;
            hashMap1.put("", new TtmlRegion(null));
            xmlPullParser0.setInput(new ByteArrayInputStream(arr_b, 0, v), null);
            ArrayDeque arrayDeque0 = new ArrayDeque();
            int v1 = xmlPullParser0.getEventType();
            int v2 = 0;
            FrameAndTickRate ttmlDecoder$FrameAndTickRate0 = TtmlDecoder.DEFAULT_FRAME_AND_TICK_RATE;
            CellResolution ttmlDecoder$CellResolution0 = TtmlDecoder.DEFAULT_CELL_RESOLUTION;
            Subtitle subtitle0 = null;
            while(true) {
                if(v1 == 1) {
                    return subtitle0;
                }
                TtmlNode ttmlNode0 = (TtmlNode)arrayDeque0.peek();
                if(v2 == 0) {
                    String s = xmlPullParser0.getName();
                    if(v1 == 2) {
                        if("tt".equals(s)) {
                            ttmlDecoder$FrameAndTickRate0 = this.parseFrameAndTickRates(xmlPullParser0);
                            ttmlDecoder$CellResolution0 = this.parseCellResolution(xmlPullParser0, TtmlDecoder.DEFAULT_CELL_RESOLUTION);
                            ttmlDecoder$TtsExtent0 = this.parseTtsExtent(xmlPullParser0);
                        }
                        if(!TtmlDecoder.isSupportedTag(s)) {
                            String s1 = xmlPullParser0.getName();
                            Log.i("TtmlDecoder", (s1.length() == 0 ? new String("Ignoring unsupported tag: ") : "Ignoring unsupported tag: " + s1));
                            goto label_43;
                        }
                        else if("head".equals(s)) {
                            this.parseHeader(xmlPullParser0, hashMap0, ttmlDecoder$CellResolution0, ttmlDecoder$TtsExtent0, hashMap1, hashMap2);
                        }
                        else {
                            try {
                                TtmlNode ttmlNode1 = this.parseNode(xmlPullParser0, ttmlNode0, hashMap1, ttmlDecoder$FrameAndTickRate0);
                                arrayDeque0.push(ttmlNode1);
                                if(ttmlNode0 != null) {
                                    ttmlNode0.addChild(ttmlNode1);
                                }
                                goto label_54;
                            }
                            catch(SubtitleDecoderException subtitleDecoderException0) {
                                Log.w("TtmlDecoder", "Suppressing parser error", subtitleDecoderException0);
                            }
                        label_43:
                            v2 = 1;
                        }
                    }
                    else {
                        switch(v1) {
                            case 3: {
                                if(xmlPullParser0.getName().equals("tt")) {
                                    subtitle0 = new TtmlSubtitle(((TtmlNode)arrayDeque0.peek()), hashMap0, hashMap1, hashMap2);
                                }
                                arrayDeque0.pop();
                                break;
                            }
                            case 4: {
                                ttmlNode0.addChild(TtmlNode.buildTextNode(xmlPullParser0.getText()));
                            }
                        }
                    }
                }
                else {
                    switch(v1) {
                        case 2: {
                            ++v2;
                            break;
                        }
                        case 3: {
                            --v2;
                        }
                    }
                }
            label_54:
                xmlPullParser0.next();
                v1 = xmlPullParser0.getEventType();
            }
            throw new IllegalStateException("Unexpected error when reading input.", iOException0);
        }
        catch(XmlPullParserException xmlPullParserException0) {
        }
        catch(IOException iOException0) {
            throw new IllegalStateException("Unexpected error when reading input.", iOException0);
        }
        throw new SubtitleDecoderException("Unable to decode source", xmlPullParserException0);
    }

    // 去混淆评级： 中等(150)
    private static boolean isSupportedTag(String s) {
        return s.equals("tt") || s.equals("head") || s.equals("body") || s.equals("div") || s.equals("p") || s.equals("span") || s.equals("br") || s.equals("style") || s.equals("styling") || s.equals("layout") || s.equals("region") || s.equals("metadata") || s.equals("image") || s.equals("data") || s.equals("information");
    }

    private CellResolution parseCellResolution(XmlPullParser xmlPullParser0, CellResolution ttmlDecoder$CellResolution0) {
        String s = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if(s == null) {
            return ttmlDecoder$CellResolution0;
        }
        Matcher matcher0 = TtmlDecoder.CELL_RESOLUTION.matcher(s);
        if(!matcher0.matches()) {
            Log.w("TtmlDecoder", (s.length() == 0 ? new String("Ignoring malformed cell resolution: ") : "Ignoring malformed cell resolution: " + s));
            return ttmlDecoder$CellResolution0;
        }
        try {
            int v = Integer.parseInt(matcher0.group(1));
            int v1 = Integer.parseInt(matcher0.group(2));
            if(v == 0 || v1 == 0) {
                throw new SubtitleDecoderException("Invalid cell resolution " + v + " " + v1);
            }
            return new CellResolution(v, v1);
        }
        catch(NumberFormatException unused_ex) {
            Log.w("TtmlDecoder", (s.length() == 0 ? new String("Ignoring malformed cell resolution: ") : "Ignoring malformed cell resolution: " + s));
            return ttmlDecoder$CellResolution0;
        }
    }

    private static void parseFontSize(String s, TtmlStyle ttmlStyle0) {
        Matcher matcher0;
        String[] arr_s = Util.split(s, "\\s+");
        if(arr_s.length == 1) {
            matcher0 = TtmlDecoder.FONT_SIZE.matcher(s);
        }
        else if(arr_s.length == 2) {
            matcher0 = TtmlDecoder.FONT_SIZE.matcher(arr_s[1]);
            Log.w("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        else {
            throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + arr_s.length + ".");
        }
        if(!matcher0.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: \'" + s + "\'.");
        }
        String s1 = matcher0.group(3);
        s1.getClass();
        switch(s1) {
            case "%": {
                ttmlStyle0.setFontSizeUnit(3);
                break;
            }
            case "em": {
                ttmlStyle0.setFontSizeUnit(2);
                break;
            }
            case "px": {
                ttmlStyle0.setFontSizeUnit(1);
                break;
            }
            default: {
                throw new SubtitleDecoderException("Invalid unit for fontSize: \'" + s1 + "\'.");
            }
        }
        ttmlStyle0.setFontSize(((float)Float.valueOf(matcher0.group(1))));
    }

    private FrameAndTickRate parseFrameAndTickRates(XmlPullParser xmlPullParser0) {
        float f;
        String s = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int v = s == null ? 30 : Integer.parseInt(s);
        String s1 = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if(s1 == null) {
            f = 1.0f;
        }
        else {
            String[] arr_s = Util.split(s1, " ");
            if(arr_s.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn\'t have 2 parts");
            }
            f = ((float)Integer.parseInt(arr_s[0])) / ((float)Integer.parseInt(arr_s[1]));
        }
        FrameAndTickRate ttmlDecoder$FrameAndTickRate0 = TtmlDecoder.DEFAULT_FRAME_AND_TICK_RATE;
        int v1 = ttmlDecoder$FrameAndTickRate0.subFrameRate;
        String s2 = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if(s2 != null) {
            v1 = Integer.parseInt(s2);
        }
        int v2 = ttmlDecoder$FrameAndTickRate0.tickRate;
        String s3 = xmlPullParser0.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if(s3 != null) {
            v2 = Integer.parseInt(s3);
        }
        return new FrameAndTickRate(((float)v) * f, v1, v2);
    }

    private Map parseHeader(XmlPullParser xmlPullParser0, Map map0, CellResolution ttmlDecoder$CellResolution0, TtsExtent ttmlDecoder$TtsExtent0, Map map1, Map map2) {
        do {
            xmlPullParser0.next();
            if(XmlPullParserUtil.isStartTag(xmlPullParser0, "style")) {
                String s = XmlPullParserUtil.getAttributeValue(xmlPullParser0, "style");
                TtmlStyle ttmlStyle0 = this.parseStyleAttributes(xmlPullParser0, new TtmlStyle());
                if(s != null) {
                    String[] arr_s = this.parseStyleIds(s);
                    for(int v = 0; v < arr_s.length; ++v) {
                        ttmlStyle0.chain(((TtmlStyle)map0.get(arr_s[v])));
                    }
                }
                if(ttmlStyle0.getId() != null) {
                    map0.put(ttmlStyle0.getId(), ttmlStyle0);
                }
            }
            else if(XmlPullParserUtil.isStartTag(xmlPullParser0, "region")) {
                TtmlRegion ttmlRegion0 = this.parseRegionAttributes(xmlPullParser0, ttmlDecoder$CellResolution0, ttmlDecoder$TtsExtent0);
                if(ttmlRegion0 != null) {
                    map1.put(ttmlRegion0.id, ttmlRegion0);
                }
            }
            else if(XmlPullParserUtil.isStartTag(xmlPullParser0, "metadata")) {
                this.parseMetadata(xmlPullParser0, map2);
            }
        }
        while(!XmlPullParserUtil.isEndTag(xmlPullParser0, "head"));
        return map0;
    }

    private void parseMetadata(XmlPullParser xmlPullParser0, Map map0) {
        do {
            xmlPullParser0.next();
            if(XmlPullParserUtil.isStartTag(xmlPullParser0, "image")) {
                String s = XmlPullParserUtil.getAttributeValue(xmlPullParser0, "id");
                if(s != null) {
                    map0.put(s, xmlPullParser0.nextText());
                }
            }
        }
        while(!XmlPullParserUtil.isEndTag(xmlPullParser0, "metadata"));
    }

    // This method was un-flattened
    private TtmlNode parseNode(XmlPullParser xmlPullParser0, TtmlNode ttmlNode0, Map map0, FrameAndTickRate ttmlDecoder$FrameAndTickRate0) {
        int v = xmlPullParser0.getAttributeCount();
        TtmlStyle ttmlStyle0 = this.parseStyleAttributes(xmlPullParser0, null);
        String[] arr_s = null;
        String s = null;
        String s1 = "";
        long v2 = 0x8000000000000001L;
        long v3 = 0x8000000000000001L;
        long v4 = 0x8000000000000001L;
        for(int v1 = 0; v1 < v; ++v1) {
            String s2 = xmlPullParser0.getAttributeName(v1);
            String s3 = xmlPullParser0.getAttributeValue(v1);
            s2.getClass();
            switch(s2) {
                case "backgroundImage": {
                    if(s3.startsWith("#")) {
                        s = s3.substring(1);
                    }
                    break;
                }
                case "begin": {
                    v2 = TtmlDecoder.parseTimeExpression(s3, ttmlDecoder$FrameAndTickRate0);
                    break;
                }
                case "dur": {
                    v4 = TtmlDecoder.parseTimeExpression(s3, ttmlDecoder$FrameAndTickRate0);
                    break;
                }
                case "end": {
                    v3 = TtmlDecoder.parseTimeExpression(s3, ttmlDecoder$FrameAndTickRate0);
                    break;
                }
                case "region": {
                    if(map0.containsKey(s3)) {
                        s1 = s3;
                    }
                    break;
                }
                case "style": {
                    String[] arr_s1 = this.parseStyleIds(s3);
                    if(arr_s1.length > 0) {
                        arr_s = arr_s1;
                    }
                }
            }
        }
        if(ttmlNode0 != null) {
            long v5 = ttmlNode0.startTimeUs;
            if(v5 != 0x8000000000000001L) {
                if(v2 != 0x8000000000000001L) {
                    v2 += v5;
                }
                if(v3 != 0x8000000000000001L) {
                    v3 += v5;
                }
            }
        }
        if(v3 == 0x8000000000000001L) {
            if(v4 != 0x8000000000000001L) {
                return TtmlNode.buildNode(xmlPullParser0.getName(), v2, v2 + v4, ttmlStyle0, arr_s, s1, s);
            }
            if(ttmlNode0 != null) {
                return ttmlNode0.endTimeUs == 0x8000000000000001L ? TtmlNode.buildNode(xmlPullParser0.getName(), v2, 0x8000000000000001L, ttmlStyle0, arr_s, s1, s) : TtmlNode.buildNode(xmlPullParser0.getName(), v2, ttmlNode0.endTimeUs, ttmlStyle0, arr_s, s1, s);
            }
        }
        return TtmlNode.buildNode(xmlPullParser0.getName(), v2, v3, ttmlStyle0, arr_s, s1, s);
    }

    private TtmlRegion parseRegionAttributes(XmlPullParser xmlPullParser0, CellResolution ttmlDecoder$CellResolution0, TtsExtent ttmlDecoder$TtsExtent0) {
        float f5;
        int v3;
        float f4;
        float f3;
        float f2;
        int v1;
        float f1;
        float f;
        String s = XmlPullParserUtil.getAttributeValue(xmlPullParser0, "id");
        if(s == null) {
            return null;
        }
        String s1 = XmlPullParserUtil.getAttributeValue(xmlPullParser0, "origin");
        if(s1 != null) {
            Pattern pattern0 = TtmlDecoder.PERCENTAGE_COORDINATES;
            Matcher matcher0 = pattern0.matcher(s1);
            Pattern pattern1 = TtmlDecoder.PIXEL_COORDINATES;
            Matcher matcher1 = pattern1.matcher(s1);
            if(matcher0.matches()) {
                try {
                    f = Float.parseFloat(matcher0.group(1)) / 100.0f;
                    f1 = Float.parseFloat(matcher0.group(2)) / 100.0f;
                    goto label_27;
                }
                catch(NumberFormatException unused_ex) {
                    Log.w("TtmlDecoder", (s1.length() == 0 ? new String("Ignoring region with malformed origin: ") : "Ignoring region with malformed origin: " + s1));
                    return null;
                }
            }
            if(matcher1.matches()) {
                if(ttmlDecoder$TtsExtent0 == null) {
                    Log.w("TtmlDecoder", (s1.length() == 0 ? new String("Ignoring region with missing tts:extent: ") : "Ignoring region with missing tts:extent: " + s1));
                    return null;
                }
                try {
                    int v = Integer.parseInt(matcher1.group(1));
                    v1 = Integer.parseInt(matcher1.group(2));
                    f2 = ((float)v) / ((float)ttmlDecoder$TtsExtent0.width);
                }
                catch(NumberFormatException unused_ex) {
                    Log.w("TtmlDecoder", (s1.length() == 0 ? new String("Ignoring region with malformed origin: ") : "Ignoring region with malformed origin: " + s1));
                    return null;
                }
                f = f2;
                f1 = ((float)v1) / ((float)ttmlDecoder$TtsExtent0.height);
            label_27:
                String s2 = XmlPullParserUtil.getAttributeValue(xmlPullParser0, "extent");
                if(s2 != null) {
                    Matcher matcher2 = pattern0.matcher(s2);
                    Matcher matcher3 = pattern1.matcher(s2);
                    if(matcher2.matches()) {
                        try {
                            f3 = Float.parseFloat(matcher2.group(1)) / 100.0f;
                            f4 = Float.parseFloat(matcher2.group(2)) / 100.0f;
                            goto label_49;
                        }
                        catch(NumberFormatException unused_ex) {
                            Log.w("TtmlDecoder", (s1.length() == 0 ? new String("Ignoring region with malformed extent: ") : "Ignoring region with malformed extent: " + s1));
                            return null;
                        }
                    }
                    if(matcher3.matches()) {
                        if(ttmlDecoder$TtsExtent0 == null) {
                            Log.w("TtmlDecoder", (s1.length() == 0 ? new String("Ignoring region with missing tts:extent: ") : "Ignoring region with missing tts:extent: " + s1));
                            return null;
                        }
                        try {
                            int v2 = Integer.parseInt(matcher3.group(1));
                            v3 = Integer.parseInt(matcher3.group(2));
                            f5 = ((float)v2) / ((float)ttmlDecoder$TtsExtent0.width);
                        }
                        catch(NumberFormatException unused_ex) {
                            Log.w("TtmlDecoder", (s1.length() == 0 ? new String("Ignoring region with malformed extent: ") : "Ignoring region with malformed extent: " + s1));
                            return null;
                        }
                        f4 = ((float)v3) / ((float)ttmlDecoder$TtsExtent0.height);
                        f3 = f5;
                    label_49:
                        String s3 = XmlPullParserUtil.getAttributeValue(xmlPullParser0, "displayAlign");
                        if(s3 != null) {
                            String s4 = Util.toLowerInvariant(s3);
                            s4.getClass();
                            if(!s4.equals("center")) {
                                return s4.equals("after") ? new TtmlRegion(s, f, f1 + f4, 0, 2, f3, f4, 1, 1.0f / ((float)ttmlDecoder$CellResolution0.rows)) : new TtmlRegion(s, f, f1, 0, 0, f3, f4, 1, 1.0f / ((float)ttmlDecoder$CellResolution0.rows));
                            }
                            return new TtmlRegion(s, f, f1 + f4 / 2.0f, 0, 1, f3, f4, 1, 1.0f / ((float)ttmlDecoder$CellResolution0.rows));
                        }
                        return new TtmlRegion(s, f, f1, 0, 0, f3, f4, 1, 1.0f / ((float)ttmlDecoder$CellResolution0.rows));
                    }
                    Log.w("TtmlDecoder", (s1.length() == 0 ? new String("Ignoring region with unsupported extent: ") : "Ignoring region with unsupported extent: " + s1));
                    return null;
                }
                Log.w("TtmlDecoder", "Ignoring region without an extent");
                return null;
            }
            Log.w("TtmlDecoder", (s1.length() == 0 ? new String("Ignoring region with unsupported origin: ") : "Ignoring region with unsupported origin: " + s1));
            return null;
        }
        Log.w("TtmlDecoder", "Ignoring region without an origin");
        return null;
    }

    // This method was un-flattened
    private TtmlStyle parseStyleAttributes(XmlPullParser xmlPullParser0, TtmlStyle ttmlStyle0) {
        int v = xmlPullParser0.getAttributeCount();
        for(int v1 = 0; v1 < v; ++v1) {
            String s = xmlPullParser0.getAttributeValue(v1);
            String s1 = xmlPullParser0.getAttributeName(v1);
            s1.getClass();
            switch(s1) {
                case "backgroundColor": {
                    ttmlStyle0 = this.createIfNull(ttmlStyle0);
                    try {
                        ttmlStyle0.setBackgroundColor(ColorParser.parseTtmlColor(s));
                    }
                    catch(IllegalArgumentException unused_ex) {
                        String s6 = String.valueOf(s);
                        Log.w("TtmlDecoder", (s6.length() == 0 ? new String("Failed parsing background value: ") : "Failed parsing background value: " + s6));
                    }
                    break;
                }
                case "color": {
                    ttmlStyle0 = this.createIfNull(ttmlStyle0);
                    try {
                        ttmlStyle0.setFontColor(ColorParser.parseTtmlColor(s));
                    }
                    catch(IllegalArgumentException unused_ex) {
                        String s4 = String.valueOf(s);
                        Log.w("TtmlDecoder", (s4.length() == 0 ? new String("Failed parsing color value: ") : "Failed parsing color value: " + s4));
                    }
                    break;
                }
                case "fontFamily": {
                    ttmlStyle0 = this.createIfNull(ttmlStyle0).setFontFamily(s);
                    break;
                }
                case "fontSize": {
                    try {
                        ttmlStyle0 = this.createIfNull(ttmlStyle0);
                        TtmlDecoder.parseFontSize(s, ttmlStyle0);
                    }
                    catch(SubtitleDecoderException unused_ex) {
                        String s5 = String.valueOf(s);
                        Log.w("TtmlDecoder", (s5.length() == 0 ? new String("Failed parsing fontSize value: ") : "Failed parsing fontSize value: " + s5));
                    }
                    break;
                }
                case "fontStyle": {
                    ttmlStyle0 = this.createIfNull(ttmlStyle0).setItalic("italic".equalsIgnoreCase(s));
                    break;
                }
                case "fontWeight": {
                    ttmlStyle0 = this.createIfNull(ttmlStyle0).setBold("bold".equalsIgnoreCase(s));
                    break;
                }
                case "id": {
                    if("style".equals(xmlPullParser0.getName())) {
                        ttmlStyle0 = this.createIfNull(ttmlStyle0).setId(s);
                    }
                    break;
                }
                case "textAlign": {
                    String s2 = Util.toLowerInvariant(s);
                    s2.getClass();
                    switch(s2) {
                        case "center": {
                            ttmlStyle0 = this.createIfNull(ttmlStyle0).setTextAlign(Layout.Alignment.ALIGN_CENTER);
                            break;
                        }
                        case "end": {
                            ttmlStyle0 = this.createIfNull(ttmlStyle0).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            break;
                        }
                        case "left": {
                            ttmlStyle0 = this.createIfNull(ttmlStyle0).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                            break;
                        }
                        case "right": {
                            ttmlStyle0 = this.createIfNull(ttmlStyle0).setTextAlign(Layout.Alignment.ALIGN_OPPOSITE);
                            break;
                        }
                        case "start": {
                            ttmlStyle0 = this.createIfNull(ttmlStyle0).setTextAlign(Layout.Alignment.ALIGN_NORMAL);
                        }
                    }
                    break;
                }
                case "textDecoration": {
                    String s3 = Util.toLowerInvariant(s);
                    s3.getClass();
                    switch(s3) {
                        case "linethrough": {
                            ttmlStyle0 = this.createIfNull(ttmlStyle0).setLinethrough(true);
                            break;
                        }
                        case "nolinethrough": {
                            ttmlStyle0 = this.createIfNull(ttmlStyle0).setLinethrough(false);
                            break;
                        }
                        case "nounderline": {
                            ttmlStyle0 = this.createIfNull(ttmlStyle0).setUnderline(false);
                            break;
                        }
                        case "underline": {
                            ttmlStyle0 = this.createIfNull(ttmlStyle0).setUnderline(true);
                        }
                    }
                }
            }
        }
        return ttmlStyle0;
    }

    private String[] parseStyleIds(String s) {
        String s1 = s.trim();
        return s1.isEmpty() ? new String[0] : Util.split(s1, "\\s+");
    }

    private static long parseTimeExpression(String s, FrameAndTickRate ttmlDecoder$FrameAndTickRate0) {
        Matcher matcher0 = TtmlDecoder.CLOCK_TIME.matcher(s);
        if(matcher0.matches()) {
            double f = ((double)(Long.parseLong(matcher0.group(1)) * 3600L)) + ((double)(Long.parseLong(matcher0.group(2)) * 60L)) + ((double)Long.parseLong(matcher0.group(3)));
            String s1 = matcher0.group(4);
            double f1 = 0.0;
            double f2 = s1 == null ? 0.0 : Double.parseDouble(s1);
            String s2 = matcher0.group(5);
            double f3 = s2 == null ? 0.0 : ((double)(((float)Long.parseLong(s2)) / ttmlDecoder$FrameAndTickRate0.effectiveFrameRate));
            String s3 = matcher0.group(6);
            if(s3 != null) {
                f1 = ((double)Long.parseLong(s3)) / ((double)ttmlDecoder$FrameAndTickRate0.subFrameRate) / ((double)ttmlDecoder$FrameAndTickRate0.effectiveFrameRate);
            }
            return (long)((f + f2 + f3 + f1) * 1000000.0);
        }
        Matcher matcher1 = TtmlDecoder.OFFSET_TIME.matcher(s);
        if(matcher1.matches()) {
            double f4 = Double.parseDouble(matcher1.group(1));
            String s4 = matcher1.group(2);
            s4.getClass();
            switch(s4) {
                case "f": {
                    return (long)(f4 / ((double)ttmlDecoder$FrameAndTickRate0.effectiveFrameRate) * 1000000.0);
                }
                case "h": {
                    return (long)(f4 * 3600000000.0);
                }
                case "m": {
                    return (long)(f4 * 60000000.0);
                }
                case "ms": {
                    return (long)(f4 / 1000.0 * 1000000.0);
                }
                case "t": {
                    return (long)(f4 / ((double)ttmlDecoder$FrameAndTickRate0.tickRate) * 1000000.0);
                }
                default: {
                    return (long)(f4 * 1000000.0);
                }
            }
        }
        String s5 = String.valueOf(s);
        throw new SubtitleDecoderException((s5.length() == 0 ? new String("Malformed time expression: ") : "Malformed time expression: " + s5));
    }

    private TtsExtent parseTtsExtent(XmlPullParser xmlPullParser0) {
        String s = XmlPullParserUtil.getAttributeValue(xmlPullParser0, "extent");
        if(s == null) {
            return null;
        }
        Matcher matcher0 = TtmlDecoder.PIXEL_COORDINATES.matcher(s);
        if(!matcher0.matches()) {
            Log.w("TtmlDecoder", (s.length() == 0 ? new String("Ignoring non-pixel tts extent: ") : "Ignoring non-pixel tts extent: " + s));
            return null;
        }
        try {
            return new TtsExtent(Integer.parseInt(matcher0.group(1)), Integer.parseInt(matcher0.group(2)));
        }
        catch(NumberFormatException unused_ex) {
            Log.w("TtmlDecoder", (s.length() == 0 ? new String("Ignoring malformed tts extent: ") : "Ignoring malformed tts extent: " + s));
            return null;
        }
    }
}

