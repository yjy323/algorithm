n, k = map(int, input().split(" "))

count = 0
while n > 1:
	mod = n % k
	count += mod
	n -= mod
	if n < k:
		break
	n //= k
	count += 1

count += n - 1
print(count)
