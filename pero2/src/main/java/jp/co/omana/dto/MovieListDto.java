package jp.co.omana.dto;


import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class MovieListDto implements Serializable {

	private static final long serialVersionUID = 1L;

	public int catId;
	public int sid;
}
