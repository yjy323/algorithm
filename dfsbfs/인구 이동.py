'''
	1회 20240725
	2회
	3회

	아이디어
		1.
'''
from collections import deque


def bfs(matrix, vistited, start, l, r):
	n = len(matrix)
	q = deque([start])
	unity = []

	dx = (1, 0, -1, 0)
	dy = (0, 1, 0, -1)

	sum_population = 0
	while q:
		x, y = q.popleft()
		unity.append((x, y))
		sum_population += matrix[x][y]
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < n and 0 <= ny < n \
					and visited[nx][ny] == 0 \
					and l <= abs(matrix[x][y] - matrix[nx][ny]) <= r:
				visited[nx][ny] = 1
				q.append((nx, ny))

	unity_len = len(unity)
	avg_population = sum_population // unity_len
	for u in unity:
		x, y = u
		matrix[x][y] = avg_population
	return unity_len


n, l, r = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

MAX_DAY = 2000
day = 0
while day <= MAX_DAY:
	unity_number = 0
	visited = [[0] * n for _ in range(n)]
	for i in range(n):
		for j in range(n):
			if visited[i][j] == 0:
				visited[i][j] = 1
				if bfs(matrix, visited, (i, j), l, r) > 1:
					unity_number += 1
	if unity_number == 0:
		break
	day += 1

print(day)
