/**
 * 
 */
package com.junaid.sample.springbootmongo.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author juansari
 *
 *POJO represents a Mongo document to be stored in Mongo DB
 */
@Document
public class MongoAppDetails {
	
	@Id
	private Long appId;
	private String appName;
	private String appDescription;
	private String appType;
	
	/**
	 * @return the appId
	 */
	public Long getAppId() {
		return appId;
	}
	/**
	 * @param appId the appId to set
	 */
	public void setAppId(Long appId) {
		this.appId = appId;
	}
	/**
	 * @return the appName
	 */
	public String getAppName() {
		return appName;
	}
	/**
	 * @param appName the appName to set
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	/**
	 * @return the appDescription
	 */
	public String getAppDescription() {
		return appDescription;
	}
	/**
	 * @param appDescription the appDescription to set
	 */
	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}
	/**
	 * @return the appType
	 */
	public String getAppType() {
		return appType;
	}
	/**
	 * @param appType the appType to set
	 */
	public void setAppType(String appType) {
		this.appType = appType;
	}
	
	@Override
	public String toString() {
		return "MongoAppDetails [appId=" + appId + ", appName=" + appName + ", appDescription=" + appDescription
				+ ", appType=" + appType + "]";
	}
	

}
