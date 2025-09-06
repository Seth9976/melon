package com.kakao.sdk.partner.model;

import com.kakao.sdk.common.model.ServerHosts;
import i.n.i.b.a.s.e.M3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\bR\u0014\u0010\u000B\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\bR\u0014\u0010\r\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\bR\u0014\u0010\u000F\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/kakao/sdk/partner/model/PhasedServerHosts;", "Lcom/kakao/sdk/common/model/ServerHosts;", "phase", "Lcom/kakao/sdk/partner/model/KakaoPhase;", "(Lcom/kakao/sdk/partner/model/KakaoPhase;)V", "account", "", "getAccount", "()Ljava/lang/String;", "apps", "getApps", "channel", "getChannel", "kapi", "getKapi", "kauth", "getKauth", "mobileAccount", "getMobileAccount", "navi", "getNavi", "getPhase", "()Lcom/kakao/sdk/partner/model/KakaoPhase;", "sharer", "getSharer", "partner-common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class PhasedServerHosts extends ServerHosts {
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[KakaoPhase.values().length];
            try {
                arr_v[KakaoPhase.DEV.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[KakaoPhase.SANDBOX.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[KakaoPhase.CBT.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[KakaoPhase.PRODUCTION.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

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
    private final KakaoPhase phase;
    @NotNull
    private final String sharer;

    public PhasedServerHosts(@NotNull KakaoPhase kakaoPhase0) {
        q.g(kakaoPhase0, "phase");
        String s7;
        String s6;
        String s5;
        String s4;
        String s3;
        String s2;
        String s1;
        String s;
        super();
        this.phase = kakaoPhase0;
        int[] arr_v = WhenMappings.$EnumSwitchMapping$0;
        switch(arr_v[kakaoPhase0.ordinal()]) {
            case 1: {
                s = "alpha-kauth.kakao.com";
                break;
            }
            case 2: {
                s = "sandbox-kauth.kakao.com";
                break;
            }
            case 3: {
                s = "beta-kauth.kakao.com";
                break;
            }
            case 4: {
                s = "kauth.kakao.com";
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.kauth = s;
        switch(arr_v[kakaoPhase0.ordinal()]) {
            case 1: {
                s1 = "alpha-kapi.kakao.com";
                break;
            }
            case 2: {
                s1 = "sandbox-kapi.kakao.com";
                break;
            }
            case 3: {
                s1 = "beta-kapi.kakao.com";
                break;
            }
            case 4: {
                s1 = "kapi.kakao.com";
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.kapi = s1;
        switch(arr_v[kakaoPhase0.ordinal()]) {
            case 1: {
                s2 = "alpha-apps.kakao.com";
                break;
            }
            case 2: {
                s2 = "sandbox-apps.kakao.com";
                break;
            }
            case 3: {
                s2 = "beta-apps.kakao.com";
                break;
            }
            case 4: {
                s2 = "apps.kakao.com";
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.apps = s2;
        switch(arr_v[kakaoPhase0.ordinal()]) {
            case 1: {
                s3 = "alpha-accounts.kakao.com";
                break;
            }
            case 2: {
                s3 = "sandbox-accounts.kakao.com";
                break;
            }
            case 3: {
                s3 = "beta-accounts.kakao.com";
                break;
            }
            case 4: {
                s3 = "accounts.kakao.com";
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.account = s3;
        switch(arr_v[kakaoPhase0.ordinal()]) {
            case 1: {
                s4 = "alpha-auth.kakao.com";
                break;
            }
            case 2: {
                s4 = "sandbox-auth.kakao.com";
                break;
            }
            case 3: {
                s4 = "beta-auth.kakao.com";
                break;
            }
            case 4: {
                s4 = "auth.kakao.com";
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.mobileAccount = s4;
        switch(arr_v[kakaoPhase0.ordinal()]) {
            case 1: {
                s5 = "alpha-sharer.devel.kakao.com";
                break;
            }
            case 2: {
                s5 = "sandbox-sharer.devel.kakao.com";
                break;
            }
            case 3: {
                s5 = "beta-sharer.kakao.com";
                break;
            }
            case 4: {
                s5 = "sharer.kakao.com";
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.sharer = s5;
        switch(arr_v[kakaoPhase0.ordinal()]) {
            case 1: 
            case 2: {
                s6 = "sandbox-kakaonavi-wguide.kakao.com";
                break;
            }
            case 3: 
            case 4: {
                s6 = "kakaonavi-wguide.kakao.com";
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.navi = s6;
        switch(arr_v[kakaoPhase0.ordinal()]) {
            case 1: 
            case 2: {
                s7 = "sandbox-pf.kakao.com";
                break;
            }
            case 3: {
                s7 = "beta-pf.kakao.com";
                break;
            }
            case 4: {
                s7 = "pf.kakao.com";
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.channel = s7;
    }

    @Override  // com.kakao.sdk.common.model.ServerHosts
    @NotNull
    public String getAccount() {
        return this.account;
    }

    @Override  // com.kakao.sdk.common.model.ServerHosts
    @NotNull
    public String getApps() {
        return this.apps;
    }

    @Override  // com.kakao.sdk.common.model.ServerHosts
    @NotNull
    public String getChannel() {
        return this.channel;
    }

    @Override  // com.kakao.sdk.common.model.ServerHosts
    @NotNull
    public String getKapi() {
        return this.kapi;
    }

    @Override  // com.kakao.sdk.common.model.ServerHosts
    @NotNull
    public String getKauth() {
        return this.kauth;
    }

    @Override  // com.kakao.sdk.common.model.ServerHosts
    @NotNull
    public String getMobileAccount() {
        return this.mobileAccount;
    }

    @Override  // com.kakao.sdk.common.model.ServerHosts
    @NotNull
    public String getNavi() {
        return this.navi;
    }

    @NotNull
    public final KakaoPhase getPhase() {
        return this.phase;
    }

    @Override  // com.kakao.sdk.common.model.ServerHosts
    @NotNull
    public String getSharer() {
        return this.sharer;
    }
}

