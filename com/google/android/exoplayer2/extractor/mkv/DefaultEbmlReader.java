package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayDeque;

final class DefaultEbmlReader implements EbmlReader {
    static final class MasterElement {
        private final long elementEndPosition;
        private final int elementId;

        private MasterElement(int v, long v1) {
            this.elementId = v;
            this.elementEndPosition = v1;
        }

        public MasterElement(int v, long v1, com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader.1 defaultEbmlReader$10) {
            this(v, v1);
        }
    }

    private static final int ELEMENT_STATE_READ_CONTENT = 2;
    private static final int ELEMENT_STATE_READ_CONTENT_SIZE = 1;
    private static final int ELEMENT_STATE_READ_ID = 0;
    private static final int MAX_ID_BYTES = 4;
    private static final int MAX_INTEGER_ELEMENT_SIZE_BYTES = 8;
    private static final int MAX_LENGTH_BYTES = 8;
    private static final int VALID_FLOAT32_ELEMENT_SIZE_BYTES = 4;
    private static final int VALID_FLOAT64_ELEMENT_SIZE_BYTES = 8;
    private long elementContentSize;
    private int elementId;
    private int elementState;
    private final ArrayDeque masterElementsStack;
    private EbmlProcessor processor;
    private final byte[] scratch;
    private final VarintReader varintReader;

    public DefaultEbmlReader() {
        this.scratch = new byte[8];
        this.masterElementsStack = new ArrayDeque();
        this.varintReader = new VarintReader();
    }

    @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void init(EbmlProcessor ebmlProcessor0) {
        this.processor = ebmlProcessor0;
    }

    private long maybeResyncToNextLevel1Element(ExtractorInput extractorInput0) {
        int v1;
        int v;
        extractorInput0.resetPeekPosition();
        while(true) {
            extractorInput0.peekFully(this.scratch, 0, 4);
            v = VarintReader.parseUnsignedVarintLength(this.scratch[0]);
            if(v != -1 && v <= 4) {
                v1 = (int)VarintReader.assembleVarint(this.scratch, v, false);
                if(!this.processor.isLevel1Element(v1)) {
                    goto label_6;
                }
                break;
            }
        label_6:
            extractorInput0.skipFully(1);
        }
        extractorInput0.skipFully(v);
        return (long)v1;
    }

    @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public boolean read(ExtractorInput extractorInput0) {
        Assertions.checkNotNull(this.processor);
        while(true) {
            if(!this.masterElementsStack.isEmpty() && extractorInput0.getPosition() >= ((MasterElement)this.masterElementsStack.peek()).elementEndPosition) {
                this.processor.endMasterElement(((MasterElement)this.masterElementsStack.pop()).elementId);
                return true;
            }
            if(this.elementState == 0) {
                long v = this.varintReader.readUnsignedVarint(extractorInput0, true, false, 4);
                if(v == -2L) {
                    v = this.maybeResyncToNextLevel1Element(extractorInput0);
                }
                if(v == -1L) {
                    return false;
                }
                this.elementId = (int)v;
                this.elementState = 1;
            }
            if(this.elementState == 1) {
                this.elementContentSize = this.varintReader.readUnsignedVarint(extractorInput0, false, true, 8);
                this.elementState = 2;
            }
            int v1 = this.processor.getElementType(this.elementId);
            switch(v1) {
                case 0: {
                    extractorInput0.skipFully(((int)this.elementContentSize));
                    this.elementState = 0;
                    break;
                }
                case 1: {
                    long v5 = extractorInput0.getPosition();
                    MasterElement defaultEbmlReader$MasterElement0 = new MasterElement(this.elementId, this.elementContentSize + v5, null);
                    this.masterElementsStack.push(defaultEbmlReader$MasterElement0);
                    this.processor.startMasterElement(this.elementId, v5, this.elementContentSize);
                    this.elementState = 0;
                    return true;
                }
                default: {
                    if(v1 != 2) {
                        switch(v1) {
                            case 3: {
                                long v3 = this.elementContentSize;
                                if(v3 > 0x7FFFFFFFL) {
                                    throw new ParserException("String element size: " + this.elementContentSize);
                                }
                                this.processor.stringElement(this.elementId, this.readString(extractorInput0, ((int)v3)));
                                this.elementState = 0;
                                return true;
                            }
                            case 4: {
                                this.processor.binaryElement(this.elementId, ((int)this.elementContentSize), extractorInput0);
                                this.elementState = 0;
                                return true;
                            }
                            default: {
                                if(v1 != 5) {
                                    throw new ParserException("Invalid element type " + v1);
                                }
                                long v2 = this.elementContentSize;
                                if(v2 != 4L && v2 != 8L) {
                                    throw new ParserException("Invalid float size: " + this.elementContentSize);
                                }
                                this.processor.floatElement(this.elementId, this.readFloat(extractorInput0, ((int)v2)));
                                this.elementState = 0;
                                return true;
                            }
                        }
                    }
                    long v4 = this.elementContentSize;
                    if(v4 > 8L) {
                        throw new ParserException("Invalid integer size: " + this.elementContentSize);
                    }
                    this.processor.integerElement(this.elementId, this.readInteger(extractorInput0, ((int)v4)));
                    this.elementState = 0;
                    return true;
                }
            }
        }
    }

    private double readFloat(ExtractorInput extractorInput0, int v) {
        long v1 = this.readInteger(extractorInput0, v);
        return v == 4 ? ((double)Float.intBitsToFloat(((int)v1))) : Double.longBitsToDouble(v1);
    }

    private long readInteger(ExtractorInput extractorInput0, int v) {
        extractorInput0.readFully(this.scratch, 0, v);
        long v2 = 0L;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 = v2 << 8 | ((long)(this.scratch[v1] & 0xFF));
        }
        return v2;
    }

    private String readString(ExtractorInput extractorInput0, int v) {
        if(v == 0) {
            return "";
        }
        byte[] arr_b = new byte[v];
        extractorInput0.readFully(arr_b, 0, v);
        while(v > 0 && arr_b[v - 1] == 0) {
            --v;
        }
        return new String(arr_b, 0, v);
    }

    @Override  // com.google.android.exoplayer2.extractor.mkv.EbmlReader
    public void reset() {
        this.elementState = 0;
        this.masterElementsStack.clear();
        this.varintReader.reset();
    }

    class com.google.android.exoplayer2.extractor.mkv.DefaultEbmlReader.1 {
    }

}

