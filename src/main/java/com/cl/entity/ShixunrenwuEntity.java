package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 实训任务
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@TableName("shixunrenwu")
public class ShixunrenwuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShixunrenwuEntity() {
		
	}
	
	public ShixunrenwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 任务名称
	 */
					
	private String renwumingcheng;
	
	/**
	 * 任务图片
	 */
					
	private String renwutupian;
	
	/**
	 * 任务分类
	 */
					
	private String renwufenlei;
	
	/**
	 * 任务场景
	 */
					
	private String renwuchangjing;
	
	/**
	 * 任务难度
	 */
					
	private String renwunandu;
	
	/**
	 * 任务简介
	 */
					
	private String renwujianjie;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 任务详情
	 */
					
	private String renwuxiangqing;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：任务名称
	 */
	public void setRenwumingcheng(String renwumingcheng) {
		this.renwumingcheng = renwumingcheng;
	}
	/**
	 * 获取：任务名称
	 */
	public String getRenwumingcheng() {
		return renwumingcheng;
	}
	/**
	 * 设置：任务图片
	 */
	public void setRenwutupian(String renwutupian) {
		this.renwutupian = renwutupian;
	}
	/**
	 * 获取：任务图片
	 */
	public String getRenwutupian() {
		return renwutupian;
	}
	/**
	 * 设置：任务分类
	 */
	public void setRenwufenlei(String renwufenlei) {
		this.renwufenlei = renwufenlei;
	}
	/**
	 * 获取：任务分类
	 */
	public String getRenwufenlei() {
		return renwufenlei;
	}
	/**
	 * 设置：任务场景
	 */
	public void setRenwuchangjing(String renwuchangjing) {
		this.renwuchangjing = renwuchangjing;
	}
	/**
	 * 获取：任务场景
	 */
	public String getRenwuchangjing() {
		return renwuchangjing;
	}
	/**
	 * 设置：任务难度
	 */
	public void setRenwunandu(String renwunandu) {
		this.renwunandu = renwunandu;
	}
	/**
	 * 获取：任务难度
	 */
	public String getRenwunandu() {
		return renwunandu;
	}
	/**
	 * 设置：任务简介
	 */
	public void setRenwujianjie(String renwujianjie) {
		this.renwujianjie = renwujianjie;
	}
	/**
	 * 获取：任务简介
	 */
	public String getRenwujianjie() {
		return renwujianjie;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：任务详情
	 */
	public void setRenwuxiangqing(String renwuxiangqing) {
		this.renwuxiangqing = renwuxiangqing;
	}
	/**
	 * 获取：任务详情
	 */
	public String getRenwuxiangqing() {
		return renwuxiangqing;
	}

}
