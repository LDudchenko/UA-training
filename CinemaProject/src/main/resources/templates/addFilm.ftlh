<#import "parts/common.ftlh" as c>
<#import "/spring.ftl" as spring>

<@c.page>
<div class="row">
    <div class="col-md-3"></div>
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default" style="margin-top:45px">
                <div class="panel-heading">
                    <h3 class="panel-title"><@spring.message "film.adding"/></h3>
                </div>
                <div class="panel-body">
                    <form action="/films/add" enctype="multipart/form-data" method="post">
                        <div class="form-group mb-2">
                            <label for="name"><@spring.message "name.ua"/></label>
                            <input type="text"  class="form-control" name="name" required>
                        </div>
                        <div class="form-group mb-2">
                            <label for="name_en"><@spring.message "name.en"/></label>
                            <input type="text" class="form-control" name="name_en" required>
                        </div>
                        <div class="form-group mb-2">
                            <label for="duration"><@spring.message "duration"/></label>
                            <input type="text" class="form-control" name="duration" required>
                        </div>
                        <div class="form-group mb-2">
                            <label for="description"><@spring.message "description.ua"/></label>
                            <textarea name="description" class="form-control" rows="4" cols="50" required>
                            </textarea>
                        </div>
                        <div class="form-group mb-2">
                            <label for="description_en"><@spring.message "description.en"/></label>
                            <textarea name="description_en" class="form-control" rows="4" cols="50" required>
                            </textarea>
                        </div>
                        <input type="hidden" value="${_csrf.token}" name="_csrf">
                        <button type="submit" class="btn btn-primary"><@spring.message "save"/></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@c.page>