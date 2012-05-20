package com.shrikar.analytics;

import java.util.BitSet;
import com.shrikar.util.MurmurHash;

/* For more on Linear counting check :
 * http://dblab.kaist.ac.kr/Publication/pdf/ACM90_TODS_v15n2.pdf
 * Linear Time Probabilistic counting algorithm for Database Application
 * by Whang, Vander-Zanden, Taylor
 */
public class LinearCounting {

	BitSet bitmap = null;
	
	/* Size of the map in bits */
	private int size ;

	/* Number of bits unset in the map */
	private int count;
	
	public LinearCounting(int size){
		bitmap = new BitSet(size);
		this.size = size;
	}
	
	public void addKey(Object obj){
		long index = MurmurHash.hash(obj.toString().getBytes());
		index = ( index & ( 0xFFFFFFFFL)) % size;
		bitmap.set((int) index);
		
	}
	
	public int cardinality(){
		double Vn = (double)getCount()/size;
		return (int) (-size * Math.log(Vn));
	}
	
	/* Return bits which are not set */
	private int getCount(){
		/* bitmap.cardinality returns the number of bits set */
		count = size - bitmap.cardinality();
		return count;
	}
}
