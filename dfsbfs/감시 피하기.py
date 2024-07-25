'''
	1회 20240723
	2회
	3회

	아이디어
		1.
'''

from itertools import combinations

def view(t, d, candidate):
	x, y = t
	while 0 <= x < n and 0 <= y < n:
		x += d[0]
		y += d[1]
		if (x, y) in candidate:
			return True
		if (x, y) in students:
			return False
	return True

n = int(input())
matrix = [list(input().split()) for _ in range(n)]

teachers, students, emptys = [], [], []
for i in range(n):
	for j in range(n):
		if matrix[i][j] == 'T':
			teachers.append((i, j))
		elif matrix[i][j] == 'S':
			students.append((i, j))
		else:
			emptys.append((i, j))

candidates = list(combinations(emptys, 3))

d = [(1, 0), (0, 1), (-1, 0), (0, -1)]

flag = False
for candidate in candidates:
	t_cnt = 0
	for t in teachers:
		d_cnt = 0
		for i in range(4):
			if view(t, d[i], candidate):
				d_cnt += 1
		if d_cnt == 4:
			t_cnt += 1
	if t_cnt == len(teachers):
		flag = True

print('YES' if flag == True else 'NO')
