package jp.co.omana.form;

import org.seasar.struts.annotation.IntegerType;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;

public class IndexForm {

	@IntegerType
	@Minlength(minlength = 1)
	@Maxlength(maxlength = 2)
	public String catId="";

	@IntegerType
	@Maxlength(maxlength = 1000)
	public String page="";

	@IntegerType
	public String sid ="";


}
