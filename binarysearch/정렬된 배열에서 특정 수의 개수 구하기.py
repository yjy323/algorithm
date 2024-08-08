'''
	1회 20240807
	2회 
	3회

	아이디어
		1.
'''
import bisect
	
n, x = map(int, input().split())
a = list(map(int, input().split()))

low = bisect.bisect_left(a, x)
high = bisect.bisect_right(a, x)

print(-1 if high == low else high - low)
