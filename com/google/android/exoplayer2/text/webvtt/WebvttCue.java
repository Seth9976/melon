package com.google.android.exoplayer2.text.webvtt;

import android.text.Layout.Alignment;
import b3.Z;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class WebvttCue extends Cue {
    public static class Builder {
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface TextAlignment {
        }

        private static final String TAG = "WebvttCueBuilder";
        public static final int TEXT_ALIGNMENT_CENTER = 2;
        public static final int TEXT_ALIGNMENT_END = 3;
        public static final int TEXT_ALIGNMENT_LEFT = 4;
        public static final int TEXT_ALIGNMENT_RIGHT = 5;
        public static final int TEXT_ALIGNMENT_START = 1;
        private long endTime;
        private float line;
        private int lineAnchor;
        private int lineType;
        private float position;
        private int positionAnchor;
        private long startTime;
        private CharSequence text;
        private int textAlignment;
        private float width;

        public Builder() {
            this.reset();
        }

        public WebvttCue build() {
            this.line = Builder.computeLine(this.line, this.lineType);
            if(this.position == -3.402823E+38f) {
                this.position = Builder.derivePosition(this.textAlignment);
            }
            if(this.positionAnchor == 0x80000000) {
                this.positionAnchor = Builder.derivePositionAnchor(this.textAlignment);
            }
            this.width = Math.min(this.width, Builder.deriveMaxSize(this.positionAnchor, this.position));
            return new WebvttCue(this.startTime, this.endTime, ((CharSequence)Assertions.checkNotNull(this.text)), Builder.convertTextAlignment(this.textAlignment), this.line, this.lineType, this.lineAnchor, this.position, this.positionAnchor, this.width, null);
        }

        private static float computeLine(float f, int v) {
            int v1 = Float.compare(f, -3.402823E+38f);
            if(v1 != 0 && v == 0 && (f < 0.0f || f > 1.0f)) {
                return 1.0f;
            }
            if(v1 != 0) {
                return f;
            }
            return v == 0 ? 1.0f : -3.402823E+38f;
        }

        private static Layout.Alignment convertTextAlignment(int v) {
            switch(v) {
                case 2: {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                case 1: 
                case 4: {
                    return Layout.Alignment.ALIGN_NORMAL;
                }
                case 3: 
                case 5: {
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                default: {
                    Z.q(34, v, "Unknown textAlignment: ", "WebvttCueBuilder");
                    return null;
                }
            }
        }

        private static float deriveMaxSize(int v, float f) {
            switch(v) {
                case 0: {
                    return 1.0f - f;
                }
                case 1: {
                    return Float.compare(f, 0.5f) > 0 ? (1.0f - f) * 2.0f : f * 2.0f;
                }
                case 2: {
                    return f;
                }
                default: {
                    throw new IllegalStateException(String.valueOf(v));
                }
            }
        }

        private static float derivePosition(int v) {
            switch(v) {
                case 4: {
                    return 0.0f;
                }
                case 5: {
                    return 1.0f;
                }
                default: {
                    return 0.5f;
                }
            }
        }

        private static int derivePositionAnchor(int v) {
            switch(v) {
                case 1: 
                case 4: {
                    return 0;
                }
                case 3: 
                case 5: {
                    return 2;
                }
                default: {
                    return 1;
                }
            }
        }

        public void reset() {
            this.startTime = 0L;
            this.endTime = 0L;
            this.text = null;
            this.textAlignment = 2;
            this.line = -3.402823E+38f;
            this.lineType = 1;
            this.lineAnchor = 0;
            this.position = -3.402823E+38f;
            this.positionAnchor = 0x80000000;
            this.width = 1.0f;
        }

        public Builder setEndTime(long v) {
            this.endTime = v;
            return this;
        }

        public Builder setLine(float f) {
            this.line = f;
            return this;
        }

        public Builder setLineAnchor(int v) {
            this.lineAnchor = v;
            return this;
        }

        public Builder setLineType(int v) {
            this.lineType = v;
            return this;
        }

        public Builder setPosition(float f) {
            this.position = f;
            return this;
        }

        public Builder setPositionAnchor(int v) {
            this.positionAnchor = v;
            return this;
        }

        public Builder setStartTime(long v) {
            this.startTime = v;
            return this;
        }

        public Builder setText(CharSequence charSequence0) {
            this.text = charSequence0;
            return this;
        }

        public Builder setTextAlignment(int v) {
            this.textAlignment = v;
            return this;
        }

        public Builder setWidth(float f) {
            this.width = f;
            return this;
        }
    }

    private static final float DEFAULT_POSITION = 0.5f;
    public final long endTime;
    public final long startTime;

    private WebvttCue(long v, long v1, CharSequence charSequence0, Layout.Alignment layout$Alignment0, float f, int v2, int v3, float f1, int v4, float f2) {
        super(charSequence0, layout$Alignment0, f, v2, v3, f1, v4, f2);
        this.startTime = v;
        this.endTime = v1;
    }

    public WebvttCue(long v, long v1, CharSequence charSequence0, Layout.Alignment layout$Alignment0, float f, int v2, int v3, float f1, int v4, float f2, com.google.android.exoplayer2.text.webvtt.WebvttCue.1 webvttCue$10) {
        this(v, v1, charSequence0, layout$Alignment0, f, v2, v3, f1, v4, f2);
    }

    public boolean isNormalCue() {
        return this.line == -3.402823E+38f && this.position == 0.5f;
    }

    class com.google.android.exoplayer2.text.webvtt.WebvttCue.1 {
    }

}

