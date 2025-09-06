package com.iloen.melon.utils.template;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0002\b\b\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006R$\u0010\f\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\u000BR$\u0010\u0010\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b\r\u0010\b\u001A\u0004\b\u000E\u0010\u0006\"\u0004\b\u000F\u0010\u000BR$\u0010\u0014\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b\u0011\u0010\b\u001A\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\u000BR$\u0010\u0018\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b\u0015\u0010\b\u001A\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\u000BR$\u0010\u001C\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b\u0019\u0010\b\u001A\u0004\b\u001A\u0010\u0006\"\u0004\b\u001B\u0010\u000BR$\u0010 \u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b\u001D\u0010\b\u001A\u0004\b\u001E\u0010\u0006\"\u0004\b\u001F\u0010\u000BR$\u0010$\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b!\u0010\b\u001A\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\u000BR$\u0010(\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b%\u0010\b\u001A\u0004\b&\u0010\u0006\"\u0004\b\'\u0010\u000BR$\u0010,\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b)\u0010\b\u001A\u0004\b*\u0010\u0006\"\u0004\b+\u0010\u000BR$\u00100\u001A\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b-\u0010\b\u001A\u0004\b.\u0010\u0006\"\u0004\b/\u0010\u000BR6\u00109\u001A\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u000101j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`28\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b3\u00104\u001A\u0004\b5\u00106\"\u0004\b7\u00108R6\u0010=\u001A\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u000101j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`28\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b:\u00104\u001A\u0004\b;\u00106\"\u0004\b<\u00108R\"\u0010A\u001A\u00020>8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0012\n\u0004\b?\u0010@\u001A\u0004\bA\u0010B\"\u0004\bC\u0010D\u00A8\u0006F"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateCoverInfo;", "Ljava/io/Serializable;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "a", "Ljava/lang/String;", "getType", "setType", "(Ljava/lang/String;)V", "type", "b", "getSubType", "setSubType", "subType", "c", "getTitle", "setTitle", "title", "d", "getTitleLine1", "setTitleLine1", "titleLine1", "e", "getTitleLine2", "setTitleLine2", "titleLine2", "f", "getSubTitle", "setSubTitle", "subTitle", "g", "getTextShadowColor", "setTextShadowColor", "textShadowColor", "h", "getTitleColor", "setTitleColor", "titleColor", "i", "getTitleImageUrl", "setTitleImageUrl", "titleImageUrl", "j", "getArtistName", "setArtistName", "artistName", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "k", "Ljava/util/ArrayList;", "getImages", "()Ljava/util/ArrayList;", "setImages", "(Ljava/util/ArrayList;)V", "images", "l", "getBgColors", "setBgColors", "bgColors", "", "m", "Z", "isShowMelonLogo", "()Z", "setShowMelonLogo", "(Z)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateCoverInfo implements Serializable {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateCoverInfo$Companion;", "", "", "serialVersionUID", "J", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @b("TYPE")
    @Nullable
    private String a;
    @b("SUBTYPE")
    @Nullable
    private String b;
    @b("TITLE")
    @Nullable
    private String c;
    @b("TITLELINE1")
    @Nullable
    private String d;
    @b("TITLELINE2")
    @Nullable
    private String e;
    @b("SUBTITLE")
    @Nullable
    private String f;
    @b("TEXTSHADOWCOLOR")
    @Nullable
    private String g;
    @b("TITLECOLOR")
    @Nullable
    private String h;
    @b("TITLEIMAGEURL")
    @Nullable
    private String i;
    @b("ARTISTNAME")
    @Nullable
    private String j;
    @b("IMAGES")
    @Nullable
    private ArrayList k;
    @b("BGCOLORS")
    @Nullable
    private ArrayList l;
    @b("ISMELONLOGO")
    private boolean m;
    private static final long serialVersionUID = 0x5EEB1D2D1E969432L;

    static {
        TemplateCoverInfo.Companion = new Companion(null);
        TemplateCoverInfo.$stable = 8;
    }

    public TemplateCoverInfo() {
        this.m = true;
    }

    @Nullable
    public final String getArtistName() {
        return this.j;
    }

    @Nullable
    public final ArrayList getBgColors() {
        return this.l;
    }

    @Nullable
    public final ArrayList getImages() {
        return this.k;
    }

    @Nullable
    public final String getSubTitle() {
        return this.f;
    }

    @Nullable
    public final String getSubType() {
        return this.b;
    }

    @Nullable
    public final String getTextShadowColor() {
        return this.g;
    }

    @Nullable
    public final String getTitle() {
        return this.c;
    }

    @Nullable
    public final String getTitleColor() {
        return this.h;
    }

    @Nullable
    public final String getTitleImageUrl() {
        return this.i;
    }

    @Nullable
    public final String getTitleLine1() {
        return this.d;
    }

    @Nullable
    public final String getTitleLine2() {
        return this.e;
    }

    @Nullable
    public final String getType() {
        return this.a;
    }

    public final boolean isShowMelonLogo() {
        return this.m;
    }

    public final void setArtistName(@Nullable String s) {
        this.j = s;
    }

    public final void setBgColors(@Nullable ArrayList arrayList0) {
        this.l = arrayList0;
    }

    public final void setImages(@Nullable ArrayList arrayList0) {
        this.k = arrayList0;
    }

    public final void setShowMelonLogo(boolean z) {
        this.m = z;
    }

    public final void setSubTitle(@Nullable String s) {
        this.f = s;
    }

    public final void setSubType(@Nullable String s) {
        this.b = s;
    }

    public final void setTextShadowColor(@Nullable String s) {
        this.g = s;
    }

    public final void setTitle(@Nullable String s) {
        this.c = s;
    }

    public final void setTitleColor(@Nullable String s) {
        this.h = s;
    }

    public final void setTitleImageUrl(@Nullable String s) {
        this.i = s;
    }

    public final void setTitleLine1(@Nullable String s) {
        this.d = s;
    }

    public final void setTitleLine2(@Nullable String s) {
        this.e = s;
    }

    public final void setType(@Nullable String s) {
        this.a = s;
    }

    @Override
    @NotNull
    public String toString() {
        String s = ToStringUtil.toStringFields(this);
        q.f(s, "toStringFields(...)");
        return s;
    }
}

