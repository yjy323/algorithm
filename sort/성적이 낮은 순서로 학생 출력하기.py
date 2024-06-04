n = int(input())

scores = []
for _ in range(n):
	data = input().split()
	scores.append((data[0], int(data[1])))

scores = sorted(scores, key=lambda scores: scores[1])
print(scores)
