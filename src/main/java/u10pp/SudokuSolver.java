package u10pp;

public class SudokuSolver{
    /**
     * 
     * @param puzzle - a sudoku board with one solution
     * @return - returns a solved sudoku board
     */
    public static int[][] solve(int[][] puzzle){
        if(boardSolve(puzzle) == true){
            return puzzle;
        } else{
            System.out.println("Puzzle was not solveable");
            return puzzle;
        }
    }

    /**
     * 
     * @param puzzle - a sudoku board
     * @param checked - the number that is being checked for duplicates
     * @param row - the row that the number is being checked for
     * @return - true if the checked number is in the row, false if else
     */
    public static boolean isInRow(int[][] puzzle, int checked, int row){
        for(int i = 0; i < puzzle.length; i++){
            if(puzzle[row][i] == checked){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param puzzle - a sudoku board
     * @param checked - the number that is being checked for duplicates
     * @param column - the column that the number is being checked for
     * @return - true if the checked number is in the column, false if else
     */
    public static boolean isInColumn(int[][] puzzle, int checked, int column){
        for(int i = 0; i < puzzle.length; i++){
            if(puzzle[i][column] == checked){
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param puzzle - a sudoku board
     * @param checked - the number that is being checked for duplicates
     * @param row - the row that the number is being checked for
     * @param column - the column that the number is being checked for
     * @return - true if the checked number is in the small box on the sudoku board, false if else
     */
    public static boolean isInBox(int[][] puzzle, int checked, int row, int column){
        int smallBoxLength = (int)(Math.sqrt(puzzle.length));
        int smallBoxRow = row - (row % smallBoxLength);
        int smallBoxColumn = column - (column % smallBoxLength);

        for(int r = smallBoxRow; r < (smallBoxRow + smallBoxLength); r++){
            for(int c = smallBoxColumn; c < (smallBoxColumn + smallBoxLength); c++){
                if(puzzle[r][c] == checked){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param puzzle - a sudoku board
     * @return - recursive function that loops through the board, returns true once the board is solved
     */
    public static boolean boardSolve(int[][] puzzle){
        if(isBoardSolved(puzzle) == true){
            return true;
        } else{
            for(int r = 0; r < puzzle.length; r++){
                for(int c = 0; c < puzzle.length; c++){
                    if(puzzle[r][c] == 0){
                        for(int count = 1; count <= puzzle.length; count++){
                            if(isInRow(puzzle, count, r) == false && isInColumn(puzzle, count, c) == false && isInBox(puzzle, count, r, c) == false){
                                puzzle[r][c] = count;
    
                                if(boardSolve(puzzle) == true){
                                    return true;
                                } else{
                                    puzzle[r][c] = 0;
                                }
                            }
                        }
                        return false;
                    }
                }
            }
            return false;
        }
    }

    /**
     * 
     * @param puzzle - a sudoku board
     * @return - returns true if the board is solved, i.e. no zeros in the board
     */
    public static boolean isBoardSolved(int[][] puzzle){
        for(int r = 0; r < puzzle.length; r++){
            for(int c = 0; c < puzzle.length; c++){
                if(puzzle[r][c] == 0){
                    return false;
                }
            }
        }
        return true;
    }
}