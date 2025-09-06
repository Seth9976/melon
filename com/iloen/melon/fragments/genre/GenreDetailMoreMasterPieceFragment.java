package com.iloen.melon.fragments.genre;

import Tf.v;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.DetailLinearLayoutManager;
import com.iloen.melon.custom.FilterDropDownView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v5x.request.GenreMoreMasterpieceReq.Params;
import com.iloen.melon.net.v5x.request.GenreMoreMasterpieceReq;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes.RESPONSE.GNRMENULIST.GNRLIST.DTLGNRLIST;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes.RESPONSE.GNRMENULIST.GNRLIST;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes.RESPONSE.GNRMENULIST;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes.RESPONSE;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.CommonFilterPopup;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.AlbumHolder;
import e.k;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 K2\u00020\u0001:\u0002KLB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0003J\'\u0010\u000E\u001A\u00020\r2\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u0010H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0013J-\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\u0006\u0010\u0017\u001A\u00020\u00162\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001A\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ!\u0010\u001F\u001A\u00020\u00042\u0006\u0010\u001E\u001A\u00020\u001B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0010H\u0016\u00A2\u0006\u0004\b\u001F\u0010 J\u001D\u0010$\u001A\b\u0012\u0002\b\u0003\u0018\u00010#2\u0006\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b$\u0010%J\u0011\u0010\'\u001A\u0004\u0018\u00010&H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u000F\u0010)\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b)\u0010*J\u001F\u0010-\u001A\u00020\r2\u0006\u0010+\u001A\u00020\u000B2\b\u0010,\u001A\u0004\u0018\u00010\u000B\u00A2\u0006\u0004\b-\u0010.R\"\u00100\u001A\u00020/8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b0\u00101\u001A\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001A\u00020/8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b6\u00101\u001A\u0004\b7\u00103\"\u0004\b8\u00105R\"\u00109\u001A\u00020/8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b9\u00101\u001A\u0004\b:\u00103\"\u0004\b;\u00105R\u0018\u0010<\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001A\u0004\u0018\u00010\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b>\u0010=R\u0018\u0010@\u001A\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001A\u00020B8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010=R\u0016\u0010F\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010=R\u001A\u0010I\u001A\b\u0012\u0004\u0012\u00020H0G8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bI\u0010J\u00A8\u0006M"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreMasterPieceFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "initFilterLayout", "updateSelectedFilterInfo", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCacheKey", "()Ljava/lang/String;", "mainGenreCode", "subGenreCode", "isSubGenre", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "firstFilterSelectedIndex", "I", "getFirstFilterSelectedIndex", "()I", "setFirstFilterSelectedIndex", "(I)V", "secondFilterSelectedIndex", "getSecondFilterSelectedIndex", "setSecondFilterSelectedIndex", "thirdFilterSelectedIndex", "getThirdFilterSelectedIndex", "setThirdFilterSelectedIndex", "gnrCode", "Ljava/lang/String;", "gnrContsSeq", "Lcom/iloen/melon/net/v5x/response/GenreMoreMasterpieceRes$RESPONSE;", "genreMoreMasterpieceRes", "Lcom/iloen/melon/net/v5x/response/GenreMoreMasterpieceRes$RESPONSE;", "Lcom/iloen/melon/custom/FilterDropDownView;", "filterLayout", "Lcom/iloen/melon/custom/FilterDropDownView;", "currentGnrName", "currentGnrFilterName", "", "Lv9/j;", "filterList", "Ljava/util/List;", "Companion", "GenreMasterpieceAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class GenreDetailMoreMasterPieceFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u0005H\u0007J\u001A\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00052\b\u0010\r\u001A\u0004\u0018\u00010\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreMasterPieceFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_GENRE_CODE", "ARG_GENRE_CONTS_SEQ", "FILTER_TYPE_DEFAULT", "", "newInstance", "Lcom/iloen/melon/fragments/genre/GenreDetailMoreMasterPieceFragment;", "genreCode", "genreContsSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final GenreDetailMoreMasterPieceFragment newInstance(@NotNull String s) {
            q.g(s, "genreCode");
            return this.newInstance(s, "");
        }

        @NotNull
        public final GenreDetailMoreMasterPieceFragment newInstance(@NotNull String s, @Nullable String s1) {
            q.g(s, "genreCode");
            GenreDetailMoreMasterPieceFragment genreDetailMoreMasterPieceFragment0 = new GenreDetailMoreMasterPieceFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGenreCode", s);
            bundle0.putString("argGenreContsSeq", s1);
            genreDetailMoreMasterPieceFragment0.setArguments(bundle0);
            return genreDetailMoreMasterPieceFragment0;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001B\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/genre/GenreDetailMoreMasterPieceFragment$GenreMasterpieceAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v5x/response/GenreMoreMasterpieceRes$RESPONSE$ALBUMLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/genre/GenreDetailMoreMasterPieceFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_ALBUM", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class GenreMasterpieceAdapter extends p {
        private final int VIEW_TYPE_ALBUM;

        public GenreMasterpieceAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            GenreDetailMoreMasterPieceFragment.this = genreDetailMoreMasterPieceFragment0;
            super(context0, list0);
            this.VIEW_TYPE_ALBUM = 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.VIEW_TYPE_ALBUM;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            if(httpResponse0 instanceof GenreMoreMasterpieceRes) {
                RESPONSE genreMoreMasterpieceRes$RESPONSE0 = ((GenreMoreMasterpieceRes)httpResponse0).response;
                if(genreMoreMasterpieceRes$RESPONSE0 != null) {
                    this.setMenuId(genreMoreMasterpieceRes$RESPONSE0.menuId);
                    this.setHasMore(((GenreMoreMasterpieceRes)httpResponse0).response.hasMore);
                    this.updateModifiedTime(this.getCacheKey());
                    ArrayList arrayList0 = ((GenreMoreMasterpieceRes)httpResponse0).response.albumList;
                    if(arrayList0 != null && arrayList0.size() > 0) {
                        this.addAll(arrayList0);
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            if(o00.getItemViewType() == this.VIEW_TYPE_ALBUM) {
                AlbumHolder albumHolder0 = (AlbumHolder)o00;
                Object object0 = this.getItem(v1);
                if(((ALBUMLIST)object0) != null) {
                    ViewUtils.showWhen(albumHolder0.foldLayout, false);
                    ViewUtils.showWhen(albumHolder0.arrowIv, true);
                    boolean z = ((ALBUMLIST)object0).canService;
                    ViewUtils.setEnable(albumHolder0.wrapperLayout, z);
                    ViewUtils.setOnClickListener(albumHolder0.btnPlayIv, new a(z, GenreDetailMoreMasterPieceFragment.this, v1, ((ALBUMLIST)object0), this, 1));
                    if(z) {
                        ViewUtils.setOnClickListener(albumHolder0.wrapperLayout, new e(5, ((ALBUMLIST)object0), GenreDetailMoreMasterPieceFragment.this));
                    }
                    else {
                        ViewUtils.setOnClickListener(albumHolder0.wrapperLayout, null);
                    }
                    ViewUtils.setOnLongClickListener(albumHolder0.wrapperLayout, new o(GenreDetailMoreMasterPieceFragment.this, ((ALBUMLIST)object0), this, 0));
                    ViewUtils.setOnLongClickListener(albumHolder0.expandLayout, new o(GenreDetailMoreMasterPieceFragment.this, ((ALBUMLIST)object0), this, 1));
                    albumHolder0.btnPlayIv.setImageResource((z ? 0x7F080309 : 0x7F0801F1));  // drawable:common_btn_play_01
                    ImageView imageView0 = albumHolder0.thumbnailIv;
                    if(imageView0 != null) {
                        Glide.with(imageView0.getContext()).load(((ALBUMLIST)object0).albumImg).into(albumHolder0.thumbnailIv);
                    }
                    albumHolder0.titleTv.setText(((ALBUMLIST)object0).albumName);
                    albumHolder0.artistTv.setText(ProtocolUtils.getArtistNames(((ALBUMLIST)object0).artistList));
                    albumHolder0.issueTv.setText(((ALBUMLIST)object0).issueDate);
                    albumHolder0.masterpieceTitleTv.setText(((ALBUMLIST)object0).masterpieceTitle);
                    TextView textView0 = albumHolder0.masterpieceDescTv;
                    String s = ((ALBUMLIST)object0).masterpieceDesc;
                    q.f(s, "masterpieceDesc");
                    int v2 = s.length() - 1;
                    int v3 = 0;
                    boolean z1 = false;
                    while(v3 <= v2) {
                        boolean z2 = q.h(s.charAt((z1 ? v2 : v3)), 0x20) <= 0;
                        if(z1) {
                            if(!z2) {
                                break;
                            }
                            --v2;
                        }
                        else if(z2) {
                            ++v3;
                        }
                        else {
                            z1 = true;
                        }
                    }
                    textView0.setText(Html.fromHtml(s.subSequence(v3, v2 + 1).toString(), 0).toString());
                    ViewUtils.showWhen(albumHolder0.ratingContainer, true);
                    albumHolder0.ratingView.c(((ALBUMLIST)object0).totAvrgScore);
                    albumHolder0.ratingText.setText(Float.toString(((ALBUMLIST)object0).totAvrgScore));
                    albumHolder0.ratingUserCntTv.setText(StringUtils.getFormattedStringNumber(ProtocolUtils.parseInt(((ALBUMLIST)object0).ptcPnmPrco, 0)));
                    ViewUtils.setOnClickListener(albumHolder0.expandLayout, new h(((ALBUMLIST)object0), 4));
                }
            }
        }

        private static final void onBindViewImpl$lambda$0(boolean z, GenreDetailMoreMasterPieceFragment genreDetailMoreMasterPieceFragment0, int v, ALBUMLIST genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0, GenreMasterpieceAdapter genreDetailMoreMasterPieceFragment$GenreMasterpieceAdapter0, View view0) {
            if(z) {
                genreDetailMoreMasterPieceFragment0.playAlbum(v);
                return;
            }
            genreDetailMoreMasterPieceFragment0.showContextPopupAlbum(Playable.from(genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0, genreDetailMoreMasterPieceFragment$GenreMasterpieceAdapter0.getMenuId(), null));
        }

        private static final void onBindViewImpl$lambda$1(ALBUMLIST genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0, GenreDetailMoreMasterPieceFragment genreDetailMoreMasterPieceFragment0, View view0) {
            if(!TextUtils.isEmpty(genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0.albumId)) {
                genreDetailMoreMasterPieceFragment0.showAlbumInfoPage(genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0.albumId);
            }
        }

        private static final boolean onBindViewImpl$lambda$2(GenreDetailMoreMasterPieceFragment genreDetailMoreMasterPieceFragment0, ALBUMLIST genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0, GenreMasterpieceAdapter genreDetailMoreMasterPieceFragment$GenreMasterpieceAdapter0, View view0) {
            genreDetailMoreMasterPieceFragment0.showContextPopupAlbum(Playable.from(genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0, genreDetailMoreMasterPieceFragment$GenreMasterpieceAdapter0.getMenuId(), null));
            return true;
        }

        private static final boolean onBindViewImpl$lambda$3(GenreDetailMoreMasterPieceFragment genreDetailMoreMasterPieceFragment0, ALBUMLIST genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0, GenreMasterpieceAdapter genreDetailMoreMasterPieceFragment$GenreMasterpieceAdapter0, View view0) {
            genreDetailMoreMasterPieceFragment0.showContextPopupAlbum(Playable.from(genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0, genreDetailMoreMasterPieceFragment$GenreMasterpieceAdapter0.getMenuId(), null));
            return true;
        }

        private static final void onBindViewImpl$lambda$6(ALBUMLIST genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0, View view0) {
            String s = genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0.masterpieceDesc;
            q.f(s, "masterpieceDesc");
            int v = s.length() - 1;
            int v1 = 0;
            boolean z = false;
            while(v1 <= v) {
                boolean z1 = q.h(s.charAt((z ? v : v1)), 0x20) <= 0;
                if(z) {
                    if(!z1) {
                        break;
                    }
                    --v;
                }
                else if(z1) {
                    ++v1;
                }
                else {
                    z = true;
                }
            }
            String s1 = Html.fromHtml(s.subSequence(v1, v + 1).toString(), 0).toString();
            String s2 = genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0.masterpieceTitle;
            q.f(s2, "masterpieceTitle");
            GenreArtistPopupFragment.Companion.newInstance(s2, s1).open();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            return v == this.VIEW_TYPE_ALBUM ? new AlbumHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0455, viewGroup0, false)) : null;  // layout:listitem_album
        }
    }

    public static final int $stable;
    @NotNull
    private static final String ARG_GENRE_CODE;
    @NotNull
    private static final String ARG_GENRE_CONTS_SEQ;
    @NotNull
    public static final Companion Companion;
    private static final int FILTER_TYPE_DEFAULT;
    @NotNull
    private static final String TAG;
    @NotNull
    private String currentGnrFilterName;
    @NotNull
    private String currentGnrName;
    private FilterDropDownView filterLayout;
    @NotNull
    private final List filterList;
    private int firstFilterSelectedIndex;
    @Nullable
    private RESPONSE genreMoreMasterpieceRes;
    @Nullable
    private String gnrCode;
    @Nullable
    private String gnrContsSeq;
    private int secondFilterSelectedIndex;
    private int thirdFilterSelectedIndex;

    static {
        GenreDetailMoreMasterPieceFragment.Companion = new Companion(null);
        GenreDetailMoreMasterPieceFragment.$stable = 8;
        GenreDetailMoreMasterPieceFragment.TAG = "GenreDetailMoreMasterPieceFragment";
        GenreDetailMoreMasterPieceFragment.ARG_GENRE_CODE = "argGenreCode";
        GenreDetailMoreMasterPieceFragment.ARG_GENRE_CONTS_SEQ = "argGenreContsSeq";
    }

    public GenreDetailMoreMasterPieceFragment() {
        this.currentGnrName = "";
        this.currentGnrFilterName = "";
        this.filterList = new ArrayList();
    }

    public static final String access$getARG_GENRE_CODE$cp() [...] // 潜在的解密器

    public static final String access$getARG_GENRE_CONTS_SEQ$cp() [...] // 潜在的解密器

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new GenreMasterpieceAdapter(this, context0, null);
        ((j)j00).setListContentType(2);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.w0.buildUpon().appendQueryParameter("genreCode", this.gnrCode).toString();
        q.f(s, "toString(...)");
        return s;
    }

    public final int getFirstFilterSelectedIndex() {
        return this.firstFilterSelectedIndex;
    }

    public final int getSecondFilterSelectedIndex() {
        return this.secondFilterSelectedIndex;
    }

    public final int getThirdFilterSelectedIndex() {
        return this.thirdFilterSelectedIndex;
    }

    private final void initFilterLayout() {
        this.filterList.clear();
        RESPONSE genreMoreMasterpieceRes$RESPONSE0 = this.genreMoreMasterpieceRes;
        if(genreMoreMasterpieceRes$RESPONSE0 != null) {
            ArrayList arrayList0 = genreMoreMasterpieceRes$RESPONSE0.gnrMenuList;
            if(arrayList0 != null) {
                int v = 0;
                for(Object object0: arrayList0) {
                    if(v >= 0) {
                        List list0 = this.filterList;
                        v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                        j0.b = ((GNRMENULIST)object0).menuName;
                        ArrayList arrayList1 = ((GNRMENULIST)object0).gnrList;
                        q.f(arrayList1, "gnrList");
                        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
                        int v1 = 0;
                        for(Object object1: arrayList1) {
                            if(v1 >= 0) {
                                String s = ((GNRLIST)object1).gnrCode;
                                q.f(s, "gnrCode");
                                if(this.isSubGenre(s, this.gnrCode)) {
                                    this.firstFilterSelectedIndex = v;
                                    this.secondFilterSelectedIndex = v1;
                                }
                                v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                                j1.b = ((GNRLIST)object1).gnrName;
                                j1.c = ((GNRLIST)object1).gnrCode;
                                ArrayList arrayList3 = ((GNRLIST)object1).dtlGnrList;
                                q.f(arrayList3, "dtlGnrList");
                                ArrayList arrayList4 = new ArrayList(je.q.Q(10, arrayList3));
                                int v2 = 0;
                                for(Object object2: arrayList3) {
                                    if(v2 >= 0) {
                                        if(q.b(((DTLGNRLIST)object2).gnrCode, this.gnrCode)) {
                                            this.thirdFilterSelectedIndex = v2;
                                        }
                                        v9.j j2 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
                                        j2.b = ((DTLGNRLIST)object2).gnrName;
                                        j2.c = ((DTLGNRLIST)object2).gnrCode;
                                        arrayList4.add(j2);
                                        ++v2;
                                        continue;
                                    }
                                    k.O();
                                    throw null;
                                }
                                j1.e = arrayList4;
                                arrayList2.add(j1);
                                ++v1;
                                continue;
                            }
                            k.O();
                            throw null;
                        }
                        j0.e = arrayList2;
                        list0.add(j0);
                        ++v;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
            if(!this.filterList.isEmpty()) {
                FilterDropDownView filterDropDownView0 = this.filterLayout;
                if(filterDropDownView0 != null) {
                    ViewUtils.showWhen(filterDropDownView0, true);
                    goto label_66;
                }
                q.m("filterLayout");
                throw null;
            }
        label_66:
            this.updateSelectedFilterInfo();
            FilterDropDownView filterDropDownView1 = this.filterLayout;
            if(filterDropDownView1 != null) {
                filterDropDownView1.setOnDropDownListener(new c(this, 6));
                return;
            }
            q.m("filterLayout");
            throw null;
        }
    }

    private static final void initFilterLayout$lambda$11$lambda$10(GenreDetailMoreMasterPieceFragment genreDetailMoreMasterPieceFragment0, FilterDropDownView filterDropDownView0) {
        LogU.Companion.d("GenreDetailMoreMasterPieceFragment", "GenreDetailMoreMasterPieceFragment filterLayout setOnDropDownListener");
        if(!genreDetailMoreMasterPieceFragment0.isRetainedPopupShowing()) {
            int v = genreDetailMoreMasterPieceFragment0.firstFilterSelectedIndex;
            int v1 = genreDetailMoreMasterPieceFragment0.secondFilterSelectedIndex;
            int v2 = genreDetailMoreMasterPieceFragment0.thirdFilterSelectedIndex;
            n n0 = new n(genreDetailMoreMasterPieceFragment0);
            CommonFilterPopup commonFilterPopup0 = CommonFilterPopup.Companion.newInstance(0x7F1307D1, "LIST_TYPE_DEPTH_THREE", genreDetailMoreMasterPieceFragment0.filterList, v, v1, v2, n0);  // string:order_by "정렬"
            FragmentActivity fragmentActivity0 = genreDetailMoreMasterPieceFragment0.getActivity();
            if(fragmentActivity0 != null) {
                l0 l00 = fragmentActivity0.getSupportFragmentManager();
                if(l00 != null) {
                    commonFilterPopup0.setDismissFragment(genreDetailMoreMasterPieceFragment0);
                    commonFilterPopup0.show(l00, "ComposeBottomSheet");
                }
            }
        }
    }

    private static final H initFilterLayout$lambda$11$lambda$10$lambda$8(GenreDetailMoreMasterPieceFragment genreDetailMoreMasterPieceFragment0, int v, int v1, int v2) {
        if(v != genreDetailMoreMasterPieceFragment0.firstFilterSelectedIndex || v1 != genreDetailMoreMasterPieceFragment0.secondFilterSelectedIndex || v2 != genreDetailMoreMasterPieceFragment0.thirdFilterSelectedIndex) {
            genreDetailMoreMasterPieceFragment0.firstFilterSelectedIndex = v;
            genreDetailMoreMasterPieceFragment0.secondFilterSelectedIndex = v1;
            genreDetailMoreMasterPieceFragment0.thirdFilterSelectedIndex = v2;
            genreDetailMoreMasterPieceFragment0.updateSelectedFilterInfo();
            genreDetailMoreMasterPieceFragment0.startFetch("filter change");
        }
        return H.a;
    }

    public final boolean isSubGenre(@NotNull String s, @Nullable String s1) {
        q.g(s, "mainGenreCode");
        if(!Tf.o.H0(s) && s1 != null && !Tf.o.H0(s1) && s.length() > 4 && s1.length() > 4) {
            String s2 = s1.substring(0, 4);
            q.f(s2, "substring(...)");
            return v.r0(s, s2, false);
        }
        return false;
    }

    @NotNull
    public static final GenreDetailMoreMasterPieceFragment newInstance(@NotNull String s) {
        return GenreDetailMoreMasterPieceFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final GenreDetailMoreMasterPieceFragment newInstance(@NotNull String s, @Nullable String s1) {
        return GenreDetailMoreMasterPieceFragment.Companion.newInstance(s, s1);
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

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02AE, viewGroup0, false);  // layout:fragment_genre_detail_more_masterpiece
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        Y.w("onFetchStart() - genreCode: ", this.gnrCode, LogU.Companion, "GenreDetailMoreMasterPieceFragment");
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.genre.GenreDetailMoreMasterPieceFragment.GenreMasterpieceAdapter");
        i i1 = i.b;
        if(i1.equals(i0)) {
            ((GenreMasterpieceAdapter)j00).clear();
        }
        Params genreMoreMasterpieceReq$Params0 = new Params();
        genreMoreMasterpieceReq$Params0.gnrCode = this.gnrCode;
        genreMoreMasterpieceReq$Params0.startIndex = i1.equals(i0) ? 1 : ((GenreMasterpieceAdapter)j00).getCount() + 1;
        genreMoreMasterpieceReq$Params0.pageSize = 100;
        genreMoreMasterpieceReq$Params0.gnrContsSeq = this.gnrContsSeq;
        RequestBuilder.newInstance(new GenreMoreMasterpieceReq(this.getContext(), genreMoreMasterpieceReq$Params0)).tag("GenreDetailMoreMasterPieceFragment").listener(new com.iloen.melon.fragments.genre.k(this, i0, 4)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$0(GenreDetailMoreMasterPieceFragment genreDetailMoreMasterPieceFragment0, i i0, GenreMoreMasterpieceRes genreMoreMasterpieceRes0) {
        genreDetailMoreMasterPieceFragment0.genreMoreMasterpieceRes = genreMoreMasterpieceRes0.response;
        if(genreDetailMoreMasterPieceFragment0.filterList.isEmpty()) {
            genreDetailMoreMasterPieceFragment0.initFilterLayout();
        }
        if(!genreDetailMoreMasterPieceFragment0.prepareFetchComplete(genreMoreMasterpieceRes0)) {
            return;
        }
        genreDetailMoreMasterPieceFragment0.performFetchComplete(i0, genreMoreMasterpieceRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.gnrCode = bundle0.getString("argGenreCode");
        this.gnrContsSeq = bundle0.getString("argGenreContsSeq");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argGenreCode", this.gnrCode);
        bundle0.putString("argGenreContsSeq", this.gnrContsSeq);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        titleBar0.a(B.a.s(1));
        titleBar0.setTitle(this.getString(0x7F13047E));  // string:genre_more_masterpiece_title "명반"
        titleBar0.f(true);
        View view1 = this.findViewById(0x7F0A049E);  // id:filter_layout
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.FilterDropDownView");
        this.filterLayout = (FilterDropDownView)view1;
        if(!this.filterList.isEmpty() && this.genreMoreMasterpieceRes != null) {
            this.initFilterLayout();
        }
    }

    public final void setFirstFilterSelectedIndex(int v) {
        this.firstFilterSelectedIndex = v;
    }

    public final void setSecondFilterSelectedIndex(int v) {
        this.secondFilterSelectedIndex = v;
    }

    public final void setThirdFilterSelectedIndex(int v) {
        this.thirdFilterSelectedIndex = v;
    }

    private final void updateSelectedFilterInfo() {
        v9.j j0 = (v9.j)((v9.j)this.filterList.get(this.firstFilterSelectedIndex)).e.get(this.secondFilterSelectedIndex);
        v9.j j1 = (v9.j)j0.e.get(this.thirdFilterSelectedIndex);
        String s = j0.b;
        q.f(s, "name");
        this.currentGnrName = s;
        this.gnrCode = j1.c;
        String s1 = j1.b;
        q.f(s1, "name");
        this.currentGnrFilterName = s1;
        StringBuilder stringBuilder0 = new StringBuilder(this.currentGnrName);
        if(!Tf.o.H0(this.currentGnrFilterName)) {
            stringBuilder0.append(", ");
            stringBuilder0.append(this.currentGnrFilterName);
        }
        FilterDropDownView filterDropDownView0 = this.filterLayout;
        if(filterDropDownView0 != null) {
            filterDropDownView0.setText(stringBuilder0.toString());
            return;
        }
        q.m("filterLayout");
        throw null;
    }
}

