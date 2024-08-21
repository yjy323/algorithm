t = int(input())

for _ in range(t):
	n, m = map(int, input().split())
	golds = list(map(int, input().split()))

	dp = []
	i = 0
	for _ in range(n):
		dp.append(golds[i:i + m])
		i += m
	
	for j in range(1, m):
		for i in range(n):
			left, left_up, left_down = 0, 0, 0
			left = dp[i][j - 1]
			if i != 0:
				left_up = dp[i - 1][j - 1]
			if i != n - 1:
				left_up = dp[i + 1][j - 1]
			
			dp[i][j] += max(left, left_up, left_down)
	print(max([x[m - 1] for x in dp]))
