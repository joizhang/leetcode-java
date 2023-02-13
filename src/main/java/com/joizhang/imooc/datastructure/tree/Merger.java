package com.joizhang.imooc.datastructure.tree;

/**
 * @param <E>
 * @author joizhang
 */
@FunctionalInterface
public interface Merger<E> {

    E merge(E a, E b);

}
