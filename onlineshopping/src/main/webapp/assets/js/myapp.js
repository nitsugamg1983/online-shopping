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
		console.info("tiene productos");
		
		$table.DataTable({
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All']],
			pagelength:5,
			data:products
		});
	}
	
}
)