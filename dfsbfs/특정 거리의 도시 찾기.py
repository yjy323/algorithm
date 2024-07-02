'''
	1회 20240702
	2회
	3회

	아이디어
		1. BFS
			1. DFS로 문제를 해결할 수 있지만, 최단 거리 k보다 멀리 있는 노드를 검사할 필요가 없으므로
				BFS가 유리하다.
		2. 인접 리스트
'''
import sys
from collections import deque

input = sys.stdin.readline

n, m, k, x = map(int, input().split())
adj = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)
dist = []
for _ in range(m):
	s, e = map(int, input().split())
	adj[s].append(e)

visited[x] = 1
q = deque([(x, 0)])
while q:
	node = q.popleft()
	v = node[0]
	c = node[1] + 1
	for w in adj[v]:
		if visited[w] == 0:
			visited[w] = 1
			if c == k:
				dist.append(w)
			elif c < k:
				q.append((w, c))

dist.sort()
if len(dist) == 0:
	print(-1)
else:
	for i in dist:
		print(i)
