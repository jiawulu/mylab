require 'java'

include_class 'com.taobao.wuzhong.spring.Hello'

class JrubyHello

	def sayHello(name)
		p name  + ".............."
		true
	end

end