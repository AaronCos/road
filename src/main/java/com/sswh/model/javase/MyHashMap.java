package com.sswh.model.javase;

/**
 * Created by wangchengcheng on 2019/7/25
 */
public class MyHashMap<K,V> {

    public static void main(String[] args) {
    float a = 12.0f;
        System.out.println(isNaN(a));

    }
    public static boolean isNaN(float num){
        return num != num;
    }

    private Entry[] table;
    public static Integer DEFAULT_CAPACITY = 8;

    public MyHashMap(){
       this(DEFAULT_CAPACITY);
    }
    public MyHashMap(Integer size){
        this.table = new Entry[size];
    }
    public int size(){
        return 0;
    }
    public V get(Object key){
        int hash = key.hashCode();
        int i = intforhash(hash, table.length);
        for (Entry<K,V> e = table[i]; e != null;e = e.next) {
            if (e.k.equals(key)) {
                return e.v;
            }
        }
        return null;

    }

    private int intforhash(int hash, int length) {
        return hash % length;
    }

    public V put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key,value,null);
        Integer i = getByKey(key, table.length);
        V oldvalue = value;
        for(Entry e = table[i];e != null;e = e.next){
            if (e.k.equals(key)) {
                e.v = value;
                return oldvalue;
            }
        }
        addEntry(key, value, i);

        return null;
    }

    private void addEntry(K key, V value, Integer i) {
        Entry<K, V> entryone = new Entry<>(key, value, table[i]);
        table[i] = entryone;
    }

    public Integer getByKey(K key,int length){
        int hash = key.hashCode();
        return hash % length;
    }

    class Entry<K,V>{
        private K k;
        private V v;
        private Entry<K,V> next;

        public Entry(){

        }
        public Entry(K k,V v,Entry entry){
            this.k = k;
            this.v = v;
            this.next = entry;
        }
    }

}
