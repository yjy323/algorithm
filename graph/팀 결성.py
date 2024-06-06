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

for _ in range(m):
	c, a, b = map(int, input().split())
	if c == 1:
		if find(a) == find(b):
			print("YES")
		else:
			print("NO")
	else:
		union(a, b)
