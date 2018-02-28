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
		
		var jsonUrl = '';
		
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
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg" height="50" width="50"/>';
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
		setTimeout(function(){
			$alert.fadeOut('slow');
		}, 3000);
	}
	
	
	//------------data table for admin---------------
	
var $adminProductsTable = $('#adminProductsTable')
	
	if($adminProductsTable.length){
		
		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';
		
		
		console.info("tiene productos "+jsonUrl);
		
		
		$adminProductsTable.DataTable({
			lengthMenu: [[10,30,50,-1],['10 Records','30 Records','50 Records','All']],
			pagelength:5,
			ajax:{
				url:jsonUrl,
				dataSrc: ''
			},
			
			columns:[
				
				{
					data: 'id'
				},
				{
					data:'code',
					mRender: function(data, type, row){
						return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg" height="50" width="50"/>';
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
					data:'unitPrice',
					mRender: function(data, type, row){
						return '&#8377; '+data;
					}
				},
				{
					data:'active',
					mRender: function(data, type, row){
						var str = '';
						if(data) {											
							str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
							
						}else {
							str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
						}
						
						return str;
					}
				},
				{
					data : 'id',
					bSortable : false,
					mRender : function(data, type, row) {

						var str = '';
						str += '<a href="'
								+ window.contextRoot
								+ '/manage/'
								+ data
								+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span></a> &#160;';

						return str;
					}
				}		
			],
			
			initComplete: function () {
				var api = this.api();
				api.$('.switch input[type="checkbox"]').on('change' , function() {							
					var dText = (this.checked)? 'You want to activate the Product?': 'You want to de-activate the Product?';
					var checked = this.checked;
					var checkbox = $(this);
					var value = checkbox.prop('value');
					
				    bootbox.confirm({
				    	size: 'medium',
				    	title: 'Product Activation/Deactivation',
				    	message: dText,
				    	callback: function (confirmed) {
					        if (confirmed) {
					        	
					        	var activationURL = window.contextRoot + '/manage/product/'+value+'/activation';
					        	$.post(activationURL, function(data){
					        		bootbox.alert({
						            	size:'medium',
						            	title:'Information',
						            	message: data
						            });
					        		
					        		
					        		
					        	});
					        	
					            
					        }
					        else {							        	
					        	checkbox.prop('checked', !checked);
					        }
				    	}
				    });																											
				});
					
			}			
			
		});
	}
	

//validation code for category

	var $categoryForm = $('#categoryForm');
	
	if($categoryForm.length){
		$categoryForm.validate({
			rules : {
				name :{
					required : true,
					minlength : 2
				},
				description : {
					required : true
				}
			},
			messages :{
				name : {
					required : 'Please add the category name!',
					minlength : 'The category name should not be less than 2 characters'
				},
				description : {
					required : 'Please add a description form this category!'
				}
			},
			errorElement : 'em',
			errorPlacement :function(error, element){
				//add the class for help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
				
			}
		});
	}
	
	
	
	var $loginForm = $('#loginForm');
	
	if($loginForm.length){
		$loginForm.validate({
			rules : {
				username :{
					required : true,
					email : true
				},
				password : {
					required : true
				}
			},
			messages :{
				username : {
					required : 'Please add username!',
					email : 'Please enter valid email address'
				},
				password : {
					required : 'Please add password!'
				}
			},
			errorElement : 'em',
			errorPlacement :function(error, element){
				//add the class for help-block
				error.addClass('help-block');
				//add the error element after the input element
				error.insertAfter(element);
				
			}
		});
	}
	
	
	
}
)