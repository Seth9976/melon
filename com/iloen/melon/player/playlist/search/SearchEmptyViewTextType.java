package com.iloen.melon.player.playlist.search;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/player/playlist/search/SearchEmptyViewTextType;", "", "EMPTY_KEYWORD", "EMPTY_RESULT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum SearchEmptyViewTextType {
    EMPTY_KEYWORD,
    EMPTY_RESULT;

    public static final SearchEmptyViewTextType[] a;
    public static final b b;

    static {
        SearchEmptyViewTextType.a = arr_searchEmptyViewTextType;
        q.g(arr_searchEmptyViewTextType, "entries");
        SearchEmptyViewTextType.b = new b(arr_searchEmptyViewTextType);
    }

    @NotNull
    public static a getEntries() {
        return SearchEmptyViewTextType.b;
    }
}

