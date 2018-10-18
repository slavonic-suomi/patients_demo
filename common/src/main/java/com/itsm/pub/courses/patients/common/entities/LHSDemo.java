package com.itsm.pub.courses.patients.common.entities;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LHSDemo {
    public static void main(String[] args) {
//        new LinkedHashSet<String>();

        Map<Integer, String> map =
                new LRUMap<>(2);

        map.put(1, "Moscow");
        map.put(2, "NY");
        map.put(3, "Minsk");

        String s = map.get(2);
        String s1 = map.get(2);
        String s2 = map.get(2);

        map.values().forEach(System.out::println);

    }

    public static class LRUMap<K, V> extends LinkedHashMap<K,V> {

        private final int cap;

        public LRUMap(int initialCapacity) {
            super(initialCapacity + 1, 1.1f, true);
            cap = initialCapacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return (size() >  cap);
        }
    }
}
