'''
	1회 20240723
	2회
	3회

	아이디어
		1.
'''

from itertools import permutations

n = int(input())
a = list(map(int, input().split()))
m = list(map(int, input().split()))

ops = []
ops.extend(['+'] * m[0])
ops.extend(['-'] * m[1])
ops.extend(['*'] * m[2])
ops.extend(['/'] * m[3])\

ops_comb = set(permutations(ops, len(ops)))
max_calc = -10**9
min_calc = 10**9
for ops in ops_comb:
	i = 0
	calc = a[i]
	for op in ops:
		i += 1
		if op == '+':
			calc += a[i]
		elif op == '-':
			calc -= a[i]
		elif op == '*':
			calc *= a[i]
		elif op == '/':
			calc = int(calc / a[i])
	max_calc = max(max_calc, calc)
	min_calc = min(min_calc, calc)

print(max_calc)
print(min_calc)
