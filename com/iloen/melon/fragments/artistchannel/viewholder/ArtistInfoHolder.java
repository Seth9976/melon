package com.iloen.melon.fragments.artistchannel.viewholder;

import Ad.s;
import De.I;
import J8.e;
import J8.f3;
import Tf.o;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.tablayout.TagLayout;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder;
import com.iloen.melon.fragments.main.common.MainTabTitleView.SimpleEventListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.CREDITINFO;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.DETAILINFO.AWARDLIST;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.DETAILINFO.DEBUTSONG;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE.DETAILINFO;
import com.iloen.melon.net.v6x.response.ArtistHomeContentsRes.RESPONSE;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e.k;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0017\u0018\u0000 \u001F2\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\u001FB\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0012\u001A\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001D\u0010\u0018\u001A\u00020\u000E2\f\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u000E2\u0006\u0010\u001A\u001A\u00020\nH\u0016¢\u0006\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistInfoHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE;", "LJ8/e;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/e;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "", "text", "", "hasLeftPoint", "Lie/H;", "addCreditTextView", "(Ljava/lang/String;Z)V", "Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$DETAILINFO;", "item", "getTypeText", "(Lcom/iloen/melon/net/v6x/response/ArtistHomeContentsRes$RESPONSE$DETAILINFO;)Ljava/lang/String;", "getTitleName", "()Ljava/lang/String;", "row", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "clickLog", "itemClickLog", "(Ljava/lang/String;)V", "holderBind", "LJ8/e;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class ArtistInfoHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistInfoHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/viewholder/ArtistInfoHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistInfoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0033, viewGroup0, false);  // layout:artist_detail_artistdetail
            int v = 0x7F0A00C2;  // id:artist_tv
            View view1 = I.C(view0, 0x7F0A00C2);  // id:artist_tv
            if(((MelonTextView)view1) != null) {
                v = 0x7F0A00CC;  // id:attached_music_layout
                View view2 = I.C(view0, 0x7F0A00CC);  // id:attached_music_layout
                if(((RelativeLayout)view2) != null && ((FrameLayout)I.C(view0, 0x7F0A00CD)) != null) {  // id:attached_thumb_container
                    v = 0x7F0A00E2;  // id:award_layout
                    View view3 = I.C(view0, 0x7F0A00E2);  // id:award_layout
                    if(((LinearLayout)view3) != null) {
                        v = 0x7F0A00E3;  // id:award_tv
                        View view4 = I.C(view0, 0x7F0A00E3);  // id:award_tv
                        if(((MelonTextView)view4) != null) {
                            v = 0x7F0A0300;  // id:company_tv
                            View view5 = I.C(view0, 0x7F0A0300);  // id:company_tv
                            if(((MelonTextView)view5) != null) {
                                v = 0x7F0A0364;  // id:credit_tag_layout
                                View view6 = I.C(view0, 0x7F0A0364);  // id:credit_tag_layout
                                if(((TagLayout)view6) != null) {
                                    v = 0x7F0A038F;  // id:debut_layout
                                    View view7 = I.C(view0, 0x7F0A038F);  // id:debut_layout
                                    if(((LinearLayout)view7) != null) {
                                        v = 0x7F0A0390;  // id:debut_song_layout
                                        View view8 = I.C(view0, 0x7F0A0390);  // id:debut_song_layout
                                        if(((LinearLayout)view8) != null) {
                                            v = 0x7F0A0391;  // id:debut_tv
                                            View view9 = I.C(view0, 0x7F0A0391);  // id:debut_tv
                                            if(((MelonTextView)view9) != null) {
                                                v = 0x7F0A058B;  // id:intro_layout
                                                View view10 = I.C(view0, 0x7F0A058B);  // id:intro_layout
                                                if(((LinearLayout)view10) != null) {
                                                    v = 0x7F0A058E;  // id:intro_tv
                                                    View view11 = I.C(view0, 0x7F0A058E);  // id:intro_tv
                                                    if(((MelonTextView)view11) != null) {
                                                        v = 0x7F0A07CA;  // id:main_contents_title
                                                        View view12 = I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                                                        if(((MainTabTitleView)view12) != null) {
                                                            v = 0x7F0A0B72;  // id:thumb_container
                                                            View view13 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
                                                            if(view13 != null) {
                                                                f3 f30 = f3.a(view13);
                                                                v = 0x7F0A0BAA;  // id:title_tv
                                                                View view14 = I.C(view0, 0x7F0A0BAA);  // id:title_tv
                                                                if(((MelonTextView)view14) != null) {
                                                                    v = 0x7F0A0D67;  // id:type_tv
                                                                    View view15 = I.C(view0, 0x7F0A0D67);  // id:type_tv
                                                                    if(((MelonTextView)view15) != null) {
                                                                        return new ArtistInfoHolder(new e(((LinearLayout)view0), ((MelonTextView)view1), ((RelativeLayout)view2), ((LinearLayout)view3), ((MelonTextView)view4), ((MelonTextView)view5), ((TagLayout)view6), ((LinearLayout)view7), ((LinearLayout)view8), ((MelonTextView)view9), ((LinearLayout)view10), ((MelonTextView)view11), ((MainTabTitleView)view12), f30, ((MelonTextView)view14), ((MelonTextView)view15)), onViewHolderActionBaseListener0);
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
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "ArtistInfoHolder";
    @NotNull
    private e holderBind;

    static {
        ArtistInfoHolder.Companion = new Companion(null);
        ArtistInfoHolder.$stable = 8;
    }

    public ArtistInfoHolder(@NotNull e e0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(e0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(e0, onViewHolderActionBaseListener0);
        this.holderBind = e0;
        this.setTitleView(e0.m);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void a(ArtistInfoHolder artistInfoHolder0, DEBUTSONG artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0, View view0) {
        ArtistInfoHolder.onBindView$lambda$4$lambda$3(artistInfoHolder0, artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0, view0);
    }

    private final void addCreditTextView(String s, boolean z) {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D004D, null, false);  // layout:artist_info_credit_item
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0365);  // id:credit_tv
        textView0.setText(s);
        if(z) {
            textView0.setCompoundDrawablesWithIntrinsicBounds(0x7F080850, 0, 0, 0);  // drawable:shape_circle_gray400s_dark_2dp
        }
        this.holderBind.g.addView(view0);
    }

    public static void addCreditTextView$default(ArtistInfoHolder artistInfoHolder0, String s, boolean z, int v, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addCreditTextView");
        }
        if((v & 2) != 0) {
            z = false;
        }
        artistInfoHolder0.addCreditTextView(s, z);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F1302FF);  // string:detail_info_button "상세정보"
    }

    private final String getTypeText(DETAILINFO artistHomeContentsRes$RESPONSE$DETAILINFO0) {
        StringBuilder stringBuilder0 = new StringBuilder();
        if(artistHomeContentsRes$RESPONSE$DETAILINFO0.nationality != null && !o.H0(artistHomeContentsRes$RESPONSE$DETAILINFO0.nationality)) {
            stringBuilder0.append(artistHomeContentsRes$RESPONSE$DETAILINFO0.nationality);
        }
        if(artistHomeContentsRes$RESPONSE$DETAILINFO0.gender != null && !o.H0(artistHomeContentsRes$RESPONSE$DETAILINFO0.gender)) {
            if(!TextUtils.isEmpty(stringBuilder0)) {
                stringBuilder0.append("/");
            }
            stringBuilder0.append(artistHomeContentsRes$RESPONSE$DETAILINFO0.gender);
        }
        if(artistHomeContentsRes$RESPONSE$DETAILINFO0.actType != null && !o.H0(artistHomeContentsRes$RESPONSE$DETAILINFO0.actType)) {
            if(!TextUtils.isEmpty(stringBuilder0)) {
                stringBuilder0.append("/");
            }
            stringBuilder0.append(artistHomeContentsRes$RESPONSE$DETAILINFO0.actType);
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    public void itemClickLog(@NotNull String s) {
        q.g(s, "clickLog");
    }

    @NotNull
    public static final ArtistInfoHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return ArtistInfoHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        boolean z2;
        boolean z1;
        boolean z;
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        CREDITINFO artistHomeContentsRes$RESPONSE$CREDITINFO0 = ((RESPONSE)adapterInViewHolder$Row0.getItem()).creditInfo;
        DETAILINFO artistHomeContentsRes$RESPONSE$DETAILINFO0 = ((RESPONSE)adapterInViewHolder$Row0.getItem()).detailinfo;
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(true);
        }
        MainTabTitleView mainTabTitleView2 = this.getTitleView();
        if(mainTabTitleView2 != null) {
            mainTabTitleView2.setOnEventListener(new SimpleEventListener() {
                @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$SimpleEventListener
                public void onViewAllButtonClick(View view0) {
                    q.g(view0, "view");
                    Navigator.open(ArtistDetailDetailInfoFragment.Companion.newInstance(this.artistid));
                    f f0 = ArtistInfoHolder.this.getOnViewHolderActionListener().onTiaraEventBuilder();
                    if(f0 != null) {
                        f0.a = ArtistInfoHolder.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                        f0.y = ArtistInfoHolder.this.getString(0x7F130DF0);  // string:tiara_common_layer1_detail_info "상세정보"
                        f0.F = ArtistInfoHolder.this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
                        f0.a().track();
                    }
                }
            });
        }
        TagLayout tagLayout0 = this.holderBind.g;
        tagLayout0.removeAllViews();
        tagLayout0.setHorizontalSpace(ScreenUtils.dipToPixel(tagLayout0.getContext(), 5.0f));
        tagLayout0.setVerticalSpace(ScreenUtils.dipToPixel(tagLayout0.getContext(), 3.0f));
        if(artistHomeContentsRes$RESPONSE$CREDITINFO0 == null) {
            z = false;
            z1 = false;
            z2 = false;
        }
        else {
            z = artistHomeContentsRes$RESPONSE$CREDITINFO0.releaseSongCount > 0;
            z1 = artistHomeContentsRes$RESPONSE$CREDITINFO0.featSongCount > 0;
            z2 = artistHomeContentsRes$RESPONSE$CREDITINFO0.lyricCompoSongCount > 0;
        }
        if(z || z1 || z2) {
            if(z) {
                ArtistInfoHolder.addCreditTextView$default(this, String.format(this.getString(0x7F130112), Arrays.copyOf(new Object[]{StringUtils.getFormattedStringNumber(artistHomeContentsRes$RESPONSE$CREDITINFO0.releaseSongCount)}, 1)), false, 2, null);  // string:artist_channel_release "발매곡 %1$s"
            }
            if(z1) {
                this.addCreditTextView(String.format(this.getString(0x7F130103), Arrays.copyOf(new Object[]{StringUtils.getFormattedStringNumber(artistHomeContentsRes$RESPONSE$CREDITINFO0.featSongCount)}, 1)), z);  // string:artist_channel_feat "참여 %1$s"
            }
            if(z2) {
                this.addCreditTextView(String.format(this.getString(0x7F13010C), Arrays.copyOf(new Object[]{StringUtils.getFormattedStringNumber(artistHomeContentsRes$RESPONSE$CREDITINFO0.lyricCompoSongCount)}, 1)), z || z1);  // string:artist_channel_lyric_compose "작사/작곡 %1$s"
            }
        }
        else {
            ArtistInfoHolder.addCreditTextView$default(this, this.getString(0x7F130A6A), false, 2, null);  // string:song_detail_extra_dash "-"
        }
        if(artistHomeContentsRes$RESPONSE$DETAILINFO0.debutDate != null && !o.H0(artistHomeContentsRes$RESPONSE$DETAILINFO0.debutDate)) {
            this.holderBind.h.setVisibility(0);
            this.holderBind.j.setText(artistHomeContentsRes$RESPONSE$DETAILINFO0.debutDate);
        }
        ViewUtils.setDefaultImage(this.holderBind.n.c, ScreenUtils.dipToPixel(this.getContext(), 48.0f));
        DEBUTSONG artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0 = artistHomeContentsRes$RESPONSE$DETAILINFO0.debutSong;
        if(artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0 != null) {
            this.holderBind.i.setVisibility(0);
            this.holderBind.o.setText(artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0.songName);
            this.holderBind.b.setText(ProtocolUtils.getArtistNames(artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0.artistList));
            Context context0 = this.getContext();
            if(context0 != null) {
                Glide.with(context0).load(artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0.albumImg).into(this.holderBind.n.b);
            }
            this.holderBind.c.setOnClickListener(new s(19, this, artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0));
            ViewUtils.setContentDescriptionWithButtonClassName(this.holderBind.c, String.format(this.getString(0x7F130B0A), Arrays.copyOf(new Object[]{this.holderBind.o.getText(), this.holderBind.b.getText()}, 2)));  // string:talkback_debut_song_play "데뷔곡, %1$s, 아티스트 : %2$s, 곡 재생하기"
        }
        String s = this.getTypeText(artistHomeContentsRes$RESPONSE$DETAILINFO0);
        MelonTextView melonTextView0 = this.holderBind.p;
        if(o.H0(s)) {
            s = this.getString(0x7F130A6A);  // string:song_detail_extra_dash "-"
        }
        melonTextView0.setText(s);
        this.holderBind.f.setText((artistHomeContentsRes$RESPONSE$DETAILINFO0.compName == null || o.H0(artistHomeContentsRes$RESPONSE$DETAILINFO0.compName) ? this.getString(0x7F130A6A) : artistHomeContentsRes$RESPONSE$DETAILINFO0.compName));  // string:song_detail_extra_dash "-"
        List list0 = artistHomeContentsRes$RESPONSE$DETAILINFO0.awardList;
        if(list0 != null) {
            this.holderBind.d.setVisibility(0);
            StringBuilder stringBuilder0 = new StringBuilder();
            int v = 0;
            for(Object object0: list0) {
                if(v >= 0) {
                    if(v > 0) {
                        stringBuilder0.append("\n");
                    }
                    stringBuilder0.append(String.format(this.getString(0x7F130116), Arrays.copyOf(new Object[]{((AWARDLIST)object0).name, ((AWARDLIST)object0).priot}, 2)));  // string:artist_channel_user_detail_award_history "%1$s %2$s"
                    if(v >= 1) {
                        break;
                    }
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
            if(list0.size() >= 3) {
                stringBuilder0.append("…");
            }
            this.holderBind.e.setText(stringBuilder0.toString());
        }
        String s1 = artistHomeContentsRes$RESPONSE$DETAILINFO0.intro;
        if(s1 != null && !o.H0(s1) == 1) {
            this.holderBind.k.setVisibility(0);
            this.holderBind.l.setText(s1);
            MelonTextView melonTextView1 = this.holderBind.l;
            if(s1.length() > 59) {
                String s2 = s1.substring(0, 59);
                q.f(s2, "substring(...)");
                s1 = s2 + "…";
            }
            melonTextView1.setContentDescription(s1);
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$4$lambda$3(ArtistInfoHolder artistInfoHolder0, DEBUTSONG artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0, View view0) {
        artistInfoHolder0.getOnViewHolderActionListener().onPlaySongListener(artistHomeContentsRes$RESPONSE$DETAILINFO$DEBUTSONG0.songId);
    }
}

