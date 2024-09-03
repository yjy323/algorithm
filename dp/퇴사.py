n = int(input())
data = []
for _ in range(n):
	data.append(list(map(int, input().split())))

dp = [0] * (n + 1)
max_cost = 0

for i in range(n - 1, -1, -1):
	time, cost = data[i]
	time += i
	if time > n:
		dp[i] = max_cost
	else:
		dp[i] = max_cost = max(max_cost, dp[time] + cost)

print(max_cost)
