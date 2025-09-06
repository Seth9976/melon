package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SsaStyle {
    static final class Format {
        public final int alignmentIndex;
        public final int length;
        public final int nameIndex;

        private Format(int v, int v1, int v2) {
            this.nameIndex = v;
            this.alignmentIndex = v1;
            this.length = v2;
        }

        public static Format fromFormatLine(String s) {
            String[] arr_s = TextUtils.split(s.substring(7), ",");
            int v1 = -1;
            int v2 = -1;
            for(int v = 0; v < arr_s.length; ++v) {
                String s1 = Util.toLowerInvariant(arr_s[v].trim());
                s1.getClass();
                if(s1.equals("name")) {
                    v1 = v;
                }
                else if(s1.equals("alignment")) {
                    v2 = v;
                }
            }
            return v1 == -1 ? null : new Format(v1, v2, arr_s.length);
        }
    }

    static final class Overrides {
        private static final Pattern ALIGNMENT_OVERRIDE_PATTERN = null;
        private static final Pattern BRACES_PATTERN = null;
        private static final Pattern MOVE_PATTERN = null;
        private static final String PADDED_DECIMAL_PATTERN = "\\s*\\d+(?:\\.\\d+)?\\s*";
        private static final Pattern POSITION_PATTERN = null;
        private static final String TAG = "SsaStyle.Overrides";
        public final int alignment;
        public final PointF position;

        static {
            Overrides.BRACES_PATTERN = Pattern.compile("\\{([^}]*)\\}");
            Overrides.POSITION_PATTERN = Pattern.compile("\\\\pos\\((\\s*\\d+(?:\\.\\d+)?\\s*),(\\s*\\d+(?:\\.\\d+)?\\s*)\\)");
            Overrides.MOVE_PATTERN = Pattern.compile("\\\\move\\(\\s*\\d+(?:\\.\\d+)?\\s*,\\s*\\d+(?:\\.\\d+)?\\s*,(\\s*\\d+(?:\\.\\d+)?\\s*),(\\s*\\d+(?:\\.\\d+)?\\s*)(?:,\\s*\\d+(?:\\.\\d+)?\\s*,\\s*\\d+(?:\\.\\d+)?\\s*)?\\)");
            Overrides.ALIGNMENT_OVERRIDE_PATTERN = Pattern.compile("\\\\an(\\d+)");
        }

        private Overrides(int v, PointF pointF0) {
            this.alignment = v;
            this.position = pointF0;
        }

        private static int parseAlignmentOverride(String s) {
            Matcher matcher0 = Overrides.ALIGNMENT_OVERRIDE_PATTERN.matcher(s);
            return matcher0.find() ? SsaStyle.parseAlignment(matcher0.group(1)) : -1;
        }

        public static Overrides parseFromDialogue(String s) {
            int v1;
            Matcher matcher0 = Overrides.BRACES_PATTERN.matcher(s);
            PointF pointF0 = null;
            int v = -1;
            while(matcher0.find()) {
                String s1 = matcher0.group(1);
                try {
                    PointF pointF1 = Overrides.parsePosition(s1);
                    if(pointF1 != null) {
                        pointF0 = pointF1;
                    }
                }
                catch(RuntimeException unused_ex) {
                }
                try {
                    v1 = Overrides.parseAlignmentOverride(s1);
                    if(v1 != -1) {
                        goto label_10;
                    }
                }
                catch(RuntimeException unused_ex) {
                }
                continue;
            label_10:
                v = v1;
            }
            return new Overrides(v, pointF0);
        }

        private static PointF parsePosition(String s) {
            String s2;
            String s1;
            Matcher matcher0 = Overrides.POSITION_PATTERN.matcher(s);
            Matcher matcher1 = Overrides.MOVE_PATTERN.matcher(s);
            boolean z = matcher0.find();
            boolean z1 = matcher1.find();
            if(z) {
                if(z1) {
                    Log.i("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override=\'" + s + "\'");
                }
                s1 = matcher0.group(1);
                s2 = matcher0.group(2);
                return new PointF(Float.parseFloat(((String)Assertions.checkNotNull(s1)).trim()), Float.parseFloat(((String)Assertions.checkNotNull(s2)).trim()));
            }
            if(z1) {
                s1 = matcher1.group(1);
                s2 = matcher1.group(2);
                return new PointF(Float.parseFloat(((String)Assertions.checkNotNull(s1)).trim()), Float.parseFloat(((String)Assertions.checkNotNull(s2)).trim()));
            }
            return null;
        }

        public static String stripStyleOverrides(String s) {
            return Overrides.BRACES_PATTERN.matcher(s).replaceAll("");
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface SsaAlignment {
    }

    public static final int SSA_ALIGNMENT_BOTTOM_CENTER = 2;
    public static final int SSA_ALIGNMENT_BOTTOM_LEFT = 1;
    public static final int SSA_ALIGNMENT_BOTTOM_RIGHT = 3;
    public static final int SSA_ALIGNMENT_MIDDLE_CENTER = 5;
    public static final int SSA_ALIGNMENT_MIDDLE_LEFT = 4;
    public static final int SSA_ALIGNMENT_MIDDLE_RIGHT = 6;
    public static final int SSA_ALIGNMENT_TOP_CENTER = 8;
    public static final int SSA_ALIGNMENT_TOP_LEFT = 7;
    public static final int SSA_ALIGNMENT_TOP_RIGHT = 9;
    public static final int SSA_ALIGNMENT_UNKNOWN = -1;
    private static final String TAG = "SsaStyle";
    public final int alignment;
    public final String name;

    private SsaStyle(String s, int v) {
        this.name = s;
        this.alignment = v;
    }

    public static SsaStyle fromStyleLine(String s, Format ssaStyle$Format0) {
        Assertions.checkArgument(s.startsWith("Style:"));
        String[] arr_s = TextUtils.split(s.substring(6), ",");
        int v = ssaStyle$Format0.length;
        if(arr_s.length != v) {
            Log.w("SsaStyle", Util.formatInvariant("Skipping malformed \'Style:\' line (expected %s values, found %s): \'%s\'", new Object[]{v, ((int)arr_s.length), s}));
            return null;
        }
        try {
            return new SsaStyle(arr_s[ssaStyle$Format0.nameIndex].trim(), SsaStyle.parseAlignment(arr_s[ssaStyle$Format0.alignmentIndex]));
        }
        catch(RuntimeException runtimeException0) {
            Log.w("SsaStyle", "Skipping malformed \'Style:\' line: \'" + s + "\'", runtimeException0);
            return null;
        }
    }

    private static boolean isValidAlignment(int v) {
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    private static int parseAlignment(String s) {
        try {
            int v = Integer.parseInt(s.trim());
            if(SsaStyle.isValidAlignment(v)) {
                return v;
            }
        }
        catch(NumberFormatException unused_ex) {
        }
        String s1 = String.valueOf(s);
        Log.w("SsaStyle", (s1.length() == 0 ? new String("Ignoring unknown alignment: ") : "Ignoring unknown alignment: " + s1));
        return -1;
    }
}

