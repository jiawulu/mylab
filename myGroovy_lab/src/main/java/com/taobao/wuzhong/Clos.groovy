//�հ�
def clos = {param -> println "hello  $param"}

clos.call("world")
//��ʡ��call
clos("world")

def clos2 = {println "hello ${it}"}
clos2.call("aaa")