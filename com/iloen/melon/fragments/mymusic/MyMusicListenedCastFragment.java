package com.iloen.melon.fragments.mymusic;

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
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v5x.response.CreatorInfoBase;
import com.iloen.melon.net.v6x.request.MyMusicRecentListCastRecntReq;
import com.iloen.melon.net.v6x.response.MyMusicCastListRes.RESPONSE.CASTLIST;
import com.iloen.melon.net.v6x.response.MyMusicCastListRes;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001A\u001A\u00020\u00192\b\u0010\u0015\u001A\u0004\u0018\u00010\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001D\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\u00112\u0006\u0010\u001F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b \u0010\u001EJ\u000F\u0010\"\u001A\u00020!H\u0014¢\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014¢\u0006\u0004\b\'\u0010(R\u0016\u0010)\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedCastFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "memberKey", "Ljava/lang/String;", "Companion", "ListenedCastAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicListenedCastFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedCastFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicListenedCastFragment;", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicListenedCastFragment newInstance(@NotNull String s) {
            q.g(s, "targetMemberKey");
            MyMusicListenedCastFragment myMusicListenedCastFragment0 = new MyMusicListenedCastFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argMemberKey", s);
            myMusicListenedCastFragment0.setArguments(bundle0);
            return myMusicListenedCastFragment0;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002$%B+\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000E\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000B¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001A\u001A\u00020\u00032\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001D\u001A\u00020\r2\b\u0010\u001C\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00108\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001A\u00020\u000B8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedCastFragment$ListenedCastAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v6x/response/MyMusicCastListRes$RESPONSE$CASTLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedCastFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "guide", "Lie/H;", "setGuideText", "(Ljava/lang/String;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "getFooterViewItemCount", "()I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_CAST", "I", "VIEW_TYPE_FOOTER", "tvGuide", "Ljava/lang/String;", "FooterViewHolder", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ListenedCastAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedCastFragment$ListenedCastAdapter$FooterViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedCastFragment$ListenedCastAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/MelonTextView;", "tvTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getTvTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class FooterViewHolder extends O0 {
            @NotNull
            private final MelonTextView tvTitle;

            public FooterViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ListenedCastAdapter.this = myMusicListenedCastFragment$ListenedCastAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0BAA);  // id:title_tv
                q.f(view1, "findViewById(...)");
                this.tvTitle = (MelonTextView)view1;
            }

            @NotNull
            public final MelonTextView getTvTitle() {
                return this.tvTitle;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0019\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0019\u0010\u0010\u001A\u0004\u0018\u00010\u000B8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001A\u0004\b\u0011\u0010\u000FR\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u000B8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001A\u0004\b\u0013\u0010\u000FR\u0019\u0010\u0014\u001A\u0004\u0018\u00010\u000B8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\r\u001A\u0004\b\u0015\u0010\u000F¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicListenedCastFragment$ListenedCastAdapter$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicListenedCastFragment$ListenedCastAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "ivThumb", "Landroid/widget/ImageView;", "getIvThumb", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "tvContentTitle", "Landroid/widget/TextView;", "getTvContentTitle", "()Landroid/widget/TextView;", "tvContentWriter", "getTvContentWriter", "tvContentDate", "getTvContentDate", "tvContentLikeCount", "getTvContentLikeCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
                ListenedCastAdapter.this = myMusicListenedCastFragment$ListenedCastAdapter0;
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

        private final int VIEW_TYPE_CAST;
        private final int VIEW_TYPE_FOOTER;
        @NotNull
        private String tvGuide;

        public ListenedCastAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicListenedCastFragment.this = myMusicListenedCastFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_CAST = 1;
            this.VIEW_TYPE_FOOTER = 2;
            this.tvGuide = "";
        }

        public static void a(CASTLIST myMusicCastListRes$RESPONSE$CASTLIST0, View view0) {
            ListenedCastAdapter.onBindViewImpl$lambda$1(myMusicCastListRes$RESPONSE$CASTLIST0, view0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getFooterViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getFooterCount() <= 0 || v != this.getAvailableFooterPosition() ? this.VIEW_TYPE_CAST : this.VIEW_TYPE_FOOTER;
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
                    C c0 = new C(myMusicCastListRes$RESPONSE$CASTLIST0, 1);
                    ((ViewHolder)o00).itemView.setOnClickListener(c0);
                }
            }
            else if(o00 instanceof FooterViewHolder) {
                if(!TextUtils.isEmpty(this.tvGuide)) {
                    ViewUtils.showWhen(((FooterViewHolder)o00).getTvTitle(), true);
                    ViewUtils.setText(((FooterViewHolder)o00).getTvTitle(), this.tvGuide);
                    return;
                }
                ViewUtils.hideWhen(((FooterViewHolder)o00).getTvTitle(), true);
            }
        }

        private static final void onBindViewImpl$lambda$1(CASTLIST myMusicCastListRes$RESPONSE$CASTLIST0, View view0) {
            Navigator.INSTANCE.openCastEpisodeDetail(myMusicCastListRes$RESPONSE$CASTLIST0.castSeq);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == this.VIEW_TYPE_FOOTER) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D056F, viewGroup0, false);  // layout:mymusic_recent_last
                q.f(view0, "inflate(...)");
                return new FooterViewHolder(this, view0);
            }
            View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D046C, viewGroup0, false);  // layout:listitem_cast
            q.f(view1, "inflate(...)");
            return new ViewHolder(this, view1);
        }

        public final void setGuideText(@NotNull String s) {
            q.g(s, "guide");
            this.tvGuide = s;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MyMusicListenedCastFragment";
    @NotNull
    private String memberKey;

    static {
        MyMusicListenedCastFragment.Companion = new Companion(null);
        MyMusicListenedCastFragment.$stable = 8;
    }

    public MyMusicListenedCastFragment() {
        this.memberKey = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new ListenedCastAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.V.buildUpon().appendPath("cast"), "targetMemberKey", this.memberKey, "toString(...)");
    }

    @NotNull
    public static final MyMusicListenedCastFragment newInstance(@NotNull String s) {
        return MyMusicListenedCastFragment.Companion.newInstance(s);
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

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D056B, viewGroup0, false);  // layout:mymusic_more
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        RequestBuilder.newInstance(new MyMusicRecentListCastRecntReq(this.getContext())).tag("MyMusicListenedCastFragment").listener(new g(this, i0, 17)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$1(MyMusicListenedCastFragment myMusicListenedCastFragment0, i i0, MyMusicCastListRes myMusicCastListRes0) {
        if(!myMusicListenedCastFragment0.prepareFetchComplete(myMusicCastListRes0)) {
            return;
        }
        ArrayList arrayList0 = myMusicCastListRes0.response == null ? null : myMusicCastListRes0.response.castList;
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            j0 j00 = myMusicListenedCastFragment0.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicListenedCastFragment.ListenedCastAdapter");
            String s = myMusicCastListRes0.response.guidetext;
            q.f(s, "guidetext");
            ((ListenedCastAdapter)j00).setGuideText(s);
        }
        myMusicListenedCastFragment0.performFetchComplete(i0, myMusicCastListRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argMemberKey");
        if(s == null) {
            s = "";
        }
        this.memberKey = s;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argMemberKey", this.memberKey);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }
}

