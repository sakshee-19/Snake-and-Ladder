import java.util.*;

class DICE
{
	public int dcno;
	DICE()
	{
	
	}
	public void roll_dice()
	{
		Random rand = new Random();
		dcno=rand.nextInt(6)+1;
	}
}