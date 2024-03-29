package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.datastructure.graph.SparseWeightedGraph;
import com.joizhang.imooc.datastructure.graph.WeightedGraph;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class LazyPrimMinSpanningTreeTest {

    @Test
    public void testMst() throws IOException {
        WeightedGraph<Double> graph = new SparseWeightedGraph<>(8, false);
        new WeightedGraphFiller(graph, "graph/testWeightedG1.txt");
        LazyPrimMinSpanningTree<Double> lazyPrimMinSpanningTree = new LazyPrimMinSpanningTree<Double>(graph);
        System.out.println(lazyPrimMinSpanningTree.mstEdges());
        assertEquals(1.81, lazyPrimMinSpanningTree.result());
    }

}