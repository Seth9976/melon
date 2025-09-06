package com.kakaoent.leonplayer.core.model.data.configuration;

import A7.d;
import java.util.Map;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017R\u0014\u0010\u0002\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u001E\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0012\u0010\u000B\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\rR\u0012\u0010\u000E\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\rR\u0012\u0010\u0010\u001A\u00020\u0011X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001A\u00020\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonPlayerItem;", "", "drmInfo", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "getDrmInfo", "()Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "header", "", "", "getHeader", "()Ljava/util/Map;", "id", "getId", "()Ljava/lang/String;", "posterImage", "getPosterImage", "startTime", "", "getStartTime", "()I", "url", "getUrl", "Companion", "Impl", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface LeonPlayerItem {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0003\u001A\u00020\u00042\b\b\u0002\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u00062\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\f2\u0014\b\u0002\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000E¨\u0006\u000F"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonPlayerItem$Companion;", "", "()V", "of", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonPlayerItem;", "id", "", "url", "startTime", "", "posterImage", "drmInfo", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "header", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE;

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final LeonPlayerItem of(@NotNull String s, @NotNull String s1, int v, @NotNull String s2, @Nullable LeonDrmInfo leonDrmInfo0, @NotNull Map map0) {
            q.g(s, "id");
            q.g(s1, "url");
            q.g(s2, "posterImage");
            q.g(map0, "header");
            return new Impl(s, s1, v, s2, leonDrmInfo0, map0);
        }

        public static LeonPlayerItem of$default(Companion leonPlayerItem$Companion0, String s, String s1, int v, String s2, LeonDrmInfo leonDrmInfo0, Map map0, int v1, Object object0) {
            if((v1 & 1) != 0) {
                s = "";
            }
            if((v1 & 4) != 0) {
                v = 0;
            }
            if((v1 & 8) != 0) {
                s2 = "";
            }
            if((v1 & 16) != 0) {
                leonDrmInfo0 = null;
            }
            if((v1 & 0x20) != 0) {
                map0 = x.a;
            }
            return leonPlayerItem$Companion0.of(s, s1, v, s2, leonDrmInfo0, map0);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0013\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\u0012\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000B¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0006HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\tHÆ\u0003J\u0015\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000BHÆ\u0003JS\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000BHÆ\u0001J\u0013\u0010\u001E\u001A\u00020\u001F2\b\u0010 \u001A\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001A\u00020\u0006HÖ\u0001J\t\u0010#\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\b\u001A\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER \u0010\n\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000BX\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012¨\u0006$"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonPlayerItem$Impl;", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonPlayerItem;", "id", "", "url", "startTime", "", "posterImage", "drmInfo", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "header", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;Ljava/util/Map;)V", "getDrmInfo", "()Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "getHeader", "()Ljava/util/Map;", "getId", "()Ljava/lang/String;", "getPosterImage", "getStartTime", "()I", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    static final class Impl implements LeonPlayerItem {
        @Nullable
        private final LeonDrmInfo drmInfo;
        @NotNull
        private final Map header;
        @NotNull
        private final String id;
        @NotNull
        private final String posterImage;
        private final int startTime;
        @NotNull
        private final String url;

        public Impl(@NotNull String s, @NotNull String s1, int v, @NotNull String s2, @Nullable LeonDrmInfo leonDrmInfo0, @NotNull Map map0) {
            q.g(s, "id");
            q.g(s1, "url");
            q.g(s2, "posterImage");
            q.g(map0, "header");
            super();
            this.id = s;
            this.url = s1;
            this.startTime = v;
            this.posterImage = s2;
            this.drmInfo = leonDrmInfo0;
            this.header = map0;
        }

        @NotNull
        public final String component1() {
            return this.getId();
        }

        @NotNull
        public final String component2() {
            return this.getUrl();
        }

        public final int component3() {
            return this.getStartTime();
        }

        @NotNull
        public final String component4() {
            return this.getPosterImage();
        }

        @Nullable
        public final LeonDrmInfo component5() {
            return this.getDrmInfo();
        }

        @NotNull
        public final Map component6() {
            return this.getHeader();
        }

        @NotNull
        public final Impl copy(@NotNull String s, @NotNull String s1, int v, @NotNull String s2, @Nullable LeonDrmInfo leonDrmInfo0, @NotNull Map map0) {
            q.g(s, "id");
            q.g(s1, "url");
            q.g(s2, "posterImage");
            q.g(map0, "header");
            return new Impl(s, s1, v, s2, leonDrmInfo0, map0);
        }

        public static Impl copy$default(Impl leonPlayerItem$Impl0, String s, String s1, int v, String s2, LeonDrmInfo leonDrmInfo0, Map map0, int v1, Object object0) {
            if((v1 & 1) != 0) {
                s = leonPlayerItem$Impl0.getId();
            }
            if((v1 & 2) != 0) {
                s1 = leonPlayerItem$Impl0.getUrl();
            }
            if((v1 & 4) != 0) {
                v = leonPlayerItem$Impl0.getStartTime();
            }
            if((v1 & 8) != 0) {
                s2 = leonPlayerItem$Impl0.getPosterImage();
            }
            if((v1 & 16) != 0) {
                leonDrmInfo0 = leonPlayerItem$Impl0.getDrmInfo();
            }
            if((v1 & 0x20) != 0) {
                map0 = leonPlayerItem$Impl0.getHeader();
            }
            return leonPlayerItem$Impl0.copy(s, s1, v, s2, leonDrmInfo0, map0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Impl)) {
                return false;
            }
            if(!q.b(this.getId(), ((Impl)object0).getId())) {
                return false;
            }
            if(!q.b(this.getUrl(), ((Impl)object0).getUrl())) {
                return false;
            }
            if(this.getStartTime() != ((Impl)object0).getStartTime()) {
                return false;
            }
            if(!q.b(this.getPosterImage(), ((Impl)object0).getPosterImage())) {
                return false;
            }
            return q.b(this.getDrmInfo(), ((Impl)object0).getDrmInfo()) ? q.b(this.getHeader(), ((Impl)object0).getHeader()) : false;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem
        @Nullable
        public LeonDrmInfo getDrmInfo() {
            return this.drmInfo;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem
        @NotNull
        public Map getHeader() {
            return this.header;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem
        @NotNull
        public String getId() {
            return this.id;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem
        @NotNull
        public String getPosterImage() {
            return this.posterImage;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem
        public int getStartTime() {
            return this.startTime;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonPlayerItem
        @NotNull
        public String getUrl() {
            return this.url;
        }

        @Override
        public int hashCode() {
            int v = U4.x.b(d.b(this.getStartTime(), U4.x.b(this.getId().hashCode() * 0x1F, 0x1F, this.getUrl()), 0x1F), 0x1F, this.getPosterImage());
            return this.getDrmInfo() == null ? this.getHeader().hashCode() + v * 0x1F : this.getHeader().hashCode() + (v + this.getDrmInfo().hashCode()) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "Impl(id=" + this.getId() + ", url=" + this.getUrl() + ", startTime=" + this.getStartTime() + ", posterImage=" + this.getPosterImage() + ", drmInfo=" + this.getDrmInfo() + ", header=" + this.getHeader() + ')';
        }
    }

    @NotNull
    public static final Companion Companion;

    static {
        LeonPlayerItem.Companion = Companion.$$INSTANCE;
    }

    @Nullable
    LeonDrmInfo getDrmInfo();

    @NotNull
    Map getHeader();

    @NotNull
    String getId();

    @NotNull
    String getPosterImage();

    int getStartTime();

    @NotNull
    String getUrl();
}

