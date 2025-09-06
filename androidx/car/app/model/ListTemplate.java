package androidx.car.app.model;

import androidx.car.app.messaging.model.ConversationItem;
import androidx.car.app.messaging.model.f;
import androidx.car.app.utils.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class ListTemplate implements Y {
    static final int MAX_ALLOWED_ITEMS = 100;
    static final int MAX_MESSAGES_PER_CONVERSATION = 10;
    private final ActionStrip mActionStrip;
    private final List mActions;
    private final Action mHeaderAction;
    private final boolean mIsLoading;
    private final List mSectionedLists;
    private final ItemList mSingleList;
    private final CarText mTitle;

    private ListTemplate() {
        this.mIsLoading = false;
        this.mTitle = null;
        this.mHeaderAction = null;
        this.mSingleList = null;
        this.mSectionedLists = Collections.EMPTY_LIST;
        this.mActionStrip = null;
        this.mActions = Collections.EMPTY_LIST;
    }

    public ListTemplate(u u0) {
        this.mIsLoading = u0.a;
        this.mTitle = u0.d;
        this.mHeaderAction = u0.e;
        this.mSingleList = u0.b;
        this.mSectionedLists = g.g(u0.c);
        this.mActionStrip = u0.f;
        this.mActions = g.g(u0.g);
    }

    // 去混淆评级： 低(23)
    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ListTemplate ? this.mIsLoading == ((ListTemplate)object0).mIsLoading && Objects.equals(this.mTitle, ((ListTemplate)object0).mTitle) && Objects.equals(this.mHeaderAction, ((ListTemplate)object0).mHeaderAction) && Objects.equals(this.mSingleList, ((ListTemplate)object0).mSingleList) && Objects.equals(this.mSectionedLists, ((ListTemplate)object0).mSectionedLists) && Objects.equals(this.mActionStrip, ((ListTemplate)object0).mActionStrip) && Objects.equals(this.mActions, ((ListTemplate)object0).mActions) : false;
    }

    public ActionStrip getActionStrip() {
        return this.mActionStrip;
    }

    public List getActions() {
        return this.mActions;
    }

    public Action getHeaderAction() {
        return this.mHeaderAction;
    }

    public List getSectionedLists() {
        return this.mSectionedLists == null ? Collections.EMPTY_LIST : this.mSectionedLists;
    }

    public ItemList getSingleList() {
        return this.mSingleList;
    }

    public CarText getTitle() {
        return this.mTitle;
    }

    public static List getTruncatedCopy(List list0) {
        v v0 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
        v0.a = 100;
        List list1 = new ArrayList();
        for(Object object0: list0) {
            ((ArrayList)list1).add(SectionedItemList.create(ListTemplate.truncate(((SectionedItemList)object0).getItemList(), v0), ((SectionedItemList)object0).getHeader().toCharSequence()));
            if(v0.a <= 0) {
                break;
            }
        }
        return list1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mIsLoading), this.mTitle, this.mHeaderAction, this.mSingleList, this.mSectionedLists, this.mActionStrip});
    }

    public boolean isLoading() {
        return this.mIsLoading;
    }

    public u toBuilder() {
        return new u(this);
    }

    @Override
    public String toString() {
        return "ListTemplate";
    }

    public static ItemList truncate(ItemList itemList0, v v0) {
        r r0 = new r(itemList0);
        ArrayList arrayList0 = r0.a;
        arrayList0.clear();
        for(Object object0: itemList0.getItems()) {
            q q0 = (q)object0;
            if(q0 instanceof ConversationItem) {
                if(v0.a < 2) {
                    break;
                }
                f f0 = new f(((ConversationItem)q0));
                int v1 = v0.a - 1;
                v0.a = v1;
                int v2 = ((ConversationItem)q0).getMessages().size();
                int v3 = Math.min(v2, Math.min(v1, 10));
                f0.f = ((ConversationItem)q0).getMessages().subList(v2 - v3, v2);
                arrayList0.add(new ConversationItem(f0));
                v0.a -= v3;
            }
            else {
                if(v0.a < 1) {
                    break;
                }
                Objects.requireNonNull(q0);
                arrayList0.add(q0);
                --v0.a;
            }
        }
        if(r0.c != null) {
            int v4 = arrayList0.size();
            if(v4 == 0) {
                throw new IllegalStateException("A selectable list cannot be empty");
            }
            int v5 = r0.b;
            if(v5 < v4) {
                Iterator iterator1 = arrayList0.iterator();
                while(true) {
                    if(!iterator1.hasNext()) {
                        return new ItemList(r0);
                    }
                    Object object1 = iterator1.next();
                    if(ItemList.getOnClickDelegate(((q)object1)) != null) {
                        throw new IllegalStateException("Items that belong to selectable lists can\'t have an onClickListener. Use the OnSelectedListener of the list instead");
                    }
                    if(ItemList.getToggle(((q)object1)) != null) {
                        throw new IllegalStateException("Items that belong to selectable lists can\'t have a toggle");
                    }
                }
            }
            throw new IllegalStateException("The selected item index (" + v5 + ") is larger than the size of the list (" + v4 + ")");
        }
        return new ItemList(r0);
    }
}

