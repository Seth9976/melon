package com.iloen.melon.fragments.mymusic;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.L;
import com.iloen.melon.custom.ToggleView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.response.CreatorInfoBase;
import com.iloen.melon.net.v6x.request.MyMusicLikeListCastBaseReq.Params;
import com.iloen.melon.net.v6x.request.MyMusicLikeListCastReq;
import com.iloen.melon.net.v6x.response.MyMusicCastListRes.RESPONSE.CASTLIST;
import com.iloen.melon.net.v6x.response.MyMusicCastListRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import e.k;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;
import v9.j;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0007\u0018\u0000 32\u00020\u0001:\u00043456B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\rH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0010J!\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0015\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001E\u001A\u00020\u001D2\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001C\u001A\u0004\u0018\u00010\bH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u000F\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u001B\u0010&\u001A\u0006\u0012\u0002\b\u00030%2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020\u00068\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001A\u00020\u00068\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b*\u0010)R\u001A\u0010-\u001A\b\u0012\u0004\u0012\u00020,0+8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u00100R\u0016\u00102\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u0010)\u00A8\u00067"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedCastFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "setFilterData", "", "position", "", "getFilterTypeForServer", "(I)Ljava/lang/String;", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/view/View;", "view", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "START_INDEX", "I", "PAGE_SIZE", "Ljava/util/ArrayList;", "Lv9/j;", "filterList", "Ljava/util/ArrayList;", "memberKey", "Ljava/lang/String;", "filterType", "togglePos", "Companion", "LikedCastAdapter", "HeaderViewHolder", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicLikedCastFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedCastFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicLikedCastFragment;", "memberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicLikedCastFragment newInstance(@NotNull String s) {
            q.g(s, "memberKey");
            MyMusicLikedCastFragment myMusicLikedCastFragment0 = new MyMusicLikedCastFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicLikedCastFragment0.setArguments(bundle0);
            return myMusicLikedCastFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedCastFragment$HeaderViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedCastFragment;Landroid/view/View;)V", "Lcom/iloen/melon/custom/ToggleView;", "toggleView", "Lcom/iloen/melon/custom/ToggleView;", "getToggleView", "()Lcom/iloen/melon/custom/ToggleView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class HeaderViewHolder extends O0 {
        @NotNull
        private final ToggleView toggleView;

        public HeaderViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            MyMusicLikedCastFragment.this = myMusicLikedCastFragment0;
            super(view0);
            View view1 = view0.findViewById(0x7F0A0BBD);  // id:toggle_layout
            q.f(view1, "findViewById(...)");
            this.toggleView = (ToggleView)view1;
            String[] arr_s = myMusicLikedCastFragment0.getResources().getStringArray(0x7F03001B);  // array:my_music_cast_like_filter_type
            q.f(arr_s, "getStringArray(...)");
            ((ToggleView)view1).e(k.A(Arrays.copyOf(arr_s, arr_s.length)), new B(myMusicLikedCastFragment0, 1));
            ((ToggleView)view1).setFilterPosition(myMusicLikedCastFragment0.togglePos);
        }

        private static final void _init_$lambda$0(MyMusicLikedCastFragment myMusicLikedCastFragment0, int v, String s) {
            myMusicLikedCastFragment0.filterType = myMusicLikedCastFragment0.getFilterTypeForServer(v);
            myMusicLikedCastFragment0.togglePos = v;
            myMusicLikedCastFragment0.startFetch("filter change");
        }

        public static void a(MyMusicLikedCastFragment myMusicLikedCastFragment0, int v, String s) {
            HeaderViewHolder._init_$lambda$0(myMusicLikedCastFragment0, v, s);
        }

        @NotNull
        public final ToggleView getToggleView() {
            return this.toggleView;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000F\u0010\u0010J!\u0010\u0014\u001A\u00020\u00032\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u0018\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001C\u001A\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001C\u0010\u001B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedCastFragment$LikedCastAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/MyMusicCastListRes$RESPONSE$CASTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedCastFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getHeaderViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_CAST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LikedCastAdapter extends p {
        private final int VIEW_TYPE_CAST;
        private final int VIEW_TYPE_HEADER;

        public LikedCastAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicLikedCastFragment.this = myMusicLikedCastFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_HEADER = 1;
            this.VIEW_TYPE_CAST = 2;
        }

        public static void a(CASTLIST myMusicCastListRes$RESPONSE$CASTLIST0, View view0) {
            LikedCastAdapter.onBindViewImpl$lambda$1(myMusicCastListRes$RESPONSE$CASTLIST0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? this.VIEW_TYPE_CAST : this.VIEW_TYPE_HEADER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            CASTLIST myMusicCastListRes$RESPONSE$CASTLIST0 = (CASTLIST)this.getItem(v1);
            if(o00 instanceof ViewHolder) {
                if(myMusicCastListRes$RESPONSE$CASTLIST0 != null) {
                    ImageView imageView0 = ((ViewHolder)o00).getIvThumb();
                    if(imageView0 != null) {
                        Glide.with(this.getContext()).load(myMusicCastListRes$RESPONSE$CASTLIST0.castImgUrl).into(imageView0);
                    }
                    TextView textView0 = ((ViewHolder)o00).getTvContentTitle();
                    String s = "";
                    if(textView0 != null) {
                        textView0.setText((myMusicCastListRes$RESPONSE$CASTLIST0.castTitle == null ? "" : myMusicCastListRes$RESPONSE$CASTLIST0.castTitle));
                    }
                    if(myMusicCastListRes$RESPONSE$CASTLIST0.creator == null) {
                        TextView textView2 = ((ViewHolder)o00).getTvContentWriter();
                        if(textView2 != null) {
                            textView2.setText("");
                        }
                    }
                    else {
                        TextView textView1 = ((ViewHolder)o00).getTvContentWriter();
                        if(textView1 != null) {
                            textView1.setText(CreatorInfoBase.getCreatorNames(this.getContext(), myMusicCastListRes$RESPONSE$CASTLIST0.creator, true));
                        }
                    }
                    TextView textView3 = ((ViewHolder)o00).getTvContentDate();
                    if(textView3 != null) {
                        String s1 = myMusicCastListRes$RESPONSE$CASTLIST0.castDate;
                        if(s1 != null) {
                            s = s1;
                        }
                        textView3.setText(s);
                    }
                    TextView textView4 = ((ViewHolder)o00).getTvContentLikeCount();
                    if(textView4 != null) {
                        textView4.setText(StringUtils.getCountFormattedString(myMusicCastListRes$RESPONSE$CASTLIST0.likeCnt));
                    }
                    C c0 = new C(myMusicCastListRes$RESPONSE$CASTLIST0, 0);
                    ((ViewHolder)o00).itemView.setOnClickListener(c0);
                }
            }
            else if(o00 instanceof HeaderViewHolder) {
                ToggleView toggleView0 = ((HeaderViewHolder)o00).getToggleView();
                g g0 = new g(MyMusicLikedCastFragment.this, this, 3);
                toggleView0.c(L.f, g0);
            }
        }

        private static final void onBindViewImpl$lambda$1(CASTLIST myMusicCastListRes$RESPONSE$CASTLIST0, View view0) {
            Navigator.INSTANCE.openCastEpisodeDetail(myMusicCastListRes$RESPONSE$CASTLIST0.castSeq);
        }

        private static final void onBindViewImpl$lambda$2(MyMusicLikedCastFragment myMusicLikedCastFragment0, LikedCastAdapter myMusicLikedCastFragment$LikedCastAdapter0, View view0) {
            MyMusicLikeEditFragment.newInstance("cast", myMusicLikedCastFragment0.filterType, myMusicLikedCastFragment$LikedCastAdapter0.getCacheKey()).open();
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_HEADER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D089B, viewGroup0, false);  // layout:toggle_standalone
                q.f(view0, "inflate(...)");
                return new HeaderViewHolder(MyMusicLikedCastFragment.this, view0);
            }
            View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D046C, viewGroup0, false);  // layout:listitem_cast
            q.f(view1, "inflate(...)");
            return new ViewHolder(MyMusicLikedCastFragment.this, view1);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0019\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0019\u0010\u0010\u001A\u0004\u0018\u00010\u000B8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001A\u0004\b\u0011\u0010\u000FR\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u000B8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001A\u0004\b\u0013\u0010\u000FR\u0019\u0010\u0014\u001A\u0004\u0018\u00010\u000B8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001A\u0004\b\u0015\u0010\u000F¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicLikedCastFragment$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicLikedCastFragment;Landroid/view/View;)V", "Landroid/widget/ImageView;", "ivThumb", "Landroid/widget/ImageView;", "getIvThumb", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvContentTitle", "Landroid/widget/TextView;", "getTvContentTitle", "()Landroid/widget/TextView;", "tvContentWriter", "getTvContentWriter", "tvContentDate", "getTvContentDate", "tvContentLikeCount", "getTvContentLikeCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ViewHolder extends O0 {
        @Nullable
        private final ImageView ivThumb;
        @Nullable
        private final TextView tvContentDate;
        @Nullable
        private final TextView tvContentLikeCount;
        @Nullable
        private final TextView tvContentTitle;
        @Nullable
        private final TextView tvContentWriter;

        public ViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            MyMusicLikedCastFragment.this = myMusicLikedCastFragment0;
            super(view0);
            this.ivThumb = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
            this.tvContentTitle = (TextView)view0.findViewById(0x7F0A0C4E);  // id:tv_content_title
            this.tvContentWriter = (TextView)view0.findViewById(0x7F0A0C4F);  // id:tv_content_writer
            this.tvContentDate = (TextView)view0.findViewById(0x7F0A0C4A);  // id:tv_content_date
            this.tvContentLikeCount = (TextView)view0.findViewById(0x7F0A0C4B);  // id:tv_content_like_count
        }

        @Nullable
        public final ImageView getIvThumb() {
            return this.ivThumb;
        }

        @Nullable
        public final TextView getTvContentDate() {
            return this.tvContentDate;
        }

        @Nullable
        public final TextView getTvContentLikeCount() {
            return this.tvContentLikeCount;
        }

        @Nullable
        public final TextView getTvContentTitle() {
            return this.tvContentTitle;
        }

        @Nullable
        public final TextView getTvContentWriter() {
            return this.tvContentWriter;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private final int PAGE_SIZE;
    private final int START_INDEX;
    @NotNull
    private static final String TAG = "MyMusicLikedCastFragment";
    @NotNull
    private final ArrayList filterList;
    @NotNull
    private String filterType;
    @NotNull
    private String memberKey;
    private int togglePos;

    static {
        MyMusicLikedCastFragment.Companion = new Companion(null);
        MyMusicLikedCastFragment.$stable = 8;
    }

    public MyMusicLikedCastFragment() {
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
        this.filterList = new ArrayList();
        this.memberKey = "";
        this.filterType = "NEW";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new LikedCastAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.S.buildUpon().appendPath("cast").appendQueryParameter("filterType", this.filterType), "targetMemberKey", this.memberKey, "toString(...)");
    }

    private final String getFilterTypeForServer(int v) {
        j j0 = (j)je.p.n0(v, this.filterList);
        if(j0 != null) {
            return j0.c == null ? "" : j0.c;
        }
        return "";
    }

    @NotNull
    public static final MyMusicLikedCastFragment newInstance(@NotNull String s) {
        return MyMusicLikedCastFragment.Companion.newInstance(s);
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

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        int v;
        i i1 = i.b;
        if(i1.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedCastFragment.LikedCastAdapter");
            ((LikedCastAdapter)j00).clear();
        }
        Params myMusicLikeListCastBaseReq$Params0 = new Params();
        myMusicLikeListCastBaseReq$Params0.orderBy = this.filterType;
        if(i1.equals(i0)) {
            v = this.START_INDEX;
        }
        else {
            j0 j01 = this.mAdapter;
            q.e(j01, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicLikedCastFragment.LikedCastAdapter");
            v = ((LikedCastAdapter)j01).getCount() + 1;
        }
        myMusicLikeListCastBaseReq$Params0.startIndex = v;
        myMusicLikeListCastBaseReq$Params0.pageSize = this.PAGE_SIZE;
        RequestBuilder.newInstance(new MyMusicLikeListCastReq(this.getContext(), myMusicLikeListCastBaseReq$Params0)).tag("MyMusicLikedCastFragment").listener(new g(this, i0, 15)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$2(MyMusicLikedCastFragment myMusicLikedCastFragment0, i i0, MyMusicCastListRes myMusicCastListRes0) {
        if(!myMusicLikedCastFragment0.prepareFetchComplete(myMusicCastListRes0)) {
            return;
        }
        myMusicLikedCastFragment0.performFetchComplete(i0, myMusicCastListRes0);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argMemberKey");
        if(s == null) {
            s = "";
        }
        this.memberKey = s;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMemberKey", this.memberKey);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getTitleBar().setVisibility(8);
        this.setFilterData();
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }

    private final void setFilterData() {
        j j0 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j0.c = "NEW";
        this.filterList.add(j0);
        j j1 = new j();  // 初始化器: Ljava/lang/Object;-><init>()V
        j1.c = "ALPHABET";
        this.filterList.add(j1);
    }
}

