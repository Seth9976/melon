package com.google.android.exoplayer2.text.ssa;

import android.graphics.PointF;
import android.text.Layout.Alignment;
import b3.Z;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final float DEFAULT_MARGIN = 0.05f;
    private static final String DIALOGUE_LINE_PREFIX = "Dialogue:";
    static final String FORMAT_LINE_PREFIX = "Format:";
    private static final Pattern SSA_TIMECODE_PATTERN = null;
    static final String STYLE_LINE_PREFIX = "Style:";
    private static final String TAG = "SsaDecoder";
    private final SsaDialogueFormat dialogueFormatFromInitializationData;
    private final boolean haveInitializationData;
    private float screenHeight;
    private float screenWidth;
    private Map styles;

    static {
        SsaDecoder.SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    }

    public SsaDecoder() {
        this(null);
    }

    public SsaDecoder(List list0) {
        super("SsaDecoder");
        this.screenWidth = -3.402823E+38f;
        this.screenHeight = -3.402823E+38f;
        if(list0 != null && !list0.isEmpty()) {
            this.haveInitializationData = true;
            String s = Util.fromUtf8Bytes(((byte[])list0.get(0)));
            Assertions.checkArgument(s.startsWith("Format:"));
            this.dialogueFormatFromInitializationData = (SsaDialogueFormat)Assertions.checkNotNull(SsaDialogueFormat.fromFormatLine(s));
            this.parseHeader(new ParsableByteArray(((byte[])list0.get(1))));
            return;
        }
        this.haveInitializationData = false;
        this.dialogueFormatFromInitializationData = null;
    }

    private static int addCuePlacerholderByTime(long v, List list0, List list1) {
        int v2;
        for(int v1 = list0.size() - 1; true; --v1) {
            v2 = 0;
            if(v1 < 0) {
                break;
            }
            if(((long)(((Long)list0.get(v1)))) == v) {
                return v1;
            }
            if(((long)(((Long)list0.get(v1)))) < v) {
                v2 = v1 + 1;
                break;
            }
        }
        list0.add(v2, v);
        list1.add(v2, (v2 == 0 ? new ArrayList() : new ArrayList(((Collection)list1.get(v2 - 1)))));
        return v2;
    }

    private static float computeDefaultLineOrPosition(int v) {
        switch(v) {
            case 0: {
                return 0.05f;
            }
            case 1: {
                return 0.5f;
            }
            case 2: {
                return 0.95f;
            }
            default: {
                return -3.402823E+38f;
            }
        }
    }

    private static Cue createCue(String s, SsaStyle ssaStyle0, Overrides ssaStyle$Overrides0, float f, float f1) {
        int v = ssaStyle$Overrides0.alignment;
        if(v == -1) {
            v = ssaStyle0 == null ? -1 : ssaStyle0.alignment;
        }
        int v1 = SsaDecoder.toPositionAnchor(v);
        int v2 = SsaDecoder.toLineAnchor(v);
        PointF pointF0 = ssaStyle$Overrides0.position;
        if(pointF0 != null && f1 != -3.402823E+38f && f != -3.402823E+38f) {
            float f2 = pointF0.x / f;
            float f3 = pointF0.y / f1;
            return new Cue(s, SsaDecoder.toTextAlignment(v), f3, 0, v2, f2, v1, -3.402823E+38f);
        }
        return new Cue(s, SsaDecoder.toTextAlignment(v), SsaDecoder.computeDefaultLineOrPosition(v2), 0, v2, SsaDecoder.computeDefaultLineOrPosition(v1), v1, -3.402823E+38f);
    }

    @Override  // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] arr_b, int v, boolean z) {
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(arr_b, v);
        if(!this.haveInitializationData) {
            this.parseHeader(parsableByteArray0);
        }
        this.parseEventBody(parsableByteArray0, arrayList0, arrayList1);
        return new SsaSubtitle(arrayList0, arrayList1);
    }

    private void parseDialogueLine(String s, SsaDialogueFormat ssaDialogueFormat0, List list0, List list1) {
        SsaStyle ssaStyle0;
        Assertions.checkArgument(s.startsWith("Dialogue:"));
        String[] arr_s = s.substring(9).split(",", ssaDialogueFormat0.length);
        if(arr_s.length != ssaDialogueFormat0.length) {
            Log.w("SsaDecoder", (s.length() == 0 ? new String("Skipping dialogue line with fewer columns than format: ") : "Skipping dialogue line with fewer columns than format: " + s));
            return;
        }
        long v = SsaDecoder.parseTimecodeUs(arr_s[ssaDialogueFormat0.startTimeIndex]);
        if(Long.compare(v, 0x8000000000000001L) == 0) {
            Log.w("SsaDecoder", (s.length() == 0 ? new String("Skipping invalid timing: ") : "Skipping invalid timing: " + s));
            return;
        }
        long v1 = SsaDecoder.parseTimecodeUs(arr_s[ssaDialogueFormat0.endTimeIndex]);
        if(v1 == 0x8000000000000001L) {
            Log.w("SsaDecoder", (s.length() == 0 ? new String("Skipping invalid timing: ") : "Skipping invalid timing: " + s));
            return;
        }
        Map map0 = this.styles;
        if(map0 == null) {
            ssaStyle0 = null;
        }
        else {
            int v2 = ssaDialogueFormat0.styleIndex;
            ssaStyle0 = v2 == -1 ? null : ((SsaStyle)map0.get(arr_s[v2].trim()));
        }
        String s1 = arr_s[ssaDialogueFormat0.textIndex];
        Overrides ssaStyle$Overrides0 = Overrides.parseFromDialogue(s1);
        Cue cue0 = SsaDecoder.createCue(Overrides.stripStyleOverrides(s1).replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n"), ssaStyle0, ssaStyle$Overrides0, this.screenWidth, this.screenHeight);
        int v3 = SsaDecoder.addCuePlacerholderByTime(v, list1, list0);
        int v4 = SsaDecoder.addCuePlacerholderByTime(v1, list1, list0);
        while(v3 < v4) {
            ((List)list0.get(v3)).add(cue0);
            ++v3;
        }
    }

    private void parseEventBody(ParsableByteArray parsableByteArray0, List list0, List list1) {
        SsaDialogueFormat ssaDialogueFormat0 = this.haveInitializationData ? this.dialogueFormatFromInitializationData : null;
        String s;
        while((s = parsableByteArray0.readLine()) != null) {
            if(s.startsWith("Format:")) {
                ssaDialogueFormat0 = SsaDialogueFormat.fromFormatLine(s);
            }
            else if(!s.startsWith("Dialogue:")) {
            }
            else if(ssaDialogueFormat0 == null) {
                Log.w("SsaDecoder", (s.length() == 0 ? new String("Skipping dialogue line before complete format: ") : "Skipping dialogue line before complete format: " + s));
            }
            else {
                this.parseDialogueLine(s, ssaDialogueFormat0, list0, list1);
            }
        }
    }

    private void parseHeader(ParsableByteArray parsableByteArray0) {
        String s;
        while((s = parsableByteArray0.readLine()) != null) {
            if("[Script Info]".equalsIgnoreCase(s)) {
                this.parseScriptInfo(parsableByteArray0);
            }
            else if("[V4+ Styles]".equalsIgnoreCase(s)) {
                this.styles = SsaDecoder.parseStyles(parsableByteArray0);
            }
            else if("[V4 Styles]".equalsIgnoreCase(s)) {
                Log.i("SsaDecoder", "[V4 Styles] are not supported");
            }
            else if("[Events]".equalsIgnoreCase(s)) {
                break;
            }
        }
    }

    private void parseScriptInfo(ParsableByteArray parsableByteArray0) {
        while(true) {
            String s = parsableByteArray0.readLine();
            if(s == null || parsableByteArray0.bytesLeft() != 0 && parsableByteArray0.peekUnsignedByte() == 91) {
                break;
            }
            String[] arr_s = s.split(":");
            if(arr_s.length == 2) {
                String s1 = Util.toLowerInvariant(arr_s[0].trim());
                s1.getClass();
                if(s1.equals("playresx")) {
                    this.screenWidth = Float.parseFloat(arr_s[1].trim());
                }
                else if(s1.equals("playresy")) {
                    this.screenHeight = Float.parseFloat(arr_s[1].trim());
                }
                else {
                    continue;
                }
            }
        }
    }

    private static Map parseStyles(ParsableByteArray parsableByteArray0) {
        Map map0 = new LinkedHashMap();
        Format ssaStyle$Format0 = null;
        while(true) {
            String s = parsableByteArray0.readLine();
            if(s == null || parsableByteArray0.bytesLeft() != 0 && parsableByteArray0.peekUnsignedByte() == 91) {
                break;
            }
            if(s.startsWith("Format:")) {
                ssaStyle$Format0 = Format.fromFormatLine(s);
            }
            else if(!s.startsWith("Style:")) {
            }
            else if(ssaStyle$Format0 == null) {
                Log.w("SsaDecoder", (s.length() == 0 ? new String("Skipping \'Style:\' line before \'Format:\' line: ") : "Skipping \'Style:\' line before \'Format:\' line: " + s));
            }
            else {
                SsaStyle ssaStyle0 = SsaStyle.fromStyleLine(s, ssaStyle$Format0);
                if(ssaStyle0 != null) {
                    map0.put(ssaStyle0.name, ssaStyle0);
                }
            }
        }
        return map0;
    }

    private static long parseTimecodeUs(String s) {
        Matcher matcher0 = SsaDecoder.SSA_TIMECODE_PATTERN.matcher(s.trim());
        if(!matcher0.matches()) {
            return 0x8000000000000001L;
        }
        long v = Long.parseLong(((String)Util.castNonNull(matcher0.group(1))));
        long v1 = Long.parseLong(((String)Util.castNonNull(matcher0.group(2))));
        long v2 = Long.parseLong(((String)Util.castNonNull(matcher0.group(3))));
        return Long.parseLong(((String)Util.castNonNull(matcher0.group(4)))) * 10000L + (v2 * 1000000L + (v1 * 60000000L + v * 3600000000L));
    }

    private static int toLineAnchor(int v) {
        switch(v) {
            case -1: {
                return 0x80000000;
            }
            case 1: 
            case 2: 
            case 3: {
                return 2;
            }
            case 4: 
            case 5: 
            case 6: {
                return 1;
            }
            case 7: 
            case 8: 
            case 9: {
                return 0;
            }
            default: {
                Z.q(30, v, "Unknown alignment: ", "SsaDecoder");
                return 0x80000000;
            }
        }
    }

    private static int toPositionAnchor(int v) {
        switch(v) {
            case -1: {
                return 0x80000000;
            }
            case 1: 
            case 4: 
            case 7: {
                return 0;
            }
            case 2: 
            case 5: 
            case 8: {
                return 1;
            }
            case 3: 
            case 6: 
            case 9: {
                return 2;
            }
            default: {
                Z.q(30, v, "Unknown alignment: ", "SsaDecoder");
                return 0x80000000;
            }
        }
    }

    private static Layout.Alignment toTextAlignment(int v) {
        switch(v) {
            case -1: {
                return null;
            }
            case 1: 
            case 4: 
            case 7: {
                return Layout.Alignment.ALIGN_NORMAL;
            }
            case 2: 
            case 5: 
            case 8: {
                return Layout.Alignment.ALIGN_CENTER;
            }
            case 3: 
            case 6: 
            case 9: {
                return Layout.Alignment.ALIGN_OPPOSITE;
            }
            default: {
                Z.q(30, v, "Unknown alignment: ", "SsaDecoder");
                return null;
            }
        }
    }
}

