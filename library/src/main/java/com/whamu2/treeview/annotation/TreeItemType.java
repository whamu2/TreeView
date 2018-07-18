package com.whamu2.treeview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 可使用在item类上或者bean的变量上,type值与注册的item类对应.
 * 如果使用在item的类上,只取type值,value无效.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface TreeItemType {
    /**
     * @return -1代表不查找，请勿使用该值
     */
    int value() default -1;

    int type() default -1;
}
