package com.iloen.melon.net.v6x.response;

import A7.d;
import U4.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\t\n\u0002\b\u001E\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001A\u00020\u0003H\u00C6\u0003J\t\u0010!\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\"\u001A\u00020\u0003H\u00C6\u0003J\t\u0010#\u001A\u00020\u0003H\u00C6\u0003J\t\u0010$\u001A\u00020\u0003H\u00C6\u0003J\t\u0010%\u001A\u00020\u0003H\u00C6\u0003J\t\u0010&\u001A\u00020\u0003H\u00C6\u0003J\u000F\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u00030\u000BH\u00C6\u0003J\t\u0010(\u001A\u00020\rH\u00C6\u0003J\t\u0010)\u001A\u00020\u000FH\u00C6\u0003Js\u0010*\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B2\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\u000FH\u00C6\u0001J\u0013\u0010+\u001A\u00020\r2\b\u0010,\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010-\u001A\u00020.H\u00D6\u0001J\t\u0010/\u001A\u00020\u0003H\u00D6\u0001R\u0011\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0013R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u000B\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u001BR\u0011\u0010\f\u001A\u00020\r\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0011\u0010\u000E\u001A\u00020\u000F\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001F\u00A8\u00060"}, d2 = {"Lcom/iloen/melon/net/v6x/response/SearchKeywordContent;", "", "contentsTypeCode", "", "contentsId", "thumbnail", "title", "scheme", "trackAlbumId", "trackAlbumScheme", "description", "", "hasHistory", "", "timestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZJ)V", "getContentsTypeCode", "()Ljava/lang/String;", "getContentsId", "getThumbnail", "getTitle", "getScheme", "getTrackAlbumId", "getTrackAlbumScheme", "getDescription", "()Ljava/util/List;", "getHasHistory", "()Z", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SearchKeywordContent {
    public static final int $stable = 8;
    @NotNull
    private final String contentsId;
    @NotNull
    private final String contentsTypeCode;
    @NotNull
    private final List description;
    private final boolean hasHistory;
    @NotNull
    private final String scheme;
    @NotNull
    private final String thumbnail;
    private final long timestamp;
    @NotNull
    private final String title;
    @NotNull
    private final String trackAlbumId;
    @NotNull
    private final String trackAlbumScheme;

    public SearchKeywordContent(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull List list0, boolean z, long v) {
        q.g(s, "contentsTypeCode");
        q.g(s1, "contentsId");
        q.g(s2, "thumbnail");
        q.g(s3, "title");
        q.g(s4, "scheme");
        q.g(s5, "trackAlbumId");
        q.g(s6, "trackAlbumScheme");
        q.g(list0, "description");
        super();
        this.contentsTypeCode = s;
        this.contentsId = s1;
        this.thumbnail = s2;
        this.title = s3;
        this.scheme = s4;
        this.trackAlbumId = s5;
        this.trackAlbumScheme = s6;
        this.description = list0;
        this.hasHistory = z;
        this.timestamp = v;
    }

    public SearchKeywordContent(String s, String s1, String s2, String s3, String s4, String s5, String s6, List list0, boolean z, long v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(s, s1, s2, s3, s4, s5, s6, list0, ((v1 & 0x100) == 0 ? z : false), v);
    }

    @NotNull
    public final String component1() {
        return this.contentsTypeCode;
    }

    public final long component10() {
        return this.timestamp;
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
    public final String component5() {
        return this.scheme;
    }

    @NotNull
    public final String component6() {
        return this.trackAlbumId;
    }

    @NotNull
    public final String component7() {
        return this.trackAlbumScheme;
    }

    @NotNull
    public final List component8() {
        return this.description;
    }

    public final boolean component9() {
        return this.hasHistory;
    }

    @NotNull
    public final SearchKeywordContent copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull List list0, boolean z, long v) {
        q.g(s, "contentsTypeCode");
        q.g(s1, "contentsId");
        q.g(s2, "thumbnail");
        q.g(s3, "title");
        q.g(s4, "scheme");
        q.g(s5, "trackAlbumId");
        q.g(s6, "trackAlbumScheme");
        q.g(list0, "description");
        return new SearchKeywordContent(s, s1, s2, s3, s4, s5, s6, list0, z, v);
    }

    public static SearchKeywordContent copy$default(SearchKeywordContent searchKeywordContent0, String s, String s1, String s2, String s3, String s4, String s5, String s6, List list0, boolean z, long v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = searchKeywordContent0.contentsTypeCode;
        }
        if((v1 & 2) != 0) {
            s1 = searchKeywordContent0.contentsId;
        }
        if((v1 & 4) != 0) {
            s2 = searchKeywordContent0.thumbnail;
        }
        if((v1 & 8) != 0) {
            s3 = searchKeywordContent0.title;
        }
        if((v1 & 16) != 0) {
            s4 = searchKeywordContent0.scheme;
        }
        if((v1 & 0x20) != 0) {
            s5 = searchKeywordContent0.trackAlbumId;
        }
        if((v1 & 0x40) != 0) {
            s6 = searchKeywordContent0.trackAlbumScheme;
        }
        if((v1 & 0x80) != 0) {
            list0 = searchKeywordContent0.description;
        }
        if((v1 & 0x100) != 0) {
            z = searchKeywordContent0.hasHistory;
        }
        if((v1 & 0x200) != 0) {
            v = searchKeywordContent0.timestamp;
        }
        return searchKeywordContent0.copy(s, s1, s2, s3, s4, s5, s6, list0, z, v);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SearchKeywordContent)) {
            return false;
        }
        if(!q.b(this.contentsTypeCode, ((SearchKeywordContent)object0).contentsTypeCode)) {
            return false;
        }
        if(!q.b(this.contentsId, ((SearchKeywordContent)object0).contentsId)) {
            return false;
        }
        if(!q.b(this.thumbnail, ((SearchKeywordContent)object0).thumbnail)) {
            return false;
        }
        if(!q.b(this.title, ((SearchKeywordContent)object0).title)) {
            return false;
        }
        if(!q.b(this.scheme, ((SearchKeywordContent)object0).scheme)) {
            return false;
        }
        if(!q.b(this.trackAlbumId, ((SearchKeywordContent)object0).trackAlbumId)) {
            return false;
        }
        if(!q.b(this.trackAlbumScheme, ((SearchKeywordContent)object0).trackAlbumScheme)) {
            return false;
        }
        if(!q.b(this.description, ((SearchKeywordContent)object0).description)) {
            return false;
        }
        return this.hasHistory == ((SearchKeywordContent)object0).hasHistory ? this.timestamp == ((SearchKeywordContent)object0).timestamp : false;
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

    public final boolean getHasHistory() {
        return this.hasHistory;
    }

    @NotNull
    public final String getScheme() {
        return this.scheme;
    }

    @NotNull
    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getTrackAlbumId() {
        return this.trackAlbumId;
    }

    @NotNull
    public final String getTrackAlbumScheme() {
        return this.trackAlbumScheme;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.timestamp) + d.e(d.d(x.b(x.b(x.b(x.b(x.b(x.b(this.contentsTypeCode.hashCode() * 0x1F, 0x1F, this.contentsId), 0x1F, this.thumbnail), 0x1F, this.title), 0x1F, this.scheme), 0x1F, this.trackAlbumId), 0x1F, this.trackAlbumScheme), 0x1F, this.description), 0x1F, this.hasHistory);
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("SearchKeywordContent(contentsTypeCode=", this.contentsTypeCode, ", contentsId=", this.contentsId, ", thumbnail=");
        d.u(stringBuilder0, this.thumbnail, ", title=", this.title, ", scheme=");
        d.u(stringBuilder0, this.scheme, ", trackAlbumId=", this.trackAlbumId, ", trackAlbumScheme=");
        stringBuilder0.append(this.trackAlbumScheme);
        stringBuilder0.append(", description=");
        stringBuilder0.append(this.description);
        stringBuilder0.append(", hasHistory=");
        stringBuilder0.append(this.hasHistory);
        stringBuilder0.append(", timestamp=");
        stringBuilder0.append(this.timestamp);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

