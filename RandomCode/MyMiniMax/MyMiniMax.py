from math import inf as infinity
from random import choice
import platform
import time
from os import system


def num_empty_positions(state):
    """Finds and Returns the amount of unplaced spaces left on the grid"""
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
    """Calculates the score of the state passed in"""
    in_row = 0
    current_score = 0
    indirect_score = 0
    community_score = 0
    for row in range(3):
        for cell in state[row]:
            if cell != 0:
                in_row += 1
            else:
                if in_row == 2:
                    indirect_score += 2/(row + 1)
                in_row = 0
            if in_row == 3:
                in_row = 0
                current_score +=3/(row + 1)
        for i in range(2,5):
            print()
            # community score stuff

    return current_score + indirect_score

def change_state(state, change_row, change_col):
    """updates the state at possition specified to 1. This means it has an item"""
    state[change_row][change_col] = 1


state = [[0 for y in range(9)]for x in range(3)]
change_state(state, 0, 0)
change_state(state, 0, 1)
change_state(state, 0, 2)
change_state(state, 1, 2)
change_state(state, 1, 3)

print(find_score(state))