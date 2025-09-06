package com.iloen.melon.fragments.musicmessage;

import Ad.s;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.custom.c;
import com.iloen.melon.net.v4x.common.TargetMemberInfoBase;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.CONTENTSLIST.TARGETMEMBERINFOLIST;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\'\u0010\u000E\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0011\u001A\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorYouViewHolder;", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorBaseViewHolder;", "Landroid/view/View;", "itemView", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;", "fragment", "<init>", "(Landroid/view/View;Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;)V", "Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;", "info", "", "adapterposition", "dataposition", "Lie/H;", "bindView", "(Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;II)V", "Landroid/widget/ImageView;", "btnReport", "Landroid/widget/ImageView;", "getBtnReport", "()Landroid/widget/ImageView;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicMessageEditorYouViewHolder extends MusicMessageEditorBaseViewHolder {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorYouViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "getLayoutRsId", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final int getLayoutRsId() [...] // Inlined contents
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "MusicMessageEditorYouViewHolder";
    @NotNull
    private final ImageView btnReport;

    static {
        MusicMessageEditorYouViewHolder.Companion = new Companion(null);
        MusicMessageEditorYouViewHolder.$stable = 8;
    }

    public MusicMessageEditorYouViewHolder(@NotNull View view0, @NotNull MusicMessageEditorFragment musicMessageEditorFragment0) {
        q.g(view0, "itemView");
        q.g(musicMessageEditorFragment0, "fragment");
        super(view0, musicMessageEditorFragment0);
        View view1 = view0.findViewById(0x7F0A01A0);  // id:btn_report
        q.f(view1, "findViewById(...)");
        this.btnReport = (ImageView)view1;
    }

    public void bindView(@NotNull CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, int v, int v1) {
        int v2;
        q.g(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, "info");
        if(this.isContentListValid(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) && this.isFragmentValid(this.getFragment())) {
            String s = null;
            boolean z = false;
            String s1 = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.targetmemberinfolist == null || musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.targetmemberinfolist.size() <= 0 ? null : ((TargetMemberInfoBase)musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.targetmemberinfolist.get(0)).targetmemberkey;
            boolean z1 = Receiver.d(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.targetmemberinfolist);
            ArrayList arrayList0 = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.targetmemberinfolist;
            if(arrayList0 != null && arrayList0.size() > 0) {
                s = ((TargetMemberInfoBase)arrayList0.get(0)).targetpageimg;
            }
            String s2 = Receiver.c(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.targetmemberinfolist);
            if(this.getAdapter().isSameDate(v1)) {
                ViewUtils.showWhen(this.getItemDateSeperatorContainer(), false);
            }
            else {
                ViewUtils.showWhen(this.getItemDateSeperatorContainer(), true);
                TextView textView0 = this.getTvSeperateDay();
                if(textView0 != null) {
                    textView0.setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.regdateformat);
                }
            }
            if(v1 == this.getAdapter().getCount() - 1) {
                this.setLastSeperatorVisibility(0);
            }
            else {
                this.setLastSeperatorVisibility(8);
            }
            if(this.getAdapter().isSamePerson(v1)) {
                this.setPersonSeperatorVisibility(8);
                this.setPersonInfoVisibility(4);
            }
            else {
                if(v1 == 0) {
                    this.setPersonSeperatorVisibility(8);
                }
                else {
                    this.setPersonSeperatorVisibility(0);
                }
                this.setPersonInfoVisibility(0);
                if(this.getThumbCircleContainer() != null) {
                    if(this.getIvThumbCircle() != null) {
                        Glide.with(this.getIvThumbCircle().getContext()).load(s).apply(RequestOptions.circleCropTransform()).into(this.getIvThumbCircle());
                    }
                    MelonAppBase.Companion.getClass();
                    q.f("%s 회원 이미지", "getString(...)");
                    String s3 = String.format("%s 회원 이미지", Arrays.copyOf(new Object[]{s2}, 1));
                    if(!TextUtils.isEmpty(s3)) {
                        this.getThumbCircleContainer().setContentDescription(s3);
                    }
                    ViewUtils.setOnClickListener(this.getThumbCircleContainer(), new g(s1, z1, 0));
                }
                if(this.getTvNickname() != null) {
                    this.getTvNickname().setText(s2);
                }
            }
            if(this.getTvDate() != null) {
                this.getTvDate().setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.updatetime);
            }
            if(this.getAdapter().isInEditMode()) {
                ViewUtils.showWhen(this.getBtnDelete(), true);
                ViewUtils.hideWhen(this.btnReport, true);
                ViewUtils.setOnClickListener(this.getBtnDelete(), new c(this, v, v1, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, 3));
            }
            else {
                ViewUtils.hideWhen(this.getBtnDelete(), true);
                try {
                    ArrayList arrayList1 = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.targetmemberinfolist;
                    if(arrayList1 == null) {
                    label_57:
                        v2 = 0;
                    }
                    else {
                        TARGETMEMBERINFOLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST$TARGETMEMBERINFOLIST0 = (TARGETMEMBERINFOLIST)arrayList1.get(0);
                        if(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST$TARGETMEMBERINFOLIST0 != null) {
                            String s4 = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST$TARGETMEMBERINFOLIST0.targetmemberkey;
                            if(s4 != null) {
                                v2 = Integer.parseInt(s4);
                                goto label_58;
                            }
                        }
                        goto label_57;
                    }
                }
                catch(Exception unused_ex) {
                    goto label_57;
                }
            label_58:
                ImageView imageView0 = this.btnReport;
                if(q.b(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.contstypecode, "TEXT") && v2 > 0) {
                    z = true;
                }
                ViewUtils.showWhen(imageView0, z);
                s s5 = new s(26, this, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0);
                ViewUtils.setOnClickListener(this.btnReport, s5);
            }
            if(this.getMessageContainer() != null) {
                this.addContentsView(this.getMessageContainer(), musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0);
            }
            ViewUtils.showWhen(this.getMainContainer(), true);
        }
    }

    @Override  // com.iloen.melon.fragments.musicmessage.MusicMessageBaseViewHolder
    public void bindView(Object object0, int v, int v1) {
        this.bindView(((CONTENTSLIST)object0), v, v1);
    }

    private static final void bindView$lambda$0(String s, boolean z, View view0) {
        Navigator.openUserMain(s, z);
    }

    private static final void bindView$lambda$1(MusicMessageEditorYouViewHolder musicMessageEditorYouViewHolder0, int v, int v1, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, View view0) {
        musicMessageEditorYouViewHolder0.getFragment().deleteItem(v, v1, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0);
    }

    private static final void bindView$lambda$2(MusicMessageEditorYouViewHolder musicMessageEditorYouViewHolder0, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, View view0) {
        MusicMessageEditorFragment musicMessageEditorFragment0 = musicMessageEditorYouViewHolder0.getFragment();
        String s = musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.musicmesgseq;
        q.f(s, "musicmesgseq");
        musicMessageEditorFragment0.reportServer(s);
    }

    public static void c(MusicMessageEditorYouViewHolder musicMessageEditorYouViewHolder0, int v, int v1, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, View view0) {
        MusicMessageEditorYouViewHolder.bindView$lambda$1(musicMessageEditorYouViewHolder0, v, v1, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, view0);
    }

    @NotNull
    public final ImageView getBtnReport() {
        return this.btnReport;
    }

    public static final int getLayoutRsId() {
        return 0x7F0D055E;  // layout:musicmessage_editor_list_item_you
    }
}

