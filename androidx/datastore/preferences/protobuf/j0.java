package androidx.datastore.preferences.protobuf;

import com.google.protobuf.G2;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;
import rf.y;

public class j0 extends AbstractSet {
    public final int a;
    public final AbstractMap b;

    public j0(AbstractMap abstractMap0, int v) {
        this.a = v;
        this.b = abstractMap0;
        super();
    }

    @Override
    public final boolean add(Object object0) {
        switch(this.a) {
            case 0: {
                if(!this.contains(((Map.Entry)object0))) {
                    Comparable comparable1 = (Comparable)((Map.Entry)object0).getKey();
                    Object object2 = ((Map.Entry)object0).getValue();
                    ((g0)this.b).g(comparable1, object2);
                    return true;
                }
                return false;
            }
            case 1: {
                if(!this.contains(((Map.Entry)object0))) {
                    Comparable comparable2 = (Comparable)((Map.Entry)object0).getKey();
                    Object object3 = ((Map.Entry)object0).getValue();
                    ((G2)this.b).h(comparable2, object3);
                    return true;
                }
                return false;
            }
            default: {
                if(!this.contains(((Map.Entry)object0))) {
                    Comparable comparable0 = (Comparable)((Map.Entry)object0).getKey();
                    Object object1 = ((Map.Entry)object0).getValue();
                    ((y)this.b).e(comparable0, object1);
                    return true;
                }
                return false;
            }
        }
    }

    @Override
    public final void clear() {
        switch(this.a) {
            case 0: {
                ((g0)this.b).clear();
                return;
            }
            case 1: {
                ((G2)this.b).clear();
                return;
            }
            default: {
                ((y)this.b).clear();
            }
        }
    }

    @Override
    public final boolean contains(Object object0) {
        switch(this.a) {
            case 0: {
                Object object4 = ((Map.Entry)object0).getKey();
                Object object5 = ((g0)this.b).get(object4);
                Object object6 = ((Map.Entry)object0).getValue();
                return object5 == object6 || object5 != null && object5.equals(object6);
            }
            case 1: {
                Object object7 = ((Map.Entry)object0).getKey();
                Object object8 = ((G2)this.b).get(object7);
                Object object9 = ((Map.Entry)object0).getValue();
                return object8 == object9 || object8 != null && object8.equals(object9);
            }
            default: {
                Object object1 = ((Map.Entry)object0).getKey();
                Object object2 = ((y)this.b).get(object1);
                Object object3 = ((Map.Entry)object0).getValue();
                return object2 == object3 || object2 != null && object2.equals(object3);
            }
        }
    }

    @Override
    public Iterator iterator() {
        switch(this.a) {
            case 0: {
                return new i0(((g0)this.b), 0);
            }
            case 1: {
                return new i0(((G2)this.b), 1);
            }
            default: {
                return new i0(((y)this.b), 2);
            }
        }
    }

    @Override
    public final boolean remove(Object object0) {
        switch(this.a) {
            case 0: {
                if(this.contains(((Map.Entry)object0))) {
                    Object object2 = ((Map.Entry)object0).getKey();
                    ((g0)this.b).remove(object2);
                    return true;
                }
                return false;
            }
            case 1: {
                if(this.contains(((Map.Entry)object0))) {
                    Object object3 = ((Map.Entry)object0).getKey();
                    ((G2)this.b).remove(object3);
                    return true;
                }
                return false;
            }
            default: {
                if(this.contains(((Map.Entry)object0))) {
                    Object object1 = ((Map.Entry)object0).getKey();
                    ((y)this.b).remove(object1);
                    return true;
                }
                return false;
            }
        }
    }

    @Override
    public final int size() {
        switch(this.a) {
            case 0: {
                return ((g0)this.b).size();
            }
            case 1: {
                return ((G2)this.b).size();
            }
            default: {
                return ((y)this.b).size();
            }
        }
    }
}

