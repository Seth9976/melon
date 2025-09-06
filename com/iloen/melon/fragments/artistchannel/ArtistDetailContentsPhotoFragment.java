package com.iloen.melon.fragments.artistchannel;

import B9.e;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.Q0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailGridLayoutManager;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.DetailPhotoSpanSizeLookup;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoInfoList;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment.PhotoItem;
import com.iloen.melon.fragments.detail.PhotoDetailViewFragment;
import com.iloen.melon.fragments.detail.PhotoGridSpacingItemDecoration;
import com.iloen.melon.fragments.detail.PhotoGridSpacingItemDecorationKt;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsPhotoItemHolder.PhotoActionListener;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsPhotoItemHolder;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.net.v6x.request.ArtistContentsPhotoListReq.Params;
import com.iloen.melon.net.v6x.request.ArtistContentsPhotoListReq;
import com.iloen.melon.net.v6x.response.ArtistContentsPhotoListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistContentsPhotoListRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import e.k;
import ie.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import p8.s;
import v9.h;
import v9.i;
import z6.f;

@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\b\t*\u0001F\b\u0007\u0018\u0000 L2\u00020\u0001:\u0002LMB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\r\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\r\u0010\u000BJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\t2\u0006\u0010\u0012\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\b\u0010\u0019\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u001B\u0010\u001CJ!\u0010\u001E\u001A\u00020\t2\u0006\u0010\u001D\u001A\u00020\u001A2\b\u0010\u0019\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u001B\u0010&\u001A\u0006\u0012\u0002\b\u00030%2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010\'J-\u0010-\u001A\u00020\u00042\b\u0010)\u001A\u0004\u0018\u00010(2\b\u0010+\u001A\u0004\u0018\u00010*2\b\u0010,\u001A\u0004\u0018\u00010\u000EH\u0014\u00A2\u0006\u0004\b-\u0010.J\u000F\u0010/\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b/\u0010\u0003J\u0013\u00101\u001A\u00020\u000E*\u000200H\u0002\u00A2\u0006\u0004\b1\u00102R\u0016\u00103\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00104R\u0016\u00106\u001A\u0002008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u00107R\u001C\u0010:\u001A\b\u0012\u0004\u0012\u000209088\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001A\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R)\u0010E\u001A\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u000E0\u000E0?8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bA\u0010B\u001A\u0004\bC\u0010DR\u0014\u0010G\u001A\u00020F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010K\u001A\u0002008BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bI\u0010J\u00A8\u0006N"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsPhotoFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "hasScrolledLine", "()Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "updateSpanCount", "", "asOrder", "(I)Ljava/lang/String;", "artistId", "Ljava/lang/String;", "artistName", "filterType", "I", "", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem;", "photos", "Ljava/util/List;", "Lcom/iloen/melon/custom/DetailGridLayoutManager;", "layoutManager", "Lcom/iloen/melon/custom/DetailGridLayoutManager;", "", "kotlin.jvm.PlatformType", "filterList$delegate", "Lie/j;", "getFilterList", "()Ljava/util/List;", "filterList", "com/iloen/melon/fragments/artistchannel/ArtistDetailContentsPhotoFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsPhotoFragment$actionListener$1;", "getSpanCount", "()I", "spanCount", "Companion", "PhotoAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailContentsPhotoFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsPhotoFragment$Companion;", "", "<init>", "()V", "TAG", "", "FILTER_NEW", "", "FILTER_POP", "VIEW_TYPE_HEADER", "VIEW_TYPE_PHOTO", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsPhotoFragment;", "artistId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailContentsPhotoFragment newInstance(@Nullable String s) {
            ArtistDetailContentsPhotoFragment artistDetailContentsPhotoFragment0 = new ArtistDetailContentsPhotoFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argArtistId", s);
            artistDetailContentsPhotoFragment0.setArguments(bundle0);
            return artistDetailContentsPhotoFragment0;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001A\u001A\u00020\u00192\b\u0010\u0018\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsPhotoFragment$PhotoAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;", "actionListener", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailContentsPhotoFragment;Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class PhotoAdapter extends p {
        @NotNull
        private final PhotoActionListener actionListener;

        public PhotoAdapter(@Nullable Context context0, @Nullable List list0, @NotNull PhotoActionListener detailContentsPhotoItemHolder$PhotoActionListener0) {
            q.g(detailContentsPhotoItemHolder$PhotoActionListener0, "actionListener");
            ArtistDetailContentsPhotoFragment.this = artistDetailContentsPhotoFragment0;
            super(context0, list0);
            this.actionListener = detailContentsPhotoItemHolder$PhotoActionListener0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? 1 : 0;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof e) {
                List list0 = ArtistDetailContentsPhotoFragment.this.getFilterList();
                String s = (String)je.p.n0(ArtistDetailContentsPhotoFragment.this.filterType, list0);
                ((e)o00).b.setText(s);
                Object[] arr_object = {((e)o00).b.getText()};
                String s1 = ArtistDetailContentsPhotoFragment.this.getString(0x7F130BAF, arr_object);  // string:talkback_order_change "%1$s, 정렬기준 변경"
                ViewUtils.setContentDescriptionWithButtonClassName(((e)o00).b, s1);
                d d0 = new d(ArtistDetailContentsPhotoFragment.this, ((e)o00).b, this, 2);
                ((e)o00).b.setOnClickListener(d0);
                return;
            }
            if(o00 instanceof DetailContentsPhotoItemHolder) {
                ((DetailContentsPhotoItemHolder)o00).bind(((PHOTO)this.getItem(v1)), v1);
            }
        }

        private static final void onBindViewImpl$lambda$2(ArtistDetailContentsPhotoFragment artistDetailContentsPhotoFragment0, TextView textView0, PhotoAdapter artistDetailContentsPhotoFragment$PhotoAdapter0, View view0) {
            if(artistDetailContentsPhotoFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = artistDetailContentsPhotoFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(artistDetailContentsPhotoFragment0.getFilterList(), artistDetailContentsPhotoFragment0.filterType);
                    bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.artistchannel.e(artistDetailContentsPhotoFragment0, textView0, artistDetailContentsPhotoFragment$PhotoAdapter0, 2));
                    bottomSingleFilterListPopup0.setOnDismissListener(artistDetailContentsPhotoFragment0.mDialogDismissListener);
                    artistDetailContentsPhotoFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$2$lambda$1(ArtistDetailContentsPhotoFragment artistDetailContentsPhotoFragment0, TextView textView0, PhotoAdapter artistDetailContentsPhotoFragment$PhotoAdapter0, int v) {
            artistDetailContentsPhotoFragment0.filterType = v;
            String s = (String)je.p.n0(artistDetailContentsPhotoFragment0.filterType, artistDetailContentsPhotoFragment0.getFilterList());
            textView0.setText(s);
            ViewUtils.setContentDescriptionWithButtonClassName(textView0, artistDetailContentsPhotoFragment0.getString(0x7F130BAF, new Object[]{textView0.getText()}));  // string:talkback_order_change "%1$s, 정렬기준 변경"
            artistDetailContentsPhotoFragment0.startFetch("filter change");
            Context context0 = artistDetailContentsPhotoFragment$PhotoAdapter0.getContext();
            if(context0 != null && context0.getResources() != null) {
                g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                g0.I = artistDetailContentsPhotoFragment$PhotoAdapter0.getMenuId();
                g0.a = "페이지이동";
                s s1 = artistDetailContentsPhotoFragment0.mMelonTiaraProperty;
                String s2 = null;
                g0.b = s1 == null ? null : s1.a;
                s s3 = artistDetailContentsPhotoFragment0.mMelonTiaraProperty;
                if(s3 != null) {
                    s2 = s3.b;
                }
                g0.c = s2;
                g0.d = ActionKind.ClickContent;
                g0.y = "포토리스트";
                g0.F = s;
                g0.o = artistDetailContentsPhotoFragment0.artistId;
                g0.p = "아티스트";
                g0.q = artistDetailContentsPhotoFragment0.artistName;
                g0.a().track();
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == 0 ? f.p(viewGroup0, 9.0f, 2) : DetailContentsPhotoItemHolder.Companion.newInstance(viewGroup0, this.actionListener);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int FILTER_NEW = 0;
    private static final int FILTER_POP = 1;
    @NotNull
    private static final String TAG = "ArtistDetailContentsPhotoFragment";
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_PHOTO = 1;
    @NotNull
    private final com.iloen.melon.fragments.artistchannel.ArtistDetailContentsPhotoFragment.actionListener.1 actionListener;
    @NotNull
    private String artistId;
    @NotNull
    private String artistName;
    @NotNull
    private final j filterList$delegate;
    private int filterType;
    @Nullable
    private DetailGridLayoutManager layoutManager;
    @NotNull
    private List photos;

    static {
        ArtistDetailContentsPhotoFragment.Companion = new Companion(null);
        ArtistDetailContentsPhotoFragment.$stable = 8;
    }

    public ArtistDetailContentsPhotoFragment() {
        this.artistId = "";
        this.artistName = "";
        this.photos = new ArrayList();
        this.filterList$delegate = d3.g.Q(new a(this, 2));
        this.actionListener = new PhotoActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsPhotoItemHolder$PhotoActionListener
            public void onClickPhoto(PHOTO detailBaseRes$PHOTO0, int v) {
                if(!ArtistDetailContentsPhotoFragment.this.photos.isEmpty()) {
                    j0 j00 = ArtistDetailContentsPhotoFragment.this.mAdapter;
                    q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsPhotoFragment.PhotoAdapter");
                    boolean z = ((PhotoAdapter)j00).hasMore();
                    PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = PhotoInfoList.Companion.buildArtistInfoParams(ArtistDetailContentsPhotoFragment.this.photos, z, v, ArtistDetailContentsPhotoFragment.this.photos.size(), ArtistDetailContentsPhotoFragment.this.asOrder(ArtistDetailContentsPhotoFragment.this.filterType));
                    Navigator.open(com.iloen.melon.fragments.detail.PhotoDetailViewFragment.Companion.newInstance$default(PhotoDetailViewFragment.Companion, photoDetailViewFragment$PhotoInfoList0, false, false, 6, null));
                    g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
                    g0.I = ArtistDetailContentsPhotoFragment.this.getMenuId();
                    g0.a = ArtistDetailContentsPhotoFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    s s0 = ArtistDetailContentsPhotoFragment.this.mMelonTiaraProperty;
                    String s1 = null;
                    g0.b = s0 == null ? null : s0.a;
                    s s2 = ArtistDetailContentsPhotoFragment.this.mMelonTiaraProperty;
                    g0.c = s2 == null ? null : s2.b;
                    g0.d = ActionKind.ClickContent;
                    g0.y = ArtistDetailContentsPhotoFragment.this.getString(0x7F130E04);  // string:tiara_common_layer1_photo_list "포토리스트"
                    g0.C = String.valueOf(v + 1);
                    if(detailBaseRes$PHOTO0 != null) {
                        s1 = detailBaseRes$PHOTO0.photoId;
                    }
                    g0.e = s1;
                    g0.f = Y.i(ContsTypeCode.PHOTO, "code(...)");
                    g0.h = ArtistDetailContentsPhotoFragment.this.artistName;
                    g0.o = ArtistDetailContentsPhotoFragment.this.artistId;
                    g0.p = ArtistDetailContentsPhotoFragment.this.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
                    g0.q = ArtistDetailContentsPhotoFragment.this.artistName;
                    g0.a().track();
                }
            }
        };
    }

    private final String asOrder(int v) {
        return v == 1 ? "POP" : "NEW";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new PhotoAdapter(this, context0, null, this.actionListener);
    }

    private static final List filterList_delegate$lambda$0(ArtistDetailContentsPhotoFragment artistDetailContentsPhotoFragment0) {
        String[] arr_s;
        Context context0 = artistDetailContentsPhotoFragment0.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F030003);  // array:artist_channel_basic_tab_order
        }
        return arr_s != null ? k.A(Arrays.copyOf(arr_s, arr_s.length)) : w.a;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.b.buildUpon().appendPath("CACHE_KEY_PHOTO").appendPath(this.artistId).appendQueryParameter("filterType", String.valueOf(this.filterType)).build().toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final List getFilterList() {
        return (List)this.filterList$delegate.getValue();
    }

    private final int getSpanCount() {
        return PhotoGridSpacingItemDecorationKt.getPhotoSpanCount(this.getContext());
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @NotNull
    public static final ArtistDetailContentsPhotoFragment newInstance(@Nullable String s) {
        return ArtistDetailContentsPhotoFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        this.updateSpanCount();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        DetailGridLayoutManager detailGridLayoutManager0 = new DetailGridLayoutManager(((RecyclerView)view0).getContext(), this.getSpanCount());
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsPhotoFragment.PhotoAdapter");
        detailGridLayoutManager0.g = new DetailPhotoSpanSizeLookup(detailGridLayoutManager0, ((PhotoAdapter)j00));
        this.layoutManager = detailGridLayoutManager0;
        ((RecyclerView)view0).setLayoutManager(detailGridLayoutManager0);
        ((RecyclerView)view0).addItemDecoration(new PhotoGridSpacingItemDecoration());
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAccessibilityDelegateCompat(new Q0(/*ERROR_MISSING_ARG_0/*) {
            @Override  // androidx.recyclerview.widget.Q0
            public void onInitializeAccessibilityNodeInfo(View view0, d2.d d0) {
                q.g(view0, "host");
                q.g(d0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, d0);
                d0.m(null);
            }
        });
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0206, null, false);  // layout:detail_contents_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailContentsPhotoFragment.PhotoAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((PhotoAdapter)j00).clear();
            this.photos.clear();
        }
        Params artistContentsPhotoListReq$Params0 = new Params();
        artistContentsPhotoListReq$Params0.artistId = this.artistId;
        artistContentsPhotoListReq$Params0.startIndex = i1.equals(i0) ? 1 : ((PhotoAdapter)j00).getCount() + 1;
        artistContentsPhotoListReq$Params0.pageSize = 100;
        artistContentsPhotoListReq$Params0.orderBy = this.asOrder(this.filterType);
        RequestBuilder.newInstance(new ArtistContentsPhotoListReq(this.getContext(), artistContentsPhotoListReq$Params0)).tag(this.getRequestTag()).listener(new c(7, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$6(ArtistDetailContentsPhotoFragment artistDetailContentsPhotoFragment0, i i0, ArtistContentsPhotoListRes artistContentsPhotoListRes0) {
        if(!artistDetailContentsPhotoFragment0.prepareFetchComplete(artistContentsPhotoListRes0)) {
            return;
        }
        RESPONSE artistContentsPhotoListRes$RESPONSE0 = artistContentsPhotoListRes0.response;
        artistDetailContentsPhotoFragment0.mMelonTiaraProperty = new s(artistContentsPhotoListRes$RESPONSE0.section, artistContentsPhotoListRes$RESPONSE0.page, artistContentsPhotoListRes$RESPONSE0.menuId, null);
        String s = artistContentsPhotoListRes$RESPONSE0.artistName;
        q.f(s, "artistName");
        artistDetailContentsPhotoFragment0.artistName = s;
        Collection collection0 = artistContentsPhotoListRes0.getItems();
        if(collection0 != null) {
            for(Object object0: collection0) {
                artistDetailContentsPhotoFragment0.photos.add(new PhotoItem(((PHOTO)object0).photoId, artistDetailContentsPhotoFragment0.artistId, null, null, null, 16, null));
            }
        }
        artistDetailContentsPhotoFragment0.performFetchComplete(i0, artistContentsPhotoListRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.artistId = l1.g(bundle0, "inState", "argArtistId", "", "getString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F13012B));  // string:artist_detail_contents_photo_title "포토"
        }
    }

    private final void updateSpanCount() {
        DetailGridLayoutManager detailGridLayoutManager0 = this.layoutManager;
        if(detailGridLayoutManager0 != null) {
            detailGridLayoutManager0.P(this.getSpanCount());
        }
        this.mAdapter.notifyDataSetChanged();
    }
}

