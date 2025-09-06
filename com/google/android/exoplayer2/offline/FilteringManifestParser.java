package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import java.io.InputStream;
import java.util.List;

public final class FilteringManifestParser implements Parser {
    private final Parser parser;
    private final List streamKeys;

    public FilteringManifestParser(Parser parsingLoadable$Parser0, List list0) {
        this.parser = parsingLoadable$Parser0;
        this.streamKeys = list0;
    }

    public FilterableManifest parse(Uri uri0, InputStream inputStream0) {
        FilterableManifest filterableManifest0 = (FilterableManifest)this.parser.parse(uri0, inputStream0);
        return this.streamKeys == null || this.streamKeys.isEmpty() ? filterableManifest0 : ((FilterableManifest)filterableManifest0.copy(this.streamKeys));
    }

    @Override  // com.google.android.exoplayer2.upstream.ParsingLoadable$Parser
    public Object parse(Uri uri0, InputStream inputStream0) {
        return this.parse(uri0, inputStream0);
    }
}

