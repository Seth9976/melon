package com.iloen.melon.sns.target;

import com.iloen.melon.sns.model.Sharable;

public interface SnsPostListener {
    void onError(String arg1, Sharable arg2, Object arg3);

    void onSuccess(String arg1, Sharable arg2);
}

