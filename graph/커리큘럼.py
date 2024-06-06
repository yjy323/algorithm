from collections import deque
import copy
import sys
input = sys.stdin.readline

n = int(input())
graph = [[] for _ in range(n + 1)]
cost = [0] * (n + 1)
indegree = [0] * (n + 1)

for i in range(1, n + 1):
	info = list(map(int, input().split()))
	cost[i] = info[0]
	for x in info[1:-1]:
		indegree[i] += 1
		graph[x].append(i)

def topology_sort():
	result = copy.deepcopy(cost)
	q = deque()
	for i in range(1, n + 1):
		if indegree[i] == 0:
			q.append(i)

	while q:
		v = q.popleft()
		for nv in graph[v]:
			result[nv] = max(result[nv], result[v] + cost[nv])
			indegree[nv] -= 1
			if indegree[nv] == 0:
				q.append(nv)

	for i in range(1, n + 1):
		print(result[i])

topology_sort()
