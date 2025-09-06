package com.kakao.emoticon.net.response;

import S7.b;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\u0018\u001A\u0004\u0018\u00010\bHÆ\u0003J\u000F\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u000B0\nHÆ\u0003JC\u0010\u001A\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\b2\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\nHÆ\u0001J\u0013\u0010\u001B\u001A\u00020\u00052\b\u0010\u001C\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001D\u001A\u00020\u001EHÖ\u0001J\t\u0010\u001F\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001A\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\rR\u001C\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0018\u0010\u0007\u001A\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0013¨\u0006 "}, d2 = {"Lcom/kakao/emoticon/net/response/MyItems;", "", "uid", "", "isKakaoConnected", "", "settingBannerUrl", "keyboard", "Lcom/kakao/emoticon/net/response/Keyboard;", "items", "", "Lcom/kakao/emoticon/net/response/Emoticon;", "(Ljava/lang/String;ZLjava/lang/String;Lcom/kakao/emoticon/net/response/Keyboard;Ljava/util/List;)V", "()Z", "getItems", "()Ljava/util/List;", "getKeyboard", "()Lcom/kakao/emoticon/net/response/Keyboard;", "getSettingBannerUrl", "()Ljava/lang/String;", "getUid", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class MyItems {
    @b("logged_id")
    private final boolean isKakaoConnected;
    @b("items")
    @NotNull
    private final List items;
    @b("keyboard")
    @Nullable
    private final Keyboard keyboard;
    @b("settings_banner_image_url")
    @NotNull
    private final String settingBannerUrl;
    @b("id")
    @NotNull
    private final String uid;

    public MyItems(@NotNull String s, boolean z, @NotNull String s1, @Nullable Keyboard keyboard0, @NotNull List list0) {
        q.g(s, "uid");
        q.g(s1, "settingBannerUrl");
        q.g(list0, "items");
        super();
        this.uid = s;
        this.isKakaoConnected = z;
        this.settingBannerUrl = s1;
        this.keyboard = keyboard0;
        this.items = list0;
    }

    public MyItems(String s, boolean z, String s1, Keyboard keyboard0, List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 16) != 0) {
            list0 = w.a;
        }
        this(s, z, s1, keyboard0, list0);
    }

    @NotNull
    public final String component1() {
        return this.uid;
    }

    public final boolean component2() {
        return this.isKakaoConnected;
    }

    @NotNull
    public final String component3() {
        return this.settingBannerUrl;
    }

    @Nullable
    public final Keyboard component4() {
        return this.keyboard;
    }

    @NotNull
    public final List component5() {
        return this.items;
    }

    @NotNull
    public final MyItems copy(@NotNull String s, boolean z, @NotNull String s1, @Nullable Keyboard keyboard0, @NotNull List list0) {
        q.g(s, "uid");
        q.g(s1, "settingBannerUrl");
        q.g(list0, "items");
        return new MyItems(s, z, s1, keyboard0, list0);
    }

    public static MyItems copy$default(MyItems myItems0, String s, boolean z, String s1, Keyboard keyboard0, List list0, int v, Object object0) {
        if((v & 1) != 0) {
            s = myItems0.uid;
        }
        if((v & 2) != 0) {
            z = myItems0.isKakaoConnected;
        }
        if((v & 4) != 0) {
            s1 = myItems0.settingBannerUrl;
        }
        if((v & 8) != 0) {
            keyboard0 = myItems0.keyboard;
        }
        if((v & 16) != 0) {
            list0 = myItems0.items;
        }
        return myItems0.copy(s, z, s1, keyboard0, list0);
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(@Nullable Object object0) {
        return this == object0 || object0 instanceof MyItems && q.b(this.uid, ((MyItems)object0).uid) && this.isKakaoConnected == ((MyItems)object0).isKakaoConnected && q.b(this.settingBannerUrl, ((MyItems)object0).settingBannerUrl) && q.b(this.keyboard, ((MyItems)object0).keyboard) && q.b(this.items, ((MyItems)object0).items);
    }

    @NotNull
    public final List getItems() {
        return this.items;
    }

    @Nullable
    public final Keyboard getKeyboard() {
        return this.keyboard;
    }

    @NotNull
    public final String getSettingBannerUrl() {
        return this.settingBannerUrl;
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.uid == null ? 0 : this.uid.hashCode();
        int v2 = this.isKakaoConnected;
        if(v2) {
            v2 = 1;
        }
        int v3 = this.settingBannerUrl == null ? 0 : this.settingBannerUrl.hashCode();
        int v4 = this.keyboard == null ? 0 : this.keyboard.hashCode();
        List list0 = this.items;
        if(list0 != null) {
            v = list0.hashCode();
        }
        return (((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }

    public final boolean isKakaoConnected() {
        return this.isKakaoConnected;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MyItems(uid=");
        stringBuilder0.append(this.uid);
        stringBuilder0.append(", isKakaoConnected=");
        stringBuilder0.append(this.isKakaoConnected);
        stringBuilder0.append(", settingBannerUrl=");
        stringBuilder0.append(this.settingBannerUrl);
        stringBuilder0.append(", keyboard=");
        stringBuilder0.append(this.keyboard);
        stringBuilder0.append(", items=");
        return Y.m(stringBuilder0, this.items, ")");
    }
}

