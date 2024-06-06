Shortest Path
===
### Dijkstra Algorithm
그리디 알고리즘의 일종
1. 출발 노드를 설정한다.
2. **최단 거리 테이블**을 초기화한다.
3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.
4. 3번에서 선택한 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
5. 3~4번을 반복한다.


**시간 복잡도**
1. $O(V^2)$
2. $O(ElogV)$, Priority Queue

**자료구조**</br>
Priority Queue(우선순위 큐) in python: *heapq*
- 첫 번째 원소를 기준으로 우선순위 정렬
- 기본적으로 최소 힙
	- 최대 힙: 우선순위 기준 원소에 (-) 음수 부호를 붙여 저장하고, pop 이후 (-) 부호를 다시 붙여 되돌리는 기법으로 해결한다.

``` python
import heapq

INF = int(1e9)
graph = [[] for _ in range(v + 1)]
distance = [INF] * (v + 1)

def dijkstra(start):
	q = []
	heapq.heappush(q, (0, start))
	distance[start] = 0
	while q:
		dist, now = heapq.heappop(q)
		if distance[now] < dist:
			continue
		for nv in graph[now]:
			cost = dist + nv[1]
			if cost < distance[nv[0]]:
				distance[nv[0]] = cost
				heapq.heappush(q, (cost, nv[0]))
```
---
### Floyd-Warshall Algorithm
모든 노드에서 다른 모든 노드로의 최단 경로를 구하는 알고리즘으로, 서로 다른 두 노드가 제 3의 노드를 통해 더 짧은 경로를 이룰 수 있다는 아이디어로 전개된다.

**시간 복잡도**
1. $O(N^3)$

**자료구조**</br>
2차원 Distance 배열

``` python
INF = int(1e9)
distance = [[INF] * (v + 1) for _ in range(v + 1)]

def floyd_warshall(start):
	for a in range(v + 1):
		for b in range(v + 1):
			if a == b:
				graph[a][b] = 0
		
	# 방향 그래프
	for edge in range(e):
		a = edge[0]
		b = edge[1]
		c = edge[2]
		graph[a][b] = c
	
	for k in range(v + 1):
		for a in range(v + 1):
			for b in range(v + 1):
				graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
```
