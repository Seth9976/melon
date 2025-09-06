package com.google.android.exoplayer2.metadata;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.emsg.EventMessageDecoder;
import com.google.android.exoplayer2.metadata.icy.IcyDecoder;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.scte35.SpliceInfoDecoder;

public interface MetadataDecoderFactory {
    public static final MetadataDecoderFactory DEFAULT;

    static {
        MetadataDecoderFactory.DEFAULT = new MetadataDecoderFactory() {
            @Override  // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
            public MetadataDecoder createDecoder(Format format0) {
                String s = format0.sampleMimeType;
                if(s != null) {
                    switch(s) {
                        case "application/id3": {
                            return new Id3Decoder();
                        }
                        case "application/x-emsg": {
                            return new EventMessageDecoder();
                        }
                        case "application/x-icy": {
                            return new IcyDecoder();
                        }
                        case "application/x-scte35": {
                            return new SpliceInfoDecoder();
                        }
                    }
                }
                String s1 = String.valueOf(s);
                throw new IllegalArgumentException((s1.length() == 0 ? new String("Attempted to create decoder for unsupported MIME type: ") : "Attempted to create decoder for unsupported MIME type: " + s1));
            }

            // 去混淆评级： 低(40)
            @Override  // com.google.android.exoplayer2.metadata.MetadataDecoderFactory
            public boolean supportsFormat(Format format0) {
                return "application/id3".equals(format0.sampleMimeType) || "application/x-emsg".equals(format0.sampleMimeType) || "application/x-scte35".equals(format0.sampleMimeType) || "application/x-icy".equals(format0.sampleMimeType);
            }
        };
    }

    MetadataDecoder createDecoder(Format arg1);

    boolean supportsFormat(Format arg1);
}

