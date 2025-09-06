package com.iloen.melon.fragments.genre;

import P4.a;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.request.GenreLabelDetailReq;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ALBUMINFO.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ALBUMINFO;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.PLYLSTINFO.PLYLSTLIST;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.PLYLSTINFO;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreLabelDetailRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl.OnClickListener;
import com.iloen.melon.viewholders.DjPlaylistNewHolderImpl;
import com.melon.net.res.common.DjPlayListInfoBase;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0003\'()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\'\u0010\u000E\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J!\u0010\u001A\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u00172\b\u0010\u0019\u001A\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u001B\u0010\u001F\u001A\u0006\u0012\u0002\b\u00030\u001E2\u0006\u0010\u001D\u001A\u00020\u001CH\u0014¢\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b\"\u0010#R\u0016\u0010$\u001A\u00020\u000B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001A\u00020\u000B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010%¨\u0006*"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes;", "fetchData", "()Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "labelSeq", "Ljava/lang/String;", "labelCacheKey", "Companion", "GenreDetailLabelAdapter", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class GenreDetailLabelBottomFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_LABEL_SEQ", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment;", "labelSeq", "cacheKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreDetailLabelBottomFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "labelSeq");
            q.g(s1, "cacheKey");
            GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0 = new GenreDetailLabelBottomFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argLabelSeq", s);
            bundle0.putString("argCacheKey", s1);
            genreDetailLabelBottomFragment0.setArguments(bundle0);
            return genreDetailLabelBottomFragment0;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\'()*B!\b\u0000\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001A\u00020\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001B\u001A\u00020\u00032\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010\"¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$GenreDetailLabelAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$ServerDataWrapper;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_SECTION", "I", "VIEW_TYPE_ALBUM", "VIEW_TYPE_ARTIST", "VIEW_TYPE_PLAYLIST", "VIEW_TYPE_SPACE", "SectionViewHolder", "AlbumViewHolder", "ArtistViewHolder", "BottomSpaceViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class GenreDetailLabelAdapter extends p {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\r\u001A\n \u0007*\u0004\u0018\u00010\f0\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$GenreDetailLabelAdapter$AlbumViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$GenreDetailLabelAdapter;Landroid/view/View;)V", "Landroid/widget/HorizontalScrollView;", "kotlin.jvm.PlatformType", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "getHorizontalScrollView", "()Landroid/widget/HorizontalScrollView;", "Landroid/widget/LinearLayout;", "itemContainer", "Landroid/widget/LinearLayout;", "getItemContainer", "()Landroid/widget/LinearLayout;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class AlbumViewHolder extends O0 {
            private final HorizontalScrollView horizontalScrollView;
            private final LinearLayout itemContainer;

            public AlbumViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                GenreDetailLabelAdapter.this = genreDetailLabelBottomFragment$GenreDetailLabelAdapter0;
                super(view0);
                HorizontalScrollView horizontalScrollView0 = (HorizontalScrollView)view0.findViewById(0x7F0A053D);  // id:horizontal_scrollview
                this.horizontalScrollView = horizontalScrollView0;
                this.itemContainer = (LinearLayout)horizontalScrollView0.findViewById(0x7F0A05A7);  // id:item_container
            }

            public final HorizontalScrollView getHorizontalScrollView() {
                return this.horizontalScrollView;
            }

            public final LinearLayout getItemContainer() {
                return this.itemContainer;
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\b\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001A\u0004\b\n\u0010\u000BR\u001F\u0010\f\u001A\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001A\u0004\b\r\u0010\u000BR\u001F\u0010\u000F\u001A\n \u0007*\u0004\u0018\u00010\u000E0\u000E8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\u001F\u0010\u0014\u001A\n \u0007*\u0004\u0018\u00010\u00130\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u001F\u0010\u0019\u001A\n \u0007*\u0004\u0018\u00010\u00180\u00188\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$GenreDetailLabelAdapter$ArtistViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$GenreDetailLabelAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/MelonTextView;", "kotlin.jvm.PlatformType", "tvArtistName", "Lcom/iloen/melon/custom/MelonTextView;", "getTvArtistName", "()Lcom/iloen/melon/custom/MelonTextView;", "tvArtistSubName", "getTvArtistSubName", "Landroid/widget/ImageView;", "ivArtist", "Landroid/widget/ImageView;", "getIvArtist", "()Landroid/widget/ImageView;", "Landroid/widget/HorizontalScrollView;", "horizontalScrollView", "Landroid/widget/HorizontalScrollView;", "getHorizontalScrollView", "()Landroid/widget/HorizontalScrollView;", "Landroid/widget/LinearLayout;", "itemContainer", "Landroid/widget/LinearLayout;", "getItemContainer", "()Landroid/widget/LinearLayout;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ArtistViewHolder extends O0 {
            private final HorizontalScrollView horizontalScrollView;
            private final LinearLayout itemContainer;
            private final ImageView ivArtist;
            private final MelonTextView tvArtistName;
            private final MelonTextView tvArtistSubName;

            public ArtistViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                GenreDetailLabelAdapter.this = genreDetailLabelBottomFragment$GenreDetailLabelAdapter0;
                super(view0);
                this.tvArtistName = (MelonTextView)view0.findViewById(0x7F0A0C16);  // id:tv_artist_name
                this.tvArtistSubName = (MelonTextView)view0.findViewById(0x7F0A0C19);  // id:tv_artist_sub_name
                this.ivArtist = (ImageView)view0.findViewById(0x7F0A05F2);  // id:iv_artist
                HorizontalScrollView horizontalScrollView0 = (HorizontalScrollView)view0.findViewById(0x7F0A053D);  // id:horizontal_scrollview
                this.horizontalScrollView = horizontalScrollView0;
                this.itemContainer = (LinearLayout)horizontalScrollView0.findViewById(0x7F0A05A7);  // id:item_container
            }

            public final HorizontalScrollView getHorizontalScrollView() {
                return this.horizontalScrollView;
            }

            public final LinearLayout getItemContainer() {
                return this.itemContainer;
            }

            public final ImageView getIvArtist() {
                return this.ivArtist;
            }

            public final MelonTextView getTvArtistName() {
                return this.tvArtistName;
            }

            public final MelonTextView getTvArtistSubName() {
                return this.tvArtistSubName;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$GenreDetailLabelAdapter$BottomSpaceViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$GenreDetailLabelAdapter;Landroid/view/View;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class BottomSpaceViewHolder extends O0 {
            public BottomSpaceViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                GenreDetailLabelAdapter.this = genreDetailLabelBottomFragment$GenreDetailLabelAdapter0;
                super(view0);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001F\u0010\u0007\u001A\n \u0006*\u0004\u0018\u00010\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u001F\u0010\f\u001A\n \u0006*\u0004\u0018\u00010\u000B0\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u001F\u0010\u0011\u001A\n \u0006*\u0004\u0018\u00010\u00100\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$GenreDetailLabelAdapter$SectionViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$GenreDetailLabelAdapter;Landroid/view/View;)V", "kotlin.jvm.PlatformType", "titleContainer", "Landroid/view/View;", "getTitleContainer", "()Landroid/view/View;", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "Landroid/widget/ImageView;", "ivArrow", "Landroid/widget/ImageView;", "getIvArrow", "()Landroid/widget/ImageView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SectionViewHolder extends O0 {
            private final ImageView ivArrow;
            private final View titleContainer;
            private final MelonTextView tvTitle;

            public SectionViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                GenreDetailLabelAdapter.this = genreDetailLabelBottomFragment$GenreDetailLabelAdapter0;
                super(view0);
                this.titleContainer = view0.findViewById(0x7F0A0B96);  // id:title_container
                this.tvTitle = (MelonTextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
                this.ivArrow = (ImageView)view0.findViewById(0x7F0A05F1);  // id:iv_arrow
            }

            public final ImageView getIvArrow() {
                return this.ivArrow;
            }

            public final View getTitleContainer() {
                return this.titleContainer;
            }

            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        private final int VIEW_TYPE_ALBUM;
        private final int VIEW_TYPE_ARTIST;
        private final int VIEW_TYPE_PLAYLIST;
        private final int VIEW_TYPE_SECTION;
        private final int VIEW_TYPE_SPACE;

        public GenreDetailLabelAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            GenreDetailLabelBottomFragment.this = genreDetailLabelBottomFragment0;
            super(context0, list0);
            this.VIEW_TYPE_SECTION = 1;
            this.VIEW_TYPE_ALBUM = 2;
            this.VIEW_TYPE_ARTIST = 3;
            this.VIEW_TYPE_PLAYLIST = 4;
            this.VIEW_TYPE_SPACE = 5;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Object object0 = this.getItem(v1);
            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreDetailLabelBottomFragment.ServerDataWrapper");
            return ((ServerDataWrapper)object0).getViewType();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            int v4;
            int v1;
            LABELINFO genreLabelDetailRes$RESPONSE$LABELINFO0 = null;
            this.setMenuId((httpResponse0 == null ? null : httpResponse0.getMenuId()));
            this.updateModifiedTime(this.getCacheKey());
            if(httpResponse0 == null) {
                return false;
            }
            if(httpResponse0 instanceof GenreLabelDetailRes) {
                RESPONSE genreLabelDetailRes$RESPONSE0 = ((GenreLabelDetailRes)httpResponse0).response;
                if(genreLabelDetailRes$RESPONSE0 != null) {
                    genreLabelDetailRes$RESPONSE$LABELINFO0 = genreLabelDetailRes$RESPONSE0.labelInfo;
                }
                if(genreLabelDetailRes$RESPONSE$LABELINFO0 != null) {
                    ALBUMINFO genreLabelDetailRes$RESPONSE$LABELINFO$ALBUMINFO0 = genreLabelDetailRes$RESPONSE$LABELINFO0.albumInfo;
                    if(genreLabelDetailRes$RESPONSE$LABELINFO$ALBUMINFO0 == null) {
                        v1 = 0;
                    }
                    else {
                        ArrayList arrayList0 = genreLabelDetailRes$RESPONSE$LABELINFO$ALBUMINFO0.albumList;
                        v1 = arrayList0 == null ? 0 : arrayList0.size();
                    }
                    if(v1 > 0) {
                        ServerDataWrapper genreDetailLabelBottomFragment$ServerDataWrapper0 = new ServerDataWrapper();
                        genreDetailLabelBottomFragment$ServerDataWrapper0.setViewType(this.VIEW_TYPE_SECTION);
                        String s1 = genreLabelDetailRes$RESPONSE$LABELINFO0.albumInfo.title;
                        q.f(s1, "title");
                        genreDetailLabelBottomFragment$ServerDataWrapper0.setSectionTitle(s1);
                        genreDetailLabelBottomFragment$ServerDataWrapper0.setArrow(true);
                        this.add(genreDetailLabelBottomFragment$ServerDataWrapper0);
                        ServerDataWrapper genreDetailLabelBottomFragment$ServerDataWrapper1 = new ServerDataWrapper();
                        genreDetailLabelBottomFragment$ServerDataWrapper1.setViewType(this.VIEW_TYPE_ALBUM);
                        ArrayList arrayList1 = genreLabelDetailRes$RESPONSE$LABELINFO0.albumInfo.albumList;
                        q.f(arrayList1, "albumList");
                        genreDetailLabelBottomFragment$ServerDataWrapper1.setAlbumList(arrayList1);
                        this.add(genreDetailLabelBottomFragment$ServerDataWrapper1);
                    }
                    int v2 = genreLabelDetailRes$RESPONSE$LABELINFO0.artistList == null ? 0 : genreLabelDetailRes$RESPONSE$LABELINFO0.artistList.size();
                    if(v2 > 0) {
                        for(int v3 = 0; v3 < v2; ++v3) {
                            ServerDataWrapper genreDetailLabelBottomFragment$ServerDataWrapper2 = new ServerDataWrapper();
                            genreDetailLabelBottomFragment$ServerDataWrapper2.setViewType(this.VIEW_TYPE_ARTIST);
                            Object object0 = genreLabelDetailRes$RESPONSE$LABELINFO0.artistList.get(v3);
                            q.f(object0, "get(...)");
                            genreDetailLabelBottomFragment$ServerDataWrapper2.setArtistList(((ARTISTLIST)object0));
                            genreDetailLabelBottomFragment$ServerDataWrapper2.setArtistImgPattern(v3);
                            this.add(genreDetailLabelBottomFragment$ServerDataWrapper2);
                        }
                    }
                    PLYLSTINFO genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO0 = genreLabelDetailRes$RESPONSE$LABELINFO0.plyLstInfo;
                    if(genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO0 == null) {
                        v4 = 0;
                    }
                    else {
                        ArrayList arrayList2 = genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO0.plyLstList;
                        v4 = arrayList2 == null ? 0 : arrayList2.size();
                    }
                    if(v4 > 0) {
                        ServerDataWrapper genreDetailLabelBottomFragment$ServerDataWrapper3 = new ServerDataWrapper();
                        genreDetailLabelBottomFragment$ServerDataWrapper3.setViewType(this.VIEW_TYPE_SECTION);
                        String s2 = genreLabelDetailRes$RESPONSE$LABELINFO0.plyLstInfo.title;
                        q.f(s2, "title");
                        genreDetailLabelBottomFragment$ServerDataWrapper3.setSectionTitle(s2);
                        this.add(genreDetailLabelBottomFragment$ServerDataWrapper3);
                        for(int v = 0; v < v4; ++v) {
                            ServerDataWrapper genreDetailLabelBottomFragment$ServerDataWrapper4 = new ServerDataWrapper();
                            genreDetailLabelBottomFragment$ServerDataWrapper4.setViewType(this.VIEW_TYPE_PLAYLIST);
                            Object object1 = genreLabelDetailRes$RESPONSE$LABELINFO0.plyLstInfo.plyLstList.get(v);
                            q.f(object1, "get(...)");
                            genreDetailLabelBottomFragment$ServerDataWrapper4.setPlayList(((PLYLSTLIST)object1));
                            this.add(genreDetailLabelBottomFragment$ServerDataWrapper4);
                        }
                    }
                    ServerDataWrapper genreDetailLabelBottomFragment$ServerDataWrapper5 = new ServerDataWrapper();
                    genreDetailLabelBottomFragment$ServerDataWrapper5.setViewType(this.VIEW_TYPE_SPACE);
                    this.add(genreDetailLabelBottomFragment$ServerDataWrapper5);
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00 instanceof SectionViewHolder) {
                GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0 = GenreDetailLabelBottomFragment.this;
                ServerDataWrapper genreDetailLabelBottomFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v1);
                ViewUtils.setText(((SectionViewHolder)o00).getTvTitle(), "");
                if(genreDetailLabelBottomFragment$ServerDataWrapper0.isArrow()) {
                    ViewUtils.showWhen(((SectionViewHolder)o00).getIvArrow(), genreDetailLabelBottomFragment$ServerDataWrapper0.isArrow());
                    ViewUtils.setOnClickListener(((SectionViewHolder)o00).getTitleContainer(), new e(0, genreDetailLabelBottomFragment0, genreDetailLabelBottomFragment$ServerDataWrapper0));
                    return;
                }
                ViewUtils.showWhen(((SectionViewHolder)o00).getIvArrow(), genreDetailLabelBottomFragment$ServerDataWrapper0.isArrow());
                return;
            }
            if(o00 instanceof AlbumViewHolder) {
                GenreDetailLabelBottomFragment genreDetailLabelBottomFragment1 = GenreDetailLabelBottomFragment.this;
                ArrayList arrayList0 = ((ServerDataWrapper)this.getItem(v1)).getAlbumList();
                int v2 = arrayList0.size();
                ((AlbumViewHolder)o00).getItemContainer().removeAllViews();
                Ce.e e0 = a.C(a.K(0, v2), 2);
                int v3 = e0.a;
                int v4 = e0.b;
                int v5 = e0.c;
                if(v5 > 0 && v3 <= v4 || v5 < 0 && v4 <= v3) {
                    while(true) {
                        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0491, ((AlbumViewHolder)o00).getHorizontalScrollView(), false);  // layout:listitem_genre_label_album
                        ViewUtils.setText(((TextView)view0.findViewById(0x7F0A0C09)), ((ALBUMLIST)arrayList0.get(v3)).albumName);  // id:tv_album_name1
                        ViewUtils.setText(((TextView)view0.findViewById(0x7F0A0C17)), ((ALBUMLIST)arrayList0.get(v3)).getArtistNames());  // id:tv_artist_name1
                        ImageView imageView0 = (ImageView)((ViewGroup)view0.findViewById(0x7F0A0B73)).findViewById(0x7F0A069A);  // id:thumb_container1
                        Glide.with(this.getContext()).load(((ALBUMLIST)arrayList0.get(v3)).albumImg).into(imageView0);
                        ViewUtils.setOnClickListener(view0.findViewById(0x7F0A06F6), new f(arrayList0, v3, 0));  // id:layout_album_container1
                        ViewUtils.setOnClickListener(view0.findViewById(0x7F0A0186), new g(genreDetailLabelBottomFragment1, arrayList0, v3, this, 0));  // id:btn_play_right_top1
                        if(v3 == v2 - 1) {
                            ViewUtils.hideWhen(view0.findViewById(0x7F0A0A4C), true);  // id:second_item_container
                            return;
                        }
                        ViewUtils.showWhen(view0.findViewById(0x7F0A0A4C), true);  // id:second_item_container
                        ViewUtils.setText(((TextView)view0.findViewById(0x7F0A0C0A)), ((ALBUMLIST)arrayList0.get(v3 + 1)).albumName);  // id:tv_album_name2
                        ViewUtils.setText(((TextView)view0.findViewById(0x7F0A0C18)), ((ALBUMLIST)arrayList0.get(v3 + 1)).getArtistNames());  // id:tv_artist_name2
                        ImageView imageView1 = (ImageView)((ViewGroup)view0.findViewById(0x7F0A0B74)).findViewById(0x7F0A069A);  // id:thumb_container2
                        Glide.with(this.getContext()).load(((ALBUMLIST)arrayList0.get(v3 + 1)).albumImg).into(imageView1);
                        ViewUtils.setOnClickListener(view0.findViewById(0x7F0A06F7), new f(arrayList0, v3, 1));  // id:layout_album_container2
                        ViewUtils.setOnClickListener(view0.findViewById(0x7F0A0187), new g(genreDetailLabelBottomFragment1, arrayList0, v3, this, 1));  // id:btn_play_right_top2
                        ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((LinearLayout)view0.findViewById(0x7F0A0710)).getLayoutParams();  // id:layout_container
                        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0;
                        if(v3 == 0) {
                            viewGroup$MarginLayoutParams0.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                            viewGroup$MarginLayoutParams0.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                        }
                        else if(v3 == v2 - 2) {
                            viewGroup$MarginLayoutParams0.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                            viewGroup$MarginLayoutParams0.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                        }
                        else {
                            viewGroup$MarginLayoutParams0.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                            viewGroup$MarginLayoutParams0.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 6.0f);
                        }
                        ((AlbumViewHolder)o00).getItemContainer().addView(view0);
                        if(v3 == v4) {
                            break;
                        }
                        v3 += v5;
                    }
                }
            }
            else {
                if(o00 instanceof ArtistViewHolder) {
                    ServerDataWrapper genreDetailLabelBottomFragment$ServerDataWrapper1 = (ServerDataWrapper)this.getItem(v1);
                    GenreDetailLabelBottomFragment genreDetailLabelBottomFragment2 = GenreDetailLabelBottomFragment.this;
                    ARTISTLIST genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0 = genreDetailLabelBottomFragment$ServerDataWrapper1.getArtistList();
                    int v6 = genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.albumList == null ? 0 : genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.albumList.size();
                    ViewUtils.setText(((ArtistViewHolder)o00).getTvArtistName(), genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.getArtistName());
                    ViewUtils.setText(((ArtistViewHolder)o00).getTvArtistSubName(), genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.artistSubName);
                    if(!TextUtils.isEmpty(genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.getArtistImg())) {
                        ((ArtistViewHolder)o00).getIvArtist().setBackgroundResource((genreDetailLabelBottomFragment$ServerDataWrapper1.getArtistImgPattern() % 2 == 0 ? 0x7F080666 : 0x7F080667));  // drawable:img_pattern_jazz_01
                        Glide.with(this.getContext()).load(genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.getArtistImg()).into(((ArtistViewHolder)o00).getIvArtist());
                    }
                    ViewUtils.setOnClickListener(((ArtistViewHolder)o00).getTvArtistName(), new h(genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0, 0));
                    ((ArtistViewHolder)o00).getItemContainer().removeAllViews();
                    for(int v7 = 0; v7 < v6; ++v7) {
                        View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0492, ((ArtistViewHolder)o00).getHorizontalScrollView(), false);  // layout:listitem_genre_label_artist_album
                        ViewUtils.setText(((TextView)view1.findViewById(0x7F0A0C08)), ((com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST.ALBUMLIST)genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.albumList.get(v7)).albumName);  // id:tv_album_name
                        ViewUtils.setText(((TextView)view1.findViewById(0x7F0A0C16)), ((com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST.ALBUMLIST)genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.albumList.get(v7)).getArtistNames());  // id:tv_artist_name
                        Glide.with(this.getContext()).load(((com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST.ALBUMLIST)genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.albumList.get(v7)).albumImg).into(((ImageView)view1.findViewById(0x7F0A069A)));  // id:iv_thumb
                        ViewUtils.setOnClickListener(view1.findViewById(0x7F0A0185), new com.iloen.melon.fragments.genre.i(genreDetailLabelBottomFragment2, genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0, v7, this, 0));  // id:btn_play_right_top
                        ViewUtils.setOnClickListener(view1.findViewById(0x7F0A0710), new j(genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0, v7, 0));  // id:layout_container
                        ViewGroup.LayoutParams viewGroup$LayoutParams1 = ((LinearLayout)view1.findViewById(0x7F0A0710)).getLayoutParams();  // id:layout_container
                        q.e(viewGroup$LayoutParams1, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams1 = (ViewGroup.MarginLayoutParams)viewGroup$LayoutParams1;
                        if(v7 == 0) {
                            viewGroup$MarginLayoutParams1.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                            viewGroup$MarginLayoutParams1.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 3.5f);
                        }
                        else if(v7 == v6 - 1) {
                            viewGroup$MarginLayoutParams1.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 3.5f);
                            viewGroup$MarginLayoutParams1.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
                        }
                        else {
                            viewGroup$MarginLayoutParams1.leftMargin = ScreenUtils.dipToPixel(this.getContext(), 3.5f);
                            viewGroup$MarginLayoutParams1.rightMargin = ScreenUtils.dipToPixel(this.getContext(), 3.5f);
                        }
                        ((ArtistViewHolder)o00).getItemContainer().addView(view1);
                    }
                    return;
                }
                if(o00 instanceof DjPlaylistNewHolderImpl) {
                    PLYLSTLIST genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0 = ((ServerDataWrapper)this.getItem(v1)).getPlayList();
                    ((DjPlaylistNewHolderImpl)o00).bindView(genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0, v1);
                    ((DjPlaylistNewHolderImpl)o00).setOnClickListener(new OnClickListener() {
                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void clickBody(DjPlayListInfoBase djPlayListInfoBase0) {
                            q.g(djPlayListInfoBase0, "data");
                            ContsTypeCode contsTypeCode0 = ContsTypeCode.valueOf(this.$playlistData.contsTypeCode);
                            if(q.b(ContsTypeCode.DJ_PLAYLIST, contsTypeCode0)) {
                                Navigator.openDjPlaylistDetail(this.$playlistData.plylstseq);
                                return;
                            }
                            Navigator.INSTANCE.openPlaylistDetail(this.$playlistData.plylstseq);
                        }

                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void clickTag1(String s) {
                            q.g(s, "tagSeq");
                            Navigator.openMelonDJTagHubDetail(s);
                        }

                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void clickTag2(String s) {
                            q.g(s, "tagSeq");
                            Navigator.openMelonDJTagHubDetail(s);
                        }

                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void clickThumbnail(DjPlayListInfoBase djPlayListInfoBase0) {
                            q.g(djPlayListInfoBase0, "data");
                            ContsTypeCode contsTypeCode0 = ContsTypeCode.valueOf(this.$playlistData.contsTypeCode);
                            if(q.b(ContsTypeCode.DJ_PLAYLIST, contsTypeCode0)) {
                                Navigator.openDjPlaylistDetail(this.$playlistData.plylstseq);
                                return;
                            }
                            Navigator.INSTANCE.openPlaylistDetail(this.$playlistData.plylstseq);
                        }

                        @Override  // com.iloen.melon.viewholders.DjPlaylistNewHolderImpl$OnClickListener
                        public void playDjPlaylist(DjPlayListInfoBase djPlayListInfoBase0) {
                            q.g(djPlayListInfoBase0, "data");
                            String s = djPlayListInfoBase0.plylstseq;
                            String s1 = djPlayListInfoBase0.contsTypeCode;
                            String s2 = genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0.getMenuId();
                            this.playPlaylist(s, s1, s2, djPlayListInfoBase0.statsElements);
                        }
                    });
                    ((DjPlaylistNewHolderImpl)o00).setOnLongClickListener(new k(GenreDetailLabelBottomFragment.this, genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0, 0));
                }
            }
        }

        private static final void onBindViewImpl$lambda$16$lambda$15$lambda$14$lambda$10(GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0, ArrayList arrayList0, int v, GenreDetailLabelAdapter genreDetailLabelBottomFragment$GenreDetailLabelAdapter0, View view0) {
            genreDetailLabelBottomFragment0.playAlbum(((ALBUMLIST)arrayList0.get(v)).albumId, genreDetailLabelBottomFragment$GenreDetailLabelAdapter0.getMenuId());
        }

        private static final void onBindViewImpl$lambda$16$lambda$15$lambda$14$lambda$11(ArrayList arrayList0, int v, View view0) {
            Navigator.openAlbumInfo(((ALBUMLIST)arrayList0.get(v + 1)).albumId);
        }

        private static final void onBindViewImpl$lambda$16$lambda$15$lambda$14$lambda$12(GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0, ArrayList arrayList0, int v, GenreDetailLabelAdapter genreDetailLabelBottomFragment$GenreDetailLabelAdapter0, View view0) {
            genreDetailLabelBottomFragment0.playAlbum(((ALBUMLIST)arrayList0.get(v + 1)).albumId, genreDetailLabelBottomFragment$GenreDetailLabelAdapter0.getMenuId());
        }

        private static final void onBindViewImpl$lambda$16$lambda$15$lambda$14$lambda$9(ArrayList arrayList0, int v, View view0) {
            Navigator.openAlbumInfo(((ALBUMLIST)arrayList0.get(v)).albumId);
        }

        private static final void onBindViewImpl$lambda$23$lambda$22$lambda$17(ARTISTLIST genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0, View view0) {
            if(!TextUtils.isEmpty(genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.gnrArtistSeq)) {
                Navigator.INSTANCE.openGenreArtistDetail(genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.gnrArtistSeq);
                return;
            }
            Navigator.openArtistInfo(genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.getArtistId());
        }

        private static final void onBindViewImpl$lambda$23$lambda$22$lambda$21$lambda$18(GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0, ARTISTLIST genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0, int v, GenreDetailLabelAdapter genreDetailLabelBottomFragment$GenreDetailLabelAdapter0, View view0) {
            genreDetailLabelBottomFragment0.playAlbum(((com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST.ALBUMLIST)genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.albumList.get(v)).albumId, genreDetailLabelBottomFragment$GenreDetailLabelAdapter0.getMenuId());
        }

        private static final void onBindViewImpl$lambda$23$lambda$22$lambda$21$lambda$19(ARTISTLIST genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0, int v, View view0) {
            Navigator.openAlbumInfo(((com.iloen.melon.net.v5x.response.GenreLabelDetailRes.RESPONSE.LABELINFO.ARTISTLIST.ALBUMLIST)genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0.albumList.get(v)).albumId);
        }

        private static final void onBindViewImpl$lambda$26$lambda$25$lambda$24(GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0, PLYLSTLIST genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0, View view0, int v) {
            genreDetailLabelBottomFragment0.showContextPopupDjPlaylist(genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0);
        }

        private static final void onBindViewImpl$lambda$8$lambda$7$lambda$6(GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0, ServerDataWrapper genreDetailLabelBottomFragment$ServerDataWrapper0, View view0) {
            com.iloen.melon.fragments.genre.GenreDetailLabelAlbumListFragment.Companion genreDetailLabelAlbumListFragment$Companion0 = GenreDetailLabelAlbumListFragment.Companion;
            String s = genreDetailLabelBottomFragment0.labelSeq;
            if(s != null) {
                Navigator.open(genreDetailLabelAlbumListFragment$Companion0.newInstance(s, ""));
                return;
            }
            q.m("labelSeq");
            throw null;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_SECTION) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D02EB, viewGroup0, false);  // layout:genre_label_section
                q.f(view0, "inflate(...)");
                return new SectionViewHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_ALBUM) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D02E4, viewGroup0, false);  // layout:genre_label_album
                q.f(view1, "inflate(...)");
                return new AlbumViewHolder(this, view1);
            }
            if(v == this.VIEW_TYPE_ARTIST) {
                View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D02E6, viewGroup0, false);  // layout:genre_label_artist
                q.f(view2, "inflate(...)");
                return new ArtistViewHolder(this, view2);
            }
            if(v == this.VIEW_TYPE_PLAYLIST) {
                return new DjPlaylistNewHolderImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D048E, viewGroup0, false));  // layout:listitem_djplaylist_new
            }
            View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D02E0, viewGroup0, false);  // layout:genre_detail_label_bottom_space
            q.f(view3, "inflate(...)");
            return new BottomSpaceViewHolder(this, view3);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\u0007\"\u0004\b\f\u0010\tR\u001A\u0010\r\u001A\u00020\u000EX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001A\u0010\u0013\u001A\u00020\u0014X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001A\u0012\u0012\u0004\u0012\u00020\u001A0\u0019j\b\u0012\u0004\u0012\u00020\u001A`\u001BX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001D\"\u0004\b\u001E\u0010\u001FR\u001A\u0010 \u001A\u00020!X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001A\u0010&\u001A\u00020\'X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailLabelBottomFragment$ServerDataWrapper;", "", "<init>", "()V", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "artistImgPattern", "getArtistImgPattern", "setArtistImgPattern", "sectionTitle", "", "getSectionTitle", "()Ljava/lang/String;", "setSectionTitle", "(Ljava/lang/String;)V", "isArrow", "", "()Z", "setArrow", "(Z)V", "albumList", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO$ALBUMINFO$ALBUMLIST;", "Lkotlin/collections/ArrayList;", "getAlbumList", "()Ljava/util/ArrayList;", "setAlbumList", "(Ljava/util/ArrayList;)V", "artistList", "Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST;", "getArtistList", "()Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST;", "setArtistList", "(Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST;)V", "playList", "Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST;", "getPlayList", "()Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST;", "setPlayList", "(Lcom/iloen/melon/net/v5x/response/GenreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ServerDataWrapper {
        public ArrayList albumList;
        private int artistImgPattern;
        public ARTISTLIST artistList;
        private boolean isArrow;
        public PLYLSTLIST playList;
        @NotNull
        private String sectionTitle;
        private int viewType;

        public ServerDataWrapper() {
            this.viewType = -1;
            this.artistImgPattern = -1;
            this.sectionTitle = "";
        }

        @NotNull
        public final ArrayList getAlbumList() {
            ArrayList arrayList0 = this.albumList;
            if(arrayList0 != null) {
                return arrayList0;
            }
            q.m("albumList");
            throw null;
        }

        public final int getArtistImgPattern() {
            return this.artistImgPattern;
        }

        @NotNull
        public final ARTISTLIST getArtistList() {
            ARTISTLIST genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0 = this.artistList;
            if(genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0 != null) {
                return genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0;
            }
            q.m("artistList");
            throw null;
        }

        @NotNull
        public final PLYLSTLIST getPlayList() {
            PLYLSTLIST genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0 = this.playList;
            if(genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0 != null) {
                return genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0;
            }
            q.m("playList");
            throw null;
        }

        @NotNull
        public final String getSectionTitle() [...] // 潜在的解密器

        public final int getViewType() {
            return this.viewType;
        }

        public final boolean isArrow() {
            return this.isArrow;
        }

        public final void setAlbumList(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "<set-?>");
            this.albumList = arrayList0;
        }

        public final void setArrow(boolean z) {
            this.isArrow = z;
        }

        public final void setArtistImgPattern(int v) {
            this.artistImgPattern = v;
        }

        public final void setArtistList(@NotNull ARTISTLIST genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0) {
            q.g(genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0, "<set-?>");
            this.artistList = genreLabelDetailRes$RESPONSE$LABELINFO$ARTISTLIST0;
        }

        public final void setPlayList(@NotNull PLYLSTLIST genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0) {
            q.g(genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0, "<set-?>");
            this.playList = genreLabelDetailRes$RESPONSE$LABELINFO$PLYLSTINFO$PLYLSTLIST0;
        }

        public final void setSectionTitle(@NotNull String s) {
            q.g(s, "<set-?>");
            this.sectionTitle = s;
        }

        public final void setViewType(int v) {
            this.viewType = v;
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_LABEL_SEQ;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final String TAG;
    private String labelCacheKey;
    private String labelSeq;

    static {
        GenreDetailLabelBottomFragment.Companion = new Companion(null);
        GenreDetailLabelBottomFragment.$stable = 8;
        GenreDetailLabelBottomFragment.TAG = "GenreDetailLabelFragment";
        GenreDetailLabelBottomFragment.ARG_LABEL_SEQ = "argLabelSeq";
    }

    public static final String access$getARG_LABEL_SEQ$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new GenreDetailLabelAdapter(this, context0, null);
    }

    private final GenreLabelDetailRes fetchData() {
        Context context0 = this.getContext();
        String s = this.labelCacheKey;
        if(s != null) {
            Cursor cursor0 = com.iloen.melon.responsecache.a.f(context0, s);
            if(cursor0 != null && cursor0.getCount() > 0) {
                GenreLabelDetailRes genreLabelDetailRes0 = (GenreLabelDetailRes)com.iloen.melon.responsecache.a.d(cursor0, GenreLabelDetailRes.class);
                if(!cursor0.isClosed()) {
                    cursor0.close();
                }
                if(genreLabelDetailRes0 == null) {
                    LogU.Companion.w("GenreDetailLabelFragment", "fetchData() failed to extract contents");
                    return null;
                }
                return genreLabelDetailRes0;
            }
            LogU.Companion.w("GenreDetailLabelFragment", "fetchData() invalid cursor");
            return null;
        }
        q.m("labelCacheKey");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new DetailLinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        ((RecyclerView)view0).setHasFixedSize(false);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        String s1 = this.labelCacheKey;
        if(s1 != null) {
            logU$Companion0.d("GenreDetailLabelFragment", "onFetchStart() - " + s1);
            GenreLabelDetailRes genreLabelDetailRes0 = this.fetchData();
            if(genreLabelDetailRes0 == null) {
                Context context0 = this.getContext();
                String s2 = this.labelSeq;
                if(s2 != null) {
                    RequestBuilder.newInstance(new GenreLabelDetailReq(context0, s2)).tag("GenreDetailLabelFragment").listener(new k(this, i0, 2)).errorListener(new c(this, 2)).request();
                    return false;
                }
                q.m("labelSeq");
                throw null;
            }
            this.performFetchComplete(i0, genreLabelDetailRes0);
            return false;
        }
        q.m("labelCacheKey");
        throw null;
    }

    private static final void onFetchStart$lambda$0(GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0, i i0, GenreLabelDetailRes genreLabelDetailRes0) {
        if(!genreDetailLabelBottomFragment0.prepareFetchComplete(genreLabelDetailRes0)) {
            return;
        }
        genreDetailLabelBottomFragment0.performFetchComplete(i0, genreLabelDetailRes0);
    }

    private static final void onFetchStart$lambda$1(GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0, VolleyError volleyError0) {
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argLabelSeq");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        this.labelSeq = s;
        String s2 = bundle0.getString("argCacheKey");
        if(s2 != null) {
            s1 = s2;
        }
        this.labelCacheKey = s1;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = this.labelSeq;
        if(s != null) {
            bundle0.putString("argLabelSeq", s);
            String s1 = this.labelCacheKey;
            if(s1 != null) {
                bundle0.putString("argCacheKey", s1);
                return;
            }
            q.m("labelCacheKey");
            throw null;
        }
        q.m("labelSeq");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }

    public static void r0(GenreDetailLabelBottomFragment genreDetailLabelBottomFragment0, VolleyError volleyError0) {
    }
}

