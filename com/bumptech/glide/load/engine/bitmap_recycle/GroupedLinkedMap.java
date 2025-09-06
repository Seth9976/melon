package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupedLinkedMap {
    static class LinkedEntry {
        final Object key;
        LinkedEntry next;
        LinkedEntry prev;
        private List values;

        public LinkedEntry() {
            this(null);
        }

        public LinkedEntry(Object object0) {
            this.prev = this;
            this.next = this;
            this.key = object0;
        }

        public void add(Object object0) {
            if(this.values == null) {
                this.values = new ArrayList();
            }
            this.values.add(object0);
        }

        public Object removeLast() {
            int v = this.size();
            return v <= 0 ? null : this.values.remove(v - 1);
        }

        public int size() {
            return this.values == null ? 0 : this.values.size();
        }
    }

    private final LinkedEntry head;
    private final Map keyToEntry;

    public GroupedLinkedMap() {
        this.head = new LinkedEntry();
        this.keyToEntry = new HashMap();
    }

    public Object get(Poolable poolable0) {
        LinkedEntry groupedLinkedMap$LinkedEntry0 = (LinkedEntry)this.keyToEntry.get(poolable0);
        if(groupedLinkedMap$LinkedEntry0 == null) {
            groupedLinkedMap$LinkedEntry0 = new LinkedEntry(poolable0);
            this.keyToEntry.put(poolable0, groupedLinkedMap$LinkedEntry0);
        }
        else {
            poolable0.offer();
        }
        this.makeHead(groupedLinkedMap$LinkedEntry0);
        return groupedLinkedMap$LinkedEntry0.removeLast();
    }

    private void makeHead(LinkedEntry groupedLinkedMap$LinkedEntry0) {
        GroupedLinkedMap.removeEntry(groupedLinkedMap$LinkedEntry0);
        groupedLinkedMap$LinkedEntry0.prev = this.head;
        groupedLinkedMap$LinkedEntry0.next = this.head.next;
        GroupedLinkedMap.updateEntry(groupedLinkedMap$LinkedEntry0);
    }

    private void makeTail(LinkedEntry groupedLinkedMap$LinkedEntry0) {
        GroupedLinkedMap.removeEntry(groupedLinkedMap$LinkedEntry0);
        groupedLinkedMap$LinkedEntry0.prev = this.head.prev;
        groupedLinkedMap$LinkedEntry0.next = this.head;
        GroupedLinkedMap.updateEntry(groupedLinkedMap$LinkedEntry0);
    }

    public void put(Poolable poolable0, Object object0) {
        LinkedEntry groupedLinkedMap$LinkedEntry0 = (LinkedEntry)this.keyToEntry.get(poolable0);
        if(groupedLinkedMap$LinkedEntry0 == null) {
            groupedLinkedMap$LinkedEntry0 = new LinkedEntry(poolable0);
            this.makeTail(groupedLinkedMap$LinkedEntry0);
            this.keyToEntry.put(poolable0, groupedLinkedMap$LinkedEntry0);
        }
        else {
            poolable0.offer();
        }
        groupedLinkedMap$LinkedEntry0.add(object0);
    }

    private static void removeEntry(LinkedEntry groupedLinkedMap$LinkedEntry0) {
        groupedLinkedMap$LinkedEntry0.prev.next = groupedLinkedMap$LinkedEntry0.next;
        groupedLinkedMap$LinkedEntry0.next.prev = groupedLinkedMap$LinkedEntry0.prev;
    }

    public Object removeLast() {
        for(LinkedEntry groupedLinkedMap$LinkedEntry0 = this.head.prev; !groupedLinkedMap$LinkedEntry0.equals(this.head); groupedLinkedMap$LinkedEntry0 = groupedLinkedMap$LinkedEntry0.prev) {
            Object object0 = groupedLinkedMap$LinkedEntry0.removeLast();
            if(object0 != null) {
                return object0;
            }
            GroupedLinkedMap.removeEntry(groupedLinkedMap$LinkedEntry0);
            this.keyToEntry.remove(groupedLinkedMap$LinkedEntry0.key);
            ((Poolable)groupedLinkedMap$LinkedEntry0.key).offer();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("GroupedLinkedMap( ");
        LinkedEntry groupedLinkedMap$LinkedEntry0 = this.head.next;
        boolean z;
        for(z = false; !groupedLinkedMap$LinkedEntry0.equals(this.head); z = true) {
            stringBuilder0.append('{');
            stringBuilder0.append(groupedLinkedMap$LinkedEntry0.key);
            stringBuilder0.append(':');
            stringBuilder0.append(groupedLinkedMap$LinkedEntry0.size());
            stringBuilder0.append("}, ");
            groupedLinkedMap$LinkedEntry0 = groupedLinkedMap$LinkedEntry0.next;
        }
        if(z) {
            stringBuilder0.delete(stringBuilder0.length() - 2, stringBuilder0.length());
        }
        stringBuilder0.append(" )");
        return stringBuilder0.toString();
    }

    private static void updateEntry(LinkedEntry groupedLinkedMap$LinkedEntry0) {
        groupedLinkedMap$LinkedEntry0.next.prev = groupedLinkedMap$LinkedEntry0;
        groupedLinkedMap$LinkedEntry0.prev.next = groupedLinkedMap$LinkedEntry0;
    }
}

