package c4;

import android.graphics.PointF;
import e3.b;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {
    public static final Pattern a;
    public static final Pattern b;
    public static final Pattern c;
    public static final Pattern d;

    static {
        c.a = Pattern.compile("\\{([^}]*)\\}");
        c.b = Pattern.compile("\\\\pos\\((\\s*\\d+(?:\\.\\d+)?\\s*),(\\s*\\d+(?:\\.\\d+)?\\s*)\\)");
        c.c = Pattern.compile("\\\\move\\(\\s*\\d+(?:\\.\\d+)?\\s*,\\s*\\d+(?:\\.\\d+)?\\s*,(\\s*\\d+(?:\\.\\d+)?\\s*),(\\s*\\d+(?:\\.\\d+)?\\s*)(?:,\\s*\\d+(?:\\.\\d+)?\\s*,\\s*\\d+(?:\\.\\d+)?\\s*)?\\)");
        c.d = Pattern.compile("\\\\an(\\d+)");
    }

    public static PointF a(String s) {
        String s2;
        String s1;
        Matcher matcher0 = c.b.matcher(s);
        Matcher matcher1 = c.c.matcher(s);
        boolean z = matcher0.find();
        boolean z1 = matcher1.find();
        if(z) {
            if(z1) {
                b.u("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override=\'" + s + "\'");
            }
            s1 = matcher0.group(1);
            s2 = matcher0.group(2);
        }
        else if(z1) {
            s1 = matcher1.group(1);
            s2 = matcher1.group(2);
        }
        else {
            return null;
        }
        s1.getClass();
        float f = Float.parseFloat(s1.trim());
        s2.getClass();
        return new PointF(f, Float.parseFloat(s2.trim()));
    }
}

