//±Õ°ü
def clos = {param -> println "hello  $param"}

clos.call("world")
//¿ÉÊ¡ÂÔcall
clos("world")

def clos2 = {println "hello ${it}"}
clos2.call("aaa")