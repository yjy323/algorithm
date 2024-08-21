'''
	1회 20240808
	2회
	3회

	아이디어
		1.
'''
n = int(input())
a = list(map(int, input().split()))

def binary_search(a, lo, hi):
	if lo > hi:
		return -1
	mid = (lo + hi) // 2

	if a[mid] == mid:
		return mid
	elif a[mid] < mid:
		return binary_search(a, mid + 1, hi)
	else:
		return binary_search(a, lo, mid - 1)

print(binary_search(a, 0, n - 1))
