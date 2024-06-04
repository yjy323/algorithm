DFS & BFS
===
### 자료구조
파이썬에서는 모두 'list' 자료구조로 표현할 수 있다.
1. 인접 행렬, 연결되지 않은 노드 간의 가중치는 INF와 같이 표시한다.
2. 인접 리스트
---
### DFS, O(N)
Stack OR 재귀: LIFO
1. 탐색 시작 노드를 스택에 삽입하고 방문 처리를 한다.
2. 스택에서 최상단 노드를 꺼낸다. 그 후 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 해당 인접 노드를 스택에 넣고 방문 처리 한다.
3. 2번의 과정을 반복한다.
```python
def dfs(graph, start, visited):
	visited[start] = True

	for e in graph[v]:
			if not visited[e]:
				dfs(graph, e, visited)
```
---
### BFS, O(N)
Queue: FIFO
1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
2. 큐에서 노드를 꺼낸다. 그 후 노드에 방문하지 않은 인접 노드가 있으면 해당 인접 노드를 모두 큐에 넣고 방문 처리 한다.
3. 2번의 과정을 반복한다.

```python
from collections import deque

def bfs(graph, start, visited):
	queue = deque([start])
	visited[start] = True

	while queue:
		v = queue.popleft()
		for e in graph[v]:
			if not visited[e]:
				queue.append(e)
				visited[e] = True
```
