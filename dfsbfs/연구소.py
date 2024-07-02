'''
	1회 20240702
	2회
	3회

	아이디어
		1. 완전 탐색 + BFS
			1. 완전 탐색에는 DFS를 적용한다.
		2. 벽을 세우는 완전탐색 알고리즘
		3. 바이러스를 퍼뜨리는 BFS 알고리즘
		4. 빈 공간의 개수를 세는 반복문
'''
import sys
import copy
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
init_map = []
copy_map = [[0] * m for _ in range(n)]
for _ in range(n):
	init_map.append(list(map(int, input().split())))

result = 0
def virus(start):
	dx = [1, 0, -1, 0]
	dy = [0, 1, 0, -1]

	x, y = start
	q = deque([(x, y)])
	while q:
		v = q.popleft()
		x, y = v
		for i in range(4):
			nx = x + dx[i]
			ny = y + dy[i]
			if 0 <= nx < n and 0 <= ny < m \
				and copy_map[nx][ny] == 0:
				copy_map[nx][ny] = 2
				q.append((nx, ny))

def safty_area():
	area = 0
	for row in copy_map:
		for col in row:
			if col == 0:
				area += 1
	return area

def wall(wall_ctr):
	global result
	if wall_ctr == 3:
		for i in range(n):
			for j in range(m): 
				copy_map[i][j] = init_map[i][j]
		for i in range(n):
			for j in range(m): 
				if copy_map[i][j] == 2:
					virus((i, j))
		result = max(result, safty_area())
		return
	
	for i in range(n):
		for j in range(m):
			if init_map[i][j] == 0:
				init_map[i][j] = 1
				wall(wall_ctr + 1)
				init_map[i][j] = 0

wall(0)
print(result)
