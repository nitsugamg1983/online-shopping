$(function(){
	//solving the active menu
	switch(menu){
		case 'About us':
			$('#about').addClass('active');
			break;
		case 'Contact us':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			break;
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break;
		case 'Home':
			$('#home').addClass('active');
			break;
		default:
			$('#listProducts').addClass('active');
			$('#a_'+menu).addClass('active');
			break;
			
	}
	
	
	//code for jequery table
	//create a dataset
	
	var products  = [
			['1','ABC1'],
			['2','ABC2'],
			['3','ABC3'],
			['4','ABC4'],
			['5','ABC5'],
			['6','ABC6'],
			['7','ABC7'],
			['8','ABC8'],
			['9','ABC9'],
			['10','ABC10']
		
		
	];
	
	var $table = $('#productListTable')
	
	if($table.length){
		
		var jasonUrl = '';
		
		console.info("tiene productos "+window.categoryId);
		
		if(window.categoryId == ''){
			jsonUrl = window.contextRoot + '/json/data/all/products'
		}else{
			jsonUrl = window.contextRoot + '/json/data/category/'+window.categoryId+'/products'
		}
		
		
		
		console.info("tiene productos "+jsonUrl);
		
//		$table.DataTable({
//			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
//			pagelength:5,
//			data:products
//		});
		
		$table.DataTable({
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
			pagelength:5,
			ajax:{
				url:jsonUrl,
				dataSrc: ''
			},
			
			columns:[
				{
					data:'code',
					mRender: function(data, type, row){
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
						//return data;
					}
				},
				{
					data:'name'
				},
				{
					data:'brand'
				},
				{
					data:'unitPrice',
					mRender: function(data, type, row){
						return '&#8377; '+data;
					}
				},
				{
					data:'quantity',
					mRender: function(data, type, row){
						console.info("data "+data);
						if(data < 1){
							return '<span style="color:red">Out of stock!</span>';
						}
						return data;
					}
				},
				{
					data:'id',
					bSortable : false,
					mRender:function(data, type, row){
						var str='';
						
						console.info(row.quantity);
						str += '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> ';
						if(row.quantity < 1){	
							str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a> '
						}else{
							str += '<a href="'+window.contextRoot+'/cart/add/'+data+'/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a> '
						}			
						
						return str;
					}
				}
			]
		});
	}
	
	
	//dismissing the alert alter 3 seconds
	var $alert =$('.alert');
	
	if($alert.length){
		setTimeOut(function(){
			$alert.fadeOut('slow');
		}, 3000);
	}
	
}
)