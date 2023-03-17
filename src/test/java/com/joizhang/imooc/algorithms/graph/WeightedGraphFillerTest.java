package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.datastructure.graph.DenseWeightedGraph;
import com.joizhang.imooc.datastructure.graph.SparseWeightedGraph;
import com.joizhang.imooc.datastructure.graph.WeightedGraph;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WeightedGraphFillerTest {

    @Test
    public void testReadEdgesIntoDenseWeightedGraph() throws IOException {
        WeightedGraph<Double> graph = new DenseWeightedGraph<>(8, false);
        new WeightedGraphFiller<>(graph, "graph/testWeightedG1.txt");
        assertEquals(8, graph.V());
        assertEquals(16, graph.E());
        System.out.println(graph);
    }

    @Test
    public void testReadEdgesIntoSparseWeightedGraph() throws IOException {
        WeightedGraph<Double> graph = new SparseWeightedGraph<>(8, false);
        new WeightedGraphFiller<>(graph, "graph/testWeightedG1.txt");
        assertEquals(8, graph.V());
        assertEquals(16, graph.E());
        System.out.println(graph);
    }

}