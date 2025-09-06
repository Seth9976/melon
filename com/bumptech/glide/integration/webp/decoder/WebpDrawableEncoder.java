package com.bumptech.glide.integration.webp.decoder;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;

public class WebpDrawableEncoder implements ResourceEncoder {
    private static final String TAG = "WebpEncoder";

    public boolean encode(Resource resource0, File file0, Options options0) {
        WebpDrawable webpDrawable0 = (WebpDrawable)resource0.get();
        try {
            ByteBufferUtil.toFile(webpDrawable0.getBuffer(), file0);
            return true;
        }
        catch(IOException iOException0) {
            if(Log.isLoggable("WebpEncoder", 5)) {
                Log.w("WebpEncoder", "Failed to encode WebP drawable data", iOException0);
            }
            return false;
        }
    }

    @Override  // com.bumptech.glide.load.Encoder
    public boolean encode(Object object0, File file0, Options options0) {
        return this.encode(((Resource)object0), file0, options0);
    }

    @Override  // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy getEncodeStrategy(Options options0) {
        return EncodeStrategy.SOURCE;
    }
}

