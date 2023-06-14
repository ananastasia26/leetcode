package com.saltuk.network.delay.time;

import java.util.*;

/**
 * 743. Network Delay Time
 */

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        var adjList = createAdjListWithTimes(n, times);
        var handledVertexes = useDijkstra(k - 1, n, adjList);

        var maxTime = -1;
        for(int i = 0; i < n; ++i) {
            if (handledVertexes[i] == -1) {
                return -1;
            }
            maxTime = Math.max(maxTime, handledVertexes[i]);
        }
        return maxTime;
    }

    private int[] useDijkstra(int k, int n, List<Map<Integer, Integer>> adjList) {
        var handledVertexes = new int[n];
        Arrays.fill(handledVertexes, -1);

        var vertexInProcess = new HashMap<Integer, Integer>();
        vertexInProcess.put(k, 0);

        while(!vertexInProcess.isEmpty()) {
            var minTimeVertex = getVertextWithMinTime(vertexInProcess);
            var time = vertexInProcess.get(minTimeVertex);

            for(var pair : adjList.get(minTimeVertex).entrySet()) {
                var neighbour = pair.getKey();

                if(handledVertexes[neighbour] != -1) {
                    continue;
                }

                var newTimeToNeightbour = time + pair.getValue();

                if(vertexInProcess.get(neighbour) == null || newTimeToNeightbour < vertexInProcess.get(neighbour)) {
                    vertexInProcess.put(neighbour, newTimeToNeightbour);
                }
            }
            vertexInProcess.remove(minTimeVertex);
            handledVertexes[minTimeVertex] = time;
        }

        return handledVertexes;
    }

    private List<Map<Integer, Integer>> createAdjListWithTimes(int n, int[][] times) {
        var adjList = new ArrayList<Map<Integer, Integer>>();
        for(int i = 0; i < n; ++i) {
            adjList.add(new HashMap<>());
        }

        for(var tuple : times) {
            var sourceNode = tuple[0] - 1;
            var targetNode = tuple[1] - 1;
            var time = tuple[2];

            var neighbours = adjList.get(sourceNode);
            neighbours.put(targetNode, time);
        }
        return adjList;
    }

    private int getVertextWithMinTime(Map<Integer, Integer> vertexes) {
        Optional<Map.Entry<Integer, Integer>> entry = vertexes.entrySet().stream()
                .min(Map.Entry.comparingByValue());
        return entry.get().getKey();
    }
}