'''
	1회 20240807
	2회 20240808
	3회

	아이디어
		1.
'''
import sys
input = sys.stdin.readline

n, c = map(int, input().split())
a = []
for _ in range(n):
	a.append(int(input()))
a.sort()

lo = a[0]
hi = a[-1] - a[0]
answer = 0

while lo <= hi:
	mid = (hi + lo) // 2
	ctr = 1
	val = a[0]
	for x in a[1:]:
		if x >= val + mid:
			val = x
			ctr += 1
	if ctr >= c:
		answer = mid
		lo = mid + 1
	else:
		hi = mid - 1

print(answer)
