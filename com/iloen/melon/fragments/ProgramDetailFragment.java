package com.iloen.melon.fragments;

import B.a;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.detail.ProfileImageView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.CastProgramDetailReq;
import com.iloen.melon.net.v5x.request.MyMusicLikeListContentsLikeReq.Params;
import com.iloen.melon.net.v5x.request.MyMusicLikeListContentsLikeReq;
import com.iloen.melon.net.v5x.response.CastProgramDetailRes.Response.Banner;
import com.iloen.melon.net.v5x.response.CastProgramDetailRes.Response.Program;
import com.iloen.melon.net.v5x.response.CastProgramDetailRes.Response;
import com.iloen.melon.net.v5x.response.CastProgramDetailRes;
import com.iloen.melon.net.v5x.response.CreatorInfoBase.ContsList;
import com.iloen.melon.net.v5x.response.CreatorInfoBase;
import com.iloen.melon.net.v5x.response.MyMusicLikeListContentsLikeRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v5x.response.MyMusicLikeListContentsLikeRes;
import com.iloen.melon.net.v5x.response.ProgramBase.Creator;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableProgram;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.MelonBlurTransformation;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ActionKind;
import d5.m;
import ie.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@d
@Metadata(d1 = {"\u0000\u00A6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 k2\u00020\u0001:\u0001kB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\n\u0010\bJ!\u0010\r\u001A\u00020\u00062\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0011\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0019\u001A\u00020\u00182\b\u0010\u0013\u001A\u0004\u0018\u00010\u00122\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016H\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u000F\u0010\u001B\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u0003J!\u0010!\u001A\u00020 2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b!\u0010\"J\u001D\u0010&\u001A\b\u0012\u0002\b\u0003\u0018\u00010%2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u0017\u0010*\u001A\u00020\u000B2\u0006\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b*\u0010+J\u0017\u0010,\u001A\u00020\u000B2\u0006\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b,\u0010+J\u0017\u0010-\u001A\u00020\u000B2\u0006\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b-\u0010+J\u000F\u0010.\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b.\u0010/J\u000F\u00100\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b0\u0010/J\u000F\u00101\u001A\u00020\u0018H\u0014\u00A2\u0006\u0004\b1\u00102J\u000F\u00103\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b3\u0010/J\u000F\u00104\u001A\u00020\u0018H\u0016\u00A2\u0006\u0004\b4\u00102J\u0015\u00106\u001A\b\u0012\u0004\u0012\u00020\u001C05H\u0014\u00A2\u0006\u0004\b6\u00107J\u0017\u0010:\u001A\u00020\u00062\u0006\u00109\u001A\u000208H\u0014\u00A2\u0006\u0004\b:\u0010;J\u000F\u0010<\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b<\u0010=J\u0011\u0010?\u001A\u0004\u0018\u00010>H\u0014\u00A2\u0006\u0004\b?\u0010@J\u000F\u0010A\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bA\u0010\u0003J\u000F\u0010B\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bB\u0010\u0003J\u000F\u0010C\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\bC\u0010\u0003R\u0016\u0010E\u001A\u00020D8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001A\u00020D8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bG\u0010FR\u0016\u0010I\u001A\u00020H8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001A\u00020K8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001A\u00020D8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bN\u0010FR\u0016\u0010O\u001A\u00020D8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bO\u0010FR\u0014\u0010P\u001A\u00020\u001E8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010R\u001A\u00020H8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bR\u0010JR\u0016\u0010S\u001A\u00020H8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bS\u0010JR\u0016\u0010T\u001A\u00020\u000B8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001A\u00020D8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bV\u0010FR\u0016\u0010W\u001A\u00020D8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bW\u0010FR\u0016\u0010X\u001A\u00020H8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bX\u0010JR\u0016\u0010Y\u001A\u00020D8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bY\u0010FR\u0016\u0010Z\u001A\u00020\u000B8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bZ\u0010UR\u0016\u0010[\u001A\u00020\u000B8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b[\u0010UR\u0016\u0010\\\u001A\u00020H8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b\\\u0010JR\u0016\u0010]\u001A\u00020D8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b]\u0010FR\u0016\u0010^\u001A\u00020H8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b^\u0010JR\u0016\u0010_\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\ba\u0010`R\u0016\u0010b\u001A\u00020\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010d\u001A\u00020c8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bh\u0010gR\u0016\u0010i\u001A\u00020\u00168\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bi\u0010gR\u0014\u0010j\u001A\u00020\u00168\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bj\u0010g\u00A8\u0006l"}, d2 = {"Lcom/iloen/melon/fragments/ProgramDetailFragment;", "Lcom/iloen/melon/fragments/DetailTabPagerBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "onResume", "Lcom/iloen/melon/custom/tablayout/TabInfo;", "tabInfo", "", "position", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "makeTabFragment", "(Lcom/iloen/melon/custom/tablayout/TabInfo;I)Lcom/iloen/melon/fragments/MelonBaseFragment;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroid/view/LayoutInflater;", "inflater", "createTopHeaderView", "(Landroid/view/LayoutInflater;)Landroid/view/View;", "createImageHeaderView", "createBottomHeaderView", "getTopHeaderHeight", "()I", "getBottomHeaderHeight", "disableSwipeable", "()Z", "getTabHeight", "isScreenLandscapeSupported", "", "makeTabInfo", "()Ljava/util/List;", "", "ratio", "updateHeaderRatio", "(F)V", "getCacheKey", "()Ljava/lang/String;", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "updateUI", "subscriptionInquiry", "requestSubscribe", "Landroid/widget/ImageView;", "backgroundImg", "Landroid/widget/ImageView;", "coverImg", "Landroid/widget/TextView;", "programTitleTv", "Landroid/widget/TextView;", "Lcom/iloen/melon/custom/detail/ProfileImageView;", "thumbnailImg", "Lcom/iloen/melon/custom/detail/ProfileImageView;", "starBadgeIv", "strokeIv", "PROFILE_DPSIZE", "I", "progDescTv", "creatorNameTv", "subscribeContainer", "Landroid/view/View;", "shareBtn", "subscribeIv", "actSubscribetv", "bannerIv", "expandDescriptionBtn", "userTitleContainer", "djBadge", "djOfficial", "otherCreatorCountText", "isExpandDesc", "Z", "isSubscription", "hasBanner", "Lcom/iloen/melon/net/v5x/response/CastProgramDetailRes;", "programRes", "Lcom/iloen/melon/net/v5x/response/CastProgramDetailRes;", "progSeq", "Ljava/lang/String;", "section", "page", "ARG_EXPAND_DESC", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ProgramDetailFragment extends DetailTabPagerBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/ProgramDetailFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_PROCSEQ", "newInstance", "Lcom/iloen/melon/fragments/ProgramDetailFragment;", "procSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ProgramDetailFragment newInstance(@NotNull String s) {
            q.g(s, "procSeq");
            ProgramDetailFragment programDetailFragment0 = new ProgramDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argProcSeq", s);
            programDetailFragment0.setArguments(bundle0);
            return programDetailFragment0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private final String ARG_EXPAND_DESC;
    @NotNull
    public static final String ARG_PROCSEQ = "argProcSeq";
    @NotNull
    public static final Companion Companion = null;
    private final int PROFILE_DPSIZE;
    @NotNull
    public static final String TAG = "ProgramHomeFragment";
    private TextView actSubscribetv;
    private ImageView backgroundImg;
    private ImageView bannerIv;
    private ImageView coverImg;
    private TextView creatorNameTv;
    private TextView djBadge;
    private ImageView djOfficial;
    private View expandDescriptionBtn;
    private boolean hasBanner;
    private boolean isExpandDesc;
    private boolean isSubscription;
    private TextView otherCreatorCountText;
    @NotNull
    private String page;
    private TextView progDescTv;
    @NotNull
    private String progSeq;
    private CastProgramDetailRes programRes;
    private TextView programTitleTv;
    @NotNull
    private String section;
    private ImageView shareBtn;
    private ImageView starBadgeIv;
    private ImageView strokeIv;
    private View subscribeContainer;
    private ImageView subscribeIv;
    private ProfileImageView thumbnailImg;
    private View userTitleContainer;

    static {
        ProgramDetailFragment.Companion = new Companion(null);
        ProgramDetailFragment.$stable = 8;
    }

    public ProgramDetailFragment() {
        this.PROFILE_DPSIZE = 46;
        this.progSeq = "";
        this.section = "";
        this.page = "";
        this.ARG_EXPAND_DESC = "argExpandDesc";
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @NotNull
    public View createBottomHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D05C2, null, false);  // layout:program_detail_bottom_header
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @NotNull
    public View createImageHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D05C3, null, false);  // layout:program_detail_image_header
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @NotNull
    public View createTopHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D05C6, null, false);  // layout:program_detail_top_header
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public boolean disableSwipeable() {
        return true;
    }

    public static void f0(ProgramDetailFragment programDetailFragment0, View view0) {
        ProgramDetailFragment.onViewCreated$lambda$3(programDetailFragment0, view0);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getBottomHeaderHeight() {
        int v = ScreenUtils.dipToPixel(this.getActivity(), 145.0f);
        TextView textView0 = this.progDescTv;
        if(textView0 != null && this.isExpandDesc) {
            if(textView0 == null) {
                q.m("progDescTv");
                throw null;
            }
            else if(textView0.getLineCount() > 2) {
                TextView textView1 = this.progDescTv;
                if(textView1 != null) {
                    int v1 = textView1.getLineCount();
                    v += ViewUtilsKt.dpToPx(21.0f) * (v1 - 2);
                    return this.hasBanner ? ScreenUtils.dipToPixel(this.getActivity(), 54.0f) + v : v;
                }
                q.m("progDescTv");
                throw null;
            }
        }
        return this.hasBanner ? ScreenUtils.dipToPixel(this.getActivity(), 54.0f) + v : v;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.V0.buildUpon(), "progSeq", this.progSeq, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @Nullable
    public Sharable getSNSSharable() {
        CastProgramDetailRes castProgramDetailRes0 = this.programRes;
        if(castProgramDetailRes0 != null) {
            Program castProgramDetailRes$Response$Program0 = castProgramDetailRes0.response.program;
            m m0 = new m(11, false);
            String s = castProgramDetailRes$Response$Program0.progTitle;
            q.f(s, "progTitle");
            m0.c = s;
            String s1 = castProgramDetailRes$Response$Program0.progSeq;
            q.f(s1, "progSeq");
            m0.b = s1;
            String s2 = castProgramDetailRes$Response$Program0.progImgUrl;
            q.f(s2, "progImgUrl");
            m0.d = s2;
            return new SharableProgram(m0);
        }
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTabHeight() {
        return 0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTopHeaderHeight() {
        Context context0 = this.getContext();
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            return resources0 == null ? 0 : resources0.getDimensionPixelSize(0x7F07041C);  // dimen:programdetail_top_header_height
        }
        return 0;
    }

    public static void h0(ProgramDetailFragment programDetailFragment0, Creator programBase$Creator0, View view0) {
        ProgramDetailFragment.updateUI$lambda$12$lambda$9(programDetailFragment0, programBase$Creator0, view0);
    }

    public static void i0(ProgramDetailFragment programDetailFragment0, CastProgramDetailRes castProgramDetailRes0) {
        ProgramDetailFragment.onFetchStart$lambda$6(programDetailFragment0, castProgramDetailRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    public static void j0(ProgramDetailFragment programDetailFragment0, Creator programBase$Creator0, View view0) {
        ProgramDetailFragment.updateUI$lambda$12$lambda$8(programDetailFragment0, programBase$Creator0, view0);
    }

    public static void k0(Program castProgramDetailRes$Response$Program0, ProgramDetailFragment programDetailFragment0, View view0) {
        ProgramDetailFragment.updateUI$lambda$12$lambda$7(castProgramDetailRes$Response$Program0, programDetailFragment0, view0);
    }

    public static void l0(ProgramDetailFragment programDetailFragment0, View view0) {
        ProgramDetailFragment.onViewCreated$lambda$2(programDetailFragment0, view0);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @NotNull
    public MelonBaseFragment makeTabFragment(@Nullable TabInfo tabInfo0, int v) {
        return ProgramDetailBottomFragment.Companion.newInstance(this.progSeq);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @NotNull
    public List makeTabInfo() {
        List list0 = new ArrayList();
        TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
        tabInfo0.a = 0;
        tabInfo0.b = "";
        tabInfo0.c = 0;
        tabInfo0.d = null;
        tabInfo0.e = 0;
        tabInfo0.f = 0;
        tabInfo0.g = 0;
        tabInfo0.h = 0;
        tabInfo0.i = 0x7F080820;  // drawable:selector_dot
        tabInfo0.j = -1.0f;
        tabInfo0.k = -1.0f;
        tabInfo0.l = -1.0f;
        tabInfo0.m = -1.0f;
        tabInfo0.n = 1.0f;
        tabInfo0.o = -1;
        ((ArrayList)list0).add(tabInfo0);
        return list0;
    }

    public static void n0(ProgramDetailFragment programDetailFragment0, MyMusicLikeListContentsLikeRes myMusicLikeListContentsLikeRes0) {
        ProgramDetailFragment.subscriptionInquiry$lambda$13(programDetailFragment0, myMusicLikeListContentsLikeRes0);
    }

    public static void o0(ProgramDetailFragment programDetailFragment0, View view0) {
        ProgramDetailFragment.onViewCreated$lambda$4(programDetailFragment0, view0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        RequestBuilder.newInstance(new CastProgramDetailReq(this.getContext(), this.progSeq)).tag(this.getRequestTag()).listener(new D(this, 1)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$6(ProgramDetailFragment programDetailFragment0, CastProgramDetailRes castProgramDetailRes0) {
        if(!programDetailFragment0.prepareFetchComplete(castProgramDetailRes0)) {
            return;
        }
        q.d(castProgramDetailRes0);
        programDetailFragment0.programRes = castProgramDetailRes0;
        if(castProgramDetailRes0.response != null) {
            programDetailFragment0.updateUI();
            TitleBar titleBar0 = programDetailFragment0.getTitleBar();
            if(titleBar0 != null) {
                Response castProgramDetailRes$Response0 = castProgramDetailRes0.response;
                String s = castProgramDetailRes$Response0.section;
                String s1 = "";
                if(s == null) {
                    s = "";
                }
                programDetailFragment0.section = s;
                String s2 = castProgramDetailRes$Response0.page;
                if(s2 != null) {
                    s1 = s2;
                }
                programDetailFragment0.page = s1;
                titleBar0.setTiaraProperty(new s(s, s1, castProgramDetailRes$Response0.menuId, null));
            }
        }
        programDetailFragment0.performFetchCompleteOnlyViews();
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "savedInstanceState");
        this.isExpandDesc = bundle0.getBoolean(this.ARG_EXPAND_DESC);
        String s = bundle0.getString("argProcSeq");
        if(s == null) {
            s = "";
        }
        this.progSeq = s;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        TextView textView0 = this.progDescTv;
        if(textView0 != null) {
            Linkify.addLinks(textView0, 1);
            TextView textView1 = this.progDescTv;
            if(textView1 != null) {
                textView1.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
            q.m("progDescTv");
            throw null;
        }
        q.m("progDescTv");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putBoolean(this.ARG_EXPAND_DESC, this.isExpandDesc);
        bundle0.putString("argProcSeq", this.progSeq);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(0));
        }
        View view1 = view0.findViewById(0x7F0A0105);  // id:bg_iv
        q.f(view1, "findViewById(...)");
        this.backgroundImg = (ImageView)view1;
        View view2 = view0.findViewById(0x7F0A0353);  // id:cover_iv
        q.f(view2, "findViewById(...)");
        this.coverImg = (ImageView)view2;
        View view3 = view0.findViewById(0x7F0A0354);  // id:cover_title_tv
        q.f(view3, "findViewById(...)");
        this.programTitleTv = (TextView)view3;
        View view4 = view0.findViewById(0x7F0A096C);  // id:profile_image
        q.f(view4, "findViewById(...)");
        this.thumbnailImg = (ProfileImageView)view4;
        ((ProfileImageView)view4).setDefaultImg(this.PROFILE_DPSIZE);
        View view5 = view0.findViewById(0x7F0A0ADD);  // id:star_badge_iv
        q.f(view5, "findViewById(...)");
        this.starBadgeIv = (ImageView)view5;
        View view6 = view0.findViewById(0x7F0A0AF0);  // id:stroke_iv
        q.f(view6, "findViewById(...)");
        this.strokeIv = (ImageView)view6;
        View view7 = view0.findViewById(0x7F0A03B2);  // id:description_tv
        q.f(view7, "findViewById(...)");
        this.progDescTv = (TextView)view7;
        View view8 = view0.findViewById(0x7F0A0D8A);  // id:user_title_container
        q.f(view8, "findViewById(...)");
        this.userTitleContainer = view8;
        View view9 = view0.findViewById(0x7F0A03DA);  // id:dj_badge
        q.f(view9, "findViewById(...)");
        this.djBadge = (TextView)view9;
        View view10 = view0.findViewById(0x7F0A03DC);  // id:dj_official
        q.f(view10, "findViewById(...)");
        this.djOfficial = (ImageView)view10;
        View view11 = view0.findViewById(0x7F0A0D8B);  // id:user_title_tv
        q.f(view11, "findViewById(...)");
        this.creatorNameTv = (TextView)view11;
        View view12 = view0.findViewById(0x7F0A08ED);  // id:other_user_title_tv
        q.f(view12, "findViewById(...)");
        this.otherCreatorCountText = (TextView)view12;
        View view13 = view0.findViewById(0x7F0A0A82);  // id:share_btn
        q.f(view13, "findViewById(...)");
        this.shareBtn = (ImageView)view13;
        View view14 = view0.findViewById(0x7F0A0B04);  // id:subscribe_iv
        q.f(view14, "findViewById(...)");
        this.subscribeIv = (ImageView)view14;
        View view15 = view0.findViewById(0x7F0A004E);  // id:act_subscribe_tv
        q.f(view15, "findViewById(...)");
        this.actSubscribetv = (TextView)view15;
        View view16 = view0.findViewById(0x7F0A00F1);  // id:banner_iv
        q.f(view16, "findViewById(...)");
        this.bannerIv = (ImageView)view16;
        View view17 = view0.findViewById(0x7F0A0B03);  // id:subscribe_container
        q.f(view17, "findViewById(...)");
        this.subscribeContainer = view17;
        View view18 = view0.findViewById(0x7F0A0474);  // id:expand_description_btn
        q.f(view18, "findViewById(...)");
        this.expandDescriptionBtn = view18;
        ViewUtils.setOnClickListener(view18, new F(this, 0));
        ImageView imageView0 = this.shareBtn;
        if(imageView0 != null) {
            ViewUtils.setOnClickListener(imageView0, new F(this, 1));
            View view19 = this.subscribeContainer;
            if(view19 != null) {
                ViewUtils.setOnClickListener(view19, new F(this, 2));
                return;
            }
            q.m("subscribeContainer");
            throw null;
        }
        q.m("shareBtn");
        throw null;
    }

    private static final void onViewCreated$lambda$2(ProgramDetailFragment programDetailFragment0, View view0) {
        View view1 = programDetailFragment0.expandDescriptionBtn;
        if(view1 != null) {
            view1.setVisibility(8);
            TextView textView0 = programDetailFragment0.progDescTv;
            if(textView0 != null) {
                textView0.setMaxLines(0x7FFFFFFF);
                programDetailFragment0.isExpandDesc = true;
                TextView textView1 = programDetailFragment0.progDescTv;
                if(textView1 != null) {
                    textView1.post(new l(programDetailFragment0, 4));
                    return;
                }
                q.m("progDescTv");
                throw null;
            }
            q.m("progDescTv");
            throw null;
        }
        q.m("expandDescriptionBtn");
        throw null;
    }

    private static final void onViewCreated$lambda$2$lambda$1(ProgramDetailFragment programDetailFragment0) {
        programDetailFragment0.updateParallaxHeaderHeight();
    }

    private static final void onViewCreated$lambda$3(ProgramDetailFragment programDetailFragment0, View view0) {
        programDetailFragment0.showSNSListPopup(programDetailFragment0.getSNSSharable());
        if(programDetailFragment0.programRes != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            CastProgramDetailRes castProgramDetailRes0 = programDetailFragment0.programRes;
            if(castProgramDetailRes0 != null) {
                g0.I = castProgramDetailRes0.response.menuId;
                g0.d = ActionKind.Share;
                g0.a = "공유";
                g0.b = programDetailFragment0.section;
                g0.c = programDetailFragment0.page;
                g0.y = "프로그램정보";
                g0.z = "공유하기";
                CastProgramDetailRes castProgramDetailRes1 = programDetailFragment0.programRes;
                if(castProgramDetailRes1 != null) {
                    Program castProgramDetailRes$Response$Program0 = castProgramDetailRes1.response.program;
                    g0.e = castProgramDetailRes$Response$Program0.progSeq;
                    if(castProgramDetailRes1 != null) {
                        g0.g = castProgramDetailRes$Response$Program0.progTitle;
                        Context context0 = programDetailFragment0.getContext();
                        CastProgramDetailRes castProgramDetailRes2 = programDetailFragment0.programRes;
                        if(castProgramDetailRes2 != null) {
                            g0.h = CreatorInfoBase.getCreatorNames(context0, castProgramDetailRes2.response.program.creator);
                            g0.a().track();
                            return;
                        }
                        q.m("programRes");
                        throw null;
                    }
                    q.m("programRes");
                    throw null;
                }
                q.m("programRes");
                throw null;
            }
            q.m("programRes");
            throw null;
        }
    }

    private static final void onViewCreated$lambda$4(ProgramDetailFragment programDetailFragment0, View view0) {
        programDetailFragment0.requestSubscribe();
    }

    // 去混淆评级： 低(20)
    private final void requestSubscribe() {
        this.updateSubscribe(this.progSeq, "N10083", !this.isSubscription, (this.programRes == null ? "9999999999" : ""), new OnJobFinishListener() {
            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onJobComplete(String s, int v, boolean z) {
                q.g(s, "errorMsg");
                if(ProgramDetailFragment.this.isFragmentValid()) {
                    if(s.length() != 0) {
                        ProgramDetailFragment.this.showErrorPopup(s, false);
                        return;
                    }
                    ProgramDetailFragment.this.isSubscription = z;
                    if(ProgramDetailFragment.this.isSubscription) {
                        TextView textView0 = ProgramDetailFragment.this.actSubscribetv;
                        if(textView0 != null) {
                            textView0.setText(ProgramDetailFragment.this.getText(0x7F13066F));  // string:melondj_use_subscribe "구독 중"
                            ImageView imageView0 = ProgramDetailFragment.this.subscribeIv;
                            if(imageView0 != null) {
                                imageView0.setImageResource(0x7F0801A8);  // drawable:btn_follow_23_on
                                goto label_22;
                            }
                            q.m("subscribeIv");
                            throw null;
                        }
                        q.m("actSubscribetv");
                        throw null;
                    }
                    else {
                        ImageView imageView1 = ProgramDetailFragment.this.subscribeIv;
                        if(imageView1 == null) {
                            q.m("subscribeIv");
                            throw null;
                        }
                        imageView1.setImageResource(0x7F0801A6);  // drawable:btn_follow_23_off
                        TextView textView1 = ProgramDetailFragment.this.actSubscribetv;
                        if(textView1 == null) {
                            q.m("actSubscribetv");
                            throw null;
                        }
                        textView1.setText(ProgramDetailFragment.this.getText(0x7F130662));  // string:melondj_subscribe "구독하기"
                    }
                label_22:
                    if(z) {
                        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                        CastProgramDetailRes castProgramDetailRes0 = ProgramDetailFragment.this.programRes;
                        if(castProgramDetailRes0 != null) {
                            g0.I = castProgramDetailRes0.response.menuId;
                            g0.d = ActionKind.Follow;
                            g0.a = "구독";
                            g0.b = ProgramDetailFragment.this.section;
                            g0.c = ProgramDetailFragment.this.page;
                            g0.y = "프로그램정보";
                            g0.z = "구독하기";
                            CastProgramDetailRes castProgramDetailRes1 = ProgramDetailFragment.this.programRes;
                            if(castProgramDetailRes1 != null) {
                                g0.e = castProgramDetailRes1.response.program.progSeq;
                                CastProgramDetailRes castProgramDetailRes2 = ProgramDetailFragment.this.programRes;
                                if(castProgramDetailRes2 != null) {
                                    g0.g = castProgramDetailRes2.response.program.progTitle;
                                    Context context0 = ProgramDetailFragment.this.getContext();
                                    CastProgramDetailRes castProgramDetailRes3 = ProgramDetailFragment.this.programRes;
                                    if(castProgramDetailRes3 != null) {
                                        g0.h = CreatorInfoBase.getCreatorNames(context0, castProgramDetailRes3.response.program.creator);
                                        g0.a().track();
                                        return;
                                    }
                                    q.m("programRes");
                                    throw null;
                                }
                                q.m("programRes");
                                throw null;
                            }
                            q.m("programRes");
                            throw null;
                        }
                        q.m("programRes");
                        throw null;
                    }
                }
            }

            @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
            public void onStartAsyncTask() {
            }
        });
    }

    private final void subscriptionInquiry() {
        Params myMusicLikeListContentsLikeReq$Params0 = new Params();
        myMusicLikeListContentsLikeReq$Params0.contsTypeCode = "N10083";
        myMusicLikeListContentsLikeReq$Params0.contsIds = this.progSeq;
        myMusicLikeListContentsLikeReq$Params0.actTypeCode = "N20001";
        RequestBuilder.newInstance(new MyMusicLikeListContentsLikeReq(this.getContext(), myMusicLikeListContentsLikeReq$Params0)).tag(this.getRequestTag()).listener(new D(this, 0)).request();
    }

    private static final void subscriptionInquiry$lambda$13(ProgramDetailFragment programDetailFragment0, MyMusicLikeListContentsLikeRes myMusicLikeListContentsLikeRes0) {
        if(myMusicLikeListContentsLikeRes0.response != null && (myMusicLikeListContentsLikeRes0.response.contentslist != null && myMusicLikeListContentsLikeRes0.response.contentslist.size() != 0 && q.b(((CONTENTSLIST)myMusicLikeListContentsLikeRes0.response.contentslist.get(0)).likeyn, "Y"))) {
            TextView textView0 = programDetailFragment0.actSubscribetv;
            if(textView0 != null) {
                Context context0 = programDetailFragment0.getContext();
                textView0.setText((context0 == null ? null : context0.getText(0x7F13066F)));  // string:melondj_use_subscribe "구독 중"
                ImageView imageView0 = programDetailFragment0.subscribeIv;
                if(imageView0 != null) {
                    imageView0.setImageResource(0x7F0801A8);  // drawable:btn_follow_23_on
                    programDetailFragment0.isSubscription = true;
                    return;
                }
                q.m("subscribeIv");
                throw null;
            }
            q.m("actSubscribetv");
            throw null;
        }
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void updateHeaderRatio(float f) {
        float f1 = this.getAlphaValue(f);
        ProfileImageView profileImageView0 = this.thumbnailImg;
        if(profileImageView0 != null) {
            profileImageView0.setAlpha(f1);
            View view0 = this.userTitleContainer;
            if(view0 != null) {
                view0.setAlpha(f1);
                TextView textView0 = this.programTitleTv;
                if(textView0 != null) {
                    textView0.setAlpha(f1);
                    ImageView imageView0 = this.starBadgeIv;
                    if(imageView0 != null) {
                        imageView0.setAlpha(f1);
                        ImageView imageView1 = this.strokeIv;
                        if(imageView1 != null) {
                            imageView1.setAlpha(f1);
                            return;
                        }
                        q.m("strokeIv");
                        throw null;
                    }
                    q.m("starBadgeIv");
                    throw null;
                }
                q.m("programTitleTv");
                throw null;
            }
            q.m("userTitleContainer");
            throw null;
        }
        q.m("thumbnailImg");
        throw null;
    }

    private final void updateUI() {
        if(this.programRes != null) {
            Context context0 = this.getContext();
            if(context0 != null) {
                CastProgramDetailRes castProgramDetailRes0 = this.programRes;
                if(castProgramDetailRes0 == null) {
                    q.m("programRes");
                    throw null;
                }
                Program castProgramDetailRes$Response$Program0 = castProgramDetailRes0.response.program;
                TitleBar titleBar0 = this.mTitleBar;
                if(titleBar0 != null) {
                    titleBar0.setTitle(castProgramDetailRes$Response$Program0.progTitle);
                    this.mTitleBar.setTitleSize(17.0f);
                }
                com.bumptech.glide.RequestBuilder requestBuilder0 = Glide.with(context0).load(castProgramDetailRes$Response$Program0.progImgUrl).apply(new RequestOptions().transform(new MelonBlurTransformation(this.getContext())));
                ImageView imageView0 = this.backgroundImg;
                if(imageView0 == null) {
                    q.m("backgroundImg");
                    throw null;
                }
                requestBuilder0.into(imageView0);
                com.bumptech.glide.RequestBuilder requestBuilder1 = Glide.with(context0).load(castProgramDetailRes$Response$Program0.progImgUrl);
                ImageView imageView1 = this.coverImg;
                if(imageView1 == null) {
                    q.m("coverImg");
                    throw null;
                }
                requestBuilder1.into(imageView1);
                TextView textView0 = this.programTitleTv;
                if(textView0 == null) {
                    q.m("programTitleTv");
                    throw null;
                }
                textView0.setText(castProgramDetailRes$Response$Program0.progTitle);
                ImageView imageView2 = this.coverImg;
                if(imageView2 == null) {
                    q.m("coverImg");
                    throw null;
                }
                ViewUtils.setOnClickListener(imageView2, new E(castProgramDetailRes$Response$Program0, this));
                ArrayList arrayList0 = castProgramDetailRes$Response$Program0.creator.contsList;
                if(arrayList0 != null && !arrayList0.isEmpty()) {
                    Creator programBase$Creator0 = castProgramDetailRes$Response$Program0.creator;
                    ProfileImageView profileImageView0 = this.thumbnailImg;
                    if(profileImageView0 == null) {
                        q.m("thumbnailImg");
                        throw null;
                    }
                    String s = ((ContsList)programBase$Creator0.contsList.get(0)).imgUrl;
                    int v = ScreenUtils.dipToPixel(this.getContext(), 46.0f);
                    Context context1 = profileImageView0.getContext();
                    if(context1 != null && profileImageView0.b != null && !TextUtils.isEmpty(s)) {
                        Glide.with(context1).load(s).apply(RequestOptions.circleCropTransform()).into(new B8.a(profileImageView0, v));
                    }
                    if(q.b(programBase$Creator0.creatorLevel, "artist")) {
                        ImageView imageView3 = this.starBadgeIv;
                        if(imageView3 != null) {
                            ViewUtils.showWhen(imageView3, true);
                            goto label_41;
                        }
                        q.m("starBadgeIv");
                        throw null;
                    }
                label_41:
                    ProfileImageView profileImageView1 = this.thumbnailImg;
                    if(profileImageView1 == null) {
                        q.m("thumbnailImg");
                        throw null;
                    }
                    ViewUtils.setOnClickListener(profileImageView1, new E(this, programBase$Creator0, 0));
                    TextView textView1 = this.creatorNameTv;
                    if(textView1 == null) {
                        q.m("creatorNameTv");
                        throw null;
                    }
                    ViewUtils.setOnClickListener(textView1, new E(this, programBase$Creator0, 1));
                    int v1 = ResourceUtils.getDjIconColorId(programBase$Creator0.getFirstCreator().memberDjIconType);
                    if(v1 > -1) {
                        TextView textView2 = this.djBadge;
                        if(textView2 != null) {
                            textView2.setVisibility(0);
                            TextView textView3 = this.djBadge;
                            if(textView3 != null) {
                                textView3.setTextColor(ColorUtils.getColor(this.getContext(), v1));
                                goto label_63;
                            }
                            q.m("djBadge");
                            throw null;
                        }
                        q.m("djBadge");
                        throw null;
                    }
                    else {
                        TextView textView4 = this.djBadge;
                        if(textView4 == null) {
                            q.m("djBadge");
                            throw null;
                        }
                        textView4.setVisibility(8);
                    }
                label_63:
                    ImageView imageView4 = this.djOfficial;
                    if(imageView4 == null) {
                        q.m("djOfficial");
                        throw null;
                    }
                    ViewUtils.showWhen(imageView4, programBase$Creator0.getFirstCreator().isOfficial);
                    if(programBase$Creator0.contsList.size() <= 1 || !programBase$Creator0.getFirstCreator().isOfficial) {
                        TextView textView8 = this.creatorNameTv;
                        if(textView8 != null) {
                            textView8.setText(CreatorInfoBase.getCreatorNames(this.getContext(), programBase$Creator0));
                            TextView textView9 = this.otherCreatorCountText;
                            if(textView9 != null) {
                                ViewUtils.hideWhen(textView9, true);
                                goto label_107;
                            }
                            q.m("otherCreatorCountText");
                            throw null;
                        }
                        q.m("creatorNameTv");
                        throw null;
                    }
                    else {
                        TextView textView5 = this.creatorNameTv;
                        if(textView5 != null) {
                            textView5.setText(programBase$Creator0.getFirstCreator().name);
                            String s1 = this.getString(0x7F1308A8);  // string:program_except "외"
                            int v2 = programBase$Creator0.contsList.size();
                            String s2 = this.getString(0x7F1308A9);  // string:program_number_people "명"
                            TextView textView6 = this.otherCreatorCountText;
                            if(textView6 != null) {
                                textView6.setText(s1 + " " + (v2 - 1) + s2);
                                TextView textView7 = this.otherCreatorCountText;
                                if(textView7 != null) {
                                    ViewUtils.showWhen(textView7, true);
                                    goto label_107;
                                }
                                q.m("otherCreatorCountText");
                                throw null;
                            }
                            q.m("otherCreatorCountText");
                            throw null;
                        }
                        q.m("creatorNameTv");
                    }
                    throw null;
                }
            label_107:
                TextView textView10 = this.progDescTv;
                if(textView10 == null) {
                    q.m("progDescTv");
                    throw null;
                }
                textView10.setText(Html.fromHtml(castProgramDetailRes$Response$Program0.progDesc, 0));
                TextView textView11 = this.progDescTv;
                if(textView11 == null) {
                    q.m("progDescTv");
                    throw null;
                }
                if(ViewUtils.isTextViewEllipsis(textView11)) {
                label_119:
                    if(this.isExpandDesc) {
                        View view0 = this.expandDescriptionBtn;
                        if(view0 != null) {
                            view0.setVisibility(8);
                            TextView textView13 = this.progDescTv;
                            if(textView13 != null) {
                                textView13.setMaxLines(0x7FFFFFFF);
                                this.isExpandDesc = true;
                                this.updateParallaxHeaderHeight();
                                goto label_136;
                            }
                            q.m("progDescTv");
                            throw null;
                        }
                        q.m("expandDescriptionBtn");
                        throw null;
                    }
                    else {
                        View view1 = this.expandDescriptionBtn;
                        if(view1 == null) {
                            q.m("expandDescriptionBtn");
                            throw null;
                        }
                        ViewUtils.showWhen(view1, true);
                    }
                }
                else {
                    TextView textView12 = this.progDescTv;
                    if(textView12 == null) {
                        q.m("progDescTv");
                        throw null;
                    }
                    else if(textView12.getLineCount() > 2) {
                        goto label_119;
                    }
                }
            label_136:
                CastProgramDetailRes castProgramDetailRes1 = this.programRes;
                if(castProgramDetailRes1 == null) {
                    q.m("programRes");
                    throw null;
                }
                Banner castProgramDetailRes$Response$Banner0 = castProgramDetailRes1.response.banner;
                if(castProgramDetailRes$Response$Banner0 != null) {
                    String s3 = castProgramDetailRes$Response$Banner0.bgcolor;
                    q.f(s3, "bgcolor");
                    if(s3.length() > 0) {
                        this.hasBanner = true;
                        CastProgramDetailRes castProgramDetailRes2 = this.programRes;
                        if(castProgramDetailRes2 != null) {
                            Banner castProgramDetailRes$Response$Banner1 = castProgramDetailRes2.response.banner;
                            ImageView imageView5 = this.bannerIv;
                            if(imageView5 != null) {
                                ViewUtils.showWhen(imageView5, true);
                                ImageView imageView6 = this.bannerIv;
                                if(imageView6 != null) {
                                    imageView6.setBackgroundColor(ColorUtils.getColorFromHexStr(castProgramDetailRes$Response$Banner1.bgcolor));
                                    ImageView imageView7 = this.bannerIv;
                                    if(imageView7 != null) {
                                        com.bumptech.glide.RequestBuilder requestBuilder2 = Glide.with(imageView7.getContext()).load(castProgramDetailRes$Response$Banner1.imgurl).apply(RequestOptions.noAnimation());
                                        ImageView imageView8 = this.bannerIv;
                                        if(imageView8 != null) {
                                            requestBuilder2.into(imageView8);
                                            this.updateParallaxHeaderHeight();
                                            ImageView imageView9 = this.bannerIv;
                                            if(imageView9 != null) {
                                                ViewUtils.setOnClickListener(imageView9, new u(castProgramDetailRes$Response$Banner1, 1));
                                                this.subscriptionInquiry();
                                                return;
                                            }
                                            q.m("bannerIv");
                                            throw null;
                                        }
                                        q.m("bannerIv");
                                        throw null;
                                    }
                                    q.m("bannerIv");
                                    throw null;
                                }
                                q.m("bannerIv");
                                throw null;
                            }
                            q.m("bannerIv");
                            throw null;
                        }
                        q.m("programRes");
                        throw null;
                    }
                }
            }
            this.subscriptionInquiry();
        }
    }

    private static final void updateUI$lambda$12$lambda$11(Banner castProgramDetailRes$Response$Banner0, View view0) {
        MelonLinkExecutor.open(MelonLinkInfo.b(castProgramDetailRes$Response$Banner0));
    }

    private static final void updateUI$lambda$12$lambda$7(Program castProgramDetailRes$Response$Program0, ProgramDetailFragment programDetailFragment0, View view0) {
        if(castProgramDetailRes$Response$Program0.progImgUrl != null && castProgramDetailRes$Response$Program0.progImgUrl.length() != 0) {
            Navigator.openPhotoUrl(castProgramDetailRes$Response$Program0.progImgUrl);
        }
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        CastProgramDetailRes castProgramDetailRes0 = programDetailFragment0.programRes;
        if(castProgramDetailRes0 != null) {
            g0.I = castProgramDetailRes0.response.menuId;
            g0.d = ActionKind.ClickContent;
            g0.a = "페이지이동";
            g0.b = programDetailFragment0.section;
            g0.c = programDetailFragment0.page;
            g0.y = "프로그램정보";
            g0.z = "이미지상세보기";
            g0.a().track();
            return;
        }
        q.m("programRes");
        throw null;
    }

    private static final void updateUI$lambda$12$lambda$8(ProgramDetailFragment programDetailFragment0, Creator programBase$Creator0, View view0) {
        programDetailFragment0.showMultiCreatorPopup(programBase$Creator0);
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        CastProgramDetailRes castProgramDetailRes0 = programDetailFragment0.programRes;
        if(castProgramDetailRes0 != null) {
            g0.I = castProgramDetailRes0.response.menuId;
            g0.d = ActionKind.ClickContent;
            g0.a = "페이지이동";
            g0.b = programDetailFragment0.section;
            g0.c = programDetailFragment0.page;
            g0.y = "프로그램정보";
            g0.z = "유저정보보기";
            g0.a().track();
            return;
        }
        q.m("programRes");
        throw null;
    }

    private static final void updateUI$lambda$12$lambda$9(ProgramDetailFragment programDetailFragment0, Creator programBase$Creator0, View view0) {
        programDetailFragment0.showMultiCreatorPopup(programBase$Creator0);
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        CastProgramDetailRes castProgramDetailRes0 = programDetailFragment0.programRes;
        if(castProgramDetailRes0 != null) {
            g0.I = castProgramDetailRes0.response.menuId;
            g0.d = ActionKind.ClickContent;
            g0.a = "페이지이동";
            g0.b = programDetailFragment0.section;
            g0.c = programDetailFragment0.page;
            g0.y = "프로그램정보";
            g0.z = "유저정보보기";
            g0.a().track();
            return;
        }
        q.m("programRes");
        throw null;
    }
}

