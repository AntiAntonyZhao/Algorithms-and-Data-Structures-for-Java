import java.util.*;
public class A2_Q1{
	public static int game_recursion(int[][] board) {
		boolean DadTurn = true; // Initialize the boolean for turning before the recursion
		return gr_helper(board, DadTurn);
	}
	private static int gr_helper(int[][] board, boolean DadTurn) {
		int pD = 0; // point difference
		List<Integer> DifferenceS = new ArrayList<Integer>();
		if(!hasMove(board)){			// No move available, Game over.
			pD = 0;
		}else {
			for(int row=0; row<board.length; row++){
				for(int col=0; col<board[0].length; col++){
					if(board[row][col] == 0){
						if(canMove(board, row-2, col, row-1, col)){	//Move from North
							int[][] copyBoard = copyBoard(board);
							int score = move(copyBoard, row, col,DadTurn, Direction.N);
							int recursionPoint = gr_helper(copyBoard, DadTurn);
							pD = score - recursionPoint;
							DifferenceS.add(pD);
						}
						if(canMove(board, row+2, col, row+1, col)){	//Move from South
							int[][] copyBoard = copyBoard(board);
							int score = move(copyBoard, row, col,DadTurn, Direction.S);
							int recursionPoint = gr_helper(copyBoard, DadTurn);
							pD = score - recursionPoint;
							DifferenceS.add(pD);
						}
						if(canMove(board, row, col-2, row, col-1)){	//Move from West
							int[][] copyBoard = copyBoard(board);
							int score = move(copyBoard, row, col,DadTurn, Direction.W);
							int recursionPoint = gr_helper(copyBoard, DadTurn);
							pD = score - recursionPoint;
							DifferenceS.add(pD);
						}
						if(canMove(board, row, col+2, row, col+1)){	//Move from East
							int[][] copyBoard = copyBoard(board);
							int score = move(copyBoard, row, col,DadTurn, Direction.E);
							int recursionPoint = gr_helper(copyBoard, DadTurn);
							pD = score - recursionPoint;
							DifferenceS.add(pD);
						}
						if(canMove(board, row-2, col-2, row-1, col-1)){	//Move from NorthWest
							int[][] copyBoard = copyBoard(board);
							int score = move(copyBoard, row, col,DadTurn, Direction.NW);
							int recursionPoint = gr_helper(copyBoard, DadTurn);
							pD = score - recursionPoint;
							DifferenceS.add(pD);
						}
						if(canMove(board, row+2, col+2, row+1, col+1)){	//Move from SouthEast
							int[][] copyBoard = copyBoard(board);
							int score = move(copyBoard, row, col,DadTurn, Direction.SE);
							int recursionPoint = gr_helper(copyBoard, DadTurn);
							pD = score - recursionPoint;
							DifferenceS.add(pD);
						}
					}
				}
			}
		}
		for(int i = 0; i<DifferenceS.size();i++) {
			pD = Math.max(pD, DifferenceS.get(i));
		}
		return pD;
	}
	private static boolean hasMove (int[][] board){
		boolean hasMove = false;
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board[row].length; col++){ // only check for the pyramid area.
				if(board[row][col] == 0){
					if(canMove(board, row-2, col, row-1, col)  			//Move from North
							|| canMove(board, row+2, col, row+1, col)	//Move from South
							|| canMove(board, row, col-2, row, col-1)	//Move from West
							|| canMove(board, row, col+2, row, col+1)	//Move from East
							|| canMove(board, row-2, col-2, row-1, col-1) 	//Move from NorthWest
							|| canMove(board, row+2, col+2, row+1, col+1)) {//Move from SouthEast
						hasMove = true;
					}
				}
			}
		}
		return hasMove;
	}
	private static boolean canMove (int[][] board, int row, int col, int rowMiddle, int colMiddle){
		boolean canMove = true;
		if(row > board.length-1 || row < 0) {	// row out
			canMove = false;
		}else if (col > board[row].length-1 || col < 0) { // col out
			canMove = false;
		}else if(board[row][col] <=0 || board[rowMiddle][colMiddle] <= 0){ //Can not jump from/over an ZERO
			canMove = false;
		}
		return canMove;
	}
	private static int move (int [][] board, int row, int col, Boolean DadTurn, Direction d) {
		int score=0;
		if(d==Direction.N) {
			board[row][col] = board[row-2][col];
			score = board[row-2][col] * board[row-1][col];
			// Dad/Kid Iterator
			if(DadTurn){ 
				DadTurn = false;
			}else{
				DadTurn = true;
			}
			board[row-2][col] = 0; // update the jumped area
			board[row-1][col] = 0;
		}
		if(d==Direction.S) {
			board[row][col] = board[row+2][col];
			score = board[row+2][col] * board[row+1][col];
			// Dad/Kid Iterator
			if(DadTurn){
				DadTurn = false;
			}else{
				DadTurn = true;
			}
			board[row+2][col] = 0; // update the jumped area
			board[row+1][col] = 0;
		}
		if(d==Direction.W) {
			board[row][col] = board[row][col-2];
			score = board[row][col-2] * board[row][col-1];
			// Dad/Kid Iterator
			if(DadTurn){
				DadTurn = false;
			}else{
				DadTurn = true;
			}
			board[row][col-2] = 0; // update the jumped area
			board[row][col-1] = 0;
		}
		if(d==Direction.E) {
			board[row][col] = board[row][col+2];
			score = board[row][col+2] * board[row][col+1];
			// Dad/Kid Iterator
			if(DadTurn){
				DadTurn = false;
			}else{
				DadTurn = true;
			}
			board[row][col+2] = 0; // update the jumped area
			board[row][col+1] = 0;
		}
		if(d==Direction.NW) {
			board[row][col] = board[row-2][col-2];
			score = board[row-2][col-2] * board[row-1][col-1];
			// Dad/Kid Iterator
			if(DadTurn){
				DadTurn = false;
			}else{
				DadTurn = true;
			}
			board[row-2][col-2] = 0; // update the jumped area
			board[row-1][col-1] = 0;
		}
		if(d==Direction.SE) {
			board[row][col] = board[row+2][col+2];
			score = board[row+2][col+2] * board[row+1][col+1];
			// Dad/Kid Iterator
			if(DadTurn){
				DadTurn = false;
			}else{
				DadTurn = true;
			}
			board[row+2][col+2] = 0; // update the jumped area
			board[row+1][col+1] = 0;
		}
		return score;
	}
	private static int[][] copyBoard(int[][] board) {
		int[][] newB = new int[5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(board[i][j]>-1) {
					newB[i][j]=board[i][j];
				}else {
					newB[i][j]=-1;
				}
			}
		}
		return newB;
	}
	private enum Direction{
		N, S, W, E, NW, SE
	};
}
