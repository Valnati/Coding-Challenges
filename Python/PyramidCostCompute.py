"""
Given a cap, and a cost of an individual unit,
compute how many levels of a pyramid can be constructed
Assume pyramid levels require n^2 units, 
where n is the current level.

This solution loops through each level, calculating
its added cost, until it overestimates, and returns 
the level at which the cap was reached.

The space cost is constant, with only two variables.
The time cost is root(n), where n is the number of final levels.
"""

def pyramidcostcompute(cap, price):
    if cap<price: return 0

    total = 0.0
    level = 1
    
    while(total < cap):
        total += level*level*price
        level += 1
    return level-1 if total==bonus else level-2
