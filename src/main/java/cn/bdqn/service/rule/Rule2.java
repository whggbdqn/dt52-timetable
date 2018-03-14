package cn.bdqn.service.rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.bdqn.pojo.Classes;

public class Rule2 {

	public Classes[] check(List<Classes> allClass){
		Random random = new Random();
		List<Classes> nulclazz=null;
		Integer[] nulrom={0,5,6};
		Classes[] clazz=new Classes[56];
		 
		int n=0;
		int m=0;
		 List<Classes> list = new ArrayList<Classes>();
			for (Classes classes : allClass) {
				if(classes.getStuNum()>30){
					list.add(classes);
				}
			}
		for(int i = 0; i < 4; i++) {
			int ran = random.nextInt(nulrom.length);
			if(ran==0){
				n=1;m=2;
			}else{
			if(ran==1){
				n=2;m=0;
			}else{
				n=0;m=1;
			}
			}
			System.out.println(ran+"-"+n+"-"+m);
			clazz[(nulrom[ran]+(i*8))]=list.get(0);
			clazz[(nulrom[n]+(i*8))]=list.get(1);
			clazz[(nulrom[m]+(i*8))]=list.get(2);
		}
		
//		for (Classes classes : clazz) {
//			System.out.println(classes);
//		}
		return clazz;
	}
}
