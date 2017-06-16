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
			System.out.println("���ӵ㣺"+"("+ks.x+","+ks.y+")"
							+"���ͣ�"+ks.type);
			for(kMeansData kd:kData)
			{	
				if(kd.type==ks.type)
				{
					System.out.println("��Ⱥ��"+"("+kd.x+","+kd.y+")"
							+"���ͣ�"+kd.type);
				}
			}		
		}
	}
	
	//1��ȡk��������ӵ�
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
	
	//2���������е㵽���ӵ�ľ��룬ѡ����ÿ������������ӵ㣬�������ӵ�����͸���õ�
	public static void calculate(List<kMeansData> kList,List<kMeansData> kData)
	{
		//�������еĵ�����ӵ㣬�������߾���
		for(kMeansData kd:kData)
		{
			for(kMeansData ks:kList)
			{
				ks.distance=disCal(kd,ks);
			}	
			//��kList���а������С��������ȡ���������KΪkd��type
			Collections.sort(kList);
			kd.type=kList.get(0).type;
		}
	}
	
	public static double disCal(kMeansData kd,kMeansData ks)
	{
		return Math.sqrt((kd.x-ks.x)*(kd.x-ks.x)
				+(kd.y-ks.y)*(kd.y-ks.y));	
	}
	
	//3�������ӵ��ƶ�����Ⱥ����λ��,�������ӵ��Ƿ��ƶ�
	public static boolean move(int k,List<kMeansData> kList,List<kMeansData> kData)
	{
		double sumx=0;
		double sumy=0;
		int t=1;
		double beforex,beforey;
		int m=0;
		//�������еĵ�����ӵ㣬�������߾���
		for(kMeansData ks:kList)
		{
			beforex=ks.x;
			beforey=ks.y;
			for(kMeansData kd:kData)
			{
				//�ҳ����ӵ�ks�ĵ�Ⱥ
				if(kd.type==ks.type)
				{
					sumx+=kd.x;
					sumy+=kd.y;
					++t;
				}						
			}
			//�ƶ����ӵ㵽��Ⱥ����λ��
			ks.x=sumx/t;
			ks.y=sumy/t;
			System.out.println("x:"+ks.x+" y:"+ks.y);
			t=1;
			if(beforex==ks.x&&beforey==ks.y)
			{
				m++;
			}
		}
		//������е����ӵ㶼û���ƶ����򷵻�false
		if(m==k)
		{
			return false;
		}
		return true;
	}
}
