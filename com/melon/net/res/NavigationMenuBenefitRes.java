package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.LinkInfoBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002\n\u000BB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/melon/net/res/NavigationMenuBenefitRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/melon/net/res/NavigationMenuBenefitRes$Response;", "getResponse", "()Lcom/melon/net/res/NavigationMenuBenefitRes$Response;", "setResponse", "(Lcom/melon/net/res/NavigationMenuBenefitRes$Response;)V", "Response", "MenuItem", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NavigationMenuBenefitRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001E\u0010\n\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001E\u0010\r\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR\u001E\u0010\u0010\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001E\u0010\u0013\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001E\u0010\u0016\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR \u0010\u0019\u001A\u0004\u0018\u00010\u001A8\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lcom/melon/net/res/NavigationMenuBenefitRes$MenuItem;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "seq", "", "getSeq", "()Ljava/lang/String;", "setSeq", "(Ljava/lang/String;)V", "imgUrl", "getImgUrl", "setImgUrl", "darkImgUrl", "getDarkImgUrl", "setDarkImgUrl", "title", "getTitle", "setTitle", "copy", "getCopy", "setCopy", "redDot", "getRedDot", "setRedDot", "redDotInfo", "Lcom/melon/net/res/RedDotInfo;", "getRedDotInfo", "()Lcom/melon/net/res/RedDotInfo;", "setRedDotInfo", "(Lcom/melon/net/res/RedDotInfo;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MenuItem extends LinkInfoBase {
        public static final int $stable = 8;
        @b("COPY")
        @NotNull
        private String copy;
        @b("DARKIMGURL")
        @NotNull
        private String darkImgUrl;
        @b("IMGURL")
        @NotNull
        private String imgUrl;
        @b("REDDOT")
        @NotNull
        private String redDot;
        @b("REDDOTINFO")
        @Nullable
        private RedDotInfo redDotInfo;
        @b("SEQ")
        @Nullable
        private String seq;
        @b("TITLE")
        @NotNull
        private String title;

        public MenuItem() {
            this.imgUrl = "";
            this.darkImgUrl = "";
            this.title = "";
            this.copy = "";
            this.redDot = "N";
        }

        @NotNull
        public final String getCopy() [...] // 潜在的解密器

        @NotNull
        public final String getDarkImgUrl() [...] // 潜在的解密器

        @NotNull
        public final String getImgUrl() [...] // 潜在的解密器

        @NotNull
        public final String getRedDot() [...] // 潜在的解密器

        @Nullable
        public final RedDotInfo getRedDotInfo() {
            return this.redDotInfo;
        }

        @Nullable
        public final String getSeq() {
            return this.seq;
        }

        @NotNull
        public final String getTitle() [...] // 潜在的解密器

        public final void setCopy(@NotNull String s) {
            q.g(s, "<set-?>");
            this.copy = s;
        }

        public final void setDarkImgUrl(@NotNull String s) {
            q.g(s, "<set-?>");
            this.darkImgUrl = s;
        }

        public final void setImgUrl(@NotNull String s) {
            q.g(s, "<set-?>");
            this.imgUrl = s;
        }

        public final void setRedDot(@NotNull String s) {
            q.g(s, "<set-?>");
            this.redDot = s;
        }

        public final void setRedDotInfo(@Nullable RedDotInfo redDotInfo0) {
            this.redDotInfo = redDotInfo0;
        }

        public final void setSeq(@Nullable String s) {
            this.seq = s;
        }

        public final void setTitle(@NotNull String s) {
            q.g(s, "<set-?>");
            this.title = s;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001A\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR.\u0010\f\u001A\u0012\u0012\u0004\u0012\u00020\r0\u0005j\b\u0012\u0004\u0012\u00020\r`\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\t\"\u0004\b\u000F\u0010\u000B¨\u0006\u0010"}, d2 = {"Lcom/melon/net/res/NavigationMenuBenefitRes$Response;", "", "<init>", "()V", "menuList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/NavigationMenuBenefitRes$MenuItem;", "Lkotlin/collections/ArrayList;", "getMenuList", "()Ljava/util/ArrayList;", "setMenuList", "(Ljava/util/ArrayList;)V", "expiredRedDotIds", "", "getExpiredRedDotIds", "setExpiredRedDotIds", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response {
        public static final int $stable = 8;
        @b("EXPIREDREDDOTIDS")
        @NotNull
        private ArrayList expiredRedDotIds;
        @b("MENULIST")
        @NotNull
        private ArrayList menuList;

        public Response() {
            this.menuList = new ArrayList();
            this.expiredRedDotIds = new ArrayList();
        }

        @NotNull
        public final ArrayList getExpiredRedDotIds() {
            return this.expiredRedDotIds;
        }

        @NotNull
        public final ArrayList getMenuList() {
            return this.menuList;
        }

        public final void setExpiredRedDotIds(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "<set-?>");
            this.expiredRedDotIds = arrayList0;
        }

        public final void setMenuList(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "<set-?>");
            this.menuList = arrayList0;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @NotNull
    private Response response;

    public NavigationMenuBenefitRes() {
        this.response = new Response();
    }

    @NotNull
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@NotNull Response navigationMenuBenefitRes$Response0) {
        q.g(navigationMenuBenefitRes$Response0, "<set-?>");
        this.response = navigationMenuBenefitRes$Response0;
    }
}

