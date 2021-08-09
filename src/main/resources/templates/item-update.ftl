<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Update</h1>
<div style="width: 60%; text-align: center">
    <fieldset>
        <legend></legend>
        <form name="item" action="" method="POST">
            name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>
</body>
</html>