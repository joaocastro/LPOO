package Proj;

import java.util.ArrayList;

import maze.cli.Game;

public class Labirinto {
	
	private char table[][] = new char[10][10];
	
	public Labirinto(){
		
		char[] l0={'X','X','X','X', 'X', 'X', 'X', 'X', 'X', 'X'};
		char[] l1={'X','H',' ',' ', ' ', ' ', ' ', ' ', ' ', 'X'};
		char[] l2={'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'};
		char[] l3={'X','D','X','X', ' ', 'X', ' ', 'X', ' ', 'X'};
		char[] l4={'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'};
		char[] l5={'X',' ',' ',' ', ' ', ' ', ' ', 'X', ' ', 'S'};
		char[] l6={'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'};
		char[] l7={'X',' ','X','X', ' ', 'X', ' ', 'X', ' ', 'X'};
		char[] l8={'X','E','X','X', ' ', 'X', ' ', 'X', ' ', 'X'};
		char[] l9={'X','X','X','X', 'X', 'X', 'X', 'X', 'X', 'X'};
		
		table[0]=l0;
		table[1]=l1;
		table[2]=l2;
		table[3]=l3;
		table[4]=l4;
		table[5]=l5;
		table[6]=l6;
		table[7]=l7;
		table[8]=l8;
		table[9]=l9;
	}
	
	public char[][] getTable(){
		
		return table;
	}
	
	
	public int[] getPos(){
		
		int[] pos=new int[1];
		int line=0;
		int col=0;
		char type;
		int heroi=0; //Tipo 'H' = 1, Tipo 'A' = 2
		
		for (int i=0; i<10; i++)
		{
			for(int j=0; j<10; j++)
			{
				if (table[i][j]=='H')
				{
					line=i;
					col=j;
					heroi=1;
				}
				if (table[i][j]=='A')
				{
					line=i;
					col=j;
					heroi=2;
				}
			}
		}
		
		pos[0]=line;
		pos[1]=col;
		pos[2]=heroi;
		
		return pos;
	}
	
	
	public void makeMove(char dir){
		
		Game jogo = new Game();
		int pos[] = getPos();
		int line = pos[0];
		int col = pos[1];
		int heroi = pos[3];
		
		if (jogo.move(dir)==true)
		{
			switch(dir){
			case('N'):
			{
				if (table[line-1][col]=='E')
				{
					table[line][col]=' ';
					if (heroi==2)
						table[line-1][col]='A';
					else if (heroi==1)
						table[line-1][col]='H';
				}
				else if (table[line-1][col]=='D')
				{
					if (heroi==2)
					{
						table[line][col]=' ';
						table[line-1][col]='A';
					}
					else if (heroi==1)
					{
						//perde o jogo
					}
				}
				else if (table[line-1][col]=='S')
				{
					if (heroi==2){
						/*termina o jogo*/}
					else
						break;
				}
				else if (table[line-1][col]==' ')
				{
					table[line][col]=' ';
					if (heroi==2)
						table[line-1][col]='A';
					else if (heroi==1)
						table[line-1][col]='E';
				}
			}
			case('S'):
			{
				if (table[line+1][col]=='E')
				{
					table[line][col]=' ';
					if (heroi==2)
						table[line+1][col]='A';
					else if (heroi==1)
						table[line+1][col]='H';
				}
				else if (table[line+1][col]=='D')
				{
					if (heroi==2)
					{
						table[line][col]=' ';
						table[line+1][col]='A';
					}
					else if (heroi==1)
					{
						//perde o jogo
					}
				}
				else if (table[line+1][col]=='S')
				{
					if (heroi==2){
						/*termina o jogo*/}
					else
						break;
				}
				else if (table[line+1][col]==' ')
				{
					table[line][col]=' ';
					if (heroi==2)
						table[line+1][col]='A';
					else if (heroi==1)
						table[line+1][col]='E';
				}
			}
			case('E'):
			{
				if (table[line][col+1]=='E')
				{
					table[line][col+1]=' ';
					if (heroi==2)
						table[line][col+1]='A';
					else if (heroi==1)
						table[line][col+1]='H';
				}
				else if (table[line][col+1]=='D')
				{
					if (heroi==2)
					{
						table[line][col+1]=' ';
						table[line][col+1]='A';
					}
					else if (heroi==1)
					{
						//perde o jogo
					}
				}
				else if (table[line][col+1]=='S')
				{
					if (heroi==2){
						/*termina o jogo*/}
					else
						break;
				}
				else if (table[line][col+1]==' ')
				{
					table[line][col]=' ';
					if (heroi==2)
						table[line][col+1]='A';
					else if (heroi==1)
						table[line][col+1]='E';
				}
			}
			case('O'):
			{
				if (table[line][col-1]=='E')
				{
					table[line][col]=' ';
					if (heroi==2)
						table[line][col-1]='A';
					else if (heroi==1)
						table[line][col-1]='H';
				}
				else if (table[line][col-1]=='D')
				{
					if (heroi==2)
					{
						table[line][col]=' ';
						table[line][col-1]='A';
					}
					else if (heroi==1)
					{
						//perde o jogo
					}
				}
				else if (table[line][col-1]=='S')
				{
					if (heroi==2){
						/*termina o jogo*/}
					else
						break;
				}
				else if (table[line][col-1]==' ')
				{
					table[line][col-1]=' ';
					if (heroi==2)
						table[line][col-1]='A';
					else if (heroi==1)
						table[line][col-1]='E';
				}
			}
			}
		}
	}

}
