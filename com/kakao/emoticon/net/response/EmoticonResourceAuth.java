package com.kakao.emoticon.net.response;

import S7.b;
import U4.x;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÂ\u0003J\t\u0010\u0014\u001A\u00020\u0007HÆ\u0003J1\u0010\u0015\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u0003HÖ\u0001R\u0010\u0010\u0002\u001A\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001A\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001A\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR*\u0010\u000B\u001A\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8FX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u001C"}, d2 = {"Lcom/kakao/emoticon/net/response/EmoticonResourceAuth;", "", "_credential", "", "_signature", "_path", "expires", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getExpires", "()J", "toQueryMap", "", "getToQueryMap", "()Ljava/util/Map;", "setToQueryMap", "(Ljava/util/Map;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonResourceAuth {
    @b("credential")
    private final String _credential;
    @b("path")
    private final String _path;
    @b("signature")
    private final String _signature;
    @b("expires")
    private final long expires;
    @Nullable
    private Map toQueryMap;

    public EmoticonResourceAuth(@NotNull String s, @NotNull String s1, @NotNull String s2, long v) {
        q.g(s, "_credential");
        q.g(s1, "_signature");
        q.g(s2, "_path");
        super();
        this._credential = s;
        this._signature = s1;
        this._path = s2;
        this.expires = v;
    }

    private final String component1() {
        return this._credential;
    }

    private final String component2() {
        return this._signature;
    }

    private final String component3() {
        return this._path;
    }

    public final long component4() {
        return this.expires;
    }

    @NotNull
    public final EmoticonResourceAuth copy(@NotNull String s, @NotNull String s1, @NotNull String s2, long v) {
        q.g(s, "_credential");
        q.g(s1, "_signature");
        q.g(s2, "_path");
        return new EmoticonResourceAuth(s, s1, s2, v);
    }

    public static EmoticonResourceAuth copy$default(EmoticonResourceAuth emoticonResourceAuth0, String s, String s1, String s2, long v, int v1, Object object0) {
        if((v1 & 1) != 0) {
            s = emoticonResourceAuth0._credential;
        }
        if((v1 & 2) != 0) {
            s1 = emoticonResourceAuth0._signature;
        }
        if((v1 & 4) != 0) {
            s2 = emoticonResourceAuth0._path;
        }
        if((v1 & 8) != 0) {
            v = emoticonResourceAuth0.expires;
        }
        return emoticonResourceAuth0.copy(s, s1, s2, v);
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof EmoticonResourceAuth && q.b(this._credential, ((EmoticonResourceAuth)object0)._credential) && q.b(this._signature, ((EmoticonResourceAuth)object0)._signature) && q.b(this._path, ((EmoticonResourceAuth)object0)._path) && this.expires == ((EmoticonResourceAuth)object0).expires;
    }

    public final long getExpires() {
        return this.expires;
    }

    @Nullable
    public final Map getToQueryMap() {
        if(this.toQueryMap == null) {
            HashMap hashMap0 = new HashMap();
            hashMap0.put("credential", this._credential);
            hashMap0.put("signature", this._signature);
            hashMap0.put("path", this._path);
            hashMap0.put("expires", String.valueOf(this.expires));
            this.toQueryMap = hashMap0;
        }
        return this.toQueryMap;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this._credential == null ? 0 : this._credential.hashCode();
        int v2 = this._signature == null ? 0 : this._signature.hashCode();
        String s = this._path;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v) * 0x1F + ((int)(this.expires ^ this.expires >>> 0x20));
    }

    public final void setToQueryMap(@Nullable Map map0) {
        this.toQueryMap = map0;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("EmoticonResourceAuth(_credential=");
        stringBuilder0.append(this._credential);
        stringBuilder0.append(", _signature=");
        stringBuilder0.append(this._signature);
        stringBuilder0.append(", _path=");
        stringBuilder0.append(this._path);
        stringBuilder0.append(", expires=");
        return x.h(this.expires, ")", stringBuilder0);
    }
}

