<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Good update</title>
</head>
<body>
<h1>Good Update</h1>
<div style="width: 60%; text-align: center">
    <fieldset>
        <legend>Good update</legend>
        <form name="good" action="" method="POST">
            name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            Single good price:<@spring.formInput "form.singleGoodPrice" "" "text"/>
            <br>
            Multiple good price:<@spring.formInput "form.multipleGoodPrice" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>
</body>
</html>