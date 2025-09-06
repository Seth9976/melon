package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class WebvttDecoder extends SimpleSubtitleDecoder {
    private static final String COMMENT_START = "NOTE";
    private static final int EVENT_COMMENT = 1;
    private static final int EVENT_CUE = 3;
    private static final int EVENT_END_OF_FILE = 0;
    private static final int EVENT_NONE = -1;
    private static final int EVENT_STYLE_BLOCK = 2;
    private static final String STYLE_START = "STYLE";
    private final CssParser cssParser;
    private final WebvttCueParser cueParser;
    private final List definedStyles;
    private final ParsableByteArray parsableWebvttData;
    private final Builder webvttCueBuilder;

    public WebvttDecoder() {
        super("WebvttDecoder");
        this.cueParser = new WebvttCueParser();
        this.parsableWebvttData = new ParsableByteArray();
        this.webvttCueBuilder = new Builder();
        this.cssParser = new CssParser();
        this.definedStyles = new ArrayList();
    }

    @Override  // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] arr_b, int v, boolean z) {
        this.parsableWebvttData.reset(arr_b, v);
        this.webvttCueBuilder.reset();
        this.definedStyles.clear();
        try {
            WebvttParserUtil.validateWebvttHeaderLine(this.parsableWebvttData);
        }
        catch(ParserException parserException0) {
            throw new SubtitleDecoderException(parserException0);
        }
        while(!TextUtils.isEmpty(this.parsableWebvttData.readLine())) {
        }
        ArrayList arrayList0 = new ArrayList();
        while(true) {
            switch(WebvttDecoder.getNextEvent(this.parsableWebvttData)) {
                case 0: {
                    return new WebvttSubtitle(arrayList0);
                }
                case 1: {
                    WebvttDecoder.skipComment(this.parsableWebvttData);
                    break;
                }
                case 2: {
                    if(!arrayList0.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.parsableWebvttData.readLine();
                    List list0 = this.cssParser.parseBlock(this.parsableWebvttData);
                    this.definedStyles.addAll(list0);
                    break;
                }
                case 3: {
                    if(!this.cueParser.parseCue(this.parsableWebvttData, this.webvttCueBuilder, this.definedStyles)) {
                        break;
                    }
                    arrayList0.add(this.webvttCueBuilder.build());
                    this.webvttCueBuilder.reset();
                }
            }
        }
    }

    // This method was un-flattened
    private static int getNextEvent(ParsableByteArray parsableByteArray0) {
        int v1;
        int v = parsableByteArray0.getPosition();
        String s = parsableByteArray0.readLine();
        if(s == null) {
            v1 = 0;
        }
        else if("STYLE".equals(s)) {
            v1 = 2;
        }
        else {
            v1 = s.startsWith("NOTE") ? 1 : 3;
        }
        parsableByteArray0.setPosition(v);
        return v1;
    }

    private static void skipComment(ParsableByteArray parsableByteArray0) {
        while(!TextUtils.isEmpty(parsableByteArray0.readLine())) {
        }
    }
}

