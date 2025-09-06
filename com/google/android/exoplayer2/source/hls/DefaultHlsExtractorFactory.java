package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.EOFException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {
    public static final String AAC_FILE_EXTENSION = ".aac";
    public static final String AC3_FILE_EXTENSION = ".ac3";
    public static final String AC4_FILE_EXTENSION = ".ac4";
    public static final String CMF_FILE_EXTENSION_PREFIX = ".cmf";
    public static final String EC3_FILE_EXTENSION = ".ec3";
    public static final String M4_FILE_EXTENSION_PREFIX = ".m4";
    public static final String MP3_FILE_EXTENSION = ".mp3";
    public static final String MP4_FILE_EXTENSION = ".mp4";
    public static final String MP4_FILE_EXTENSION_PREFIX = ".mp4";
    public static final String VTT_FILE_EXTENSION = ".vtt";
    public static final String WEBVTT_FILE_EXTENSION = ".webvtt";
    private final boolean exposeCea608WhenMissingDeclarations;
    private final int payloadReaderFactoryFlags;

    public DefaultHlsExtractorFactory() {
        this(0, true);
    }

    public DefaultHlsExtractorFactory(int v, boolean z) {
        this.payloadReaderFactoryFlags = v;
        this.exposeCea608WhenMissingDeclarations = z;
    }

    // 去混淆评级： 低(40)
    private static Result buildResult(Extractor extractor0) {
        return extractor0 instanceof AdtsExtractor || extractor0 instanceof Ac3Extractor || extractor0 instanceof Ac4Extractor || extractor0 instanceof Mp3Extractor ? new Result(extractor0, true, DefaultHlsExtractorFactory.isReusable(extractor0)) : new Result(extractor0, false, DefaultHlsExtractorFactory.isReusable(extractor0));
    }

    private static Result buildResultForSameExtractorType(Extractor extractor0, Format format0, TimestampAdjuster timestampAdjuster0) {
        if(extractor0 instanceof WebvttExtractor) {
            return DefaultHlsExtractorFactory.buildResult(new WebvttExtractor(format0.language, timestampAdjuster0));
        }
        if(extractor0 instanceof AdtsExtractor) {
            return DefaultHlsExtractorFactory.buildResult(new AdtsExtractor());
        }
        if(extractor0 instanceof Ac3Extractor) {
            return DefaultHlsExtractorFactory.buildResult(new Ac3Extractor());
        }
        if(extractor0 instanceof Ac4Extractor) {
            return DefaultHlsExtractorFactory.buildResult(new Ac4Extractor());
        }
        return extractor0 instanceof Mp3Extractor ? DefaultHlsExtractorFactory.buildResult(new Mp3Extractor()) : null;
    }

    @Override  // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public Result createExtractor(Extractor extractor0, Uri uri0, Format format0, List list0, TimestampAdjuster timestampAdjuster0, Map map0, ExtractorInput extractorInput0) {
        if(extractor0 != null) {
            if(DefaultHlsExtractorFactory.isReusable(extractor0)) {
                return DefaultHlsExtractorFactory.buildResult(extractor0);
            }
            if(DefaultHlsExtractorFactory.buildResultForSameExtractorType(extractor0, format0, timestampAdjuster0) == null) {
                String s = extractor0.getClass().getSimpleName();
                throw new IllegalArgumentException((s.length() == 0 ? new String("Unexpected previousExtractor type: ") : "Unexpected previousExtractor type: " + s));
            }
        }
        Extractor extractor1 = this.createExtractorByFileExtension(uri0, format0, list0, timestampAdjuster0);
        extractorInput0.resetPeekPosition();
        if(DefaultHlsExtractorFactory.sniffQuietly(extractor1, extractorInput0)) {
            return DefaultHlsExtractorFactory.buildResult(extractor1);
        }
        if(!(extractor1 instanceof WebvttExtractor)) {
            WebvttExtractor webvttExtractor0 = new WebvttExtractor(format0.language, timestampAdjuster0);
            if(DefaultHlsExtractorFactory.sniffQuietly(webvttExtractor0, extractorInput0)) {
                return DefaultHlsExtractorFactory.buildResult(webvttExtractor0);
            }
        }
        if(!(extractor1 instanceof AdtsExtractor)) {
            AdtsExtractor adtsExtractor0 = new AdtsExtractor();
            if(DefaultHlsExtractorFactory.sniffQuietly(adtsExtractor0, extractorInput0)) {
                return DefaultHlsExtractorFactory.buildResult(adtsExtractor0);
            }
        }
        if(!(extractor1 instanceof Ac3Extractor)) {
            Ac3Extractor ac3Extractor0 = new Ac3Extractor();
            if(DefaultHlsExtractorFactory.sniffQuietly(ac3Extractor0, extractorInput0)) {
                return DefaultHlsExtractorFactory.buildResult(ac3Extractor0);
            }
        }
        if(!(extractor1 instanceof Ac4Extractor)) {
            Ac4Extractor ac4Extractor0 = new Ac4Extractor();
            if(DefaultHlsExtractorFactory.sniffQuietly(ac4Extractor0, extractorInput0)) {
                return DefaultHlsExtractorFactory.buildResult(ac4Extractor0);
            }
        }
        if(!(extractor1 instanceof Mp3Extractor)) {
            Mp3Extractor mp3Extractor0 = new Mp3Extractor(0, 0L);
            if(DefaultHlsExtractorFactory.sniffQuietly(mp3Extractor0, extractorInput0)) {
                return DefaultHlsExtractorFactory.buildResult(mp3Extractor0);
            }
        }
        if(!(extractor1 instanceof FragmentedMp4Extractor)) {
            FragmentedMp4Extractor fragmentedMp4Extractor0 = DefaultHlsExtractorFactory.createFragmentedMp4Extractor(timestampAdjuster0, format0, list0);
            if(DefaultHlsExtractorFactory.sniffQuietly(fragmentedMp4Extractor0, extractorInput0)) {
                return DefaultHlsExtractorFactory.buildResult(fragmentedMp4Extractor0);
            }
        }
        if(!(extractor1 instanceof TsExtractor)) {
            TsExtractor tsExtractor0 = DefaultHlsExtractorFactory.createTsExtractor(this.payloadReaderFactoryFlags, this.exposeCea608WhenMissingDeclarations, format0, list0, timestampAdjuster0);
            return DefaultHlsExtractorFactory.sniffQuietly(tsExtractor0, extractorInput0) ? DefaultHlsExtractorFactory.buildResult(tsExtractor0) : DefaultHlsExtractorFactory.buildResult(extractor1);
        }
        return DefaultHlsExtractorFactory.buildResult(extractor1);
    }

    private Extractor createExtractorByFileExtension(Uri uri0, Format format0, List list0, TimestampAdjuster timestampAdjuster0) {
        String s = uri0.getLastPathSegment();
        if(s == null) {
            s = "";
        }
        if(!"text/vtt".equals(format0.sampleMimeType) && !s.endsWith(".webvtt") && !s.endsWith(".vtt")) {
            if(s.endsWith(".aac")) {
                return new AdtsExtractor();
            }
            if(!s.endsWith(".ac3") && !s.endsWith(".ec3")) {
                if(s.endsWith(".ac4")) {
                    return new Ac4Extractor();
                }
                if(s.endsWith(".mp3")) {
                    return new Mp3Extractor(0, 0L);
                }
                return !s.endsWith(".mp4") && !s.startsWith(".m4", s.length() - 4) && !s.startsWith(".mp4", s.length() - 5) && !s.startsWith(".cmf", s.length() - 5) ? DefaultHlsExtractorFactory.createTsExtractor(this.payloadReaderFactoryFlags, this.exposeCea608WhenMissingDeclarations, format0, list0, timestampAdjuster0) : DefaultHlsExtractorFactory.createFragmentedMp4Extractor(timestampAdjuster0, format0, list0);
            }
            return new Ac3Extractor();
        }
        return new WebvttExtractor(format0.language, timestampAdjuster0);
    }

    private static FragmentedMp4Extractor createFragmentedMp4Extractor(TimestampAdjuster timestampAdjuster0, Format format0, List list0) {
        int v = DefaultHlsExtractorFactory.isFmp4Variant(format0) ? 4 : 0;
        if(list0 == null) {
            list0 = Collections.EMPTY_LIST;
        }
        return new FragmentedMp4Extractor(v, timestampAdjuster0, null, list0);
    }

    private static TsExtractor createTsExtractor(int v, boolean z, Format format0, List list0, TimestampAdjuster timestampAdjuster0) {
        int v1 = v | 16;
        if(list0 == null) {
            list0 = z ? Collections.singletonList(Format.createTextSampleFormat(null, "application/cea-608", 0, null)) : Collections.EMPTY_LIST;
        }
        else {
            v1 = v | 0x30;
        }
        String s = format0.codecs;
        if(!TextUtils.isEmpty(s)) {
            if(!"audio/mp4a-latm".equals(MimeTypes.getAudioMediaMimeType(s))) {
                v1 |= 2;
            }
            if(!"video/avc".equals(MimeTypes.getVideoMediaMimeType(s))) {
                v1 |= 4;
            }
        }
        return new TsExtractor(2, timestampAdjuster0, new DefaultTsPayloadReaderFactory(v1, list0));
    }

    private static boolean isFmp4Variant(Format format0) {
        Metadata metadata0 = format0.metadata;
        if(metadata0 == null) {
            return false;
        }
        for(int v = 0; v < metadata0.length(); ++v) {
            Entry metadata$Entry0 = metadata0.get(v);
            if(metadata$Entry0 instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry)metadata$Entry0).variantInfos.isEmpty();
            }
        }
        return false;
    }

    // 去混淆评级： 低(20)
    private static boolean isReusable(Extractor extractor0) {
        return extractor0 instanceof TsExtractor || extractor0 instanceof FragmentedMp4Extractor;
    }

    private static boolean sniffQuietly(Extractor extractor0, ExtractorInput extractorInput0) {
        try {
            return extractor0.sniff(extractorInput0);
        }
        catch(EOFException unused_ex) {
            return false;
        }
        finally {
            extractorInput0.resetPeekPosition();
        }
    }
}

