n, m, k = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
count = m // (k + 1) * k + m % (k + 1)
print(count * data[-1] + (m - count) * data[-2])
