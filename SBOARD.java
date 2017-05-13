import java.util.*;
class SBOARD
{
	public int winner;
	public int runner;
	public static int no_players;
	public static POINTER square[][];
	public static NOP nop[][];
	public PLAYERs ply[];
	public SNAKE snake=new SNAKE();
	public LADDER ladder=new LADDER();
	public DICE dice=new DICE();
	//--------------------------------------------------
	public SBOARD(int n)
	{
		this.no_players=n;
		square=new POINTER[101][n+1];
		nop=new NOP[101][n+1];
		ply=new PLAYERs[n+1];
		this.winner=-1;
		this.runner=-1;
		int i=1;
		
		for(i=1;i<=100;++i)				//for remaining sqrs
		{
			for(int k=1;k<=no_players;++k)
			{
				square[i][k]=new NOP(-1,i);		//players id -1 for no pointer
				nop[i][k]=new NOP(-1,i);
			}
		}
		for(i=1;i<=no_players;++i)
		{
			ply[i]=new PLAYERs(i);
			square[1][i]=new POINTER(i,1);
		}
		
		
	}
	//----------------------------------------------------
	public void display()
	{
		int i,j,k,l,cnt=100,ct=100,cont=100,chck;
		System.out.println("\n--------------------------------------------------------------------------------------------------");
		for(i=1;i<=10;++i)
		{
			if(cnt==90)
			{
				cnt=81;
				ct=81;
				cont=81;
			}
			if(i%2!=0 && i>1)
			{
				cnt=cnt-11;
				cont=cont-11;
				ct=ct-11;
			}
			if(i%2==0 && i>2)
			{
				cnt=cnt-9;
				cont=cont-9;
				ct=ct-9;
			}
			for(k=1;k<=10;++k)				//for numbers
			{
				if(cnt==100)
				{
					System.out.printf(" %d",cnt);
				}
				else if(cnt>10 && cnt <100)
				{
					System.out.printf("  ");
					System.out.printf("%d",cnt);
				}
				else
				{
					System.out.printf("  ");
					System.out.printf("%d ",cnt);
				}
				
				if(i%2!=0 )
				{
					cnt--;
				}
				else
				{
					cnt++;
				}
				for(l=1;l<=(no_players*2)+no_players;++l)
				{
					System.out.printf(" ");
				}
			}
			System.out.println();
			for(k=1;k<=10;++k)				//for players
			{
				System.out.printf("  ");
				//System.out.printf("%d ct",ct);
				for(j=1;j<=no_players;++j)
				{
					int no=square[ct][j].get_player();
					if(no==-1)
						System.out.printf("-  ");
					else
						System.out.printf("p%d,",no);
				
				}
				if(i%2!=0 )
				{
					ct--;
				}
				else
				{
					ct++;
				}
				System.out.printf("  ");
			}
			System.out.println();
			for(k=1;k<=10;++k)		//for position of snake and ladders
			{
				int f=0;
				System.out.printf("  ");
				if(snake.is_snake_fc(cont)!=-1)
				{
					 chck=snake.is_snake_fc(cont);
					 System.out.printf("snk.%d",chck);
				}
				else if(snake.is_snake_tl(cont)!=-1)
				{
					chck=snake.is_snake_tl(cont);
					System.out.printf("snk.%d",chck);
					
				}
				else if(ladder.is_ladder_fc(cont)!=-1)
				{
					chck=ladder.is_ladder_fc(cont);
					System.out.printf("ldr.%d",chck);
				}
				else if(ladder.is_ladder_tl(cont)!=-1)
				{
					chck=ladder.is_ladder_tl(cont);
					System.out.printf("ldr.%d",chck);
				}
				else
				{
					for(l=1;l<=(no_players*2)+no_players+2;++l)
					{
						System.out.printf(" ");
					}
					f=1;
				}
				if(i%2!=0 )
				{
					cont--;
				}
				else
				{
					cont++;
				}
				if(f==0)
				{
					if(no_players>2)
					{
						for(l=1;l<=(no_players*2);++l)
						{
							System.out.printf(" ");
						}
					}
					else
					{
						for(l=1;l<=(no_players*2)-1;++l)
						{
							System.out.printf(" ");
						}
					}
				}
			}
			System.out.println("\n\n");
			//System.out.println("\n\n");
		}
		System.out.println("--------------------------------------------------------------------------------------------------");
	}
	//----end display
	//................game..................
	public void start_game()
	{
		display();
		while(winner==-1 || runner==-1)
		{
			
			int to,turn=1;
			for(int p=1;p<=no_players;++p)
			{
				Scanner scan=new Scanner(System.in);
				scan.nextLine();
				turn=1;
				while(turn==1)
				{
					if(ply[p].plyr.pos==100)
					{
						turn=0;
					}
					else
					{
						System.out.println(":: Player "+p+" ::");
						System.out.println("Press Enter to roll a dice");
						
						String s;
						scan.nextLine();
						//................
						dice.roll_dice();
						System.out.println(" you got - "+dice.dcno);
						scan.nextLine();
						if(snake.is_snake(dice.dcno+ply[p].plyr.pos)==true)
						{
							to=snake.tl_snake(dice.dcno+ply[p].plyr.pos);
							System.out.println("\nDegraded by snake");
						}
						else if(ladder.is_ladder(dice.dcno+ply[p].plyr.pos)==true)
						{
							to=ladder.in_ladder(dice.dcno+ply[p].plyr.pos);
							System.out.println("\nUpgreaded by ladder");
						}
						else
						{
							to=dice.dcno+ply[p].plyr.pos;
						}
						if(to<=100)
						{
							ply[p].plyr.move(to);
						}
						if(dice.dcno==6)
						{}
						else
						{
							turn=0;
						}
						if(to==100)
						{
							
							if(winner==-1)
							{
								winner=p;
								if(no_players==2)
									break;
							}
							else
							{
								runner=p;
								break;
							}
							turn=0;
						}
					//	System.out.println(" pl "+ply[p].plyr.pos);
						display();
					}
				}
			}
		}
	}
}