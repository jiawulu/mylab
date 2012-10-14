require "open-uri";
require 'net/smtp';

hosts = [
"sirius177108.cm3",
"sirius049107.cm4",
"sirius049090.cm4",
"sirius049072.cm4",
"sirius048132.cm4",
"sirius177185.cm3",
"sirius177179.cm3",
"sirius213193.cm3"
];

faileMache = Array.new

hosts.each do |host|
   _url = "http://" + host + ".ot.m.taobao.com/cart/confirm_order.htm?cart_id=14610703840&sid=333dc1f8f4e252e008f794a98c9c188e";
  ##puts _url;

  _success = false;
  #regex = /(?:pay-online/;
  open(_url){ |content|
    while line = content.gets

      if line.include? "wmac"
          puts "not logined  ...";
          _success = true;
          break;
      end

      if line.include? "pay-online"
          _success = true;
          break;
      end
    end
  }

   if !_success
       faileMache.push host;
       #puts host;
   end
end

puts faileMache.join(",")
=begin
if faileMache.length > 0

  msg = faileMache.join(",") + "online mache is broken,\n please check it now!!!\n\n\n sirius177108 is at debug , ignore it! "

  smtp = Net::SMTP.new 'smtp.gmail.com', 587
  smtp.enable_starttls
  smtp.start("localhost", "jiawu.lu@gmail.com", "taobao034885", :login) do
    smtp.send_message(msg, 'jiawu.lu@gmail.com', ['wuzhong@taobao.com','yefan.csh@taobao.com','qinde@taobao.com'] )
  end

else

  puts "================= noting to do ================"

end
=end


##et::SMTP.start( 'smtp.gmail.com', 587, "jiawu.lu@gmail.com", "taobao034885", :login ) do |smtp|
#  smtp.sendmail( msg,  'jiawu.lu@gmail.com', ['wuzhong@taobao.com'] )
#end