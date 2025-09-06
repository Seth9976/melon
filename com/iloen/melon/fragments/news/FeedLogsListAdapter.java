package com.iloen.melon.fragments.news;

import Jc.t0;
import android.content.Context;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.MoreExpandTextView;
import com.iloen.melon.fragments.detail.viewholder.n;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v6x.response.FeedLogsListRes.FEEDLOGLIST;
import com.iloen.melon.net.v6x.response.FeedLogsListRes.RESPONSE;
import com.iloen.melon.net.v6x.response.FeedLogsListRes;
import com.iloen.melon.utils.color.ColorUtils;
import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00015B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tJ!\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\f\u001A\u0004\u0018\u00010\nH\u0002\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001A\u00020\u00102\u0006\u0010\u0014\u001A\u00020\u0013\u00A2\u0006\u0004\b\u0015\u0010\u0016J-\u0010\u001D\u001A\u00020\u001C2\b\u0010\u0017\u001A\u0004\u0018\u00010\n2\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u001AH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u001F\u0010\"\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\"\u0010#J!\u0010\'\u001A\u00020\u00032\b\u0010%\u001A\u0004\u0018\u00010$2\u0006\u0010&\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b\'\u0010(J)\u0010*\u001A\u00020\u00102\b\u0010)\u001A\u0004\u0018\u00010\u00032\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u001FH\u0016\u00A2\u0006\u0004\b*\u0010+J\u001D\u0010-\u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u001F2\u0006\u0010,\u001A\u00020\u001C\u00A2\u0006\u0004\b-\u0010.R\u0014\u0010/\u001A\u00020\u001F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001A\u00020\u001F8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b1\u00100R\u0018\u0010\u0014\u001A\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0014\u00102R\u0016\u00103\u001A\u00020\u001C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u00104\u00A8\u00066"}, d2 = {"Lcom/iloen/melon/fragments/news/FeedLogsListAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "", "desc", "date", "Landroid/text/SpannableStringBuilder;", "makeSpannableText", "(Ljava/lang/String;Ljava/lang/String;)Landroid/text/SpannableStringBuilder;", "Lie/H;", "initDividerData", "()V", "Lcom/iloen/melon/fragments/news/OnActionListener;", "actionListener", "setActionListener", "(Lcom/iloen/melon/fragments/news/OnActionListener;)V", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "isToday", "getDataPosition", "(IZ)I", "VIEW_TYPE_ITEM", "I", "VIEW_TYPE_TITLE", "Lcom/iloen/melon/fragments/news/OnActionListener;", "isAddedBeforeList", "Z", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FeedLogsListAdapter extends p {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/news/FeedLogsListAdapter$ServerDataWrapper;", "", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ServerDataWrapper {
        public static final int $stable = 8;
        public String title;

        @NotNull
        public final String getTitle() {
            String s = this.title;
            if(s != null) {
                return s;
            }
            q.m("title");
            throw null;
        }

        public final void setTitle(@NotNull String s) {
            q.g(s, "<set-?>");
            this.title = s;
        }
    }

    public static final int $stable = 8;
    private final int VIEW_TYPE_ITEM;
    private final int VIEW_TYPE_TITLE;
    @Nullable
    private OnActionListener actionListener;
    private boolean isAddedBeforeList;

    public FeedLogsListAdapter(@NotNull Context context0, @Nullable List list0) {
        q.g(context0, "context");
        super(context0, list0);
        this.VIEW_TYPE_TITLE = 1;
    }

    public static boolean a(FeedLogsListAdapter feedLogsListAdapter0, FeedLogsItemHolder feedLogsItemHolder0, View view0) {
        return FeedLogsListAdapter.onCreateViewHolderImpl$lambda$6$lambda$5(feedLogsListAdapter0, feedLogsItemHolder0, view0);
    }

    public final int getDataPosition(int v, boolean z) {
        if(!z) {
            for(Object object0: this.getList()) {
                if(object0 instanceof FEEDLOGLIST && ((FEEDLOGLIST)object0).isToday()) {
                    return v - 2;
                }
                if(false) {
                    break;
                }
            }
        }
        return v - 1;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.adapters.common.p
    public int getItemViewTypeImpl(int v, int v1) {
        return this.getItem(v1) instanceof FEEDLOGLIST ? this.VIEW_TYPE_ITEM : this.VIEW_TYPE_TITLE;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
        if(httpResponse0 instanceof FeedLogsListRes) {
            RESPONSE feedLogsListRes$RESPONSE0 = ((FeedLogsListRes)httpResponse0).response;
            if(feedLogsListRes$RESPONSE0 == null) {
                return false;
            }
            this.setHasMore(((FeedLogsListRes)httpResponse0).hasMore());
            this.setMenuId("");
            this.updateModifiedTime(this.getCacheKey());
            String s1 = null;
            if(i.b.equals(i0)) {
                this.initDividerData();
                if(feedLogsListRes$RESPONSE0.todayList != null && !feedLogsListRes$RESPONSE0.todayList.isEmpty()) {
                    ServerDataWrapper feedLogsListAdapter$ServerDataWrapper0 = new ServerDataWrapper();
                    feedLogsListAdapter$ServerDataWrapper0.setTitle(String.valueOf((this.getContext() == null ? null : "오늘")));
                    this.add(feedLogsListAdapter$ServerDataWrapper0);
                }
            }
            if(feedLogsListRes$RESPONSE0.todayList != null && !feedLogsListRes$RESPONSE0.todayList.isEmpty()) {
                for(Object object0: feedLogsListRes$RESPONSE0.todayList) {
                    ((FEEDLOGLIST)object0).setToday(true);
                }
                this.addAll(feedLogsListRes$RESPONSE0.todayList);
            }
            if(feedLogsListRes$RESPONSE0.beforeList != null && !feedLogsListRes$RESPONSE0.beforeList.isEmpty()) {
                if(!this.isAddedBeforeList) {
                    ServerDataWrapper feedLogsListAdapter$ServerDataWrapper1 = new ServerDataWrapper();
                    if(this.getContext() != null) {
                        s1 = "이전";
                    }
                    feedLogsListAdapter$ServerDataWrapper1.setTitle(String.valueOf(s1));
                    this.add(feedLogsListAdapter$ServerDataWrapper1);
                    this.isAddedBeforeList = true;
                }
                for(Object object1: feedLogsListRes$RESPONSE0.beforeList) {
                    ((FEEDLOGLIST)object1).setToday(false);
                }
                this.addAll(feedLogsListRes$RESPONSE0.beforeList);
            }
        }
        return true;
    }

    private final void initDividerData() {
        this.isAddedBeforeList = false;
    }

    private final SpannableStringBuilder makeSpannableText(String s, String s1) {
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(Html.fromHtml(s, 0));
        if(s1 != null && s1.length() != 0) {
            spannableStringBuilder0.append(" ");
            spannableStringBuilder0.append(s1);
            spannableStringBuilder0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06015D)), spannableStringBuilder0.length() - s1.length(), spannableStringBuilder0.length(), 34);  // color:gray500s_support_high_contrast
        }
        return spannableStringBuilder0;
    }

    @Override  // com.iloen.melon.adapters.common.p
    public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
        if(o00 instanceof FeedLogsItemHolder) {
            Object object0 = this.getItem(v1);
            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.FeedLogsListRes.FEEDLOGLIST");
            if(((FEEDLOGLIST)object0).contsImg == null) {
                ((FeedLogsItemHolder)o00).getContentGroup().setVisibility(8);
            }
            else {
                ((FeedLogsItemHolder)o00).getContentGroup().setVisibility(0);
                q.d(Glide.with(this.getContext()).load(((FEEDLOGLIST)object0).contsImg).into(((FeedLogsItemHolder)o00).getContentImage()));
            }
            String s = ((FEEDLOGLIST)object0).actTitle;
            if(s == null || s.length() == 0) {
                ((FeedLogsItemHolder)o00).getMessage().setText("");
            }
            else if(((FeedLogsItemHolder)o00).getMessage() instanceof MoreExpandTextView) {
                MoreExpandTextView moreExpandTextView0 = (MoreExpandTextView)((FeedLogsItemHolder)o00).getMessage();
                String s1 = ((FEEDLOGLIST)object0).dateStr;
                q.f(s1, "dateStr");
                moreExpandTextView0.setExpandTitle(s1);
                MoreExpandTextView moreExpandTextView1 = (MoreExpandTextView)((FeedLogsItemHolder)o00).getMessage();
                String s2 = ((FEEDLOGLIST)object0).actTitle;
                q.f(s2, "actTitle");
                moreExpandTextView1.setText(this.makeSpannableText(s2, ((FEEDLOGLIST)object0).dateStr));
            }
            String s3 = ((FEEDLOGLIST)object0).profileImg;
            if(s3 == null || s3.length() == 0) {
                ((FeedLogsItemHolder)o00).getProfileImage().setImageDrawable(null);
            }
            else {
                q.d(Glide.with(this.getContext()).load(((FEEDLOGLIST)object0).profileImg).apply(RequestOptions.circleCropTransform()).into(((FeedLogsItemHolder)o00).getProfileImage()));
            }
            t0 t00 = new t0(this, v1, ((FEEDLOGLIST)object0), ((FeedLogsItemHolder)o00));
            ((FeedLogsItemHolder)o00).addAndStartViewableCheck(((FeedLogsItemHolder)o00).itemView, v1, t00);
            return;
        }
        if(o00 instanceof FeedLogsTitleHolder) {
            Object object1 = this.getItem(v1);
            q.e(object1, "null cannot be cast to non-null type com.iloen.melon.fragments.news.FeedLogsListAdapter.ServerDataWrapper");
            ((FeedLogsTitleHolder)o00).getTitle().setText(((ServerDataWrapper)object1).getTitle());
        }
    }

    private static final H onBindViewImpl$lambda$7(FeedLogsListAdapter feedLogsListAdapter0, int v, FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0, O0 o00) {
        int v1 = feedLogsListAdapter0.getDataPosition(v, feedLogsListRes$FEEDLOGLIST0.isToday());
        String s = feedLogsListRes$FEEDLOGLIST0.isToday() ? "오늘소식" : "이전소식";
        q.d(s);
        OnActionListener onActionListener0 = feedLogsListAdapter0.actionListener;
        if(onActionListener0 != null) {
            String s1 = ((FeedLogsItemHolder)o00).getImpLogKey(feedLogsListRes$FEEDLOGLIST0.rowKey);
            ViewImpContent viewImpContent0 = new Builder().impProvider("melon_recommend").impOrdNum(String.valueOf(v1 + 1)).layer1(s).id(feedLogsListRes$FEEDLOGLIST0.feedType).build();
            q.f(viewImpContent0, "build(...)");
            onActionListener0.onImpLogListener(s1, viewImpContent0);
        }
        return H.a;
    }

    @Override  // com.iloen.melon.adapters.common.p
    @NotNull
    public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
        if(v == this.VIEW_TYPE_ITEM) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0490, viewGroup0, false);  // layout:listitem_feed_logs
            q.f(view0, "inflate(...)");
            O0 o00 = new FeedLogsItemHolder(view0, this.actionListener);
            ((FeedLogsItemHolder)o00).getProfileImage().setOnClickListener(new a(this, ((FeedLogsItemHolder)o00), 0));
            ((FeedLogsItemHolder)o00).getContentImage().setOnClickListener(new a(this, ((FeedLogsItemHolder)o00), 1));
            ((FeedLogsItemHolder)o00).getMessage().setOnClickListener(new a(this, ((FeedLogsItemHolder)o00), 2));
            ((FeedLogsItemHolder)o00).getMessage().setOnLongClickListener(new n(1, this, o00));
            return o00;
        }
        if(v == this.VIEW_TYPE_TITLE) {
            View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D04B8, viewGroup0, false);  // layout:listitem_title_noarrow
            q.f(view1, "inflate(...)");
            return new FeedLogsTitleHolder(view1);
        }
        View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0490, viewGroup0, false);  // layout:listitem_feed_logs
        q.f(view2, "inflate(...)");
        return new FeedLogsItemHolder(view2, this.actionListener);
    }

    private static final void onCreateViewHolderImpl$lambda$6$lambda$2(FeedLogsListAdapter feedLogsListAdapter0, FeedLogsItemHolder feedLogsItemHolder0, View view0) {
        Object object0 = feedLogsListAdapter0.getItem(feedLogsItemHolder0.getBindingAdapterPosition());
        OnActionListener onActionListener0 = feedLogsListAdapter0.actionListener;
        if(onActionListener0 != null) {
            onActionListener0.onProfileClickListener(feedLogsItemHolder0.getBindingAdapterPosition(), (object0 instanceof FEEDLOGLIST ? ((FEEDLOGLIST)object0) : null));
        }
    }

    private static final void onCreateViewHolderImpl$lambda$6$lambda$3(FeedLogsListAdapter feedLogsListAdapter0, FeedLogsItemHolder feedLogsItemHolder0, View view0) {
        Object object0 = feedLogsListAdapter0.getItem(feedLogsItemHolder0.getBindingAdapterPosition());
        OnActionListener onActionListener0 = feedLogsListAdapter0.actionListener;
        if(onActionListener0 != null) {
            onActionListener0.onContentsClickListener(feedLogsItemHolder0.getBindingAdapterPosition(), (object0 instanceof FEEDLOGLIST ? ((FEEDLOGLIST)object0) : null));
        }
    }

    private static final void onCreateViewHolderImpl$lambda$6$lambda$4(FeedLogsListAdapter feedLogsListAdapter0, FeedLogsItemHolder feedLogsItemHolder0, View view0) {
        Object object0 = feedLogsListAdapter0.getItem(feedLogsItemHolder0.getBindingAdapterPosition());
        OnActionListener onActionListener0 = feedLogsListAdapter0.actionListener;
        if(onActionListener0 != null) {
            onActionListener0.onMessageClickListener(feedLogsItemHolder0.getBindingAdapterPosition(), (object0 instanceof FEEDLOGLIST ? ((FEEDLOGLIST)object0) : null));
        }
    }

    private static final boolean onCreateViewHolderImpl$lambda$6$lambda$5(FeedLogsListAdapter feedLogsListAdapter0, FeedLogsItemHolder feedLogsItemHolder0, View view0) {
        Object object0 = feedLogsListAdapter0.getItem(feedLogsItemHolder0.getBindingAdapterPosition());
        OnActionListener onActionListener0 = feedLogsListAdapter0.actionListener;
        if(onActionListener0 != null) {
            onActionListener0.onMessageLongClickListener(feedLogsItemHolder0.getBindingAdapterPosition(), (object0 instanceof FEEDLOGLIST ? ((FEEDLOGLIST)object0) : null));
        }
        return true;
    }

    public final void setActionListener(@NotNull OnActionListener onActionListener0) {
        q.g(onActionListener0, "actionListener");
        this.actionListener = onActionListener0;
    }
}

