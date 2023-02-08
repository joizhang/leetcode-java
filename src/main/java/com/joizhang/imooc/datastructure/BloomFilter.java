package com.joizhang.imooc.datastructure;

import java.util.BitSet;

public class BloomFilter<T> {

    static class Hash<T> {
        int index;

        public Hash(int index) {
            this.index = index;
        }

        public int compute(T key) {
            return index + asciiString(String.valueOf(key));
        }

        private int asciiString(String word) {
            int num = 0;
            for (int i = 0; i < word.length(); i++) {
                num += word.charAt(i);
            }
            return num;
        }
    }

    private final int numberOfHashFunctions;

    private final BitSet bitSet;

    private final Hash<T>[] hashFunctions;

    @SuppressWarnings("unchecked")
    public BloomFilter(int numberOfHashFunctions, int n) {
        this.numberOfHashFunctions = numberOfHashFunctions;
        hashFunctions = new Hash[numberOfHashFunctions];
        bitSet = new BitSet(n);
        insertHash();
    }

    private void insertHash() {
        for (int i = 0; i < numberOfHashFunctions; i++) {
            hashFunctions[i] = new Hash<>(i);
        }
    }

    public void insert(T key) {
        for(Hash<T> hash : hashFunctions) {
            int position = hash.compute(key) % bitSet.size();
            bitSet.set(position);
        }
    }

    public boolean contains(T key) {
        for (Hash<T> hash : hashFunctions) {
            int position = hash.compute(key) % bitSet.size();
            if (!bitSet.get(position)) {
                return false;
            }
        }
        return true;
    }
}
