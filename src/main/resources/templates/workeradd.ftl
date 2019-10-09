
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Create Worker</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div class="container-fluid" style="padding-left: 100px; padding-right: 100px " >
    <fieldset>
        <legend>Add worker</legend>
        <form name="worker" action="" method="POST">
            First name:<@spring.formInput "WorkerForm.name" "class='form-control'" "text"/>
            <br>Occupation:<@spring.formInput "WorkerForm.occupation" "class='form-control'" "text"/>
            <br>Salary:<@spring.formInput "WorkerForm.salary" "class='form-control'" "text"/>
            <br>Speciality:<@spring.formSingleSelect "WorkerForm.speciality", mavs, "class='form-control'"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>