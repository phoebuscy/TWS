package com.enums;

/**
 * Created by caiyong on 2016/12/26.
 */
public enum SCallOrPut
{
    CALL(1),
    PUT(2);

    private int val;
    private String label;

    SCallOrPut(int val)
    {
        this.val = val;
    }

    @Override
    public String toString()
    {
        return this == CALL ? "CALL" : "PUT";
    }
}
