package com.night.service;

import com.night.domain.Entity;
import com.night.exception.MapSizeException;

public class CustomHashMap {
    private Entity[] entities;
    private final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public CustomHashMap() {
        entities = new Entity[DEFAULT_CAPACITY];
    }


    /**
     * Add new Element in map
     *
     * @param key
     * @param value
     */
    public void put(Integer key, Long value) {
        if (key == null) {
            throw new RuntimeException("Key can't be null");
        }
        if (size >= DEFAULT_CAPACITY - 1) {
            throw new MapSizeException("Rehashing required");
        }
        int bucket = getHash(key.hashCode());
        Entity exist = entities[bucket];
        if (exist == null) {
            Entity newEntity = Entity.builder().key(key).value(value).build();
            entities[bucket] = newEntity;
            size++;
        } else {
            while (entities[bucket] != null) {
                if (bucket < DEFAULT_CAPACITY - 1) {
                    bucket++;
                    continue;
                }
                break;
            }
            if (entities[bucket] == null) {
                Entity newEntity = Entity.builder().key(key).value(value).build();
                entities[bucket] = newEntity;
                size++;
            }
        }
    }


    /**
     * Get element in map by key
     *
     * @param key
     * @return exist.getValue() or null;
     */
    public Long get(Integer key) {
        if (key == null) {
            throw new RuntimeException("Key can't be null");
        }
        int bucket = getHash(key.hashCode());
        Entity exist = entities[bucket];
        if (exist != null && exist.getKey().equals(key)) {
            return exist.getValue();
        }
        return null;
    }

    private int getHash(int hashCode) {
        return hashCode % DEFAULT_CAPACITY;
    }

    public Integer size() {
        return this.size;
    }
}
