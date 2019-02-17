import java.util.*;
public class Minesweeper
{
	private int num_rows;
	private int num_cols;
	Minesweeper()
	{
		num_rows=0;
		num_cols=0;
	}//end of function
	public void printBoard(String myBoard[][])
	{
		for(int i=0;i<myBoard.length;i++)
		{
			System.out.print(i+" ");
			for(int j=0;j<myBoard[i].length;j++)
			{
				System.out.print(myBoard[i][j]+" ");
			}
			System.out.println();
		}
		System.out.print("  ");
		for(int i=0;i<num_cols;i++)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}//end of function
	public String[][] createBoard()
	{
		String myBoard[][]=new String[num_rows][num_cols];
		for(int i=0;i<myBoard.length;i++)
		{
			for(int j=0;j<myBoard[i].length;j++)
			{
				myBoard[i][j]="*";
			}
		}
		return myBoard;
	}//end of function
	public String[][] createDummyBoard()
	{
		String dummyBoard[][]=new String[num_rows][num_cols];
		int minesLimit=num_cols-1;
		int minesCounter=0;
		dummyBoard=createBoard();
		while(minesCounter<minesLimit)
		{
			int x=(int)(Math.random()*num_rows);
			int y=(int)(Math.random()*num_cols);
			if(dummyBoard[x][y].equals("*"))
			{
				dummyBoard[x][y]="X";
				minesCounter++;
			}
		}
		return dummyBoard;
	}//end of function
	public void setRows(int rows)
	{
		num_rows=rows;
	}//end of function
	public int getRows()
	{
		return num_rows;
	}//end of function
	public void setCols(int cols)
	{
		num_cols=cols;
	}//end of function
	public int getCols()
	{
		return num_cols;
	}//end of function
	public boolean selectedMine(String dummyBoard[][],Choice choice)
	{
		if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()].equals("X"))
		{
			return true;
		}
		return false;
	}//end of function
	public boolean filledBoard(String myBoard[][],String dummyBoard[][])
	{
		for(int i=0;i<myBoard.length;i++)
		{
			for(int j=0;j<myBoard[i].length;j++)
			{
				if(myBoard[i][j].equals(dummyBoard[i][j])&&!dummyBoard[i][j].equals("X"))
				{
					return false;
				}
			}
		}
		return true;
	}//end of function
	public boolean gameOver(String myBoard[][],String dummyBoard[][],Choice choice)
	{
		return selectedMine(dummyBoard,choice)||filledBoard(myBoard,dummyBoard);
	}//end of function
	public String[][] completeBoard(String myBoard[][],String dummyBoard[][])
	{
		for(int i=0;i<myBoard.length;i++)
		{
			for(int j=0;j<myBoard[i].length;j++)
			{
				if(dummyBoard[i][j].equals("X"))
				{
					myBoard[i][j]="X";
				}
			}
		}
		return myBoard;
	}//end of function
	public int numBombsAround(String dummyBoard[][],Choice choice)
	{
		int numBombs=0;
		if(choice.getChoiceX()==0)//if the player's choice is in the first row
		{
			if(choice.getChoiceY()==0)//if the player's choice is in the first column
			{
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
			}
			else if(choice.getChoiceY()==num_cols-1)//if the player's choice is in the last column
			{
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
			}
			else//if the player's choice is anywhere else
			{
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
			}
		}
		else if(choice.getChoiceX()==num_rows-1)//if the player's choice is in the last row
		{
			if(choice.getChoiceY()==0)//if the player's choice is in the first column
			{
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
			}
			else if(choice.getChoiceY()==num_cols-1)//if the player's choice is in the last column
			{
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
			}
			else//if the player's choice is anywhere else
			{
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
			}
		}
		else//if the player's choice is anywhere else
		{
			if(choice.getChoiceY()==0)//if the player's choice is in the first column
			{
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
			}
			else if(choice.getChoiceY()==num_cols-1)//if the player's choice is in the last column
			{
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
			}
			else//if the player's choice is anywhere else
			{
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()-1][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()+1].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()].equals("X"))
				{
					numBombs+=1;
				}
				if(dummyBoard[choice.getChoiceX()+1][choice.getChoiceY()-1].equals("X"))
				{
					numBombs+=1;
				}
			}
		}
		return numBombs;
	}//end of function
	public void playGame(String myBoard[][],String dummyBoard[][])
	{
		Choice choice=new Choice();
		Scanner scanner=new Scanner(System.in);
		do
		{
			do
			{
				System.out.print("Please enter your choice: ");
				choice.setChoiceX(scanner.nextInt());
				choice.setChoiceY(scanner.nextInt());
				if(choice.getChoiceX()<0||choice.getChoiceX()>=num_rows||choice.getChoiceY()<0||choice.getChoiceY()>=num_cols)
				{
					System.out.println("Please enter a choice that's within the range of the board!");
				}
			}while(choice.getChoiceX()<0||choice.getChoiceX()>=num_rows||choice.getChoiceY()<0||choice.getChoiceY()>=num_cols);
			if(!selectedMine(dummyBoard,choice))
			{
				myBoard[choice.getChoiceX()][choice.getChoiceY()]=Integer.toString(numBombsAround(dummyBoard,choice));
				printBoard(myBoard);
			}
			else
			{
				myBoard[choice.getChoiceX()][choice.getChoiceY()]="X";
				System.out.println("You lose!");
			}
		}while(!gameOver(myBoard,dummyBoard,choice));
		myBoard=completeBoard(myBoard,dummyBoard);
		System.out.println("The completed board is as follows: ");
		printBoard(myBoard);
		if(!selectedMine(dummyBoard,choice))
		{
			System.out.println("You win!");
		}
	}//end of function
	public static void main(String args[])
	{
		Minesweeper mine=new Minesweeper();
		Scanner scanner=new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		mine.setRows(scanner.nextInt());
		System.out.print("Enter the number of columns: ");
		mine.setCols(scanner.nextInt());
		String myBoard[][]=new String[mine.getRows()][mine.getCols()];
		String dummyBoard[][]=new String[mine.getRows()][mine.getCols()];
		myBoard=mine.createBoard();
		dummyBoard=mine.createDummyBoard();
		mine.printBoard(myBoard);
		//mine.printBoard(dummyBoard);--->Only used for testing purposes
		mine.playGame(myBoard,dummyBoard);
	}//end of function
}