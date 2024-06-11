'''
	1회 20240611
	2회
	3회

	아이디어
	1. 0으로 이루어진 수열의 개수를 구한다.
	2. 1로 이루어진 수열의 개수를 구한다.
	3. 둘 중에 더 작은 개수를 출력한다.
'''

data = input()

zero = 0
one = 0

if data[0] == '0':
	zero += 1
else:
	one +=1
for i in range(1, len(data)):
	if data[i - 1] != data[i]:
		if data[i] == '0':
			zero += 1
		else:
			one += 1

print(min(zero, one))
