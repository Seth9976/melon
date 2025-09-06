package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.InputStream;
import java.util.Map;

public final class ParsingLoadable implements Loadable {
    public interface Parser {
        Object parse(Uri arg1, InputStream arg2);
    }

    private final StatsDataSource dataSource;
    public final DataSpec dataSpec;
    private final Parser parser;
    private volatile Object result;
    public final int type;

    public ParsingLoadable(DataSource dataSource0, Uri uri0, int v, Parser parsingLoadable$Parser0) {
        this(dataSource0, new DataSpec(uri0, 1), v, parsingLoadable$Parser0);
    }

    public ParsingLoadable(DataSource dataSource0, DataSpec dataSpec0, int v, Parser parsingLoadable$Parser0) {
        this.dataSource = new StatsDataSource(dataSource0);
        this.dataSpec = dataSpec0;
        this.type = v;
        this.parser = parsingLoadable$Parser0;
    }

    public long bytesLoaded() {
        return this.dataSource.getBytesRead();
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public final void cancelLoad() {
    }

    public Map getResponseHeaders() {
        return this.dataSource.getLastResponseHeaders();
    }

    public final Object getResult() {
        return this.result;
    }

    public Uri getUri() {
        return this.dataSource.getLastOpenedUri();
    }

    public static Object load(DataSource dataSource0, Parser parsingLoadable$Parser0, Uri uri0, int v) {
        ParsingLoadable parsingLoadable0 = new ParsingLoadable(dataSource0, uri0, v, parsingLoadable$Parser0);
        parsingLoadable0.load();
        return Assertions.checkNotNull(parsingLoadable0.getResult());
    }

    public static Object load(DataSource dataSource0, Parser parsingLoadable$Parser0, DataSpec dataSpec0, int v) {
        ParsingLoadable parsingLoadable0 = new ParsingLoadable(dataSource0, dataSpec0, v, parsingLoadable$Parser0);
        parsingLoadable0.load();
        return Assertions.checkNotNull(parsingLoadable0.getResult());
    }

    @Override  // com.google.android.exoplayer2.upstream.Loader$Loadable
    public final void load() {
        this.dataSource.resetBytesRead();
        DataSourceInputStream dataSourceInputStream0 = new DataSourceInputStream(this.dataSource, this.dataSpec);
        try {
            dataSourceInputStream0.open();
            Uri uri0 = (Uri)Assertions.checkNotNull(this.dataSource.getUri());
            this.result = this.parser.parse(uri0, dataSourceInputStream0);
        }
        finally {
            Util.closeQuietly(dataSourceInputStream0);
        }
    }
}

