package i.n.i.b.a.s.e;

import A7.d;
import android.graphics.Color;
import android.text.TextUtils;
import com.iloen.melon.utils.a;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class G0 {
    public static final Pattern a;
    public static final Pattern b;
    public static final Pattern c;
    public static final HashMap d;

    static {
        G0.a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        G0.b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        G0.c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap0 = new HashMap();
        G0.d = hashMap0;
        d.r(0xFFF0F8FF, hashMap0, "aliceblue", 0xFFFAEBD7, "antiquewhite");
        a.x(hashMap0, "aqua", 0xFF00FFFF, 0xFF7FFFD4, "aquamarine");
        d.r(0xFFF0FFFF, hashMap0, "azure", 0xFFF5F5DC, "beige");
        d.r(-6972, hashMap0, "bisque", 0xFF000000, "black");
        d.r(-5171, hashMap0, "blanchedalmond", 0xFF0000FF, "blue");
        d.r(-7722014, hashMap0, "blueviolet", 0xFFA52A2A, "brown");
        d.r(-2180985, hashMap0, "burlywood", 0xFF5F9EA0, "cadetblue");
        d.r(0xFF7FFF00, hashMap0, "chartreuse", 0xFFD2691E, "chocolate");
        d.r(0xFFFF7F50, hashMap0, "coral", -10185235, "cornflowerblue");
        d.r(0xFFFFF8DC, hashMap0, "cornsilk", 0xFFDC143C, "crimson");
        a.x(hashMap0, "cyan", 0xFF00FFFF, 0xFF00008B, "darkblue");
        d.r(0xFF008B8B, hashMap0, "darkcyan", 0xFFB8860B, "darkgoldenrod");
        a.x(hashMap0, "darkgray", 0xFFA9A9A9, 0xFF006400, "darkgreen");
        a.x(hashMap0, "darkgrey", 0xFFA9A9A9, 0xFFBDB76B, "darkkhaki");
        d.r(0xFF8B008B, hashMap0, "darkmagenta", 0xFF556B2F, "darkolivegreen");
        d.r(0xFFFF8C00, hashMap0, "darkorange", -6737204, "darkorchid");
        d.r(0xFF8B0000, hashMap0, "darkred", -1468806, "darksalmon");
        d.r(0xFF8FBC8F, hashMap0, "darkseagreen", -12042869, "darkslateblue");
        hashMap0.put("darkslategray", 0xFF2F4F4F);
        hashMap0.put("darkslategrey", 0xFF2F4F4F);
        a.x(hashMap0, "darkturquoise", 0xFF00CED1, 0xFF9400D3, "darkviolet");
        d.r(-60269, hashMap0, "deeppink", 0xFF00BFFF, "deepskyblue");
        hashMap0.put("dimgray", 0xFF696969);
        hashMap0.put("dimgrey", 0xFF696969);
        a.x(hashMap0, "dodgerblue", 0xFF1E90FF, -5103070, "firebrick");
        d.r(0xFFFFFAF0, hashMap0, "floralwhite", 0xFF228B22, "forestgreen");
        a.x(hashMap0, "fuchsia", 0xFFFF00FF, -2302756, "gainsboro");
        d.r(0xFFF8F8FF, hashMap0, "ghostwhite", 0xFFFFD700, "gold");
        hashMap0.put("goldenrod", 0xFFDAA520);
        hashMap0.put("gray", 0xFF808080);
        d.r(0xFF008000, hashMap0, "green", 0xFFADFF2F, "greenyellow");
        a.x(hashMap0, "grey", 0xFF808080, 0xFFF0FFF0, "honeydew");
        d.r(0xFFFF69B4, hashMap0, "hotpink", 0xFFCD5C5C, "indianred");
        d.r(0xFF4B0082, hashMap0, "indigo", -16, "ivory");
        d.r(0xFFF0E68C, hashMap0, "khaki", 0xFFE6E6FA, "lavender");
        d.r(0xFFFFF0F5, hashMap0, "lavenderblush", 0xFF7CFC00, "lawngreen");
        d.r(0xFFFFFACD, hashMap0, "lemonchiffon", 0xFFADD8E6, "lightblue");
        d.r(0xFFF08080, hashMap0, "lightcoral", 0xFFE0FFFF, "lightcyan");
        hashMap0.put("lightgoldenrodyellow", -329006);
        hashMap0.put("lightgray", 0xFFD3D3D3);
        hashMap0.put("lightgreen", 0xFF90EE90);
        hashMap0.put("lightgrey", 0xFFD3D3D3);
        d.r(0xFFFFB6C1, hashMap0, "lightpink", 0xFFFFA07A, "lightsalmon");
        d.r(0xFF20B2AA, hashMap0, "lightseagreen", 0xFF87CEFA, "lightskyblue");
        hashMap0.put("lightslategray", 0xFF778899);
        hashMap0.put("lightslategrey", 0xFF778899);
        a.x(hashMap0, "lightsteelblue", 0xFFB0C4DE, 0xFFFFFFE0, "lightyellow");
        d.r(0xFF00FF00, hashMap0, "lime", 0xFF32CD32, "limegreen");
        hashMap0.put("linen", 0xFFFAF0E6);
        hashMap0.put("magenta", 0xFFFF00FF);
        d.r(0xFF800000, hashMap0, "maroon", -10039894, "mediumaquamarine");
        d.r(0xFF0000CD, hashMap0, "mediumblue", 0xFFBA55D3, "mediumorchid");
        d.r(0xFF9370DB, hashMap0, "mediumpurple", 0xFF3CB371, "mediumseagreen");
        d.r(0xFF7B68EE, hashMap0, "mediumslateblue", 0xFF00FA9A, "mediumspringgreen");
        d.r(-12004916, hashMap0, "mediumturquoise", -3730043, "mediumvioletred");
        d.r(0xFF191970, hashMap0, "midnightblue", 0xFFF5FFFA, "mintcream");
        d.r(0xFFFFE4E1, hashMap0, "mistyrose", -6987, "moccasin");
        d.r(-8531, hashMap0, "navajowhite", 0xFF000080, "navy");
        d.r(0xFFFDF5E6, hashMap0, "oldlace", 0xFF808000, "olive");
        d.r(0xFF6B8E23, hashMap0, "olivedrab", 0xFFFFA500, "orange");
        d.r(0xFFFF4500, hashMap0, "orangered", 0xFFDA70D6, "orchid");
        d.r(-1120086, hashMap0, "palegoldenrod", 0xFF98FB98, "palegreen");
        d.r(0xFFAFEEEE, hashMap0, "paleturquoise", 0xFFDB7093, "palevioletred");
        d.r(0xFFFFEFD5, hashMap0, "papayawhip", -9543, "peachpuff");
        d.r(-3308225, hashMap0, "peru", 0xFFFFC0CB, "pink");
        d.r(0xFFDDA0DD, hashMap0, "plum", 0xFFB0E0E6, "powderblue");
        d.r(0xFF800080, hashMap0, "purple", -10079335, "rebeccapurple");
        d.r(0xFFFF0000, hashMap0, "red", 0xFFBC8F8F, "rosybrown");
        d.r(0xFF4169E1, hashMap0, "royalblue", -7650029, "saddlebrown");
        d.r(0xFFFA8072, hashMap0, "salmon", 0xFFF4A460, "sandybrown");
        d.r(0xFF2E8B57, hashMap0, "seagreen", 0xFFFFF5EE, "seashell");
        d.r(0xFFA0522D, hashMap0, "sienna", 0xFFC0C0C0, "silver");
        d.r(0xFF87CEEB, hashMap0, "skyblue", -9807155, "slateblue");
        hashMap0.put("slategray", 0xFF708090);
        hashMap0.put("slategrey", 0xFF708090);
        a.x(hashMap0, "snow", 0xFFFFFAFA, 0xFF00FF7F, "springgreen");
        d.r(0xFF4682B4, hashMap0, "steelblue", 0xFFD2B48C, "tan");
        d.r(0xFF008080, hashMap0, "teal", 0xFFD8BFD8, "thistle");
        d.r(-40121, hashMap0, "tomato", 0, "transparent");
        d.r(0xFF40E0D0, hashMap0, "turquoise", -1146130, "violet");
        d.r(0xFFF5DEB3, hashMap0, "wheat", -1, "white");
        d.r(0xFFF5F5F5, hashMap0, "whitesmoke", 0xFFFFFF00, "yellow");
        hashMap0.put("yellowgreen", 0xFF9ACD32);
    }

    public static int a(String s, boolean z) {
        int v1;
        M7.u(!TextUtils.isEmpty(s));
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
            Matcher matcher0 = (z ? G0.c : G0.b).matcher(s1);
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
            Matcher matcher1 = G0.a.matcher(s1);
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
            String s10 = M7.j(s1);
            Integer integer0 = (Integer)G0.d.get(s10);
            if(integer0 != null) {
                return (int)integer0;
            }
        }
        throw new IllegalArgumentException();
    }
}

