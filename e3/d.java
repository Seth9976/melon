package e3;

import android.graphics.Color;
import android.text.TextUtils;
import com.iloen.melon.utils.a;
import h7.u0;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class d {
    public static final Pattern a;
    public static final Pattern b;
    public static final Pattern c;
    public static final HashMap d;

    static {
        d.a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        d.b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        d.c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap0 = new HashMap();
        d.d = hashMap0;
        A7.d.r(0xFFF0F8FF, hashMap0, "aliceblue", 0xFFFAEBD7, "antiquewhite");
        a.x(hashMap0, "aqua", 0xFF00FFFF, 0xFF7FFFD4, "aquamarine");
        A7.d.r(0xFFF0FFFF, hashMap0, "azure", 0xFFF5F5DC, "beige");
        A7.d.r(-6972, hashMap0, "bisque", 0xFF000000, "black");
        A7.d.r(-5171, hashMap0, "blanchedalmond", 0xFF0000FF, "blue");
        A7.d.r(-7722014, hashMap0, "blueviolet", 0xFFA52A2A, "brown");
        A7.d.r(-2180985, hashMap0, "burlywood", 0xFF5F9EA0, "cadetblue");
        A7.d.r(0xFF7FFF00, hashMap0, "chartreuse", 0xFFD2691E, "chocolate");
        A7.d.r(0xFFFF7F50, hashMap0, "coral", -10185235, "cornflowerblue");
        A7.d.r(0xFFFFF8DC, hashMap0, "cornsilk", 0xFFDC143C, "crimson");
        a.x(hashMap0, "cyan", 0xFF00FFFF, 0xFF00008B, "darkblue");
        A7.d.r(0xFF008B8B, hashMap0, "darkcyan", 0xFFB8860B, "darkgoldenrod");
        a.x(hashMap0, "darkgray", 0xFFA9A9A9, 0xFF006400, "darkgreen");
        a.x(hashMap0, "darkgrey", 0xFFA9A9A9, 0xFFBDB76B, "darkkhaki");
        A7.d.r(0xFF8B008B, hashMap0, "darkmagenta", 0xFF556B2F, "darkolivegreen");
        A7.d.r(0xFFFF8C00, hashMap0, "darkorange", -6737204, "darkorchid");
        A7.d.r(0xFF8B0000, hashMap0, "darkred", -1468806, "darksalmon");
        A7.d.r(0xFF8FBC8F, hashMap0, "darkseagreen", -12042869, "darkslateblue");
        hashMap0.put("darkslategray", 0xFF2F4F4F);
        hashMap0.put("darkslategrey", 0xFF2F4F4F);
        a.x(hashMap0, "darkturquoise", 0xFF00CED1, 0xFF9400D3, "darkviolet");
        A7.d.r(-60269, hashMap0, "deeppink", 0xFF00BFFF, "deepskyblue");
        hashMap0.put("dimgray", 0xFF696969);
        hashMap0.put("dimgrey", 0xFF696969);
        a.x(hashMap0, "dodgerblue", 0xFF1E90FF, -5103070, "firebrick");
        A7.d.r(0xFFFFFAF0, hashMap0, "floralwhite", 0xFF228B22, "forestgreen");
        a.x(hashMap0, "fuchsia", 0xFFFF00FF, -2302756, "gainsboro");
        A7.d.r(0xFFF8F8FF, hashMap0, "ghostwhite", 0xFFFFD700, "gold");
        hashMap0.put("goldenrod", 0xFFDAA520);
        hashMap0.put("gray", 0xFF808080);
        A7.d.r(0xFF008000, hashMap0, "green", 0xFFADFF2F, "greenyellow");
        a.x(hashMap0, "grey", 0xFF808080, 0xFFF0FFF0, "honeydew");
        A7.d.r(0xFFFF69B4, hashMap0, "hotpink", 0xFFCD5C5C, "indianred");
        A7.d.r(0xFF4B0082, hashMap0, "indigo", -16, "ivory");
        A7.d.r(0xFFF0E68C, hashMap0, "khaki", 0xFFE6E6FA, "lavender");
        A7.d.r(0xFFFFF0F5, hashMap0, "lavenderblush", 0xFF7CFC00, "lawngreen");
        A7.d.r(0xFFFFFACD, hashMap0, "lemonchiffon", 0xFFADD8E6, "lightblue");
        A7.d.r(0xFFF08080, hashMap0, "lightcoral", 0xFFE0FFFF, "lightcyan");
        hashMap0.put("lightgoldenrodyellow", -329006);
        hashMap0.put("lightgray", 0xFFD3D3D3);
        hashMap0.put("lightgreen", 0xFF90EE90);
        hashMap0.put("lightgrey", 0xFFD3D3D3);
        A7.d.r(0xFFFFB6C1, hashMap0, "lightpink", 0xFFFFA07A, "lightsalmon");
        A7.d.r(0xFF20B2AA, hashMap0, "lightseagreen", 0xFF87CEFA, "lightskyblue");
        hashMap0.put("lightslategray", 0xFF778899);
        hashMap0.put("lightslategrey", 0xFF778899);
        a.x(hashMap0, "lightsteelblue", 0xFFB0C4DE, 0xFFFFFFE0, "lightyellow");
        A7.d.r(0xFF00FF00, hashMap0, "lime", 0xFF32CD32, "limegreen");
        hashMap0.put("linen", 0xFFFAF0E6);
        hashMap0.put("magenta", 0xFFFF00FF);
        A7.d.r(0xFF800000, hashMap0, "maroon", -10039894, "mediumaquamarine");
        A7.d.r(0xFF0000CD, hashMap0, "mediumblue", 0xFFBA55D3, "mediumorchid");
        A7.d.r(0xFF9370DB, hashMap0, "mediumpurple", 0xFF3CB371, "mediumseagreen");
        A7.d.r(0xFF7B68EE, hashMap0, "mediumslateblue", 0xFF00FA9A, "mediumspringgreen");
        A7.d.r(-12004916, hashMap0, "mediumturquoise", -3730043, "mediumvioletred");
        A7.d.r(0xFF191970, hashMap0, "midnightblue", 0xFFF5FFFA, "mintcream");
        A7.d.r(0xFFFFE4E1, hashMap0, "mistyrose", -6987, "moccasin");
        A7.d.r(-8531, hashMap0, "navajowhite", 0xFF000080, "navy");
        A7.d.r(0xFFFDF5E6, hashMap0, "oldlace", 0xFF808000, "olive");
        A7.d.r(0xFF6B8E23, hashMap0, "olivedrab", 0xFFFFA500, "orange");
        A7.d.r(0xFFFF4500, hashMap0, "orangered", 0xFFDA70D6, "orchid");
        A7.d.r(-1120086, hashMap0, "palegoldenrod", 0xFF98FB98, "palegreen");
        A7.d.r(0xFFAFEEEE, hashMap0, "paleturquoise", 0xFFDB7093, "palevioletred");
        A7.d.r(0xFFFFEFD5, hashMap0, "papayawhip", -9543, "peachpuff");
        A7.d.r(-3308225, hashMap0, "peru", 0xFFFFC0CB, "pink");
        A7.d.r(0xFFDDA0DD, hashMap0, "plum", 0xFFB0E0E6, "powderblue");
        A7.d.r(0xFF800080, hashMap0, "purple", -10079335, "rebeccapurple");
        A7.d.r(0xFFFF0000, hashMap0, "red", 0xFFBC8F8F, "rosybrown");
        A7.d.r(0xFF4169E1, hashMap0, "royalblue", -7650029, "saddlebrown");
        A7.d.r(0xFFFA8072, hashMap0, "salmon", 0xFFF4A460, "sandybrown");
        A7.d.r(0xFF2E8B57, hashMap0, "seagreen", 0xFFFFF5EE, "seashell");
        A7.d.r(0xFFA0522D, hashMap0, "sienna", 0xFFC0C0C0, "silver");
        A7.d.r(0xFF87CEEB, hashMap0, "skyblue", -9807155, "slateblue");
        hashMap0.put("slategray", 0xFF708090);
        hashMap0.put("slategrey", 0xFF708090);
        a.x(hashMap0, "snow", 0xFFFFFAFA, 0xFF00FF7F, "springgreen");
        A7.d.r(0xFF4682B4, hashMap0, "steelblue", 0xFFD2B48C, "tan");
        A7.d.r(0xFF008080, hashMap0, "teal", 0xFFD8BFD8, "thistle");
        A7.d.r(-40121, hashMap0, "tomato", 0, "transparent");
        A7.d.r(0xFF40E0D0, hashMap0, "turquoise", -1146130, "violet");
        A7.d.r(0xFFF5DEB3, hashMap0, "wheat", -1, "white");
        A7.d.r(0xFFF5F5F5, hashMap0, "whitesmoke", 0xFFFFFF00, "yellow");
        hashMap0.put("yellowgreen", 0xFF9ACD32);
    }

    public static int a(String s, boolean z) {
        int v1;
        b.c(!TextUtils.isEmpty(s));
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
            Matcher matcher0 = (z ? d.c : d.b).matcher(s1);
            if(matcher0.matches()) {
                if(z) {
                    String s2 = matcher0.group(4);
                    s2.getClass();
                    v1 = (int)(Float.parseFloat(s2) * 255.0f);
                }
                else {
                    String s3 = matcher0.group(4);
                    s3.getClass();
                    v1 = Integer.parseInt(s3, 10);
                }
                String s4 = matcher0.group(1);
                s4.getClass();
                int v2 = Integer.parseInt(s4, 10);
                String s5 = matcher0.group(2);
                s5.getClass();
                int v3 = Integer.parseInt(s5, 10);
                String s6 = matcher0.group(3);
                s6.getClass();
                return Color.argb(v1, v2, v3, Integer.parseInt(s6, 10));
            }
        }
        else if(s1.startsWith("rgb")) {
            Matcher matcher1 = d.a.matcher(s1);
            if(matcher1.matches()) {
                String s7 = matcher1.group(1);
                s7.getClass();
                int v4 = Integer.parseInt(s7, 10);
                String s8 = matcher1.group(2);
                s8.getClass();
                int v5 = Integer.parseInt(s8, 10);
                String s9 = matcher1.group(3);
                s9.getClass();
                return Color.rgb(v4, v5, Integer.parseInt(s9, 10));
            }
        }
        else {
            String s10 = u0.U(s1);
            Integer integer0 = (Integer)d.d.get(s10);
            if(integer0 != null) {
                return (int)integer0;
            }
        }
        throw new IllegalArgumentException();
    }
}

