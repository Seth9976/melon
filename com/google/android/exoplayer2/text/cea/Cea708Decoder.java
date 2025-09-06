package com.google.android.exoplayer2.text.cea;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import b3.Z;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cea708Decoder extends CeaDecoder {
    static final class CueBuilder {
        private static final int BORDER_AND_EDGE_TYPE_NONE = 0;
        private static final int BORDER_AND_EDGE_TYPE_UNIFORM = 3;
        public static final int COLOR_SOLID_BLACK = 0;
        public static final int COLOR_SOLID_WHITE = 0;
        public static final int COLOR_TRANSPARENT = 0;
        private static final int DEFAULT_PRIORITY = 4;
        private static final int DIRECTION_BOTTOM_TO_TOP = 3;
        private static final int DIRECTION_LEFT_TO_RIGHT = 0;
        private static final int DIRECTION_RIGHT_TO_LEFT = 1;
        private static final int DIRECTION_TOP_TO_BOTTOM = 2;
        private static final int HORIZONTAL_SIZE = 209;
        private static final int JUSTIFICATION_CENTER = 2;
        private static final int JUSTIFICATION_FULL = 3;
        private static final int JUSTIFICATION_LEFT = 0;
        private static final int JUSTIFICATION_RIGHT = 1;
        private static final int MAXIMUM_ROW_COUNT = 15;
        private static final int PEN_FONT_STYLE_DEFAULT = 0;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITHOUT_SERIFS = 3;
        private static final int PEN_FONT_STYLE_MONOSPACED_WITH_SERIFS = 1;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITHOUT_SERIFS = 4;
        private static final int PEN_FONT_STYLE_PROPORTIONALLY_SPACED_WITH_SERIFS = 2;
        private static final int PEN_OFFSET_NORMAL = 1;
        private static final int PEN_SIZE_STANDARD = 1;
        private static final int[] PEN_STYLE_BACKGROUND = null;
        private static final int[] PEN_STYLE_EDGE_TYPE = null;
        private static final int[] PEN_STYLE_FONT_STYLE = null;
        private static final int RELATIVE_CUE_SIZE = 99;
        private static final int VERTICAL_SIZE = 74;
        private static final int[] WINDOW_STYLE_FILL;
        private static final int[] WINDOW_STYLE_JUSTIFICATION;
        private static final int[] WINDOW_STYLE_PRINT_DIRECTION;
        private static final int[] WINDOW_STYLE_SCROLL_DIRECTION;
        private static final boolean[] WINDOW_STYLE_WORD_WRAP;
        private int anchorId;
        private int backgroundColor;
        private int backgroundColorStartPosition;
        private final SpannableStringBuilder captionStringBuilder;
        private boolean defined;
        private int foregroundColor;
        private int foregroundColorStartPosition;
        private int horizontalAnchor;
        private int italicsStartPosition;
        private int justification;
        private int penStyleId;
        private int priority;
        private boolean relativePositioning;
        private final List rolledUpCaptions;
        private int row;
        private int rowCount;
        private boolean rowLock;
        private int underlineStartPosition;
        private int verticalAnchor;
        private boolean visible;
        private int windowFillColor;
        private int windowStyleId;

        static {
            CueBuilder.COLOR_SOLID_WHITE = CueBuilder.getArgbColorFromCeaColor(2, 2, 2, 0);
            int v = CueBuilder.getArgbColorFromCeaColor(0, 0, 0, 0);
            CueBuilder.COLOR_SOLID_BLACK = v;
            int v1 = CueBuilder.getArgbColorFromCeaColor(0, 0, 0, 3);
            CueBuilder.COLOR_TRANSPARENT = v1;
            CueBuilder.WINDOW_STYLE_JUSTIFICATION = new int[]{0, 0, 0, 0, 0, 2, 0};
            CueBuilder.WINDOW_STYLE_PRINT_DIRECTION = new int[]{0, 0, 0, 0, 0, 0, 2};
            CueBuilder.WINDOW_STYLE_SCROLL_DIRECTION = new int[]{3, 3, 3, 3, 3, 3, 1};
            CueBuilder.WINDOW_STYLE_WORD_WRAP = new boolean[]{false, false, false, true, true, true, false};
            CueBuilder.WINDOW_STYLE_FILL = new int[]{v, v1, v, v, v1, v, v};
            CueBuilder.PEN_STYLE_FONT_STYLE = new int[]{0, 1, 2, 3, 4, 3, 4};
            CueBuilder.PEN_STYLE_EDGE_TYPE = new int[]{0, 0, 0, 0, 0, 3, 3};
            CueBuilder.PEN_STYLE_BACKGROUND = new int[]{v, v, v, v, v, v1, v1};
        }

        public CueBuilder() {
            this.rolledUpCaptions = new ArrayList();
            this.captionStringBuilder = new SpannableStringBuilder();
            this.reset();
        }

        public void append(char c) {
            if(c == 10) {
                SpannableString spannableString0 = this.buildSpannableString();
                this.rolledUpCaptions.add(spannableString0);
                this.captionStringBuilder.clear();
                if(this.italicsStartPosition != -1) {
                    this.italicsStartPosition = 0;
                }
                if(this.underlineStartPosition != -1) {
                    this.underlineStartPosition = 0;
                }
                if(this.foregroundColorStartPosition != -1) {
                    this.foregroundColorStartPosition = 0;
                }
                if(this.backgroundColorStartPosition != -1) {
                    this.backgroundColorStartPosition = 0;
                }
                while(this.rowLock && this.rolledUpCaptions.size() >= this.rowCount || this.rolledUpCaptions.size() >= 15) {
                    this.rolledUpCaptions.remove(0);
                }
                return;
            }
            this.captionStringBuilder.append(c);
        }

        public void backspace() {
            int v = this.captionStringBuilder.length();
            if(v > 0) {
                this.captionStringBuilder.delete(v - 1, v);
            }
        }

        public Cea708Cue build() {
            int v3;
            float f3;
            int v2;
            float f1;
            float f;
            Layout.Alignment layout$Alignment0;
            if(this.isEmpty()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder();
            for(int v = 0; v < this.rolledUpCaptions.size(); ++v) {
                spannableStringBuilder0.append(((CharSequence)this.rolledUpCaptions.get(v)));
                spannableStringBuilder0.append('\n');
            }
            spannableStringBuilder0.append(this.buildSpannableString());
            switch(this.justification) {
                case 1: {
                    layout$Alignment0 = Layout.Alignment.ALIGN_OPPOSITE;
                    break;
                }
                case 2: {
                    layout$Alignment0 = Layout.Alignment.ALIGN_CENTER;
                    break;
                }
                case 0: 
                case 3: {
                    layout$Alignment0 = Layout.Alignment.ALIGN_NORMAL;
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unexpected justification value: " + this.justification);
                }
            }
            if(this.relativePositioning) {
                f = ((float)this.horizontalAnchor) / 99.0f;
                f1 = ((float)this.verticalAnchor) / 99.0f;
            }
            else {
                f = ((float)this.horizontalAnchor) / 209.0f;
                f1 = ((float)this.verticalAnchor) / 74.0f;
            }
            float f2 = f * 0.9f + 0.05f;
            int v1 = this.anchorId;
            if(v1 % 3 == 0) {
                v2 = v1;
                f3 = f2;
                v3 = 0;
            }
            else if(v1 % 3 == 1) {
                v2 = v1;
                f3 = f2;
                v3 = 1;
            }
            else {
                v2 = v1;
                f3 = f2;
                v3 = 2;
            }
            switch(v2 / 3) {
                case 0: {
                    return this.windowFillColor == CueBuilder.COLOR_SOLID_BLACK ? new Cea708Cue(spannableStringBuilder0, layout$Alignment0, f1 * 0.9f + 0.05f, 0, v3, f3, 0, -3.402823E+38f, false, this.windowFillColor, this.priority) : new Cea708Cue(spannableStringBuilder0, layout$Alignment0, f1 * 0.9f + 0.05f, 0, v3, f3, 0, -3.402823E+38f, true, this.windowFillColor, this.priority);
                }
                case 1: {
                    return this.windowFillColor == CueBuilder.COLOR_SOLID_BLACK ? new Cea708Cue(spannableStringBuilder0, layout$Alignment0, f1 * 0.9f + 0.05f, 0, v3, f3, 1, -3.402823E+38f, false, this.windowFillColor, this.priority) : new Cea708Cue(spannableStringBuilder0, layout$Alignment0, f1 * 0.9f + 0.05f, 0, v3, f3, 1, -3.402823E+38f, true, this.windowFillColor, this.priority);
                }
                default: {
                    return this.windowFillColor == CueBuilder.COLOR_SOLID_BLACK ? new Cea708Cue(spannableStringBuilder0, layout$Alignment0, f1 * 0.9f + 0.05f, 0, v3, f3, 2, -3.402823E+38f, false, this.windowFillColor, this.priority) : new Cea708Cue(spannableStringBuilder0, layout$Alignment0, f1 * 0.9f + 0.05f, 0, v3, f3, 2, -3.402823E+38f, true, this.windowFillColor, this.priority);
                }
            }
        }

        public SpannableString buildSpannableString() {
            SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(this.captionStringBuilder);
            int v = spannableStringBuilder0.length();
            if(v > 0) {
                if(this.italicsStartPosition != -1) {
                    spannableStringBuilder0.setSpan(new StyleSpan(2), this.italicsStartPosition, v, 33);
                }
                if(this.underlineStartPosition != -1) {
                    spannableStringBuilder0.setSpan(new UnderlineSpan(), this.underlineStartPosition, v, 33);
                }
                if(this.foregroundColorStartPosition != -1) {
                    spannableStringBuilder0.setSpan(new ForegroundColorSpan(this.foregroundColor), this.foregroundColorStartPosition, v, 33);
                }
                if(this.backgroundColorStartPosition != -1) {
                    spannableStringBuilder0.setSpan(new BackgroundColorSpan(this.backgroundColor), this.backgroundColorStartPosition, v, 33);
                }
            }
            return new SpannableString(spannableStringBuilder0);
        }

        public void clear() {
            this.rolledUpCaptions.clear();
            this.captionStringBuilder.clear();
            this.italicsStartPosition = -1;
            this.underlineStartPosition = -1;
            this.foregroundColorStartPosition = -1;
            this.backgroundColorStartPosition = -1;
            this.row = 0;
        }

        public void defineWindow(boolean z, boolean z1, boolean z2, int v, boolean z3, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
            this.defined = true;
            this.visible = z;
            this.rowLock = z1;
            this.priority = v;
            this.relativePositioning = z3;
            this.verticalAnchor = v1;
            this.horizontalAnchor = v2;
            this.anchorId = v5;
            if(this.rowCount != v3 + 1) {
                this.rowCount = v3 + 1;
                while(z1 && this.rolledUpCaptions.size() >= this.rowCount || this.rolledUpCaptions.size() >= 15) {
                    this.rolledUpCaptions.remove(0);
                }
            }
            if(v6 != 0 && this.windowStyleId != v6) {
                this.windowStyleId = v6;
                this.setWindowAttributes(CueBuilder.WINDOW_STYLE_FILL[v6 - 1], CueBuilder.COLOR_TRANSPARENT, CueBuilder.WINDOW_STYLE_WORD_WRAP[v6 - 1], 0, CueBuilder.WINDOW_STYLE_PRINT_DIRECTION[v6 - 1], CueBuilder.WINDOW_STYLE_SCROLL_DIRECTION[v6 - 1], CueBuilder.WINDOW_STYLE_JUSTIFICATION[v6 - 1]);
            }
            if(v7 != 0 && this.penStyleId != v7) {
                this.penStyleId = v7;
                this.setPenAttributes(0, 1, 1, false, false, CueBuilder.PEN_STYLE_EDGE_TYPE[v7 - 1], CueBuilder.PEN_STYLE_FONT_STYLE[v7 - 1]);
                this.setPenColor(CueBuilder.COLOR_SOLID_WHITE, CueBuilder.PEN_STYLE_BACKGROUND[v7 - 1], CueBuilder.COLOR_SOLID_BLACK);
            }
        }

        public static int getArgbColorFromCeaColor(int v, int v1, int v2) {
            return CueBuilder.getArgbColorFromCeaColor(v, v1, v2, 0);
        }

        public static int getArgbColorFromCeaColor(int v, int v1, int v2, int v3) {
            int v5;
            int v4 = 0;
            Assertions.checkIndex(v, 0, 4);
            Assertions.checkIndex(v1, 0, 4);
            Assertions.checkIndex(v2, 0, 4);
            Assertions.checkIndex(v3, 0, 4);
            if(v3 == 0 || v3 == 1) {
                v5 = 0xFF;
            }
            else {
                switch(v3) {
                    case 2: {
                        v5 = 0x7F;
                        break;
                    }
                    case 3: {
                        v5 = 0;
                        break;
                    }
                    default: {
                        v5 = 0xFF;
                    }
                }
            }
            if(v2 > 1) {
                v4 = 0xFF;
            }
            return Color.argb(v5, (v <= 1 ? 0 : 0xFF), (v1 <= 1 ? 0 : 0xFF), v4);
        }

        public boolean isDefined() {
            return this.defined;
        }

        // 去混淆评级： 低(20)
        public boolean isEmpty() {
            return !this.isDefined() || this.rolledUpCaptions.isEmpty() && this.captionStringBuilder.length() == 0;
        }

        public boolean isVisible() {
            return this.visible;
        }

        public void reset() {
            this.clear();
            this.defined = false;
            this.visible = false;
            this.priority = 4;
            this.relativePositioning = false;
            this.verticalAnchor = 0;
            this.horizontalAnchor = 0;
            this.anchorId = 0;
            this.rowCount = 15;
            this.rowLock = true;
            this.justification = 0;
            this.windowStyleId = 0;
            this.penStyleId = 0;
            this.windowFillColor = CueBuilder.COLOR_SOLID_BLACK;
            this.foregroundColor = CueBuilder.COLOR_SOLID_WHITE;
            this.backgroundColor = CueBuilder.COLOR_SOLID_BLACK;
        }

        public void setPenAttributes(int v, int v1, int v2, boolean z, boolean z1, int v3, int v4) {
            if(this.italicsStartPosition == -1) {
                if(z) {
                    this.italicsStartPosition = this.captionStringBuilder.length();
                }
            }
            else if(!z) {
                StyleSpan styleSpan0 = new StyleSpan(2);
                int v5 = this.italicsStartPosition;
                int v6 = this.captionStringBuilder.length();
                this.captionStringBuilder.setSpan(styleSpan0, v5, v6, 33);
                this.italicsStartPosition = -1;
            }
            if(this.underlineStartPosition != -1) {
                if(!z1) {
                    UnderlineSpan underlineSpan0 = new UnderlineSpan();
                    int v7 = this.underlineStartPosition;
                    int v8 = this.captionStringBuilder.length();
                    this.captionStringBuilder.setSpan(underlineSpan0, v7, v8, 33);
                    this.underlineStartPosition = -1;
                }
            }
            else if(z1) {
                this.underlineStartPosition = this.captionStringBuilder.length();
            }
        }

        public void setPenColor(int v, int v1, int v2) {
            if(this.foregroundColorStartPosition != -1 && this.foregroundColor != v) {
                ForegroundColorSpan foregroundColorSpan0 = new ForegroundColorSpan(this.foregroundColor);
                int v3 = this.foregroundColorStartPosition;
                int v4 = this.captionStringBuilder.length();
                this.captionStringBuilder.setSpan(foregroundColorSpan0, v3, v4, 33);
            }
            if(v != CueBuilder.COLOR_SOLID_WHITE) {
                this.foregroundColorStartPosition = this.captionStringBuilder.length();
                this.foregroundColor = v;
            }
            if(this.backgroundColorStartPosition != -1 && this.backgroundColor != v1) {
                BackgroundColorSpan backgroundColorSpan0 = new BackgroundColorSpan(this.backgroundColor);
                int v5 = this.backgroundColorStartPosition;
                int v6 = this.captionStringBuilder.length();
                this.captionStringBuilder.setSpan(backgroundColorSpan0, v5, v6, 33);
            }
            if(v1 != CueBuilder.COLOR_SOLID_BLACK) {
                this.backgroundColorStartPosition = this.captionStringBuilder.length();
                this.backgroundColor = v1;
            }
        }

        public void setPenLocation(int v, int v1) {
            if(this.row != v) {
                this.append('\n');
            }
            this.row = v;
        }

        public void setVisibility(boolean z) {
            this.visible = z;
        }

        public void setWindowAttributes(int v, int v1, boolean z, int v2, int v3, int v4, int v5) {
            this.windowFillColor = v;
            this.justification = v5;
        }
    }

    static final class DtvCcPacket {
        int currentIndex;
        public final byte[] packetData;
        public final int packetSize;
        public final int sequenceNumber;

        public DtvCcPacket(int v, int v1) {
            this.sequenceNumber = v;
            this.packetSize = v1;
            this.packetData = new byte[v1 * 2 - 1];
            this.currentIndex = 0;
        }
    }

    private static final int CC_VALID_FLAG = 4;
    private static final int CHARACTER_BIG_CARONS = 42;
    private static final int CHARACTER_BIG_OE = 44;
    private static final int CHARACTER_BOLD_BULLET = 53;
    private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
    private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
    private static final int CHARACTER_DIAERESIS_Y = 0x3F;
    private static final int CHARACTER_ELLIPSIS = 37;
    private static final int CHARACTER_FIVE_EIGHTHS = 120;
    private static final int CHARACTER_HORIZONTAL_BORDER = 0x7D;
    private static final int CHARACTER_LOWER_LEFT_BORDER = 0x7C;
    private static final int CHARACTER_LOWER_RIGHT_BORDER = 0x7E;
    private static final int CHARACTER_MN = 0x7F;
    private static final int CHARACTER_NBTSP = 33;
    private static final int CHARACTER_ONE_EIGHTH = 0x76;
    private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
    private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
    private static final int CHARACTER_SEVEN_EIGHTHS = 0x79;
    private static final int CHARACTER_SM = 61;
    private static final int CHARACTER_SMALL_CARONS = 58;
    private static final int CHARACTER_SMALL_OE = 60;
    private static final int CHARACTER_SOLID_BLOCK = 0x30;
    private static final int CHARACTER_THREE_EIGHTHS = 0x77;
    private static final int CHARACTER_TM = 57;
    private static final int CHARACTER_TSP = 0x20;
    private static final int CHARACTER_UPPER_LEFT_BORDER = 0x7F;
    private static final int CHARACTER_UPPER_RIGHT_BORDER = 0x7B;
    private static final int CHARACTER_VERTICAL_BORDER = 0x7A;
    private static final int COMMAND_BS = 8;
    private static final int COMMAND_CLW = 0x88;
    private static final int COMMAND_CR = 13;
    private static final int COMMAND_CW0 = 0x80;
    private static final int COMMAND_CW1 = 0x81;
    private static final int COMMAND_CW2 = 130;
    private static final int COMMAND_CW3 = 0x83;
    private static final int COMMAND_CW4 = 0x84;
    private static final int COMMAND_CW5 = 0x85;
    private static final int COMMAND_CW6 = 0x86;
    private static final int COMMAND_CW7 = 0x87;
    private static final int COMMAND_DF0 = 0x98;
    private static final int COMMAND_DF1 = 0x99;
    private static final int COMMAND_DF2 = 0x9A;
    private static final int COMMAND_DF3 = 0x9B;
    private static final int COMMAND_DF4 = 0x9C;
    private static final int COMMAND_DF5 = 0x9D;
    private static final int COMMAND_DF6 = 0x9E;
    private static final int COMMAND_DF7 = 0x9F;
    private static final int COMMAND_DLC = 0x8E;
    private static final int COMMAND_DLW = 140;
    private static final int COMMAND_DLY = 0x8D;
    private static final int COMMAND_DSW = 0x89;
    private static final int COMMAND_ETX = 3;
    private static final int COMMAND_EXT1 = 16;
    private static final int COMMAND_EXT1_END = 23;
    private static final int COMMAND_EXT1_START = 17;
    private static final int COMMAND_FF = 12;
    private static final int COMMAND_HCR = 14;
    private static final int COMMAND_HDW = 0x8A;
    private static final int COMMAND_NUL = 0;
    private static final int COMMAND_P16_END = 0x1F;
    private static final int COMMAND_P16_START = 24;
    private static final int COMMAND_RST = 0x8F;
    private static final int COMMAND_SPA = 0x90;
    private static final int COMMAND_SPC = 0x91;
    private static final int COMMAND_SPL = 0x92;
    private static final int COMMAND_SWA = 0x97;
    private static final int COMMAND_TGW = 0x8B;
    private static final int DTVCC_PACKET_DATA = 2;
    private static final int DTVCC_PACKET_START = 3;
    private static final int GROUP_C0_END = 0x1F;
    private static final int GROUP_C1_END = 0x9F;
    private static final int GROUP_C2_END = 0x1F;
    private static final int GROUP_C3_END = 0x9F;
    private static final int GROUP_G0_END = 0x7F;
    private static final int GROUP_G1_END = 0xFF;
    private static final int GROUP_G2_END = 0x7F;
    private static final int GROUP_G3_END = 0xFF;
    private static final int NUM_WINDOWS = 8;
    private static final String TAG = "Cea708Decoder";
    private final ParsableByteArray ccData;
    private final CueBuilder[] cueBuilders;
    private List cues;
    private CueBuilder currentCueBuilder;
    private DtvCcPacket currentDtvCcPacket;
    private int currentWindow;
    private List lastCues;
    private final int selectedServiceNumber;
    private final ParsableBitArray serviceBlockPacket;

    public Cea708Decoder(int v, List list0) {
        this.ccData = new ParsableByteArray();
        this.serviceBlockPacket = new ParsableBitArray();
        if(v == -1) {
            v = 1;
        }
        this.selectedServiceNumber = v;
        this.cueBuilders = new CueBuilder[8];
        for(int v1 = 0; v1 < 8; ++v1) {
            this.cueBuilders[v1] = new CueBuilder();
        }
        this.currentCueBuilder = this.cueBuilders[0];
        this.resetCueBuilders();
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
        while(this.ccData.bytesLeft() >= 3) {
            int v = this.ccData.readUnsignedByte();
            int v1 = v & 3;
            boolean z = false;
            byte b = (byte)this.ccData.readUnsignedByte();
            byte b1 = (byte)this.ccData.readUnsignedByte();
            if((v1 == 2 || v1 == 3) && (v & 4) == 4) {
                switch(v1) {
                    case 2: {
                        z = true;
                    label_12:
                        Assertions.checkArgument(z);
                        DtvCcPacket cea708Decoder$DtvCcPacket0 = this.currentDtvCcPacket;
                        if(cea708Decoder$DtvCcPacket0 == null) {
                            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                            continue;
                        }
                        else {
                            int v2 = cea708Decoder$DtvCcPacket0.currentIndex;
                            cea708Decoder$DtvCcPacket0.currentIndex = v2 + 1;
                            cea708Decoder$DtvCcPacket0.packetData[v2] = b;
                            cea708Decoder$DtvCcPacket0.currentIndex = v2 + 2;
                            cea708Decoder$DtvCcPacket0.packetData[v2 + 1] = b1;
                            break;
                        }
                        goto label_23;
                    }
                    case 3: {
                    label_23:
                        this.finalizeCurrentPacket();
                        DtvCcPacket cea708Decoder$DtvCcPacket1 = new DtvCcPacket((b & 0xC0) >> 6, ((b & 0x3F) == 0 ? 0x40 : b & 0x3F));
                        this.currentDtvCcPacket = cea708Decoder$DtvCcPacket1;
                        int v3 = cea708Decoder$DtvCcPacket1.currentIndex;
                        cea708Decoder$DtvCcPacket1.currentIndex = v3 + 1;
                        cea708Decoder$DtvCcPacket1.packetData[v3] = b1;
                        break;
                    }
                    default: {
                        goto label_12;
                    }
                }
                if(this.currentDtvCcPacket.currentIndex == this.currentDtvCcPacket.packetSize * 2 - 1) {
                    this.finalizeCurrentPacket();
                }
            }
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

    private void finalizeCurrentPacket() {
        if(this.currentDtvCcPacket == null) {
            return;
        }
        this.processCurrentPacket();
        this.currentDtvCcPacket = null;
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void flush() {
        super.flush();
        this.cues = null;
        this.lastCues = null;
        this.currentWindow = 0;
        this.currentCueBuilder = this.cueBuilders[0];
        this.resetCueBuilders();
        this.currentDtvCcPacket = null;
    }

    private List getDisplayCues() {
        ArrayList arrayList0 = new ArrayList();
        for(int v = 0; v < 8; ++v) {
            if(!this.cueBuilders[v].isEmpty() && this.cueBuilders[v].isVisible()) {
                arrayList0.add(this.cueBuilders[v].build());
            }
        }
        Collections.sort(arrayList0);
        return Collections.unmodifiableList(arrayList0);
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public String getName() {
        return "Cea708Decoder";
    }

    private void handleC0Command(int v) {
        switch(v) {
            case 3: {
                this.cues = this.getDisplayCues();
                break;
            }
            case 8: {
                this.currentCueBuilder.backspace();
                return;
            }
            case 12: {
                this.resetCueBuilders();
                return;
            }
            case 13: {
                this.currentCueBuilder.append('\n');
                return;
            }
            case 0: 
            case 14: {
                break;
            }
            default: {
                if(v >= 17 && v <= 23) {
                    Z.q(55, v, "Currently unsupported COMMAND_EXT1 Command: ", "Cea708Decoder");
                    this.serviceBlockPacket.skipBits(8);
                    return;
                }
                if(v >= 24 && v <= 0x1F) {
                    Z.q(54, v, "Currently unsupported COMMAND_P16 Command: ", "Cea708Decoder");
                    this.serviceBlockPacket.skipBits(16);
                    return;
                }
                Z.q(0x1F, v, "Invalid C0 command: ", "Cea708Decoder");
            }
        }
    }

    private void handleC1Command(int v) {
        int v1 = 1;
        switch(v) {
            case 0x80: 
            case 0x81: 
            case 130: 
            case 0x83: 
            case 0x84: 
            case 0x85: 
            case 0x86: 
            case 0x87: {
                if(this.currentWindow != v - 0x80) {
                    this.currentWindow = v - 0x80;
                    this.currentCueBuilder = this.cueBuilders[v - 0x80];
                    return;
                }
                break;
            }
            case 0x88: {
                while(v1 <= 8) {
                    if(this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - v1].clear();
                    }
                    ++v1;
                }
                return;
            }
            case 0x89: {
                for(int v2 = 1; v2 <= 8; ++v2) {
                    if(this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - v2].setVisibility(true);
                    }
                }
                return;
            }
            case 0x8A: {
                while(v1 <= 8) {
                    if(this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - v1].setVisibility(false);
                    }
                    ++v1;
                }
                return;
            }
            case 0x8B: {
                for(int v3 = 1; v3 <= 8; ++v3) {
                    if(this.serviceBlockPacket.readBit()) {
                        CueBuilder cea708Decoder$CueBuilder0 = this.cueBuilders[8 - v3];
                        cea708Decoder$CueBuilder0.setVisibility(!cea708Decoder$CueBuilder0.isVisible());
                    }
                }
                return;
            }
            case 140: {
                while(v1 <= 8) {
                    if(this.serviceBlockPacket.readBit()) {
                        this.cueBuilders[8 - v1].reset();
                    }
                    ++v1;
                }
                return;
            }
            case 0x8D: {
                this.serviceBlockPacket.skipBits(8);
                return;
            }
            case 0x8E: {
                break;
            }
            case 0x8F: {
                this.resetCueBuilders();
                return;
            }
            case 0x90: {
                if(!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(16);
                    return;
                }
                this.handleSetPenAttributes();
                return;
            }
            case 0x91: {
                if(!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(24);
                    return;
                }
                this.handleSetPenColor();
                return;
            }
            case 0x92: {
                if(!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(16);
                    return;
                }
                this.handleSetPenLocation();
                return;
            }
            case 0x97: {
                if(!this.currentCueBuilder.isDefined()) {
                    this.serviceBlockPacket.skipBits(0x20);
                    return;
                }
                this.handleSetWindowAttributes();
                return;
            }
            case 0x98: 
            case 0x99: 
            case 0x9A: 
            case 0x9B: 
            case 0x9C: 
            case 0x9D: 
            case 0x9E: 
            case 0x9F: {
                this.handleDefineWindow(v - 0x98);
                if(this.currentWindow != v - 0x98) {
                    this.currentWindow = v - 0x98;
                    this.currentCueBuilder = this.cueBuilders[v - 0x98];
                    return;
                }
                break;
            }
            default: {
                Z.q(0x1F, v, "Invalid C1 command: ", "Cea708Decoder");
            }
        }
    }

    private void handleC2Command(int v) {
        if(v > 7) {
            if(v <= 15) {
                this.serviceBlockPacket.skipBits(8);
                return;
            }
            if(v <= 23) {
                this.serviceBlockPacket.skipBits(16);
                return;
            }
            if(v <= 0x1F) {
                this.serviceBlockPacket.skipBits(24);
            }
        }
    }

    private void handleC3Command(int v) {
        if(v <= 0x87) {
            this.serviceBlockPacket.skipBits(0x20);
            return;
        }
        if(v <= 0x8F) {
            this.serviceBlockPacket.skipBits(40);
            return;
        }
        if(v <= 0x9F) {
            this.serviceBlockPacket.skipBits(2);
            int v1 = this.serviceBlockPacket.readBits(6);
            this.serviceBlockPacket.skipBits(v1 * 8);
        }
    }

    private void handleDefineWindow(int v) {
        CueBuilder cea708Decoder$CueBuilder0 = this.cueBuilders[v];
        this.serviceBlockPacket.skipBits(2);
        boolean z = this.serviceBlockPacket.readBit();
        boolean z1 = this.serviceBlockPacket.readBit();
        boolean z2 = this.serviceBlockPacket.readBit();
        int v1 = this.serviceBlockPacket.readBits(3);
        boolean z3 = this.serviceBlockPacket.readBit();
        int v2 = this.serviceBlockPacket.readBits(7);
        int v3 = this.serviceBlockPacket.readBits(8);
        int v4 = this.serviceBlockPacket.readBits(4);
        int v5 = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        int v6 = this.serviceBlockPacket.readBits(6);
        this.serviceBlockPacket.skipBits(2);
        cea708Decoder$CueBuilder0.defineWindow(z, z1, z2, v1, z3, v2, v3, v5, v6, v4, this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
    }

    private void handleG0Character(int v) {
        if(v == 0x7F) {
            this.currentCueBuilder.append('♫');
            return;
        }
        this.currentCueBuilder.append(((char)(v & 0xFF)));
    }

    private void handleG1Character(int v) {
        this.currentCueBuilder.append(((char)(v & 0xFF)));
    }

    private void handleG2Character(int v) {
        switch(v) {
            case 0x20: {
                this.currentCueBuilder.append(' ');
                return;
            }
            case 33: {
                this.currentCueBuilder.append(' ');
                return;
            }
            case 37: {
                this.currentCueBuilder.append('…');
                return;
            }
            case 42: {
                this.currentCueBuilder.append('Š');
                return;
            }
            case 44: {
                this.currentCueBuilder.append('Œ');
                return;
            }
            case 0x30: {
                this.currentCueBuilder.append('█');
                return;
            }
            case 49: {
                this.currentCueBuilder.append('‘');
                return;
            }
            case 50: {
                this.currentCueBuilder.append('’');
                return;
            }
            case 51: {
                this.currentCueBuilder.append('“');
                return;
            }
            case 52: {
                this.currentCueBuilder.append('”');
                return;
            }
            case 53: {
                this.currentCueBuilder.append('•');
                return;
            }
            case 57: {
                this.currentCueBuilder.append('™');
                return;
            }
            case 58: {
                this.currentCueBuilder.append('š');
                return;
            }
            case 60: {
                this.currentCueBuilder.append('œ');
                return;
            }
            case 61: {
                this.currentCueBuilder.append('℠');
                return;
            }
            case 0x3F: {
                this.currentCueBuilder.append('Ÿ');
                return;
            }
            case 0x76: {
                this.currentCueBuilder.append('⅛');
                return;
            }
            case 0x77: {
                this.currentCueBuilder.append('⅜');
                return;
            }
            case 120: {
                this.currentCueBuilder.append('⅝');
                return;
            }
            case 0x79: {
                this.currentCueBuilder.append('⅞');
                return;
            }
            case 0x7A: {
                this.currentCueBuilder.append('│');
                return;
            }
            case 0x7B: {
                this.currentCueBuilder.append('┐');
                return;
            }
            case 0x7C: {
                this.currentCueBuilder.append('└');
                return;
            }
            case 0x7D: {
                this.currentCueBuilder.append('─');
                return;
            }
            case 0x7E: {
                this.currentCueBuilder.append('┘');
                return;
            }
            case 0x7F: {
                this.currentCueBuilder.append('┌');
                return;
            }
            default: {
                Z.q(33, v, "Invalid G2 character: ", "Cea708Decoder");
            }
        }
    }

    private void handleG3Character(int v) {
        if(v == 0xA0) {
            this.currentCueBuilder.append('㏄');
            return;
        }
        Z.q(33, v, "Invalid G3 character: ", "Cea708Decoder");
        this.currentCueBuilder.append('_');
    }

    private void handleSetPenAttributes() {
        int v = this.serviceBlockPacket.readBits(4);
        int v1 = this.serviceBlockPacket.readBits(2);
        int v2 = this.serviceBlockPacket.readBits(2);
        boolean z = this.serviceBlockPacket.readBit();
        boolean z1 = this.serviceBlockPacket.readBit();
        int v3 = this.serviceBlockPacket.readBits(3);
        int v4 = this.serviceBlockPacket.readBits(3);
        this.currentCueBuilder.setPenAttributes(v, v1, v2, z, z1, v3, v4);
    }

    private void handleSetPenColor() {
        int v = this.serviceBlockPacket.readBits(2);
        int v1 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), v);
        int v2 = this.serviceBlockPacket.readBits(2);
        int v3 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), v2);
        this.serviceBlockPacket.skipBits(2);
        int v4 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        this.currentCueBuilder.setPenColor(v1, v3, v4);
    }

    private void handleSetPenLocation() {
        this.serviceBlockPacket.skipBits(4);
        int v = this.serviceBlockPacket.readBits(4);
        this.serviceBlockPacket.skipBits(2);
        int v1 = this.serviceBlockPacket.readBits(6);
        this.currentCueBuilder.setPenLocation(v, v1);
    }

    private void handleSetWindowAttributes() {
        int v = this.serviceBlockPacket.readBits(2);
        int v1 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), v);
        int v2 = this.serviceBlockPacket.readBits(2);
        int v3 = CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
        if(this.serviceBlockPacket.readBit()) {
            v2 |= 4;
        }
        boolean z = this.serviceBlockPacket.readBit();
        int v4 = this.serviceBlockPacket.readBits(2);
        int v5 = this.serviceBlockPacket.readBits(2);
        int v6 = this.serviceBlockPacket.readBits(2);
        this.serviceBlockPacket.skipBits(8);
        this.currentCueBuilder.setWindowAttributes(v1, v3, z, v2, v4, v5, v6);
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public boolean isNewSubtitleDataAvailable() {
        return this.cues != this.lastCues;
    }

    private void processCurrentPacket() {
        int v5;
        DtvCcPacket cea708Decoder$DtvCcPacket0 = this.currentDtvCcPacket;
        int v = cea708Decoder$DtvCcPacket0.currentIndex;
        int v1 = cea708Decoder$DtvCcPacket0.packetSize;
        if(v != v1 * 2 - 1) {
            Log.w("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + (v1 * 2 - 1) + ", but current index is " + v + " (sequence number " + cea708Decoder$DtvCcPacket0.sequenceNumber + "); ignoring packet");
            return;
        }
        this.serviceBlockPacket.reset(cea708Decoder$DtvCcPacket0.packetData, v);
        int v2 = this.serviceBlockPacket.readBits(3);
        int v3 = this.serviceBlockPacket.readBits(5);
        if(v2 == 7) {
            this.serviceBlockPacket.skipBits(2);
            v2 = this.serviceBlockPacket.readBits(6);
            if(v2 < 7) {
                Z.q(44, v2, "Invalid extended service number: ", "Cea708Decoder");
            }
        }
        if(v3 == 0) {
            if(v2 != 0) {
                Log.w("Cea708Decoder", "serviceNumber is non-zero (" + v2 + ") when blockSize is 0");
            }
        }
        else if(v2 == this.selectedServiceNumber) {
            boolean z = false;
            while(this.serviceBlockPacket.bitsLeft() > 0) {
                int v4 = this.serviceBlockPacket.readBits(8);
                if(v4 == 16) {
                    v5 = this.serviceBlockPacket.readBits(8);
                    if(v5 <= 0x1F) {
                        this.handleC2Command(v5);
                        continue;
                    }
                    else if(v5 <= 0x7F) {
                        this.handleG2Character(v5);
                    }
                    else if(v5 <= 0x9F) {
                        this.handleC3Command(v5);
                        continue;
                    }
                    else if(v5 <= 0xFF) {
                        this.handleG3Character(v5);
                    }
                    else {
                        goto label_51;
                    }
                }
                else {
                    if(v4 <= 0x1F) {
                        this.handleC0Command(v4);
                    }
                    else if(v4 <= 0x7F) {
                        this.handleG0Character(v4);
                        z = true;
                    }
                    else if(v4 <= 0x9F) {
                        this.handleC1Command(v4);
                        z = true;
                    }
                    else if(v4 <= 0xFF) {
                        this.handleG1Character(v4);
                        z = true;
                    }
                    else {
                        Z.q(33, v4, "Invalid base command: ", "Cea708Decoder");
                    }
                    continue;
                }
                z = true;
                continue;
            label_51:
                Z.q(37, v5, "Invalid extended command: ", "Cea708Decoder");
            }
            if(z) {
                this.cues = this.getDisplayCues();
            }
        }
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void queueInputBuffer(SubtitleInputBuffer subtitleInputBuffer0) {
        super.queueInputBuffer(subtitleInputBuffer0);
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void release() {
        super.release();
    }

    private void resetCueBuilders() {
        for(int v = 0; v < 8; ++v) {
            this.cueBuilders[v].reset();
        }
    }

    @Override  // com.google.android.exoplayer2.text.cea.CeaDecoder
    public void setPositionUs(long v) {
        super.setPositionUs(v);
    }
}

