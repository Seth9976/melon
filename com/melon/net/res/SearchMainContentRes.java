package com.melon.net.res;

import A7.d;
import S7.b;
import U4.x;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u00002\u00020\u0001:\u0006\n\u000B\f\r\u000E\u000FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001E\u0010\u0004\u001A\u00020\u00058\u0006@\u0006X\u0087\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/melon/net/res/SearchMainContentRes;", "", "<init>", "()V", "response", "Lcom/melon/net/res/SearchMainContentRes$Response;", "getResponse", "()Lcom/melon/net/res/SearchMainContentRes$Response;", "setResponse", "(Lcom/melon/net/res/SearchMainContentRes$Response;)V", "Response", "TextOffering", "ThemeOffering", "Genre", "ArchivingThemeItem", "ArchivingTheme", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SearchMainContentRes {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u000B\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\u000F\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J9\u0010\u0015\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001A\u00020\u001AHÖ\u0001J\t\u0010\u001B\u001A\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u001C\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001C"}, d2 = {"Lcom/melon/net/res/SearchMainContentRes$ArchivingTheme;", "", "archivingThemeTitle", "", "archivingThemeType", "archivingThemeUrl", "archivingThemeList", "", "Lcom/melon/net/res/SearchMainContentRes$ArchivingThemeItem;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getArchivingThemeTitle", "()Ljava/lang/String;", "getArchivingThemeType", "getArchivingThemeUrl", "getArchivingThemeList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ArchivingTheme {
        public static final int $stable = 8;
        @b("ARCHIVINGTHEMELIST")
        @NotNull
        private final List archivingThemeList;
        @b("ARCHIVINGTHEMETITLE")
        @Nullable
        private final String archivingThemeTitle;
        @b("ARCHIVINGTHEMETYPE")
        @NotNull
        private final String archivingThemeType;
        @b("ARCHIVINGTHEMEURL")
        @NotNull
        private final String archivingThemeUrl;

        public ArchivingTheme() {
            this(null, null, null, null, 15, null);
        }

        public ArchivingTheme(@Nullable String s, @NotNull String s1, @NotNull String s2, @NotNull List list0) {
            q.g(s1, "archivingThemeType");
            q.g(s2, "archivingThemeUrl");
            q.g(list0, "archivingThemeList");
            super();
            this.archivingThemeTitle = s;
            this.archivingThemeType = s1;
            this.archivingThemeUrl = s2;
            this.archivingThemeList = list0;
        }

        public ArchivingTheme(String s, String s1, String s2, List list0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                list0 = new ArrayList();
            }
            this(s, s1, s2, list0);
        }

        @Nullable
        public final String component1() {
            return this.archivingThemeTitle;
        }

        @NotNull
        public final String component2() {
            return this.archivingThemeType;
        }

        @NotNull
        public final String component3() {
            return this.archivingThemeUrl;
        }

        @NotNull
        public final List component4() {
            return this.archivingThemeList;
        }

        @NotNull
        public final ArchivingTheme copy(@Nullable String s, @NotNull String s1, @NotNull String s2, @NotNull List list0) {
            q.g(s1, "archivingThemeType");
            q.g(s2, "archivingThemeUrl");
            q.g(list0, "archivingThemeList");
            return new ArchivingTheme(s, s1, s2, list0);
        }

        public static ArchivingTheme copy$default(ArchivingTheme searchMainContentRes$ArchivingTheme0, String s, String s1, String s2, List list0, int v, Object object0) {
            if((v & 1) != 0) {
                s = searchMainContentRes$ArchivingTheme0.archivingThemeTitle;
            }
            if((v & 2) != 0) {
                s1 = searchMainContentRes$ArchivingTheme0.archivingThemeType;
            }
            if((v & 4) != 0) {
                s2 = searchMainContentRes$ArchivingTheme0.archivingThemeUrl;
            }
            if((v & 8) != 0) {
                list0 = searchMainContentRes$ArchivingTheme0.archivingThemeList;
            }
            return searchMainContentRes$ArchivingTheme0.copy(s, s1, s2, list0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ArchivingTheme)) {
                return false;
            }
            if(!q.b(this.archivingThemeTitle, ((ArchivingTheme)object0).archivingThemeTitle)) {
                return false;
            }
            if(!q.b(this.archivingThemeType, ((ArchivingTheme)object0).archivingThemeType)) {
                return false;
            }
            return q.b(this.archivingThemeUrl, ((ArchivingTheme)object0).archivingThemeUrl) ? q.b(this.archivingThemeList, ((ArchivingTheme)object0).archivingThemeList) : false;
        }

        @NotNull
        public final List getArchivingThemeList() {
            return this.archivingThemeList;
        }

        @Nullable
        public final String getArchivingThemeTitle() [...] // 潜在的解密器

        @NotNull
        public final String getArchivingThemeType() [...] // 潜在的解密器

        @NotNull
        public final String getArchivingThemeUrl() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.archivingThemeTitle == null ? this.archivingThemeList.hashCode() + x.b(x.b(0, 0x1F, this.archivingThemeType), 0x1F, this.archivingThemeUrl) : this.archivingThemeList.hashCode() + x.b(x.b(this.archivingThemeTitle.hashCode() * 0x1F, 0x1F, this.archivingThemeType), 0x1F, this.archivingThemeUrl);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("ArchivingTheme(archivingThemeTitle=", this.archivingThemeTitle, ", archivingThemeType=", this.archivingThemeType, ", archivingThemeUrl=");
            stringBuilder0.append(this.archivingThemeUrl);
            stringBuilder0.append(", archivingThemeList=");
            stringBuilder0.append(this.archivingThemeList);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003JE\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0016\u0010\u0006\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0016\u0010\u0007\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\f¨\u0006\u001F"}, d2 = {"Lcom/melon/net/res/SearchMainContentRes$ArchivingThemeItem;", "", "seq", "", "title", "cardImg", "bgColor", "linkType", "linkUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSeq", "()Ljava/lang/String;", "getTitle", "getCardImg", "getBgColor", "getLinkType", "getLinkUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ArchivingThemeItem {
        public static final int $stable;
        @b("BGCOLOR")
        @NotNull
        private final String bgColor;
        @b("CARDIMG")
        @NotNull
        private final String cardImg;
        @b("LINKTYPE")
        @NotNull
        private final String linkType;
        @b("LINKURL")
        @NotNull
        private final String linkUrl;
        @b("SEQ")
        @NotNull
        private final String seq;
        @b("TITLE")
        @NotNull
        private final String title;

        public ArchivingThemeItem() {
            this(null, null, null, null, null, null, 0x3F, null);
        }

        public ArchivingThemeItem(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5) {
            q.g(s, "seq");
            q.g(s1, "title");
            q.g(s2, "cardImg");
            q.g(s3, "bgColor");
            q.g(s4, "linkType");
            q.g(s5, "linkUrl");
            super();
            this.seq = s;
            this.title = s1;
            this.cardImg = s2;
            this.bgColor = s3;
            this.linkType = s4;
            this.linkUrl = s5;
        }

        public ArchivingThemeItem(String s, String s1, String s2, String s3, String s4, String s5, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "";
            }
            if((v & 16) != 0) {
                s4 = "";
            }
            this(s, s1, s2, s3, s4, ((v & 0x20) == 0 ? s5 : ""));
        }

        @NotNull
        public final String component1() {
            return this.seq;
        }

        @NotNull
        public final String component2() {
            return this.title;
        }

        @NotNull
        public final String component3() {
            return this.cardImg;
        }

        @NotNull
        public final String component4() {
            return this.bgColor;
        }

        @NotNull
        public final String component5() {
            return this.linkType;
        }

        @NotNull
        public final String component6() {
            return this.linkUrl;
        }

        @NotNull
        public final ArchivingThemeItem copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5) {
            q.g(s, "seq");
            q.g(s1, "title");
            q.g(s2, "cardImg");
            q.g(s3, "bgColor");
            q.g(s4, "linkType");
            q.g(s5, "linkUrl");
            return new ArchivingThemeItem(s, s1, s2, s3, s4, s5);
        }

        public static ArchivingThemeItem copy$default(ArchivingThemeItem searchMainContentRes$ArchivingThemeItem0, String s, String s1, String s2, String s3, String s4, String s5, int v, Object object0) {
            if((v & 1) != 0) {
                s = searchMainContentRes$ArchivingThemeItem0.seq;
            }
            if((v & 2) != 0) {
                s1 = searchMainContentRes$ArchivingThemeItem0.title;
            }
            if((v & 4) != 0) {
                s2 = searchMainContentRes$ArchivingThemeItem0.cardImg;
            }
            if((v & 8) != 0) {
                s3 = searchMainContentRes$ArchivingThemeItem0.bgColor;
            }
            if((v & 16) != 0) {
                s4 = searchMainContentRes$ArchivingThemeItem0.linkType;
            }
            if((v & 0x20) != 0) {
                s5 = searchMainContentRes$ArchivingThemeItem0.linkUrl;
            }
            return searchMainContentRes$ArchivingThemeItem0.copy(s, s1, s2, s3, s4, s5);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ArchivingThemeItem)) {
                return false;
            }
            if(!q.b(this.seq, ((ArchivingThemeItem)object0).seq)) {
                return false;
            }
            if(!q.b(this.title, ((ArchivingThemeItem)object0).title)) {
                return false;
            }
            if(!q.b(this.cardImg, ((ArchivingThemeItem)object0).cardImg)) {
                return false;
            }
            if(!q.b(this.bgColor, ((ArchivingThemeItem)object0).bgColor)) {
                return false;
            }
            return q.b(this.linkType, ((ArchivingThemeItem)object0).linkType) ? q.b(this.linkUrl, ((ArchivingThemeItem)object0).linkUrl) : false;
        }

        @NotNull
        public final String getBgColor() [...] // 潜在的解密器

        @NotNull
        public final String getCardImg() [...] // 潜在的解密器

        @NotNull
        public final String getLinkType() [...] // 潜在的解密器

        @NotNull
        public final String getLinkUrl() [...] // 潜在的解密器

        @NotNull
        public final String getSeq() [...] // 潜在的解密器

        @NotNull
        public final String getTitle() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.linkUrl.hashCode() + x.b(x.b(x.b(x.b(this.seq.hashCode() * 0x1F, 0x1F, this.title), 0x1F, this.cardImg), 0x1F, this.bgColor), 0x1F, this.linkType);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("ArchivingThemeItem(seq=", this.seq, ", title=", this.title, ", cardImg=");
            d.u(stringBuilder0, this.cardImg, ", bgColor=", this.bgColor, ", linkType=");
            return d.n(stringBuilder0, this.linkType, ", linkUrl=", this.linkUrl, ")");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003JE\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0016\u0010\u0006\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0016\u0010\u0007\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\f¨\u0006\u001F"}, d2 = {"Lcom/melon/net/res/SearchMainContentRes$Genre;", "", "menuName", "", "genreCode", "landingUrl", "darkModeColor", "lightModeColor", "promotionYn", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMenuName", "()Ljava/lang/String;", "getGenreCode", "getLandingUrl", "getDarkModeColor", "getLightModeColor", "getPromotionYn", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Genre {
        public static final int $stable;
        @b("DARKMODECOLOR")
        @NotNull
        private final String darkModeColor;
        @b("GENRECODE")
        @NotNull
        private final String genreCode;
        @b("LANDINGURL")
        @NotNull
        private final String landingUrl;
        @b("LIGHTMODECOLOR")
        @NotNull
        private final String lightModeColor;
        @b("MENUNAME")
        @NotNull
        private final String menuName;
        @b("PROMOTIONYN")
        @NotNull
        private final String promotionYn;

        public Genre() {
            this(null, null, null, null, null, null, 0x3F, null);
        }

        public Genre(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5) {
            q.g(s, "menuName");
            q.g(s1, "genreCode");
            q.g(s2, "landingUrl");
            q.g(s3, "darkModeColor");
            q.g(s4, "lightModeColor");
            q.g(s5, "promotionYn");
            super();
            this.menuName = s;
            this.genreCode = s1;
            this.landingUrl = s2;
            this.darkModeColor = s3;
            this.lightModeColor = s4;
            this.promotionYn = s5;
        }

        public Genre(String s, String s1, String s2, String s3, String s4, String s5, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "";
            }
            if((v & 16) != 0) {
                s4 = "";
            }
            this(s, s1, s2, s3, s4, ((v & 0x20) == 0 ? s5 : ""));
        }

        @NotNull
        public final String component1() {
            return this.menuName;
        }

        @NotNull
        public final String component2() {
            return this.genreCode;
        }

        @NotNull
        public final String component3() {
            return this.landingUrl;
        }

        @NotNull
        public final String component4() {
            return this.darkModeColor;
        }

        @NotNull
        public final String component5() {
            return this.lightModeColor;
        }

        @NotNull
        public final String component6() {
            return this.promotionYn;
        }

        @NotNull
        public final Genre copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5) {
            q.g(s, "menuName");
            q.g(s1, "genreCode");
            q.g(s2, "landingUrl");
            q.g(s3, "darkModeColor");
            q.g(s4, "lightModeColor");
            q.g(s5, "promotionYn");
            return new Genre(s, s1, s2, s3, s4, s5);
        }

        public static Genre copy$default(Genre searchMainContentRes$Genre0, String s, String s1, String s2, String s3, String s4, String s5, int v, Object object0) {
            if((v & 1) != 0) {
                s = searchMainContentRes$Genre0.menuName;
            }
            if((v & 2) != 0) {
                s1 = searchMainContentRes$Genre0.genreCode;
            }
            if((v & 4) != 0) {
                s2 = searchMainContentRes$Genre0.landingUrl;
            }
            if((v & 8) != 0) {
                s3 = searchMainContentRes$Genre0.darkModeColor;
            }
            if((v & 16) != 0) {
                s4 = searchMainContentRes$Genre0.lightModeColor;
            }
            if((v & 0x20) != 0) {
                s5 = searchMainContentRes$Genre0.promotionYn;
            }
            return searchMainContentRes$Genre0.copy(s, s1, s2, s3, s4, s5);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Genre)) {
                return false;
            }
            if(!q.b(this.menuName, ((Genre)object0).menuName)) {
                return false;
            }
            if(!q.b(this.genreCode, ((Genre)object0).genreCode)) {
                return false;
            }
            if(!q.b(this.landingUrl, ((Genre)object0).landingUrl)) {
                return false;
            }
            if(!q.b(this.darkModeColor, ((Genre)object0).darkModeColor)) {
                return false;
            }
            return q.b(this.lightModeColor, ((Genre)object0).lightModeColor) ? q.b(this.promotionYn, ((Genre)object0).promotionYn) : false;
        }

        @NotNull
        public final String getDarkModeColor() [...] // 潜在的解密器

        @NotNull
        public final String getGenreCode() [...] // 潜在的解密器

        @NotNull
        public final String getLandingUrl() [...] // 潜在的解密器

        @NotNull
        public final String getLightModeColor() [...] // 潜在的解密器

        @NotNull
        public final String getMenuName() [...] // 潜在的解密器

        @NotNull
        public final String getPromotionYn() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.promotionYn.hashCode() + x.b(x.b(x.b(x.b(this.menuName.hashCode() * 0x1F, 0x1F, this.genreCode), 0x1F, this.landingUrl), 0x1F, this.darkModeColor), 0x1F, this.lightModeColor);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("Genre(menuName=", this.menuName, ", genreCode=", this.genreCode, ", landingUrl=");
            d.u(stringBuilder0, this.landingUrl, ", darkModeColor=", this.darkModeColor, ", lightModeColor=");
            return d.n(stringBuilder0, this.lightModeColor, ", promotionYn=", this.promotionYn, ")");
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001C\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001A\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u001C\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\bR\u001C\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00110\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\bR\u0018\u0010\u0013\u001A\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/melon/net/res/SearchMainContentRes$Response;", "Lcom/melon/net/res/common/ResponseBase;", "<init>", "()V", "textOfferingList", "", "Lcom/melon/net/res/SearchMainContentRes$TextOffering;", "getTextOfferingList", "()Ljava/util/List;", "offeringType", "", "getOfferingType", "()Ljava/lang/String;", "themeOfferingList", "Lcom/melon/net/res/SearchMainContentRes$ThemeOffering;", "getThemeOfferingList", "genreList", "Lcom/melon/net/res/SearchMainContentRes$Genre;", "getGenreList", "archiveTheme", "Lcom/melon/net/res/SearchMainContentRes$ArchivingTheme;", "getArchiveTheme", "()Lcom/melon/net/res/SearchMainContentRes$ArchivingTheme;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Response extends ResponseBase {
        public static final int $stable = 8;
        @b("ARCHIVINGTHEME")
        @Nullable
        private final ArchivingTheme archiveTheme;
        @b("GENRELIST")
        @NotNull
        private final List genreList;
        @b("THEMEOFFERINGTYPE")
        @NotNull
        private final String offeringType;
        @b("TEXTOFFERINGLIST")
        @NotNull
        private final List textOfferingList;
        @b("THEMEOFFERINGLIST")
        @NotNull
        private final List themeOfferingList;

        public Response() {
            this.textOfferingList = new ArrayList();
            this.offeringType = "";
            this.themeOfferingList = new ArrayList();
            this.genreList = new ArrayList();
        }

        @Nullable
        public final ArchivingTheme getArchiveTheme() {
            return this.archiveTheme;
        }

        @NotNull
        public final List getGenreList() {
            return this.genreList;
        }

        @NotNull
        public final String getOfferingType() [...] // 潜在的解密器

        @NotNull
        public final List getTextOfferingList() {
            return this.textOfferingList;
        }

        @NotNull
        public final List getThemeOfferingList() {
            return this.themeOfferingList;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0016\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003JE\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001A\u00020\u001A2\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0016\u0010\u0006\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\fR\u0016\u0010\u0007\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001A\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\f¨\u0006\u001F"}, d2 = {"Lcom/melon/net/res/SearchMainContentRes$TextOffering;", "", "offerSeq", "", "linkType", "linkUrl", "scheme", "preFix", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOfferSeq", "()Ljava/lang/String;", "getLinkType", "getLinkUrl", "getScheme", "getPreFix", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TextOffering {
        public static final int $stable;
        @b("LINKTYPE")
        @NotNull
        private final String linkType;
        @b("LINKURL")
        @NotNull
        private final String linkUrl;
        @b("OFFERSEQ")
        @NotNull
        private final String offerSeq;
        @b("PREFIX")
        @NotNull
        private final String preFix;
        @b("SCHEME")
        @NotNull
        private final String scheme;
        @b("TITLE")
        @NotNull
        private final String title;

        public TextOffering() {
            this(null, null, null, null, null, null, 0x3F, null);
        }

        public TextOffering(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5) {
            q.g(s, "offerSeq");
            q.g(s1, "linkType");
            q.g(s2, "linkUrl");
            q.g(s3, "scheme");
            q.g(s4, "preFix");
            q.g(s5, "title");
            super();
            this.offerSeq = s;
            this.linkType = s1;
            this.linkUrl = s2;
            this.scheme = s3;
            this.preFix = s4;
            this.title = s5;
        }

        public TextOffering(String s, String s1, String s2, String s3, String s4, String s5, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "";
            }
            if((v & 16) != 0) {
                s4 = "";
            }
            this(s, s1, s2, s3, s4, ((v & 0x20) == 0 ? s5 : ""));
        }

        @NotNull
        public final String component1() {
            return this.offerSeq;
        }

        @NotNull
        public final String component2() {
            return this.linkType;
        }

        @NotNull
        public final String component3() {
            return this.linkUrl;
        }

        @NotNull
        public final String component4() {
            return this.scheme;
        }

        @NotNull
        public final String component5() {
            return this.preFix;
        }

        @NotNull
        public final String component6() {
            return this.title;
        }

        @NotNull
        public final TextOffering copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5) {
            q.g(s, "offerSeq");
            q.g(s1, "linkType");
            q.g(s2, "linkUrl");
            q.g(s3, "scheme");
            q.g(s4, "preFix");
            q.g(s5, "title");
            return new TextOffering(s, s1, s2, s3, s4, s5);
        }

        public static TextOffering copy$default(TextOffering searchMainContentRes$TextOffering0, String s, String s1, String s2, String s3, String s4, String s5, int v, Object object0) {
            if((v & 1) != 0) {
                s = searchMainContentRes$TextOffering0.offerSeq;
            }
            if((v & 2) != 0) {
                s1 = searchMainContentRes$TextOffering0.linkType;
            }
            if((v & 4) != 0) {
                s2 = searchMainContentRes$TextOffering0.linkUrl;
            }
            if((v & 8) != 0) {
                s3 = searchMainContentRes$TextOffering0.scheme;
            }
            if((v & 16) != 0) {
                s4 = searchMainContentRes$TextOffering0.preFix;
            }
            if((v & 0x20) != 0) {
                s5 = searchMainContentRes$TextOffering0.title;
            }
            return searchMainContentRes$TextOffering0.copy(s, s1, s2, s3, s4, s5);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof TextOffering)) {
                return false;
            }
            if(!q.b(this.offerSeq, ((TextOffering)object0).offerSeq)) {
                return false;
            }
            if(!q.b(this.linkType, ((TextOffering)object0).linkType)) {
                return false;
            }
            if(!q.b(this.linkUrl, ((TextOffering)object0).linkUrl)) {
                return false;
            }
            if(!q.b(this.scheme, ((TextOffering)object0).scheme)) {
                return false;
            }
            return q.b(this.preFix, ((TextOffering)object0).preFix) ? q.b(this.title, ((TextOffering)object0).title) : false;
        }

        @NotNull
        public final String getLinkType() [...] // 潜在的解密器

        @NotNull
        public final String getLinkUrl() [...] // 潜在的解密器

        @NotNull
        public final String getOfferSeq() {
            return this.offerSeq;
        }

        @NotNull
        public final String getPreFix() [...] // 潜在的解密器

        @NotNull
        public final String getScheme() [...] // 潜在的解密器

        @NotNull
        public final String getTitle() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.title.hashCode() + x.b(x.b(x.b(x.b(this.offerSeq.hashCode() * 0x1F, 0x1F, this.linkType), 0x1F, this.linkUrl), 0x1F, this.scheme), 0x1F, this.preFix);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("TextOffering(offerSeq=", this.offerSeq, ", linkType=", this.linkType, ", linkUrl=");
            d.u(stringBuilder0, this.linkUrl, ", scheme=", this.scheme, ", preFix=");
            return d.n(stringBuilder0, this.preFix, ", title=", this.title, ")");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u001C\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\b\b\u0002\u0010\b\u001A\u00020\u0003\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\u0003\u00A2\u0006\u0004\b\u000B\u0010\fJ\t\u0010\u0016\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u0017\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u0018\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u0019\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001A\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001B\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001C\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001D\u001A\u00020\u0003H\u00C6\u0003JY\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u0003H\u00C6\u0001J\u0013\u0010\u001F\u001A\u00020 2\b\u0010!\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003J\t\u0010\"\u001A\u00020#H\u00D6\u0001J\t\u0010$\u001A\u00020\u0003H\u00D6\u0001R\u0016\u0010\u0002\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0016\u0010\u0004\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u000ER\u0016\u0010\u0005\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000ER\u0016\u0010\u0006\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000ER\u0016\u0010\u0007\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000ER\u0016\u0010\b\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000ER\u0016\u0010\t\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000ER\u0016\u0010\n\u001A\u00020\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000E\u00A8\u0006%"}, d2 = {"Lcom/melon/net/res/SearchMainContentRes$ThemeOffering;", "", "offerSeq", "", "linkType", "linkUrl", "scheme", "title", "imagePath", "bgColor", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOfferSeq", "()Ljava/lang/String;", "getLinkType", "getLinkUrl", "getScheme", "getTitle", "getImagePath", "getBgColor", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ThemeOffering {
        public static final int $stable;
        @b("BGCOLOR")
        @NotNull
        private final String bgColor;
        @b("IMAGEPATH")
        @NotNull
        private final String imagePath;
        @b("LINKTYPE")
        @NotNull
        private final String linkType;
        @b("LINKURL")
        @NotNull
        private final String linkUrl;
        @b("OFFERSEQ")
        @NotNull
        private final String offerSeq;
        @b("SCHEME")
        @NotNull
        private final String scheme;
        @b("TITLE")
        @NotNull
        private final String title;
        @b("TYPE")
        @NotNull
        private final String type;

        public ThemeOffering() {
            this(null, null, null, null, null, null, null, null, 0xFF, null);
        }

        public ThemeOffering(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7) {
            q.g(s, "offerSeq");
            q.g(s1, "linkType");
            q.g(s2, "linkUrl");
            q.g(s3, "scheme");
            q.g(s4, "title");
            q.g(s5, "imagePath");
            q.g(s6, "bgColor");
            q.g(s7, "type");
            super();
            this.offerSeq = s;
            this.linkType = s1;
            this.linkUrl = s2;
            this.scheme = s3;
            this.title = s4;
            this.imagePath = s5;
            this.bgColor = s6;
            this.type = s7;
        }

        public ThemeOffering(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                s2 = "";
            }
            if((v & 8) != 0) {
                s3 = "";
            }
            if((v & 16) != 0) {
                s4 = "";
            }
            if((v & 0x20) != 0) {
                s5 = "";
            }
            if((v & 0x40) != 0) {
                s6 = "";
            }
            this(s, s1, s2, s3, s4, s5, s6, ((v & 0x80) == 0 ? s7 : ""));
        }

        @NotNull
        public final String component1() {
            return this.offerSeq;
        }

        @NotNull
        public final String component2() {
            return this.linkType;
        }

        @NotNull
        public final String component3() {
            return this.linkUrl;
        }

        @NotNull
        public final String component4() {
            return this.scheme;
        }

        @NotNull
        public final String component5() {
            return this.title;
        }

        @NotNull
        public final String component6() {
            return this.imagePath;
        }

        @NotNull
        public final String component7() {
            return this.bgColor;
        }

        @NotNull
        public final String component8() {
            return this.type;
        }

        @NotNull
        public final ThemeOffering copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7) {
            q.g(s, "offerSeq");
            q.g(s1, "linkType");
            q.g(s2, "linkUrl");
            q.g(s3, "scheme");
            q.g(s4, "title");
            q.g(s5, "imagePath");
            q.g(s6, "bgColor");
            q.g(s7, "type");
            return new ThemeOffering(s, s1, s2, s3, s4, s5, s6, s7);
        }

        public static ThemeOffering copy$default(ThemeOffering searchMainContentRes$ThemeOffering0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, int v, Object object0) {
            if((v & 1) != 0) {
                s = searchMainContentRes$ThemeOffering0.offerSeq;
            }
            if((v & 2) != 0) {
                s1 = searchMainContentRes$ThemeOffering0.linkType;
            }
            if((v & 4) != 0) {
                s2 = searchMainContentRes$ThemeOffering0.linkUrl;
            }
            if((v & 8) != 0) {
                s3 = searchMainContentRes$ThemeOffering0.scheme;
            }
            if((v & 16) != 0) {
                s4 = searchMainContentRes$ThemeOffering0.title;
            }
            if((v & 0x20) != 0) {
                s5 = searchMainContentRes$ThemeOffering0.imagePath;
            }
            if((v & 0x40) != 0) {
                s6 = searchMainContentRes$ThemeOffering0.bgColor;
            }
            if((v & 0x80) != 0) {
                s7 = searchMainContentRes$ThemeOffering0.type;
            }
            return searchMainContentRes$ThemeOffering0.copy(s, s1, s2, s3, s4, s5, s6, s7);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ThemeOffering)) {
                return false;
            }
            if(!q.b(this.offerSeq, ((ThemeOffering)object0).offerSeq)) {
                return false;
            }
            if(!q.b(this.linkType, ((ThemeOffering)object0).linkType)) {
                return false;
            }
            if(!q.b(this.linkUrl, ((ThemeOffering)object0).linkUrl)) {
                return false;
            }
            if(!q.b(this.scheme, ((ThemeOffering)object0).scheme)) {
                return false;
            }
            if(!q.b(this.title, ((ThemeOffering)object0).title)) {
                return false;
            }
            if(!q.b(this.imagePath, ((ThemeOffering)object0).imagePath)) {
                return false;
            }
            return q.b(this.bgColor, ((ThemeOffering)object0).bgColor) ? q.b(this.type, ((ThemeOffering)object0).type) : false;
        }

        @NotNull
        public final String getBgColor() [...] // 潜在的解密器

        @NotNull
        public final String getImagePath() [...] // 潜在的解密器

        @NotNull
        public final String getLinkType() [...] // 潜在的解密器

        @NotNull
        public final String getLinkUrl() [...] // 潜在的解密器

        @NotNull
        public final String getOfferSeq() [...] // 潜在的解密器

        @NotNull
        public final String getScheme() [...] // 潜在的解密器

        @NotNull
        public final String getTitle() [...] // 潜在的解密器

        @NotNull
        public final String getType() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.type.hashCode() + x.b(x.b(x.b(x.b(x.b(x.b(this.offerSeq.hashCode() * 0x1F, 0x1F, this.linkType), 0x1F, this.linkUrl), 0x1F, this.scheme), 0x1F, this.title), 0x1F, this.imagePath), 0x1F, this.bgColor);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("ThemeOffering(offerSeq=", this.offerSeq, ", linkType=", this.linkType, ", linkUrl=");
            d.u(stringBuilder0, this.linkUrl, ", scheme=", this.scheme, ", title=");
            d.u(stringBuilder0, this.title, ", imagePath=", this.imagePath, ", bgColor=");
            return d.n(stringBuilder0, this.bgColor, ", type=", this.type, ")");
        }
    }

    public static final int $stable = 8;
    @b("response")
    @NotNull
    private Response response;

    public SearchMainContentRes() {
        this.response = new Response();
    }

    @NotNull
    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(@NotNull Response searchMainContentRes$Response0) {
        q.g(searchMainContentRes$Response0, "<set-?>");
        this.response = searchMainContentRes$Response0;
    }
}

