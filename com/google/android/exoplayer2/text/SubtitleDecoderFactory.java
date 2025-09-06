package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.google.android.exoplayer2.text.dvb.DvbDecoder;
import com.google.android.exoplayer2.text.pgs.PgsDecoder;
import com.google.android.exoplayer2.text.ssa.SsaDecoder;
import com.google.android.exoplayer2.text.subrip.SubripDecoder;
import com.google.android.exoplayer2.text.ttml.TtmlDecoder;
import com.google.android.exoplayer2.text.tx3g.Tx3gDecoder;
import com.google.android.exoplayer2.text.webvtt.Mp4WebvttDecoder;
import com.google.android.exoplayer2.text.webvtt.WebvttDecoder;

public interface SubtitleDecoderFactory {
    public static final SubtitleDecoderFactory DEFAULT;

    static {
        SubtitleDecoderFactory.DEFAULT = new SubtitleDecoderFactory() {
            @Override  // com.google.android.exoplayer2.text.SubtitleDecoderFactory
            public SubtitleDecoder createDecoder(Format format0) {
                String s = format0.sampleMimeType;
                if(s != null) {
                    switch(s) {
                        case "application/cea-608": {
                            return new Cea608Decoder(s, format0.accessibilityChannel);
                        }
                        case "application/cea-708": {
                            return new Cea708Decoder(format0.accessibilityChannel, format0.initializationData);
                        }
                        case "application/dvbsubs": {
                            return new DvbDecoder(format0.initializationData);
                        }
                        case "application/pgs": {
                            return new PgsDecoder();
                        }
                        case "application/ttml+xml": {
                            return new TtmlDecoder();
                        }
                        case "application/x-mp4-cea-608": {
                            return new Cea608Decoder(s, format0.accessibilityChannel);
                        }
                        case "application/x-mp4-vtt": {
                            return new Mp4WebvttDecoder();
                        }
                        case "application/x-quicktime-tx3g": {
                            return new Tx3gDecoder(format0.initializationData);
                        }
                        case "application/x-subrip": {
                            return new SubripDecoder();
                        }
                        case "text/vtt": {
                            return new WebvttDecoder();
                        }
                        case "text/x-ssa": {
                            return new SsaDecoder(format0.initializationData);
                        }
                    }
                }
                String s1 = String.valueOf(s);
                throw new IllegalArgumentException((s1.length() == 0 ? new String("Attempted to create decoder for unsupported MIME type: ") : "Attempted to create decoder for unsupported MIME type: " + s1));
            }

            // 去混淆评级： 中等(110)
            @Override  // com.google.android.exoplayer2.text.SubtitleDecoderFactory
            public boolean supportsFormat(Format format0) {
                return "text/vtt".equals(format0.sampleMimeType) || "text/x-ssa".equals(format0.sampleMimeType) || "application/ttml+xml".equals(format0.sampleMimeType) || "application/x-mp4-vtt".equals(format0.sampleMimeType) || "application/x-subrip".equals(format0.sampleMimeType) || "application/x-quicktime-tx3g".equals(format0.sampleMimeType) || "application/cea-608".equals(format0.sampleMimeType) || "application/x-mp4-cea-608".equals(format0.sampleMimeType) || "application/cea-708".equals(format0.sampleMimeType) || "application/dvbsubs".equals(format0.sampleMimeType) || "application/pgs".equals(format0.sampleMimeType);
            }
        };
    }

    SubtitleDecoder createDecoder(Format arg1);

    boolean supportsFormat(Format arg1);
}

