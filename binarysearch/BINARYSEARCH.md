Binary Search
===
### 시간 복잡도
매 단계마다 확인해야할 값이 1/2로 줄어든다: O(logN)

---
### Code
```python
def binary_search(array, target, start, end):
	if start > end:
		return None
	mid = (start + end) // 2

	if array[mid] == target:
		return mid
	elif array[mid] > target:
		binary_search(array, target, start, mid - 1)
	else:
		binary_search(array, target, mid + 1, end)
```

---
### bisect()
이분 탐색 라이브러리이지만, 기본적으로 삽입 위치를 찾는데 유용하다. 검색 작업(값의 유무 검사 등)에 사용하기 위해서는 응용이 필요하다.

---
### Parametric Search
이분 탐색의 원리를 활용해 최적화 문제를 결정 문제로 치환하는 알고리즘 기법이다.</br>
다음 세 조건을 만족하는 경우 적용할 수 있다.
1. **특정 조건**을 만족하는 **최댓값/최솟값**을 구하는 문제
2. 어떤 값이 **특정 조건**을 만족한다면 그보다 큰 값(문제에 따라 작은 값)은 모두 **해당 조건**을 만족한다.
3. 답의 범위가 정수이거나, 오차를 허용한다.

이분 탐색의 성질을 이용하기 위해서는 1, 2번 조건이 필요하다.</br>
이분 탐색의 특징에 의해 3번 조건이 필요하다.
