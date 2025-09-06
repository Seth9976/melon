package com.kakaoent.leonplayer.core.model.data.json;

import A7.d;
import U4.x;
import Vd.i;
import Vd.l;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@l(generateAdapter = true)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001A\u00020\u0003\u0012\u000E\b\u0001\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u000E\b\u0001\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u000E\b\u0001\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0007\u0012\u0010\b\u0001\u0010\f\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007\u00A2\u0006\u0002\u0010\u000EJ\t\u0010\u0018\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u0019\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001A\u001A\u00020\u0003H\u00C6\u0003J\u000F\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007H\u00C6\u0003J\u000F\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\t0\u0007H\u00C6\u0003J\u000F\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0007H\u00C6\u0003J\u0011\u0010\u001E\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007H\u00C6\u0003Ji\u0010\u001F\u001A\u00020\u00002\b\b\u0003\u0010\u0002\u001A\u00020\u00032\b\b\u0003\u0010\u0004\u001A\u00020\u00032\b\b\u0003\u0010\u0005\u001A\u00020\u00032\u000E\b\u0003\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u00072\u000E\b\u0003\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u00072\u000E\b\u0003\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00072\u0010\b\u0003\u0010\f\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007H\u00C6\u0001J\u0013\u0010 \u001A\u00020!2\b\u0010\"\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010#\u001A\u00020$H\u00D6\u0001J\t\u0010%\u001A\u00020\u0003H\u00D6\u0001R\u0017\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0005\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00030\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0010R\u0019\u0010\f\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012R\u0017\u0010\b\u001A\b\u0012\u0004\u0012\u00020\t0\u0007\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0010\u00A8\u0006&"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/Media;", "", "id", "", "url", "dispName", "selectionTags", "", "videos", "Lcom/kakaoent/leonplayer/core/model/data/json/Video;", "audios", "Lcom/kakaoent/leonplayer/core/model/data/json/Audio;", "subtitles", "Lcom/kakaoent/leonplayer/core/model/data/json/Subtitle;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAudios", "()Ljava/util/List;", "getDispName", "()Ljava/lang/String;", "getId", "getSelectionTags", "getSubtitles", "getUrl", "getVideos", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class Media {
    @NotNull
    private final List audios;
    @NotNull
    private final String dispName;
    @NotNull
    private final String id;
    @NotNull
    private final List selectionTags;
    @Nullable
    private final List subtitles;
    @NotNull
    private final String url;
    @NotNull
    private final List videos;

    public Media(@i(name = "id") @NotNull String s, @i(name = "url") @NotNull String s1, @i(name = "disp_name") @NotNull String s2, @i(name = "selection_tags") @NotNull List list0, @i(name = "videos") @NotNull List list1, @i(name = "audios") @NotNull List list2, @i(name = "subtitles") @Nullable List list3) {
        q.g(s, "id");
        q.g(s1, "url");
        q.g(s2, "dispName");
        q.g(list0, "selectionTags");
        q.g(list1, "videos");
        q.g(list2, "audios");
        super();
        this.id = s;
        this.url = s1;
        this.dispName = s2;
        this.selectionTags = list0;
        this.videos = list1;
        this.audios = list2;
        this.subtitles = list3;
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final String component3() {
        return this.dispName;
    }

    @NotNull
    public final List component4() {
        return this.selectionTags;
    }

    @NotNull
    public final List component5() {
        return this.videos;
    }

    @NotNull
    public final List component6() {
        return this.audios;
    }

    @Nullable
    public final List component7() {
        return this.subtitles;
    }

    @NotNull
    public final Media copy(@i(name = "id") @NotNull String s, @i(name = "url") @NotNull String s1, @i(name = "disp_name") @NotNull String s2, @i(name = "selection_tags") @NotNull List list0, @i(name = "videos") @NotNull List list1, @i(name = "audios") @NotNull List list2, @i(name = "subtitles") @Nullable List list3) {
        q.g(s, "id");
        q.g(s1, "url");
        q.g(s2, "dispName");
        q.g(list0, "selectionTags");
        q.g(list1, "videos");
        q.g(list2, "audios");
        return new Media(s, s1, s2, list0, list1, list2, list3);
    }

    public static Media copy$default(Media media0, String s, String s1, String s2, List list0, List list1, List list2, List list3, int v, Object object0) {
        if((v & 1) != 0) {
            s = media0.id;
        }
        if((v & 2) != 0) {
            s1 = media0.url;
        }
        if((v & 4) != 0) {
            s2 = media0.dispName;
        }
        if((v & 8) != 0) {
            list0 = media0.selectionTags;
        }
        if((v & 16) != 0) {
            list1 = media0.videos;
        }
        if((v & 0x20) != 0) {
            list2 = media0.audios;
        }
        if((v & 0x40) != 0) {
            list3 = media0.subtitles;
        }
        return media0.copy(s, s1, s2, list0, list1, list2, list3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof Media)) {
            return false;
        }
        if(!q.b(this.id, ((Media)object0).id)) {
            return false;
        }
        if(!q.b(this.url, ((Media)object0).url)) {
            return false;
        }
        if(!q.b(this.dispName, ((Media)object0).dispName)) {
            return false;
        }
        if(!q.b(this.selectionTags, ((Media)object0).selectionTags)) {
            return false;
        }
        if(!q.b(this.videos, ((Media)object0).videos)) {
            return false;
        }
        return q.b(this.audios, ((Media)object0).audios) ? q.b(this.subtitles, ((Media)object0).subtitles) : false;
    }

    @NotNull
    public final List getAudios() {
        return this.audios;
    }

    @NotNull
    public final String getDispName() {
        return this.dispName;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final List getSelectionTags() {
        return this.selectionTags;
    }

    @Nullable
    public final List getSubtitles() {
        return this.subtitles;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final List getVideos() {
        return this.videos;
    }

    @Override
    public int hashCode() {
        int v = d.d(d.d(d.d(x.b(x.b(this.id.hashCode() * 0x1F, 0x1F, this.url), 0x1F, this.dispName), 0x1F, this.selectionTags), 0x1F, this.videos), 0x1F, this.audios);
        return this.subtitles == null ? v : v + this.subtitles.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "Media(id=" + this.id + ", url=" + this.url + ", dispName=" + this.dispName + ", selectionTags=" + this.selectionTags + ", videos=" + this.videos + ", audios=" + this.audios + ", subtitles=" + this.subtitles + ')';
    }
}

