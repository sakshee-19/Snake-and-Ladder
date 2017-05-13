import java.util.*;

class SGAME
{
	public static void main(String arg[])
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("\n\n\t----------SNAKE & LADDER----------\n");
		System.out.println("Enter no of players...");
		int n=scan.nextInt();
		SBOARD obj=new SBOARD(n);
		obj.start_game();
		System.out.println("\nRESULT::\n\tWINNER:- "+obj.winner+"\n\tRUNNER:-"+obj.runner);
	}
}