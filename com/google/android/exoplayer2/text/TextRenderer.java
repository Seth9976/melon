package com.google.android.exoplayer2.text;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MSG_UPDATE_OUTPUT = 0;
    private static final int REPLACEMENT_STATE_NONE = 0;
    private static final int REPLACEMENT_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int REPLACEMENT_STATE_WAIT_END_OF_STREAM = 2;
    private static final String TAG = "TextRenderer";
    private SubtitleDecoder decoder;
    private final SubtitleDecoderFactory decoderFactory;
    private int decoderReplacementState;
    private final FormatHolder formatHolder;
    private boolean inputStreamEnded;
    private SubtitleInputBuffer nextInputBuffer;
    private SubtitleOutputBuffer nextSubtitle;
    private int nextSubtitleEventIndex;
    private final TextOutput output;
    private final Handler outputHandler;
    private boolean outputStreamEnded;
    private Format streamFormat;
    private SubtitleOutputBuffer subtitle;

    public TextRenderer(TextOutput textOutput0, Looper looper0) {
        this(textOutput0, looper0, SubtitleDecoderFactory.DEFAULT);
    }

    public TextRenderer(TextOutput textOutput0, Looper looper0, SubtitleDecoderFactory subtitleDecoderFactory0) {
        super(3);
        this.output = (TextOutput)Assertions.checkNotNull(textOutput0);
        this.outputHandler = looper0 == null ? null : Util.createHandler(looper0, this);
        this.decoderFactory = subtitleDecoderFactory0;
        this.formatHolder = new FormatHolder();
    }

    private void clearOutput() {
        this.updateOutput(Collections.EMPTY_LIST);
    }

    private long getNextEventTime() {
        return this.nextSubtitleEventIndex == -1 || this.nextSubtitleEventIndex >= this.subtitle.getEventTimeCount() ? 0x7FFFFFFFFFFFFFFFL : this.subtitle.getEventTime(this.nextSubtitleEventIndex);
    }

    private void handleDecoderError(SubtitleDecoderException subtitleDecoderException0) {
        Log.e("TextRenderer", "Subtitle decoding failed. streamFormat=" + this.streamFormat, subtitleDecoderException0);
        this.resetOutputAndDecoder();
    }

    @Override  // android.os.Handler$Callback
    public boolean handleMessage(Message message0) {
        if(message0.what != 0) {
            throw new IllegalStateException();
        }
        this.invokeUpdateOutputInternal(((List)message0.obj));
        return true;
    }

    private void invokeUpdateOutputInternal(List list0) {
        this.output.onCues(list0);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.streamFormat = null;
        this.clearOutput();
        this.releaseDecoder();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long v, boolean z) {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        this.resetOutputAndDecoder();
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] arr_format, long v) {
        Format format0 = arr_format[0];
        this.streamFormat = format0;
        if(this.decoder != null) {
            this.decoderReplacementState = 1;
            return;
        }
        this.decoder = this.decoderFactory.createDecoder(format0);
    }

    private void releaseBuffers() {
        this.nextInputBuffer = null;
        this.nextSubtitleEventIndex = -1;
        SubtitleOutputBuffer subtitleOutputBuffer0 = this.subtitle;
        if(subtitleOutputBuffer0 != null) {
            subtitleOutputBuffer0.release();
            this.subtitle = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer1 = this.nextSubtitle;
        if(subtitleOutputBuffer1 != null) {
            subtitleOutputBuffer1.release();
            this.nextSubtitle = null;
        }
    }

    private void releaseDecoder() {
        this.releaseBuffers();
        this.decoder.release();
        this.decoder = null;
        this.decoderReplacementState = 0;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public void render(long v, long v1) {
        if(this.outputStreamEnded) {
            return;
        }
        else {
            if(this.nextSubtitle == null) {
                this.decoder.setPositionUs(v);
                try {
                    this.nextSubtitle = (SubtitleOutputBuffer)this.decoder.dequeueOutputBuffer();
                }
                catch(SubtitleDecoderException subtitleDecoderException0) {
                    this.handleDecoderError(subtitleDecoderException0);
                    return;
                }
            }
            if(this.getState() == 2) {
                if(this.subtitle == null) {
                    z = false;
                }
                else {
                    long v2 = this.getNextEventTime();
                    boolean z;
                    for(z = false; v2 <= v; z = true) {
                        ++this.nextSubtitleEventIndex;
                        v2 = this.getNextEventTime();
                    }
                }
                SubtitleOutputBuffer subtitleOutputBuffer0 = this.nextSubtitle;
                if(subtitleOutputBuffer0 != null) {
                    if(!subtitleOutputBuffer0.isEndOfStream()) {
                        if(this.nextSubtitle.timeUs <= v) {
                            SubtitleOutputBuffer subtitleOutputBuffer1 = this.subtitle;
                            if(subtitleOutputBuffer1 != null) {
                                subtitleOutputBuffer1.release();
                            }
                            SubtitleOutputBuffer subtitleOutputBuffer2 = this.nextSubtitle;
                            this.subtitle = subtitleOutputBuffer2;
                            this.nextSubtitle = null;
                            this.nextSubtitleEventIndex = subtitleOutputBuffer2.getNextEventTimeIndex(v);
                            z = true;
                        }
                    }
                    else if(!z && this.getNextEventTime() == 0x7FFFFFFFFFFFFFFFL) {
                        if(this.decoderReplacementState == 2) {
                            this.replaceDecoder();
                        }
                        else {
                            this.releaseBuffers();
                            this.outputStreamEnded = true;
                        }
                    }
                }
                if(z) {
                    this.updateOutput(this.subtitle.getCues(v));
                }
                if(this.decoderReplacementState != 2) {
                    try {
                        while(!this.inputStreamEnded) {
                            if(this.nextInputBuffer == null) {
                                SubtitleInputBuffer subtitleInputBuffer0 = (SubtitleInputBuffer)this.decoder.dequeueInputBuffer();
                                this.nextInputBuffer = subtitleInputBuffer0;
                                if(subtitleInputBuffer0 == null) {
                                    return;
                                }
                            }
                            if(this.decoderReplacementState == 1) {
                                this.nextInputBuffer.setFlags(4);
                                this.decoder.queueInputBuffer(this.nextInputBuffer);
                                this.nextInputBuffer = null;
                                this.decoderReplacementState = 2;
                                return;
                            }
                            int v3 = this.readSource(this.formatHolder, this.nextInputBuffer, false);
                            if(v3 == -4) {
                                if(this.nextInputBuffer.isEndOfStream()) {
                                    this.inputStreamEnded = true;
                                }
                                else {
                                    this.nextInputBuffer.subsampleOffsetUs = this.formatHolder.format.subsampleOffsetUs;
                                    this.nextInputBuffer.flip();
                                }
                                this.decoder.queueInputBuffer(this.nextInputBuffer);
                                this.nextInputBuffer = null;
                            }
                            else if(v3 == -3) {
                                break;
                            }
                        }
                        return;
                    }
                    catch(SubtitleDecoderException subtitleDecoderException1) {
                    }
                }
            }
        }
        this.handleDecoderError(subtitleDecoderException1);
    }

    private void replaceDecoder() {
        this.releaseDecoder();
        this.decoder = this.decoderFactory.createDecoder(this.streamFormat);
    }

    private void resetOutputAndDecoder() {
        this.clearOutput();
        if(this.decoderReplacementState != 0) {
            this.replaceDecoder();
            return;
        }
        this.releaseBuffers();
        this.decoder.flush();
    }

    // 去混淆评级： 低(43)
    @Override  // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format0) {
        if(this.decoderFactory.supportsFormat(format0)) {
            return BaseRenderer.supportsFormatDrm(null, format0.drmInitData) ? 4 : 2;
        }
        return MimeTypes.isText(format0.sampleMimeType) ? 1 : 0;
    }

    private void updateOutput(List list0) {
        Handler handler0 = this.outputHandler;
        if(handler0 != null) {
            handler0.obtainMessage(0, list0).sendToTarget();
            return;
        }
        this.invokeUpdateOutputInternal(list0);
    }
}

