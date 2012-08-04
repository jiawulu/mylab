package cn.easywork

class Company {

   static belongsTo = [ftc:Company]
	static constraints = {
    }
	
	String name
	//foreign trade company
	Company ftc
}
