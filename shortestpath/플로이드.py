import sys
input = sys.stdin.readline

n = int(input()) + 1
m = int(input())

INF = 100000
dp = [[INF] * n for _ in range(n)]
for _ in range(m):
	a, b, c = map(int, input().split())
	dp[a][b] = min(dp[a][b], c)

for k in range(1, n):
	for i in range(1, n):
		for j in range(1, n):
			dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])

for i in range(1, n):
	for j in range(1, n):
		if dp[i][j] == INF or i == j:
			dp[i][j] = 0
		print(dp[i][j], end = " ")
	print()
