package com.google.android.exoplayer2.text.ttml;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import java.util.Map;

final class TtmlRenderUtil {
    public static void applyStylesToSpan(SpannableStringBuilder spannableStringBuilder0, int v, int v1, TtmlStyle ttmlStyle0) {
        if(ttmlStyle0.getStyle() != -1) {
            spannableStringBuilder0.setSpan(new StyleSpan(ttmlStyle0.getStyle()), v, v1, 33);
        }
        if(ttmlStyle0.isLinethrough()) {
            spannableStringBuilder0.setSpan(new StrikethroughSpan(), v, v1, 33);
        }
        if(ttmlStyle0.isUnderline()) {
            spannableStringBuilder0.setSpan(new UnderlineSpan(), v, v1, 33);
        }
        if(ttmlStyle0.hasFontColor()) {
            spannableStringBuilder0.setSpan(new ForegroundColorSpan(ttmlStyle0.getFontColor()), v, v1, 33);
        }
        if(ttmlStyle0.hasBackgroundColor()) {
            spannableStringBuilder0.setSpan(new BackgroundColorSpan(ttmlStyle0.getBackgroundColor()), v, v1, 33);
        }
        if(ttmlStyle0.getFontFamily() != null) {
            spannableStringBuilder0.setSpan(new TypefaceSpan(ttmlStyle0.getFontFamily()), v, v1, 33);
        }
        if(ttmlStyle0.getTextAlign() != null) {
            spannableStringBuilder0.setSpan(new AlignmentSpan.Standard(ttmlStyle0.getTextAlign()), v, v1, 33);
        }
        switch(ttmlStyle0.getFontSizeUnit()) {
            case 1: {
                spannableStringBuilder0.setSpan(new AbsoluteSizeSpan(((int)ttmlStyle0.getFontSize()), true), v, v1, 33);
                return;
            }
            case 2: {
                spannableStringBuilder0.setSpan(new RelativeSizeSpan(ttmlStyle0.getFontSize()), v, v1, 33);
                return;
            }
            case 3: {
                spannableStringBuilder0.setSpan(new RelativeSizeSpan(ttmlStyle0.getFontSize() / 100.0f), v, v1, 33);
            }
        }
    }

    public static String applyTextElementSpacePolicy(String s) {
        return s.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void endParagraph(SpannableStringBuilder spannableStringBuilder0) {
        int v;
        for(v = spannableStringBuilder0.length() - 1; v >= 0 && spannableStringBuilder0.charAt(v) == 0x20; --v) {
        }
        if(v >= 0 && spannableStringBuilder0.charAt(v) != 10) {
            spannableStringBuilder0.append('\n');
        }
    }

    public static TtmlStyle resolveStyle(TtmlStyle ttmlStyle0, String[] arr_s, Map map0) {
        int v = 0;
        if(ttmlStyle0 == null && arr_s == null) {
            return null;
        }
        if(ttmlStyle0 == null && arr_s.length == 1) {
            return (TtmlStyle)map0.get(arr_s[0]);
        }
        if(ttmlStyle0 == null && arr_s.length > 1) {
            TtmlStyle ttmlStyle1 = new TtmlStyle();
            while(v < arr_s.length) {
                ttmlStyle1.chain(((TtmlStyle)map0.get(arr_s[v])));
                ++v;
            }
            return ttmlStyle1;
        }
        if(ttmlStyle0 != null && arr_s != null && arr_s.length == 1) {
            return ttmlStyle0.chain(((TtmlStyle)map0.get(arr_s[0])));
        }
        if(ttmlStyle0 != null && arr_s != null && arr_s.length > 1) {
            while(v < arr_s.length) {
                ttmlStyle0.chain(((TtmlStyle)map0.get(arr_s[v])));
                ++v;
            }
        }
        return ttmlStyle0;
    }
}

