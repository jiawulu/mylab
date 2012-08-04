package cn.easywork

class User {

	static belongsTo = [company:Company,department:Department,leader:User]
   
	static constraints = {
    }
	
	String name
	String password
	User leader
		
}
