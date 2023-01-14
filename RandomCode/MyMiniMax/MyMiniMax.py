from math import inf as infinity
from random import choice
import platform
import time
from os import system

class GameNode:
    def __init__(self, name, value=1, parent=None):
        self.Name = name      # a char
        self.value = value    # an int
        self.parent = parent  # a node reference
        self.children = []    # a list of nodes

    def addChild(self, childNode):
        self.children.append(childNode)

class GameTree:
    def __init__(self):
        self.root = None

    def build_tree(self, data_list):
        """
        :param data_list: Take data in list format
        :return: Parse a tree from it
        """
        self.root = GameNode(data_list.pop(0))
        for elem in data_list:
            self.parse_subtree(elem, self.root)

    def parse_subtree(self, data_list, parent):
        # base case
        if type(data_list) is tuple:
            # make connections
            leaf_node = GameNode(data_list[0])
            leaf_node.parent = parent
            parent.addChild(leaf_node)
            # if we're at a leaf, set the value
            if len(data_list) == 2:
                leaf_node.value = data_list[1]
            return

        # recursive case
        tree_node = GameNode(data_list.pop(0))
        # make connections
        tree_node.parent = parent
        parent.addChild(tree_node)
        for elem in data_list:
            self.parse_subtree(elem, tree_node)

        # return from entire method if base case and recursive case both done running
        return

def parse_data_as_list(fname):
    with open(fname, "r") as f:
        data_as_string = f.read()
        print (data_as_string)
        data_list = literal_eval(data_as_string)
    return data_list


def minimax(state, depth, player):
    """
    AI function that choice the best move
    :param state: current state of the board
    :param depth: node index in the tree (0 <= depth <= 9),
    but never nine in this case (see iaturn() function)
    :param player: an human or a computer
    :return: a list with [the best row, best col, best score]
    """
    if player == COMP:
        best = [-1, -1, -infinity]
    else:
        best = [-1, -1, +infinity]

    if depth == 0 or game_over(state):
        score = evaluate(state)
        return [-1, -1, score]

    for cell in empty_cells(state):
        x, y = cell[0], cell[1]
        state[x][y] = player
        score = minimax(state, depth - 1, -player)
        state[x][y] = 0
        score[0], score[1] = x, y

        if player == COMP:
            if score[2] > best[2]:
                best = score  # max value
        else:
            if score[2] < best[2]:
                best = score  # min value

    return best



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

def change_state(state2, change_row, change_col):
    """updates the state at possition specified to 1. This means it has an item"""
    state2[change_row][change_col] = 1
    return state2


def best_move(state, depth):
    if depth == 0:
        stuff = 0
    else:
        best_move(state, depth-1)
    
    
        

current_state = [[0 for y in range(9)]for x in range(3)]

#while True:
#    print(" 1  2  3  4  5  6  7  8  9")
#    for i in range(3):
#        print(state[i])
#    change_state(state, int(input("Row: "))-1, int(input("Col: "))-1)
#    find_score(state)
#    print()

data_tree = GameTree()
data_tree.build_tree(data_list)
best_move(current_state, 3)
    