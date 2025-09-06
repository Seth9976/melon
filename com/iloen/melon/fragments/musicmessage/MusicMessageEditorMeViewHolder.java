package com.iloen.melon.fragments.musicmessage;

import android.view.View;
import android.widget.TextView;
import com.iloen.melon.custom.c;
import com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\'\u0010\u000E\u001A\u00020\r2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorMeViewHolder;", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorBaseViewHolder;", "Landroid/view/View;", "itemView", "Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;", "fragment", "<init>", "(Landroid/view/View;Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorFragment;)V", "Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;", "info", "", "adapterposition", "dataposition", "Lie/H;", "bindView", "(Lcom/iloen/melon/net/v4x/response/MusicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST;II)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MusicMessageEditorMeViewHolder extends MusicMessageEditorBaseViewHolder {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/musicmessage/MusicMessageEditorMeViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "getLayoutRsId", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
    public static final String TAG = "MusicMessageEditorMeViewHolder";

    static {
        MusicMessageEditorMeViewHolder.Companion = new Companion(null);
        MusicMessageEditorMeViewHolder.$stable = 8;
    }

    public MusicMessageEditorMeViewHolder(@NotNull View view0, @NotNull MusicMessageEditorFragment musicMessageEditorFragment0) {
        q.g(view0, "itemView");
        q.g(musicMessageEditorFragment0, "fragment");
        super(view0, musicMessageEditorFragment0);
    }

    public static void b(MusicMessageEditorMeViewHolder musicMessageEditorMeViewHolder0, int v, int v1, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, View view0) {
        MusicMessageEditorMeViewHolder.bindView$lambda$0(musicMessageEditorMeViewHolder0, v, v1, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, view0);
    }

    public void bindView(@NotNull CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, int v, int v1) {
        q.g(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, "info");
        if(this.isContentListValid(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0) && this.isFragmentValid(this.getFragment())) {
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
            }
            else if(v1 == 0) {
                this.setPersonSeperatorVisibility(8);
            }
            else {
                this.setPersonSeperatorVisibility(0);
            }
            this.setPersonInfoVisibility(8);
            if(this.getTvDate() != null) {
                this.getTvDate().setText(musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0.updatetime);
            }
            if(this.getAdapter().isInEditMode()) {
                ViewUtils.showWhen(this.getBtnDelete(), true);
                ViewUtils.setOnClickListener(this.getBtnDelete(), new c(this, v, v1, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, 2));
            }
            else {
                ViewUtils.showWhen(this.getBtnDelete(), false);
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

    private static final void bindView$lambda$0(MusicMessageEditorMeViewHolder musicMessageEditorMeViewHolder0, int v, int v1, CONTENTSLIST musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0, View view0) {
        musicMessageEditorMeViewHolder0.getFragment().deleteItem(v, v1, musicMessageListMusicMsgInboxContentsRes$RESPONSE$CONTENTSLIST0);
    }

    public static final int getLayoutRsId() {
        return 0x7F0D055D;  // layout:musicmessage_editor_list_item_me
    }
}

