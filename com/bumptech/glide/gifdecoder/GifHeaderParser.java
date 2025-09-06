package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.appcompat.app.o;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int DESCRIPTOR_MASK_INTERLACE_FLAG = 0x40;
    private static final int DESCRIPTOR_MASK_LCT_FLAG = 0x80;
    private static final int DESCRIPTOR_MASK_LCT_SIZE = 7;
    private static final int EXTENSION_INTRODUCER = 33;
    private static final int GCE_DISPOSAL_METHOD_SHIFT = 2;
    private static final int GCE_MASK_DISPOSAL_METHOD = 28;
    private static final int GCE_MASK_TRANSPARENT_COLOR_FLAG = 1;
    private static final int IMAGE_SEPARATOR = 44;
    private static final int LABEL_APPLICATION_EXTENSION = 0xFF;
    private static final int LABEL_COMMENT_EXTENSION = 0xFE;
    private static final int LABEL_GRAPHIC_CONTROL_EXTENSION = 0xF9;
    private static final int LABEL_PLAIN_TEXT_EXTENSION = 1;
    private static final int LSD_MASK_GCT_FLAG = 0x80;
    private static final int LSD_MASK_GCT_SIZE = 7;
    private static final int MASK_INT_LOWEST_BYTE = 0xFF;
    private static final int MAX_BLOCK_SIZE = 0x100;
    static final int MIN_FRAME_DELAY = 2;
    private static final String TAG = "GifHeaderParser";
    private static final int TRAILER = 59;
    private final byte[] block;
    private int blockSize;
    private GifHeader header;
    private ByteBuffer rawData;

    public GifHeaderParser() {
        this.block = new byte[0x100];
        this.blockSize = 0;
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    private boolean err() {
        return this.header.status != 0;
    }

    public boolean isAnimated() {
        this.readHeader();
        if(!this.err()) {
            this.readContents(2);
        }
        return this.header.frameCount > 1;
    }

    public GifHeader parseHeader() {
        if(this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if(this.err()) {
            return this.header;
        }
        this.readHeader();
        if(!this.err()) {
            this.readContents();
            GifHeader gifHeader0 = this.header;
            if(gifHeader0.frameCount < 0) {
                gifHeader0.status = 1;
            }
        }
        return this.header;
    }

    private int read() {
        try {
            return this.rawData.get() & 0xFF;
        }
        catch(Exception unused_ex) {
            this.header.status = 1;
            return 0;
        }
    }

    private void readBitmap() {
        GifFrame gifFrame0 = this.header.currentFrame;
        gifFrame0.ix = this.readShort();
        GifFrame gifFrame1 = this.header.currentFrame;
        gifFrame1.iy = this.readShort();
        GifFrame gifFrame2 = this.header.currentFrame;
        gifFrame2.iw = this.readShort();
        GifFrame gifFrame3 = this.header.currentFrame;
        gifFrame3.ih = this.readShort();
        int v = this.read();
        boolean z = false;
        int v1 = (int)Math.pow(2.0, (v & 7) + 1);
        GifFrame gifFrame4 = this.header.currentFrame;
        if((v & 0x40) != 0) {
            z = true;
        }
        gifFrame4.interlace = z;
        gifFrame4.lct = (v & 0x80) == 0 ? null : this.readColorTable(v1);
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        this.skipImageData();
        if(this.err()) {
            return;
        }
        ++this.header.frameCount;
        this.header.frames.add(this.header.currentFrame);
    }

    private void readBlock() {
        int v3;
        int v = this.read();
        this.blockSize = v;
        if(v > 0) {
            for(int v1 = 0; true; v1 += v3) {
                int v2 = this.blockSize;
                if(v1 >= v2) {
                    break;
                }
                try {
                    v3 = v2 - v1;
                    this.rawData.get(this.block, v1, v3);
                }
                catch(Exception exception0) {
                    if(Log.isLoggable("GifHeaderParser", 3)) {
                        StringBuilder stringBuilder0 = o.t(v1, v3, "Error Reading Block n: ", " count: ", " blockSize: ");
                        stringBuilder0.append(this.blockSize);
                        Log.d("GifHeaderParser", stringBuilder0.toString(), exception0);
                    }
                    this.header.status = 1;
                    break;
                }
            }
        }
    }

    private int[] readColorTable(int v) {
        byte[] arr_b = new byte[v * 3];
        int[] arr_v = null;
        try {
            this.rawData.get(arr_b);
            arr_v = new int[0x100];
            int v2 = 0;
            for(int v1 = 0; v1 < v; ++v1) {
                int v3 = arr_b[v2] & 0xFF;
                int v4 = v2 + 2;
                int v5 = arr_b[v2 + 1] & 0xFF;
                v2 += 3;
                arr_v[v1] = v5 << 8 | (v3 << 16 | 0xFF000000) | arr_b[v4] & 0xFF;
            }
        }
        catch(BufferUnderflowException bufferUnderflowException0) {
            if(Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", bufferUnderflowException0);
            }
            this.header.status = 1;
        }
        return arr_v;
    }

    private void readContents() {
        this.readContents(0x7FFFFFFF);
    }

    private void readContents(int v) {
        boolean z = false;
        while(!z && !this.err() && this.header.frameCount <= v) {
            switch(this.read()) {
                case 33: {
                    switch(this.read()) {
                        case 1: {
                            this.skip();
                            break;
                        }
                        case 0xF9: {
                            GifHeader gifHeader0 = this.header;
                            gifHeader0.currentFrame = new GifFrame();
                            this.readGraphicControlExt();
                            break;
                        }
                        case 0xFE: {
                            this.skip();
                            break;
                        }
                        case 0xFF: {
                            this.readBlock();
                            StringBuilder stringBuilder0 = new StringBuilder();
                            for(int v1 = 0; v1 < 11; ++v1) {
                                stringBuilder0.append(((char)this.block[v1]));
                            }
                            if(stringBuilder0.toString().equals("NETSCAPE2.0")) {
                                this.readNetscapeExt();
                            }
                            else {
                                this.skip();
                            }
                            break;
                        }
                        default: {
                            this.skip();
                        }
                    }
                    break;
                }
                case 44: {
                    GifHeader gifHeader1 = this.header;
                    if(gifHeader1.currentFrame == null) {
                        gifHeader1.currentFrame = new GifFrame();
                    }
                    this.readBitmap();
                    break;
                }
                case 59: {
                    z = true;
                    break;
                }
                default: {
                    this.header.status = 1;
                }
            }
        }
    }

    private void readGraphicControlExt() {
        this.read();
        int v = this.read();
        GifFrame gifFrame0 = this.header.currentFrame;
        int v1 = (v & 28) >> 2;
        gifFrame0.dispose = v1;
        boolean z = true;
        if(v1 == 0) {
            gifFrame0.dispose = 1;
        }
        if((v & 1) == 0) {
            z = false;
        }
        gifFrame0.transparency = z;
        int v2 = this.readShort();
        if(v2 < 2) {
            v2 = 10;
        }
        GifFrame gifFrame1 = this.header.currentFrame;
        gifFrame1.delay = v2 * 10;
        gifFrame1.transIndex = this.read();
        this.read();
    }

    private void readHeader() {
        StringBuilder stringBuilder0 = new StringBuilder();
        for(int v = 0; v < 6; ++v) {
            stringBuilder0.append(((char)this.read()));
        }
        if(!stringBuilder0.toString().startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        this.readLSD();
        if(this.header.gctFlag && !this.err()) {
            GifHeader gifHeader0 = this.header;
            gifHeader0.gct = this.readColorTable(gifHeader0.gctSize);
            this.header.bgColor = this.header.gct[this.header.bgIndex];
        }
    }

    private void readLSD() {
        GifHeader gifHeader0 = this.header;
        gifHeader0.width = this.readShort();
        GifHeader gifHeader1 = this.header;
        gifHeader1.height = this.readShort();
        int v = this.read();
        this.header.gctFlag = (v & 0x80) != 0;
        this.header.gctSize = (int)Math.pow(2.0, (v & 7) + 1);
        GifHeader gifHeader2 = this.header;
        gifHeader2.bgIndex = this.read();
        GifHeader gifHeader3 = this.header;
        gifHeader3.pixelAspect = this.read();
    }

    private void readNetscapeExt() {
        do {
            this.readBlock();
            byte[] arr_b = this.block;
            if(arr_b[0] == 1) {
                this.header.loopCount = (arr_b[2] & 0xFF) << 8 | arr_b[1] & 0xFF;
            }
        }
        while(this.blockSize > 0 && !this.err());
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    public GifHeaderParser setData(ByteBuffer byteBuffer0) {
        this.reset();
        ByteBuffer byteBuffer1 = byteBuffer0.asReadOnlyBuffer();
        this.rawData = byteBuffer1;
        byteBuffer1.position(0);
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public GifHeaderParser setData(byte[] arr_b) {
        if(arr_b != null) {
            this.setData(ByteBuffer.wrap(arr_b));
            return this;
        }
        this.rawData = null;
        this.header.status = 2;
        return this;
    }

    private void skip() {
        do {
            int v = this.read();
            this.rawData.position(Math.min(this.rawData.position() + v, this.rawData.limit()));
        }
        while(v > 0);
    }

    private void skipImageData() {
        this.read();
        this.skip();
    }
}

