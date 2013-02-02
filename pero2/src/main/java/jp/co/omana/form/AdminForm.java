package jp.co.omana.form;

import org.seasar.struts.annotation.IntegerType;

public class AdminForm {


	public String userName="";

	public String password="";

	@IntegerType
	public String catId="";

	public String roles="";

	public String page="";


	public String sid ="";
	public String snum ="";

	public String mid ="";


	public String stitle ="";

	public String spic ="";

	@IntegerType
	public String stime ="";

	public String sdate ="";

	@IntegerType
	public String sdeadFlg ="";

	@IntegerType
	public String compFlg ="";

	@IntegerType
	public String totalPlay ="";


}
