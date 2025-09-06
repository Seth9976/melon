package com.iloen.melon.net.v6x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/net/v6x/response/SearchAutoCompleteContentResponse;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/iloen/melon/net/v6x/response/SearchAutoCompleteContentResponse$Response;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/SearchAutoCompleteContentResponse$Response;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/SearchAutoCompleteContentResponse$Response;)V", "Response", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SearchAutoCompleteContentResponse extends ResponseV6Res {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0010\u0010\u0002\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u000E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J/\u0010\u000E\u001A\u00020\u00002\u0012\b\u0002\u0010\u0002\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0004HÖ\u0001R \u0010\u0002\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u001E\u0010\u0005\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/net/v6x/response/SearchAutoCompleteContentResponse$Response;", "Lcom/melon/net/res/common/ResponseBase;", "keywordList", "", "", "contentsList", "Lcom/iloen/melon/net/v6x/response/SearchKeywordContent;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getKeywordList", "()Ljava/util/List;", "getContentsList", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("CONTENTSLIST")
        @Nullable
        private final List contentsList;
        @b("KEYWORDLIST")
        @Nullable
        private final List keywordList;

        public Response(@Nullable List list0, @Nullable List list1) {
            this.keywordList = list0;
            this.contentsList = list1;
        }

        @Nullable
        public final List component1() {
            return this.keywordList;
        }

        @Nullable
        public final List component2() {
            return this.contentsList;
        }

        @NotNull
        public final Response copy(@Nullable List list0, @Nullable List list1) {
            return new Response(list0, list1);
        }

        public static Response copy$default(Response searchAutoCompleteContentResponse$Response0, List list0, List list1, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = searchAutoCompleteContentResponse$Response0.keywordList;
            }
            if((v & 2) != 0) {
                list1 = searchAutoCompleteContentResponse$Response0.contentsList;
            }
            return searchAutoCompleteContentResponse$Response0.copy(list0, list1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Response)) {
                return false;
            }
            return q.b(this.keywordList, ((Response)object0).keywordList) ? q.b(this.contentsList, ((Response)object0).contentsList) : false;
        }

        @Nullable
        public final List getContentsList() {
            return this.contentsList;
        }

        @Nullable
        public final List getKeywordList() {
            return this.keywordList;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.keywordList == null ? 0 : this.keywordList.hashCode();
            List list0 = this.contentsList;
            if(list0 != null) {
                v = list0.hashCode();
            }
            return v1 * 0x1F + v;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        @NotNull
        public String toString() {
            return "Response(keywordList=" + this.keywordList + ", contentsList=" + this.contentsList + ")";
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

    public final void setResponse(@Nullable Response searchAutoCompleteContentResponse$Response0) {
        this.response = searchAutoCompleteContentResponse$Response0;
    }
}

