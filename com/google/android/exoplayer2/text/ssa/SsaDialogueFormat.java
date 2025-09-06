package com.google.android.exoplayer2.text.ssa;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class SsaDialogueFormat {
    public final int endTimeIndex;
    public final int length;
    public final int startTimeIndex;
    public final int styleIndex;
    public final int textIndex;

    private SsaDialogueFormat(int v, int v1, int v2, int v3, int v4) {
        this.startTimeIndex = v;
        this.endTimeIndex = v1;
        this.styleIndex = v2;
        this.textIndex = v3;
        this.length = v4;
    }

    // This method was un-flattened
    public static SsaDialogueFormat fromFormatLine(String s) {
        Assertions.checkArgument(s.startsWith("Format:"));
        String[] arr_s = TextUtils.split(s.substring(7), ",");
        int v = -1;
        int v1 = -1;
        int v2 = -1;
        int v3 = -1;
        for(int v4 = 0; v4 < arr_s.length; ++v4) {
            String s1 = Util.toLowerInvariant(arr_s[v4].trim());
            s1.getClass();
            switch(s1) {
                case "end": {
                    v1 = v4;
                    break;
                }
                case "start": {
                    v = v4;
                    break;
                }
                case "style": {
                    v2 = v4;
                    break;
                }
                case "text": {
                    v3 = v4;
                }
            }
        }
        return v == -1 || v1 == -1 ? null : new SsaDialogueFormat(v, v1, v2, v3, arr_s.length);
    }
}

