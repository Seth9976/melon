package com.kakaoent.leonplayer.core.model.data.json;

import Vd.D;
import Vd.I;
import Vd.k;
import Vd.n;
import Vd.p;
import Vd.v;
import Wd.f;
import java.lang.reflect.Type;
import java.util.List;
import je.y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001A\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001A\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001A\u0010\u0018R \u0010\u001C\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001B0\u00190\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001C\u0010\u0018R \u0010\u001E\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001D0\u00190\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u0018R\"\u0010 \u001A\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001F\u0018\u00010\u00190\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0018¨\u0006!"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/json/MediaJsonAdapter;", "LVd/k;", "Lcom/kakaoent/leonplayer/core/model/data/json/Media;", "LVd/D;", "moshi", "<init>", "(LVd/D;)V", "", "toString", "()Ljava/lang/String;", "LVd/p;", "reader", "fromJson", "(LVd/p;)Lcom/kakaoent/leonplayer/core/model/data/json/Media;", "LVd/v;", "writer", "value_", "Lie/H;", "toJson", "(LVd/v;Lcom/kakaoent/leonplayer/core/model/data/json/Media;)V", "LVd/n;", "options", "LVd/n;", "stringAdapter", "LVd/k;", "", "listOfStringAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/Video;", "listOfVideoAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/Audio;", "listOfAudioAdapter", "Lcom/kakaoent/leonplayer/core/model/data/json/Subtitle;", "nullableListOfSubtitleAdapter", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MediaJsonAdapter extends k {
    @NotNull
    private final k listOfAudioAdapter;
    @NotNull
    private final k listOfStringAdapter;
    @NotNull
    private final k listOfVideoAdapter;
    @NotNull
    private final k nullableListOfSubtitleAdapter;
    @NotNull
    private final n options;
    @NotNull
    private final k stringAdapter;

    public MediaJsonAdapter(@NotNull D d0) {
        q.g(d0, "moshi");
        super();
        this.options = n.a(new String[]{"id", "url", "disp_name", "selection_tags", "videos", "audios", "subtitles"});
        this.stringAdapter = d0.b(String.class, y.a, "id");
        this.listOfStringAdapter = d0.b(I.f(new Type[]{String.class}), y.a, "selectionTags");
        this.listOfVideoAdapter = d0.b(I.f(new Type[]{Video.class}), y.a, "videos");
        this.listOfAudioAdapter = d0.b(I.f(new Type[]{Audio.class}), y.a, "audios");
        this.nullableListOfSubtitleAdapter = d0.b(I.f(new Type[]{Subtitle.class}), y.a, "subtitles");
    }

    @NotNull
    public Media fromJson(@NotNull p p0) {
        q.g(p0, "reader");
        p0.m();
        String s = null;
        String s1 = null;
        String s2 = null;
        List list0 = null;
        List list1 = null;
        List list2 = null;
        List list3 = null;
        while(p0.r()) {
            switch(p0.M(this.options)) {
                case -1: {
                    p0.P();
                    p0.Q();
                    break;
                }
                case 0: {
                    s = (String)this.stringAdapter.fromJson(p0);
                    if(s == null) {
                        throw f.j("id", "id", p0);
                    }
                    continue;
                }
                case 1: {
                    s1 = (String)this.stringAdapter.fromJson(p0);
                    if(s1 == null) {
                        throw f.j("url", "url", p0);
                    }
                    continue;
                }
                case 2: {
                    s2 = (String)this.stringAdapter.fromJson(p0);
                    if(s2 == null) {
                        throw f.j("dispName", "disp_name", p0);
                    }
                    continue;
                }
                case 3: {
                    list0 = (List)this.listOfStringAdapter.fromJson(p0);
                    if(list0 == null) {
                        throw f.j("selectionTags", "selection_tags", p0);
                    }
                    continue;
                }
                case 4: {
                    list1 = (List)this.listOfVideoAdapter.fromJson(p0);
                    if(list1 == null) {
                        throw f.j("videos", "videos", p0);
                    }
                    continue;
                }
                case 5: {
                    list2 = (List)this.listOfAudioAdapter.fromJson(p0);
                    if(list2 == null) {
                        throw f.j("audios", "audios", p0);
                    }
                    continue;
                }
                case 6: {
                    list3 = (List)this.nullableListOfSubtitleAdapter.fromJson(p0);
                }
            }
        }
        p0.p();
        if(s == null) {
            throw f.e("id", "id", p0);
        }
        if(s1 == null) {
            throw f.e("url", "url", p0);
        }
        if(s2 == null) {
            throw f.e("dispName", "disp_name", p0);
        }
        if(list0 == null) {
            throw f.e("selectionTags", "selection_tags", p0);
        }
        if(list1 == null) {
            throw f.e("videos", "videos", p0);
        }
        if(list2 == null) {
            throw f.e("audios", "audios", p0);
        }
        return new Media(s, s1, s2, list0, list1, list2, list3);
    }

    @Override  // Vd.k
    public Object fromJson(p p0) {
        return this.fromJson(p0);
    }

    public void toJson(@NotNull v v0, @Nullable Media media0) {
        q.g(v0, "writer");
        if(media0 == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        v0.m();
        v0.s("id");
        this.stringAdapter.toJson(v0, media0.getId());
        v0.s("url");
        this.stringAdapter.toJson(v0, media0.getUrl());
        v0.s("disp_name");
        this.stringAdapter.toJson(v0, media0.getDispName());
        v0.s("selection_tags");
        this.listOfStringAdapter.toJson(v0, media0.getSelectionTags());
        v0.s("videos");
        this.listOfVideoAdapter.toJson(v0, media0.getVideos());
        v0.s("audios");
        this.listOfAudioAdapter.toJson(v0, media0.getAudios());
        v0.s("subtitles");
        this.nullableListOfSubtitleAdapter.toJson(v0, media0.getSubtitles());
        v0.q();
    }

    @Override  // Vd.k
    public void toJson(v v0, Object object0) {
        this.toJson(v0, ((Media)object0));
    }

    // 去混淆评级： 低(20)
    @Override
    @NotNull
    public String toString() {
        return "GeneratedJsonAdapter(Media)";
    }
}

