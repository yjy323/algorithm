n = int(input())
array = list(map(int, input().split()))

m = int(input())
request = list(map(int, input().split()))

def binary_search(target, start, end):
	if start > end:
		return None
	mid = (start + end) // 2

	if array[mid] == target:
		return mid
	elif array[mid] > target:
		return binary_search(target, start, mid - 1)
	else:
		return binary_search(target, mid + 1, end)

array.sort()
for rq in request:
	if binary_search(rq, 0, n - 1) == None:
		print('no', end = " ")
	else:
		print('yes', end = " ")
print()
