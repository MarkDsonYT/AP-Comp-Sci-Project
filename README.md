Algorithm:
1. Goes through each element in grid and counts the number of ' X's around its neighbors. 
2. If the ammount is 3 and the grid position is empty, it makes an " X" in the same position on a new grid, else it makes "  "
3. If the ammmount is 2 or 3 and the grid position has ' X' then it makes ' X' in the same position on a new grid, else it makes '  '
4. The new grid is copied onto the private instance variable grid[][].
