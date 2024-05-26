from sys import stdin

for _ in range(int(stdin.readline().rstrip())):
    a = list(stdin.readline().rstrip().split())
    for i in a:
        print(i[::-1], end=' ')
