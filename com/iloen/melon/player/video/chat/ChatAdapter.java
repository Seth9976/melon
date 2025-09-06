package com.iloen.melon.player.video.chat;

import De.I;
import H0.b;
import J8.C1;
import J8.D1;
import P1.c;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.google.gson.n;
import com.google.gson.x;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO.USER;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response;
import com.iloen.melon.utils.DateUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakaoent.leonchat.data.messages.ArtistMessageEntity;
import com.kakaoent.leonchat.data.messages.ErrorMessageMessageEntity;
import com.kakaoent.leonchat.data.messages.InputMessage;
import com.kakaoent.leonchat.data.messages.MessageEntity;
import com.kakaoent.leonchat.data.messages.NoticeMessageEntity;
import com.kakaoent.leonchat.data.messages.UserMessageEntity;
import e1.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;
import x1.a;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005./012B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000F\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0018\u001A\u00020\u00022\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u001A\u001A\u00020\u00022\u0006\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\u000F\u0010\u001D\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ\u001D\u0010\"\u001A\u00020\u000B2\u000E\u0010!\u001A\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001F¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001A\u00020\u000B¢\u0006\u0004\b$\u0010%R$\u0010-\u001A\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u00063"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatAdapter;", "Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/O0;", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "fragment", "", "isFullMode", "<init>", "(Lcom/iloen/melon/fragments/MelonBaseFragment;Z)V", "Lcom/iloen/melon/player/video/chat/ChatAdapter$OnItemLongClickListener;", "listener", "Lie/H;", "setOnItemLongClickListener", "(Lcom/iloen/melon/player/video/chat/ChatAdapter$OnItemLongClickListener;)V", "Lcom/iloen/melon/player/video/chat/ChatAdapter$OnDataChangedListener;", "setOnDataChangedListener", "(Lcom/iloen/melon/player/video/chat/ChatAdapter$OnDataChangedListener;)V", "", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;I)V", "getItemCount", "()I", "", "Lcom/kakaoent/leonchat/data/messages/MessageEntity;", "list", "addMessageList", "(Ljava/util/List;)V", "clearMessageList", "()V", "Lcom/iloen/melon/net/v6x/response/LiveChatRes$Response;", "f", "Lcom/iloen/melon/net/v6x/response/LiveChatRes$Response;", "getResponse", "()Lcom/iloen/melon/net/v6x/response/LiveChatRes$Response;", "setResponse", "(Lcom/iloen/melon/net/v6x/response/LiveChatRes$Response;)V", "response", "Companion", "OnItemLongClickListener", "OnDataChangedListener", "NotificationMessageHolder", "MessageHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ChatAdapter extends j0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000B\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatAdapter$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "POPUP_INDEX_REPORT_PROFILE", "I", "POPUP_INDEX_REPORT_CHAT", "VIEW_TYPE_NOTIFICATION", "VIEW_TYPE_USER_MESSAGE", "VIEW_TYPE_MESSAGE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatAdapter$MessageHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/C1;", "binding", "<init>", "(Lcom/iloen/melon/player/video/chat/ChatAdapter;LJ8/C1;)V", "a", "LJ8/C1;", "getBinding", "()LJ8/C1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class MessageHolder extends O0 {
        public final C1 a;

        public MessageHolder(@NotNull C1 c10) {
            q.g(c10, "binding");
            super(c10.a);
            this.a = c10;
            Context context0 = c10.a.getContext();
            int v = ColorUtils.getColor(context0, (chatAdapter0.b ? 0x7F0604A1 : 0x7F06016D));  // color:white000e
            c10.e.setTextColor(v);
            c10.c.setBackgroundColor(ColorUtils.getColor(context0, (chatAdapter0.b ? 0x7F060144 : 0x7F060145)));  // color:gray050e
            c10.c.setStrokeColorResource((chatAdapter0.b ? 0x7F0604AE : 0x7F06014A));  // color:white120e
        }

        @NotNull
        public final C1 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatAdapter$NotificationMessageHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/D1;", "binding", "<init>", "(Lcom/iloen/melon/player/video/chat/ChatAdapter;LJ8/D1;)V", "a", "LJ8/D1;", "getBinding", "()LJ8/D1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class NotificationMessageHolder extends O0 {
        public final D1 a;

        public NotificationMessageHolder(@NotNull D1 d10) {
            q.g(d10, "binding");
            super(d10.a);
            this.a = d10;
            Context context0 = d10.a.getContext();
            int v = ColorUtils.getColor(context0, (chatAdapter0.b ? 0x7F0604B7 : 0x7F060163));  // color:white700e
            d10.c.setTextColor(v);
            Drawable drawable0 = c.getDrawable(context0, (chatAdapter0.b ? 0x7F0808D0 : 0x7F0808A8));  // drawable:shape_rectangle_gray200e_round4
            d10.b.setBackground(drawable0);
        }

        @NotNull
        public final D1 getBinding() {
            return this.a;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatAdapter$OnDataChangedListener;", "", "", "forceDownScroll", "Lie/H;", "onDataChangedListener", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnDataChangedListener {
        void onDataChangedListener(boolean arg1);
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/video/chat/ChatAdapter$OnItemLongClickListener;", "", "Lcom/kakaoent/leonchat/data/messages/InputMessage;", "message", "Lcom/iloen/melon/net/v6x/response/LiveChatRes$Response$CHATSDKINFO$USER;", "userData", "Lie/H;", "onItemLongClick", "(Lcom/kakaoent/leonchat/data/messages/InputMessage;Lcom/iloen/melon/net/v6x/response/LiveChatRes$Response$CHATSDKINFO$USER;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnItemLongClickListener {
        void onItemLongClick(@NotNull InputMessage arg1, @NotNull USER arg2);
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int POPUP_INDEX_REPORT_CHAT = 1;
    public static final int POPUP_INDEX_REPORT_PROFILE;
    public final MelonBaseFragment a;
    public final boolean b;
    public final ArrayList c;
    public OnItemLongClickListener d;
    public OnDataChangedListener e;
    public Response f;

    static {
        ChatAdapter.Companion = new Companion(null);
        ChatAdapter.$stable = 8;
    }

    public ChatAdapter(@NotNull MelonBaseFragment melonBaseFragment0, boolean z) {
        q.g(melonBaseFragment0, "fragment");
        super();
        this.a = melonBaseFragment0;
        this.b = z;
        this.c = new ArrayList();
    }

    public final void a(boolean z, MessageHolder chatAdapter$MessageHolder0) {
        Context context0 = this.a.requireContext();
        q.f(context0, "requireContext(...)");
        if(z) {
            Drawable drawable0 = c.getDrawable(context0, (this.b ? 0x7F0808D0 : 0x7F0808A8));  // drawable:shape_rectangle_gray200e_round4
            chatAdapter$MessageHolder0.getBinding().b.setBackground(drawable0);
            a.I(chatAdapter$MessageHolder0.getBinding().d, null, 7.0f, null, 7.0f);
            return;
        }
        chatAdapter$MessageHolder0.getBinding().b.setBackgroundResource(0x7F08093C);  // drawable:transparent
        a.I(chatAdapter$MessageHolder0.getBinding().d, null, 0.0f, null, 0.0f);
    }

    public final void addMessageList(@Nullable List list0) {
        if(list0 != null && !list0.isEmpty()) {
            ArrayList arrayList0 = this.c;
            int v = arrayList0.size();
            arrayList0.addAll(list0);
            VideoChatHelper videoChatHelper0 = VideoChatHelper.INSTANCE;
            boolean z = videoChatHelper0.isOverLimit(arrayList0);
            if(z) {
                int v1 = videoChatHelper0.handleOverMessageCount(arrayList0);
                if(v1 > 0) {
                    this.notifyItemRangeRemoved(0, v1);
                }
            }
            else {
                this.notifyItemRangeInserted(v, arrayList0.size());
            }
            OnDataChangedListener chatAdapter$OnDataChangedListener0 = this.e;
            if(chatAdapter$OnDataChangedListener0 != null) {
                chatAdapter$OnDataChangedListener0.onDataChangedListener(z);
            }
        }
    }

    public final void clearMessageList() {
        this.c.clear();
        this.notifyDataSetChanged();
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemCount() {
        return this.c.size();
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemViewType(int v) {
        MessageEntity messageEntity0 = (MessageEntity)this.c.get(v);
        if(messageEntity0 instanceof NoticeMessageEntity) {
            return 1;
        }
        return messageEntity0 instanceof UserMessageEntity || messageEntity0 instanceof ArtistMessageEntity ? 2 : 3;
    }

    @Nullable
    public final Response getResponse() {
        return this.f;
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(@NotNull O0 o00, int v) {
        String s11;
        String s8;
        String s5;
        String s2;
        q.g(o00, "holder");
        MessageEntity messageEntity0 = (MessageEntity)this.c.get(v);
        if(messageEntity0 instanceof NoticeMessageEntity) {
            Log.i("ChatAdapter", "NoticeMessageEntity message : " + ((NoticeMessageEntity)messageEntity0).d());
            D1 d10 = ((NotificationMessageHolder)o00).getBinding();
            String s = ((NoticeMessageEntity)messageEntity0).d();
            d10.c.setText(s);
            return;
        }
        boolean z = this.b;
        Class class0 = USER.class;
        MelonBaseFragment melonBaseFragment0 = this.a;
        if(messageEntity0 instanceof UserMessageEntity) {
            boolean z1 = "ID_MADE_BY_CLIENT".equals(((UserMessageEntity)messageEntity0).c());
            this.a(z1, ((MessageHolder)o00));
            Log.i("ChatAdapter", "UserMessageEntity message : " + ((UserMessageEntity)messageEntity0).f());
            String s1 = DateUtils.getZonedTimeHhmm(((UserMessageEntity)messageEntity0).d());
            n n0 = new n();
            Map map0 = ((UserMessageEntity)messageEntity0).e().a();
            Object object0 = map0 == null ? null : map0.get("melonUser");
            H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            try {
                h0.a = n0.e(n0.k(object0), class0);
            }
            catch(x x0) {
                b.w("onBindViewHolder(), UserMessageEntity e = ", x0.getMessage(), LogU.Companion, "ChatAdapter");
            }
            Context context0 = melonBaseFragment0.getContext();
            if(context0 != null) {
                Drawable drawable0 = c.getDrawable(context0, (z ? 0x7F0807A4 : 0x7F0807A3));  // drawable:noimage_person_xxmini_w
                RequestManager requestManager0 = Glide.with(context0);
                USER liveChatRes$Response$CHATSDKINFO$USER0 = (USER)h0.a;
                ((RequestBuilder)((RequestBuilder)requestManager0.load((liveChatRes$Response$CHATSDKINFO$USER0 == null ? null : liveChatRes$Response$CHATSDKINFO$USER0.imgUrl)).error(drawable0)).placeholder(drawable0)).into(((MessageHolder)o00).getBinding().c);
            }
            USER liveChatRes$Response$CHATSDKINFO$USER1 = (USER)h0.a;
            if(liveChatRes$Response$CHATSDKINFO$USER1 == null) {
                s2 = ((UserMessageEntity)messageEntity0).e().c();
            }
            else {
                s2 = liveChatRes$Response$CHATSDKINFO$USER1.name;
                if(s2 == null) {
                    s2 = ((UserMessageEntity)messageEntity0).e().c();
                }
            }
            USER liveChatRes$Response$CHATSDKINFO$USER2 = (USER)h0.a;
            boolean z2 = q.b((liveChatRes$Response$CHATSDKINFO$USER2 == null ? null : liveChatRes$Response$CHATSDKINFO$USER2.memberkey), u.v(((e0)o.a()).j()));
            MelonTextView melonTextView0 = ((MessageHolder)o00).getBinding().e;
            VideoChatHelper videoChatHelper0 = VideoChatHelper.INSTANCE;
            Context context1 = melonBaseFragment0.requireContext();
            q.f(context1, "requireContext(...)");
            String s3 = VideoChatHelperKt.replaceSpaceToNbsp(s2);
            USER liveChatRes$Response$CHATSDKINFO$USER3 = (USER)h0.a;
            if(liveChatRes$Response$CHATSDKINFO$USER3 == null) {
                s5 = "";
            }
            else {
                String s4 = liveChatRes$Response$CHATSDKINFO$USER3.degree;
                s5 = s4 == null ? "" : s4;
            }
            String s6 = VideoChatHelperKt.replaceSpaceToNbsp(VideoChatHelperKt.executeBlindWord(((UserMessageEntity)messageEntity0).f()));
            q.d(s1);
            USER liveChatRes$Response$CHATSDKINFO$USER4 = (USER)h0.a;
            melonTextView0.setText(videoChatHelper0.getChatMessageSpan(context1, this.b, s3, s5, s6, s1, (liveChatRes$Response$CHATSDKINFO$USER4 == null ? false : liveChatRes$Response$CHATSDKINFO$USER4.isArtist), z2));
            com.iloen.melon.player.video.chat.a a0 = new com.iloen.melon.player.video.chat.a(h0, z2, z1, this, ((UserMessageEntity)messageEntity0), 0);
            ViewUtils.setOnLongClickListener(((MessageHolder)o00).getBinding().a, a0);
            return;
        }
        if(messageEntity0 instanceof ArtistMessageEntity) {
            boolean z3 = "ID_MADE_BY_CLIENT".equals(((ArtistMessageEntity)messageEntity0).c());
            this.a(z3, ((MessageHolder)o00));
            Log.i("ChatAdapter", "ArtistMessageEntity message : " + ((ArtistMessageEntity)messageEntity0).f());
            String s7 = DateUtils.getZonedTimeHhmm(((ArtistMessageEntity)messageEntity0).d());
            n n1 = new n();
            Map map1 = ((ArtistMessageEntity)messageEntity0).e().a();
            Object object1 = map1 == null ? null : map1.get("melonUser");
            H h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
            try {
                h1.a = n1.e(n1.k(object1), class0);
            }
            catch(x x1) {
                b.w("onBindViewHolder(), UserMessageEntity e = ", x1.getMessage(), LogU.Companion, "ChatAdapter");
            }
            Context context2 = melonBaseFragment0.getContext();
            if(context2 != null) {
                Drawable drawable1 = c.getDrawable(context2, (z ? 0x7F0807A4 : 0x7F0807A3));  // drawable:noimage_person_xxmini_w
                RequestManager requestManager1 = Glide.with(context2);
                USER liveChatRes$Response$CHATSDKINFO$USER5 = (USER)h1.a;
                ((RequestBuilder)((RequestBuilder)requestManager1.load((liveChatRes$Response$CHATSDKINFO$USER5 == null ? null : liveChatRes$Response$CHATSDKINFO$USER5.imgUrl)).error(drawable1)).placeholder(drawable1)).into(((MessageHolder)o00).getBinding().c);
            }
            USER liveChatRes$Response$CHATSDKINFO$USER6 = (USER)h1.a;
            if(liveChatRes$Response$CHATSDKINFO$USER6 == null) {
                s8 = ((ArtistMessageEntity)messageEntity0).e().c();
            }
            else {
                s8 = liveChatRes$Response$CHATSDKINFO$USER6.name;
                if(s8 == null) {
                    s8 = ((ArtistMessageEntity)messageEntity0).e().c();
                }
            }
            USER liveChatRes$Response$CHATSDKINFO$USER7 = (USER)h1.a;
            boolean z4 = q.b((liveChatRes$Response$CHATSDKINFO$USER7 == null ? null : liveChatRes$Response$CHATSDKINFO$USER7.memberkey), u.v(((e0)o.a()).j()));
            MelonTextView melonTextView1 = ((MessageHolder)o00).getBinding().e;
            VideoChatHelper videoChatHelper1 = VideoChatHelper.INSTANCE;
            Context context3 = melonBaseFragment0.requireContext();
            q.f(context3, "requireContext(...)");
            String s9 = VideoChatHelperKt.replaceSpaceToNbsp(s8);
            USER liveChatRes$Response$CHATSDKINFO$USER8 = (USER)h1.a;
            if(liveChatRes$Response$CHATSDKINFO$USER8 == null) {
                s11 = "";
            }
            else {
                String s10 = liveChatRes$Response$CHATSDKINFO$USER8.degree;
                s11 = s10 == null ? "" : s10;
            }
            String s12 = VideoChatHelperKt.replaceSpaceToNbsp(VideoChatHelperKt.executeBlindWord(((ArtistMessageEntity)messageEntity0).f()));
            q.d(s7);
            melonTextView1.setText(videoChatHelper1.getChatMessageSpan(context3, this.b, s9, s11, s12, s7, true, z4));
            com.iloen.melon.player.video.chat.a a1 = new com.iloen.melon.player.video.chat.a(h1, z4, z3, this, ((ArtistMessageEntity)messageEntity0), 1);
            ViewUtils.setOnLongClickListener(((MessageHolder)o00).getBinding().a, a1);
            return;
        }
        if(messageEntity0 instanceof ErrorMessageMessageEntity) {
            ToastManager.debug(("ERROR - code : " + ((ErrorMessageMessageEntity)messageEntity0).b() + "   /   reason : " + ((ErrorMessageMessageEntity)messageEntity0).c()));
            LogU.Companion.d("ChatAdapter", "onBindViewHolder() - " + messageEntity0);
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    @NotNull
    public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        switch(v) {
            case 1: {
                View view0 = androidx.appcompat.app.o.e(viewGroup0, 0x7F0D0473, viewGroup0, false);  // layout:listitem_chat_message_notification
                MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0CD2);  // id:tv_notification_message
                if(melonTextView0 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0CD2));  // id:tv_notification_message
                }
                return new NotificationMessageHolder(this, new D1(((RelativeLayout)view0), ((RelativeLayout)view0), melonTextView0));
            }
            case 2: {
                return new MessageHolder(this, C1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0));
            }
            default: {
                return new MessageHolder(this, C1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0));
            }
        }
    }

    public final void setOnDataChangedListener(@NotNull OnDataChangedListener chatAdapter$OnDataChangedListener0) {
        q.g(chatAdapter$OnDataChangedListener0, "listener");
        this.e = chatAdapter$OnDataChangedListener0;
    }

    public final void setOnItemLongClickListener(@NotNull OnItemLongClickListener chatAdapter$OnItemLongClickListener0) {
        q.g(chatAdapter$OnItemLongClickListener0, "listener");
        this.d = chatAdapter$OnItemLongClickListener0;
    }

    public final void setResponse(@Nullable Response liveChatRes$Response0) {
        this.f = liveChatRes$Response0;
    }
}

