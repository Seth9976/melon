package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.util.Preconditions;
import java.util.Collections;
import java.util.List;

public interface ModelLoader {
    public static class LoadData {
        public final List alternateKeys;
        public final DataFetcher fetcher;
        public final Key sourceKey;

        public LoadData(Key key0, DataFetcher dataFetcher0) {
            this(key0, Collections.EMPTY_LIST, dataFetcher0);
        }

        public LoadData(Key key0, List list0, DataFetcher dataFetcher0) {
            this.sourceKey = (Key)Preconditions.checkNotNull(key0);
            this.alternateKeys = (List)Preconditions.checkNotNull(list0);
            this.fetcher = (DataFetcher)Preconditions.checkNotNull(dataFetcher0);
        }
    }

    LoadData buildLoadData(Object arg1, int arg2, int arg3, Options arg4);

    boolean handles(Object arg1);
}

