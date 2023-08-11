package com.example.datastructure;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder<T> {

    public Builder<T> b;

    public MapBuilder(Builder<T> b){
        this.b = b;
    }

    public Map<String,T> map(){
        return b.map;
    }

    public T get(String key){
        return b.map.get(key);
    }

    public static class Builder<T>{

        public Map<String, T> map;

        public Builder(){
            map = new HashMap<String, T>();
        }

        public Builder<T> map(String key, T value){
            map.put(key, value);
            return this;
        }


        public MapBuilder<T> build(){
            return new MapBuilder<T>(this);
        }
    }

    public static void main(String[] args) {
        MapBuilder<Object> build = new Builder<Object>().map("name", "fasttest").map("age", 1).build();
        System.out.println(build.get("age"));
    }

}


