package com.example.datastructure;

import java.util.ArrayList;
import java.util.List;

public class ListBuilder<T> {

    public Builder<T> b;

    public ListBuilder(Builder<T> b){
        this.b = b;
    }

    public List<T> list(){
        return b.list;
    }

    public T get(int index){
        return b.list.get(index);
    }

    public static class Builder<T>{

        public List<T> list;

        public Builder(){
            list = new ArrayList<T>();
        }

        public Builder<T> add(T value){
            list.add(value);
            return this;
        }


        public ListBuilder<T> build(){
            return new ListBuilder<T>(this);
        }
    }

    public static void main(String[] args) {
        ListBuilder<String> build = new ListBuilder.Builder<String>().add("a").add("b").build();
        System.out.println(build.get(0));
        System.out.println(build.get(1));
    }

}
