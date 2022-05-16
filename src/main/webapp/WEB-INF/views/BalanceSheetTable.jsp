<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row" style="display: block;">
              <div class="col-md-6 col-sm-6  ">
                <div class="x_panel">
                  <div class="x_content">

                    <table class="table"<h>Payments Table</h>
                      <thead>
                        <c:forEach items="${paymentsList }" var="pay">
                       <tr>
                       	<td>${pay.cat }</td>
                       	<td>${pay.totalPaymt }</td>
                       </tr>
                       </c:forEach>
                        <tr>
                          <th><h3><small>Closing Balance</small></h3></th>
                          <td><h3><small><span id="closingBalance"></span></small></h3></td>
                        </tr>
                         <tr>
                          <th><h3><small>Tally</small></h1></th>
                          <td><h3><small><span id="tallyPayments"></span></small></h3></td>
                        </tr>
                      </thead>
                      <tbody></tbody>
                    </table>

                  </div>
                </div>
              </div>
              <div class="col-md-6 col-sm-6  ">
                <div class="x_panel">
                  <div class="x_content">
                    <table class="table table-striped"<h>Receipts Table</h>
                      <thead>
                        <c:forEach items="${ReceiptsList }" var="pay">
                        <tr>
                        <td>${pay.cat }</td>
                       	<td>${pay.totalRecp }</td>
                        </tr>
                         </c:forEach>
                         <tr>
                        <th><h3><small>Opening Balance</small></th>
                        <td><h3><small>${openingBalance}</small></h3></td>
                        </tr>
                        <tr>
                        <th><h3><small>Tally</small></h3></th>
                        <td><h3><small><span id="tallyReceipts"></span></small></h3></td>
                        </tr>
                      </thead>
                      <tbody></tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
            
 