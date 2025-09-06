package com.melon.data.service;

import A7.d;
import U4.x;
import androidx.annotation.Keep;
import com.melon.net.Api;
import com.melon.net.ApiType;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.a;
import vg.f;
import vg.o;
import vg.t;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001)J\u0016\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00A7@\u00A2\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\t\u001A\b\u0012\u0004\u0012\u00020\b0\u00022\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u00A7@\u00A2\u0006\u0004\b\t\u0010\nJF\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00022\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\f\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001A\u0004\u0018\u00010\u0006H\u00A7@\u00A2\u0006\u0004\b\u000F\u0010\u0010JR\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00022\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0011\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0012\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001A\u0004\u0018\u00010\u0006H\u00A7@\u00A2\u0006\u0004\b\u0013\u0010\u0014JF\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00022\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0015\u001A\u0004\u0018\u00010\u0006H\u00A7@\u00A2\u0006\u0004\b\u0016\u0010\u0010J:\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00022\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0017\u001A\u0004\u0018\u00010\u0006H\u00A7@\u00A2\u0006\u0004\b\u0018\u0010\u0019J:\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00022\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u000B\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\r\u001A\u0004\u0018\u00010\u0006H\u00A7@\u00A2\u0006\u0004\b\u001A\u0010\u0019J\u0016\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001B0\u0002H\u00A7@\u00A2\u0006\u0004\b\u001C\u0010\u0005J.\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u001E0\u00022\n\b\u0001\u0010\u001D\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u00A7@\u00A2\u0006\u0004\b\u001F\u0010 J8\u0010#\u001A\b\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0001\u0010\u001D\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\b\u0001\u0010\"\u001A\u00020!H\u00A7@\u00A2\u0006\u0004\b#\u0010$J.\u0010%\u001A\b\u0012\u0004\u0012\u00020\u00010\u00022\n\b\u0001\u0010\u001D\u001A\u0004\u0018\u00010\u00062\n\b\u0001\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u00A7@\u00A2\u0006\u0004\b%\u0010 J \u0010(\u001A\b\u0012\u0004\u0012\u00020\'0\u00022\b\b\u0001\u0010&\u001A\u00020\u0006H\u00A7@\u00A2\u0006\u0004\b(\u0010\n\u00A8\u0006*\u00C0\u0006\u0003"}, d2 = {"Lcom/melon/data/service/SearchApi;", "", "Lcom/melon/net/ApiResult;", "Lcom/iloen/melon/net/v6x/response/SearchHotKeywordAndMenuListRes;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "memberKey", "Lcom/iloen/melon/net/v6x/response/SearchTagListRes;", "e", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tagType", "artistId", "displayKeyword", "Lcom/iloen/melon/net/v6x/response/SearchNextTagListRes;", "g", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "genreTypeGroupName", "genreType", "l", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tagSeq", "a", "promotionSeq", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lcom/melon/net/res/SearchMainContentRes;", "f", "deviceId", "Lcom/iloen/melon/net/v6x/response/SearchRecentKeywordGetResponse;", "j", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/melon/data/service/SearchApi$RecentKeywordBody;", "body", "c", "(Ljava/lang/String;Ljava/lang/String;Lcom/melon/data/service/SearchApi$RecentKeywordBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "keyword", "Lcom/iloen/melon/net/v6x/response/SearchAutoCompleteContentResponse;", "i", "RecentKeywordBody", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface SearchApi {
    @Keep
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\b\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u0019\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001A\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001B\u001A\u00020\u0003H\u00C6\u0003J\u000F\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u00030\bH\u00C6\u0003J\t\u0010\u001D\u001A\u00020\u0003H\u00C6\u0003J\u000B\u0010\u001E\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001F\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003Jc\u0010 \u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\u000E\b\u0002\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\b2\b\b\u0002\u0010\t\u001A\u00020\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003H\u00C6\u0001J\u0013\u0010!\u001A\u00020\"2\b\u0010#\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010$\u001A\u00020%H\u00D6\u0001J\t\u0010&\u001A\u00020\u0003H\u00D6\u0001R\u0011\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00030\b\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000FR\u0013\u0010\n\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u000FR\u0013\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000F\u00A8\u0006\'"}, d2 = {"Lcom/melon/data/service/SearchApi$RecentKeywordBody;", "", "contentsTypeCode", "", "contentsId", "thumbnail", "title", "description", "", "scheme", "trackAlbumId", "trackAlbumScheme", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContentsTypeCode", "()Ljava/lang/String;", "getContentsId", "getThumbnail", "getTitle", "getDescription", "()Ljava/util/List;", "getScheme", "getTrackAlbumId", "getTrackAlbumScheme", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RecentKeywordBody {
        public static final int $stable = 8;
        @NotNull
        private final String contentsId;
        @NotNull
        private final String contentsTypeCode;
        @NotNull
        private final List description;
        @NotNull
        private final String scheme;
        @NotNull
        private final String thumbnail;
        @NotNull
        private final String title;
        @Nullable
        private final String trackAlbumId;
        @Nullable
        private final String trackAlbumScheme;

        public RecentKeywordBody(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull List list0, @NotNull String s4, @Nullable String s5, @Nullable String s6) {
            q.g(s, "contentsTypeCode");
            q.g(s1, "contentsId");
            q.g(s2, "thumbnail");
            q.g(s3, "title");
            q.g(list0, "description");
            q.g(s4, "scheme");
            super();
            this.contentsTypeCode = s;
            this.contentsId = s1;
            this.thumbnail = s2;
            this.title = s3;
            this.description = list0;
            this.scheme = s4;
            this.trackAlbumId = s5;
            this.trackAlbumScheme = s6;
        }

        @NotNull
        public final String component1() {
            return this.contentsTypeCode;
        }

        @NotNull
        public final String component2() {
            return this.contentsId;
        }

        @NotNull
        public final String component3() {
            return this.thumbnail;
        }

        @NotNull
        public final String component4() {
            return this.title;
        }

        @NotNull
        public final List component5() {
            return this.description;
        }

        @NotNull
        public final String component6() {
            return this.scheme;
        }

        @Nullable
        public final String component7() {
            return this.trackAlbumId;
        }

        @Nullable
        public final String component8() {
            return this.trackAlbumScheme;
        }

        @NotNull
        public final RecentKeywordBody copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull List list0, @NotNull String s4, @Nullable String s5, @Nullable String s6) {
            q.g(s, "contentsTypeCode");
            q.g(s1, "contentsId");
            q.g(s2, "thumbnail");
            q.g(s3, "title");
            q.g(list0, "description");
            q.g(s4, "scheme");
            return new RecentKeywordBody(s, s1, s2, s3, list0, s4, s5, s6);
        }

        public static RecentKeywordBody copy$default(RecentKeywordBody searchApi$RecentKeywordBody0, String s, String s1, String s2, String s3, List list0, String s4, String s5, String s6, int v, Object object0) {
            if((v & 1) != 0) {
                s = searchApi$RecentKeywordBody0.contentsTypeCode;
            }
            if((v & 2) != 0) {
                s1 = searchApi$RecentKeywordBody0.contentsId;
            }
            if((v & 4) != 0) {
                s2 = searchApi$RecentKeywordBody0.thumbnail;
            }
            if((v & 8) != 0) {
                s3 = searchApi$RecentKeywordBody0.title;
            }
            if((v & 16) != 0) {
                list0 = searchApi$RecentKeywordBody0.description;
            }
            if((v & 0x20) != 0) {
                s4 = searchApi$RecentKeywordBody0.scheme;
            }
            if((v & 0x40) != 0) {
                s5 = searchApi$RecentKeywordBody0.trackAlbumId;
            }
            if((v & 0x80) != 0) {
                s6 = searchApi$RecentKeywordBody0.trackAlbumScheme;
            }
            return searchApi$RecentKeywordBody0.copy(s, s1, s2, s3, list0, s4, s5, s6);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof RecentKeywordBody)) {
                return false;
            }
            if(!q.b(this.contentsTypeCode, ((RecentKeywordBody)object0).contentsTypeCode)) {
                return false;
            }
            if(!q.b(this.contentsId, ((RecentKeywordBody)object0).contentsId)) {
                return false;
            }
            if(!q.b(this.thumbnail, ((RecentKeywordBody)object0).thumbnail)) {
                return false;
            }
            if(!q.b(this.title, ((RecentKeywordBody)object0).title)) {
                return false;
            }
            if(!q.b(this.description, ((RecentKeywordBody)object0).description)) {
                return false;
            }
            if(!q.b(this.scheme, ((RecentKeywordBody)object0).scheme)) {
                return false;
            }
            return q.b(this.trackAlbumId, ((RecentKeywordBody)object0).trackAlbumId) ? q.b(this.trackAlbumScheme, ((RecentKeywordBody)object0).trackAlbumScheme) : false;
        }

        @NotNull
        public final String getContentsId() {
            return this.contentsId;
        }

        @NotNull
        public final String getContentsTypeCode() {
            return this.contentsTypeCode;
        }

        @NotNull
        public final List getDescription() {
            return this.description;
        }

        @NotNull
        public final String getScheme() {
            return this.scheme;
        }

        @NotNull
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getTrackAlbumId() {
            return this.trackAlbumId;
        }

        @Nullable
        public final String getTrackAlbumScheme() {
            return this.trackAlbumScheme;
        }

        @Override
        public int hashCode() {
            int v = x.b(d.d(x.b(x.b(x.b(this.contentsTypeCode.hashCode() * 0x1F, 0x1F, this.contentsId), 0x1F, this.thumbnail), 0x1F, this.title), 0x1F, this.description), 0x1F, this.scheme);
            int v1 = 0;
            int v2 = this.trackAlbumId == null ? 0 : this.trackAlbumId.hashCode();
            String s = this.trackAlbumScheme;
            if(s != null) {
                v1 = s.hashCode();
            }
            return (v + v2) * 0x1F + v1;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("RecentKeywordBody(contentsTypeCode=", this.contentsTypeCode, ", contentsId=", this.contentsId, ", thumbnail=");
            d.u(stringBuilder0, this.thumbnail, ", title=", this.title, ", description=");
            stringBuilder0.append(this.description);
            stringBuilder0.append(", scheme=");
            stringBuilder0.append(this.scheme);
            stringBuilder0.append(", trackAlbumId=");
            return d.n(stringBuilder0, this.trackAlbumId, ", trackAlbumScheme=", this.trackAlbumScheme, ")");
        }
    }

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/nextTagList.json")
    Object a(@Nullable @t("memberKey") String arg1, @Nullable @t("tagType") String arg2, @Nullable @t("displayKeyword") String arg3, @Nullable @t("tagSeq") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/hotKeywordAndMenuList.json")
    Object b(@NotNull Continuation arg1);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @o("/search/recent_keyword/set.json")
    Object c(@Nullable @t("deviceId") String arg1, @Nullable @t("memberKey") String arg2, @NotNull @a RecentKeywordBody arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/nextTagList.json")
    Object d(@Nullable @t("memberKey") String arg1, @Nullable @t("tagType") String arg2, @Nullable @t("displayKeyword") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/tagList.json")
    Object e(@Nullable @t("memberKey") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/main/contentList.json")
    Object f(@NotNull Continuation arg1);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/nextTagList.json")
    Object g(@Nullable @t("memberKey") String arg1, @Nullable @t("tagType") String arg2, @Nullable @t("artistId") String arg3, @Nullable @t("displayKeyword") String arg4, @NotNull Continuation arg5);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @o("/search/recent_keyword/delete.json")
    Object h(@Nullable @t("deviceId") String arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/autocomplete/contents.json")
    Object i(@NotNull @t("query") String arg1, @NotNull Continuation arg2);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/recent_keyword/get.json")
    Object j(@Nullable @t("deviceId") String arg1, @Nullable @t("memberKey") String arg2, @NotNull Continuation arg3);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/nextTagList.json")
    Object k(@Nullable @t("memberKey") String arg1, @Nullable @t("tagType") String arg2, @Nullable @t("promotionSeq") String arg3, @NotNull Continuation arg4);

    @Api(type = ApiType.V6, useAppVersion = true)
    @Nullable
    @f("/search/nextTagList.json")
    Object l(@Nullable @t("memberKey") String arg1, @Nullable @t("tagType") String arg2, @Nullable @t("genreTypeGroupName") String arg3, @Nullable @t("genreType") String arg4, @Nullable @t("displayKeyword") String arg5, @NotNull Continuation arg6);
}

