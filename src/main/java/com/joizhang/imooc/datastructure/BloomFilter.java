package com.joizhang.imooc.datastructure;

import java.util.BitSet;

/**
 * 布隆过滤器
 *
 * @param <T>
 */
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

    /**
     * 通过K个散列函数将这个key元素映射成一个位数组中的K个点，把它们置为1
     *
     * @param key 元素
     */
    public void insert(T key) {

        for (Hash<T> hash : hashFunctions) {
            int position = hash.compute(key) % bitSet.size();
            bitSet.set(position);
        }
    }

    /**
     * 检索时，我们只要看看这些点是不是都是1就（大约）知道集合中有没有它了：
     * 如果这些点有任何一个0，则被检元素一定不在；如果都是1，则被检元素很可能在。
     *
     * @param key 元素
     * @return 如果这些点有任何一个0，则被检元素一定不在；如果都是1，则被检元素很可能在。
     */
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
