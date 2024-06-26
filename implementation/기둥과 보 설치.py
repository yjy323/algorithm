'''
	1회 20240625
	2회 20240626
	3회

	아이디어
		1. 시물레이션 문제
		2. 각 명령을 수행한다.
    3. 명령을 우선 수행한 뒤, 건물 전체가 조건을 만족하는 지 확인한다.
			1. 효율성보다는 문제의 조건을 잘 이행하는 지 확인하는 문제이기 때문이다.
'''

VER, HOR = 0, 1
REMOVE, APPEND = 0, 1

def inspect_buildings(answer):
    for building in answer:
        x, y, a = building
        if a == VER:
            if y != 0 \
								and (x, y - 1, VER) not in answer \
								and (x, y, HOR) not in answer and (x - 1, y, HOR) not in answer:
                return False
        else:
            if (x, y - 1, VER) not in answer and (x + 1, y - 1, VER) not in answer \
								and ((x - 1, y, HOR) not in answer or (x + 1, y, HOR) not in answer):
                return False
    return True

def build(answer, build_frame):
    for build_info in build_frame:
        x, y, a, b = build_info
        building = (x, y, a)
        if b == APPEND:
            answer.append(building)
            if not inspect_buildings(answer):
                answer.remove(building)
        else:
            answer.remove(building)
            if not inspect_buildings(answer):
                answer.append(building)

def solution(n, build_frame):
    answer = []
    build(answer, build_frame)
    return sorted(answer)
