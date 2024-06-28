'''
	1회 20240628
	2회 
	3회

	아이디어
		1. 원형 완전탐색 문제
		2. Bit-Masking과 Permutation가 핵심 아이디어
'''
from itertools import permutations

def inspect(n, weak, dist):
    lists = [weak.copy() for _ in range(len(weak))]
    
    for i in range(len(weak)):
        for _ in range(i):
            lists[i].append(lists[i].pop(0) + n)
    for i in range(1, len(dist) + 1):
        permutations_list = list(permutations(dist, i))
        for permutation in permutations_list:
            for a_list in lists:
              ptr = 0
              for p in permutation:
                      val = a_list[ptr] + p
                      while a_list[ptr] <= val:
                              ptr += 1
                              if ptr == len(a_list):
                                   return i
    return -1
                
def solution(n, weak, dist):
    return inspect(n, weak, dist)

