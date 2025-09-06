package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class SectionReader implements TsPayloadReader {
    private static final int DEFAULT_SECTION_BUFFER_LENGTH = 0x20;
    private static final int MAX_SECTION_LENGTH = 0x1002;
    private static final int SECTION_HEADER_LENGTH = 3;
    private int bytesRead;
    private final SectionPayloadReader reader;
    private final ParsableByteArray sectionData;
    private boolean sectionSyntaxIndicator;
    private int totalSectionLength;
    private boolean waitingForPayloadStart;

    public SectionReader(SectionPayloadReader sectionPayloadReader0) {
        this.reader = sectionPayloadReader0;
        this.sectionData = new ParsableByteArray(0x20);
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void consume(ParsableByteArray parsableByteArray0, int v) {
        boolean z = (v & 1) != 0;
        int v1 = z ? parsableByteArray0.getPosition() + parsableByteArray0.readUnsignedByte() : -1;
        if(!this.waitingForPayloadStart) {
        label_7:
            while(parsableByteArray0.bytesLeft() > 0) {
                int v2 = this.bytesRead;
                if(v2 < 3) {
                    if(v2 == 0) {
                        int v3 = parsableByteArray0.readUnsignedByte();
                        parsableByteArray0.setPosition(parsableByteArray0.getPosition() - 1);
                        if(v3 == 0xFF) {
                            this.waitingForPayloadStart = true;
                            return;
                        }
                    }
                    int v4 = Math.min(parsableByteArray0.bytesLeft(), 3 - this.bytesRead);
                    parsableByteArray0.readBytes(this.sectionData.data, this.bytesRead, v4);
                    int v5 = this.bytesRead + v4;
                    this.bytesRead = v5;
                    if(v5 != 3) {
                        continue;
                    }
                    this.sectionData.reset(3);
                    this.sectionData.skipBytes(1);
                    int v6 = this.sectionData.readUnsignedByte();
                    int v7 = this.sectionData.readUnsignedByte();
                    this.sectionSyntaxIndicator = (v6 & 0x80) != 0;
                    this.totalSectionLength = ((v6 & 15) << 8 | v7) + 3;
                    int v8 = this.totalSectionLength;
                    if(this.sectionData.capacity() >= v8) {
                        continue;
                    }
                    byte[] arr_b = this.sectionData.data;
                    this.sectionData.reset(Math.min(0x1002, Math.max(v8, arr_b.length * 2)));
                    System.arraycopy(arr_b, 0, this.sectionData.data, 0, 3);
                }
                else {
                    int v9 = Math.min(parsableByteArray0.bytesLeft(), this.totalSectionLength - this.bytesRead);
                    parsableByteArray0.readBytes(this.sectionData.data, this.bytesRead, v9);
                    int v10 = this.bytesRead + v9;
                    this.bytesRead = v10;
                    int v11 = this.totalSectionLength;
                    if(v10 == v11) {
                        if(this.sectionSyntaxIndicator) {
                            if(Util.crc32(this.sectionData.data, 0, v11, -1) != 0) {
                                this.waitingForPayloadStart = true;
                                return;
                            }
                            this.sectionData.reset(this.totalSectionLength - 4);
                        }
                        else {
                            this.sectionData.reset(v11);
                        }
                        this.reader.consume(this.sectionData);
                        this.bytesRead = 0;
                    }
                }
            }
        }
        else if(z) {
            this.waitingForPayloadStart = false;
            parsableByteArray0.setPosition(v1);
            this.bytesRead = 0;
            goto label_7;
        }
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void init(TimestampAdjuster timestampAdjuster0, ExtractorOutput extractorOutput0, TrackIdGenerator tsPayloadReader$TrackIdGenerator0) {
        this.reader.init(timestampAdjuster0, extractorOutput0, tsPayloadReader$TrackIdGenerator0);
        this.waitingForPayloadStart = true;
    }

    @Override  // com.google.android.exoplayer2.extractor.ts.TsPayloadReader
    public void seek() {
        this.waitingForPayloadStart = true;
    }
}

