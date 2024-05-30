n, m = map(int, input().split(" "))

max_value = 0
for _ in range(n):
	max_value = max([max_value, min(list(map(int, input().split(" "))))])
print(max_value)
