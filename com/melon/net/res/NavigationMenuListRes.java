package com.melon.net.res;

import S7.b;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.LinkInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/melon/net/res/NavigationMenuListRes;", "Lcom/iloen/melon/net/v6x/response/ResponseV6Res;", "<init>", "()V", "response", "Lcom/melon/net/res/NavigationMenuListRes$RESPONSE;", "getResponse", "()Lcom/melon/net/res/NavigationMenuListRes$RESPONSE;", "setResponse", "(Lcom/melon/net/res/NavigationMenuListRes$RESPONSE;)V", "RESPONSE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NavigationMenuListRes extends ResponseV6Res {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R2\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR2\u0010\f\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00078\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\t\"\u0004\b\u000E\u0010\u000B¨\u0006\u0010"}, d2 = {"Lcom/melon/net/res/NavigationMenuListRes$RESPONSE;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "list", "Ljava/util/ArrayList;", "Lcom/melon/net/res/NavigationMenuListRes$RESPONSE$Menu;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "snsList", "getSnsList", "setSnsList", "Menu", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RESPONSE extends ResponseBase {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR2\u0010\u0010\u001A\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/melon/net/res/NavigationMenuListRes$RESPONSE$Menu;", "", "<init>", "()V", "menuGroup", "", "getMenuGroup", "()Ljava/lang/String;", "setMenuGroup", "(Ljava/lang/String;)V", "groupType", "getGroupType", "setGroupType", "layer1", "getLayer1", "setLayer1", "menuList", "Ljava/util/ArrayList;", "Lcom/melon/net/res/NavigationMenuListRes$RESPONSE$Menu$MenuItem;", "Lkotlin/collections/ArrayList;", "getMenuList", "()Ljava/util/ArrayList;", "setMenuList", "(Ljava/util/ArrayList;)V", "MenuItem", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Menu {
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u0007\"\u0004\b\u000F\u0010\tR \u0010\u0010\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001E\u0010\u0013\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR \u0010\u0016\u001A\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001E\u0010\u0019\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\t¨\u0006\u001C"}, d2 = {"Lcom/melon/net/res/NavigationMenuListRes$RESPONSE$Menu$MenuItem;", "Lcom/melon/net/res/common/LinkInfoBase;", "<init>", "()V", "seq", "", "getSeq", "()Ljava/lang/String;", "setSeq", "(Ljava/lang/String;)V", "imgUrl", "getImgUrl", "setImgUrl", "darkImgUrl", "getDarkImgUrl", "setDarkImgUrl", "title", "getTitle", "setTitle", "redDot", "getRedDot", "setRedDot", "copy", "getCopy", "setCopy", "loginYn", "getLoginYn", "setLoginYn", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class MenuItem extends LinkInfoBase {
                public static final int $stable = 8;
                @b("COPY")
                @Nullable
                private String copy;
                @b("DARKIMGURL")
                @Nullable
                private String darkImgUrl;
                @b("IMGURL")
                @Nullable
                private String imgUrl;
                @b("LOGINYN")
                @NotNull
                private String loginYn;
                @b("REDDOT")
                @NotNull
                private String redDot;
                @b("SEQ")
                @Nullable
                private String seq;
                @b("TITLE")
                @Nullable
                private String title;

                public MenuItem() {
                    this.redDot = "N";
                    this.loginYn = "N";
                }

                @Nullable
                public final String getCopy() {
                    return this.copy;
                }

                @Nullable
                public final String getDarkImgUrl() {
                    return this.darkImgUrl;
                }

                @Nullable
                public final String getImgUrl() {
                    return this.imgUrl;
                }

                @NotNull
                public final String getLoginYn() [...] // 潜在的解密器

                @NotNull
                public final String getRedDot() [...] // 潜在的解密器

                @Nullable
                public final String getSeq() {
                    return this.seq;
                }

                @Nullable
                public final String getTitle() {
                    return this.title;
                }

                public final void setCopy(@Nullable String s) {
                    this.copy = s;
                }

                public final void setDarkImgUrl(@Nullable String s) {
                    this.darkImgUrl = s;
                }

                public final void setImgUrl(@Nullable String s) {
                    this.imgUrl = s;
                }

                public final void setLoginYn(@NotNull String s) {
                    q.g(s, "<set-?>");
                    this.loginYn = s;
                }

                public final void setRedDot(@NotNull String s) {
                    q.g(s, "<set-?>");
                    this.redDot = s;
                }

                public final void setSeq(@Nullable String s) {
                    this.seq = s;
                }

                public final void setTitle(@Nullable String s) {
                    this.title = s;
                }
            }

            public static final int $stable = 8;
            @b("GROUPTYPE")
            @Nullable
            private String groupType;
            @b("LAYER1")
            @Nullable
            private String layer1;
            @b("MENUGROUP")
            @Nullable
            private String menuGroup;
            @b("MENULIST")
            @Nullable
            private ArrayList menuList;

            @Nullable
            public final String getGroupType() {
                return this.groupType;
            }

            @Nullable
            public final String getLayer1() {
                return this.layer1;
            }

            @Nullable
            public final String getMenuGroup() {
                return this.menuGroup;
            }

            @Nullable
            public final ArrayList getMenuList() {
                return this.menuList;
            }

            public final void setGroupType(@Nullable String s) {
                this.groupType = s;
            }

            public final void setLayer1(@Nullable String s) {
                this.layer1 = s;
            }

            public final void setMenuGroup(@Nullable String s) {
                this.menuGroup = s;
            }

            public final void setMenuList(@Nullable ArrayList arrayList0) {
                this.menuList = arrayList0;
            }
        }

        public static final int $stable = 8;
        @b("LIST")
        @Nullable
        private ArrayList list;
        @b("SNSLIST")
        @Nullable
        private ArrayList snsList;

        @Nullable
        public final ArrayList getList() {
            return this.list;
        }

        @Nullable
        public final ArrayList getSnsList() {
            return this.snsList;
        }

        public final void setList(@Nullable ArrayList arrayList0) {
            this.list = arrayList0;
        }

        public final void setSnsList(@Nullable ArrayList arrayList0) {
            this.snsList = arrayList0;
        }
    }

    public static final int $stable = 8;
    @b("response")
    @Nullable
    private RESPONSE response;

    @Nullable
    public final RESPONSE getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable RESPONSE navigationMenuListRes$RESPONSE0) {
        this.response = navigationMenuListRes$RESPONSE0;
    }
}

