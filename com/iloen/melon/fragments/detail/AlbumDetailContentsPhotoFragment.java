package com.iloen.melon.fragments.detail;

import B9.e;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailGridLayoutManager;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsPhotoItemHolder.PhotoActionListener;
import com.iloen.melon.fragments.detail.viewholder.DetailContentsPhotoItemHolder;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.net.v6x.request.AlbumContentsPhotoReq.Params;
import com.iloen.melon.net.v6x.request.AlbumContentsPhotoReq;
import com.iloen.melon.net.v6x.response.AlbumContentsPhotoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.AlbumContentsPhotoRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import d3.g;
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
import p8.f;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000\u009B\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001F\b\u0007\u0018\u0000 P2\u00020\u0001:\u0002PQB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0013\u0010\b\u001A\u00020\u0007*\u00020\u0006H\u0002\u00A2\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0010J\u000F\u0010\u0013\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\u0006\u0010\u001A\u001A\u00020\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001D\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u001F\u0010 J!\u0010\"\u001A\u00020\u00042\u0006\u0010!\u001A\u00020\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\"\u0010#J\u000F\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b%\u0010&J\u001B\u0010*\u001A\u0006\u0012\u0002\b\u00030)2\u0006\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b*\u0010+J-\u00101\u001A\u00020\n2\b\u0010-\u001A\u0004\u0018\u00010,2\b\u0010/\u001A\u0004\u0018\u00010.2\b\u00100\u001A\u0004\u0018\u00010\u0007H\u0014\u00A2\u0006\u0004\b1\u00102R\u0016\u00103\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00104R\u0016\u00106\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u00107R\u001C\u0010:\u001A\b\u0012\u0004\u0012\u000209088\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010=\u001A\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010>R)\u0010E\u001A\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u00070\u00070?8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bA\u0010B\u001A\u0004\bC\u0010DR\u0014\u0010G\u001A\u00020F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010K\u001A\u00020\u00068BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bI\u0010JR\u0014\u0010O\u001A\u00020L8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bM\u0010N\u00A8\u0006R"}, d2 = {"Lcom/iloen/melon/fragments/detail/AlbumDetailContentsPhotoFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "updateSpanCount", "", "", "asOrder", "(I)Ljava/lang/String;", "", "hasScrolledLine", "()Z", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "getCacheKey", "()Ljava/lang/String;", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "albumId", "Ljava/lang/String;", "pageMetaName", "filterType", "I", "", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment$PhotoItem;", "photos", "Ljava/util/List;", "Lcom/iloen/melon/custom/DetailGridLayoutManager;", "layoutManager", "Lcom/iloen/melon/custom/DetailGridLayoutManager;", "", "kotlin.jvm.PlatformType", "filterList$delegate", "Lie/j;", "getFilterList", "()Ljava/util/List;", "filterList", "com/iloen/melon/fragments/detail/AlbumDetailContentsPhotoFragment$actionListener$1", "actionListener", "Lcom/iloen/melon/fragments/detail/AlbumDetailContentsPhotoFragment$actionListener$1;", "getSpanCount", "()I", "spanCount", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "PhotoAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class AlbumDetailContentsPhotoFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000B\u001A\u00020\f2\b\u0010\r\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/detail/AlbumDetailContentsPhotoFragment$Companion;", "", "<init>", "()V", "TAG", "", "FILTER_NEW", "", "FILTER_ARTIST", "VIEW_TYPE_HEADER", "VIEW_TYPE_PHOTO", "newInstance", "Lcom/iloen/melon/fragments/detail/AlbumDetailContentsPhotoFragment;", "albumId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final AlbumDetailContentsPhotoFragment newInstance(@Nullable String s) {
            AlbumDetailContentsPhotoFragment albumDetailContentsPhotoFragment0 = new AlbumDetailContentsPhotoFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argAlbumId", s);
            albumDetailContentsPhotoFragment0.setArguments(bundle0);
            return albumDetailContentsPhotoFragment0;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B)\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001A\u001A\u00020\u00192\b\u0010\u0018\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000F\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\fH\u0016¢\u0006\u0004\b\u001A\u0010\u001BR\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/detail/AlbumDetailContentsPhotoFragment$PhotoAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;", "actionListener", "<init>", "(Lcom/iloen/melon/fragments/detail/AlbumDetailContentsPhotoFragment;Landroid/content/Context;Ljava/util/List;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class PhotoAdapter extends p {
        @NotNull
        private final PhotoActionListener actionListener;

        public PhotoAdapter(@Nullable Context context0, @Nullable List list0, @NotNull PhotoActionListener detailContentsPhotoItemHolder$PhotoActionListener0) {
            q.g(detailContentsPhotoItemHolder$PhotoActionListener0, "actionListener");
            AlbumDetailContentsPhotoFragment.this = albumDetailContentsPhotoFragment0;
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
                List list0 = AlbumDetailContentsPhotoFragment.this.getFilterList();
                String s = (String)je.p.n0(AlbumDetailContentsPhotoFragment.this.filterType, list0);
                ((e)o00).b.setText(s);
                d d0 = new d(AlbumDetailContentsPhotoFragment.this, ((e)o00), v1);
                ((e)o00).b.setOnClickListener(d0);
                return;
            }
            if(o00 instanceof DetailContentsPhotoItemHolder) {
                ((DetailContentsPhotoItemHolder)o00).bind(((PHOTO)this.getItem(v1)), v1);
            }
        }

        private static final void onBindViewImpl$lambda$1(AlbumDetailContentsPhotoFragment albumDetailContentsPhotoFragment0, O0 o00, int v, View view0) {
            if(albumDetailContentsPhotoFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = albumDetailContentsPhotoFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(albumDetailContentsPhotoFragment0.getFilterList(), albumDetailContentsPhotoFragment0.filterType);
                    bottomSingleFilterListPopup0.setFilterListener(new c(albumDetailContentsPhotoFragment0, o00, v));
                    bottomSingleFilterListPopup0.setOnDismissListener(albumDetailContentsPhotoFragment0.mDialogDismissListener);
                    albumDetailContentsPhotoFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$1$lambda$0(AlbumDetailContentsPhotoFragment albumDetailContentsPhotoFragment0, O0 o00, int v, int v1) {
            albumDetailContentsPhotoFragment0.filterType = v1;
            String s = (String)je.p.n0(albumDetailContentsPhotoFragment0.filterType, albumDetailContentsPhotoFragment0.getFilterList());
            ((e)o00).b.setText(s);
            albumDetailContentsPhotoFragment0.startFetch("filter change");
            f f0 = albumDetailContentsPhotoFragment0.getBaseTiaraLogEventBuilder();
            f0.a = albumDetailContentsPhotoFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = albumDetailContentsPhotoFragment0.getString(0x7F130E04);  // string:tiara_common_layer1_photo_list "포토리스트"
            f0.C = String.valueOf(v + 1);
            f0.F = s;
            f0.a().track();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == 0 ? z6.f.p(viewGroup0, 9.0f, 2) : DetailContentsPhotoItemHolder.Companion.newInstance(viewGroup0, this.actionListener);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int FILTER_ARTIST = 1;
    private static final int FILTER_NEW = 0;
    @NotNull
    private static final String TAG = "AlbumDetailContentsPhotoFragment";
    private static final int VIEW_TYPE_HEADER = 0;
    private static final int VIEW_TYPE_PHOTO = 1;
    @NotNull
    private final com.iloen.melon.fragments.detail.AlbumDetailContentsPhotoFragment.actionListener.1 actionListener;
    @NotNull
    private String albumId;
    @NotNull
    private final j filterList$delegate;
    private int filterType;
    @Nullable
    private DetailGridLayoutManager layoutManager;
    @NotNull
    private String pageMetaName;
    @NotNull
    private List photos;

    static {
        AlbumDetailContentsPhotoFragment.Companion = new Companion(null);
        AlbumDetailContentsPhotoFragment.$stable = 8;
    }

    public AlbumDetailContentsPhotoFragment() {
        this.albumId = "";
        this.pageMetaName = "";
        this.photos = new ArrayList();
        this.filterList$delegate = g.Q(new b(this, 0));
        this.actionListener = new PhotoActionListener() {
            @Override  // com.iloen.melon.fragments.detail.viewholder.DetailContentsPhotoItemHolder$PhotoActionListener
            public void onClickPhoto(PHOTO detailBaseRes$PHOTO0, int v) {
                if(!AlbumDetailContentsPhotoFragment.this.photos.isEmpty()) {
                    j0 j00 = AlbumDetailContentsPhotoFragment.this.mAdapter;
                    q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.AlbumDetailContentsPhotoFragment.PhotoAdapter");
                    boolean z = ((PhotoAdapter)j00).hasMore();
                    PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = PhotoInfoList.Companion.buildAlbumInfoParams(AlbumDetailContentsPhotoFragment.this.photos, z, v, AlbumDetailContentsPhotoFragment.this.photos.size(), AlbumDetailContentsPhotoFragment.this.asOrder(AlbumDetailContentsPhotoFragment.this.filterType));
                    Navigator.open(com.iloen.melon.fragments.detail.PhotoDetailViewFragment.Companion.newInstance$default(PhotoDetailViewFragment.Companion, photoDetailViewFragment$PhotoInfoList0, false, false, 6, null));
                    f f0 = AlbumDetailContentsPhotoFragment.this.getBaseTiaraLogEventBuilder();
                    f0.a = AlbumDetailContentsPhotoFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = AlbumDetailContentsPhotoFragment.this.getString(0x7F130E04);  // string:tiara_common_layer1_photo_list "포토리스트"
                    f0.C = String.valueOf(v + 1);
                    String s = null;
                    f0.e = detailBaseRes$PHOTO0 == null ? null : detailBaseRes$PHOTO0.photoId;
                    f0.f = Y.i(ContsTypeCode.PHOTO, "code(...)");
                    if(detailBaseRes$PHOTO0 != null) {
                        s = detailBaseRes$PHOTO0.getArtistName();
                    }
                    f0.h = s;
                    f0.a().track();
                }
            }
        };
    }

    private final String asOrder(int v) {
        return v == 1 ? "ARTIST" : "NEW";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new PhotoAdapter(this, context0, null, this.actionListener);
    }

    private static final List filterList_delegate$lambda$0(AlbumDetailContentsPhotoFragment albumDetailContentsPhotoFragment0) {
        String[] arr_s;
        Context context0 = albumDetailContentsPhotoFragment0.getContext();
        if(context0 == null) {
            arr_s = null;
        }
        else {
            Resources resources0 = context0.getResources();
            arr_s = resources0 == null ? null : resources0.getStringArray(0x7F030000);  // array:album_detail_contents_photo_sort_type
        }
        return arr_s != null ? k.A(Arrays.copyOf(arr_s, arr_s.length)) : w.a;
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
        f0.I = this.getMenuId();
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.o = this.albumId;
        f0.p = this.getString(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
        f0.q = this.pageMetaName;
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.a.buildUpon().appendPath("CACHE_KEY_PHOTO").appendPath(this.albumId).appendQueryParameter("filterType", String.valueOf(this.filterType)).build().toString();
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
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.AlbumDetailContentsPhotoFragment.PhotoAdapter");
        detailGridLayoutManager0.g = new DetailPhotoSpanSizeLookup(detailGridLayoutManager0, ((PhotoAdapter)j00));
        this.layoutManager = detailGridLayoutManager0;
        ((RecyclerView)view0).setLayoutManager(detailGridLayoutManager0);
        ((RecyclerView)view0).addItemDecoration(new PhotoGridSpacingItemDecoration());
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(true);
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
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.detail.AlbumDetailContentsPhotoFragment.PhotoAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((PhotoAdapter)j00).clear();
            this.photos.clear();
        }
        Params albumContentsPhotoReq$Params0 = new Params();
        albumContentsPhotoReq$Params0.albumId = this.albumId;
        albumContentsPhotoReq$Params0.startIndex = i1.equals(i0) ? 1 : ((PhotoAdapter)j00).getCount() + 1;
        albumContentsPhotoReq$Params0.pageSize = 30;
        albumContentsPhotoReq$Params0.orderBy = this.asOrder(this.filterType);
        RequestBuilder.newInstance(new AlbumContentsPhotoReq(this.getContext(), albumContentsPhotoReq$Params0)).tag(this.getRequestTag()).listener(new a(4, this, i0)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$6(AlbumDetailContentsPhotoFragment albumDetailContentsPhotoFragment0, i i0, AlbumContentsPhotoRes albumContentsPhotoRes0) {
        if(!albumDetailContentsPhotoFragment0.prepareFetchComplete(albumContentsPhotoRes0)) {
            return;
        }
        RESPONSE albumContentsPhotoRes$RESPONSE0 = albumContentsPhotoRes0.response;
        albumDetailContentsPhotoFragment0.mMelonTiaraProperty = new s(albumContentsPhotoRes$RESPONSE0.section, albumContentsPhotoRes$RESPONSE0.page, albumContentsPhotoRes$RESPONSE0.menuId, null);
        String s = albumContentsPhotoRes$RESPONSE0.pageMetaName;
        q.f(s, "pageMetaName");
        albumDetailContentsPhotoFragment0.pageMetaName = s;
        Collection collection0 = albumContentsPhotoRes0.getItems();
        if(collection0 != null) {
            for(Object object0: collection0) {
                albumDetailContentsPhotoFragment0.photos.add(new PhotoItem(((PHOTO)object0).photoId, albumDetailContentsPhotoFragment0.albumId, null, null, null, 28, null));
            }
        }
        albumDetailContentsPhotoFragment0.performFetchComplete(i0, albumContentsPhotoRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.albumId = l1.g(bundle0, "inState", "argAlbumId", "", "getString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argAlbumId", this.albumId);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F13005A));  // string:album_detail_contents_photo_title "이 앨범의 포토"
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

