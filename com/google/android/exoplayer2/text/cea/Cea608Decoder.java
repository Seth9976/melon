package com.google.android.exoplayer2.text.cea;

import U4.x;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cea608Decoder extends CeaDecoder {
    static class CueBuilder {
        static class CueStyle {
            public int start;
            public final int style;
            public final boolean underline;

            public CueStyle(int v, boolean z, int v1) {
                this.style = v;
                this.underline = z;
                this.start = v1;
            }
        }

        private static final int BASE_ROW = 15;
        private static final int SCREEN_CHARWIDTH = 0x20;
        private int captionMode;
        private int captionRowCount;
        private final StringBuilder captionStringBuilder;
        private final List cueStyles;
        private int indent;
        private final List rolledUpCaptions;
        private int row;
        private int tabOffset;

        public CueBuilder(int v, int v1) {
            this.cueStyles = new ArrayList();
            this.rolledUpCaptions = new ArrayList();
            this.captionStringBuilder = new StringBuilder();
            this.reset(v);
            this.setCaptionRowCount(v1);
        }

        public static int access$002(CueBuilder cea608Decoder$CueBuilder0, int v) {
            cea608Decoder$CueBuilder0.tabOffset = v;
            return v;
        }

        public static int access$100(CueBuilder cea608Decoder$CueBuilder0) {
            return cea608Decoder$CueBuilder0.row;
        }

        public static int access$102(CueBuilder cea608Decoder$CueBuilder0, int v) {
            cea608Decoder$CueBuilder0.row = v;
            return v;
        }

        public static int access$202(CueBuilder cea608Decoder$CueBuilder0, int v) {
            cea608Decoder$CueBuilder0.indent = v;
            return v;
        }

        public void append(char c) {
            this.captionStringBuilder.append(c);
        }

        public void backspace() {
            int v = this.captionStringBuilder.length();
            if(v > 0) {
                this.captionStringBuilder.delete(v - 1, v);
                for(int v1 = this.cueStyles.size() - 1; v1 >= 0; --v1) {
                    CueStyle cea608Decoder$CueBuilder$CueStyle0 = (CueStyle)this.cueStyles.get(v1);
                    int v2 = cea608Decoder$CueBuilder$CueStyle0.start;
                    if(v2 != v) {
                        break;
                    }
                    cea608Decoder$CueBuilder$CueStyle0.start = v2 - 1;
                }
            }
        }

        public Cue build(int v) {
            float f;
            SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder();
            for(int v1 = 0; v1 < this.rolledUpCaptions.size(); ++v1) {
                spannableStringBuilder0.append(((CharSequence)this.rolledUpCaptions.get(v1)));
                spannableStringBuilder0.append('\n');
            }
            spannableStringBuilder0.append(this.buildCurrentLine());
            if(spannableStringBuilder0.length() == 0) {
                return null;
            }
            int v2 = this.indent + this.tabOffset;
            int v3 = 0x20 - v2 - spannableStringBuilder0.length();
            int v4 = v2 - v3;
            if(v == 0x80000000) {
                if(this.captionMode != 2 || Math.abs(v4) >= 3 && v3 >= 0) {
                    v = this.captionMode != 2 || v4 <= 0 ? 0 : 2;
                }
                else {
                    v = 1;
                }
            }
            switch(v) {
                case 1: {
                    f = 0.5f;
                    break;
                }
                case 2: {
                    f = ((float)(0x20 - v3)) / 32.0f * 0.8f + 0.1f;
                    break;
                }
                default: {
                    f = ((float)v2) / 32.0f * 0.8f + 0.1f;
                }
            }
            if(this.captionMode != 1) {
                int v5 = this.row;
                return v5 > 7 ? new Cue(spannableStringBuilder0, Layout.Alignment.ALIGN_NORMAL, ((float)(this.row - 17)), 1, 2, f, v, -3.402823E+38f) : new Cue(spannableStringBuilder0, Layout.Alignment.ALIGN_NORMAL, ((float)v5), 1, 0, f, v, -3.402823E+38f);
            }
            return new Cue(spannableStringBuilder0, Layout.Alignment.ALIGN_NORMAL, ((float)(this.row - 17)), 1, 2, f, v, -3.402823E+38f);
        }

        private SpannableString buildCurrentLine() {
            SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(this.captionStringBuilder);
            int v = spannableStringBuilder0.length();
            int v1 = -1;
            int v2 = -1;
            int v3 = -1;
            int v4 = -1;
            int v5 = 0;
            int v6 = 0;
            int v7 = 0;
            while(v5 < this.cueStyles.size()) {
                CueStyle cea608Decoder$CueBuilder$CueStyle0 = (CueStyle)this.cueStyles.get(v5);
                boolean z = cea608Decoder$CueBuilder$CueStyle0.underline;
                int v8 = cea608Decoder$CueBuilder$CueStyle0.style;
                if(v8 != 8) {
                    if(v8 != 7) {
                        v4 = Cea608Decoder.STYLE_COLORS[v8];
                    }
                    v7 = v8 == 7 ? 1 : 0;
                }
                int v9 = cea608Decoder$CueBuilder$CueStyle0.start;
                ++v5;
                if(v9 != (v5 >= this.cueStyles.size() ? v : ((CueStyle)this.cueStyles.get(v5)).start)) {
                    if(v1 != -1 && !z) {
                        CueBuilder.setUnderlineSpan(spannableStringBuilder0, v1, v9);
                        v1 = -1;
                    }
                    else if(v1 == -1 && z) {
                        v1 = v9;
                    }
                    if(v2 != -1 && v7 == 0) {
                        CueBuilder.setItalicSpan(spannableStringBuilder0, v2, v9);
                        v2 = -1;
                    }
                    else if(v2 == -1 && v7 != 0) {
                        v2 = v9;
                    }
                    if(v4 != v3) {
                        CueBuilder.setColorSpan(spannableStringBuilder0, v6, v9, v3);
                        v3 = v4;
                        v6 = v9;
                    }
                }
            }
            if(v1 != -1 && v1 != v) {
                CueBuilder.setUnderlineSpan(spannableStringBuilder0, v1, v);
            }
            if(v2 != -1 && v2 != v) {
                CueBuilder.setItalicSpan(spannableStringBuilder0, v2, v);
            }
            if(v6 != v) {
                CueBuilder.setColorSpan(spannableStringBuilder0, v6, v, v3);
            }
            return new SpannableString(spannableStringBuilder0);
        }

        // 去混淆评级： 低(20)
        public boolean isEmpty() {
            return this.cueStyles.isEmpty() && this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0;
        }

        public void reset(int v) {
            this.captionMode = v;
            this.cueStyles.clear();
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.setLength(0);
            this.row = 15;
            this.indent = 0;
            this.tabOffset = 0;
        }

        public void rollUp() {
            SpannableString spannableString0 = this.buildCurrentLine();
            this.rolledUpCaptions.add(spannableString0);
            this.captionStringBuilder.setLength(0);
            this.cueStyles.clear();
            int v = Math.min(this.captionRowCount, this.row);
            while(this.rolledUpCaptions.size() >= v) {
                this.rolledUpCaptions.remove(0);
            }
        }

        public void setCaptionMode(int v) {
            this.captionMode = v;
        }

        public void setCaptionRowCount(int v) {
            this.captionRowCount = v;
        }

        private static void setColorSpan(SpannableStringBuilder spannableStringBuilder0, int v, int v1, int v2) {
            if(v2 == -1) {
                return;
            }
            spannableStringBuilder0.setSpan(new ForegroundColorSpan(v2), v, v1, 33);
        }

        private static void setItalicSpan(SpannableStringBuilder spannableStringBuilder0, int v, int v1) {
            x.t(2, spannableStringBuilder0, v, v1, 33);
        }

        public void setStyle(int v, boolean z) {
            CueStyle cea608Decoder$CueBuilder$CueStyle0 = new CueStyle(v, z, this.captionStringBuilder.length());
            this.cueStyles.add(cea608Decoder$CueBuilder$CueStyle0);
        }

        private static void setUnderlineSpan(SpannableStringBuilder spannableStringBuilder0, int v, int v1) {
            spannableStringBuilder0.setSpan(new UnderlineSpan(), v, v1, 33);
        }
    }

    private static final int[] BASIC_CHARACTER_SET = null;
    private static final int CC_FIELD_FLAG = 1;
    private static final byte CC_IMPLICIT_DATA_HEADER = -4;
    private static final int CC_MODE_PAINT_ON = 3;
    private static final int CC_MODE_POP_ON = 2;
    private static final int CC_MODE_ROLL_UP = 1;
    private static final int CC_MODE_UNKNOWN = 0;
    private static final int CC_TYPE_FLAG = 2;
    private static final int CC_VALID_FLAG = 4;
    private static final int[] COLUMN_INDICES = null;
    private static final byte CTRL_BACKSPACE = 33;
    private static final byte CTRL_CARRIAGE_RETURN = 45;
    private static final byte CTRL_DELETE_TO_END_OF_ROW = 36;
    private static final byte CTRL_END_OF_CAPTION = 0x2F;
    private static final byte CTRL_ERASE_DISPLAYED_MEMORY = 44;
    private static final byte CTRL_ERASE_NON_DISPLAYED_MEMORY = 46;
    private static final byte CTRL_RESUME_CAPTION_LOADING = 0x20;
    private static final byte CTRL_RESUME_DIRECT_CAPTIONING = 41;
    private static final byte CTRL_RESUME_TEXT_DISPLAY = 43;
    private static final byte CTRL_ROLL_UP_CAPTIONS_2_ROWS = 37;
    private static final byte CTRL_ROLL_UP_CAPTIONS_3_ROWS = 38;
    private static final byte CTRL_ROLL_UP_CAPTIONS_4_ROWS = 39;
    private static final byte CTRL_TEXT_RESTART = 42;
    private static final int DEFAULT_CAPTIONS_ROW_COUNT = 4;
    private static final int NTSC_CC_CHANNEL_1 = 0;
    private static final int NTSC_CC_CHANNEL_2 = 1;
    private static final int NTSC_CC_FIELD_1 = 0;
    private static final int NTSC_CC_FIELD_2 = 1;
    private static final boolean[] ODD_PARITY_BYTE_TABLE = null;
    private static final int[] ROW_INDICES = null;
    private static final int[] SPECIAL_CHARACTER_SET = null;
    private static final int[] SPECIAL_ES_FR_CHARACTER_SET = null;
    private static final int[] SPECIAL_PT_DE_CHARACTER_SET = null;
    private static final int[] STYLE_COLORS = null;
    private static final int STYLE_ITALICS = 7;
    private static final int STYLE_UNCHANGED = 8;
    private static final String TAG = "Cea608Decoder";
    private int captionMode;
    private int captionRowCount;
    private final ParsableByteArray ccData;
    private final ArrayList cueBuilders;
    private List cues;
    private int currentChannel;
    private CueBuilder currentCueBuilder;
    private boolean isCaptionValid;
    private boolean isInCaptionService;
    private List lastCues;
    private final int packetLength;
    private byte repeatableControlCc1;
    private byte repeatableControlCc2;
    private boolean repeatableControlSet;
    private final int selectedChannel;
    private final int selectedField;

    static {
        Cea608Decoder.ROW_INDICES = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
        Cea608Decoder.COLUMN_INDICES = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
        Cea608Decoder.STYLE_COLORS = new int[]{-1, 0xFF00FF00, 0xFF0000FF, 0xFF00FFFF, 0xFFFF0000, 0xFFFFFF00, 0xFFFF00FF};
        Cea608Decoder.BASIC_CHARACTER_SET = new int[]{0x20, 33, 34, 35, 36, 37, 38, 39, 40, 41, 0xE1, 43, 44, 45, 46, 0x2F, 0x30, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 0x3F, 0x40, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 0x4F, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 0xE9, 93, 0xED, 0xF3, 0xFA, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 120, 0x79, 0x7A, 0xE7, 0xF7, 209, 0xF1, 0x25A0};
        Cea608Decoder.SPECIAL_CHARACTER_SET = new int[]{0xAE, 0xB0, 0xBD, 0xBF, 8482, 0xA2, 0xA3, 9834, 0xE0, 0x20, 0xE8, 0xE2, 0xEA, 0xEE, 0xF4, 0xFB};
        Cea608Decoder.SPECIAL_ES_FR_CHARACTER_SET = new int[]{0xC1, 201, 0xD3, 0xDA, 220, 0xFC, 0x2018, 0xA1, 42, 39, 0x2014, 0xA9, 8480, 0x2022, 8220, 0x201D, 0xC0, 0xC2, 0xC7, 200, 202, 203, 0xEB, 206, 0xCF, 0xEF, 0xD4, 0xD9, 0xF9, 0xDB, 0xAB, 0xBB};
        Cea608Decoder.SPECIAL_PT_DE_CHARACTER_SET = new int[]{0xC3, 0xE3, 205, 204, 0xEC, 210, 0xF2, 0xD5, 0xF5, 0x7B, 0x7D, 92, 94, 0x5F, 0x7C, 0x7E, 0xC4, 0xE4, 0xD6, 0xF6, 0xDF, 0xA5, 0xA4, 0x2502, 0xC5, 0xE5, 0xD8, 0xF8, 0x250C, 0x2510, 9492, 9496};
        Cea608Decoder.ODD_PARITY_BYTE_TABLE = new boolean[]{false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    }

    public Cea608Decoder(String s, int v) {
        this.ccData = new ParsableByteArray();
        this.cueBuilders = new ArrayList();
        this.currentCueBuilder = new CueBuilder(0, 4);
        this.currentChannel = 0;
        this.packetLength = "application/x-mp4-cea-608".equals(s) ? 2 : 3;
        switch(v) {
            case 1: {
                this.selectedChannel = 0;
                this.selectedField = 0;
                break;
            }
            case 2: {
                this.selectedChannel = 1;
                this.selectedField = 0;
                break;
            }
            case 3: {
                this.selectedChannel = 0;
                this.selectedField = 1;
                break;
            }
            case 4: {
                this.selectedChannel = 1;
                this.selectedField = 1;
                break;
            }
            default: {
                Log.w("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
                this.selectedChannel = 0;
                this.selectedField = 0;
            }
        }
        this.setCaptionMode(0);
        this.resetCueBuilders();
        this.isInCaptionService = true;
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public Subtitle createSubtitle() {
        this.lastCues = this.cues;
        return new CeaSubtitle(this.cues);
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void decode(SubtitleInputBuffer subtitleInputBuffer0) {
        byte[] arr_b = subtitleInputBuffer0.data.array();
        this.ccData.reset(arr_b, subtitleInputBuffer0.data.limit());
        boolean z = false;
        while(true) {
            int v = this.packetLength;
            if(this.ccData.bytesLeft() < v) {
                break;
            }
            int v1 = v == 2 ? -4 : ((byte)this.ccData.readUnsignedByte());
            int v2 = this.ccData.readUnsignedByte();
            int v3 = this.ccData.readUnsignedByte();
            if((v1 & 2) == 0 && (v1 & 1) == this.selectedField && (((byte)(v2 & 0x7F)) != 0 || ((byte)(v3 & 0x7F)) != 0)) {
                boolean z1 = this.isCaptionValid;
                boolean z2 = (v1 & 4) == 4 && (Cea608Decoder.ODD_PARITY_BYTE_TABLE[v2] && Cea608Decoder.ODD_PARITY_BYTE_TABLE[v3]);
                this.isCaptionValid = z2;
                if(!this.isRepeatedCommand(z2, ((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F)))) {
                    if(this.isCaptionValid) {
                        this.maybeUpdateIsInCaptionService(((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F)));
                        if(!this.isInCaptionService || !this.updateAndVerifyCurrentChannel(((byte)(v2 & 0x7F)))) {
                            continue;
                        }
                        if(!Cea608Decoder.isCtrlCode(((byte)(v2 & 0x7F)))) {
                            this.currentCueBuilder.append(Cea608Decoder.getBasicChar(((byte)(v2 & 0x7F))));
                            if((((byte)(v3 & 0x7F)) & 0xE0) != 0) {
                                this.currentCueBuilder.append(Cea608Decoder.getBasicChar(((byte)(v3 & 0x7F))));
                            }
                        }
                        else if(Cea608Decoder.isSpecialNorthAmericanChar(((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F)))) {
                            this.currentCueBuilder.append(Cea608Decoder.getSpecialNorthAmericanChar(((byte)(v3 & 0x7F))));
                        }
                        else if(Cea608Decoder.isExtendedWestEuropeanChar(((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F)))) {
                            this.currentCueBuilder.backspace();
                            this.currentCueBuilder.append(Cea608Decoder.getExtendedWestEuropeanChar(((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F))));
                        }
                        else if(Cea608Decoder.isMidrowCtrlCode(((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F)))) {
                            this.handleMidrowCtrl(((byte)(v3 & 0x7F)));
                        }
                        else if(Cea608Decoder.isPreambleAddressCode(((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F)))) {
                            this.handlePreambleAddressCode(((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F)));
                        }
                        else if(Cea608Decoder.isTabCtrlCode(((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F)))) {
                            CueBuilder.access$002(this.currentCueBuilder, ((byte)(v3 & 0x7F)) - 0x20);
                        }
                        else if(Cea608Decoder.isMiscCode(((byte)(v2 & 0x7F)), ((byte)(v3 & 0x7F)))) {
                            this.handleMiscCode(((byte)(v3 & 0x7F)));
                        }
                    }
                    else {
                        if(!z1) {
                            continue;
                        }
                        this.resetCueBuilders();
                    }
                    z = true;
                }
            }
        }
        if(z && (this.captionMode == 1 || this.captionMode == 3)) {
            this.cues = this.getDisplayCues();
        }
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public SubtitleInputBuffer dequeueInputBuffer() {
        return super.dequeueInputBuffer();
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public SubtitleOutputBuffer dequeueOutputBuffer() {
        return super.dequeueOutputBuffer();
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.setCaptionMode(0);
        this.setCaptionRowCount(4);
        this.resetCueBuilders();
        this.isCaptionValid = false;
        this.repeatableControlSet = false;
        this.repeatableControlCc1 = 0;
        this.repeatableControlCc2 = 0;
        this.currentChannel = 0;
        this.isInCaptionService = true;
    }

    private static char getBasicChar(byte b) {
        return (char)Cea608Decoder.BASIC_CHARACTER_SET[(b & 0x7F) - 0x20];
    }

    private static int getChannel(byte b) [...] // Inlined contents

    private List getDisplayCues() {
        int v = this.cueBuilders.size();
        ArrayList arrayList0 = new ArrayList(v);
        int v1 = 2;
        for(int v3 = 0; v3 < v; ++v3) {
            Cue cue0 = ((CueBuilder)this.cueBuilders.get(v3)).build(0x80000000);
            arrayList0.add(cue0);
            if(cue0 != null) {
                v1 = Math.min(v1, cue0.positionAnchor);
            }
        }
        List list0 = new ArrayList(v);
        for(int v2 = 0; v2 < v; ++v2) {
            Cue cue1 = (Cue)arrayList0.get(v2);
            if(cue1 != null) {
                if(cue1.positionAnchor != v1) {
                    cue1 = ((CueBuilder)this.cueBuilders.get(v2)).build(v1);
                }
                ((ArrayList)list0).add(cue1);
            }
        }
        return list0;
    }

    private static char getExtendedEsFrChar(byte b) {
        return (char)Cea608Decoder.SPECIAL_ES_FR_CHARACTER_SET[b & 0x1F];
    }

    private static char getExtendedPtDeChar(byte b) {
        return (char)Cea608Decoder.SPECIAL_PT_DE_CHARACTER_SET[b & 0x1F];
    }

    private static char getExtendedWestEuropeanChar(byte b, byte b1) {
        return (b & 1) == 0 ? Cea608Decoder.getExtendedEsFrChar(b1) : Cea608Decoder.getExtendedPtDeChar(b1);
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public String getName() {
        return "Cea608Decoder";
    }

    private static char getSpecialNorthAmericanChar(byte b) {
        return (char)Cea608Decoder.SPECIAL_CHARACTER_SET[b & 15];
    }

    private void handleMidrowCtrl(byte b) {
        this.currentCueBuilder.append(' ');
        this.currentCueBuilder.setStyle(b >> 1 & 7, (b & 1) == 1);
    }

    private void handleMiscCode(byte b) {
        switch(b) {
            case 0x20: {
                this.setCaptionMode(2);
                return;
            }
            case 37: {
                this.setCaptionMode(1);
                this.setCaptionRowCount(2);
                return;
            }
            case 38: {
                this.setCaptionMode(1);
                this.setCaptionRowCount(3);
                return;
            }
            case 39: {
                this.setCaptionMode(1);
                this.setCaptionRowCount(4);
                return;
            }
            case 41: {
                this.setCaptionMode(3);
                return;
            }
            default: {
                int v = this.captionMode;
                if(v != 0) {
                    if(b == 33) {
                        this.currentCueBuilder.backspace();
                        return;
                    }
                    switch(b) {
                        case 44: {
                            this.cues = Collections.EMPTY_LIST;
                            if(v == 1 || v == 3) {
                                this.resetCueBuilders();
                                return;
                            }
                            break;
                        }
                        case 45: {
                            if(v == 1 && !this.currentCueBuilder.isEmpty()) {
                                this.currentCueBuilder.rollUp();
                                return;
                            }
                            break;
                        }
                        case 46: {
                            this.resetCueBuilders();
                            return;
                        }
                        case 0x2F: {
                            this.cues = this.getDisplayCues();
                            this.resetCueBuilders();
                        }
                    }
                }
            }
        }
    }

    private void handlePreambleAddressCode(byte b, byte b1) {
        int v = Cea608Decoder.ROW_INDICES[b & 7];
        if((b1 & 0x20) != 0) {
            ++v;
        }
        if(v != CueBuilder.access$100(this.currentCueBuilder)) {
            if(this.captionMode != 1 && !this.currentCueBuilder.isEmpty()) {
                CueBuilder cea608Decoder$CueBuilder0 = new CueBuilder(this.captionMode, this.captionRowCount);
                this.currentCueBuilder = cea608Decoder$CueBuilder0;
                this.cueBuilders.add(cea608Decoder$CueBuilder0);
            }
            CueBuilder.access$102(this.currentCueBuilder, v);
        }
        boolean z = false;
        boolean z1 = (b1 & 16) == 16;
        if((b1 & 1) == 1) {
            z = true;
        }
        int v1 = b1 >> 1 & 7;
        this.currentCueBuilder.setStyle((z1 ? 8 : v1), z);
        if(z1) {
            CueBuilder.access$202(this.currentCueBuilder, Cea608Decoder.COLUMN_INDICES[v1]);
        }
    }

    private static boolean isCtrlCode(byte b) {
        return (b & 0xE0) == 0;
    }

    private static boolean isExtendedWestEuropeanChar(byte b, byte b1) {
        return (b & 0xF6) == 18 && (b1 & 0xE0) == 0x20;
    }

    private static boolean isMidrowCtrlCode(byte b, byte b1) {
        return (b & 0xF7) == 17 && (b1 & 0xF0) == 0x20;
    }

    private static boolean isMiscCode(byte b, byte b1) {
        return (b & 0xF6) == 20 && (b1 & 0xF0) == 0x20;
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    private static boolean isPreambleAddressCode(byte b, byte b1) {
        return (b & 0xF0) == 16 && (b1 & 0xC0) == 0x40;
    }

    private static boolean isRepeatable(byte b) {
        return (b & 0xF0) == 16;
    }

    private boolean isRepeatedCommand(boolean z, byte b, byte b1) {
        if(z && Cea608Decoder.isRepeatable(b)) {
            if(this.repeatableControlSet && this.repeatableControlCc1 == b && this.repeatableControlCc2 == b1) {
                this.repeatableControlSet = false;
                return true;
            }
            this.repeatableControlSet = true;
            this.repeatableControlCc1 = b;
            this.repeatableControlCc2 = b1;
            return false;
        }
        this.repeatableControlSet = false;
        return false;
    }

    private static boolean isServiceSwitchCommand(byte b) {
        return (b & 0xF7) == 20;
    }

    private static boolean isSpecialNorthAmericanChar(byte b, byte b1) {
        return (b & 0xF7) == 17 && (b1 & 0xF0) == 0x30;
    }

    private static boolean isTabCtrlCode(byte b, byte b1) {
        return (b & 0xF7) == 23 && b1 >= 33 && b1 <= 35;
    }

    private static boolean isXdsControlCode(byte b) {
        return 1 <= b && b <= 15;
    }

    private void maybeUpdateIsInCaptionService(byte b, byte b1) {
        if(Cea608Decoder.isXdsControlCode(b)) {
            this.isInCaptionService = false;
            return;
        }
        if(Cea608Decoder.isServiceSwitchCommand(b)) {
            if(b1 != 0x20 && b1 != 0x2F && (b1 != 37 && b1 != 38 && b1 != 39)) {
                switch(b1) {
                    case 41: {
                        break;
                    }
                    case 42: 
                    case 43: {
                        this.isInCaptionService = false;
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            this.isInCaptionService = true;
        }
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer0) {
        super.queueInputBuffer(subtitleInputBuffer0);
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void release() {
    }

    private void resetCueBuilders() {
        this.currentCueBuilder.reset(this.captionMode);
        this.cueBuilders.clear();
        this.cueBuilders.add(this.currentCueBuilder);
    }

    private void setCaptionMode(int v) {
        int v1 = this.captionMode;
        if(v1 != v) {
            this.captionMode = v;
            if(v == 3) {
                for(int v2 = 0; v2 < this.cueBuilders.size(); ++v2) {
                    ((CueBuilder)this.cueBuilders.get(v2)).setCaptionMode(3);
                }
                return;
            }
            this.resetCueBuilders();
            if(v1 == 3 || (v == 0 || v == 1)) {
                this.cues = Collections.EMPTY_LIST;
            }
        }
    }

    private void setCaptionRowCount(int v) {
        this.captionRowCount = v;
        this.currentCueBuilder.setCaptionRowCount(v);
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void setPositionUs(long v) {
        super.setPositionUs(v);
    }

    private boolean updateAndVerifyCurrentChannel(byte b) {
        if(Cea608Decoder.isCtrlCode(b)) {
            this.currentChannel = b >> 3 & 1;
        }
        return this.currentChannel == this.selectedChannel;
    }
}

