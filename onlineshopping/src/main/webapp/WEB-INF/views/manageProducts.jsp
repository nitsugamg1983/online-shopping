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
					<sf:form class="form-horizontal" modelAttribute="product" 
						action="${contextRoot}/manage/products" method="POST">
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Product Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control"/>
							</div>						
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Brand Name:</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control"/>
							</div>						
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:textarea path="description" class="form-control"
									placeholder="Enter your description here!" /> 
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4">Unit Price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" class="form-control"
									placeholder="Enter Unit Price" />
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
							<label class="control-label col-md-4">Select Category</label>
							<div class="col-md-8">
								<sf:select class="form-control" id="categoryId" path="categoryId" 
									items="${categories}"
									itemLabel="name"
									itemValue="id" />
							</div>
						</div>
						
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

</div>