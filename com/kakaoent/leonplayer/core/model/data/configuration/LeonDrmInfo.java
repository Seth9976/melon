package com.kakaoent.leonplayer.core.model.data.configuration;

import java.util.Map;
import je.x;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\f\bf\u0018\u0000 \u000E2\u00020\u0001:\u0002\u000E\u000FR\u001E\u0010\u0002\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0012\u0010\n\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\tR\u0012\u0010\f\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "", "header", "", "", "getHeader", "()Ljava/util/Map;", "licenseUrl", "getLicenseUrl", "()Ljava/lang/String;", "token", "getToken", "type", "getType", "Companion", "Impl", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface LeonDrmInfo {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u00042\u0014\b\u0002\u0010\u000B\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\fR\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo$Companion;", "", "()V", "TYPE_PLAYREADY", "", "TYPE_WIDEVINE", "of", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "type", "licenseUrl", "token", "header", "", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        static final Companion $$INSTANCE = null;
        @NotNull
        public static final String TYPE_PLAYREADY = "playready";
        @NotNull
        public static final String TYPE_WIDEVINE = "widevine";

        static {
            Companion.$$INSTANCE = new Companion();
        }

        @NotNull
        public final LeonDrmInfo of(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull Map map0) {
            q.g(s, "type");
            q.g(s1, "licenseUrl");
            q.g(s2, "token");
            q.g(map0, "header");
            return new Impl(s, s1, s2, map0);
        }

        public static LeonDrmInfo of$default(Companion leonDrmInfo$Companion0, String s, String s1, String s2, Map map0, int v, Object object0) {
            if((v & 8) != 0) {
                map0 = x.a;
            }
            return leonDrmInfo$Companion0.of(s, s1, s2, map0);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0012\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000F\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001A\u00020\u0003HÆ\u0003J\u0015\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J=\u0010\u0013\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\u0014\b\u0002\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0014\u001A\u00020\u00152\b\u0010\u0016\u001A\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u0003HÖ\u0001R \u0010\u0006\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0014\u0010\u0005\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\f¨\u0006\u001B"}, d2 = {"Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo$Impl;", "Lcom/kakaoent/leonplayer/core/model/data/configuration/LeonDrmInfo;", "type", "", "licenseUrl", "token", "header", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getHeader", "()Ljava/util/Map;", "getLicenseUrl", "()Ljava/lang/String;", "getToken", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "leonplayer_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    static final class Impl implements LeonDrmInfo {
        @NotNull
        private final Map header;
        @NotNull
        private final String licenseUrl;
        @NotNull
        private final String token;
        @NotNull
        private final String type;

        public Impl(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull Map map0) {
            q.g(s, "type");
            q.g(s1, "licenseUrl");
            q.g(s2, "token");
            q.g(map0, "header");
            super();
            this.type = s;
            this.licenseUrl = s1;
            this.token = s2;
            this.header = map0;
        }

        @NotNull
        public final String component1() {
            return this.getType();
        }

        @NotNull
        public final String component2() {
            return this.getLicenseUrl();
        }

        @NotNull
        public final String component3() {
            return this.getToken();
        }

        @NotNull
        public final Map component4() {
            return this.getHeader();
        }

        @NotNull
        public final Impl copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull Map map0) {
            q.g(s, "type");
            q.g(s1, "licenseUrl");
            q.g(s2, "token");
            q.g(map0, "header");
            return new Impl(s, s1, s2, map0);
        }

        public static Impl copy$default(Impl leonDrmInfo$Impl0, String s, String s1, String s2, Map map0, int v, Object object0) {
            if((v & 1) != 0) {
                s = leonDrmInfo$Impl0.getType();
            }
            if((v & 2) != 0) {
                s1 = leonDrmInfo$Impl0.getLicenseUrl();
            }
            if((v & 4) != 0) {
                s2 = leonDrmInfo$Impl0.getToken();
            }
            if((v & 8) != 0) {
                map0 = leonDrmInfo$Impl0.getHeader();
            }
            return leonDrmInfo$Impl0.copy(s, s1, s2, map0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Impl)) {
                return false;
            }
            if(!q.b(this.getType(), ((Impl)object0).getType())) {
                return false;
            }
            if(!q.b(this.getLicenseUrl(), ((Impl)object0).getLicenseUrl())) {
                return false;
            }
            return q.b(this.getToken(), ((Impl)object0).getToken()) ? q.b(this.getHeader(), ((Impl)object0).getHeader()) : false;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonDrmInfo
        @NotNull
        public Map getHeader() {
            return this.header;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonDrmInfo
        @NotNull
        public String getLicenseUrl() {
            return this.licenseUrl;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonDrmInfo
        @NotNull
        public String getToken() {
            return this.token;
        }

        @Override  // com.kakaoent.leonplayer.core.model.data.configuration.LeonDrmInfo
        @NotNull
        public String getType() {
            return this.type;
        }

        @Override
        public int hashCode() {
            return this.getHeader().hashCode() + U4.x.b(U4.x.b(this.getType().hashCode() * 0x1F, 0x1F, this.getLicenseUrl()), 0x1F, this.getToken());
        }

        @Override
        @NotNull
        public String toString() {
            return "Impl(type=" + this.getType() + ", licenseUrl=" + this.getLicenseUrl() + ", token=" + this.getToken() + ", header=" + this.getHeader() + ')';
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TYPE_PLAYREADY = "playready";
    @NotNull
    public static final String TYPE_WIDEVINE = "widevine";

    static {
        LeonDrmInfo.Companion = Companion.$$INSTANCE;
    }

    @NotNull
    Map getHeader();

    @NotNull
    String getLicenseUrl();

    @NotNull
    String getToken();

    @NotNull
    String getType();
}

