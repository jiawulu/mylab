package cn.easywork

class Department {

	static hasMany = [processes:Process]
	static belongsTo = [company:Company]
	
   static constraints = {
    }
	
	String name
}
