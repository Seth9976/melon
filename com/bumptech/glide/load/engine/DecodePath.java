package com.bumptech.glide.load.engine;

import android.util.Log;
import b2.d;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecodePath {
    interface DecodeCallback {
        Resource onResourceDecoded(Resource arg1);
    }

    private static final String TAG = "DecodePath";
    private final Class dataClass;
    private final List decoders;
    private final String failureMessage;
    private final d listPool;
    private final ResourceTranscoder transcoder;

    public DecodePath(Class class0, Class class1, Class class2, List list0, ResourceTranscoder resourceTranscoder0, d d0) {
        this.dataClass = class0;
        this.decoders = list0;
        this.transcoder = resourceTranscoder0;
        this.listPool = d0;
        this.failureMessage = "Failed DecodePath{" + class0.getSimpleName() + "->" + class1.getSimpleName() + "->" + class2.getSimpleName() + "}";
    }

    public Resource decode(DataRewinder dataRewinder0, int v, int v1, Options options0, DecodeCallback decodePath$DecodeCallback0) {
        Resource resource0 = decodePath$DecodeCallback0.onResourceDecoded(this.decodeResource(dataRewinder0, v, v1, options0));
        return this.transcoder.transcode(resource0, options0);
    }

    private Resource decodeResource(DataRewinder dataRewinder0, int v, int v1, Options options0) {
        List list0 = (List)Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return this.decodeResourceWithList(dataRewinder0, v, v1, options0, list0);
        }
        finally {
            this.listPool.release(list0);
        }
    }

    private Resource decodeResourceWithList(DataRewinder dataRewinder0, int v, int v1, Options options0, List list0) {
        int v2 = this.decoders.size();
        Resource resource0 = null;
        for(int v3 = 0; v3 < v2; ++v3) {
            ResourceDecoder resourceDecoder0 = (ResourceDecoder)this.decoders.get(v3);
            try {
                if(resourceDecoder0.handles(dataRewinder0.rewindAndGet(), options0)) {
                    resource0 = resourceDecoder0.decode(dataRewinder0.rewindAndGet(), v, v1, options0);
                }
            }
            catch(IOException | RuntimeException | OutOfMemoryError iOException0) {
                if(Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + resourceDecoder0, iOException0);
                }
                list0.add(iOException0);
            }
            if(resource0 != null) {
                break;
            }
        }
        if(resource0 != null) {
            return resource0;
        }
        ArrayList arrayList0 = new ArrayList(list0);
        throw new GlideException(this.failureMessage, arrayList0);
    }

    @Override
    public String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + '}';
    }
}

