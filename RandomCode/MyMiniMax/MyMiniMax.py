from math import inf as infinity
from random import choice
import platform
import time
from os import system


def num_Empty_Positions(state):
    count = 0
    i = 0
    cells = []
    for cell in state:
        if (cell == 0):
            count += 1
            
        i += 1
    return count

# Current Score
# Potential for more score
# Three in the community area
def find_score(state):
    for cell in state:
        fdfd


state = [[]]

for colums in range(3):
    for rows in range(9):
        state


