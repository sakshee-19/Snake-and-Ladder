class LADDER
{
	public int no_lad;			//to see no of ladders in board	
	public int lad_init[]=new int[5];
	public int lad_fin[]=new int[5];
	//-----------constructing ladder
	public LADDER()
	{
		this.no_lad=5;
		this.lad_init[0]=9;
		this.lad_init[1]=18;
		this.lad_init[2]=36;
		this.lad_init[3]=61;
		this.lad_init[4]=71;
		this.lad_fin[0]=55;
		this.lad_fin[1]=25;
		this.lad_fin[2]=64;
		this.lad_fin[3]=98;
		this.lad_fin[4]=92;			
	}
	//-------------
	public int in_ladder(int n)	//to check if there is ladder or not and return final position if ladder is there
	{
		int i=0;
		for(i=0;i<no_lad;++i)
		{
			if(n==lad_init[i])
				return lad_fin[i];
		}
		return -1;
	}
	public boolean is_ladder(int n)		//to check if there is ladder or not
	{
		int i=0;
		for(i=0;i<no_lad;++i)
		{
			if(n==lad_init[i])
				return true;
		}
		return false;
	}
	public int is_ladder_fc(int n)		//to check if there is ladder initial or not
	{
		int i=0;
		for(i=0;i<no_lad;++i)
		{
			if(n==lad_init[i])
				return i;
		}
		return -1;
		
	}
	public int is_ladder_tl(int n)		//to check if there is ladder final or not
	{
		int i=0;
		for(i=0;i<no_lad;++i)
		{
			if(n==lad_fin[i])
				return i;
		}
		return -1;
		
	}
}