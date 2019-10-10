<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Worker List</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>
<div class="container-fluid" style="padding-left: 100px; padding-right: 100px " >
<h3>Worker List</h3>
<br>
<div>

    <table class="table table-sm table-striped table-bordered table-dark">
        <tr class="bg-success">

            <th> ID </th>
            <th>Name</th>
            <th>Occupation</th>
            <th>Salary</th>
            <th>Speciality</th>
            <th>Date</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>

        <#list workers as worker>
            <tr>
                <td>${worker.id}</td>
                <td>${worker.name}</td>
                <td>${worker.occupation}</td>
                <td>${worker.salary}</td>
                <td>${worker.speciality.name}</td>
                <td>${worker.employmentDay}</td>
                <td><a href="/worker/delete/${worker.id}" type="Button" class="btn btn-danger" >Delete</a></td>
                <td><a href="/worker/update/${worker.id}" type="Button" class="btn btn-primary" >Update</a></td>
            </tr>
        </#list>

    </table>

</div>

<a href="/worker/create" type="Button" class="btn btn-info">Add new worker</a>

</div>
</body>
</html>