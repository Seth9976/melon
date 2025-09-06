package com.iloen.melon.utils.template;

import Tf.o;
import android.view.View;
import android.widget.ImageView;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.net.v6x.response.ForUMixInfoBase;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.ArrayList;
import java.util.List;
import je.p;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0019\b\u0007\u0018\u0000 +2\u00020\u0001:\r+,-./01234567B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\b\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\u0006\u0010\u000BR\u0016\u0010\n\u001A\u00020\t8\u0006@\u0006X\u0087\u000E¢\u0006\u0006\n\u0004\b\n\u0010\fR$\u0010\u0003\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r8\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R$\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00048\u0006@BX\u0086\u000E¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016R\"\u0010\u001E\u001A\u00020\u00178\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR$\u0010&\u001A\u0004\u0018\u00010\u001F8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010*\u001A\u0004\u0018\u00010\u001F8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\'\u0010!\u001A\u0004\b(\u0010#\"\u0004\b)\u0010%¨\u00068"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData;", "", "Lcom/iloen/melon/custom/CoverView;", "targetView", "Lcom/iloen/melon/utils/template/TemplateCoverInfo;", "templateCoverInfo", "<init>", "(Lcom/iloen/melon/custom/CoverView;Lcom/iloen/melon/utils/template/TemplateCoverInfo;)V", "Landroid/widget/ImageView;", "", "standardSizeDp", "(Landroid/widget/ImageView;Lcom/iloen/melon/utils/template/TemplateCoverInfo;I)V", "I", "Landroid/view/View;", "value", "a", "Landroid/view/View;", "getTargetView", "()Landroid/view/View;", "b", "Lcom/iloen/melon/utils/template/TemplateCoverInfo;", "getTemplateCoverInfo", "()Lcom/iloen/melon/utils/template/TemplateCoverInfo;", "", "c", "Z", "getShowTitle", "()Z", "setShowTitle", "(Z)V", "showTitle", "", "d", "Ljava/lang/String;", "getAnimationImgUrl", "()Ljava/lang/String;", "setAnimationImgUrl", "(Ljava/lang/String;)V", "animationImgUrl", "e", "getShadowColor", "setShadowColor", "shadowColor", "Companion", "Builder", "CustomTemplateDataBuilder", "UserTasteShortCutTemplateDataBuilder", "WelcomePickTemplateDataBuilder", "ArtistMixDataBuilder", "SingleImageTemplateDataBuilder", "RecentRecmTemplateDataBuilder", "GenreRecmTemplateDataBuilder", "StationRecmTemplateDataBuilder", "DjPlaylistTemplateDataBuilder", "MixMakerPlaylistTemplateDataBuilder", "DrawerPlaylistArtistMixTemplateDataBuilder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TemplateData {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u000E\u0010\u0006\u001A\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B\u0012\b\b\u0002\u0010\f\u001A\u00020\u0005¢\u0006\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$ArtistMixDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "artistName", "", "artistImgUrl", "", "coverImgUrl", "contsId", "isMelonLogo", "", "shadowColor", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ArtistMixDataBuilder extends CustomTemplateDataBuilder {
        public static final int $stable = 8;

        public ArtistMixDataBuilder(@NotNull CoverView coverView0, @Nullable String s, @Nullable List list0, @Nullable String s1, @Nullable String s2, boolean z, @NotNull String s3) {
            q.g(coverView0, "targetView");
            q.g(s3, "shadowColor");
            super(coverView0, "TYPE_FORU_ARTIST");
            this.title(s);
            this.addImgUrl(s1);
            if(list0 != null) {
                for(Object object0: list0) {
                    this.addImgUrl(((String)object0));
                }
            }
            this.subType(s2);
            this.isMelonLogo(z);
            this.shadowColor(s3);
        }

        public ArtistMixDataBuilder(CoverView coverView0, String s, List list0, String s1, String s2, boolean z, String s3, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 0x20) != 0) {
                z = true;
            }
            this(coverView0, s, list0, s1, s2, z, ((v & 0x40) == 0 ? s3 : ""));
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001FB\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\u000B\u0010\fR\"\u0010\u0003\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0005\u001A\u00020\u00048\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0007\u001A\u00020\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$Builder;", "", "Lcom/iloen/melon/custom/CoverView;", "coverView", "Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;", "mixInfo", "Lcom/iloen/melon/utils/template/TemplateData$Builder$BUILD_TYPE;", "buildType", "<init>", "(Lcom/iloen/melon/custom/CoverView;Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;Lcom/iloen/melon/utils/template/TemplateData$Builder$BUILD_TYPE;)V", "Lcom/iloen/melon/utils/template/TemplateData;", "build", "()Lcom/iloen/melon/utils/template/TemplateData;", "a", "Lcom/iloen/melon/custom/CoverView;", "getCoverView", "()Lcom/iloen/melon/custom/CoverView;", "setCoverView", "(Lcom/iloen/melon/custom/CoverView;)V", "b", "Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;", "getMixInfo", "()Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;", "setMixInfo", "(Lcom/iloen/melon/net/v6x/response/ForUMixInfoBase;)V", "c", "Lcom/iloen/melon/utils/template/TemplateData$Builder$BUILD_TYPE;", "getBuildType", "()Lcom/iloen/melon/utils/template/TemplateData$Builder$BUILD_TYPE;", "setBuildType", "(Lcom/iloen/melon/utils/template/TemplateData$Builder$BUILD_TYPE;)V", "BUILD_TYPE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Builder {
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$Builder$BUILD_TYPE;", "", "TOP", "MAIN", "DETAIL", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static enum BUILD_TYPE {
            TOP,
            MAIN,
            DETAIL;

            public static final BUILD_TYPE[] a;
            public static final b b;

            static {
                BUILD_TYPE.a = arr_templateData$Builder$BUILD_TYPE;
                q.g(arr_templateData$Builder$BUILD_TYPE, "entries");
                BUILD_TYPE.b = new b(arr_templateData$Builder$BUILD_TYPE);
            }

            @NotNull
            public static a getEntries() {
                return BUILD_TYPE.b;
            }
        }

        public static final int $stable = 8;
        public CoverView a;
        public ForUMixInfoBase b;
        public BUILD_TYPE c;

        public Builder(@NotNull CoverView coverView0, @NotNull ForUMixInfoBase forUMixInfoBase0, @NotNull BUILD_TYPE templateData$Builder$BUILD_TYPE0) {
            q.g(coverView0, "coverView");
            q.g(forUMixInfoBase0, "mixInfo");
            q.g(templateData$Builder$BUILD_TYPE0, "buildType");
            super();
            this.a = coverView0;
            this.b = forUMixInfoBase0;
            this.c = templateData$Builder$BUILD_TYPE0;
        }

        // 去混淆评级： 低(28)
        @Nullable
        public final TemplateData build() {
            ArrayList arrayList0 = new ArrayList();
            BUILD_TYPE templateData$Builder$BUILD_TYPE0 = this.c;
            w w0 = w.a;
            if(templateData$Builder$BUILD_TYPE0 == BUILD_TYPE.TOP) {
                if("TYPE_UNKNOWN".equals("TYPE_FORU_DAILY_PICK") || "TYPE_UNKNOWN".equals("TYPE_FORU_WEEKLY_PICK") || "TYPE_UNKNOWN".equals("TYPE_FORU_NEW_SONGS")) {
                    String s1 = this.b.getMixTabImageUrl();
                    if(s1 != null && !o.H0(s1)) {
                        String s2 = this.b.getMixTabImageUrl();
                        if(s2 == null) {
                            s2 = "";
                        }
                        arrayList0.add(s2);
                    }
                    String s3 = this.b.getMixTabInsideImageUrl();
                    boolean z = s3 == null || o.H0(s3);
                }
                else {
                    ArrayList arrayList1 = this.b.getUpperImgUrls();
                    if(arrayList1 != null && !arrayList1.isEmpty()) {
                        ArrayList arrayList2 = this.b.getUpperImgUrls();
                        if(arrayList2 != null) {
                            w0 = arrayList2;
                        }
                        arrayList0.addAll(w0);
                    }
                    ArrayList arrayList3 = this.b.getUpperInsideImgUrls();
                    if(arrayList3 != null && !arrayList3.isEmpty()) {
                        ArrayList arrayList4 = this.b.getUpperInsideImgUrls();
                        if(arrayList4 != null) {
                            String s = (String)p.m0(arrayList4);
                        }
                    }
                }
                boolean z1 = !"TYPE_UNKNOWN".equals("TYPE_FORU_ARTIST");
                ScreenUtils.isDarkMode(this.a.getContext());
                return null;
            }
            if(templateData$Builder$BUILD_TYPE0 == BUILD_TYPE.MAIN) {
                if("TYPE_UNKNOWN".equals("TYPE_FORU_DAILY_PICK") || "TYPE_UNKNOWN".equals("TYPE_FORU_WEEKLY_PICK") || "TYPE_UNKNOWN".equals("TYPE_FORU_NEW_SONGS")) {
                    String s4 = this.b.getMixTabImageUrl();
                    if(s4 != null && !o.H0(s4)) {
                        String s5 = this.b.getMixTabImageUrl();
                        if(s5 == null) {
                            s5 = "";
                        }
                        arrayList0.add(s5);
                    }
                }
                else {
                    ArrayList arrayList5 = this.b.getMainImgUrls();
                    if(arrayList5 != null && !arrayList5.isEmpty()) {
                        ArrayList arrayList6 = this.b.getMainImgUrls();
                        if(arrayList6 != null) {
                            w0 = arrayList6;
                        }
                        arrayList0.addAll(w0);
                    }
                }
                "TYPE_UNKNOWN".equals("TYPE_FORU_ARTIST");
                return null;
            }
            ArrayList arrayList7 = this.b.getDetailImgUrls();
            if(arrayList7 != null && !arrayList7.isEmpty()) {
                ArrayList arrayList8 = this.b.getDetailImgUrls();
                if(arrayList8 != null) {
                    w0 = arrayList8;
                }
                arrayList0.addAll(w0);
            }
            return "TYPE_UNKNOWN".equals("TYPE_FORU_ARTIST") ? null : null;
        }

        @NotNull
        public final BUILD_TYPE getBuildType() {
            return this.c;
        }

        @NotNull
        public final CoverView getCoverView() {
            return this.a;
        }

        @NotNull
        public final ForUMixInfoBase getMixInfo() {
            return this.b;
        }

        public final void setBuildType(@NotNull BUILD_TYPE templateData$Builder$BUILD_TYPE0) {
            q.g(templateData$Builder$BUILD_TYPE0, "<set-?>");
            this.c = templateData$Builder$BUILD_TYPE0;
        }

        public final void setCoverView(@NotNull CoverView coverView0) {
            q.g(coverView0, "<set-?>");
            this.a = coverView0;
        }

        public final void setMixInfo(@NotNull ForUMixInfoBase forUMixInfoBase0) {
            q.g(forUMixInfoBase0, "<set-?>");
            this.b = forUMixInfoBase0;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$Companion;", "", "", "STANDARD_DP_SIZE_FORU_SMALL_COVER", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b.\b\u0017\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001A\u00020\u00002\b\u0010\b\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000B\u001A\u00020\u00002\u0006\u0010\u000B\u001A\u00020\n\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\u00002\b\u0010\r\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u000E\u0010\tJ+\u0010\u000E\u001A\u00020\u00002\b\u0010\r\u001A\u0004\u0018\u00010\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u00042\b\u0010\u0010\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u000E\u0010\u0011J\u0017\u0010\u0012\u001A\u00020\u00002\b\u0010\u0012\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0012\u0010\tJ\u0017\u0010\u0013\u001A\u00020\u00002\b\u0010\u0013\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0013\u0010\tJ\u0017\u0010\u0014\u001A\u00020\u00002\b\u0010\u0014\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u0014\u0010\tJ)\u0010\u0017\u001A\u00020\u00002\u001A\u0010\u0017\u001A\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u00002\b\u0010\u0019\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u001A\u0010\tJ\u0017\u0010\u001B\u001A\u00020\u00002\b\u0010\u001B\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u001B\u0010\tJ\u0017\u0010\u001C\u001A\u00020\u00002\b\u0010\u001C\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b\u001C\u0010\tJ\r\u0010\u001E\u001A\u00020\u001D\u00A2\u0006\u0004\b\u001E\u0010\u001FR\"\u0010\u0005\u001A\u00020\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0003\u001A\u00020&8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00104\u001A\u00020-8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b.\u0010/\u001A\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\b\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b5\u0010!\u001A\u0004\b6\u0010#\"\u0004\b7\u0010%R\"\u0010\u000B\u001A\u00020\n8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b8\u00109\u001A\u0004\b\u000B\u0010:\"\u0004\b;\u0010<R$\u0010\r\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b=\u0010!\u001A\u0004\b>\u0010#\"\u0004\b?\u0010%R$\u0010\u000F\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b@\u0010!\u001A\u0004\bA\u0010#\"\u0004\bB\u0010%R$\u0010\u0010\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bC\u0010!\u001A\u0004\bD\u0010#\"\u0004\bE\u0010%R$\u0010\u0012\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bF\u0010!\u001A\u0004\bG\u0010#\"\u0004\bH\u0010%R$\u0010\u0013\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bI\u0010!\u001A\u0004\bJ\u0010#\"\u0004\bK\u0010%R6\u0010\u0017\u001A\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00168\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bL\u0010M\u001A\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010\u0014\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bR\u0010!\u001A\u0004\bS\u0010#\"\u0004\bT\u0010%R$\u0010\u001B\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bU\u0010!\u001A\u0004\bV\u0010#\"\u0004\bW\u0010%R$\u0010\u001C\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bX\u0010!\u001A\u0004\bY\u0010#\"\u0004\bZ\u0010%\u00A8\u0006["}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "", "Lcom/iloen/melon/custom/CoverView;", "targetView", "", "type", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;)V", "subType", "(Ljava/lang/String;)Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "", "isMelonLogo", "(Z)Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "mainTitle", "title", "mainTitleLine1", "mainTitleLine2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "textShadowColor", "subTitle", "animationImgUrl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imgUrlList", "(Ljava/util/ArrayList;)Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "imgUrl", "addImgUrl", "shadowColor", "bgColor", "Lcom/iloen/melon/utils/template/TemplateData;", "build", "()Lcom/iloen/melon/utils/template/TemplateData;", "a", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "Landroid/view/View;", "b", "Landroid/view/View;", "getTargetView", "()Landroid/view/View;", "setTargetView", "(Landroid/view/View;)V", "", "c", "I", "getStandardSizeDp", "()I", "setStandardSizeDp", "(I)V", "standardSizeDp", "d", "getSubType", "setSubType", "e", "Z", "()Z", "setMelonLogo", "(Z)V", "f", "getMainTitle", "setMainTitle", "g", "getMainTitleLine1", "setMainTitleLine1", "h", "getMainTitleLine2", "setMainTitleLine2", "i", "getTextShadowColor", "setTextShadowColor", "j", "getSubTitle", "setSubTitle", "k", "Ljava/util/ArrayList;", "getImgUrlList", "()Ljava/util/ArrayList;", "setImgUrlList", "(Ljava/util/ArrayList;)V", "l", "getAnimationImgUrl", "setAnimationImgUrl", "m", "getShadowColor", "setShadowColor", "n", "getBgColor", "setBgColor", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class CustomTemplateDataBuilder {
        public static final int $stable = 8;
        public String a;
        public View b;
        public int c;
        public String d;
        public boolean e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public ArrayList k;
        public String l;
        public String m;
        public String n;

        public CustomTemplateDataBuilder(@NotNull CoverView coverView0, @NotNull String s) {
            q.g(coverView0, "targetView");
            q.g(s, "type");
            super();
            this.a = s;
            this.b = coverView0;
            this.e = true;
        }

        @NotNull
        public final CustomTemplateDataBuilder addImgUrl(@Nullable String s) {
            if(s != null) {
                if(this.k == null) {
                    this.k = new ArrayList();
                }
                ArrayList arrayList0 = this.k;
                if(arrayList0 != null) {
                    arrayList0.add(s);
                }
            }
            return this;
        }

        @NotNull
        public final CustomTemplateDataBuilder animationImgUrl(@Nullable String s) {
            this.l = s;
            return this;
        }

        @NotNull
        public final CustomTemplateDataBuilder bgColor(@Nullable String s) {
            this.n = s;
            return this;
        }

        @NotNull
        public final TemplateData build() {
            TemplateData templateData0;
            TemplateCoverInfo templateCoverInfo0 = new TemplateCoverInfo();
            templateCoverInfo0.setTitle(this.f);
            templateCoverInfo0.setTitleLine1(this.g);
            templateCoverInfo0.setTitleLine2(this.h);
            templateCoverInfo0.setSubTitle(this.j);
            templateCoverInfo0.setType(this.a);
            templateCoverInfo0.setSubType(this.d);
            templateCoverInfo0.setTextShadowColor(this.i);
            templateCoverInfo0.setImages(this.k);
            templateCoverInfo0.setShowMelonLogo(this.e);
            String s = this.n;
            if(s != null) {
                ArrayList arrayList0 = new ArrayList();
                arrayList0.add(s);
                templateCoverInfo0.setBgColors(arrayList0);
            }
            if(this.b instanceof CoverView) {
                View view0 = this.b;
                q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.CoverView");
                templateData0 = new TemplateData(((CoverView)view0), templateCoverInfo0);
            }
            else {
                View view1 = this.b;
                q.e(view1, "null cannot be cast to non-null type android.widget.ImageView");
                templateData0 = new TemplateData(((ImageView)view1), templateCoverInfo0, this.c);
            }
            templateData0.setShadowColor(this.m);
            templateData0.setAnimationImgUrl(this.l);
            return templateData0;
        }

        @Nullable
        public final String getAnimationImgUrl() {
            return this.l;
        }

        @Nullable
        public final String getBgColor() {
            return this.n;
        }

        @Nullable
        public final ArrayList getImgUrlList() {
            return this.k;
        }

        @Nullable
        public final String getMainTitle() {
            return this.f;
        }

        @Nullable
        public final String getMainTitleLine1() {
            return this.g;
        }

        @Nullable
        public final String getMainTitleLine2() {
            return this.h;
        }

        @Nullable
        public final String getShadowColor() {
            return this.m;
        }

        public final int getStandardSizeDp() {
            return this.c;
        }

        @Nullable
        public final String getSubTitle() {
            return this.j;
        }

        @Nullable
        public final String getSubType() {
            return this.d;
        }

        @NotNull
        public final View getTargetView() {
            return this.b;
        }

        @Nullable
        public final String getTextShadowColor() {
            return this.i;
        }

        @NotNull
        public final String getType() {
            return this.a;
        }

        @NotNull
        public final CustomTemplateDataBuilder imgUrlList(@Nullable ArrayList arrayList0) {
            this.k = arrayList0;
            return this;
        }

        @NotNull
        public final CustomTemplateDataBuilder isMelonLogo(boolean z) {
            this.e = z;
            return this;
        }

        public final boolean isMelonLogo() {
            return this.e;
        }

        public final void setAnimationImgUrl(@Nullable String s) {
            this.l = s;
        }

        public final void setBgColor(@Nullable String s) {
            this.n = s;
        }

        public final void setImgUrlList(@Nullable ArrayList arrayList0) {
            this.k = arrayList0;
        }

        public final void setMainTitle(@Nullable String s) {
            this.f = s;
        }

        public final void setMainTitleLine1(@Nullable String s) {
            this.g = s;
        }

        public final void setMainTitleLine2(@Nullable String s) {
            this.h = s;
        }

        public final void setMelonLogo(boolean z) {
            this.e = z;
        }

        public final void setShadowColor(@Nullable String s) {
            this.m = s;
        }

        public final void setStandardSizeDp(int v) {
            this.c = v;
        }

        public final void setSubTitle(@Nullable String s) {
            this.j = s;
        }

        public final void setSubType(@Nullable String s) {
            this.d = s;
        }

        public final void setTargetView(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.b = view0;
        }

        public final void setTextShadowColor(@Nullable String s) {
            this.i = s;
        }

        public final void setType(@NotNull String s) {
            q.g(s, "<set-?>");
            this.a = s;
        }

        @NotNull
        public final CustomTemplateDataBuilder shadowColor(@Nullable String s) {
            this.m = s;
            return this;
        }

        @NotNull
        public final CustomTemplateDataBuilder subTitle(@Nullable String s) {
            this.j = s;
            return this;
        }

        @NotNull
        public final CustomTemplateDataBuilder subType(@Nullable String s) {
            this.d = s;
            return this;
        }

        @NotNull
        public final CustomTemplateDataBuilder textShadowColor(@Nullable String s) {
            this.i = s;
            return this;
        }

        @NotNull
        public final CustomTemplateDataBuilder title(@Nullable String s) {
            this.f = s;
            return this;
        }

        @NotNull
        public final CustomTemplateDataBuilder title(@Nullable String s, @Nullable String s1, @Nullable String s2) {
            this.f = s;
            this.g = s1;
            this.h = s2;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$DjPlaylistTemplateDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$SingleImageTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "title", "", "subTitle", "coverImgUrl", "bgColor", "shadowColor", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DjPlaylistTemplateDataBuilder extends SingleImageTemplateDataBuilder {
        public static final int $stable = 8;

        public DjPlaylistTemplateDataBuilder(@NotNull CoverView coverView0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
            q.g(coverView0, "targetView");
            super(coverView0, "TYPE_FORU_DJ_PLAYLIST", s2);
            this.title(s);
            this.subTitle(s1);
            this.bgColor(s3);
            this.shadowColor(s4);
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$DrawerPlaylistArtistMixTemplateDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "contsId", "", "thumbImageList", "", "artistName", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DrawerPlaylistArtistMixTemplateDataBuilder extends CustomTemplateDataBuilder {
        public static final int $stable = 8;

        public DrawerPlaylistArtistMixTemplateDataBuilder(@NotNull CoverView coverView0, @Nullable String s, @NotNull List list0, @Nullable String s1) {
            q.g(coverView0, "targetView");
            q.g(list0, "thumbImageList");
            super(coverView0, "TYPE_FORU_ARTIST");
            for(Object object0: list0) {
                this.addImgUrl(((String)object0));
            }
            this.setSubType(s);
            this.title(s1);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$GenreRecmTemplateDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$SingleImageTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "title", "", "subTitle", "coverImgUrl", "bgColor", "shadowColor", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class GenreRecmTemplateDataBuilder extends SingleImageTemplateDataBuilder {
        public static final int $stable = 8;

        public GenreRecmTemplateDataBuilder(@NotNull CoverView coverView0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
            q.g(coverView0, "targetView");
            super(coverView0, "TYPE_FORU_GENRE_RECM", s2);
            this.title(s);
            this.subTitle(s1);
            this.bgColor(s3);
            this.shadowColor(s4);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u001A\u0010\u0004\u001A\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$MixMakerPlaylistTemplateDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "imgUrls", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/util/ArrayList;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MixMakerPlaylistTemplateDataBuilder extends CustomTemplateDataBuilder {
        public static final int $stable = 8;

        public MixMakerPlaylistTemplateDataBuilder(@NotNull CoverView coverView0, @Nullable ArrayList arrayList0) {
            q.g(coverView0, "targetView");
            super(coverView0, "TYPE_FORU_MIX_MAKER_PLAYLIST");
            this.imgUrlList(arrayList0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$RecentRecmTemplateDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$SingleImageTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "title", "", "subTitle", "coverImgUrl", "bgColor", "shadowColor", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class RecentRecmTemplateDataBuilder extends SingleImageTemplateDataBuilder {
        public static final int $stable = 8;

        public RecentRecmTemplateDataBuilder(@NotNull CoverView coverView0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
            q.g(coverView0, "targetView");
            super(coverView0, "TYPE_FORU_RECENT_RECM", s2);
            this.title(s);
            this.subTitle(s1);
            this.bgColor(s3);
            this.shadowColor(s4);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$SingleImageTemplateDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "type", "", "coverImgUrl", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class SingleImageTemplateDataBuilder extends CustomTemplateDataBuilder {
        public static final int $stable = 8;

        public SingleImageTemplateDataBuilder(@NotNull CoverView coverView0, @NotNull String s, @Nullable String s1) {
            q.g(coverView0, "targetView");
            q.g(s, "type");
            super(coverView0, s);
            this.setImgUrlList(new ArrayList());
            if(s1 != null && s1.length() != 0) {
                ArrayList arrayList0 = this.getImgUrlList();
                if(arrayList0 != null) {
                    arrayList0.add(s1);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$StationRecmTemplateDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$SingleImageTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "title", "", "subTitle", "coverImgUrl", "bgColor", "shadowColor", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class StationRecmTemplateDataBuilder extends SingleImageTemplateDataBuilder {
        public static final int $stable = 8;

        public StationRecmTemplateDataBuilder(@NotNull CoverView coverView0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
            q.g(coverView0, "targetView");
            super(coverView0, "TYPE_FORU_STATION_RECM", s2);
            this.title(s);
            this.subTitle(s1);
            this.bgColor(s3);
            this.shadowColor(s4);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$UserTasteShortCutTemplateDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "mainTitle", "", "mainTitleLine1", "mainTitleLine2", "shadowColor", "animationImgUrl", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class UserTasteShortCutTemplateDataBuilder extends CustomTemplateDataBuilder {
        public static final int $stable = 8;

        public UserTasteShortCutTemplateDataBuilder(@NotNull CoverView coverView0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
            q.g(coverView0, "targetView");
            super(coverView0, "TYPE_FORU_USER_TASTE");
            this.title(s, s1, s2);
            this.animationImgUrl(s4);
            this.shadowColor(s3);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/template/TemplateData$WelcomePickTemplateDataBuilder;", "Lcom/iloen/melon/utils/template/TemplateData$CustomTemplateDataBuilder;", "targetView", "Lcom/iloen/melon/custom/CoverView;", "mainTitle", "", "mainTitleLine1", "mainTitleLine2", "shadowColor", "animationImgUrl", "<init>", "(Lcom/iloen/melon/custom/CoverView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class WelcomePickTemplateDataBuilder extends CustomTemplateDataBuilder {
        public static final int $stable = 8;

        public WelcomePickTemplateDataBuilder(@NotNull CoverView coverView0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4) {
            q.g(coverView0, "targetView");
            super(coverView0, "TYPE_FORU_WELCOMEPICK");
            this.title(s, s1, s2);
            this.animationImgUrl(s4);
            this.shadowColor(s3);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int STANDARD_DP_SIZE_FORU_SMALL_COVER = 0x90;
    public final View a;
    public final TemplateCoverInfo b;
    public boolean c;
    public String d;
    public String e;
    public int standardSizeDp;

    static {
        TemplateData.Companion = new Companion(null);
        TemplateData.$stable = 8;
    }

    public TemplateData(@NotNull ImageView imageView0, @NotNull TemplateCoverInfo templateCoverInfo0, int v) {
        q.g(imageView0, "targetView");
        q.g(templateCoverInfo0, "templateCoverInfo");
        super();
        this.c = true;
        this.a = imageView0;
        this.b = templateCoverInfo0;
        this.standardSizeDp = v;
    }

    public TemplateData(@NotNull CoverView coverView0, @NotNull TemplateCoverInfo templateCoverInfo0) {
        q.g(coverView0, "targetView");
        q.g(templateCoverInfo0, "templateCoverInfo");
        super();
        this.standardSizeDp = -1;
        this.c = true;
        this.a = coverView0;
        this.b = templateCoverInfo0;
    }

    @Nullable
    public final String getAnimationImgUrl() {
        return this.d;
    }

    @Nullable
    public final String getShadowColor() {
        return this.e;
    }

    public final boolean getShowTitle() {
        return this.c;
    }

    @NotNull
    public final View getTargetView() {
        return this.a;
    }

    @NotNull
    public final TemplateCoverInfo getTemplateCoverInfo() {
        return this.b;
    }

    public final void setAnimationImgUrl(@Nullable String s) {
        this.d = s;
    }

    public final void setShadowColor(@Nullable String s) {
        this.e = s;
    }

    public final void setShowTitle(boolean z) {
        this.c = z;
    }
}

