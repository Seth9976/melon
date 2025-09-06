package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import b3.Z;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ColorParser {
    private static final Map COLOR_MAP = null;
    private static final String RGB = "rgb";
    private static final String RGBA = "rgba";
    private static final Pattern RGBA_PATTERN_FLOAT_ALPHA;
    private static final Pattern RGBA_PATTERN_INT_ALPHA;
    private static final Pattern RGB_PATTERN;

    static {
        ColorParser.RGB_PATTERN = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        ColorParser.RGBA_PATTERN_INT_ALPHA = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        ColorParser.RGBA_PATTERN_FLOAT_ALPHA = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap0 = new HashMap();
        ColorParser.COLOR_MAP = hashMap0;
        Z.t(0xFFF0F8FF, hashMap0, "aliceblue", 0xFFFAEBD7, "antiquewhite");
        hashMap0.put("aqua", 0xFF00FFFF);
        hashMap0.put("aquamarine", 0xFF7FFFD4);
        Z.t(0xFFF0FFFF, hashMap0, "azure", 0xFFF5F5DC, "beige");
        Z.t(-6972, hashMap0, "bisque", 0xFF000000, "black");
        Z.t(-5171, hashMap0, "blanchedalmond", 0xFF0000FF, "blue");
        Z.t(-7722014, hashMap0, "blueviolet", 0xFFA52A2A, "brown");
        Z.t(-2180985, hashMap0, "burlywood", 0xFF5F9EA0, "cadetblue");
        Z.t(0xFF7FFF00, hashMap0, "chartreuse", 0xFFD2691E, "chocolate");
        Z.t(0xFFFF7F50, hashMap0, "coral", -10185235, "cornflowerblue");
        Z.t(0xFFFFF8DC, hashMap0, "cornsilk", 0xFFDC143C, "crimson");
        hashMap0.put("cyan", 0xFF00FFFF);
        hashMap0.put("darkblue", 0xFF00008B);
        Z.t(0xFF008B8B, hashMap0, "darkcyan", 0xFFB8860B, "darkgoldenrod");
        hashMap0.put("darkgray", 0xFFA9A9A9);
        hashMap0.put("darkgreen", 0xFF006400);
        hashMap0.put("darkgrey", 0xFFA9A9A9);
        hashMap0.put("darkkhaki", 0xFFBDB76B);
        Z.t(0xFF8B008B, hashMap0, "darkmagenta", 0xFF556B2F, "darkolivegreen");
        Z.t(0xFFFF8C00, hashMap0, "darkorange", -6737204, "darkorchid");
        Z.t(0xFF8B0000, hashMap0, "darkred", -1468806, "darksalmon");
        Z.t(0xFF8FBC8F, hashMap0, "darkseagreen", -12042869, "darkslateblue");
        hashMap0.put("darkslategray", 0xFF2F4F4F);
        hashMap0.put("darkslategrey", 0xFF2F4F4F);
        hashMap0.put("darkturquoise", 0xFF00CED1);
        hashMap0.put("darkviolet", 0xFF9400D3);
        Z.t(-60269, hashMap0, "deeppink", 0xFF00BFFF, "deepskyblue");
        hashMap0.put("dimgray", 0xFF696969);
        hashMap0.put("dimgrey", 0xFF696969);
        hashMap0.put("dodgerblue", 0xFF1E90FF);
        hashMap0.put("firebrick", -5103070);
        Z.t(0xFFFFFAF0, hashMap0, "floralwhite", 0xFF228B22, "forestgreen");
        hashMap0.put("fuchsia", 0xFFFF00FF);
        hashMap0.put("gainsboro", -2302756);
        Z.t(0xFFF8F8FF, hashMap0, "ghostwhite", 0xFFFFD700, "gold");
        hashMap0.put("goldenrod", 0xFFDAA520);
        hashMap0.put("gray", 0xFF808080);
        Z.t(0xFF008000, hashMap0, "green", 0xFFADFF2F, "greenyellow");
        hashMap0.put("grey", 0xFF808080);
        hashMap0.put("honeydew", 0xFFF0FFF0);
        Z.t(0xFFFF69B4, hashMap0, "hotpink", 0xFFCD5C5C, "indianred");
        Z.t(0xFF4B0082, hashMap0, "indigo", -16, "ivory");
        Z.t(0xFFF0E68C, hashMap0, "khaki", 0xFFE6E6FA, "lavender");
        Z.t(0xFFFFF0F5, hashMap0, "lavenderblush", 0xFF7CFC00, "lawngreen");
        Z.t(0xFFFFFACD, hashMap0, "lemonchiffon", 0xFFADD8E6, "lightblue");
        Z.t(0xFFF08080, hashMap0, "lightcoral", 0xFFE0FFFF, "lightcyan");
        hashMap0.put("lightgoldenrodyellow", -329006);
        hashMap0.put("lightgray", 0xFFD3D3D3);
        hashMap0.put("lightgreen", 0xFF90EE90);
        hashMap0.put("lightgrey", 0xFFD3D3D3);
        Z.t(0xFFFFB6C1, hashMap0, "lightpink", 0xFFFFA07A, "lightsalmon");
        Z.t(0xFF20B2AA, hashMap0, "lightseagreen", 0xFF87CEFA, "lightskyblue");
        hashMap0.put("lightslategray", 0xFF778899);
        hashMap0.put("lightslategrey", 0xFF778899);
        hashMap0.put("lightsteelblue", 0xFFB0C4DE);
        hashMap0.put("lightyellow", 0xFFFFFFE0);
        Z.t(0xFF00FF00, hashMap0, "lime", 0xFF32CD32, "limegreen");
        hashMap0.put("linen", 0xFFFAF0E6);
        hashMap0.put("magenta", 0xFFFF00FF);
        Z.t(0xFF800000, hashMap0, "maroon", -10039894, "mediumaquamarine");
        Z.t(0xFF0000CD, hashMap0, "mediumblue", 0xFFBA55D3, "mediumorchid");
        Z.t(0xFF9370DB, hashMap0, "mediumpurple", 0xFF3CB371, "mediumseagreen");
        Z.t(0xFF7B68EE, hashMap0, "mediumslateblue", 0xFF00FA9A, "mediumspringgreen");
        Z.t(-12004916, hashMap0, "mediumturquoise", -3730043, "mediumvioletred");
        Z.t(0xFF191970, hashMap0, "midnightblue", 0xFFF5FFFA, "mintcream");
        Z.t(0xFFFFE4E1, hashMap0, "mistyrose", -6987, "moccasin");
        Z.t(-8531, hashMap0, "navajowhite", 0xFF000080, "navy");
        Z.t(0xFFFDF5E6, hashMap0, "oldlace", 0xFF808000, "olive");
        Z.t(0xFF6B8E23, hashMap0, "olivedrab", 0xFFFFA500, "orange");
        Z.t(0xFFFF4500, hashMap0, "orangered", 0xFFDA70D6, "orchid");
        Z.t(-1120086, hashMap0, "palegoldenrod", 0xFF98FB98, "palegreen");
        Z.t(0xFFAFEEEE, hashMap0, "paleturquoise", 0xFFDB7093, "palevioletred");
        Z.t(0xFFFFEFD5, hashMap0, "papayawhip", -9543, "peachpuff");
        Z.t(-3308225, hashMap0, "peru", 0xFFFFC0CB, "pink");
        Z.t(0xFFDDA0DD, hashMap0, "plum", 0xFFB0E0E6, "powderblue");
        Z.t(0xFF800080, hashMap0, "purple", -10079335, "rebeccapurple");
        Z.t(0xFFFF0000, hashMap0, "red", 0xFFBC8F8F, "rosybrown");
        Z.t(0xFF4169E1, hashMap0, "royalblue", -7650029, "saddlebrown");
        Z.t(0xFFFA8072, hashMap0, "salmon", 0xFFF4A460, "sandybrown");
        Z.t(0xFF2E8B57, hashMap0, "seagreen", 0xFFFFF5EE, "seashell");
        Z.t(0xFFA0522D, hashMap0, "sienna", 0xFFC0C0C0, "silver");
        Z.t(0xFF87CEEB, hashMap0, "skyblue", -9807155, "slateblue");
        hashMap0.put("slategray", 0xFF708090);
        hashMap0.put("slategrey", 0xFF708090);
        hashMap0.put("snow", 0xFFFFFAFA);
        hashMap0.put("springgreen", 0xFF00FF7F);
        Z.t(0xFF4682B4, hashMap0, "steelblue", 0xFFD2B48C, "tan");
        Z.t(0xFF008080, hashMap0, "teal", 0xFFD8BFD8, "thistle");
        Z.t(-40121, hashMap0, "tomato", 0, "transparent");
        Z.t(0xFF40E0D0, hashMap0, "turquoise", -1146130, "violet");
        Z.t(0xFFF5DEB3, hashMap0, "wheat", -1, "white");
        Z.t(0xFFF5F5F5, hashMap0, "whitesmoke", 0xFFFFFF00, "yellow");
        hashMap0.put("yellowgreen", 0xFF9ACD32);
    }

    private static int argb(int v, int v1, int v2, int v3) [...] // Inlined contents

    private static int parseColorInternal(String s, boolean z) {
        Assertions.checkArgument(!TextUtils.isEmpty(s));
        String s1 = s.replace(" ", "");
        if(s1.charAt(0) == 35) {
            int v = (int)Long.parseLong(s1.substring(1), 16);
            if(s1.length() == 7) {
                return 0xFF000000 | v;
            }
            if(s1.length() != 9) {
                throw new IllegalArgumentException();
            }
            return (v & 0xFF) << 24 | v >>> 8;
        }
        if(s1.startsWith("rgba")) {
            Matcher matcher0 = (z ? ColorParser.RGBA_PATTERN_FLOAT_ALPHA : ColorParser.RGBA_PATTERN_INT_ALPHA).matcher(s1);
            if(matcher0.matches()) {
                return z ? ColorParser.argb(((int)(Float.parseFloat(matcher0.group(4)) * 255.0f)), Integer.parseInt(matcher0.group(1), 10), Integer.parseInt(matcher0.group(2), 10), Integer.parseInt(matcher0.group(3), 10)) : ColorParser.argb(Integer.parseInt(matcher0.group(4), 10), Integer.parseInt(matcher0.group(1), 10), Integer.parseInt(matcher0.group(2), 10), Integer.parseInt(matcher0.group(3), 10));
            }
        }
        else if(s1.startsWith("rgb")) {
            Matcher matcher1 = ColorParser.RGB_PATTERN.matcher(s1);
            if(matcher1.matches()) {
                return ColorParser.rgb(Integer.parseInt(matcher1.group(1), 10), Integer.parseInt(matcher1.group(2), 10), Integer.parseInt(matcher1.group(3), 10));
            }
        }
        else {
            String s2 = Util.toLowerInvariant(s1);
            Integer integer0 = (Integer)ColorParser.COLOR_MAP.get(s2);
            if(integer0 != null) {
                return (int)integer0;
            }
        }
        throw new IllegalArgumentException();
    }

    public static int parseCssColor(String s) {
        return ColorParser.parseColorInternal(s, true);
    }

    public static int parseTtmlColor(String s) {
        return ColorParser.parseColorInternal(s, false);
    }

    private static int rgb(int v, int v1, int v2) {
        return 0xFF000000 | v << 16 | v1 << 8 | v2;
    }
}

