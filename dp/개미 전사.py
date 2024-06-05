import sys

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

arr[1] = max(arr[0], arr[1])
for i in range(2, n):
	arr[i] = max(arr[i - 1], arr[i - 2] + arr[i])

print(arr[n - 1])
