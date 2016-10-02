/**
 * Steven Ward
 * GameBoard.java | Tic Tac Toe Project
 *
 * This file contains the definition for the GameBoard class, which is described below.
 *
 * Due Date: October 2, 2016
 *
 */

/**
 * GameBoard class that encapsulates a 'tic-tac-toe' board.
 * The 'GameBoard' class is an implementation of the board used in a game of 'tic-tac-toe'.
 * A 'tic-tac-toe' board is a 3x3 table of equally-sized squares, each of which being empty or
 * containing either a single 'X' or 'O' symbol. A player wins the game by having three like symbols
 * in a single column, row, or diagonal.
 *
 * TODO: DOCUMENTATION!
 *        - rewrite class description
 *        - write method descriptions and line comments
 */

public class GameBoard {

  // Only instance field of the GameBoard class.
  private char[][] board;

  // Only initializer (default) for the GameBoard class.
  public GameBoard() {
    this.board = new char[3][3];
    this.resetBoard();
  }


  // DEFINITION OF PRIVATE INSTANCE METHODS
  // --------------------------------------

  public void resetBoard() {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        this.board[row][col] = '-';
      }
    }
  }


  public void display() {
    System.out.println("-------------");

    for (int row = 0; row < 3; row++) {
      System.out.print("| ");
      for (int col = 0; col < 3; col++) {
        System.out.print(this.board[row][col] + " | ");
      }
      System.out.println();
      System.out.println("-------------");
    }
  }


  public boolean attemptPlay(int row, int col, char mark) {
    mark = Character.toLowerCase(mark);

    if ( !(mark == 'x' || mark == 'o') ) {
      return false;
    }
    else if ( isValidPlay(row, col) ) {
      this.board[row][col] = mark;
      return true;
    }
    else {
      return false;
    }
  }


  public boolean isFull() {
    boolean full = true;
    int row = 0;
    while (row < 3 && full) {
      int col = 0;
      while (col < 3 && full) {
        full = ( this.board[row][col] == '-' ) ? false : full;
        col++;
      }
      row++;
    }
    return full;
  }


  public boolean hasWinner() {
    return winByRow() || winByColumn() || winByDiagonal();
  }


  // DEFINITION OF PRIVATE INSTANCE METHODS
  // --------------------------------------

  private boolean isValidPlay(int row, int col) {
    boolean validRow = ( row >= 0 && row < 3 );
    boolean validCol = ( col >= 0 && col < 3 );

    return ( validRow && validCol && this.board[row][col] == '-' );
  }


  private boolean charCompare3(char[] chars) {
    return ( chars[0] != '-' && chars[0] == chars[1] && chars[1] == chars[2] );
  }


  private boolean winByRow() {
    boolean winner = false;
    for (int row = 0; row < 3; row++) {
      winner = charCompare3(this.board[row]) ? true : winner;
    }
    return winner;
  }


  private boolean winByColumn() {
    boolean winner = false;
    int col = 0;
    while (col < 3 && !winner) {
      char[] column =
          { this.board[0][col], this.board[1][col], this.board[2][col] };
      winner = charCompare3(column) ? true : winner;
      col++;
    }
    return winner;
  }


  private boolean winByDiagonal() {
    char[] diagA =
        { this.board[0][0], this.board[1][1], this.board[2][2] };
    char[] diagB =
        { this.board[0][2], this.board[1][1], this.board[2][0] };

    return ( charCompare3(diagA) || charCompare3(diagB) );
  }
}
