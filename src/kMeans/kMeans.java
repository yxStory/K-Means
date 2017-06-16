package kMeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class kMeans {

	public List<kMeansData> list=null;
	public kMeans(List<kMeansData> list)
	{
		this.list=list;
	}
	
	public static void cluster(int k,List<kMeansData> kData)
	{
		List<kMeansData> kList=random(k);
		for(kMeansData kss:kList)
		{
				System.out.println("x:"+kss.x+"y:"+kss.y+"type:"+kss.type);
		}
		while(true)
		{
			calculate(kList,kData);
			boolean ll;
			ll=move(k,kList,kData);
			if(ll==false)
			{
				break;
			}			
		}	
		for(kMeansData ks:kList)
		{
			System.out.println("种子点："+"("+ks.x+","+ks.y+")"
							+"类型："+ks.type);
			for(kMeansData kd:kData)
			{	
				if(kd.type==ks.type)
				{
					System.out.println("点群："+"("+kd.x+","+kd.y+")"
							+"类型："+kd.type);
				}
			}		
		}
	}
	
	//1、取k个随机种子点
	public static List<kMeansData> random(int k)
	{
		List<kMeansData> kList1 = new ArrayList<kMeansData>();
		for(int i=0;i<k;i++)
		{
			//Random random=new Random();
			//int randomx=random.nextInt(100);
			//int randomy=random.nextInt(100);
			double randomx=Math.random()*100%100;
			double randomy=Math.random()*100%100;	
			kList1.add(new kMeansData(randomx,randomy,i));
		}
		return kList1;	
	}
	
	//2、计算所有点到种子点的距离，选出离每个点最近的种子点，将该种子点的类型赋予该点
	public static void calculate(List<kMeansData> kList,List<kMeansData> kData)
	{
		//遍历所有的点和种子点，计算两者距离
		for(kMeansData kd:kData)
		{
			for(kMeansData ks:kList)
			{
				ks.distance=disCal(kd,ks);
			}	
			//将kList进行按距离从小到大排序，取距离最近的K为kd的type
			Collections.sort(kList);
			kd.type=kList.get(0).type;
		}
	}
	
	public static double disCal(kMeansData kd,kMeansData ks)
	{
		return Math.sqrt((kd.x-ks.x)*(kd.x-ks.x)
				+(kd.y-ks.y)*(kd.y-ks.y));	
	}
	
	//3、将种子点移动到点群中心位置,返回种子点是否移动
	public static boolean move(int k,List<kMeansData> kList,List<kMeansData> kData)
	{
		double sumx=0;
		double sumy=0;
		int t=1;
		double beforex,beforey;
		int m=0;
		//遍历所有的点和种子点，计算两者距离
		for(kMeansData ks:kList)
		{
			beforex=ks.x;
			beforey=ks.y;
			for(kMeansData kd:kData)
			{
				//找出种子点ks的点群
				if(kd.type==ks.type)
				{
					sumx+=kd.x;
					sumy+=kd.y;
					++t;
				}						
			}
			//移动种子点到点群中心位置
			ks.x=sumx/t;
			ks.y=sumy/t;
			System.out.println("x:"+ks.x+" y:"+ks.y);
			t=1;
			if(beforex==ks.x&&beforey==ks.y)
			{
				m++;
			}
		}
		//如果所有的种子点都没有移动，则返回false
		if(m==k)
		{
			return false;
		}
		return true;
	}
}
