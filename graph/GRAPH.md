Graph Algorithm
===
### 자료구조
1. Adjacency Matrix, M: $O(V^2)$ / T: $O(1)$
2. Adjacency List, M: $O(E)$ / T: $O(V)$

---
### 서로소 집합, union-find algorithm
서로소 집합: 서로 공통 원소가 존재하지 않는 집합</br>
시간 복잡도: V개의 노드, V-1개의 union, M개의 find 연산 시, $O(V + Mlog_2V)$

```python
def find(parent, x):
	if parent[x] != x:
		return find(parent, parent[x])
	return x

def path_compression_find(parent, x):
	if parent[x] != x:
		return parent[x] = find(parent, parent[x])
	return parent[x]

def union(parent, a, b):
	a = find(parent, a)
	b = find(parent, b)

	if a < b:
		parent[b] = a
	else:
		parent[a] = b
```

서로소 집합을 활용한 사이클 판별
1. 각 간선을 확인하며 두 노드의 루트 노드를 확인(find)한다.
	1. 루트 노드가 다르다면 union
	2. 루트 노드가 이미 같다면 사이클이 발생한 것
2. 모든 간선에 대해 1번을 반복한다.

---
### 최소 신장 트리, kruskal algorithm
최소 신장 트리: 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프</br>
1. 비용에 따라 간선 데이터를 오름차순 정렬한다.
2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는 지 확인한다.
	1. 사이클이 발생하지 않는다면, MST에 포함한다.
3. 모든 간선에 대해 2번을 반복한다.

시간 복잡도: $O(ElogE)$, sort()의 시간 복잡도에 의해 결정된다.

```python

def find(parent, x):
	if parent[x] != x:
		return parent[x] = find(parent, parent[x])
	return parent[x]

def union(parent, a, b):
	a = find(parent, a)
	b = find(parent, b)

	if a < b:
		parent[b] = a
	else:
		parent[a] = b

def kruskal():
	parent = [...]  # 서로소 집합의 대표 노드 정보가 저장된 리스트
	edges = [...]  # 간선 정보가 저장된 리스트
	result = 0  # MST의 최종 비용

	edges.sort()
	for edge in edges:
		cost, a, b = edge
		if find(parent, a) != find(parent, b):
			union(parent, a, b)
			result += cost
```

---
### 위상 정렬
**방향 그래프**의 모든 노드를 '방향성에 거스르지 않도록' 정렬하는 것</br>
**사이클**이 존재하면 사이클을 이루는 모든 노드는 큐에 들어갈 수 없기 때문에 V개의 노드를 검사하기 전에 정렬이 종료된다. </br></br>
시간 복잡도: $O(V + E)$

1. 진입차수가 0인 노드를 큐에 넣는다.
2. 큐가 빌 때까지 다음의 과정을 반복한다.
	1. 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거한다.
	2. 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.

```python
from collections import deque

indegree = [0] * (v + 1)  # 진입 차수
graph = [[] for _ in range(v + 1)]

def topology_sort():
	result = []
	q = deque()

	for i in range(1, v + 1):
		if indegree[i] == 0:
			q.append(i)
	
	while q:
		v = q.popleft()
		result.append(v)
		for i in graph[v]:
			indegree[i] -= 1
			if indegree[i] == 0:
				q.append(i)
```
