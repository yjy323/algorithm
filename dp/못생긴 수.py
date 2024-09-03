'''
	1회 20240902
	2회
	3회

	아이디어
		1.
'''
import time
import heapq


n = int(input())

def func1(n):

	q = [1]

	cnt = 0
	while q:
		v = heapq.heappop(q)
		cnt += 1
		if cnt == n:
			print(v)
			break
		if v * 2 not in q:
			heapq.heappush(q, v * 2)
		if v * 3 not in q:
			heapq.heappush(q, v * 3)
		if v * 5 not in q:
			heapq.heappush(q, v * 5)

def func2(n):
	dp = [0] * n
	dp[0] = 1
	
	i2 = i3 = i5 = 0
	next2, next3, next5 = 2, 3, 5

	for i in range(1, n):
		dp[i] = min(next2, next3, next5)

		if dp[i] == next2:
			i2 += 1
			next2 = dp[i2] * 2
		if dp[i] == next3:
			i3 += 1
			next3 = dp[i3] * 3
		if dp[i] == next5:
			i5 += 1
			next5 = dp[i5] * 5

	print(dp[n - 1])

start = time.time()
func1(n)
print(time.time() - start)

start = time.time()
func2(n)
print(time.time() - start)
