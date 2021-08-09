<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order update</title>
</head>
<body>
<h1>Order Update</h1>
<div style="width: 60%; text-align: center">
    <fieldset>
        <legend>Order update</legend>
        <form name="good" action="" method="POST">
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            Client:<@spring.formInput "form.client" "" "text"/>
            <br>
            Goods (good-amount): <@spring.formInput "form.goodsAndAmounts" "" "text"/>
            <br>
            WholeSale: <@spring.formCheckbox "form.isWholeSale" ""/>
            <br>
            Discount:<@spring.formInput "form.discount" "" "text"/>
            <br>
            Purchase date:<@spring.formInput "form.purchaseDate" "" "date"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>
</body>
</html>