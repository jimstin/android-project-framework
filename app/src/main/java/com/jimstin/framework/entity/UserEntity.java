package com.jimstin.framework.entity;

/**
 * Created by jim on 16-2-11.
 */
public class UserEntity extends BaseEntity {

    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 2;
    private String name;
    private int age;
    private int gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
