n, m = map(int, input().split())
coin = []
for _ in range(n):
	coin.append(int(input()))

MAX_VALUE = 10001

dp = [MAX_VALUE] * (m + 1)
dp[0] = 0
for i in range(n):
	for j in range(coin[i], m + 1):
		dp[j] = min(dp[j], dp[j - coin[i]] + 1)
		
if dp[m] == MAX_VALUE:
	print(-1)
else:
	print(dp[m])
