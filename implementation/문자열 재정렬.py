'''
	1회 20240614
	2회
	3회

	아이디어
		1. sort()를 이용한다.
'''

data = list(input())
data.sort()

digit = 0
while data[0].isdigit():
	digit += int(data[0])
	data.remove(data[0])

if digit > 0:
	data.append(str(digit))
print(''.join(data))
