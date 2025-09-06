package com.iloen.melon.fragments.genre;

import Gd.f;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.DetailTabPagerBaseFragment;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.GenreLabelDetailReq;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.Navigator;
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

@Metadata(d1 = {"\u0000\u00A6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0002\u00A2\u0006\u0004\b\u000B\u0010\u0003J\u000F\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0013\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\'\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\fH\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0017\u0010\u001E\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0017\u0010!\u001A\u00020\b2\u0006\u0010 \u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b!\u0010\u001FJ\u0017\u0010$\u001A\u00020\u000F2\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b$\u0010%J\u0017\u0010&\u001A\u00020\u000F2\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b&\u0010%J\u0017\u0010\'\u001A\u00020\u000F2\u0006\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b\'\u0010%J\u000F\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020(H\u0014\u00A2\u0006\u0004\b+\u0010*J\u001D\u0010/\u001A\b\u0012\u0002\b\u0003\u0018\u00010.2\u0006\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b/\u00100J\u0011\u00102\u001A\u0004\u0018\u000101H\u0014\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b4\u00105J\u000F\u00106\u001A\u00020(H\u0014\u00A2\u0006\u0004\b6\u0010*J\u0017\u00109\u001A\u00020\b2\u0006\u00108\u001A\u000207H\u0014\u00A2\u0006\u0004\b9\u0010:J!\u0010?\u001A\u00020>2\b\u0010<\u001A\u0004\u0018\u00010;2\u0006\u0010=\u001A\u00020(H\u0014\u00A2\u0006\u0004\b?\u0010@R\u0016\u0010A\u001A\u00020\f8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001A\u00020C8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001A\u00020F8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010I\u001A\u00020F8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bI\u0010HR\u0016\u0010J\u001A\u00020\u000F8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001A\u00020L8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010P\u001A\u00020O8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bP\u0010Q\u00A8\u0006S"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelFragment;", "Lcom/iloen/melon/fragments/DetailTabPagerBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO;", "fetchData", "()Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO;", "res", "Lie/H;", "updateHeaderView", "(Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO;)V", "updateTabInfoList", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "createTopHeaderView", "(Landroid/view/LayoutInflater;)Landroid/view/View;", "createBottomHeaderView", "createImageHeaderView", "", "getTopHeaderHeight", "()I", "getBottomHeaderHeight", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "disableSwipeable", "()Z", "getTabHeight", "", "ratio", "updateHeaderRatio", "(F)V", "Lcom/iloen/melon/custom/tablayout/TabInfo;", "tabInfo", "position", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "makeTabFragment", "(Lcom/iloen/melon/custom/tablayout/TabInfo;I)Lcom/iloen/melon/fragments/MelonBaseFragment;", "labelSeq", "Ljava/lang/String;", "Lcom/iloen/melon/custom/MelonImageView;", "ivBg", "Lcom/iloen/melon/custom/MelonImageView;", "Lcom/iloen/melon/custom/MelonTextView;", "tvLabelTitle", "Lcom/iloen/melon/custom/MelonTextView;", "tvLabelDesc", "centerLayout", "Landroid/view/View;", "Lcom/iloen/melon/custom/BorderImageView;", "ivProfile", "Lcom/iloen/melon/custom/BorderImageView;", "Landroid/widget/ImageView;", "ivTitleArrow", "Landroid/widget/ImageView;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GenreDetailLabelFragment extends DetailTabPagerBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_LABEL_SEQ", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreDetailLabelFragment;", "labelSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreDetailLabelFragment newInstance(@NotNull String s) {
            q.g(s, "labelSeq");
            GenreDetailLabelFragment genreDetailLabelFragment0 = new GenreDetailLabelFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argLabelSeq", s);
            genreDetailLabelFragment0.setArguments(bundle0);
            return genreDetailLabelFragment0;
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_LABEL_SEQ;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String TAG;
    private View centerLayout;
    private MelonImageView ivBg;
    private BorderImageView ivProfile;
    private ImageView ivTitleArrow;
    @NotNull
    private String labelSeq;
    private MelonTextView tvLabelDesc;
    private MelonTextView tvLabelTitle;

    static {
        GenreDetailLabelFragment.Companion = new Companion(null);
        GenreDetailLabelFragment.$stable = 8;
        GenreDetailLabelFragment.TAG = "GenreDetailLabelFragment";
        GenreDetailLabelFragment.ARG_LABEL_SEQ = "argLabelSeq";
    }

    public GenreDetailLabelFragment() {
        this.labelSeq = "";
    }

    public static final String access$getARG_LABEL_SEQ$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @NotNull
    public View createBottomHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02E7, null, false);  // layout:genre_label_bottom_header
        View view1 = view0.findViewById(0x7F0A0D34);  // id:tv_title
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        this.tvLabelTitle = (MelonTextView)view1;
        View view2 = view0.findViewById(0x7F0A0C96);  // id:tv_label_desc
        q.e(view2, "null cannot be cast to non-null type com.iloen.melon.custom.MelonTextView");
        this.tvLabelDesc = (MelonTextView)view2;
        View view3 = view0.findViewById(0x7F0A06AA);  // id:iv_title_arrow
        q.f(view3, "findViewById(...)");
        this.ivTitleArrow = (ImageView)view3;
        return view0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @NotNull
    public View createImageHeaderView(@NotNull LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D02E8, null, false);  // layout:genre_label_image_header
        View view1 = view0.findViewById(0x7F0A023E);  // id:center_layout
        q.f(view1, "findViewById(...)");
        this.centerLayout = view1;
        View view2 = view0.findViewById(0x7F0A023D);  // id:center_img_layout
        View view3 = view2.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
        q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
        ViewUtils.setDefaultImage(((ImageView)view3), ScreenUtils.dipToPixel(this.getContext(), 86.0f), false);
        View view4 = view2.findViewById(0x7F0A069B);  // id:iv_thumb_circle
        q.e(view4, "null cannot be cast to non-null type com.iloen.melon.custom.BorderImageView");
        this.ivProfile = (BorderImageView)view4;
        ((BorderImageView)view4).setBorderWidth(0);
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
        View view0 = layoutInflater0.inflate(0x7F0D02EC, null, false);  // layout:genre_label_top_header
        View view1 = view0.findViewById(0x7F0A0105);  // id:bg_iv
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.MelonImageView");
        this.ivBg = (MelonImageView)view1;
        return view0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public boolean disableSwipeable() {
        return true;
    }

    public static void f0(View view0) {
    }

    private final LABELINFO fetchData() {
        Cursor cursor0 = a.f(this.getContext(), this.getCacheKey());
        if(cursor0 == null) {
            LogU.Companion.w("GenreDetailLabelFragment", "fetchData() invalid cursor");
            return null;
        }
        GenreLabelDetailRes genreLabelDetailRes0 = (GenreLabelDetailRes)a.d(cursor0, GenreLabelDetailRes.class);
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        RESPONSE genreLabelDetailRes$RESPONSE0 = genreLabelDetailRes0.response;
        if(genreLabelDetailRes$RESPONSE0 == null) {
            LogU.Companion.w("GenreDetailLabelFragment", "fetchData() failed to extract contents");
            return null;
        }
        return genreLabelDetailRes$RESPONSE0.labelInfo;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getBottomHeaderHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 151.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.B0.buildUpon(), this.labelSeq, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTabHeight() {
        return 0;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public int getTopHeaderHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 156.0f);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    @NotNull
    public MelonBaseFragment makeTabFragment(@Nullable TabInfo tabInfo0, int v) {
        String s = this.labelSeq;
        String s1 = this.getCacheKey();
        return GenreDetailLabelBottomFragment.Companion.newInstance(s, s1);
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
            RequestBuilder.newInstance(new GenreLabelDetailReq(this.getContext(), this.labelSeq)).tag("GenreDetailLabelFragment").listener(new c(this, 3)).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.updateHeaderView(this.fetchData());
        this.updateTabInfoList();
        return false;
    }

    private static final void onFetchStart$lambda$0(GenreDetailLabelFragment genreDetailLabelFragment0, GenreLabelDetailRes genreLabelDetailRes0) {
        LABELINFO genreLabelDetailRes$RESPONSE$LABELINFO0;
        if(!genreDetailLabelFragment0.prepareFetchComplete(genreLabelDetailRes0)) {
            return;
        }
        a.a(genreDetailLabelFragment0.getContext(), genreLabelDetailRes0, genreDetailLabelFragment0.getCacheKey());
        if(genreLabelDetailRes0 == null) {
            genreLabelDetailRes$RESPONSE$LABELINFO0 = null;
        }
        else {
            RESPONSE genreLabelDetailRes$RESPONSE0 = genreLabelDetailRes0.response;
            genreLabelDetailRes$RESPONSE$LABELINFO0 = genreLabelDetailRes$RESPONSE0 == null ? null : genreLabelDetailRes$RESPONSE0.labelInfo;
        }
        if(genreLabelDetailRes$RESPONSE$LABELINFO0 != null) {
            genreDetailLabelFragment0.updateHeaderView(genreLabelDetailRes0.response.labelInfo);
        }
        genreDetailLabelFragment0.performFetchCompleteOnlyViews();
        genreDetailLabelFragment0.updateTabInfoList();
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argLabelSeq");
        if(s == null) {
            s = "";
        }
        this.labelSeq = s;
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argLabelSeq", this.labelSeq);
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(0));
        }
    }

    @Override  // com.iloen.melon.fragments.DetailTabPagerBaseFragment
    public void updateHeaderRatio(float f) {
        super.updateHeaderRatio(f);
        View view0 = this.centerLayout;
        if(view0 != null) {
            view0.setAlpha(this.getAlphaValue(f));
            return;
        }
        q.m("centerLayout");
        throw null;
    }

    private final void updateHeaderView(LABELINFO genreLabelDetailRes$RESPONSE$LABELINFO0) {
        if(genreLabelDetailRes$RESPONSE$LABELINFO0 != null) {
            TitleBar titleBar0 = this.getTitleBar();
            if(titleBar0 != null) {
                titleBar0.setTitle(genreLabelDetailRes$RESPONSE$LABELINFO0.labelName);
            }
            MelonTextView melonTextView0 = this.tvLabelTitle;
            if(melonTextView0 != null) {
                ViewUtils.setText(melonTextView0, genreLabelDetailRes$RESPONSE$LABELINFO0.labelName);
                MelonTextView melonTextView1 = this.tvLabelDesc;
                if(melonTextView1 != null) {
                    ViewUtils.setText(melonTextView1, genreLabelDetailRes$RESPONSE$LABELINFO0.labelIntrod);
                    ImageView imageView0 = this.ivTitleArrow;
                    if(imageView0 != null) {
                        ViewUtils.hideWhen(imageView0, TextUtils.isEmpty(genreLabelDetailRes$RESPONSE$LABELINFO0.brandPageUrl));
                        MelonImageView melonImageView0 = this.ivBg;
                        if(melonImageView0 != null) {
                            melonImageView0.setCornerType(0);
                            MelonImageView melonImageView1 = this.ivBg;
                            if(melonImageView1 != null) {
                                com.bumptech.glide.RequestBuilder requestBuilder0 = Glide.with(melonImageView1.getContext()).load(genreLabelDetailRes$RESPONSE$LABELINFO0.bgImgUrl);
                                MelonImageView melonImageView2 = this.ivBg;
                                if(melonImageView2 != null) {
                                    requestBuilder0.into(melonImageView2);
                                    BorderImageView borderImageView0 = this.ivProfile;
                                    if(borderImageView0 != null) {
                                        com.bumptech.glide.RequestBuilder requestBuilder1 = Glide.with(borderImageView0.getContext()).load(genreLabelDetailRes$RESPONSE$LABELINFO0.logoImgUrl).apply(RequestOptions.circleCropTransform());
                                        BorderImageView borderImageView1 = this.ivProfile;
                                        if(borderImageView1 != null) {
                                            requestBuilder1.into(borderImageView1);
                                            MelonTextView melonTextView2 = this.tvLabelTitle;
                                            if(melonTextView2 != null) {
                                                ViewUtils.setOnClickListener(melonTextView2, new f(5));
                                                MelonTextView melonTextView3 = this.tvLabelDesc;
                                                if(melonTextView3 != null) {
                                                    ViewUtils.setOnClickListener(melonTextView3, new com.iloen.melon.fragments.genre.h(this, 2));
                                                    return;
                                                }
                                                q.m("tvLabelDesc");
                                                throw null;
                                            }
                                            q.m("tvLabelTitle");
                                            throw null;
                                        }
                                        q.m("ivProfile");
                                        throw null;
                                    }
                                    q.m("ivProfile");
                                    throw null;
                                }
                                q.m("ivBg");
                                throw null;
                            }
                            q.m("ivBg");
                            throw null;
                        }
                        q.m("ivBg");
                        throw null;
                    }
                    q.m("ivTitleArrow");
                    throw null;
                }
                q.m("tvLabelDesc");
                throw null;
            }
            q.m("tvLabelTitle");
            throw null;
        }
    }

    private static final void updateHeaderView$lambda$1(View view0) {
    }

    private static final void updateHeaderView$lambda$2(GenreDetailLabelFragment genreDetailLabelFragment0, View view0) {
        Navigator.open(GenreDetailLabelIntroFragment.Companion.newInstance(genreDetailLabelFragment0.labelSeq));
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

