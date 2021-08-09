<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Goods</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>  Table of goods</h1>
<div style="width: 60%; text-align: center">
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Single good price</th>
            <th>Multiple good price</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <#list goods as good>
            <tr>
                <td>${good.id}</td>
                <td>${good.name}</td>
                <td>${good.description}</td>
                <td>${good.createdAt}</td>
                <td>${good.updatedAt}</td>
                <td>${good.singleGoodPrice}</td>
                <td>${good.multipleGoodPrice}</td>
                <td>
                    <a href="/gui/goods/update/${good.id}">Update</a>
                </td>
                <td>
                    <a href="/gui/goods/delete/${good.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
    <a href="/gui/goods/create">Create</a>
</div>
</body>
</html>