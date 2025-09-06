package com.iloen.melon.fragments.musicmessage;

import Ad.s;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import he.e;
import java.util.Arrays;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000E\b\'\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\\B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0005H\u0014\u00A2\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001A\u00060\u000BR\u00020\u0005\u00A2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0002H\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH\u0004\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020\u0014H\u0004\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020\u0014H\u0004\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u00162\u0006\u0010\u0015\u001A\u00020\u0014H\u0004\u00A2\u0006\u0004\b\u001A\u0010\u0018J!\u0010\u001D\u001A\u00020\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u000E\u001A\u00020\u0002H\u0004\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010 \u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b \u0010!J\'\u0010#\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u00022\u0006\u0010\"\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b#\u0010$J\'\u0010%\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u00022\u0006\u0010\"\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b%\u0010$J\'\u0010&\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u00022\u0006\u0010\"\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b&\u0010$J\u001F\u0010\'\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b\'\u0010!J\u001F\u0010(\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b(\u0010!J\'\u0010)\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001F\u001A\u00020\u00022\u0006\u0010\"\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b)\u0010$J\'\u0010-\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*H\u0002\u00A2\u0006\u0004\b-\u0010.J\u001F\u00101\u001A\u00020\u00162\u0006\u00100\u001A\u00020/2\u0006\u0010\u001F\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b1\u00102J\u001F\u00103\u001A\u00020\u00162\u0006\u00100\u001A\u00020/2\u0006\u0010\u001F\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b3\u00102R\u0019\u00104\u001A\u0004\u0018\u00010\u00038\u0006\u00A2\u0006\f\n\u0004\b4\u00105\u001A\u0004\b6\u00107R\u0019\u00109\u001A\u0004\u0018\u0001088\u0006\u00A2\u0006\f\n\u0004\b9\u0010:\u001A\u0004\b;\u0010<R\u0019\u0010=\u001A\u0004\u0018\u00010\u00038\u0006\u00A2\u0006\f\n\u0004\b=\u00105\u001A\u0004\b>\u00107R\u0019\u0010?\u001A\u0004\u0018\u00010\u00038\u0006\u00A2\u0006\f\n\u0004\b?\u00105\u001A\u0004\b@\u00107R\u0019\u0010A\u001A\u0004\u0018\u00010\u00038\u0006\u00A2\u0006\f\n\u0004\bA\u00105\u001A\u0004\bB\u00107R\u0019\u0010C\u001A\u0004\u0018\u00010\u001B8\u0006\u00A2\u0006\f\n\u0004\bC\u0010D\u001A\u0004\bE\u0010FR\u0019\u0010G\u001A\u0004\u0018\u00010\u00038\u0006\u00A2\u0006\f\n\u0004\bG\u00105\u001A\u0004\bH\u00107R\u0019\u0010I\u001A\u0004\u0018\u00010/8\u0006\u00A2\u0006\f\n\u0004\bI\u0010J\u001A\u0004\bK\u0010LR\u0019\u0010M\u001A\u0004\u0018\u00010/8\u0006\u00A2\u0006\f\n\u0004\bM\u0010J\u001A\u0004\bN\u0010LR\u0019\u0010P\u001A\u0004\u0018\u00010O8\u0006\u00A2\u0006\f\n\u0004\bP\u0010Q\u001A\u0004\bR\u0010SR\u0019\u0010T\u001A\u0004\u0018\u00010/8\u0006\u00A2\u0006\f\n\u0004\bT\u0010J\u001A\u0004\bU\u0010LR\u0019\u0010V\u001A\u0004\u0018\u0001088\u0006\u00A2\u0006\f\n\u0004\bV\u0010:\u001A\u0004\bW\u0010<R\u0019\u0010X\u001A\u0004\u0018\u0001088\u0006\u00A2\u0006\f\n\u0004\bX\u0010:\u001A\u0004\bY\u0010<R\u0019\u0010Z\u001A\u0004\u0018\u0001088\u0006\u00A2\u0006\f\n\u0004\bZ\u0010:\u001A\u0004\b[\u0010<\u00A8\u0006]"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorBaseViewHolder;", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageBaseViewHolder;", "Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;", "Landroid/view/View;", "itemView", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;", "fragment", "<init>", "(Landroid/view/View;Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;)V", "getFragment", "()Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$MusicMessageEditorAdapter;", "getAdapter", "()Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment$MusicMessageEditorAdapter;", "info", "", "isContentListValid", "(Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;)Z", "hideMe", "()Z", "", "visibility", "Lie/H;", "setPersonInfoVisibility", "(I)V", "setPersonSeperatorVisibility", "setLastSeperatorVisibility", "Landroid/view/ViewGroup;", "rootView", "addContentsView", "(Landroid/view/ViewGroup;Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;)V", "item", "setContentsTextView", "(Landroid/view/ViewGroup;Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;)Landroid/view/View;", "isService", "setContentsSongView", "(Landroid/view/ViewGroup;Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;Z)Landroid/view/View;", "setContentsVideoView", "setContentsAlbumView", "setContentsArtistView", "setContentsPhotoView", "setContentsPlaylistView", "", "contsTypeCode", "trnsmtye", "setBackgroundBalloon", "(Landroid/view/ViewGroup;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/widget/ImageView;", "iv", "setSongIcon", "(Landroid/widget/ImageView;Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;)V", "setMvIcon", "itemDateSeperatorContainer", "Landroid/view/View;", "getItemDateSeperatorContainer", "()Landroid/view/View;", "Landroid/widget/TextView;", "tvSeperateDay", "Landroid/widget/TextView;", "getTvSeperateDay", "()Landroid/widget/TextView;", "itemPersonSeperator", "getItemPersonSeperator", "itemLastSeperator", "getItemLastSeperator", "itemContainer", "getItemContainer", "messageContainer", "Landroid/view/ViewGroup;", "getMessageContainer", "()Landroid/view/ViewGroup;", "thumbCircleContainer", "getThumbCircleContainer", "ivThumbCircleDefaultBg", "Landroid/widget/ImageView;", "getIvThumbCircleDefaultBg", "()Landroid/widget/ImageView;", "ivThumbCircleDefault", "getIvThumbCircleDefault", "Lcom/iloen/melon/custom/BorderImageView;", "ivThumbCircle", "Lcom/iloen/melon/custom/BorderImageView;", "getIvThumbCircle", "()Lcom/iloen/melon/custom/BorderImageView;", "ivThumbCircleBadge", "getIvThumbCircleBadge", "tvNickname", "getTvNickname", "tvDate", "getTvDate", "btnDelete", "getBtnDelete", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MusicMessageEditorBaseViewHolder extends MusicMessageBaseViewHolder {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorBaseViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "thumbCircleDiameter", "", "getThumbCircleDiameter", "()I", "getLayoutRsId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final int getLayoutRsId() {
            return 0x7F0D0560;  // layout:musicmessage_list_item
        }

        public final int getThumbCircleDiameter() {
            return MusicMessageEditorBaseViewHolder.thumbCircleDiameter;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "MusicMessageEditorViewHolder";
    @Nullable
    private final TextView btnDelete;
    @Nullable
    private final View itemContainer;
    @Nullable
    private final View itemDateSeperatorContainer;
    @Nullable
    private final View itemLastSeperator;
    @Nullable
    private final View itemPersonSeperator;
    @Nullable
    private final BorderImageView ivThumbCircle;
    @Nullable
    private final ImageView ivThumbCircleBadge;
    @Nullable
    private final ImageView ivThumbCircleDefault;
    @Nullable
    private final ImageView ivThumbCircleDefaultBg;
    @Nullable
    private final ViewGroup messageContainer;
    @Nullable
    private final View thumbCircleContainer;
    private static final int thumbCircleDiameter;
    @Nullable
    private final TextView tvDate;
    @Nullable
    private final TextView tvNickname;
    @Nullable
    private final TextView tvSeperateDay;

    static {
        MusicMessageEditorBaseViewHolder.Companion = new Companion(null);
        MusicMessageEditorBaseViewHolder.$stable = 8;
        MelonAppBase.Companion.getClass();
        MusicMessageEditorBaseViewHolder.thumbCircleDiameter = ScreenUtils.dipToPixel(t.a().getContext(), 40.0f);
    }

    public MusicMessageEditorBaseViewHolder(@NotNull View view0, @NotNull MusicMessageEditorFragment musicMessageEditorFragment0) {
        q.g(view0, "itemView");
        q.g(musicMessageEditorFragment0, "fragment");
        super(view0, musicMessageEditorFragment0);
        this.itemDateSeperatorContainer = view0.findViewById(0x7F0A05A9);  // id:item_date_seperator_container
        this.tvSeperateDay = (TextView)view0.findViewById(0x7F0A0D0B);  // id:tv_seperate_day
        this.itemPersonSeperator = view0.findViewById(0x7F0A05C3);  // id:item_person_seperator
        this.itemLastSeperator = view0.findViewById(0x7F0A05B6);  // id:item_last_seperator
        this.itemContainer = view0.findViewById(0x7F0A05A7);  // id:item_container
        this.messageContainer = (ViewGroup)view0.findViewById(0x7F0A07FC);  // id:message_container
        this.thumbCircleContainer = view0.findViewById(0x7F0A0B71);  // id:thumb_circle_container
        this.ivThumbCircleDefaultBg = (ImageView)view0.findViewById(0x7F0A069D);  // id:iv_thumb_circle_default_bg
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        this.ivThumbCircleDefault = imageView0;
        this.ivThumbCircle = (BorderImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        this.ivThumbCircleBadge = (ImageView)view0.findViewById(0x7F0A06A7);  // id:iv_thumbnail_circle_badge
        this.tvNickname = (TextView)view0.findViewById(0x7F0A0CCD);  // id:tv_nickname
        this.tvDate = (TextView)view0.findViewById(0x7F0A0C59);  // id:tv_date
        this.btnDelete = (TextView)view0.findViewById(0x7F0A0157);  // id:btn_delete
        ViewUtils.setDefaultImage(imageView0, MusicMessageEditorBaseViewHolder.thumbCircleDiameter, true);
    }

    public final void addContentsView(@Nullable ViewGroup viewGroup0, @NotNull CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) {
        View view0;
        q.g(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, "info");
        if(viewGroup0 != null) {
            viewGroup0.removeAllViews();
            int v = 1;
            int v1 = !this.getAdapter().isInEditMode();
            String s = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.contstypecode;
            q.f(s, "contstypecode");
            String s1 = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.trnsmtye;
            q.f(s1, "trnsmtye");
            this.setBackgroundBalloon(viewGroup0, s, s1);
            String s2 = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.contstypecode;
            s s3 = null;
            int v2 = 0;
            if(q.b(s2, "TEXT")) {
                boolean z = this.getAdapter().isInEditMode();
                view0 = this.setContentsTextView(viewGroup0, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0);
                v2 = !z;
                v1 = 0;
            }
            else if(q.b(s2, "N10001")) {
                boolean z1 = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.canService;
                if(!this.getAdapter().isInEditMode()) {
                    v2 = z1;
                }
                view0 = this.setContentsSongView(viewGroup0, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, z1);
                v1 = v2;
            }
            else if(q.b(s2, "N10003")) {
                if(!musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.canService || ProtocolUtils.parseBoolean(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.privateyn)) {
                    v = 0;
                }
                v1 = this.getAdapter().isInEditMode() ? 0 : v;
                view0 = this.setContentsVideoView(viewGroup0, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, ((boolean)v));
                v2 = v1;
            }
            else if(q.b(s2, "N10002")) {
                boolean z2 = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.canService;
                if(!this.getAdapter().isInEditMode()) {
                    v2 = z2;
                }
                view0 = this.setContentsAlbumView(viewGroup0, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, z2);
                v1 = v2;
            }
            else if(q.b(s2, "N10006")) {
                view0 = this.setContentsArtistView(viewGroup0, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0);
                v2 = v1;
            }
            else if(q.b(s2, "N10004")) {
                v1 = !ProtocolUtils.parseBoolean(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.privateyn);
                if(this.getAdapter().isInEditMode()) {
                    v1 = 0;
                }
                view0 = this.setContentsPhotoView(viewGroup0, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0);
                v2 = v1;
            }
            else if(q.b(s2, "N10005") || q.b(s2, "N10009") || q.b(s2, "N10016")) {
                if(!ProtocolUtils.parseBoolean(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.openyn) || ProtocolUtils.parseBoolean(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.dimYn)) {
                    v = 0;
                }
                v1 = this.getAdapter().isInEditMode() ? 0 : v;
                view0 = this.setContentsPlaylistView(viewGroup0, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, ((boolean)v));
                v2 = v1;
            }
            else {
                v2 = v1;
                view0 = null;
            }
            if(view0 != null) {
                viewGroup0.addView(view0);
            }
            viewGroup0.setClickable(((boolean)v1));
            viewGroup0.setEnabled(((boolean)v2));
            if(v1 != 0) {
                s3 = new s(25, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, this);
            }
            ViewUtils.setOnClickListener(viewGroup0, s3);
        }
    }

    private static final void addContentsView$lambda$4(CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, MusicMessageEditorBaseViewHolder musicMessageEditorBaseViewHolder0, View view0) {
        String s = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.contstypecode;
        if(!q.b(s, "TEXT")) {
            if(q.b(s, "N10001")) {
                musicMessageEditorBaseViewHolder0.getFragment().playSong(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.songId, musicMessageEditorBaseViewHolder0.getAdapter().getMenuId(), false);
                return;
            }
            if(q.b(s, "N10003")) {
                musicMessageEditorBaseViewHolder0.getFragment().showMvInfoPage(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.mvId, musicMessageEditorBaseViewHolder0.getAdapter().getMenuId());
                return;
            }
            if(q.b(s, "N10002")) {
                musicMessageEditorBaseViewHolder0.getFragment().showAlbumInfoPage(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.albumId);
                return;
            }
            if(q.b(s, "N10006")) {
                musicMessageEditorBaseViewHolder0.getFragment().showArtistInfoPage(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.getArtistId());
                return;
            }
            if(!q.b(s, "N10004")) {
                if(q.b(s, "N10005")) {
                    Navigator.INSTANCE.openPlaylistDetail(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.plylstseq);
                    return;
                }
                if(q.b(s, "N10009")) {
                    Navigator.openDjPlaylistDetail(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.plylstseq);
                    return;
                }
                if(q.b(s, "N10016")) {
                    Navigator.INSTANCE.openArtistPlaylistDetail(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.plylstseq);
                }
            }
            else if(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.artistList != null && musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.artistList.size() > 0) {
                Navigator.INSTANCE.openPhotoInfo(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.imgid);
            }
        }
    }

    @NotNull
    public final MusicMessageEditorAdapter getAdapter() {
        p p0 = this.getFragment().getMelonArrayAdapter();
        q.e(p0, "null cannot be cast to non-null type com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment.MusicMessageEditorAdapter");
        return (MusicMessageEditorAdapter)p0;
    }

    @Nullable
    public final TextView getBtnDelete() {
        return this.btnDelete;
    }

    @Override  // com.iloen.melon.fragments.musicmessage.MusicMessageBaseViewHolder
    public MetaContentBaseFragment getFragment() {
        return this.getFragment();
    }

    @NotNull
    public MusicMessageEditorFragment getFragment() {
        MetaContentBaseFragment metaContentBaseFragment0 = super.getFragment();
        q.e(metaContentBaseFragment0, "null cannot be cast to non-null type com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment");
        return (MusicMessageEditorFragment)metaContentBaseFragment0;
    }

    @Nullable
    public final View getItemContainer() {
        return this.itemContainer;
    }

    @Nullable
    public final View getItemDateSeperatorContainer() {
        return this.itemDateSeperatorContainer;
    }

    @Nullable
    public final View getItemLastSeperator() {
        return this.itemLastSeperator;
    }

    @Nullable
    public final View getItemPersonSeperator() {
        return this.itemPersonSeperator;
    }

    @Nullable
    public final BorderImageView getIvThumbCircle() {
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
    public final ImageView getIvThumbCircleDefaultBg() {
        return this.ivThumbCircleDefaultBg;
    }

    @Nullable
    public final ViewGroup getMessageContainer() {
        return this.messageContainer;
    }

    @Nullable
    public final View getThumbCircleContainer() {
        return this.thumbCircleContainer;
    }

    @Nullable
    public final TextView getTvDate() {
        return this.tvDate;
    }

    @Nullable
    public final TextView getTvNickname() {
        return this.tvNickname;
    }

    @Nullable
    public final TextView getTvSeperateDay() {
        return this.tvSeperateDay;
    }

    public final boolean hideMe() [...] // Inlined contents

    public boolean isContentListValid(@Nullable CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) {
        if((musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0 == null ? null : musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.targetmemberinfolist) == null) {
            LogU.Companion.w("MusicMessageEditorViewHolder", "Invalid ContentList dataset!");
            return false;
        }
        return true;
    }

    @Override  // com.iloen.melon.fragments.musicmessage.MusicMessageBaseViewHolder
    public boolean isContentListValid(Object object0) {
        return this.isContentListValid(((CONTENTSLIST)object0));
    }

    private final void setBackgroundBalloon(ViewGroup viewGroup0, String s, String s1) {
        viewGroup0.setBackgroundTintList(null);
        int v = 0x7F0800D2;  // drawable:bg_m_white01
        if(q.b(s, "TEXT")) {
            if("S".equalsIgnoreCase(s1)) {
                viewGroup0.setBackgroundResource(0x7F0800D1);  // drawable:bg_m_green
                viewGroup0.setBackgroundTintList(ColorUtils.getColorStateList(viewGroup0.getContext(), 0x7F06017F));  // color:green502s_support_high_contrast
                return;
            }
            viewGroup0.setBackgroundResource(0x7F0800D2);  // drawable:bg_m_white01
            viewGroup0.setBackgroundTintList(ColorUtils.getColorStateList(viewGroup0.getContext(), 0x7F0604AC));  // color:white002s
            return;
        }
        if(q.b(s, "N10004")) {
            viewGroup0.setBackgroundResource(0x7F08093C);  // drawable:transparent
            return;
        }
        if("S".equalsIgnoreCase(s1)) {
            v = 0x7F0800D3;  // drawable:bg_m_white02
        }
        viewGroup0.setBackgroundResource(v);
        viewGroup0.setBackgroundTintList(ColorUtils.getColorStateList(viewGroup0.getContext(), 0x7F0604AC));  // color:white002s
    }

    private final View setContentsAlbumView(ViewGroup viewGroup0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, boolean z) {
        FragmentActivity fragmentActivity0 = this.getFragment().getActivity();
        Object object0 = fragmentActivity0 == null ? null : fragmentActivity0.getSystemService("layout_inflater");
        q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
        View view0 = ((LayoutInflater)object0).inflate(0x7F0D0555, viewGroup0, false);  // layout:musicmessage_editor_list_item_inc_album
        View view1 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        q.f(view1, "findViewById(...)");
        MelonAppBase.Companion.getClass();
        ViewUtils.setDefaultImage(((ImageView)view1), ScreenUtils.dipToPixel(t.a().getContext(), 48.0f), false);
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        if(imageView0 != null) {
            Glide.with(imageView0.getContext()).load(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.albumImg).into(imageView0);
            q.f("이미지", "getString(...)");
            if(!TextUtils.isEmpty("이미지")) {
                imageView0.setContentDescription("이미지");
            }
        }
        View view2 = view0.findViewById(0x7F0A0D34);  // id:tv_title
        q.f(view2, "findViewById(...)");
        ((TextView)view2).setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.albumName);
        View view3 = view0.findViewById(0x7F0A0C12);  // id:tv_artist
        q.f(view3, "findViewById(...)");
        ((TextView)view3).setText(ProtocolUtils.getArtistNames(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.artistList));
        ViewUtils.setEnable(view0, z);
        return view0;
    }

    private final View setContentsArtistView(ViewGroup viewGroup0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) {
        FragmentActivity fragmentActivity0 = this.getFragment().getActivity();
        Object object0 = fragmentActivity0 == null ? null : fragmentActivity0.getSystemService("layout_inflater");
        q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
        View view0 = ((LayoutInflater)object0).inflate(0x7F0D0556, viewGroup0, false);  // layout:musicmessage_editor_list_item_inc_artist
        MelonAppBase.Companion.getClass();
        int v = ScreenUtils.dipToPixel(t.a().getContext(), 48.0f);
        View view1 = view0.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        q.f(view1, "findViewById(...)");
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        ViewUtils.setDefaultImage(((ImageView)view1), v, true);
        if(imageView0 != null) {
            Glide.with(imageView0.getContext()).load(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(imageView0);
        }
        q.f("%s 아티스트 이미지", "getString(...)");
        String s = String.format("%s 아티스트 이미지", Arrays.copyOf(new Object[]{musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.getArtistName()}, 1));
        if(!TextUtils.isEmpty(s) && imageView0 != null) {
            imageView0.setContentDescription(s);
        }
        View view2 = view0.findViewById(0x7F0A0C12);  // id:tv_artist
        q.f(view2, "findViewById(...)");
        ((TextView)view2).setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.getArtistName());
        View view3 = view0.findViewById(0x7F0A0C83);  // id:tv_genre
        q.f(view3, "findViewById(...)");
        ((TextView)view3).setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.actGenre);
        return view0;
    }

    private final View setContentsPhotoView(ViewGroup viewGroup0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) {
        FragmentActivity fragmentActivity0 = this.getFragment().getActivity();
        Object object0 = fragmentActivity0 == null ? null : fragmentActivity0.getSystemService("layout_inflater");
        q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
        View view0 = ((LayoutInflater)object0).inflate(0x7F0D0558, viewGroup0, false);  // layout:musicmessage_editor_list_item_inc_photo
        View view1 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        q.f(view1, "findViewById(...)");
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        Context context0 = this.getFragment().getContext();
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            if(resources0 != null) {
                ViewUtils.setDefaultImage(((ImageView)view1), resources0.getDimensionPixelSize(0x7F0703ED));  // dimen:musicmessage_item_photo_height
            }
        }
        if(imageView0 != null) {
            Glide.with(imageView0.getContext()).load(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.imgurl).apply(RequestOptions.bitmapTransform(new MultiTransformation(new Transformation[]{new CenterCrop(), new e(10, RoundedCornersTransformation.CornerType.ALL)}))).into(imageView0);
        }
        MelonAppBase.Companion.getClass();
        q.f("이미지", "getString(...)");
        if(!TextUtils.isEmpty("이미지") && imageView0 != null) {
            imageView0.setContentDescription("이미지");
        }
        return view0;
    }

    private final View setContentsPlaylistView(ViewGroup viewGroup0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, boolean z) {
        FragmentActivity fragmentActivity0 = this.getFragment().getActivity();
        Object object0 = fragmentActivity0 == null ? null : fragmentActivity0.getSystemService("layout_inflater");
        q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
        View view0 = ((LayoutInflater)object0).inflate(0x7F0D0559, viewGroup0, false);  // layout:musicmessage_editor_list_item_inc_playlist
        View view1 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        q.f(view1, "findViewById(...)");
        MelonAppBase.Companion.getClass();
        ViewUtils.setDefaultImage(((ImageView)view1), ScreenUtils.dipToPixel(t.a().getContext(), 48.0f), false);
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        if(imageView0 != null) {
            Glide.with(imageView0.getContext()).load(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.plylstimg).into(imageView0);
            q.f("이미지", "getString(...)");
            if(!TextUtils.isEmpty("이미지")) {
                imageView0.setContentDescription("이미지");
            }
        }
        View view2 = view0.findViewById(0x7F0A0D34);  // id:tv_title
        q.f(view2, "findViewById(...)");
        ((TextView)view2).setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.plylsttitle);
        View view3 = view0.findViewById(0x7F0A0CCD);  // id:tv_nickname
        q.f(view3, "findViewById(...)");
        if(q.b("N10016", musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.contstypecode)) {
            ((TextView)view3).setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.getArtistName());
        }
        else {
            ((TextView)view3).setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.ownernickname);
        }
        View view4 = view0.findViewById(0x7F0A0C50);  // id:tv_count
        q.f(view4, "findViewById(...)");
        ((TextView)view4).setText(StringUtils.getSongCountString(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.getSongCnt()));
        ViewUtils.setEnable(view0, z);
        return view0;
    }

    private final View setContentsSongView(ViewGroup viewGroup0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, boolean z) {
        FragmentActivity fragmentActivity0 = this.getFragment().getActivity();
        Object object0 = fragmentActivity0 == null ? null : fragmentActivity0.getSystemService("layout_inflater");
        q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
        View view0 = ((LayoutInflater)object0).inflate(0x7F0D055A, viewGroup0, false);  // layout:musicmessage_editor_list_item_inc_song
        View view1 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        q.f(view1, "findViewById(...)");
        MelonAppBase.Companion.getClass();
        ViewUtils.setDefaultImage(((ImageView)view1), ScreenUtils.dipToPixel(t.a().getContext(), 48.0f));
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        if(imageView0 != null) {
            Glide.with(imageView0.getContext()).load(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.albumImg).into(imageView0);
            q.f("이미지", "getString(...)");
            if(!TextUtils.isEmpty("이미지")) {
                imageView0.setContentDescription("이미지");
            }
        }
        View view2 = view0.findViewById(0x7F0A0633);  // id:iv_grade
        q.f(view2, "findViewById(...)");
        this.setSongIcon(((ImageView)view2), musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0);
        View view3 = view0.findViewById(0x7F0A0D34);  // id:tv_title
        q.f(view3, "findViewById(...)");
        ((TextView)view3).setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.songName);
        View view4 = view0.findViewById(0x7F0A0C12);  // id:tv_artist
        q.f(view4, "findViewById(...)");
        ((TextView)view4).setText(ProtocolUtils.getArtistNames(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.artistList));
        ViewUtils.setEnable(view0, z);
        return view0;
    }

    private final View setContentsTextView(ViewGroup viewGroup0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) {
        FragmentActivity fragmentActivity0 = this.getFragment().getActivity();
        Object object0 = fragmentActivity0 == null ? null : fragmentActivity0.getSystemService("layout_inflater");
        q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
        View view0 = ((LayoutInflater)object0).inflate(0x7F0D055B, viewGroup0, false);  // layout:musicmessage_editor_list_item_inc_text
        View view1 = view0.findViewById(0x7F0A0CB5);  // id:tv_message
        q.f(view1, "findViewById(...)");
        ((TextView)view1).setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.content);
        ((TextView)view1).setTextColor(("S".equalsIgnoreCase(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.trnsmtye) ? ColorUtils.getColor(this.getFragment().getContext(), 0x7F0604A1) : ColorUtils.getColor(this.getFragment().getContext(), 0x7F06016D)));  // color:white000e
        return view0;
    }

    private final View setContentsVideoView(ViewGroup viewGroup0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, boolean z) {
        FragmentActivity fragmentActivity0 = this.getFragment().getActivity();
        Object object0 = fragmentActivity0 == null ? null : fragmentActivity0.getSystemService("layout_inflater");
        q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
        View view0 = ((LayoutInflater)object0).inflate(0x7F0D055C, viewGroup0, false);  // layout:musicmessage_editor_list_item_inc_video
        View view1 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
        q.f(view1, "findViewById(...)");
        MelonAppBase.Companion.getClass();
        ViewUtils.setDefaultImage(((ImageView)view1), ScreenUtils.dipToPixel(t.a().getContext(), 48.0f));
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
        if(imageView0 != null) {
            Glide.with(imageView0.getContext()).load(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.mvImg).into(imageView0);
            q.f("이미지", "getString(...)");
            if(!TextUtils.isEmpty("이미지")) {
                imageView0.setContentDescription("이미지");
            }
        }
        View view2 = view0.findViewById(0x7F0A0633);  // id:iv_grade
        q.f(view2, "findViewById(...)");
        this.setMvIcon(((ImageView)view2), musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0);
        View view3 = view0.findViewById(0x7F0A0D34);  // id:tv_title
        q.f(view3, "findViewById(...)");
        ((TextView)view3).setText("null");
        View view4 = view0.findViewById(0x7F0A0C12);  // id:tv_artist
        q.f(view4, "findViewById(...)");
        ((TextView)view4).setText(ProtocolUtils.getArtistNames(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.artistList));
        ViewUtils.setEnable(view0, z);
        return view0;
    }

    public final void setLastSeperatorVisibility(int v) {
        View view0 = this.itemLastSeperator;
        if(view0 != null) {
            view0.setVisibility(v);
        }
    }

    private final void setMvIcon(ImageView imageView0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) {
        int v = ResourceUtils.getMvAdultGradeSmallIcon(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.adultGrade);
        if(v != -1) {
            imageView0.setImageResource(v);
            ViewUtils.showWhen(imageView0, true);
            return;
        }
        ViewUtils.showWhen(imageView0, false);
    }

    public final void setPersonInfoVisibility(int v) {
        View view0 = this.thumbCircleContainer;
        if(view0 != null && this.tvNickname != null) {
            if(v != 0) {
                switch(v) {
                    case 4: {
                        view0.setVisibility(4);
                        this.tvNickname.setVisibility(8);
                        return;
                    }
                    case 8: {
                        view0.setVisibility(8);
                        this.tvNickname.setVisibility(8);
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            view0.setVisibility(0);
            this.tvNickname.setVisibility(0);
        }
    }

    public final void setPersonSeperatorVisibility(int v) {
        View view0 = this.itemPersonSeperator;
        if(view0 != null) {
            view0.setVisibility(v);
        }
    }

    private final void setSongIcon(ImageView imageView0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) {
        int v = ResourceUtils.getMvAdultGradeSmallIcon((musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.isAdult ? "19" : ""));
        if(v != -1) {
            imageView0.setImageResource(v);
            ViewUtils.showWhen(imageView0, true);
            return;
        }
        ViewUtils.showWhen(imageView0, false);
    }
}

