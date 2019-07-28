package com.sswh.model.javase;

/**
 * Created by wangchengcheng on 2019/7/25
 */
public class MyHashMap<K, V> {

    public Entry<K, V>[] table;
    static final Integer DEFAULT_CAPACITY = 8;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int size) {
        table = new Entry[size];

    }
    public V get(K key){
        int i = getI(key);
        for (Entry<K,V> e=table[i];e != null;e=e.next){
            if (key.equals(e.key)) {
                return e.value;
            }
        }
        return null;
    }

    public V put(K key, V value) {
        Entry entry = new Entry(key, value, null);
        int i = getI(key);
        for (Entry<K, V> e = table[i]; e != null; e = e.next) {
            V oldValue;
            if (e.key.equals(key)) {
                oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        Entry<K, V> kvEntry = new Entry<>(key, value, table[i]);
        table[i] = kvEntry;
        return null;
    }

    private int getI(K k) {
        int hash = k.hashCode();
        return hash % table.length;
    }

    class Entry<K, V> {
        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry() {
        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
