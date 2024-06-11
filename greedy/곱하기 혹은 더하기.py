'''
	1회 20240611
	2회
	3회

	아이디어
	1. 현재까지 결과값 또는 새로 연산할 값이 0 또는 1이면 +
	2. 나머지 *
'''
data = list(map(int, list(input())))

result = data[0]
for i in data[1:]:
	if result <= 1 or i <= 1:
		result += i
	else:
		result *= i
print(result)
