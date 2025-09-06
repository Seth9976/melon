package com.iloen.melon.fragments.friend;

import android.os.Bundle;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.sns.model.Sharable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import l8.a;
import l8.b;
import l8.c;

public abstract class FriendBaseSelectFragment extends MetaContentBaseFragment {
    public static final String ARG_FRIEND_MAX_COUNT = "argFriendMaxCount";
    public static final String ARG_FRIEND_RECEIVER_LIST = "argFriendReceiverList";
    public static final String ARG_PRESENT_TO_CONTACTS_OF_FRIEND = "argPresentToContactsOfFriend";
    public static final String ARG_TOOLBAR_TYPE = "argToolbarType";
    private c mAddedFriendListHelper;
    private WeakReference mAddedFriendListHelperReference;
    protected SearchBarView mSearchBarView;
    private int mToolBarLayoutType;

    public FriendBaseSelectFragment() {
        c c0 = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        c0.a = new ArrayList();
        c0.b = new ArrayList();
        c0.e = new a(c0);
        this.mAddedFriendListHelper = c0;
        this.mToolBarLayoutType = -1;
        this.mAddedFriendListHelperReference = new WeakReference(this.mAddedFriendListHelper);
    }

    public void clearMakedItems() {
        this.clearSelection();
    }

    public void clearSelection() {
        this.resetFriendList();
        this.setSelectAllWithToolbar(false);
    }

    public boolean existMarkedItem() {
        List list0 = ((p)this.getAdapter()).getMarkedItems();
        return list0 != null && list0.size() > 0;
    }

    private c getAddedFriendListHelper() {
        return (c)this.mAddedFriendListHelperReference.get();
    }

    public b getOnAddedFriendListListener() {
        return this.getAddedFriendListHelper().e;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            ArrayList arrayList0 = bundle0.getParcelableArrayList("argFriendReceiverList");
            Sharable sharable0 = (Sharable)bundle0.getParcelable("argAttachedSharable");
            int v = bundle0.getInt("argFriendMaxCount");
            if(arrayList0 != null && arrayList0.size() > 0) {
                this.getAddedFriendListHelper().a = arrayList0;
            }
            if(sharable0 != null) {
                this.getAddedFriendListHelper().c = sharable0;
            }
            if(bundle0.containsKey("argToolbarType")) {
                this.mToolBarLayoutType = bundle0.getInt("argToolbarType");
            }
            this.getAddedFriendListHelper().d = v;
        }
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        super.onPause();
        this.resetFriendList();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(Bundle bundle0) {
        super.onSaveInstanceState(bundle0);
        if(bundle0 != null) {
            bundle0.putParcelableArrayList("argFriendReceiverList", this.getAddedFriendListHelper().a);
            bundle0.putInt("argFriendMaxCount", this.getAddedFriendListHelper().d);
            bundle0.putInt("argToolbarType", this.mToolBarLayoutType);
        }
    }

    public void resetFriendList() {
        c c0 = this.getAddedFriendListHelper();
        if(c0 != null) {
            c0.a.removeAll(c0.b);
        }
    }
}

