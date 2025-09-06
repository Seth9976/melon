package com.kakao.emoticon.ui.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.db.model.EmoticonResource;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.ui.DoubleClickListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001 B\u0017\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u000B\u0010\fJ#\u0010\u0011\u001A\u00060\u0002R\u00020\u00002\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0018\u001A\u00020\u00172\n\u0010\u0015\u001A\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001D\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u0004\u001A\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001ER\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001F¨\u0006!"}, d2 = {"Lcom/kakao/emoticon/ui/widget/EmoticonGridAdapter;", "Landroidx/recyclerview/widget/j0;", "Lcom/kakao/emoticon/ui/widget/EmoticonGridAdapter$EmoticonGridViewHolder;", "Lcom/kakao/emoticon/net/response/Emoticon;", "emoticon", "Lcom/kakao/emoticon/interfaces/EmoticonClickListener;", "emoticonClickListener", "<init>", "(Lcom/kakao/emoticon/net/response/Emoticon;Lcom/kakao/emoticon/interfaces/EmoticonClickListener;)V", "", "Lcom/kakao/emoticon/db/model/EmoticonResource;", "makeEmoticonResources", "(Lcom/kakao/emoticon/net/response/Emoticon;)Ljava/util/List;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/kakao/emoticon/ui/widget/EmoticonGridAdapter$EmoticonGridViewHolder;", "getItemCount", "()I", "holder", "position", "Lie/H;", "onBindViewHolder", "(Lcom/kakao/emoticon/ui/widget/EmoticonGridAdapter$EmoticonGridViewHolder;I)V", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Lcom/kakao/emoticon/net/response/Emoticon;", "Lcom/kakao/emoticon/interfaces/EmoticonClickListener;", "EmoticonGridViewHolder", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonGridAdapter extends j0 {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/kakao/emoticon/ui/widget/EmoticonGridAdapter$EmoticonGridViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/kakao/emoticon/ui/widget/EmoticonGridAdapter;Landroid/view/View;)V", "Lcom/kakao/emoticon/db/model/EmoticonResource;", "itemResource", "Lie/H;", "bind", "(Lcom/kakao/emoticon/db/model/EmoticonResource;)V", "Lcom/kakao/emoticon/ui/widget/EmoticonView;", "emoticonView", "Lcom/kakao/emoticon/ui/widget/EmoticonView;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    public final class EmoticonGridViewHolder extends O0 {
        private final EmoticonView emoticonView;

        public EmoticonGridViewHolder(@NotNull View view0) {
            q.g(view0, "itemView");
            EmoticonGridAdapter.this = emoticonGridAdapter0;
            super(view0);
            View view1 = view0.findViewById(id.emoticon_icon);
            q.f(view1, "itemView.findViewById(R.id.emoticon_icon)");
            this.emoticonView = (EmoticonView)view1;
        }

        public final void bind(@NotNull EmoticonResource emoticonResource0) {
            q.g(emoticonResource0, "itemResource");
            EmoticonViewParam emoticonViewParam0 = EmoticonResource.convertToEmoticonParam(emoticonResource0, EmoticonGridAdapter.this.emoticon.getVersion(), EmoticonGridAdapter.this.emoticon.getItemSubType());
            this.emoticonView.loadThumbnail(emoticonViewParam0, null);
            com.kakao.emoticon.ui.widget.EmoticonGridAdapter.EmoticonGridViewHolder.bind.1 emoticonGridAdapter$EmoticonGridViewHolder$bind$10 = new DoubleClickListener() {
                @Override  // com.kakao.emoticon.ui.DoubleClickListener
                public void onDoubleClick(@NotNull View view0) {
                    q.g(view0, "v");
                    EmoticonGridAdapter.this.emoticonClickListener.onEmoticonDoubleClick(this.$param);
                }

                @Override  // com.kakao.emoticon.ui.DoubleClickListener
                public void onSingleClick(@NotNull View view0) {
                    q.g(view0, "v");
                    EmoticonGridAdapter.this.emoticonClickListener.onEmoticonClick(this.$param);
                }
            };
            this.itemView.setOnClickListener(emoticonGridAdapter$EmoticonGridViewHolder$bind$10);
        }
    }

    private final Emoticon emoticon;
    private final EmoticonClickListener emoticonClickListener;
    @NotNull
    private final List items;

    public EmoticonGridAdapter(@NotNull Emoticon emoticon0, @NotNull EmoticonClickListener emoticonClickListener0) {
        q.g(emoticon0, "emoticon");
        q.g(emoticonClickListener0, "emoticonClickListener");
        super();
        this.emoticon = emoticon0;
        this.emoticonClickListener = emoticonClickListener0;
        this.items = this.makeEmoticonResources(emoticon0);
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemCount() {
        return this.items.size();
    }

    @NotNull
    public final List getItems() {
        return this.items;
    }

    private final List makeEmoticonResources(Emoticon emoticon0) {
        List list0 = new ArrayList();
        if(emoticon0 != null) {
            int v = emoticon0.getResourceCount();
            if(1 <= v) {
                for(int v1 = 1; true; ++v1) {
                    ((ArrayList)list0).add(new EmoticonResource(emoticon0.getId(), v1));
                    if(v1 == v) {
                        break;
                    }
                }
            }
        }
        return list0;
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(O0 o00, int v) {
        this.onBindViewHolder(((EmoticonGridViewHolder)o00), v);
    }

    public void onBindViewHolder(@NotNull EmoticonGridViewHolder emoticonGridAdapter$EmoticonGridViewHolder0, int v) {
        q.g(emoticonGridAdapter$EmoticonGridViewHolder0, "holder");
        emoticonGridAdapter$EmoticonGridViewHolder0.bind(((EmoticonResource)this.items.get(v)));
    }

    @Override  // androidx.recyclerview.widget.j0
    public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        return this.onCreateViewHolder(viewGroup0, v);
    }

    @NotNull
    public EmoticonGridViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(layout.default_emoticon_grid_item, viewGroup0, false);
        q.f(view0, "LayoutInflater.from(pare…grid_item, parent, false)");
        return new EmoticonGridViewHolder(this, view0);
    }
}

