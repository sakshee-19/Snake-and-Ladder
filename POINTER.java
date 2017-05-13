class POINTER
{
	public int pos;
	public int p;
	public POINTER(int n,int po)
	{
		pos=po;
		p=n;
	}
	POINTER()
	{
		
	}
	public int get_player()
	{
		return p;
	}
	public void move(int n)
	{
		SBOARD.square[n][p]=SBOARD.square[pos][p];
		SBOARD.square[pos][p]=SBOARD.nop[pos][p];
		this.pos=n;
		
	}
	
}