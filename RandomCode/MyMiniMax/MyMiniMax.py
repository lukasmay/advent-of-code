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
        for i in range(3,5):
            if state[row][i] == 1 and community_score < 3:
                community_score += 1

                
    print("current_score: " + str(current_score))
    print("indirect_score: " + str(indirect_score))
    print("community_score: " + str(community_score))
    return current_score + indirect_score + community_score

def change_state(state, change_row, change_col):
    """updates the state at possition specified to 1. This means it has an item"""
    state[change_row][change_col] = 1


state = [[0 for y in range(9)]for x in range(3)]

while True:
    print(" 1  2  3  4  5  6  7  8  9")
    for i in range(3):
        print(state[i])
    change_state(state, int(input("Row: "))-1, int(input("Col: "))-1)
    find_score(state)
    print()
    