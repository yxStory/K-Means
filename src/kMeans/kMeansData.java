package kMeans;

public class kMeansData implements Comparable<kMeansData>{
	double x,y;
	int type;
	double distance;
	
	public kMeansData(double x,double y,int type)
	{
		this.x=x;
		this.y=y;
		this.type=type;
	}

	public int compareTo(kMeansData arg0) {
		// TODO Auto-generated method stub
		return Double.valueOf(this.distance)
				.compareTo(Double.valueOf(arg0.distance));
	}
}
