package com.iloen.melon.fragments.mymusic;

import Cb.k;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.j;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.I;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.ToggleView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.MyMusicLikeListMvReq.Params;
import com.iloen.melon.net.v4x.request.MyMusicLikeListMvReq;
import com.iloen.melon.net.v4x.response.MyMusicLikeListMvRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicLikeListMvRes;
import com.iloen.melon.net.v5x.request.MelonTvProgramLikeProgListForMyMusicReq;
import com.iloen.melon.net.v5x.response.MelonTvProgramLikeProgListForMyMusicRes.RESPONSE.CONTENTSLIST.MVLIST;
import com.iloen.melon.net.v5x.response.MelonTvProgramLikeProgListForMyMusicRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v5x.response.MelonTvProgramLikeProgListForMyMusicRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.MvHolderDefaultImpl.OnClickListener;
import com.iloen.melon.viewholders.MvHolderDefaultImpl;
import com.melon.net.res.common.MvInfoBase.REPARTIST;
import com.melon.net.res.common.MvInfoBase;
import e1.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 P2\u00020\u0001:\u0003PQRB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J!\u0010\f\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0016\u00A2\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u0003J\u0017\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\tH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0011J-\u0010\u001A\u001A\u00020\u00192\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u000F\u0010\u001F\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u001EH\u0014\u00A2\u0006\u0004\b!\u0010 J\u000F\u0010#\u001A\u00020\"H\u0014\u00A2\u0006\u0004\b#\u0010$J\u001B\u0010(\u001A\u0006\u0012\u0002\b\u00030\'2\u0006\u0010&\u001A\u00020%H\u0014\u00A2\u0006\u0004\b(\u0010)J\u0019\u0010*\u001A\u00020\u000B2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0002\u00A2\u0006\u0004\b*\u0010+J\u0019\u0010,\u001A\u00020\u000B2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014H\u0002\u00A2\u0006\u0004\b,\u0010+J\u000F\u0010-\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b-\u0010\u0003J\u0017\u0010.\u001A\u00020\u000B2\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b.\u0010/J\u0017\u00101\u001A\u00020\u000B2\u0006\u00100\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\b1\u00102J\u0017\u00104\u001A\u00020\u000B2\u0006\u00103\u001A\u00020\u0019H\u0002\u00A2\u0006\u0004\b4\u00105J\u0017\u00107\u001A\u00020\u00042\u0006\u00106\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\b7\u00108J\u0017\u00109\u001A\u00020\u00042\u0006\u00106\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\b9\u00108R\u0016\u0010:\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001A\u00020\u001E8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010>\u001A\u00020\u001E8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b>\u0010=R\u0016\u0010?\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010;R\u0016\u0010@\u001A\u00020\u001E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010=R\u0016\u0010A\u001A\u00020\u001E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010=R\u001E\u0010C\u001A\n B*\u0004\u0018\u00010\u00040\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010;R\u001A\u0010F\u001A\b\u0012\u0004\u0012\u00020E0D8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001A\u00020\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010K\u001A\u00020J8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001A\u00020M8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bN\u0010O\u00A8\u0006S"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedVideoFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "buildParallaxHeaderView", "()Landroid/view/View;", "", "getParallaxHeaderHeight", "()I", "getParallaxFixedHeight", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "requestLikeListMv", "(Lv9/i;)V", "requestProgramLike", "setToggleData", "initMyMusicHeaderView", "(Landroid/view/View;)V", "initPosition", "refreshToggle", "(I)V", "isVisible", "showToggleView", "(Z)V", "position", "getSortPositionForServer", "(I)Ljava/lang/String;", "getFilterTypeForServer", "memberKey", "Ljava/lang/String;", "START_INDEX", "I", "PAGE_SIZE", "toggleType", "sortPos", "togglePos", "kotlin.jvm.PlatformType", "sortType", "Ljava/util/ArrayList;", "Lv9/j;", "toggleList", "Ljava/util/ArrayList;", "isProgramItemEmpty", "Z", "Lcom/iloen/melon/custom/ToggleView;", "toggleView", "Lcom/iloen/melon/custom/ToggleView;", "Lcom/iloen/melon/custom/SortingBarView;", "sortingBarView", "Lcom/iloen/melon/custom/SortingBarView;", "Companion", "LikedMvAdapter", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicLikedVideoFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedVideoFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SORT_POS", "ARG_SORT_TYPE", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicLikedVideoFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicLikedVideoFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            MyMusicLikedVideoFragment myMusicLikedVideoFragment0 = new MyMusicLikedVideoFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicLikedVideoFragment0.setArguments(bundle0);
            return myMusicLikedVideoFragment0;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001A\u00020\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001B\u001A\u00020\u00032\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ)\u0010\u001F\u001A\u00020\u001E2\b\u0010\u001D\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001A\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010\"¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedVideoFragment$LikedMvAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedVideoFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_MV", "I", "VIEW_TYPE_PROGRAM", "ProgramViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LikedMvAdapter extends p {
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b)\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR\u0017\u0010\u000B\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000ER\u0017\u0010\u0010\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001A\u00020\u00148\u0006\u00A2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001A\u00020\u00148\u0006\u00A2\u0006\f\n\u0004\b\u0019\u0010\u0016\u001A\u0004\b\u001A\u0010\u0018R\u0017\u0010\u001B\u001A\u00020\u00148\u0006\u00A2\u0006\f\n\u0004\b\u001B\u0010\u0016\u001A\u0004\b\u001C\u0010\u0018R\u0017\u0010\u001D\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u001D\u0010\u0007\u001A\u0004\b\u001E\u0010\tR\u0017\u0010\u001F\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b\u001F\u0010\u0007\u001A\u0004\b \u0010\tR\u0017\u0010\"\u001A\u00020!8\u0006\u00A2\u0006\f\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%R\u0017\u0010&\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b&\u0010\u0007\u001A\u0004\b\'\u0010\tR\u0017\u0010(\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b(\u0010\u0011\u001A\u0004\b)\u0010\u0013R\u0017\u0010*\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b*\u0010\u0011\u001A\u0004\b+\u0010\u0013R\u0017\u0010,\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b,\u0010\u0011\u001A\u0004\b-\u0010\u0013R\u0017\u0010.\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b.\u0010\u0011\u001A\u0004\b/\u0010\u0013R\u0017\u00100\u001A\u00020!8\u0006\u00A2\u0006\f\n\u0004\b0\u0010#\u001A\u0004\b1\u0010%R\u0017\u00102\u001A\u00020!8\u0006\u00A2\u0006\f\n\u0004\b2\u0010#\u001A\u0004\b3\u0010%R\u0017\u00104\u001A\u00020!8\u0006\u00A2\u0006\f\n\u0004\b4\u0010#\u001A\u0004\b5\u0010%R\u0017\u00106\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b6\u0010\u0007\u001A\u0004\b7\u0010\tR\u0017\u00108\u001A\u00020!8\u0006\u00A2\u0006\f\n\u0004\b8\u0010#\u001A\u0004\b9\u0010%R\u0017\u0010:\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b:\u0010\u0007\u001A\u0004\b;\u0010\tR\u0017\u0010<\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b<\u0010\u0011\u001A\u0004\b=\u0010\u0013R\u0017\u0010>\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b>\u0010\u0011\u001A\u0004\b?\u0010\u0013R\u0017\u0010@\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b@\u0010\u0011\u001A\u0004\bA\u0010\u0013R\u0017\u0010B\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\bB\u0010\u0011\u001A\u0004\bC\u0010\u0013R\u0017\u0010D\u001A\u00020!8\u0006\u00A2\u0006\f\n\u0004\bD\u0010#\u001A\u0004\bE\u0010%R\u0017\u0010F\u001A\u00020!8\u0006\u00A2\u0006\f\n\u0004\bF\u0010#\u001A\u0004\bG\u0010%R\u0017\u0010H\u001A\u00020!8\u0006\u00A2\u0006\f\n\u0004\bH\u0010#\u001A\u0004\bI\u0010%\u00A8\u0006J"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedVideoFragment$LikedMvAdapter;Landroid/view/View;)V", "progTitleContainer", "Landroid/view/View;", "getProgTitleContainer", "()Landroid/view/View;", "Lcom/iloen/melon/custom/BorderImageView;", "ivProgThumb", "Lcom/iloen/melon/custom/BorderImageView;", "getIvProgThumb", "()Lcom/iloen/melon/custom/BorderImageView;", "Landroid/widget/ImageView;", "ivNew", "Landroid/widget/ImageView;", "getIvNew", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvProgTitle", "Landroid/widget/TextView;", "getTvProgTitle", "()Landroid/widget/TextView;", "tvHot", "getTvHot", "tvProgDesc", "getTvProgDesc", "progItemContainer", "getProgItemContainer", "progItem1", "getProgItem1", "Lcom/iloen/melon/custom/MelonTextView;", "tvPlayTime1", "Lcom/iloen/melon/custom/MelonTextView;", "getTvPlayTime1", "()Lcom/iloen/melon/custom/MelonTextView;", "thumbContainer1", "getThumbContainer1", "ivThumb1", "getIvThumb1", "ivDefaultThumb1", "getIvDefaultThumb1", "ivGrade1", "getIvGrade1", "btnInfo1", "getBtnInfo1", "tvRound1", "getTvRound1", "tvTitle1", "getTvTitle1", "tvArtist1", "getTvArtist1", "progItem2", "getProgItem2", "tvPlayTime2", "getTvPlayTime2", "thumbContainer2", "getThumbContainer2", "ivThumb2", "getIvThumb2", "ivDefaultThumb2", "getIvDefaultThumb2", "ivGrade2", "getIvGrade2", "btnInfo2", "getBtnInfo2", "tvRound2", "getTvRound2", "tvTitle2", "getTvTitle2", "tvArtist2", "getTvArtist2", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ProgramViewHolder extends O0 {
            @NotNull
            private final ImageView btnInfo1;
            @NotNull
            private final ImageView btnInfo2;
            @NotNull
            private final ImageView ivDefaultThumb1;
            @NotNull
            private final ImageView ivDefaultThumb2;
            @NotNull
            private final ImageView ivGrade1;
            @NotNull
            private final ImageView ivGrade2;
            @NotNull
            private final ImageView ivNew;
            @NotNull
            private final BorderImageView ivProgThumb;
            @NotNull
            private final ImageView ivThumb1;
            @NotNull
            private final ImageView ivThumb2;
            @NotNull
            private final View progItem1;
            @NotNull
            private final View progItem2;
            @NotNull
            private final View progItemContainer;
            @NotNull
            private final View progTitleContainer;
            @NotNull
            private final View thumbContainer1;
            @NotNull
            private final View thumbContainer2;
            @NotNull
            private final MelonTextView tvArtist1;
            @NotNull
            private final MelonTextView tvArtist2;
            @NotNull
            private final TextView tvHot;
            @NotNull
            private final MelonTextView tvPlayTime1;
            @NotNull
            private final MelonTextView tvPlayTime2;
            @NotNull
            private final TextView tvProgDesc;
            @NotNull
            private final TextView tvProgTitle;
            @NotNull
            private final MelonTextView tvRound1;
            @NotNull
            private final MelonTextView tvRound2;
            @NotNull
            private final MelonTextView tvTitle1;
            @NotNull
            private final MelonTextView tvTitle2;

            public ProgramViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                LikedMvAdapter.this = myMusicLikedVideoFragment$LikedMvAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A097B);  // id:program_title_container
                q.f(view1, "findViewById(...)");
                this.progTitleContainer = view1;
                View view2 = view0.findViewById(0x7F0A0675);  // id:iv_program_title_thumb
                q.f(view2, "findViewById(...)");
                this.ivProgThumb = (BorderImageView)view2;
                View view3 = view0.findViewById(0x7F0A08AF);  // id:new_iv
                q.f(view3, "findViewById(...)");
                this.ivNew = (ImageView)view3;
                View view4 = view0.findViewById(0x7F0A0CEF);  // id:tv_program_title
                q.f(view4, "findViewById(...)");
                this.tvProgTitle = (TextView)view4;
                View view5 = view0.findViewById(0x7F0A0C8A);  // id:tv_hot
                q.f(view5, "findViewById(...)");
                this.tvHot = (TextView)view5;
                View view6 = view0.findViewById(0x7F0A0CED);  // id:tv_program_desc
                q.f(view6, "findViewById(...)");
                this.tvProgDesc = (TextView)view6;
                View view7 = view0.findViewById(0x7F0A0975);  // id:program_item_container
                q.f(view7, "findViewById(...)");
                this.progItemContainer = view7;
                View view8 = view0.findViewById(0x7F0A0970);  // id:program_item1
                q.f(view8, "findViewById(...)");
                this.progItem1 = view8;
                View view9 = view8.findViewById(0x7F0A0CE5);  // id:tv_playtime
                q.f(view9, "findViewById(...)");
                this.tvPlayTime1 = (MelonTextView)view9;
                View view10 = view8.findViewById(0x7F0A0B72);  // id:thumb_container
                q.f(view10, "findViewById(...)");
                this.thumbContainer1 = view10;
                View view11 = view10.findViewById(0x7F0A069A);  // id:iv_thumb
                q.f(view11, "findViewById(...)");
                this.ivThumb1 = (ImageView)view11;
                View view12 = view10.findViewById(0x7F0A069E);  // id:iv_thumb_default
                q.f(view12, "findViewById(...)");
                this.ivDefaultThumb1 = (ImageView)view12;
                View view13 = view8.findViewById(0x7F0A0633);  // id:iv_grade
                q.f(view13, "findViewById(...)");
                this.ivGrade1 = (ImageView)view13;
                View view14 = view8.findViewById(0x7F0A0169);  // id:btn_info
                q.f(view14, "findViewById(...)");
                this.btnInfo1 = (ImageView)view14;
                View view15 = view8.findViewById(0x7F0A0CFF);  // id:tv_round
                q.f(view15, "findViewById(...)");
                this.tvRound1 = (MelonTextView)view15;
                View view16 = view8.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view16, "findViewById(...)");
                this.tvTitle1 = (MelonTextView)view16;
                View view17 = view8.findViewById(0x7F0A0C12);  // id:tv_artist
                q.f(view17, "findViewById(...)");
                this.tvArtist1 = (MelonTextView)view17;
                View view18 = view0.findViewById(0x7F0A0971);  // id:program_item2
                q.f(view18, "findViewById(...)");
                this.progItem2 = view18;
                View view19 = view18.findViewById(0x7F0A0CE5);  // id:tv_playtime
                q.f(view19, "findViewById(...)");
                this.tvPlayTime2 = (MelonTextView)view19;
                View view20 = view18.findViewById(0x7F0A0B72);  // id:thumb_container
                q.f(view20, "findViewById(...)");
                this.thumbContainer2 = view20;
                View view21 = view20.findViewById(0x7F0A069A);  // id:iv_thumb
                q.f(view21, "findViewById(...)");
                this.ivThumb2 = (ImageView)view21;
                View view22 = view20.findViewById(0x7F0A069E);  // id:iv_thumb_default
                q.f(view22, "findViewById(...)");
                this.ivDefaultThumb2 = (ImageView)view22;
                View view23 = view18.findViewById(0x7F0A0633);  // id:iv_grade
                q.f(view23, "findViewById(...)");
                this.ivGrade2 = (ImageView)view23;
                View view24 = view18.findViewById(0x7F0A0169);  // id:btn_info
                q.f(view24, "findViewById(...)");
                this.btnInfo2 = (ImageView)view24;
                View view25 = view18.findViewById(0x7F0A0CFF);  // id:tv_round
                q.f(view25, "findViewById(...)");
                this.tvRound2 = (MelonTextView)view25;
                View view26 = view18.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view26, "findViewById(...)");
                this.tvTitle2 = (MelonTextView)view26;
                View view27 = view18.findViewById(0x7F0A0C12);  // id:tv_artist
                q.f(view27, "findViewById(...)");
                this.tvArtist2 = (MelonTextView)view27;
                ((BorderImageView)view2).setBorderColor(ColorUtils.getColor(myMusicLikedVideoFragment$LikedMvAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                ((BorderImageView)view2).setBorderWidth(ScreenUtils.dipToPixel(myMusicLikedVideoFragment$LikedMvAdapter0.getContext(), 0.5f));
            }

            @NotNull
            public final ImageView getBtnInfo1() {
                return this.btnInfo1;
            }

            @NotNull
            public final ImageView getBtnInfo2() {
                return this.btnInfo2;
            }

            @NotNull
            public final ImageView getIvDefaultThumb1() {
                return this.ivDefaultThumb1;
            }

            @NotNull
            public final ImageView getIvDefaultThumb2() {
                return this.ivDefaultThumb2;
            }

            @NotNull
            public final ImageView getIvGrade1() {
                return this.ivGrade1;
            }

            @NotNull
            public final ImageView getIvGrade2() {
                return this.ivGrade2;
            }

            @NotNull
            public final ImageView getIvNew() {
                return this.ivNew;
            }

            @NotNull
            public final BorderImageView getIvProgThumb() {
                return this.ivProgThumb;
            }

            @NotNull
            public final ImageView getIvThumb1() {
                return this.ivThumb1;
            }

            @NotNull
            public final ImageView getIvThumb2() {
                return this.ivThumb2;
            }

            @NotNull
            public final View getProgItem1() {
                return this.progItem1;
            }

            @NotNull
            public final View getProgItem2() {
                return this.progItem2;
            }

            @NotNull
            public final View getProgItemContainer() {
                return this.progItemContainer;
            }

            @NotNull
            public final View getProgTitleContainer() {
                return this.progTitleContainer;
            }

            @NotNull
            public final View getThumbContainer1() {
                return this.thumbContainer1;
            }

            @NotNull
            public final View getThumbContainer2() {
                return this.thumbContainer2;
            }

            @NotNull
            public final MelonTextView getTvArtist1() {
                return this.tvArtist1;
            }

            @NotNull
            public final MelonTextView getTvArtist2() {
                return this.tvArtist2;
            }

            @NotNull
            public final TextView getTvHot() {
                return this.tvHot;
            }

            @NotNull
            public final MelonTextView getTvPlayTime1() {
                return this.tvPlayTime1;
            }

            @NotNull
            public final MelonTextView getTvPlayTime2() {
                return this.tvPlayTime2;
            }

            @NotNull
            public final TextView getTvProgDesc() {
                return this.tvProgDesc;
            }

            @NotNull
            public final TextView getTvProgTitle() {
                return this.tvProgTitle;
            }

            @NotNull
            public final MelonTextView getTvRound1() {
                return this.tvRound1;
            }

            @NotNull
            public final MelonTextView getTvRound2() {
                return this.tvRound2;
            }

            @NotNull
            public final MelonTextView getTvTitle1() {
                return this.tvTitle1;
            }

            @NotNull
            public final MelonTextView getTvTitle2() {
                return this.tvTitle2;
            }
        }

        private final int VIEW_TYPE_MV;
        private final int VIEW_TYPE_PROGRAM;

        public LikedMvAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicLikedVideoFragment.this = myMusicLikedVideoFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_MV = 1;
            this.VIEW_TYPE_PROGRAM = 2;
        }

        public static boolean e(Object object0, LikedMvAdapter myMusicLikedVideoFragment$LikedMvAdapter0, MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
            return LikedMvAdapter.onBindViewImpl$lambda$8$lambda$7(object0, myMusicLikedVideoFragment$LikedMvAdapter0, myMusicLikedVideoFragment0, view0);
        }

        // 去混淆评级： 低(20)
        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getItem(v1) instanceof ServerDataWrapper ? this.VIEW_TYPE_PROGRAM : this.VIEW_TYPE_MV;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            if((httpResponse0 == null ? null : httpResponse0.getResponse()) == null) {
                return false;
            }
            if(httpResponse0 instanceof MelonTvProgramLikeProgListForMyMusicRes) {
                this.setMenuId(((MelonTvProgramLikeProgListForMyMusicRes)httpResponse0).getMenuId());
                ArrayList arrayList0 = ((MelonTvProgramLikeProgListForMyMusicRes)httpResponse0).response.contentsList;
                int v1 = arrayList0 == null ? 0 : arrayList0.size();
                for(int v = 0; v < v1; ++v) {
                    ServerDataWrapper myMusicLikedVideoFragment$ServerDataWrapper0 = new ServerDataWrapper(MyMusicLikedVideoFragment.this);
                    myMusicLikedVideoFragment$ServerDataWrapper0.setViewType(this.VIEW_TYPE_PROGRAM);
                    Object object0 = arrayList0.get(v);
                    q.f(object0, "get(...)");
                    myMusicLikedVideoFragment$ServerDataWrapper0.setContents(((CONTENTSLIST)object0));
                    this.add(myMusicLikedVideoFragment$ServerDataWrapper0);
                }
                return true;
            }
            return false;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            Object object0 = this.getItem(v1);
            if(o00 instanceof ProgramViewHolder) {
                MyMusicLikedVideoFragment myMusicLikedVideoFragment0 = MyMusicLikedVideoFragment.this;
                ProgramViewHolder myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0 = (ProgramViewHolder)o00;
                if(object0 != null && object0 instanceof ServerDataWrapper) {
                    CONTENTSLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0 = ((ServerDataWrapper)object0).getContents();
                    Glide.with(this.getContext()).load(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.progThumbImageUrl).apply(RequestOptions.circleCropTransform()).into(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvProgThumb());
                    ViewUtils.showWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvNew(), ProtocolUtils.parseBoolean(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.newYN));
                    ViewUtils.showWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvHot(), ProtocolUtils.parseBoolean(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.hotYN));
                    myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvProgTitle().setText(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.progName);
                    myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvProgDesc().setText(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.progSimplDesc);
                    ViewUtils.setOnClickListener(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getProgTitleContainer(), new w(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0, 2));
                    if(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.mvList == null || melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.mvList.isEmpty()) {
                        ViewUtils.hideWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getProgItemContainer(), true);
                        return;
                    }
                    ViewUtils.showWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getProgItemContainer(), true);
                    int v2 = melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.mvList == null ? 0 : melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.mvList.size();
                    if(v2 >= 1) {
                        MVLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0 = (MVLIST)melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.mvList.get(0);
                        ViewUtils.showWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvRound1(), !TextUtils.isEmpty(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0.epsdName));
                        ViewUtils.setText(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvRound1(), melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0.epsdName);
                        ViewUtils.setText(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvTitle1(), melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0.mvName);
                        ViewUtils.setText(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvArtist1(), melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0.getArtistNames());
                        ViewUtils.setDefaultImage(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvDefaultThumb1(), ScreenUtils.dipToPixel(this.getContext(), 117.0f));
                        Glide.with(this.getContext()).load(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0.mvImg).into(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvThumb1());
                        ViewUtils.showWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvPlayTime1(), !TextUtils.isEmpty(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0.playTime));
                        MelonTextView melonTextView0 = myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvPlayTime1();
                        String s = melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0.playTime;
                        String s1 = "";
                        if(s == null) {
                            s = "";
                        }
                        melonTextView0.setText(k.f(s));
                        ViewUtils.hideWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvGrade1(), true);
                        if(!TextUtils.isEmpty(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0.adultGrade)) {
                            int v3 = ResourceUtils.getMvAdultGradeIcon(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0.adultGrade);
                            if(v3 != -1) {
                                ViewUtils.showWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvGrade1(), true);
                                myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvGrade1().setBackgroundResource(v3);
                            }
                        }
                        ViewUtils.setOnClickListener(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getProgItem1(), new N(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, this, myMusicLikedVideoFragment0, 0));
                        ViewUtils.setOnClickListener(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getBtnInfo1(), new N(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, this, myMusicLikedVideoFragment0, 1));
                        if(v2 >= 2) {
                            MVLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1 = (MVLIST)melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.mvList.get(1);
                            ViewUtils.showWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvRound2(), !TextUtils.isEmpty(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1.epsdName));
                            ViewUtils.setText(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvRound2(), melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1.epsdName);
                            ViewUtils.setText(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvTitle2(), melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1.mvName);
                            ViewUtils.setText(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvArtist2(), melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1.getArtistNames());
                            ViewUtils.setDefaultImage(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvDefaultThumb2(), ScreenUtils.dipToPixel(this.getContext(), 117.0f));
                            Glide.with(this.getContext()).load(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1.mvImg).into(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvThumb2());
                            ViewUtils.showWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvPlayTime2(), !TextUtils.isEmpty(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1.playTime));
                            MelonTextView melonTextView1 = myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getTvPlayTime2();
                            String s2 = melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1.playTime;
                            if(s2 != null) {
                                s1 = s2;
                            }
                            melonTextView1.setText(k.f(s1));
                            ViewUtils.hideWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvGrade2(), true);
                            if(!TextUtils.isEmpty(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1.adultGrade)) {
                                int v4 = ResourceUtils.getMvAdultGradeIcon(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1.adultGrade);
                                if(v4 != -1) {
                                    ViewUtils.showWhen(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvGrade2(), true);
                                    myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getIvGrade2().setBackgroundResource(v4);
                                }
                            }
                            ViewUtils.setOnClickListener(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getProgItem2(), new N(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1, this, myMusicLikedVideoFragment0, 2));
                            ViewUtils.setOnClickListener(myMusicLikedVideoFragment$LikedMvAdapter$ProgramViewHolder0.getBtnInfo2(), new N(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST1, this, myMusicLikedVideoFragment0, 3));
                        }
                    }
                }
            }
            else if(o00 instanceof MvHolderDefaultImpl) {
                MyMusicLikedVideoFragment myMusicLikedVideoFragment1 = MyMusicLikedVideoFragment.this;
                if(object0 != null && object0 instanceof MvInfoBase) {
                    ((MvHolderDefaultImpl)o00).bindView(((MvInfoBase)object0), true, this.getMenuId(), v1);
                    ((MvHolderDefaultImpl)o00).setOnClickListener(new OnClickListener() {
                        @Override  // com.iloen.melon.viewholders.MvHolderDefaultImpl$OnClickListener
                        public void playMusicVideo(int v) {
                            object0.playMv(v);
                        }

                        @Override  // com.iloen.melon.viewholders.MvHolderDefaultImpl$OnClickListener
                        public void showContextPopup(Playable playable0) {
                            q.g(playable0, "playable");
                            REPARTIST mvInfoBase$REPARTIST0 = ((MvInfoBase)this.$data).repArtist;
                            if(mvInfoBase$REPARTIST0 != null && mvInfoBase$REPARTIST0.isBrandDjs) {
                                playable0.setArtist(mvInfoBase$REPARTIST0.getArtistId(), mvInfoBase$REPARTIST0.getArtistName());
                                playable0.setBrandDj(mvInfoBase$REPARTIST0.isBrandDjs);
                            }
                            object0.showContextPopupMvWithLike(playable0);
                        }
                    });
                    A a0 = new A(object0, this, myMusicLikedVideoFragment1, 2);
                    ViewUtils.setOnLongClickListener(((MvHolderDefaultImpl)o00).itemView, a0);
                }
            }
        }

        private static final void onBindViewImpl$lambda$6$lambda$1(CONTENTSLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0, View view0) {
            if(!TextUtils.isEmpty(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.progSeq)) {
                Navigator.open(TvProgramHomeFragment.Companion.newInstance(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0.progSeq));
            }
        }

        private static final void onBindViewImpl$lambda$6$lambda$2(MVLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, LikedMvAdapter myMusicLikedVideoFragment$LikedMvAdapter0, MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
            Playable playable0 = Playable.from(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, myMusicLikedVideoFragment$LikedMvAdapter0.getMenuId(), null);
            if(playable0 != null) {
                myMusicLikedVideoFragment0.playMv(playable0);
            }
        }

        private static final void onBindViewImpl$lambda$6$lambda$3(MVLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, LikedMvAdapter myMusicLikedVideoFragment$LikedMvAdapter0, MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
            Playable playable0 = Playable.from(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, myMusicLikedVideoFragment$LikedMvAdapter0.getMenuId(), null);
            if(playable0 != null) {
                myMusicLikedVideoFragment0.showContextPopupMvWithLike(playable0);
            }
        }

        private static final void onBindViewImpl$lambda$6$lambda$4(MVLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, LikedMvAdapter myMusicLikedVideoFragment$LikedMvAdapter0, MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
            Playable playable0 = Playable.from(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, myMusicLikedVideoFragment$LikedMvAdapter0.getMenuId(), null);
            if(playable0 != null) {
                myMusicLikedVideoFragment0.playMv(playable0);
            }
        }

        private static final void onBindViewImpl$lambda$6$lambda$5(MVLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, LikedMvAdapter myMusicLikedVideoFragment$LikedMvAdapter0, MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
            Playable playable0 = Playable.from(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST$MVLIST0, myMusicLikedVideoFragment$LikedMvAdapter0.getMenuId(), null);
            if(playable0 != null) {
                myMusicLikedVideoFragment0.showContextPopupMvWithLike(playable0);
            }
        }

        private static final boolean onBindViewImpl$lambda$8$lambda$7(Object object0, LikedMvAdapter myMusicLikedVideoFragment$LikedMvAdapter0, MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
            Playable playable0 = Playable.from(((MvInfoBase)object0), myMusicLikedVideoFragment$LikedMvAdapter0.getMenuId(), null);
            REPARTIST mvInfoBase$REPARTIST0 = ((MvInfoBase)object0).repArtist;
            if(mvInfoBase$REPARTIST0 != null && mvInfoBase$REPARTIST0.isBrandDjs) {
                playable0.setArtist(mvInfoBase$REPARTIST0.getArtistId(), mvInfoBase$REPARTIST0.getArtistName());
                playable0.setBrandDj(mvInfoBase$REPARTIST0.isBrandDjs);
            }
            myMusicLikedVideoFragment0.showContextPopupMvWithLike(playable0);
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_PROGRAM) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0566, viewGroup0, false);  // layout:mymusic_like_program_list
                q.f(view0, "inflate(...)");
                return new ProgramViewHolder(this, view0);
            }
            return new MvHolderDefaultImpl(LayoutInflater.from(this.getContext()).inflate(0x7F0D04BB, viewGroup0, false));  // layout:listitem_video
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedVideoFragment$ServerDataWrapper;", "", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedVideoFragment;)V", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "contents", "Lcom/iloen/melon/net/v5x/response/MelonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST;", "getContents", "()Lcom/iloen/melon/net/v5x/response/MelonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST;", "setContents", "(Lcom/iloen/melon/net/v5x/response/MelonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ServerDataWrapper {
        public CONTENTSLIST contents;
        private int viewType;

        public ServerDataWrapper() {
            this.viewType = -1;
        }

        @NotNull
        public final CONTENTSLIST getContents() {
            CONTENTSLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0 = this.contents;
            if(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0 != null) {
                return melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0;
            }
            q.m("contents");
            throw null;
        }

        public final int getViewType() {
            return this.viewType;
        }

        public final void setContents(@NotNull CONTENTSLIST melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0) {
            q.g(melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0, "<set-?>");
            this.contents = melonTvProgramLikeProgListForMyMusicRes$RESPONSE$CONTENTSLIST0;
        }

        public final void setViewType(int v) {
            this.viewType = v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_SORT_POS = "argSortPos";
    @NotNull
    private static final String ARG_SORT_TYPE = "argSortType";
    @NotNull
    public static final Companion Companion = null;
    private final int PAGE_SIZE;
    private final int START_INDEX;
    @NotNull
    private static final String TAG = "MyMusicLikedVideoFragment";
    private boolean isProgramItemEmpty;
    @NotNull
    private String memberKey;
    private int sortPos;
    private String sortType;
    private SortingBarView sortingBarView;
    @NotNull
    private final ArrayList toggleList;
    private int togglePos;
    @NotNull
    private String toggleType;
    private ToggleView toggleView;

    static {
        MyMusicLikedVideoFragment.Companion = new Companion(null);
        MyMusicLikedVideoFragment.$stable = 8;
    }

    public MyMusicLikedVideoFragment() {
        this.memberKey = "";
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
        this.toggleType = "NEW";
        this.sortType = "";
        this.toggleList = new ArrayList();
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    @NotNull
    public View buildParallaxHeaderView() {
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0859, null, false);  // layout:sortbar_filter_toggle
        q.f(view0, "inflate(...)");
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LikedMvAdapter(this, context0, null);
        ((j)j00).setListContentType(3);
        return j00;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.S.buildUpon().appendPath("video").appendQueryParameter("sortIndex", this.sortType).appendQueryParameter("filterIndex", this.toggleType), "targetMemberKey", this.memberKey, "toString(...)");
    }

    private final String getFilterTypeForServer(int v) {
        v9.j j0 = (v9.j)je.p.n0(v, this.toggleList);
        if(j0 != null) {
            return j0.c == null ? "" : j0.c;
        }
        return "";
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxFixedHeight() {
        if(this.toggleView != null && this.toggleView.getVisibility() != 0) {
            return 0;
        }
        return q.b(this.sortType, "PROG") ? 0 : ScreenUtils.dipToPixel(this.getContext(), 51.0f);
    }

    // 去混淆评级： 低(25)
    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public int getParallaxHeaderHeight() {
        float f = this.toggleView != null && this.toggleView.getVisibility() != 0 || q.b(this.sortType, "PROG") && !this.isProgramItemEmpty ? 54.0f : 97.0f;
        return ScreenUtils.dipToPixel(this.getContext(), f);
    }

    // 去混淆评级： 低(26)
    private final String getSortPositionForServer(int v) {
        switch(v) {
            case 1: {
                q.d("M");
                return "M";
            }
            case 2: {
                q.d("OB");
                return "OB";
            }
            case 3: {
                q.d("PROG");
                return "PROG";
            }
            default: {
                q.d("");
                return "";
            }
        }
    }

    private final void initMyMusicHeaderView(View view0) {
        View view1 = view0.findViewById(0x7F0A0AB8);  // id:sort_bar
        q.f(view1, "findViewById(...)");
        this.sortingBarView = (SortingBarView)view1;
        ((SortingBarView)view1).setItems(this.getResources().getStringArray(0x7F030020));  // array:my_music_video_like_sort_type
        SortingBarView sortingBarView0 = this.sortingBarView;
        if(sortingBarView0 != null) {
            sortingBarView0.setButtonPadding(ScreenUtils.dipToPixel(this.getContext(), 17.0f));
            SortingBarView sortingBarView1 = this.sortingBarView;
            if(sortingBarView1 != null) {
                sortingBarView1.setSelection(0);
                SortingBarView sortingBarView2 = this.sortingBarView;
                if(sortingBarView2 != null) {
                    sortingBarView2.setOnSortSelectionListener(new M(this));
                    View view2 = view0.findViewById(0x7F0A0498);  // id:filter
                    q.f(view2, "findViewById(...)");
                    this.toggleView = (ToggleView)view2;
                    String[] arr_s = this.getResources().getStringArray(0x7F03003B);  // array:sortingbar_like
                    q.f(arr_s, "getStringArray(...)");
                    List list0 = e.k.A(Arrays.copyOf(arr_s, arr_s.length));
                    ToggleView toggleView0 = this.toggleView;
                    if(toggleView0 != null) {
                        toggleView0.e(list0, new M(this));
                        ToggleView toggleView1 = this.toggleView;
                        if(toggleView1 != null) {
                            toggleView1.setFilterPosition(this.togglePos);
                            return;
                        }
                        q.m("toggleView");
                        throw null;
                    }
                    q.m("toggleView");
                    throw null;
                }
                q.m("sortingBarView");
                throw null;
            }
            q.m("sortingBarView");
            throw null;
        }
        q.m("sortingBarView");
        throw null;
    }

    private static final void initMyMusicHeaderView$lambda$8(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, int v) {
        if(myMusicLikedVideoFragment0.sortPos == v) {
            return;
        }
        myMusicLikedVideoFragment0.sortPos = v;
        myMusicLikedVideoFragment0.sortType = myMusicLikedVideoFragment0.getSortPositionForServer(v);
        myMusicLikedVideoFragment0.refreshToggle(0);
        myMusicLikedVideoFragment0.startFetch("sortbar change");
    }

    private static final void initMyMusicHeaderView$lambda$9(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, int v, String s) {
        myMusicLikedVideoFragment0.toggleType = myMusicLikedVideoFragment0.getFilterTypeForServer(v);
        myMusicLikedVideoFragment0.togglePos = v;
        myMusicLikedVideoFragment0.startFetch("toggle change");
    }

    @NotNull
    public static final MyMusicLikedVideoFragment newInstance(@NotNull String s) {
        return MyMusicLikedVideoFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onDestroyView() {
        SortingBarView sortingBarView0 = this.sortingBarView;
        if(sortingBarView0 != null) {
            sortingBarView0.setOnSortSelectionListener(null);
            super.onDestroyView();
            return;
        }
        q.m("sortingBarView");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        if(i.b.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedVideoFragment.LikedMvAdapter");
            ((LikedMvAdapter)j00).clear();
        }
        if(q.b(this.sortType, "PROG")) {
            this.showToggleView(false);
            this.requestProgramLike(i0);
            return true;
        }
        this.requestLikeListMv(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argMemberKey");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        this.memberKey = s;
        this.sortPos = bundle0.getInt("argSortPos");
        String s2 = bundle0.getString("argSortType");
        if(s2 != null) {
            s1 = s2;
        }
        this.sortType = s1;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMemberKey", this.memberKey);
        bundle0.putInt("argSortPos", this.sortPos);
        bundle0.putString("argSortType", this.sortType);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getTitleBar().setVisibility(8);
        this.setToggleData();
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        boolean z = false;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
        this.initMyMusicHeaderView(view0);
        if(this.getItemCount() > 0) {
            z = true;
        }
        this.showToggleView(z);
    }

    public static void r0(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, VolleyError volleyError0) {
        MyMusicLikedVideoFragment.requestLikeListMv$lambda$3(myMusicLikedVideoFragment0, volleyError0);
    }

    private final void refreshToggle(int v) {
        ToggleView toggleView0 = this.toggleView;
        if(toggleView0 != null) {
            toggleView0.setFilterPosition(v);
            this.toggleType = this.getFilterTypeForServer(v);
            return;
        }
        q.m("toggleView");
        throw null;
    }

    private final void requestLikeListMv(i i0) {
        int v;
        Params myMusicLikeListMvReq$Params0 = new Params();
        if(i.b.equals(i0)) {
            v = this.START_INDEX;
        }
        else {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedVideoFragment.LikedMvAdapter");
            v = ((LikedMvAdapter)j00).getCount() + 1;
        }
        myMusicLikeListMvReq$Params0.startIndex = v;
        myMusicLikeListMvReq$Params0.pageSize = this.PAGE_SIZE;
        myMusicLikeListMvReq$Params0.orderBy = this.toggleType;
        myMusicLikeListMvReq$Params0.menuSeq = this.sortType;
        myMusicLikeListMvReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        RequestBuilder.newInstance(new MyMusicLikeListMvReq(this.getContext(), myMusicLikeListMvReq$Params0)).tag("MyMusicLikedVideoFragment").listener(new L(this, i0, 1)).errorListener(new M(this)).request();
    }

    private static final void requestLikeListMv$lambda$2(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, i i0, MyMusicLikeListMvRes myMusicLikeListMvRes0) {
        int v = 0;
        if(!myMusicLikedVideoFragment0.prepareFetchComplete(myMusicLikeListMvRes0)) {
            myMusicLikedVideoFragment0.showToggleView(false);
            return;
        }
        RESPONSE myMusicLikeListMvRes$RESPONSE0 = myMusicLikeListMvRes0.response;
        if(myMusicLikeListMvRes$RESPONSE0 != null) {
            ArrayList arrayList0 = myMusicLikeListMvRes$RESPONSE0.mvlist;
            if(arrayList0 != null) {
                v = arrayList0.size();
            }
        }
        if(v > 0) {
            myMusicLikedVideoFragment0.showToggleView(true);
        }
        myMusicLikedVideoFragment0.performFetchComplete(i0, myMusicLikeListMvRes0);
    }

    private static final void requestLikeListMv$lambda$3(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, VolleyError volleyError0) {
        myMusicLikedVideoFragment0.showToggleView(false);
        myMusicLikedVideoFragment0.performFetchError(volleyError0);
    }

    private final void requestProgramLike(i i0) {
        RequestBuilder.newInstance(new MelonTvProgramLikeProgListForMyMusicReq(this.getContext())).tag("MyMusicLikedVideoFragment").listener(new L(this, i0, 0)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestProgramLike$lambda$4(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, i i0, MelonTvProgramLikeProgListForMyMusicRes melonTvProgramLikeProgListForMyMusicRes0) {
        if(!myMusicLikedVideoFragment0.prepareFetchComplete(melonTvProgramLikeProgListForMyMusicRes0)) {
            myMusicLikedVideoFragment0.isProgramItemEmpty = true;
            myMusicLikedVideoFragment0.updateParallaxHeaderView();
            return;
        }
        myMusicLikedVideoFragment0.isProgramItemEmpty = false;
        myMusicLikedVideoFragment0.performFetchComplete(i0, melonTvProgramLikeProgListForMyMusicRes0);
    }

    public static void s0(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, int v) {
        MyMusicLikedVideoFragment.initMyMusicHeaderView$lambda$8(myMusicLikedVideoFragment0, v);
    }

    private final void setToggleData() {
        if(!this.toggleList.isEmpty()) {
            this.toggleList.clear();
        }
        v9.j j0 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.c = "NEW";
        this.toggleList.add(j0);
        v9.j j1 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j1.c = "ALPHABET";
        this.toggleList.add(j1);
        v9.j j2 = new v9.j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j2.c = "ARTIST";
        this.toggleList.add(j2);
    }

    private final void showToggleView(boolean z) {
        ToggleView toggleView0 = this.toggleView;
        if(toggleView0 != null) {
            ViewUtils.showWhen(toggleView0, z);
            if(z) {
                ToggleView toggleView1 = this.toggleView;
                if(toggleView1 != null) {
                    M m0 = new M(this);
                    toggleView1.c(com.iloen.melon.custom.L.d, m0);
                    ToggleView toggleView2 = this.toggleView;
                    if(toggleView2 != null) {
                        M m1 = new M(this);
                        toggleView2.a(I.d, m1);
                        this.onUpdateParallaxHeader();
                        return;
                    }
                    q.m("toggleView");
                    throw null;
                }
                q.m("toggleView");
                throw null;
            }
            ToggleView toggleView3 = this.toggleView;
            if(toggleView3 != null) {
                toggleView3.setRightLayout(null);
                ToggleView toggleView4 = this.toggleView;
                if(toggleView4 != null) {
                    toggleView4.setLeftButton(null);
                    this.onUpdateParallaxHeader();
                    return;
                }
                q.m("toggleView");
                throw null;
            }
            q.m("toggleView");
            throw null;
        }
        q.m("toggleView");
        throw null;
    }

    private static final void showToggleView$lambda$10(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
        myMusicLikedVideoFragment0.playAll();
    }

    private static final void showToggleView$lambda$11(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
        MyMusicLikeEditFragment.newInstance("mv", myMusicLikedVideoFragment0.sortType, myMusicLikedVideoFragment0.toggleType, myMusicLikedVideoFragment0.getCacheKey()).open();
    }

    public static void t0(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
        MyMusicLikedVideoFragment.showToggleView$lambda$11(myMusicLikedVideoFragment0, view0);
    }

    public static void u0(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, int v, String s) {
        MyMusicLikedVideoFragment.initMyMusicHeaderView$lambda$9(myMusicLikedVideoFragment0, v, s);
    }

    public static void v0(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, i i0, MyMusicLikeListMvRes myMusicLikeListMvRes0) {
        MyMusicLikedVideoFragment.requestLikeListMv$lambda$2(myMusicLikedVideoFragment0, i0, myMusicLikeListMvRes0);
    }

    public static void w0(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, i i0, MelonTvProgramLikeProgListForMyMusicRes melonTvProgramLikeProgListForMyMusicRes0) {
        MyMusicLikedVideoFragment.requestProgramLike$lambda$4(myMusicLikedVideoFragment0, i0, melonTvProgramLikeProgListForMyMusicRes0);
    }

    public static void x0(MyMusicLikedVideoFragment myMusicLikedVideoFragment0, View view0) {
        MyMusicLikedVideoFragment.showToggleView$lambda$10(myMusicLikedVideoFragment0, view0);
    }
}

