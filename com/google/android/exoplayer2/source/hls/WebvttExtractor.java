package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap.Unseekable;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class WebvttExtractor implements Extractor {
    private static final int HEADER_MAX_LENGTH = 9;
    private static final int HEADER_MIN_LENGTH = 6;
    private static final Pattern LOCAL_TIMESTAMP;
    private static final Pattern MEDIA_TIMESTAMP;
    private final String language;
    private ExtractorOutput output;
    private byte[] sampleData;
    private final ParsableByteArray sampleDataWrapper;
    private int sampleSize;
    private final TimestampAdjuster timestampAdjuster;

    static {
        WebvttExtractor.LOCAL_TIMESTAMP = Pattern.compile("LOCAL:([^,]+)");
        WebvttExtractor.MEDIA_TIMESTAMP = Pattern.compile("MPEGTS:(-?\\d+)");
    }

    public WebvttExtractor(String s, TimestampAdjuster timestampAdjuster0) {
        this.language = s;
        this.timestampAdjuster = timestampAdjuster0;
        this.sampleDataWrapper = new ParsableByteArray();
        this.sampleData = new byte[0x400];
    }

    @RequiresNonNull({"output"})
    private TrackOutput buildTrackOutput(long v) {
        TrackOutput trackOutput0 = this.output.track(0, 3);
        trackOutput0.format(Format.createTextSampleFormat(null, "text/vtt", null, -1, 0, this.language, null, v));
        this.output.endTracks();
        return trackOutput0;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput0) {
        this.output = extractorOutput0;
        extractorOutput0.seekMap(new Unseekable(0x8000000000000001L));
    }

    @RequiresNonNull({"output"})
    private void processSample() {
        ParsableByteArray parsableByteArray0 = new ParsableByteArray(this.sampleData);
        WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray0);
        String s = parsableByteArray0.readLine();
        long v = 0L;
        long v1 = 0L;
        while(!TextUtils.isEmpty(s)) {
            if(s.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher0 = WebvttExtractor.LOCAL_TIMESTAMP.matcher(s);
                if(!matcher0.find()) {
                    throw new ParserException((s.length() == 0 ? new String("X-TIMESTAMP-MAP doesn\'t contain local timestamp: ") : "X-TIMESTAMP-MAP doesn\'t contain local timestamp: " + s));
                }
                Matcher matcher1 = WebvttExtractor.MEDIA_TIMESTAMP.matcher(s);
                if(!matcher1.find()) {
                    throw new ParserException((s.length() == 0 ? new String("X-TIMESTAMP-MAP doesn\'t contain media timestamp: ") : "X-TIMESTAMP-MAP doesn\'t contain media timestamp: " + s));
                }
                v1 = WebvttParserUtil.parseTimestampUs(matcher0.group(1));
                v = TimestampAdjuster.ptsToUs(Long.parseLong(matcher1.group(1)));
            }
            s = parsableByteArray0.readLine();
        }
        Matcher matcher2 = WebvttParserUtil.findNextCueHeader(parsableByteArray0);
        if(matcher2 == null) {
            this.buildTrackOutput(0L);
            return;
        }
        long v2 = WebvttParserUtil.parseTimestampUs(matcher2.group(1));
        long v3 = this.timestampAdjuster.adjustTsTimestamp((v + v2 - v1) * 90000L / 1000000L);
        TrackOutput trackOutput0 = this.buildTrackOutput(v3 - v2);
        this.sampleDataWrapper.reset(this.sampleData, this.sampleSize);
        trackOutput0.sampleData(this.sampleDataWrapper, this.sampleSize);
        trackOutput0.sampleMetadata(v3, 1, this.sampleSize, 0, null);
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput0, PositionHolder positionHolder0) {
        Assertions.checkNotNull(this.output);
        int v = (int)extractorInput0.getLength();
        byte[] arr_b = this.sampleData;
        if(this.sampleSize == arr_b.length) {
            this.sampleData = Arrays.copyOf(arr_b, (v == -1 ? arr_b.length : v) * 3 / 2);
        }
        int v1 = extractorInput0.read(this.sampleData, this.sampleSize, this.sampleData.length - this.sampleSize);
        if(v1 != -1) {
            int v2 = this.sampleSize + v1;
            this.sampleSize = v2;
            if(v == -1 || v2 != v) {
                return 0;
            }
        }
        this.processSample();
        return -1;
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long v, long v1) {
        throw new IllegalStateException();
    }

    @Override  // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput0) {
        extractorInput0.peekFully(this.sampleData, 0, 6, false);
        this.sampleDataWrapper.reset(this.sampleData, 6);
        if(WebvttParserUtil.isWebvttHeaderLine(this.sampleDataWrapper)) {
            return true;
        }
        extractorInput0.peekFully(this.sampleData, 6, 3, false);
        this.sampleDataWrapper.reset(this.sampleData, 9);
        return WebvttParserUtil.isWebvttHeaderLine(this.sampleDataWrapper);
    }
}

