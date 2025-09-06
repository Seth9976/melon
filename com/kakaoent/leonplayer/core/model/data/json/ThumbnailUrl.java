package com.kakaoent.leonplayer.core.model.data.json;

import Vd.i;
import Vd.l;
import androidx.appcompat.app.o;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001A\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000BJ\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J.\u0010\u0011\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\n\b\u0003\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0006\u001A\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001A\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001A\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailUrl;", "", "mime", "", "timeScale", "", "url", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getMime", "()Ljava/lang/String;", "getTimeScale", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/kakaoent/leonplayer/core/model/data/json/ThumbnailUrl;", "equals", "", "other", "hashCode", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ThumbnailUrl {
    @NotNull
    private final String mime;
    @Nullable
    private final Integer timeScale;
    @NotNull
    private final String url;

    public ThumbnailUrl(@i(name = "mime") @NotNull String s, @i(name = "timescale") @Nullable Integer integer0, @i(name = "url") @NotNull String s1) {
        q.g(s, "mime");
        q.g(s1, "url");
        super();
        this.mime = s;
        this.timeScale = integer0;
        this.url = s1;
    }

    @NotNull
    public final String component1() {
        return this.mime;
    }

    @Nullable
    public final Integer component2() {
        return this.timeScale;
    }

    @NotNull
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final ThumbnailUrl copy(@i(name = "mime") @NotNull String s, @i(name = "timescale") @Nullable Integer integer0, @i(name = "url") @NotNull String s1) {
        q.g(s, "mime");
        q.g(s1, "url");
        return new ThumbnailUrl(s, integer0, s1);
    }

    public static ThumbnailUrl copy$default(ThumbnailUrl thumbnailUrl0, String s, Integer integer0, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = thumbnailUrl0.mime;
        }
        if((v & 2) != 0) {
            integer0 = thumbnailUrl0.timeScale;
        }
        if((v & 4) != 0) {
            s1 = thumbnailUrl0.url;
        }
        return thumbnailUrl0.copy(s, integer0, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof ThumbnailUrl)) {
            return false;
        }
        if(!q.b(this.mime, ((ThumbnailUrl)object0).mime)) {
            return false;
        }
        return q.b(this.timeScale, ((ThumbnailUrl)object0).timeScale) ? q.b(this.url, ((ThumbnailUrl)object0).url) : false;
    }

    @NotNull
    public final String getMime() {
        return this.mime;
    }

    @Nullable
    public final Integer getTimeScale() {
        return this.timeScale;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Override
    public int hashCode() {
        int v = this.mime.hashCode();
        return this.timeScale == null ? this.url.hashCode() + v * 961 : this.url.hashCode() + (v * 0x1F + this.timeScale.hashCode()) * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("ThumbnailUrl(mime=");
        stringBuilder0.append(this.mime);
        stringBuilder0.append(", timeScale=");
        stringBuilder0.append(this.timeScale);
        stringBuilder0.append(", url=");
        return o.r(stringBuilder0, this.url, ')');
    }
}

