require "open-uri";
require 'net/smtp';

hosts = [
"sirius213193.cm3"
];

faileMache = Array.new

hosts.each do |host|
   _url = "http://" + host + ".ot.m.taobao.com/cart/confirm_order.htm";
  ##puts _url;

  _success = false;
  open(_url){ |content|
    while line = content.gets
      puts line
    end
  }

   if !_success
       faileMache.push host;
       #puts host;
   end
end
