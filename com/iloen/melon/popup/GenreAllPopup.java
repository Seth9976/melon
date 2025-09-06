package com.iloen.melon.popup;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.r0;
import androidx.recyclerview.widget.w0;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.UaLogDummyReq;
import com.iloen.melon.net.v5x.request.GenreMenuReq;
import com.iloen.melon.net.v5x.response.GenreMenuRes.RESPONSE;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import p8.O;

public class GenreAllPopup extends MelonBaseListPopup {
    public class GenreGroupTitle extends O0 {
        public TextView tvTitle;

        public GenreGroupTitle(View view0) {
            super(view0);
            this.tvTitle = (TextView)view0.findViewById(0x7F0A0D34);  // id:tv_title
        }
    }

    class GenreInfo {
        public final MelonLinkInfo a;
        public final boolean b;
        public final boolean c;
        public final String d;
        public final String e;
        public final int f;
        public boolean g;

        public GenreInfo(boolean z, boolean z1, String s, String s1, int v, MelonLinkInfo melonLinkInfo0) {
            this.g = false;
            this.c = z;
            this.b = z1;
            this.d = s;
            this.e = s1;
            this.f = v;
            this.a = melonLinkInfo0;
        }
    }

    class GenreItemDecoration extends r0 {
        public final int a;
        public final int b;
        public final int c;
        public final GenreAllPopup d;

        public GenreItemDecoration() {
            this.a = ScreenUtils.dipToPixel(genreAllPopup0.getContext(), 5.0f);
            this.b = ScreenUtils.dipToPixel(genreAllPopup0.getContext(), 16.0f);
            this.c = ScreenUtils.dipToPixel(genreAllPopup0.getContext(), 16.0f);
        }

        @Override  // androidx.recyclerview.widget.r0
        public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
            int v = recyclerView0.getChildAdapterPosition(view0);
            GenreAllPopup genreAllPopup0 = GenreAllPopup.this;
            int v1 = genreAllPopup0.e.getItemViewType(v);
            GenreInfo genreAllPopup$GenreInfo0 = (GenreInfo)genreAllPopup0.c.get(v);
            if(v1 == 0) {
                if(v != 0) {
                    rect0.top = ScreenUtils.dipToPixel(genreAllPopup0.getContext(), 3.0f);
                }
            }
            else if(v1 == 1) {
                int v2 = this.a;
                rect0.top = v2;
                rect0.bottom = genreAllPopup$GenreInfo0.g ? this.b : v2;
                int v3 = genreAllPopup0.a;
                int v4 = genreAllPopup$GenreInfo0.f % v3;
                int v5 = this.c;
                if(v4 == 0) {
                    rect0.left = v5;
                    rect0.right = v2;
                    return;
                }
                if(v4 == v3 - 1) {
                    rect0.left = v2;
                    rect0.right = v5;
                    return;
                }
                rect0.left = v2;
                rect0.right = v2;
            }
        }
    }

    class GenreListAdapter extends j0 {
        public static final int VIEW_TYPE_GENRE_MENU = 1;
        public static final int VIEW_TYPE_GROUP_TITLE;
        public final GenreAllPopup a;

        @Override  // androidx.recyclerview.widget.j0
        public int getItemCount() {
            return GenreAllPopup.this.c.size();
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            return !((GenreInfo)GenreAllPopup.this.c.get(v)).c;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(O0 o00, int v) {
            GenreAllPopup genreAllPopup0 = GenreAllPopup.this;
            GenreInfo genreAllPopup$GenreInfo0 = (GenreInfo)genreAllPopup0.c.get(v);
            if(o00 instanceof GenreGroupTitle) {
                ((GenreGroupTitle)o00).tvTitle.setText(genreAllPopup$GenreInfo0.d);
                return;
            }
            if(o00 instanceof GenreMenuHolder) {
                ViewUtils.setText(((GenreMenuHolder)o00).genreName, genreAllPopup$GenreInfo0.d);
                boolean z = TextUtils.isEmpty(genreAllPopup$GenreInfo0.e) ? false : genreAllPopup$GenreInfo0.e.equals(genreAllPopup0.d);
                ((GenreMenuHolder)o00).genreName.setTextColor(ColorUtils.getColor(genreAllPopup0.getContext(), (z ? 0x7F06017C : 0x7F060165)));  // color:green500s_support_high_contrast
                ViewUtils.showWhen(((GenreMenuHolder)o00).ivCheckState, z);
                com.iloen.melon.popup.GenreAllPopup.GenreListAdapter.1 genreAllPopup$GenreListAdapter$10 = new View.OnClickListener() {
                    public final GenreInfo a;
                    public final GenreListAdapter b;

                    {
                        GenreInfo genreAllPopup$GenreInfo0 = genreAllPopup$GenreInfo0;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                        this.b = genreAllPopup$GenreListAdapter0;
                        this.a = genreAllPopup$GenreInfo0;
                    }

                    @Override  // android.view.View$OnClickListener
                    public void onClick(View view0) {
                        HashMap hashMap0 = new HashMap();
                        GenreInfo genreAllPopup$GenreInfo0 = this.a;
                        hashMap0.put("contentsId", genreAllPopup$GenreInfo0.e);
                        GenreListAdapter genreAllPopup$GenreListAdapter0 = this.b;
                        O.a(new UaLogDummyReq(GenreAllPopup.this.getContext(), "genrePopupMove", hashMap0));
                        if(GenreAllPopup.this.j) {
                            if(genreAllPopup$GenreInfo0.b) {
                                MelonLinkExecutor.open(genreAllPopup$GenreInfo0.a);
                            }
                            else {
                                Navigator.openGenreDetail(genreAllPopup$GenreInfo0.e);
                            }
                        }
                        GenreAllPopup.this.dismiss();
                        OnActionListener genreAllPopup$OnActionListener0 = GenreAllPopup.this.i;
                        if(genreAllPopup$OnActionListener0 != null) {
                            genreAllPopup$OnActionListener0.onItemSelected(genreAllPopup$GenreInfo0.e, genreAllPopup$GenreInfo0.d);
                        }
                    }
                };
                ViewUtils.setOnClickListener(((GenreMenuHolder)o00).itemView, genreAllPopup$GenreListAdapter$10);
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            GenreAllPopup genreAllPopup0 = GenreAllPopup.this;
            return v == 0 ? new GenreGroupTitle(genreAllPopup0, LayoutInflater.from(genreAllPopup0.getContext()).inflate(0x7F0D02D9, viewGroup0, false)) : new GenreMenuHolder(genreAllPopup0, LayoutInflater.from(genreAllPopup0.getContext()).inflate(0x7F0D02DA, viewGroup0, false));  // layout:genre_all_popup_list_group_title
        }
    }

    public class GenreMenuHolder extends O0 {
        public TextView genreName;
        public ImageView ivCheckState;

        public GenreMenuHolder(View view0) {
            super(view0);
            this.genreName = (TextView)view0.findViewById(0x7F0A0C86);  // id:tv_genre_name
            this.ivCheckState = (ImageView)view0.findViewById(0x7F0A0611);  // id:iv_check_state
        }
    }

    public interface OnActionListener {
        void onItemSelected(String arg1, String arg2);
    }

    public int a;
    public boolean b;
    public final ArrayList c;
    public final String d;
    public GenreListAdapter e;
    public RecyclerView f;
    public View g;
    public RESPONSE h;
    public OnActionListener i;
    public final boolean j;

    public GenreAllPopup(Activity activity0, String s) {
        super(activity0);
        this.a = 2;
        this.b = false;
        this.c = new ArrayList();
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = true;
        this.d = s;
    }

    public GenreAllPopup(Activity activity0, String s, boolean z) {
        super(activity0);
        this.a = 2;
        this.b = false;
        this.c = new ArrayList();
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.d = s;
        this.j = z;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public int getLayoutView() {
        return 0x7F0D02D8;  // layout:genre_all_popup_layout
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onViewCreated() {
        View view0 = this.findViewById(0x7F0A070A);  // id:layout_close
        this.g = view0;
        view0.setOnClickListener(new View.OnClickListener() {
            public final GenreAllPopup a;

            {
                this.a = genreAllPopup0;
            }

            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                this.a.dismiss();
            }
        });
        GridLayoutManager gridLayoutManager0 = new GridLayoutManager(this.getContext(), this.a);
        gridLayoutManager0.g = new H() {
            public final GenreAllPopup a;

            @Override  // androidx.recyclerview.widget.H
            public int getSpanSize(int v) {
                return GenreAllPopup.this.e.getItemViewType(v) == 0 ? GenreAllPopup.this.a : 1;
            }
        };
        this.e = new GenreListAdapter(this);
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        this.f = recyclerView0;
        recyclerView0.setLayoutManager(gridLayoutManager0);
        this.f.addItemDecoration(new GenreItemDecoration(this));
        this.f.setAdapter(this.e);
        this.setPopupHeight();
        RequestBuilder.newInstance(new GenreMenuReq(this.getContext())).tag("MelonBaseListPopup").listener(new GenreAllPopup.4(this)).errorListener(new GenreAllPopup.3()).request();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public void setOnActionListener(OnActionListener genreAllPopup$OnActionListener0) {
        this.i = genreAllPopup$OnActionListener0;
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    @NotNull
    public WindowManager.LayoutParams setWindowLayoutParams(WindowManager.LayoutParams windowManager$LayoutParams0) {
        windowManager$LayoutParams0.gravity = 80;
        windowManager$LayoutParams0.width = -1;
        windowManager$LayoutParams0.height = (int)(((float)ScreenUtils.getScreenHeight(this.getContext())) * 0.60625f);
        windowManager$LayoutParams0.windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
        return windowManager$LayoutParams0;
    }

    @Override  // android.app.Dialog
    public void show() {
        this.b = true;
        this.a = ScreenUtils.isPortrait(this.getContext()) ? 2 : 3;
        RecyclerView recyclerView0 = this.f;
        if(recyclerView0 != null) {
            w0 w00 = recyclerView0.getLayoutManager();
            if(w00 instanceof GridLayoutManager) {
                ((GridLayoutManager)w00).P(this.a);
            }
        }
        super.show();
    }
}

