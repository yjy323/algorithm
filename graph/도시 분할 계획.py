import sys
input = sys.stdin.readline

n, m = map(int, input().split())
parent = [x for x in range(n + 1)]

def find(x):
	if parent[x] != x:
		parent[x] = find(parent[x])
	return parent[x]

def union(a, b):
	a = find(a)
	b = find(b)

	if a < b:
		parent[b] = a
	else:
		parent[a] = b

edges = [tuple(map(int, input().split())) for _ in range(m)]
edges.sort(key=lambda edges:edges[2])

sum_cost = 0
max_cost = 0
for edge in edges:
	a, b, c = edge
	if find(a) != find(b):
		union(a, b)
		sum_cost += c
		max_cost = c

print(sum_cost - max_cost)
