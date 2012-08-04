package cn.easywork

/**
 * 工序
 * @author admin
 *
 */
class Process {
	
	static belongsTo = Department
	static hasMany = [departments:Department]

    static constraints = {
    }
	
	//工序名称
	String name
}
