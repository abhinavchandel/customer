<html>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<style>
h3 {
	text-align: center;
}
.formwrap {
    width: 600px;
    margin: auto;
    border: 1px solid #ccc;
    border-radius: 10px;
    padding: 0 20px 0;
    background: #fff9db;
}
.input {
	display: block;
    width: 100%;
    margin-top: 15px;
    font-size: 16px;
    padding: 5px;
}
.btn {
    padding: 10px;
    width: 200px;
    background: #2196f3;
    color: #fff;
    font-weight: bold;
    border: 0;
    margin: 15px auto 20px auto;
    display: block;
    text-align: center;
    text-decoration: none;
    cursor: pointer;
}
table {
    width: 100%;
    margin: auto;
}
</style>
<div class="formwrap">
<h3>Add Product</h3>
<div class="productclass">
Product Name : <input type="text" id="pr_name"> <input type="button" id="btn" class="btn" value="Search">
</div>
<br>
<br>
<table border="1" id="tab1">

	<thead>
		<tr>
		<th>Product Id</th>
		<th>Product Name</th>
		<th>Product Price</th>
	</tr>

	</thead>
	<tbody>
		
	</tbody>
</table>

</div>
<script type="text/javascript">

$(document).ready(function() {


		$("#btn").click(function(){
			var value=$("#pr_name").val();
			
			$.ajax({ 
    type: 'GET', 
    url: 'getprod_name/'+value, 
     
    success: function (data) { 
       console.log(data);
    $("#tab1 tbody").empty();

   // var jsondata=JSON.parse(data);
       //console.log(jsondata);
       for(i in data){
       	console.log(data[i]);


 $("#tab1 tbody").append(
   '<tr>'
   +'<td>'+data[i].product_id+'</td>'
   +'<td>'+data[i].product_name+'</td>'
   
   +'<td>'+data[i].product_price+'</td>'
   
   
   

   +'</tr>'

	);
     
}//

    }
    });
		
	});
		
});	
</script>
</body>
</html>