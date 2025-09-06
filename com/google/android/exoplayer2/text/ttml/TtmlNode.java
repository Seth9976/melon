package com.google.android.exoplayer2.text.ttml;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

final class TtmlNode {
    public static final String ANONYMOUS_REGION_ID = "";
    public static final String ATTR_ID = "id";
    public static final String ATTR_TTS_BACKGROUND_COLOR = "backgroundColor";
    public static final String ATTR_TTS_COLOR = "color";
    public static final String ATTR_TTS_DISPLAY_ALIGN = "displayAlign";
    public static final String ATTR_TTS_EXTENT = "extent";
    public static final String ATTR_TTS_FONT_FAMILY = "fontFamily";
    public static final String ATTR_TTS_FONT_SIZE = "fontSize";
    public static final String ATTR_TTS_FONT_STYLE = "fontStyle";
    public static final String ATTR_TTS_FONT_WEIGHT = "fontWeight";
    public static final String ATTR_TTS_ORIGIN = "origin";
    public static final String ATTR_TTS_TEXT_ALIGN = "textAlign";
    public static final String ATTR_TTS_TEXT_DECORATION = "textDecoration";
    public static final String BOLD = "bold";
    public static final String CENTER = "center";
    public static final String END = "end";
    public static final String ITALIC = "italic";
    public static final String LEFT = "left";
    public static final String LINETHROUGH = "linethrough";
    public static final String NO_LINETHROUGH = "nolinethrough";
    public static final String NO_UNDERLINE = "nounderline";
    public static final String RIGHT = "right";
    public static final String START = "start";
    public static final String TAG_BODY = "body";
    public static final String TAG_BR = "br";
    public static final String TAG_DATA = "data";
    public static final String TAG_DIV = "div";
    public static final String TAG_HEAD = "head";
    public static final String TAG_IMAGE = "image";
    public static final String TAG_INFORMATION = "information";
    public static final String TAG_LAYOUT = "layout";
    public static final String TAG_METADATA = "metadata";
    public static final String TAG_P = "p";
    public static final String TAG_REGION = "region";
    public static final String TAG_SPAN = "span";
    public static final String TAG_STYLE = "style";
    public static final String TAG_STYLING = "styling";
    public static final String TAG_TT = "tt";
    public static final String UNDERLINE = "underline";
    private List children;
    public final long endTimeUs;
    public final String imageId;
    public final boolean isTextNode;
    private final HashMap nodeEndsByRegion;
    private final HashMap nodeStartsByRegion;
    public final String regionId;
    public final long startTimeUs;
    public final TtmlStyle style;
    private final String[] styleIds;
    public final String tag;
    public final String text;

    private TtmlNode(String s, String s1, long v, long v1, TtmlStyle ttmlStyle0, String[] arr_s, String s2, String s3) {
        this.tag = s;
        this.text = s1;
        this.imageId = s3;
        this.style = ttmlStyle0;
        this.styleIds = arr_s;
        this.isTextNode = s1 != null;
        this.startTimeUs = v;
        this.endTimeUs = v1;
        this.regionId = (String)Assertions.checkNotNull(s2);
        this.nodeStartsByRegion = new HashMap();
        this.nodeEndsByRegion = new HashMap();
    }

    public void addChild(TtmlNode ttmlNode0) {
        if(this.children == null) {
            this.children = new ArrayList();
        }
        this.children.add(ttmlNode0);
    }

    private void applyStyleToOutput(Map map0, SpannableStringBuilder spannableStringBuilder0, int v, int v1) {
        TtmlStyle ttmlStyle0 = TtmlRenderUtil.resolveStyle(this.style, this.styleIds, map0);
        if(ttmlStyle0 != null) {
            TtmlRenderUtil.applyStylesToSpan(spannableStringBuilder0, v, v1, ttmlStyle0);
        }
    }

    public static TtmlNode buildNode(String s, long v, long v1, TtmlStyle ttmlStyle0, String[] arr_s, String s1, String s2) {
        return new TtmlNode(s, null, v, v1, ttmlStyle0, arr_s, s1, s2);
    }

    public static TtmlNode buildTextNode(String s) {
        return new TtmlNode(null, TtmlRenderUtil.applyTextElementSpacePolicy(s), 0x8000000000000001L, 0x8000000000000001L, null, null, "", null);
    }

    private SpannableStringBuilder cleanUpText(SpannableStringBuilder spannableStringBuilder0) {
        int v = spannableStringBuilder0.length();
        for(int v2 = 0; v2 < v; ++v2) {
            if(spannableStringBuilder0.charAt(v2) == 0x20) {
                int v3;
                for(v3 = v2 + 1; v3 < spannableStringBuilder0.length() && spannableStringBuilder0.charAt(v3) == 0x20; ++v3) {
                }
                int v4 = v3 - (v2 + 1);
                if(v4 > 0) {
                    spannableStringBuilder0.delete(v2, v2 + v4);
                    v -= v4;
                }
            }
        }
        if(v > 0 && spannableStringBuilder0.charAt(0) == 0x20) {
            spannableStringBuilder0.delete(0, 1);
            --v;
        }
        for(int v5 = 0; v5 < v - 1; ++v5) {
            if(spannableStringBuilder0.charAt(v5) == 10 && spannableStringBuilder0.charAt(v5 + 1) == 0x20) {
                spannableStringBuilder0.delete(v5 + 1, v5 + 2);
                --v;
            }
        }
        if(v > 0 && spannableStringBuilder0.charAt(v - 1) == 0x20) {
            spannableStringBuilder0.delete(v - 1, v);
            --v;
        }
        for(int v1 = 0; v1 < v - 1; ++v1) {
            if(spannableStringBuilder0.charAt(v1) == 0x20 && spannableStringBuilder0.charAt(v1 + 1) == 10) {
                spannableStringBuilder0.delete(v1, v1 + 1);
                --v;
            }
        }
        if(v > 0 && spannableStringBuilder0.charAt(v - 1) == 10) {
            spannableStringBuilder0.delete(v - 1, v);
        }
        return spannableStringBuilder0;
    }

    public TtmlNode getChild(int v) {
        List list0 = this.children;
        if(list0 == null) {
            throw new IndexOutOfBoundsException();
        }
        return (TtmlNode)list0.get(v);
    }

    public int getChildCount() {
        return this.children == null ? 0 : this.children.size();
    }

    public List getCues(long v, Map map0, Map map1, Map map2) {
        ArrayList arrayList0 = new ArrayList();
        this.traverseForImage(v, this.regionId, arrayList0);
        TreeMap treeMap0 = new TreeMap();
        this.traverseForText(v, false, this.regionId, treeMap0);
        this.traverseForStyle(v, map0, treeMap0);
        List list0 = new ArrayList();
        for(Object object0: arrayList0) {
            Pair pair0 = (Pair)object0;
            String s = (String)map2.get(pair0.second);
            if(s != null) {
                byte[] arr_b = Base64.decode(s, 0);
                Bitmap bitmap0 = BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length);
                TtmlRegion ttmlRegion0 = (TtmlRegion)map1.get(pair0.first);
                ((ArrayList)list0).add(new Cue(bitmap0, ttmlRegion0.position, 0, ttmlRegion0.line, ttmlRegion0.lineAnchor, ttmlRegion0.width, ttmlRegion0.height));
            }
        }
        for(Object object1: treeMap0.entrySet()) {
            TtmlRegion ttmlRegion1 = (TtmlRegion)map1.get(((Map.Entry)object1).getKey());
            ((ArrayList)list0).add(new Cue(this.cleanUpText(((SpannableStringBuilder)((Map.Entry)object1).getValue())), null, ttmlRegion1.line, ttmlRegion1.lineType, ttmlRegion1.lineAnchor, ttmlRegion1.position, 0x80000000, ttmlRegion1.width, ttmlRegion1.textSizeType, ttmlRegion1.textSize));
        }
        return list0;
    }

    private void getEventTimes(TreeSet treeSet0, boolean z) {
        boolean z1 = "p".equals(this.tag);
        if(z || z1 || "div".equals(this.tag) && this.imageId != null) {
            long v = this.startTimeUs;
            if(v != 0x8000000000000001L) {
                treeSet0.add(v);
            }
            long v1 = this.endTimeUs;
            if(v1 != 0x8000000000000001L) {
                treeSet0.add(v1);
            }
        }
        if(this.children != null) {
            for(int v2 = 0; v2 < this.children.size(); ++v2) {
                ((TtmlNode)this.children.get(v2)).getEventTimes(treeSet0, z || z1);
            }
        }
    }

    public long[] getEventTimesUs() {
        TreeSet treeSet0 = new TreeSet();
        int v = 0;
        this.getEventTimes(treeSet0, false);
        long[] arr_v = new long[treeSet0.size()];
        for(Object object0: treeSet0) {
            arr_v[v] = (long)(((Long)object0));
            ++v;
        }
        return arr_v;
    }

    private static SpannableStringBuilder getRegionOutput(String s, Map map0) {
        if(!map0.containsKey(s)) {
            map0.put(s, new SpannableStringBuilder());
        }
        return (SpannableStringBuilder)map0.get(s);
    }

    public String[] getStyleIds() {
        return this.styleIds;
    }

    // 去混淆评级： 低(40)
    public boolean isActive(long v) {
        return this.startTimeUs == 0x8000000000000001L && this.endTimeUs == 0x8000000000000001L || this.startTimeUs <= v && this.endTimeUs == 0x8000000000000001L || this.startTimeUs == 0x8000000000000001L && v < this.endTimeUs || this.startTimeUs <= v && v < this.endTimeUs;
    }

    private void traverseForImage(long v, String s, List list0) {
        if(!"".equals(this.regionId)) {
            s = this.regionId;
        }
        if(this.isActive(v) && "div".equals(this.tag) && this.imageId != null) {
            list0.add(new Pair(s, this.imageId));
            return;
        }
        for(int v1 = 0; v1 < this.getChildCount(); ++v1) {
            this.getChild(v1).traverseForImage(v, s, list0);
        }
    }

    private void traverseForStyle(long v, Map map0, Map map1) {
        int v1;
        if(this.isActive(v)) {
            Iterator iterator0 = this.nodeEndsByRegion.entrySet().iterator();
            while(true) {
                v1 = 0;
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object0 = iterator0.next();
                String s = (String)((Map.Entry)object0).getKey();
                if(this.nodeStartsByRegion.containsKey(s)) {
                    v1 = (int)(((Integer)this.nodeStartsByRegion.get(s)));
                }
                int v2 = (int)(((Integer)((Map.Entry)object0).getValue()));
                if(v1 != v2) {
                    this.applyStyleToOutput(map0, ((SpannableStringBuilder)map1.get(s)), v1, v2);
                }
            }
            while(v1 < this.getChildCount()) {
                this.getChild(v1).traverseForStyle(v, map0, map1);
                ++v1;
            }
        }
    }

    private void traverseForText(long v, boolean z, String s, Map map0) {
        long v2;
        boolean z2;
        this.nodeStartsByRegion.clear();
        this.nodeEndsByRegion.clear();
        if(!"metadata".equals(this.tag)) {
            if(!"".equals(this.regionId)) {
                s = this.regionId;
            }
            if(this.isTextNode && z) {
                TtmlNode.getRegionOutput(s, map0).append(this.text);
                return;
            }
            if("br".equals(this.tag) && z) {
                TtmlNode.getRegionOutput(s, map0).append('\n');
                return;
            }
            if(this.isActive(v)) {
                for(Object object0: map0.entrySet()) {
                    String s1 = (String)((Map.Entry)object0).getKey();
                    Integer integer0 = ((SpannableStringBuilder)((Map.Entry)object0).getValue()).length();
                    this.nodeStartsByRegion.put(s1, integer0);
                }
                boolean z1 = "p".equals(this.tag);
                int v1 = 0;
                while(v1 < this.getChildCount()) {
                    TtmlNode ttmlNode0 = this.getChild(v1);
                    z2 = z || z1;
                    v2 = v;
                    ttmlNode0.traverseForText(v2, z2, s, map0);
                    ++v1;
                    v = v2;
                }
                if(z1) {
                    TtmlRenderUtil.endParagraph(TtmlNode.getRegionOutput(s, map0));
                }
                for(Object object1: map0.entrySet()) {
                    String s2 = (String)((Map.Entry)object1).getKey();
                    Integer integer1 = ((SpannableStringBuilder)((Map.Entry)object1).getValue()).length();
                    this.nodeEndsByRegion.put(s2, integer1);
                }
            }
        }
    }
}

