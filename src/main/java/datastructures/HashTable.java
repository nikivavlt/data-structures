package datastructures;

public class HashTable<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private int capacity;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.buckets = (LinkedList<Entry<K, V>>[]) new LinkedList[capacity];
    }

    public HashTable(){
        this(16);
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        int newCapacity = capacity * 2;
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;

        buckets = (LinkedList<Entry<K, V>>[]) new LinkedList[newCapacity];
        capacity = newCapacity;
        size = 0;

        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets[index] = bucket;
        }

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        if ((double) (size + 1) / capacity > LOAD_FACTOR_THRESHOLD) {
            resize();
            index = hash(key);
            bucket = buckets[index];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[index] = bucket;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);

        LinkedList<Entry<K, V>> bucket = buckets[index];

        if (bucket == null) return null;

        for (Entry<K, V> entry : bucket) {
            if ((entry.key).equals(key)) {
                return entry.value;
            }
        }

        return null;
    }
    
    public boolean containsKey (K key) {
        int index = hash(key);

        LinkedList<Entry<K, V>> bucket = buckets[index];

        if (bucket == null) return false;

        for (Entry<K, V> entry : bucket) {
            if ((entry.key).equals(key)) {
                return true;
            }
        }

        return false;
    }

    public V remove(K key) {
        int index = hash(key);

        LinkedList<Entry<K, V>> bucket = buckets[index];

        if (bucket != null) {
            for (int i = 0; i < bucket.size(); i += 1) {
                Entry<K, V> instance = bucket.get(i);

                if ((instance.key).equals(key)) {
                    V value = instance.value;
                    bucket.remove(i);
                    size -= 1;
                    return value;
                }
            }
        }

        return null;
    }

    public int size() { return this.size; }

    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() { return this.size == 0; }
}