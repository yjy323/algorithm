n = int(input())
tri = []

for _ in range(n):
	tri.append(list(map(int, input().split())))

for i in range(1, n):
	m = len(tri[i])
	for j in range(m):
		if j == 0:
			tri[i][j] += tri[i - 1][j]
		elif j == m - 1:
			tri[i][j] += tri[i - 1][j - 1]
		else:
			tri[i][j] += max(tri[i - 1][j - 1], tri[i - 1][j])
print(max(tri[n - 1]))
