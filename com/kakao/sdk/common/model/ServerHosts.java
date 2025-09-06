package com.kakao.sdk.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0006R\u0014\u0010\u000B\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u0006R\u0014\u0010\u000F\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001A\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/kakao/sdk/common/model/ServerHosts;", "", "()V", "account", "", "getAccount", "()Ljava/lang/String;", "apps", "getApps", "channel", "getChannel", "kapi", "getKapi", "kauth", "getKauth", "mobileAccount", "getMobileAccount", "navi", "getNavi", "sharer", "getSharer", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class ServerHosts {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/kakao/sdk/common/model/ServerHosts$Companion;", "", "()V", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String account;
    @NotNull
    private final String apps;
    @NotNull
    private final String channel;
    @NotNull
    private final String kapi;
    @NotNull
    private final String kauth;
    @NotNull
    private final String mobileAccount;
    @NotNull
    private final String navi;
    @NotNull
    private final String sharer;

    static {
        ServerHosts.Companion = new Companion(null);
    }

    public ServerHosts() {
        this.kauth = "kauth.kakao.com";
        this.kapi = "kapi.kakao.com";
        this.apps = "apps.kakao.com";
        this.account = "accounts.kakao.com";
        this.mobileAccount = "auth.kakao.com";
        this.sharer = "sharer.kakao.com";
        this.navi = "kakaonavi-wguide.kakao.com";
        this.channel = "pf.kakao.com";
    }

    @NotNull
    public String getAccount() {
        return this.account;
    }

    @NotNull
    public String getApps() [...] // 潜在的解密器

    @NotNull
    public String getChannel() {
        return this.channel;
    }

    @NotNull
    public String getKapi() [...] // 潜在的解密器

    @NotNull
    public String getKauth() [...] // 潜在的解密器

    @NotNull
    public String getMobileAccount() {
        return this.mobileAccount;
    }

    @NotNull
    public String getNavi() {
        return this.navi;
    }

    @NotNull
    public String getSharer() [...] // 潜在的解密器
}

