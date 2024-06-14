'''
	1회 20240614
	2회
	3회

	아이디어
		1. 특정 조건을 만족하는 지 확인
		2. 앞에서 부터 N/2개의 자릿수의 합과 나머지 N/2개의 자릿수의 합이 같으면 조건을 만족한다.
			1. 자릿수의 개수는 항상 2로 나누어 떨어진다.
'''

data = list(map(int, list(input())))
offset = len(data) // 2

if sum(data[:offset]) == sum(data[offset:]):
	print("LUCKY")
else:
	print("READY")
