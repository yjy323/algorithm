from collections import deque

n, m = map(int, input().split())
graph = [list(map(int, input())) for _ in range(n)]

d = [(1, 0), (-1, 0), (0, 1), (0, -1)]

def bfs(start):
	queue = deque([start])
	
	while queue:
		v = queue.popleft()
		x = v[0]
		y = v[1]
		if x == n - 1 and y == m - 1:
			return

		for i in range(4):
			nx = x + d[i][0]
			ny = y + d[i][1]

			if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 1:
				graph[nx][ny] = graph[x][y] + 1
				queue.append((nx, ny))

bfs((0, 0))
print(graph[n - 1][m - 1])
