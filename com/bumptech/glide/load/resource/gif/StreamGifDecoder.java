package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class StreamGifDecoder implements ResourceDecoder {
    private static final String TAG = "StreamGifDecoder";
    private final ArrayPool byteArrayPool;
    private final ResourceDecoder byteBufferDecoder;
    private final List parsers;

    public StreamGifDecoder(List list0, ResourceDecoder resourceDecoder0, ArrayPool arrayPool0) {
        this.parsers = list0;
        this.byteBufferDecoder = resourceDecoder0;
        this.byteArrayPool = arrayPool0;
    }

    public Resource decode(InputStream inputStream0, int v, int v1, Options options0) {
        byte[] arr_b = StreamGifDecoder.inputStreamToBytes(inputStream0);
        if(arr_b == null) {
            return null;
        }
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(arr_b);
        return this.byteBufferDecoder.decode(byteBuffer0, v, v1, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public Resource decode(Object object0, int v, int v1, Options options0) {
        return this.decode(((InputStream)object0), v, v1, options0);
    }

    public boolean handles(InputStream inputStream0, Options options0) {
        return !((Boolean)options0.get(GifOptions.DISABLE_ANIMATION)).booleanValue() && ImageHeaderParserUtils.getType(this.parsers, inputStream0, this.byteArrayPool) == ImageType.GIF;
    }

    @Override  // com.bumptech.glide.load.ResourceDecoder
    public boolean handles(Object object0, Options options0) {
        return this.handles(((InputStream)object0), options0);
    }

    private static byte[] inputStreamToBytes(InputStream inputStream0) {
        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream(0x4000);
        try {
            byte[] arr_b = new byte[0x4000];
            int v;
            while((v = inputStream0.read(arr_b)) != -1) {
                byteArrayOutputStream0.write(arr_b, 0, v);
            }
            byteArrayOutputStream0.flush();
            return byteArrayOutputStream0.toByteArray();
        }
        catch(IOException iOException0) {
            if(Log.isLoggable("StreamGifDecoder", 5)) {
                Log.w("StreamGifDecoder", "Error reading data from stream", iOException0);
            }
            return null;
        }
    }
}

