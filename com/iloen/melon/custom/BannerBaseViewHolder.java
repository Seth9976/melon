package com.iloen.melon.custom;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.O0;

public abstract class BannerBaseViewHolder extends O0 {
    public BannerBaseViewHolder(Context context0) {
        super(LayoutInflater.from(context0).inflate(0x7F0D0057, null, false));  // layout:banner
        ItemsPagerContainer itemsPagerContainer0 = (ItemsPagerContainer)this.itemView.findViewById(0x7F0A00F3);  // id:banner_pager
    }
}

