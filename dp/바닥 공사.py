# 전형적인 DP 유형의 타일링 문제

n = int(input())
dp = [0] * 1001

dp[1] = 1
dp[2] = 3
for i in range(3, n + 1):
	dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 796796

print(dp[n])
