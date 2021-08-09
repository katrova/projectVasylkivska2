<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>  Table of items</h1>
<div style="width: 60%; text-align: center">
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <#list items as item>
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.description}</td>
                <td>${item.createdAt}</td>
                <td>${item.updatedAt}</td>
                <td>
                    <a href="/gui/items/update/${item.id}">Update</a>
                </td>
                <td>
                    <a href="/gui/items/delete/${item.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
    <a href="/gui/items/create">Create</a>
</div>
</body>
</html>