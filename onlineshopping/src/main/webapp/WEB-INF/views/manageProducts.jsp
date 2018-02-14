<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"   %>


<div class="container">

	<div class="row">
		
		<c:if test="${not empty message }">
		
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${message}
				</div>
			
			</div>
		</c:if>
		
		
		
	
		<div class="col-md-offset-2 col-md-8">
			
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Product Management</h4>
				</div>
				
				<div class="panel-body">
					<!-- Form Elements -->
					<sf:form class="form-horizontal" 
						modelAttribute="product" 
						action="${contextRoot}/manage/products" 
						method="POST" 
						enctype="multipart/form-data">
						
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control"/>
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>						
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control"/>
								<sf:errors path="brand" cssClass="help-block" element="em"/>
							</div>						
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter your description here!" />
								<sf:errors path="description" cssClass="help-block" element="em"/> 
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" class="form-control"
									placeholder="Enter Unit Price" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em"/>
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Quantity</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" class="form-control"
									placeholder="Enter Quantity" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Select Image</label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control"/>
								<sf:errors path="file" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Select Category</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId" 
									items="${categories}"
									itemLabel="name"
									itemValue="id" />
							</div>
						</div>
						<c:if test="${product.id == 0}">
							<div class="text-right">
								<br>
								<button type="button" data-toggle="modal" data-target="#myCategoryModal"
							 		class="btn btn-warning btn-xs">Add Category</button>
							</div>							
						</c:if>
						
						
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
								<sf:hidden path="id"/>
								<sf:hidden path="code"/>
								<sf:hidden path="supplierId"/>
								<sf:hidden path="purchases"/>
								<sf:hidden path="active"/>	
								<sf:hidden path="views"/>
							</div>						
						</div>
					</sf:form>
					
				</div>
			
			</div>
		</div>
	
	</div>
	
	
	
	<hr/>	
	<h1>Available Products</h1>
	<hr/>
	
	<div class="row">
				
		
		<div class='col-xs-12'>
		
		
			<table id="adminProductsTable" class="table table-condensed table-bordered">
							
				<thead>					
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>					
				</thead>
				
				<tfoot>
					<tr>					
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Brand</th>
						<th>Qty. Avail</th>
						<th>Unit Price</th>
						<th>Activate</th>				
						<th>Edit</th>
					</tr>									
				</tfoot>
				
							
			</table>
		
		
		</div>
	
	
	</div>

	<div class="row"> 
		<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Add New Category</h4>
					</div>
					<div class="modal-body">
						<!-- category form -->
						<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category"
							method="POST" class="form-horizontal">
							<div class="form-group">
								<label for="category_name" class="control-label col-md-4">Category Name</label>
								<div class="col-md-8">
									
									<sf:input type="text" path="name" class="form-control" id="category_name"/>
								</div>
							</div>
							<div class="form-group">
								<label for="category_description" class="control-label col-md-4">Category Description</label>
								<div class="col-md-8">
									
									<sf:textarea cols="" rows="5"
										path="description" class="form-control" id="category_description"/>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<input type="submit" value="Add Category" class="btn btn-primary"/> 
								</div>
							</div>
						</sf:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>