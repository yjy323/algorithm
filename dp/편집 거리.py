s1 = input()
s2 = input()
n = len(s1) + 1
m = len(s2) + 1

dp = [[0] * m for _ in range(n)]
for i in range(1, n):
	dp[i][0] = i
for j in range(1, m):
	dp[0][j] = j

for i in range(1, n):
	for j in range(1, m):
		if s1[i - 1] == s2[j - 1]:
			dp[i][j] = dp[i - 1][j - 1]
		else:
			dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])

print(dp[n - 1][m - 1])
