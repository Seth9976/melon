package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import Ad.s;
import De.I;
import J8.o0;
import J8.p0;
import U4.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.flexbox.FlexboxLayout;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.GenreInfoBase;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.ArtistInfo;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE.STYLELIST;
import com.iloen.melon.net.v6x.response.SongInfoRes.RESPONSE;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.net.res.common.SongInfoBase;
import e.k;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \'2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\'(B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ)\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001F\u0010\u0013\u001A\u00020\u00122\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J5\u0010\u001E\u001A\u00020\u001D2\u0006\u0010\u0019\u001A\u00020\u00182\b\u0010\u001A\u001A\u0004\u0018\u00010\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u00182\b\u0010\u001C\u001A\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001E\u0010\u001FJ\u001D\u0010!\u001A\u00020\u001D2\f\u0010 \u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b!\u0010\"J\u000F\u0010#\u001A\u00020\u0018H\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010%\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/SongInfoRes$RESPONSE;", "LJ8/o0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/o0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder$TagInfo;", "item", "", "isLastTagItem", "isLastContent", "LJ8/p0;", "bindTag", "(Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder$TagInfo;ZZ)LJ8/p0;", "", "getBottomMargin", "(ZZ)I", "hasBorder", "getSidePadding", "(Z)I", "", "clickCopy", "metaId", "metaType", "metaName", "Lie/H;", "itemClickLog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/o0;", "Companion", "TagInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CreditHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final CreditHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0228, viewGroup0, false);  // layout:detail_song_credit
            int v = 0x7F0A00AD;  // id:arranger_container
            View view1 = I.C(view0, 0x7F0A00AD);  // id:arranger_container
            if(((RelativeLayout)view1) != null) {
                v = 0x7F0A030F;  // id:composer_container
                View view2 = I.C(view0, 0x7F0A030F);  // id:composer_container
                if(((RelativeLayout)view2) != null) {
                    v = 0x7F0A04EB;  // id:genre_container
                    View view3 = I.C(view0, 0x7F0A04EB);  // id:genre_container
                    if(((RelativeLayout)view3) != null) {
                        v = 0x7F0A07C2;  // id:lyricist_container
                        View view4 = I.C(view0, 0x7F0A07C2);  // id:lyricist_container
                        if(((RelativeLayout)view4) != null) {
                            v = 0x7F0A07CA;  // id:main_contents_title
                            View view5 = I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                            if(((MainTabTitleView)view5) != null) {
                                v = 0x7F0A0AF7;  // id:style_container
                                View view6 = I.C(view0, 0x7F0A0AF7);  // id:style_container
                                if(((RelativeLayout)view6) != null) {
                                    v = 0x7F0A0B22;  // id:tag_arranger
                                    View view7 = I.C(view0, 0x7F0A0B22);  // id:tag_arranger
                                    if(((FlexboxLayout)view7) != null) {
                                        v = 0x7F0A0B24;  // id:tag_composer
                                        View view8 = I.C(view0, 0x7F0A0B24);  // id:tag_composer
                                        if(((FlexboxLayout)view8) != null) {
                                            v = 0x7F0A0B26;  // id:tag_genre
                                            View view9 = I.C(view0, 0x7F0A0B26);  // id:tag_genre
                                            if(((FlexboxLayout)view9) != null) {
                                                v = 0x7F0A0B28;  // id:tag_lyricist
                                                View view10 = I.C(view0, 0x7F0A0B28);  // id:tag_lyricist
                                                if(((FlexboxLayout)view10) != null) {
                                                    v = 0x7F0A0B30;  // id:tag_style
                                                    View view11 = I.C(view0, 0x7F0A0B30);  // id:tag_style
                                                    if(((FlexboxLayout)view11) != null) {
                                                        v = 0x7F0A0D14;  // id:tv_song
                                                        View view12 = I.C(view0, 0x7F0A0D14);  // id:tv_song
                                                        if(((MelonTextView)view12) != null && ((MelonTextView)I.C(view0, 0x7F0A0D37)) != null && (((MelonTextView)I.C(view0, 0x7F0A0D39)) != null && ((MelonTextView)I.C(view0, 0x7F0A0D3A)) != null) && (((MelonTextView)I.C(view0, 0x7F0A0D3D)) != null && ((MelonTextView)I.C(view0, 0x7F0A0D3F)) != null)) {  // id:tv_title_arranger
                                                            return new CreditHolder(new o0(((LinearLayout)view0), ((RelativeLayout)view1), ((RelativeLayout)view2), ((RelativeLayout)view3), ((RelativeLayout)view4), ((MainTabTitleView)view5), ((RelativeLayout)view6), ((FlexboxLayout)view7), ((FlexboxLayout)view8), ((FlexboxLayout)view9), ((FlexboxLayout)view10), ((FlexboxLayout)view11), ((MelonTextView)view12)), onViewHolderActionBaseListener0);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0006HÆ\u0003J1\u0010\u0019\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u001A\u001A\u00020\u00062\b\u0010\u001B\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001C\u001A\u00020\u001DHÖ\u0001J\t\u0010\u001E\u001A\u00020\u0003HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\rR\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000E\u0010\u000B\"\u0004\b\u000F\u0010\rR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0007\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/CreditHolder$TagInfo;", "", "tagName", "", "tagCode", "isGenre", "", "hasBorder", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "getTagCode", "setTagCode", "()Z", "setGenre", "(Z)V", "getHasBorder", "setHasBorder", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TagInfo {
        public static final int $stable = 8;
        private boolean hasBorder;
        private boolean isGenre;
        @NotNull
        private String tagCode;
        @NotNull
        private String tagName;

        public TagInfo() {
            this(null, null, false, false, 15, null);
        }

        public TagInfo(@NotNull String s, @NotNull String s1, boolean z, boolean z1) {
            q.g(s, "tagName");
            q.g(s1, "tagCode");
            super();
            this.tagName = s;
            this.tagCode = s1;
            this.isGenre = z;
            this.hasBorder = z1;
        }

        public TagInfo(String s, String s1, boolean z, boolean z1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                z = false;
            }
            if((v & 8) != 0) {
                z1 = true;
            }
            this(s, s1, z, z1);
        }

        @NotNull
        public final String component1() {
            return this.tagName;
        }

        @NotNull
        public final String component2() {
            return this.tagCode;
        }

        public final boolean component3() {
            return this.isGenre;
        }

        public final boolean component4() {
            return this.hasBorder;
        }

        @NotNull
        public final TagInfo copy(@NotNull String s, @NotNull String s1, boolean z, boolean z1) {
            q.g(s, "tagName");
            q.g(s1, "tagCode");
            return new TagInfo(s, s1, z, z1);
        }

        public static TagInfo copy$default(TagInfo creditHolder$TagInfo0, String s, String s1, boolean z, boolean z1, int v, Object object0) {
            if((v & 1) != 0) {
                s = creditHolder$TagInfo0.tagName;
            }
            if((v & 2) != 0) {
                s1 = creditHolder$TagInfo0.tagCode;
            }
            if((v & 4) != 0) {
                z = creditHolder$TagInfo0.isGenre;
            }
            if((v & 8) != 0) {
                z1 = creditHolder$TagInfo0.hasBorder;
            }
            return creditHolder$TagInfo0.copy(s, s1, z, z1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof TagInfo)) {
                return false;
            }
            if(!q.b(this.tagName, ((TagInfo)object0).tagName)) {
                return false;
            }
            if(!q.b(this.tagCode, ((TagInfo)object0).tagCode)) {
                return false;
            }
            return this.isGenre == ((TagInfo)object0).isGenre ? this.hasBorder == ((TagInfo)object0).hasBorder : false;
        }

        public final boolean getHasBorder() {
            return this.hasBorder;
        }

        @NotNull
        public final String getTagCode() [...] // 潜在的解密器

        @NotNull
        public final String getTagName() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.hasBorder) + d.e(x.b(this.tagName.hashCode() * 0x1F, 0x1F, this.tagCode), 0x1F, this.isGenre);
        }

        public final boolean isGenre() {
            return this.isGenre;
        }

        public final void setGenre(boolean z) {
            this.isGenre = z;
        }

        public final void setHasBorder(boolean z) {
            this.hasBorder = z;
        }

        public final void setTagCode(@NotNull String s) {
            q.g(s, "<set-?>");
            this.tagCode = s;
        }

        public final void setTagName(@NotNull String s) {
            q.g(s, "<set-?>");
            this.tagName = s;
        }

        @Override
        @NotNull
        public String toString() {
            boolean z = this.isGenre;
            boolean z1 = this.hasBorder;
            StringBuilder stringBuilder0 = d.o("TagInfo(tagName=", this.tagName, ", tagCode=", this.tagCode, ", isGenre=");
            stringBuilder0.append(z);
            stringBuilder0.append(", hasBorder=");
            stringBuilder0.append(z1);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "CreditHolder";
    @NotNull
    private o0 holderBind;

    static {
        CreditHolder.Companion = new Companion(null);
        CreditHolder.$stable = 8;
    }

    public CreditHolder(@NotNull o0 o00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(o00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(o00, onViewHolderActionBaseListener0);
        this.holderBind = o00;
        this.setTitleView(o00.f);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final p0 bindTag(TagInfo creditHolder$TagInfo0, boolean z, boolean z1) {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0229, null, false);  // layout:detail_song_credit_tag_item
        MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0D22);  // id:tv_tag
        if(melonTextView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0D22));  // id:tv_tag
        }
        p0 p00 = new p0(((FrameLayout)view0), melonTextView0);
        melonTextView0.setText("");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = melonTextView0.getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin = this.getBottomMargin(z, z1);
        melonTextView0.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
        int v = this.getSidePadding(creditHolder$TagInfo0.getHasBorder());
        melonTextView0.setPadding(v, 0, v, 0);
        if(!creditHolder$TagInfo0.getHasBorder()) {
            melonTextView0.setBackground(null);
        }
        melonTextView0.setOnClickListener(new s(22, creditHolder$TagInfo0, this));
        return p00;
    }

    public static p0 bindTag$default(CreditHolder creditHolder0, TagInfo creditHolder$TagInfo0, boolean z, boolean z1, int v, Object object0) {
        if((v & 4) != 0) {
            z1 = false;
        }
        return creditHolder0.bindTag(creditHolder$TagInfo0, z, z1);
    }

    private static final void bindTag$lambda$11$lambda$10(TagInfo creditHolder$TagInfo0, CreditHolder creditHolder0, View view0) {
        if(creditHolder$TagInfo0.isGenre()) {
            Navigator.openGenreDetail("");
            creditHolder0.itemClickLog(creditHolder0.getString(0x7F130D31), null, null, null);  // string:tiara_click_copy_genre "장르"
            return;
        }
        if(!creditHolder$TagInfo0.getHasBorder()) {
            return;
        }
        Navigator.openArtistInfo("");
        creditHolder0.itemClickLog(creditHolder0.getString(0x7F130CFD), "", creditHolder0.getString(0x7F130EF1), "");  // string:tiara_click_copy_artist "아티스트"
    }

    private final int getBottomMargin(boolean z, boolean z1) {
        if(z1) {
            return 0;
        }
        return z ? ScreenUtils.dipToPixel(this.getContext(), 12.0f) : ScreenUtils.dipToPixel(this.getContext(), 6.0f);
    }

    private final int getSidePadding(boolean z) {
        Context context0 = this.getContext();
        return z ? ScreenUtils.dipToPixel(context0, 11.0f) : ScreenUtils.dipToPixel(context0, 4.0f);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F130A72);  // string:song_detail_title_credit "크레딧"
    }

    private final void itemClickLog(String s, String s1, String s2, String s3) {
        f f0 = this.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = this.getString(0x7F130E10);  // string:tiara_common_layer1_song_credit "크레딧"
            f0.F = s;
            if(s1 != null) {
                f0.e = s1;
            }
            if(s2 != null) {
                f0.f = s2;
            }
            if(s3 != null) {
                f0.g = s3;
            }
            f0.a().track();
        }
    }

    @NotNull
    public static final CreditHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return CreditHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        RESPONSE songInfoRes$RESPONSE0 = (RESPONSE)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        SongInfoBase songInfoBase0 = songInfoRes$RESPONSE0.songInfo;
        if(songInfoBase0 != null) {
            this.holderBind.m.setText(songInfoBase0.songName);
        }
        ArrayList arrayList0 = songInfoRes$RESPONSE0.lystList;
        ArrayList arrayList1 = songInfoRes$RESPONSE0.cmpsrList;
        ArrayList arrayList2 = songInfoRes$RESPONSE0.arngrList;
        ArrayList arrayList3 = songInfoRes$RESPONSE0.genreList;
        ArrayList arrayList4 = songInfoRes$RESPONSE0.styleList;
        if(arrayList0 == null || arrayList0.isEmpty()) {
            this.holderBind.e.setVisibility(8);
        }
        else {
            this.holderBind.e.setVisibility(0);
            if(this.holderBind.k.getChildCount() <= 0) {
                int v = 0;
                for(Object object0: arrayList0) {
                    if(v >= 0) {
                        TagInfo creditHolder$TagInfo0 = new TagInfo(null, null, false, false, 15, null);
                        String s = ((ArtistInfo)object0).getArtistName();
                        if(s == null) {
                            s = "";
                        }
                        creditHolder$TagInfo0.setTagName(s);
                        String s1 = ((ArtistInfo)object0).getArtistId();
                        if(s1 == null) {
                            s1 = "";
                        }
                        creditHolder$TagInfo0.setTagCode(s1);
                        creditHolder$TagInfo0.setGenre(false);
                        String s2 = ((ArtistInfo)object0).getArtistId();
                        creditHolder$TagInfo0.setHasBorder(((boolean)((s2 == null || s2.length() == 0 ? 1 : 0) ^ 1)));
                        p0 p00 = CreditHolder.bindTag$default(this, creditHolder$TagInfo0, v == arrayList0.size() - 1, false, 4, null);
                        this.holderBind.k.addView(p00.a);
                        ++v;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
        }
        if(arrayList1 == null || arrayList1.isEmpty()) {
            this.holderBind.c.setVisibility(8);
        }
        else {
            this.holderBind.c.setVisibility(0);
            if(this.holderBind.i.getChildCount() <= 0) {
                int v1 = 0;
                for(Object object1: arrayList1) {
                    if(v1 >= 0) {
                        TagInfo creditHolder$TagInfo1 = new TagInfo(null, null, false, false, 15, null);
                        String s3 = ((ArtistInfo)object1).getArtistName();
                        if(s3 == null) {
                            s3 = "";
                        }
                        creditHolder$TagInfo1.setTagName(s3);
                        String s4 = ((ArtistInfo)object1).getArtistId();
                        if(s4 == null) {
                            s4 = "";
                        }
                        creditHolder$TagInfo1.setTagCode(s4);
                        creditHolder$TagInfo1.setGenre(false);
                        String s5 = ((ArtistInfo)object1).getArtistId();
                        creditHolder$TagInfo1.setHasBorder(((boolean)((s5 == null || s5.length() == 0 ? 1 : 0) ^ 1)));
                        p0 p01 = CreditHolder.bindTag$default(this, creditHolder$TagInfo1, v1 == arrayList1.size() - 1, false, 4, null);
                        this.holderBind.i.addView(p01.a);
                        ++v1;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
        }
        if(arrayList2 == null || arrayList2.isEmpty()) {
            this.holderBind.b.setVisibility(8);
        }
        else {
            this.holderBind.b.setVisibility(0);
            if(this.holderBind.h.getChildCount() <= 0) {
                int v2 = 0;
                for(Object object2: arrayList2) {
                    if(v2 >= 0) {
                        TagInfo creditHolder$TagInfo2 = new TagInfo(null, null, false, false, 15, null);
                        String s6 = ((ArtistInfo)object2).getArtistName();
                        if(s6 == null) {
                            s6 = "";
                        }
                        creditHolder$TagInfo2.setTagName(s6);
                        String s7 = ((ArtistInfo)object2).getArtistId();
                        if(s7 == null) {
                            s7 = "";
                        }
                        creditHolder$TagInfo2.setTagCode(s7);
                        creditHolder$TagInfo2.setGenre(false);
                        String s8 = ((ArtistInfo)object2).getArtistId();
                        creditHolder$TagInfo2.setHasBorder(((boolean)((s8 == null || s8.length() == 0 ? 1 : 0) ^ 1)));
                        p0 p02 = CreditHolder.bindTag$default(this, creditHolder$TagInfo2, v2 == arrayList2.size() - 1, false, 4, null);
                        this.holderBind.h.addView(p02.a);
                        ++v2;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
        }
        if(arrayList3 == null || arrayList3.isEmpty()) {
            this.holderBind.d.setVisibility(8);
        }
        else {
            this.holderBind.d.setVisibility(0);
            if(this.holderBind.j.getChildCount() <= 0) {
                int v3 = 0;
                for(Object object3: arrayList3) {
                    if(v3 >= 0) {
                        TagInfo creditHolder$TagInfo3 = new TagInfo(null, null, false, false, 15, null);
                        String s9 = ((GenreInfoBase)object3).genreName;
                        q.f(s9, "genreName");
                        creditHolder$TagInfo3.setTagName(s9);
                        String s10 = ((GenreInfoBase)object3).genreCode;
                        q.f(s10, "genreCode");
                        creditHolder$TagInfo3.setTagCode(s10);
                        creditHolder$TagInfo3.setGenre(true);
                        creditHolder$TagInfo3.setHasBorder(true);
                        p0 p03 = this.bindTag(creditHolder$TagInfo3, v3 == arrayList3.size() - 1, arrayList4 == null || arrayList4.isEmpty());
                        this.holderBind.j.addView(p03.a);
                        ++v3;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
        }
        if(arrayList4 != null && !arrayList4.isEmpty()) {
            this.holderBind.g.setVisibility(0);
            if(this.holderBind.l.getChildCount() <= 0) {
                int v4 = 0;
                for(Object object4: arrayList4) {
                    if(v4 >= 0) {
                        TagInfo creditHolder$TagInfo4 = new TagInfo(null, null, false, false, 15, null);
                        String s11 = ((STYLELIST)object4).styleName;
                        q.f(s11, "styleName");
                        creditHolder$TagInfo4.setTagName(s11);
                        String s12 = ((STYLELIST)object4).styleCode;
                        q.f(s12, "styleCode");
                        creditHolder$TagInfo4.setTagCode(s12);
                        creditHolder$TagInfo4.setHasBorder(false);
                        p0 p04 = this.bindTag(creditHolder$TagInfo4, v4 == arrayList4.size() - 1, true);
                        this.holderBind.l.addView(p04.a);
                        ++v4;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
            return;
        }
        this.holderBind.g.setVisibility(8);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

