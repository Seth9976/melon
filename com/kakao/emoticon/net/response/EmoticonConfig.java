package com.kakao.emoticon.net.response;

import S7.b;
import Tf.v;
import i.n.i.b.a.s.e.M3;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000B\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\u001A\u0010\u0014\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u0018H\u0002J\u001E\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0018J\u000E\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u0003J\u000E\u0010\u001C\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u0003J\u0016\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0018J\u0016\u0010\u001E\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0018J\u000E\u0010\u001F\u001A\u00020\u00032\u0006\u0010\u001A\u001A\u00020\u0003J\t\u0010 \u001A\u00020\u0018HÖ\u0001J\t\u0010!\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001A\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\f¨\u0006#"}, d2 = {"Lcom/kakao/emoticon/net/response/EmoticonConfig;", "", "host", "", "base", "resourceAuth", "Lcom/kakao/emoticon/net/response/EmoticonResourceAuth;", "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/emoticon/net/response/EmoticonResourceAuth;)V", "getBase", "()Ljava/lang/String;", "getHost", "getResourceAuth", "()Lcom/kakao/emoticon/net/response/EmoticonResourceAuth;", "component1", "component2", "component3", "copy", "equals", "", "other", "getEmot", "itemSubType", "Lcom/kakao/emoticon/net/response/ItemSubType;", "resourceId", "", "getEmotUrl", "itemId", "getOffUrl", "getOnUrl", "getSoundUrl", "getThumbUrl", "getTitleUrl", "hashCode", "toString", "Companion", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonConfig {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/kakao/emoticon/net/response/EmoticonConfig$Companion;", "", "()V", "SCHEME", "", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final String SCHEME = "https";
    @b("base")
    @NotNull
    private final String base;
    @b("host")
    @NotNull
    private final String host;
    @b("auth")
    @NotNull
    private final EmoticonResourceAuth resourceAuth;

    static {
        EmoticonConfig.Companion = new Companion(null);
    }

    public EmoticonConfig(@NotNull String s, @NotNull String s1, @NotNull EmoticonResourceAuth emoticonResourceAuth0) {
        q.g(s, "host");
        q.g(s1, "base");
        q.g(emoticonResourceAuth0, "resourceAuth");
        super();
        this.host = s;
        this.base = s1;
        this.resourceAuth = emoticonResourceAuth0;
    }

    @NotNull
    public final String component1() {
        return this.host;
    }

    @NotNull
    public final String component2() {
        return this.base;
    }

    @NotNull
    public final EmoticonResourceAuth component3() {
        return this.resourceAuth;
    }

    @NotNull
    public final EmoticonConfig copy(@NotNull String s, @NotNull String s1, @NotNull EmoticonResourceAuth emoticonResourceAuth0) {
        q.g(s, "host");
        q.g(s1, "base");
        q.g(emoticonResourceAuth0, "resourceAuth");
        return new EmoticonConfig(s, s1, emoticonResourceAuth0);
    }

    public static EmoticonConfig copy$default(EmoticonConfig emoticonConfig0, String s, String s1, EmoticonResourceAuth emoticonResourceAuth0, int v, Object object0) {
        if((v & 1) != 0) {
            s = emoticonConfig0.host;
        }
        if((v & 2) != 0) {
            s1 = emoticonConfig0.base;
        }
        if((v & 4) != 0) {
            emoticonResourceAuth0 = emoticonConfig0.resourceAuth;
        }
        return emoticonConfig0.copy(s, s1, emoticonResourceAuth0);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof EmoticonConfig && q.b(this.host, ((EmoticonConfig)object0).host) && q.b(this.base, ((EmoticonConfig)object0).base) && q.b(this.resourceAuth, ((EmoticonConfig)object0).resourceAuth);
    }

    @NotNull
    public final String getBase() {
        return this.base;
    }

    private final String getEmot(ItemSubType itemSubType0, int v) {
        int v1 = EmoticonConfig.WhenMappings.$EnumSwitchMapping$0[itemSubType0.ordinal()];
        if(v1 != 1 && v1 != 2) {
            switch(v1) {
                case 3: 
                case 4: {
                    return v.p0("emot_###", "###", String.format("%03d%s", Arrays.copyOf(new Object[]{v, ".webp"}, 2)));
                }
                case 5: {
                    return v.p0("emot_###", "###", String.format("%03d%s", Arrays.copyOf(new Object[]{v, ".png"}, 2)));
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
        }
        return v.p0("emot_###", "###", String.format("%03d%s", Arrays.copyOf(new Object[]{v, ".gif"}, 2)));
    }

    @NotNull
    public final String getEmotUrl(@NotNull ItemSubType itemSubType0, @NotNull String s, int v) {
        q.g(itemSubType0, "itemSubType");
        q.g(s, "itemId");
        String s1 = this.getEmot(itemSubType0, v);
        return String.format("%s://%s%s/%s/%s", Arrays.copyOf(new Object[]{"https", this.host, this.base, s, s1}, 5));
    }

    @NotNull
    public final String getHost() {
        return this.host;
    }

    @NotNull
    public final String getOffUrl(@NotNull String s) {
        q.g(s, "itemId");
        return String.format("%s://%s%s/%s/icon_off.png", Arrays.copyOf(new Object[]{"https", this.host, this.base, s}, 4));
    }

    @NotNull
    public final String getOnUrl(@NotNull String s) {
        q.g(s, "itemId");
        return String.format("%s://%s%s/%s/icon_on.png", Arrays.copyOf(new Object[]{"https", this.host, this.base, s}, 4));
    }

    @NotNull
    public final EmoticonResourceAuth getResourceAuth() {
        return this.resourceAuth;
    }

    @NotNull
    public final String getSoundUrl(@NotNull String s, int v) {
        q.g(s, "itemId");
        String s1 = v.p0("sound_###.mp3", "###", String.format("%03d", Arrays.copyOf(new Object[]{v}, 1)));
        return String.format("%s://%s%s/%s/%s", Arrays.copyOf(new Object[]{"https", this.host, this.base, s, s1}, 5));
    }

    @NotNull
    public final String getThumbUrl(@NotNull String s, int v) {
        q.g(s, "itemId");
        String s1 = v.p0("thum_###.png", "###", String.format("%03d", Arrays.copyOf(new Object[]{v}, 1)));
        return String.format("%s://%s%s/%s/%s", Arrays.copyOf(new Object[]{"https", this.host, this.base, s, s1}, 5));
    }

    @NotNull
    public final String getTitleUrl(@NotNull String s) {
        q.g(s, "itemId");
        return String.format("%s://%s%s/%s/title.png", Arrays.copyOf(new Object[]{"https", this.host, this.base, s}, 4));
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.host == null ? 0 : this.host.hashCode();
        int v2 = this.base == null ? 0 : this.base.hashCode();
        EmoticonResourceAuth emoticonResourceAuth0 = this.resourceAuth;
        if(emoticonResourceAuth0 != null) {
            v = emoticonResourceAuth0.hashCode();
        }
        return (v1 * 0x1F + v2) * 0x1F + v;
    }

    @Override
    @NotNull
    public String toString() {
        return "EmoticonConfig(host=" + this.host + ", base=" + this.base + ", resourceAuth=" + this.resourceAuth + ")";
    }
}

