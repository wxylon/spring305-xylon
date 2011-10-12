package com.xylon.propertyEditor.spring;

import java.beans.PropertyEditorSupport;

public class PersonEditor extends PropertyEditorSupport{

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        String[] temp=text.split("-");
        String name=temp[0];
        int age=Integer.parseInt(temp[1]);
        Person p=new Person(name,age);
        setValue(p);
    }
}