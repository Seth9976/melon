package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader.LoadData;
import com.bumptech.glide.load.model.ModelLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BaseGlideUrlLoader implements ModelLoader {
    private final ModelLoader concreteLoader;
    private final ModelCache modelCache;

    public BaseGlideUrlLoader(ModelLoader modelLoader0) {
        this(modelLoader0, null);
    }

    public BaseGlideUrlLoader(ModelLoader modelLoader0, ModelCache modelCache0) {
        this.concreteLoader = modelLoader0;
        this.modelCache = modelCache0;
    }

    @Override  // com.bumptech.glide.load.model.ModelLoader
    public LoadData buildLoadData(Object object0, int v, int v1, Options options0) {
        GlideUrl glideUrl0 = this.modelCache == null ? null : ((GlideUrl)this.modelCache.get(object0, v, v1));
        if(glideUrl0 == null) {
            String s = this.getUrl(object0, v, v1, options0);
            if(TextUtils.isEmpty(s)) {
                return null;
            }
            GlideUrl glideUrl1 = new GlideUrl(s, this.getHeaders(object0, v, v1, options0));
            ModelCache modelCache0 = this.modelCache;
            if(modelCache0 != null) {
                modelCache0.put(object0, v, v1, glideUrl1);
            }
            glideUrl0 = glideUrl1;
        }
        List list0 = this.getAlternateUrls(object0, v, v1, options0);
        LoadData modelLoader$LoadData0 = this.concreteLoader.buildLoadData(glideUrl0, v, v1, options0);
        if(modelLoader$LoadData0 != null && !list0.isEmpty()) {
            List list1 = BaseGlideUrlLoader.getAlternateKeys(list0);
            return new LoadData(modelLoader$LoadData0.sourceKey, list1, modelLoader$LoadData0.fetcher);
        }
        return modelLoader$LoadData0;
    }

    private static List getAlternateKeys(Collection collection0) {
        List list0 = new ArrayList(collection0.size());
        for(Object object0: collection0) {
            ((ArrayList)list0).add(new GlideUrl(((String)object0)));
        }
        return list0;
    }

    public List getAlternateUrls(Object object0, int v, int v1, Options options0) {
        return Collections.EMPTY_LIST;
    }

    public Headers getHeaders(Object object0, int v, int v1, Options options0) {
        return Headers.DEFAULT;
    }

    public abstract String getUrl(Object arg1, int arg2, int arg3, Options arg4);
}

