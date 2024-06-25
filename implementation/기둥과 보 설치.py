'''
	1회 20240625
	2회
	3회

	아이디어
		1. 시물레이션 문제
		2. 각 조건을 검증하는 함수를 작성한다.
			1. 기둥을 설치하는 조건
			2. 기둥을 삭제하는 조건
			3. 보를 설치하는 조건
			4. 보를 삭제하는 조건
		3. 입력 순서대로 각 조건을 검증하며 건축을 수행한다.
'''

from copy import deepcopy

VERT = 0
HORZ = 1
POP = 0
PUSH = 1

def push_v(answer, x, y):
	if y == 0 \
			or (x, y - 1, VERT) in answer \
			or (x, y, HORZ) in answer or (x - 1, y, HORZ) in answer:
		return True
	else:
		return False
	
def push_h(answer, x, y):
	if (x, y - 1, VERT) in answer or (x + 1, y - 1, VERT) in answer \
			or ((x - 1, y, HORZ) in answer and (x + 1, y, HORZ) in answer):
		return True
	else:
		return False
	
def pop_v(answer, x, y):
	new_answer = deepcopy(answer)
	new_answer.remove((x, y, VERT))
	if (x, y + 1, VERT) in new_answer and not push_v(new_answer, x, y + 1):
		return False
	elif (x, y + 1, HORZ) in new_answer and not push_h(new_answer, x, y + 1):
		return False
	elif (x - 1, y + 1, HORZ) in new_answer and not push_h(new_answer, x - 1, y + 1):
		return False
	else:
		return True
	
def pop_h(answer, x, y):
	new_answer = deepcopy(answer)
	new_answer.remove((x, y, HORZ))
	if (x, y, VERT) in new_answer and not push_v(new_answer, x, y):
		return False
	elif (x + 1, y, VERT) in new_answer and not push_v(new_answer, x + 1, y):
		return False
	elif (x - 1, y, HORZ) in new_answer and not push_h(new_answer, x - 1, y):
		return False
	elif (x + 1, y, HORZ) in new_answer and not push_h(new_answer, x + 1, y):
		return False
	else:
		return True

def solution(n, build_frame):
	answer = []
	for x, y, a, b in build_frame:
		if a == VERT and b == PUSH and push_v(answer, x, y):
			answer.append((x, y, VERT))
		elif a == HORZ and b == PUSH and push_h(answer, x, y):
			answer.append((x, y, HORZ))
		elif a == VERT and b == POP and pop_v(answer, x, y):
			answer.remove((x, y, VERT))
		elif a == HORZ and b == POP and pop_h(answer, x, y):
			answer.remove((x, y, HORZ))
	answer.sort()
	return answer

print(solution(5, [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]))
