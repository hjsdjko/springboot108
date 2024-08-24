package com.cl.entity.view;

import com.cl.entity.ShixunrenwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 实训任务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@TableName("shixunrenwu")
public class ShixunrenwuView  extends ShixunrenwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShixunrenwuView(){
	}
 
 	public ShixunrenwuView(ShixunrenwuEntity shixunrenwuEntity){
 	try {
			BeanUtils.copyProperties(this, shixunrenwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
