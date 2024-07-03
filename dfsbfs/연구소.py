'''
	1회 20240702
	2회 20240703
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
from itertools import combinations

input = sys.stdin.readline

n, m = map(int, input().split())
init_map = []

for _ in range(n):
	init_map.append(list(map(int, input().split())))

dx = (1, 0, -1, 0)
dy = (0, 1, 0, -1)

max_safty_zone = 0
def virus(copy_map, x, y):
	for i in range(4):
		nx = x + dx[i]
		ny = y + dy[i]
		if 0 <= nx < n and 0 <= ny < m and copy_map[nx][ny] == 0:
			copy_map[nx][ny] = 2
			virus(copy_map, nx, ny)

def safty_zone(copy_map):
	zone = 0
	for row in copy_map:
		for col in row:
			if col == 0:
				zone += 1
	return zone

def wall(max_safty_zone):
	candidates = list(combinations([(x, y) for x in range(n) for y in range(m) if init_map[x][y] == 0], 3))
	for candidate in candidates:
		copy_map = copy.deepcopy(init_map)
		for i in range(3):
			x, y = candidate[i]
			copy_map[x][y] = 1
		for x in range(n):
			for y in range(m):
				if init_map[x][y] == 2:
					virus(copy_map, x, y)
		max_safty_zone = max(max_safty_zone, safty_zone(copy_map))
	return max_safty_zone

print(wall(max_safty_zone))
