package com.iloen.melon.fragments.genre;

import Tf.o;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.request.GenreMoreArtistReq.Params;
import com.iloen.melon.net.v5x.request.GenreMoreArtistReq;
import com.iloen.melon.net.v5x.response.GenreMoreArtistRes.RESPONSE.ARTISTLIST;
import com.iloen.melon.net.v5x.response.GenreMoreArtistRes.RESPONSE.FILTERLIST;
import com.iloen.melon.net.v5x.response.GenreMoreArtistRes.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreMoreArtistRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.AlbumInfoBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;
import v9.j;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 B2\u00020\u0001:\u0003BCDB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0011\u0010\u0007\u001A\u0004\u0018\u00010\u0006H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\f\u0010\u000BJ\u000F\u0010\r\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\r\u0010\u0003J\u0015\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000EH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u0011J\'\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0016\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001B\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u001AH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u001DJ!\u0010#\u001A\u00020\u00042\u0006\u0010!\u001A\u00020 2\b\u0010\"\u001A\u0004\u0018\u00010\u001AH\u0016\u00A2\u0006\u0004\b#\u0010$J\u001D\u0010(\u001A\b\u0012\u0002\b\u0003\u0018\u00010\'2\u0006\u0010&\u001A\u00020%H\u0014\u00A2\u0006\u0004\b(\u0010)J\u0011\u0010+\u001A\u0004\u0018\u00010*H\u0014\u00A2\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b-\u0010\u000BJ\u0011\u0010.\u001A\u0004\u0018\u00010 H\u0014\u00A2\u0006\u0004\b.\u0010/J\u000F\u00101\u001A\u000200H\u0014\u00A2\u0006\u0004\b1\u00102R\u001C\u00103\u001A\b\u0012\u0004\u0012\u00020\u000F0\u000E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001A\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001A\u0002008\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010;R\u0018\u0010=\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010;R\u0018\u0010>\u001A\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010;R\u0018\u0010@\u001A\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010A\u00A8\u0006E"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreArtistFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "updateFileterLayout", "Lcom/iloen/melon/net/v5x/response/GenreMoreArtistRes$RESPONSE$FILTERLIST;", "getCurrentFilter", "()Lcom/iloen/melon/net/v5x/response/GenreMoreArtistRes$RESPONSE$FILTERLIST;", "", "syncFilterNameFromParam", "()Ljava/lang/String;", "getCurrentFilterName", "showFilterPopup", "Ljava/util/ArrayList;", "Lv9/j;", "getFilterDataArray", "()Ljava/util/ArrayList;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCacheKey", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "filterDataArray", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/FilterDropDownView;", "filterDropDownView", "Lcom/iloen/melon/custom/FilterDropDownView;", "filterType", "I", "gnrCode", "Ljava/lang/String;", "genreContsSeq", "filterTypeFlg", "filterTypeCode", "Lcom/iloen/melon/net/v5x/response/GenreMoreArtistRes$RESPONSE;", "genreMoreArtistRes", "Lcom/iloen/melon/net/v5x/response/GenreMoreArtistRes$RESPONSE;", "Companion", "GenreArtistAdapter", "ArtistItemHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class GenreDetailMoreArtistFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0003\u001A\u00020\u00028\u0000@\u0000X\u0080\u000E¢\u0006\u0012\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000B\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\u0006\u001A\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0017\u0010\u000F\u001A\u00020\u000E8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001A\u00020\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0013\u0010\u0010\u001A\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001A\u00020\u00178\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\u001B\"\u0004\b\u001C\u0010\u001DR\"\u0010\u001E\u001A\u00020\u00178\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001E\u0010\u0019\u001A\u0004\b\u001F\u0010\u001B\"\u0004\b \u0010\u001DR\"\u0010!\u001A\u00020\u000E8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b!\u0010\u0010\u001A\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0016R\"\u0010$\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b$\u0010\u0006\u001A\u0004\b%\u0010\b\"\u0004\b&\u0010\nR\"\u0010\'\u001A\u00020\u00178\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\'\u0010\u0019\u001A\u0004\b(\u0010\u001B\"\u0004\b)\u0010\u001D¨\u0006*"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreArtistFragment$ArtistItemHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "rootView", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailMoreArtistFragment;Landroid/view/View;)V", "Landroid/view/View;", "getRootView$app_playstoreProdRelease", "()Landroid/view/View;", "setRootView$app_playstoreProdRelease", "(Landroid/view/View;)V", "thumbContainer", "getThumbContainer", "setThumbContainer", "Landroid/widget/ImageView;", "ivDefaultThumb", "Landroid/widget/ImageView;", "getIvDefaultThumb", "()Landroid/widget/ImageView;", "ivThumb", "getIvThumb", "setIvThumb", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "tvArtistName", "Landroid/widget/TextView;", "getTvArtistName", "()Landroid/widget/TextView;", "setTvArtistName", "(Landroid/widget/TextView;)V", "tvArtistDesc", "getTvArtistDesc", "setTvArtistDesc", "ivArtistAlbumIcon", "getIvArtistAlbumIcon", "setIvArtistAlbumIcon", "layoutAlbumInfo", "getLayoutAlbumInfo", "setLayoutAlbumInfo", "tvAlbumInfo", "getTvAlbumInfo", "setTvAlbumInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class ArtistItemHolder extends O0 {
        @NotNull
        private ImageView ivArtistAlbumIcon;
        @NotNull
        private final ImageView ivDefaultThumb;
        @NotNull
        private ImageView ivThumb;
        @NotNull
        private View layoutAlbumInfo;
        @NotNull
        private View rootView;
        @NotNull
        private View thumbContainer;
        @NotNull
        private TextView tvAlbumInfo;
        @NotNull
        private TextView tvArtistDesc;
        @NotNull
        private TextView tvArtistName;

        public ArtistItemHolder(@NotNull View view0) {
            q.g(view0, "rootView");
            GenreDetailMoreArtistFragment.this = genreDetailMoreArtistFragment0;
            super(view0);
            this.rootView = view0;
            View view1 = view0.findViewById(0x7F0A0B72);  // id:thumb_container
            q.f(view1, "findViewById(...)");
            this.thumbContainer = view1;
            View view2 = this.rootView.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
            q.f(view2, "findViewById(...)");
            this.ivDefaultThumb = (ImageView)view2;
            View view3 = this.rootView.findViewById(0x7F0A069B);  // id:iv_thumb_circle
            q.f(view3, "findViewById(...)");
            this.ivThumb = (ImageView)view3;
            View view4 = this.rootView.findViewById(0x7F0A0C16);  // id:tv_artist_name
            q.f(view4, "findViewById(...)");
            this.tvArtistName = (TextView)view4;
            View view5 = this.rootView.findViewById(0x7F0A0C15);  // id:tv_artist_desc
            q.f(view5, "findViewById(...)");
            this.tvArtistDesc = (TextView)view5;
            View view6 = this.rootView.findViewById(0x7F0A05F5);  // id:iv_artist_album_icon
            q.f(view6, "findViewById(...)");
            this.ivArtistAlbumIcon = (ImageView)view6;
            View view7 = this.rootView.findViewById(0x7F0A06F8);  // id:layout_album_info
            q.f(view7, "findViewById(...)");
            this.layoutAlbumInfo = view7;
            View view8 = this.rootView.findViewById(0x7F0A0C07);  // id:tv_album_info
            q.f(view8, "findViewById(...)");
            this.tvAlbumInfo = (TextView)view8;
        }

        @NotNull
        public final ImageView getIvArtistAlbumIcon() {
            return this.ivArtistAlbumIcon;
        }

        @NotNull
        public final ImageView getIvDefaultThumb() {
            return this.ivDefaultThumb;
        }

        @NotNull
        public final ImageView getIvThumb() {
            return this.ivThumb;
        }

        @NotNull
        public final View getLayoutAlbumInfo() {
            return this.layoutAlbumInfo;
        }

        @NotNull
        public final View getRootView$app_playstoreProdRelease() {
            return this.rootView;
        }

        @NotNull
        public final View getThumbContainer() {
            return this.thumbContainer;
        }

        @NotNull
        public final TextView getTvAlbumInfo() {
            return this.tvAlbumInfo;
        }

        @NotNull
        public final TextView getTvArtistDesc() {
            return this.tvArtistDesc;
        }

        @NotNull
        public final TextView getTvArtistName() {
            return this.tvArtistName;
        }

        public final void setIvArtistAlbumIcon(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.ivArtistAlbumIcon = imageView0;
        }

        public final void setIvThumb(@NotNull ImageView imageView0) {
            q.g(imageView0, "<set-?>");
            this.ivThumb = imageView0;
        }

        public final void setLayoutAlbumInfo(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.layoutAlbumInfo = view0;
        }

        public final void setRootView$app_playstoreProdRelease(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.rootView = view0;
        }

        public final void setThumbContainer(@NotNull View view0) {
            q.g(view0, "<set-?>");
            this.thumbContainer = view0;
        }

        public final void setTvAlbumInfo(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.tvAlbumInfo = textView0;
        }

        public final void setTvArtistDesc(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.tvArtistDesc = textView0;
        }

        public final void setTvArtistName(@NotNull TextView textView0) {
            q.g(textView0, "<set-?>");
            this.tvArtistName = textView0;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0005J,\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00052\b\u0010\u000F\u001A\u0004\u0018\u00010\u00052\b\u0010\u0010\u001A\u0004\u0018\u00010\u00052\b\u0010\u0011\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreArtistFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_GENRE_CODE", "ARG_GENRE_CONTS_SEQ", "ARG_GENRE_FILTER_TYPE_FLG", "ARG_GENRE_FILTER_TYPE_CODE", "FILTER_TYPE_DEFAULT", "", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreDetailMoreArtistFragment;", "genreCode", "genreContsSeq", "filterTypeFlg", "filterTypeCode", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreDetailMoreArtistFragment newInstance(@NotNull String s) {
            q.g(s, "genreCode");
            GenreDetailMoreArtistFragment genreDetailMoreArtistFragment0 = new GenreDetailMoreArtistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGenreCode", s);
            genreDetailMoreArtistFragment0.setArguments(bundle0);
            return genreDetailMoreArtistFragment0;
        }

        @NotNull
        public final GenreDetailMoreArtistFragment newInstance(@NotNull String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
            q.g(s, "genreCode");
            GenreDetailMoreArtistFragment genreDetailMoreArtistFragment0 = new GenreDetailMoreArtistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGenreCode", s);
            bundle0.putString("argGenreContsSeq", s1);
            bundle0.putString("argGenreFilterTypeFlg", s2);
            bundle0.putString("argGenreFilterTypeCode", s3);
            genreDetailMoreArtistFragment0.setArguments(bundle0);
            return genreDetailMoreArtistFragment0;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0016\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\'\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0019\u0010\u001AR\u0014\u0010\u001B\u001A\u00020\u000E8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001B\u0010\u001C¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreArtistFragment$GenreArtistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/GenreMoreArtistRes$RESPONSE$ARTISTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailMoreArtistFragment;Landroid/content/Context;Ljava/util/List;)V", "data", "Lie/H;", "openArtistInfo", "(Lcom/iloen/melon/net/v5x/response/GenreMoreArtistRes$RESPONSE$ARTISTLIST;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_ARTIST", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class GenreArtistAdapter extends p {
        private final int VIEW_TYPE_ARTIST;

        public GenreArtistAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            GenreDetailMoreArtistFragment.this = genreDetailMoreArtistFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_ARTIST;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00.getItemViewType() == this.VIEW_TYPE_ARTIST) {
                ARTISTLIST genreMoreArtistRes$RESPONSE$ARTISTLIST0 = (ARTISTLIST)this.getItem(v1);
                if(genreMoreArtistRes$RESPONSE$ARTISTLIST0 != null) {
                    boolean z = true;
                    ViewUtils.setDefaultImage(((ArtistItemHolder)o00).getIvDefaultThumb(), ScreenUtils.dipToPixel(this.getContext(), 74.0f), true);
                    Glide.with(this.getContext()).load(genreMoreArtistRes$RESPONSE$ARTISTLIST0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(((ArtistItemHolder)o00).getIvThumb());
                    ((ArtistItemHolder)o00).getTvArtistName().setText(genreMoreArtistRes$RESPONSE$ARTISTLIST0.getArtistName());
                    ((ArtistItemHolder)o00).getTvArtistDesc().setText(genreMoreArtistRes$RESPONSE$ARTISTLIST0.artistDesc);
                    AlbumInfoBase albumInfoBase0 = genreMoreArtistRes$RESPONSE$ARTISTLIST0.album;
                    if(albumInfoBase0 != null) {
                        ((ArtistItemHolder)o00).getTvAlbumInfo().setText(albumInfoBase0.albumName);
                        ((ArtistItemHolder)o00).getTvAlbumInfo().requestLayout();
                        ViewUtils.setOnClickListener(((ArtistItemHolder)o00).getTvAlbumInfo(), new h(albumInfoBase0, 3));
                    }
                    ViewUtils.showWhen(((ArtistItemHolder)o00).getIvArtistAlbumIcon(), albumInfoBase0 != null);
                    View view0 = ((ArtistItemHolder)o00).getLayoutAlbumInfo();
                    if(albumInfoBase0 == null) {
                        z = false;
                    }
                    ViewUtils.showWhen(view0, z);
                    ViewUtils.setOnClickListener(((ArtistItemHolder)o00).getThumbContainer(), new m(this, genreMoreArtistRes$RESPONSE$ARTISTLIST0, 0));
                    ViewUtils.setOnClickListener(((ArtistItemHolder)o00).getTvArtistName(), new m(this, genreMoreArtistRes$RESPONSE$ARTISTLIST0, 1));
                }
            }
        }

        private static final void onBindViewImpl$lambda$0(AlbumInfoBase albumInfoBase0, View view0) {
            Navigator.openAlbumInfo(albumInfoBase0.albumId);
        }

        private static final void onBindViewImpl$lambda$1(GenreArtistAdapter genreDetailMoreArtistFragment$GenreArtistAdapter0, ARTISTLIST genreMoreArtistRes$RESPONSE$ARTISTLIST0, View view0) {
            genreDetailMoreArtistFragment$GenreArtistAdapter0.openArtistInfo(genreMoreArtistRes$RESPONSE$ARTISTLIST0);
        }

        private static final void onBindViewImpl$lambda$2(GenreArtistAdapter genreDetailMoreArtistFragment$GenreArtistAdapter0, ARTISTLIST genreMoreArtistRes$RESPONSE$ARTISTLIST0, View view0) {
            genreDetailMoreArtistFragment$GenreArtistAdapter0.openArtistInfo(genreMoreArtistRes$RESPONSE$ARTISTLIST0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D02E1, viewGroup0, false);  // layout:genre_detail_more_artist_listitem
            q.f(view0, "inflate(...)");
            return new ArtistItemHolder(GenreDetailMoreArtistFragment.this, view0);
        }

        private final void openArtistInfo(ARTISTLIST genreMoreArtistRes$RESPONSE$ARTISTLIST0) {
            if(!TextUtils.isEmpty(genreMoreArtistRes$RESPONSE$ARTISTLIST0.gnrArtistSeq)) {
                Navigator.INSTANCE.openGenreArtistDetail(genreMoreArtistRes$RESPONSE$ARTISTLIST0.gnrArtistSeq);
                return;
            }
            Navigator.openArtistInfo(genreMoreArtistRes$RESPONSE$ARTISTLIST0.getArtistId());
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_GENRE_CODE;
    @NotNull
    private static final String ARG_GENRE_CONTS_SEQ;
    @NotNull
    private static final String ARG_GENRE_FILTER_TYPE_CODE;
    @NotNull
    private static final String ARG_GENRE_FILTER_TYPE_FLG;
    @NotNull
    public static final Companion Companion;
    private static final int FILTER_TYPE_DEFAULT;
    @NotNull
    private static final String TAG;
    @NotNull
    private ArrayList filterDataArray;
    @Nullable
    private FilterDropDownView filterDropDownView;
    private int filterType;
    @Nullable
    private String filterTypeCode;
    @Nullable
    private String filterTypeFlg;
    @Nullable
    private String genreContsSeq;
    @Nullable
    private RESPONSE genreMoreArtistRes;
    @Nullable
    private String gnrCode;

    static {
        GenreDetailMoreArtistFragment.Companion = new Companion(null);
        GenreDetailMoreArtistFragment.$stable = 8;
        GenreDetailMoreArtistFragment.TAG = "GenreDetailMoreArtistFragment";
        GenreDetailMoreArtistFragment.ARG_GENRE_CODE = "argGenreCode";
        GenreDetailMoreArtistFragment.ARG_GENRE_CONTS_SEQ = "argGenreContsSeq";
        GenreDetailMoreArtistFragment.ARG_GENRE_FILTER_TYPE_FLG = "argGenreFilterTypeFlg";
        GenreDetailMoreArtistFragment.ARG_GENRE_FILTER_TYPE_CODE = "argGenreFilterTypeCode";
    }

    public GenreDetailMoreArtistFragment() {
        this.filterDataArray = new ArrayList();
        this.filterType = GenreDetailMoreArtistFragment.FILTER_TYPE_DEFAULT;
    }

    public static final String access$getARG_GENRE_CODE$cp() [...] // 潜在的解密器

    public static final String access$getARG_GENRE_CONTS_SEQ$cp() [...] // 潜在的解密器

    public static final String access$getARG_GENRE_FILTER_TYPE_CODE$cp() [...] // 潜在的解密器

    public static final String access$getARG_GENRE_FILTER_TYPE_FLG$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @Nullable
    public View buildParallaxHeaderView() {
        return LayoutInflater.from(this.getContext()).inflate(0x7F0D027B, null, false);  // layout:filter_standalone
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new GenreArtistAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.v0.buildUpon().appendQueryParameter("gnrCode", this.gnrCode).toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final FILTERLIST getCurrentFilter() {
        RESPONSE genreMoreArtistRes$RESPONSE0 = this.genreMoreArtistRes;
        if(genreMoreArtistRes$RESPONSE0 != null) {
            return genreMoreArtistRes$RESPONSE0.filterList.size() <= this.filterType ? null : ((FILTERLIST)genreMoreArtistRes$RESPONSE0.filterList.get(this.filterType));
        }
        return null;
    }

    private final String getCurrentFilterName() {
        FILTERLIST genreMoreArtistRes$RESPONSE$FILTERLIST0 = this.getCurrentFilter();
        if(genreMoreArtistRes$RESPONSE$FILTERLIST0 != null) {
            String s = genreMoreArtistRes$RESPONSE$FILTERLIST0.filterTypeName;
            q.f(s, "filterTypeName");
            return s;
        }
        return "";
    }

    private final ArrayList getFilterDataArray() {
        if(this.genreMoreArtistRes == null) {
            return this.filterDataArray;
        }
        this.filterDataArray.clear();
        RESPONSE genreMoreArtistRes$RESPONSE0 = this.genreMoreArtistRes;
        if(genreMoreArtistRes$RESPONSE0 != null) {
            Iterator iterator0 = genreMoreArtistRes$RESPONSE0.filterList.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
                j0.b = ((FILTERLIST)object0).filterTypeName;
                this.filterDataArray.add(j0);
            }
        }
        return this.filterDataArray;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        return this.getFilterDataArray().size() <= 0 ? 0 : ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new DetailLinearLayoutManager(this.getActivity()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        Y.w("onFetchStart() - gnrCode: ", this.gnrCode, LogU.Companion, "GenreDetailMoreArtistFragment");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreDetailMoreArtistFragment.GenreArtistAdapter");
        if(i.b.equals(i0)) {
            ((GenreArtistAdapter)j00).clear();
        }
        Params genreMoreArtistReq$Params0 = new Params();
        genreMoreArtistReq$Params0.gnrCode = this.gnrCode;
        genreMoreArtistReq$Params0.startIndex = 0;
        genreMoreArtistReq$Params0.pageSize = 100;
        String s1 = null;
        genreMoreArtistReq$Params0.gnrContsSeq = this.genreContsSeq == null || o.H0(this.genreContsSeq) ? null : this.genreContsSeq;
        genreMoreArtistReq$Params0.filterTypeFlg = this.filterTypeFlg == null || o.H0(this.filterTypeFlg) ? null : this.filterTypeFlg;
        if(this.filterTypeCode != null && !o.H0(this.filterTypeCode)) {
            s1 = this.filterTypeCode;
        }
        genreMoreArtistReq$Params0.filterTypeCode = s1;
        if(this.genreMoreArtistRes != null) {
            FILTERLIST genreMoreArtistRes$RESPONSE$FILTERLIST0 = this.getCurrentFilter();
            if(genreMoreArtistRes$RESPONSE$FILTERLIST0 != null) {
                genreMoreArtistReq$Params0.filterTypeFlg = genreMoreArtistRes$RESPONSE$FILTERLIST0.filterTypeFlg;
                genreMoreArtistReq$Params0.filterTypeCode = genreMoreArtistRes$RESPONSE$FILTERLIST0.filterTypeCode;
            }
        }
        RequestBuilder.newInstance(new GenreMoreArtistReq(this.getContext(), genreMoreArtistReq$Params0)).tag("GenreDetailMoreArtistFragment").listener(new k(this, i0, 3)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(GenreDetailMoreArtistFragment genreDetailMoreArtistFragment0, i i0, GenreMoreArtistRes genreMoreArtistRes0) {
        genreDetailMoreArtistFragment0.genreMoreArtistRes = genreMoreArtistRes0.response;
        if(!genreDetailMoreArtistFragment0.prepareFetchComplete(genreMoreArtistRes0)) {
            return;
        }
        genreDetailMoreArtistFragment0.performFetchComplete(i0, genreMoreArtistRes0);
        genreDetailMoreArtistFragment0.updateFileterLayout();
        genreDetailMoreArtistFragment0.updateParallaxHeaderView();
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.gnrCode = bundle0.getString("argGenreCode");
        this.genreContsSeq = bundle0.getString("argGenreContsSeq");
        this.filterTypeFlg = bundle0.getString("argGenreFilterTypeFlg");
        this.filterTypeCode = bundle0.getString("argGenreFilterTypeCode");
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argGenreCode", this.gnrCode);
        bundle0.putString("argGenreContsSeq", this.genreContsSeq);
        bundle0.putString("argGenreFilterTypeFlg", this.filterTypeFlg);
        bundle0.putString("argGenreFilterTypeCode", this.filterTypeCode);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.filterDropDownView = (FilterDropDownView)view0.findViewById(0x7F0A049E);  // id:filter_layout
        this.updateFileterLayout();
    }

    private final void showFilterPopup() {
        GenreFilterListPopup genreFilterListPopup0 = new GenreFilterListPopup(this.getActivity(), 0);
        genreFilterListPopup0.setFilterItem(this.getFilterDataArray());
        genreFilterListPopup0.setFilterListener(new l(this));
        genreFilterListPopup0.setSelection(this.filterType);
        genreFilterListPopup0.setOnDismissListener(this.mDialogDismissListener);
        this.mRetainDialog = genreFilterListPopup0;
        genreFilterListPopup0.show();
    }

    private static final void showFilterPopup$lambda$7(GenreDetailMoreArtistFragment genreDetailMoreArtistFragment0, int v) {
        if(genreDetailMoreArtistFragment0.filterType != v) {
            genreDetailMoreArtistFragment0.filterType = v;
            FilterDropDownView filterDropDownView0 = genreDetailMoreArtistFragment0.filterDropDownView;
            if(filterDropDownView0 != null) {
                filterDropDownView0.setText(genreDetailMoreArtistFragment0.getCurrentFilterName());
            }
            genreDetailMoreArtistFragment0.startFetch(i.b);
        }
    }

    private final String syncFilterNameFromParam() {
        RESPONSE genreMoreArtistRes$RESPONSE0 = this.genreMoreArtistRes;
        if(genreMoreArtistRes$RESPONSE0 != null) {
            this.filterType = 0;
            Iterator iterator0 = genreMoreArtistRes$RESPONSE0.filterList.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                FILTERLIST genreMoreArtistRes$RESPONSE$FILTERLIST0 = (FILTERLIST)object0;
                if(q.b(genreMoreArtistRes$RESPONSE$FILTERLIST0.filterTypeCode, this.filterTypeCode)) {
                    String s = genreMoreArtistRes$RESPONSE$FILTERLIST0.filterTypeName;
                    q.f(s, "filterTypeName");
                    return s;
                }
                ++this.filterType;
            }
        }
        this.filterType = 0;
        return this.getCurrentFilterName();
    }

    private final void updateFileterLayout() {
        if(this.genreMoreArtistRes != null && (this.genreMoreArtistRes.filterList != null && this.genreMoreArtistRes.filterList.size() > 0)) {
            FilterDropDownView filterDropDownView0 = this.filterDropDownView;
            if(filterDropDownView0 != null) {
                if(this.filterTypeCode == null || o.H0(this.filterTypeCode)) {
                    filterDropDownView0.setText(this.getCurrentFilterName());
                }
                else {
                    filterDropDownView0.setText(this.syncFilterNameFromParam());
                    this.filterTypeFlg = null;
                    this.filterTypeCode = null;
                }
                filterDropDownView0.setOnDropDownListener(new l(this));
            }
        }
    }

    private static final void updateFileterLayout$lambda$4$lambda$3$lambda$2(GenreDetailMoreArtistFragment genreDetailMoreArtistFragment0, FilterDropDownView filterDropDownView0) {
        genreDetailMoreArtistFragment0.showFilterPopup();
    }
}

