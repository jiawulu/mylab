<html>
<head>
  <meta name="layout" content="ext"/>
  <link rel="stylesheet" href="${resource(dir:'css', file: 'main_ext.css')}" />
  <script type="text/javascript" src="${resource(dir:'js', file: 'default.js')}"></script>
</head>
<body>
	 <div id="north" class="x-hide-display">
        <p>LOGO here</p>
    </div>

    <!-- use class="x-hide-display" to prevent a brief flicker of the content -->
    <div id="west" class="x-hide-display">
         <ul>
         	<li><a href="javascript:createTab()"  class="menubar" >等待我处理的</a></li>
         	<li><a href="javascript:createTab()"  class="menubar" >我发起的</a></li>
         	<li><a href="javascript:createTab()"  class="menubar" >我处理过的</a></li>
         </ul>
    </div>
    
    <div id="tableManager" class="x-hide-display">
         <ul>
         	<li><a href="javascript:opentable('company')"  class="menubar" >公司表</a></li>
         	<li><a href="javascript:opentable('department')"  class="menubar" >部门表</a></li>
         	<li><a href="javascript:opentable('user')"  class="menubar" >用户表</a></li>
         	<li><a href="javascript:opentable('process')"  class="menubar" >工序表</a></li>
         	<li><a href="javascript:opentable('material')"  class="menubar" >材料表</a></li>
         </ul>
    </div>
    
    <div id="cpxx_accord" class="x-hide-display">
         <ul>
         	<li><a href="javascript:opentable('cpxxk','产品信息')"  class="menubar" >产品信息库</a></li>
         </ul>
    </div>

    <div id="about" class="x-hide-display">
        <h2>about info here</h2>
    </div>
    
    <div id="south" class="x-hide-display">
        <p>company@copyright</p>
    </div>
    
</body>
</html>