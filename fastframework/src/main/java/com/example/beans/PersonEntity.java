package com.example.beans;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class PersonEntity {
    private Integer age;
    private String name;
    private Map<String, Object> params;
    private List<String> favoriteBooks;

    @Override
    public String toString() {
        return "PersonEntity{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", params=" + params +
                ", favoriteBooks=" + favoriteBooks +
                '}';
    }

}
