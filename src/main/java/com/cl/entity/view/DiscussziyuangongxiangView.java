package com.cl.entity.view;

import com.cl.entity.DiscussziyuangongxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 资源共享评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@TableName("discussziyuangongxiang")
public class DiscussziyuangongxiangView  extends DiscussziyuangongxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussziyuangongxiangView(){
	}
 
 	public DiscussziyuangongxiangView(DiscussziyuangongxiangEntity discussziyuangongxiangEntity){
 	try {
			BeanUtils.copyProperties(this, discussziyuangongxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
