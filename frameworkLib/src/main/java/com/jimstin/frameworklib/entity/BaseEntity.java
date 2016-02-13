package com.jimstin.frameworklib.entity;

import java.io.Serializable;

/**
 * Created by jim on 16-2-12.
 */
public abstract class BaseEntity implements Serializable {

    public abstract BaseEntity doParse(String jsonString);

}
