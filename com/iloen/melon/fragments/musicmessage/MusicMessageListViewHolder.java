package com.iloen.melon.fragments.musicmessage;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.c;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.TargetMemberInfoBase;
import com.iloen.melon.net.v6x.response.MusicMessageListMusicMsgInboxRes.RESPONSE.INBOXLIST;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.Arrays;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\u0002H\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\t\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001A\u0004\u0018\u00010\u00038\u0006\u00A2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0006\u00A2\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u0019\u0010\u001E\u001A\u0004\u0018\u00010\u00198\u0006\u00A2\u0006\f\n\u0004\b\u001E\u0010\u001B\u001A\u0004\b\u001F\u0010\u001DR\u0019\u0010 \u001A\u0004\u0018\u00010\u00198\u0006\u00A2\u0006\f\n\u0004\b \u0010\u001B\u001A\u0004\b!\u0010\u001DR\u0019\u0010#\u001A\u0004\u0018\u00010\"8\u0006\u00A2\u0006\f\n\u0004\b#\u0010$\u001A\u0004\b%\u0010&R\u0019\u0010\'\u001A\u0004\u0018\u00010\"8\u0006\u00A2\u0006\f\n\u0004\b\'\u0010$\u001A\u0004\b(\u0010&R\u0019\u0010)\u001A\u0004\u0018\u00010\"8\u0006\u00A2\u0006\f\n\u0004\b)\u0010$\u001A\u0004\b*\u0010&R\u0019\u0010+\u001A\u0004\u0018\u00010\"8\u0006\u00A2\u0006\f\n\u0004\b+\u0010$\u001A\u0004\b,\u0010&R\u0019\u0010-\u001A\u0004\u0018\u00010\u00198\u0006\u00A2\u0006\f\n\u0004\b-\u0010\u001B\u001A\u0004\b.\u0010\u001DR\u0019\u0010/\u001A\u0004\u0018\u00010\"8\u0006\u00A2\u0006\f\n\u0004\b/\u0010$\u001A\u0004\b0\u0010&R\u0019\u00101\u001A\u0004\u0018\u00010\u00198\u0006\u00A2\u0006\f\n\u0004\b1\u0010\u001B\u001A\u0004\b2\u0010\u001DR\u0019\u00103\u001A\u0004\u0018\u00010\"8\u0006\u00A2\u0006\f\n\u0004\b3\u0010$\u001A\u0004\b4\u0010&\u00A8\u00066"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageListViewHolder;", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;", "Lcom/iloen/melon/net/v6x/response/MusicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST;", "Landroid/view/View;", "itemView", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageListFragment;", "fragment", "<init>", "(Landroid/view/View;Lcom/iloen/melon/fragments/musicmessage/MusicMessageListFragment;)V", "info", "", "isInboxListValid", "(Lcom/iloen/melon/net/v6x/response/MusicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST;)Z", "", "adapterposition", "dataposition", "Lie/H;", "bindView", "(Lcom/iloen/melon/net/v6x/response/MusicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST;II)V", "getFragment", "()Lcom/iloen/melon/fragments/musicmessage/MusicMessageListFragment;", "thumbCircleContainer", "Landroid/view/View;", "getThumbCircleContainer", "()Landroid/view/View;", "Landroid/widget/ImageView;", "ivThumbCircleDefault", "Landroid/widget/ImageView;", "getIvThumbCircleDefault", "()Landroid/widget/ImageView;", "ivThumbCircle", "getIvThumbCircle", "ivThumbCircleBadge", "getIvThumbCircleBadge", "Landroid/widget/TextView;", "tvNickname", "Landroid/widget/TextView;", "getTvNickname", "()Landroid/widget/TextView;", "tvDetail", "getTvDetail", "tvDate", "getTvDate", "tvCount", "getTvCount", "ivBlock", "getIvBlock", "djBadge", "getDjBadge", "djOfficial", "getDjOfficial", "otherCreatorCountText", "getOtherCreatorCountText", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicMessageListViewHolder extends MusicMessageBaseViewHolder {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageListViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "thumbCircleDiameter", "", "getThumbCircleDiameter", "()I", "getLayoutRsId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final int getLayoutRsId() [...] // Inlined contents

        public final int getThumbCircleDiameter() {
            return MusicMessageListViewHolder.thumbCircleDiameter;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "MusicMessageListViewHolder";
    @Nullable
    private final TextView djBadge;
    @Nullable
    private final ImageView djOfficial;
    @Nullable
    private final ImageView ivBlock;
    @Nullable
    private final ImageView ivThumbCircle;
    @Nullable
    private final ImageView ivThumbCircleBadge;
    @Nullable
    private final ImageView ivThumbCircleDefault;
    @Nullable
    private final TextView otherCreatorCountText;
    @Nullable
    private final View thumbCircleContainer;
    private static final int thumbCircleDiameter;
    @Nullable
    private final TextView tvCount;
    @Nullable
    private final TextView tvDate;
    @Nullable
    private final TextView tvDetail;
    @Nullable
    private final TextView tvNickname;

    static {
        MusicMessageListViewHolder.Companion = new Companion(null);
        MusicMessageListViewHolder.$stable = 8;
        MelonAppBase.Companion.getClass();
        MusicMessageListViewHolder.thumbCircleDiameter = ScreenUtils.dipToPixel(t.a().getContext(), 65.0f);
    }

    public MusicMessageListViewHolder(@NotNull View view0, @NotNull MusicMessageListFragment musicMessageListFragment0) {
        q.g(view0, "itemView");
        q.g(musicMessageListFragment0, "fragment");
        super(view0, musicMessageListFragment0);
        this.thumbCircleContainer = view0.findViewById(0x7F0A0B71);  // id:thumb_circle_container
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        this.ivThumbCircleDefault = imageView0;
        this.ivThumbCircle = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        this.ivThumbCircleBadge = (ImageView)view0.findViewById(0x7F0A06A7);  // id:iv_thumbnail_circle_badge
        this.tvNickname = (TextView)view0.findViewById(0x7F0A0CCD);  // id:tv_nickname
        this.tvDetail = (TextView)view0.findViewById(0x7F0A0C62);  // id:tv_detail
        this.tvDate = (TextView)view0.findViewById(0x7F0A0C59);  // id:tv_date
        this.tvCount = (TextView)view0.findViewById(0x7F0A0C50);  // id:tv_count
        this.ivBlock = (ImageView)view0.findViewById(0x7F0A0605);  // id:iv_block
        this.djBadge = (TextView)view0.findViewById(0x7F0A03DA);  // id:dj_badge
        this.djOfficial = (ImageView)view0.findViewById(0x7F0A03DC);  // id:dj_official
        this.otherCreatorCountText = (TextView)view0.findViewById(0x7F0A08ED);  // id:other_user_title_tv
        ViewUtils.setDefaultImage(imageView0, MusicMessageListViewHolder.thumbCircleDiameter, true);
    }

    public void bindView(@NotNull INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, int v, int v1) {
        q.g(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, "info");
        if(this.isInboxListValid(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0) && this.isFragmentValid(this.getFragment())) {
            String s = null;
            String s1 = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist == null || musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.size() <= 0 ? null : ((TargetMemberInfoBase)musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.get(0)).targetmemberkey;
            boolean z = Receiver.d(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist);
            boolean z1 = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist == null || musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.size() <= 0 ? false : ProtocolUtils.parseBoolean(((TargetMemberInfoBase)musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.get(0)).targetbanyn);
            String s2 = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist == null || musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.size() <= 0 ? null : ((TargetMemberInfoBase)musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.get(0)).targetpageimg;
            String s3 = Receiver.c(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist);
            TargetMemberInfoBase targetMemberInfoBase0 = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist == null || musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.size() <= 0 ? null : ((TargetMemberInfoBase)musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.get(0));
            int v2 = ResourceUtils.getDjIconColorId(targetMemberInfoBase0.memberDjIconType);
            if(v2 > -1) {
                TextView textView0 = this.djBadge;
                if(textView0 != null) {
                    textView0.setVisibility(0);
                }
                TextView textView1 = this.djBadge;
                if(textView1 != null) {
                    textView1.setTextColor(ColorUtils.getColor(this.getMContext(), v2));
                }
            }
            else {
                TextView textView2 = this.djBadge;
                if(textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            ViewUtils.showWhen(this.djOfficial, targetMemberInfoBase0.isOfficial);
            if(this.thumbCircleContainer != null) {
                ImageView imageView0 = this.ivThumbCircle;
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(s2).apply(RequestOptions.circleCropTransform()).into(this.ivThumbCircle);
                }
                MelonAppBase.Companion.getClass();
                q.f("%s 회원 이미지", "getString(...)");
                String s4 = String.format("%s 회원 이미지", Arrays.copyOf(new Object[]{s3}, 1));
                if(!TextUtils.isEmpty(s4)) {
                    ImageView imageView1 = this.ivThumbCircle;
                    if(imageView1 != null) {
                        imageView1.setContentDescription(s4);
                    }
                }
                g g0 = new g(s1, z, 1);
                ViewUtils.setOnClickListener(this.thumbCircleContainer, g0);
            }
            if(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist == null || musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.size() <= 1 || !targetMemberInfoBase0.isOfficial) {
                TextView textView5 = this.tvNickname;
                if(textView5 != null) {
                    textView5.setText(s3);
                }
                ViewUtils.hideWhen(this.otherCreatorCountText, true);
            }
            else {
                TextView textView3 = this.tvNickname;
                if(textView3 != null) {
                    textView3.setText(targetMemberInfoBase0.targetnickname);
                }
                String s5 = this.getMContext() == null ? null : "외";
                int v3 = musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist.size();
                if(this.getMContext() != null) {
                    s = "명";
                }
                TextView textView4 = this.otherCreatorCountText;
                if(textView4 != null) {
                    textView4.setText(s5 + " " + (v3 - 1) + s);
                }
                ViewUtils.showWhen(this.otherCreatorCountText, true);
            }
            ViewUtils.showWhen(this.ivBlock, z1);
            TextView textView6 = this.tvDate;
            if(textView6 != null) {
                textView6.setText(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.updatedate);
            }
            TextView textView7 = this.tvDetail;
            if(textView7 != null) {
                textView7.setText(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.summary);
            }
            if(this.tvCount != null) {
                if(ProtocolUtils.parseInt(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.msgenoconfmcnt, 0) > 0) {
                    String s6 = StringUtils.getCountString(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.msgenoconfmcnt, 99);
                    this.tvCount.setText(s6);
                    ViewUtils.showWhen(this.tvCount, true);
                }
                else {
                    ViewUtils.showWhen(this.tvCount, false);
                }
            }
            ViewUtils.setOnClickListener(this.getMainContainer(), new c(this, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, v, v1, 4));
            ViewUtils.setOnLongClickListener(this.getMainContainer(), new l(this, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, v, v1));
            ViewUtils.showWhen(this.getMainContainer(), true);
        }
    }

    @Override  // com.iloen.melon.fragments.musicmessage.MusicMessageBaseViewHolder
    public void bindView(Object object0, int v, int v1) {
        this.bindView(((INBOXLIST)object0), v, v1);
    }

    private static final void bindView$lambda$1(String s, boolean z, View view0) {
        Navigator.openUserMain(s, z);
    }

    private static final void bindView$lambda$2(MusicMessageListViewHolder musicMessageListViewHolder0, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, int v, int v1, View view0) {
        if(musicMessageListViewHolder0.isInboxListValid(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0) && musicMessageListViewHolder0.isFragmentValid(musicMessageListViewHolder0.getFragment())) {
            musicMessageListViewHolder0.getFragment().openEditor(v, v1, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0);
        }
    }

    private static final boolean bindView$lambda$3(MusicMessageListViewHolder musicMessageListViewHolder0, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, int v, int v1, View view0) {
        if(musicMessageListViewHolder0.isInboxListValid(musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0) && musicMessageListViewHolder0.isFragmentValid(musicMessageListViewHolder0.getFragment())) {
            musicMessageListViewHolder0.getFragment().openContextListPopup(v, v1, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0);
        }
        return true;
    }

    public static void c(MusicMessageListViewHolder musicMessageListViewHolder0, INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, int v, int v1, View view0) {
        MusicMessageListViewHolder.bindView$lambda$2(musicMessageListViewHolder0, musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0, v, v1, view0);
    }

    @Nullable
    public final TextView getDjBadge() {
        return this.djBadge;
    }

    @Nullable
    public final ImageView getDjOfficial() {
        return this.djOfficial;
    }

    @Override  // com.iloen.melon.fragments.musicmessage.MusicMessageBaseViewHolder
    public MetaContentBaseFragment getFragment() {
        return this.getFragment();
    }

    @NotNull
    public MusicMessageListFragment getFragment() {
        MetaContentBaseFragment metaContentBaseFragment0 = super.getFragment();
        q.e(metaContentBaseFragment0, "null cannot be cast to non-null type com.iloen.melon.fragments.musicmessage.MusicMessageListFragment");
        return (MusicMessageListFragment)metaContentBaseFragment0;
    }

    @Nullable
    public final ImageView getIvBlock() {
        return this.ivBlock;
    }

    @Nullable
    public final ImageView getIvThumbCircle() {
        return this.ivThumbCircle;
    }

    @Nullable
    public final ImageView getIvThumbCircleBadge() {
        return this.ivThumbCircleBadge;
    }

    @Nullable
    public final ImageView getIvThumbCircleDefault() {
        return this.ivThumbCircleDefault;
    }

    @Nullable
    public final TextView getOtherCreatorCountText() {
        return this.otherCreatorCountText;
    }

    @Nullable
    public final View getThumbCircleContainer() {
        return this.thumbCircleContainer;
    }

    @Nullable
    public final TextView getTvCount() {
        return this.tvCount;
    }

    @Nullable
    public final TextView getTvDate() {
        return this.tvDate;
    }

    @Nullable
    public final TextView getTvDetail() {
        return this.tvDetail;
    }

    @Nullable
    public final TextView getTvNickname() {
        return this.tvNickname;
    }

    private final boolean isInboxListValid(INBOXLIST musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0) {
        if((musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0 == null ? null : musicMessageListMusicMsgInboxRes$RESPONSE$INBOXLIST0.targetmemberinfolist) == null) {
            LogU.Companion.w("MusicMessageListViewHolder", "Invalid InboxList dataset!");
            return false;
        }
        return true;
    }
}

