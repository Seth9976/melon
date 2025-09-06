package com.iloen.melon.fragments.musicmessage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.custom.c;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.viewholder.p;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MusicMessageListBanUserRes.RESPONSE.USERLIST;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\'\u0010\u000E\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001A\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001A\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001A\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001A\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u0019\u001A\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\u0016\u0010\u001B\u001A\u0004\u0018\u00010\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u0004\u0018\u00010\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001CR\u0016\u0010\u001E\u001A\u0004\u0018\u00010\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001E\u0010\u001CR\u0016\u0010\u001F\u001A\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001F\u0010\u0013R\u0016\u0010 \u001A\u0004\u0018\u00010\u001A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001CR\u0016\u0010!\u001A\u0004\u0018\u00010\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0016R\u001C\u0010$\u001A\n #*\u0004\u0018\u00010\"0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006\'"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListViewHolder;", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;", "Lcom/iloen/melon/net/v4x/response/MusicMessageListBanUserRes$RESPONSE$USERLIST;", "Landroid/view/View;", "itemView", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListFragment;", "fragment", "<init>", "(Landroid/view/View;Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListFragment;)V", "info", "", "adapterposition", "dataposition", "Lie/H;", "bindView", "(Lcom/iloen/melon/net/v4x/response/MusicMessageListBanUserRes$RESPONSE$USERLIST;II)V", "getFragment", "()Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListFragment;", "thumbCircleContainer", "Landroid/view/View;", "Landroid/widget/ImageView;", "ivThumbCircleDefault", "Landroid/widget/ImageView;", "ivThumbCircle", "ivThumbCircleBadge", "ivNew", "Landroid/widget/TextView;", "tvNickname", "Landroid/widget/TextView;", "tvDate", "btnCancelBlock", "extraContainer", "djBadge", "djOfficial", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicMessageBlockListViewHolder extends MusicMessageBaseViewHolder {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageBlockListViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "getLayoutRsId", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final int getLayoutRsId() [...] // Inlined contents
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "MusicMessageBlockListViewHolder";
    @Nullable
    private final TextView btnCancelBlock;
    private final Context context;
    @Nullable
    private final TextView djBadge;
    @Nullable
    private final ImageView djOfficial;
    @Nullable
    private final View extraContainer;
    @Nullable
    private final ImageView ivNew;
    @Nullable
    private final ImageView ivThumbCircle;
    @Nullable
    private final ImageView ivThumbCircleBadge;
    @Nullable
    private final ImageView ivThumbCircleDefault;
    @Nullable
    private final View thumbCircleContainer;
    @Nullable
    private final TextView tvDate;
    @Nullable
    private final TextView tvNickname;

    static {
        MusicMessageBlockListViewHolder.Companion = new Companion(null);
        MusicMessageBlockListViewHolder.$stable = 8;
    }

    public MusicMessageBlockListViewHolder(@NotNull View view0, @NotNull MusicMessageBlockListFragment musicMessageBlockListFragment0) {
        q.g(view0, "itemView");
        q.g(musicMessageBlockListFragment0, "fragment");
        super(view0, musicMessageBlockListFragment0);
        this.thumbCircleContainer = view0.findViewById(0x7F0A00BF);  // id:artist_thumb_layout
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        this.ivThumbCircleDefault = imageView0;
        this.ivThumbCircle = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        this.ivThumbCircleBadge = (ImageView)view0.findViewById(0x7F0A06A7);  // id:iv_thumbnail_circle_badge
        this.ivNew = (ImageView)view0.findViewById(0x7F0A0653);  // id:iv_new
        this.tvNickname = (TextView)view0.findViewById(0x7F0A0D4D);  // id:tv_user_nickname
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0C59);  // id:tv_date
        this.tvDate = textView0;
        TextView textView1 = (TextView)view0.findViewById(0x7F0A0145);  // id:btn_block_cancel
        this.btnCancelBlock = textView1;
        this.extraContainer = view0.findViewById(0x7F0A0483);  // id:extra_container
        this.djBadge = (TextView)view0.findViewById(0x7F0A03DA);  // id:dj_badge
        this.djOfficial = (ImageView)view0.findViewById(0x7F0A03DC);  // id:dj_official
        Context context0 = view0.getContext();
        this.context = context0;
        ViewUtils.setDefaultImage(imageView0, ScreenUtils.dipToPixel(context0, 65.0f), true);
        ViewUtils.showWhen(textView0, true);
        ViewUtils.showWhen(textView1, true);
    }

    public static void a(USERLIST musicMessageListBanUserRes$RESPONSE$USERLIST0, View view0) {
        MusicMessageBlockListViewHolder.bindView$lambda$0(musicMessageListBanUserRes$RESPONSE$USERLIST0, view0);
    }

    public static void b(MusicMessageBlockListViewHolder musicMessageBlockListViewHolder0, USERLIST musicMessageListBanUserRes$RESPONSE$USERLIST0, int v, int v1, View view0) {
        MusicMessageBlockListViewHolder.bindView$lambda$5$lambda$4(musicMessageBlockListViewHolder0, musicMessageListBanUserRes$RESPONSE$USERLIST0, v, v1, view0);
    }

    public void bindView(@NotNull USERLIST musicMessageListBanUserRes$RESPONSE$USERLIST0, int v, int v1) {
        q.g(musicMessageListBanUserRes$RESPONSE$USERLIST0, "info");
        String s = musicMessageListBanUserRes$RESPONSE$USERLIST0.membernickname == null || musicMessageListBanUserRes$RESPONSE$USERLIST0.membernickname.length() <= 0 ? "닉네임 없음" : musicMessageListBanUserRes$RESPONSE$USERLIST0.membernickname;
        if(this.isContentListValid(musicMessageListBanUserRes$RESPONSE$USERLIST0) && this.isFragmentValid(this.getFragment())) {
            if(this.thumbCircleContainer != null) {
                ImageView imageView0 = this.ivThumbCircle;
                if(imageView0 != null) {
                    Glide.with(imageView0.getContext()).load(musicMessageListBanUserRes$RESPONSE$USERLIST0.mypageimg).apply(RequestOptions.circleCropTransform()).into(this.ivThumbCircle);
                    q.f("%s 회원 이미지", "getString(...)");
                    String s1 = String.format("%s 회원 이미지", Arrays.copyOf(new Object[]{s}, 1));
                    if(!TextUtils.isEmpty(s1)) {
                        this.ivThumbCircle.setContentDescription(s1);
                    }
                    p p0 = new p(musicMessageListBanUserRes$RESPONSE$USERLIST0, 4);
                    ViewUtils.setOnClickListener(this.thumbCircleContainer, p0);
                }
            }
            int v2 = ResourceUtils.getDjIconColorId(musicMessageListBanUserRes$RESPONSE$USERLIST0.memberDjIconType);
            boolean z = false;
            if(v2 > -1) {
                TextView textView0 = this.djBadge;
                if(textView0 != null) {
                    textView0.setVisibility(0);
                }
                TextView textView1 = this.djBadge;
                if(textView1 != null) {
                    textView1.setTextColor(ColorUtils.getColor(this.context, v2));
                }
            }
            else {
                TextView textView2 = this.djBadge;
                if(textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            ViewUtils.showWhen(this.djOfficial, musicMessageListBanUserRes$RESPONSE$USERLIST0.isOfficial);
            TextView textView3 = this.tvNickname;
            if(textView3 != null) {
                textView3.setText(s);
            }
            TextView textView4 = this.tvDate;
            if(textView4 != null) {
                textView4.setText(musicMessageListBanUserRes$RESPONSE$USERLIST0.updtdate2);
            }
            TextView textView5 = this.tvDate;
            if(musicMessageListBanUserRes$RESPONSE$USERLIST0.updtdate2 == null || musicMessageListBanUserRes$RESPONSE$USERLIST0.updtdate2.length() == 0) {
                z = true;
            }
            ViewUtils.hideWhen(textView5, z);
            c c0 = new c(this, musicMessageListBanUserRes$RESPONSE$USERLIST0, v, v1, 1);
            ViewUtils.setOnClickListener(this.btnCancelBlock, c0);
            ViewUtils.showWhen(this.getMainContainer(), true);
        }
    }

    @Override  // com.iloen.melon.fragments.musicmessage.MusicMessageBaseViewHolder
    public void bindView(Object object0, int v, int v1) {
        this.bindView(((USERLIST)object0), v, v1);
    }

    private static final void bindView$lambda$0(USERLIST musicMessageListBanUserRes$RESPONSE$USERLIST0, View view0) {
        Navigator.openUserMain(musicMessageListBanUserRes$RESPONSE$USERLIST0.mypageimg, ProtocolUtils.parseBoolean(musicMessageListBanUserRes$RESPONSE$USERLIST0.memberstatus));
    }

    private static final void bindView$lambda$5$lambda$4(MusicMessageBlockListViewHolder musicMessageBlockListViewHolder0, USERLIST musicMessageListBanUserRes$RESPONSE$USERLIST0, int v, int v1, View view0) {
        if(musicMessageBlockListViewHolder0.isContentListValid(musicMessageListBanUserRes$RESPONSE$USERLIST0) && musicMessageBlockListViewHolder0.isFragmentValid(musicMessageBlockListViewHolder0.getFragment())) {
            musicMessageBlockListViewHolder0.getFragment().unblockUser(v, v1, musicMessageListBanUserRes$RESPONSE$USERLIST0);
        }
    }

    @Override  // com.iloen.melon.fragments.musicmessage.MusicMessageBaseViewHolder
    public MetaContentBaseFragment getFragment() {
        return this.getFragment();
    }

    @NotNull
    public MusicMessageBlockListFragment getFragment() {
        MetaContentBaseFragment metaContentBaseFragment0 = super.getFragment();
        q.e(metaContentBaseFragment0, "null cannot be cast to non-null type com.iloen.melon.fragments.musicmessage.MusicMessageBlockListFragment");
        return (MusicMessageBlockListFragment)metaContentBaseFragment0;
    }

    public static final int getLayoutRsId() {
        return 0x7F0D04B9;  // layout:listitem_user
    }
}

