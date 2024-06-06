import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

n, m, c = map(int, input().split())
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
	x, y, z = map(int, input().split())
	graph[x].append((y, z))

def dijkstra(start):
	q = []
	heapq.heappush(q, (0, start))
	distance[start] = 0

	while q:
		dist, v = heapq.heappop(q)
		if distance[v] < dist:
			continue
		for nv in graph[v]:
			cost = dist + nv[1]
			if cost < distance[nv[0]]:
				distance[nv[0]] = cost
				heapq.heappush(q, (cost, nv[0]))

dijkstra(c)
distance = [x for x in distance if x != INF]
print(len(distance) - 1, max(distance))
