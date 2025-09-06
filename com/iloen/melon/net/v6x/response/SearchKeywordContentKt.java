package com.iloen.melon.net.v6x.response;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0002\u001A\n\u0010\u0003\u001A\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"toDescriptionFirst", "", "Lcom/iloen/melon/net/v6x/response/SearchKeywordContent;", "toDescriptionSecond", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class SearchKeywordContentKt {
    @NotNull
    public static final String toDescriptionFirst(@NotNull SearchKeywordContent searchKeywordContent0) {
        q.g(searchKeywordContent0, "<this>");
        return searchKeywordContent0.getDescription().isEmpty() ? "" : ((String)searchKeywordContent0.getDescription().get(0));
    }

    @NotNull
    public static final String toDescriptionSecond(@NotNull SearchKeywordContent searchKeywordContent0) {
        q.g(searchKeywordContent0, "<this>");
        return searchKeywordContent0.getDescription().size() <= 1 ? "" : ((String)searchKeywordContent0.getDescription().get(1));
    }
}

