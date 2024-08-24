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
 * 成绩反馈
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@TableName("chengjifankui")
public class ChengjifankuiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChengjifankuiEntity() {
		
	}
	
	public ChengjifankuiEntity(T t) {
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
	 * 申请日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shenqingriqi;
	
	/**
	 * 申请说明
	 */
					
	private String shenqingshuoming;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 任务成绩
	 */
					
	private String renwuchengji;
	
	/**
	 * 任务反馈
	 */
					
	private String renwufankui;
	
	
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
	 * 设置：申请日期
	 */
	public void setShenqingriqi(Date shenqingriqi) {
		this.shenqingriqi = shenqingriqi;
	}
	/**
	 * 获取：申请日期
	 */
	public Date getShenqingriqi() {
		return shenqingriqi;
	}
	/**
	 * 设置：申请说明
	 */
	public void setShenqingshuoming(String shenqingshuoming) {
		this.shenqingshuoming = shenqingshuoming;
	}
	/**
	 * 获取：申请说明
	 */
	public String getShenqingshuoming() {
		return shenqingshuoming;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：任务成绩
	 */
	public void setRenwuchengji(String renwuchengji) {
		this.renwuchengji = renwuchengji;
	}
	/**
	 * 获取：任务成绩
	 */
	public String getRenwuchengji() {
		return renwuchengji;
	}
	/**
	 * 设置：任务反馈
	 */
	public void setRenwufankui(String renwufankui) {
		this.renwufankui = renwufankui;
	}
	/**
	 * 获取：任务反馈
	 */
	public String getRenwufankui() {
		return renwufankui;
	}

}
