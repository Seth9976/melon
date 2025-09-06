package com.iloen.melon.fragments.genre;

import Tf.o;
import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailTabPagerBaseFragment;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.GenreDetailArtistReq;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes.RESPONSE.ARTIST;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreDetailArtistRes;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.image.MelonBlurTransformation;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000\u00B0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001YB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u000B\u0010\u0003J\u000F\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000FH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001A\u00020\b2\u0006\u0010\u0013\u001A\u00020\u000FH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0012J!\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\u000FH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001C\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0019\u0010 \u001A\u0004\u0018\u00010\u00152\u0006\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b \u0010!J\u0019\u0010\"\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b\"\u0010!J\u0019\u0010#\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b#\u0010!J\u000F\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010\'\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010&J\'\u0010.\u001A\u00020-2\u0006\u0010)\u001A\u00020(2\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b.\u0010/J\u001D\u00103\u001A\b\u0012\u0002\b\u0003\u0018\u0001022\u0006\u00101\u001A\u000200H\u0014\u00A2\u0006\u0004\b3\u00104J\u0011\u00106\u001A\u0004\u0018\u000105H\u0014\u00A2\u0006\u0004\b6\u00107J\u001F\u0010<\u001A\u00020;2\u0006\u00109\u001A\u0002082\u0006\u0010:\u001A\u00020$H\u0014\u00A2\u0006\u0004\b<\u0010=J\u000F\u0010>\u001A\u00020-H\u0014\u00A2\u0006\u0004\b>\u0010?J\u000F\u0010@\u001A\u00020$H\u0014\u00A2\u0006\u0004\b@\u0010&J\u0017\u0010C\u001A\u00020\b2\u0006\u0010B\u001A\u00020AH\u0014\u00A2\u0006\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010G\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010J\u001A\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010L\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010O\u001A\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010Q\u001A\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bQ\u0010PR\u0018\u0010S\u001A\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001A\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bU\u0010MR\u0018\u0010W\u001A\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010X\u00A8\u0006Z"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreArtistDetailFragment;", "Lcom/iloen/melon/fragments/DetailTabPagerBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v5x/response/GenreDetailArtistRes$RESPONSE$ARTIST;", "fetchData", "()Lcom/iloen/melon/net/v5x/response/GenreDetailArtistRes$RESPONSE$ARTIST;", "res", "Lie/H;", "updateHeader", "(Lcom/iloen/melon/net/v5x/response/GenreDetailArtistRes$RESPONSE$ARTIST;)V", "updateTabInfoList", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/LayoutInflater;", "inflater", "createTopHeaderView", "(Landroid/view/LayoutInflater;)Landroid/view/View;", "createBottomHeaderView", "createImageHeaderView", "", "getTopHeaderHeight", "()I", "getBottomHeaderHeight", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/custom/tablayout/TabInfo;", "tabInfo", "position", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "makeTabFragment", "(Lcom/iloen/melon/custom/tablayout/TabInfo;I)Lcom/iloen/melon/fragments/MelonBaseFragment;", "disableSwipeable", "()Z", "getTabHeight", "", "ratio", "updateHeaderRatio", "(F)V", "mGnrArtistSeq", "Ljava/lang/String;", "genreDetailArtistRes", "Lcom/iloen/melon/net/v5x/response/GenreDetailArtistRes$RESPONSE$ARTIST;", "Lcom/iloen/melon/custom/MelonImageView;", "mBgIv", "Lcom/iloen/melon/custom/MelonImageView;", "mArtistChannelLayout", "Landroid/view/View;", "Landroid/widget/TextView;", "mArtistTv", "Landroid/widget/TextView;", "mArtistDescTv", "Landroid/widget/ImageView;", "mOpenIv", "Landroid/widget/ImageView;", "mCenterLayout", "Lcom/iloen/melon/custom/BorderImageView;", "mProfileImageIv", "Lcom/iloen/melon/custom/BorderImageView;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GenreArtistDetailFragment extends DetailTabPagerBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreArtistDetailFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_GNR_ARTIST_SEQ", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreArtistDetailFragment;", "gnrArtistSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreArtistDetailFragment newInstance(@NotNull String s) {
            q.g(s, "gnrArtistSeq");
            GenreArtistDetailFragment genreArtistDetailFragment0 = new GenreArtistDetailFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGnrArtistSeq", s);
            genreArtistDetailFragment0.setArguments(bundle0);
            return genreArtistDetailFragment0;
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_GNR_ARTIST_SEQ;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String TAG;
    @Nullable
    private ARTIST genreDetailArtistRes;
    @Nullable
    private View mArtistChannelLayout;
    @Nullable
    private TextView mArtistDescTv;
    @Nullable
    private TextView mArtistTv;
    @Nullable
    private MelonImageView mBgIv;
    @Nullable
    private View mCenterLayout;
    @NotNull
    private String mGnrArtistSeq;
    @Nullable
    private ImageView mOpenIv;
    @Nullable
    private BorderImageView mProfileImageIv;

    static {
        GenreArtistDetailFragment.Companion = new Companion(null);
        GenreArtistDetailFragment.$stable = 8;
        GenreArtistDetailFragment.TAG = "GenreArtistDetailFragment";
        GenreArtistDetailFragment.ARG_GNR_ARTIST_SEQ = "argGnrArtistSeq";
    }

    public GenreArtistDetailFragment() {
        this.mGnrArtistSeq = "";
    }

    public static final String access$getARG_GNR_ARTIST_SEQ$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @Nullable
    public View createBottomHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02DB, null, false);  // layout:genre_artist_detail_bottom_header
        View view1 = view0.findViewById(0x7F0A00C2);  // id:artist_tv
        q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
        this.mArtistTv = (TextView)view1;
        View view2 = view0.findViewById(0x7F0A00B5);  // id:artist_desc_tv
        q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
        this.mArtistDescTv = (TextView)view2;
        View view3 = view0.findViewById(0x7F0A08D8);  // id:open_iv
        q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
        this.mOpenIv = (ImageView)view3;
        return view0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @Nullable
    public View createImageHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02DC, null, false);  // layout:genre_artist_detail_image_header
        this.mCenterLayout = view0.findViewById(0x7F0A023E);  // id:center_layout
        View view1 = view0.findViewById(0x7F0A023D);  // id:center_img_layout
        View view2 = view1.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
        ViewUtils.setDefaultImage(((ImageView)view2), ScreenUtils.dipToPixel(this.getContext(), 86.0f), true);
        View view3 = view1.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        q.e(view3, "null cannot be cast to non-null type com.iloen.melon.custom.BorderImageView");
        this.mProfileImageIv = (BorderImageView)view3;
        ((BorderImageView)view3).setBorderWidth(0);
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @Nullable
    public View createTopHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02DD, null, false);  // layout:genre_artist_detail_top_header
        View view1 = view0.findViewById(0x7F0A0105);  // id:bg_iv
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonImageView");
        this.mBgIv = (MelonImageView)view1;
        this.mArtistChannelLayout = view0.findViewById(0x7F0A00B2);  // id:artist_channel_layout
        return view0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public boolean disableSwipeable() {
        return true;
    }

    private final ARTIST fetchData() {
        Cursor cursor0 = a.f(this.getContext(), this.getCacheKey());
        if(cursor0 == null) {
            LogU.Companion.w("GenreArtistDetailFragment", "fetchData() invalid cursor");
            return null;
        }
        GenreDetailArtistRes genreDetailArtistRes0 = (GenreDetailArtistRes)a.d(cursor0, GenreDetailArtistRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if((genreDetailArtistRes0 == null ? null : genreDetailArtistRes0.response) == null) {
            LogU.Companion.w("GenreArtistDetailFragment", "fetchData() failed to extract contents");
            return null;
        }
        return genreDetailArtistRes0.response.artist;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getBottomHeaderHeight() {
        String s = this.genreDetailArtistRes == null ? null : this.genreDetailArtistRes.artistRevw;
        return s == null || o.H0(s) ? ScreenUtils.dipToPixel(this.getContext(), 97.0f) : ScreenUtils.dipToPixel(this.getContext(), 205.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.A0.buildUpon(), this.mGnrArtistSeq, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTabHeight() {
        return 0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTopHeaderHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 100.0f);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @NotNull
    public MelonBaseFragment makeTabFragment(@NotNull TabInfo tabInfo0, int v) {
        q.g(tabInfo0, "tabInfo");
        String s = this.mGnrArtistSeq;
        String s1 = this.getCacheKey();
        return GenreArtistDetailBottomFragment.Companion.newInstance(s, s1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.updateHeader(this.fetchData());
        this.updateTabInfoList();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        Context context0 = this.getContext();
        if(a.e(300000L, this.getCacheKey(), context0)) {
            RequestBuilder.newInstance(new GenreDetailArtistReq(this.getContext(), this.mGnrArtistSeq)).tag("GenreArtistDetailFragment").listener(new c(this, 0)).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        ARTIST genreDetailArtistRes$RESPONSE$ARTIST0 = this.fetchData();
        this.genreDetailArtistRes = genreDetailArtistRes$RESPONSE$ARTIST0;
        this.updateHeader(genreDetailArtistRes$RESPONSE$ARTIST0);
        this.updateTabInfoList();
        this.updateParallaxHeaderHeight();
        return false;
    }

    private static final void onFetchStart$lambda$1(GenreArtistDetailFragment genreArtistDetailFragment0, GenreDetailArtistRes genreDetailArtistRes0) {
        if(!genreArtistDetailFragment0.prepareFetchComplete(genreDetailArtistRes0)) {
            return;
        }
        a.a(genreArtistDetailFragment0.getContext(), genreDetailArtistRes0, genreArtistDetailFragment0.getCacheKey());
        RESPONSE genreDetailArtistRes$RESPONSE0 = genreDetailArtistRes0.response;
        if(genreDetailArtistRes$RESPONSE0 != null) {
            genreArtistDetailFragment0.genreDetailArtistRes = genreDetailArtistRes$RESPONSE0.artist;
            genreArtistDetailFragment0.updateHeader(genreDetailArtistRes$RESPONSE0.artist);
        }
        genreArtistDetailFragment0.performFetchCompleteOnlyViews();
        genreArtistDetailFragment0.updateTabInfoList();
        genreArtistDetailFragment0.updateParallaxHeaderHeight();
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argGnrArtistSeq");
        if(s == null) {
            s = "";
        }
        this.mGnrArtistSeq = s;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argGnrArtistSeq", this.mGnrArtistSeq);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getTitleBar().a(B.a.s(0));
    }

    private final void updateHeader(ARTIST genreDetailArtistRes$RESPONSE$ARTIST0) {
        if(genreDetailArtistRes$RESPONSE$ARTIST0 != null) {
            TitleBar titleBar0 = this.getTitleBar();
            if(titleBar0 != null) {
                titleBar0.setTitleVisibility(true);
                titleBar0.setTitle(genreDetailArtistRes$RESPONSE$ARTIST0.getArtistName());
            }
            MelonImageView melonImageView0 = this.mBgIv;
            int v = 0;
            if(melonImageView0 != null) {
                melonImageView0.setCornerType(0);
                Glide.with(melonImageView0.getContext()).load(genreDetailArtistRes$RESPONSE$ARTIST0.getArtistImg()).apply(new RequestOptions().transform(new MelonBlurTransformation(melonImageView0.getContext()))).into(melonImageView0);
            }
            ViewUtils.showWhen(this.mArtistChannelLayout, "Y".equals(genreDetailArtistRes$RESPONSE$ARTIST0.artistChnlYn));
            ViewUtils.setOnClickListener(this.mArtistChannelLayout, new e(3, this, genreDetailArtistRes$RESPONSE$ARTIST0));
            TextView textView0 = this.mArtistTv;
            if(textView0 != null) {
                textView0.setText(genreDetailArtistRes$RESPONSE$ARTIST0.getArtistName());
            }
            TextView textView1 = this.mArtistDescTv;
            if(textView1 != null) {
                textView1.setText(Html.fromHtml(genreDetailArtistRes$RESPONSE$ARTIST0.artistRevw, 0));
                if(genreDetailArtistRes$RESPONSE$ARTIST0.artistRevw == null || o.H0(genreDetailArtistRes$RESPONSE$ARTIST0.artistRevw)) {
                    v = 1;
                }
                ViewUtils.showWhen(textView1, ((boolean)(1 ^ v)));
            }
            ViewUtils.setOnClickListener(this.mOpenIv, new com.iloen.melon.fragments.genre.h(genreDetailArtistRes$RESPONSE$ARTIST0, 1));
            new Handler(Looper.getMainLooper()).postDelayed(new d(this), 50L);
            BorderImageView borderImageView0 = this.mProfileImageIv;
            if(borderImageView0 != null) {
                Glide.with(borderImageView0.getContext()).load(genreDetailArtistRes$RESPONSE$ARTIST0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
            }
        }
    }

    private static final void updateHeader$lambda$4(GenreArtistDetailFragment genreArtistDetailFragment0, ARTIST genreDetailArtistRes$RESPONSE$ARTIST0, View view0) {
        genreArtistDetailFragment0.showArtistInfoPage(genreDetailArtistRes$RESPONSE$ARTIST0.getArtistId());
    }

    private static final void updateHeader$lambda$7(ARTIST genreDetailArtistRes$RESPONSE$ARTIST0, View view0) {
        com.iloen.melon.fragments.genre.GenreArtistPopupFragment.Companion genreArtistPopupFragment$Companion0 = GenreArtistPopupFragment.Companion;
        String s = genreDetailArtistRes$RESPONSE$ARTIST0.getArtistName();
        if(s == null) {
            s = "";
        }
        String s1 = genreDetailArtistRes$RESPONSE$ARTIST0.artistRevw;
        q.f(s1, "artistRevw");
        genreArtistPopupFragment$Companion0.newInstance(s, s1).open();
    }

    private static final void updateHeader$lambda$8(GenreArtistDetailFragment genreArtistDetailFragment0) {
        boolean z = ViewUtils.isTextViewEllipsis(genreArtistDetailFragment0.mArtistDescTv);
        ViewUtils.showWhen(genreArtistDetailFragment0.mOpenIv, z);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void updateHeaderRatio(float f) {
        super.updateHeaderRatio(f);
        View view0 = this.mCenterLayout;
        if(view0 != null) {
            view0.setAlpha(this.getAlphaValue(f));
        }
        View view1 = this.mArtistChannelLayout;
        if(view1 != null) {
            view1.setAlpha(this.getAlphaValue(f));
        }
    }

    private final void updateTabInfoList() {
        ArrayList arrayList0 = new ArrayList();
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
        arrayList0.add(tabInfo0);
        this.updateTabInfoList(arrayList0);
    }
}

