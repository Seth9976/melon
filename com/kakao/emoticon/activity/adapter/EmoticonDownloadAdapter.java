package com.kakao.emoticon.activity.adapter;

import A6.d;
import Ad.n;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.kakao.emoticon.R.anim;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.R.id;
import com.kakao.emoticon.R.layout;
import com.kakao.emoticon.R.string;
import com.kakao.emoticon.controller.EmoticonResourceLoader;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.util.StringUtils;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class EmoticonDownloadAdapter extends j0 {
    public interface AddDownloadItemListener {
        void onAddItem(Emoticon arg1);
    }

    public static class BannerViewHolder extends O0 {
        private final ImageView bannerView;

        public BannerViewHolder(View view0) {
            super(view0);
            this.bannerView = (ImageView)view0.findViewById(id.emoticon_banner);
        }
    }

    public static class DownloadViewHolder extends O0 {
        private final ImageView ivAdd;
        private final ImageView ivTitle;
        private final View rlDownload;
        private final TextView tvEditor;
        private final TextView tvExpireAt;
        private final TextView tvName;

        public DownloadViewHolder(View view0) {
            super(view0);
            this.ivTitle = (ImageView)view0.findViewById(id.emoticon_icon);
            this.tvName = (TextView)view0.findViewById(id.emoticon_set_name);
            this.tvEditor = (TextView)view0.findViewById(id.emoticon_set_editor);
            this.tvExpireAt = (TextView)view0.findViewById(id.emoticon_set_expire);
            this.rlDownload = view0.findViewById(id.rl_download);
            this.ivAdd = (ImageView)view0.findViewById(id.iv_add);
        }

        public static TextView access$000(DownloadViewHolder emoticonDownloadAdapter$DownloadViewHolder0) {
            return emoticonDownloadAdapter$DownloadViewHolder0.tvName;
        }

        public static TextView access$100(DownloadViewHolder emoticonDownloadAdapter$DownloadViewHolder0) {
            return emoticonDownloadAdapter$DownloadViewHolder0.tvEditor;
        }

        public static TextView access$200(DownloadViewHolder emoticonDownloadAdapter$DownloadViewHolder0) {
            return emoticonDownloadAdapter$DownloadViewHolder0.tvExpireAt;
        }

        public static ImageView access$300(DownloadViewHolder emoticonDownloadAdapter$DownloadViewHolder0) {
            return emoticonDownloadAdapter$DownloadViewHolder0.ivTitle;
        }

        public static View access$400(DownloadViewHolder emoticonDownloadAdapter$DownloadViewHolder0) {
            return emoticonDownloadAdapter$DownloadViewHolder0.rlDownload;
        }

        public static ImageView access$500(DownloadViewHolder emoticonDownloadAdapter$DownloadViewHolder0) {
            return emoticonDownloadAdapter$DownloadViewHolder0.ivAdd;
        }
    }

    private static final int BANNER_TYPE = 1;
    private static final int ITEM_TYPE;
    private String bannerUrl;
    private AddDownloadItemListener downloadItemListener;
    private final SimpleDateFormat expireFormat;
    private List mEmoticonList;

    public EmoticonDownloadAdapter() {
        this.expireFormat = new SimpleDateFormat("~ yyyy.MM.dd", Locale.getDefault());
    }

    public static void a(EmoticonDownloadAdapter emoticonDownloadAdapter0, int v) {
        emoticonDownloadAdapter0.lambda$null$0(v);
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemCount() {
        List list0 = this.mEmoticonList;
        return list0 != null ? list0.size() + this.hasBanner() : this.hasBanner();
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemViewType(int v) {
        return !this.hasBanner() || v != 0 ? 0 : 1;
    }

    private boolean hasBanner() {
        return StringUtils.isNotBlank(this.bannerUrl);
    }

    private void lambda$null$0(int v) {
        this.notifyItemChanged(v);
    }

    private void lambda$onBindViewHolder$1(int v, DownloadViewHolder emoticonDownloadAdapter$DownloadViewHolder0, View view0) {
        ((Emoticon)this.mEmoticonList.get(v)).setShow(true);
        AddDownloadItemListener emoticonDownloadAdapter$AddDownloadItemListener0 = this.downloadItemListener;
        if(emoticonDownloadAdapter$AddDownloadItemListener0 != null) {
            emoticonDownloadAdapter$AddDownloadItemListener0.onAddItem(((Emoticon)this.mEmoticonList.get(v)));
        }
        this.startAddAnimation(DownloadViewHolder.access$500(emoticonDownloadAdapter$DownloadViewHolder0));
        DownloadViewHolder.access$500(emoticonDownloadAdapter$DownloadViewHolder0).postDelayed(new d(this, v, 12), 1000L);
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(O0 o00, int v) {
        if(o00 instanceof DownloadViewHolder) {
            int v1 = o00.getAdapterPosition() - this.hasBanner();
            Emoticon emoticon0 = (Emoticon)this.mEmoticonList.get(v1);
            DownloadViewHolder.access$000(((DownloadViewHolder)o00)).setText(emoticon0.getTitle());
            DownloadViewHolder.access$100(((DownloadViewHolder)o00)).setText(emoticon0.getEditorName());
            if(emoticon0.getExpiredAt() > 0L) {
                DownloadViewHolder.access$200(((DownloadViewHolder)o00)).setText(this.expireFormat.format(((long)(emoticon0.getExpiredAt() * 1000L))));
            }
            else {
                DownloadViewHolder.access$200(((DownloadViewHolder)o00)).setText(string.label_unlimit);
            }
            ImageView imageView0 = DownloadViewHolder.access$300(((DownloadViewHolder)o00));
            EmoticonResourceLoader.INSTANCE.loadTitle(imageView0, emoticon0);
            if(emoticon0.isShow()) {
                DownloadViewHolder.access$400(((DownloadViewHolder)o00)).setVisibility(4);
            }
            else {
                DownloadViewHolder.access$500(((DownloadViewHolder)o00)).setBackgroundResource(drawable.icon_add);
                DownloadViewHolder.access$500(((DownloadViewHolder)o00)).setVisibility(0);
                DownloadViewHolder.access$400(((DownloadViewHolder)o00)).setVisibility(0);
            }
            DownloadViewHolder.access$400(((DownloadViewHolder)o00)).setOnClickListener(new n(this, v1, ((DownloadViewHolder)o00), 17));
            return;
        }
        ImageView imageView1 = ((BannerViewHolder)o00).bannerView;
        EmoticonResourceLoader.INSTANCE.loadUrl(imageView1, this.bannerUrl, null);
    }

    @Override  // androidx.recyclerview.widget.j0
    public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        return v == 1 ? new BannerViewHolder(LayoutInflater.from(viewGroup0.getContext()).inflate(layout.emoticon_banner_item, viewGroup0, false)) : new DownloadViewHolder(LayoutInflater.from(viewGroup0.getContext()).inflate(layout.emoticon_download_item, viewGroup0, false));
    }

    public void setDownloadItemListener(AddDownloadItemListener emoticonDownloadAdapter$AddDownloadItemListener0) {
        this.downloadItemListener = emoticonDownloadAdapter$AddDownloadItemListener0;
    }

    public void setEmoticonList(List list0, String s) {
        this.mEmoticonList = list0;
        this.bannerUrl = s;
        this.notifyDataSetChanged();
    }

    private void startAddAnimation(View view0) {
        Animation animation0 = AnimationUtils.loadAnimation(view0.getContext(), anim.emoticon_add_anim);
        Animation animation1 = AnimationUtils.loadAnimation(view0.getContext(), anim.emoticon_add_check_anim);
        animation0.setAnimationListener(new Animation.AnimationListener() {
            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                view0.startAnimation(animation1);
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
                view0.setBackgroundResource(drawable.icon_add);
                view0.setVisibility(0);
            }
        });
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                view0.setVisibility(8);
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
                view0.setBackgroundResource(drawable.icon_add_check);
            }
        });
        view0.startAnimation(animation0);
    }
}

