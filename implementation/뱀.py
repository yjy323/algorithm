'''
	1회 20240615
	2회
	3회

	아이디어
		1. 시뮬레이션: 문제의 조건을 '정확히' 구현한다.
'''

import sys
input = sys.stdin.readline

n = int(input())
k = int(input())
data = [[0] * (n + 1) for _ in range(n + 1)]
info = {}

for _ in range(k):
	a, b = map(int, input().split())
	data[a][b] = 1

l = int(input())
for _ in range(l):
	a, b = input().split()
	info[int(a)] = b

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def turn(direction, c):
	if c == 'L':
		direction = (direction - 1) % 4
	else:
		direction = (direction + 1) % 4
	return direction

def simulate():
	nx, ny = 1, 1
	data[nx][ny] = 2
	direction = 0
	time = 0
	q = [(nx, ny)]
	while True:
		nx += dx[direction]
		ny += dy[direction]

		time += 1
		if not(1 <= nx <= n and 1 <= ny <= n) or data[nx][ny] == 2:
			break
		if data[nx][ny] == 0:
			px, py = q.pop(0)
			data[px][py] = 0
		data[nx][ny] = 2
		q.append((nx, ny))
		if time in info:
			direction = turn(direction, info[time])
	return time

print(simulate())
