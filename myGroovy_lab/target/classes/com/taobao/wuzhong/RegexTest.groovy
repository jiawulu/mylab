def regex = /hello/
println("hello world" ==~ regex)
println("hello world" ==~ /^h.*d$/)

def str = '13640901345'
def re = /13[0-9]{9}/
println str ==~ re
println str =~ re