<%@ include file="header.jsp" %>

<div class="container">    
  <div class="row">
  
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"> Cart Check Out </div>
        <table cellpadding="3" cellspacing="3" border="2">
          <tr>
          	<th>Id</th>
          	<th>Product</th>
          	<th>Price</th>
          	<th>Quantity</th>
          	<th>Total Amount</th>
          	<th>After Promotion Total Amount</th>
          </tr>
          <c:set var="s" value="0"></c:set>
          <c:forEach items="${sessionScope.cart}" var="cartitem">
          		<c:set var="s" value="${s+cartitem.promotionPrice}"></c:set>
             <tr>
                <td> ${cartitem.product.id}</td>
                <td> ${cartitem.product.name}</td>
                <td> ${cartitem.product.price}</td>
                <td> ${cartitem.quantity}</td>
                <td> ${cartitem.product.price * cartitem.quantity}</td> 
                 <td> ${cartitem.promotionPrice}</td>
                
             </tr>
          </c:forEach>
         <tr>
          <td colspan="5" align="right">Total Pay</td>
          <td>${s }</td>
          </tr> 
        </table>
        
        <%-- <div class="panel-heading"> ${product.name} </div>
        <div class="panel-body">
        <p>Price : ${product.price}  </p> 
        </div> --%>
        <div class="panel-footer"> <button type="button" class="btn btn-primary btn-md"
           onClick="location.href='/products/all'">Continue Shopping</button>
           <button type="button" class="btn btn-primary btn-ed"
           onClick="location.href='/products/all'">Check Out</button>
           </div> 
      </div>
    </div>
   
  </div>
</div><br>

</body>
</html>
