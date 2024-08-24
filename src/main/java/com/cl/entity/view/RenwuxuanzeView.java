package com.cl.entity.view;

import com.cl.entity.RenwuxuanzeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 任务选择
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@TableName("renwuxuanze")
public class RenwuxuanzeView  extends RenwuxuanzeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RenwuxuanzeView(){
	}
 
 	public RenwuxuanzeView(RenwuxuanzeEntity renwuxuanzeEntity){
 	try {
			BeanUtils.copyProperties(this, renwuxuanzeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
