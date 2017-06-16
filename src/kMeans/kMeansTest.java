package kMeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class kMeansTest {
	static int k=0;
	public static void main(String[] args)
	{
		List<kMeansData> kData = new ArrayList<kMeansData>();
		kData.add(new kMeansData(0, 0, 0));
		kData.add(new kMeansData(76, 82, 0));
		kData.add(new kMeansData(15, 15, 0));
		kData.add(new kMeansData(2, 3, 0));
		kData.add(new kMeansData(96, 97, 0));
		kData.add(new kMeansData(5, 12, 0));
		kData.add(new kMeansData(20, 18, 0));
		kData.add(new kMeansData(18, 20, 0));
		kData.add(new kMeansData(82, 85, 0));
		kData.add(new kMeansData(16, 8, 0));
		Scanner scanner=new Scanner(System.in);
		System.out.println("ÇëÊäÈëKµÄÖµ£º");
		k=scanner.nextInt();
		kMeans.cluster(k,kData);
	}
}
