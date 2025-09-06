package com.iloen.melon.popup;

import F8.m;
import F8.o;
import F8.p;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.custom.J0;
import com.iloen.melon.custom.K0;
import com.iloen.melon.custom.PlaylistCreatingInputBarView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.detail.PlaylistMakeFragment;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.playlist.PlaylistDetailFactoryBase;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import v9.d;

public class AddToPlaylistPopup extends AbsListPopup implements ForegroundPopup {
    class ItemViewHolder extends O0 {
        protected View layoutItemContainer;
        protected TextView tvSongCnt;
        protected TextView tvText;
        protected View vBottomLine;

        public ItemViewHolder(View view0) {
            super(view0);
            View view1 = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
            this.layoutItemContainer = view1;
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view1.getLayoutParams();
            viewGroup$MarginLayoutParams0.setMargins(ScreenUtils.dipToPixel(addToPlaylistPopup0.getContext(), 20.0f), viewGroup$MarginLayoutParams0.topMargin, viewGroup$MarginLayoutParams0.rightMargin, viewGroup$MarginLayoutParams0.bottomMargin);
            this.tvText = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
            this.tvSongCnt = (TextView)view0.findViewById(0x7F0A0C50);  // id:tv_count
            this.vBottomLine = view0.findViewById(0x7F0A0D6B);  // id:underline
        }
    }

    public interface OnMenuItemClickListener {
        void onItemClick(ContextItemInfo arg1, ContextItemType arg2, Params arg3);
    }

    public interface PopupClickListener {
        void onAddNewListEvent(String arg1, String arg2);

        void onClickListItemEvent(int arg1, ContextItemInfo arg2);

        void onMoveToDjPlaylistEvent();
    }

    class PopupPlaylistAdapter extends j0 {
        public ArrayList a;
        public final AddToPlaylistPopup b;

        public PopupPlaylistAdapter(Context context0) {
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemCount() {
            return this.a == null ? 0 : this.a.size();
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            return 0;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(O0 o00, int v) {
            if(!(o00 instanceof ItemViewHolder) || v > this.a.size()) {
                return;
            }
            d d0 = (d)((ContextItemInfo)this.a.get(v)).a;
            if(d0 != null) {
                ((ItemViewHolder)o00).tvText.setText(d0.R);
                ((ItemViewHolder)o00).tvText.requestLayout();
                ((ItemViewHolder)o00).tvSongCnt.setText(StringUtils.getCountFormattedString(d0.S));
            }
            ViewUtils.hideWhen(((ItemViewHolder)o00).vBottomLine, v == this.a.size());
            ViewUtils.setOnClickListener(((ItemViewHolder)o00).layoutItemContainer, new View.OnClickListener() {
                public final int a;
                public final PopupPlaylistAdapter b;

                {
                    int v = v;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                    this.b = addToPlaylistPopup$PopupPlaylistAdapter0;
                    this.a = v;
                }

                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    PopupClickListener addToPlaylistPopup$PopupClickListener0 = AddToPlaylistPopup.this.d;
                    ContextItemInfo contextItemInfo0 = (ContextItemInfo)this.b.a.get(this.a);
                    addToPlaylistPopup$PopupClickListener0.onClickListItemEvent(this.a, contextItemInfo0);
                    AddToPlaylistPopup.this.getClass();
                    AddToPlaylistPopup.this.a = null;
                    AddToPlaylistPopup.this.dismiss();
                }
            });
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            View view0 = AddToPlaylistPopup.this.getLayoutInflater().inflate(0x7F0D0499, viewGroup0, false);  // layout:listitem_local_playlist
            return new ItemViewHolder(AddToPlaylistPopup.this, view0);
        }

        public void setContextItems(ArrayList arrayList0) {
            this.a = arrayList0;
        }
    }

    public PopupPlaylistAdapter a;
    public TitleBar b;
    public PlaylistCreatingInputBarView c;
    public PopupClickListener d;
    public final String e;
    public String f;

    public AddToPlaylistPopup(Activity activity0) {
        super(activity0);
        this.a = new PopupPlaylistAdapter(this, this.getContext());
        this.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
    }

    public AddToPlaylistPopup(Activity activity0, String s) {
        super(activity0);
        this.e = s;
        this.a = new PopupPlaylistAdapter(this, this.getContext());
        this.setBackgroundColor(ColorUtils.getColor(this.getContext(), 0x7F0604AA));  // color:white000s_support_high_contrast
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public j0 createAdapter(Context context0) {
        if(this.a == null) {
            this.a = new PopupPlaylistAdapter(this, context0);
        }
        return this.a;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public int getLayoutView() {
        return 0x7F0D002C;  // layout:add_to_playlist_popup_layout
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Window window0 = this.getWindow();
        if(window0 != null) {
            WindowManager.LayoutParams windowManager$LayoutParams0 = window0.getAttributes();
            windowManager$LayoutParams0.windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
            windowManager$LayoutParams0.width = -1;
            windowManager$LayoutParams0.height = -1;
            windowManager$LayoutParams0.flags = 0x400;
            window0.setAttributes(windowManager$LayoutParams0);
        }
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public void onViewCreated() {
        super.onViewCreated();
        TitleBar titleBar0 = (TitleBar)this.findViewById(0x7F0A0BAD);  // id:titlebar
        this.b = titleBar0;
        m m0 = new m(2, false);
        p p0 = new p(1);
        p0.c = new View.OnClickListener() {
            public final AddToPlaylistPopup a;

            {
                this.a = addToPlaylistPopup0;
            }

            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                this.a.a = null;
                this.a.cancel();
            }
        };
        o[] arr_o = {m0, p0};
        o o0 = null;
        for(int v = 0; v < 2; ++v) {
            o o1 = arr_o[v];
            if(o0 == null) {
                o0 = o1;
            }
            else {
                o0.g(o1);
            }
        }
        titleBar0.a(o0);
        this.b.f(true);
        this.b.setTitle(this.getTitle());
        PlaylistCreatingInputBarView playlistCreatingInputBarView0 = (PlaylistCreatingInputBarView)this.findViewById(0x7F0A0581);  // id:inputBarView
        this.c = playlistCreatingInputBarView0;
        playlistCreatingInputBarView0.setPlaylistType(this.e);
        this.c.setDefaultPlayListTitle(this.f);
        if(this.e != null && "M20002".equals(this.e)) {
            this.c.setOnCreateListListener(new K0() {
                public final AddToPlaylistPopup a;

                {
                    this.a = addToPlaylistPopup0;
                }

                @Override  // com.iloen.melon.custom.K0
                public void onNewListButtonClicked() {
                    this.a.d.onMoveToDjPlaylistEvent();
                    this.a.a = null;
                    this.a.dismiss();
                }
            });
            return;
        }
        this.c.setOnClickListener(new J0() {
            public final AddToPlaylistPopup a;

            {
                this.a = addToPlaylistPopup0;
            }

            @Override  // com.iloen.melon.custom.J0
            public boolean onComplete(PlaylistCreatingInputBarView playlistCreatingInputBarView0, String s) {
                if(TextUtils.isEmpty(s)) {
                    ToastManager.show(0x7F13034F);  // string:djplaylist_alert_input_title "제목을 입력해주세요."
                    return true;
                }
                AddToPlaylistPopup addToPlaylistPopup0 = this.a;
                PopupClickListener addToPlaylistPopup$PopupClickListener0 = addToPlaylistPopup0.d;
                if(addToPlaylistPopup$PopupClickListener0 != null) {
                    addToPlaylistPopup$PopupClickListener0.onAddNewListEvent(s, addToPlaylistPopup0.e);
                    addToPlaylistPopup0.a = null;
                    addToPlaylistPopup0.dismiss();
                }
                return true;
            }

            @Override  // com.iloen.melon.custom.J0
            public void onEditStart(PlaylistCreatingInputBarView playlistCreatingInputBarView0) {
            }

            @Override  // com.iloen.melon.custom.J0
            public void onEditStop(PlaylistCreatingInputBarView playlistCreatingInputBarView0) {
            }
        });
    }

    public void setAdapter(PopupPlaylistAdapter addToPlaylistPopup$PopupPlaylistAdapter0) {
        this.a = addToPlaylistPopup$PopupPlaylistAdapter0;
    }

    public void setListItems(ArrayList arrayList0) {
        this.a.setContextItems(arrayList0);
        this.a.notifyDataSetChanged();
    }

    public void setOnPopupClickListener(PopupClickListener addToPlaylistPopup$PopupClickListener0) {
        this.d = addToPlaylistPopup$PopupClickListener0;
    }

    public void setPlayListTitle(String s) {
        this.f = s;
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public boolean setPopupHeight() {
        return false;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    @NotNull
    public WindowManager.LayoutParams setWindowLayoutParams(WindowManager.LayoutParams windowManager$LayoutParams0) {
        windowManager$LayoutParams0.gravity = 80;
        windowManager$LayoutParams0.width = -1;
        return windowManager$LayoutParams0;
    }

    @Override  // com.iloen.melon.popup.AbsListPopup
    public void showEmptyView(boolean z) {
        super.showEmptyView(z);
        View view0 = this.getShowingView();
        if(z && view0 != null && PlaylistDetailFactoryBase.isValidPlylstType(this.e).booleanValue()) {
            ViewUtils.showWhen(view0.findViewById(0x7F0A042B), true);  // id:empty_layout
            View view1 = view0.findViewById(0x7F0A042D);  // id:empty_scrollview_container
            view1.setPadding(view1.getPaddingLeft(), view1.getPaddingTop(), view1.getPaddingRight(), ((int)this.getContext().getResources().getDimension(0x7F070111)));  // dimen:empty_or_network_error_layout_top_margin
            ViewUtils.showWhen(view0.findViewById(0x7F0A042A), true);  // id:empty_image
            TextView textView0 = (TextView)view0.findViewById(0x7F0A042F);  // id:empty_text
            textView0.setText(0x7F130819);  // string:playlist_add_popup_empty_text "자주 듣는 곡을\n플레이리스트로 만들어 보세요!"
            ViewUtils.showWhen(textView0, true);
            TextView textView1 = (TextView)view0.findViewById(0x7F0A042E);  // id:empty_sub_text
            textView1.setText(0x7F130818);  // string:playlist_add_popup_empty_sub_text "나만의 플레이리스트를 관리할 수 있어요."
            ViewUtils.showWhen(textView1, true);
            TextView textView2 = (TextView)view0.findViewById(0x7F0A0426);  // id:empty_button
            textView2.setText(0x7F130817);  // string:playlist_add "플레이리스트 만들기"
            ViewUtils.showWhen(textView2, false);
            ViewUtils.setOnClickListener(textView2, new View.OnClickListener() {
                public final AddToPlaylistPopup a;

                {
                    this.a = addToPlaylistPopup0;
                }

                @Override  // android.view.View$OnClickListener
                public void onClick(View view0) {
                    Navigator.open(PlaylistMakeFragment.newInstance("", this.a.e));
                    this.a.a = null;
                    this.a.dismiss();
                }
            });
        }
    }
}

