package jp.co.omana.action;

import java.util.ArrayList;
import java.util.List;

import org.seasar.framework.util.IntegerConversionUtil;

public abstract class Paging {


	/**
	 * (page * LIMIT < total)であればtrue
	 * @author ikraikra
	 * @param page
	 * @param LIMIT
	 * @param total
	 * @return
	 */
	public boolean hasNextPage(int page, int LIMIT, long total) {
		boolean hasNext =false;


		if ((page) * LIMIT < total){
			hasNext = true;
		}
		return hasNext;
	}

	/**
	 * (page * LIMIT < total)であればtrue
	 * @author iKra
	 * @param page
	 * @param LIMIT
	 * @param total
	 * @return
	 */
	public boolean hasPrevPage(int page, int LIMIT, long total) {
		boolean hasPrev =false;
		if (page > 1 ){
			hasPrev = true;
		}
		return hasPrev;
	}



	public List<Integer> paging(int page, int LIMIT, long total){

		int maxPage = 1 + IntegerConversionUtil.toPrimitiveInt(total)/LIMIT;
		List<Integer> pagings = new ArrayList<Integer>();

		for (int i=0;pagings.size()<15;i++) {
			//最大ページ以下の場合
			if (maxPage >= (i + page -7) && (i + page -7)>0){
				pagings.add(i + page -7);

				//最大値に達した場合
				if (maxPage == (i + page -7)){
					break;
				}
			}
		}
		return pagings;
	}
}
