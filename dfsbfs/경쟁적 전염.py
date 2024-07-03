'''
	1회 20240703
	2회 
	3회

	아이디어
		1. BFS
			1. 초 당 전염 순서를 제어할 수 있다.
		2. 전염 순서대로 초기 dequeue 정렬
			1. 이후 전염 순서는 보장된다.
'''

from collections import deque

n, k = map(int, input().split())
matrix = []
for _ in range(n):
	matrix.append(list(map(int, input().split())))

virus = [(matrix[i][j], (i, j), 0) for i in range(n) for j in range(n) if matrix[i][j] != 0]
q = deque(sorted(virus, key=lambda x:x[0]))

s, s_x, s_y = map(int, input().split())
dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)

while q:
	v = q.popleft()
	c = v[0]
	x, y = v[1]
	depth = v[2]
	if depth == s:
		break

	for i in range(4):
		nx = x + dx[i]
		ny = y + dy[i]
		if 0 <= nx < n and 0 <= ny < n and matrix[nx][ny] == 0:
			matrix[nx][ny] = c
			q.append((c, (nx, ny), depth + 1))

print(matrix[s_x - 1][s_y - 1])
