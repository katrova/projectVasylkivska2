<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Orders</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>  Table of orders</h1>
<div style="width: 60%; text-align: center">
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Created</th>
            <th>Updated</th>
            <th>Client</th>
            <th>Goods (good-amount)</th>
            <th>Wholesale</th>
            <th>Discount</th>
            <th>Purchase date</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <#list orders as order>
            <tr>
                <td>${order.id}</td>
                <td>${order.description}</td>
                <td>${order.createdAt}</td>
                <td>${order.updatedAt}</td>
                <td>${order.client}</td>
                <td>${order.goodsAndAmounts}</td>
                <td>${order.isWholeSale()?string}</td>
                <td>${order.discount}</td>
                <td>${order.purchaseDate}</td>
                <td>
                    <a href="/gui/orders/update/${order.id}">Update</a>
                </td>
                <td>
                    <a href="/gui/orders/delete/${order.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
    <a href="/gui/orders/create">Create</a>
</div>
</body>
</html>