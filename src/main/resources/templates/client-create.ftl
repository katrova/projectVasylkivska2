<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client creation</title>
</head>
<body>
<h1>Client Creation</h1>
<div style="width: 60%; text-align: center">
    <fieldset>
        <legend>Client create</legend>
        <form name="client" action="" method="POST">
            name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            Address:<@spring.formInput "form.address" "" "text"/>
            <br>
            Phone number:<@spring.formInput "form.phoneNumber" "" "text"/>
            <br>
            Contact person:<@spring.formInput "form.contactPerson" "" "text"/>
            <br>
            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>
</body>
</html>