package com.bumptech.glide.load.engine;

import b2.d;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoadPath {
    private final Class dataClass;
    private final List decodePaths;
    private final String failureMessage;
    private final d listPool;

    public LoadPath(Class class0, Class class1, Class class2, List list0, d d0) {
        this.dataClass = class0;
        this.listPool = d0;
        this.decodePaths = (List)Preconditions.checkNotEmpty(list0);
        this.failureMessage = "Failed LoadPath{" + class0.getSimpleName() + "->" + class1.getSimpleName() + "->" + class2.getSimpleName() + "}";
    }

    public Class getDataClass() {
        return this.dataClass;
    }

    public Resource load(DataRewinder dataRewinder0, Options options0, int v, int v1, DecodeCallback decodePath$DecodeCallback0) {
        List list0 = (List)Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return this.loadWithExceptionList(dataRewinder0, options0, v, v1, decodePath$DecodeCallback0, list0);
        }
        finally {
            this.listPool.release(list0);
        }
    }

    private Resource loadWithExceptionList(DataRewinder dataRewinder0, Options options0, int v, int v1, DecodeCallback decodePath$DecodeCallback0, List list0) {
        int v2 = this.decodePaths.size();
        Resource resource0 = null;
        for(int v3 = 0; v3 < v2; ++v3) {
            DecodePath decodePath0 = (DecodePath)this.decodePaths.get(v3);
            try {
                resource0 = decodePath0.decode(dataRewinder0, v, v1, options0, decodePath$DecodeCallback0);
            }
            catch(GlideException glideException0) {
                list0.add(glideException0);
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
        return "LoadPath{decodePaths=" + Arrays.toString(this.decodePaths.toArray()) + '}';
    }
}

