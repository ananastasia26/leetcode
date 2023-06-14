package com.saltuk.course.schedule;

import java.util.*;

/**
 * 207. Course Schedule
 */
class Solution {
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = createGraph(prerequisites, numCourses);

        var topologySorted = new ArrayList<Integer>();
        var independentVertexes = getIndependentVertexes(graph);

        while(!independentVertexes.isEmpty()) {
            var independentVertex = independentVertexes.poll();

            var iterator = graph.entrySet().iterator();
            while(iterator.hasNext()) {
                var pair = iterator.next();
                var vertex = pair.getKey();
                var dependencies = pair.getValue();

                dependencies.remove(independentVertex);
                if (dependencies.isEmpty()) {
                    independentVertexes.add(vertex);
                    iterator.remove();
                }
            }

            topologySorted.add(independentVertex);
        }

        if(graph.size() != 0) {
            return false;
        }

        return topologySorted.size() <= numCourses;
    }

    private Deque<Integer> getIndependentVertexes(Map<Integer, Set<Integer>> graph) {
        var startVertexes = new LinkedList<Integer>();

        var iterator = graph.entrySet().iterator();
        while(iterator.hasNext()) {
            var pair = iterator.next();

            if(pair.getValue().isEmpty()) {
                startVertexes.add(pair.getKey());
                iterator.remove();
            }
        }

        return startVertexes;
    }

    private Map<Integer, Set<Integer>> createGraph(int[][] edges, int maxVertexNumber) {
        var graph = new HashMap<Integer, Set<Integer>>();

        IntStream.rangeClosed(0, maxVertexNumber - 1).forEach(i -> graph.put(i, new HashSet<>()));

        for(var edge : edges) {
            var depended = edge[0];
            var dependency = edge[1];

            var neighbours = graph.get(depended);
            neighbours.add(dependency);
        }
        return graph;
    }
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var adjList = createAdjList(prerequisites, numCourses);

        var incomeEdgesForVertex = new int[numCourses];
        for(var edge : prerequisites) {
            var depended = edge[0];
            incomeEdgesForVertex[depended] += 1;
        }

        var independentVertexes = new LinkedList<Integer>();

        for(int i = 0; i < incomeEdgesForVertex.length; ++i) {
            if (incomeEdgesForVertex[i] == 0) {
                independentVertexes.add(i);
            }
        }

        while(!independentVertexes.isEmpty()) {
            var independentVertex = independentVertexes.poll();
            for(var dependent : adjList.get(independentVertex)) {
                incomeEdgesForVertex[dependent]--;
                if(incomeEdgesForVertex[dependent] == 0) {
                    independentVertexes.add(dependent);
                }
            }
        }

        for (int edgesForVertex : incomeEdgesForVertex) {
            if (edgesForVertex != 0) {
                return false;
            }
        }

        return true;
    }
    private List<Set<Integer>> createAdjList(int[][] edges, int maxVertexNumber) {
        var adjList = new ArrayList<Set<Integer>>(maxVertexNumber);
        for(int i = 0; i < maxVertexNumber; ++i) {
            adjList.add(new HashSet<>());
        }

        for(var edge : edges) {
            var depended = edge[0];
            var dependency = edge[1];

            adjList.get(dependency).add(depended);
        }
        return adjList;
    }
}