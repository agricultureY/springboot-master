package com.ycn.springboot.database.mybatis;

public class DbContextHolder {

	public enum DbType {
		/**主从分配*/
		MASTER,SLAVE
	}
	
	private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<>();
	
	public static void setDbType(DbType dbType) {
		if(null == dbType)
			throw new NullPointerException();
		contextHolder.set(dbType);
	}
	
	public static DbType getDbType() {
		return contextHolder.get() == null?DbType.MASTER:contextHolder.get();
	}
	
	public static void clearDbType() {
		contextHolder.remove();
	}
	
}
