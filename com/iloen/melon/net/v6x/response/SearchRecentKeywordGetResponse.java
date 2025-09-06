package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/SearchRecentKeywordGetResponse;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/SearchRecentKeywordGetResponse$Response;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/SearchRecentKeywordGetResponse$Response;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/SearchRecentKeywordGetResponse$Response;)V", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SearchRecentKeywordGetResponse extends ResponseV6Res {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u000E\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u000B\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001A\u00020\u00002\u0010\b\u0002\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000E\u001A\u00020\u000F2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u001E\u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u001E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/net/v6x/response/SearchRecentKeywordGetResponse$Response;", "Lcom/melon/net/res/common/ResponseBase;", "keywords", "", "Lcom/iloen/melon/net/v6x/response/SearchKeywordContent;", "contents", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getKeywords", "()Ljava/util/List;", "getContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("CONTENTSLIST")
        @Nullable
        private final List contents;
        @b("KEYWORDLIST")
        @Nullable
        private final List keywords;

        public Response(@Nullable List list0, @Nullable List list1) {
            this.keywords = list0;
            this.contents = list1;
        }

        @Nullable
        public final List component1() {
            return this.keywords;
        }

        @Nullable
        public final List component2() {
            return this.contents;
        }

        @NotNull
        public final Response copy(@Nullable List list0, @Nullable List list1) {
            return new Response(list0, list1);
        }

        public static Response copy$default(Response searchRecentKeywordGetResponse$Response0, List list0, List list1, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = searchRecentKeywordGetResponse$Response0.keywords;
            }
            if((v & 2) != 0) {
                list1 = searchRecentKeywordGetResponse$Response0.contents;
            }
            return searchRecentKeywordGetResponse$Response0.copy(list0, list1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Response)) {
                return false;
            }
            return q.b(this.keywords, ((Response)object0).keywords) ? q.b(this.contents, ((Response)object0).contents) : false;
        }

        @Nullable
        public final List getContents() {
            return this.contents;
        }

        @Nullable
        public final List getKeywords() {
            return this.keywords;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.keywords == null ? 0 : this.keywords.hashCode();
            List list0 = this.contents;
            if(list0 != null) {
                v = list0.hashCode();
            }
            return v1 * 0x1F + v;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        @NotNull
        public String toString() {
            return "Response(keywords=" + this.keywords + ", contents=" + this.contents + ")";
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private Response response;

    @Nullable
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable Response searchRecentKeywordGetResponse$Response0) {
        this.response = searchRecentKeywordGetResponse$Response0;
    }
}

