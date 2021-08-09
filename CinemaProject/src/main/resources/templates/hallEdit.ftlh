<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
<div class="row">
    <div class="col-md-3"></div>
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title"><@spring.message "hall.editor"/></h3>
                </div>
                <div class="panel-body">
                    <form action="/halls" method="post">
                        <div class="form-group mb-2">
                            <label for="name"><@spring.message "name"/></label>
                            <input type="text" class="form-control" name="name" value="${hall.name}">
                        </div>
                        <div class="form-group mb-2">
                            <label for="numOfRows"><@spring.message "numOfRows"/></label>
                            <input type="text" class="form-control" name="numOfRows" value="${hall.numOfRows}">
                        </div>
                        <div class="form-group mb-2">
                            <label for="numOfSeatsAtRow"><@spring.message "numOfSeatsAtRow"/></label>
                            <input type="text" class="form-control" name="numOfSeatsAtRow" value="${hall.numOfSeatsAtRow}">
                        </div>
                        <input type="hidden" value="${hall.id}" name="hallId">
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn btn-primary"><@spring.message "save"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<a href="/halls/delete/${hall.id}" class="btn-ref red"><@spring.message "delete"/></a>
</@c.page>